package com.overstar.bank.atm.memory;

/**
 * Models identifiers for all objects in this package.
 * The class is based on the String class.
 * It also uses its implementations for hashing.
 * Class will be used as base for derived innerclasses
 * of the respective classes.
 * 
 */
class PrimaryKey {
	
/**
 * The class is based on the String class.
 */
private String id;

/**
 * Construct a new primary key.
 * This implementation uses the time on the computer to
 * create a new 'unique' id. 
 * NOTE: This is not bullet proof !
 * 
 * Creation date: (11/28/00 5:31:14 PM)
 */
public PrimaryKey() {
	id = Long.toString((new java.util.Date()).getTime());
}
/**
 * @param anId
 * @exception 
 * @roseuid 3A22977B0025
 */
	public PrimaryKey(String anId)
	{
		id = anId;
	}
/**
 * Uses the equals implementation of the underlying String.
 * Needed for use in HashMap.
 * 
 * Creation date: (11/28/00 4:17:42 PM)
 * @return boolean
 * @param anObject java.lang.Object
 */
public boolean equals(Object anObject) {
	try {
		return id.equals(((PrimaryKey) anObject).id);
	} catch(ClassCastException ex) {
		return false;
	}
}
/**
 * Return the ID.
 * 
 * Creation date: ()
 * @return java.lang.String
 */
public String getIdAsString() {
	return id;
}
/**
 * Uses the hashCode of the underlying String.
 * Needed for use in HashMap.
 * 
 * Creation date: ()
 * @return int
 */
public int hashCode() {
	return id.hashCode();
}
/**
 * Gives standard representation of an instance.
 *
 * @return String
 * @exception 
 */
 	public String toString() 
	{
		return ("PK = " + id);
	}
}
