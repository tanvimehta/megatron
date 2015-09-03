package cs4321.project1;

import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.NumberListNode;
import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.UnaryMinusListNode;

import java.util.Stack;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */
public class EvaluatePostfixListVisitor implements ListVisitor {

    private Stack<Double> result;

	public EvaluatePostfixListVisitor() {
		// TODO fill me in
        result = new Stack<Double>();
	}

	public double getResult() {
		// TODO fill me in
		return result.pop(); // so that skeleton code compiles
	}

	@Override
	public void visit(NumberListNode node) {
		// TODO fill me in
        result.push(node.getData());
        if (node.getNext() != null)
            node.getNext().accept(this);
	}

	@Override
	public void visit(AdditionListNode node) {
		// TODO fill me in
        double operand1 = result.pop();
        double operand2 = result.pop();
        result.push(operand1 + operand2);
        if (node.getNext() != null)
            node.getNext().accept(this);
    }

	@Override
	public void visit(SubtractionListNode node) {
		// TODO fill me in
        double operand1 = result.pop();
        double operand2 = result.pop();
        result.push(operand2 - operand1);
        if (node.getNext() != null)
            node.getNext().accept(this);

    }

	@Override
	public void visit(MultiplicationListNode node) {
		// TODO fill me in
        double operand1 = result.pop();
        double operand2 = result.pop();
        result.push(operand1 * operand2);
        if (node.getNext() != null)
            node.getNext().accept(this);
	}

	@Override
	public void visit(DivisionListNode node) {
		// TODO fill me in
        double operand1 = result.pop();
        double operand2 = result.pop();
        result.push(operand2 / operand1);
        if (node.getNext() != null)
            node.getNext().accept(this);
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
        double operand1 = result.pop();
        result.push(-1 * operand1);
        if (node.getNext() != null)
            node.getNext().accept(this);
	}

}
