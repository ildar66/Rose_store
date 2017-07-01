package com.overstar.bank.atm.memory;

//package com.ibm.itso.sg245264.atm.memory;

/**
 * An instance of this gets thrown when a transfer would 
 * bring the balance lower then allowed.
 * 
 */
public abstract class ExceedLimitException 
extends TransactionAbortedException {
/**
 * ExceedLimitException constructor comment.
 * @param aMessage java.lang.String
 */
ExceedLimitException(String aMessage) {
	super(aMessage);
}
}
