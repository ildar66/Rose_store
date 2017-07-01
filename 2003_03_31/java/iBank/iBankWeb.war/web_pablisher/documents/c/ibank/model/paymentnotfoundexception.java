//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\overstar\\ildar\\ibank\\model\\PaymentNotFoundException.java

package com.overstar.ildar.ibank.model;


/**
 * Insert the type's description here.
 * Creation date: (17.10.2002 12:05:02)
 * @author: Shafigullin Ildar
 */
public class PaymentNotFoundException extends PersistenceException 
{
   
   /**
    * Constructor taking a description as argument.
    * @param aDescriptionStr java.lang.String
    * @roseuid 3E0041B60264
    */
   public PaymentNotFoundException(String aDescriptionStr) 
   {
	super(aDescriptionStr);    
   }
}
