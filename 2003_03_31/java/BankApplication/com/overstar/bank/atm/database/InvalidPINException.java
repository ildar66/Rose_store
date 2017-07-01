package com.overstar.bank.atm.database;

/**
 * An instance of this gets thrown when a PIN is not correct.
 */
public class InvalidPINException 
extends Exception {
/**
 * Constructor taking a description as argument.
 *
 * @param aDescriptionStr java.lang.String
 */
InvalidPINException(String aDescriptionStr) {
	super( aDescriptionStr);
}
}