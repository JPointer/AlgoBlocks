grammar AlgoBlocks;

fragment Letter : [a-zA-Z];
fragment NonZeroDigit : [1-9];
fragment Digit : [0-9];
fragment NaturalNumber : NonZeroDigit (Digit)*;

Name : Letter (Letter|Digit|'_')*;
Int : '0'|'-'? NaturalNumber;
MulOp : '*'|'/'|'%';
AddOp : '+'|'-';
RelOp : '<'|'<='|'>'|'>=';
EqOp : '=='|'!=';
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines


program : (funcDef)* mainFunc EOF;
funcDef : funcAnn 'int' Name '(' (parameterList)? ')' '{' (statementList)? returnStmt '}';
parameterList : 'int' Name (',' 'int' Name)*;
mainFunc : mainAnn 'int' 'main' '(' ')' '{' (statementList)? returnStmt '}';

whileStmt : whileAnn 'while' '(' orExpr ')' '{' (statementList)? '}';
ifStmt : ifAnn 'if' '(' orExpr ')' '{' (trueList= statementList)? '}' ('else' '{' (elseList= statementList)? '}')?;
declarationStmt : declAnn 'int' Name ('=' orExpr)? ';';
returnStmt : retAnn 'return' orExpr ';';
assignmentStmt : assignAnn Name '=' orExpr ';';
statementList : (statement)+;
writeStmt : writeAnn 'write' '(' writeParams ')' ';';
readStmt : readAnn 'read' '(' Name ')' ';';
writeParams : Name (',' Name)*;
statement : assignmentStmt|readStmt|writeStmt|declarationStmt|ifStmt|whileStmt;

mainAnn : '/*' 'MAIN' annBody '*/';
funcAnn : '/*' 'FUNC' annBody '*/';
readAnn : '/*' 'READ' annBody '*/';
writeAnn : '/*' 'WRITE' annBody '*/';
declAnn : '/*' 'DECL' annBody '*/';
assignAnn : '/*' 'ASSIGN' annBody '*/';
retAnn : '/*' 'RET' annBody '*/';
ifAnn : '/*' 'IF' annBody 'TRUE' annBody ('ELSE' annBody)?'*/';
whileAnn : '/*' 'WHILE' annBody 'WHILEOP' annBody '*/';
annBody : xVal ',' yVal ',' wVal ',' hVal ',' pVal ';' ;
xVal : 'x' '=' Int;
yVal : 'y' '=' Int;
wVal : 'w' '=' Int;
hVal : 'h' '=' Int;
pVal : 'p' '=' Int;

orExpr : andExpr ('||' andExpr)*;
andExpr : notExpr ('&&' notExpr)*;
notExpr : '!' eqExpr |eqExpr;
eqExpr : relExpr (EqOp relExpr)?;
relExpr : addExpr (RelOp addExpr)?;
addExpr : mulExpr (AddOp mulExpr)*;
mulExpr : atom (MulOp atom)*;
atom : Int|Name|funcCall|'(' orExpr ')';
argList : orExpr (',' orExpr)*;
funcCall : Name '(' (argList)? ')';