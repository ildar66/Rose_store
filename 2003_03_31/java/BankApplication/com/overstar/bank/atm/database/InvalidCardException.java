package com.overstar.bank.atm.database;

/**
 * An instance of this gets thrown when a Card instance
 * can not be handled by an ATM.
 * 
 * Creation date: (11/27/00 10:30:34 PM)
 * @author: Frederik Haesbrouck
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