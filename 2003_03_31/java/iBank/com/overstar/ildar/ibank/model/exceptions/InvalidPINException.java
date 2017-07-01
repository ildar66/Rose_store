package com.overstar.ildar.ibank.model.exceptions;

/**
 * An instance of this gets thrown when a PIN is not correct.
 * Creation date: (20.09.2002 11:50:17)
 * @author: Shafigullin Ildar
 */
public class InvalidPINException extends Exception 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E0041AC0346
    */
   public InvalidPINException(String aDescriptionStr) 
   {
	super( aDescriptionStr);    
   }
}
