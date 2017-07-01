package com.overstar.ildar.ibank.model;

import java.math.*;
import java.sql.*;
import java.util.Vector;
/**
 * Insert the type's description here.
 * Creation date: (11.09.2002 14:25:35)
 * @author: Shafigullin Ildar
 */
public class IClient {

    /**
     * PrimaryKey class to be used for instances of type IClient.
     */
    public static class IClientPK extends PrimaryKey {
        public IClientPK(String anId) {
            super(anId);
        }
    }
    private IClientPK client_id;
    private java.lang.String inn_cln;
    private java.lang.String okpo;
    private java.lang.String name_cln;
    private java.lang.String fio_cln;
    private java.lang.String phone_cln;
    private java.lang.String fax_cln;
    private java.lang.String email_cln;
    private java.lang.String addr_cln;
    private java.lang.String num_dogov;
    private java.sql.Date reg_date;
    private java.lang.String perms = "0";
    private java.lang.String lock_word;
    private java.lang.String ordering_customer;
    private Integer status = new Integer(1);
    private java.lang.String cln_type;
    private java.lang.String kpp;
    private java.lang.String doc_sign_num;
    private java.lang.String ext_client_id;
    private java.lang.String country_code;
    private java.lang.String city;
    private java.lang.String city_latin;
    private java.lang.String address_latin;
    private java.lang.String soato;
    private java.lang.String resident_flag;
	private com.ibm.ivj.db.uibeans.Select ivjIClientSelect = null;
	private com.ibm.ivj.db.uibeans.Modify ivjIClientInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjIClientDelete = null;
	private com.ibm.ivj.db.uibeans.Modify ivjIClientUpdate = null;
    private Integer PIN = new Integer(1);
	private com.ibm.ivj.db.uibeans.Select ivjIClientRecipientsSelect = null;
	private java.util.Vector recipientsAll;
	private java.util.Vector documentsAll;
	private java.util.Vector bankAccountsAll;
	private com.ibm.ivj.db.uibeans.Select ivjIClientPaymentsSelect = null;
	private com.ibm.ivj.db.uibeans.Select ivjIClientBankAccountsSelect = null;
	private com.ibm.ivj.db.uibeans.Select ivjIClientRecipientsNameInnBillBicSelect = null;
    /**
     * IClient constructor comment.
     */
    public IClient() {
        super();
        initialize();
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:23:23)
 * @param anClient_id IClientPK
 * @param anInn_cln java.lang.String
 * @param anOkpo java.lang.String
 * @param anName_cln java.lang.String
 * @param anFio_cln java.lang.String
 * @param anPhone_cln java.lang.String
 * @param anFax_cln java.lang.String
 * @param anEmail_cln java.lang.String
 * @param anAddr_cln java.lang.String
 * @param anNum_dogov java.lang.String
 * @param anReg_date java.sql.Date
 * @param anPerms java.lang.String
 * @param anLock_word java.lang.String
 * @param anOrdering_customer java.lang.String
 * @param anStatus int
 * @param anCln_type java.lang.String
 * @param anKpp java.lang.String
 * @param anDoc_sign_num java.lang.String
 * @param anExt_client_id java.lang.String
 * @param anCountry_codejava.lang.String
 * @param anCity java.lang.String
 * @param anCity_latin java.lang.String
 * @param anAddress_latin java.lang.String
 * @param anSoato java.lang.String
 * @param anResident_flag java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public IClient(
    IClientPK anClient_id,
    String anInn_cln,
    String anOkpo,
    String anName_cln,
    String anFio_cln,
    String anPhone_cln,
    String anFax_cln,
    String anEmail_cln,
    String anAddr_cln,
    String anNum_dogov,
    java.sql.Date anReg_date,
    String anPerms,
    String anLock_word,
    String anOrdering_customer,
    Integer anStatus,
    String anCln_type,
    String anKpp,
    String anDoc_sign_num,
    String anExt_client_id,
    String anCountry_code,
    String anCity,
    String anCity_latin,
    String anAddress_latin,
    String anSoato,
    String anResident_flag)
    throws PersistenceException {

    client_id = anClient_id;
    initInn_cln(anInn_cln);
    initOkpo(anOkpo);
    initName_cln(anName_cln);
    initFio_cln(anFio_cln);
    initPhone_cln(anPhone_cln);
    initFax_cln(anFax_cln);
    initEmail_cln(anEmail_cln);
    initAddr_cln(anAddr_cln);
    initNum_dogov(anNum_dogov);
    initReg_date(anReg_date);
    initPerms(anPerms);
    initLock_word(anLock_word);
    initOrdering_customer(anOrdering_customer);
    initStatus(anStatus);
    initCln_type(anCln_type);
    initKpp(anKpp);
    initDoc_sign_num(anDoc_sign_num);
    initExt_client_id(anExt_client_id);
    initCountry_code(anCountry_code);
    initCity(anCity);
    initCity_latin(anCity_latin);
    initAddress_latin(anAddress_latin);
    initSoato(anSoato);
    initResident_flag(anResident_flag);
       
    store();
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 16:32:22)
 * @return boolean
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected boolean exists() throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getIClientSelect();

        select.setParameterFromString("CLIENT_ID", getClient_id().getIdAsString());
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
     * This finder will search for the IClient with the given
     * primary key and return it. 
     *
     * Creation date: (12.09.2002 11:31:09)
     * @return com.overstar.ildar.ibank.model.IClient
     * @param anId com.overstar.ildar.ibank.model.IClient.IClientPK
     * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
     */
    public static IClient findWithIClientPK(IClientPK anId) throws PersistenceException {
        try {
            IClient tempIClient = new IClient();
            com.ibm.ivj.db.uibeans.Select select = tempIClient.getIClientSelect();
            select.setParameterFromString("CLIENT_ID", anId.getIdAsString());
            select.execute();
            if (select.getRowCount() <= 0) {
                throw new IClientNotFoundException("The IClient with primary key " + anId.getIdAsString() + " was not found.");
            }
            select.firstRow();
            String tmpIClientCLIENT_ID = select.getColumnValueToString("CLIENTS.CLIENT_ID");
            String tmpIClientINN_CLN = (String) select.getColumnValue("CLIENTS.INN_CLN");
            String tmpIClientOKPO = (String) select.getColumnValue("CLIENTS.OKPO");
            String tmpIClientNAME_CLN = (String) select.getColumnValue("CLIENTS.NAME_CLN");
            String tmpIClientFIO_CLN = (String) select.getColumnValue("CLIENTS.FIO_CLN");
            String tmpIClientPHONE_CLN = (String) select.getColumnValue("CLIENTS.PHONE_CLN");
            String tmpIClientFAX_CLN = (String) select.getColumnValue("CLIENTS.FAX_CLN");
            String tmpIClientEMAIL_CLN = (String) select.getColumnValue("CLIENTS.EMAIL_CLN");
            String tmpIClientADDR_CLN = (String) select.getColumnValue("CLIENTS.ADDR_CLN");
            String tmpIClientNUM_DOGOV = (String) select.getColumnValue("CLIENTS.NUM_DOGOV");
            java.sql.Date tmpIClientREG_DATE = (java.sql.Date) select.getColumnValue("CLIENTS.REG_DATE");
            String tmpIClientPERMS = (String) select.getColumnValue("CLIENTS.PERMS");
            String tmpIClientLOCK_WORD = (String) select.getColumnValue("CLIENTS.LOCK_WORD");
            String tmpIClientORDERING_CUSTOMER = (String) select.getColumnValue("CLIENTS.ORDERING_CUSTOMER");
            Integer tmpIClientSTATUS = (Integer) select.getColumnValue("CLIENTS.STATUS");
            String tmpIClientCLN_TYPE = (String) select.getColumnValue("CLIENTS.CLN_TYPE");
            String tmpIClientKPP = (String) select.getColumnValue("CLIENTS.KPP");
            String tmpIClientDOC_SIGN_NUM = (String) select.getColumnValue("CLIENTS.DOC_SIGN_NUM");
            String tmpIClientEXT_CLIENT_ID = (String) select.getColumnValue("CLIENTS.EXT_CLIENT_ID");
            String tmpIClientCOUNTRY_CODE = (String) select.getColumnValue("CLIENTS.COUNTRY_CODE");
            String tmpIClientCITY = (String) select.getColumnValue("CLIENTS.CITY");
            String tmpIClientCITY_LATIN = (String) select.getColumnValue("CLIENTS.CITY_LATIN");
            String tmpIClientADDRESS_LATIN = (String) select.getColumnValue("CLIENTS.ADDRESS_LATIN");
            String tmpIClientSOATO = (String) select.getColumnValue("CLIENTS.SOATO");
            String tmpIClientRESIDENT_FLAG = (String) select.getColumnValue("CLIENTS.RESIDENT_FLAG");

            tempIClient =
                new IClient(
                    (new IClientPK(tmpIClientCLIENT_ID)),
                    tmpIClientINN_CLN,
                    tmpIClientOKPO,
                    tmpIClientNAME_CLN,
                    tmpIClientFIO_CLN,
                    tmpIClientPHONE_CLN,
                    tmpIClientFAX_CLN,
                    tmpIClientEMAIL_CLN,
                    tmpIClientADDR_CLN,
                    tmpIClientNUM_DOGOV,
                    tmpIClientREG_DATE,
                    tmpIClientPERMS,
                    tmpIClientLOCK_WORD,
                    tmpIClientORDERING_CUSTOMER,
                    tmpIClientSTATUS,
                    tmpIClientCLN_TYPE,
                    tmpIClientKPP,
                    tmpIClientDOC_SIGN_NUM,
                    tmpIClientEXT_CLIENT_ID,
                    tmpIClientCOUNTRY_CODE,
                    tmpIClientCITY,
                    tmpIClientCITY_LATIN,
                    tmpIClientADDRESS_LATIN,
                    tmpIClientSOATO,
                    tmpIClientRESIDENT_FLAG);
            return tempIClient;
        }
        catch (Exception exp) {
            throw new PersistenceException(exp.toString());
        }
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 17:48:47)
 * @return com.overstar.ildar.ibank.model.IClient
 * @param anIdStr java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static IClient findWithIClientPK(String anIdStr) throws PersistenceException {
	return findWithIClientPK(new IClientPK(anIdStr));
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 10:15:49)
 * @return java.util.Vector
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getBankAccounts() throws PersistenceException {
    try {
        Vector tmpBankAccountsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getIClientBankAccountsSelect();
        select.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpAccountsBRANCH_ID = (String) select.getColumnValue("ACCOUNTS.BRANCH_ID");
                String tmpAccountsACCOUNT = (String) select.getColumnValue("ACCOUNTS.ACCOUNT");
                BankAccount tmpbnkacct = BankAccount.findWithBankAccountPK(tmpAccountsBRANCH_ID, tmpAccountsACCOUNT);
                // add the new Recipient to the vector holding all recipients associated with
                // this IClient.
                tmpBankAccountsAll.addElement(tmpbnkacct);
                select.nextRow();
            }
        }
        setBankAccountsAll(tmpBankAccountsAll);

        //return new Vector(bankAccountsAll);
        return bankAccountsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 10:21:10)
 * @return java.util.Vector
 */
public java.util.Vector getBankAccountsAll() {
	return bankAccountsAll;
}
    /**
     * Insert the method's description here.
     * Creation date: (12.09.2002 12:35:53)
     * @return com.overstar.ildar.ibank.model.IClient.IClientPK
     */
    public com.overstar.ildar.ibank.model.IClient.IClientPK getClient_id() {
        return client_id;
    }
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 15:31:18)
 * @return java.util.Vector
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getDocuments(int anDoc_type, String anFromDate, String anToDate, String [] anStatuses, String anSortBy) throws PersistenceException {
    if (anDoc_type==Document.PAYMENTS) {
        return getPayments(anFromDate, anToDate, anStatuses, anSortBy);
    }
    else
        return null;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 16:11:02)
 * @return java.util.Vector
 */
public java.util.Vector getDocumentsAll() {
	return documentsAll;
}
/**
 * Return the IClientBankAccountsSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getIClientBankAccountsSelect() {
	if (ivjIClientBankAccountsSelect == null) {
		try {
			ivjIClientBankAccountsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientBankAccountsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientBankAccountsSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientBankAccountsSelect;
}
    /**
     * Return the IClientDelete property value.
     * @return com.ibm.ivj.db.uibeans.Modify
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private com.ibm.ivj.db.uibeans.Modify getIClientDelete() {
	if (ivjIClientDelete == null) {
		try {
			ivjIClientDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjIClientDelete.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientDeleteSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientDelete;
}
    /**
     * Return the IClientInsert property value.
     * @return com.ibm.ivj.db.uibeans.Modify
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private com.ibm.ivj.db.uibeans.Modify getIClientInsert() {
	if (ivjIClientInsert == null) {
		try {
			ivjIClientInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjIClientInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientInsert;
}
/**
 * Return the IClientDocumentsSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getIClientPaymentsSelect() {
	if (ivjIClientPaymentsSelect == null) {
		try {
			ivjIClientPaymentsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientPaymentsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientPaymentsSelectSQL()));
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
 * Return the IClientRecipientsNameInnBillBicSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getIClientRecipientsNameInnBillBicSelect() {
	if (ivjIClientRecipientsNameInnBillBicSelect == null) {
		try {
			ivjIClientRecipientsNameInnBillBicSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientRecipientsNameInnBillBicSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientRecipientsNameInnBillBicSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientRecipientsNameInnBillBicSelect;
}
/**
 * Return the IClientRecipientsSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getIClientRecipientsSelect() {
	if (ivjIClientRecipientsSelect == null) {
		try {
			ivjIClientRecipientsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientRecipientsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientRecipientsSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientRecipientsSelect;
}
    /**
     * Return the IClientSelect property value.
     * @return com.ibm.ivj.db.uibeans.Select
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private com.ibm.ivj.db.uibeans.Select getIClientSelect() {
	if (ivjIClientSelect == null) {
		try {
			ivjIClientSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientSelect;
}
    /**
     * Return the IClientUpdate property value.
     * @return com.ibm.ivj.db.uibeans.Modify
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private com.ibm.ivj.db.uibeans.Modify getIClientUpdate() {
	if (ivjIClientUpdate == null) {
		try {
			ivjIClientUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjIClientUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.IClientDAB.connToIBank(), com.overstar.ildar.ibank.model.IClientDAB.IClientUpdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjIClientUpdate;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 15:31:18)
 * @return java.util.Vector
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
private Vector getPayments(String fromdate, String todate) throws PersistenceException {
    try {
        Vector tmpPaymentsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getIClientPaymentsSelect();

        select.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());
        select.setParameterFromString("FROMDATE", fromdate);
        select.setParameterFromString("TODATE", todate);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
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
                        Document.PAYMENTS,
                        tmpPaymentPAYMENT_TYPE,
                        tmpPaymentPAYER_INN,
                        tmpPaymentPAYER_NAME,
                        tmpPaymentPAYER_ACCOUNT,
                        tmpPaymentPAYER_BANK_NAME,
                        tmpPaymentPAYER_BANK_BIC,
                        tmpPaymentPAYER_BANK_ACC,
                        new Money(tmpPaymentAMOUNT.toString()),
                        tmpPaymentRCPT_INN,
                        tmpPaymentRCPT_NAME,
                        tmpPaymentRCPT_ACCOUNT,
                        tmpPaymentRCPT_BANK_NAME,
                        tmpPaymentRCPT_BANK_BIC,
                        tmpPaymentRCPT_BANK_ACC,
                        tmpPaymentTYPE_OPER,
                        tmpPaymentQUEUE,
                        tmpPaymentTERM,
                        tmpPaymentPAYMENT_DETAILS,
                        tmpPaymentKPP,
                        false);

                tmpPaymentsAll.addElement(tmpPayment);
                select.nextRow();
            }
        }
        setDocumentsAll(tmpPaymentsAll);

        //return new Vector(PaymentsAll);
        return documentsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 15:31:18)
 * @return java.util.Vector
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
private Vector getPayments(String fromdate, String todate, String[] anStatuses) throws PersistenceException {
    try {
        Vector tmpPaymentsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getIClientPaymentsSelect();
        String statement =
            "SELECT ILDAR.PAYMENTS.DOC_ID, ILDAR.PAYMENTS.CLIENT_ID, ILDAR.PAYMENTS.DATE_DOC, ILDAR.PAYMENTS.NUM_DOC, ILDAR.PAYMENTS.PAYMENT_TYPE, ILDAR.PAYMENTS.PAYER_INN, ILDAR.PAYMENTS.PAYER_NAME, ILDAR.PAYMENTS.PAYER_ACCOUNT, ILDAR.PAYMENTS.AMOUNT, ILDAR.PAYMENTS.PAYER_BANK_NAME, ILDAR.PAYMENTS.PAYER_BANK_BIC, ILDAR.PAYMENTS.PAYER_BANK_ACC, ILDAR.PAYMENTS.RCPT_INN, ILDAR.PAYMENTS.RCPT_NAME, ILDAR.PAYMENTS.RCPT_ACCOUNT, ILDAR.PAYMENTS.RCPT_BANK_NAME, ILDAR.PAYMENTS.RCPT_BANK_BIC, ILDAR.PAYMENTS.RCPT_BANK_ACC, ILDAR.PAYMENTS.TYPE_OPER, ILDAR.PAYMENTS.QUEUE, ILDAR.PAYMENTS.TERM, ILDAR.PAYMENTS.PAYMENT_DETAILS, ILDAR.PAYMENTS.KPP, ILDAR.PAYMENTS.STATUS_DOC, ILDAR.PAYMENTS.SIGNERS FROM ILDAR.PAYMENTS WHERE ( ( ILDAR.PAYMENTS.CLIENT_ID = :CLIENT_ID ) AND ( ILDAR.PAYMENTS.DATE_DOC between :FROMDATE and :TODATE ) ) ";
        if (anStatuses.length != 0) {
            StringBuffer stats = new StringBuffer(anStatuses[0]);
            for (int i = 1; i < anStatuses.length; i++) {
                stats.append("','" + anStatuses[i]);
            }
            select.getStatementMetaData().setSQL(statement + " AND ILDAR.PAYMENTS.STATUS_DOC IN('" + stats + "')");
        }
        else {
            setDocumentsAll(tmpPaymentsAll);
            return documentsAll;
        }
        //ORDER BY ILDAR.PAYMENTS.DATE_DOC
        //select.getStatementMetaData().setSQL(statement + " order by " + aSortBy);

        select.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());
        select.setParameterFromString("FROMDATE", fromdate);
        select.setParameterFromString("TODATE", todate);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
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
                        Document.PAYMENTS,
                        tmpPaymentPAYMENT_TYPE,
                        tmpPaymentPAYER_INN,
                        tmpPaymentPAYER_NAME,
                        tmpPaymentPAYER_ACCOUNT,
                        tmpPaymentPAYER_BANK_NAME,
                        tmpPaymentPAYER_BANK_BIC,
                        tmpPaymentPAYER_BANK_ACC,
                        new Money(tmpPaymentAMOUNT.toString()),
                        tmpPaymentRCPT_INN,
                        tmpPaymentRCPT_NAME,
                        tmpPaymentRCPT_ACCOUNT,
                        tmpPaymentRCPT_BANK_NAME,
                        tmpPaymentRCPT_BANK_BIC,
                        tmpPaymentRCPT_BANK_ACC,
                        tmpPaymentTYPE_OPER,
                        tmpPaymentQUEUE,
                        tmpPaymentTERM,
                        tmpPaymentPAYMENT_DETAILS,
                        tmpPaymentKPP,
                        false);

                tmpPaymentsAll.addElement(tmpPayment);
                select.nextRow();
            }
        }
        setDocumentsAll(tmpPaymentsAll);

        //return new Vector(PaymentsAll);
        return documentsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 15:31:18)
 * @return java.util.Vector
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
private Vector getPayments(String fromdate, String todate, String[] anStatuses, String aSortBy) throws PersistenceException {
    try {
        Vector tmpPaymentsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getIClientPaymentsSelect();
        String statement =
            "SELECT ILDAR.PAYMENTS.DOC_ID, ILDAR.PAYMENTS.CLIENT_ID, ILDAR.PAYMENTS.DATE_DOC, ILDAR.PAYMENTS.NUM_DOC, ILDAR.PAYMENTS.PAYMENT_TYPE, ILDAR.PAYMENTS.PAYER_INN, ILDAR.PAYMENTS.PAYER_NAME, ILDAR.PAYMENTS.PAYER_ACCOUNT, ILDAR.PAYMENTS.AMOUNT, ILDAR.PAYMENTS.PAYER_BANK_NAME, ILDAR.PAYMENTS.PAYER_BANK_BIC, ILDAR.PAYMENTS.PAYER_BANK_ACC, ILDAR.PAYMENTS.RCPT_INN, ILDAR.PAYMENTS.RCPT_NAME, ILDAR.PAYMENTS.RCPT_ACCOUNT, ILDAR.PAYMENTS.RCPT_BANK_NAME, ILDAR.PAYMENTS.RCPT_BANK_BIC, ILDAR.PAYMENTS.RCPT_BANK_ACC, ILDAR.PAYMENTS.TYPE_OPER, ILDAR.PAYMENTS.QUEUE, ILDAR.PAYMENTS.TERM, ILDAR.PAYMENTS.PAYMENT_DETAILS, ILDAR.PAYMENTS.KPP, ILDAR.PAYMENTS.STATUS_DOC, ILDAR.PAYMENTS.SIGNERS FROM ILDAR.PAYMENTS WHERE ( ( ILDAR.PAYMENTS.CLIENT_ID = :CLIENT_ID ) AND ( ILDAR.PAYMENTS.DATE_DOC between :FROMDATE and :TODATE ) ) ";
        if (anStatuses.length != 0) {
            StringBuffer stats = new StringBuffer(anStatuses[0]);
            for (int i = 1; i < anStatuses.length; i++) {
                stats.append("','" + anStatuses[i]);
            }
            select.getStatementMetaData().setSQL(statement + " AND ILDAR.PAYMENTS.STATUS_DOC IN('" + stats + "')" + " order by " + aSortBy);
        }
        else {
            setDocumentsAll(tmpPaymentsAll);
            return documentsAll;
        }
        //ORDER BY ILDAR.PAYMENTS.DATE_DOC
        //select.getStatementMetaData().setSQL(statement + " order by " + aSortBy);

        select.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());
        select.setParameterFromString("FROMDATE", fromdate);
        select.setParameterFromString("TODATE", todate);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
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
                        Document.PAYMENTS,
                        tmpPaymentPAYMENT_TYPE,
                        tmpPaymentPAYER_INN,
                        tmpPaymentPAYER_NAME,
                        tmpPaymentPAYER_ACCOUNT,
                        tmpPaymentPAYER_BANK_NAME,
                        tmpPaymentPAYER_BANK_BIC,
                        tmpPaymentPAYER_BANK_ACC,
                        new Money(tmpPaymentAMOUNT.toString()),
                        tmpPaymentRCPT_INN,
                        tmpPaymentRCPT_NAME,
                        tmpPaymentRCPT_ACCOUNT,
                        tmpPaymentRCPT_BANK_NAME,
                        tmpPaymentRCPT_BANK_BIC,
                        tmpPaymentRCPT_BANK_ACC,
                        tmpPaymentTYPE_OPER,
                        tmpPaymentQUEUE,
                        tmpPaymentTERM,
                        tmpPaymentPAYMENT_DETAILS,
                        tmpPaymentKPP,
                        false);

                tmpPaymentsAll.addElement(tmpPayment);
                select.nextRow();
            }
        }
        setDocumentsAll(tmpPaymentsAll);

        //return new Vector(PaymentsAll);
        return documentsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.09.2002 16:09:21)
 * @return java.util.Vector
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getRecipients() throws PersistenceException {
    try {
        Vector tmpRecipientsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getIClientRecipientsSelect();

        select.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpRecipientID = (String) select.getColumnValue("RECIPIENTS.ID");
                Integer tmpRecipientCLIENT_ID = (Integer) select.getColumnValue("RECIPIENTS.CLIENT_ID");
                String tmpRecipientINN = (String) select.getColumnValue("RECIPIENTS.INN");
                String tmpRecipientNAME = (String) select.getColumnValue("RECIPIENTS.NAME");
                String tmpRecipientBIC = (String) select.getColumnValue("RECIPIENTS.BIC");
                String tmpRecipientBILL = (String) select.getColumnValue("RECIPIENTS.BILL");
                String tmpRecipientCOMMENTS = (String) select.getColumnValue("RECIPIENTS.COMMENTS");
                // add the new Recipient to the vector holding all recipients associated with
                // this IClient.
                Recipient tmpRecipient =
                    new Recipient(
                        new Recipient.RecipientPK(tmpRecipientID),
                        tmpRecipientCLIENT_ID,
                        tmpRecipientINN,
                        tmpRecipientNAME,
                        tmpRecipientBIC,
                        tmpRecipientBILL,
                        tmpRecipientCOMMENTS, false);

                tmpRecipientsAll.addElement(tmpRecipient);
                select.nextRow();
            }
        }

        setRecipientsAll(tmpRecipientsAll);

        //return new Vector(recipientsAll);
        return recipientsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (30.09.2002 16:21:56)
 * @return java.util.Vector
 * @param aSortBy java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getRecipients(String aSortBy) throws PersistenceException {
    try {
        Vector tmpRecipientsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getIClientRecipientsSelect();
        String statement =
            "SELECT ILDAR.RECIPIENTS.ID, ILDAR.RECIPIENTS.CLIENT_ID, ILDAR.RECIPIENTS.INN, ILDAR.RECIPIENTS.NAME, ILDAR.RECIPIENTS.BIC, ILDAR.RECIPIENTS.BILL, ILDAR.RECIPIENTS.COMMENTS FROM ILDAR.RECIPIENTS WHERE ( ( ILDAR.RECIPIENTS.CLIENT_ID = :CLIENT_ID ) )";

        select.getStatementMetaData().setSQL(statement + " order by " + aSortBy);

        select.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpRecipientID = (String) select.getColumnValue("RECIPIENTS.ID");
                Integer tmpRecipientCLIENT_ID = (Integer) select.getColumnValue("RECIPIENTS.CLIENT_ID");
                String tmpRecipientINN = (String) select.getColumnValue("RECIPIENTS.INN");
                String tmpRecipientNAME = (String) select.getColumnValue("RECIPIENTS.NAME");
                String tmpRecipientBIC = (String) select.getColumnValue("RECIPIENTS.BIC");
                String tmpRecipientBILL = (String) select.getColumnValue("RECIPIENTS.BILL");
                String tmpRecipientCOMMENTS = (String) select.getColumnValue("RECIPIENTS.COMMENTS");
                // add the new acct to the vector holding all recipients associated with
                // this IClient.
                Recipient tmpRecipient =
                    new Recipient(
                        new Recipient.RecipientPK(tmpRecipientID),
                        tmpRecipientCLIENT_ID,
                        tmpRecipientINN,
                        tmpRecipientNAME,
                        tmpRecipientBIC,
                        tmpRecipientBILL,
                        tmpRecipientCOMMENTS, false);

                tmpRecipientsAll.addElement(tmpRecipient);
                select.nextRow();
            }
        }

        setRecipientsAll(tmpRecipientsAll);

        //return new Vector(recipientsAll);
        return recipientsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 17:55:17)
 * @return java.util.Vector
 * @param anName java.lang.String
 * @param anInn java.lang.String
 * @param anBill java.lang.String
 * @param anBic java.lang.String
 * @param aOperation java.lang.String
 * @param aSortBy java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getRecipients(
    String anName,
    String anInn,
    String anBill,
    String anBic,
    String aOperation,
    String aSortBy)
    throws PersistenceException {
    try {
        Vector tmpRecipientsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getIClientRecipientsNameInnBillBicSelect();
        String statement =
            "SELECT ILDAR.RECIPIENTS.ID, ILDAR.RECIPIENTS.CLIENT_ID, ILDAR.RECIPIENTS.INN, ILDAR.RECIPIENTS.NAME, ILDAR.RECIPIENTS.BIC, ILDAR.RECIPIENTS.BILL, ILDAR.RECIPIENTS.COMMENTS FROM ILDAR.RECIPIENTS WHERE( ((ILDAR.RECIPIENTS.NAME like '%'||:NAME||'%') "
                + aOperation
                + " (ILDAR.RECIPIENTS.INN like '%'||:INN||'%') "
                + aOperation
                + " (ILDAR.RECIPIENTS.BILL like '%'||:BILL||'%') "
                + aOperation
                + " (ILDAR.RECIPIENTS.BIC like '%'||:BIC||'%')) AND (ILDAR.RECIPIENTS.CLIENT_ID = :CLIENT_ID) )";
        select.getStatementMetaData().setSQL(statement + " order by " + aSortBy );

        select.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());        
        select.setParameter("NAME", anName);
        select.setParameter("INN", anInn);
        select.setParameter("BILL", anBill);
        select.setParameter("BIC", anBic);

        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpRecipientID = (String) select.getColumnValue("RECIPIENTS.ID");
                Integer tmpRecipientCLIENT_ID = (Integer) select.getColumnValue("RECIPIENTS.CLIENT_ID");
                String tmpRecipientINN = (String) select.getColumnValue("RECIPIENTS.INN");
                String tmpRecipientNAME = (String) select.getColumnValue("RECIPIENTS.NAME");
                String tmpRecipientBIC = (String) select.getColumnValue("RECIPIENTS.BIC");
                String tmpRecipientBILL = (String) select.getColumnValue("RECIPIENTS.BILL");
                String tmpRecipientCOMMENTS = (String) select.getColumnValue("RECIPIENTS.COMMENTS");
                // add the new acct to the vector holding all recipients associated with
                // this IClient.
                Recipient tmpRecipient =
                    new Recipient(
                        new Recipient.RecipientPK(tmpRecipientID),
                        tmpRecipientCLIENT_ID,
                        tmpRecipientINN,
                        tmpRecipientNAME,
                        tmpRecipientBIC,
                        tmpRecipientBILL,
                        tmpRecipientCOMMENTS,
                        false);

                tmpRecipientsAll.addElement(tmpRecipient);
                select.nextRow();
            }
        }

        setRecipientsAll(tmpRecipientsAll);

        //return new Vector(recipientsAll);
        return recipientsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (24.09.2002 16:44:44)
 * @return java.util.Vector
 */
public java.util.Vector getRecipientsAll() {
	return recipientsAll;
}
    /**
     * Called whenever the part throws an exception.
     * @param exception java.lang.Throwable
     */
    private void handleException(java.lang.Throwable exception) {

        /* Uncomment the following lines to print uncaught exceptions to stdout */
        // System.out.println("--------- UNCAUGHT EXCEPTION ---------");
        // exception.printStackTrace(System.out);
    }
    /**
     * Insert the method's description here.
     * Creation date: (12.09.2002 12:35:53)
     * @param newAddr_cln java.lang.String
     */
    void initAddr_cln(java.lang.String newAddr_cln) {
        addr_cln = newAddr_cln;
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newAddress_latin java.lang.String
 */
void initAddress_latin(java.lang.String newAddress_latin) {
    address_latin = newAddress_latin;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newCity java.lang.String
 */
void initCity(java.lang.String newCity) {
    city = newCity;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newCity_latin java.lang.String
 */
void initCity_latin(java.lang.String newCity_latin) {
    city_latin = newCity_latin;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newCln_type java.lang.String
 */
void initCln_type(java.lang.String newCln_type) {
    cln_type = newCln_type;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newCountry_code java.lang.String
 */
void initCountry_code(java.lang.String newCountry_code) {
    country_code = newCountry_code;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newDoc_sign_num java.lang.String
 */
void initDoc_sign_num(java.lang.String newDoc_sign_num) {
    doc_sign_num = newDoc_sign_num;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newEmail_cln java.lang.String
 */
void initEmail_cln(java.lang.String newEmail_cln) {
    email_cln = newEmail_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newExt_client_id java.lang.String
 */
void initExt_client_id(java.lang.String newExt_client_id) {
    ext_client_id = newExt_client_id;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newFax_cln java.lang.String
 */
void initFax_cln(java.lang.String newFax_cln) {
    fax_cln = newFax_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newFio_cln java.lang.String
 */
void initFio_cln(java.lang.String newFio_cln) {
    fio_cln = newFio_cln;
}
    /**
     * Initialize the class.
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void initialize() {
        try {
            // user code begin {1}
            // user code end
        }
        catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        }
        // user code begin {2}
        // user code end
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newInn_cln java.lang.String
 */
void initInn_cln(java.lang.String newInn_cln) {
    inn_cln = newInn_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newKpp java.lang.String
 */
void initKpp(java.lang.String newKpp) {
    kpp = newKpp;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newLock_word java.lang.String
 */
void initLock_word(java.lang.String newLock_word) {
    lock_word = newLock_word;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newName_cln java.lang.String
 */
void initName_cln(java.lang.String newName_cln) {
    name_cln = newName_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newNum_dogov java.lang.String
 */
void initNum_dogov(java.lang.String newNum_dogov) {
    num_dogov = newNum_dogov;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newOkpo java.lang.String
 */
void initOkpo(java.lang.String newOkpo) {
    okpo = newOkpo;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newOrdering_customer java.lang.String
 */
void initOrdering_customer(java.lang.String newOrdering_customer) {
    ordering_customer = newOrdering_customer;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newPerms java.lang.String
 */
void initPerms(java.lang.String newPerms) {
    perms = newPerms;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newPhone_cln java.lang.String
 */
void initPhone_cln(java.lang.String newPhone_cln) {
    phone_cln = newPhone_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newReg_date java.util.Date
 */
void initReg_date(java.sql.Date newReg_date) {
    reg_date = newReg_date;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newResident_flag java.lang.String
 */
void initResident_flag(java.lang.String newResident_flag) {
    resident_flag = newResident_flag;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newSoato java.lang.String
 */
void initSoato(java.lang.String newSoato) {
    soato = newSoato;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @param newStatus int
 */
void initStatus(Integer newStatus) {
    status = newStatus;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 16:36:33)
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected void load() throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getIClientSelect();
        select.setParameterFromString("CLIENT_ID", getClient_id().getIdAsString());

        select.execute();
        select.firstRow();
        String tmpIClientCLIENT_ID = select.getColumnValueToString("CLIENTS.CLIENT_ID");
        String tmpIClientINN_CLN = (String) select.getColumnValue("CLIENTS.INN_CLN");
        String tmpIClientOKPO = (String) select.getColumnValue("CLIENTS.OKPO");
        String tmpIClientNAME_CLN = (String) select.getColumnValue("CLIENTS.NAME_CLN");
        String tmpIClientFIO_CLN = (String) select.getColumnValue("CLIENTS.FIO_CLN");
        String tmpIClientPHONE_CLN = (String) select.getColumnValue("CLIENTS.PHONE_CLN");
        String tmpIClientFAX_CLN = (String) select.getColumnValue("CLIENTS.FAX_CLN");
        String tmpIClientEMAIL_CLN = (String) select.getColumnValue("CLIENTS.EMAIL_CLN");
        String tmpIClientADDR_CLN = (String) select.getColumnValue("CLIENTS.ADDR_CLN");
        String tmpIClientNUM_DOGOV = (String) select.getColumnValue("CLIENTS.NUM_DOGOV");
        java.sql.Date tmpIClientREG_DATE = (java.sql.Date)select.getColumnValue("CLIENTS.REG_DATE");
        String tmpIClientPERMS = (String) select.getColumnValue("CLIENTS.PERMS");
        String tmpIClientLOCK_WORD = (String) select.getColumnValue("CLIENTS.LOCK_WORD");
        String tmpIClientORDERING_CUSTOMER = (String) select.getColumnValue("CLIENTS.ORDERING_CUSTOMER");
        Integer tmpIClientSTATUS = (Integer) select.getColumnValue("CLIENTS.STATUS");
        String tmpIClientCLN_TYPE = (String) select.getColumnValue("CLIENTS.CLN_TYPE");
        String tmpIClientKPP = (String) select.getColumnValue("CLIENTS.KPP");
        String tmpIClientDOC_SIGN_NUM = (String) select.getColumnValue("CLIENTS.DOC_SIGN_NUM");
        String tmpIClientEXT_CLIENT_ID = (String) select.getColumnValue("CLIENTS.EXT_CLIENT_ID");
        String tmpIClientCOUNTRY_CODE = (String) select.getColumnValue("CLIENTS.COUNTRY_CODE");
        String tmpIClientCITY = (String) select.getColumnValue("CLIENTS.CITY");
        String tmpIClientCITY_LATIN = (String) select.getColumnValue("CLIENTS.CITY_LATIN");
        String tmpIClientADDRESS_LATIN = (String) select.getColumnValue("CLIENTS.ADDRESS_LATIN");
        String tmpIClientSOATO = (String) select.getColumnValue("CLIENTS.SOATO");
        String tmpIClientRESIDENT_FLAG = (String) select.getColumnValue("CLIENTS.RESIDENT_FLAG");

        initInn_cln(tmpIClientINN_CLN);
        initOkpo(tmpIClientOKPO);
        initName_cln(tmpIClientNAME_CLN);
        initFio_cln(tmpIClientFIO_CLN);
        initPhone_cln(tmpIClientPHONE_CLN);
        initFax_cln(tmpIClientFAX_CLN);
        initEmail_cln(tmpIClientEMAIL_CLN);
        initAddr_cln(tmpIClientADDR_CLN);
        initNum_dogov(tmpIClientNUM_DOGOV);
        initReg_date(tmpIClientREG_DATE);
        initPerms(tmpIClientPERMS);
        initLock_word(tmpIClientLOCK_WORD);
        initOrdering_customer(tmpIClientORDERING_CUSTOMER);
        initStatus(tmpIClientSTATUS);
        initCln_type(tmpIClientCLN_TYPE);
        initKpp(tmpIClientKPP);
        initDoc_sign_num(tmpIClientDOC_SIGN_NUM);
        initExt_client_id(tmpIClientEXT_CLIENT_ID);
        initCountry_code(tmpIClientCOUNTRY_CODE);
        initCity(tmpIClientCITY);
        initCity_latin(tmpIClientCITY_LATIN);
        initAddress_latin(tmpIClientADDRESS_LATIN);
        initSoato(tmpIClientSOATO);
        initResident_flag(tmpIClientRESIDENT_FLAG);

    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
    IClient tempIClient;

    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        /*        
                String newClientIDstr = "3"; // определите newClientIDstr !!! 
                System.out.println("Make new IClient with key " + newClientIDstr + "\n");
                tempIClient =
                    new IClient(
                        new IClient.IClientPK(newClientIDstr),
                        "Inn" + newClientIDstr,
                        "Okpo" + newClientIDstr,
                        "Name_cln" + newClientIDstr,
                        "nFio_cln" + newClientIDstr,
                        "Phone_cln" + newClientIDstr,
                        "Fax_cln" + newClientIDstr,
                        "Email_cln" + newClientIDstr,
                        "Addr_cln" + newClientIDstr,
                        "Num_dog" + newClientIDstr,
                        new java.sql.Date(System.currentTimeMillis()),
                        "P-s" + newClientIDstr,
                        "Lock_word" + newClientIDstr,
                        "Ordering_customer" + newClientIDstr,
                        new Integer(1),
                        "3",
                        "Kpp" + newClientIDstr,
                        "Doc_sign_num" + newClientIDstr,
                        "Ext_client_id" + newClientIDstr,
                        "333",
                        "City" + newClientIDstr,
                        "nCity_latin" + newClientIDstr,
                        "Address_latin" + newClientIDstr,
                        "Soato" + newClientIDstr,
                        "1");
                System.out.println(tempIClient.toStringFull());
                System.out.println("______________________________________");
                System.out.println();
        */
        //Инициализация клиента:
        String getClientIDstr = "1";
        System.out.println("Find IClient with key " + getClientIDstr + ".\n");
        tempIClient = findWithIClientPK(getClientIDstr);
        System.out.println(tempIClient);
        System.out.println("______________________________________");
        System.out.println();
        
        //Получатели:
        //tempIClient.getRecipients();//без сортировки.
        //tempIClient.getRecipients("name desc"); //с сортировкой
        tempIClient.getRecipients("name klient 7", "777777777777", "%", "%", "or", "name desc"); //расширенный.

        //Документы:
        String fromDate = "2001-1-1";
        String toDate = "2002-10-23";
        String sortBy = "date_doc desc"; //-сортировки по полю - amount, status_doc, num_doc, rcpt_name
        //tempIClient.getDocuments(Document.PAYMENTS, fromDate, toDate, new String[]{"2","3"});
        //tempIClient.getDocuments(Document.PAYMENTS, fromDate, toDate, new String[]{"1","2","3","4"});
        tempIClient.getDocuments(Document.PAYMENTS, fromDate, toDate, new String[] { "0", "1", "2" }, sortBy);
        //tempIClient.getPayments( fromDate, toDate);
        
        //Счета:
        tempIClient.getBankAccounts();
        System.out.println(tempIClient.toStringFull());
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
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtAddr_cln() {
    return addr_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtAddress_latin() {
    return address_latin;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtCity() {
    return city;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtCity_latin() {
    return city_latin;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtCln_type() {
    return cln_type;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtCountry_code() {
    return country_code;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtDoc_sign_num() {
    return doc_sign_num;
}
    /**
     * Insert the method's description here.
     * Creation date: (12.09.2002 12:35:53)
     * @return java.lang.String
     */
    public java.lang.String rtEmail_cln() {
        return email_cln;
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtExt_client_id() {
    return ext_client_id;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtFax_cln() {
    return fax_cln;
}
    /**
     * Insert the method's description here.
     * Creation date: (12.09.2002 12:35:53)
     * @return java.lang.String
     */
    public java.lang.String rtFio_cln() {
        return fio_cln;
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtInn_cln() {
    return inn_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtKpp() {
    return kpp;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtLock_word() {
    return lock_word;
}
    /**
     * Insert the method's description here.
     * Creation date: (12.09.2002 12:35:53)
     * @return java.lang.String
     */
    public java.lang.String rtName_cln() {
        return name_cln;
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtNum_dogov() {
    return num_dogov;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtOkpo() {
    return okpo;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtOrdering_customer() {
    return ordering_customer;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtPerms() {
    return perms;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtPhone_cln() {
    return phone_cln;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.util.Date
 */
public java.util.Date rtReg_date() {
    return reg_date;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtResident_flag() {
    return resident_flag;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return java.lang.String
 */
public java.lang.String rtSoato() {
    return soato;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 12:35:53)
 * @return int
 */
public Integer rtStatus() {
    return status;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2002 10:21:10)
 * @param newBankAccountsAll java.util.Vector
 */
private void setBankAccountsAll(java.util.Vector newBankAccountsAll) {
	bankAccountsAll = newBankAccountsAll;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 16:11:02)
 * @param newDocumentsAll java.util.Vector
 */
private void setDocumentsAll(java.util.Vector newDocumentsAll) {
	documentsAll = newDocumentsAll;
}
/**
 * Insert the method's description here.
 * Creation date: (24.09.2002 16:44:44)
 * @param newRecipientsAll java.util.Vector
 */
private void setRecipientsAll(java.util.Vector newRecipientsAll) {
	recipientsAll = newRecipientsAll;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 15:05:12)
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
private void store() throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists()) {
            modify = getIClientUpdate();
            modify.setParameterFromString("ID", this.getClient_id().getIdAsString());

        }
        else { 
            //record doesn't exist.
            modify = getIClientInsert();
        }

        modify.setParameterFromString("CLIENT_ID", this.getClient_id().getIdAsString());
        modify.setParameter("INN_CLN", rtInn_cln());
        modify.setParameter("OKPO", rtOkpo());
        modify.setParameter("NAME_CLN", rtName_cln());
        modify.setParameter("FIO_CLN", rtFio_cln());
        modify.setParameter("PHONE_CLN", rtPhone_cln());
        modify.setParameter("FAX_CLN", rtFax_cln());
        modify.setParameter("EMAIL_CLN", rtEmail_cln());
        modify.setParameter("ADDR_CLN", rtAddr_cln());
        modify.setParameter("NUM_DOGOV", rtNum_dogov());
        modify.setParameter("REG_DATE", rtReg_date());
        modify.setParameter("PERMS", rtPerms());
        modify.setParameter("LOCK_WORD", rtLock_word());
        modify.setParameter("ORD_CUST", rtOrdering_customer());
        modify.setParameter("STATUS", rtStatus());
        modify.setParameter("CLN_TYPE", rtCln_type());
        modify.setParameter("KPP", rtKpp());
        modify.setParameter("DOC_SIGN_NUM", rtDoc_sign_num());
        modify.setParameter("EXT_CLIENT_ID", rtExt_client_id());
        modify.setParameter("COUNTRY_CODE", rtCountry_code());
        modify.setParameter("CITY", rtCity());
        modify.setParameter("CITY_LATIN", rtCity_latin());
        modify.setParameter("ADDRESS_LATIN", rtAddress_latin());
        modify.setParameter("SOATO", rtSoato());
        modify.setParameter("RESIDENT_FLAG", rtResident_flag());
       
        modify.execute();
        load();

    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
    /**
     * Returns a String that represents the value of this object.
     * @return a string representation of the receiver
     */
    public String toString() {
        // Insert code to print the receiver here.
        // This implementation forwards the message to super. You may replace or supplement this.
        return "\nIClient (" + client_id + ")" + ".\n " + 
        " inn_cln (" + inn_cln + ")" + ".\n " + 
        " okpo  (" + okpo + ")" + ".\n " + 
        " name_cln (" + name_cln + ")" + ".\n " +
        " fio_cln (" + fio_cln + ")" + ".\n " +
        " phone_cln (" + phone_cln + ")" + ".\n " +
        " fax_cln (" + fax_cln + ")" + ".\n " +
        " email_cln (" + email_cln + ")" + ".\n " +
        " addr_cln  (" + addr_cln + ")" + ".\n " +
        " num_dogov  (" + num_dogov + ")" + ".\n " +
        " reg_date  (" + reg_date + ")" + ".\n " +
        " perms  (" + perms + ")" + ".\n " +
        " lock_word  (" + lock_word + ")" + ".\n " +
        " ordering_customer  (" + ordering_customer + ")" + ".\n " +
        " status  (" + status + ")" + ".\n " +
        " cln_type  (" + cln_type + ")" + ".\n " +
        " kpp  (" + kpp + ")" + ".\n " +
        " doc_sign_num  (" + doc_sign_num + ")" + ".\n " +
        " ext_client_id (" + ext_client_id + ")" + ".\n " +
        " country_code (" + country_code + ")" + ".\n " +
        "  city (" + city + ")" + ".\n " +
        "  city_latin(" + city_latin + ")" + ".\n " +
        "  address_latin (" + address_latin + ")" + ".\n " +
        "  soato (" + soato + ")" + ".\n " +
        "  resident_flag (" + resident_flag + ")" + ".\n "  ;
    }
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 18:27:22)
 */
public String toStringFull() {
    return "IClient ("
        + getClient_id()
        + ")"
        + ".\n -----------Счета:-----------------\n"
        + "AssociatedBankAccounts:"+getBankAccountsAll().size()+"\n"
        + getBankAccountsAll()
        + ".\n ------Документы:------------------\n"
        + "AssociatedDocuments:"+getDocumentsAll().size()+"\n"
        + getDocumentsAll()
        + ".\n ------Получатели:-----------------\n"
        + "AssociatedRecipients:"+getRecipientsAll().size()+"\n"
        + getRecipientsAll();
}
/**
 * Validate the PIN code in the procedure to
 * authenticate the current Person.
 * 
 * Creation date: (20.09.2002 12:23:29)
 * @param aPINStr java.lang.String
 * @exception com.overstar.ildar.ibank.model.InvalidPINException The exception description.
 */
void validatePIN(String aPINStr) throws InvalidPINException {
	try {
		if (PIN.intValue() != Integer.parseInt(aPINStr)) {
			throw new InvalidPINException("The given PIN is not valid for this IClient.");
		}
	} catch(NumberFormatException ex) {
		throw new InvalidPINException("The given PIN is not valid for this IClient.");
	}
}
}
