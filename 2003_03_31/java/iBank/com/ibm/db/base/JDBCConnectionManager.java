//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\JDBCConnectionManager.java

package com.ibm.db.base;

import java.util.Hashtable;
import java.util.Vector;
import java.sql.SQLException;

public class JDBCConnectionManager 
{
   private static Hashtable sqlTypeTable;
   private Hashtable connections;
   private Hashtable specs;
   private Vector drivers;
   private static final String copyright;
   static com.ibm.db.base.JDBCConnectionManager singleton;
   
   /**
    * @roseuid 3E00405100BC
    */
   public JDBCConnectionManager() 
   {
    
   }
   
   /**
    * @return java.util.Hashtable
    * @roseuid 3E00405100E4
    */
   private static Hashtable buildSQLTypeTable() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return com.ibm.db.base.DatabaseConnection
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040510134
    */
   protected synchronized com.ibm.db.base.DatabaseConnection connectUsingSpec(com.ibm.db.base.DatabaseConnectionSpec arg0) throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return boolean
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E0040510351
    */
   public synchronized boolean disconnectUsingSpec(com.ibm.db.base.DatabaseConnectionSpec arg0) throws java.sql.SQLException, com.ibm.db.base.DataException, java.lang.ClassNotFoundException 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @return com.ibm.db.base.DatabaseConnection
    * @roseuid 3E004052017B
    */
   public com.ibm.db.base.DatabaseConnection getConnectionAtAlias(java.lang.String arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return com.ibm.db.base.JDBCConnectionManager
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E0040520244
    */
   public static com.ibm.db.base.JDBCConnectionManager getJDBCConnectionManager(java.lang.String arg0) throws java.lang.ClassNotFoundException 
   {
    return null;
   }
   
   /**
    * @return java.util.Hashtable
    * @roseuid 3E0040520348
    */
   public static Hashtable getSQLTypeTable() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040520370
    */
   protected void registerConnection(com.ibm.db.base.DatabaseConnection arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E0040530014
    */
   protected void registerDriver(java.lang.String arg0) throws java.lang.ClassNotFoundException 
   {
    
   }
   
   /**
    * @return com.ibm.db.base.JDBCConnectionManager
    * @roseuid 3E00405300AB
    */
   public static com.ibm.db.base.JDBCConnectionManager singleton() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return boolean
    * @roseuid 3E004053012D
    */
   protected boolean unregisterConnection(com.ibm.db.base.DatabaseConnection arg0) 
   {
    return true;
   }
}
