package com.overstar.ildar.ibank.model.documents;

import com.overstar.ildar.ibank.model.*;
import com.overstar.ildar.ibank.model.exceptions.*;
import java.sql.*;
import java.math.*;
import java.util.Vector;
/**
 * Insert the type's description here.
 * Creation date: (13.02.2003 10:55:24)
 * @author: Shafigullin Ildar
 */
public class AccreditiveTransactionMgr {
	private static com.ibm.ivj.db.uibeans.Modify ivjAccreditivInsert = null;
	private static com.ibm.ivj.db.uibeans.Select ivjAccreditivSelect = null;
	private static com.ibm.ivj.db.uibeans.Select ivjIClientAccreditivsSelect = null;
	private static com.ibm.ivj.db.uibeans.Modify ivjAccreditivUpdate = null;
	private static com.ibm.ivj.db.uibeans.Modify ivjAccreditivDelete = null;
/**
 * AccreditivsTransactionMgr constructor comment.
 */
public AccreditiveTransactionMgr() {
    super();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2003 14:19:36)
 * @param anId com.overstar.ildar.ibank.model.documents.Document.DocumentPK
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 */
public static synchronized void deleteWithAccreditivePK(Document.DocumentPK anId)
    throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        modify = getAccreditivDelete();
        modify.setParameter("DOC_ID", anId.getIdAsString());
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2003 14:27:41)
 * @return boolean
 * @param anAccreditive com.overstar.ildar.ibank.model.documents.Accreditive
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 */
private static boolean exists(Accreditive anAccreditive)
    throws com.overstar.ildar.ibank.model.exceptions.PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getAccreditivSelect();

        select.setParameter("DOC_ID", anAccreditive.getDoc_id().getIdAsString());
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
 * Creation date: (13.02.2003 14:34:46)
 * @return com.overstar.ildar.ibank.model.documents.Accreditive
 * @param anId com.overstar.ildar.ibank.model.documents.Document.DocumentPK
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 */
public static synchronized Accreditive findWithAccreditivePK(Document.DocumentPK anId)
    throws com.overstar.ildar.ibank.model.exceptions.PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getAccreditivSelect();
        select.setParameter("DOC_ID", anId.getIdAsString());
        select.execute();

        if (select.getRowCount() <= 0) {
            throw new AccreditiveNotFoundException("The Accreditive with primary key " + anId.getIdAsString() + " was not found.");
        }

        select.firstRow();
        String tmpAccreditivDOC_ID = (String) select.getColumnValue("ACCREDITIVS.DOC_ID");
        Integer tmpAccreditivCLIENT_ID = (Integer) select.getColumnValue("ACCREDITIVS.CLIENT_ID");
        Date tmpAccreditivDATE_DOC = (Date) select.getColumnValue("ACCREDITIVS.DATE_DOC");
        String tmpAccreditivNUM_DOC = (String) select.getColumnValue("ACCREDITIVS.NUM_DOC");
        String tmpAccreditivACCREDITIV_TYPE = (String) select.getColumnValue("ACCREDITIVS.ACCREDITIV_TYPE");
        String tmpAccreditivPAYER_INN = (String) select.getColumnValue("ACCREDITIVS.PAYER_INN");
        String tmpAccreditivPAYER_NAME = (String) select.getColumnValue("ACCREDITIVS.PAYER_NAME");
        String tmpAccreditivPAYER_ACCOUNT = (String) select.getColumnValue("ACCREDITIVS.PAYER_ACCOUNT");
        BigDecimal tmpAccreditivAMOUNT = (BigDecimal) select.getColumnValue("ACCREDITIVS.AMOUNT");
        String tmpAccreditivPAYER_BANK_NAME = (String) select.getColumnValue("ACCREDITIVS.PAYER_BANK_NAME");
        String tmpAccreditivPAYER_BANK_BIC = (String) select.getColumnValue("ACCREDITIVS.PAYER_BANK_BIC");
        String tmpAccreditivPAYER_BANK_ACC = (String) select.getColumnValue("ACCREDITIVS.PAYER_BANK_ACC");
        String tmpAccreditivRCPT_INN = (String) select.getColumnValue("ACCREDITIVS.RCPT_INN");
        String tmpAccreditivRCPT_NAME = (String) select.getColumnValue("ACCREDITIVS.RCPT_NAME");
        String tmpAccreditivRCPT_ACCOUNT = (String) select.getColumnValue("ACCREDITIVS.RCPT_ACCOUNT");
        String tmpAccreditivRCPT_BANK_NAME = (String) select.getColumnValue("ACCREDITIVS.RCPT_BANK_NAME");
        String tmpAccreditivRCPT_BANK_BIC = (String) select.getColumnValue("ACCREDITIVS.RCPT_BANK_BIC");
        String tmpAccreditivRCPT_BANK_ACC = (String) select.getColumnValue("ACCREDITIVS.RCPT_BANK_ACC");
        String tmpAccreditivACCOUNT_40901 = (String) select.getColumnValue("ACCREDITIVS.ACCOUNT_40901");
        String tmpAccreditivTYPE_OPER = (String) select.getColumnValue("ACCREDITIVS.TYPE_OPER");
        Date tmpAccreditivTERM = (Date) select.getColumnValue("ACCREDITIVS.TERM");
        String tmpAccreditivTYPE_ACCREDITIV1 = (String) select.getColumnValue("ACCREDITIVS.TYPE_ACCREDITIV1");
        String tmpAccreditivTYPE_ACCREDITIV2 = (String) select.getColumnValue("ACCREDITIVS.TYPE_ACCREDITIV2");
        String tmpAccreditivCONDITION_PAY = (String) select.getColumnValue("ACCREDITIVS.CONDITION_PAY");
        String tmpAccreditivACCREDITIV_DETAILS = (String) select.getColumnValue("ACCREDITIVS.ACCREDITIV_DETAILS");
        String tmpAccreditivACCREDITIV_DOCS = (String) select.getColumnValue("ACCREDITIVS.ACCREDITIV_DOCS");
        String tmpAccreditivADD_CONDITION = (String) select.getColumnValue("ACCREDITIVS.ADD_CONDITION");
        String tmpAccreditivSTATUS_DOC = (String) select.getColumnValue("ACCREDITIVS.STATUS_DOC");
        String tmpAccreditivSIGNERS = (String) select.getColumnValue("ACCREDITIVS.SIGNERS");

        Accreditive tempAccreditive =
            new Accreditive(
                new Document.DocumentPK(tmpAccreditivDOC_ID),
                tmpAccreditivCLIENT_ID,
                tmpAccreditivDATE_DOC,
                tmpAccreditivNUM_DOC,
                tmpAccreditivSTATUS_DOC,
                tmpAccreditivSIGNERS,
                tmpAccreditivACCREDITIV_TYPE,
                new BusinessPartner(
                    tmpAccreditivPAYER_INN,
                    tmpAccreditivPAYER_NAME,
                    tmpAccreditivPAYER_ACCOUNT,
                    tmpAccreditivPAYER_BANK_BIC,
                    tmpAccreditivPAYER_BANK_NAME,
                    tmpAccreditivPAYER_BANK_ACC),
                new Money(tmpAccreditivAMOUNT.toString()),
                new BusinessPartner(
                    tmpAccreditivRCPT_INN,
                    tmpAccreditivRCPT_NAME,
                    tmpAccreditivRCPT_ACCOUNT,
                    tmpAccreditivRCPT_BANK_BIC,
                    tmpAccreditivRCPT_BANK_NAME,
                    tmpAccreditivRCPT_BANK_ACC),
                tmpAccreditivACCOUNT_40901,
                tmpAccreditivTYPE_OPER,
                tmpAccreditivTERM,
                tmpAccreditivTYPE_ACCREDITIV1,
                tmpAccreditivTYPE_ACCREDITIV2,
                tmpAccreditivCONDITION_PAY,
                tmpAccreditivACCREDITIV_DETAILS,
                tmpAccreditivACCREDITIV_DOCS,
                tmpAccreditivADD_CONDITION);

        return tempAccreditive;
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2003 14:31:40)
 * @return com.overstar.ildar.ibank.model.documents.Accreditive
 * @param anDoc_IDStr java.lang.String
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 */
public static synchronized Accreditive findWithAccreditivePK(String anDoc_IDStr) throws com.overstar.ildar.ibank.model.exceptions.PersistenceException {
	return findWithAccreditivePK(new Document.DocumentPK(anDoc_IDStr));
}
/**
 * Return the AccreditivDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private static com.ibm.ivj.db.uibeans.Modify getAccreditivDelete() {
	if (ivjAccreditivDelete == null) {
		try {
			ivjAccreditivDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjAccreditivDelete.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.documents.AccreditivDAB.connToIBank(), com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivDeleteSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccreditivDelete;
}
/**
 * Return the AccreditivInsert property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private static com.ibm.ivj.db.uibeans.Modify getAccreditivInsert() {
	if (ivjAccreditivInsert == null) {
		try {
			ivjAccreditivInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjAccreditivInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.documents.AccreditivDAB.connToIBank(), com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccreditivInsert;
}
/**
 * Return the AccreditivSelectSQL property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private static com.ibm.ivj.db.uibeans.Select getAccreditivSelect() {
	if (ivjAccreditivSelect == null) {
		try {
			ivjAccreditivSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjAccreditivSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.documents.AccreditivDAB.connToIBank(), com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccreditivSelect;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2003 15:40:26)
 * @return java.util.Vector
 * @param iClient java.lang.String
 * @param fromdate java.lang.String
 * @param todate java.lang.String
 * @param anStatuses java.lang.String[]
 * @param aSortBy java.lang.String
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 * @exception com.overstar.ildar.ibank.model.exceptions.InvalidDocumentStatusException The exception description.
 */
public static synchronized Vector getAccreditivsForIClient(
    String iClient,
    String fromdate,
    String todate,
    String[] anStatuses,
    String aSortBy)
    throws
        com.overstar.ildar.ibank.model.exceptions.PersistenceException,
        com.overstar.ildar.ibank.model.exceptions.InvalidDocumentStatusException {
    try {
        Vector tmpAccreditivsAll = new Vector(0); // lazy init. 
        com.ibm.ivj.db.uibeans.Select select = getIClientAccreditivsSelect();
        String statement =
            "SELECT ILDAR.ACCREDITIVS.DOC_ID, ILDAR.ACCREDITIVS.CLIENT_ID, ILDAR.ACCREDITIVS.DATE_DOC, ILDAR.ACCREDITIVS.NUM_DOC, ILDAR.ACCREDITIVS.ACCREDITIV_TYPE, ILDAR.ACCREDITIVS.PAYER_INN, ILDAR.ACCREDITIVS.PAYER_NAME, ILDAR.ACCREDITIVS.PAYER_ACCOUNT, ILDAR.ACCREDITIVS.AMOUNT, ILDAR.ACCREDITIVS.PAYER_BANK_NAME, ILDAR.ACCREDITIVS.PAYER_BANK_BIC, ILDAR.ACCREDITIVS.PAYER_BANK_ACC, ILDAR.ACCREDITIVS.RCPT_INN, ILDAR.ACCREDITIVS.RCPT_NAME, ILDAR.ACCREDITIVS.RCPT_ACCOUNT, ILDAR.ACCREDITIVS.RCPT_BANK_NAME, ILDAR.ACCREDITIVS.RCPT_BANK_BIC, ILDAR.ACCREDITIVS.RCPT_BANK_ACC, ILDAR.ACCREDITIVS.ACCOUNT_40901, ILDAR.ACCREDITIVS.TYPE_OPER, ILDAR.ACCREDITIVS.TERM, ILDAR.ACCREDITIVS.TYPE_ACCREDITIV1, ILDAR.ACCREDITIVS.TYPE_ACCREDITIV2, ILDAR.ACCREDITIVS.CONDITION_PAY, ILDAR.ACCREDITIVS.ACCREDITIV_DETAILS, ILDAR.ACCREDITIVS.ACCREDITIV_DOCS, ILDAR.ACCREDITIVS.ADD_CONDITION, ILDAR.ACCREDITIVS.STATUS_DOC, ILDAR.ACCREDITIVS.SIGNERS FROM ILDAR.ACCREDITIVS WHERE ( ( ILDAR.ACCREDITIVS.CLIENT_ID = :CLIENT_ID ) AND ( ILDAR.ACCREDITIVS.DATE_DOC between :FROMDATE and :TODATE ) ) ";
        if (anStatuses.length != 0) {
            StringBuffer stats = new StringBuffer(anStatuses[0]);
            for (int i = 1; i < anStatuses.length; i++) {
                stats.append("','" + anStatuses[i]);
            }
            select.getStatementMetaData().setSQL(
                statement + " AND ILDAR.ACCREDITIVS.STATUS_DOC IN('" + stats + "')" + " order by " + aSortBy);
        }
        else {
            return tmpAccreditivsAll;
        }

        select.setParameterFromString("CLIENT_ID", iClient);
        select.setParameterFromString("FROMDATE", fromdate);
        select.setParameterFromString("TODATE", todate);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpAccreditivDOC_ID = (String) select.getColumnValue("ACCREDITIVS.DOC_ID");
                Integer tmpAccreditivCLIENT_ID = (Integer) select.getColumnValue("ACCREDITIVS.CLIENT_ID");
                Date tmpAccreditivDATE_DOC = (Date) select.getColumnValue("ACCREDITIVS.DATE_DOC");
                String tmpAccreditivNUM_DOC = (String) select.getColumnValue("ACCREDITIVS.NUM_DOC");
                String tmpAccreditivACCREDITIV_TYPE = (String) select.getColumnValue("ACCREDITIVS.ACCREDITIV_TYPE");
                String tmpAccreditivPAYER_INN = (String) select.getColumnValue("ACCREDITIVS.PAYER_INN");
                String tmpAccreditivPAYER_NAME = (String) select.getColumnValue("ACCREDITIVS.PAYER_NAME");
                String tmpAccreditivPAYER_ACCOUNT = (String) select.getColumnValue("ACCREDITIVS.PAYER_ACCOUNT");
                BigDecimal tmpAccreditivAMOUNT = (BigDecimal) select.getColumnValue("ACCREDITIVS.AMOUNT");
                String tmpAccreditivPAYER_BANK_NAME = (String) select.getColumnValue("ACCREDITIVS.PAYER_BANK_NAME");
                String tmpAccreditivPAYER_BANK_BIC = (String) select.getColumnValue("ACCREDITIVS.PAYER_BANK_BIC");
                String tmpAccreditivPAYER_BANK_ACC = (String) select.getColumnValue("ACCREDITIVS.PAYER_BANK_ACC");
                String tmpAccreditivRCPT_INN = (String) select.getColumnValue("ACCREDITIVS.RCPT_INN");
                String tmpAccreditivRCPT_NAME = (String) select.getColumnValue("ACCREDITIVS.RCPT_NAME");
                String tmpAccreditivRCPT_ACCOUNT = (String) select.getColumnValue("ACCREDITIVS.RCPT_ACCOUNT");
                String tmpAccreditivRCPT_BANK_NAME = (String) select.getColumnValue("ACCREDITIVS.RCPT_BANK_NAME");
                String tmpAccreditivRCPT_BANK_BIC = (String) select.getColumnValue("ACCREDITIVS.RCPT_BANK_BIC");
                String tmpAccreditivRCPT_BANK_ACC = (String) select.getColumnValue("ACCREDITIVS.RCPT_BANK_ACC");
                String tmpAccreditivACCOUNT_40901 = (String) select.getColumnValue("ACCREDITIVS.ACCOUNT_40901");
                String tmpAccreditivTYPE_OPER = (String) select.getColumnValue("ACCREDITIVS.TYPE_OPER");
                Date tmpAccreditivTERM = (Date) select.getColumnValue("ACCREDITIVS.TERM");
                String tmpAccreditivTYPE_ACCREDITIV1 = (String) select.getColumnValue("ACCREDITIVS.TYPE_ACCREDITIV1");
                String tmpAccreditivTYPE_ACCREDITIV2 = (String) select.getColumnValue("ACCREDITIVS.TYPE_ACCREDITIV2");
                String tmpAccreditivCONDITION_PAY = (String) select.getColumnValue("ACCREDITIVS.CONDITION_PAY");
                String tmpAccreditivACCREDITIV_DETAILS = (String) select.getColumnValue("ACCREDITIVS.ACCREDITIV_DETAILS");
                String tmpAccreditivACCREDITIV_DOCS = (String) select.getColumnValue("ACCREDITIVS.ACCREDITIV_DOCS");
                String tmpAccreditivADD_CONDITION = (String) select.getColumnValue("ACCREDITIVS.ADD_CONDITION");
                String tmpAccreditivSTATUS_DOC = (String) select.getColumnValue("ACCREDITIVS.STATUS_DOC");
                String tmpAccreditivSIGNERS = (String) select.getColumnValue("ACCREDITIVS.SIGNERS");
                // add the new accreditive to the vector holding all Documents associated with
                // this IClient.
                Accreditive tempAccreditive =
                    new Accreditive(
                        new Document.DocumentPK(tmpAccreditivDOC_ID),
                        tmpAccreditivCLIENT_ID,
                        tmpAccreditivDATE_DOC,
                        tmpAccreditivNUM_DOC,
                        tmpAccreditivSTATUS_DOC,
                        tmpAccreditivSIGNERS,
                        tmpAccreditivACCREDITIV_TYPE,
                        new BusinessPartner(
                            tmpAccreditivPAYER_INN,
                            tmpAccreditivPAYER_NAME,
                            tmpAccreditivPAYER_ACCOUNT,
                            tmpAccreditivPAYER_BANK_BIC,
                            tmpAccreditivPAYER_BANK_NAME,
                            tmpAccreditivPAYER_BANK_ACC),
                        new Money(tmpAccreditivAMOUNT.toString()),
                        new BusinessPartner(
                            tmpAccreditivRCPT_INN,
                            tmpAccreditivRCPT_NAME,
                            tmpAccreditivRCPT_ACCOUNT,
                            tmpAccreditivRCPT_BANK_BIC,
                            tmpAccreditivRCPT_BANK_NAME,
                            tmpAccreditivRCPT_BANK_ACC),
                        tmpAccreditivACCOUNT_40901,
                        tmpAccreditivTYPE_OPER,
                        tmpAccreditivTERM,
                        tmpAccreditivTYPE_ACCREDITIV1,
                        tmpAccreditivTYPE_ACCREDITIV2,
                        tmpAccreditivCONDITION_PAY,
                        tmpAccreditivACCREDITIV_DETAILS,
                        tmpAccreditivACCREDITIV_DOCS,
                        tmpAccreditivADD_CONDITION);

                tmpAccreditivsAll.addElement(tempAccreditive);
                select.nextRow();
            }
        }
        //return new Vector(tempAccreditivsAll);
        return tmpAccreditivsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Return the AccreditivUpdate property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private static com.ibm.ivj.db.uibeans.Modify getAccreditivUpdate() {
	if (ivjAccreditivUpdate == null) {
		try {
			ivjAccreditivUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjAccreditivUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.documents.AccreditivDAB.connToIBank(), com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivUpdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccreditivUpdate;
}
/**
 * Return the IClientAccreditivsSelectSQL property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private static com.ibm.ivj.db.uibeans.Select getIClientAccreditivsSelect() {
	if (ivjIClientAccreditivsSelect == null) {
		try {
			ivjIClientAccreditivsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientAccreditivsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.documents.AccreditivDAB.connToIBank(), com.overstar.ildar.ibank.model.documents.AccreditivDAB.IClientAccreditivsSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientAccreditivsSelect;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private static void handleException(java.lang.Throwable exception) {

    /* Uncomment the following lines to print uncaught exceptions to stdout */
    // System.out.println("--------- UNCAUGHT EXCEPTION ---------");
    exception.printStackTrace(System.out);
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
    Accreditive tempAccreditive;

    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        String newAccreditiveIDstr = "1"; // определите newAccreditiveIDstr !!!
        String newClientIDstr = "2"; // определите newClientIDstr !!!
        Integer newClient_ID = new Integer(newClientIDstr);
        String newStatus_doc = "0"; //"0"-:-"7"
        System.out.println("Make new Accreditive with key " + newAccreditiveIDstr + "\n");
        //Может убить существующую запись в базе!!!
        tempAccreditive =
            new Accreditive(
                new Document.DocumentPK(newAccreditiveIDstr),
                newClient_ID,
                new java.sql.Date(System.currentTimeMillis()),
                "№" + newAccreditiveIDstr,
                newStatus_doc,
                "S" + newAccreditiveIDstr,
                Accreditive.ELECTRONIC,
                new BusinessPartner(
                    "Payer_inn" + newAccreditiveIDstr,
                    "Payer_name" + newAccreditiveIDstr,
                    "Payer_account" + newAccreditiveIDstr,
                    "P_b_bic" + newAccreditiveIDstr,
                    "Payer_bank_name" + newAccreditiveIDstr,
                    "Payer_bank_acc" + newAccreditiveIDstr),
                new Money(new BigInteger("1000"), 2),
                new BusinessPartner(
                    "Rcpt_inn" + newAccreditiveIDstr,
                    "Rcpt_name" + newAccreditiveIDstr,
                    "Rcpt_account" + newAccreditiveIDstr,
                    "R_b_bic" + newAccreditiveIDstr,
                    "Rcpt_bank_name" + newAccreditiveIDstr,
                    "Rcpt_bank_acc" + newAccreditiveIDstr),
                "anAccount_40901",
                "08",
                new java.sql.Date(System.currentTimeMillis()),
                "Отзывный",
                "Покрытый",
                "С акцептом",
                "Accreditive_details" + newAccreditiveIDstr,
                "Accreditiv_docs" + newAccreditiveIDstr,
                "anAddConditions" + newAccreditiveIDstr);
        AccreditiveTransactionMgr.storeAccreditive(tempAccreditive);
        System.out.println(tempAccreditive);
        System.out.println("______________________________________");
        System.out.println();

        ////////////////////////////////////////////////////////////////
        String getAccreditiveIDstr = newAccreditiveIDstr;
        System.out.println("Find Accreditive with key " + getAccreditiveIDstr + ".\n");
        tempAccreditive = findWithAccreditivePK(getAccreditiveIDstr);
        System.out.println(tempAccreditive);
        System.out.println("______________________________________");
        System.out.println();
        ///////////////////////////////////////////////////////////////

        System.out.println("Make new Accreditive with unique key  \n"); //заранее уникальный :)
        tempAccreditive =
            tempAccreditive =
                new Accreditive(
                    new Document.DocumentPK(),
                    newClient_ID,
                    new java.sql.Date(System.currentTimeMillis()),
                    "№" + newAccreditiveIDstr,
                    newStatus_doc,
                    "S" + newAccreditiveIDstr,
                    Accreditive.TELEGRAPH,
                    new BusinessPartner(
                        "Payer_inn" + newAccreditiveIDstr,
                        "Payer_name" + newAccreditiveIDstr,
                        "Payer_account" + newAccreditiveIDstr,
                        "P_b_bic" + newAccreditiveIDstr,
                        "Payer_bank_name" + newAccreditiveIDstr,
                        "Payer_bank_acc" + newAccreditiveIDstr),
                    new Money(new BigInteger("3000"), 2),
                    new BusinessPartner(
                        "Rcpt_inn" + newAccreditiveIDstr,
                        "Rcpt_name" + newAccreditiveIDstr,
                        "Rcpt_account" + newAccreditiveIDstr,
                        "R_b_bic" + newAccreditiveIDstr,
                        "Rcpt_bank_name" + newAccreditiveIDstr,
                        "Rcpt_bank_acc" + newAccreditiveIDstr),
                    "anAccount_40901",
                    "08",
                    new java.sql.Date(System.currentTimeMillis()),
                    "Отзывный",
                    "Покрытый",
                    "С акцептом",
                    "Accreditive_details" + newAccreditiveIDstr,
                    "Accreditiv_docs" + newAccreditiveIDstr,
                    "anAddConditions" + newAccreditiveIDstr);
        System.out.println(tempAccreditive);
        AccreditiveTransactionMgr.storeAccreditive(tempAccreditive);
        System.out.println("______________________________________");
        System.out.println();
        System.out.println("Find Accreditive with unique key " + tempAccreditive.getDoc_id() + ".\n");
        tempAccreditive = findWithAccreditivePK(tempAccreditive.getDoc_id().getIdAsString());
        System.out.println(tempAccreditive);
        System.out.println("______________________________________");
        System.out.println();

        //Документы:
        System.out.println("Find Accreditives for iClient=" + newClient_ID + ":\n");
        String fromDate = "2001-1-1";
        String toDate = "2003-10-23";
        String sortBy = "date_doc desc"; //-сортировки по полю - amount, status_doc, num_doc, rcpt_name
        Vector accreditives =
            AccreditiveTransactionMgr.getAccreditivsForIClient(
                newClient_ID.toString(),
                fromDate,
                toDate,
                new String[] { "0", "1", "2", "3" },
                sortBy);
        System.out.println("Accreditives: " + accreditives.size() + ":\n" + accreditives);
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
 * Creation date: (13.02.2003 15:54:36)
 * @param aAccreditive com.overstar.ildar.ibank.model.documents.Accreditive
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 */
public static synchronized void storeAccreditive(Accreditive aAccreditive)
    throws com.overstar.ildar.ibank.model.exceptions.PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists(aAccreditive)) {
            modify = getAccreditivUpdate();
            modify.setParameter("ID", aAccreditive.getDoc_id().getIdAsString());

        }
        else {
            //record doesn't exist.
            modify = getAccreditivInsert();
        }

        modify.setParameterFromString("DOC_ID", aAccreditive.getDoc_id().getIdAsString());
        modify.setParameter("CLIENT_ID", aAccreditive.rtClient_id());
        modify.setParameter("DATE_DOC", aAccreditive.rtDate_doc());
        modify.setParameter("NUM_DOC", aAccreditive.rtNum_doc());
        modify.setParameter("ACCREDITIV_TYPE", aAccreditive.rtAccreditiv_type());
        modify.setParameter("PAYER_INN", aAccreditive.rtPayer().rtInn());
        modify.setParameter("PAYER_NAME", aAccreditive.rtPayer().rtName());
        modify.setParameter("PAYER_ACCOUNT", aAccreditive.rtPayer().rtBill());
        modify.setParameter("AMOUNT", aAccreditive.rtAmount());
        modify.setParameter("PAYER_BANK_NAME", aAccreditive.rtPayer().rtBank_name());
        modify.setParameter("PAYER_BANK_BIC", aAccreditive.rtPayer().rtBank_Bic());
        modify.setParameter("PAYER_BANK_ACC", aAccreditive.rtPayer().rtBank_acc());
        modify.setParameter("RCPT_INN", aAccreditive.rtRecipient().rtInn());
        modify.setParameter("RCPT_NAME", aAccreditive.rtRecipient().rtName());
        modify.setParameter("RCPT_ACCOUNT", aAccreditive.rtRecipient().rtBill());
        modify.setParameter("RCPT_BANK_NAME", aAccreditive.rtRecipient().rtBank_name());
        modify.setParameter("RCPT_BANK_BIC", aAccreditive.rtRecipient().rtBank_Bic());
        modify.setParameter("RCPT_BANK_ACC", aAccreditive.rtRecipient().rtBank_acc());
        modify.setParameter("ACCOUNT_40901", aAccreditive.rtAccount_40901());
        modify.setParameter("TYPE_OPER", aAccreditive.rtType_oper());
        modify.setParameter("TERM", aAccreditive.rtTerm());
        modify.setParameter("TYPE_ACCREDITIV1", aAccreditive.rtType_accreditiv1());
        modify.setParameter("TYPE_ACCREDITIV2", aAccreditive.rtType_accreditiv2());
        modify.setParameter("CONDITION_PAY", aAccreditive.rtCondition_pay());
        modify.setParameter("ACCREDITIV_DETAILS", aAccreditive.rtAccreditiv_details());
        modify.setParameter("ACCREDITIV_DOCS", aAccreditive.rtAccreditiv_docs());
        modify.setParameter("ADD_CONDITION", aAccreditive.rtAdd_condition());
        modify.setParameter("STATUS_DOC", aAccreditive.rtStatus_doc().getID());
        modify.setParameter("SIGNERS", aAccreditive.rtSigners());

        modify.execute();
        //load();

    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
}
