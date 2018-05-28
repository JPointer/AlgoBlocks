package com.algoBlocks.ast;

import com.algoBlocks.ast.atom.FuncCallAtom;
import com.algoBlocks.ast.atom.IntAtom;
import com.algoBlocks.ast.atom.NameAtom;
import com.algoBlocks.ast.aux.*;
import com.algoBlocks.ast.expr.*;
import com.algoBlocks.ast.stmt.*;

import java.util.*;

public class Ast {

    private Node root;
    private HashMap<String, Integer> funSignatures = new HashMap<>(); /*name of function and number of params*/
    private Scanner in = new Scanner(System.in);
    private Stack<Integer> returnVals = new Stack<>();

    public Ast(Node root) {
        this.root = root;
    }

    public String toString() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        String result = new String();
        int i = 0;
        while(!stack.empty()) {
            Node node = stack.pop();
            //System.out.println(i++);
            result += node.toString() + "\n";

            ArrayList<? extends Node> children = node.getChildren();
            ListIterator<? extends Node> listIter = children.listIterator(children.size());
            while(listIter.hasPrevious())
                stack.push(listIter.previous());
        }
        return result;
    }//toString

    private void nextStep() {
        int n = in.nextInt();
        if(n != 1)
            System.exit(1);
    }

    public void preExecuting() throws Exception {
        Node main = ((Program) root).getMainNode();
        ArrayList<? extends Node> funDef = ((Program) root).getFunDefs();

        if(funDef != null) {
            for(Node fd: funDef)
            {
                if(funSignatures.containsKey(((FunDef) fd).getName()))
                    throw new Exception("Multiple function name:" + ((FunDef) fd).getName());
                funSignatures.put(((FunDef) fd).getName(), ((FunDef) fd).getParams().size());
            }
            for (Node fd : funDef)
                validDef(fd);
        }
        validDef(main);
    }

    private void validDef(Node def) throws Exception {
        ArrayList<String> vars = new ArrayList<String>();
        ArrayList<Node> stmts = null;
        Node retNode = null;
        Stack<ArrayList<String>> stack = new Stack<>();
        if(def instanceof FunDef) {
                vars.addAll(((FunDef) def).getParams());
                stmts = ((FunDef) def).getOperations();
                retNode = ((FunDef) def).getRetStmt();
                stack.push(vars);
        }
        else {
            stmts = ((MainNode) def).getOperations();
            retNode = ((MainNode) def).getRetStmt();
            stack.push(vars);
        }
        if(stmts != null)
            for(Node n: stmts) {
                if(n instanceof DeclarationStmt) {
                    ArrayList<String> temp = stack.pop();
                    temp.add(((DeclarationStmt) n).getVarName());
                    stack.push(temp);
                    validExpr(((DeclarationStmt) n).getExpr(), stack);
                }
                else {
                    validStmt(n, stack);
                }
            }

        validRetStmt(retNode, vars);
    }// validDef

    private void validStmt(Node stmt, Stack<ArrayList<String>> stack) throws Exception {

        if(stmt instanceof AssignmentStmt) {

            validExpr(((AssignmentStmt) stmt).getExpr(), stack);

        } else if(stmt instanceof DeclarationStmt) {

            validExpr(((DeclarationStmt) stmt).getExpr(), stack);
            ArrayList<String> local = stack.pop();
            local.add(((DeclarationStmt) stmt).getVarName());
            stack.push(local);

        } else if(stmt instanceof IfStmt) {

            //valid condition
            validExpr(((IfStmt) stmt).getCondition(), stack);

            //true nodes
            stack.push(new ArrayList<String>());
            if(((IfStmt) stmt).getTrueNodes() != null)
                for(Node n: ((IfStmt) stmt).getTrueNodes())
                    validStmt(n, stack);
            stack.pop();

            // false nodes
            stack.push(new ArrayList<String>());
            if(((IfStmt) stmt).getFalseNodes() != null)
                for(Node n: ((IfStmt) stmt).getFalseNodes())
                    validStmt(n, stack);
            stack.pop();

        } else if(stmt instanceof WhileStmt) {

            validExpr(((WhileStmt) stmt).getCondition(), stack);

            stack.push(new ArrayList<String>());
            if(((WhileStmt) stmt).getWhileNodes() != null)
                for(Node n: ((WhileStmt) stmt).getWhileNodes())
                    validStmt(n, stack);
            stack.pop();

        } else if(stmt instanceof ReadStmt) {
            Stack<ArrayList<String>> temp = new Stack<ArrayList<String>>();
            String param = ((ReadStmt) stmt).getVarName();
            ArrayList<String> vars = null;
            boolean found = false;
            while(found == false) {
                if(stack.empty())
                    throw new Exception("ERROR read: invalid " + param + " variable");
                vars = stack.peek();
                if(vars != null)
                    for(String s : vars)
                        if(s.equals(param)) {
                            found = true;
                            break;
                        }
                if(found == false) {
                    vars = stack.pop();
                    temp.push(vars);
                }
            }

            while(!temp.empty()) {
                vars = temp.pop();
                stack.push(vars);
            }

        } else if(stmt instanceof  WriteStmt) {
            Stack<ArrayList<String>> temp = new Stack<ArrayList<String>>();
            ArrayList<String> params = ((WriteStmt) stmt).getVarNames();
            ArrayList<String> paramsTemp = new ArrayList<>(params);

            ArrayList<String> vars = null;
            boolean found = false;
            while(found == false) {
                if(stack.empty()) {
                    for(String p : paramsTemp)
                    throw new Exception("ERROR write: invalid " + p + " variable");
                }
                vars = stack.peek();
                if(vars != null)
                    for(String s : params)
                        if(vars.contains(s)) {
                            paramsTemp.remove(s);
                            if(paramsTemp.isEmpty())
                                found = true;
                        }
                if(found == false) {
                    vars = stack.pop();
                    temp.push(vars);
                }
            }

            while(!temp.empty()) {
                vars = temp.pop();
                stack.push(vars);
            }
        }
    }// validStmt

    private void validRetStmt(Node node, ArrayList<String> vars) throws Exception {
        Stack<ArrayList<String>> stack = new Stack<ArrayList<String>>();
        stack.add(vars);
        validExpr(((ReturnStmt) node).getRet(), stack);
    }// validRetStmt

    private void validExpr(Node node, Stack<ArrayList<String>> stack) throws Exception {
        //TODO node == null
        if(node instanceof OrExpr) {

            for(Node n: ((OrExpr) node).getOperands())
                validExpr(n, stack);

        } else if(node instanceof AndExpr) {

            for(Node n: ((AndExpr) node).getOperands())
                validExpr(n, stack);

        } else if(node instanceof NotExpr) {

            validExpr(((NotExpr) node).getOperand(), stack);

        } else if(node instanceof EqExpr) {

            validExpr(((EqExpr) node).getLeft(), stack);
            validExpr(((EqExpr) node).getRight(), stack);

        } else if(node instanceof RelExpr) {

            validExpr(((RelExpr) node).getLeft(), stack);
            validExpr(((RelExpr) node).getRight(), stack);

        } else if(node instanceof AddExpr) {

            for(AddOperand op: ((AddExpr) node).getOperands())
                validExpr(op.getOperand(), stack);

        } else if(node instanceof MulExpr) {

            for(MulOperand mop: ((MulExpr) node).getOperands()) {
                Node op = mop.getOperand();
                validExpr(op, stack);
            }
        } else if(node instanceof FuncCallAtom) {
                String name = ((FuncCallAtom) node).getFuncName();
                ArrayList<Node> params = ((FuncCallAtom) node).getParams();

                if(!funSignatures.containsKey(name)) {
                    throw new Exception("There is no function called: " + name);
                }
                if(funSignatures.get(name) != params.size())
                    throw new Exception("Function " + name + " wrong number of arguments");
                for(Node n: params)
                    validExpr(n, stack);
        } else if(node instanceof NameAtom) {
            String name = ((NameAtom) node).getName();
                    if(!nameOnStack(name, stack)) {
                        throw new Exception("ERROR variable " + name + " not found");
                    }
        }

    }// valid expr

    private boolean nameOnStack(String name, Stack<ArrayList<String>> stack) {
        Stack<ArrayList<String>> temp = new Stack<ArrayList<String>>();
        ArrayList<String> vars = null;

        boolean found = false;
        while (found == false) {
            if (stack.empty())
                break;
            vars = stack.peek();
            if (vars != null)
                for (String s : vars)
                    if (s.equals(name)) {
                        found = true;
                        break;
                    }
            if (found == false) {
                vars = stack.pop();
                temp.push(vars);
            }
        }

        while (!temp.empty()) {
            vars = temp.pop();
            stack.push(vars);
        }
        return found;
    }

    public void execute() {
        Stack<ArrayList<Variable>> stack = new Stack<>();
        enterBlock(((Program) root).getMainNode(), stack);
    }
    private void enterBlock(Node block, Stack<ArrayList<Variable>> stack) {

        if(block instanceof MainNode) {
            ArrayList<Variable> vars = new ArrayList<Variable>();
            stack.push(vars);

            BlockMeta meta = ((MainNode) block).getBlockMeta();
            System.out.println(enterMsg(meta));
            nextStep();

            for(Node n: ((MainNode) block).getOperations())
                enterBlock(n, stack);

            enterBlock(((MainNode) block).getRetStmt(), stack);
            System.out.println(exitMsg(meta));

            stack.pop();

        } else if(block instanceof AssignmentStmt) {

            BlockMeta meta = ((AssignmentStmt) block).getBlockMeta();

            System.out.println(enterMsg(meta));
            nextStep();
            int a = calculateExpr(((AssignmentStmt) block).getExpr(), stack);
            updateVariable(stack, ((AssignmentStmt) block).getVarName(), a);
            System.out.println(new String (((AssignmentStmt) block).getVarName() + " = " + a));
            nextStep();
            System.out.println(exitMsg(meta));
            nextStep();

        } else if(block instanceof DeclarationStmt) {

            BlockMeta meta = ((DeclarationStmt) block).getBlockMeta();

            System.out.println(enterMsg(meta));
            nextStep();

            String name = ((DeclarationStmt) block).getVarName();
            Variable newVal = new Variable(name);
            //calculate expression
            if(((DeclarationStmt) block).getExpr() == null) {
                System.out.println(new String(name));

            } else{
                int a = calculateExpr(((DeclarationStmt) block).getExpr(), stack);
                System.out.println(new String(name + " = " + a));
                newVal.setValue(a);
            }
            nextStep();
            //variable add to stack
            ArrayList<Variable> vars = stack.pop();
            vars.add(newVal);
            stack.push(vars);
            System.out.println(exitMsg(meta));
            nextStep();

        } else if(block instanceof IfStmt) {

            BlockMeta condition = ((IfStmt) block).getBlockMetaCondition();
            BlockMeta falseMeta = ((IfStmt) block).getBlockMetaFalse();
            BlockMeta trueMeta = ((IfStmt) block).getBlockMetaTrue();

            System.out.println(enterMsg(condition));
            nextStep();
            if(calculateExpr(((IfStmt) block).getCondition(),stack) == 1) {
                System.out.println(enterMsg(trueMeta));
                nextStep();
                for(Node n: ((IfStmt) block).getTrueNodes())
                    enterBlock(n, stack);
                System.out.println(exitMsg(trueMeta));
                nextStep();
            } else {
                System.out.println(enterMsg(falseMeta));
                nextStep();
                for(Node n: ((IfStmt) block).getFalseNodes())
                    enterBlock(n, stack);
                System.out.println(exitMsg(falseMeta));
                nextStep();
            }
            System.out.println(exitMsg(condition));
            nextStep();

        } else if(block instanceof ReadStmt) {

            BlockMeta meta = ((ReadStmt) block).getBlockMeta();
            System.out.println(enterMsg(meta));
            nextStep();
            String name = ((ReadStmt) block).getVarName();
            System.out.println("Give " + name + " value: " );
            int k = in.nextInt();
            updateVariable(stack, name, k);
            System.out.println(exitMsg(meta));
            nextStep();

        } else if(block instanceof ReturnStmt) {

            BlockMeta meta = ((ReturnStmt) block).getBlockMeta();

            System.out.println(enterMsg(meta));
            nextStep();
            int a = calculateExpr(((ReturnStmt) block).getRet(), stack);
            System.out.println("return value = " + a);
            returnVals.push(a);
            nextStep();
            System.out.println(exitMsg(meta));
            nextStep();

        } else if(block instanceof WhileStmt) {

            BlockMeta whileMeta = ((WhileStmt) block).getBlockMetaWhile();
            BlockMeta whileOpMeta = ((WhileStmt) block).getBlockMetaWhileOp();

            Node condition = ((WhileStmt) block).getCondition();
            ArrayList<Node> whileNodes = ((WhileStmt) block).getWhileNodes();


            System.out.println(enterMsg(whileMeta));
            nextStep();
            while(calculateExpr(condition,stack) == 1) {
                System.out.println(enterMsg(whileOpMeta));
                nextStep();
                if(whileNodes != null)
                    for(Node n: whileNodes)
                        enterBlock(n, stack);
                System.out.println(exitMsg(whileOpMeta));
                nextStep();
            }
            System.out.println(exitMsg(whileMeta));
            nextStep();

        } else if(block instanceof WriteStmt) {

            BlockMeta meta = ((WriteStmt) block).getBlockMeta();

            System.out.println(enterMsg(meta));
            nextStep();
            ArrayList<Variable> variables = getVariablesByName(((WriteStmt) block).getVarNames(), stack);

            for(Variable v: variables)
                System.out.println("Variable " + v.getName() + " = " + v.getValue());

            nextStep();
            System.out.println(exitMsg(meta));
            nextStep();

        } else if(block instanceof FunDef) {
            BlockMeta meta = ((FunDef) block).getBlockMeta();

            System.out.println(enterMsg(meta));
            nextStep();
            ArrayList<Node> operations = ((FunDef) block).getOperations();
            if(operations != null)
                for(Node n: operations) {
                    enterBlock(n, stack);
                }
            enterBlock(((FunDef) block).getRetStmt(), stack);
            System.out.println(exitMsg(meta));
            nextStep();
        }
    }// enter block

    private String enterMsg(BlockMeta meta) {
        return new String("ENTER " + meta.getName() + " BLOCK" + " x=" + meta.getX() + " y=" + meta.getY() + " w=" + meta.getW() +
                         " h=" + meta.getY() + " p=" + meta.getP());
    }

    private String exitMsg(BlockMeta meta) {
        return new String("EXIT " + meta.getName() + " BLOCK");
    }

    private int calculateExpr(Node node, Stack<ArrayList<Variable>> stack) {
        //TODO node == null
        if(node instanceof OrExpr) {
            for(Node n: ((OrExpr) node).getOperands()) {
                if (calculateExpr(n, stack) != 0)
                    return 1;
            }
            return 0;
        } else if(node instanceof AndExpr) {
            for(Node n: ((AndExpr) node).getOperands()) {
                if(calculateExpr(n, stack) == 0)
                    return 0;
            }
            return 1;

        } else if(node instanceof NotExpr) {
            if(calculateExpr(((NotExpr) node).getOperand(), stack) == 0)
                return 1;
            else return 0;

        } else if(node instanceof EqExpr) {
            Node left =((EqExpr) node).getLeft();
            Node right = ((EqExpr) node).getRight();
            EqOp eqOp = ((EqExpr) node).getEqOp();

            if(eqOp.equals(EqOp.EQ)) {
                if(calculateExpr(left, stack) == calculateExpr(right, stack))
                    return 1;
                return 0;
            }
            if(calculateExpr(left, stack) != calculateExpr(right, stack))
                return 1;
            return 0;

        } else if(node instanceof RelExpr) {
            Node left = ((RelExpr) node).getLeft();
            Node right = ((RelExpr) node).getRight();
            RelOp relOp = ((RelExpr) node).getRelOp();

            if(relOp.equals(RelOp.GE)) {
                if(calculateExpr(left, stack) >= calculateExpr(right, stack))
                    return 1;
                else return 0;
            }
            else if(relOp.equals(RelOp.GT)) {
                if(calculateExpr(left, stack) > calculateExpr(right, stack))
                    return 1;
                else return 0;
            }
            else if(relOp.equals(RelOp.LE)) {
                if(calculateExpr(left, stack) <= calculateExpr(right, stack))
                    return 1;
                else return 0;
            }
            else if(relOp.equals(RelOp.LT)) {
                if(calculateExpr(left, stack) < calculateExpr(right, stack))
                    return 1;
                else return 0;
            }

        } else if(node instanceof AddExpr) {
            ArrayList<AddOperand> addOperands = ((AddExpr) node).getOperands();
            int result = calculateExpr(addOperands.get(0).getOperand(), stack);

            int n = addOperands.size();
            for(int i = 1; i < n; i++) {
                if(addOperands.get(i).getAddOp().equals(AddOp.PLUS))
                    result += calculateExpr(addOperands.get(i).getOperand(), stack);
                else result -= calculateExpr(addOperands.get(i).getOperand(), stack);
            }
            return result;

        } else if(node instanceof MulExpr) {
            ArrayList<MulOperand> mulOperands = ((MulExpr) node).getOperands();
            int result = calculateExpr(mulOperands.get(0).getOperand(), stack);

            int n = mulOperands.size();
            for(int i = 1; i < n; i++) {
                if(mulOperands.get(i).getMulOp().equals(MulOp.MUL))
                    result *= calculateExpr(mulOperands.get(i).getOperand(), stack);
                else if(mulOperands.get(i).getMulOp().equals(MulOp.DIV))
                    result /= calculateExpr(mulOperands.get(i).getOperand(), stack);
                else if(mulOperands.get(i).getMulOp().equals(MulOp.MOD))
                    result %= calculateExpr(mulOperands.get(i).getOperand(), stack);
            }
            return result;

        } else if(node instanceof FuncCallAtom) {
            ArrayList<Node> nodes = ((FuncCallAtom) node).getParams();
            String funName = ((FuncCallAtom) node).getFuncName();

            ArrayList<Integer> values = new ArrayList<Integer>();

            if(nodes != null)
                for(Node n: nodes) {
                    values.add(calculateExpr(n, stack));
                }

            return executeFinction(funName, values, stack); //TODO call function

        } else if(node instanceof NameAtom) {

            Stack<ArrayList<Variable>> temp = new Stack<>();
            ArrayList<Variable> vars = null;

            String name = ((NameAtom) node).getName();
            boolean found = false;
            int result = 0;

            while(!found) {

                if(stack.empty())
                    break;

                vars = stack.peek();
                if(vars != null)
                    for (Variable v : vars) {
                        if (v.getName().equals(name)) {
                            result = v.getValue();
                            found = true;
                            break;
                        }
                    }
                if(!found) {
                    vars = stack.pop();
                    temp.push(vars);
                }

            }
            while (!temp.empty()) {
                vars = temp.pop();
                stack.push(vars);
            }
            return result;

        } else if(node instanceof IntAtom) {
            return ((IntAtom) node).getValue();
        }
        return 0;
    }

    private void updateVariable(Stack<ArrayList<Variable>> stack, String varName, int newVal) {
        Stack<ArrayList<Variable>> temp = new Stack<>();
        ArrayList<Variable> vars = null;

        boolean found = false;
        int result = 0;

        while(!found) {

            if(stack.empty())
                break;

            vars = stack.pop();
            if(vars != null) {
                int n = vars.size();
                for (int i = 0; i < n; i++ ) {
                    if (vars.get(i).getName().equals(varName)) {
                        vars.get(i).setValue(newVal);
                        stack.push(vars);
                        found = true;
                        break;
                    }
                }
            }
            if(!found) {
                temp.push(vars);
            }

        }
        while (!temp.empty()) {
            vars = temp.pop();
            stack.push(vars);
        }
    } // update variable

    private ArrayList<Variable> getVariablesByName(ArrayList<String> names, Stack<ArrayList<Variable>> stack) {
        ArrayList<Variable> variables = new ArrayList<Variable>();
        ArrayList<Variable> temp = null;
        Stack<ArrayList<Variable>> tempStack = new Stack<>();

        for(String name : names) {
            boolean found = false;
            while(!found) {

                if(stack.empty())
                    break;

                temp = stack.pop();
                if(temp != null) {
                    int n = temp.size();
                    for (int i = 0; i < n; i++ ) {
                        if (temp.get(i).getName().equals(name)) {
                            variables.add(new Variable(name, temp.get(i).getValue()));
                            stack.push(temp);
                            found = true;
                            break;
                        }
                    }
                }
                if(!found) {
                    tempStack.push(temp);
                }

            }
            while (!tempStack.empty()) {
                temp = tempStack.pop();
                stack.push(temp);
            }
        }
        return variables;
    }

    private Integer executeFinction(String funName, ArrayList<Integer> values, Stack<ArrayList<Variable>> stack) {
        ArrayList<? extends Node> funDef = ((Program) root).getFunDefs();
        ArrayList<Variable> variables = new ArrayList<>();
        if(funDef != null) {
            for(Node n: funDef)
                if(((FunDef) n).getName().equals(funName)) {
                    int i =0;
                    for(String str: ((FunDef) n).getParams()) {
                        variables.add(new Variable(str, values.get(i++)));
                    }
                    stack.push(variables);
                    enterBlock(n, stack);
                    stack.pop();
                    break;
                }
        }
        return returnVals.pop();
    }
}// AST
