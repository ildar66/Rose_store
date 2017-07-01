package com.overstar.bank.atm.database;

/**
 * Insert the type's description here.
 * Creation date: (12/13/00 10:02:12 AM)
 * @author: 
 */
public class CardNotFoundException extends PersistenceException {
/**
 * CardNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
CardNotFoundException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}