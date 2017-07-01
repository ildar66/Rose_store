//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\overstar\\ildar\\ibank\\model\\BankAccountNotFoundException.java

package com.overstar.ildar.ibank.model;


/**
 * Insert the type's description here.
 * Creation date: (31.10.2002 13:00:26)
 * @author: Shafigullin Ildar
 */
public class BankAccountNotFoundException extends PersistenceException 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E0041930354
    */
   public BankAccountNotFoundException(String aDescriptionStr) 
   {
	super(aDescriptionStr);    
   }
}
