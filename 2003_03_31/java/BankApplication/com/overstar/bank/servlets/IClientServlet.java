package com.overstar.bank.servlets;

import com.overstar.bank.database.IClient;
/**
 * Insert the type's description here.
 * Creation date: (10.08.2001 17:44:33)
 * @author: Shafigullin Ildar
 */
public class IClientServlet extends javax.servlet.http.HttpServlet {
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
//java.io.PrintWriter	out = null;//для темпового вывода
	try
	{
//out = response.getWriter();//для темпового вывода
		com.overstar.bank.database.IClient iClient = null;

		// instantiate the bean.
		iClient = (com.overstar.bank.database.IClient) java.beans.Beans.instantiate(getClass().getClassLoader(),"com.overstar.bank.database.IClient");

		request.getSession(true).putValue("iClient", iClient);

		// To comply with Java Servlet v2.2 specification, please use the following
		// setAttribute(... , ...) method instead of putValue(... , ...).
		// request.getSession(true).setAttribute("iClient", iClient);

		// Initialize the bean name property
		if (!getParameter(request, "name", true, true, true, null).equals("")) {
		  iClient.setName((getParameter(request, "name", true, true, true, null)));
		}
		// Initialize the bean password property
		if (!getParameter(request, "password", true, true, true, null).equals("")) {
		  iClient.setPassword((getParameter(request, "password", true, true, true, null)));
		}

		// Invoke selectIClientExecute action on the bean.
		iClient.selectIClientExecute();
	    sc = getServletContext();	
		//проверка существует ли имя?
		if(iClient.getRowCount() != 1)
		  {
		    rd = sc.getRequestDispatcher("/NameIncorrect.jsp");
		    rd.forward(request, response);	
		  }		  
		//проверка пароля:
		if(!iClient.checkPassword())
		  {
		    rd = sc.getRequestDispatcher("/PasswordIncorrect.jsp");
		    rd.forward(request, response);	
		  }
		else  //все нормально:	
		  {
	     	//инициализация клиента:
	     	iClient.initClient();
	     	//запоминание текущей даты:
	     	iClient.selectCurdateExecute();
	     	//настройка счетов:
	     	iClient.getBankAccount().setClient(iClient.getPartyID());
			iClient.getBankAccount().selectAccountsExecute("0");
			
		    //rd = sc.getRequestDispatcher("/IClientServletResults.jsp");
		    rd = sc.getRequestDispatcher("/BankAccountsServletResults1.jsp");
		    rd.forward(request, response);
		  }
	}
	catch(Throwable theException)
	{
		// uncomment the following line when unexpected exceptions
	 	// are occuring to aid in debugging the problem.
//response.setContentType("text/plain");                         //для темпового вывода
//out.println("theException from IClientServlet: "+theException);//для темпового вывода
		 theException.printStackTrace();
	}
}
}
