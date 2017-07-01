package com.overstar.bank.atm.servlets;

//package com.overstar.bank.atm.servlets;

/**
 * This servlet checks the parameter "cardnumber" and if
 * the number is valid, inserts the card into the ATM using the
 * business objects.
 */
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import com.overstar.bank.atm.memory.*;
import com.overstar.bank.atm.database.*;
 
public class ShowATMServlet extends javax.servlet.http.HttpServlet {
/**
 * Insert the method's description here.
 * Creation date: (12/21/00 4:06:51 PM)
 * @return ATM
 *
 * @param request Object that encapsulates the request to the servlet. It needed to retreive cookie and session. 
 * @param response Object that encapsulates the response from the servlet. This is needed to write a cookie.
 */
private ATM createOrRetreiveUserATM(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	String          cookie_value = null;
	String			atm_key= null;
	boolean         no_ATM_cookie_found = true;
	
	// Get the current session object, create one if necessary
	HttpSession session = request.getSession(true);
  
	// Try to retieve the userATM from the session.
	ATM userATM = (ATM)session.getValue("userATM");
   
	if (userATM == null){
		 //Check if our cookie is available in the browser.
		 
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        // cookies are present! loop through all the cookies looking 
	        // for the one we want. If we find the cookie we want,
	        // assign its value to atm_key.
	        for(int i=0; (i < cookies.length) && no_ATM_cookie_found; i++){
	            if ( cookies[i].getName().equals("ATM_KEY")){
	                atm_key = cookies[i].getValue();
	                no_ATM_cookie_found= false;
	     	   }
	        }
	    }

	
		if( no_ATM_cookie_found ) {		//  no ATM in session, no cookie
			// this means the user has never used the ATM application.
	System.out.println("undo new ATM");//		
			//userATM = new ATM();
	userATM = new ATM(new ATM$ATMPK("123")); //добавлено для инициализации машины №123
	System.out.println("after new ATM");//
			// put the ATM key into a cookie. That way we can recognize repeat
			// users even if they do not have a session. 
			Cookie atm_key_cookie= new Cookie("ATM_KEY" , userATM.getId().getIdAsString() );
	        atm_key_cookie.setPath("/"); // this is optional. It means that any servlet on this server can view the cookie. 
	        response.addCookie(atm_key_cookie);
	    }
		else{ //no ATM in session, have cookie
			// user is a returning user. 
  			userATM = new ATM(new ATM.ATMPK(atm_key));
		}
  		
  		if ( userATM.getState() == ATM.OUT_OF_ORDER){
  			userATM.initialize();
  		}
  		if ( userATM.getState() == ATM.READY_TO_USE) {
	  		session.putValue("userATM", userATM);
  		}
  		else{
	  		throw new Exception("Error: ATM is not ready to use. The current ATM state is: " + userATM.getState() );
  		}
	}

	
	return userATM;
}
/**
 * Insert the method's description here.
 * Creation date: (12/21/00 4:15:33 PM)
 * @return javax.servlet.RequestDispatcher
 */
private RequestDispatcher determineNextPage(ATM$ATMState curstate) {
	RequestDispatcher dispatcher= null ;
	
	if (curstate ==  ATM.OUT_OF_ORDER){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/OUT_OF_ORDER.jsp");
		//showOUT_OF_ORDERpage(request, response);
		}
	else if (curstate ==  ATM.READY_TO_USE){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/READY_TO_USE.jsp");
		//showREADY_TO_USEpage(request, response); 
		}
	else if (curstate ==  ATM.NOT_LOGGED_ON){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/NOT_LOGGED_ON.jsp");
		//showNOT_LOGGED_ONpage(request, response);
		}
	else if (curstate ==  ATM.BANK_ACCOUNTS_LISTED){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/BANK_ACCOUNTS_LISTED.jsp");
		//showBANK_ACCOUNTS_LISTEDpage(request, response);
		}
	else if (curstate ==  ATM.BANK_ACCOUNT_CHOOSEN){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/BANK_ACCOUNT_CHOSEN.jsp");
		//showBANK_ACCOUNT_CHOSENpage(request, response);
		}
	else if (curstate ==  ATM.ASK_AMOUNT){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/ASK_AMOUNT.jsp");
		//showASK_AMOUNTpage(request, response);
		}
	else if (curstate ==  ATM.DISPENSE_MONEY){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/DISPENSE_MONEY.jsp");
		//showDISPENSE_MONEYpage(request, response);
		}
	else if (curstate ==  ATM.TRX_HISTORY_LISTED){
		dispatcher = getServletContext().getRequestDispatcher("/jsp/TRX_HISTORY_LISTED.jsp");
		//showTRX_HISTORY_LISTEDpage(request, response);
		}
	else{
		throw new IllegalStateException();
	}

	return dispatcher;
}
/**
 * Process incoming HTTP GET requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {

	try{
		performTask(request, response);
	}catch(Exception exp){
		System.out.println("exp Persistense");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/error.jsp");
		dispatcher.forward(request, response);
	}

}
/**
 * Process incoming HTTP POST requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

	try{ 
		performTask(request, response);
	}catch(Exception exp){
		//System.out.println("exp Persistense");//
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/itsojsp/error.jsp");
		dispatcher.forward(request, response);
	}


}
	/**
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(HttpServletRequest request, HttpServletResponse response) 
throws Exception {
 System.out.println("startPerformTask !!!");
	ATM userATM = createOrRetreiveUserATM(request, response);
 System.out.println("createATM");	
	// add the userATM object to the request, to ensure the JSPs only use the request attributes.
	request.setAttribute("userATMrq", userATM );

	//To use hard-coded HTML pages as described in the Servlet chapter,  uncomment the following line.
	//showNextPage(request, response, userATM.getState());

	// Next two lines get the JSP to show, then forward the request to the JSP. This is the
	// implementation built in the JSP chapter.
	RequestDispatcher dispatcher = determineNextPage(userATM.getState());
	dispatcher.forward(request, response);	
}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 6:41:56 PM)
 */
public void showASK_AMOUNTpage(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {

	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	
	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() +   "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P>Please enter the amount to withdraw now. <BR>");
	out.println("<FORM METHOD='GET' ACTION='/servlet/com.overstar.bank.atm.servlets.EnterAmountServlet'>");
	out.println(" Amount: <INPUT TYPE=TEXT NAME='amount' SIZE=10>");
	out.println(" <INPUT TYPE=SUBMIT VALUE='Next'>");
	out.println("</FORM> </P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.StopServlet'>Restart</A></P>");
	out.println("</BODY></HTML>");
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 6:41:32 PM)
 */
public void showBANK_ACCOUNT_CHOSENpage(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException{
	
	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	
	
	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() + "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P>Account Chosen: " + userATM.getCurrentBankAccount());
	out.println("</P>");
	out.println("<FORM METHOD='GET' ACTION='/servlet/com.overstar.bank.atm.servlets.ChooseActionServlet'>");
	out.println("<INPUT TYPE=RADIO NAME='action' VALUE='withdraw'>Withdraw Money<BR>");
	out.println("<INPUT TYPE=RADIO NAME='action' VALUE='history'>View Transaction History<BR>");
	out.println("<INPUT TYPE=RADIO NAME='action' VALUE='changeacct'>Pick a different Account<BR>");
	out.println("<INPUT TYPE=SUBMIT VALUE='Next'>");
	out.println("</FORM> </P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.StopServlet'>Restart</A></P>");
	out.println("</BODY></HTML>");
	
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 6:40:32 PM)
 */
public void showBANK_ACCOUNTS_LISTEDpage(HttpServletRequest request, HttpServletResponse response) throws Exception{

	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	
	Vector allaccts = userATM.getListBankAccounts();
	
	
	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() +   "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P>Please choose an account now. <BR>");
	out.println("<FORM METHOD='GET' ACTION='/servlet/com.overstar.bank.atm.servlets.ChooseAccountServlet'>");

	for (int i=0; i < allaccts.capacity(); i++){
		BankAccount curacct = (BankAccount)allaccts.elementAt(i);
		out.println("<INPUT TYPE=RADIO NAME='acct' VALUE='" + curacct.getId().getIdAsString() + "'>"  + curacct + "<BR>" );
	}
	out.println(" <INPUT TYPE=SUBMIT VALUE='Next'>");
	out.println("</FORM> </P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.StopServlet'>Restart</A></P>");
	out.println("</BODY></HTML>");
	
	
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 6:42:44 PM)
 */
public void showDISPENSE_MONEYpage(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
	
	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	
	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() +   "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P>Dispense Money");
	out.println("</P>");
	out.println("</BODY></HTML>");
	
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12/21/00 4:15:33 PM)
 * @return javax.servlet.RequestDispatcher
 */
private void showNextPage(HttpServletRequest request, HttpServletResponse response, ATM$ATMState curstate) throws Exception {
	
	if (curstate ==  ATM.OUT_OF_ORDER){
		showOUT_OF_ORDERpage(request, response);
		}
	else if (curstate ==  ATM.READY_TO_USE){
		showREADY_TO_USEpage(request, response); 
		}
	else if (curstate ==  ATM.NOT_LOGGED_ON){
		showNOT_LOGGED_ONpage(request, response);
		}
	else if (curstate ==  ATM.BANK_ACCOUNTS_LISTED){
		showBANK_ACCOUNTS_LISTEDpage(request, response);
		}
	else if (curstate ==  ATM.BANK_ACCOUNT_CHOOSEN){
		showBANK_ACCOUNT_CHOSENpage(request, response);
		}
	else if (curstate ==  ATM.ASK_AMOUNT){
		showASK_AMOUNTpage(request, response);
		}
	else if (curstate ==  ATM.DISPENSE_MONEY){
		showDISPENSE_MONEYpage(request, response);
		}
	else if (curstate ==  ATM.TRX_HISTORY_LISTED){
		showTRX_HISTORY_LISTEDpage(request, response);
		}
	else{
		throw new IllegalStateException();
	}

}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 6:39:16 PM)
 */
public void showNOT_LOGGED_ONpage(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
	
	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	
	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() +   "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P>Please enter your PIN now. <BR>");
	out.println("<FORM METHOD='GET' ACTION='/servlet/com.overstar.bank.atm.servlets.EnterPINServlet'>");
	out.println(" PIN: <INPUT TYPE=TEXT NAME='pin' SIZE=10>");
	out.println(" <INPUT TYPE=SUBMIT VALUE='Next'>");
	out.println("</FORM> </P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.StopServlet'>Restart</A></P>");
	out.println("</BODY></HTML>");
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 4:27:20 PM)
 */
public void showOUT_OF_ORDERpage(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
	
	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	
	
	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() +   "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P>Out of Order");
	out.println("</P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.StopServlet'>Restart</A></P>");
	out.println("</BODY></HTML>");
	
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 4:28:10 PM)
 */
public void showREADY_TO_USEpage(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
	
	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	

	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() +   "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P>Please enter your card now. <BR>");
	out.println("If you don't have a card reader, type in your card number.<BR>");
	out.println("<FORM METHOD='POST' ACTION='/servlet/com.overstar.bank.atm.servlets.InsertCardServlet'>");
	out.println("card number: <INPUT TYPE=TEXT NAME='cardnum' SIZE=10>");
	out.println(" <INPUT TYPE=SUBMIT VALUE='Next'>");
	out.println("</FORM> </P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.StopServlet'>Restart</A></P>");
	out.println("</BODY></HTML>");
	
	
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12/1/00 6:43:17 PM)
 */
public void showTRX_HISTORY_LISTEDpage(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {

	ATM userATM = (ATM)request.getAttribute("userATMrq");
	response.setContentType("text/html");
	PrintWriter	out = response.getWriter();
	
	Vector alltrans = userATM.getTransactions();
	
	out.println("<HTML><HEAD>");
	out.println("<TITLE>" +  userATM.getState() +   "</TITLE>");
	out.println("</HEAD><BODY>");
	out.println("<P ALIGN=CENTER>Transaction History");
	out.println("</P>");

	if( alltrans.capacity() > 0){
		out.println("<TABLE ALIGN=CENTER BORDER=1><TR><TH>Post Date</TH><TH>Amount</TH><TH>Source Acct</TH><TH>Target Acct</TH></TR>");	
 		for (int i=0; i < alltrans.capacity(); i++){
			Transaction curtran = (Transaction)alltrans.elementAt(i);
			out.println("<TR><TD>" + curtran.getTimestamp() + "</TD>");
			out.println("<TD>" + curtran.getTrxAmount() + "</TD>");
			out.println("<TD>" + curtran.getSrcAccount().getId().getIdAsString()  + "</TD>");
			out.println("<TD>" + curtran.getTrgtAccount().getId().getIdAsString() + "</TD>");
			out.println("</TR>");
		}
 		out.println("</TABLE>");
	}
	else{
		out.println("No Transactions found. ");

	}

	//out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.ShowActionsServlet?acct="+ userATM.getCurrentBankAccount().getId().getIdAsString() + "'>Choose a different Action</A></P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.ShowActionsServlet'>Choose a different Action</A></P>");
	out.println("<P><A HREF='/servlet/com.overstar.bank.atm.servlets.StopServlet'>Restart</A></P>");
	out.println("</BODY></HTML>");
	
	
	
	}
}
