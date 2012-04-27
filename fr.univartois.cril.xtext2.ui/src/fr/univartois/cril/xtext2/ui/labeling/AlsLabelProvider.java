/*
* generated by Xtext
*/
package fr.univartois.cril.xtext2.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

import fr.univartois.cril.xtext2.als.Assertion;
import fr.univartois.cril.xtext2.als.CheckCommand;
import fr.univartois.cril.xtext2.als.EnumDecl;
import fr.univartois.cril.xtext2.als.Fact;
import fr.univartois.cril.xtext2.als.Function;
import fr.univartois.cril.xtext2.als.Let;
import fr.univartois.cril.xtext2.als.Module;
import fr.univartois.cril.xtext2.als.Open;
import fr.univartois.cril.xtext2.als.Predicate;
import fr.univartois.cril.xtext2.als.RunCommand;
import fr.univartois.cril.xtext2.als.Scope;
import fr.univartois.cril.xtext2.als.Signature;
import fr.univartois.cril.xtext2.als.SignatureName;
import fr.univartois.cril.xtext2.als.Specification;
import fr.univartois.cril.xtext2.als.Typescope;

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

	String image(Open open){
		return "open.gif";
	}
	
	String image(Module module) {
		return "module.gif";
	}

	String text(Signature sig) {
		String name = sig.getSignatureName().get(0).getName();
		
		for(SignatureName n : sig.getSignatureName().subList(1, sig.getSignatureName().size()))
			name+=", "+n.getName();
		return name;
	}

	String image(Signature sig) {
		return "sig.gif";
	}

	
	String text(Let l){
		return l.getName().getName();
	}
	
	String image(Let l){
		return "let.gif";
	}
	

	String text(Fact fact){
		if(fact.getName().getName()==null){
			return "Block Fact";
			
		}
		return fact.getName().getName();
	}

	String image(Fact fact) {
		return "fact.gif";
	}

	String text(Assertion assertD) {
		return assertD.getName().getName();
	}

	String image(Assertion assertD) {
		return "assert.gif";
	}

	String text(Function fun) {
		return fun.getName().getName();
	}

	String image(Function fun) {
		return "function.gif";
	}

	String text(Predicate pred) {
		return pred.getName().getName();
	}

	String image(Predicate fun) {
		return "predicate.gif";
	}

	String text(RunCommand run) {
		StringBuffer sb=new StringBuffer();
		if (run.getRunName()==null){			
			if(run.getName()==null){
				sb.append("{ Block } ");				
			}
			else{				
				sb.append(run.getName().getName()+" ");
			}
				Scope s=run.getScope();
				if(s.getFor()!=null)sb.append(s.getFor()+" ");
				if(s.getValue()!=0)sb.append(s.getValue()+" ");
				if(s.getBut()!=null)sb.append(s.getBut()+" ");
				
				for(Typescope t: s.getTypescope()){
					if(t.getExactly()!=null)sb.append(t.getExactly()+" ");
					sb.append(t.getValue()+" ");
					if(t.getAsname()!=null)sb.append(t.getAsname().getName()+" ");
					if(t.getPrev()!=null) sb.append(t.getPrev()+" ");
					if(t.getSl()!=null) sb.append(t.getSl()+" ");
					if(t.getName()!=null)sb.append(t.getName().getName()+" ");
					if(t.getPost()!=null)sb.append(t.getPost()+" ");
					if(s.getTypescope().lastIndexOf(t)!=s.getTypescope().size()-1)
						sb.append(", ");
				}
				if(s.getExpect()!=null){
					sb.append(s.getExpect().getExpect()+" ");
					sb.append(s.getExpect().getValue()+" ");
				}
					
				
				return sb.toString();
				
			}		
		
		
		return run.getRunName().getName();
	}

	String image(RunCommand run) {
		return "run.gif";
		
	}

	String text(CheckCommand check) {
		StringBuffer sb=new StringBuffer();
		if (check.getCheckName()==null){
			if(check.getName()==null){
				sb.append("{ Block } ");				
			}
			else{				
				sb.append(check.getName().getName()+" ");
			}
				Scope s=check.getScope();
				if(s.getFor()!=null)sb.append(s.getFor()+" ");
				if(s.getValue()!=0)sb.append(s.getValue()+" ");
				if(s.getBut()!=null)sb.append(s.getBut()+" ");
				
				for(Typescope t: s.getTypescope()){
					if(t.getExactly()!=null)sb.append(t.getExactly()+" ");
					sb.append(t.getValue()+" ");
					if(t.getAsname()!=null)sb.append(t.getAsname().getName()+" ");
					if(t.getPrev()!=null) sb.append(t.getPrev()+" ");
					if(t.getSl()!=null) sb.append(t.getSl()+" ");
					if(t.getName()!=null)sb.append(t.getName().getName()+" ");
					if(t.getPost()!=null)sb.append(t.getPost()+" ");
					if(s.getTypescope().lastIndexOf(t)!=s.getTypescope().size()-1)
						sb.append(", ");
				}
				if(s.getExpect()!=null){
					sb.append(s.getExpect().getExpect()+" ");
					sb.append(s.getExpect().getValue()+" ");
				}
					
				
				return sb.toString();
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
		return "enum.gif";
	}
}
