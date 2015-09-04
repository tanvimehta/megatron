package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */
public class BuildPostfixExpressionTreeVisitor implements TreeVisitor {

    private ListNode tempResult;
    private ListNode result;

	public BuildPostfixExpressionTreeVisitor() {
		// TODO fill me in
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
	}

	@Override
	public void visit(UnaryMinusTreeNode node) {
		// TODO fill me in
        node.getChild().accept(this);
        if (tempResult != null) {
            tempResult.setNext(new UnaryMinusListNode());
        } else {
            tempResult = new UnaryMinusListNode();
        }
	}

	@Override
	public void visit(AdditionTreeNode node) {
		// TODO fill me in
        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
        tempResult = tempResult.getNext();
        tempResult.setNext(new AdditionListNode());
        tempResult = tempResult.getNext();
    }

	@Override
	public void visit(MultiplicationTreeNode node) {
		// TODO fill me in
        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
        tempResult = tempResult.getNext();
        tempResult.setNext(new MultiplicationListNode());
        tempResult = tempResult.getNext();
	}

	@Override
	public void visit(SubtractionTreeNode node) {
		// TODO fill me in
        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
        tempResult = tempResult.getNext();
        tempResult.setNext(new SubtractionListNode());
        tempResult = tempResult.getNext();
    }

	@Override
	public void visit(DivisionTreeNode node) {
		// TODO fill me in
        node.getLeftChild().accept(this);
        node.getRightChild().accept(this);
        tempResult = tempResult.getNext();
        tempResult.setNext(new DivisionListNode());
        tempResult = tempResult.getNext();
    }

}
