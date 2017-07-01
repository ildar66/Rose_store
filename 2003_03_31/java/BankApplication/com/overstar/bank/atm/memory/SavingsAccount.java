package com.overstar.bank.atm.memory;

//package com.ibm.itso.sg245264.atm.memory;

/**
 * Represents a SavingsAccount as a specialised version of a regular BankAccount.
 */
public class SavingsAccount 
extends BankAccount 
{
	public final static SavingsAccount BILLS_ACCOUNT;

/**
 * Minimum balance that should be maintained.
 * NOTE: To keep things simple, this value is hardcoded.
 */
	private Money minimumBalance = new Money("200");

	
	static {
		BILLS_ACCOUNT = new SavingsAccount(new BankAccount.BankAccountPK("$$$"));
		BILLS_ACCOUNT.setBalance(new Money("1000000"));
	}

/**
 * This constructor will create a new instance
 * with the given primary key.
 * 
 * @param anId com.ibm.itso.sg245264.BankAccountPK
 */
public SavingsAccount(BankAccountPK anId) {
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
public static BankAccount findWithBankAccountPK(BankAccountPK anId) {
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
private Money getMinimumBalance() {
	return minimumBalance;
}
/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */
public String toOneLineString() {
	return "Savings account " + super.toOneLineString();
}
/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString() {
	return ("\nSavingsAccount (" + getId() + ") with a current balance of " + getBalance() + ".\n");
}
/*
 * Withdraws money from the account.
 * 
 * @param anAmount com.ibm.itso.sg245264.Money
 * @exception com.ibm.itso.sg245264.BelowMinimumBalanceException Withdraw cannot be completed
 */  
protected synchronized void withdraw(Money anAmount) 
throws TransactionAbortedException {
	if (getMinimumBalance().compareTo(getBalance().subtract(anAmount)) > 0) { 	// test if it would bring balance below overdraft
		throw new BelowMinimumBalanceException("There is not enough money, account would go below minimum balance.");
	}
	super.withdraw(anAmount);
}
}
