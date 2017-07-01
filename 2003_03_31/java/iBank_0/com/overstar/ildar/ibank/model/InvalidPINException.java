package com.overstar.ildar.ibank.model;

/**
 * An instance of this gets thrown when a PIN is not correct.
 *
 * Creation date: (20.09.2002 11:50:17)
 * @author: Shafigullin Ildar
 */
public class InvalidPINException extends Exception {
/**
 * Constructor taking a description as argument.
 *
 * @param aDescriptionStr java.lang.String
 */
InvalidPINException(String aDescriptionStr) {
	super( aDescriptionStr);
}
}
