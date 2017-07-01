package com.overstar.bank.atm.memory;

//package com.ibm.itso.sg245264.atm.memory;

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
