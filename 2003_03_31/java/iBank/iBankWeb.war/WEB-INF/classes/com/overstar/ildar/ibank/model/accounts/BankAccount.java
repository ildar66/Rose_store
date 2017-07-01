package com.overstar.ildar.ibank.model.accounts;

import java.sql.*;
import com.overstar.ildar.ibank.model.*;

/**
 * Insert the type's description here.
 * Creation date: (30.10.2002 15:59:07)
 * @author: Shafigullin Ildar
 */
public abstract class BankAccount {

    /**
     * 'Идентификатор клиента';
     */
    private Integer client_id;

    /**
     * 'Дата заведения счета';
     */
    private Date create_date;
    
    /**
    * 'Валюта счета';
    */
    private String currency;

    /**
     * 'Уникальный идентификатор счета';
     */
    private BankAccount.BankAccountPK id;

    /**
     * 'Сумма на момент заведения счета(в единицах валюты)';
     */
    private Money create_amount;

/**
 * PrimaryKey class to be used for instances of type BankAccount.
 * @param anBranch_id java.lang.String - 'Уникальный идентификатор банка или 
 * филиала, зарегистрированных в системе';
 * @param anAccount java.lang.String - 'Счет клиента';
 */
public static class BankAccountPK extends PrimaryKeyTwo {

    /**
     * @param anBranch_id
     * @param anAccount
     * @roseuid 3E0EEA08011E
     */
    public BankAccountPK(String anBranch_id, String anAccount) {
        super(anBranch_id, anAccount);
    }
}
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:47:42)
    * @roseuid 3E0EEA0502FB
    */
   public BankAccount() 
   {
    super();    
   }
/**
 * BankAccount constructor comment.
 * по умолчанию currency = "RUR"
 * @param anId
 * @param anClient_id
 * @param anCreate_date
 * @param anCreate_amount
 * @param isStore
 * @roseuid 3E0EEA060090
 */
protected BankAccount(
    BankAccount.BankAccountPK anId,
    Integer anClient_id,
    java.sql.Date anCreate_date,
    Money anCreate_amount) {
    this(anId, anClient_id, anCreate_date, anCreate_amount, "RUR");
}
/**
 * BankAccount constructor comment.
 * @param anId
 * @param anClient_id
 * @param anCreate_date
 * @param anCreate_amount
 * @param anCurrency
 * @param isStore
 * @roseuid 3E0EEA05030F
 */
protected BankAccount(
    BankAccount.BankAccountPK anId,
    Integer anClient_id,
    java.sql.Date anCreate_date,
    Money anCreate_amount,
    String anCurrency) {
    id = anId;
    initClient_id(anClient_id);
    initCreate_date(anCreate_date);
    initCreate_amount(anCreate_amount);
    initCurrency(anCurrency);
}
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @return com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
    * @roseuid 3E0EEA06036B
    */
   public BankAccount.BankAccountPK getId() 
   {
	return id;    
   }
/**
* Insert the method's description here.
* Creation date: (22.01.2003 17:30:31)
* @return java.lang.String
*/
public abstract String getType();
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @param newClient_id java.lang.Integer
    * @roseuid 3E0EEA07002D
    */
   private void initClient_id(java.lang.Integer newClient_id) 
   {
	client_id = newClient_id;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @param newCreate_amount com.overstar.ildar.ibank.model.Money
    * @roseuid 3E0EEA070091
    */
   private void initCreate_amount(Money newCreate_amount) 
   {
	create_amount = newCreate_amount;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @param newCreate_date java.sql.Date
    * @roseuid 3E0EEA0700FF
    */
   private void initCreate_date(java.sql.Date newCreate_date) 
   {
	create_date = newCreate_date;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @param newCurrency java.lang.String
    * @roseuid 3E0EEA07016D
    */
   private void initCurrency(java.lang.String newCurrency) 
   {
	currency = newCurrency;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @return java.lang.Integer
    * @roseuid 3E0EEA070290
    */
   protected Integer rtClient_id() 
   {
	return client_id;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @return com.overstar.ildar.ibank.model.Money
    * @roseuid 3E0EEA0702D6
    */
   public Money rtCreate_amount() 
   {
	return create_amount;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @return java.sql.Date
    * @roseuid 3E0EEA07033A
    */
   public Date rtCreate_date() 
   {
	return create_date;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 16:32:05)
    * @return java.lang.String
    * @roseuid 3E0EEA070394
    */
   public String rtCurrency() 
   {
	return currency;    
   }
   /**
    * Specific implementation for toString().
    * @return java.lang.String
    * @roseuid 3E0EEA0800CE
    */
   public String toString() 
   {
    return (
        "\nBankAccount ("
            + getId()
            + ")\n"
            + " with a Create_amount of "
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
