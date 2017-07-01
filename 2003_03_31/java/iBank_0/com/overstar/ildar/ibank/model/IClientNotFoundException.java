package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (12.09.2002 11:56:16)
 * @author: Shafigullin Ildar
 */
public class IClientNotFoundException extends PersistenceException {
/**
 * IClientNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
public IClientNotFoundException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}
