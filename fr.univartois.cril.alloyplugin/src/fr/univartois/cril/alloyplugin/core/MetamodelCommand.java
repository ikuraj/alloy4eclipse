package fr.univartois.cril.alloyplugin.core;import java.io.FileNotFoundException;import java.io.PrintWriter;import java.io.UnsupportedEncodingException;import org.eclipse.core.resources.IFile;import org.eclipse.core.resources.IFolder;import org.eclipse.core.resources.IResource;import org.eclipse.core.runtime.CoreException;import org.eclipse.core.runtime.Path;import org.eclipse.jface.resource.ImageRegistry;import org.eclipse.swt.graphics.Image;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.IViewPart;import org.eclipse.ui.IWorkbenchPage;import org.eclipse.ui.IWorkbenchWindow;import org.eclipse.ui.PlatformUI;import edu.mit.csail.sdg.alloy4.ConstList;import edu.mit.csail.sdg.alloy4.Err;import edu.mit.csail.sdg.alloy4.Pair;import edu.mit.csail.sdg.alloy4.Version;import edu.mit.csail.sdg.alloy4compiler.ast.Sig;import edu.mit.csail.sdg.alloy4compiler.parser.Module;import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;import edu.mit.csail.sdg.alloy4compiler.translator.A4SolutionWriter;import edu.mit.csail.sdg.alloy4compiler.translator.A4Options.SatSolver;import fr.univartois.cril.alloyplugin.AlloyPlugin;import fr.univartois.cril.alloyplugin.api.ALSImageRegistry;import fr.univartois.cril.alloyplugin.api.IALSCommand;import fr.univartois.cril.alloyplugin.api.IALSFile;import fr.univartois.cril.alloyplugin.api.IReporter;import fr.univartois.cril.alloyplugin.api.Util;import fr.univartois.cril.alloyplugin.preferences.PreferenceConstants;import fr.univartois.cril.alloyplugin.views.VizView;/** * An Alloy command with its world and its resources. Can be executed. */public class MetamodelCommand implements IALSCommand, INextable {    public static final Image iconrun   = ALSImageRegistry.getImage(            ALSImageRegistry.RUN_ICON_ID);    public static final Image iconcheck = ALSImageRegistry.getImage(            ALSImageRegistry.CHECK_ICON_ID);    /**     * The Command's world .     */    private final Module      world;      /**     * The ALS file which has provided the command.     */    private final IALSFile     file;    /**     * result can be executable.SAT executable.UNSAT or executable.UNKNOWN.     */    private int               result;    /**     *      *      *      */    private String            stringResult;    private IFile        	metamodelFile = null;    private IViewPart[]			viewPart = new IViewPart[1];        /**     * Constructor.     */    public MetamodelCommand(IALSFile file, Module world) {        assert (file != null);        assert (world != null);        this.file = file;        this.world = world;        this.result = IALSCommand.UNKNOW;        this.viewPart[0] = null;    }    /**     * Get the option.     */    public A4Options getOptions() {        A4Options options = new A4Options();        SatSolver solver;// =A4Options.SatSolver.SAT4J;        String defaultSolver = AlloyPlugin.getDefault().getPreferenceStore()                .getString(PreferenceConstants.P_SOLVER_CHOICE);        if (PreferenceConstants.V_SOLVER_BERKMIN.equals(defaultSolver)) {            solver = A4Options.SatSolver.BerkMinPIPE;        } else if (PreferenceConstants.V_SOLVER_ZChaffJNI.equals(defaultSolver)) {            solver = A4Options.SatSolver.ZChaffJNI;        } else if (PreferenceConstants.V_SOLVER_MiniSatProverJNI.equals(defaultSolver)) {            solver = A4Options.SatSolver.MiniSatProverJNI;        } else if (PreferenceConstants.V_SOLVER_MiniSatProverUnsatCore.equals(defaultSolver)) {            solver = A4Options.SatSolver.MiniSatProverJNI;        } else {            solver = A4Options.SatSolver.SAT4J;        }        // solver = A4Options.SatSolver.MiniSatProverJNI;        options.solver = solver;        options.solverDirectory = AlloyPlugin.getDefault().getPreferenceStore()                .getString(PreferenceConstants.P_SOLVERS_PATH);        options.originalFilename = getFilename();        return options;    }    /**     * Get the resource which this command is from.     */    public IResource getResource() {        return file.getResource();    }    /**     * Get the location of the file where this command is located.     */    public String getFilename() {        return Util.getFileLocation(file.getResource());    }    public IViewPart getViewPart() { return viewPart[0]; }        /**     * return the world.     */    public Module getWorld() {        return world;    }    /**     * Return the result.     */    private int getResult() {        return result;    }    public static void A4Metamodel(    		String a4Filename,    		Module a4Module,    		String mmFilename) throws Err {    	try {    		Iterable<Sig> sigs = a4Module.getAllReachableSigs();    		PrintWriter of=new PrintWriter(mmFilename, "UTF-8");    		edu.mit.csail.sdg.alloy4.Util.encodeXMLs(of, "\n<alloy builddate=\"", Version.buildDate(), "\">\n\n");    		A4SolutionWriter.writeMetamodel(ConstList.make(sigs), a4Filename, of);    		edu.mit.csail.sdg.alloy4.Util.encodeXMLs(of, "\n</alloy>");    		edu.mit.csail.sdg.alloy4.Util.close(of);    	} catch (UnsupportedEncodingException e) {    		throw new edu.mit.csail.sdg.alloy4.ErrorAPI(e.getMessage(), e);    	} catch (FileNotFoundException e) {    		throw new edu.mit.csail.sdg.alloy4.ErrorAPI(e.getMessage(), e);    	}    }        /**     * Execute this command with te given reporter.     */    public Pair<A4Solution, Boolean> execute(IReporter rep) throws Err {    	metamodelFile = null;        rep.setExecCommand(this);               IFolder outputFolder = getAnswerFolder("output");        if (outputFolder == null)            return new Pair<A4Solution, Boolean>(null, false);                IFile mFile = outputFolder.getFile(getName() + ".xml");        if (mFile.exists()) {            try {            	mFile.delete(true, null);            } catch (CoreException e) {                AlloyPlugin.getDefault().log(e);            }        }                try {        	A4Metamodel(getFilename(), world, Util.getFileLocation(mFile));        	metamodelFile = mFile;        } catch (Err e) {        	AlloyPlugin.getDefault().log(e);		}        file.fireChange();        // if preference "show answer after execution" is enable, display answer        // in a Graphic thread:        // if (AlloyPlugin.getDefault().getPreferenceStore().getBoolean(        //        PreferenceConstants.P_BOOLEAN_WRITE_SHOW_ANSWER))        // {            displayAnsSafe();        // }        return new Pair<A4Solution, Boolean>(null, null!=metamodelFile);    }    public Pair<A4Solution, Boolean> getAns() {        return new Pair<A4Solution, Boolean>(null, null!=metamodelFile);    }    /**     * Set this command sat.     */    public void setSat(boolean sat) {        if (sat)            result = IALSCommand.SAT;        else            result = IALSCommand.UNSAT;        file.fireChange();    }    /**     * Set the string result for this command.     */    public void setStringResult(String s) {        stringResult = s;    }    /**     * Get the string result of this command.     */    public String getStringResult() {        return stringResult;    }    public Image getIcon() {        // return command.check ?iconcheck:iconrun;        ImageRegistry reg = ALSImageRegistry.getImageRegistry();        if (getResult() == IALSCommand.SAT) {            if (isCheck()) {                if (isExpect())// expected sat check command                    return reg.get(ALSImageRegistry.BLUE_CHECK_ID);                // not expected                // sat check                // command                return reg.get(ALSImageRegistry.RED_CHECK_ID);            }            // Sat Run command            return reg.get(ALSImageRegistry.GREEN_RUN_ID);        }        if (getResult() == IALSCommand.UNSAT) {            if (isCheck())                return reg.get(ALSImageRegistry.GREEN_CHECK_ID);// OK            return reg.get(ALSImageRegistry.RED_RUN_ID);        }        if (isCheck())            return reg.get(ALSImageRegistry.CHECK_ID);        return reg.get(ALSImageRegistry.RUN_ID);    }    public int getBeginLine() {    	/**    	 * TODO Return the line number of the 'module ...'    	 */        return 1;    }        public int getEndLine() {        return getBeginLine();    }    public String getName() {        return "Metamodel";    }    public String toString() {        if (this.getResult() == IALSCommand.UNKNOW)            return getName();        if (this.getResult() != IALSCommand.SAT)            return getName() + " [UNSAT]";        return getName() + " [SAT]";    }    /**     * Display answer.     */    private void displayAns() throws Err {    	if (null == metamodelFile)    		return;    	    	IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();    	IWorkbenchPage page = window.getActivePage();        	String secondaryId = metamodelFile.getFullPath().toString().replace(' ', '_').replace(':', '_');    	String titlename = "MM - " + AlloyLaunching.getResourcePartName(getResource());				this.viewPart[0] = VizView.showAlloyVisualizationView(this,				page, metamodelFile, titlename, secondaryId);    }    /**     * Get answer folder.     */    private IFolder getAnswerFolder(String folderName)    {        IFolder outputFolder = getResource().getParent().getFolder(new Path(folderName));        if (!outputFolder.exists())        {            try {                outputFolder.create(false, true, null);            } catch (CoreException e) {            	AlloyPlugin.getDefault().log(e);                return null;            }        }        return outputFolder;    }    /*     * (non-Javadoc)     * @see fr.univartois.cril.alloyplugin.api.IALSCommand#displayAnsSafe()     */    public void displayAnsSafe() {        Display display = PlatformUI.getWorkbench().getDisplay();        if (display != null) {            display.asyncExec(            new Runnable() {                public void run() {                    try {                    	MetamodelCommand.this.displayAns();                    } catch (Err e) {                    	AlloyPlugin.getDefault().log(e);                    }                }            });        }    }    public boolean isCheck() {        return false;    }    public boolean isExpect() {        return false;    }	public void showNextA4Solution() {		// do nothing ?	}}