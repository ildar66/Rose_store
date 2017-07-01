//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\sun\\naming\\internal\\ResourceManager.java

package com.sun.naming.internal;

import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.Context;

public final class ResourceManager 
{
   private static final String PROVIDER_RESOURCE_FILE_NAME;
   private static final String APP_RESOURCE_FILE_NAME;
   private static final String JRELIB_PROPERTY_FILE_NAME;
   private static final String listProperties[];
   private static final Hashtable propertiesCache;
   private static final Hashtable factoryCache;
   private static final Hashtable urlFactoryCache;
   private static final com.sun.naming.internal.VersionHelper helper;
   
   /**
    * @roseuid 3E00410B02FE
    */
   private ResourceManager() 
   {
    
   }
   
   /**
    * @return com.sun.naming.internal.VersionHelper
    * @roseuid 3E00410B0326
    */
   static com.sun.naming.internal.VersionHelper access$0() 
   {
    return null;
   }
   
   /**
    * @return java.util.Hashtable
    * @throws javax.naming.NamingException
    * @roseuid 3E00410B03C6
    */
   private static Hashtable getApplicationResources() throws javax.naming.NamingException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @return com.sun.naming.internal.FactoryEnumeration
    * @throws javax.naming.NamingException
    * @roseuid 3E00410C0074
    */
   public static com.sun.naming.internal.FactoryEnumeration getFactories(java.lang.String arg0, java.util.Hashtable arg1, javax.naming.Context arg2) throws javax.naming.NamingException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @param arg3
    * @param arg4
    * @return java.lang.Object
    * @throws javax.naming.NamingException
    * @roseuid 3E00410C01BF
    */
   public static Object getFactory(java.lang.String arg0, java.util.Hashtable arg1, javax.naming.Context arg2, java.lang.String arg3, java.lang.String arg4) throws javax.naming.NamingException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.util.Hashtable
    * @throws javax.naming.NamingException
    * @roseuid 3E00410C031D
    */
   public static Hashtable getInitialEnvironment(java.util.Hashtable arg0) throws javax.naming.NamingException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @param arg2
    * @param arg3
    * @return java.lang.String
    * @throws javax.naming.NamingException
    * @roseuid 3E00410C03D2
    */
   public static String getProperty(java.lang.String arg0, java.util.Hashtable arg1, javax.naming.Context arg2, boolean arg3) throws javax.naming.NamingException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.util.Hashtable
    * @throws javax.naming.NamingException
    * @roseuid 3E00410D010C
    */
   private static Hashtable getProviderResource(java.lang.Object arg0) throws javax.naming.NamingException 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return boolean
    * @roseuid 3E00410D01A2
    */
   private static boolean isListProperty(java.lang.String arg0) 
   {
    return true;
   }
   
   /**
    * @param arg0
    * @param arg1
    * @roseuid 3E00410D01D4
    */
   private static void mergeTables(java.util.Hashtable arg0, java.util.Hashtable arg1) 
   {
    
   }
}
