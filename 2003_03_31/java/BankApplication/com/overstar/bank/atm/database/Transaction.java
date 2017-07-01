//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\Transaction.java

package com.overstar.bank.atm.database;
import java.util.Date;
import java.text.DateFormat;
import java.util.HashMap;

import java.text.*;/**
 * Represents a (succeeded) transfer of money from one account to another.
 * This class is responsible for 'making' the actual transfer, 
 * ensuring that no money can be 'created' or 'disappear' by demanding 
 * that subtraction from source account and addition to target account
 * BOTH succeeded.
 * Instances of this class will be created as a result of that process.
 */
public class Transaction {

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
throws TransactionAbortedException, PersistenceException 
   {
	   //Transaction tempTrx = new Transaction(aTrxAmount, aSrcAccount, aTrgtAccount);
	   
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
		   aSrcAccount.deposit(aTrxAmount); // NOTE: theoretically this could also throw exception...
		   throw ex;
	   }

	   Transaction tempTrx = new Transaction(aTrxAmount, aSrcAccount, aTrgtAccount);//перенес сверху
	   tempTrx.store();
	   
	   allTransactions.put(tempTrx.getId(), tempTrx);
	   aSrcAccount.addTransaction(tempTrx);
	   aTrgtAccount.addTransaction(tempTrx);
	   
	   return tempTrx;
   }                                                                                          
/**
 * This allows a simple -persistenceless- implementation.
 */
	private static HashMap allTransactions = new HashMap();		private BankAccount srcAccount;		private BankAccount trgtAccount;		private Money trxAmount;
/**
 * Constructor that makes a new Transaction based on the given values.
 * 
 * Creation date: (11/28/00 5:24:20 PM)
 * @param aTrxAmount Money
 * @param aSrcAccount BankAccount
 * @param aTrgtAccount BankAccount
 */
private Transaction(Money aTrxAmount, BankAccount aSrcAccount, BankAccount aTrgtAccount) throws PersistenceException {
	id = new TransactionPK();
	setTrxAmount(aTrxAmount);
	setSrcAccount(aSrcAccount);
	setTrgtAccount(aTrgtAccount);
	setTimestamp(new Date());
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

	private java.util.Date timestamp;

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
 * Get the date and time of this transaction.
 * 
 * Creation date: (12/4/00 4:30:19 PM)
 * @return java.util.Date
 */
public java.util.Date getTimestamp() {
	return timestamp;
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
	private com.ibm.ivj.db.uibeans.Modify ivjTransactionInsert = null;/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Transaction() {
	super();
	initialize();
}/**
 * Return the TransactionInsert property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getTransactionInsert() {
	if (ivjTransactionInsert == null) {
		try {
			ivjTransactionInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjTransactionInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.TransactionDAB.conn1(), com.overstar.bank.atm.database.TransactionDAB.TransactionInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTransactionInsert;
}/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		Transaction aTransaction;
		//aTransaction = Transaction.createTrx(null, new com.overstar.bank.atm.database.BankAccount(), new com.overstar.bank.atm.database.BankAccount());
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of java.lang.Object");
		exception.printStackTrace(System.out);
	}
}/**
 * Insert the method's description here.
 * Creation date: (17.07.2001 11:08:56)
 * @exception com.overstar.bank.atm.database.PersistenceException The exception description.
 */
private void store() throws PersistenceException {
	com.ibm.ivj.db.uibeans.Modify modify=null;
	
	try{	
			modify = getTransactionInsert();
			java.text.SimpleDateFormat sdf;
							
			modify.setParameter("REF_NUM",this.getId().getIdAsString());
			//System.out.println(modify.getParameterToString("REF_NUM"));
			modify.setParameter("AMOUNT",new Double(this.getTrxAmount().doubleValue()));
			//System.out.println(modify.getParameterToString("AMOUNT"));
			modify.setParameter("SRC_ACT",this.getSrcAccount().getId().getIdAsString());
			//System.out.println(modify.getParameterToString("SRC_ACT"));
			modify.setParameter("TGT_ACT",this.getTrgtAccount().getId().getIdAsString());
			//System.out.println(modify.getParameterToString("TGT_ACT"));

			sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			modify.setParameterFromString("DATE", sdf.format(getTimestamp())); 
			//modify.setParameterFromString("DATE", "" + (1900 + getTimestamp().getYear()) + "-" + getTimestamp().getMonth() + "-" + getTimestamp().getDay());
			System.out.println(modify.getParameterToString("DATE"));
			//modify.setParameterFromString("TMESTAMP","1988-12-25 17:12:30.000000");
			sdf = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS");
			modify.setParameterFromString("TMESTAMP", sdf.format(getTimestamp()));
			//modify.setParameterFromString("TMESTAMP", getTimestamp().toLocaleString());
			System.out.println(modify.getParameterToString("TMESTAMP"));	
			
					
			modify.execute();
			//load();
				
	}
	catch(com.ibm.db.DataException exp){
		//exp.printStackTrace();
		throw new PersistenceException(exp.toString());
	}
	

	}}