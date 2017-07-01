//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\StatementResultRow.java

package com.ibm.db;

import com.ibm.db.base.DatabaseRow;
import java.io.Serializable;

class StatementResultRow implements java.io.Serializable 
{
   protected int status;
   protected int action;
   protected boolean inDatabase;
   protected int numberWhenChanged;
   public static final int UNCHANGED = 0;
   public static final int VALUE_SET = 1;
   public static final int NEW = 2;
   public static final int TRUNCATED = 3;
   public static final int NONE = 0;
   public static final int UPDATED = 1;
   public static final int DELETED = 2;
   public static final int INSERTED = 3;
   static final long serialVersionUID = -1311365;
   private static final String copyright;
   protected com.ibm.db.base.DatabaseRow currentColumnValues;
   protected com.ibm.db.base.DatabaseRow previousColumnValues;
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
   static java.lang.Class class$java$lang$Integer;
   static java.lang.Class class$java$math$BigDecimal;
   
   /**
    * @param arg0
    * @roseuid 3E003FD70215
    */
   public StatementResultRow(com.ibm.db.base.DatabaseRow arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003FD700DE
    */
   public StatementResultRow(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E003FD702BF
    */
   public static Object copyValue(java.lang.Object arg0) 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E003FD7030F
    */
   public int getAction() 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E003FD70337
    */
   public Object getColumnValue(int arg0) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E003FD70387
    */
   public Object getColumnValue(java.lang.String arg0) 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E003FD8000D
    */
   public com.ibm.db.base.DatabaseRow getCurrentColumnValues() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E003FD80090
    */
   protected int getNumberWhenChanged() 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @roseuid 3E003FD800B8
    */
   public Object getPreviousColumnValue(int arg0) 
   {
    return null;
   }
   
   /**
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E003FD80108
    */
   public com.ibm.db.base.DatabaseRow getPreviousColumnValues() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E003FD8018A
    */
   public int getStatus() 
   {
    return 0;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003FD80194
    */
   public boolean isInDatabase() 
   {
    return true;
   }
   
   /**
    * @roseuid 3E003FD8019E
    */
   public synchronized void reset() 
   {
    
   }
   
   /**
    * @roseuid 3E003FD801A8
    */
   public synchronized void restore() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FD801BC
    */
   public void setAction(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @throws com.ibm.db.base.DataException
    * @roseuid 3E003FD801D0
    */
   public synchronized void setColumnValue(int arg0, java.lang.Object arg1) throws com.ibm.db.DataException, com.ibm.db.base.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FD9000F
    */
   public void setInDatabase(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FD9002D
    */
   protected void setNumberWhenChanged(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003FD90041
    */
   public void setStatus(int arg0) 
   {
    
   }
}
