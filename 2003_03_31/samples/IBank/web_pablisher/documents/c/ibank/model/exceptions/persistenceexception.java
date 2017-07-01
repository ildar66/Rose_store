package com.overstar.ildar.ibank.model.exceptions;

/**
 * An instance of this gets thrown whenever there is an issue with persisting an 
 * object.
 * Creation date: (12.09.2002 11:24:50)
 * @author: Shafigullin Ildar
 */
public class PersistenceException extends Exception 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E0041B60340
    */
   public PersistenceException(String aDescriptionStr) 
   {
    super(aDescriptionStr);    
   }
}
