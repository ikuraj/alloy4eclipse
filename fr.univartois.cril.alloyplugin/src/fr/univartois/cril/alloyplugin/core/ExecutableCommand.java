package fr.univartois.cril.alloyplugin.core;




import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Pair;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.parser.Module;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options ;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options.SatSolver;
import fr.univartois.cril.alloyplugin.AlloyPlugin;
import fr.univartois.cril.alloyplugin.core.ui.IALSCommand;
import fr.univartois.cril.alloyplugin.editor.MultiPageEditor;
import fr.univartois.cril.alloyplugin.launch.util.Util;
import fr.univartois.cril.alloyplugin.preferences.PreferenceConstants;

/**
 * An Alloy command with its world and its resources.
 * Can be executed.
 */


public class ExecutableCommand implements IALSCommand {
	public static final int SAT = 1;
	public static final int UNSAT = 2;
	public static final int UNKNOW = 0;

	public static final Image iconrun = AlloyPlugin.getDefault().getImage(AlloyPlugin.RUN_ICON_ID );
	public static final Image iconcheck = AlloyPlugin.getDefault().getImage(AlloyPlugin.CHECK_ICON_ID);

	/**
	 * The Command's world .
	 */
	private final Module world;

	/**
	 * The command itself.
	 */
	private final Command command;

	/**
	 * The formula associated with the command.
	 */
	private final Expr formula;
	
	/**
	 * The ALS file which has provided the command.
	 */
	private final ALSFile file;



	/**
	 * result can be executable.SAT executable.UNSAT or executable.UNKNOWN.
	 */
	private int result;

	/**
	 *
	 */
	private String stringResult;
	private A4Solution ans;



	/**
	 * Constructor.
	 */
	public ExecutableCommand(ALSFile file, Command command, Expr formula, Module world) {        

		assert(file!=null);
		assert(command!=null);
		assert(formula!=null);
		assert(world!=null);

		this.file = file;
		this.world    = world;
		this.command  = command;
		this.formula = formula;
		this.result    = UNKNOW;
	}

	/**
	 * Get the option.
	 * */
	public A4Options getOptions() {
		A4Options options;

		options = new A4Options();
		SatSolver solver;//=A4Options.SatSolver.SAT4J;
		String defaultSolver=AlloyPlugin.getDefault().getPreferenceStore().getString( PreferenceConstants.P_SOLVER_CHOICE);

		if(PreferenceConstants.V_SOLVER_MINISAT_PIPE.equals(defaultSolver)) {            
			solver = A4Options.SatSolver.MiniSatProverJNI;
		} else if(PreferenceConstants.V_SOLVER_ZChaffJNI.equals(defaultSolver)) {            
			solver = A4Options.SatSolver.ZChaffJNI;
		} else if(PreferenceConstants.V_SOLVER_MiniSatProverJNI.equals(defaultSolver)) {            
			solver = A4Options.SatSolver.MiniSatProverJNI;
		} else if(PreferenceConstants.V_SOLVER_MiniSatProverUnsatCore.equals(defaultSolver)) {            
			solver = A4Options.SatSolver.MiniSatProverJNI;
		} else {            
			solver = A4Options.SatSolver.SAT4J;
		}

		//solver = A4Options.SatSolver.MiniSatProverJNI;

		options.solver=solver;
		return options;
	}

	/**
	 * Get the resource which this command is from.
	 */
	public IResource getResource() {
		return file.getResource();
	}    


	/**
	 *  Get the location of the file where this command is located.
	 */
	public String getFilename() {        
		return Util.getFileLocation(file.getResource());        
	}    

	/**
	 * return the world.
	 */
	public Module getWorld() {
		return world;
	}



	/**
	 * return the command.
	 */
	public Command getCommand() {
		return command;
	}



	/**
	 * Return the result.
	 */
	private int getResult() {

		return result;        
	}



	/**
	 * Execute this command with te given reporter.
	 * */
	protected A4Solution execute(Reporter rep) throws Err {
		rep.setExecCommand(this);
		Iterable<Sig> sigs = world.getAllReachableSigs();
		Expr fact = formula;
		for(Module m: world.getAllReachableModules()) for(Pair<String,Expr> e: m.getAllFacts()) fact=fact.and(e.b);
		A4Solution ans = TranslateAlloyToKodkod.execute_command(rep,sigs,fact,command,getOptions());
		this.ans=ans;
		file.fireChange();
		//if preference "show answer after execution" is enable, display answer in a Graphic thread:
		if(AlloyPlugin.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_BOOLEAN_WRITE_SHOW_ANSWER))
		{         
			displayAnsSafe();

		}
		return ans;
	}

	public A4Solution getAns(){return ans;}

	/**
	 * Set this command sat.
	 */
	public void setSat(boolean sat) {
		if (sat) result=SAT;
		else result=UNSAT;        
		file.fireChange();
	}



	/**
	 * Set the string result for this command.
	 */
	public void setStringResult(String s) {
		stringResult=s;
	}



	/**
	 * Get the string result of this command.
	 */
	public String getStringResult() {
		return stringResult;
	}


	public Image getIcon() {
		//return command.check ?iconcheck:iconrun;

		ImageRegistry reg = AlloyPlugin.getDefault().getImageRegistry();

		if (getResult()==ExecutableCommand.SAT)
			if (isCheck()) {
				if(isExpect())
					return reg.get(AlloyPlugin.BLUE_CHECK_ID);// not expected sat check command
				else
					return reg.get(AlloyPlugin.RED_CHECK_ID);// expected sat check command
			}
			else return reg.get(AlloyPlugin.GREEN_RUN_ID);;//Sat Run command
			if (getResult()==ExecutableCommand.UNSAT)
				if (isCheck()) return reg.get(AlloyPlugin.GREEN_CHECK_ID );//OK
				else {
					if(getCommand().expects==0)
						return reg.get(AlloyPlugin.BLUE_RUN_ID);
					else
						return reg.get (AlloyPlugin.RED_RUN_ID);
				}
			if (isCheck())
				return reg.get(AlloyPlugin.CHECK_ID);
			else
				return reg.get(AlloyPlugin.RUN_ID);

			//return reg.get(AlloyPlugin.COMMAND_ID);

	}



	public int getLine() {
		return command.pos.y;
	}



	public String getName() {
		return command.toString();

	}


	public String toString(){        
		if (this.getResult()==ExecutableCommand.UNKNOW)
			return command.toString();
		if (this.getResult()!=ExecutableCommand.SAT)
			return command.toString()+" [UNSAT]";
		else return command.toString()+" [SAT]";    

	}
	/**
	 * Display answer.
	 *
	 * */
	public  void displayAns() throws Err {

		if (ans.satisfiable()){
			IFolder outputFolder=getAnswerFolder("output");
			if (outputFolder==null) return;
			IFile outputFile=outputFolder.getFile(getName()+".xml");

			if(!outputFile.exists())
			{
				try {
					outputFile.create(null/*new byte[0]*/, false, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ans.writeXML(Util.getFileLocation(outputFile));            
			IEditorInput editorInput = new FileEditorInput(outputFile);
			IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();            
			try {
				page.openEditor(editorInput, MultiPageEditor.EDITOR_ID);
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}


	/**
	 * Get answer folder.
	 * */
	private IFolder getAnswerFolder(String folderName)
	{
		IFolder outputFolder=getResource().getParent().getFolder(new Path(folderName));
		if(!outputFolder.exists())
		{
			try {
				outputFolder.create(false,true, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return outputFolder;
	}

	/** 
	 * Display Answer in a SWT thread. 
	 **/
	private void displayAnsSafe() {
		Display display = PlatformUI.getWorkbench().getDisplay();        
		if (display!=null)
			display.asyncExec(
					new Runnable() {
						public void run(){
							try {
								ExecutableCommand.this.displayAns();
							} catch (Err e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}                    
						}
					});

	}

	public boolean isCheck() {
		return command.check;
	}



	public boolean isExpect() {
		// TODO Auto-generated method stub
		return (command.expects>=1);
	}





}