package com.overstar.dab;

import com.overstar.dab.EmployeeBean;
/**
 * Insert the type's description here.
 * Creation date: (09.07.2001 14:59:56)
 * @author: Shafigullin Ildar
 */
public class EmployeeServlet extends javax.servlet.http.HttpServlet {
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
	//System.out.println("into doPost");
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
		com.overstar.dab.EmployeeBean employeeBean = null;

		// instantiate the bean.
		employeeBean = (com.overstar.dab.EmployeeBean) java.beans.Beans.instantiate(getClass().getClassLoader(),"com.overstar.dab.EmployeeBean");

		request.setAttribute("employeeBean", employeeBean);

		sc = getServletContext();
		  
		// Initialize the bean username property
		if (!getParameter(request, "username", true, true, true, null).equals("")) {
		  employeeBean.setUsername((getParameter(request, "username", true, true, true, null)));
		}

		//проверка пароля:
	    if(!employeeBean.checkPassword(getParameter(request, "password", true, true, true, null)))
	      {
		    //System.out.println("Password incorrect!!!");
		    rd = sc.getRequestDispatcher("/PasswordIncorrect.jsp");
		    rd.forward(request, response);
		  }	
	      	
		// Invoke execute action on the bean.
		else 
		  {
		    employeeBean.execute();
			rd = sc.getRequestDispatcher("/EmployeeServletResults.jsp");
	        rd.forward(request, response);
		  }
	}
	catch(Throwable theException)
	{
		// uncomment the following line when unexpected exceptions
		// are occuring to aid in debugging the problem.
		// theException.printStackTrace();
	}
}
}
