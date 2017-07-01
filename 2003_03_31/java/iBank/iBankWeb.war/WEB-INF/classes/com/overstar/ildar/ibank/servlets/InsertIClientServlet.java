package com.overstar.ildar.ibank.servlets;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import com.overstar.ildar.ibank.model.*;
/**
 * This servlet checks the parameter "IClientnumber" and if
 * the number is valid, inserts the IClient into the IBank using the
 * business objects.
 *
 * Creation date: (19.09.2002 16:08:21)
 * @author: Shafigullin Ildar
 */
public class InsertIClientServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>InsertIClientServlet Error</TITLE>");
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
public void performTask(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession(false);
    if (session != null) {
        IBank userIBank = (IBank) session.getAttribute("userIBank");

        if (userIBank != null) {
            IClient userIClient;
            String IClientstr = request.getParameter("IClientnum").trim();
            //validate syntax of IClient number. It must be numeric.
            try {
                Double IClientnum = new Double(IClientstr);
            }
            catch (Exception exp) {
                throw new Exception("Invalid IClient number. IClient number must be numeric.");
            }
            userIClient = IClientTransactionMgr.findWithIClientPK(IClientstr);
            userIBank.insertIClient(userIClient);
            //validate PIN IClient.
            String pinstr = request.getParameter("PIN");
            if (pinstr != null) {
                userIBank.enterPIN(pinstr);
            }

        }
    }

    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/servlet/com.overstar.ildar.ibank.servlets.ShowIBankServlet");

    dispatcher.forward(request, response);

}
}
