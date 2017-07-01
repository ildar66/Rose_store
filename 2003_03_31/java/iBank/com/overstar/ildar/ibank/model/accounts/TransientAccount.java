package com.overstar.ildar.ibank.model.accounts;

import com.overstar.ildar.ibank.model.Money;
import java.sql.Date;
import com.overstar.ildar.ibank.model.exceptions.*;
/**
 * Insert the type's description here.
 * Creation date: (31.10.2002 16:31:18)
 * 
 * @author  Shafigullin Ildar
 */
public class TransientAccount extends BankAccount 
{
   
   /**
    * TransientAccount constructor comment.
    * @roseuid 3E0041C00344
    */
   public TransientAccount() 
   {
	super();    
   }
/**
 * TransientAccount constructor comment.
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @param anClient_id java.lang.Integer
 * @param anCreate_date java.sql.Date
 * @param anCreate_amount com.overstar.ildar.ibank.model.Money
 * @roseuid 3E0041C10039
 */
protected TransientAccount(
    BankAccount.BankAccountPK anId,
    Integer anClient_id,
    java.sql.Date anCreate_date,
    Money anCreate_amount) {
    super(anId, anClient_id, anCreate_date, anCreate_amount);
}
/**
 * TransientAccount constructor comment.
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @param anClient_id java.lang.Integer
 * @param anCreate_date java.sql.Date
 * @param anCreate_amount com.overstar.ildar.ibank.model.Money
 * @param anCurrency java.lang.String
 * @roseuid 3E0041C0034E
 */
protected TransientAccount(
    BankAccount.BankAccountPK anId,
    Integer anClient_id,
    java.sql.Date anCreate_date,
    Money anCreate_amount,
    String anCurrency) {
    super(anId, anClient_id, anCreate_date, anCreate_amount, anCurrency);
}
   /**
    * Insert the method's description here.
    * Creation date: (01.11.2002 12:41:11)
    * @return java.lang.String
    * @roseuid 3E0041C10103
    */
   public String getType() 
   {
	return "транзитный";    
   }
   /**
    * Insert the method's description here.
    * Creation date: (01.11.2002 12:24:11)
    * @return java.lang.String
    * @roseuid 3E0041C10115
    */
   public String toString() 
   {
	return ("\nTransientAccount (" + super.toString() + ").\n");    
   }
}
