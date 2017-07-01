package com.overstar.bank.atm.database;

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\ATM.java

import java.util.Vector;
import java.util.HashMap;

/**
 * This class models real world Automated Teller Machines.
 * As controller, it interacts with the other main classes
 * in this package.
 *
 * @see BankAccount
 * @see Card
 * @see Money
 * @see Transaction
 */
 
public class ATM 
{
	public static class ATMPK 
	extends PrimaryKey
	{
public ATMPK()
		{
				super();
		}
		public ATMPK(String anId)
		{
				super(anId);
		}
	}
	
	public static class ATMState 
	{
		private String stateDescription;
		
		private ATMState(String aStateDescription)
		{
			stateDescription = aStateDescription;
		}
		public synchronized String toString()
		{
			return stateDescription;
		}
	}

/**
 * This attribute contains the primary key of the ATM.
 * An ATM can be retrieved by searching on this value.
 */
private ATMPK id;

/**
 * This attribute contains the state of the ATM system.
 * See the two ATM state diagrams for more information.
 * We flattened the two diagrams: The 'In Use' state is not retained, instead we promote the substates of it to become states of the ATM.
 * ATMState is an innerclass, all possible values for 'state' are static fields on the ATM.
 */
private ATMState state;

private CardReader cardReader;
private CashDispenser cashDispenser;
private ATMAccount atmAccount;	
private BankAccount currentBankAccount = null;

/**
 * This allows a simple -persistenceless- implementation.
 */
private static HashMap allATMs =  new HashMap();
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState OUT_OF_ORDER = new ATMState("The ATM is out of order: OUT_OF_ORDER.");
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState READY_TO_USE = new ATMState("The card reader of the ATM is currently empty, but the ATM is ready to accept a card: READY_TO_USE.");
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState NOT_LOGGED_ON = new ATMState("The ATM has a card but Person didn't authenticated yet: NOT_LOGGED_ON.");
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState BANK_ACCOUNTS_LISTED = new ATMState("The ATM lists the bank accounts associated with the inserted card: BANK_ACCOUNTS_LISTED.");
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState BANK_ACCOUNT_CHOOSEN = new ATMState("The ATM is working with a current bank account specified: BANK_ACCOUNT_CHOOSEN.");
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState ASK_AMOUNT = new ATMState("The ATM is asking the person to specify the amount of money he wishes to withdraw: ASK_AMOUNT.");
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState DISPENSE_MONEY = new ATMState("The ATM is dispensing money: DISPENSE_MONEY.");
   
/**
 * This is one of the possible states of the ATM machine.
 */
public static ATMState TRX_HISTORY_LISTED = new ATMState("The ATM lists the transactions associated with the current bank account: TRX_HISTORY_LISTED.");



/**
 * This constructor will create a new instance
 * with the given primary key.
 * Its associated CardReader, CashDispenser, ATMAccount, ...
 * instances are also created.
 * The created ATM is in the OUT_OF_ORDER state.
 *
 * Creation date: (11/22/00 5:12:16 PM)
 * @param anId com.overstar.bank.atm.database.ATM
 */
public ATM(ATMPK anId) throws PersistenceException
{

	id = anId;
	state = OUT_OF_ORDER;
	cardReader = new CardReader();
	cashDispenser = new CashDispenser();

	atmAccount = (ATMAccount) ATMAccount.findWithBankAccountPK(
					new BankAccount.BankAccountPK(anId.getIdAsString()));
	System.out.println("---ATMPK");//
	allATMs.put(anId, this);	   // ATTENTION: This might silently override existing instance with given key...
}

/**
 * This finder will search for the ATM with the given
 * primary key and return it. 
 * It will create a new ATM with the given primary key 
 * if it didn't found an existing ATM with that primary key. 
 * The newly created ATM is in the OUT_OF_ORDER state.
 *
 * Creation date: (11/22/00 5:12:16 PM)
 * @param anId ATMPK Primary key
 * @return ATM instance
 */  
public static ATM findWithATMPK(ATMPK anId) throws PersistenceException
{
	ATM tempATM;
	if((tempATM = (ATM) allATMs.get(anId)) == null) {
		tempATM = new ATM(anId);
	}
	return tempATM;
}



/**
 * Specific implementation for toString().
 *
 * Creation date: (11/22/00 3:23:44 PM)
 * @return java.lang.String
 */
public String toString() {
	return ("\nATM (" + getId() + ").\n" 
				+ getState() + "\n"
				+ atmAccount + "\n");
}


/**
 * Interrupt the ATM.
 * Call this method to put the ATM OUT_OF_ORDER.
 *
 * Creation date: (11/22/00 5:21:15 PM)
 */  
public void interrupt() {
	setState(OUT_OF_ORDER);	// broader then specs, no testing, example purposes only
}



/**
 * Signal that the ATM has timed out.
 * NOTE: A better implementation of ATM would keep track of timeouts itself.
 * A call to this method makes the cardreader
 * eject the card and will make the ATM READY_TO_USE again.
 *
 * Creation date: (11/22/00 5:21:15 PM)
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 */  
public void timeout() 
throws java.lang.IllegalStateException {
	if (state == OUT_OF_ORDER) {
		throw new IllegalStateException("The ATM cannot time out when it's not in use...");
	} else {
		resetATM();
	}
}

	
/**
 * Enter the PIN code for the current Card.
 * If incorrect, an InvalidPINException is thrown.
 * NOTE: The case when there too many attempts to guess the PIN is not implemented.
 * 
 * Creation date: (11/27/00 11:30:22 PM)
 * @param aPINStr java.lang.String String representing a PIN code.
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 * @exception com.ibm.itso.sg245264.InvalidPINException PIN is invalid.
 */
public void enterPIN(String aPINStr) 
throws IllegalStateException, InvalidPINException, PersistenceException {
	if (state == NOT_LOGGED_ON) {
		getCardReader().getCurrentCard().validatePIN(aPINStr);	// can throw exception, state should remain NOT_LOGGED_ON
		Vector assAccountsV = getCardReader().getCurrentCard().getBankAccounts();
		if (assAccountsV.size() > 1) {
			setState(BANK_ACCOUNTS_LISTED);
		} else {
			if (assAccountsV.size() == 1) {
				setCurrentBankAccount((BankAccount) assAccountsV.firstElement());
				setState(BANK_ACCOUNT_CHOOSEN);
			} else {
				throw new RuntimeException("A Card instance must have at least one associated BankAccount instance.");
			}
		}
	} else {
		throw new IllegalStateException("The ATM cannot accept PIN when it's not in the NOT_LOGGED_ON state.");
	}
}

/**
 * Get the CardReader instance for this ATM.
 * 
 * Creation date: (11/27/00 10:15:22 PM)
 * @return com.ibm.itso.sg245264.CardReader
 */
protected CardReader getCardReader() {
	return cardReader;
}

/**
 * Return the current BankAccount instance.
 * 
 * Creation date: (11/28/00 12:05:45 AM)
 * @return com.ibm.itso.sg245264.BankAccount
 */    
public BankAccount getCurrentBankAccount() {
	return currentBankAccount;
}

/**
 * Get the primary key of the ATM.
 * 
 * Creation date: (11/27/00 10:42:36 PM)
 * @return com.ibm.itso.sg245264.ATM.ATMPK
 */   
public ATM.ATMPK getId() {
	return id;
}

/**
 * Get the state of the ATM.
 * 
 * Creation date: (11/27/00 10:42:36 PM)
 * @return com.ibm.itso.sg245264.ATM.ATMState
 */   
public ATM.ATMState getState() {
	return state;
}

/**
 * Insert the Card in the ATM.
 * 
 * Creation date: (11/27/00 9:45:49 PM)
 * @param aCard com.ibm.itso.sg245264.Card
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 * @exception com.ibm.itso.sg245264.InvalidCardException Card is not recognised.
 */   
public void insertCard(Card aCard) 
throws java.lang.IllegalStateException, InvalidCardException {
	if (state == READY_TO_USE) {
		getCardReader().acceptCard(aCard);	// can throw exception, state should remain READY_TO_USE
		setState(NOT_LOGGED_ON);
	} else {
		throw new IllegalStateException("The ATM cannot accept cards when it's not in the READY_TO_USE state.");
	}
}

/**
 * Insert the method's description here.
 * 
 * Creation date: (11/28/00 12:05:45 AM)
 * @param newCurrentBankAccount com.ibm.itso.sg245264.BankAccount
 */   
private void setCurrentBankAccount(BankAccount newCurrentBankAccount) {
	currentBankAccount = newCurrentBankAccount;
}

/**
 * Choose an account to work with.
 * 
 * Creation date: (11/29/00 12:47:26 AM)
 * @param aBankAccount com.ibm.itso.sg245264.BankAccount
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 */
public void chooseAccount(BankAccount aBankAccount) 
throws java.lang.IllegalStateException {
	if (state == BANK_ACCOUNTS_LISTED) {
		// NOTE: Not bullet proof: We assume the given account is one of the accounts associated with the current card...
		setCurrentBankAccount(aBankAccount);
		setState(BANK_ACCOUNT_CHOOSEN);
	} else {
		throw new IllegalStateException("You cannot choose an account when the ATM is not in the BANK_ACCOUNTS_LISTED state.");
	}
}
/**
 * Get the list of bank account that are associated with the current card.
 * 
 * Creation date: (11/29/00 12:29:42 AM)
 * @return java.util.Vector
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 */ 
public Vector getListBankAccounts() 
throws java.lang.IllegalStateException, PersistenceException {
	if ((state == BANK_ACCOUNT_CHOOSEN) 
		|| (state == TRX_HISTORY_LISTED)
		|| (state == DISPENSE_MONEY)) {
			setCurrentBankAccount(null);
			setState(BANK_ACCOUNTS_LISTED);
	}
	if (state == BANK_ACCOUNTS_LISTED) {
		return getCardReader().getCurrentCard().getBankAccounts();
	} else {
		throw new IllegalStateException("The ATM cannot list accounts when it's not in the BANK_ACCOUNTS_LISTED state.");
	}
}

/**
 * Resets the session variable(s).
 * 
 * Creation date: (11/29/00 12:58:31 AM)
 */ 
private void resetATM() {
	setCurrentBankAccount(null);
	getCardReader().ejectCurrentCard();
	setState(READY_TO_USE);	
}

/**
 * State setter.
 * 
 * Creation date: (11/29/00 1:03:57 AM)
 * @param newState com.ibm.itso.sg245264.ATM.ATMState
 */ 
private void setState(ATMState newState) {
	state = newState;
}

/**
 * Stop the ATM session.
 * A call to this method makes the cardreader
 * eject the card and will make the ATM READY_TO_USE again.
 *
 * Creation date: (11/22/00 5:21:15 PM)
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 */   
public void stop() 
throws java.lang.IllegalStateException {
	if ((state == OUT_OF_ORDER) || (state == READY_TO_USE)) {
		throw new IllegalStateException("You cannot stop, because there's nothing to stop.");
	} else {
		resetATM();
	}
}

/**
 * Test this class.
 * 
 * Creation date: (11/27/00 4:50:12 PM)
 * @param args java.lang.String[]
 */  
public static void main(String[] args) {

	try{
		System.out.println("Main() started at: " + new java.util.Date());
		testATMRetrieval();
		// testRoundTripScenario();
		// testGetMoneyOneAccountScenario();
		
	} catch(Throwable ex) {
		System.out.println("An exception occured while testing:\n");
		ex.printStackTrace();
	}
	
	System.out.println("Main() ended at: " + new java.util.Date());
}


/**
 * Choose to get money from the current bankaccount.
 *
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 */  
public void chooseMoneyWithdrawal() 
throws java.lang.IllegalStateException {
	if (state == BANK_ACCOUNT_CHOOSEN) {
		setState(ASK_AMOUNT);
	} else {
		throw new IllegalStateException("You cannot get money when the ATM is not in the BANK_ACCOUNT_CHOOSEN state.");
	}
}/**
 * Get the amount of Money specified, to be booked 
 * from current BankAccount of the ATM to its
 * associated ATMAccount.
 * 
 * Creation date: (11/29/00 1:43:13 AM)
 * @return com.ibm.itso.sg245264.Money
 * @param anAmount com.ibm.itso.sg245264.Money
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 * @exception com.ibm.itso.sg245264.TransactionAbortedException The transaction could not be committed.
 */      
public Money getMoney(Money anAmount) 
throws java.lang.IllegalStateException, TransactionAbortedException, PersistenceException  {
	if (state == ASK_AMOUNT) {
		Transaction.createTrx(anAmount, getCurrentBankAccount(), atmAccount);	// can throw exception, state should remain ASK_AMOUNT
		setState(DISPENSE_MONEY);
		cashDispenser.dispenseMoney(anAmount);
		setState(BANK_ACCOUNT_CHOOSEN);
		return anAmount;
	} else {
		throw new IllegalStateException("The ATM cannot give money when not in the ASK_AMOUNT state.");
	}
}/**
 * Get the list of transactions of the current bank account.
 * 
 * @return java.util.Vector
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 */        
public Vector getTransactions() 
throws java.lang.IllegalStateException {
	if ((state == BANK_ACCOUNT_CHOOSEN) || (state == TRX_HISTORY_LISTED)) {
		setState(TRX_HISTORY_LISTED);
		return getCurrentBankAccount().getTransactions();
	} else {
		throw new IllegalStateException("The ATM cannot give the transaction history when it's not in the BANK_ACCOUNT_CHOOSEN state.");
	}
}/**
 * This finder converts String to key and uses the other one. 
 * Convenience method of {@link #findWithATMPK()}.
 *
 * @param anIdStr String
 * @return ATM instance
 */      
public static ATM findWithATMPK(String anIdStr) throws PersistenceException
{
	return findWithATMPK(new ATMPK(anIdStr));
}/**
 * Start the ATM.
 * Call this method to make a new ATM READY_TO_USE.
 *
 * Creation date: (11/22/00 5:21:15 PM)
 * @exception java.lang.IllegalStateException The ATM is not in the proper state
 */       
public void initialize() 
throws java.lang.IllegalStateException {
	if (state == OUT_OF_ORDER) {
		resetATM();
	} else {
		throw new IllegalStateException("The ATM can only be initialized when it is in the OUT_OF_ORDER state.");
	}
}/**
 * Test retrieval of an ATM.
 * 
 * @exception java.lang.Throwable The exception description.
 */    
private static void testATMRetrieval() 
throws java.lang.Throwable {
	ATM tempATM;

	System.out.println("Test retrieval of an ATM.\n");

	System.out.println("Make new ATM with key 123.\n");
	tempATM = new ATM(new ATMPK("123"));
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Find the ATM with key 123.\n");
	tempATM = ATM.findWithATMPK("123");
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

}/**
 * Scenario1 will test the case of taking out money 
 * when only 1 account is associated to the Card.
 * 
 * Creation date: (11/29/00 4:10:55 PM)
 * @exception java.lang.Throwable The exception description.
 */    
private static void testGetMoneyOneAccountScenario() 
throws java.lang.Throwable {
	ATM tempATM;
	Card tempCard;

	System.out.println("Doing the GetMoneyOneAccountScenario.\n");

	System.out.println("Get the ATM with key 123.\n");
	tempATM = ATM.findWithATMPK("123");
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Create a Card with key 321.\n");
	tempCard = new Card(new Card.CardPK("321"));
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Create a CheckingAccount with key 111, associate with card.\n");
	tempCard.associateBankAccount(new CheckingAccount(new BankAccount.BankAccountPK("111")));
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Start the ATM.\n");
	tempATM.initialize();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Insert the Card.\n");
	tempATM.insertCard(tempCard);
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Enter PIN = 1234.\n");
	tempATM.enterPIN("1234");
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

}/**
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

	System.out.println("Find the Card with key 321.\n");
	tempCard = Card.findWithCardPK("321");
	System.out.println(tempCard);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Start the ATM.\n");
	tempATM.initialize();
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Insert the Card.\n");
	tempATM.insertCard(tempCard);
	System.out.println(tempATM);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Enter PIN = 1234.\n");
	tempATM.enterPIN("1234");
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

/**
 * This constructor will create a new instance
 * creating a primary key by itself.
 * Its associated CardReader, CashDispenser, ATMAccount, ...
 * instances are also created.
 * The created ATM is in the OUT_OF_ORDER state.
 */
public ATM() throws PersistenceException{

	this(new ATMPK());
}

/**
 * Return to the detail of the current account.
 * 
 * Creation date: (12/4/00 4:52:14 PM)
 * @exception java.lang.IllegalStateException The exception description.
 */
public void returnToAccountDetail() 
throws IllegalStateException {
	if (state == TRX_HISTORY_LISTED) {
		// NOTE: Not bullet proof: We assume the given account is one of the accounts associated with the current card...
		setState(BANK_ACCOUNT_CHOOSEN);
	} else {
		throw new IllegalStateException("You cannot return to the account when the ATM is not in the TRX_HISTORY_LISTED state.");
	}

}
}