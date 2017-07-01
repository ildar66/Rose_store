//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\DatabaseTypeField.java

package com.ibm.db.base;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public abstract class DatabaseTypeField implements java.io.Serializable 
{
   public static final int INPUT = 1;
   public static final int INOUT = 2;
   public static final int OUTPUT = 4;
   public static final int DATALINK = 70;
   public static final int GRAPHIC = -8;
   public static final int VARGRAPHIC = -9;
   public static final int LONGVARGRAPHIC = -10;
   protected String name;
   protected int sqlType;
   protected int length;
   protected int scale;
   protected boolean searchable;
   protected int mode;
   protected String sqlTypeName;
   private static final long serialVersionUID = -196678;
   private static final String copyright;
   
   /**
    * @roseuid 3E0040490237
    */
   public DatabaseTypeField() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404901FB
    */
   public DatabaseTypeField(java.lang.String arg0) 
   {
    
   }
   
   /**
    * @return java.lang.Object
    * @throws java.lang.CloneNotSupportedException
    * @roseuid 3E004049025F
    */
   public Object clone() throws java.lang.CloneNotSupportedException 
   {
    return null;
   }
   
   /**
    * @return java.lang.Class
    * @roseuid 3E00404902F5
    */
   public abstract java.lang.Class getFieldClass();
   
   /**
    * @return int
    * @roseuid 3E004049034F
    */
   public int getLength() 
   {
    return 0;
   }
   
   /**
    * @return int
    * @roseuid 3E0040490359
    */
   public int getMode() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3E004049038B
    */
   public String getName() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Object
    * @throws java.sql.SQLException
    * @roseuid 3E00404903D1
    */
   public Object getObject(java.sql.CallableStatement arg0, int arg1) throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Object
    * @throws java.sql.SQLException
    * @roseuid 3E00404A00E4
    */
   public abstract Object getObject(java.sql.ResultSet arg0, int arg1) throws java.sql.SQLException;
   
   /**
    * @return int
    * @roseuid 3E00404A01C0
    */
   public int getScale() 
   {
    return 0;
   }
   
   /**
    * @return int
    * @roseuid 3E00404A01CA
    */
   public abstract int getSQLType();
   
   /**
    * @return java.lang.String
    * @roseuid 3E00404A01FC
    */
   public String getSQLTypeName() 
   {
    return null;
   }
   
   /**
    * @return boolean
    * @roseuid 3E00404A0224
    */
   public boolean isSearchable() 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @throws java.sql.SQLException
    * @roseuid 3E00404A0238
    */
   public abstract void setFieldObject(java.lang.Object arg0, java.sql.PreparedStatement arg1, int arg2) throws java.sql.SQLException;
   
   /**
    * @param arg0
    * @roseuid 3E00404A031F
    */
   public void setLength(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404A033D
    */
   public void setMode(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404A0351
    */
   public void setName(java.lang.String arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @throws java.sql.SQLException
    * @roseuid 3E00404A038D
    */
   public void setObject(java.lang.Object arg0, java.sql.PreparedStatement arg1, int arg2) throws java.sql.SQLException 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404B0095
    */
   public void setScale(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404B00B3
    */
   public void setSearchable(boolean arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404B00D1
    */
   public void setSQLType(int arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00404B00EF
    */
   public void setSQLTypeName(java.lang.String arg0) 
   {
    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3E00404B0149
    */
   public String toString() 
   {
    return null;
   }
}
