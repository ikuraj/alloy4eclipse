lexer grammar InternalAls;
@header {
package fr.univartois.cril.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : 'int' ;
T13 : 'seq' ;
T14 : 'abstract' ;
T15 : 'lone' ;
T16 : 'one' ;
T17 : 'some' ;
T18 : 'private' ;
T19 : '!' ;
T20 : 'not' ;
T21 : '=>' ;
T22 : 'implies' ;
T23 : 'fun' ;
T24 : 'pred' ;
T25 : 'this' ;
T26 : 'all' ;
T27 : 'sum' ;
T28 : '||' ;
T29 : 'or' ;
T30 : '&&' ;
T31 : 'and' ;
T32 : '&' ;
T33 : '<=>' ;
T34 : 'iff' ;
T35 : '+' ;
T36 : '-' ;
T37 : '++' ;
T38 : '<:' ;
T39 : ':>' ;
T40 : '<<' ;
T41 : '>>' ;
T42 : '>>>' ;
T43 : 'set' ;
T44 : '#' ;
T45 : '~' ;
T46 : '*' ;
T47 : '^' ;
T48 : 'no' ;
T49 : '=' ;
T50 : 'in' ;
T51 : '<' ;
T52 : '>' ;
T53 : '=<' ;
T54 : '<=' ;
T55 : '>=' ;
T56 : 'univ' ;
T57 : 'Int' ;
T58 : 'seq/Int' ;
T59 : 'module' ;
T60 : '/' ;
T61 : 'as' ;
T62 : 'run' ;
T63 : ':' ;
T64 : 'check' ;
T65 : 'for' ;
T66 : 'but' ;
T67 : 'expect' ;
T68 : 'exactly' ;
T69 : 'sig' ;
T70 : '{' ;
T71 : '}' ;
T72 : 'extends' ;
T73 : 'else' ;
T74 : '@' ;
T75 : 'disj' ;
T76 : '(' ;
T77 : ')' ;
T78 : '|' ;
T79 : 'open' ;
T80 : 'fact' ;
T81 : 'assert' ;
T82 : 'enum' ;
T83 : 'let' ;
T84 : ',' ;
T85 : 'none' ;
T86 : 'iden' ;
T87 : '->' ;
T88 : '.' ;
T89 : '[' ;
T90 : ']' ;

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15959
RULE_NEGATIVE_INTEGER : '-' RULE_INT;

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15961
RULE_SL_COMMENT : ('//' ~(('\n'|'\r'))* ('\r'? '\n')?|'--' ( options {greedy=false;} : . )*'\n');

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15963
RULE_ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ('\''|'"')*;

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15965
RULE_INT : ('0'..'9')+;

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15967
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15969
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15971
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../fr.univartois.cril.xtext.als.ui/src-gen/fr/univartois/cril/xtext/ui/contentassist/antlr/internal/InternalAls.g" 15973
RULE_ANY_OTHER : .;


