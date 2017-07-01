package com.overstar.ildar.ibank.model;

import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * Represents an amount of money.
 * The currency is not taken into account here.(Нужно привязать его таблице Валют(ildar.Currency))
 * This basically represents only a quantity, without a fraction.
 * We use BigDecimal as basis for our implementation.
 *
 * Creation date: (04.09.2002 12:24:42)
 * @author: Shafigullin Ildar
 */
public class Money extends java.math.BigDecimal {
    public final static Money ZERO = new Money(BigInteger.ZERO);
/**
 * Money constructor comment.
 * @param val double
 */
public Money(double val) {
	super(val);
}
/**
 * Money constructor comment.
 * @param val java.lang.String
 * @exception java.lang.NumberFormatException When the parameter cannot be converted to a number
 */
public Money(String anAmountStr) throws NumberFormatException {
	super(anAmountStr);
}
/**
 * Money constructor comment.
 * @param val java.math.BigInteger
 */
public Money(java.math.BigInteger val) {
	super(val);
}
/**
 * Money constructor comment.
 * @param unscaledVal java.math.BigInteger
 * @param scale int
 */
public Money(java.math.BigInteger unscaledVal, int scale) {
	super(unscaledVal, scale);
}
/**
 * Convenience method.
 *
 * Creation date: (04.09.2002 12:54:03)
 * @return com.overstar.ildar.ibank.Money
 * @param anAmount com.overstar.ildar.ibank.Money
 */
public Money add(Money anAmount) {
    return new Money((super.add(anAmount)).doubleValue());
}
/**
 * Is this instance positive (0 inclusive) ?
 *
 * Creation date: (04.09.2002 12:32:48)
 * @return boolean
 */
public boolean isPositive() {
	return (compareTo(ZERO) >= 0);
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 17:46:52)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
    Money tempMoney = new Money(new BigInteger("1111"));
    System.out.println(tempMoney);
    tempMoney = new Money(new BigInteger("1111"), 1);
    System.out.println(tempMoney);
    tempMoney = new Money(new BigInteger("1111"), 2);
    System.out.println(tempMoney);
    tempMoney = new Money(0.1);
    System.out.println(tempMoney);
    tempMoney = new Money(0.01);
    System.out.println(tempMoney);
    tempMoney = new Money("0.0123512355");
    System.out.println(tempMoney);
    tempMoney = new Money("12355");
    System.out.println(tempMoney);
    tempMoney = new Money("0");
    System.out.println(tempMoney);
    tempMoney = new Money("0.0");
    System.out.println(tempMoney);
    tempMoney = new Money("0.01");
    System.out.println(tempMoney);
    tempMoney = new Money("0.012");
    System.out.println(tempMoney);
}
/**
 * Convenience method.
 * 
 * Creation date: (04.09.2002 13:03:40)
 * @return com.overstar.ildar.ibank.Money
 * @param anAmount com.overstar.ildar.ibank.Money
 */
public Money subtract(Money anAmount) {
	return new Money((super.subtract(anAmount)).doubleValue());
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 18:31:59)
 * @return java.lang.String
 */
public String toString() {
    String tempStr = super.toString();
    int scale = 2;//количество цифр после "."
    int point = tempStr.indexOf(".");
    if ( (point != (-1)) && ((point + scale+1)< tempStr.length()) )
        return tempStr.substring(0, point + scale+1);
    else
        return tempStr;
}
}
