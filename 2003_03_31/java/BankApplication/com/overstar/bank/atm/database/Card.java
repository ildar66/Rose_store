package com.overstar.bank.atm.database;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\Card.java



import java.util.HashMap;
import java.util.Vector;
import java.sql.*;

public class Card {

   private CardPK id;
   private Integer PIN;
   
/**
 * This constructor will create a new instance
 * with the given primary key.
 *
 * @param anId ATM
 * @roseuid 3A22977A020E
 */
public Card(CardPK anId) throws PersistenceException, InvalidPINException{
	
	this(anId, "unknown", "0");
	
	//allCards.put(anId, this);	// ATTENTION: This might silently override existing instance with given key...
}   

/**
 * PrimaryKey class to be used for instances of type Card.
 */ 
   public static class CardPK extends PrimaryKey
   {
	   public CardPK(String anId)
	   {
			super(anId);
	   }
   }
/**
 * This allows a simple -persistenceless- implementation.
 */
	private static HashMap allCards = new HashMap();	
	private java.util.Vector bankAccounts;
	
/**
 * This finder will search for the Card with the given
 * primary key and return it. 
 * It will create a new Card with the given primary key 
 * if it doesn't find an existing Card with that primary key.
 * That newly created Card will also be associated to
 * two newly created BankAccounts (one Checking and one Savings).
 *
 * Creation date: (11/22/00 5:12:16 PM)
 * @param anId CardPK Primary key
 * @return Card instance
 */  
public static Card findWithCardPK(CardPK anId) throws PersistenceException{
	try{	
		Card tempCard=new Card();
		com.ibm.ivj.db.uibeans.Select select = tempCard.getCardSelect();


		//Vector tempAccountsV = new Vector()
		select.setParameter("CARDNUM", anId.getIdAsString());


		select.execute(); 

		if( select.getRowCount() <= 0){
			throw new CardNotFoundException("The card with primary key " + anId.getIdAsString() + " was not found.");
		}
			
		select.firstRow();
		String tmpcardnum = (String)select.getColumnValue("CARDS.CARD_NUM");
		String tmpcardowner = (String)select.getColumnValue("CARDS.OWNER");
		String tmpPIN = (String)select.getColumnValue("CARDS.PIN");

		tempCard = new Card((new Card$CardPK(tmpcardnum)),tmpcardowner, tmpPIN );



		//if((tempCard = (Card) allCards.get(anId)) == null) {
		// create new one
		//tempCard = new Card(anId);
		// associate checking and savings account with the same PK as base
		//tempAccountsV.addElement(new CheckingAccount(new BankAccount.BankAccountPK(anId.getIdAsString() + 'C')));
		//tempAccountsV.addElement(new SavingsAccount(new BankAccount.BankAccountPK(anId.getIdAsString() + 'S')));
		//tempCard.setBankAccounts(tempAccountsV);
		//}

		return tempCard;
	}
	catch(Exception exp){
		throw new PersistenceException(exp.toString());
	}
}

public Card(CardPK anId, String anOwner, String aPIN) throws PersistenceException, InvalidPINException{
	
	id = anId;
	initOwner(anOwner);
	initPIN(aPIN);
	store();
	
}
	
/**
 * Get the primary key of the Card.
 * 
 * Creation date: (11/27/00 10:43:40 PM)
 * @return com.ibm.itso.sg245264.Card.CardPK
 */ 
public Card.CardPK getId() {
	return id;
}

	  
	
/**
 * Validate the PIN code in the procedure to
 * authenticate the current Person as owner of the Card.
 * 
 * Creation date: (11/28/00 2:44:35 PM)
 * @param aPINStr java.lang.String
 * @exception com.ibm.itso.sg245264.InvalidPINException The PIN is invalid.
 */ 
void validatePIN(String aPINStr) 
throws InvalidPINException {
	try {
		if (PIN.intValue() != Integer.parseInt(aPINStr)) {
			throw new InvalidPINException("The given PIN is not valid for this Card.");
		}
	} catch(NumberFormatException ex) {
		throw new InvalidPINException("The given PIN is not valid for this Card.");
	}
			
}											private com.ibm.ivj.db.uibeans.Modify ivjCardDelete = null;				private com.ibm.ivj.db.uibeans.Modify ivjCardDeleteAttached = null;				private com.ibm.ivj.db.uibeans.Modify ivjCardInsert = null;				private com.ibm.ivj.db.uibeans.Select ivjCardSelect = null;				private com.ibm.ivj.db.uibeans.Modify ivjCardUpdate = null;
	private java.lang.String owner = "<unknown>";/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Card() {
	super();
	initialize();
}
   
public Card(CardPK anId, String anOwner) throws PersistenceException, InvalidPINException{

	this(anId, anOwner, "0");
}/**
 * Add the given BankAccount to the list of accounts 
 * accessible through this Card instance.
 * It will throw an exception when trying to 
 * associat the card with an account already in its list.
 * 
 * Creation date: (11/29/00 5:21:59 PM)
 * @param aBankAccount BankAccount
 * @exception IllegalStateException When removing the last account
 */                    
public void associateBankAccount(BankAccount aBankAccount) throws IllegalStateException, PersistenceException{
	try{
	
			Vector tempV = getBankAccounts();

			if (tempV.contains(aBankAccount)) {
				throw new IllegalStateException("The card is already associated with this account.");
			}
			else{
				com.ibm.ivj.db.uibeans.Modify insert = this.getCardAssociateAcct();
				insert.setParameter("CARDNUM", this.getId().getIdAsString());
				insert.setParameter("ACCTNUM", aBankAccount.getId().getIdAsString());
				insert.execute();
				insert.commit();
			}

	}	
	catch(com.ibm.db.DataException exp){
		throw new PersistenceException(exp.toString());
	}

	
	}
	
	
	
	
	/**
 * Remove the given BankAccount from the list of accounts
 * associated with this Card instance.
 * This method will not complain if you want to remove
 * something that isn't there.
 * A card has to have at least one bank account, removing
 * the last one results in an IllegalStateException.
 * 
 * @param aBankAccount com.ibm.itso.sg245264.BankAccount
 * @exception IllegalStateException When removing the last account
 */                      
public void disassociateBankAccount(BankAccount aBankAccount) 
throws IllegalStateException, PersistenceException{
	try{
			// the method getBankAccounts goes to the database.
			Vector tempV = getBankAccounts();
			tempV.removeElement(aBankAccount);
			//Do not allow deletion if the account is the only one attached to this card.
			if (tempV.isEmpty()) {
				throw new IllegalStateException("A Card must at least have one BankAccount instance associated.");		
			}
			
			com.ibm.ivj.db.uibeans.Modify delete = this.getCardDeleteAttached();
			delete.setParameter("CARDNUM",this.getId().getIdAsString());
			delete.setParameter("ACCTNUM", aBankAccount.getId().getIdAsString());
			delete.execute();
			delete.commit();
	}
	catch(com.ibm.db.DataException exp){
		throw new PersistenceException(exp.toString());
	}
	
	//setBankAccounts(tempV);
}/**
 * Convenience method.
 *
 * Creation date: (11/22/00 5:12:16 PM)
 * @param anIdStr String Primary key string
 * @return Card instance
 */                       
public static Card findWithCardPK(String anIdStr) throws PersistenceException
{
	return findWithCardPK(new CardPK(anIdStr));
}/**
 * Get (a copy of) the BankAccount instances 
 * associated to this Card
 * 
 * Creation date: (11/27/00 11:55:22 PM)
 * @return java.util.Vector
 */             

public Vector getBankAccounts() throws PersistenceException {
		try{
				Vector tmpAllAccts = new Vector(0);	// lazy init.
				com.ibm.ivj.db.uibeans.Select select = this.getCardAcctSelect();
				
				select.setParameter("CARDNUM", this.getId().getIdAsString());
				select.execute();
				int numrecs  = select.getNumRows();
				if(numrecs > 0){	
					select.firstRow();
					for(int i=0; i< numrecs; i++){
						String tmpacctnum = (String)select.getColumnValue("CARDACCT.ACCT_NUM");
						BankAccount tmpbnkacct = BankAccount.findWithBankAccountPK(tmpacctnum);
						// add the new acct to the vector holding all accounts associated with
						// this card.
						tmpAllAccts.addElement(tmpbnkacct);
						select.nextRow();
					}
				}

				setBankAccounts(tmpAllAccts);
				
			//return new Vector(bankAccounts);
			return bankAccounts;
		}
		catch(com.ibm.db.DataException exp){
			throw new PersistenceException(exp.toString());
		}
	
}

 /**
 * Return the CardDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getCardDelete() {
	if (ivjCardDelete == null) {
		try {
			ivjCardDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjCardDelete.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardDeleteSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardDelete;
}

   
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getCardDeleteAttached() {
	if (ivjCardDeleteAttached == null) {
		try {
			ivjCardDeleteAttached = new com.ibm.ivj.db.uibeans.Modify();
			ivjCardDeleteAttached.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardDeleteAttatchedSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardDeleteAttached;
}

   
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getCardInsert() {
	if (ivjCardInsert == null) {
		try {
			ivjCardInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjCardInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardInsert;
}

/**
 * Return the CardSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getCardSelect() {
	if (ivjCardSelect == null) {
		try {
			ivjCardSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjCardSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardSelect;
}

/**
 * Return the CardUpdate property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getCardUpdate() {
	if (ivjCardUpdate == null) {
		try {
			ivjCardUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjCardUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardUpdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardUpdate;
}

   
public static Vector getListOfAllCards() throws PersistenceException, InvalidPINException{
	try{
	Vector allcards = new Vector(0);
	Card tempCard = new Card();

	com.ibm.ivj.db.uibeans.Select select = tempCard.getCardSelectAll();
		
	select.execute();
	int numrecs  = select.getNumRows();
	if ( numrecs <= 0 ){
		throw new CardNotFoundException("No cards were found.");
	}
		
	select.firstRow();
	for(int i=0; i< numrecs; i++){
			String tmpcardnum = (String)select.getColumnValue("CARDS.CARD_NUM");
			String tmpcardowner = (String)select.getColumnValue("CARDS.OWNER");
			String tmpPIN = (String)select.getColumnValue("CARDS.PIN");
	
			tempCard = new Card((new Card$CardPK(tmpcardnum)),tmpcardowner, tmpPIN );
			
			// add the new acct to the vector holding all accounts associated with
			// this card.
			allcards.addElement(tempCard);
			select.nextRow();
		}




	return allcards;
	}
	catch(com.ibm.db.DataException exp){
		throw new PersistenceException(exp.toString());
	}
	
}/**
 * Get name of the owner of the Card.
 * 
 * Creation date: (11/30/00 11:00:25 PM)
 * @return java.lang.String
 */                         
public java.lang.String getOwner() throws PersistenceException, InvalidPINException{
	load();
	return owner;
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
}
   
public static void main(String[] args) {
	Card tempCard;

	try{
		System.out.println("Main() started at: " + new java.util.Date());
		System.out.println("Doing simple create/find test.\n");

		System.out.println("Make new Card with key 123456.\n");
		tempCard = new Card(new Card.CardPK("123456"));
		System.out.println(tempCard);
		System.out.println("______________________________________");
		System.out.println();

		System.out.println("Find Card with key 123456.\n");
		//tempCard = findWithCardPK("123456");
		System.out.println(tempCard);
		System.out.println("______________________________________");
		System.out.println();

		System.out.println("Find Card with key 654321 (has to create new one with accounts).\n");
		//tempCard = findWithCardPK("654321");
		System.out.println(tempCard);
		System.out.println("______________________________________");
		System.out.println();
			
		
	} catch(Throwable ex) {
		System.out.println("An exception occured while testing:\n");
		ex.printStackTrace();
	}
	
	System.out.println("Main() ended at: " + new java.util.Date());
}/**
 * Set the associated BankAccount instances.
 * 
 * Creation date: (11/27/00 11:55:22 PM)
 * @param newBankAccounts java.util.Vector
 */         
private void setBankAccounts(Vector newBankAccounts) {
	bankAccounts = newBankAccounts;
}

/**
 * Set owner's name.
 * 
 * Creation date: (11/30/00 11:00:25 PM)
 * @param newOwner java.lang.String
 */
void setOwner(java.lang.String newOwner) throws PersistenceException, InvalidPINException {
	owner = newOwner;
	store();
}/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */          
public String toOneLineString() throws PersistenceException, InvalidPINException {
	return  id.getIdAsString() + " owned by " + getOwner();
}/**
 * Specific implementation for toString().
 * 
 * Creation date: (11/29/00 10:51:33 AM)
 * @return java.lang.String
 */         
public String toString() {
	return "\nCard (" + id + ")" + ".\n";
		//	+ "Associated BankAccounts:\n" + getBankAccounts() + "\n";
}			private com.ibm.ivj.db.uibeans.Select ivjCardAcctSelect = null;			private com.ibm.ivj.db.uibeans.Modify ivjCardAssociateAcct = null;
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getCardAcctSelect() {
	if (ivjCardAcctSelect == null) {
		try {
			ivjCardAcctSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjCardAcctSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardAcctSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardAcctSelect;
}


/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getCardAssociateAcct() {
	if (ivjCardAssociateAcct == null) {
		try {
			ivjCardAssociateAcct = new com.ibm.ivj.db.uibeans.Modify();
			ivjCardAssociateAcct.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardAssociateAcctSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardAssociateAcct;
}
protected String getPIN() throws PersistenceException, InvalidPINException{
	load();
	return PIN.toString();
}/**
 * Set owner's name.
 * 
 * Creation date: (11/30/00 11:00:25 PM)
 * @param newOwner java.lang.String
 */     
void setPIN(java.lang.String newPIN) throws PersistenceException, InvalidPINException{
	PIN =  new Integer(newPIN);
	store();
}/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */          

	private com.ibm.ivj.db.uibeans.Select ivjCardSelectAll = null;

/**
 * Insert the method's description here.
 * Creation date: (12/12/00 1:47:40 PM)
 * @return boolean
 */
protected boolean exists() throws PersistenceException{
	try{	
		com.ibm.ivj.db.uibeans.Select select = getCardSelect();
		
		select.setParameter("CARDNUM", getId().getIdAsString());
		select.execute();
		if (select.getNumRows() > 0) {
			return true;
		}
		else{
			return false;
		}
	}
	catch(Exception exp){
		throw new PersistenceException(exp.toString());
	}
}

/**
 * Return the CardSelectAll property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getCardSelectAll() {
	if (ivjCardSelectAll == null) {
		try {
			ivjCardSelectAll = new com.ibm.ivj.db.uibeans.Select();
			ivjCardSelectAll.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.CardDAB.conn1(), com.overstar.bank.atm.database.CardDAB.CardSelectAll()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjCardSelectAll;
}


/**
 * Set owner's name.
 * 
 * Creation date: (11/30/00 11:00:25 PM)
 * @param newOwner java.lang.String
 */
void initOwner(java.lang.String newOwner) {
	owner = newOwner;
}/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */    

void initPIN(java.lang.String newPIN) throws InvalidPINException{
	try{
		PIN =  new Integer(newPIN);
	}
	catch(Exception exp){
		throw new InvalidPINException("Invalid PIN format");
	}
		
}/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */      

/**
 * Insert the method's description here.
 * Creation date: (12/12/00 12:04:21 PM)
 */
protected void load() throws PersistenceException, InvalidPINException {
		try{
			com.ibm.ivj.db.uibeans.Select select = getCardSelect();
			select.setParameter("CARDNUM", getId().getIdAsString());


			select.execute();
			select.firstRow();
			String tmpcardnum = (String)select.getColumnValue("CARDS.CARD_NUM");
			String tmpcardowner = (String)select.getColumnValue("CARDS.OWNER");
			String tmpPIN = (String)select.getColumnValue("CARDS.PIN");
		

			initOwner(tmpcardowner);
			initPIN(tmpPIN);
		}catch(com.ibm.db.DataException exp){
			throw new PersistenceException(exp.toString());
		}
	
	}

public java.lang.String rtOwner() {
	return owner;
}/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */    

protected String rtPIN() {
	if (PIN != null){
		return PIN.toString();
	}
	else{
		return "";
	}
	
}/**
 * Set owner's name.
 * 
 * Creation date: (11/30/00 11:00:25 PM)
 * @param newOwner java.lang.String
 */       

/**
 * Insert the method's description here.
 * Creation date: (12/12/00 11:54:46 AM)
 */
private void store() throws PersistenceException, InvalidPINException {
	com.ibm.ivj.db.uibeans.Modify modify=null;
	
	try{	
			if (exists()){
				modify = getCardUpdate();
				modify.setParameter("CARD_NUM",this.getId().getIdAsString());

			}
			else{
				//record doesn't exist.
				modify = getCardInsert();
			}
				
				
			modify.setParameter("CARDNUM",this.getId().getIdAsString());
			modify.setParameter("PIN",rtPIN());
			modify.setParameter("OWNER",rtOwner());

			modify.execute();
			load();
				
	}
	catch(com.ibm.db.DataException exp){
		throw new PersistenceException(exp.toString());
	}
	

	}
}