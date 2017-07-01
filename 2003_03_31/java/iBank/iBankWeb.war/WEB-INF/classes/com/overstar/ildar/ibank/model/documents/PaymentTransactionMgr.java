package com.overstar.ildar.ibank.model.documents;

import com.overstar.ildar.ibank.model.*;
import java.sql.*;
import com.overstar.ildar.ibank.model.Money;
import java.math.*;
import com.overstar.ildar.ibank.model.exceptions.*;
import java.util.Vector;
/**
 * Insert the type's description here.
 * Creation date: (24.01.2003 16:26:58)
 * @author: Shafigullin Ildar
 */
public class PaymentTransactionMgr {
    private static com.ibm.ivj.db.uibeans.Select ivjPaymentSelect = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjPaymentInsert = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjPaymentDelete = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjPaymentUpdate = null;

    private static com.ibm.ivj.db.uibeans.Select ivjIClientPaymentsSelect = null;
/**
 * PaymentTransactionMgr constructor comment.
 */
public PaymentTransactionMgr() {
	super();
}
   /**
    * Insert the method's description here.
    * Creation date: (24.10.2002 18:38:04)
    * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E09AFE101ED
    */
   public static synchronized void deleteWithPaymentPK(Document.DocumentPK anId) throws PersistenceException 
   {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        modify = getPaymentDelete();
        modify.setParameter("DOC_ID", anId.getIdAsString());
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }    
   }
   /**
    * Insert the method's description here.
    * Creation date: (17.10.2002 15:57:34)
    * @return boolean
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E09AFE10202
    */
   private static boolean exists(Payment anPayment) throws PersistenceException 
   {
    try {
        com.ibm.ivj.db.uibeans.Select select = getPaymentSelect();

        select.setParameter("DOC_ID", anPayment.getDoc_id().getIdAsString());
        select.execute();
        if (select.getNumRows() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }    
   }
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 12:08:02)
 * @return com.overstar.ildar.ibank.model.Payment
 * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
 * @return Payment
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E09AFE10215
 */
public static synchronized Payment findWithPaymentPK(Document.DocumentPK anId) throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getPaymentSelect();
        select.setParameter("DOC_ID", anId.getIdAsString());
        select.execute();

        if (select.getRowCount() <= 0) {
            throw new PaymentNotFoundException("The Payment with primary key " + anId.getIdAsString() + " was not found.");
        }

        select.firstRow();
        String tmpPaymentDOC_ID = (String) select.getColumnValue("PAYMENTS.DOC_ID");
        Integer tmpPaymentCLIENT_ID = (Integer) select.getColumnValue("PAYMENTS.CLIENT_ID");
        Date tmpPaymentDATE_DOC = (Date) select.getColumnValue("PAYMENTS.DATE_DOC");
        String tmpPaymentNUM_DOC = (String) select.getColumnValue("PAYMENTS.NUM_DOC");
        String tmpPaymentPAYMENT_TYPE = (String) select.getColumnValue("PAYMENTS.PAYMENT_TYPE");
        String tmpPaymentPAYER_INN = (String) select.getColumnValue("PAYMENTS.PAYER_INN");
        String tmpPaymentPAYER_NAME = (String) select.getColumnValue("PAYMENTS.PAYER_NAME");
        String tmpPaymentPAYER_ACCOUNT = (String) select.getColumnValue("PAYMENTS.PAYER_ACCOUNT");
        BigDecimal tmpPaymentAMOUNT = (BigDecimal) select.getColumnValue("PAYMENTS.AMOUNT");
        String tmpPaymentPAYER_BANK_NAME = (String) select.getColumnValue("PAYMENTS.PAYER_BANK_NAME");
        String tmpPaymentPAYER_BANK_BIC = (String) select.getColumnValue("PAYMENTS.PAYER_BANK_BIC");
        String tmpPaymentPAYER_BANK_ACC = (String) select.getColumnValue("PAYMENTS.PAYER_BANK_ACC");
        String tmpPaymentRCPT_INN = (String) select.getColumnValue("PAYMENTS.RCPT_INN");
        String tmpPaymentRCPT_NAME = (String) select.getColumnValue("PAYMENTS.RCPT_NAME");
        String tmpPaymentRCPT_ACCOUNT = (String) select.getColumnValue("PAYMENTS.RCPT_ACCOUNT");
        String tmpPaymentRCPT_BANK_NAME = (String) select.getColumnValue("PAYMENTS.RCPT_BANK_NAME");
        String tmpPaymentRCPT_BANK_BIC = (String) select.getColumnValue("PAYMENTS.RCPT_BANK_BIC");
        String tmpPaymentRCPT_BANK_ACC = (String) select.getColumnValue("PAYMENTS.RCPT_BANK_ACC");
        String tmpPaymentTYPE_OPER = (String) select.getColumnValue("PAYMENTS.TYPE_OPER");
        String tmpPaymentQUEUE = (String) select.getColumnValue("PAYMENTS.QUEUE");
        Date tmpPaymentTERM = (Date) select.getColumnValue("PAYMENTS.TERM");
        String tmpPaymentPAYMENT_DETAILS = (String) select.getColumnValue("PAYMENTS.PAYMENT_DETAILS");
        String tmpPaymentKPP = (String) select.getColumnValue("PAYMENTS.KPP");
        String tmpPaymentSTATUS_DOC = (String) select.getColumnValue("PAYMENTS.STATUS_DOC");
        String tmpPaymentSIGNERS = (String) select.getColumnValue("PAYMENTS.SIGNERS");

        Payment tempPayment =
            new Payment(
                new Document.DocumentPK(tmpPaymentDOC_ID),
                tmpPaymentCLIENT_ID,
                tmpPaymentDATE_DOC,
                tmpPaymentNUM_DOC,
                tmpPaymentSTATUS_DOC,
                tmpPaymentSIGNERS,
                tmpPaymentPAYMENT_TYPE,
                new BusinessPartner(
                    tmpPaymentPAYER_INN,
                    tmpPaymentPAYER_NAME,
                    tmpPaymentPAYER_ACCOUNT,
                    tmpPaymentPAYER_BANK_BIC,
                    tmpPaymentPAYER_BANK_NAME,
                    tmpPaymentPAYER_BANK_ACC),
                new Money(tmpPaymentAMOUNT.toString()),
                new BusinessPartner(
                    tmpPaymentRCPT_INN,
                    tmpPaymentRCPT_NAME,
                    tmpPaymentRCPT_ACCOUNT,
                    tmpPaymentRCPT_BANK_BIC,
                    tmpPaymentRCPT_BANK_NAME,
                    tmpPaymentRCPT_BANK_ACC),
                tmpPaymentTYPE_OPER,
                tmpPaymentQUEUE,
                tmpPaymentTERM,
                tmpPaymentPAYMENT_DETAILS,
                tmpPaymentKPP);

        return tempPayment;
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
   /**
    * Insert the method's description here.
    * Creation date: (17.10.2002 14:57:46)
    * @return com.overstar.ildar.ibank.model.Payment
    * @param anDoc_IDStr java.lang.String
    * @return Payment
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E09AFE10233
    */
   public static synchronized Payment findWithPaymentPK(String anDoc_IDStr) throws PersistenceException 
   {
	return findWithPaymentPK(new Document.DocumentPK(anDoc_IDStr));    
   }
   /**
    * Return the IClientDocumentsSelect property value.
    * @return com.ibm.ivj.db.uibeans.Select
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041A2026F
    */
   private static com.ibm.ivj.db.uibeans.Select getIClientPaymentsSelect() 
   {
	if (ivjIClientPaymentsSelect == null) {
		try {
			ivjIClientPaymentsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientPaymentsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(PaymentDAB.connToIBank(), PaymentDAB.IClientPaymentsSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientPaymentsSelect;    
   }
   /**
    * Return the PaymentDelete property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E09AFE10247
    */
   private static com.ibm.ivj.db.uibeans.Modify getPaymentDelete() 
   {
	if (ivjPaymentDelete == null) {
		try {
			ivjPaymentDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjPaymentDelete.setAction(new com.ibm.ivj.db.uibeans.Query(PaymentDAB.connToIBank(), PaymentDAB.PaymentDeleteSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPaymentDelete;    
   }
   /**
    * Return the PaymentInsert property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E09AFE10265
    */
   private static com.ibm.ivj.db.uibeans.Modify getPaymentInsert() 
   {
	if (ivjPaymentInsert == null) {
		try {
			ivjPaymentInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjPaymentInsert.setAction(new com.ibm.ivj.db.uibeans.Query(PaymentDAB.connToIBank(), PaymentDAB.PaymentInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPaymentInsert;    
   }
   /**
    * Return the PaymentSelect property value.
    * @return com.ibm.ivj.db.uibeans.Select
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E09AFE1026F
    */
   private static com.ibm.ivj.db.uibeans.Select getPaymentSelect() 
   {
	if (ivjPaymentSelect == null) {
		try {
			ivjPaymentSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjPaymentSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(PaymentDAB.connToIBank(), PaymentDAB.PaymentSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPaymentSelect;    
   }
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 15:31:18)
 * @param iClient
 * @param fromdate
 * @param todate
 * @param anStatuses
 * @param aSortBy
 * @return java.util.Vector
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041A3014E
 */
public static synchronized Vector getPaymentsForIClient(
    String iClient,
    String fromdate,
    String todate,
    String[] anStatuses,
    String aSortBy)
    throws PersistenceException, InvalidDocumentStatusException {
    try {
        Vector tmpPaymentsAll = new Vector(0); // lazy init. 
        com.ibm.ivj.db.uibeans.Select select = getIClientPaymentsSelect();
        String statement =
            "SELECT ILDAR.PAYMENTS.DOC_ID, ILDAR.PAYMENTS.CLIENT_ID, ILDAR.PAYMENTS.DATE_DOC, ILDAR.PAYMENTS.NUM_DOC, ILDAR.PAYMENTS.PAYMENT_TYPE, ILDAR.PAYMENTS.PAYER_INN, ILDAR.PAYMENTS.PAYER_NAME, ILDAR.PAYMENTS.PAYER_ACCOUNT, ILDAR.PAYMENTS.AMOUNT, ILDAR.PAYMENTS.PAYER_BANK_NAME, ILDAR.PAYMENTS.PAYER_BANK_BIC, ILDAR.PAYMENTS.PAYER_BANK_ACC, ILDAR.PAYMENTS.RCPT_INN, ILDAR.PAYMENTS.RCPT_NAME, ILDAR.PAYMENTS.RCPT_ACCOUNT, ILDAR.PAYMENTS.RCPT_BANK_NAME, ILDAR.PAYMENTS.RCPT_BANK_BIC, ILDAR.PAYMENTS.RCPT_BANK_ACC, ILDAR.PAYMENTS.TYPE_OPER, ILDAR.PAYMENTS.QUEUE, ILDAR.PAYMENTS.TERM, ILDAR.PAYMENTS.PAYMENT_DETAILS, ILDAR.PAYMENTS.KPP, ILDAR.PAYMENTS.STATUS_DOC, ILDAR.PAYMENTS.SIGNERS FROM ILDAR.PAYMENTS WHERE ( ( ILDAR.PAYMENTS.CLIENT_ID = :CLIENT_ID ) AND ( ILDAR.PAYMENTS.DATE_DOC between :FROMDATE and :TODATE ) ) ";
        if (anStatuses.length != 0) {
            StringBuffer stats = new StringBuffer(anStatuses[0]);
            for (int i = 1; i < anStatuses.length; i++) {
                stats.append("','" + anStatuses[i]);
            }
            select.getStatementMetaData().setSQL(
                statement + " AND ILDAR.PAYMENTS.STATUS_DOC IN('" + stats + "')" + " order by " + aSortBy);
        }
        else {
            return tmpPaymentsAll;
        }

        select.setParameterFromString("CLIENT_ID", iClient);
        select.setParameterFromString("FROMDATE", fromdate);
        select.setParameterFromString("TODATE", todate);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpPaymentDOC_ID = (String) select.getColumnValue("PAYMENTS.DOC_ID");
                Integer tmpPaymentCLIENT_ID = (Integer) select.getColumnValue("PAYMENTS.CLIENT_ID");
                java.sql.Date tmpPaymentDATE_DOC = (java.sql.Date) select.getColumnValue("PAYMENTS.DATE_DOC");
                String tmpPaymentNUM_DOC = (String) select.getColumnValue("PAYMENTS.NUM_DOC");
                String tmpPaymentPAYMENT_TYPE = (String) select.getColumnValue("PAYMENTS.PAYMENT_TYPE");
                String tmpPaymentPAYER_INN = (String) select.getColumnValue("PAYMENTS.PAYER_INN");
                String tmpPaymentPAYER_NAME = (String) select.getColumnValue("PAYMENTS.PAYER_NAME");
                String tmpPaymentPAYER_ACCOUNT = (String) select.getColumnValue("PAYMENTS.PAYER_ACCOUNT");
                BigDecimal tmpPaymentAMOUNT = (BigDecimal) select.getColumnValue("PAYMENTS.AMOUNT");
                String tmpPaymentPAYER_BANK_NAME = (String) select.getColumnValue("PAYMENTS.PAYER_BANK_NAME");
                String tmpPaymentPAYER_BANK_BIC = (String) select.getColumnValue("PAYMENTS.PAYER_BANK_BIC");
                String tmpPaymentPAYER_BANK_ACC = (String) select.getColumnValue("PAYMENTS.PAYER_BANK_ACC");
                String tmpPaymentRCPT_INN = (String) select.getColumnValue("PAYMENTS.RCPT_INN");
                String tmpPaymentRCPT_NAME = (String) select.getColumnValue("PAYMENTS.RCPT_NAME");
                String tmpPaymentRCPT_ACCOUNT = (String) select.getColumnValue("PAYMENTS.RCPT_ACCOUNT");
                String tmpPaymentRCPT_BANK_NAME = (String) select.getColumnValue("PAYMENTS.RCPT_BANK_NAME");
                String tmpPaymentRCPT_BANK_BIC = (String) select.getColumnValue("PAYMENTS.RCPT_BANK_BIC");
                String tmpPaymentRCPT_BANK_ACC = (String) select.getColumnValue("PAYMENTS.RCPT_BANK_ACC");
                String tmpPaymentTYPE_OPER = (String) select.getColumnValue("PAYMENTS.TYPE_OPER");
                String tmpPaymentQUEUE = (String) select.getColumnValue("PAYMENTS.QUEUE");
                java.sql.Date tmpPaymentTERM = (java.sql.Date) select.getColumnValue("PAYMENTS.TERM");
                String tmpPaymentPAYMENT_DETAILS = (String) select.getColumnValue("PAYMENTS.PAYMENT_DETAILS");
                String tmpPaymentKPP = (String) select.getColumnValue("PAYMENTS.KPP");
                String tmpPaymentSTATUS_DOC = (String) select.getColumnValue("PAYMENTS.STATUS_DOC");
                String tmpPaymentSIGNERS = (String) select.getColumnValue("PAYMENTS.SIGNERS");
                // add the new payment to the vector holding all Documents associated with
                // this IClient.
                Payment tmpPayment =
                    new Payment(
                        new Document.DocumentPK(tmpPaymentDOC_ID),
                        tmpPaymentCLIENT_ID,
                        tmpPaymentDATE_DOC,
                        tmpPaymentNUM_DOC,
                        tmpPaymentSTATUS_DOC,
                        tmpPaymentSIGNERS,
                        tmpPaymentPAYMENT_TYPE,
                        new BusinessPartner(
                            tmpPaymentPAYER_INN,
                            tmpPaymentPAYER_NAME,
                            tmpPaymentPAYER_ACCOUNT,
                            tmpPaymentPAYER_BANK_BIC,
                            tmpPaymentPAYER_BANK_NAME,
                            tmpPaymentPAYER_BANK_ACC),
                        new Money(tmpPaymentAMOUNT.toString()),
                        new BusinessPartner(
                            tmpPaymentRCPT_INN,
                            tmpPaymentRCPT_NAME,
                            tmpPaymentRCPT_ACCOUNT,
                            tmpPaymentRCPT_BANK_BIC,
                            tmpPaymentRCPT_BANK_NAME,
                            tmpPaymentRCPT_BANK_ACC),
                        tmpPaymentTYPE_OPER,
                        tmpPaymentQUEUE,
                        tmpPaymentTERM,
                        tmpPaymentPAYMENT_DETAILS,
                        tmpPaymentKPP);

                tmpPaymentsAll.addElement(tmpPayment);
                select.nextRow();
            }
        }
        //return new Vector(tmpPaymentsAll);
        return tmpPaymentsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
   /**
    * Return the PaymentUpdate property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E09AFE10283
    */
   private static com.ibm.ivj.db.uibeans.Modify getPaymentUpdate() 
   {
	if (ivjPaymentUpdate == null) {
		try {
			ivjPaymentUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjPaymentUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(PaymentDAB.connToIBank(), PaymentDAB.PaymentUpdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPaymentUpdate;    
   }
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 * @roseuid 3E0041BA00CF
 */
private static void handleException(java.lang.Throwable exception) {

    /* Uncomment the following lines to print uncaught exceptions to stdout */
    // System.out.println("--------- UNCAUGHT EXCEPTION ---------");
    exception.printStackTrace(System.out);
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 * @roseuid 3E09AFE20071
 */
public static void main(java.lang.String[] args) {
    Payment tempPayment;

    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        String newPaymentIDstr = "4"; // определите newPaymentIDstr !!!
        String newClientIDstr = "3"; // определите newClientIDstr !!!
        Integer newClient_ID = new Integer(newClientIDstr);
        String newStatus_doc = "0"; //"0"-:-"7"
        System.out.println("Make new Payment with key " + newPaymentIDstr + "\n"); //Может убить существующую запись в базе!!!
        tempPayment =
            new Payment(
                new Document.DocumentPK(newPaymentIDstr),
                newClient_ID,
                new java.sql.Date(System.currentTimeMillis()),
                "№" + newPaymentIDstr,
                newStatus_doc,
                "S" + newPaymentIDstr,
                Payment.ELECTRONIC,
                new BusinessPartner(
                    "Payer_inn" + newPaymentIDstr,
                    "Payer_name" + newPaymentIDstr,
                    "Payer_account" + newPaymentIDstr,
                    "P_b_bic" + newPaymentIDstr,
                    "Payer_bank_name" + newPaymentIDstr,
                    "Payer_bank_acc" + newPaymentIDstr),
                new Money(new BigInteger("1111"), 2),
                new BusinessPartner(
                    "Rcpt_inn" + newPaymentIDstr,
                    "Rcpt_name" + newPaymentIDstr,
                    "Rcpt_account" + newPaymentIDstr,
                    "R_b_bic" + newPaymentIDstr,
                    "Rcpt_bank_name" + newPaymentIDstr,
                    "Rcpt_bank_acc" + newPaymentIDstr),
                "01",
                newPaymentIDstr,
                new java.sql.Date(System.currentTimeMillis()),
                "Payment_details" + newPaymentIDstr,
                "Kpp" + newPaymentIDstr);
        PaymentTransactionMgr.storePayment(tempPayment);
        System.out.println(tempPayment);
        System.out.println("______________________________________");
        System.out.println();

        ////////////////////////////////////////////////////////////////
        String getPaymentIDstr = "3";
        System.out.println("Find Payment with key " + getPaymentIDstr + ".\n");
        tempPayment = findWithPaymentPK(getPaymentIDstr);
        System.out.println(tempPayment);
        System.out.println("______________________________________");
        System.out.println();
        ///////////////////////////////////////////////////////////////

        System.out.println("Make new Payment with unique key  \n"); //заранее уникальный :)
        tempPayment =
            new Payment(
                new Document.DocumentPK(),
                newClient_ID,
                new java.sql.Date(System.currentTimeMillis()),
                "№" + newPaymentIDstr,
                newStatus_doc,
                "S" + newPaymentIDstr,
                Payment.ELECTRONIC,
                new BusinessPartner(
                    "Payer_inn" + newPaymentIDstr,
                    "Payer_name" + newPaymentIDstr,
                    "Payer_account" + newPaymentIDstr,
                    "P_b_bic" + newPaymentIDstr,
                    "Payer_bank_name" + newPaymentIDstr,
                    "Payer_bank_acc" + newPaymentIDstr),
                new Money(newPaymentIDstr + ".05"),
                new BusinessPartner(
                    "Rcpt_inn" + newPaymentIDstr,
                    "Rcpt_name" + newPaymentIDstr,
                    "Rcpt_account" + newPaymentIDstr,
                    "R_b_bic" + newPaymentIDstr,
                    "Rcpt_bank_name" + newPaymentIDstr,
                    "Rcpt_bank_acc" + newPaymentIDstr),
                "01",
                newPaymentIDstr,
                new java.sql.Date(System.currentTimeMillis()),
                "Payment_details" + newPaymentIDstr,
                "Kpp" + newPaymentIDstr);
        System.out.println(tempPayment);
        PaymentTransactionMgr.storePayment(tempPayment);
        System.out.println("______________________________________");
        System.out.println();
        System.out.println("Find Payment with unique key " + tempPayment.getDoc_id() + ".\n");
        tempPayment = findWithPaymentPK(tempPayment.getDoc_id().getIdAsString());
        System.out.println(tempPayment);
        System.out.println("______________________________________");
        System.out.println();

        //Документы:
        System.out.println("Find Payments for iClient=" + newClient_ID + ":\n");
        String fromDate = "2001-1-1";
        String toDate = "2003-10-23";
        String sortBy = "date_doc desc"; //-сортировки по полю - amount, status_doc, num_doc, rcpt_name
        Vector payments =
            PaymentTransactionMgr.getPaymentsForIClient(
                newClient_ID.toString(),
                fromDate,
                toDate,
                new String[] { "0", "1", "2", "3" },
                sortBy);
        System.out.println("Payments: " + payments.size() + ":\n" + payments);
        System.out.println("______________________________________");
        System.out.println();

    }
    catch (Throwable ex) {
        System.out.println("An exception occured while testing:\n");
        ex.printStackTrace();
    }

    System.out.println("Main() ended at: " + new java.util.Date());
}
   /**
    * Insert the method's description here.
    * Creation date: (17.10.2002 15:55:04)
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E09AFE20162
    */
public static synchronized void storePayment(Payment aPayment) throws PersistenceException 
   {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists(aPayment)) {
            modify = getPaymentUpdate();
            modify.setParameter("ID", aPayment.getDoc_id().getIdAsString());

        }
        else {
            //record doesn't exist.
            modify = getPaymentInsert();
        }

        modify.setParameterFromString("DOC_ID", aPayment.getDoc_id().getIdAsString());
        modify.setParameter("CLIENT_ID", aPayment.rtClient_id());
        modify.setParameter("DATE_DOC", aPayment.rtDate_doc());
        modify.setParameter("NUM_DOC", aPayment.rtNum_doc());
        modify.setParameter("PAYMENT_TYPE", aPayment.rtPayment_type());
        modify.setParameter("PAYER_INN", aPayment.rtPayer().rtInn());
        modify.setParameter("PAYER_NAME", aPayment.rtPayer().rtName());
        modify.setParameter("PAYER_ACCOUNT", aPayment.rtPayer().rtBill());
        modify.setParameter("AMOUNT", aPayment.rtAmount());
        modify.setParameter("PAYER_BANK_NAME", aPayment.rtPayer().rtBank_name());
        modify.setParameter("PAYER_BANK_BIC", aPayment.rtPayer().rtBank_Bic());
        modify.setParameter("PAYER_BANK_ACC", aPayment.rtPayer().rtBank_acc());
        modify.setParameter("RCPT_INN", aPayment.rtRecipient().rtInn());
        modify.setParameter("RCPT_NAME", aPayment.rtRecipient().rtName());
        modify.setParameter("RCPT_ACCOUNT", aPayment.rtRecipient().rtBill());
        modify.setParameter("RCPT_BANK_NAME", aPayment.rtRecipient().rtBank_name());
        modify.setParameter("RCPT_BANK_BIC", aPayment.rtRecipient().rtBank_Bic());
        modify.setParameter("RCPT_BANK_ACC", aPayment.rtRecipient().rtBank_acc());
        modify.setParameter("TYPE_OPER", aPayment.rtType_oper());
        modify.setParameter("QUEUE", aPayment.rtQueue());
        modify.setParameter("TERM", aPayment.rtTerm());
        modify.setParameter("PAYMENT_DETAILS", aPayment.rtPayment_details());
        modify.setParameter("KPP", aPayment.rtKpp());
        modify.setParameter("STATUS_DOC", aPayment.rtStatus_doc().getID());
        modify.setParameter("SIGNERS", aPayment.rtSigners());

        modify.execute();
        //load();

    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }    
   }
}
