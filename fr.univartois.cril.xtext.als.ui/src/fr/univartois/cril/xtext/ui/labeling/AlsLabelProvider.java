/*
* generated by Xtext
*/
package fr.univartois.cril.xtext.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

import fr.univartois.cril.xtext.als.Assertion;
import fr.univartois.cril.xtext.als.CheckCommand;
import fr.univartois.cril.xtext.als.EnumDecl;
import fr.univartois.cril.xtext.als.Fact;
import fr.univartois.cril.xtext.als.Function;
import fr.univartois.cril.xtext.als.Let;
import fr.univartois.cril.xtext.als.Module;
import fr.univartois.cril.xtext.als.Open;
import fr.univartois.cril.xtext.als.Predicate;
import fr.univartois.cril.xtext.als.RunCommand;
import fr.univartois.cril.xtext.als.Signature;
import fr.univartois.cril.xtext.als.SignatureName;
import fr.univartois.cril.xtext.als.Specification;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class AlsLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public AlsLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

/*
	//Labels and icons can be computed like this:
	
	String text(MyModel ele) {
	  return "my "+ele.getName();
	}
	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
	


	String image(Specification spec) {
		return "module.gif";
	}

	String text(Module module){
		return module.getModuleName();
	}
	
	String text(Open open){
		return open.getOpenName().getImportURI();
	}

	String image(Module module) {
		return "module.gif";
	}

	String text(Signature sig) {
		System.out.println("signame:"+sig.getSignatureName()+"!");
		System.out.println("signameget0:"+sig.getSignatureName().get(0)+"!");
		String name = sig.getSignatureName().get(0).getName();
		
		for(SignatureName n : sig.getSignatureName().subList(1, sig.getSignatureName().size()))
			name+=", "+n.getName();
		return name;
	}

	String image(Signature sig) {
		return "sig.gif";
	}

	String text(Let l){
		return l.getLetName().getName();
	}
	String text(Fact fact){
		if(fact.getFactName().getName()==null){
			return "Block Fact";
			
		}
		return fact.getFactName().getName();
	}

	String image(Fact fact) {
		return "fact.gif";
	}

	String text(Assertion assertD) {
		return assertD.getAssertionName().getName();
	}

	String image(Assertion assertD) {
		return "assert.gif";
	}

	String text(Function fun) {
		return fun.getFunctionName().getName();
	}

	String image(Function fun) {
		return "function.gif";
	}

	String text(Predicate pred) {
		return pred.getPredicateName().getName();
	}

	String image(Predicate fun) {
		return "predicate.gif";
	}

	String text(RunCommand run) {
		if (run.getRunName()==null){			
			if(run.getName2()==null){
				return "Block Run";
			}
			else{
				return run.getName2().getName();
			}		
		}
		//System.out.println("Nom du run:"+run.getRunName().getName()+"!!");
		//if(run.getRunName().getName()==null){			
		//}
		return run.getRunName().getName();
	}

	String image(RunCommand run) {
		return "run.gif";
		
	}

	String text(CheckCommand check) {
		if (check.getCheckName()==null){
			if(check.getName()==null){
				return "Block Check";
			}
			else{
				return check.getName().getName();
			}
		
		}
		return check.getCheckName().getName();
	}

	String image(CheckCommand check) {
		return "check.gif";
	}

	String text(EnumDecl enumD) {
		return enumD.getEnumName().getName();
	}

	String image(EnumDecl enumD) {
		return "sig.gif";
	}
}
