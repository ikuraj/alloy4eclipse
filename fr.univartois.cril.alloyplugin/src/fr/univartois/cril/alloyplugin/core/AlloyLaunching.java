package fr.univartois.cril.alloyplugin.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Pair;
import edu.mit.csail.sdg.alloy4.Pos;
import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
import edu.mit.csail.sdg.alloy4compiler.ast.Func;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.parser.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4viz.VizGUI;
import fr.univartois.cril.alloyplugin.AlloyPlugin;
import fr.univartois.cril.alloyplugin.console.AlloyMessageConsole;
import fr.univartois.cril.alloyplugin.console.Console;
import fr.univartois.cril.alloyplugin.core.ui.IALSCommand;
import fr.univartois.cril.alloyplugin.core.ui.IALSFact;
import fr.univartois.cril.alloyplugin.core.ui.IALSFunction;
import fr.univartois.cril.alloyplugin.core.ui.IALSPredicate;
import fr.univartois.cril.alloyplugin.core.ui.IALSSignature;
import fr.univartois.cril.alloyplugin.launch.util.Util;
import fr.univartois.cril.alloyplugin.preferences.PreferenceConstants;

/**
 * Static methods to launch Alloy parser or execute a command.
 */
public class AlloyLaunching {

    /**
     * Execute an ExecutableCommand previously created after a parsing.
     */
    public static final void execCommand(ExecutableCommand command) {
        assert (command != null);
        Reporter rep = new Reporter(command.getResource());
        execCommand(command, rep);
    }

    /**
     * Parse a als file.
     * 
     * @return an array (can be empty if there is no command in the file.)
     */
    public void launchParser(ALSFile file) {
        if (file == null || !file.getResource().exists())
            return;
        IResource res = file.getResource();
        try {
            res.deleteMarkers(
                    fr.univartois.cril.alloyplugin.ui.Util.ALLOYPROBLEM, false,
                    0);
        } catch (CoreException e) {
            e.printStackTrace();
        }
        Reporter rep = new Reporter(res);

        try {
            AlloyLaunching.parse(file, rep);
        } catch (Err e) {
            displayErrorInProblemView(res, e);
        }
    }

    /**
     * Parse one file.(not its subfiles) Don't update associated ALSFile.
     */
    public List<Command> parseOneFile(IResource resource) {
        if (!resource.exists())
            return null;
        try {
            resource.deleteMarkers(
                    fr.univartois.cril.alloyplugin.ui.Util.ALLOYPROBLEM, false,
                    0);
        } catch (CoreException e) {
            e.printStackTrace();
        }
        List<Command> list = null;
        try {
            list = CompUtil.parseOneModule_fromFile(resource.getLocation()
                    .toString());
        } catch (Err e) {
            displayErrorInProblemView(resource, e);
        }
        return list;

    }

    /**
     * Displays an Err exception in problem view, except if it starts with
     * "Solver fatal exception".
     */
    public static void displayErrInProblemView(IResource res, Err e,
            int severity) {
        if (e.msg.startsWith("Solver fatal exception")) {
            displaySolverFatalError();
        } else {

            res = getResourceFromErr(res, e);
            try {
                IMarker marker = res
                        .createMarker(fr.univartois.cril.alloyplugin.ui.Util.ALLOYPROBLEM);
                marker.setAttribute(IMarker.SEVERITY, severity);
                marker.setAttribute(IMarker.LINE_NUMBER, e.pos.y);
                marker.setAttribute(IMarker.MESSAGE, e.msg);
            } catch (CoreException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Display a solver fatal error in a SWT thread.
     */
    private static void displaySolverFatalError() {
        Display display = PlatformUI.getWorkbench().getDisplay();
        if (display != null)
            display.asyncExec(new Runnable() {
                public void run() {
                    String solverName = AlloyPlugin.getDefault()
                            .getPreferenceStore().getString(
                                    PreferenceConstants.P_SOLVER_CHOICE);
                    Shell shell = new Shell();
                    MessageDialog.openInformation(shell, "Alloy Plug-in",
                            "\nSolver fatal exception: " + solverName
                                    + " maybe not found.");
                }
            });
    }

    public static void displayErrorInProblemView(IResource res, Err e) {
        displayErrInProblemView(res, e, IMarker.SEVERITY_ERROR);
    }

    public static void displayWarningInProblemView(IResource res, Err e) {
        displayErrInProblemView(res, e, IMarker.SEVERITY_WARNING);
    }

    /**
     * Get the ressource where the Err is located.
     */
    private static IResource getResourceFromErr(IResource res, Err e) {
        if (e.pos != Pos.UNKNOWN) {
            if (!e.pos.filename.equals(Util.getFileLocation(res))) {
                return Util.getFileForLocation(e.pos.filename);
            }
        }
        return res;
    }

    /**
     * Parse a .als file. The ALSfile fields are modidied.
     * 
     * @throws Err
     */
    private static void parse(ALSFile file, Reporter rep) throws Err {
        IResource res = file.getResource();
        String filename = res.getLocation().toString();
        AlloyMessageConsole alloyParserConsole = Console
                .findAlloyInfoConsole(filename);
        alloyParserConsole.clear();
        alloyParserConsole.printInfo("=========== Parsing \"" + filename
                + "\" =============");
        Module world;
        world = CompUtil.parseEverything_fromFile(rep, null, filename);
        alloyParserConsole.printInfo("=========== End Parsing \"" + filename
                + "\" =============");
        updateALSFile(world, file);
    }

    /**
     * Set the fields of an alsFile. (commands, signatures..) fire changed() on
     * the als file for listeners.
     */
    private static void updateALSFile(Module world, ALSFile file) throws Err {
        // convert all commands in ExecutableCommand[]
        List<Pair<Command, Expr>> list = world.getAllCommandsWithFormulas();
        List<IALSCommand> exec_cmds = new ArrayList<IALSCommand>();// new
                                                                    // ExecutableCommand[list.size()];

        for (Pair<Command, Expr> command : list) {
            exec_cmds.add(new ExecutableCommand(file, command.a, command.b,
                    world));
        }
        file.setCommand(exec_cmds);
        SafeList<Pair<String, Expr>> factsList = world.getAllFacts();
        List<IALSFact> facts = new ArrayList<IALSFact>(factsList.size());
        for (Pair<String, Expr> fact : factsList) {
            facts.add(new Fact(fact));
        }
        file.setFacts(facts);

        SafeList<Func> funcList = world.getAllFunc();
        List<IALSFunction> funcs = new ArrayList<IALSFunction>(funcList.size());
        List<IALSPredicate> preds = new ArrayList<IALSPredicate>(funcList
                .size());
        for (Func fun : funcList) {
            if (fun.isPred) {
                preds.add(new Predicate(fun));
            } else {
                funcs.add(new Function(fun));
            }
        }
        file.setFunctions(funcs);
        file.setPredicates(preds);
        SafeList<Sig> sigList = world.getAllSigs();
        List<IALSSignature> sigs = new ArrayList<IALSSignature>(sigList.size());
        for (Sig sig : sigList) {
            sigs.add(new Signature(sig));
        }
        file.setSignatures(sigs);
        file.fireChange();
        System.out.println("ALSFile changed:" + file);
    }

    /**
     * Execute a command. The command is modified. Some informations can be show
     * to console.
     */
    private static final void execCommand(ExecutableCommand command,
            Reporter rep) {
        AlloyMessageConsole alloyConsole = Console.findAlloyConsole(command
                .getFilename());
        alloyConsole.activate();
        try {

            alloyConsole.printInfo("============ Command " + command
                    + ": ============");
            A4Solution ans;

            ans = command.execute(rep);
            // Print the outcome in console
            alloyConsole.printInfo("============ Answer ============");
            alloyConsole.print(ans.toString());

        } catch (Err e) {
            displayErrorInProblemView(command.getResource(), e);
        }

    }

    /**
     * Old method for saving the answer in a temporary file and visualize it.
     * 
     * @param ans
     * @throws Err
     */
    @Deprecated
    public static void displayAns(A4Solution ans) throws Err {
        // GraphView.Visualize(ans);
        ans.writeXML("output.xml");
        //
        // You can then visualize the XML file by calling this:
        VizGUI viz = new VizGUI(false, "", null);
        viz.run(VizGUI.evs_loadInstanceForcefully, "output.xml");
    }

}
