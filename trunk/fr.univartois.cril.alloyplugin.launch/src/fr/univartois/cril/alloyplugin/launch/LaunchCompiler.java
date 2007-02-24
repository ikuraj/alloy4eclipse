package fr.univartois.cril.alloyplugin.launch;

import java.util.ArrayList;
import java.util.List;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4.Log;
import edu.mit.csail.sdg.alloy4.LogToStringBuilder;
import edu.mit.csail.sdg.alloy4.Pref;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.World;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
//import fr.univartois.cril.alloyplugin.console.AlloyMessageConsole;
import fr.univartois.cril.alloyplugin.console.AlloyMessageConsole;
import fr.univartois.cril.alloyplugin.console.Console;

public class LaunchCompiler {


	/**
	 * parse a .als file. return the World (!!).
	 * */
	protected static World parse(String filename) 
	{
		
		AlloyMessageConsole alloyParserConsole=Console.findAlloyParserConsole(filename);
		alloyParserConsole.clear();
		alloyParserConsole.reveal();
		alloyParserConsole.printInfo("=========== Parsing \""+filename+"\" =============");
//		This log records diagnostic messages
		Log log = new LogToStringBuilder();
		World world;
		try{
			world = CompUtil.parseEverything_fromFile(null, null, filename, log);		
			//MessageDialog.openInformation(null,null,"Run Alloy4...");
			// Now, "world" is the root of the the abstract syntax tree.

			// Typecheck the model, and print out all the warnings.
			List<ErrorWarning> warnings = new ArrayList<ErrorWarning>();
			world.typecheck(log, warnings);
			for(Err e:warnings) {
				alloyParserConsole.printInfo("============ Relevance Warning: ============\n");
				alloyParserConsole.printInfo(e+"\n");
			}

			// Now, you can call getType() on each node in world to find out its type.

			//Let's display all the messages so far
			alloyParserConsole.print(log.toString());
			alloyParserConsole.printInfo("=========== End Parsing \""+filename+"\" =============");
			log.setLength(0);
		}
		catch (Err e){			
			alloyParserConsole.reveal();			
			alloyParserConsole.printErr(e);
			return null;
		}
		return world;
	}


	/*
	 * Execute every command in every file.
	 *
	 * This method parses every file, then execute every command.
	 *
	 * If there are syntax or type errors, it may throw
	 * a ErrorSyntax or ErrorType or ErrorAPI or ErrorFatal exception.
	 * You should catch them and display them,
	 * and they may contain filename/line/column information.
	 */
	public static final void command(String filename) {
		World world= parse(filename);
		if (world==null) return;
		AlloyMessageConsole alloyConsole=Console.findAlloyConsole(filename);
		alloyConsole.reveal();
		try {
		// Load the visualizer (You only need to do this if you plan to visualize an Alloy solution)
		// VizGUI viz = new VizGUI(false, "", null);
		//		 Parse the model
		//Console.clearConsole(filename);
		//AlloyMessageConsole amc=Console.findAlloyConsole(filename);
		Log log = new LogToStringBuilder();

		// Choose some default options for how you want to execute the commands
		A4Options options = new A4Options(log);
		options.solver = Pref.SatSolver.SAT4J;
		options.verbosity = 2;

		for (Command cmd: world.getRootModule().getAllCommands()) {
			// Execute the command
			alloyConsole.printInfo("============ Command "+cmd+": ============");
			A4Solution ans;

			
				ans = TranslateAlloyToKodkod.execute_command(world, cmd, options, null, null);
			

			// Print all the diagnostic messages
			alloyConsole.print(log.toString());
			log.setLength(0);
			// Print the outcome
			alloyConsole.printInfo("============ Answer ============");
			alloyConsole.print(ans.toString());
			// If satisfiable...
			if (ans.satisfiable()) {				
				// You can query "ans" to find out the values of each set or type.
				// This can be useful for debugging.
				//
				// You can also write the outcome to an XML file
				// ans.writeXML("output.xml", false);
				//
				// You can then visualize the XML file by calling this:
				// viz.run(VizGUI.evs_loadInstanceForcefully, "output.xml");
			}
		}//for all command

		
		} catch (Err e) {			
			alloyConsole.reveal();			
			alloyConsole.printErr(e);		
		}
	}




}


