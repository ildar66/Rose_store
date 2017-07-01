package com.overstar.bank.atm.memory;

//package com.ibm.itso.sg245264.atm.memory;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\Card.java



import java.util.HashMap;
import java.util.Vector;

/**
 * This represents a real world 'plastic' Card.
 * A Person would use it to get Money from an ATM.
 * A Card instance is guarded with a PIN,
 * A Person can authenticate itself as owner of the Card
 * by providing this PIN.
 * A Card can give access to one or more BankAccounts (at least one).
 *
 * @see ATM
 * @see Money
 * @see BankAccount
 */
public class Card 
{
   private CardPK id;
   
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
 * Name of the owner of the Card.
 */
private java.lang.String owner = "<unknown>";

/**
 * This constructor will create a new instance
 * with the given primary key.
 *
 * @param anId com.ibm.itso.sg245264.ATM
 * @roseuid 3A22977A020E
 */
public Card(CardPK anId) {
	
	id = anId;
	
	allCards.put(anId, this);	// ATTENTION: This might silently override existing instance with given key...
}
/**
 * This constructor will create a new instance
 * with the given primary key and an owner.
 *
 * @param anId com.ibm.itso.sg245264.ATM
 * @param anOwner String Owner of the card.
 * @roseuid 3A22977A020E
 */
public Card(CardPK anId, String anOwner) {

	this(anId);
	setOwner(anOwner);
}
/**
 * Add the given BankAccount to the list of accounts 
 * accessible through this Card instance.
 * It will throw an exception when trying to 
 * associat the card with an account already in its list.
 * 
 * Creation date: (11/29/00 5:21:59 PM)
 * @param aBankAccount com.ibm.itso.sg245264.BankAccount
 * @exception IllegalStateException When removing the last account
 */
public void associateBankAccount(BankAccount aBankAccount) {
	Vector tempV = getBankAccounts();

	if (tempV.contains(aBankAccount)) {
		throw new IllegalStateException("The card is already associated with this account.");
	}
	tempV.addElement(aBankAccount);
	setBankAccounts(tempV);
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
throws IllegalStateException {
	Vector tempV = getBankAccounts();

	tempV.removeElement(aBankAccount);
	if (tempV.isEmpty()) {
		throw new IllegalStateException("A Card must at least have one BankAccount instance associated.");		
	}
	setBankAccounts(tempV);
}
/**
 * This finder will search for the Card with the given
 * primary key and return it. 
 * It will create a new Card with the given primary key 
 * if it didn't found an existing Card with that primary key.
 * That newly created Card will also be associated to
 * two newly created BankAccounts (one Checking and one Savings).
 *
 * Creation date: (11/22/00 5:12:16 PM)
 * @param anId CardPK Primary key
 * @return Card instance
 */  
public static Card findWithCardPK(CardPK anId) {
	Card tempCard;
	Vector tempAccountsV = new Vector();
	
	if((tempCard = (Card) allCards.get(anId)) == null) {
		// create new one
		tempCard = new Card(anId);
		// associate checking and savings account with the same PK as base
		tempAccountsV.addElement(new CheckingAccount(new BankAccount.BankAccountPK(anId.getIdAsString() + 'C')));
		tempAccountsV.addElement(new SavingsAccount(new BankAccount.BankAccountPK(anId.getIdAsString() + 'S')));
		tempCard.setBankAccounts(tempAccountsV);
	}
	
	return tempCard;
}
/**
 * Convenience method.
 *
 * Creation date: (11/22/00 5:12:16 PM)
 * @param anIdStr String Primary key string
 * @return Card instance
 */  
public static Card findWithCardPK(String anIdStr) 
{
	return findWithCardPK(new CardPK(anIdStr));
}
/**
 * Get (a copy of) the BankAccount instances 
 * associated to this Card
 * 
 * Creation date: (11/27/00 11:55:22 PM)
 * @return java.util.Vector
 */  
public Vector getBankAccounts() {
	if (bankAccounts == null) {
		bankAccounts = new Vector(0);	// lazy init.
	}
	return new Vector(bankAccounts);
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
 * Get the list of all the Cards currently in the system.
 * 
 * Creation date: (12/4/00 2:18:39 PM)
 * @return java.util.Vector
 */
public static Vector getListOfAllCards() {
	return new Vector(allCards.values());
}
/**
 * Get name of the owner of the Card.
 * 
 * Creation date: (11/30/00 11:00:25 PM)
 * @return java.lang.String
 */
public java.lang.String getOwner() {
	return owner;
}
/**
 * Test this class.
 * 
 * Creation date: (11/29/00 10:05:36 AM)
 * @param args java.lang.String[]
 */
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
		tempCard = findWithCardPK("123456");
		System.out.println(tempCard);
		System.out.println("______________________________________");
		System.out.println();

		System.out.println("Find Card with key 654321 (has to create new one with accounts).\n");
		tempCard = findWithCardPK("654321");
		System.out.println(tempCard);
		System.out.println("______________________________________");
		System.out.println();
			
		
	} catch(Throwable ex) {
		System.out.println("An exception occured while testing:\n");
		ex.printStackTrace();
	}
	
	System.out.println("Main() ended at: " + new java.util.Date());
}
/**
 * Set the associated BankAccount instances.
 * 
 * Creation date: (11/27/00 11:55:22 PM)
 * @param newBankAccounts java.util.Vector
 */
void setBankAccounts(Vector newBankAccounts) {
	bankAccounts = newBankAccounts;
}
/**
 * Set owner's name.
 * 
 * Creation date: (11/30/00 11:00:25 PM)
 * @param newOwner java.lang.String
 */
void setOwner(java.lang.String newOwner) {
	owner = newOwner;
}
/**
 * Returns a string representation usefull to
 * include in a list.
 * 
 * @return java.lang.String
 */
public String toOneLineString() {
	return  id.getIdAsString() + " owned by " + getOwner();
}
/**
 * Specific implementation for toString().
 * 
 * Creation date: (11/29/00 10:51:33 AM)
 * @return java.lang.String
 */
public String toString() {
	return "\nCard (" + id + ") owned by " + getOwner() + ".\n"
			+ "Associated BankAccounts:\n" + getBankAccounts() + "\n";
}
/**
 * Validate the PIN code in the procedure to 
 * authenticate the current Person as owner of the Card. 
 * This implementation expects the PIN to be the same a 
 * the primary key of the card in order to be valid. 
 * 
 * Creation date: (11/28/00 2:44:35 PM)
 * @param aPINStr java.lang.String
 * @exception com.ibm.itso.sg245264.InvalidPINException The PIN is invalid.
 */ 
void validatePIN(String aPINStr) 
throws InvalidPINException {
	if (!(getId().getIdAsString().equals(aPINStr))) {
		throw new InvalidPINException("The given PIN is not valid for this Card.");
	}
			
}
}
