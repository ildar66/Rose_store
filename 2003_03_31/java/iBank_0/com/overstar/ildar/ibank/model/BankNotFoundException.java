package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (16.09.2002 16:36:39)
 * @author: Shafigullin Ildar
 */
public class BankNotFoundException extends PersistenceException {
/**
 * BankNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
public BankNotFoundException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}
