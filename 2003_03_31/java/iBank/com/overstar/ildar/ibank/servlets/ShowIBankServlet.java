package com.overstar.ildar.ibank.servlets;

import java.io.*;
import com.overstar.ildar.ibank.model.documents.*;
import com.overstar.ildar.ibank.model.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * This servlet - controller
 *
 * Creation date: (19.09.2002 12:15:07)
 * @author: Shafigullin Ildar
 */
public class ShowIBankServlet extends javax.servlet.http.HttpServlet {
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 12:25:55)
 * @return com.overstar.ildar.ibank.model.IBank
 * @param request javax.servlet.http.HttpServletRequest
 * @param response javax.servlet.http.HttpServletResponse
 * @exception java.lang.Exception The exception description.
 */
private IBank createOrRetreiveUserIBank(HttpServletRequest request, HttpServletResponse response)
    throws java.lang.Exception {
    String cookie_value = null;
    String IBank_key = null;
    boolean no_IBank_cookie_found = true;

    // Get the current session object, create one if necessary
    HttpSession session = request.getSession(true);

    // Try to retieve the userIBank from the session.
    IBank userIBank = (IBank) session.getAttribute("userIBank");
    if (userIBank == null) {
        //Check if our cookie is available in the browser.
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            // cookies are present! loop through all the cookies looking 
            // for the one we want. If we find the cookie we want,
            // assign its value to IBank_key.
            for (int i = 0;(i < cookies.length) && no_IBank_cookie_found; i++) {
                if (cookies[i].getName().equals("IBank_KEY")) {
                    IBank_key = cookies[i].getValue();
                    no_IBank_cookie_found = false;
                }
            }
        }

        if (no_IBank_cookie_found) { //  no IBank in session, no cookie
            // this means the user has never used the IBank application.

            userIBank = new IBank();

            // put the IBank key into a cookie. That way we can recognize repeat
            // users even if they do not have a session. 
            Cookie IBank_key_cookie = new Cookie("IBank_KEY", userIBank.getId().getIdAsString());
            IBank_key_cookie.setPath("/"); // this is optional. It means that any servlet on this server can view the cookie. 
            response.addCookie(IBank_key_cookie);
        }
        else { //no IBank in session, have cookie
            // user is a returning user. 
            userIBank = new IBank(new IBank.IBankPK(IBank_key));
        }

        if (userIBank.getState() == IBank.OUT_OF_ORDER) {
            userIBank.initialize();
        }
        if (userIBank.getState() == IBank.READY_TO_USE) {
            session.setAttribute("userIBank", userIBank);
        }
        else {
            throw new Exception("Error: IBank is not ready to use. The current IBank state is: " + userIBank.getState());
        }
    }

    return userIBank;

}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 12:40:50)
 * @return javax.servlet.RequestDispatcher
 * @param curstate com.overstar.ildar.ibank.model.IBank.IBankState
 */
private RequestDispatcher determineNextPage(IBank userIBank) {
    RequestDispatcher dispatcher = null;
    IBank.IBankState curstate = userIBank.getState();

    if (curstate == IBank.OUT_OF_ORDER) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/OUT_OF_ORDER.jsp");
    }
    else if (curstate == IBank.READY_TO_USE) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/READY_TO_USE.jsp");
    }
    else if (curstate == IBank.NOT_LOGGED_ON) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/NOT_LOGGED_ON.jsp");
    }
    else if (curstate == IBank.CLIENT_INFO) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/CLIENT_INFO.jsp");
    }
    else if (curstate == IBank.RECIPIENTS_LISTED) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/RECIPIENTS_LISTED.jsp");
    }
    else if (curstate == IBank.RECIPIENTS_CHOOSEN) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/RECIPIENTS_CHOOSEN.jsp");
    }
    else if (curstate == IBank.BANKS_LISTED) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/BANKS_LISTED.jsp");
    }
    else if (curstate == IBank.DOCUMENTS_LISTED) {
        dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/DOCUMENTS.jsp");
    }
    else if (curstate == IBank.DOCUMENTS_CHOOSEN) {
        Document curDocument = userIBank.getCurrentDocument();
        if (curDocument instanceof Payment)
            dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/PAYMENT_CHOOSEN.jsp");
        else if (curDocument instanceof Accreditive)
            dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/ACCREDITIVE_CHOOSEN.jsp");
        else if (curDocument instanceof Document) {
            //дописать для других документов !!!
        }
        //создание нового документа:
        else if (curDocument == null) {
            int doc_type = userIBank.getDocTransMgr().getDoc_type();
            switch (doc_type) {
                case DocumentTransactionMgr.PAYMENTS :
                    dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/PAYMENT_CHOOSEN.jsp");
                    break;
                case DocumentTransactionMgr.ACCREDITIVS :
                    dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/ACCREDITIVE_CHOOSEN.jsp");
                    break;
                default :
                    //пока нет др доков :TEMP
                    dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/PAYMENT_CHOOSEN.jsp");
            }
        }
    }
    /*           else if (curstate ==  IBank.BANK_ACCOUNTS_LISTED){
          		dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/BANK_ACCOUNTS_LISTED.jsp");
          		}
          	else if (curstate ==  IBank.BANK_ACCOUNT_CHOOSEN){
          		dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/BANK_ACCOUNT_CHOSEN.jsp");
          		}
          	else if (curstate ==  IBank.ASK_AMOUNT){
          		dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/ASK_AMOUNT.jsp");
          		}
          	else if (curstate ==  IBank.DISPENSE_MONEY){
          		dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/DISPENSE_MONEY.jsp");
           	    }
          	else if (curstate ==  IBank.TRX_HISTORY_LISTED){
          		dispatcher = getServletContext().getRequestDispatcher("/ibankjsp/TRX_HISTORY_LISTED.jsp");
          		}
        */
    else {
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
public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
    throws javax.servlet.ServletException, java.io.IOException {

    try {
        performTask(request, response);
    }
    catch (Exception exp) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD>");
        out.println("<TITLE>ShowIBankServlet Error</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<P>Error: " + exp.getMessage());
        out.println("</P>");
        out.println("<P><A HREF='/iBank/StopServlet'>Restart</A></P>");
        out.println("</BODY></HTML>");
    }

}
/**
 * Process incoming HTTP POST requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
    doGet(request, response);
}
/**
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
	IBank userIBank = createOrRetreiveUserIBank(request, response);
	
	// add the userIBank object to the request, to ensure the JSPs only use the request attributes.
	//request.setAttribute("userIBankrq", userIBank );  //нужно ли?

	RequestDispatcher dispatcher = determineNextPage(userIBank);
	dispatcher.forward(request, response);	
}
}
