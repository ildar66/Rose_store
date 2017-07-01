package com.overstar.ildar.ibank.model.exceptions;

/**
 * Insert the type's description here.
 * Creation date: (16.09.2002 16:36:39)
 * @author  Shafigullin Ildar
 */
public class BankNotFoundException extends PersistenceException 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E004195022A
    */
   public BankNotFoundException(String aDescriptionStr) 
   {
	super(aDescriptionStr);    
   }
}
