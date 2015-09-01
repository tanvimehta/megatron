package cs4321.project1;

import cs4321.project1.list.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Your names and netids go here
 */

public class PrintListVisitor implements ListVisitor {

    private String result; // running string representation

	public PrintListVisitor() {
		// TODO fill me in
        //result = "";
	}

	public String getResult() {
		// TODO fill me in
		//return result;
	}

    /**
     * Visit method for leaf node; just concatenates the numeric value to the
     * running string
     *
     * @param node
     *            the node to be visited
     */
	@Override
	public void visit(NumberListNode node) {
		// TODO fill me in
        //result += node.getData();

	}

	@Override
	public void visit(AdditionListNode node) {
		// TODO fill me in

	}

	@Override
	public void visit(SubtractionListNode node) {
		// TODO fill me in
	}

	@Override
	public void visit(MultiplicationListNode node) {
		// TODO fill me in

	}

	@Override
	public void visit(DivisionListNode node) {
		// TODO fill me in

	}

	@Override
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
	}

}
