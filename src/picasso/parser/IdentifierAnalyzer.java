package picasso.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.language.expressions.Variable;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

/**
 * Handle an identifier token 
 * 
 * @author Sara Sprenkle
 *
 */
public class IdentifierAnalyzer implements SemanticAnalyzerInterface {

	static Map<String, ExpressionTreeNode> idToExpression = new HashMap<String, ExpressionTreeNode>();

	static {
		// We always have x and y defined.
		idToExpression.put("x", new X());
		idToExpression.put("y", new Y());
	}
	/**
	 * Generate an expression tree for an identifier.
	 * @param tokens
	 * @return
	 * @see picasso.parser.SemanticAnalyzerInterface#generateExpressionTree(java.util.Stack)
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		IdentifierToken t = (IdentifierToken) tokens.pop();
		String id = t.getName();
		ExpressionTreeNode mapped = idToExpression.get(id);
		if (mapped != null) {
			return mapped;
		}
		// TODO : What should we do if we don't recognize the identifier?
		// Is that an error? Or, could there a valid reason? 
		// If we cannot recognize the identifier, then it could have been assigned to a value, or it could have been undefined. If undefined, return null. 
		// Otherwise, return the expression tree of the value the identifier is assigned to. But then, how do we know an identifier is assigned a value?
		else {
			boolean varIsPresent = AssignmentAnalyzer.checkForKey(id);
			if (varIsPresent) {
				return new Variable(id);
			} else {
				throw new ParseException("Variable " + id + " is not assigned to an expression.");
			}
				
		}
		
	}

}
