//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\Statement.java

package com.ibm.db;

import com.ibm.db.base.DatabaseRow;
import com.ibm.db.base.DatabaseResultTable;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.SQLException;
import java.io.ObjectInputStream;
import java.io.IOException;

public abstract class Statement implements java.io.Serializable 
{
   protected boolean fieldExecuted;
   protected boolean fieldReadOnly;
   protected boolean fieldDistinctTypesEnabled;
   protected int fieldTimeout;
   protected boolean fieldValidateLOBs;
   protected transient boolean executingSQL;
   static final long serialVersionUID = 2146383263;
   private static final String copyright;
   protected com.ibm.db.DatabaseConnection fieldConnection;
   protected com.ibm.db.StatementMetaData fieldMetaData;
   protected com.ibm.db.base.DatabaseRow parameters;
   protected transient com.ibm.db.base.DatabaseResultTable rt;
   protected transient java.beans.PropertyChangeSupport propertyChange;
   protected transient com.ibm.db.StatementBeforeListener aStatementBeforeListener;
   protected transient com.ibm.db.StatementAfterListener aStatementAfterListener;
   static java.lang.Class class$array1$$byte;
   static java.lang.Class class$java$lang$Short;
   static java.lang.Class class$java$sql$Time;
   static java.lang.Class class$java$lang$String;
   static java.lang.Class class$java$lang$Float;
   static java.lang.Class class$java$sql$Timestamp;
   static java.lang.Class class$java$lang$Double;
   static java.lang.Class class$java$lang$Boolean;
   static java.lang.Class class$java$sql$Date;
   static java.lang.Class class$java$lang$Long;
   static java.lang.Class class$java$sql$Clob;
   static java.lang.Class class$java$lang$Integer;
   static java.lang.Class class$java$net$URL;
   static java.lang.Class class$java$io$InputStream;
   static java.lang.Class class$java$math$BigDecimal;
   
   /**
    * @roseuid 3E003FA0034C
    */
   public Statement() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA00356
    */
   public void addStatementAfterListener(com.ibm.db.StatementAfterListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA10113
    */
   public void addStatementBeforeListener(com.ibm.db.StatementBeforeListener arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA101A9
    */
   protected void applyTimeout() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA10267
    */
   public abstract void cancelExecution() throws com.ibm.db.DataException;
   
   /**
    * @return boolean
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA10326
    */
   protected boolean connect() throws com.ibm.db.DataException 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA103E4
    */
   protected void copyParameters(com.ibm.db.base.DatabaseRow arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA20088
    */
   public abstract void execute() throws com.ibm.db.DataException;
   
   /**
    * @throws java.lang.Throwable
    * @roseuid 3E003FA20146
    */
   protected void finalize() throws java.lang.Throwable 
   {
      super.finalize();    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA201A0
    */
   protected void fireAboutToExecute(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA20237
    */
   protected void fireExecuted(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @return com.ibm.db.DatabaseConnection
    * @roseuid 3E003FA202EB
    */
   public com.ibm.db.DatabaseConnection getConnection() 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.StatementMetaData
    * @roseuid 3E003FA2038B
    */
   public com.ibm.db.StatementMetaData getMetaData() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA30039
    */
   public Object getParameter(int arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA3013E
    */
   public Object getParameter(java.lang.String arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E003FA3026A
    */
   protected com.ibm.db.base.DatabaseRow getParameters() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA3030A
    */
   public String getParameterToString(int arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA40027
    */
   public String getParameterToString(java.lang.String arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E003FA4012B
    */
   public int getTimeout() 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA40135
    */
   protected static void handleSQLException(java.sql.SQLException arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3E003FA40258
    */
   public boolean isExecuted() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003FA40262
    */
   public boolean isReadOnly() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003FA4026C
    */
   public boolean isValidateLOBs() 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @throws java.io.IOException
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E003FA40276
    */
   private void readObject(java.io.ObjectInputStream arg0) throws java.io.IOException, java.lang.ClassNotFoundException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA40370
    */
   public void removeStatementAfterListener(com.ibm.db.StatementAfterListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA5001E
    */
   public void removeStatementBeforeListener(com.ibm.db.StatementBeforeListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @roseuid 3E003FA500C8
    */
   protected static String replaceHostVars(java.lang.String arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA50123
    */
   public void setConnection(com.ibm.db.DatabaseConnection arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA501C3
    */
   public synchronized void setMetaData(com.ibm.db.StatementMetaData arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA5024F
    */
   public void setParameter(int arg0, java.lang.Object arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA50349
    */
   public void setParameter(java.lang.String arg0, java.lang.Object arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA6007A
    */
   public void setParameterFromString(int arg0, java.lang.String arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FA60174
    */
   public void setParameterFromString(java.lang.String arg0, java.lang.String arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA60296
    */
   public void setReadOnly(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA602B5
    */
   public void setTimeout(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FA602D3
    */
   public void setValidateLOBs(boolean arg0) 
   {
    
   }
}
