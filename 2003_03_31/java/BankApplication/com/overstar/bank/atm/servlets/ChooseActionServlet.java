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
 
public class ChooseActionServlet extends javax.servlet.http.HttpServlet {
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
		out.println("<TITLE>ChooseActionServlet Error</TITLE>");
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
		out.println("<TITLE>ChooseActionServlet Error</TITLE>");
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
				String actionstr= request.getParameter("action");
				if ( actionstr != null) {
					//validate syntax of acct number
					if ( actionstr.equals("withdraw")){
						userATM.chooseMoneyWithdrawal();
					}
					else if ( actionstr.equals("history")){
						userATM.getTransactions();
					}
					else if ( actionstr.equals("changeacct")){
						userATM.getListBankAccounts();
					}
					else{
						throw new Exception("Invalid action request. The only valid actions are 'withdraw', 'history', and 'changeacct'");
					}
				}
			}
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
						  "/servlet/com.overstar.bank.atm.servlets.ShowATMServlet");
		dispatcher.forward(request, response);

		
}
}
