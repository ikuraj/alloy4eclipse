/*
 * generated by Xtext
 */
package fr.univartois.cril.alloyplugin.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

import fr.univartois.cril.alloyplugin.services.BasicsGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class BasicsFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		BasicsGrammarAccess f = (fr.univartois.cril.alloyplugin.services.BasicsGrammarAccess) getGrammarAccess();
		c.setAutoLinewrap(120);
		c.setIndentationSpace("    ");
		this.setFormattingCurlyBracket(c, f);
		this.setFormattingAssertDecl(c, f);
		this.setFormattingOpen(c, f);
		this.setFormattingFactDecl(c, f);
		this.setFormattingFunDecl(c, f);
		this.setFormattingPredDecl(c, f);
		this.setFormattingEnumDecl(c, f);
		this.setFormattingPrivate(c, f);
		this.setFormattingSig(c, f);
		this.setFormattingSigQual(c, f);
		this.setFormattingExression(c, f);
		this.setFormattingTerminalExression(c, f);
		this.setFormattingRunDecl(c, f);
		this.setFormattingCheckDecl(c, f);
		this.setFormattingComma(c, f);
		this.setFormattingDote(c, f);
		this.setFormattingColon(c, f);
	}

	private void setFormattingCurlyBracket(FormattingConfig c,
			BasicsGrammarAccess f) {

		c.setIndentation(f.getLeftCurlyBracketAccess()
				.getLeftCurlyBracketKeyword(), f.getRightCurlyBracketAccess()
				.getRightCurlyBracketKeyword());

		c.setLinewrap().after(
				f.getLeftCurlyBracketAccess().getLeftCurlyBracketKeyword());
		c.setLinewrap().before(
				f.getRightCurlyBracketAccess().getRightCurlyBracketKeyword());
		c.setLinewrap().after(
				f.getRightCurlyBracketAccess().getRightCurlyBracketKeyword());
	}

	private void setFormattingFactDecl(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getFactDeclAccess().getFactKeyword_0());

	}

	private void setFormattingAssertDecl(FormattingConfig c,
			BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getAssertDeclAccess().getAssertKeyword_0());
	}

	private void setFormattingFunDecl(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getFunDeclAccess().getFunKeyword_1());
		c.setNoLinewrap().after(f.getPrivateAccess().getPrivateKeyword());
	}

	private void setFormattingPredDecl(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getPredDeclAccess().getPredPredKeyword_1_0());
		c.setNoLinewrap().after(f.getPrivateAccess().getPrivateKeyword());
	}

	private void setFormattingOpen(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap().before(f.getOpenAccess().getOpenKeyword_1());
		c.setNoLinewrap().after(f.getPrivateAccess().getPrivateKeyword());
	}

	private void setFormattingPrivate(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getPrivateAccess().getPrivateKeyword());
		c.setLinewrap().after(f.getPrivateAccess().getPrivateKeyword());
	}

	private void setFormattingEnumDecl(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getEnumDeclAccess().getEnumKeyword_0());

	}

	private void setFormattingSig(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getSigDeclAccess().getSigKeyword_1());
		c.setLinewrap().after(f.getSigDeclAccess().getCommaKeyword_6_1_0());
		c.setNoSpace().before(f.getSigDeclAccess().getCommaKeyword_6_1_0());
	}

	private void setFormattingSigQual(FormattingConfig c, BasicsGrammarAccess f) {
		c.setLinewrap(2).before(f.getSigQualAccess().getSigqAssignment_0());
		c.setNoLinewrap().after(f.getSigQualAccess().getSigqAssignment_0());
		c.setNoLinewrap().after(f.getSigQualAccess().getAbstractKeyword_1_0());
		c.setNoLinewrap().after(f.getSigQualAccess().getSomeKeyword_1_3());
		c.setNoLinewrap().after(f.getSigQualAccess().getLoneKeyword_1_1());
		c.setNoLinewrap().after(f.getSigQualAccess().getOneKeyword_1_2());
		c.setNoLinewrap().after(f.getSigQualAccess().getPrivateKeyword_1_4());

	}

	private void setFormattingDote(FormattingConfig c, BasicsGrammarAccess f) {
		c.setNoSpace().after(f.getDotAccess().getFullStopKeyword());
		c.setNoSpace().before(f.getDotAccess().getFullStopKeyword());
	}

	private void setFormattingExression(FormattingConfig c,
			BasicsGrammarAccess f) {
		c.setNoSpace().after(f.getExpressionAccess().getOpAssignment_1_2_0_0());

	}

	private void setFormattingTerminalExression(FormattingConfig c,
			BasicsGrammarAccess f) {
		c.setNoSpace().after(
				f.getTerminalExprAccess().getUnopAssignment_2_0_0());

	}

	private void setFormattingRunDecl(FormattingConfig c, BasicsGrammarAccess f) {
		c.setNoLinewrap().after(f.getRunDeclAccess().getColonKeyword_0_1());
		c.setNoSpace().before(f.getRunDeclAccess().getColonKeyword_0_1());
		c.setLinewrap(2)
				.before(f.getRunDeclAccess().getRunNameAssignment_0_0());
	}

	private void setFormattingComma(FormattingConfig c, BasicsGrammarAccess f) {
		c.setNoSpace().before(f.getCommaAccess().getCommaKeyword());
	}

	private void setFormattingCheckDecl(FormattingConfig c,
			BasicsGrammarAccess f) {
		c.setNoLinewrap().after(f.getCheckDeclAccess().getColonKeyword_0_1());
		c.setLinewrap(2).before(
				f.getCheckDeclAccess().getCheckCheckKeyword_1_0());
		c.setLinewrap(2).after(f.getCheckDeclAccess().getScopeAssignment_3());
	}

	private void setFormattingColon(FormattingConfig c, BasicsGrammarAccess f) {
		c.setNoSpace().before(f.getColonAccess().getColonKeyword());
	}

}
