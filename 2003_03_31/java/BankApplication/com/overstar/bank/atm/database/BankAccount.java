package com.overstar.bank.atm.database;


import java.util.HashMap;
import java.util.Vector;

abstract public class BankAccount 
{
   
	public static class BankAccountPK 
	extends PrimaryKey
	{
		public BankAccountPK(String anId)
		{
				super(anId);
		}
	}
   

	private Money balance;
/**
 * This allows a simple -persistenceless- implementation.
 */
	private static HashMap allBankAccounts = new HashMap();
/**
 * This attribute contains the primary key of the BankAccount.
 * A BankAccount can be retrieved by searching on this value.
 */
	private BankAccountPK id;

/**
 * Deposit some money on the BankAccount.
 * 
 * Creation date: (11/28/00 7:45:44 PM)
 * @param anAmount com.ibm.itso.sg245264.Money
 * @exception com.ibm.itso.sg245264.TransactionAbortedException The deposit is not allowed.
 * @roseuid 3A1ABB8E0029
 */
protected synchronized void deposit(Money anAmount) 
throws TransactionAbortedException, PersistenceException {
	setBalance(getBalance().add(anAmount));
}

/**
 * Give the balance of the account.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 * @return Money
 */  
Money getBalance() throws PersistenceException{

	load();
	return balance;
}

/**
 * Update the balance of the BankAccount.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 * @param newBalance com.ibm.itso.sg245264.Money
 */  
protected void setBalance(Money newBalance) throws PersistenceException {
	
	
	balance = newBalance;
	store();

	
	
	
	
	}

/**
 * Withdraws money from the account.
 * 
 * Creation date: (11/28/00 7:41:18 PM)
 * @param anAmount com.ibm.itso.sg245264.Money
 * @exception com.ibm.itso.sg245264.TransactionAbortedException Withdraw cannot be completed
 * @roseuid 3A1ABB870187
 */  
protected synchronized void withdraw(Money anAmount) 
throws TransactionAbortedException, PersistenceException {
	setBalance(getBalance().subtract(anAmount));
}




/**
 * This finder will search for the BankAccount with the given
 * primary key and return it. 
 * It will create a new CheckingAccount with the given primary key 
 * if it didn't found an existing BankAccount with that primary key. 
 *
 * @param anId BankAccountPK Primary key
 * @return BankAccount instance
 */  
public static BankAccount findWithBankAccountPK(BankAccountPK anId) throws PersistenceException
{
	BankAccount tempBankAccount = null;
	if((tempBankAccount = (BankAccount) searchExistingFor(anId)) == null) {
		tempBankAccount = new CheckingAccount(anId);
	}
	return tempBankAccount;
	
}
/**
 * Insert the method's description here.
 * 
 * Creation date: (11/28/00 10:10:23 PM)
 * @return BankAccount
 */
public BankAccountPK getId() {
	return id;
}
/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString() {
	try{
		return ("\nBankAccount (" + getId() + ") with a current balance of " +  getBalance() + ".\n");
	}catch(PersistenceException exp){
		return ("\nBankAccount (" + getId() + ") with a current balance of <not available>.\n");
	}
	
	
}
/**
 * List of transactions having this account as source or target.
 */
private Vector transactions = new Vector();/**
 * This constructor will create a new instance
 * with the given primary key.
 * 
 * Creation date: (11/28/00 10:27:46 PM)
 * @param anId BankAccountPK
 */
protected BankAccount(BankAccountPK anId) throws PersistenceException {
	id = anId;
	balance = Money.ZERO;
	initMinimumBalance(Money.ZERO);
	initInitialAmountCash(Money.ZERO);
	//	initInitialAmountCash(new Money("5000"));//вариант для инициализации!!!
	initOverdraftAmount(new Money("-500"));
	System.out.println("from constructor: BankAccount(BankAccountPK)");//
	store();
	
}
/**
 * Add the given transaction to the list of transactions.
 * 
 * Creation date: (11/29/00 1:23:58 AM)
 * @param newTransactions java.util.Vector
 */
synchronized void addTransaction(Transaction aTrx) {
	transactions.addElement(aTrx);
}/**
 * Convenience method.
 * This finder converts String to key and uses the other one.
 *
 * @param anIdStr String
 * @return BankAccount instance
 */     
public static BankAccount findWithBankAccountPK(String anIdStr) throws PersistenceException 
{
	return findWithBankAccountPK(new BankAccountPK(anIdStr));
}/**
 * Returns the initial amount of money in the ATM.
 * 
 * Creation date: (11/28/00 10:43:45 PM)
 * @return com.ibm.itso.sg245264.Money
 */   
private Money getInitialAmountCash() {
	return new Money("0");
}/**
 * Get the list of all BankAccount instances known to the system.
 * 
 * Creation date: (12/4/00 2:20:32 PM)
 * @return java.util.Vector
 */   
/**
 * Get a list of all BankAccounts. Return a vector with all the accounts.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 * @return java.util.Vector
 */ 
public static Vector getListOfAllBankAccounts() throws PersistenceException{
	
	try{
	Vector allaccts = new Vector(0);
	BankAccount tempBankAccount = null;
	BankAccountData tempAcctData = new BankAccountData();
	
	com.ibm.ivj.db.uibeans.Select select = tempAcctData.getAccountSelectAll_W();
		
	select.execute();
	int numrecs  = select.getNumRows();

	if (numrecs <= 0){ 
		throw new AccountNotFoundException("No accounts were found.");
	}
		
	select.firstRow();
	for(int i=0; i< numrecs; i++){
			String tmpacctnum = (String)select.getColumnValue("ACCNTS.ACCT_NUM");
			String tmptype = (String)select.getColumnValue("ACCNTS.CTYPE");
			
			if(tmptype.equals("CheckingAccount")){
				tempBankAccount = new CheckingAccount();
			}
			else if (tmptype.equals("SavingsAccount")){
				tempBankAccount = new SavingsAccount();
			}

			else if (tmptype.equals("ATMAccount")){
				tempBankAccount = new ATMAccount();
			}
			else{
				throw new PersistenceException("Invalid Account Type found in table");
			}

			tempBankAccount.initId(new BankAccount.BankAccountPK(tmpacctnum));
			tempBankAccount.load();
			
			// add the new acct to the vector holding all accounts. 
			allaccts.addElement(tempBankAccount);
			select.nextRow();
		}




	return allaccts;
	}
	catch(com.ibm.db.DataException exp){
		throw new PersistenceException(exp.toString());
	}
	
}/**
 * Get the minimum balance that should be maintained 
 * on this SavingsAccount.
 * 
 * Creation date: (11/28/00 11:39:07 PM)
 * @return com.ibm.itso.sg245264.Money
 */                         
private Money getMinimumBalance() {
	return new Money("0");;
}/**
 * Get the lowest value this account can go.
 * 
 * Creation date: (11/28/00 11:41:28 PM)
 * @return com.ibm.itso.sg245264.Money
 */   
private Money getOverdraftAmount() {
	return new Money("0");
}/**
 * Get the list of associated transactions.
 * 
 * Creation date: (11/29/00 1:23:58 AM)
 * @return java.util.Vector
 */   
Vector getTransactions() {
	return new Vector(transactions);
}/**
 * Update the balance of the BankAccount.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 * @param newBalance com.ibm.itso.sg245264.Money
 */     
protected void initBalance(Money newBalance) {
	
	balance = newBalance;	
	
	
	}/**
 * Insert the method's description here.
 * Creation date: (12/8/00 9:42:53 AM)
 */   
protected void initInitialAmountCash(Money parmInitAmountCash) {}/**
 * Insert the method's description here.
 * Creation date: (12/8/00 9:41:24 AM)
 * @param parmMinBal ...atm.database.Money
 */    
protected void initMinimumBalance(Money parmMinBal) {}/**
 * Insert the method's description here.
 * Creation date: (12/8/00 9:46:37 AM)
 * @param parmOverdraftAmount com.ibm.itso.sg245264.atm.database.Money
 */   
protected void initOverdraftAmount(Money parmOverdraftAmount) {}/**
 * Insert the method's description here.
 * Creation date: (12/8/00 11:27:25 AM)
 * @param row java.lang.String
 */   
/**
 * Refresh the current BankAccount object from the database.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 */ 


void load() throws PersistenceException {
	
	try{
			BankAccountData tempAcctData = new BankAccountData();;
			com.ibm.ivj.db.uibeans.Select select = tempAcctData.getAccountSelect_W();
			
			
			select.setParameter("ACCTNUM", getId().getIdAsString());

			select.execute();
			select.firstRow();
			
			String tmpacctnum = (String)select.getColumnValue("ACCNTS.ACCT_NUM");
			Integer tmpbal = (Integer)select.getColumnValue("ACCNTS.BALANCE");
			String tmptype = (String)select.getColumnValue("ACCNTS.CTYPE");
			Integer tmpoverdraft = (Integer)select.getColumnValue("ACCNTS.OVRDRAFT");
			Integer tmpminimumbal = (Integer)select.getColumnValue("ACCNTS.MINBALANCE");
			Integer tmpinitcash = (Integer)select.getColumnValue("ACCNTS.INITCASH");

			this.initBalance(new Money(tmpbal.toString()));
			if(tmpinitcash != null ){
				this.initInitialAmountCash(new Money(tmpinitcash.toString()));
			}
			if(tmpminimumbal != null){
				this.initMinimumBalance(new Money(tmpminimumbal.toString()));
			}
			if(tmpoverdraft != null){
				this.initOverdraftAmount(new Money(tmpoverdraft.toString()));
			}

			if (tmptype.equals("CheckingAccount")  &&  !(this instanceof CheckingAccount)){
				throw new PersistenceException("Invalid Data in table. Cannot transform account " + tmpacctnum +
					" into a checking account.");
			}
			else if (tmptype.equals("SavingsAccount")  &&  !(this instanceof SavingsAccount)){
				throw new PersistenceException("Invalid Data in table. Cannot transform account " + tmpacctnum +
					" into a savings account.");
			}
			else if (tmptype.equals("ATMAccount")  &&  !(this instanceof ATMAccount)){
				throw new PersistenceException("Invalid Data in table. Cannot transform account " + tmpacctnum +
					" into a ATM account.");
			}
	}
	catch(com.ibm.db.DataException exp){
		throw new PersistenceException(exp.toString());
	}
	
	
}/**
 * Search in the existing set of BankAccounts for one with given ID.
 * 
 * Creation date: (11/29/00 4:41:34 PM)
 * @return com.ibm.itso.sg245264.BankAccount
 * @param anId com.ibm.itso.sg245264.BankAccountPK
 */             
protected static BankAccount searchExistingFor(BankAccountPK anId) throws PersistenceException{
	try{
		//  System.out.println("000n BankAccount");//
			BankAccount tempBankAccount = null;
		//	System.out.println("undo BankAccount");//
			BankAccountData tempAcctData = new BankAccountData();
		//	System.out.println("after BankAccount");//
			com.ibm.ivj.db.uibeans.Select select = tempAcctData.getAccountSelect_W();
			
	System.out.println("select.setParametre BankAccount");//
			select.setParameter("ACCTNUM", anId.getIdAsString());
	System.out.println("undo select.execute() BankAccount");//
			select.execute();
			
//if(select.getRowCount() == 0) return null; //добавлено для входа в программу
	   	
	System.out.println("after select.execute() BankAccount");//			
			select.firstRow();
	System.out.println("after select.firstRow() BankAccount");//
			String tmptype = (String)select.getColumnValue("ACCNTS.CTYPE");
			
			
			if(tmptype.equals("CheckingAccount")){
				tempBankAccount = new CheckingAccount();
			}
			else if (tmptype.equals("SavingsAccount")){
				tempBankAccount = new SavingsAccount();
			}

			else if (tmptype.equals("ATMAccount")){
				tempBankAccount = new ATMAccount();
			}
			else{
				throw new PersistenceException("Invalid Account Type found in table");
			}

			tempBankAccount.initId(anId);


			tempBankAccount.load();
			
			return tempBankAccount;
	}
	catch(com.ibm.db.DataException exp){
		System.out.println("DataException from searchExistRor :BankAccount");//last
		throw new PersistenceException(exp.toString());
	}
}/**
 * Insert the method's description here.
 * Creation date: (12/8/00 10:35:42 AM)
 * @param parmBankAccount BankAccount
 */                               
/**
 * Store the current BankAccount object in the database. Use the
 * Visual Age for Java 3.5 Data Access Beans. If the account already
 * exists in the database, update the account record. If the account is
 * not in the database, insert it.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 */ 


protected void store() throws PersistenceException{
	com.ibm.ivj.db.uibeans.Modify modify=null;

	
	try{	
		BankAccountData tempAcctData = new BankAccountData();
		if (exists()){		
			modify = tempAcctData.getAccountUpdate_W();
			modify.setParameter("ACCT_NUM",this.getId().getIdAsString());
		}
		else{ 
			modify = tempAcctData.getAccountInsert_W();
		}
		
		// set the SQL parameters.
		modify.setParameter("ACCTNUM",this.getId().getIdAsString());
		modify.setParameter("BALANCE",new Integer(rtBalance().intValue()));	
		modify.setParameter("OVRDRAFT",new Integer(rtOverdraftAmount().intValue()));
		modify.setParameter("MINBALANCE",new Integer(rtMinimumBalance().intValue()));
		modify.setParameter("INITCASH",new Integer(rtInitialAmountCash().intValue()));
		
		if(this instanceof CheckingAccount) { 	
			modify.setParameter("CTYPE", "CheckingAccount");
		}
		else if(this instanceof SavingsAccount) { 	
			modify.setParameter("CTYPE", "SavingsAccount");
		}
		else if(this instanceof ATMAccount) { 	
			modify.setParameter("CTYPE", "ATMAccount");
		}
		else{
			throw new PersistenceException("Invalid Account Type. Valid types are CheckingAccount, SavingsAccount, and ATMAccount");
		}

		// execute the SQL statement.
		modify.execute();
		// refresh the current BankAccount object.
		load();
		}
		catch(com.ibm.db.DataException exp){
			throw new PersistenceException(exp.toString());
		}
	
	
	
	}/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */                                    
public String toOneLineString(){
	try{
		return  id.getIdAsString() + " with balance = " + getBalance();
	}catch(PersistenceException exp){
		return  id.getIdAsString() + " with balance = <not available>.";
	}
};

/**
 * Insert the method's description here.
 * Creation date: (12/12/00 3:42:21 PM)
 */
public BankAccount() {}

/**
 * Check to see of the BankAccount object equals another
 * BankAccount. If the primary keys are equal, then the 
 * BankAccounts are considered equal.
 
 * Creation date: (12/12/00 4:49:12 PM)
 * @return boolean
 */
public boolean equals(Object anObject) {
	try {
		return id.equals(((BankAccount) anObject).id);
	} catch(ClassCastException ex) {
		return false;
	}
}

/**
 * Check to see if the BankAccount exists in the database.
 * If it exists, return true.
 *
 * Creation date: (12/12/00 1:47:40 PM)
 * @return boolean
 */
protected boolean exists() throws PersistenceException{
	try{	
		
		BankAccountData tempAcctData = new BankAccountData();
		com.ibm.ivj.db.uibeans.Select select = tempAcctData.getAccountSelect_W();
		
		select.setParameter("ACCTNUM", getId().getIdAsString());
		select.execute();
		if (select.getNumRows() > 0) {
			return true;
		}
		else{
			return false;
		}
	}
	catch(Exception exp){
		throw new PersistenceException(exp.toString());
	}
}

protected void initId(BankAccountPK anId) {
	
	id = anId;	
	
	
	}/**
 * Insert the method's description here.
 * Creation date: (12/8/00 9:42:53 AM)
 */     

/**
 * Give the balance of the account without going to the database.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 * @return com.ibm.itso.sg245264.Money
 */  
protected Money rtBalance(){

	return balance;
}

protected Money rtInitialAmountCash() {
	return new Money("0");
}/**
 * Get the list of all BankAccount instances known to the system.
 * 
 * Creation date: (12/4/00 2:20:32 PM)
 * @return java.util.Vector
 */     

protected Money rtMinimumBalance() {
	return new Money("0");;
}/**
 * Get the lowest value this account can go.
 * 
 * Creation date: (11/28/00 11:41:28 PM)
 * @return com.ibm.itso.sg245264.Money
 */     

protected Money rtOverdraftAmount() {
	return new Money("0");
}/**
 * Get the list of associated transactions.
 * 
 * Creation date: (11/29/00 1:23:58 AM)
 * @return java.util.Vector
 */     
}