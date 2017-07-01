//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\DatabaseStatement.java

package com.ibm.db.base;

import java.sql.SQLException;
import java.sql.SQLWarning;

public abstract class DatabaseStatement 
{
   protected boolean isOpen;
   private static final String copyright;
   protected com.ibm.db.base.DatabaseQuerySpec qSpec;
   protected com.ibm.db.base.DatabaseConnection conn;
   
   /**
    * @roseuid 3E00403E01FF
    */
   public DatabaseStatement() 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E00403E00FA
    */
   public DatabaseStatement(com.ibm.db.base.DatabaseConnection arg0, com.ibm.db.base.DatabaseQuerySpec arg1) 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E00403E0209
    */
   public abstract void cancel() throws java.sql.SQLException;
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E00403E0259
    */
   public abstract void clearWarnings() throws java.sql.SQLException;
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E00403E02B3
    */
   public abstract void closeStatement() throws java.sql.SQLException;
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00403E0303
    */
   public abstract void execute() throws java.sql.SQLException, com.ibm.db.base.DataException;
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00403F0052
    */
   public abstract void execute(com.ibm.db.base.DatabaseRow arg0) throws java.sql.SQLException, com.ibm.db.base.DataException;
   
   /**
    * @return com.ibm.db.base.DatabaseConnection
    * @roseuid 3E00403F0228
    */
   protected com.ibm.db.base.DatabaseConnection getConnection() 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseQuerySpec
    * @roseuid 3E00403F02D3
    */
   protected com.ibm.db.base.DatabaseQuerySpec getQuerySpec() 
   {
    return null;
   }
   
   /**
    * @return java.sql.SQLWarning
    * @throws java.sql.SQLException
    * @roseuid 3E00403F0373
    */
   public abstract java.sql.SQLWarning getWarnings() throws java.sql.SQLException;
   
   /**
    * @param arg0
    * @return boolean
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040400035
    */
   public static boolean isCallStatement(java.lang.String arg0) throws com.ibm.db.base.DataException 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E0040400143
    */
   public boolean isOpen() 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @return boolean
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040400157
    */
   public static boolean isSelectStatement(java.lang.String arg0) throws com.ibm.db.base.DataException 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040400266
    */
   protected void setConnection(com.ibm.db.base.DatabaseConnection arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404002F2
    */
   protected void setIsOpen(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040400306
    */
   protected void setQuerySpec(com.ibm.db.base.DatabaseQuerySpec arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @roseuid 3E0040400392
    */
   public abstract void setTimeout(int arg0) throws java.sql.SQLException;
}
