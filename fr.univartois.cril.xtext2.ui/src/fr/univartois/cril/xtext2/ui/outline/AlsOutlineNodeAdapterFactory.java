/*
* generated by Xtext
*/
package fr.univartois.cril.xtext2.ui.outline;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

import fr.univartois.cril.xtext2.als.Assertion;
import fr.univartois.cril.xtext2.als.CheckCommand;
import fr.univartois.cril.xtext2.als.Module;
import fr.univartois.cril.xtext2.als.Predicate;
import fr.univartois.cril.xtext2.als.RunCommand;


public class AlsOutlineNodeAdapterFactory implements IAdapterFactory {

	private static final Class<?>[] types = { 
		// provide list of classes to adapt to, e.g.:
		RunCommand.class,
		Predicate.class,
		CheckCommand.class,
		Assertion.class,
		Module.class
		
	};

	public Class<?>[] getAdapterList() {
		return types;
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		EObjectNode node = (EObjectNode) adaptableObject;
		Class<?> nodeClass = node.getEClass().getInstanceClass();
		if (adapterType==nodeClass) {
			return true;
		}
		return null;
	}

}

