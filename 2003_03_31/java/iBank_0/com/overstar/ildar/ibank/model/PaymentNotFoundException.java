package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (17.10.2002 12:05:02)
 * @author: Shafigullin Ildar
 */
public class PaymentNotFoundException extends PersistenceException {
/**
 * PaymentNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
public PaymentNotFoundException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}
