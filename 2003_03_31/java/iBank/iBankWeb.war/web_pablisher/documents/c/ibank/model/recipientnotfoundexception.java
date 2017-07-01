//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\overstar\\ildar\\ibank\\model\\RecipientNotFoundException.java

package com.overstar.ildar.ibank.model;


/**
 * Insert the type's description here.
 * Creation date: (23.09.2002 17:21:06)
 * 
 * @author  Shafigullin Ildar
 */
public class RecipientNotFoundException extends PersistenceException 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E0041BE012F
    */
   RecipientNotFoundException(String aDescriptionStr) 
   {
    super(aDescriptionStr);    
   }
}
