package fr.univartois.cril.xtext.als.uri;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;


public class AlsImportUriGlobalScopeProvider  extends ImportUriGlobalScopeProvider{

	@Override
	public IScope getScope(EObject context, EReference reference) {
		


		return super.getScope(context, reference);
	}
	
}
