package cs4321.project1;

import cs4321.project1.tree.*;

/**
 * Class for a parser that can parse a string and produce an expression tree. To
 * keep the code simple, this does no input checking whatsoever so it only works
 * on correct input.
 * 
 * An expression is one or more terms separated by + or - signs. A term is one
 * or more factors separated by * or / signs. A factor is an expression in
 * parentheses (), a factor with a unary - before it, or a number.
 * 
 * @author Lucja Kot
 * @author Your names and netids go here
 */
public class Parser {

	private String[] tokens;
	private int currentToken; // pointer to next input token to be processed
    private TreeNode result = null;
    private TreeNode result2 = null;

	/**
	 * @precondition input represents a valid expression with all tokens
	 *               separated by spaces, e.g. "3.0 - ( 1.0 + 2.0 ) / - 5.0. All
	 *               tokens must be either numbers that parse to Double, or one
	 *               of the symbols +, -, /, *, ( or ), and all parentheses must
	 *               be matched and properly nested.
	 */
	public Parser(String input) {
		this.tokens = input.split("\\s+");
		currentToken = 0;
	}

	/**
	 * Parse the input and build the expression tree
	 * 
	 * @return the (root node of) the resulting tree
	 */
	public TreeNode parse() {
		return expression();
	}

	/**
	 * Parse the remaining input as far as needed to get the next factor
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode factor() {
		// TODO fill me in
        String operand = tokens[currentToken];
        if (isNumber(operand)) {
            return new LeafTreeNode(Double.parseDouble(operand));
        } else if (operand.equalsIgnoreCase("-")) {
            currentToken++;
            result = factor();
            return new UnaryMinusTreeNode(result);
        } else {
            currentToken++;
            result = expression();
            currentToken+=2;
            return result;
        }
	}

	/**
	 * Parse the remaining input as far as needed to get the next term
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode term() {
		// TODO fill me in
        String operator = "";
        result = factor();
        currentToken++;

        while (currentToken < tokens.length && tokens[currentToken] != null) {
            operator = tokens[currentToken];
            currentToken++;
            result2 = factor();

            if (operator.equalsIgnoreCase("*")) {
                result = new MultiplicationTreeNode(result, result2);
            } else if (operator.equalsIgnoreCase("/")) {
                result = new DivisionTreeNode(result, result2);
            }

            currentToken++;
        }
		return result;

	}

	/**
	 * Parse the remaining input as far as needed to get the next expression
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode expression() {

		// TODO fill me in
        String operator = "";
        result = term();
        currentToken++;
        while (currentToken < tokens.length && tokens[currentToken] != null) {
            operator = tokens[currentToken];
            currentToken ++;
            result2 = term();

            if (operator.equalsIgnoreCase("+")) {
                result = new AdditionTreeNode(result, result2);
            } else if(operator.equalsIgnoreCase("-")) {
                result = new SubtractionTreeNode(result, result2);
            }
            currentToken++;
        }
		return result;

	}

    boolean isNumber(String operand) {
        try {
            Double.parseDouble(operand);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
