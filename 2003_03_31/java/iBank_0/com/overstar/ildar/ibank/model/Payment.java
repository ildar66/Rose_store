package com.overstar.ildar.ibank.model;

import java.math.*;
import java.sql.*;
/**
 * Insert the type's description here.
 * Creation date: (16.10.2002 15:34:04)
 * @author: Shafigullin Ildar
 */
public class Payment extends Document {
    private java.lang.String payment_type; //'Вид платежа, может принимать значения:
    public final static String EMPTY = " "; //отсутствует.
    public final static String POST = "Почтой"; //"Почтой".
    public final static String TELEGRAPH = "Телеграфом"; //"Телеграфом",.
    public final static String ELECTRONIC = "Электронно"; //"Электронно".
    private java.lang.String payer_inn; //'ИНН плательщика';
    private java.lang.String payer_name; //'Наименование плательщика';
    private java.lang.String payer_account; //'Счет плательщика';
    private java.lang.String payer_bank_name; //'Наименование банка плательщика';
    private java.lang.String payer_bank_bic; //'БИК банка плательщика';
    private java.lang.String payer_bank_acc; //'Корсчет банка плательщика';
    private Money amount; //'Сумма платежа (в единицах валюты - рублях)';
    private java.lang.String rcpt_inn; //'ИНН получателя';
    private java.lang.String rcpt_name; //'Наименование получателя';
    private java.lang.String rcpt_account; //'Счет получателя';
    private java.lang.String rcpt_bank_name; //'Наименование банка получателя';
    private java.lang.String rcpt_bank_bic; //'БИК банка получателя';
    private java.lang.String rcpt_bank_acc; //'Корсчет банка получателя';
    private java.lang.String type_oper = "01"; //'Вид операции, для платежных поручений "01"';
    //'Код очередности платежа. Может принимать значения "01", "02", "03", "04", "05" или "06", или отсутствовать';
    private java.lang.String queue;
    private java.sql.Date term; //'Срок платежа';
    private java.lang.String payment_details; //'Назначение платежа';
    private java.lang.String kpp; //'КПП плательщика';
	private com.ibm.ivj.db.uibeans.Select ivjPaymentSelect = null;
	private com.ibm.ivj.db.uibeans.Modify ivjPaymentInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjPaymentDelete = null;
	private com.ibm.ivj.db.uibeans.Modify ivjPaymentUpdate = null;
/**
 * Payment constructor comment.
 */
public Payment() {
	super();
	initialize();
}
/**
 * Payment constructor comment.
 * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
 * @param anClient_id java.lang.Integer
 * @param anDate_doc java.sql.Date
 * @param anNum_doc java.lang.String
 * @param anStatus_doc java.lang.String
 * @param anSigners java.lang.String
 * @param anDoc_type int
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Payment(
    Document.DocumentPK anId,
    Integer anClient_id,
    Date anDate_doc,
    String anNum_doc,
    String anStatus_doc,
    String anSigners,
    int anDoc_type,
    String anPayment_type,
    String anPayer_inn,
    String anPayer_name,
    String anPayer_account,
    String anPayer_bank_name,
    String anPayer_bank_bic,
    String anPayer_bank_acc,
    Money anAmount,
    String anRcpt_inn,
    String anRcpt_name,
    String anRcpt_account,
    String anRcpt_bank_name,
    String anRcpt_bank_bic,
    String anRcpt_bank_acc,
    String anType_oper,
    String anQueue,
    Date anTerm,
    String anPayment_details,
    String anKpp,
    boolean isStore)
    throws PersistenceException {
    super(anId, anClient_id, anDate_doc, anNum_doc, anStatus_doc, anSigners, anDoc_type);
    initPayment_type(anPayment_type);
    initPayer_inn(anPayer_inn);
    initPayer_name(anPayer_name);
    initPayer_account(anPayer_account);
    initPayer_bank_name(anPayer_bank_name);
    initPayer_bank_bic(anPayer_bank_bic);
    initPayer_bank_acc(anPayer_bank_acc);
    initAmount(anAmount);
    initRcpt_inn(anRcpt_inn);
    initRcpt_name(anRcpt_name);
    initRcpt_account(anRcpt_account);
    initRcpt_bank_name(anRcpt_bank_name);
    initRcpt_bank_bic(anRcpt_bank_bic);
    initRcpt_bank_acc(anRcpt_bank_acc);
    initType_oper(anType_oper);
    initQueue(anQueue);
    initTerm(anTerm);
    initPayment_details(anPayment_details);
    initKpp(anKpp);
    if (isStore)
        store();
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 18:38:04)
 * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static void deleteWithPaymentPK(Document.DocumentPK anId) throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        Payment tempPayment = new Payment();
        modify = tempPayment.getPaymentDelete();
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
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected boolean exists() throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getPaymentSelect();

        select.setParameter("DOC_ID", getDoc_id().getIdAsString());
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
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static Payment findWithPaymentPK(Document.DocumentPK anId) throws PersistenceException {
    try {
        Payment tempPayment = new Payment();
        com.ibm.ivj.db.uibeans.Select select = tempPayment.getPaymentSelect();
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

        tempPayment =
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
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static Payment findWithPaymentPK(String anDoc_IDStr) throws PersistenceException {
	return findWithPaymentPK(new Document.DocumentPK(anDoc_IDStr));
}
/**
 * Return the PaymentDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getPaymentDelete() {
	if (ivjPaymentDelete == null) {
		try {
			ivjPaymentDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjPaymentDelete.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.PaymentDAB.connToIBank(), com.overstar.ildar.ibank.model.PaymentDAB.PaymentDeleteSQL()));
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
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getPaymentInsert() {
	if (ivjPaymentInsert == null) {
		try {
			ivjPaymentInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjPaymentInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.PaymentDAB.connToIBank(), com.overstar.ildar.ibank.model.PaymentDAB.PaymentInsertSQL()));
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
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getPaymentSelect() {
	if (ivjPaymentSelect == null) {
		try {
			ivjPaymentSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjPaymentSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.PaymentDAB.connToIBank(), com.overstar.ildar.ibank.model.PaymentDAB.PaymentSelectSQL()));
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
 * Return the PaymentUpdate property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getPaymentUpdate() {
	if (ivjPaymentUpdate == null) {
		try {
			ivjPaymentUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjPaymentUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.PaymentDAB.connToIBank(), com.overstar.ildar.ibank.model.PaymentDAB.PaymentUpdateSQL()));
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
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newAmount com.overstar.ildar.ibank.model.Money
 */
void initAmount(Money newAmount) {
	amount = newAmount;
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newKpp java.lang.String
 */
void initKpp(java.lang.String newKpp) {
	kpp = newKpp;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayer_account java.lang.String
 */
void initPayer_account(java.lang.String newPayer_account) {
	payer_account = newPayer_account;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayer_bank_acc java.lang.String
 */
void initPayer_bank_acc(java.lang.String newPayer_bank_acc) {
	payer_bank_acc = newPayer_bank_acc;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayer_bank_bic java.lang.String
 */
void initPayer_bank_bic(java.lang.String newPayer_bank_bic) {
	payer_bank_bic = newPayer_bank_bic;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayer_bank_name java.lang.String
 */
void initPayer_bank_name(java.lang.String newPayer_bank_name) {
	payer_bank_name = newPayer_bank_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayer_inn java.lang.String
 */
void initPayer_inn(java.lang.String newPayer_inn) {
	payer_inn = newPayer_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayer_name java.lang.String
 */
void initPayer_name(java.lang.String newPayer_name) {
	payer_name = newPayer_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayment_details java.lang.String
 */
void initPayment_details(java.lang.String newPayment_details) {
	payment_details = newPayment_details;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newPayment_type java.lang.String
 */
void initPayment_type(java.lang.String newPayment_type) {
	payment_type = newPayment_type;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newQueue java.lang.String
 */
void initQueue(java.lang.String newQueue) {
	queue = newQueue;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newRcpt_account java.lang.String
 */
void initRcpt_account(java.lang.String newRcpt_account) {
	rcpt_account = newRcpt_account;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newRcpt_bank_acc java.lang.String
 */
void initRcpt_bank_acc(java.lang.String newRcpt_bank_acc) {
	rcpt_bank_acc = newRcpt_bank_acc;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newRcpt_bank_bic java.lang.String
 */
void initRcpt_bank_bic(java.lang.String newRcpt_bank_bic) {
	rcpt_bank_bic = newRcpt_bank_bic;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newRcpt_bank_name java.lang.String
 */
void initRcpt_bank_name(java.lang.String newRcpt_bank_name) {
	rcpt_bank_name = newRcpt_bank_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newRcpt_inn java.lang.String
 */
void initRcpt_inn(java.lang.String newRcpt_inn) {
	rcpt_inn = newRcpt_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newRcpt_name java.lang.String
 */
void initRcpt_name(java.lang.String newRcpt_name) {
	rcpt_name = newRcpt_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newTerm java.sql.Date
 */
void initTerm(java.sql.Date newTerm) {
	term = newTerm;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @param newType_oper java.lang.String
 */
void initType_oper(java.lang.String newType_oper) {
	type_oper = newType_oper;
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
    Payment tempPayment;

    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        String newPaymentIDstr = "3"; // определите newPaymentIDstr !!!
        String newClientIDstr = "1"; // определите newClientIDstr !!!
        Integer newClient_ID = new Integer(newClientIDstr);
        System.out.println("Make new Payment with key " + newPaymentIDstr + "\n"); //Может убить существующую запись в базе!!!
        tempPayment =
            new Payment(
                new Document.DocumentPK(newPaymentIDstr),
                newClient_ID,
                new java.sql.Date(System.currentTimeMillis()),
                "№" + newPaymentIDstr,
                Document.NEW,
                "S" + newPaymentIDstr,
                Document.PAYMENTS,
                Payment.ELECTRONIC,
                "Payer_inn" + newPaymentIDstr,
                "Payer_name" + newPaymentIDstr,
                "Payer_account" + newPaymentIDstr,
                "Payer_bank_name" + newPaymentIDstr,
                "P_b_bic" + newPaymentIDstr,
                "Payer_bank_acc" + newPaymentIDstr,
                new Money(new BigInteger("1111"), 2),
                "Rcpt_inn" + newPaymentIDstr,
                "Rcpt_name" + newPaymentIDstr,
                "Rcpt_account" + newPaymentIDstr,
                "Rcpt_bank_name" + newPaymentIDstr,
                "R_b_bic" + newPaymentIDstr,
                "Rcpt_bank_acc" + newPaymentIDstr,
                "01",
                newPaymentIDstr,
                new java.sql.Date(System.currentTimeMillis()),
                "Payment_details" + newPaymentIDstr,
                "Kpp" + newPaymentIDstr,
                true);
        System.out.println(tempPayment.toStringFull());
        System.out.println("______________________________________");
        System.out.println();

        ////////////////////////////////////////////////////////////////
        String getPaymentIDstr = "3";
        System.out.println("Find Payment with key " + getPaymentIDstr + ".\n");
        tempPayment = findWithPaymentPK(getPaymentIDstr);
        System.out.println(tempPayment.toStringFull());
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
                Document.DELIVERED,
                "S" + newPaymentIDstr,
                Document.PAYMENTS,
                Payment.ELECTRONIC,
                "Payer_inn" + newPaymentIDstr,
                "Payer_name" + newPaymentIDstr,
                "Payer_account" + newPaymentIDstr,
                "Payer_bank_name" + newPaymentIDstr,
                "P_b_bic" + newPaymentIDstr,
                "Payer_bank_acc" + newPaymentIDstr,
                new Money(newPaymentIDstr + ".05"),
                "Rcpt_inn" + newPaymentIDstr,
                "Rcpt_name" + newPaymentIDstr,
                "Rcpt_account" + newPaymentIDstr,
                "Rcpt_bank_name" + newPaymentIDstr,
                "R_b_bic" + newPaymentIDstr,
                "Rcpt_bank_acc" + newPaymentIDstr,
                "01",
                newPaymentIDstr,
                new java.sql.Date(System.currentTimeMillis()),
                "Payment_details" + newPaymentIDstr,
                "Kpp" + newPaymentIDstr,
                true);
        System.out.println(tempPayment.toStringFull());
        System.out.println("______________________________________");
        System.out.println();
        System.out.println("Find Payment with unique key " + tempPayment.getDoc_id() + ".\n");
        tempPayment = findWithPaymentPK(tempPayment.getDoc_id().getIdAsString());
        System.out.println(tempPayment.toStringFull());
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
 * Creation date: (16.10.2002 16:40:52)
 * @return com.overstar.ildar.ibank.model.Money
 */
public Money rtAmount() {
	return amount;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtKpp() {
	return kpp;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayer_account() {
	return payer_account;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayer_bank_acc() {
	return payer_bank_acc;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayer_bank_bic() {
	return payer_bank_bic;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayer_bank_name() {
	return payer_bank_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayer_inn() {
	return payer_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayer_name() {
	return payer_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayment_details() {
	return payment_details;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtPayment_type() {
	return payment_type;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtQueue() {
	return queue;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtRcpt_account() {
	return rcpt_account;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtRcpt_bank_acc() {
	return rcpt_bank_acc;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtRcpt_bank_bic() {
	return rcpt_bank_bic;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtRcpt_bank_name() {
	return rcpt_bank_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtRcpt_inn() {
	return rcpt_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtRcpt_name() {
	return rcpt_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.sql.Date
 */
public java.sql.Date rtTerm() {
	return term;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2002 16:40:52)
 * @return java.lang.String
 */
public java.lang.String rtType_oper() {
	return type_oper;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 15:55:04)
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
private void store() throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists()) {
            modify = getPaymentUpdate();
            modify.setParameter("ID", this.getDoc_id().getIdAsString());

        }
        else {
            //record doesn't exist.
            modify = getPaymentInsert();
        }

        modify.setParameterFromString("DOC_ID", this.getDoc_id().getIdAsString());
        modify.setParameter("CLIENT_ID", rtClient_id());
        modify.setParameter("DATE_DOC", rtDate_doc());
        modify.setParameter("NUM_DOC", rtNum_doc());
        modify.setParameter("PAYMENT_TYPE", rtPayment_type());
        modify.setParameter("PAYER_INN", rtPayer_inn());
        modify.setParameter("PAYER_NAME", rtPayer_name());
        modify.setParameter("PAYER_ACCOUNT", rtPayer_account());
        modify.setParameter("AMOUNT", rtAmount());
        modify.setParameter("PAYER_BANK_NAME", rtPayer_bank_name());
        modify.setParameter("PAYER_BANK_BIC", rtPayer_bank_bic());
        modify.setParameter("PAYER_BANK_ACC", rtPayer_bank_acc());
        modify.setParameter("RCPT_INN", rtRcpt_inn());
        modify.setParameter("RCPT_NAME", rtRcpt_name());
        modify.setParameter("RCPT_ACCOUNT", rtRcpt_account());
        modify.setParameter("RCPT_BANK_NAME", rtRcpt_bank_name());
        modify.setParameter("RCPT_BANK_BIC", rtRcpt_bank_bic());
        modify.setParameter("RCPT_BANK_ACC", rtRcpt_bank_acc());
        modify.setParameter("TYPE_OPER", rtType_oper());
        modify.setParameter("QUEUE", rtQueue());
        modify.setParameter("TERM", rtTerm());
        modify.setParameter("PAYMENT_DETAILS", rtPayment_details());
        modify.setParameter("KPP", rtKpp());
        modify.setParameter("STATUS_DOC", rtStatus_doc());
        modify.setParameter("SIGNERS", rtSigners());

        modify.execute();
        //load();

    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Specific implementation for toStringFull().
 * 
 * Creation date: (23.09.2002 19:11:03)
 * @return java.lang.String
 */
public String toStringFull() {
    return "Payment ("
        + super.toString()
        + " Amount ("
        + rtAmount()
        + ")"
        + ".\n "
        + " Rcpt_name ("
        + rtRcpt_name()
        + ")"
        + ".\n ";
}
}
