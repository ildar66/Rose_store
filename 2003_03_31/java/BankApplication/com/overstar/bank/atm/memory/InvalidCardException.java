package com.overstar.bank.atm.memory;

//package com.ibm.itso.sg245264.atm.memory;

/**
 * An instance of this gets thrown when a Card instance
 * can not be handled by an ATM.
 * 
 */
public class InvalidCardException 
extends Exception {
/**
 * Constructor taking a description as argument.
 *
 * @param aDescriptionStr java.lang.String
 */
InvalidCardException(String aDescriptionStr) {
	super( aDescriptionStr);
}
}
