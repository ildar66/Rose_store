package com.overstar.ildar.ibank.model.accounts;

import com.overstar.ildar.ibank.model.Money;
import java.sql.Date;
import com.overstar.ildar.ibank.model.exceptions.*;
/**
 * Insert the type's description here.
 * Creation date: (31.10.2002 16:29:52)
 * 
 * @author  Shafigullin Ildar
 */
public class SettlementAccount extends BankAccount 
{
   
   /**
    * SettlementAccount constructor comment.
    * @roseuid 3E0041BF0158
    */
   public SettlementAccount() 
   {
	super();    
   }
/**
 * SettlementAccount constructor comment.
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @param anClient_id java.lang.Integer
 * @param anCreate_date java.sql.Date
 * @param anCreate_amount com.overstar.ildar.ibank.model.Money
 * @param isStore boolean
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041BF0237
 */
protected SettlementAccount(
    BankAccount.BankAccountPK anId,
    Integer anClient_id,
    java.sql.Date anCreate_date,
    Money anCreate_amount) {
    super(anId, anClient_id, anCreate_date, anCreate_amount);
}
/**
 * SettlementAccount constructor comment.
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @param anClient_id java.lang.Integer
 * @param anCreate_date java.sql.Date
 * @param anCreate_amount com.overstar.ildar.ibank.model.Money
 * @param anCurrency java.lang.String
 * @param isStore boolean
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041BF0162
 */
protected SettlementAccount(
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
    * @roseuid 3E0041BF0311
    */
   public String getType() 
   {
	return "расчетный";    
   }
   /**
    * Insert the method's description here.
    * Creation date: (01.11.2002 12:24:11)
    * @return java.lang.String
    * @roseuid 3E0041BF031B
    */
   public String toString() 
   {
	return ("\nSettlementAccount (" + super.toString() + ").\n");    
   }
}
