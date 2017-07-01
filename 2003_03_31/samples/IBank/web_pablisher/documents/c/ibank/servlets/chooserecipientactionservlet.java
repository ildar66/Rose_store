package com.overstar.ildar.ibank.servlets;

import com.overstar.ildar.ibank.model.exceptions.PersistenceException;
import com.overstar.ildar.ibank.model.references.*;
import com.overstar.ildar.ibank.servlets.util.*;
import javax.servlet.*;
import com.overstar.ildar.ibank.model.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (26.09.2002 16:38:59)
 * @author: Shafigullin Ildar
 */
public class ChooseRecipientActionServlet extends javax.servlet.http.HttpServlet {
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
        out.println("<TITLE>ChooseRecipientActionServlet Error</TITLE>");
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
            String actionstr = getParameter(request, "btnaction", true, false, true, "");
            String sortByStr = getParameter(request, "sort", true, false, true, "");
            
            String nameStr = getParameter(request, "Title", true, false, true, "");
            String innStr = getParameter(request, "INN", true, false, true, "");
            String billStr = getParameter(request, "Account", true, false, true, "");
            String bicStr = getParameter(request, "BIC", true, false, true, "");
            String commentStr = getParameter(request, "comment", true, false, true, "");
            
            if (actionstr != null) {
                //validate syntax of actionstr.
                if (actionstr.equals("Save")) {
                    recipientUPDATE(userIBank, innStr, nameStr, billStr, bicStr, commentStr);
                    userIBank.getListRecipients(sortByStr);
                }
                else if (actionstr.equals("AddNew")) {
                    recipientADD(userIBank, innStr, nameStr, billStr, bicStr, commentStr);
                    userIBank.getListRecipients(sortByStr);
                }
                else if (actionstr.equals("Delete")) {
                    recipientDELETE(userIBank);
                    userIBank.getListRecipients(sortByStr);
                }
                else if (actionstr.equals("Cancel")) {
                    userIBank.getListRecipients(sortByStr);
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
    
public void recipientADD(
    IBank userIBank,
    String innStr,
    String nameStr,
    String billStr,
    String bicStr,
    String commentStr)  throws PersistenceException{
    if (userIBank.getState() == IBank.RECIPIENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Recipient is one of the Recipients associated with the current IClient...
        Recipient curRecipient =
            new Recipient(
                new Recipient.RecipientPK(),
                new Integer(userIBank.getCurrentIClient().getClient_id().getIdAsString()),
                innStr,
                nameStr,
                bicStr,
                billStr,
                commentStr);
        userIBank.setCurrentRecipient(curRecipient);
        RecipientTransactionMgr.storeRecipient(curRecipient);
    }
    else {
        throw new IllegalStateException("You cannot add an recipient when the IBank is not in the RECIPIENTS_CHOOSEN state.");
    }
}
public void recipientDELETE(IBank userIBank) throws PersistenceException {
    if (userIBank.getState() == IBank.RECIPIENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Recipient is one of the Recipients associated with the current IClient...
        RecipientTransactionMgr.deleteWithRecipientPK(userIBank.getCurrentRecipient().getId());
        userIBank.setCurrentRecipient(null);
    }
    else {
        throw new IllegalStateException("You cannot delete an recipient when the IBank is not in the RECIPIENTS_CHOOSEN state.");
    }
}
public void recipientUPDATE(
    IBank userIBank,
    String innStr,
    String nameStr,
    String billStr,
    String bicStr,
    String commentStr)
    throws PersistenceException {
    if (userIBank.getState() == IBank.RECIPIENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Recipient is one of the Recipients associated with the current IClient...
        Recipient tmpRecipient = userIBank.getCurrentRecipient();
        if (tmpRecipient != null) {
            tmpRecipient =
                new Recipient(tmpRecipient.getId(), tmpRecipient.rtClient_id(), innStr, nameStr, bicStr, billStr, commentStr);
            userIBank.setCurrentRecipient(tmpRecipient);
            RecipientTransactionMgr.storeRecipient(tmpRecipient);
        }
    }
    else {
        throw new IllegalStateException("You cannot update an recipient when the IBank is not in the RECIPIENTS_CHOOSEN state.");
    }
}
}
