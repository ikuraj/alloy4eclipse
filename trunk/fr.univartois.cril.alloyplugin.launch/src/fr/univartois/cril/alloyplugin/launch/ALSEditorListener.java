package fr.univartois.cril.alloyplugin.launch;

import fr.univartois.cril.alloyplugin.launch.ui.ViewContentProvider;
import fr.univartois.cril.alloyplugin.launch.ui.AlloyCommandView;
import fr.univartois.cril.alloyplugin.ui.IALSFile;
import fr.univartois.cril.alloyplugin.ui.IAlloyEditorListener;
/**
 * This class listens AlsEditor. 
 * Used with extension: [fr.univartois.cril.alloyplugin.launch.EditorListener].
 */
public class ALSEditorListener implements IAlloyEditorListener {
	public void fileLoaded(IALSFile file) {
		parseCommandsFor(file);
	}

	
	
	public void fileSaved(IALSFile file) {
		//parseCommandsFor(file);
	}
	
	
	
	public void fileSetFocus(IALSFile file) {
		displayCommandsFor(file);
	}

	
	
	public void fileChanged(IALSFile file) {
	}

	
	
	public void fileClosed(IALSFile file) {
		AlloyCommandView.removeCommandsFromDisplay(file);		
	}

	
	
	/**
	 * Displays all the commands of an als file. 
	 */

	private void displayCommandsFor(IALSFile file){		
		ViewContentProvider.getContentProvider().setCurrent(file);
		

	}

	
	
	/**
	 * Launch Alloy parser for an als file. 
	 */
	private void parseCommandsFor(IALSFile file){

	//	CommandsProvider.getCommandsProvider().addCommandsFrom(file);
		


	}
}