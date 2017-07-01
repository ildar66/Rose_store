package com.overstar.bank.servlets;

import com.overstar.bank.database.BankAccount;
/**
 * Insert the type's description here.
 * Creation date: (15.08.2001 18:27:37)
 * @author: Shafigullin Ildar
 */
public class BankAccountsServlet extends javax.servlet.http.HttpServlet {
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
public void performTask(
	javax.servlet.http.HttpServletRequest request, 
	javax.servlet.http.HttpServletResponse response) {

	javax.servlet.ServletContext sc;
	javax.servlet.RequestDispatcher rd;
	
	try {
		//com.overstar.bank.database.BankAccount bankAccount = null;
		String code_currency = "";
		// instantiate the bean.
		//bankAccount = (com.overstar.bank.database.BankAccount) java.beans.Beans.instantiate(getClass().getClassLoader(),"com.overstar.bank.database.BankAccount");

		//request.getSession(true).putValue("bankAccount", bankAccount);

		//запрос iClient из session:
		com.overstar.bank.database.IClient iClient = null;
		iClient = (com.overstar.bank.database.IClient) request.getSession(false).getValue("iClient"); 

		// To comply with Java Servlet v2.2 specification, please use the following
		// setAttribute(... , ...) method instead of putValue(... , ...).
		// request.getSession(true).setAttribute("bankAccount", bankAccount);

		// Initialize the bean client property
		//if (!getParameter(request, "client", true, true, true, null).equals("")) {
		//  bankAccount.setClient(Integer.valueOf(getParameter(request, "client", true, true, true, null)).intValue());
		//}

		//Инициализация code_Currency:
		if (!getParameter(request, "code_Currency", true, true, true, null).equals("")) {
		    code_currency = getParameter(request, "code_Currency", true, true, true, null);
		}
		
		// Invoke selectAccountsExecute action on the bean.
		if (iClient != null) {
			//iClient.getBankAccount().setClient(iClient.getPartyID());//поставили в IClientServlet
			iClient.getBankAccount().selectAccountsExecute(code_currency);
		}

		sc = getServletContext();
		rd = sc.getRequestDispatcher("/BankAccountsServletResults1.jsp");
		rd.forward(request, response);

	} catch (Throwable theException) {
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
		com.overstar.bank.database.BankAccount bankAccount = null;

		// instantiate the bean.
		bankAccount = (com.overstar.bank.database.BankAccount) java.beans.Beans.instantiate(getClass().getClassLoader(),"com.overstar.bank.database.BankAccount");

		request.getSession(true).putValue("bankAccount", bankAccount);

		// To comply with Java Servlet v2.2 specification, please use the following
		// setAttribute(... , ...) method instead of putValue(... , ...).
		// request.getSession(true).setAttribute("bankAccount", bankAccount);

		// Initialize the bean client property
		if (!getParameter(request, "client", true, true, true, null).equals("")) {
		  bankAccount.setClient(Integer.valueOf(getParameter(request, "client", true, true, true, null)).intValue());
		}

		// Invoke selectAccountsExecute action on the bean.
		bankAccount.selectAccountsExecute();

		sc = getServletContext();
		rd = sc.getRequestDispatcher("/BankAccountsServletResults.jsp");
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
