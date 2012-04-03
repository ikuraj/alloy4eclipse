/*
 * generated by Xtext
 */
package fr.univartois.cril.xtext2.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

import fr.univartois.cril.xtext2.als.Specification;

/**
 * customization of the default outline structure
 * 
 */
public class AlsOutlineTreeProvider extends DefaultOutlineTreeProvider {

	protected void _createChildren(DocumentRootNode parentNode,
			Specification specification) {
		for (EObject e : specification.eContents()) {
			createNode(parentNode, e);
		}
	}
	
	protected boolean _isLeaf(EObject o) {
		return true;
	}
}