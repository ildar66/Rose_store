package com.overstar.ildar.ibank.servlets;

import javax.servlet.*;
import com.overstar.ildar.ibank.model.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (18.10.2002 11:52:48)
 * @author: Shafigullin Ildar
 */
public class ChooseDocumentsServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>ChooseDocumentServlet Error</TITLE>");
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
        out.println("<TITLE>ChooseDocumentServlet Error</TITLE>");
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
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
    throws Exception {
    HttpSession session = request.getSession(false);
    if (session != null) {
        IBank userIBank = (IBank) session.getAttribute("userIBank");
        if (userIBank != null) {
            String actionstr = request.getParameter("action");
            int anDocType = Integer.parseInt(request.getParameter("formid"));
            String fromDate = request.getParameter("fromdate");
            String toDate = request.getParameter("todate");
            String[] statuses = request.getParameterValues("status");
            if (statuses == null)
                statuses = new String[0];

            String sortByStr = request.getParameter("sort");

            String documentIDstr = request.getParameter("documentID");
            Document userDocument;
            if (actionstr != null) {
                //validate syntax of actionstr.
                if (actionstr.equals("Edit")) {
                    userIBank.chooseDocument(anDocType, documentIDstr);
                }
                else if (actionstr.equals("AddNew")) {
                    userIBank.chooseDocument(null);
                }
                else if (actionstr.equals("Delete")) {
                    userIBank.chooseDocument(anDocType, documentIDstr);
                    userIBank.documentDELETE(anDocType);
                    userIBank.getListDocuments(anDocType, fromDate, toDate, statuses, sortByStr);
                }
                else if (actionstr.equals("SortBy")) {
                    userIBank.getListDocuments(anDocType, fromDate, toDate, statuses, sortByStr);
                }
                else if (actionstr.equals("Read")) {
                    userIBank.getListDocuments(anDocType, fromDate, toDate, statuses, sortByStr);
                }
                else {
                    throw new Exception("Invalid action request. The only valid actions are 'Edit', 'AddNew', 'Delete', 'SortBy' and 'Read'");
                }
            }
        }

    }
    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/servlet/com.overstar.ildar.ibank.servlets.ShowIBankServlet");
    dispatcher.forward(request, response);

}
}
