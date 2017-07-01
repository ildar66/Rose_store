package com.overstar.bank.atm.servlets;

//package com.overstar.bank.atm.servlets;

import java.io.*;
/**
 * This servlet checks the parameter "cardnumber" and if
 * the number is valid, inserts the card into the ATM using the
 * business objects.
 */

import javax.servlet.*;
import javax.servlet.http.*;
//import com.overstar.bank.atm.memory.*;
import com.overstar.bank.atm.database.*;
 
public class ChooseAccountServlet extends javax.servlet.http.HttpServlet {
/**
 * Process incoming HTTP GET requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

	
	try{   performTask(request, response);
	}catch(Exception exp){
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		out.println("<HTML><HEAD>");
		out.println("<TITLE>ChooseAccountServlet Error</TITLE>");
		out.println("</HEAD><BODY>");
		out.println("<P>Error: " +  exp.getMessage());
		out.println("</P>");
		out.println("</BODY></HTML>");
	
		
	};

}
/**
 * Process incoming HTTP POST requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

	
	try{   performTask(request, response);
	}catch(Exception exp){
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		out.println("<HTML><HEAD>");
		out.println("<TITLE>ChooseAccountServlet Error</TITLE>");
		out.println("</HEAD><BODY>");
		out.println("<P>Error: " +  exp.getMessage());
		out.println("</P>");
		out.println("</BODY></HTML>");
	
		
	};

}
/**
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(HttpServletRequest request, HttpServletResponse response) throws Exception{

		
		HttpSession session = request.getSession(false);
		if ( session != null ){
			ATM userATM = (ATM)session.getValue("userATM");
			if (userATM != null ){

				String acctstr= request.getParameter("acct");
				if (acctstr != null){
					//validate syntax of acct number
					if ((acctstr.length() > 10) || (acctstr.length() <= 0)){
						throw new Exception("Invalid account number. Account number must be at least 1 digit but no more than 10.");
					}
					
					BankAccount useracct = BankAccount.findWithBankAccountPK(acctstr);
					userATM.chooseAccount(useracct);
				}
			}
		
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
						  "/servlet/com.overstar.bank.atm.servlets.ShowATMServlet");
		dispatcher.forward(request, response);

		
}
}
