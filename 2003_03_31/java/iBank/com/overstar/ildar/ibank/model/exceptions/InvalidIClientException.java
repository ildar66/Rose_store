package com.overstar.ildar.ibank.model.exceptions;

/**
 * Insert the type's description here.
 * Creation date: (18.09.2002 16:45:24)
 * @author: Shafigullin Ildar
 */
public class InvalidIClientException extends Exception 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E0041AC0273
    */
   public InvalidIClientException(String aDescriptionStr) 
   {
    super(aDescriptionStr);    
   }
}
