package com.overstar.bank.atm.database;

/**
 * Instances of this class represent an account that is associated
 * to each ATM. This account is used to book cash withdrawels while
 * keeping track of the amount of money available for the cashdispenser.
 * 
 * Creation date: (11/28/00 10:36:46 PM)
 * @author: 
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

 
private Money initialAmountCash = new Money("0");
/**
 * Insert the method's description here.
 * Creation date: (12/12/00 3:40:59 PM)
 */
ATMAccount() {

	}
/**
 * This constructor will create a new instance
 * with the given primary key.
 * 
 * Creation date: (11/28/00 10:27:46 PM)
 * @param anId com.ibm.itso.sg245264.BankAccountPK
 */
protected ATMAccount(BankAccountPK anId) throws PersistenceException{
	
	super(anId);
}
/**
 * Redraw money from ATM = deposit some money on the ATMAccount.
 * 
 * Creation date: (11/28/00 7:45:44 PM)
 * @param anAmount Money
 * @exception TransactionAbortedException The deposit is not allowed, because there's not enough cash money available.
 * @roseuid 3A1ABB8E0029
 */
protected synchronized void deposit(Money anAmount) 
throws TransactionAbortedException, PersistenceException  {
	if (getInitialAmountCash().compareTo(getBalance().add(anAmount)) < 0) { 	// test if resulting deposit would bring balance above initialAmountCash
		throw new NotEnoughCashException("There is not enough cash money available.");
	}
	super.deposit(anAmount);
}
/**
 * Insert the method's description here.
 * Creation date: (12/11/00 11:46:08 AM)
 * @return com.ibm.itso.sg245264.atm.database.BankAccount
 * @exception com.ibm.itso.sg245264.atm.database.PersistenceException The exception description.
 */
public static BankAccount findWithBankAccountPK(BankAccountPK anId) throws PersistenceException {
	BankAccount tempBankAccount = null;
	System.out.println("---BankAccount");//	
	try {

		if((tempBankAccount = (ATMAccount) searchExistingFor(anId)) == null) {
			System.out.println("null BankAccount");//
			tempBankAccount = new ATMAccount(anId);
		}
		System.out.println("not null BankAccount");//
	} catch(ClassCastException ex) {
 System.out.println("exS BankAccount");//
		tempBankAccount = new ATMAccount(anId); // ATTENTION: This will override existing instance with given key...
	}
	
	return tempBankAccount;
}
/**
 * Return the actual amount of cash money available
 * in the ATM holding this account.
 * 
 * Creation date: (11/28/00 10:51:45 PM)
 * @return Money
 */
public Money getActualAmountOfCash() throws PersistenceException{
	return getInitialAmountCash().subtract(getBalance());
}
/**
 * Returns the initial amount of money in the ATM.
 * 
 * Creation date: (11/28/00 10:43:45 PM)
 * @return Money
 */
public Money getInitialAmountCash() throws PersistenceException{
	load();
	return initialAmountCash;
}
protected void initInitialAmountCash(Money parmInitAmountCash) {
	
	initialAmountCash = parmInitAmountCash;
	
	
	}/**
 * Insert the method's description here.
 * Creation date: (12/8/00 9:41:24 AM)
 * @param parmMinBal database.Money
 */      
/**
 * Returns the initial amount of money in the ATM.
 * 
 * Creation date: (11/28/00 10:43:45 PM)
 * @return Money
 */
protected Money rtInitialAmountCash() {
	if (initialAmountCash != null ){	
		return initialAmountCash;
	}
	else{
		return new Money("0");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (12/5/01 9:42:53 AM)
 */
protected void setInitialAmountCash(Money parmInitAmountCash) throws PersistenceException {
	
	initialAmountCash = parmInitAmountCash;
	
	super.store();
	
	
	}
/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */
public String toOneLineString(){
	return "ATM account " + super.toOneLineString();
}
/**
 * Specific implementation for toString().
 *
 * @return java.lang.String
 */
public String toString(){
	return ("\nATMAccount (" + super.toOneLineString() + ")" );
}
}