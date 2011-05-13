/*
 * generated by Xtext
 */
package fr.univartois.cril.xtext.ui;


import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.editor.outline.actions.IContentOutlineNodeAdapterFactory;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.DefaultAntlrTokenToAttributeIdMapper;

import fr.univartois.cril.xtext.alloyplugin.editor.AlloyContentOutlinePage;
import fr.univartois.cril.xtext.ui.outline.AlsOutlineNodeAdapterFactory;


/**
 * Use this class to register components to be used within the IDE.
 */
public class AlsUiModule extends fr.univartois.cril.xtext.ui.AbstractAlsUiModule {
	public AlsUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindISemanticHighlightingConfiguration() {
		return HighlightingConfiguration.class;
	}

	public Class<? extends DefaultAntlrTokenToAttributeIdMapper> bindDefaultAntlrTokenToAttributeIdMapper() {
		return TokenToIdMapper.class;
	}
	
	public Class<? extends IContentOutlineNodeAdapterFactory> bindIContentOutlineNodeAdapterFactory() {
		return AlsOutlineNodeAdapterFactory.class;
	}


}
