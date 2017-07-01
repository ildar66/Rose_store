package com.overstar.bank.database;

/**
 * Insert the type's description here.
 * Creation date: (27.08.2001 11:13:37)
 * @author: Shafigullin Ildar
 */
public class DocView {
	private java.util.Date fieldDate_Carry = new java.util.Date();
	private java.lang.String fieldCorrAccount = new String();
	private java.lang.String fieldBankCode = new String();
	private java.lang.String fieldAccountContr = new String();
	private java.lang.String fieldNameContr = new String();
	private java.math.BigDecimal fieldDebit = new java.math.BigDecimal(0);
	private java.math.BigDecimal fieldCredit = new java.math.BigDecimal(0);
	private java.lang.String fieldGround = new String();
/**
 * DocView constructor comment.
 */
public DocView() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2001 11:43:54)
 * @param date_Carry java.util.Date
 * @param bankCode java.lang.String
 * @param corrAccount java.lang.String
 * @param nameContr java.lang.String
 * @param accountContr java.lang.String
 * @param credit java.math.BigDecimal
 * @param debit java.math.BigDecimal
 * @param ground java.lang.String
 */
public DocView(java.util.Date date_Carry, String bankCode, String corrAccount, String nameContr, String accountContr, java.math.BigDecimal credit, java.math.BigDecimal debit, String ground) {
	setDate_Carry(date_Carry);
	setBankCode(bankCode);
	setCorrAccount(corrAccount);
	setNameContr(nameContr);
	setAccountContr(accountContr);
	setCredit(credit);
	setDebit(debit);
	setGround(ground);
}
/**
 * Gets the accountContr property (java.lang.String) value.
 * @return The accountContr property value.
 * @see #setAccountContr
 */
public java.lang.String getAccountContr() {
	return fieldAccountContr;
}
/**
 * Gets the bankCode property (java.lang.String) value.
 * @return The bankCode property value.
 * @see #setBankCode
 */
public java.lang.String getBankCode() {
	return fieldBankCode;
}
/**
 * Gets the corrAccount property (java.lang.String) value.
 * @return The corrAccount property value.
 * @see #setCorrAccount
 */
public java.lang.String getCorrAccount() {
	return fieldCorrAccount;
}
/**
 * Gets the credit property (java.math.BigDecimal) value.
 * @return The credit property value.
 * @see #setCredit
 */
public java.math.BigDecimal getCredit() {
	return fieldCredit;
}
/**
 * Gets the date_Carry property (java.util.Date) value.
 * @return The date_Carry property value.
 * @see #setDate_Carry
 */
public java.util.Date getDate_Carry() {
	return fieldDate_Carry;
}
/**
 * Gets the debit property (java.math.BigDecimal) value.
 * @return The debit property value.
 * @see #setDebit
 */
public java.math.BigDecimal getDebit() {
	return fieldDebit;
}
/**
 * Gets the ground property (java.lang.String) value.
 * @return The ground property value.
 * @see #setGround
 */
public java.lang.String getGround() {
	return fieldGround;
}
/**
 * Gets the nameContr property (java.lang.String) value.
 * @return The nameContr property value.
 * @see #setNameContr
 */
public java.lang.String getNameContr() {
	return fieldNameContr;
}
/**
 * Sets the accountContr property (java.lang.String) value.
 * @param accountContr The new value for the property.
 * @see #getAccountContr
 */
public void setAccountContr(java.lang.String accountContr) {
	fieldAccountContr = accountContr;
}
/**
 * Sets the bankCode property (java.lang.String) value.
 * @param bankCode The new value for the property.
 * @see #getBankCode
 */
public void setBankCode(java.lang.String bankCode) {
	fieldBankCode = bankCode;
}
/**
 * Sets the corrAccount property (java.lang.String) value.
 * @param corrAccount The new value for the property.
 * @see #getCorrAccount
 */
public void setCorrAccount(java.lang.String corrAccount) {
	fieldCorrAccount = corrAccount;
}
/**
 * Sets the credit property (java.math.BigDecimal) value.
 * @param credit The new value for the property.
 * @see #getCredit
 */
public void setCredit(java.math.BigDecimal credit) {
	fieldCredit = credit;
}
/**
 * Sets the date_Carry property (java.util.Date) value.
 * @param date_Carry The new value for the property.
 * @see #getDate_Carry
 */
public void setDate_Carry(java.util.Date date_Carry) {
	fieldDate_Carry = date_Carry;
}
/**
 * Sets the debit property (java.math.BigDecimal) value.
 * @param debit The new value for the property.
 * @see #getDebit
 */
public void setDebit(java.math.BigDecimal debit) {
	fieldDebit = debit;
}
/**
 * Sets the ground property (java.lang.String) value.
 * @param ground The new value for the property.
 * @see #getGround
 */
public void setGround(java.lang.String ground) {
	fieldGround = ground;
}
/**
 * Sets the nameContr property (java.lang.String) value.
 * @param nameContr The new value for the property.
 * @see #getNameContr
 */
public void setNameContr(java.lang.String nameContr) {
	fieldNameContr = nameContr;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2001 15:03:08)
 */
public String toStringDocView() {
	return ""+getDate_Carry()+"</TD> <TD>" +getCorrAccount() +"</TD> <TD>" +
	          getBankCode()  +"</TD> <TD>" +getAccountContr()+"</TD> <TD>" +
	          getNameContr() +"</TD> <TD>" +getDebit()       +"</TD> <TD>" +
	          getCredit()    +"</TD> <TD>" +getGround();
}
}
