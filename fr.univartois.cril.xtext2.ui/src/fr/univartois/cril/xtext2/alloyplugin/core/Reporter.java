package fr.univartois.cril.xtext2.alloyplugin.core;
import java.io.Serializable;
/**
 * Allow to display within the Eclipse framework events reported by Alloy4 compiler.
 * It implements the Map interface in order to get notified of included AlloySpecification file
 * through the method put(String key,String value) where key is the absolute filename of the included file.
 * 
 * @author leberre
 *
 */
public final class Reporter extends IReporter implements Serializable {
	/**
	private String filename;
	private transient IResource resource;
	private transient IALSCommand execCommand;
	/**
	 * Create a reporter which is associated with one resource. 
	 */
	public Reporter(IResource res){
		this.filename=res.getLocation().toOSString();
		this.resource = res;
	}
	@Override
		warningCount++;
		// the location is in "e.pos"
		printInfo("Warning #"+warningCount);
		printInfo(e.msg.trim());
		AlloyLaunching.displayWarningInProblemView(resource,e);
	}
	public void translate
	(String solver, int bitwidth,
			int maxseq, int skolemDepth, int symmetry) {
		print("Solver="+solver
				+" Bitwidth="+bitwidth
				+" MaxSeq="+maxseq
				+(skolemDepth==0?"":" SkolemDepth="+skolemDepth)
				+" Symmetry="+(symmetry>0 ? (""+symmetry) : "OFF")
				+"\nGenerating CNF...\n"
		);
	}
	public void solve
	(int primaryVars, int totalVars, int clauses) {
		print("Var="+totalVars
				+" PrimaryVars="+primaryVars
				+" Clauses="+clauses
				+"\nSolving...\n"
		);
	}
	public void resultCNF(final String filename) {
		printInfo("CNF file written to "+filename+"\n");
	}
	public void resultSAT
	(int expects, boolean check,long solvingTime) {
		StringBuilder sb = new StringBuilder("");
		if (check) {
			sb.append("Counterexample found. \nAssertion is invalid");
		} else {
			sb.append("Instance found. \nPredicate is consistent");
		}
		if (expects==0) sb.append(", contrary to expectation");
		else if (expects==1) sb.append(", as expected.");
		sb.append(" "+(System.currentTimeMillis()-startSolving)+" ms.");
		print(sb.toString());
		updateExecCommand(true,sb.toString());
	}
	public void resultUNSAT
	(int expects, boolean check,long solvingTime) {    	
		StringBuilder sb = new StringBuilder("");
		if (check) {
			sb.append("No counterexample found.\nAssertion may be valid");
		} else {
			sb.append("No instance found.\nPredicate may be inconsistent");
		}
		if (expects==1) sb.append(", contrary to expectation");
		else if (expects==0) sb.append(", as expected.");
		sb.append(" "+(System.currentTimeMillis()-startSolving)+" ms.");
		print(sb.toString());
		updateExecCommand(false,sb.toString());		
	}
	/**
	 * update associated command if there is one.  
	 */
	private void updateExecCommand(boolean sat,String resultMessage){   
		if(execCommand!=null) {
			execCommand.setSat(sat);        
			execCommand.setStringResult(resultMessage);
		}
	}
	private void printInfo(String string) {		
		AlloyMessageConsole console = Console.findAlloyInfoConsole("");
		console.print(string);
	}
	private void print(String string) {		
		AlloyMessageConsole console = Console.findAlloyConsole(filename);
		console.print(string);
	}
	/** This method is called by the parser to report parser events. */
	public void parse(String msg) {
		printInfo(msg);
	}
	/** This method is called by the typechecker to report the type for each field/function/predicate/assertion, etc. */
	public void typecheck(String msg) {
		printInfo(msg);
	}
	/** This method is called by the ScopeComputer to report the scope chosen for each sig. */
	public void scope(String msg) {
		//print("scope:"+msg);
	}
	/** This method is called by the BoundsComputer to report the bounds chosen for each sig and each field. */
	public void bound(String msg) {
//		print("bound:"+msg);
	}
	/**
	 * Set the ExecutableCommand to the reporter.
	 * */
	public void setExecCommand(IALSCommand cmd) {
		this.execCommand=cmd;
	}
    /**
     * Method called when a new file 
     */
    public String put(String key, String value) {
		String result = super.put(key, value);
        IFile res = Util.getFileForLocation(key);
        if(res!=null&&res.exists())
            try {
                res.deleteMarkers(Util.ALLOYPROBLEM, false,0);
            } catch (CoreException e) {
            	AlsActivator.getDefault().log(e);
            }                   
        return result;
    }
}