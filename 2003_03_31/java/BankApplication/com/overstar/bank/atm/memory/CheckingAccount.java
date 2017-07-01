package com.overstar.bank.atm.memory;

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CheckingAccount.java

//package com.ibm.itso.sg245264.atm.memory;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CheckingAccount.java

/**
 * Represents a CheckingsAccount as a specialised version of a regular BankAccount.
 */
public class CheckingAccount 
extends BankAccount 
{
/**
 * This represents the lowest value the balance can go.
 * NOTE: To keep things simple, this value is hardcoded.
 */
private Money overdraftAmount = new Money("-500");
/**
 * This constructor will create a new instance
 * with the given primary key.
 * 
 * Creation date: (11/28/00 11:25:24 PM)
 * @param anId com.ibm.itso.sg245264.BankAccountPK
 */
public CheckingAccount(BankAccountPK anId) {
	super(anId);
}
/**
 * This finder will search for the CheckingAccount with the given
 * primary key and return it. 
 * It will create a new CheckingAccount with the given primary key 
 * if it didn't found an existing CheckingAccount with that primary key 
 * or when the BankAccount with that key wasn't an CheckingAccount.
 *
 * @param anId BankAccountPK Primary key
 * @return CheckingAccount Will always return an CheckingAccount, although technically only a BankAccount is needed
 */  
public static BankAccount findWithBankAccountPK(BankAccountPK anId) {
	BankAccount tempBankAccount = null;
	
	try {
		if((tempBankAccount = (CheckingAccount) searchExistingFor(anId)) == null) {
			tempBankAccount = new CheckingAccount(anId);
		}
	} catch(ClassCastException ex) {
		tempBankAccount = new CheckingAccount(anId); // ATTENTION: This will override existing instance with given key...
	}
	
	return tempBankAccount;
}
/**
 * Get the lowest value this account can go.
 * 
 * Creation date: (11/28/00 11:41:28 PM)
 * @return com.ibm.itso.sg245264.Money
 */
private Money getOverdraftAmount() {
	return overdraftAmount;
}
/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */
public String toOneLineString() {
	return "Checking account " + super.toOneLineString();
}
/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString() {
	return ("\nCheckingAccount (" + getId() + ") with a current balance of " + getBalance() + ".\n");
}
/*
 * Withdraws money from the account.
 * 
 * @param anAmount com.ibm.itso.sg245264.Money
 * @exception com.ibm.itso.sg245264.OverdraftLimitExceededException Withdraw cannot be completed
 */  
protected synchronized void withdraw(Money anAmount) 
throws TransactionAbortedException {
	if (getOverdraftAmount().compareTo(getBalance().subtract(anAmount)) > 0) { 	// test if it would bring balance below overdraft
		throw new OverdraftLimitExceededException("There is not enough money, account would go below overdraft.");
	}
	super.withdraw(anAmount);
}
}
