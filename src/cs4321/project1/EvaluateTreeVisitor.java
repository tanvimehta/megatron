package cs4321.project1;

import cs4321.project1.tree.DivisionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.SubtractionTreeNode;
import cs4321.project1.tree.AdditionTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.UnaryMinusTreeNode;

import java.util.Stack;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */

public class EvaluateTreeVisitor implements TreeVisitor {

    private Stack<Double> operands = new Stack<Double>();
    private double result;
    private double operand1;
    private double operand2;

	public EvaluateTreeVisitor() {
		// TODO fill me in
        result = 0;
	}

	public double getResult() {
		// TODO fill me in
        result = operands.pop();
		return result; // so that skeleton code compiles
	}

	@Override
	public void visit(LeafTreeNode node) {
		// TODO fill me in
        operands.push(node.getData());
	}

	@Override
	public void visit(UnaryMinusTreeNode node) {
		// TODO fill me in
        operand1 = operands.pop();
        operands.push(-1 * operand1);
	}

	@Override
	public void visit(AdditionTreeNode node) {
		// TODO fill me in
        operand1 = operands.pop();
        operand2 = operands.pop();
        operands.push(operand1 + operand2);
	}

	@Override
	public void visit(MultiplicationTreeNode node) {
		// TODO fill me in
        operand1 = operands.pop();
        operand2 = operands.pop();
        operands.push(operand1 * operand2);
	}

	@Override
	public void visit(SubtractionTreeNode node) {
		// TODO fill me in
        operand1 = operands.pop();
        operand2 = operands.pop();
        operands.push(operand2 - operand1);
	}

	@Override
	public void visit(DivisionTreeNode node) {
		// TODO fill me in
        operand1 = operands.pop();
        operand2 = operands.pop();
        operands.push(operand2 / operand1);
	}
}
