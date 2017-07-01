/**
* This file was generated by IBM WebSphere Studio Version 3.5
* C:\WDT400\Studio35\BIN\GenerationStyleSheets\V3.5\JSP1.1\ServletModel\DatabaseServlet.xsl stylesheet was used to generate this file.
*
* 
*
*/ 
package com.overstar.bank.iclient;
// Imports
import com.ibm.servlet.*;
import com.ibm.webtools.runtime.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


// Imports for beans used by this servlet

import com.overstar.bank.iclient.SelectIClient2DBBean;


public class SelectIClient2 extends com.ibm.webtools.runtime.StudioPervasiveServlet implements Serializable

{

  /*****************************************************************************
  * Process incoming requests for information
  * 
  * @param request Object that encapsulates the request to the servlet
  * @param response Object that encapsulates the response from the servlet
  */
  public void performTask(HttpServletRequest request, HttpServletResponse response)
  {

	// Uncomment the following line to aid in debugging DB servlets.
	// This can help isolate problems when the servlet appears to be unable to make
	// a connection to the database. You must recompile, republish, and then shutdown and
	// restart the server for this change to take effect. 
	// java.sql.DriverManager.setLogStream(System.out);
  
	try 
	{

	  // instantiate the beans and store them so they can be accessed by the called page
	  com.overstar.bank.iclient.SelectIClient2DBBean SelectIClient2DBBean = new com.overstar.bank.iclient.SelectIClient2DBBean();      
	  setRequestAttribute("SelectIClient2DBBean", SelectIClient2DBBean, request);
	  

	  // Initialize the bean userID property from the parameters
	  SelectIClient2DBBean.setUserID(getParameter(request, "userID", true, true, false, null));

	  // Initialize the bean password optional property from the parameters
	  SelectIClient2DBBean.setPassword(getParameter(request, "password", true, true, false, null));
	  
	  // Initialize the bean URL property from the parameters
	  SelectIClient2DBBean.setURL(getParameter(request, "URL", true, true, false, null));

	  // Initialize the bean driver property from the parameters
	  SelectIClient2DBBean.setDriver(getParameter(request, "driver", true, true, false, null));
	  
	  // Initialize the bean dataSourceName optional property
	  SelectIClient2DBBean.setDataSourceName(getParameter(request, "dataSourceName", true, true, false, null));
	  
	  
	  // Call the execute action on the bean.
	  SelectIClient2DBBean.execute();
	  
	  // Call the output page. If the output page is not passed
	  // as part of the URL, the default page is called.
	  callPage(getPageNameFromRequest(request), request, response);
	}

	// handle com.ibm.webtools.runtime.NoDataException
	catch (com.ibm.webtools.runtime.NoDataException theException)
	{
	  try
	  {
		callPageNamed(getParameter(request, "com.ibm.webtools.runtime.NoDataException", true, true, false, "com.ibm.webtools.runtime.NoDataException"), request, response);
	  }
	  catch (Throwable e)
	  {
		handleError(request, response, theException);
	  }
	}

	catch (Throwable theException)
	{
	  // uncomment the following line when unexpected exceptions are occuring to aid in debugging the problem
	   theException.printStackTrace();

	  handleError(request, response, theException);
	}
	
  }    

}