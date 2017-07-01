package com.overstar.ildar.ibank.model.exceptions;

/**
 * Insert the type's description here.
 * Creation date: (13.02.2003 14:40:05)
 * @author: Shafigullin Ildar
 */
public class AccreditiveNotFoundException extends PersistenceException {
/**
 * AccreditiveNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
public AccreditiveNotFoundException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}
