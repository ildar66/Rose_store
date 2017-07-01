package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (16.09.2002 15:34:46)
 * @author: Shafigullin Ildar
 */
import java.util.Vector;
public class Bank {

    /**
     * PrimaryKey class to be used for instances of type Bank.
     */
    public static class BankPK extends PrimaryKey {
        public BankPK(String anId) {
            super(anId);
        }
    }
    private com.ibm.ivj.db.uibeans.Select ivjBankSelect = null;
    private BankPK bik;
    private java.lang.String bill_corr;
    private java.lang.String bank_name;
    private java.lang.String city;
    private java.lang.String delivery;
    private com.ibm.ivj.db.uibeans.Select ivjBankSelectBikName = null;
public Bank() {
	super();
	initialize();
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:46:38)
 * @param anBik anBik
 * @param anBill_corr java.lang.String
 * @param anBank_name java.lang.String
 * @param anCity java.lang.String
 * @param anDelivery java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Bank(BankPK anBik, String anBill_corr, String anBank_name, String anCity, String anDelivery)
    throws PersistenceException {
    bik = anBik;
    initBill_corr(anBill_corr);
    initBank_name(anBank_name);
    initCity(anCity);
    initDelivery(anDelivery);
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:15:28)
 * @return com.overstar.ildar.ibank.model.Bank
 * @param anId com.overstar.ildar.ibank.model.Bank.BankPK
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static Bank findWithBankPK(BankPK anBik) throws PersistenceException {
    try {
        Bank tempBank = new Bank();
        com.ibm.ivj.db.uibeans.Select select = tempBank.getBankSelect();
        select.setParameter("BIK", anBik.getIdAsString());
        select.execute();
        if (select.getRowCount() <= 0) {
            throw new BankNotFoundException("The Bank with primary key " + anBik.getIdAsString() + " was not found.");
        }
        select.firstRow();
        String tmpBankBIK = (String) select.getColumnValue("BANKS.BIK");
        String tmpBankBILL_CORR = (String) select.getColumnValue("BANKS.BILL_CORR");
        String tmpBankBANK_NAME = (String) select.getColumnValue("BANKS.BANK_NAME");
        String tmpBankCITY = (String) select.getColumnValue("BANKS.CITY");
        String tmpBankDELIVERY = (String) select.getColumnValue("BANKS.DELIVERY");
        tempBank = new Bank((new BankPK(tmpBankBIK)), tmpBankBILL_CORR, tmpBankBANK_NAME, tmpBankCITY, tmpBankDELIVERY);
        return tempBank;
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 17:42:11)
 * @return com.overstar.ildar.ibank.model.Bank
 * @param anId java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static Bank findWithBankPK(String anBikStr) throws PersistenceException {
	return findWithBankPK(new BankPK(anBikStr));
}
/**
 * Insert the method's description here.
 * Creation date: (17.09.2002 11:36:45)
 * @return java.util.Vector
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getBanks(String anBik, String anBank_name) throws PersistenceException {
    try {
        Vector tmpBanks = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getBankSelectBikName();

        select.setParameter("BIK", anBik);
        select.setParameter("BANK_NAME", anBank_name);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            Bank tempBank;
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpBankBIK = (String) select.getColumnValue("BANKS.BIK");
                String tmpBankBILL_CORR = (String) select.getColumnValue("BANKS.BILL_CORR");
                String tmpBankBANK_NAME = (String) select.getColumnValue("BANKS.BANK_NAME");
                String tmpBankCITY = (String) select.getColumnValue("BANKS.CITY");
                String tmpBankDELIVERY = (String) select.getColumnValue("BANKS.DELIVERY");
                tempBank = new Bank((new BankPK(tmpBankBIK)), tmpBankBILL_CORR, tmpBankBANK_NAME, tmpBankCITY, tmpBankDELIVERY);
                // add the new bank to the vector tmpBanks
                tmpBanks.addElement(tempBank);
                select.nextRow();
            }
        }

        //return new Vector(tmpBanks);
        return tmpBanks;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (08.10.2002 11:24:47)
 * @return java.util.Vector
 * @param anBik java.lang.String
 * @param anBank_name java.lang.String
 * @param aSortBy java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getBanks(String anBik, String anBank_name, String aSortBy) throws PersistenceException {
    try {
        Vector tmpBanks = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getBankSelectBikName();

        String statement =
            "SELECT ILDAR.BANKS.BIK, ILDAR.BANKS.BILL_CORR, ILDAR.BANKS.BANK_NAME, ILDAR.BANKS.CITY, ILDAR.BANKS.DELIVERY FROM ILDAR.BANKS WHERE ( ( ILDAR.BANKS.BIK like '%'||:BIK||'%' ) AND ( ILDAR.BANKS.BANK_NAME like '%'||:BANK_NAME||'%' ) ) ";
        select.getStatementMetaData().setSQL(statement + " order by " + aSortBy);

        select.setParameter("BIK", anBik);
        select.setParameter("BANK_NAME", anBank_name);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            Bank tempBank;
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpBankBIK = (String) select.getColumnValue("BANKS.BIK");
                String tmpBankBILL_CORR = (String) select.getColumnValue("BANKS.BILL_CORR");
                String tmpBankBANK_NAME = (String) select.getColumnValue("BANKS.BANK_NAME");
                String tmpBankCITY = (String) select.getColumnValue("BANKS.CITY");
                String tmpBankDELIVERY = (String) select.getColumnValue("BANKS.DELIVERY");
                tempBank = new Bank((new BankPK(tmpBankBIK)), tmpBankBILL_CORR, tmpBankBANK_NAME, tmpBankCITY, tmpBankDELIVERY);
                // add the new bank to the vector tmpBanks
                tmpBanks.addElement(tempBank);
                select.nextRow();
            }
        }

        //return new Vector(tmpBanks);
        return tmpBanks;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.10.2002 16:37:02)
 * @return java.util.Vector
 * @param anBik java.lang.String
 * @param anBank_name java.lang.String
 * @param aSortBy java.lang.String
 * @param aOperation java.lang.String
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public Vector getBanks(String anBik, String anBank_name, String aSortBy, String aOperation) throws PersistenceException {
    try {
        Vector tmpBanks = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = this.getBankSelectBikName();

        String statement =
            "SELECT ILDAR.BANKS.BIK, ILDAR.BANKS.BILL_CORR, ILDAR.BANKS.BANK_NAME, ILDAR.BANKS.CITY, ILDAR.BANKS.DELIVERY FROM ILDAR.BANKS WHERE ( ( ILDAR.BANKS.BIK like '%'||:BIK||'%' ) " + aOperation + " ( ILDAR.BANKS.BANK_NAME like '%'||:BANK_NAME||'%' ) ) ";
        select.getStatementMetaData().setSQL(statement + " order by " + aSortBy);

        select.setParameter("BIK", anBik);
        select.setParameter("BANK_NAME", anBank_name);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            Bank tempBank;
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpBankBIK = (String) select.getColumnValue("BANKS.BIK");
                String tmpBankBILL_CORR = (String) select.getColumnValue("BANKS.BILL_CORR");
                String tmpBankBANK_NAME = (String) select.getColumnValue("BANKS.BANK_NAME");
                String tmpBankCITY = (String) select.getColumnValue("BANKS.CITY");
                String tmpBankDELIVERY = (String) select.getColumnValue("BANKS.DELIVERY");
                tempBank = new Bank((new BankPK(tmpBankBIK)), tmpBankBILL_CORR, tmpBankBANK_NAME, tmpBankCITY, tmpBankDELIVERY);
                // add the new bank to the vector tmpBanks
                tmpBanks.addElement(tempBank);
                select.nextRow();
            }
        }

        //return new Vector(tmpBanks);
        return tmpBanks;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Return the BankSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getBankSelect() {
	if (ivjBankSelect == null) {
		try {
			ivjBankSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjBankSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.BankDAB.connToIBank(), com.overstar.ildar.ibank.model.BankDAB.BankSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBankSelect;
}
/**
 * Return the BankSelectBikName property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getBankSelectBikName() {
	if (ivjBankSelectBikName == null) {
		try {
			ivjBankSelectBikName = new com.ibm.ivj.db.uibeans.Select();
			ivjBankSelectBikName.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.BankDAB.connToIBank(), com.overstar.ildar.ibank.model.BankDAB.BankSelectBikNameSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBankSelectBikName;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @return com.overstar.ildar.ibank.model.Bank.BankPK
 */
public com.overstar.ildar.ibank.model.Bank.BankPK getBik() {
	return bik;
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
 * Creation date: (16.09.2002 16:59:29)
 * @param newBank_name java.lang.String
 */
void initBank_name(java.lang.String newBank_name) {
	bank_name = newBank_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @param newBill_corr java.lang.String
 */
void initBill_corr(java.lang.String newBill_corr) {
	bill_corr = newBill_corr;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @param newCity java.lang.String
 */
void initCity(java.lang.String newCity) {
	city = newCity;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @param newDelivery java.lang.String
 */
void initDelivery(java.lang.String newDelivery) {
	delivery = newDelivery;
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
        Bank tempBank;
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");

        String bankBikStr = "bik1"; // Подставьте BIK банка.
/*        System.out.println("Find Bank with key " + bankBikStr + ".\n");
        tempBank = findWithBankPK(bankBikStr);
        System.out.println(tempBank.toStringFull());
        System.out.println("_____________End test 1_____________________");
        System.out.println();
*/
/*        tempBank = new Bank();
        bankBikStr = "1"; // Подставьте BIK банка.
        String bankNameStr = "1"; // Подставьте NAME банка.
        System.out.println("Find Banks with like: key and(or) name : " + bankBikStr + " and(or) " + bankNameStr + ".\n");
        Vector tempBanks = tempBank.getBanks(bankBikStr, bankNameStr);
        for (int i = 0; i < tempBanks.size(); i++) {
            tempBank = (Bank) tempBanks.elementAt(i);
            System.out.println(" " + (i+1) + ": "+tempBank.toStringFull());
        }
        System.out.println("_______________End test 2_____________________");
        System.out.println();
*/
        tempBank = new Bank();
        bankBikStr = "%"; // Подставьте BIK банка.
        String bankNameStr = "%"; // Подставьте NAME банка.
        String aSortBy = "delivery desc";//Подставьте bik(bill_corr, bank_name, city, delivery ) ("desc") банка.
        System.out.println("Find Banks with like: key and(or) name sortBy \""+ aSortBy+ "\": \"" + bankBikStr + "\" and(or) \"" + bankNameStr + "\".\n");
        Vector tempBanks = tempBank.getBanks(bankBikStr, bankNameStr, aSortBy);
        for (int i = 0; i < tempBanks.size(); i++) {
            tempBank = (Bank) tempBanks.elementAt(i);
            System.out.println(" " + (i+1) + ": "+tempBank.toStringFull());
        }
        System.out.println("_______________End test 2_____________________");
        System.out.println();
        
    }
    catch (Throwable exception) {
        System.err.println("Exception occurred in main() of java.lang.Object");
        exception.printStackTrace(System.out);
    }
    System.out.println("Main() ended at: " + new java.util.Date());
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @return java.lang.String
 */
public java.lang.String rtBank_name() {
	return bank_name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @return java.lang.String
 */
public java.lang.String rtBill_corr() {
	return bill_corr;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @return java.lang.String
 */
public java.lang.String rtCity() {
	return city;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:59:29)
 * @return java.lang.String
 */
public java.lang.String rtDelivery() {
	return delivery;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 17:51:16)
 * @return java.lang.String
 */
public String toString() {
    return "\nBank.BIK(" + bik + ")" + ".\n ";
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 17:52:52)
 * @return java.lang.String
 */
public String toStringFull() {
	 return "\nBank : bIK (" + bik + ")" + ".\n " + 
        " bill_corr (" + bill_corr + ")" + ".\n " + 
        " bank_name  (" + bank_name + ")" + ".\n " + 
        " city (" + city + ")" + ".\n " +
        " delivery (" + delivery + ")" + ".\n " ;
        
}
}
