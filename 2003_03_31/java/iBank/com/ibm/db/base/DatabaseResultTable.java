//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\DatabaseResultTable.java

package com.ibm.db.base;

import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.util.Vector;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class DatabaseResultTable extends com.ibm.db.base.DatabaseResultTableParent 
{
   private static final String copyright;
   protected Vector qSpecVector;
   protected int resultCount;
   protected int updateCount;
   protected boolean afterLastResult;
   protected boolean readOnly;
   private java.sql.PreparedStatement aStmt;
   protected java.util.Enumeration qSpecEnum;
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @param arg3
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E004023035F
    */
   public DatabaseResultTable(com.ibm.db.base.DatabaseConnection arg0, com.ibm.db.base.DatabaseQuerySpec arg1, int arg2, boolean arg3) throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00402401B1
    */
   public void addQuerySpec(com.ibm.db.base.DatabaseQuerySpec arg0) 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E0040240234
    */
   public synchronized void cancel() throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E004024028E
    */
   public synchronized void closeStatement() throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402402DE
    */
   public void execute() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E004025002C
    */
   public void execute(com.ibm.db.base.DatabaseRow arg0) throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402501D1
    */
   public void executeUpdate() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402502FD
    */
   public void executeUpdate(com.ibm.db.base.DatabaseRow arg0) throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402600CE
    */
   private void fetchResultSet() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3E00402601FA
    */
   public boolean getAfterLastResult() 
   {
    return true;
   }
   
   /**
    * @return java.lang.String
    * @throws java.sql.SQLException
    * @roseuid 3E0040260222
    */
   public String getCursorName() throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Object
    * @throws java.sql.SQLException
    * @roseuid 3E00402602AF
    */
   public Object getParameter(int arg0, com.ibm.db.base.DatabaseTypeField arg1) throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @return java.sql.PreparedStatement
    * @roseuid 3E00402603D1
    */
   private java.sql.PreparedStatement getStatement() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E0040270039
    */
   public int getUpdateCount() 
   {
    return 0;
   }
   
   /**
    * @return java.sql.SQLWarning
    * @throws java.sql.SQLException
    * @roseuid 3E0040270061
    */
   public java.sql.SQLWarning getWarnings() throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @return boolean
    * @roseuid 3E0040270101
    */
   protected boolean hasResultSet() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E004027010B
    */
   public boolean isReadOnlyResultSet() 
   {
    return true;
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040270115
    */
   public void nextResult() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040270242
    */
   private void prepare(int arg0) throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E0040270378
    */
   public void refresh() throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E00402800C7
    */
   public void refresh(com.ibm.db.base.DatabaseRow arg0) throws java.sql.SQLException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @throws java.sql.SQLException
    * @roseuid 3E0040280275
    */
   private void registerOutputParameters() throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @roseuid 3E00402802C5
    */
   private void setInputValues(com.ibm.db.base.DatabaseRow arg0) throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040280398
    */
   protected void setQuerySpec(com.ibm.db.base.DatabaseQuerySpec arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E0040290046
    */
   private void setStatement(java.sql.PreparedStatement arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.sql.SQLException
    * @roseuid 3E00402900A0
    */
   public void setTimeout(int arg0) throws java.sql.SQLException 
   {
    
   }
}
