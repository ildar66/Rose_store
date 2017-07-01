package com.overstar.ildar.ibank.servlets;

import java.sql.*;
import javax.servlet.*;
import com.overstar.ildar.ibank.model.*;
import com.overstar.ildar.ibank.model.documents.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (24.09.2002 15:13:02)
 * @author: Shafigullin Ildar
 */
public class ChooseActionServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>ChooseActionServlet Error</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<P>Error: " + exp.getMessage());
        out.println("</P>");
        out.println("<P><A HREF='/iBank/StopServlet'>Restart</A></P>");
        out.println("</BODY></HTML>");

    };

}
/**
 * Process incoming HTTP POST requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
    throws javax.servlet.ServletException, java.io.IOException {

    doGet(request, response);
}
/**
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
    throws Exception {

    HttpSession session = request.getSession(false);
    if (session != null) {
        IBank userIBank = (IBank) session.getAttribute("userIBank");
        if (userIBank != null) {
            String actionstr = request.getParameter("action");
            if (actionstr != null) {
                //validate action:
                if (actionstr.equals("ListRecipients")) {
                    userIBank.getListRecipients("bic");
                }
                else if (actionstr.equals("ListBanks")) {
                    userIBank.setStateListBanks();
                }
                else if (actionstr.equals("ListDocuments")) {
                    //String curDate = new Date(System.currentTimeMillis()).toString();
                    //userIBank.getListDocuments(DocumentTransactionMgr.PAYMENTS, curDate, curDate, new String[]{"0","1","2","3","4","5","6","7"}, " date_doc");
                    userIBank.getListDocuments();
                }
                /*
                else if (actionstr.equals("changeacct")) {
                    userIBank.getListBankAccounts();
                }
                */
                else {
                    throw new Exception("Invalid action request. The only valid actions are 'withdraw', 'history', and 'changeacct'");
                }
            }
        }
    }

    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/servlet/com.overstar.ildar.ibank.servlets.ShowIBankServlet");
    dispatcher.forward(request, response);

}
}
