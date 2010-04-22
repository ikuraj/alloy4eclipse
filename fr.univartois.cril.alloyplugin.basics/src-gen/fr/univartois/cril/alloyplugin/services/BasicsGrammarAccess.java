/*
* generated by Xtext
*/

package fr.univartois.cril.alloyplugin.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class BasicsGrammarAccess implements IGrammarAccess {
	
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cImportsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cImportsImportParserRuleCall_0_0 = (RuleCall)cImportsAssignment_0.eContents().get(0);
		private final Assignment cElementsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cElementsTypeParserRuleCall_1_0 = (RuleCall)cElementsAssignment_1.eContents().get(0);
		
		//Model:
		//  imports+=Import* elements+=Type*;
		public ParserRule getRule() { return rule; }

		//imports+=Import* elements+=Type*
		public Group getGroup() { return cGroup; }

		//imports+=Import*
		public Assignment getImportsAssignment_0() { return cImportsAssignment_0; }

		//Import
		public RuleCall getImportsImportParserRuleCall_0_0() { return cImportsImportParserRuleCall_0_0; }

		//elements+=Type*
		public Assignment getElementsAssignment_1() { return cElementsAssignment_1; }

		//Type
		public RuleCall getElementsTypeParserRuleCall_1_0() { return cElementsTypeParserRuleCall_1_0; }
	}

	public class ImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cImportURIAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cImportURISTRINGTerminalRuleCall_1_0 = (RuleCall)cImportURIAssignment_1.eContents().get(0);
		
		//Import:
		//  "import" importURI=STRING;
		public ParserRule getRule() { return rule; }

		//"import" importURI=STRING
		public Group getGroup() { return cGroup; }

		//"import"
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//importURI=STRING
		public Assignment getImportURIAssignment_1() { return cImportURIAssignment_1; }

		//STRING
		public RuleCall getImportURISTRINGTerminalRuleCall_1_0() { return cImportURISTRINGTerminalRuleCall_1_0; }
	}

	public class TypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Type");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSimpleTypeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEntityParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Type:
		//  SimpleType|Entity;
		public ParserRule getRule() { return rule; }

		//SimpleType|Entity
		public Alternatives getAlternatives() { return cAlternatives; }

		//SimpleType
		public RuleCall getSimpleTypeParserRuleCall_0() { return cSimpleTypeParserRuleCall_0; }

		//Entity
		public RuleCall getEntityParserRuleCall_1() { return cEntityParserRuleCall_1; }
	}

	public class SimpleTypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimpleType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTypeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//SimpleType:
		//  "type" name=ID;
		public ParserRule getRule() { return rule; }

		//"type" name=ID
		public Group getGroup() { return cGroup; }

		//"type"
		public Keyword getTypeKeyword_0() { return cTypeKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class EntityElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Entity");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEntityKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cExtendsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cExtendsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cExtendsEntityCrossReference_2_1_0 = (CrossReference)cExtendsAssignment_2_1.eContents().get(0);
		private final RuleCall cExtendsEntityIDTerminalRuleCall_2_1_0_1 = (RuleCall)cExtendsEntityCrossReference_2_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cPropertiesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cPropertiesPropertyParserRuleCall_4_0 = (RuleCall)cPropertiesAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//Entity:
		//  "entity" name=ID ("extends" extends=[Entity])? "{" properties+=Property* "}";
		public ParserRule getRule() { return rule; }

		//"entity" name=ID ("extends" extends=[Entity])? "{" properties+=Property* "}"
		public Group getGroup() { return cGroup; }

		//"entity"
		public Keyword getEntityKeyword_0() { return cEntityKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("extends" extends=[Entity])?
		public Group getGroup_2() { return cGroup_2; }

		//"extends"
		public Keyword getExtendsKeyword_2_0() { return cExtendsKeyword_2_0; }

		//extends=[Entity]
		public Assignment getExtendsAssignment_2_1() { return cExtendsAssignment_2_1; }

		//[Entity]
		public CrossReference getExtendsEntityCrossReference_2_1_0() { return cExtendsEntityCrossReference_2_1_0; }

		//ID
		public RuleCall getExtendsEntityIDTerminalRuleCall_2_1_0_1() { return cExtendsEntityIDTerminalRuleCall_2_1_0_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//properties+=Property*
		public Assignment getPropertiesAssignment_4() { return cPropertiesAssignment_4; }

		//Property
		public RuleCall getPropertiesPropertyParserRuleCall_4_0() { return cPropertiesPropertyParserRuleCall_4_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class PropertyElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Property");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPropertyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cTypeTypeCrossReference_3_0 = (CrossReference)cTypeAssignment_3.eContents().get(0);
		private final RuleCall cTypeTypeIDTerminalRuleCall_3_0_1 = (RuleCall)cTypeTypeCrossReference_3_0.eContents().get(1);
		private final Assignment cManyAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final Keyword cManyLeftSquareBracketRightSquareBracketKeyword_4_0 = (Keyword)cManyAssignment_4.eContents().get(0);
		
		//Property:
		//  "property" name=ID ":" type=[Type] many?="[]"?;
		public ParserRule getRule() { return rule; }

		//"property" name=ID ":" type=[Type] many?="[]"?
		public Group getGroup() { return cGroup; }

		//"property"
		public Keyword getPropertyKeyword_0() { return cPropertyKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//type=[Type]
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }

		//[Type]
		public CrossReference getTypeTypeCrossReference_3_0() { return cTypeTypeCrossReference_3_0; }

		//ID
		public RuleCall getTypeTypeIDTerminalRuleCall_3_0_1() { return cTypeTypeIDTerminalRuleCall_3_0_1; }

		//many?="[]"?
		public Assignment getManyAssignment_4() { return cManyAssignment_4; }

		//"[]"
		public Keyword getManyLeftSquareBracketRightSquareBracketKeyword_4_0() { return cManyLeftSquareBracketRightSquareBracketKeyword_4_0; }
	}
	
	
	private ModelElements pModel;
	private ImportElements pImport;
	private TypeElements pType;
	private SimpleTypeElements pSimpleType;
	private EntityElements pEntity;
	private PropertyElements pProperty;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public BasicsGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammarProvider = grammarProvider;
		this.gaTerminals = gaTerminals;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Model:
	//  imports+=Import* elements+=Type*;
	public ModelElements getModelAccess() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	//Import:
	//  "import" importURI=STRING;
	public ImportElements getImportAccess() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}

	//Type:
	//  SimpleType|Entity;
	public TypeElements getTypeAccess() {
		return (pType != null) ? pType : (pType = new TypeElements());
	}
	
	public ParserRule getTypeRule() {
		return getTypeAccess().getRule();
	}

	//SimpleType:
	//  "type" name=ID;
	public SimpleTypeElements getSimpleTypeAccess() {
		return (pSimpleType != null) ? pSimpleType : (pSimpleType = new SimpleTypeElements());
	}
	
	public ParserRule getSimpleTypeRule() {
		return getSimpleTypeAccess().getRule();
	}

	//Entity:
	//  "entity" name=ID ("extends" extends=[Entity])? "{" properties+=Property* "}";
	public EntityElements getEntityAccess() {
		return (pEntity != null) ? pEntity : (pEntity = new EntityElements());
	}
	
	public ParserRule getEntityRule() {
		return getEntityAccess().getRule();
	}

	//Property:
	//  "property" name=ID ":" type=[Type] many?="[]"?;
	public PropertyElements getPropertyAccess() {
		return (pProperty != null) ? pProperty : (pProperty = new PropertyElements());
	}
	
	public ParserRule getPropertyRule() {
		return getPropertyAccess().getRule();
	}

	//terminal ID:
	//  "^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//  "0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//  "\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" |
	//  "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//  "/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//  "//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//  (" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//  .;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
