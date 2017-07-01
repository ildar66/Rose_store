//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\SelectResult.java

package com.ibm.db;

import com.ibm.db.base.DatabaseRow;
import com.ibm.db.base.DatabaseResultTable;
import java.beans.PropertyChangeSupport;
import java.util.Vector;
import java.beans.PropertyChangeListener;
import java.util.Enumeration;
import java.beans.PropertyChangeEvent;
import com.ibm.db.base.DatabaseTypeField;
import com.ibm.db.base.DatabaseQuerySpec;
import java.io.ObjectInputStream;
import java.io.IOException;

public class SelectResult extends com.ibm.db.StatementResult 
{
   protected int fieldCurrentRow;
   protected int fieldCurrentRowInCache;
   protected int fieldNumPacketsInCache;
   protected int fieldNumRowsInCache;
   protected Vector rows;
   protected transient Vector changes;
   protected transient boolean dataChangesPending;
   protected transient boolean moreRows;
   protected transient boolean previousRows;
   protected transient int fetchDirection;
   protected transient boolean leavingRow;
   protected transient boolean nextOrPrev;
   protected boolean deferUpdates;
   private static final long serialVersionUID = -26267140;
   private static final String copyright;
   protected com.ibm.db.SelectStatement statement;
   protected com.ibm.db.StatementMetaData metaData;
   protected com.ibm.db.base.DatabaseRow columnDefaults;
   protected transient com.ibm.db.base.DatabaseResultTable singleRowResult;
   protected transient com.ibm.db.base.DatabaseResultTable currentStatement;
   protected transient java.beans.PropertyChangeSupport propertyChange;
   protected transient com.ibm.db.StatementResultValueChangeListener aStatementResultValueChangeListener;
   static java.lang.Class class$array1$$byte;
   static java.lang.Class class$java$lang$Short;
   static java.lang.Class class$java$sql$Time;
   static java.lang.Class class$java$lang$String;
   static java.lang.Class class$java$lang$Float;
   static java.lang.Class class$java$sql$Timestamp;
   static java.lang.Class class$java$net$URL;
   static java.lang.Class class$java$lang$Double;
   static java.lang.Class class$java$lang$Boolean;
   static java.lang.Class class$java$lang$Long;
   static java.lang.Class class$java$sql$Date;
   static java.lang.Class class$java$lang$Integer;
   static java.lang.Class class$java$sql$Clob;
   static java.lang.Class class$java$io$InputStream;
   static java.lang.Class class$java$sql$Blob;
   static java.lang.Class class$java$math$BigDecimal;
   
   /**
    * @roseuid 3E003F7600C1
    */
   public SelectResult() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F76002B
    */
   public SelectResult(com.ibm.db.SelectStatement arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F7600CB
    */
   public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F76012F
    */
   public void addStatementResultValueChangeListener(com.ibm.db.StatementResultValueChangeListener arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7601BB
    */
   protected void apply() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F760279
    */
   protected void applyDelete(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F77002C
    */
   protected void applyInsert(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F77016C
    */
   protected void applyLock(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7702A3
    */
   protected void applyUpdate(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7703E3
    */
   public void cancelAction() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7800B0
    */
   protected void checkConnection() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F78016E
    */
   public synchronized void close() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F78022C
    */
   protected void closeInternal(boolean arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7802F4
    */
   public synchronized void closeResult() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @return java.util.Enumeration
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7803D1
    */
   public java.util.Enumeration columnNames() throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7900E3
    */
   public synchronized void deleteRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7901BF
    */
   protected String delimitName(java.lang.String arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @roseuid 3E003F7902C4
    */
   protected void disconnect() 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7902CE
    */
   protected void fetchNextPacket() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F790382
    */
   protected void fetchNextRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7A0058
    */
   protected void fetchPreviousPacket() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7A0117
    */
   protected void fetchPreviousRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws java.lang.Throwable
    * @roseuid 3E003F7A01D5
    */
   protected void finalize() throws java.lang.Throwable 
   {
      super.finalize();    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F7A0225
    */
   protected void fireAboutToSetColumnValue(java.beans.PropertyChangeEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F7A0293
    */
   protected void fireCacheRowsChanged(com.ibm.db.DataEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F7A031F
    */
   protected void fireColumnValueSet(java.beans.PropertyChangeEvent arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @roseuid 3E003F7A0384
    */
   protected void firePropertyChange(java.lang.String arg0, java.lang.Object arg1, java.lang.Object arg2) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7B0032
    */
   public void firstRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7B00F0
    */
   protected void flushCacheAndGoTo(int arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7B01D6
    */
   protected String generateCastColumn(com.ibm.db.base.DatabaseTypeField arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7B03AD
    */
   protected String generateCastParam(com.ibm.db.base.DatabaseTypeField arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7C0142
    */
   public String generateCompare(com.ibm.db.base.DatabaseTypeField arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E003F7C02B4
    */
   protected com.ibm.db.base.DatabaseRow generateHostVars(com.ibm.db.base.DatabaseQuerySpec arg0, com.ibm.db.base.DatabaseRow arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E003F7D00CB
    */
   protected com.ibm.db.base.DatabaseRow generateInsertHostVars(com.ibm.db.base.DatabaseQuerySpec arg0, com.ibm.db.base.DatabaseRow arg1) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return com.ibm.db.base.DatabaseQuerySpec
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7D0279
    */
   protected com.ibm.db.base.DatabaseQuerySpec generateInsertSpec(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7E005E
    */
   protected String generatePositionedDeleteSQL() throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E003F7E0159
    */
   protected com.ibm.db.base.DatabaseRow generatePositionedUpdateHostVars(com.ibm.db.base.DatabaseQuerySpec arg0, com.ibm.db.base.DatabaseRow arg1, com.ibm.db.base.DatabaseRow arg2) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return com.ibm.db.base.DatabaseQuerySpec
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7E03C5
    */
   protected com.ibm.db.base.DatabaseQuerySpec generatePositionedUpdateSpec(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return com.ibm.db.base.DatabaseQuerySpec
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F7F01B4
    */
   protected com.ibm.db.base.DatabaseQuerySpec generateSearchedDeleteSpec(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @return com.ibm.db.base.DatabaseRow
    * @roseuid 3E003F7F0381
    */
   protected com.ibm.db.base.DatabaseRow generateSearchedUpdateHostVars(com.ibm.db.base.DatabaseQuerySpec arg0, com.ibm.db.base.DatabaseRow arg1, com.ibm.db.base.DatabaseRow arg2) 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return com.ibm.db.base.DatabaseQuerySpec
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8001D4
    */
   protected com.ibm.db.base.DatabaseQuerySpec generateSearchedUpdateSpec(com.ibm.db.StatementResultRow arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.base.DatabaseQuerySpec
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8003A0
    */
   protected com.ibm.db.base.DatabaseQuerySpec generateSelectSpec(int arg0, com.ibm.db.base.DatabaseRow arg1) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return com.ibm.db.base.DatabaseQuerySpec
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F810199
    */
   protected com.ibm.db.base.DatabaseQuerySpec generateSelectSpec(com.ibm.db.base.DatabaseRow arg0, boolean arg1) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F81037A
    */
   protected String generateTableName(boolean arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F820096
    */
   public Object getCacheValueAt(int arg0, int arg1) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @return int
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F820190
    */
   public int getColumnCount() throws com.ibm.db.DataException 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F82026D
    */
   public String getColumnName(int arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F820367
    */
   public Object getColumnValue(int arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F830083
    */
   public Object getColumnValue(java.lang.String arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8301A6
    */
   public String getColumnValueToString(int arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.String
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8302AA
    */
   public String getColumnValueToString(java.lang.String arg0) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E003F8303AF
    */
   public int getCurrentRow() 
   {
    return 0;
   }
   
   /**
    * @return int
    * @roseuid 3E003F8303B9
    */
   public int getCurrentRowInCache() 
   {
    return 0;
   }
   
   /**
    * @return com.ibm.db.StatementResultRow
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8303E1
    */
   protected com.ibm.db.StatementResultRow getCurrentRowObject() throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E003F840125
    */
   public int getNumPacketsInCache() 
   {
    return 0;
   }
   
   /**
    * @return int
    * @roseuid 3E003F840139
    */
   public int getNumRowsInCache() 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return int
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F840143
    */
   protected int getPacketsToSkip(int arg0, int arg1) throws com.ibm.db.DataException 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Object
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F840233
    */
   protected Object getValueAndValidate(int arg0, int arg1) throws com.ibm.db.DataException 
   {
    return null;
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F84032E
    */
   protected synchronized void initialize() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F850004
    */
   public boolean isEnd() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F85000E
    */
   public boolean isMaxRowsReached() throws com.ibm.db.DataException 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3E003F8500C2
    */
   public boolean isRowLocked() 
   {
    return true;
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8500D6
    */
   public synchronized void lastRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F850195
    */
   public synchronized void lockRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F850249
    */
   public synchronized void newRow(boolean arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F850311
    */
   public synchronized void nextPacket() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8503BB
    */
   public void nextRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F86009C
    */
   protected synchronized void previousPacket() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F86015A
    */
   public void previousRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws java.io.IOException
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E003F860218
    */
   private void readObject(java.io.ObjectInputStream arg0) throws java.io.IOException, java.lang.ClassNotFoundException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F860309
    */
   public void refreshColumn(int arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8603D1
    */
   public void refreshRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F87009D
    */
   public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F87010B
    */
   public void removeStatementResultValueChangeListener(com.ibm.db.StatementResultValueChangeListener arg0) 
   {
    
   }
   
   /**
    * @roseuid 3E003F870198
    */
   protected synchronized void restoreChanges() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8701AC
    */
   protected void restoreDelete(com.ibm.db.StatementResultRow arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F870238
    */
   public void restoreRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8702F6
    */
   protected void restoreUpdate(com.ibm.db.StatementResultRow arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F870382
    */
   public synchronized void setColumnValue(int arg0, java.lang.Object arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F880095
    */
   public void setColumnValue(java.lang.String arg0, java.lang.Object arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8801AD
    */
   public void setColumnValueFromString(int arg0, java.lang.String arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8802A7
    */
   public void setColumnValueFromString(java.lang.String arg0, java.lang.String arg1) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8803C0
    */
   public synchronized void setCurrentRow(int arg0) throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8900A0
    */
   protected void setCurrentRowInCache(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E003F8900BE
    */
   public void setStatement(com.ibm.db.SelectStatement arg0) 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F890154
    */
   public void unlockRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F890209
    */
   public synchronized void updateRow() throws com.ibm.db.DataException 
   {
    
   }
   
   /**
    * @throws com.ibm.db.DataException
    * @roseuid 3E003F8902C7
    */
   protected void updateRowBeforeLeaving() throws com.ibm.db.DataException 
   {
    
   }
}
