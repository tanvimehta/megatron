package cs4321.project1;

import cs4321.project1.list.*;
import javafx.util.Pair;

import java.util.Stack;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */

public class EvaluatePrefixListVisitor implements ListVisitor {

    private Stack<Pair<Character,Integer>> operators;
    private Stack<Double> operands;

	public EvaluatePrefixListVisitor() {
		// TODO fill me in
        operators = new Stack<Pair<Character, Integer>>();
        operands = new Stack<Double>();
	}

	public double getResult() {
		// TODO fill me in
		return operands.pop(); // so that skeleton code compiles
	}

	@Override
	public void visit(NumberListNode node) {
		// TODO fill me in
        operands.push(node.getData());

        if (!operators.empty()) {
            Pair<Character, Integer> currentOperator = operators.pop();
            Integer count = currentOperator.getValue() - 1;
            if (count == 0) {
                //Evaluate
                evaluateExpression(currentOperator.getKey());

                if (!operators.empty()) {
                    Pair<Character, Integer> newHead = operators.pop();
                    operators.push(new Pair<Character, Integer>(newHead.getKey(), newHead.getValue() - 1));
                }

            } else
                operators.push(new Pair<Character, Integer>(currentOperator.getKey(), count));

            if (node.getNext() != null)
                node.getNext().accept(this);
            else {
                if (!operators.empty()) {
                    evaluateExpression(operators.pop().getKey());
                }
            }
        }
	}

	@Override
	public void visit(AdditionListNode node) {
		// TODO fill me in
        operators.push(new Pair<Character, Integer>('+', 2));

        if( node.getNext() != null)
            node.getNext().accept(this);
	}

	@Override
	public void visit(SubtractionListNode node) {
		// TODO fill me in
        operators.push(new Pair<Character, Integer>('-', 2));

        if( node.getNext() != null)
            node.getNext().accept(this);
	}

	@Override
	public void visit(MultiplicationListNode node) {
		// TODO fill me in
        operators.push(new Pair<Character, Integer>('*', 2));

        if( node.getNext() != null)
            node.getNext().accept(this);
	}

	@Override
	public void visit(DivisionListNode node) {
		// TODO fill me in
        operators.push(new Pair<Character, Integer>('/', 2));

        if( node.getNext() != null)
            node.getNext().accept(this);
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
        operators.push(new Pair<Character, Integer>('~', 1));

        if( node.getNext() != null)
            node.getNext().accept(this);
	}

    private void evaluateExpression(Character operator) {

        double operand1, operand2;
        switch (operator) {
            case '+': operands.push(operands.pop() + operands.pop());
                break;

            case '-': operand1 = operands.pop();
                operand2 = operands.pop();
                operands.push(operand2 - operand1);
                break;

            case '*': operands.push(operands.pop() * operands.pop());
                break;

            case '/': operand1 = operands.pop();
                operand2 = operands.pop();
                operands.push(operand2 / operand1);
                break;

            case '~': operands.push(-1 * operands.pop());
        }
    }
}
