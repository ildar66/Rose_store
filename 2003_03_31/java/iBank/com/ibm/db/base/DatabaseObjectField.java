//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\ibm\\db\\base\\DatabaseObjectField.java

package com.ibm.db.base;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DatabaseObjectField extends com.ibm.db.base.DatabaseTypeField 
{
   static final long serialVersionUID = 2147350003;
   private static final String copyright;
   protected java.lang.Class fieldClass;
   
   /**
    * @roseuid 3E00401B0335
    */
   public DatabaseObjectField() 
   {
    
   }
   
   /**
    * @param arg0
    * @roseuid 3E00401B030D
    */
   public DatabaseObjectField(java.lang.String arg0) 
   {
    
   }
   
   /**
    * @return java.lang.Class
    * @roseuid 3E00401B035D
    */
   public java.lang.Class getFieldClass() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Object
    * @throws java.sql.SQLException
    * @roseuid 3E00401B03D5
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
    * @roseuid 3E00401C00C9
    */
   public Object getObject(java.sql.ResultSet arg0, int arg1) throws java.sql.SQLException 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3E00401C0188
    */
   public int getSQLType() 
   {
    return 0;
   }
   
   /**
    * @param arg0
    * @roseuid 3E00401C0192
    */
   public void setFieldClass(java.lang.Class arg0) 
   {
    
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @throws java.sql.SQLException
    * @roseuid 3E00401C01EC
    */
   public void setFieldObject(java.lang.Object arg0, java.sql.PreparedStatement arg1, int arg2) throws java.sql.SQLException 
   {
    
   }
}
