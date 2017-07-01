package com.overstar.ildar.ibank.model.exceptions;

/**
 * Insert the type's description here.
 * Creation date: (12.09.2002 11:56:16)
 * @author: Shafigullin Ildar
 */
public class IClientNotFoundException extends PersistenceException 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E0041AC0010
    */
   public IClientNotFoundException(String aDescriptionStr) 
   {
	super(aDescriptionStr);    
   }
}
