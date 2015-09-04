package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */
public class BuildPrefixExpressionTreeVisitor implements TreeVisitor {

    private ListNode tempResult;
    private ListNode result;

    public BuildPrefixExpressionTreeVisitor() {
		tempResult = null;
        result = null;
	}

	public ListNode getResult() {
		// TODO fill me in
		return result;
	}

	@Override
	public void visit(LeafTreeNode node) {
		// TODO fill me in
        if (tempResult != null) {
            tempResult.setNext(new NumberListNode(node.getData()));
        } else {
            tempResult = new NumberListNode(node.getData());
            result = tempResult;
        }
        tempResult = tempResult.getNext();
	}

	@Override
	public void visit(UnaryMinusTreeNode node) {
		// TODO fill me in
        if (tempResult !=null) {
            tempResult.setNext(new UnaryMinusListNode());
            tempResult = tempResult.getNext();
        } else {
            tempResult = new UnaryMinusListNode();
            result = tempResult;
        }

        node.getChild().accept(this);
	}

	@Override
	public void visit(AdditionTreeNode node) {
		// TODO fill me in
        if (tempResult != null) {
            tempResult.setNext(new AdditionListNode());
            tempResult = tempResult.getNext();
        } else {
            tempResult = new AdditionListNode();
            result = tempResult;
        }

        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
	}

	@Override
	public void visit(MultiplicationTreeNode node) {
		// TODO fill me in
        if (tempResult != null) {
            tempResult.setNext(new MultiplicationListNode());
            tempResult = tempResult.getNext();
        } else {
            tempResult = new MultiplicationListNode();
            result = tempResult;
        }

        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
	}

	@Override
	public void visit(SubtractionTreeNode node) {
		// TODO fill me in
        if (tempResult != null) {
            tempResult.setNext(new SubtractionListNode());
            tempResult = tempResult.getNext();
        } else {
            tempResult = new SubtractionListNode();
            result = tempResult;
        }

        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
	}

	@Override
	public void visit(DivisionTreeNode node) {
		// TODO fill me in
        if (tempResult != null) {
            tempResult.setNext(new DivisionListNode());
            tempResult = tempResult.getNext();
        } else {
            tempResult = new DivisionListNode();
            result = tempResult;
        }

        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
	}

}
