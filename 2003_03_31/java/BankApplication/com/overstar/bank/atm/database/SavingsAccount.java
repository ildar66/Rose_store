//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\SavingsAccount.java

package com.overstar.bank.atm.database;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\SavingsAccount.java

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\SavingsAccount.java

/**
 * Represents a SavingsAccount as a specialised version of a regular BankAccount.
 */
public class SavingsAccount 
extends BankAccount 
{
	//public final static SavingsAccount BILLS_ACCOUNT;
/**
 * Minimum balance that should be maintained. 
 * NOTE: To keep things simple, this value is hardcoded.
 */
	private Money minimumBalance = new Money("0");
/**
 * Insert the method's description here.
 * Creation date: (12/12/00 3:43:07 PM)
 */
SavingsAccount() {}

/**
 * This constructor will create a new instance
 * with the given primary key.
 * 
 * @param anId com.ibm.itso.sg245264.BankAccountPK
 */
public SavingsAccount(BankAccountPK anId) throws PersistenceException {
	super(anId);
}

/**
 * This finder will search for the SavingsAccount with the given
 * primary key and return it. 
 * It will create a new SavingsAccount with the given primary key 
 * if it didn't found an existing SavingsAccount with that primary key 
 * or when the BankAccount with that key wasn't an SavingsAccount.
 *
 * @param anId BankAccountPK Primary key
 * @return SavingsAccount Will always return an SavingsAccount, although technically only a BankAccount is needed
 */  
public static BankAccount findWithBankAccountPK(BankAccountPK anId) throws PersistenceException {
	BankAccount tempBankAccount = null;
	
	try {
		if((tempBankAccount = (SavingsAccount) searchExistingFor(anId)) == null) {
			tempBankAccount = new SavingsAccount(anId);
		}
	} catch(ClassCastException ex) {
		tempBankAccount = new SavingsAccount(anId); // ATTENTION: This will override existing instance with given key...
	}
	
	return tempBankAccount;
}

/**
 * Get the minimum balance that should be maintained 
 * on this SavingsAccount.
 * 
 * Creation date: (11/28/00 11:39:07 PM)
 * @return com.ibm.itso.sg245264.Money
 */
public Money getMinimumBalance() throws PersistenceException{
	load();
	return minimumBalance;
}

/**
 * Insert the method's description here.
 * Creation date: (12/8/00 9:41:24 AM)
 * @param parmMinBal com.ibm.itso.sg245264.atm.database.Money
 */
public void initMinimumBalance(Money parmMinBal){
	
	
	minimumBalance = parmMinBal;
	
	}

/**
 * Get the minimum balance that should be maintained 
 * on this SavingsAccount.
 * 
 * Creation date: (11/28/00 11:39:07 PM)
 * @return com.ibm.itso.sg245264.Money
 */
protected Money rtMinimumBalance() {
	if(minimumBalance != null){	
		return minimumBalance;
	}
	else{
		return new Money("0");
	}
}

/**
 * Insert the method's description here.
 * Creation date: (12/8/00 9:41:24 AM)
 * @param parmMinBal com.ibm.itso.sg245264.atm.database.Money
 */
public void setMinimumBalance(Money parmMinBal) throws PersistenceException{
	
	
	minimumBalance = parmMinBal;
	super.store();
	
	}

/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */
public String toOneLineString(){
	return "Savings account " + super.toOneLineString();
}

/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString(){
	return ("\nSavingsAccount (" + super.toOneLineString() + ")"  + ".\n");
}

/*
 * Withdraws money from the account.
 * 
 * @param anAmount Money
 * @exception BelowMinimumBalanceException Withdraw cannot be completed
 */  
protected synchronized void withdraw(Money anAmount) 
throws TransactionAbortedException, PersistenceException {
	if (getMinimumBalance().compareTo(getBalance().subtract(anAmount)) > 0) { 	// test if it would bring balance below overdraft
		throw new BelowMinimumBalanceException("There is not enough money, account would go below minimum balance.");
	}
	super.withdraw(anAmount);
}
}