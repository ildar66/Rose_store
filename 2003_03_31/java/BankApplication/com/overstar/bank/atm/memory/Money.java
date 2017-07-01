package com.overstar.bank.atm.memory;

import java.math.BigInteger;
/**
* Represents an amount of money.
* The currency is not taken into account here.
* This basicly represents only a quantity, without a fraction.
* We use BigInteger as basis for our implementation.
*
*/
public class Money extends java.math.BigInteger {
	public final static Money ZERO = new Money(BigInteger.ZERO);/**
* Create an amount of money equal to the given
* String representation of it.
*
* Creation date: (12/15/00 9:36:49 PM)
* @param anAmountStr java.lang.String
* @exception java.lang.NumberFormatException When the parameter cannot be
											 converted to a number
*/
public Money(String anAmountStr) throws NumberFormatException {
   super(anAmountStr);
}/**
* 
*
* @param anAmount BigInteger
* @exception java.lang.NumberFormatException Will never be thrown
*/
  public Money(BigInteger anAmount) throws NumberFormatException {
	  super(anAmount.toString());
}/**
 * Convenience method.
 * Creation date: (21.06.2001 10:46:13)
 * @return com.overstar.bank.atm.memory.Money
 * @param anAmount com.overstar.bank.atm.memory.Money
 */
public Money add(Money anAmount) {
	return new Money(super.add(anAmount));
}/**
 * * Is this instance positive (0 inclusive) ?
 *
 * Creation date: (21.06.2001 9:56:09)
 * @return boolean
 */
public boolean isPositive() {
	return (compareTo(ZERO) >= 0);
}/**
 * Convenience method.
 *
 * Creation date: (21.06.2001 10:47:52)
 * @return com.overstar.bank.atm.memory.Money
 * @param anAmount com.overstar.bank.atm.memory.Money
 */
public Money subtract(Money anAmount) {
	return new Money(super.subtract(anAmount));
}
}