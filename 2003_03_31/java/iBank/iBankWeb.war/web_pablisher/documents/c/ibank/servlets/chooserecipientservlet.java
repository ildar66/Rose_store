package com.overstar.ildar.ibank.servlets;

import javax.servlet.*;
import com.overstar.ildar.ibank.model.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (25.09.2002 15:34:09)
 * @author: Shafigullin Ildar
 */
public class ChooseRecipientServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>ChooseRecipientServlet Error</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<P>Error: " + exp.getMessage());
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
public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
    throws javax.servlet.ServletException, java.io.IOException {

    try {
        performTask(request, response);
    }
    catch (Exception exp) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD>");
        out.println("<TITLE>ChooseRecipientServlet Error</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<P>Error: " + exp.getMessage());
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
public void performTask(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession(false);
    if (session != null) {
        IBank userIBank = (IBank) session.getAttribute("userIBank");
        if (userIBank != null) {
            String actionstr = request.getParameter("btnaction");
            String sortByStr = request.getParameter("sort");

            String recipientIDstr = request.getParameter("recipientID");
            if (actionstr != null) {
                //validate syntax of actionstr.
                if (actionstr.equals("Edit")) {
                    Recipient userRecipient = Recipient.findWithRecipientPK(recipientIDstr);
                    userIBank.chooseRecipient(userRecipient);
                }
                else if (actionstr.equals("AddNew")) {
                    userIBank.chooseRecipient(null);
                }
                else if (actionstr.equals("Delete")) {
                    Recipient userRecipient = Recipient.findWithRecipientPK(recipientIDstr);
                    userIBank.chooseRecipient(userRecipient);
                    userIBank.recipientDELETE();
                    userIBank.getListRecipients(sortByStr);
                }
                else if (actionstr.equals("SortBy")) {
                    userIBank.getListRecipients(sortByStr);
                }
                else if (actionstr.equals("Refresh")) {
                    userIBank.getListRecipients(sortByStr);
                }
                else {
                    throw new Exception("Invalid action request. The only valid actions are 'Edit', 'AddNew', 'Delete', and 'Refresh'");
                }
            }
        }

    }
    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/servlet/com.overstar.ildar.ibank.servlets.ShowIBankServlet");
    dispatcher.forward(request, response);

}
}
