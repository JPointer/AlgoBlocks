package com.algoBlocks.ast;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

public class Ast {

    private Node root;

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
}
