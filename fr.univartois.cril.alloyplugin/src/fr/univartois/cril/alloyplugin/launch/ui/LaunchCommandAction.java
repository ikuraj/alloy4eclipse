package fr.univartois.cril.alloyplugin.launch.ui;

import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.SelectionProviderAction;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import fr.univartois.cril.alloyplugin.AlloyPlugin;
import fr.univartois.cril.alloyplugin.console.AlloyMessageConsole;
import fr.univartois.cril.alloyplugin.console.Console;
import fr.univartois.cril.alloyplugin.core.AlloyLaunching;
import fr.univartois.cril.alloyplugin.core.ExecutableCommand;



/**
 * This listens a selectionProvider and can execute selected ExecutableCommand from it.  
 * This action don't use eclipse launching mechanism so it will be replaced/deleted soon. (i hope)
 */
public class LaunchCommandAction extends SelectionProviderAction {
	private static ImageDescriptor enableImage;
	private static ImageDescriptor disableImage;
	static {
		URL url = null;
		try {
			url = new URL(AlloyPlugin.getDefault().getBundle().getEntry("/"),
			"icons/icon.gif");
		} catch (MalformedURLException e) {
		}
		enableImage = ImageDescriptor.createFromURL(url);
	}
	static {
		URL url = null;
		try {
			url = new URL(AlloyPlugin.getDefault().getBundle().getEntry("/"),
			"icons/DisableAlloyLaunch.gif");
		} catch (MalformedURLException e) {
		}
		disableImage = ImageDescriptor.createFromURL(url);
	}

	/**
	 * the selection which is associated.
	 */
	private IStructuredSelection selection;
	
	//private Object[] lastCommands;	

/**
 * Constructor. 
 * */
	public LaunchCommandAction(ISelectionProvider sp, String text) {	

		super(sp,text);
		/*if (("Execute Command").equals(text)){
	
			this.setEnabled(false);
			setImageDescriptor(enableImage);
			setDisabledImageDescriptor(disableImage);
			setToolTipText("Execute an Alloy command");
			this.setActionDefinitionId("fr.univartois.cril.alloyplugin.launch.runalloycommand");
			}*/
		if (("Display Ans").equals(text)){
			this.setEnabled(false);
			setImageDescriptor(enableImage);
			setDisabledImageDescriptor(disableImage);
			setToolTipText("Display an answer");
			}
	}
	
	
	public void selectionChanged(IStructuredSelection selection)
	{	
		//A4Solution ans;
		this.selection=selection;
		if (selection.isEmpty()) {
			this.setEnabled(false);
			return;
		}
		else this.setEnabled(true);
		
		Object[] tab=selection.toArray();
		
		for (int i=0;i<tab.length;i++){
		if (tab[i] instanceof ExecutableCommand){
			//ans=((ExecutableCommand) tab[i]).getAns();
			//if (ans!=null)
				this.setEnabled(true);
			}
		else this.setEnabled(false);
		}

	}
	
	
	/**
	 * this method display the commands answer
	 * */
	public void run(){		
		ExecutableCommand[] commands = createCommands(selection.toArray());

		A4Solution ans;
		for(int i=0;i<commands.length;i++){
			
			ans=commands[i].getAns();
			
			AlloyMessageConsole alloyConsole=Console.findAlloyConsole(commands[i].getFilename());
			alloyConsole.reveal();
			if (ans!=null)
				alloyConsole.printInfo("============ Answer ============");
			else
				alloyConsole.printInfo("No answer yet");
			if (ans!=null)
			alloyConsole.print(ans.toString());
			}
		
	}
	
	/**
	 * create commands from selection.
	 */
	private ExecutableCommand[] createCommands(Object[] commands) {
		ExecutableCommand[] cmds = new ExecutableCommand[commands.length];
		for(int i=0;i<commands.length;i++){
			cmds[i]=(ExecutableCommand) commands[i];			
		}
		return cmds;	
	}
	
}
