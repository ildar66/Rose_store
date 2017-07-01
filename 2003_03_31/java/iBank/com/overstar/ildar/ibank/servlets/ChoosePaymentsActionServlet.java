package com.overstar.ildar.ibank.servlets;

import com.overstar.ildar.ibank.model.documents.*;
import com.overstar.ildar.ibank.model.exceptions.*;
import com.overstar.ildar.ibank.servlets.util.*;
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
public class ChoosePaymentsActionServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>ChoosePaymentsActionServlet Error</TITLE>");
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
        
    //return paramValue;
    return ServletUtilities.encode(request, paramValue);

}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 17:01:53)
 * @param anDocType int
 * @param newClient_ID java.lang.String
 * @param newDate_doc java.sql.Date
 * @param newNum_doc java.lang.String
 * @param newSigners java.lang.String
 * @param newPayment_type java.lang.String
 * @param newPayer_inn java.lang.String
 * @param newPayer_name java.lang.String
 * @param newPayer_account java.lang.String
 * @param newPayer_bank_name java.lang.String
 * @param newPayer_bank_bic java.lang.String
 * @param newPayer_bank_acc java.lang.String
 * @param newAmount Money
 * @param newRcpt_inn java.lang.String
 * @param newRcpt_name java.lang.String
 * @param newRcpt_account java.lang.String
 * @param newRcpt_bank_name java.lang.String
 * @param newRcpt_bank_bic java.lang.String
 * @param newRcpt_bank_acc java.lang.String
 * @param newType_oper java.lang.String
 * @param newQueue java.lang.String
 * @param newTerm java.util.Date
 * @param newPayment_details java.lang.String
 * @param newKpp java.lang.String
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E00419901EA
 */
public void paymentADD(
    IBank userIBank,
    java.sql.Date newDate_doc,
    String newNum_doc,
    String newSigners,
    String newPayment_type,
    BusinessPartner anPayer,
    Money newAmount,
    BusinessPartner anRcpt,
    String newType_oper,
    String newQueue,
    java.sql.Date newTerm,
    String newPayment_details,
    String newKpp)
    throws PersistenceException, InvalidDocumentStatusException {
    if (userIBank.getState() == userIBank.DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        Payment curDocument = null;
        curDocument =
            new Payment(
                new Document.DocumentPK(),
                new Integer(userIBank.getCurrentIClient().getClient_id().getIdAsString()),
                newDate_doc,
                newNum_doc,
                Document.NEW.getID(),
                newSigners,
                newPayment_type,
                anPayer,
                newAmount,
                anRcpt,
                newType_oper,
                newQueue,
                newTerm,
                newPayment_details,
                newKpp);
        PaymentTransactionMgr.storePayment(curDocument);
        userIBank.setCurrentDocument(curDocument);
    }
    else {
        throw new IllegalStateException("You cannot add an document when the IBank is not in the DOCUMENTS_CHOOSEN state.");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 18:29:55)
 * @param userIBank IBank 
 * @throws com.overstar.ildar.ibank.model.exception PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E00419902F8
 */
public void paymentDELETE(IBank userIBank) throws PersistenceException {
    if (userIBank.getState() == userIBank.DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        DocumentTransactionMgr.deleteWithDocumentPK(DocumentTransactionMgr.PAYMENTS, userIBank.getCurrentDocument().getDoc_id());
        userIBank.setCurrentDocument(null);
    }
    else {
        throw new IllegalStateException("You cannot delete an Payment when the IBank is not in the DOCUMENTS_CHOOSEN state.");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 12:34:23)
 * @param anDocType int
 * @param anDate_doc java.sql.Date
 * @param anNum_doc java.lang.String
 * @param anSigners java.lang.String
 * @param anPayment_type java.lang.String
 * @param anPayer BusinessPartner
 * @param anAmount com.overstar.ildar.ibank.model.Money
 * @param anRcpt BusinessPartner
 * @param anType_oper java.lang.String
 * @param anQueue java.lang.String
 * @param anTerm java.sql.Date
 * @param anPayment_details java.lang.String
 * @param anKpp java.lang.String
 * @throws com.overstar.ildar.ibank.model.exceptions.PersistenceException
 * @throws com.overstar.ildar.ibank.model.exceptions.InvalidDocumentStatusException
 * @roseuid 3E0041990334
 */
public void paymentUPDATE(
    IBank userIBank,
    java.sql.Date anDate_doc,
    String anNum_doc,
    String anSigners,
    String anPayment_type,
    BusinessPartner anPayer,
    Money anAmount,
    BusinessPartner anRcpt,
    String anType_oper,
    String anQueue,
    java.sql.Date anTerm,
    String anPayment_details,
    String anKpp)
    throws PersistenceException, InvalidDocumentStatusException {
    if (userIBank.getState() == userIBank.DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        Payment curDocument = (Payment) userIBank.getCurrentDocument();
        curDocument =
            new Payment(
                curDocument.getDoc_id(),
                new Integer(userIBank.getCurrentIClient().getClient_id().getIdAsString()),
                anDate_doc,
                anNum_doc,
                Document.NEW.getID(),
                anSigners,
                anPayment_type,
                anPayer,
                anAmount,
                anRcpt,
                anType_oper,
                anQueue,
                anTerm,
                anPayment_details,
                anKpp);
        PaymentTransactionMgr.storePayment(curDocument);
        userIBank.setCurrentDocument(curDocument);
    }
    else {
        throw new IllegalStateException("You cannot add an document when the IBank is not in the DOCUMENTS_CHOOSEN state.");
    }
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
                    paymentUPDATE(
                        userIBank,
                        Date.valueOf(docdate),
                        docnum,
                        "000",
                        paykind,
                        new BusinessPartner(payerinn, payer, payeracc, payerbic, payerbank, payercoracc),
                        new Money(docsum),
                        new BusinessPartner(receiverinn, receiver, receiveracc, receiverbic, receiverbank, receivercoracc),
                        opkind,
                        paypriority,
                        Date.valueOf(term),
                        paypurpose,
                        "Kpp?");
                    userIBank.getListDocuments();
                }
                else if (actionstr.equals("AddNew")) {
                    paymentADD(
                        userIBank,
                        Date.valueOf(docdate),
                        docnum,
                        "000",
                        paykind,
                        new BusinessPartner(payerinn, payer, payeracc, payerbic, payerbank, payercoracc),
                        new Money(docsum),
                        new BusinessPartner(receiverinn, receiver, receiveracc, receiverbic, receiverbank, receivercoracc),
                        opkind,
                        paypriority,
                        Date.valueOf(term),
                        paypurpose,
                        "Kpp?");
                    userIBank.getListDocuments();
                }
                else if (actionstr.equals("Delete")) {
                    paymentDELETE(userIBank);
                    userIBank.getListDocuments();
                }
                else if (actionstr.equals("Cancel")) {
                    userIBank.getListDocuments();
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
