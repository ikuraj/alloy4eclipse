package fr.univartois.cril.alloyplugin.core;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.World;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import edu.mit.csail.sdg.alloy4viz.VizGUI;
import fr.univartois.cril.alloyplugin.AlloyPlugin;
import fr.univartois.cril.alloyplugin.core.ui.IALSCommand;
import fr.univartois.cril.alloyplugin.launch.util.Util;

/**
 * A command with its world and its resource. 
 * Can be executed.
 */
public class ExecutableCommand implements IALSCommand {
	public static final int SAT = 1;
	public static final int UNSAT = 2;
	public static final int UNKNOW = 0;

	public static final Image iconrun = AlloyPlugin.getDefault().getImage(AlloyPlugin.RUN_ICON_ID);
	public static final Image iconcheck = AlloyPlugin.getDefault().getImage(AlloyPlugin.CHECK_ICON_ID);

	/**
	 * The Command's world . 
	 */
	private final World world;

	/**
	 * The command itself. 
	 */
	private final Command command;

	/**
	 * The ALS file which has provided the command. 
	 */
	private final ALSFile file;

	/**
	 * An Options for execution. 
	 */
	private final A4Options options;

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
	public ExecutableCommand(ALSFile file,Command command, World world,A4Options options) {		
		if(options==null){
			this.options = new A4Options();		
			this.options.solver = A4Options.SatSolver.SAT4J;
		}
		else
			this.options=options;

		assert(file!=null);
		assert(command!=null);
		assert(world!=null);

		this.file = file;
		this.world    = world;
		this.command  = command;
		this.result   = UNKNOW;
	}



	/**
	 * Constructor. 
	 */
	public ExecutableCommand(ALSFile file,Command command, World world) {
		this(file,command,world,null);				
	}



	/**
	 * Get the option.
	 * */
	public A4Options getOptions(A4Reporter rep) {
		options.setReporter(rep);
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
	public World getWorld() {
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
	public int getResult() {

		return result;		
	}



	/**
	 * Execute this command whith te given reporter.
	 * */
	public A4Solution execute(Reporter rep) throws Err {
		rep.setExecCommand(this);
		A4Solution ans = TranslateAlloyToKodkod.execute_command(world,command,getOptions(rep), null, null); 
		this.ans=ans;
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
		//return command.check?iconcheck:iconrun;

		ImageRegistry reg = AlloyPlugin.getDefault().getImageRegistry();

		if (getResult()==ExecutableCommand.SAT)
			if (getCommand().check) {
				if(getCommand().expects==1)
					return reg.get(AlloyPlugin.BLUE_CHECK_ID);// not expected sat check command
				else
					return reg.get(AlloyPlugin.RED_CHECK_ID);// expected sat check command
			}
			else return reg.get(AlloyPlugin.GREEN_RUN_ID);;//Sat Run command 
			if (getResult()==ExecutableCommand.UNSAT)
				if (getCommand().check) return reg.get(AlloyPlugin.GREEN_CHECK_ID);//OK
				else {
					if(getCommand().expects==0)
						return reg.get(AlloyPlugin.BLUE_RUN_ID);
					else
						return reg.get(AlloyPlugin.RED_RUN_ID);
				}
			if (getCommand().check)
				return reg.get(AlloyPlugin.CHECK_ID);
			else
				return reg.get(AlloyPlugin.RUN_ID);

			//return reg.get(AlloyPlugin.COMMAND_ID);

	}



	public int getLine() {
		return command.pos.y;
	}



	public String getName() {
		return command.name;

	}
	public String toString(){		
			if (this.getResult()==ExecutableCommand.UNKNOW)
				return command.toString();
			if (this.getResult()!=ExecutableCommand.SAT)
				return command.toString()+" [UNSAT]";
			else return command.toString()+" [SAT]";	
		
	}

	public  void displayAns() throws Err {
//      GraphView.Visualize(ans);   
		if (ans.satisfiable()){
     ans.writeXML("output.xml", false);
     //
     // You can then visualize the XML file by calling this:
     VizGUI viz = new VizGUI(false,"",null);
     viz.run(VizGUI.evs_loadInstanceForcefully, "output.xml");}        
}





}