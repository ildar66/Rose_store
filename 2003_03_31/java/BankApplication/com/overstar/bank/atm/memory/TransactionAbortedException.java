package com.overstar.bank.atm.memory;

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\TransactionAbortedException.java

//package com.ibm.itso.sg245264.atm.memory;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\TransactionAbortedException.java

/**
 * An instance of a subclass of this type gets trown
 * whenever a money transaction on a BankAccount 
 * could not succeed. 
 */
abstract public class TransactionAbortedException 
extends Exception
{
   

TransactionAbortedException(String aMessage) {
	   super(aMessage);
}
}
