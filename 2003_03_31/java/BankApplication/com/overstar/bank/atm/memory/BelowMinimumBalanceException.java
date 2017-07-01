package com.overstar.bank.atm.memory;

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\BelowMinimumBalanceException.java

//package com.ibm.itso.sg245264.atm.memory;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\BelowMinimumBalanceException.java

/**
 * An instance of this gets thrown when the balance of a SavingsAccount
 * would drop below the predefined amount when executing a transaction.
 */
public class BelowMinimumBalanceException 
extends ExceedLimitException 
{
   

/**
 * Constructor taking a description as argument.
 *
 * @param aDescriptionStr java.lang.String
 */
BelowMinimumBalanceException(String aMessage) {
	   super(aMessage);
}
}
