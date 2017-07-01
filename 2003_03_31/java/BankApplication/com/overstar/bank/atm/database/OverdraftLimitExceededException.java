//Source file: C:\Program Files\Rational\Rose\Java\TestRose\OverdraftLimitExceededException.java


/**
 * An instance of this gets thrown when the balance of a CheckingAccount
 * would drop below the overdraft value when executing a transaction.
 */
public class OverdraftLimitExceededException 
extends ExceedLimitException 
{
   

/**
 * Constructor taking a description as argument.
 *
 * @param aDescriptionStr java.lang.String
 */
OverdraftLimitExceededException(String aMessage) {
	super(aMessage);
}
}