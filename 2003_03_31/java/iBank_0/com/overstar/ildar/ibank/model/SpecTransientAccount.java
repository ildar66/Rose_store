package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (31.10.2002 16:30:37)
 * @author: Shafigullin Ildar
 */
public class SpecTransientAccount extends BankAccount {
/**
 * SpecTransientAccount constructor comment.
 */
public SpecTransientAccount() {
	super();
}
/**
 * SpecTransientAccount constructor comment.
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @param anClient_id java.lang.Integer
 * @param anCreate_date java.sql.Date
 * @param anCreate_amount com.overstar.ildar.ibank.model.Money
 * @param anCurrency java.lang.String
 * @param isStore boolean
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected SpecTransientAccount(com.overstar.ildar.ibank.model.BankAccount.BankAccountPK anId, Integer anClient_id, java.sql.Date anCreate_date, Money anCreate_amount, String anCurrency, boolean isStore) throws PersistenceException {
	super(anId, anClient_id, anCreate_date, anCreate_amount, anCurrency, isStore);
}
/**
 * SpecTransientAccount constructor comment.
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @param anClient_id java.lang.Integer
 * @param anCreate_date java.sql.Date
 * @param anCreate_amount com.overstar.ildar.ibank.model.Money
 * @param isStore boolean
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected SpecTransientAccount(com.overstar.ildar.ibank.model.BankAccount.BankAccountPK anId, Integer anClient_id, java.sql.Date anCreate_date, Money anCreate_amount, boolean isStore) throws PersistenceException {
	super(anId, anClient_id, anCreate_date, anCreate_amount, isStore);
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 12:41:11)
 * @return java.lang.String
 */
public String getType() {
	return "��������������";
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 12:24:11)
 * @return java.lang.String
 */
public String toString(){
	return ("\nSpecTransientAccount (" + super.toString() + ").\n");
}
}