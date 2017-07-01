package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (31.10.2002 11:23:26)
 * @author: Shafigullin Ildar
 */
public class BankAccountData {
	private com.ibm.ivj.db.uibeans.Select ivjBankAccountSelect = null;
	private com.ibm.ivj.db.uibeans.Modify ivjBankAccountInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjBankAccountUpdate = null;
	private com.ibm.ivj.db.uibeans.Modify ivjBankAccountDelete = null;
/**
 * BankAccountData constructor comment.
 */
public BankAccountData() {
	super();
	initialize();
}
/**
 * Return the BankAccountDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getBankAccountDelete() {
	if (ivjBankAccountDelete == null) {
		try {
			ivjBankAccountDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjBankAccountDelete.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.BankAccountDAB.connToIBank(), com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountDeleteSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBankAccountDelete;
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 11:56:01)
 * @return com.ibm.ivj.db.uibeans.Modify
 */
com.ibm.ivj.db.uibeans.Modify getBankAccountDelete_W() {
	return getBankAccountDelete();
}
/**
 * Return the BankAccountInsert property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getBankAccountInsert() {
	if (ivjBankAccountInsert == null) {
		try {
			ivjBankAccountInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjBankAccountInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.BankAccountDAB.connToIBank(), com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBankAccountInsert;
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 11:56:42)
 * @return com.ibm.ivj.db.uibeans.Modify
 */
com.ibm.ivj.db.uibeans.Modify getBankAccountInsert_W() {
	return getBankAccountInsert();
}
/**
 * Return the BankAccountSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getBankAccountSelect() {
	if (ivjBankAccountSelect == null) {
		try {
			ivjBankAccountSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjBankAccountSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.BankAccountDAB.connToIBank(), com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBankAccountSelect;
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 11:54:25)
 * @return com.ibm.ivj.db.uibeans.Select
 */
com.ibm.ivj.db.uibeans.Select getBankAccountSelect_W() {
	return getBankAccountSelect();
}
/**
 * Return the BankAccountUpdate property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getBankAccountUpdate() {
	if (ivjBankAccountUpdate == null) {
		try {
			ivjBankAccountUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjBankAccountUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.BankAccountDAB.connToIBank(), com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountUpdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBankAccountUpdate;
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 11:57:24)
 * @return com.ibm.ivj.db.uibeans.Modify
 */
com.ibm.ivj.db.uibeans.Modify getBankAccountUpdate_W() {
	return getBankAccountUpdate();
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
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
    try {
        //BankAccountData aBankAccountData;
        //aBankAccountData = new BankAccountData();
        BankAccount tempBankAccount;
        String branch_id = "BRANCH_ID1";
        String account = "account2";
        BankAccount.BankAccountPK id = new BankAccount.BankAccountPK(branch_id, account);
        Integer client_id = new Integer("1");
        java.sql.Date create_date = new java.sql.Date(System.currentTimeMillis());
        Money create_amount = new Money("2000.0");
        //String currency = "";//в другой конструктор :)

        tempBankAccount = new RunningAccount(id, client_id, create_date, create_amount, true);
        //tempBankAccount = new TransientAccount(id, client_id, create_date, create_amount, true);
        //tempBankAccount = new SettlementAccount(id, client_id, create_date, create_amount, true);
        //tempBankAccount = new SpecTransientAccount(id, client_id, create_date, create_amount, true);
        tempBankAccount = BankAccount.findWithBankAccountPK(id);
        System.out.println(tempBankAccount);
        }
    catch (Throwable exception) {
        System.err.println("Exception occurred in main() of java.lang.Object");
        exception.printStackTrace(System.out);
    }
}
}
