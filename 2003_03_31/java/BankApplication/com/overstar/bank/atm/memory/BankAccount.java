package com.overstar.bank.atm.memory;

import java.util.Vector;
import java.util.HashMap;

/**
 * This class is the parent of all sorts of BankAccounts.
 * It keeps track of all accounts created and provides a 
 * finder method to retrieve them.
 * You can only transfer Money by using the Transaction class.
 * @see Transaction
 */
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
 * List of transactions having this account as source or target.
 */
private Vector transactions = new Vector();

/**
 * This constructor will create a new instance
 * with the given primary key.
 * 
 * Creation date: (11/28/00 10:27:46 PM)
 * @param anId com.ibm.itso.sg245264.BankAccountPK
 */
protected BankAccount(BankAccountPK anId) {
	id = anId;
	balance = Money.ZERO;
	allBankAccounts.put(anId, this);	// ATTENTION: This might silently override existing instance with given key...
}
/**
 * Add the given transaction to the list of transactions.
 * 
 * Creation date: (11/29/00 1:23:58 AM)
 * @param newTransactions java.util.Vector
 */
synchronized void addTransaction(Transaction aTrx) {
	transactions.addElement(aTrx);
}
/**
 * Deposit some money on the BankAccount.
 * 
 * Creation date: (11/28/00 7:45:44 PM)
 * @param anAmount com.ibm.itso.sg245264.Money
 * @exception com.ibm.itso.sg245264.TransactionAbortedException The deposit is not allowed.
 * @roseuid 3A1ABB8E0029
 */
protected synchronized void deposit(Money anAmount) 
throws TransactionAbortedException {
	setBalance(getBalance().add(anAmount));
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
public static BankAccount findWithBankAccountPK(BankAccountPK anId) 
{
	BankAccount tempBankAccount = null;
	if((tempBankAccount = (BankAccount) searchExistingFor(anId)) == null) {
		tempBankAccount = new CheckingAccount(anId);
	}
	return tempBankAccount;
}
/**
 * Convenience method.
 * This finder converts String to key and uses the other one.
 *
 * @param anIdStr String
 * @return BankAccount instance
 */  
public static BankAccount findWithBankAccountPK(String anIdStr) 
{
	return findWithBankAccountPK(new BankAccountPK(anIdStr));
}
/**
 * Give the balance of the account.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 * @return com.ibm.itso.sg245264.Money
 */  
Money getBalance() {
	return balance;
}
/**
 * Insert the method's description here.
 * 
 * Creation date: (11/28/00 10:10:23 PM)
 * @return com.ibm.itso.sg245264.BankAccount
 */
public BankAccountPK getId() {
	return id;
}
/**
 * Get the list of all BankAccount instances known to the system.
 * 
 * Creation date: (12/4/00 2:20:32 PM)
 * @return java.util.Vector
 */
public static Vector getListOfAllBankAccounts() {
	return new Vector(allBankAccounts.values());
}
/**
 * Get the list of associated transactions.
 * 
 * Creation date: (11/29/00 1:23:58 AM)
 * @return java.util.Vector
 */
Vector getTransactions() {
	return new Vector(transactions);
}
/**
 * Search in the existing set of BankAccounts for one with given ID.
 * 
 * Creation date: (11/29/00 4:41:34 PM)
 * @return BankAccount
 * @param BankAccountPK
 */
protected static BankAccount searchExistingFor(BankAccountPK anId) {
	return (BankAccount) allBankAccounts.get(anId);
}
/**
 * Update the balance of the BankAccount.
 * 
 * Creation date: (11/28/00 7:37:30 PM)
 * @param newBalance com.ibm.itso.sg245264.Money
 */  
protected void setBalance(Money newBalance) {
	balance = newBalance;
}
/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */
public String toOneLineString() {
	return  id.getIdAsString() + " with balance = " + getBalance();
}
/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString() {
	return ("\nBankAccount (" + getId() + ") with a current balance of " + getBalance() + ".\n");
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
throws TransactionAbortedException {
	setBalance(getBalance().subtract(anAmount));
}
}
