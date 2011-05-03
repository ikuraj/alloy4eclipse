/*
* generated by Xtext
*/
package fr.univartois.cril.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import fr.univartois.cril.xtext.services.AlsGrammarAccess;

public class AlsParser extends AbstractContentAssistParser {
	
	@Inject
	private AlsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected fr.univartois.cril.xtext.ui.contentassist.antlr.internal.InternalAlsParser createParser() {
		fr.univartois.cril.xtext.ui.contentassist.antlr.internal.InternalAlsParser result = new fr.univartois.cril.xtext.ui.contentassist.antlr.internal.InternalAlsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getModuleAccess().getAlternatives_2_3_1(), "rule__Module__Alternatives_2_3_1");
					put(grammarAccess.getParagraphAccess().getAlternatives(), "rule__Paragraph__Alternatives");
					put(grammarAccess.getFunDeclAccess().getAlternatives_4(), "rule__FunDecl__Alternatives_4");
					put(grammarAccess.getPredDeclAccess().getAlternatives_4(), "rule__PredDecl__Alternatives_4");
					put(grammarAccess.getRunDeclAccess().getAlternatives_2(), "rule__RunDecl__Alternatives_2");
					put(grammarAccess.getCheckDeclAccess().getAlternatives_2(), "rule__CheckDecl__Alternatives_2");
					put(grammarAccess.getScopeAccess().getAlternatives(), "rule__Scope__Alternatives");
					put(grammarAccess.getTypescopeAccess().getAlternatives_3(), "rule__Typescope__Alternatives_3");
					put(grammarAccess.getTypescopeAccess().getAlternatives_3_1(), "rule__Typescope__Alternatives_3_1");
					put(grammarAccess.getLetOutDeclAccess().getAlternatives_2(), "rule__LetOutDecl__Alternatives_2");
					put(grammarAccess.getSigQualAccess().getSigqAlternatives_0_0(), "rule__SigQual__SigqAlternatives_0_0");
					put(grammarAccess.getSigQualAccess().getAlternatives_1(), "rule__SigQual__Alternatives_1");
					put(grammarAccess.getSigExtAccess().getAlternatives(), "rule__SigExt__Alternatives");
					put(grammarAccess.getExpressionAccess().getAlternatives_1(), "rule__Expression__Alternatives_1");
					put(grammarAccess.getExpressionAccess().getAlternatives_1_2_0(), "rule__Expression__Alternatives_1_2_0");
					put(grammarAccess.getExpressionAccess().getAlternatives_1_3_0(), "rule__Expression__Alternatives_1_3_0");
					put(grammarAccess.getTerminalExpressionAccess().getAlternatives(), "rule__TerminalExpression__Alternatives");
					put(grammarAccess.getTerminalExpressionAccess().getAlternatives_3_2(), "rule__TerminalExpression__Alternatives_3_2");
					put(grammarAccess.getTerminalExpressionAccess().getAlternatives_12_2_0(), "rule__TerminalExpression__Alternatives_12_2_0");
					put(grammarAccess.getTerminalExpressionAccess().getAlternatives_12_3(), "rule__TerminalExpression__Alternatives_12_3");
					put(grammarAccess.getQuantAccess().getAlternatives(), "rule__Quant__Alternatives");
					put(grammarAccess.getBinOpAccess().getAlternatives_1(), "rule__BinOp__Alternatives_1");
					put(grammarAccess.getUnOpAccess().getAlternatives_1(), "rule__UnOp__Alternatives_1");
					put(grammarAccess.getUnOpAccess().getOpAlternatives_1_3_0(), "rule__UnOp__OpAlternatives_1_3_0");
					put(grammarAccess.getCommonQuantUnOpAccess().getAlternatives_1(), "rule__CommonQuantUnOp__Alternatives_1");
					put(grammarAccess.getCompareOpAccess().getAlternatives(), "rule__CompareOp__Alternatives");
					put(grammarAccess.getArrowOpAccess().getAlternatives_0(), "rule__ArrowOp__Alternatives_0");
					put(grammarAccess.getBlockOrBarAccess().getAlternatives(), "rule__BlockOrBar__Alternatives");
					put(grammarAccess.getNameAccess().getAlternatives_0(), "rule__Name__Alternatives_0");
					put(grammarAccess.getReferencesNameAccess().getAlternatives(), "rule__ReferencesName__Alternatives");
					put(grammarAccess.getReferencesSigAccess().getAlternatives_1(), "rule__ReferencesSig__Alternatives_1");
					put(grammarAccess.getRefAccess().getAlternatives_1(), "rule__Ref__Alternatives_1");
					put(grammarAccess.getSpecificationAccess().getGroup(), "rule__Specification__Group__0");
					put(grammarAccess.getModuleAccess().getGroup(), "rule__Module__Group__0");
					put(grammarAccess.getModuleAccess().getGroup_2(), "rule__Module__Group_2__0");
					put(grammarAccess.getModuleAccess().getGroup_2_3(), "rule__Module__Group_2_3__0");
					put(grammarAccess.getModuleAccess().getGroup_2_3_1_0(), "rule__Module__Group_2_3_1_0__0");
					put(grammarAccess.getOpenAccess().getGroup(), "rule__Open__Group__0");
					put(grammarAccess.getOpenAccess().getGroup_2(), "rule__Open__Group_2__0");
					put(grammarAccess.getOpenAccess().getGroup_2_2(), "rule__Open__Group_2_2__0");
					put(grammarAccess.getOpenAccess().getGroup_3(), "rule__Open__Group_3__0");
					put(grammarAccess.getFactDeclAccess().getGroup(), "rule__FactDecl__Group__0");
					put(grammarAccess.getAssertDeclAccess().getGroup(), "rule__AssertDecl__Group__0");
					put(grammarAccess.getFunDeclAccess().getGroup(), "rule__FunDecl__Group__0");
					put(grammarAccess.getFunDeclAccess().getGroup_2(), "rule__FunDecl__Group_2__0");
					put(grammarAccess.getFunDeclAccess().getGroup_4_0(), "rule__FunDecl__Group_4_0__0");
					put(grammarAccess.getFunDeclAccess().getGroup_4_0_1(), "rule__FunDecl__Group_4_0_1__0");
					put(grammarAccess.getFunDeclAccess().getGroup_4_0_1_1(), "rule__FunDecl__Group_4_0_1_1__0");
					put(grammarAccess.getFunDeclAccess().getGroup_4_1(), "rule__FunDecl__Group_4_1__0");
					put(grammarAccess.getFunDeclAccess().getGroup_4_1_1(), "rule__FunDecl__Group_4_1_1__0");
					put(grammarAccess.getFunDeclAccess().getGroup_4_1_1_1(), "rule__FunDecl__Group_4_1_1_1__0");
					put(grammarAccess.getFunDeclWParamAccess().getGroup(), "rule__FunDeclWParam__Group__0");
					put(grammarAccess.getFunDeclWParamAccess().getGroup_2(), "rule__FunDeclWParam__Group_2__0");
					put(grammarAccess.getPredDeclAccess().getGroup(), "rule__PredDecl__Group__0");
					put(grammarAccess.getPredDeclAccess().getGroup_2(), "rule__PredDecl__Group_2__0");
					put(grammarAccess.getPredDeclAccess().getGroup_4_0(), "rule__PredDecl__Group_4_0__0");
					put(grammarAccess.getPredDeclAccess().getGroup_4_0_1(), "rule__PredDecl__Group_4_0_1__0");
					put(grammarAccess.getPredDeclAccess().getGroup_4_0_1_1(), "rule__PredDecl__Group_4_0_1_1__0");
					put(grammarAccess.getPredDeclAccess().getGroup_4_1(), "rule__PredDecl__Group_4_1__0");
					put(grammarAccess.getPredDeclAccess().getGroup_4_1_1(), "rule__PredDecl__Group_4_1_1__0");
					put(grammarAccess.getPredDeclAccess().getGroup_4_1_1_1(), "rule__PredDecl__Group_4_1_1_1__0");
					put(grammarAccess.getRunDeclAccess().getGroup(), "rule__RunDecl__Group__0");
					put(grammarAccess.getRunDeclAccess().getGroup_0(), "rule__RunDecl__Group_0__0");
					put(grammarAccess.getCheckDeclAccess().getGroup(), "rule__CheckDecl__Group__0");
					put(grammarAccess.getCheckDeclAccess().getGroup_0(), "rule__CheckDecl__Group_0__0");
					put(grammarAccess.getScopeAccess().getGroup_0(), "rule__Scope__Group_0__0");
					put(grammarAccess.getScopeAccess().getGroup_1(), "rule__Scope__Group_1__0");
					put(grammarAccess.getScopeAccess().getGroup_1_5(), "rule__Scope__Group_1_5__0");
					put(grammarAccess.getScopeAccess().getGroup_2(), "rule__Scope__Group_2__0");
					put(grammarAccess.getScopeAccess().getGroup_2_3(), "rule__Scope__Group_2_3__0");
					put(grammarAccess.getScopeAccess().getGroup_3(), "rule__Scope__Group_3__0");
					put(grammarAccess.getExpectationAccess().getGroup(), "rule__Expectation__Group__0");
					put(grammarAccess.getTypescopeAccess().getGroup(), "rule__Typescope__Group__0");
					put(grammarAccess.getEnumDeclAccess().getGroup(), "rule__EnumDecl__Group__0");
					put(grammarAccess.getEnumDeclAccess().getGroup_3(), "rule__EnumDecl__Group_3__0");
					put(grammarAccess.getLetOutDeclAccess().getGroup(), "rule__LetOutDecl__Group__0");
					put(grammarAccess.getLetOutDeclAccess().getGroup_1(), "rule__LetOutDecl__Group_1__0");
					put(grammarAccess.getLetOutDeclAccess().getGroup_1_1(), "rule__LetOutDecl__Group_1_1__0");
					put(grammarAccess.getLetOutDeclAccess().getGroup_1_1_1(), "rule__LetOutDecl__Group_1_1_1__0");
					put(grammarAccess.getLetOutDeclAccess().getGroup_2_1(), "rule__LetOutDecl__Group_2_1__0");
					put(grammarAccess.getSigDeclAccess().getGroup(), "rule__SigDecl__Group__0");
					put(grammarAccess.getSigDeclAccess().getGroup_3(), "rule__SigDecl__Group_3__0");
					put(grammarAccess.getSigDeclAccess().getGroup_6(), "rule__SigDecl__Group_6__0");
					put(grammarAccess.getSigDeclAccess().getGroup_6_1(), "rule__SigDecl__Group_6_1__0");
					put(grammarAccess.getSigQualAccess().getGroup(), "rule__SigQual__Group__0");
					put(grammarAccess.getSigExtAccess().getGroup_0(), "rule__SigExt__Group_0__0");
					put(grammarAccess.getSigExtAccess().getGroup_1(), "rule__SigExt__Group_1__0");
					put(grammarAccess.getSigExtAccess().getGroup_1_2(), "rule__SigExt__Group_1_2__0");
					put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_0(), "rule__Expression__Group_1_0__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_1(), "rule__Expression__Group_1_1__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_2(), "rule__Expression__Group_1_2__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_3(), "rule__Expression__Group_1_3__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_3_2(), "rule__Expression__Group_1_3_2__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_4(), "rule__Expression__Group_1_4__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_4_1(), "rule__Expression__Group_1_4_1__0");
					put(grammarAccess.getExpressionAccess().getGroup_1_4_1_1(), "rule__Expression__Group_1_4_1_1__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_0(), "rule__TerminalExpression__Group_0__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_0_3(), "rule__TerminalExpression__Group_0_3__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_1(), "rule__TerminalExpression__Group_1__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_1_3(), "rule__TerminalExpression__Group_1_3__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_2(), "rule__TerminalExpression__Group_2__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_3(), "rule__TerminalExpression__Group_3__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_3_2_0(), "rule__TerminalExpression__Group_3_2_0__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_3_2_0_1(), "rule__TerminalExpression__Group_3_2_0_1__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_4(), "rule__TerminalExpression__Group_4__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_5(), "rule__TerminalExpression__Group_5__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_6(), "rule__TerminalExpression__Group_6__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_7(), "rule__TerminalExpression__Group_7__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_8(), "rule__TerminalExpression__Group_8__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_9(), "rule__TerminalExpression__Group_9__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_10(), "rule__TerminalExpression__Group_10__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_11(), "rule__TerminalExpression__Group_11__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_12(), "rule__TerminalExpression__Group_12__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_12_2(), "rule__TerminalExpression__Group_12_2__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_13(), "rule__TerminalExpression__Group_13__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_14(), "rule__TerminalExpression__Group_14__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_14_3(), "rule__TerminalExpression__Group_14_3__0");
					put(grammarAccess.getDeclAccess().getGroup(), "rule__Decl__Group__0");
					put(grammarAccess.getDeclAccess().getGroup_3(), "rule__Decl__Group_3__0");
					put(grammarAccess.getLetDeclAccess().getGroup(), "rule__LetDecl__Group__0");
					put(grammarAccess.getBinOpAccess().getGroup(), "rule__BinOp__Group__0");
					put(grammarAccess.getUnOpAccess().getGroup(), "rule__UnOp__Group__0");
					put(grammarAccess.getCommonQuantUnOpAccess().getGroup(), "rule__CommonQuantUnOp__Group__0");
					put(grammarAccess.getArrowOpAccess().getGroup(), "rule__ArrowOp__Group__0");
					put(grammarAccess.getBlockAccess().getGroup(), "rule__Block__Group__0");
					put(grammarAccess.getBlockOrBarAccess().getGroup_1(), "rule__BlockOrBar__Group_1__0");
					put(grammarAccess.getOpenNameAccess().getGroup(), "rule__OpenName__Group__0");
					put(grammarAccess.getFactNameAccess().getGroup(), "rule__FactName__Group__0");
					put(grammarAccess.getAssertionNameAccess().getGroup(), "rule__AssertionName__Group__0");
					put(grammarAccess.getEnumNameAccess().getGroup(), "rule__EnumName__Group__0");
					put(grammarAccess.getLetNameAccess().getGroup(), "rule__LetName__Group__0");
					put(grammarAccess.getNameAliasAccess().getGroup(), "rule__NameAlias__Group__0");
					put(grammarAccess.getNameAliasAccess().getGroup_1(), "rule__NameAlias__Group_1__0");
					put(grammarAccess.getNameAccess().getGroup(), "rule__Name__Group__0");
					put(grammarAccess.getNameAccess().getGroup_1(), "rule__Name__Group_1__0");
					put(grammarAccess.getReferencesSigAccess().getGroup(), "rule__ReferencesSig__Group__0");
					put(grammarAccess.getRefAccess().getGroup(), "rule__Ref__Group__0");
					put(grammarAccess.getSpecificationAccess().getModuleAssignment_0(), "rule__Specification__ModuleAssignment_0");
					put(grammarAccess.getSpecificationAccess().getOpenAssignment_1(), "rule__Specification__OpenAssignment_1");
					put(grammarAccess.getSpecificationAccess().getParagraphAssignment_2(), "rule__Specification__ParagraphAssignment_2");
					put(grammarAccess.getModuleAccess().getModuleNameAssignment_1(), "rule__Module__ModuleNameAssignment_1");
					put(grammarAccess.getModuleAccess().getLeftAssignment_2_0(), "rule__Module__LeftAssignment_2_0");
					put(grammarAccess.getModuleAccess().getExactlyAssignment_2_1(), "rule__Module__ExactlyAssignment_2_1");
					put(grammarAccess.getModuleAccess().getNameAssignment_2_2(), "rule__Module__NameAssignment_2_2");
					put(grammarAccess.getModuleAccess().getCommaAssignment_2_3_0(), "rule__Module__CommaAssignment_2_3_0");
					put(grammarAccess.getModuleAccess().getExactlyAssignment_2_3_1_0_0(), "rule__Module__ExactlyAssignment_2_3_1_0_0");
					put(grammarAccess.getModuleAccess().getNumberAssignment_2_3_1_0_1(), "rule__Module__NumberAssignment_2_3_1_0_1");
					put(grammarAccess.getModuleAccess().getNameAssignment_2_3_1_1(), "rule__Module__NameAssignment_2_3_1_1");
					put(grammarAccess.getModuleAccess().getRightAssignment_2_4(), "rule__Module__RightAssignment_2_4");
					put(grammarAccess.getOpenAccess().getOpenNameAssignment_1(), "rule__Open__OpenNameAssignment_1");
					put(grammarAccess.getOpenAccess().getLeftAssignment_2_0(), "rule__Open__LeftAssignment_2_0");
					put(grammarAccess.getOpenAccess().getRefAssignment_2_1(), "rule__Open__RefAssignment_2_1");
					put(grammarAccess.getOpenAccess().getCommaAssignment_2_2_0(), "rule__Open__CommaAssignment_2_2_0");
					put(grammarAccess.getOpenAccess().getRefAssignment_2_2_1(), "rule__Open__RefAssignment_2_2_1");
					put(grammarAccess.getOpenAccess().getRightAssignment_2_3(), "rule__Open__RightAssignment_2_3");
					put(grammarAccess.getOpenAccess().getNameAsAssignment_3_1(), "rule__Open__NameAsAssignment_3_1");
					put(grammarAccess.getFactDeclAccess().getFactNameAssignment_0(), "rule__FactDecl__FactNameAssignment_0");
					put(grammarAccess.getFactDeclAccess().getBlockAssignment_1(), "rule__FactDecl__BlockAssignment_1");
					put(grammarAccess.getAssertDeclAccess().getAssertionNameAssignment_0(), "rule__AssertDecl__AssertionNameAssignment_0");
					put(grammarAccess.getAssertDeclAccess().getBlockAssignment_1(), "rule__AssertDecl__BlockAssignment_1");
					put(grammarAccess.getFunDeclAccess().getRefAssignment_2_0(), "rule__FunDecl__RefAssignment_2_0");
					put(grammarAccess.getFunDeclAccess().getDotAssignment_2_1(), "rule__FunDecl__DotAssignment_2_1");
					put(grammarAccess.getFunDeclAccess().getFunctionNameAssignment_3(), "rule__FunDecl__FunctionNameAssignment_3");
					put(grammarAccess.getFunDeclAccess().getLeftSAssignment_4_0_0(), "rule__FunDecl__LeftSAssignment_4_0_0");
					put(grammarAccess.getFunDeclAccess().getDeclAssignment_4_0_1_0(), "rule__FunDecl__DeclAssignment_4_0_1_0");
					put(grammarAccess.getFunDeclAccess().getCommaAssignment_4_0_1_1_0(), "rule__FunDecl__CommaAssignment_4_0_1_1_0");
					put(grammarAccess.getFunDeclAccess().getDeclAssignment_4_0_1_1_1(), "rule__FunDecl__DeclAssignment_4_0_1_1_1");
					put(grammarAccess.getFunDeclAccess().getRightSAssignment_4_0_2(), "rule__FunDecl__RightSAssignment_4_0_2");
					put(grammarAccess.getFunDeclAccess().getLeftPAssignment_4_1_0(), "rule__FunDecl__LeftPAssignment_4_1_0");
					put(grammarAccess.getFunDeclAccess().getDeclAssignment_4_1_1_0(), "rule__FunDecl__DeclAssignment_4_1_1_0");
					put(grammarAccess.getFunDeclAccess().getCommaAssignment_4_1_1_1_0(), "rule__FunDecl__CommaAssignment_4_1_1_1_0");
					put(grammarAccess.getFunDeclAccess().getDeclAssignment_4_1_1_1_1(), "rule__FunDecl__DeclAssignment_4_1_1_1_1");
					put(grammarAccess.getFunDeclAccess().getRightPAssignment_4_1_2(), "rule__FunDecl__RightPAssignment_4_1_2");
					put(grammarAccess.getFunDeclAccess().getColonAssignment_5(), "rule__FunDecl__ColonAssignment_5");
					put(grammarAccess.getFunDeclAccess().getExprAssignment_6(), "rule__FunDecl__ExprAssignment_6");
					put(grammarAccess.getFunDeclAccess().getBlockAssignment_7(), "rule__FunDecl__BlockAssignment_7");
					put(grammarAccess.getFunDeclWParamAccess().getRefAssignment_2_0(), "rule__FunDeclWParam__RefAssignment_2_0");
					put(grammarAccess.getFunDeclWParamAccess().getDotAssignment_2_1(), "rule__FunDeclWParam__DotAssignment_2_1");
					put(grammarAccess.getFunDeclWParamAccess().getFunctionNamewParamAssignment_3(), "rule__FunDeclWParam__FunctionNamewParamAssignment_3");
					put(grammarAccess.getFunDeclWParamAccess().getColonAssignment_4(), "rule__FunDeclWParam__ColonAssignment_4");
					put(grammarAccess.getFunDeclWParamAccess().getExprAssignment_5(), "rule__FunDeclWParam__ExprAssignment_5");
					put(grammarAccess.getFunDeclWParamAccess().getBlockAssignment_6(), "rule__FunDeclWParam__BlockAssignment_6");
					put(grammarAccess.getPredDeclAccess().getRefAssignment_2_0(), "rule__PredDecl__RefAssignment_2_0");
					put(grammarAccess.getPredDeclAccess().getDotAssignment_2_1(), "rule__PredDecl__DotAssignment_2_1");
					put(grammarAccess.getPredDeclAccess().getPredicateNameAssignment_3(), "rule__PredDecl__PredicateNameAssignment_3");
					put(grammarAccess.getPredDeclAccess().getLeftSAssignment_4_0_0(), "rule__PredDecl__LeftSAssignment_4_0_0");
					put(grammarAccess.getPredDeclAccess().getDeclAssignment_4_0_1_0(), "rule__PredDecl__DeclAssignment_4_0_1_0");
					put(grammarAccess.getPredDeclAccess().getCommaAssignment_4_0_1_1_0(), "rule__PredDecl__CommaAssignment_4_0_1_1_0");
					put(grammarAccess.getPredDeclAccess().getDeclAssignment_4_0_1_1_1(), "rule__PredDecl__DeclAssignment_4_0_1_1_1");
					put(grammarAccess.getPredDeclAccess().getRightSAssignment_4_0_2(), "rule__PredDecl__RightSAssignment_4_0_2");
					put(grammarAccess.getPredDeclAccess().getLeftPAssignment_4_1_0(), "rule__PredDecl__LeftPAssignment_4_1_0");
					put(grammarAccess.getPredDeclAccess().getDeclAssignment_4_1_1_0(), "rule__PredDecl__DeclAssignment_4_1_1_0");
					put(grammarAccess.getPredDeclAccess().getCommaAssignment_4_1_1_1_0(), "rule__PredDecl__CommaAssignment_4_1_1_1_0");
					put(grammarAccess.getPredDeclAccess().getDeclAssignment_4_1_1_1_1(), "rule__PredDecl__DeclAssignment_4_1_1_1_1");
					put(grammarAccess.getPredDeclAccess().getRightPAssignment_4_1_2(), "rule__PredDecl__RightPAssignment_4_1_2");
					put(grammarAccess.getPredDeclAccess().getBlockAssignment_5(), "rule__PredDecl__BlockAssignment_5");
					put(grammarAccess.getRunDeclAccess().getRunNameAssignment_0_0(), "rule__RunDecl__RunNameAssignment_0_0");
					put(grammarAccess.getRunDeclAccess().getName2Assignment_2_0(), "rule__RunDecl__Name2Assignment_2_0");
					put(grammarAccess.getRunDeclAccess().getBlockAssignment_2_1(), "rule__RunDecl__BlockAssignment_2_1");
					put(grammarAccess.getRunDeclAccess().getScopeAssignment_3(), "rule__RunDecl__ScopeAssignment_3");
					put(grammarAccess.getCheckDeclAccess().getCheckNameAssignment_0_0(), "rule__CheckDecl__CheckNameAssignment_0_0");
					put(grammarAccess.getCheckDeclAccess().getNameAssignment_2_0(), "rule__CheckDecl__NameAssignment_2_0");
					put(grammarAccess.getCheckDeclAccess().getBlockAssignment_2_1(), "rule__CheckDecl__BlockAssignment_2_1");
					put(grammarAccess.getCheckDeclAccess().getScopeAssignment_3(), "rule__CheckDecl__ScopeAssignment_3");
					put(grammarAccess.getScopeAccess().getExpectAssignment_0_3(), "rule__Scope__ExpectAssignment_0_3");
					put(grammarAccess.getScopeAccess().getTypescopeAssignment_1_4(), "rule__Scope__TypescopeAssignment_1_4");
					put(grammarAccess.getScopeAccess().getCommaAssignment_1_5_0(), "rule__Scope__CommaAssignment_1_5_0");
					put(grammarAccess.getScopeAccess().getTypescopeAssignment_1_5_1(), "rule__Scope__TypescopeAssignment_1_5_1");
					put(grammarAccess.getScopeAccess().getExpectAssignment_1_6(), "rule__Scope__ExpectAssignment_1_6");
					put(grammarAccess.getScopeAccess().getTypescopeAssignment_2_2(), "rule__Scope__TypescopeAssignment_2_2");
					put(grammarAccess.getScopeAccess().getCommaAssignment_2_3_0(), "rule__Scope__CommaAssignment_2_3_0");
					put(grammarAccess.getScopeAccess().getTypescopeAssignment_2_3_1(), "rule__Scope__TypescopeAssignment_2_3_1");
					put(grammarAccess.getScopeAccess().getExpectAssignment_2_4(), "rule__Scope__ExpectAssignment_2_4");
					put(grammarAccess.getScopeAccess().getExpectAssignment_3_1(), "rule__Scope__ExpectAssignment_3_1");
					put(grammarAccess.getExpectationAccess().getValueAssignment_1(), "rule__Expectation__ValueAssignment_1");
					put(grammarAccess.getTypescopeAccess().getNameAssignment_3_0(), "rule__Typescope__NameAssignment_3_0");
					put(grammarAccess.getEnumDeclAccess().getEnumNameAssignment_0(), "rule__EnumDecl__EnumNameAssignment_0");
					put(grammarAccess.getEnumDeclAccess().getLeftCAssignment_1(), "rule__EnumDecl__LeftCAssignment_1");
					put(grammarAccess.getEnumDeclAccess().getPropertyEnumAssignment_2(), "rule__EnumDecl__PropertyEnumAssignment_2");
					put(grammarAccess.getEnumDeclAccess().getCommaAssignment_3_0(), "rule__EnumDecl__CommaAssignment_3_0");
					put(grammarAccess.getEnumDeclAccess().getPropertyEnumAssignment_3_1(), "rule__EnumDecl__PropertyEnumAssignment_3_1");
					put(grammarAccess.getEnumDeclAccess().getRightCAssignment_4(), "rule__EnumDecl__RightCAssignment_4");
					put(grammarAccess.getLetOutDeclAccess().getLetNameAssignment_0(), "rule__LetOutDecl__LetNameAssignment_0");
					put(grammarAccess.getLetOutDeclAccess().getLeftSAssignment_1_0(), "rule__LetOutDecl__LeftSAssignment_1_0");
					put(grammarAccess.getLetOutDeclAccess().getNameRefAssignment_1_1_0(), "rule__LetOutDecl__NameRefAssignment_1_1_0");
					put(grammarAccess.getLetOutDeclAccess().getCommaAssignment_1_1_1_0(), "rule__LetOutDecl__CommaAssignment_1_1_1_0");
					put(grammarAccess.getLetOutDeclAccess().getNameRefAssignment_1_1_1_1(), "rule__LetOutDecl__NameRefAssignment_1_1_1_1");
					put(grammarAccess.getLetOutDeclAccess().getRightSAssignment_1_2(), "rule__LetOutDecl__RightSAssignment_1_2");
					put(grammarAccess.getLetOutDeclAccess().getBlockAssignment_2_0(), "rule__LetOutDecl__BlockAssignment_2_0");
					put(grammarAccess.getLetOutDeclAccess().getExprNameAssignment_2_1_1(), "rule__LetOutDecl__ExprNameAssignment_2_1_1");
					put(grammarAccess.getSigDeclAccess().getSignatureNameAssignment_2(), "rule__SigDecl__SignatureNameAssignment_2");
					put(grammarAccess.getSigDeclAccess().getCommaAssignment_3_0(), "rule__SigDecl__CommaAssignment_3_0");
					put(grammarAccess.getSigDeclAccess().getSignatureNameAssignment_3_1(), "rule__SigDecl__SignatureNameAssignment_3_1");
					put(grammarAccess.getSigDeclAccess().getSigExtAssignment_4(), "rule__SigDecl__SigExtAssignment_4");
					put(grammarAccess.getSigDeclAccess().getDeclAssignment_6_0(), "rule__SigDecl__DeclAssignment_6_0");
					put(grammarAccess.getSigDeclAccess().getComma2Assignment_6_1_0(), "rule__SigDecl__Comma2Assignment_6_1_0");
					put(grammarAccess.getSigDeclAccess().getDeclAssignment_6_1_1(), "rule__SigDecl__DeclAssignment_6_1_1");
					put(grammarAccess.getSigDeclAccess().getBlockAssignment_8(), "rule__SigDecl__BlockAssignment_8");
					put(grammarAccess.getSigQualAccess().getSigqAssignment_0(), "rule__SigQual__SigqAssignment_0");
					put(grammarAccess.getSigExtAccess().getRefAssignment_0_1(), "rule__SigExt__RefAssignment_0_1");
					put(grammarAccess.getSigExtAccess().getRefAssignment_1_1(), "rule__SigExt__RefAssignment_1_1");
					put(grammarAccess.getSigExtAccess().getRef2Assignment_1_2_1(), "rule__SigExt__Ref2Assignment_1_2_1");
					put(grammarAccess.getExpressionAccess().getBinOpAssignment_1_0_0(), "rule__Expression__BinOpAssignment_1_0_0");
					put(grammarAccess.getExpressionAccess().getExprAssignment_1_0_1(), "rule__Expression__ExprAssignment_1_0_1");
					put(grammarAccess.getExpressionAccess().getArrowOpAssignment_1_1_0(), "rule__Expression__ArrowOpAssignment_1_1_0");
					put(grammarAccess.getExpressionAccess().getExprAssignment_1_1_1(), "rule__Expression__ExprAssignment_1_1_1");
					put(grammarAccess.getExpressionAccess().getCmpAssignment_1_2_1(), "rule__Expression__CmpAssignment_1_2_1");
					put(grammarAccess.getExpressionAccess().getExprAssignment_1_2_2(), "rule__Expression__ExprAssignment_1_2_2");
					put(grammarAccess.getExpressionAccess().getExprAssignment_1_3_1(), "rule__Expression__ExprAssignment_1_3_1");
					put(grammarAccess.getExpressionAccess().getExprAssignment_1_3_2_1(), "rule__Expression__ExprAssignment_1_3_2_1");
					put(grammarAccess.getExpressionAccess().getLeftAssignment_1_4_0(), "rule__Expression__LeftAssignment_1_4_0");
					put(grammarAccess.getExpressionAccess().getExprAssignment_1_4_1_0(), "rule__Expression__ExprAssignment_1_4_1_0");
					put(grammarAccess.getExpressionAccess().getCommaAssignment_1_4_1_1_0(), "rule__Expression__CommaAssignment_1_4_1_1_0");
					put(grammarAccess.getExpressionAccess().getExprAssignment_1_4_1_1_1(), "rule__Expression__ExprAssignment_1_4_1_1_1");
					put(grammarAccess.getExpressionAccess().getRightAssignment_1_4_2(), "rule__Expression__RightAssignment_1_4_2");
					put(grammarAccess.getTerminalExpressionAccess().getLetAssignment_0_1(), "rule__TerminalExpression__LetAssignment_0_1");
					put(grammarAccess.getTerminalExpressionAccess().getLetdeclAssignment_0_2(), "rule__TerminalExpression__LetdeclAssignment_0_2");
					put(grammarAccess.getTerminalExpressionAccess().getCommaAssignment_0_3_0(), "rule__TerminalExpression__CommaAssignment_0_3_0");
					put(grammarAccess.getTerminalExpressionAccess().getLetdeclAssignment_0_3_1(), "rule__TerminalExpression__LetdeclAssignment_0_3_1");
					put(grammarAccess.getTerminalExpressionAccess().getBlockOrBarAssignment_0_4(), "rule__TerminalExpression__BlockOrBarAssignment_0_4");
					put(grammarAccess.getTerminalExpressionAccess().getQuantAssignment_1_1(), "rule__TerminalExpression__QuantAssignment_1_1");
					put(grammarAccess.getTerminalExpressionAccess().getDeclAssignment_1_2(), "rule__TerminalExpression__DeclAssignment_1_2");
					put(grammarAccess.getTerminalExpressionAccess().getCommaAssignment_1_3_0(), "rule__TerminalExpression__CommaAssignment_1_3_0");
					put(grammarAccess.getTerminalExpressionAccess().getDeclAssignment_1_3_1(), "rule__TerminalExpression__DeclAssignment_1_3_1");
					put(grammarAccess.getTerminalExpressionAccess().getBlockOrBarAssignment_1_4(), "rule__TerminalExpression__BlockOrBarAssignment_1_4");
					put(grammarAccess.getTerminalExpressionAccess().getUnOpAssignment_2_1(), "rule__TerminalExpression__UnOpAssignment_2_1");
					put(grammarAccess.getTerminalExpressionAccess().getExprAssignment_2_2(), "rule__TerminalExpression__ExprAssignment_2_2");
					put(grammarAccess.getTerminalExpressionAccess().getCommonAssignment_3_1(), "rule__TerminalExpression__CommonAssignment_3_1");
					put(grammarAccess.getTerminalExpressionAccess().getDeclAssignment_3_2_0_0(), "rule__TerminalExpression__DeclAssignment_3_2_0_0");
					put(grammarAccess.getTerminalExpressionAccess().getCommaAssignment_3_2_0_1_0(), "rule__TerminalExpression__CommaAssignment_3_2_0_1_0");
					put(grammarAccess.getTerminalExpressionAccess().getDeclAssignment_3_2_0_1_1(), "rule__TerminalExpression__DeclAssignment_3_2_0_1_1");
					put(grammarAccess.getTerminalExpressionAccess().getBlockOrBarAssignment_3_2_0_2(), "rule__TerminalExpression__BlockOrBarAssignment_3_2_0_2");
					put(grammarAccess.getTerminalExpressionAccess().getExprAssignment_3_2_1(), "rule__TerminalExpression__ExprAssignment_3_2_1");
					put(grammarAccess.getTerminalExpressionAccess().getNoneAssignment_6_1(), "rule__TerminalExpression__NoneAssignment_6_1");
					put(grammarAccess.getTerminalExpressionAccess().getIdenAssignment_7_1(), "rule__TerminalExpression__IdenAssignment_7_1");
					put(grammarAccess.getTerminalExpressionAccess().getUnivAssignment_8_1(), "rule__TerminalExpression__UnivAssignment_8_1");
					put(grammarAccess.getTerminalExpressionAccess().getIntAssignment_9_1(), "rule__TerminalExpression__IntAssignment_9_1");
					put(grammarAccess.getTerminalExpressionAccess().getSeqAssignment_10_1(), "rule__TerminalExpression__SeqAssignment_10_1");
					put(grammarAccess.getTerminalExpressionAccess().getParOAssignment_11_1(), "rule__TerminalExpression__ParOAssignment_11_1");
					put(grammarAccess.getTerminalExpressionAccess().getExprAssignment_11_2(), "rule__TerminalExpression__ExprAssignment_11_2");
					put(grammarAccess.getTerminalExpressionAccess().getParFAssignment_11_3(), "rule__TerminalExpression__ParFAssignment_11_3");
					put(grammarAccess.getTerminalExpressionAccess().getAsnameAssignment_12_2_0_0(), "rule__TerminalExpression__AsnameAssignment_12_2_0_0");
					put(grammarAccess.getTerminalExpressionAccess().getNameRefAssignment_12_3_0(), "rule__TerminalExpression__NameRefAssignment_12_3_0");
					put(grammarAccess.getTerminalExpressionAccess().getBlockAssignment_13_1(), "rule__TerminalExpression__BlockAssignment_13_1");
					put(grammarAccess.getTerminalExpressionAccess().getLeftCurlyBracketAssignment_14_1(), "rule__TerminalExpression__LeftCurlyBracketAssignment_14_1");
					put(grammarAccess.getTerminalExpressionAccess().getDeclAssignment_14_2(), "rule__TerminalExpression__DeclAssignment_14_2");
					put(grammarAccess.getTerminalExpressionAccess().getCommaAssignment_14_3_0(), "rule__TerminalExpression__CommaAssignment_14_3_0");
					put(grammarAccess.getTerminalExpressionAccess().getDeclAssignment_14_3_1(), "rule__TerminalExpression__DeclAssignment_14_3_1");
					put(grammarAccess.getTerminalExpressionAccess().getBlockOrBarAssignment_14_4(), "rule__TerminalExpression__BlockOrBarAssignment_14_4");
					put(grammarAccess.getTerminalExpressionAccess().getRightCurlyBracketAssignment_14_5(), "rule__TerminalExpression__RightCurlyBracketAssignment_14_5");
					put(grammarAccess.getDeclAccess().getPropertyNameAssignment_2(), "rule__Decl__PropertyNameAssignment_2");
					put(grammarAccess.getDeclAccess().getCommaAssignment_3_0(), "rule__Decl__CommaAssignment_3_0");
					put(grammarAccess.getDeclAccess().getPropertyNameAssignment_3_1(), "rule__Decl__PropertyNameAssignment_3_1");
					put(grammarAccess.getDeclAccess().getColonAssignment_4(), "rule__Decl__ColonAssignment_4");
					put(grammarAccess.getDeclAccess().getExprAssignment_6(), "rule__Decl__ExprAssignment_6");
					put(grammarAccess.getLetDeclAccess().getNameExpressionAssignment_0(), "rule__LetDecl__NameExpressionAssignment_0");
					put(grammarAccess.getLetDeclAccess().getExprAssignment_2(), "rule__LetDecl__ExprAssignment_2");
					put(grammarAccess.getBinOpAccess().getDotAssignment_1_12(), "rule__BinOp__DotAssignment_1_12");
					put(grammarAccess.getUnOpAccess().getOpAssignment_1_3(), "rule__UnOp__OpAssignment_1_3");
					put(grammarAccess.getArrowOpAccess().getArrowAssignment_1(), "rule__ArrowOp__ArrowAssignment_1");
					put(grammarAccess.getBlockAccess().getLeftCAssignment_0(), "rule__Block__LeftCAssignment_0");
					put(grammarAccess.getBlockAccess().getExprAssignment_1(), "rule__Block__ExprAssignment_1");
					put(grammarAccess.getBlockAccess().getRightCAssignment_2(), "rule__Block__RightCAssignment_2");
					put(grammarAccess.getBlockOrBarAccess().getBlockAssignment_0(), "rule__BlockOrBar__BlockAssignment_0");
					put(grammarAccess.getBlockOrBarAccess().getExprAssignment_1_1(), "rule__BlockOrBar__ExprAssignment_1_1");
					put(grammarAccess.getOpenNameAccess().getImportURIAssignment_1(), "rule__OpenName__ImportURIAssignment_1");
					put(grammarAccess.getFactNameAccess().getNameAssignment_2(), "rule__FactName__NameAssignment_2");
					put(grammarAccess.getAssertionNameAccess().getNameAssignment_2(), "rule__AssertionName__NameAssignment_2");
					put(grammarAccess.getFunctionNameAccess().getNameAssignment(), "rule__FunctionName__NameAssignment");
					put(grammarAccess.getFunctionNamewParamAccess().getNameAssignment(), "rule__FunctionNamewParam__NameAssignment");
					put(grammarAccess.getPredicateNameAccess().getNameAssignment(), "rule__PredicateName__NameAssignment");
					put(grammarAccess.getAliasAccess().getNameAssignment(), "rule__Alias__NameAssignment");
					put(grammarAccess.getEnumNameAccess().getNameAssignment_1(), "rule__EnumName__NameAssignment_1");
					put(grammarAccess.getEnumPropertyNameAccess().getNameAssignment(), "rule__EnumPropertyName__NameAssignment");
					put(grammarAccess.getLetNameAccess().getNameAssignment_1(), "rule__LetName__NameAssignment_1");
					put(grammarAccess.getSignatureNameAccess().getNameAssignment(), "rule__SignatureName__NameAssignment");
					put(grammarAccess.getPropertyNameAccess().getNameAssignment(), "rule__PropertyName__NameAssignment");
					put(grammarAccess.getExactlyNameAccess().getNameAssignment(), "rule__ExactlyName__NameAssignment");
					put(grammarAccess.getAsNameAccess().getNameAssignment(), "rule__AsName__NameAssignment");
					put(grammarAccess.getReferencesSigAccess().getNameRefAssignment_1_0(), "rule__ReferencesSig__NameRefAssignment_1_0");
					put(grammarAccess.getRefAccess().getNameRefAssignment_1_0(), "rule__Ref__NameRefAssignment_1_0");
					put(grammarAccess.getLeftCurlyBracketAccess().getLeftCurlyBracketAssignment(), "rule__LeftCurlyBracket__LeftCurlyBracketAssignment");
					put(grammarAccess.getRightCurlyBracketAccess().getRightCurlyBracketAssignment(), "rule__RightCurlyBracket__RightCurlyBracketAssignment");
					put(grammarAccess.getDotAccess().getDotAssignment(), "rule__Dot__DotAssignment");
					put(grammarAccess.getCommaAccess().getCommaAssignment(), "rule__Comma__CommaAssignment");
					put(grammarAccess.getColonAccess().getColonAssignment(), "rule__Colon__ColonAssignment");
					put(grammarAccess.getLeftParenthesisAccess().getLeftParenthesisAssignment(), "rule__LeftParenthesis__LeftParenthesisAssignment");
					put(grammarAccess.getRightParenthesisAccess().getRightParenthesisAssignment(), "rule__RightParenthesis__RightParenthesisAssignment");
					put(grammarAccess.getLeftSquareBracketKeywordAccess().getLeftSquareBracketKeywordAssignment(), "rule__LeftSquareBracketKeyword__LeftSquareBracketKeywordAssignment");
					put(grammarAccess.getRightSquareBracketKeywordAccess().getRightSquareBracketKeywordAssignment(), "rule__RightSquareBracketKeyword__RightSquareBracketKeywordAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			fr.univartois.cril.xtext.ui.contentassist.antlr.internal.InternalAlsParser typedParser = (fr.univartois.cril.xtext.ui.contentassist.antlr.internal.InternalAlsParser) parser;
			typedParser.entryRuleSpecification();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public AlsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(AlsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
