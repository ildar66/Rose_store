package com.overstar.bank.servlets;

import java.text.*;
import com.overstar.bank.database.Document;
/**
 * Insert the type's description here.
 * Creation date: (21.08.2001 14:46:35)
 * @author: Shafigullin Ildar
 */
public class DocumentServlet extends javax.servlet.http.HttpServlet {
/**
 * Process incoming HTTP GET requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

	performTask(request, response);

}
/**
 * Process incoming HTTP POST requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

	performTask(request, response);

}
/**
 * Returns the requested parameter 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param parameterName The name of the parameter value to return 
 * @param checkRequestParameters when true, the request parameters are searched 
 * @param checkInitParameters when true, the servlet init parameters are searched 
 * @param isParameterRequired when true, an exception is thrown when the parameter cannot be found 
 * @param defaultValue The default value to return when the parameter is not found 
 * @return The parameter value 
 * @exception java.lang.Exception Thrown when the parameter is not found 
 */
public String getParameter(javax.servlet.http.HttpServletRequest request, String parameterName, boolean checkRequestParameters, boolean checkInitParameters, boolean isParameterRequired, String defaultValue) throws Exception {

	String[] parameterValues = null;
	String paramValue = null;

	// Get the parameter from the request object if necessary.
	if (checkRequestParameters)
	{
	  parameterValues = request.getParameterValues(parameterName);
	  if (parameterValues != null)
		   paramValue = parameterValues[0];
	}

	// Get the parameter from the servlet init parameters if
	// it was not in the request parameter.
	if ( (checkInitParameters) && (paramValue == null) )
	  paramValue = getServletConfig().getInitParameter(parameterName);

	// Throw an exception if the parameter was not found and it was required.
	// The exception will be caught by error processing and can be
	// displayed in the error page.
	if ( (isParameterRequired) && (paramValue == null) )
		 throw new Exception("Parameter " + parameterName + " was not specified.");

	// Set the return to the default value if the parameter was not found
	if (paramValue == null)
	  paramValue = defaultValue;

	return paramValue;
}
/**
 * Returns the servlet info string.
 */
public String getServletInfo() {

	return super.getServletInfo();

}
/**
 * Initializes the servlet.
 */
public void init() {
	// insert code to initialize the servlet here

}
/**
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

	javax.servlet.ServletContext sc;
	javax.servlet.RequestDispatcher rd;

	try
	{
		com.overstar.bank.database.Document document = null;

		// instantiate the bean.
		//document = (com.overstar.bank.database.Document) java.beans.Beans.instantiate(getClass().getClassLoader(),"com.overstar.bank.database.Document");

		//request.getSession(true).putValue("document", document);

		//запрос iClient из session:
		com.overstar.bank.database.IClient iClient = null;
		iClient = (com.overstar.bank.database.IClient) request.getSession(false).getValue("iClient"); 

		// To comply with Java Servlet v2.2 specification, please use the following
		// setAttribute(... , ...) method instead of putValue(... , ...).
		// request.getSession(true).setAttribute("document", document);
		if(iClient != null) {
		  //Инициализация BankAccount:
		  if (!getParameter(request, "account", true, true, true, null).equals("")) {
		    iClient.getBankAccount().initAccount((getParameter(request, "account" , true, true, true, null)));
		  }
		  //Инициализация документа:		  		
		  document = iClient.getBankAccount().getDocument();
			// Initialize the bean account property
		  if (!getParameter(request, "account", true, true, true, null).equals("")) {
		    document.setAccount((getParameter(request, "account" , true, true, true, null)));
		  }
		  // Initialize the bean date1String property
		  //if (!getParameter(request, "date1String", true, true, true, null).equals("")) {
		  // document.setDate1String((getParameter(request, "date1String", true, true, true, null)));
		  //}
		  // Initialize the bean date2String property
		  //if (!getParameter(request, "date2String", true, true, true, null).equals("")) {
		  //  document.setDate2String((getParameter(request, "date2String", true, true, true, null)));
		  //}
		  //Проверка и установка дат:
		  java.util.Date data1, data2 , curdate = null;		  
		  // Format the current time.
		  SimpleDateFormat formatter  = new SimpleDateFormat ("yyyy-MM-dd");
		  //Date currentTime_1 = new Date();
		  //String dateString = formatter.format(currentTime_1);
 
		  // Parse the previous string back into a Date.
		  //ParsePosition pos = new ParsePosition(0);
		  //Date currentTime_2 = formatter.parse(dateString, pos);
 		  
		  data1 =   formatter.parse( getParameter(request, "date1String", true, true, true, null) );
		  data2 =   formatter.parse( getParameter(request, "date2String", true, true, true, null) );
		  curdate = formatter.parse( iClient.getCurdate() );
		  document.setDates(data1, data2, iClient.getStartDate(), iClient.getFinishDate(), iClient.getBankAccount().getOpen_Date(), iClient.getBankAccount().getClose_Date(), curdate); 
		  // Initialize the bean includeDocuments property
		  if (!getParameter(request, "includeDocuments", true, true, false, "false").equals("")) {
		    document.setIncludeDocuments((getParameter(request, "includeDocuments", true, true, false, "false")));
//System.out.println("includeDocuments" + getParameter(request, "includeDocuments", true, true, false, "false"));
		  }
			// Initialize the bean includeRest property
		  if (!getParameter(request, "includeRest", true, true, false, "false").equals("")) {
		    document.setIncludeRest((getParameter(request, "includeRest", true, true, false, "false")));
//System.out.println("includeRest" + getParameter(request, "includeRest", true, true, false, "false"));
		  }  
		   // Invoke selectDocumentsExecute action on the bean.
		  document.selectDocumentsExecute(iClient.getBankAccount().getCurrentCodeCurrency());
		  document.selectRestExecute();
//System.out.println("from DocumentServlet: " + document.getRest());
		} 
		sc = getServletContext();
		rd = sc.getRequestDispatcher("/DocumentServletResults.jsp");
		rd.forward(request, response);

	}
	catch(Throwable theException)
	{
		// uncomment the following line when unexpected exceptions
		// are occuring to aid in debugging the problem.
		 theException.printStackTrace();
	}
}
/**
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask_original(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

	javax.servlet.ServletContext sc;
	javax.servlet.RequestDispatcher rd;

	try
	{
		com.overstar.bank.database.Document document = null;

		// instantiate the bean.
		document = (com.overstar.bank.database.Document) java.beans.Beans.instantiate(getClass().getClassLoader(),"com.overstar.bank.database.Document");

		request.getSession(true).putValue("document", document);

		// To comply with Java Servlet v2.2 specification, please use the following
		// setAttribute(... , ...) method instead of putValue(... , ...).
		// request.getSession(true).setAttribute("document", document);

		// Initialize the bean account property
		if (!getParameter(request, "account", true, true, true, null).equals("")) {
		  document.setAccount((getParameter(request, "account" , true, true, true, null)));
		}
		// Initialize the bean date1String property
		if (!getParameter(request, "date1String", true, true, true, null).equals("")) {
		  document.setDate1String((getParameter(request, "date1String", true, true, true, null)));
		}
		// Initialize the bean date2String property
		if (!getParameter(request, "date2String", true, true, true, null).equals("")) {
		  document.setDate2String((getParameter(request, "date2String", true, true, true, null)));
		}

		// Invoke selectDocumentsExecute action on the bean.
		document.selectDocumentsExecute();

		sc = getServletContext();
		rd = sc.getRequestDispatcher("/DocumentServletResults.jsp");
		rd.forward(request, response);

	}
	catch(Throwable theException)
	{
		// uncomment the following line when unexpected exceptions
		// are occuring to aid in debugging the problem.
		 theException.printStackTrace();
	}
}
}
