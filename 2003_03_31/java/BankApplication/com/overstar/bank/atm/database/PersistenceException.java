package com.overstar.bank.atm.database;

/**
 * An instance of this gets thrown whenever there is an issue with persisting an object.
 */
public class PersistenceException 
extends Exception {
/**
 * Constructor taking a description as argument.
 *
 * @param aDescriptionStr java.lang.String
 */
PersistenceException(String aDescriptionStr) {
	super( aDescriptionStr);
}
}