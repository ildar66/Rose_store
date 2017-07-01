package com.overstar.bank.atm.memory;

//package com.ibm.itso.sg245264.atm.memory;

/**
 * Instances of this class represent an account that is associated
 * to each ATM. This account is used to book cash withdrawels while
 * keeping track of the amount of money available for the cashdispenser.
 * 
 */
class ATMAccount 
extends BankAccount {
/**
 * This fields contains the initial amount of money when no cash
 * dispenses have taken place. It is hence the maximum limit that
 * this account can reach (because the associated ATM cannot give more
 * money than it has).
 * The actual amount of money available to the cash dispenser of the
 * associated ATM is equal to the difference between the amount
 * of this field and the balance of this account.
 * NOTE: To keep things simple, this value is hardcoded.
 */
private Money initialAmountCash = new Money("10000");
/**
 * This constructor will create a new instance
 * with the given primary key.
 * 
 * Creation date: (11/28/00 10:27:46 PM)
 * @param anId com.ibm.itso.sg245264.BankAccountPK
 */
protected ATMAccount(BankAccountPK anId) {
	super(anId);
}
/**
 * Redraw money from ATM = deposit some money on the ATMAccount.
 * 
 * Creation date: (11/28/00 7:45:44 PM)
 * @param anAmount com.ibm.itso.sg245264.Money
 * @exception com.ibm.itso.sg245264.TransactionAbortedException The deposit is not allowed, because there's not enough cash money available.
 * @roseuid 3A1ABB8E0029
 */
protected synchronized void deposit(Money anAmount) 
throws TransactionAbortedException {
	if (getInitialAmountCash().compareTo(getBalance().add(anAmount)) < 0) { 	// test if resulting deposit would bring balance above initialAmountCash
		throw new NotEnoughCashException("There is not enough cash money available.");
	}
	super.deposit(anAmount);
}
/**
 * This finder will search for the ATMAccount with the given
 * primary key and return it. 
 * It will create a new ATMAccount with the given primary key 
 * if it didn't found an existing ATMAccount with that primary key 
 * or when the BankAccount with that key wasn't an ATMAccount.
 *
 * @param anId BankAccountPK Primary key
 * @return ATMAccount Will always return an ATMAccount, although technically only a BankAccount is needed
 */  
public static BankAccount findWithBankAccountPK(BankAccountPK anId) {
	BankAccount tempBankAccount = null;
	
	try {
		if((tempBankAccount = (ATMAccount) searchExistingFor(anId)) == null) {
			tempBankAccount = new ATMAccount(anId);
		}
	} catch(ClassCastException ex) {
		tempBankAccount = new ATMAccount(anId); // ATTENTION: This will override existing instance with given key...
	}
	
	return tempBankAccount;
}
/**
 * Return the actual amount of cash money available
 * in the ATM holding this account.
 * 
 * Creation date: (11/28/00 10:51:45 PM)
 * @return com.ibm.itso.sg245264.Money
 */
Money getActualAmountOfCash() {
	return getInitialAmountCash().subtract(getBalance());
}
/**
 * Returns the initial amount of money in the ATM.
 * 
 * Creation date: (11/28/00 10:43:45 PM)
 * @return com.ibm.itso.sg245264.Money
 */
private Money getInitialAmountCash() {
	return initialAmountCash;
}
/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */
public String toOneLineString() {
	return "ATM account " + super.toOneLineString();
}
/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString() {
	return ("\nATMAccount (" + getId() + ") with a current balance of " + getBalance()
				+ " and initial amount = " + getInitialAmountCash() + ".\n"
				+ "(meaning that there's still " + getActualAmountOfCash() + " in the associated ATM.)\n");
}
}
