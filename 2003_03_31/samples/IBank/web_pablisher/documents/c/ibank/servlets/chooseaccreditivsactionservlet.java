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
public class ChooseAccreditivsActionServlet extends javax.servlet.http.HttpServlet {
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 17:01:53)
 * @param anDocType int
 * @param newClient_ID java.lang.String
 * @param newDate_doc java.sql.Date
 * @param newNum_doc java.lang.String
 * @param newSigners java.lang.String
 * @param newAccreditive_type java.lang.String
 * @param newPayer BusinessPartner
 * @param newAmount Money
 * @param newRcpt BusinessPartner
 * @param anAccount_40901 java.lang.String
 * @param newType_oper java.lang.String
 * @param newTerm java.util.Date
 * @param newType_accreditiv1 java.lang.String
 * @param newType_accreditiv2 java.lang.String
 * @param newCondition_pay java.lang.String
 * @param newAccreditiv_details java.lang.String
 * @param newAccreditiv_docs java.lang.String
 * @param newAdd_condition java.lang.String
 * @throws com.overstar.ildar.ibank.model.exceptions.PersistenceException
 * @throws com.overstar.ildar.ibank.model.exceptions.InvalidDocumentStatusException
 */
public void accreditiveADD(
    IBank userIBank,
    java.sql.Date newDate_doc,
    String newNum_doc,
    String newSigners,
    String newAccreditive_type,
    BusinessPartner anPayer,
    Money newAmount,
    BusinessPartner anRcpt,
    String anAccount_40901,
    String newType_oper,
    java.sql.Date newTerm,
    String newType_accreditiv1,
    String newType_accreditiv2,
    String newCondition_pay,
    String newAccreditiv_details,
    String newAccreditiv_docs,
    String newAdd_condition)
    throws PersistenceException, InvalidDocumentStatusException {
    if (userIBank.getState() == userIBank.DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        Accreditive curDocument = null;
        curDocument =
            new Accreditive(
                new Document.DocumentPK(),
                new Integer(userIBank.getCurrentIClient().getClient_id().getIdAsString()),
                newDate_doc,
                newNum_doc,
                Document.NEW.getID(),
                newSigners,
                newAccreditive_type,
                anPayer,
                newAmount,
                anRcpt,
                anAccount_40901,
                newType_oper,
                newTerm,
                newType_accreditiv1,
                newType_accreditiv2,
                newCondition_pay,
                newAccreditiv_details,
                newAccreditiv_docs,
                newAdd_condition);
        AccreditiveTransactionMgr.storeAccreditive(curDocument);
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
public void accreditiveDELETE(IBank userIBank) throws PersistenceException {
    if (userIBank.getState() == userIBank.DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        DocumentTransactionMgr.deleteWithDocumentPK(DocumentTransactionMgr.ACCREDITIVS, userIBank.getCurrentDocument().getDoc_id());
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
 * @param anAccreditive_type java.lang.String
 * @param anPayer BusinessPartner
 * @param anAmount com.overstar.ildar.ibank.model.Money
 * @param anRcpt BusinessPartner
 * @param anAccount_40901 java.lang.String
 * @param newType_oper java.lang.String
 * @param newTerm java.util.Date
 * @param newType_accreditiv1 java.lang.String
 * @param newType_accreditiv2 java.lang.String
 * @param newCondition_pay java.lang.String
 * @param newAccreditiv_details java.lang.String
 * @param newAccreditiv_docs java.lang.String
 * @param newAdd_condition java.lang.String
 * @throws com.overstar.ildar.ibank.model.exceptions.PersistenceException
 * @throws com.overstar.ildar.ibank.model.exceptions.InvalidDocumentStatusException
 */
public void accreditiveUPDATE(
    IBank userIBank,
    java.sql.Date anDate_doc,
    String anNum_doc,
    String anSigners,
    String anAccreditive_type,
    BusinessPartner anPayer,
    Money anAmount,
    BusinessPartner anRcpt,
    String anAccount_40901,
    String newType_oper,
    java.sql.Date newTerm,
    String newType_accreditiv1,
    String newType_accreditiv2,
    String newCondition_pay,
    String newAccreditiv_details,
    String newAccreditiv_docs,
    String newAdd_condition)
    throws PersistenceException, InvalidDocumentStatusException {
    if (userIBank.getState() == userIBank.DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        Accreditive curDocument = (Accreditive) userIBank.getCurrentDocument();
        curDocument =
            new Accreditive(
                curDocument.getDoc_id(),
                new Integer(userIBank.getCurrentIClient().getClient_id().getIdAsString()),
                anDate_doc,
                anNum_doc,
                Document.NEW.getID(),
                anSigners,
                anAccreditive_type,
                anPayer,
                anAmount,
                anRcpt,
                anAccount_40901,
                newType_oper,
                newTerm,
                newType_accreditiv1,
                newType_accreditiv2,
                newCondition_pay,
                newAccreditiv_details,
                newAccreditiv_docs,
                newAdd_condition);
        AccreditiveTransactionMgr.storeAccreditive(curDocument);
        userIBank.setCurrentDocument(curDocument);
    }
    else {
        throw new IllegalStateException("You cannot add an document when the IBank is not in the DOCUMENTS_CHOOSEN state.");
    }
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
        out.println("<TITLE>ChooseAccreditivsActionServlet Error</TITLE>");
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
 * @param parameterNumber The number of the parameter value to return 
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
    int parameterNumber,
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
            paramValue = parameterValues[parameterNumber];
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
            String actionstr = getParameter(request, "btnsubmit", 0, true, false, true, "");

            int anDocType = Integer.parseInt(request.getParameter("formid"));
            String docdate = getParameter(request, "docdate", 0, true, false, true, "");
            String docnum = getParameter(request, "docnum", 0, true, false, true, "");
            String paykind = getParameter(request, "paykind", 0, true, false, false, " ");
            String payerinn = getParameter(request, "payerinn", 0, true, false, true, "");
            String payer = getParameter(request, "payer", 0, true, false, true, "");
            String payeracc = getParameter(request, "payeracc", 0, true, false, true, "");
            String payerbank = getParameter(request, "payerbank", 0, true, false, true, "");
            String payerbic = getParameter(request, "payerbic", 0, true, false, true, "");
            String payercoracc = getParameter(request, "payercoracc", 0, true, false, true, "");
            String docsum = getParameter(request, "docsum", 0, true, false, true, "");
            String receiverinn = getParameter(request, "receiverinn", 0, true, false, true, "");
            String receiver = getParameter(request, "receiver", 0, true, false, true, "");
            String receiveracc = getParameter(request, "receiveracc", 0, true, false, true, "");
            String receiverbank = getParameter(request, "receiverbank", 0, true, false, true, "");
            String receiverbic = getParameter(request, "receiverbic", 0, true, false, true, "");
            String receivercoracc = getParameter(request, "receivercoracc", 0, true, false, true, "");
            String account_40901 = getParameter(request, "akacc", 0, true, false, true, "");
            String opkind = getParameter(request, "opkind", 0, true, false, true, "");
            String term = getParameter(request, "paydate", 0, true, false, true, "");
            String type_accreditiv1 = getParameter(request, "akkind", 0, true, false, true, "");
            String type_accreditiv2 = getParameter(request, "akkind", 1, true, false, true, "");
            String condition_pay = getParameter(request, "payterm", 0, true, false, true, "");
            String accreditiv_details = getParameter(request, "paypurpose", 0, true, false, true, "");
            String accreditiv_docs = getParameter(request, "payaccord", 0, true, false, true, "");
            String add_condition = getParameter(request, "paypurpose2", 0, true, false, true, "");

            if (actionstr != null) {
                //validate syntax of actionstr.
                if (actionstr.equals("Save")) {
                    accreditiveUPDATE(
                        userIBank,
                        Date.valueOf(docdate),
                        docnum,
                        "000",
                        paykind,
                        new BusinessPartner(payerinn, payer, payeracc, payerbic, payerbank, payercoracc),
                        new Money(docsum),
                        new BusinessPartner(receiverinn, receiver, receiveracc, receiverbic, receiverbank, receivercoracc),
                        account_40901,
                        opkind,
                        Date.valueOf(term),
                        type_accreditiv1,
                        type_accreditiv2,
                        condition_pay,
                        accreditiv_details,
                        accreditiv_docs,
                        add_condition);
                    userIBank.getListDocuments();
                }
                else if (actionstr.equals("AddNew")) {
                    accreditiveADD(
                        userIBank,
                        Date.valueOf(docdate),
                        docnum,
                        "000",
                        paykind,
                        new BusinessPartner(payerinn, payer, payeracc, payerbic, payerbank, payercoracc),
                        new Money(docsum),
                        new BusinessPartner(receiverinn, receiver, receiveracc, receiverbic, receiverbank, receivercoracc),
                        account_40901,
                        opkind,
                        Date.valueOf(term),
                        type_accreditiv1,
                        type_accreditiv2,
                        condition_pay,
                        accreditiv_details,
                        accreditiv_docs,
                        add_condition);
                    userIBank.getListDocuments();
                }
                else if (actionstr.equals("Delete")) {
                    accreditiveDELETE(userIBank);
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
