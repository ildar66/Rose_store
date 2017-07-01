package com.overstar.ildar.ibank.model.exceptions;

/**
 * Insert the type's description here.
 * Creation date: (27.01.2003 12:59:10)
 * @author: Shafigullin Ildar
 */
public class InvalidDocumentStatusException extends Exception{
/**
 * InvalidDocumentStatusException constructor comment.
 * Constructor taking a description as argument.
 * @param aDescriptionStr java.lang.String
 */
public InvalidDocumentStatusException(String aDescriptionStr) {
	super(aDescriptionStr);
}
}
