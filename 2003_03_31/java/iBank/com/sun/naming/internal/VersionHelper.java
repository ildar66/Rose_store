//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\sun\\naming\\internal\\VersionHelper.java

package com.sun.naming.internal;

import java.io.InputStream;
import javax.naming.NamingEnumeration;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public abstract class VersionHelper 
{
   static final String PROPS[];
   public static final int INITIAL_CONTEXT_FACTORY = 0;
   public static final int OBJECT_FACTORIES = 1;
   public static final int URL_PKG_PREFIXES = 2;
   public static final int STATE_FACTORIES = 3;
   public static final int PROVIDER_URL = 4;
   public static final int DNS_URL = 5;
   public static final int CONTROL_FACTORIES = 6;
   private static com.sun.naming.internal.VersionHelper helper;
   
   /**
    * @roseuid 3E00410E038E
    */
   VersionHelper() 
   {
    
   }
   
   /**
    * @return java.lang.ClassLoader
    * @roseuid 3E00410E03B7
    */
   abstract java.lang.ClassLoader getContextClassLoader();
   
   /**
    * @param arg0
    * @return java.io.InputStream
    * @roseuid 3E00410F0047
    */
   abstract java.io.InputStream getJavaHomeLibStream(java.lang.String arg0);
   
   /**
    * @param arg0
    * @return java.lang.String
    * @roseuid 3E00410F00DD
    */
   abstract String getJndiProperty(int arg0);
   
   /**
    * @param arg0
    * @param arg1
    * @return java.io.InputStream
    * @roseuid 3E00410F012D
    */
   abstract java.io.InputStream getResourceAsStream(java.lang.Class arg0, java.lang.String arg1);
   
   /**
    * @param arg0
    * @param arg1
    * @return javax.naming.NamingEnumeration
    * @throws java.io.IOException
    * @roseuid 3E00410F0213
    */
   abstract javax.naming.NamingEnumeration getResources(java.lang.ClassLoader arg0, java.lang.String arg1) throws java.io.IOException;
   
   /**
    * @param arg0
    * @return java.net.URL[]
    * @throws java.net.MalformedURLException
    * @roseuid 3E00410F0322
    */
   protected static java.net.URL[] getUrlArray(java.lang.String arg0) throws java.net.MalformedURLException 
   {
    return null;
   }
   
   /**
    * @return com.sun.naming.internal.VersionHelper
    * @roseuid 3E0041100020
    */
   public static com.sun.naming.internal.VersionHelper getVersionHelper() 
   {
    return null;
   }
   
   /**
    * @param arg0
    * @return java.lang.Class
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E004110008E
    */
   public abstract java.lang.Class loadClass(java.lang.String arg0) throws java.lang.ClassNotFoundException;
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Class
    * @throws java.lang.ClassNotFoundException
    * @roseuid 3E004110016B
    */
   abstract java.lang.Class loadClass(java.lang.String arg0, java.lang.ClassLoader arg1) throws java.lang.ClassNotFoundException;
   
   /**
    * @param arg0
    * @param arg1
    * @return java.lang.Class
    * @throws java.lang.ClassNotFoundException
    * @throws java.net.MalformedURLException
    * @roseuid 3E00411002A1
    */
   public abstract java.lang.Class loadClass(java.lang.String arg0, java.lang.String arg1) throws java.lang.ClassNotFoundException, java.net.MalformedURLException;
}
