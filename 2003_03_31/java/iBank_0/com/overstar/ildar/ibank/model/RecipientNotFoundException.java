package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (23.09.2002 17:21:06)
 * @author: Shafigullin Ildar
 */
public class RecipientNotFoundException extends PersistenceException {
/**
 * RecipientNotFoundException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
RecipientNotFoundException(String aDescriptionStr) {
    super(aDescriptionStr);
}
}
