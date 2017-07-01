package com.overstar.ildar.ibank.model;

/**
 * Models identifiers for all objects in this package.
 * The class is based on the String class.
 * It also uses its implementations for hashing.
 * Class will be used as base for derived innerclasses
 * of the respective classes.
 * 
 * Creation date: (04.09.2002 18:02:28)
 * @author: Shafigullin Ildar
 */
public class PrimaryKey {
    /**
     * The class is based on the String class.
     */
    private String id;
/**
 * Construct a new primary key.
 * This implementation uses the time on the computer to
 * create a new 'unique' id. 
 * NOTE: This is not bullet proof !
 *  */
public PrimaryKey() {
    id = Long.toString((new java.util.Date()).getTime());
}
/**
 * @param anId
 * 
 */
	public PrimaryKey(String anId)
	{
		id = anId;
	}
/**
 * Uses the equals implementation of the underlying String.
 * Needed for use in HashMap.
 *
 * Creation date: (04.09.2002 18:09:48)
 * @return boolean
 * @param anObject java.lang.Object
 */
public boolean equals(Object anObject) {
    try {
        return id.equals(((PrimaryKey) anObject).id);
    }
    catch (ClassCastException ex) {
        return false;
    }
}
/**
 * Return the ID.
 *
 * Creation date: (04.09.2002 18:12:58)
 * @return java.lang.String
 */
public String getIdAsString() {
    return id;
}
/**
 * Uses the hashCode of the underlying String.
 * Needed for use in HashMap.
 * 
 * Creation date: (04.09.2002 18:14:14)
 * @return int
 */
public int hashCode() {
	return id.hashCode();
}
/**
 * Gives standard representation of an instance.
 *
 * Creation date: (04.09.2002 18:17:46)
 * @return java.lang.String
 */
public String toString() {
    return ("PK = " + id);
}
}
