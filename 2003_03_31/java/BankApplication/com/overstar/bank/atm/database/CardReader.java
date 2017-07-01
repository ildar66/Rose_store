//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CardReader.java

package com.overstar.bank.atm.database;


//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CardReader.java

//Source file: C:\Program Files\Rational\Rose\Java\TestRose\com\ibm\itso\sg245264\CardReader.java

/**
 * CardReader models instances of the card reading device of an ATM.
 * To indicate what is happening, these instances write messages
 * on the console (OUT).
 */
class CardReader 
{
   
/**
 * Ejects current card.
 * NOTE: Crude implementation.
 *
 * @return void
 * @roseuid 3A19C440028B
 */
void ejectCurrentCard() {
	if (currentCard != null)
		System.out.println("CardReader: Ejecting  " + currentCard + "\n");
	currentCard = null;
}   
   
/**
 * Consumes current card.
 * NOTE: Crude implementation.
 *
 * @return void
 * @roseuid 3A19C48F0339
 */
void consumeCurrentCard() {
	if (currentCard != null)
		System.out.println("CardReader: Consuming  " + currentCard + "\n");
	currentCard = null;
}   

	private Card currentCard;

/**
 * Accept a Card inserted in the ATM,
 * or reject it by throwing an InvalidCardException.
 * This implementation simply checks if the primary key
 * of the Card represents a number (cardnumber).
 * 
 * Creation date: (11/27/00 10:35:01 PM)
 * @param aCard com.ibm.itso.sg245264.Card
 * @exception com.ibm.itso.sg245264.InvalidCardException Card is not recognised.
 */
void acceptCard(Card aCard) 
throws InvalidCardException {
	try {
		Integer.parseInt(aCard.getId().getIdAsString());
		currentCard = aCard;
		System.out.println("CardReader: Accepted  " + currentCard + "\n");
	} catch(NumberFormatException ex) {
		throw new InvalidCardException("The given Card is not recognised by this machine.");
	} catch(NullPointerException ex) {
		throw new InvalidCardException("The given Card is not recognised by this machine.");
	}
}

/**
 * Insert the method's description here.
 * 
 * Creation date: (11/27/00 11:47:48 PM)
 * @return com.ibm.itso.sg245264.Card
 */
Card getCurrentCard() {
	return currentCard;
}
}