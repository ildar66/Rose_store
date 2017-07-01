package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (18.09.2002 16:45:24)
 * @author: Shafigullin Ildar
 */
public class InvalidIClientException extends Exception {
/**
 * InvalidCardException constructor comment.
 * @param aDescriptionStr java.lang.String
 */
InvalidIClientException(String aDescriptionStr) {
    super(aDescriptionStr);
}
}
