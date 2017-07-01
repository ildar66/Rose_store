package com.overstar.bank.atm.memory;

/**
 * Insert the type's description here.
 * Creation date: (21.06.2001 11:34:57)
 * @author: Shafigullin Ildar
 */
import java.util.Date;
import java.text.DateFormat;
import java.util.HashMap;

/**
 * Represents a (succeeded) transfer of money from one account to another.
 * This class is responsible for 'making' the actual transfer, 
 * ensuring that no money can be 'created' or 'disappear' by demanding 
 * that subtraction from source account and addition to target account
 * BOTH succeeded.
 * Instances of this class will be created as a result of that process.
 */
public class Transaction 
{

	public static class TransactionPK 
	extends PrimaryKey
	{
		public TransactionPK()
		{
				super();
		}
		public TransactionPK(String anId)
		{
				super(anId);
		}
	}

/**
 * This attribute contains the primary key of the Transaction.
 * An Transaction can be retrieved by searching on this value.
 */
	private TransactionPK id;
		
/**
 * This allows a simple -persistenceless- implementation.
 */
	private static HashMap allTransactions = new HashMap();	
	private BankAccount srcAccount;	
	private BankAccount trgtAccount;	
	private Money trxAmount;
	private Date timestamp;

/**
 * Constructor that makes a new Transaction based on the given values.
 * 
 * Creation date: (11/28/00 5:24:20 PM)
 * @param aTrxAmount com.ibm.itso.sg245264.Money
 * @param aSrcAccount com.ibm.itso.sg245264.BankAccount
 * @param aTrgtAccount com.ibm.itso.sg245264.BankAccount
 */
private Transaction(Money aTrxAmount, BankAccount aSrcAccount, BankAccount aTrgtAccount) {
	id = new TransactionPK();
	setTrxAmount(aTrxAmount);
	setSrcAccount(aSrcAccount);
	setTrgtAccount(aTrgtAccount);
	setTimestamp(new Date());
}
/**
 * This method tries to make a transaction of the specified 
 * amount of money for the given source account 
 * onto the given target account.
 *
 * @param aTrxAmount
 * @param aSrcAccount
 * @param aTrgtAccount
 * @return Transaction Transaction instance indicating this transaction if successfull, otherwise null.
 * @exception TransactionAbortedException It will throw an exception if the transaction could not be completed, after it rolled back any of the already token steps.
 * @roseuid 3A1ABBA202A8
 */
public static Transaction createTrx(
							Money aTrxAmount, 
							BankAccount aSrcAccount, 
							BankAccount aTrgtAccount) 
throws TransactionAbortedException 
   {
	   Transaction tempTrx = new Transaction(aTrxAmount, aSrcAccount, aTrgtAccount);
	   
	   // deduct from aSrcAccount
	   try {
		   aSrcAccount.withdraw(aTrxAmount);
	   } catch(TransactionAbortedException ex) {
		   throw ex;
	   }

	   // add tot aTrgtAccount
	   try {
		   aTrgtAccount.deposit(aTrxAmount);
	   } catch(TransactionAbortedException ex) {
		   // put money back on aSrcAccount
		   aSrcAccount.deposit(aTrxAmount); //  NOTE: theoretically this could also throw exception...
		   throw ex;
	   }
	   
	   allTransactions.put(tempTrx.getId(), tempTrx);
	   aSrcAccount.addTransaction(tempTrx);
	   aTrgtAccount.addTransaction(tempTrx);
	   
	   return tempTrx;
   }      
/**
 * Get the Primary Key of the Transaction.
 * 
 * Creation date: (11/28/00 5:22:23 PM)
 * @return com.ibm.itso.sg245264.Transaction.TransactionPK
 */ 

public Transaction.TransactionPK getId() {
	return id;
}
/**
 * Return the source from which money is substracted
 * by this Transaction.
 * 
 * Creation date: (11/28/00 5:26:21 PM)
 * @return com.ibm.itso.sg245264.BankAccount
 */ 

public BankAccount getSrcAccount() {
	return srcAccount;
}
/**
 * Get the date and time of this transaction.
 * 
 * Creation date: (12/4/00 4:30:19 PM)
 * @return java.util.Date
 */
public java.util.Date getTimestamp() {
	return timestamp;
}
/**
 * Return the target on which money is added
 * by this Transaction.
 * 
 * Creation date: (11/28/00 5:27:44 PM)
 * @return com.ibm.itso.sg245264.BankAccount
 */ 
public BankAccount getTrgtAccount() {
	return trgtAccount;
}
/**
 * Get the amount of this Transaction.
 * 
 * Creation date: (11/28/00 5:25:21 PM)
 * @return com.ibm.itso.sg245264.Money
 */ 
public Money getTrxAmount() {
	return trxAmount;
}
/**
 * Set the source from which money is substracted
 * by this Transaction.
 * 
 * Creation date: (11/28/00 5:26:21 PM)
 * @param newSrcAccount com.ibm.itso.sg245264.BankAccount
 */ 
private void setSrcAccount(BankAccount newSrcAccount) {
	srcAccount = newSrcAccount;
}
/**
 * Insert the method's description here.
 * 
 * Creation date: (12/4/00 4:30:19 PM)
 * @param newTimestamp java.util.Date
 */
private void setTimestamp(java.util.Date newTimestamp) {
	timestamp = newTimestamp;
}
/**
 * Set the target account on which money is added
 * by this Transaction.
 * 
 * Creation date: (11/28/00 5:27:44 PM)
 * @param newTrgtAccount com.ibm.itso.sg245264.BankAccount
 */ 
private void setTrgtAccount(BankAccount newTrgtAccount) {
	trgtAccount = newTrgtAccount;
}
/**
 * Set the amount of the transaction.
 * 
 * Creation date: (11/28/00 5:25:21 PM)
 * @param newTrxAmount com.ibm.itso.sg245264.Money
 */ 
private void setTrxAmount(Money newTrxAmount) {
	trxAmount = newTrxAmount;
}
/**
 * Gives standard representation of an instance.
 * 
 * Creation date: (11/28/00 6:27:12 PM)
 * @return java.lang.String
 */
public String toString() {
	return ("\n===================================\n"
				+ "Transaction (" + getId() + ") representing the tranfer of " + getTrxAmount() 
				+ " on " + DateFormat.getDateInstance().format(getTimestamp()) + " at " + DateFormat.getTimeInstance().format(getTimestamp())
				+ "\nfrom: " + getSrcAccount() + "to: " + getTrgtAccount() 
				+ "===================================\n");
}
}
