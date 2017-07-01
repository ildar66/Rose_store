package com.overstar.bank.atm.memory;

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\NotEnoughCashException.java

//package com.ibm.itso.sg245264.atm.memory;

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\NotEnoughCashException.java

/**
 * An instance of this gets thrown when the balance of an ATMAccount
 * would exceed the maximum.
 * In practise, this means that the associated CashDispenser of the
 * ATM that is associated with the ATMAccount, would be short of
 * money when trying to execute the transaction (money withdrawal).
 */
public class NotEnoughCashException 
extends TransactionAbortedException {   

/**
 * Constructor taking a description as argument.
 *
 * @param aDescriptionStr java.lang.String
 */
NotEnoughCashException(String aMessage) {
	   super(aMessage);
}
}
