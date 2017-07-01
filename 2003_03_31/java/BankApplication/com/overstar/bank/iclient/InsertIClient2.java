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

import com.overstar.bank.iclient.InsertIClient2DBBean;


public class InsertIClient2 extends com.ibm.webtools.runtime.StudioPervasiveServlet implements Serializable

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
	  com.overstar.bank.iclient.InsertIClient2DBBean InsertIClient2DBBean = new com.overstar.bank.iclient.InsertIClient2DBBean();      
	  setRequestAttribute("InsertIClient2DBBean", InsertIClient2DBBean, request);
	  

	  // Initialize the bean userID property from the parameters
	  InsertIClient2DBBean.setUserID(getParameter(request, "userID", true, true, false, null));

	  // Initialize the bean password optional property from the parameters
	  InsertIClient2DBBean.setPassword(getParameter(request, "password", true, true, false, null));
	  
	  // Initialize the bean URL property from the parameters
	  InsertIClient2DBBean.setURL(getParameter(request, "URL", true, true, false, null));

	  // Initialize the bean driver property from the parameters
	  InsertIClient2DBBean.setDriver(getParameter(request, "driver", true, true, false, null));
	  
	  // Initialize the bean dataSourceName optional property
	  InsertIClient2DBBean.setDataSourceName(getParameter(request, "dataSourceName", true, true, false, null));
	  
	  
	  // Initialize the bean partyID property from the parameters
	  
		InsertIClient2DBBean.setPartyID(getParameter(request, "partyID", true, true, true, null));
	  
	  
	  // Initialize the bean name property from the parameters
	  
		InsertIClient2DBBean.setName(getParameter(request, "name", true, true, true, null));
	  
	  
	  // Initialize the bean pass property from the parameters
	  
		InsertIClient2DBBean.setPass(getParameter(request, "pass", true, true, true, null));
	  
	  
	  // Call the execute action on the bean.
	  InsertIClient2DBBean.execute();
	  
	  // Call the output page. If the output page is not passed
	  // as part of the URL, the default page is called.
	  callPage(getPageNameFromRequest(request), request, response);
	}

	catch (Throwable theException)
	{
	  // uncomment the following line when unexpected exceptions are occuring to aid in debugging the problem
	   theException.printStackTrace();

	  handleError(request, response, theException);
	}
	
  }        

}