package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the negate sign token.
 * 
 * @author Connor Lehman.
 * 
 */
public class NegToken extends CharToken implements OperationInterface {
	public NegToken() {
		super(CharConstants.BANG);
	}

}