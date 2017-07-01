package com.overstar.ildar.ibank.servlets;

import com.overstar.ildar.ibank.model.*;
import com.overstar.ildar.ibank.servlets.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Insert the type's description here.
 * Creation date: (30.09.2002 18:38:53)
 * @author: Shafigullin Ildar
 */
public class StopServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>StopServlet Error</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<P>Error: " + exp);
        out.println("</P>");
        out.println("</BODY></HTML>");
    }

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
public void performTask(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession(false);
    if (session != null) {
        IBank userIBank = (IBank) session.getAttribute("userIBank");
        if ((userIBank != null) && (userIBank.getState() != IBank.READY_TO_USE)) {
            userIBank.stop();
        }
        java.util.Date lastDate = new java.util.Date();
        Cookie lastDateCookie = new LongLivedCookie("lastDate", lastDate.toString());
        response.addCookie(lastDateCookie);
    }

    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/servlet/com.overstar.ildar.ibank.servlets.ShowIBankServlet");
    dispatcher.forward(request, response);

}
}
