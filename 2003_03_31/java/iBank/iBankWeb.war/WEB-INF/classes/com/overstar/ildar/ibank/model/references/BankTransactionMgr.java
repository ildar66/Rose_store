package com.overstar.ildar.ibank.model.references;

import java.util.Vector;
import com.overstar.ildar.ibank.model.exceptions.*;
/**
* Insert the type's description here.
* Creation date: (17.01.2003 10:04:36)
* @author: Shafigullin Ildar
*/
public class BankTransactionMgr {
    private static com.ibm.ivj.db.uibeans.Select ivjBankSelect = null;
    private static com.ibm.ivj.db.uibeans.Select ivjBankSelectBikName = null;
/**
 * BankTransactionMgr constructor comment.
 */
public BankTransactionMgr() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:15:28)
 * @param anBik
 * @return com.overstar.ildar.ibank.model.references.Bank
 * @throws com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception 
 * description.
 * @roseuid 3E00418B006E
 */
public static synchronized Bank findWithBankPK(Bank.BankPK anBik) throws PersistenceException {
    try {
        Bank tempBank;
        com.ibm.ivj.db.uibeans.Select select = getBankSelect();
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
        tempBank = new Bank((new Bank.BankPK(tmpBankBIK)), tmpBankBILL_CORR, tmpBankBANK_NAME, tmpBankCITY, tmpBankDELIVERY);
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
    * @param anBikStr
    * @return Bank
    * @throws com.overstar.ildar.ibank.model.exceptions.PersistenceException
    * @roseuid 3E00418B00D1
    */
   public static synchronized Bank findWithBankPK(String anBikStr) throws PersistenceException 
   {
	return findWithBankPK(new Bank.BankPK(anBikStr));    
   }
/**
 * Insert the method's description here.
 * Creation date: (09.10.2002 16:37:02)
 * @return java.util.Vector
 * @param anBik java.lang.String
 * @param anBank_name java.lang.String
 * @param aSortBy java.lang.String
 * @param aOperation java.lang.String
 * @return java.util.Vector
 * @throws com.overstar.ildar.ibank.model.exceptions.PersistenceException
 * @roseuid 3E00418B019A
 */
public static synchronized Vector getBanks(String anBik, String anBank_name, String aSortBy, String aOperation)
    throws PersistenceException {
    try {
        Vector tmpBanks = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = getBankSelectBikName();

        String statement =
            "SELECT ILDAR.BANKS.BIK, ILDAR.BANKS.BILL_CORR, ILDAR.BANKS.BANK_NAME, ILDAR.BANKS.CITY, ILDAR.BANKS.DELIVERY FROM ILDAR.BANKS WHERE ( ( ILDAR.BANKS.BIK like '%'||:BIK||'%' ) "
                + aOperation
                + " ( ILDAR.BANKS.BANK_NAME like '%'||:BANK_NAME||'%' ) ) order by "
                + aSortBy;
        select.getStatementMetaData().setSQL(statement);

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
                tempBank = new Bank((new Bank.BankPK(tmpBankBIK)), tmpBankBILL_CORR, tmpBankBANK_NAME, tmpBankCITY, tmpBankDELIVERY);
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
 * WARNING: THIS METHOD WILL BE REGENERATED.
 * @roseuid 3E00418B0208
 */
private static com.ibm.ivj.db.uibeans.Select getBankSelect() {
    if (ivjBankSelect == null) {
        try {
            ivjBankSelect = new com.ibm.ivj.db.uibeans.Select();
            ivjBankSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(BankDAB.connToIBank(), BankDAB.BankSelectSQL()));
            // user code begin {1}
            // user code end
        }
        catch (java.lang.Throwable ivjExc) {
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
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E00418B0276
    */
   private static com.ibm.ivj.db.uibeans.Select getBankSelectBikName() 
   {
	if (ivjBankSelectBikName == null) {
		try {
			ivjBankSelectBikName = new com.ibm.ivj.db.uibeans.Select();
			ivjBankSelectBikName.setQuery(new com.ibm.ivj.db.uibeans.Query(BankDAB.connToIBank(), BankDAB.BankSelectBikNameSQL()));
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
    * Called whenever the part throws an exception.
    * @param exception java.lang.Throwable
    * @roseuid 3E00418B0348
    */
   private static void handleException(java.lang.Throwable exception) 
   {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	exception.printStackTrace(System.out);    
   }
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 * @roseuid 3E00418C0097
 */
public static void main(java.lang.String[] args) {
    try {
        Bank tempBank;
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");

        String bankBikStr = "bic1"; // Подставьте BIK банка.
        System.out.println("Find Bank with key " + bankBikStr + ".\n");
        tempBank = BankTransactionMgr.findWithBankPK(bankBikStr);
        System.out.println(tempBank.toStringFull());
        System.out.println("_____________End test 1_____________________");
        System.out.println();

        bankBikStr = "%b"; // Подставьте BIK банка.
        String bankNameStr = "%А"; // Подставьте NAME банка.
        String aSortBy = "delivery desc"; //Подставьте bik(bill_corr, bank_name, city, delivery ) ("desc") банка.
        String aOperation = "or"; //Подставьте bik(bill_corr, bank_name, city, delivery ) ("desc") банка.
        System.out.println(
            "Find Banks with like-:- key:\""
                + bankBikStr
                + "\" "
                + aOperation
                + " \"bankName:\""
                + bankNameStr
                + "\" sort by:\""
                + aSortBy
                + "\".\n");
        Vector tempBanks = BankTransactionMgr.getBanks(bankBikStr, bankNameStr, aSortBy, aOperation);
        for (int i = 0; i < tempBanks.size(); i++) {
            tempBank = (Bank) tempBanks.elementAt(i);
            System.out.println(" " + (i + 1) + ": " + tempBank.toStringFull());
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
}
