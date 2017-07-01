package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (31.10.2002 13:00:26)
 * @author: Shafigullin Ildar
 */
public class BankAccountNotFoundException extends PersistenceException {
/**
 * BankAccountNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
public BankAccountNotFoundException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}
