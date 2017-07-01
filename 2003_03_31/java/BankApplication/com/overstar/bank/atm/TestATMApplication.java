package com.overstar.bank.atm;

import java.util.Iterator;
import java.util.Vector;
/**
 * Change this import statement to choose between 
 * different ATM implementations:
 * 	import com.ibm.itso.sg245264.atm.memory.*;
 * 	import com.ibm.itso.sg245264.atm.database.*;
 *
 */
import com.overstar.bank.atm.database.*;
//import com.overstar.bank.atm.memory.*;


/**
 * Test the ATM business objects.
 * 
 * Creation date: (11/30/00 5:52:10 PM)
 * @author: Frederik Haesbrouck
 */
public class TestATMApplication {
/**
 * Create a special Card.
 * 
 * Creation date: (12/4/00 4:06:36 PM)
 */
private static void createLuckyCard() throws PersistenceException, InvalidPINException{
	Card tempCard;
	BankAccount tempAccount;
	
	tempCard = new Card(new Card.CardPK("luckycard"), "luckyperson");
	tempAccount = new CheckingAccount(new BankAccount.BankAccountPK("777-7777777-77"));
	//try {
		//Transaction.createTrx(new Money("100000"), SavingsAccount.BILLS_ACCOUNT, tempAccount);
	//} catch(TransactionAbortedException ignored) {}
	try{	
		tempCard.associateBankAccount(tempAccount);
	}
	catch(Exception exp){
		System.out.println("error: " + exp );
	}
}
/**
 * Create some Card instances by using the finder 
 * in order to automatically create associated bankaccounts.
 * 
 * Creation date: (12/4/00 3:44:55 PM)
 */
private static void createSomeCards() throws PersistenceException, InvalidPINException{
	int nbr = 10;

	for (int i=0; i < nbr; i++) {
		if (((int) (Math.random() * nbr)) == 7) {
			createLuckyCard();
		}
		try{	
			Card.findWithCardPK("95120-E3249-" + i);
		}
		catch(Exception exp){
			System.out.println("error: " + exp);
		}
	}
}
/**
 * Main function.
 * 
 * Creation date: (11/27/00 4:50:12 PM)
 * @param args java.lang.String[]
 */  
public static void main(String[] args) {

	try{
		System.out.println("Main() started at: " + new java.util.Date());
		/**
		 * Choose one of the scenarios by outcommenting the others
		 */
		//testRoundTripScenario();
		//testATMRetrieval();
		//testGetMoneyOneAccountScenario();
		testGUIScenario();
		
	} catch(Throwable ex) {
		System.out.println("An exception occured while testing:\n");
		ex.printStackTrace();
	}
	
	System.out.println("Main() ended at: " + new java.util.Date());
}
/**
 * Test creation and retrieval of an ATM.
 * 
 * @exception java.lang.Throwable The exception description.
 */
private static void testATMRetrieval() 
throws java.lang.Throwable {
	ATM tempATM; 

	System.out.println("Test retrieval of an ATM.\n");

	System.out.println("Make new ATM with key 123.\n");
	tempATM = new ATM(new ATM.ATMPK("123"));
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Find the ATM with key 123.\n");
	tempATM = ATM.findWithATMPK("123");
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

}
/**
 * This method will test the case of taking out money 
 * when only 1 account is associated to the Card.
 * 
 * @exception java.lang.Throwable The exception description.
 */
private static void testGetMoneyOneAccountScenario() 
throws java.lang.Throwable {
	ATM tempATM;
	Card tempCard;

	System.out.println("Doing the GetMoneyOneAccountScenario.\n");

	System.out.println("Find the ATM with key 123.\n");
	tempATM = ATM.findWithATMPK("123");
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("(Re)start the ATM.\n");
	tempATM.interrupt();	// the ATM might still be in a ready or in use state
	tempATM.initialize();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Create a Card with key 321.\n");
	tempCard = new Card(new Card.CardPK("321"), "Judy Poger", "321");
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Create a CheckingAccount with key 111, associate with card.\n");
	tempCard.associateBankAccount(new CheckingAccount(new BankAccount.BankAccountPK("111")));
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Insert the Card.\n");
	tempATM.insertCard(tempCard);
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Enter PIN = 321.\n");
	tempATM.enterPIN("321");
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Choose to withdraw money.\n");
	tempATM.chooseMoneyWithdrawal();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Ask to get 300.\n");
	tempATM.getMoney(new Money("300"));	
	System.out.println(tempATM);
	System.out.println(tempATM.getCurrentBankAccount());
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Stop this session.\n");
	tempATM.stop();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

}
/**
 * GUIScenario will start of with a list of all 
 * Card instances in the system. 
 * It allows choosing one of them to see its detail. 
 * The detail shows the owner of the card, 
 * the primary key and a list of associated 
 * BankAccounts.
 * From this list BankAccounts can be added or
 * deleted. Adding an accounts is accomplished by
 * showing a list of all BankAccounts to choose from.
 * This scenario also tests an invalid attempt to add
 * an account twice.
 * 
 * Creation date: (12/4/00 2:22:24 PM)
 */
private static void testGUIScenario() throws PersistenceException, InvalidPINException{
	Vector tempV;
	Card tempCard;
	Iterator tempI;
	
	System.out.println("Doing the GUI scenario.\n");

	createSomeCards();
	System.out.println("Get all cards currently in the system.\n");
	tempV = Card.getListOfAllCards();
	System.out.println(tempV);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Show all cards in a one string per card list.\n");
	tempI = tempV.iterator();
	while (tempI.hasNext()) {
		System.out.println(((Card) tempI.next()).toOneLineString());
	}
	System.out.println("______________________________________");
	System.out.println();
		
	System.out.println("Select the first card to work with.\n");
	tempCard = (Card) tempV.firstElement();
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Show list of all BankAccounts.\n");
	tempV = BankAccount.getListOfAllBankAccounts();
	System.out.println(tempV);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Show all accounts in a one string per account list.\n");
	tempI = tempV.iterator();
	while (tempI.hasNext()) {
		System.out.println(((BankAccount) tempI.next()).toOneLineString());
	}
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Select the first account and add it to the Card.\n");
	try{
		tempCard.associateBankAccount((BankAccount) tempV.firstElement());
	}
	catch(Exception exp){
		System.out.println("error: " + exp);
	}
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();
	
	//System.out.println("Remove the first account that is in the list of associated account, from the Card.\n");
	//tempCard.disassociateBankAccount((BankAccount) tempCard.getBankAccounts().firstElement());
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();
	
}
/**
 * RoundTripScenario will test a usual scenario for an ATM.
 * Get money from one of the accounts and look trxhistory afterwards.
 * 
 * Creation date: (11/29/00 4:10:55 PM)
 * @exception java.lang.Throwable The exception description.
 */
private static void testRoundTripScenario() 
throws java.lang.Throwable {
	ATM tempATM;
	Card tempCard;

	System.out.println("Doing the RoundTrip test.\n");

	System.out.println("Find the ATM with key 123.\n");
	tempATM = ATM.findWithATMPK("123");
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("(Re)start the ATM.\n");
	tempATM.interrupt();	// the ATM might still be in a ready or in use state
	tempATM.initialize();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Find the Card with key 124.\n");
	tempCard = Card.findWithCardPK("124");
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Insert the Card.\n");
	tempATM.insertCard(tempCard);
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Enter PIN = 124.\n");
	tempATM.enterPIN("124");
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("List the associated bankaccounts.\n");
	System.out.println("List of associated bankaccounts:" + tempATM.getListBankAccounts());
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Choose account first of associated accounts.\n");
	tempATM.chooseAccount((BankAccount) tempATM.getListBankAccounts().firstElement());
	System.out.println(tempATM);
	System.out.println(tempATM.getCurrentBankAccount());
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Choose to withdraw money.\n");
	tempATM.chooseMoneyWithdrawal();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Ask to get 100.\n");
	tempATM.getMoney(new Money("100"));	
	System.out.println(tempATM);
	System.out.println(tempATM.getCurrentBankAccount());
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("List of transactions.\n");
	System.out.println(tempATM.getTransactions().toString() + '\n');
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Stop this session.\n");
	tempATM.stop();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

}
}
