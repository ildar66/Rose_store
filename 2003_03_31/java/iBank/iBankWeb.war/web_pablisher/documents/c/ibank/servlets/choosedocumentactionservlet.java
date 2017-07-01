package com.overstar.ildar.ibank.servlets;

import java.sql.*;
import javax.servlet.*;
import com.overstar.ildar.ibank.model.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (28.10.2002 12:40:41)
 * @author: Shafigullin Ildar
 */
public class ChooseDocumentActionServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>ChooseDocumentActionServlet Error</TITLE>");
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
        out.println("<TITLE>ChooseDocumentActionServlet Error</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<P>Error: " + exp.getMessage());
        out.println("</P>");
        out.println("</BODY></HTML>");

    };

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
public String getParameter(
    javax.servlet.http.HttpServletRequest request,
    String parameterName,
    boolean checkRequestParameters,
    boolean checkInitParameters,
    boolean isParameterRequired,
    String defaultValue)
    throws Exception {

    String[] parameterValues = null;
    String paramValue = null;

    // Get the parameter from the request object if necessary.
    if (checkRequestParameters) {
        parameterValues = request.getParameterValues(parameterName);
        if (parameterValues != null)
            paramValue = parameterValues[0];
    }

    // Get the parameter from the servlet init parameters if
    // it was not in the request parameter.
    if ((checkInitParameters) && (paramValue == null))
        paramValue = getServletConfig().getInitParameter(parameterName);

    // Throw an exception if the parameter was not found and it was required.
    // The exception will be caught by error processing and can be
    // displayed in the error page.
    if ((isParameterRequired) && (paramValue == null))
        throw new Exception("Parameter " + parameterName + " was not specified.");

    // Set the return to the default value if the parameter was not found
    if (paramValue == null)
        paramValue = defaultValue;
    // œÓ‚ÂÍ‡ ‰Îˇ CharacterEncoding:
    String clientEnc = request.getCharacterEncoding();
    if (clientEnc == null) {
        String requestEnc = "ISO-8859-5";
        clientEnc = "Cp1251";
        paramValue = new String(paramValue.getBytes(requestEnc), clientEnc);
    }

    return paramValue;
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
            String actionstr = getParameter(request, "btnsubmit", true, false, true, "");

            int anDocType = Integer.parseInt(request.getParameter("formid"));
            String docdate = getParameter(request, "docdate", true, false, true, "");
            String docnum = getParameter(request, "docnum", true, false, true, "");
            String paykind = getParameter(request, "paykind", true, false, false, " ");
            String payerinn = getParameter(request, "payerinn", true, false, true, "");
            String payer = getParameter(request, "payer", true, false, true, "");
            String payeracc = getParameter(request, "payeracc", true, false, true, "");
            String payerbank = getParameter(request, "payerbank", true, false, true, "");
            String payerbic = getParameter(request, "payerbic", true, false, true, "");
            String payercoracc = getParameter(request, "payercoracc", true, false, true, "");
            String docsum = getParameter(request, "docsum", true, false, true, "");
            String receiverinn = getParameter(request, "receiverinn", true, false, true, "");
            String receiver = getParameter(request, "receiver", true, false, true, "");
            String receiveracc = getParameter(request, "receiveracc", true, false, true, "");
            String receiverbank = getParameter(request, "receiverbank", true, false, true, "");
            String receiverbic = getParameter(request, "receiverbic", true, false, true, "");
            String receivercoracc = getParameter(request, "receivercoracc", true, false, true, "");
            String opkind = getParameter(request, "opkind", true, false, true, "");
            String paypriority = getParameter(request, "paypriority", true, false, true, "");
            String term = getParameter(request, "term", true, false, true, "");
            String paypurpose = getParameter(request, "paypurpose", true, false, true, "");
            //String  = request.getParameter("attention");//ƒŒœ»—¿“‹
            //String  = request.getParameter("kpp");//ƒŒœ»—¿“‹

            if (actionstr != null) {
                //validate syntax of actionstr.
                if (actionstr.equals("Save")) {
                    userIBank.documentUPDATE(
                        anDocType,
                        Date.valueOf(docdate),
                        docnum,
                        "000",
                        paykind,
                        payerinn,
                        payer,
                        payeracc,
                        payerbank,
                        payerbic,
                        payercoracc,
                        new Money(docsum),
                        receiverinn,
                        receiver,
                        receiveracc,
                        receiverbank,
                        receiverbic,
                        receivercoracc,
                        opkind,
                        paypriority,
                        Date.valueOf(term),
                        paypurpose,
                        "Kpp?");
                    userIBank.getListDocuments(
                        anDocType,
                        userIBank.getFromDate(),
                        userIBank.getToDate(),
                        userIBank.getStatuses(),
                        userIBank.getSortBy());
                }
                else if (actionstr.equals("AddNew")) {
                    userIBank.documentADD(
                        anDocType,
                        Date.valueOf(docdate),
                        docnum,
                        "000",
                        paykind,
                        payerinn,
                        payer,
                        payeracc,
                        payerbank,
                        payerbic,
                        payercoracc,
                        new Money(docsum),
                        receiverinn,
                        receiver,
                        receiveracc,
                        receiverbank,
                        receiverbic,
                        receivercoracc,
                        opkind,
                        paypriority,
                        Date.valueOf(term),
                        paypurpose,
                        "Kpp?");
                    userIBank.getListDocuments(
                        anDocType,
                        userIBank.getFromDate(),
                        userIBank.getToDate(),
                        userIBank.getStatuses(),
                        userIBank.getSortBy());
                }
                else if (actionstr.equals("Delete")) {
                    userIBank.documentDELETE(anDocType);
                    userIBank.getListDocuments(
                        anDocType,
                        userIBank.getFromDate(),
                        userIBank.getToDate(),
                        userIBank.getStatuses(),
                        userIBank.getSortBy());
                }
                else if (actionstr.equals("Cancel")) {
                    userIBank.getListDocuments(
                        anDocType,
                        userIBank.getFromDate(),
                        userIBank.getToDate(),
                        userIBank.getStatuses(),
                        userIBank.getSortBy());
                }
                else {
                    throw new Exception("Invalid action request. The only valid actions are 'Save', 'AddNew', 'Delete', and 'Cancel'");
                }
            }
        }
    }

    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/servlet/com.overstar.ildar.ibank.servlets.ShowIBankServlet");
    dispatcher.forward(request, response);

}
}
