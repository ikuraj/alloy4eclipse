/*
* generated by Xtext
*/
package fr.univartois.cril.xtext.ui.outline;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.IActionBarContributor;
import org.eclipse.xtext.ui.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;

import fr.univartois.cril.xtext.als.Assertion;
import fr.univartois.cril.xtext.als.CheckCommand;
import fr.univartois.cril.xtext.als.Fact;
import fr.univartois.cril.xtext.als.Function;
import fr.univartois.cril.xtext.als.Module;
import fr.univartois.cril.xtext.als.Open;
import fr.univartois.cril.xtext.als.Predicate;
import fr.univartois.cril.xtext.als.RunCommand;
import fr.univartois.cril.xtext.als.Signature;
import fr.univartois.cril.xtext.als.Specification;

/**
 * customization of the default outline structure
 * 
 */
public class AlsTransformer extends AbstractDeclarativeSemanticModelTransformer {
	
	@Override
	protected List<EObject> getChildren(EObject semanticNode) {
		if(semanticNode instanceof Specification)
			return semanticNode.eContents();
		return NO_CHILDREN;
	}

	
	public String createNode(Specification semanticNode, ContentOutlineNode parentNode) {	    
	    return INVISIBLE_ROOT_NODE;
	}
	public ContentOutlineNode createNode(Module moduleNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(moduleNode, parentNode);
		    node.setLabel("Module : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(Open openNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(openNode, parentNode);
		    node.setLabel("Open : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(Function fNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(fNode, parentNode);
		    node.setLabel("Function : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(Signature fNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(fNode, parentNode);
		    node.setLabel("Signature : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(Predicate fNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(fNode, parentNode);
		    node.setLabel("Predicat : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(Assertion fNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(fNode, parentNode);
		    node.setLabel("Assertion : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(RunCommand fNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(fNode, parentNode);
		    node.setLabel("Run : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(CheckCommand fNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(fNode, parentNode);
		    node.setLabel("Check : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	public ContentOutlineNode createNode(Fact fNode, ContentOutlineNode parentNode) {	    
		 ContentOutlineNode node = super.newOutlineNode(fNode, parentNode);
		    node.setLabel("Fact : " + node.getLabel());
		    node.setImage(node.getImage());
		    return node;
		
	}
	
	
	
}
