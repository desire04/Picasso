package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Quote;
import picasso.parser.tokens.QuoteToken;
import picasso.parser.tokens.Token;

/**
 * A semantic analyzer for processing quote tokens and generating expression
 * trees. This class implements the SemanticAnalyzerInterface and is responsible
 * for handling quote tokens.
 * 
 * @author Ford Scott
 */
public class QuoteAnalyzer implements SemanticAnalyzerInterface {
	/**
	 * Generate an expression tree from a stack of tokens containing a QuoteToken.
	 * 
	 * @param tokens A stack of tokens to process.
	 * @return An ExpressionTreeNode representing the parsed quote.
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		QuoteToken token = (QuoteToken) tokens.pop();

		String value = token.value();

		return new Quote(value);
	}
}
