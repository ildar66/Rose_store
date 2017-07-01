package com.overstar.ildar.ibank.servlets;

import com.overstar.ildar.ibank.model.exceptions.*;
import javax.servlet.*;
import com.overstar.ildar.ibank.model.*;
import com.overstar.ildar.ibank.model.documents.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (18.10.2002 11:52:48)
 * @author: Shafigullin Ildar
 */
public class ChooseDocumentsServlet extends javax.servlet.http.HttpServlet {
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 15:24:23)
 * @param docType int
 * @param aDocumentIDstr java.lang.String
 * @throws java.lang.IllegalStateException
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception java.lang.IllegalStateException The exception description.
 * @roseuid 3E0041990045
 */
public void chooseDocument(IBank userIBank, int docType, String aDocumentIDstr)
    throws java.lang.IllegalStateException, PersistenceException {
    if (userIBank.getState() == userIBank.DOCUMENTS_LISTED) {
        Document userDocument = null;
        if (docType == DocumentTransactionMgr.PAYMENTS) {
            userDocument = PaymentTransactionMgr.findWithPaymentPK(aDocumentIDstr);
        }
        else if (docType == DocumentTransactionMgr.ACCREDITIVS) {
            userDocument = AccreditiveTransactionMgr.findWithAccreditivePK(aDocumentIDstr);
        }
        else if (docType == DocumentTransactionMgr.PAYMENT_REQUESTS) {
        }
        else if (docType == DocumentTransactionMgr.ENCASHED_CONTRACTS) {
        }
        else if (docType == DocumentTransactionMgr.REFUSE_ACCEPT) {
        }
        else {
            throw new IllegalStateException("You cannot choose an Document when documentType wrong:" + docType);
        }
        userIBank.chooseDocument(userDocument);
    }
    else {
        throw new IllegalStateException("You cannot choose an Document when the IBank is not in the DOCUMENTS_LISTED state.");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 15:30:28)
 * @param anDocType int
 * @param userIBank com.overstar.ildar.ibank.model.IBank
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 */
public void documentDELETE(IBank userIBank, int anDocType) throws PersistenceException {
    if (userIBank.getState() == userIBank.DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        DocumentTransactionMgr.deleteWithDocumentPK(anDocType, userIBank.getCurrentDocument().getDoc_id());
        userIBank.setCurrentDocument(null);
    }
    else {
        throw new IllegalStateException("You cannot delete an Document when the IBank is not in the DOCUMENTS_CHOOSEN state.");
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
        out.println("<TITLE>ChooseDocumentServlet Error</TITLE>");
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
            String documentIDstr = request.getParameter("documentID");
            //тип документа из выпадающего списка типа документов:
            int formid = Integer.parseInt(request.getParameter("formid"));
            //тип документа из hidden field "doc_type":
            int anDocType = Integer.parseInt(request.getParameter("doc_type"));
            String fromDate = request.getParameter("fromdate");
            String toDate = request.getParameter("todate");
            String[] statuses = request.getParameterValues("status");
            if (statuses == null)
                statuses = new String[0];
            String sortByStr = request.getParameter("sort");

            Document userDocument;
            if (actionstr != null) {
                //validate syntax of actionstr.
                if (actionstr.equals("Edit")) {
                    chooseDocument(userIBank, anDocType, documentIDstr);
                }
                else if (actionstr.equals("AddNew")) {
                    userIBank.getDocTransMgr().setDoc_type(formid);
                    userIBank.chooseDocument(null);
                }
                else if (actionstr.equals("Delete")) {
                    chooseDocument(userIBank, anDocType, documentIDstr);
                    documentDELETE(userIBank, anDocType);
                    userIBank.getListDocuments(anDocType, fromDate, toDate, statuses, sortByStr);
                }
                else if (actionstr.equals("SortBy")) {
                    userIBank.getListDocuments(anDocType, fromDate, toDate, statuses, sortByStr);
                }
                else if (actionstr.equals("Read")) {
                    userIBank.getListDocuments(formid, fromDate, toDate, statuses, sortByStr);
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
