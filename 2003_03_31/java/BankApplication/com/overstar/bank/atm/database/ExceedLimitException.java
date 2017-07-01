//Source file: C:\Program Files\Rational\Rose\Java\TestRose\NotEnoughProvisionException.java

/**
 * An instance of this gets thrown when a transfer would 
 * bring the balance lower then allowed.
 */
abstract public class ExceedLimitException 
extends TransactionAbortedException 
{

ExceedLimitException(String aMessage) {
	   super(aMessage);
}
}