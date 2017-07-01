package com.overstar.bank.atm.database;

/**
 * Insert the type's description here.
 * Creation date: (12/13/00 10:25:28 AM)
 * @author: 
 */
public class AccountNotFoundException extends PersistenceException {
/**
 * AccountNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
AccountNotFoundException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}