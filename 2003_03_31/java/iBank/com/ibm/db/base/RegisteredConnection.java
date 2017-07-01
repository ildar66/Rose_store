//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\RegisteredConnection.java

package com.ibm.db.base;


class RegisteredConnection 
{
   int registeredCount;
   private static final String copyright;
   com.ibm.db.base.DatabaseConnection connection;
   
   /**
    * @param arg0
    * @roseuid 3E00405600B9
    */
   public RegisteredConnection(com.ibm.db.base.DatabaseConnection arg0) 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3E004056013B
    */
   protected boolean decrementRegisteredCount() 
   {
    return true;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseConnection
    * @roseuid 3E0040560163
    */
   protected com.ibm.db.base.DatabaseConnection getConnection() 
   {
    return null;
   }
   
   /**
    * @roseuid 3E00405601E5
    */
   protected void incrementRegisteredCount() 
   {
    
   }
}
