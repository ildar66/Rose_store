package com.overstar.ildar.ibank.model;

import java.math.*;
import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (30.10.2002 15:59:07)
 * @author: Shafigullin Ildar
 */
abstract public class BankAccount {

    /**
     * PrimaryKey class to be used for instances of type Recipient.
     *@param anBranch_id java.lang.String - 'Уникальный идентификатор банка или филиала, зарегистрированных в системе';
     *@param anAccount java.lang.String - 'Счет клиента';
     */
    public static class BankAccountPK extends PrimaryKeyTwo {
        public BankAccountPK(String anBranch_id, String anAccount) {
            super(anBranch_id, anAccount);
        }
    }
    private BankAccountPK id; //'Уникальный идентификатор счета';
    private java.lang.Integer client_id; //'Идентификатор клиента';
    public final static int SETTLEMENT = 0; //расчетный.
    public final static int RUNNING = 1; //текущий.
    public final static int TRANSIENT = 2; //транзитный.
    public final static int SPEC_TRANSIENT = 3; //спецтранзитный.
    private java.sql.Date create_date; //'Дата заведения счета';
    private Money create_amount; //'Сумма на момент заведения счета(в единицах валюты)';
    private java.lang.String currency = "RUR";
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:47:42)
 */
public BankAccount() {
    super();
}
/**
 * BankAccount constructor comment.
 */
protected  BankAccount(
    BankAccountPK anId,
    Integer anClient_id,
    Date anCreate_date,
    Money anCreate_amount,
    String anCurrency,
    boolean isStore)
    throws PersistenceException {
    id = anId;
    initClient_id(anClient_id);
    initCreate_date(anCreate_date);
    initCreate_amount(anCreate_amount);
    initCurrency(anCurrency);
    if (isStore)
      store();
}
/**
 * BankAccount constructor comment.
 * по умолчанию currency = "RUR"
 */
protected  BankAccount(
    BankAccountPK anId,
    Integer anClient_id,
    Date anCreate_date,
    Money anCreate_amount,
    boolean isStore)
    throws PersistenceException {
    id = anId;
    initClient_id(anClient_id);
    initCreate_date(anCreate_date);
    initCreate_amount(anCreate_amount);
    if (isStore)
      store();
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 15:41:54)
 * @return boolean
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected boolean exists() throws PersistenceException {
    try {

        BankAccountData tempAcctData = new BankAccountData();
        com.ibm.ivj.db.uibeans.Select select = tempAcctData.getBankAccountSelect_W();

        select.setParameter("BRNCH_ID", getId().getId1AsString());
        select.setParameter("ACCOUNT", getId().getId2AsString());

        select.execute();
        if (select.getNumRows() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 12:43:06)
 * @return com.overstar.ildar.ibank.model.BankAccount
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static BankAccount findWithBankAccountPK(BankAccount.BankAccountPK anId) throws PersistenceException {
    BankAccount tempBankAccount = null;
    if ((tempBankAccount = (BankAccount) searchExistingFor(anId)) == null) {
        throw new BankAccountNotFoundException("The BankAccount with primary key (" +anId.getId2AsString()+" - "+ anId.getId2AsString() + ") was not found.");
    }
    return tempBankAccount;

}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 10:47:52)
 * @return com.overstar.ildar.ibank.model.BankAccount
 * @param anBranch_id java.lang.String
 * @param anAccount java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static BankAccount findWithBankAccountPK(String anBranch_id, String anAccount) throws PersistenceException {
	return findWithBankAccountPK(new BankAccount.BankAccountPK (anBranch_id, anAccount));
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @return com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 */
public com.overstar.ildar.ibank.model.BankAccount.BankAccountPK getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 13:00:40)
 * @return java.lang.String
 * @param anBankAccount com.overstar.ildar.ibank.model.BankAccount
 */
public static String getType(BankAccount anBankAccount) {
    if (anBankAccount instanceof RunningAccount) {
        return "текущий";
    }
    else if (anBankAccount instanceof SettlementAccount) {
        return "расчетный";
    }
    else if (anBankAccount instanceof TransientAccount) {
        return "транзитный";
    }
    else if (anBankAccount instanceof SpecTransientAccount) {
        return "спецтранзитный";
    }
    else {
        return "неизвестный тип счета";
    }
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @param newClient_id java.lang.Integer
 */
protected void initClient_id(java.lang.Integer newClient_id) {
	client_id = newClient_id;
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @param newCreate_amount com.overstar.ildar.ibank.model.Money
 */
protected void initCreate_amount(Money newCreate_amount) {
	create_amount = newCreate_amount;
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @param newCreate_date java.sql.Date
 */
protected void initCreate_date(java.sql.Date newCreate_date) {
	create_date = newCreate_date;
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @param newCurrency java.lang.String
 */
protected void initCurrency(java.lang.String newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 13:18:28)
 * @param newId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 */
protected void initId(com.overstar.ildar.ibank.model.BankAccount.BankAccountPK newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @return java.lang.Integer
 */
protected java.lang.Integer rtClient_id() {
	return client_id;
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @return com.overstar.ildar.ibank.model.Money
 */
public Money rtCreate_amount() {
	return create_amount;
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @return java.sql.Date
 */
public java.sql.Date rtCreate_date() {
	return create_date;
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 16:32:05)
 * @return java.lang.String
 */
public java.lang.String rtCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 13:03:13)
 * @return com.overstar.ildar.ibank.model.BankAccount
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected static BankAccount searchExistingFor(BankAccount.BankAccountPK anId) throws PersistenceException {
    try {
        BankAccount tempBankAccount = null;
        BankAccountData tempAcctData = new BankAccountData();
        com.ibm.ivj.db.uibeans.Select select = tempAcctData.getBankAccountSelect_W();

        select.setParameter("BRNCH_ID", anId.getId1AsString());
        select.setParameter("ACCOUNT", anId.getId2AsString());

        select.execute();
        if (select.getRowCount() <= 0) {
            return null;
        }

        select.firstRow();
        int tmptype = Integer.parseInt((String)select.getColumnValue("ACCOUNTS.TYPE_ACCOUNT")) ;

        if (tmptype == BankAccount.RUNNING) {
            tempBankAccount = new RunningAccount();
        }
        else if (tmptype == BankAccount.SETTLEMENT) {
            tempBankAccount = new SettlementAccount();
        }

        else if (tmptype == BankAccount.SPEC_TRANSIENT) {
            tempBankAccount = new SpecTransientAccount();
        }
        else if (tmptype == BankAccount.TRANSIENT) {
            tempBankAccount = new TransientAccount();
        }

        else {
            throw new PersistenceException("Invalid Account Type found in table");
        }

        tempBankAccount.initId(anId);

        Integer tmpAccountsCLIENT_ID = (Integer) select.getColumnValue("ACCOUNTS.CLIENT_ID");
        Date tmpAccountsCREATE_DATE = (Date) select.getColumnValue("ACCOUNTS.CREATE_DATE");
        BigDecimal tmpAccountsCREATE_AMOUNT = (BigDecimal) select.getColumnValue("ACCOUNTS.CREATE_AMOUNT");
        String tmpAccountsCURRENCY = (String) select.getColumnValue("ACCOUNTS.CURRENCY");

        tempBankAccount.initClient_id(tmpAccountsCLIENT_ID);
        tempBankAccount.initCreate_date(tmpAccountsCREATE_DATE);
        tempBankAccount.initCreate_amount( new Money(tmpAccountsCREATE_AMOUNT.toString()) );
        tempBankAccount.initCurrency(tmpAccountsCURRENCY);
        
        return tempBankAccount;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Store the current BankAccount object in the database. Use the
 * Visual Age for Java 4.0 Data Access Beans. If the account already
 * exists in the database, update the account record. If the account is
 * not in the database, insert it.
 * 
 * Creation date: (31.10.2002 15:38:19)
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected void store() throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        BankAccountData tempAcctData = new BankAccountData();
        if (exists()) {
            modify = tempAcctData.getBankAccountUpdate_W();
            modify.setParameter("ID1_BRANCH_ID", this.getId().getId1AsString());
            modify.setParameter("ID2_ACCOUNT", this.getId().getId2AsString());
        }
        else {
            modify = tempAcctData.getBankAccountInsert_W();
        }

        // set the SQL parameters.
        modify.setParameter("BRANCH_ID", this.getId().getId1AsString());
        modify.setParameter("ACCOUNT", this.getId().getId2AsString());
        modify.setParameter("CLIENT_ID", this.rtClient_id());
        modify.setParameter("CREATE_DATE", this.rtCreate_date());
        modify.setParameter("CREATE_AMOUNT", this.rtCreate_amount());
        modify.setParameter("CURRENCY", this.rtCurrency());

        if (this instanceof RunningAccount) {
            modify.setParameter("TYPE_ACCOUNT", String.valueOf(BankAccount.RUNNING));
        }
        else if (this instanceof SettlementAccount) {
            modify.setParameter("TYPE_ACCOUNT",  String.valueOf(BankAccount.SETTLEMENT));
        }
        else if (this instanceof TransientAccount) {
            modify.setParameter("TYPE_ACCOUNT",  String.valueOf(BankAccount.TRANSIENT));
        }
        else if (this instanceof SpecTransientAccount) {
            modify.setParameter("TYPE_ACCOUNT",  String.valueOf(BankAccount.SPEC_TRANSIENT));
        }
        else {
            throw new PersistenceException("Invalid Account Type. Valid types are RunningAccount, SettlementAccount, SpecTransientAccount and TransientAccount");
        }

        // execute the SQL statement.
        modify.execute();
        // refresh the current BankAccount object.
        //load();
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString() {
    return (
        "\nBankAccount ("
            + getId()
            + ") with a Create_amount of "
            + rtCreate_amount()
            + ".\n"
            + " with a Client_id of "
            + rtClient_id()
            + ".\n"
            + " with a Create_date of "
            + rtCreate_date()
            + ".\n"
            + " with a Currency of "
            + rtCurrency()
            + ".\n"
            + " with a Class_account of "
            + this.getClass()
            + ".\n");
}
}
