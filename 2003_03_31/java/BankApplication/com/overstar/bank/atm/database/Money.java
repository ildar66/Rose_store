//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\Money.java

package com.overstar.bank.atm.database;


import java.math.BigInteger;

/**
 * Represents an amount of money.
 * The currency is not taken into account here.
 * This basicly represents only a quantity, without a fraction.
 * We use BigInteger as basis for our implementation.
 */
public class Money
extends BigInteger
{
public final static Money ZERO = new Money(BigInteger.ZERO);
/**
 * Create an amount of money equal to the given
 * String representation of it.
 * 
 * Creation date: (11/28/00 7:35:08 PM)
 * @param anAmountStr java.lang.String
 * @exception java.lang.NumberFormatException The exception description.
 */
public Money(String anAmountStr) 
throws java.lang.NumberFormatException {
	super(anAmountStr);
}

/**
 * Copy ctor.
 */
public Money(BigInteger anAmount) 
throws java.lang.NumberFormatException {
	super(anAmount.toString());
}

/**
 * Convenience.
 * 
 * Creation date: (11/29/00 12:16:06 PM)
 * @return com.ibm.itso.sg245264.Money
 * @param anAmount com.ibm.itso.sg245264.Money
 */
public Money add(Money anAmount) {
	return new Money(super.add(anAmount));
}

/**
 * Convenience.
 * 
 * Creation date: (11/29/00 12:16:06 PM)
 * @return com.ibm.itso.sg245264.Money
 * @param anAmount com.ibm.itso.sg245264.Money
 */
public Money subtract(Money anAmount) {
	return new Money(super.subtract(anAmount));
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2001 11:32:36)
 * @return boolean
 */
public boolean isPositive() {
	return (compareTo(ZERO) >= 0);
}}