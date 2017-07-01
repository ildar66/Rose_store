//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CashDispenser.java

package com.overstar.bank.atm.database;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CashDispenser.java

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CashDispenser.java

/**
 * Instances of this class represent the device in an ATM that is
 * responsible of 'dispensing money'.
 * To indicate what is happening, these instances write messages
 * on the console (OUT).
 */
class CashDispenser 
{
   

/**
 * Order this device to dispense the given amount
 * of money. This might take a while...
 */
void dispenseMoney(Money anAmount) {
	try{
		System.out.println("CashDispenser: Dispensing " + anAmount + " ...\n");
		Thread.currentThread().sleep(anAmount.longValue() * 50); // NOTE: We hardcode that it will take 0.05 seconds to give a unit of money
	} catch(InterruptedException ignored) {}
}         
}