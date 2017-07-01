package com.overstar.ildar.ibank.model.accounts;

import java.util.Vector;
import com.overstar.ildar.ibank.model.Money;
import com.overstar.ildar.ibank.model.exceptions.*;
import java.sql.Date;
import java.math.*;
/**
 * Insert the type's description here.
 * Creation date: (31.10.2002 11:23:26)
 * @author: Shafigullin Ildar
 */
public class BankAccountTransactionMgr {
    private static com.ibm.ivj.db.uibeans.Select ivjBankAccountSelect = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjBankAccountInsert = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjBankAccountUpdate = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjBankAccountDelete = null;
    private static com.ibm.ivj.db.uibeans.Select ivjIClientBankAccountsSelect = null;
    /**
     * текущий.
     */
    public static final int RUNNING = 1;

    /**
     * расчетный.
     */
    public static final int SETTLEMENT = 0;

    /**
     * транзитный.
     */
    public static final int TRANSIENT = 2;

    /**
    * спецтранзитный.
    */
    public static final int SPEC_TRANSIENT = 3;

/**
 * BankAccountData constructor comment.
 * @roseuid 3E0041920208
 */
public BankAccountTransactionMgr() {
    super();
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 11:24:24)
 * @param accID BankAccount.BankAccountPK
 */
public static synchronized void deleteWithBankAccountPK(BankAccount.BankAccountPK accID) throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        modify = getBankAccountDelete();
        modify.setParameter("BRANCH_ID", accID.getId1AsString());
        modify.setParameter("ACCOUNT", accID.getId2AsString());

        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 15:41:54)
 * @return boolean
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0EEA0601DA
 */
private static synchronized boolean exists(BankAccount aBankAccount) throws PersistenceException {
    try {

        com.ibm.ivj.db.uibeans.Select select = getBankAccountSelect();

        select.setParameter("BRNCH_ID", aBankAccount.getId().getId1AsString());
        select.setParameter("ACCOUNT", aBankAccount.getId().getId2AsString());

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
    * Creation date: (31.10.2002 12:43:06)
    * @return com.overstar.ildar.ibank.model.BankAccount
    * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
    * @return BankAccount
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0EEA06022A
    */
   public static synchronized BankAccount findWithBankAccountPK(BankAccount.BankAccountPK anId) throws PersistenceException 
   {
    BankAccount tempBankAccount = null;
    if ((tempBankAccount = (BankAccount) searchExistingFor(anId)) == null) {
        throw new BankAccountNotFoundException("The BankAccount with primary key (" +anId.getId2AsString()+" - "+ anId.getId2AsString() + ") was not found.");
    }
    return tempBankAccount;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (01.11.2002 10:47:52)
    * @return com.overstar.ildar.ibank.model.BankAccount
    * @param anBranch_id java.lang.String
    * @param anAccount java.lang.String
    * @return BankAccount
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0EEA0602C0
    */
   public static synchronized BankAccount findWithBankAccountPK(String anBranch_id, String anAccount) throws PersistenceException 
   {
	return findWithBankAccountPK(new BankAccount.BankAccountPK (anBranch_id, anAccount));    
   }
   /**
    * Return the BankAccountDelete property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041920230
    */
   private static com.ibm.ivj.db.uibeans.Modify getBankAccountDelete() 
   {
	if (ivjBankAccountDelete == null) {
		try {
			ivjBankAccountDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjBankAccountDelete.setAction(new com.ibm.ivj.db.uibeans.Query(BankAccountDAB.connToIBank(), BankAccountDAB.BankAccountDeleteSQL()));
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
    * Return the BankAccountInsert property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041920316
    */
   private static com.ibm.ivj.db.uibeans.Modify getBankAccountInsert() 
   {
	if (ivjBankAccountInsert == null) {
		try {
			ivjBankAccountInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjBankAccountInsert.setAction(new com.ibm.ivj.db.uibeans.Query(BankAccountDAB.connToIBank(), BankAccountDAB.BankAccountInsertSQL()));
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
    * Return the BankAccountSelect property value.
    * @return com.ibm.ivj.db.uibeans.Select
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E004193000A
    */
   private static com.ibm.ivj.db.uibeans.Select getBankAccountSelect() 
   {
	if (ivjBankAccountSelect == null) {
		try {
			ivjBankAccountSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjBankAccountSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(BankAccountDAB.connToIBank(), BankAccountDAB.BankAccountSelectSQL()));
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
    * Creation date: (01.11.2002 10:15:49)
    * @param iClient com.overstar.ildar.ibank.model.IClient
    * @return java.util.Vector
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041A1032C 
    */
   public static synchronized Vector getBankAccountsForIClient(String iClient) throws PersistenceException 
   {
    try {
        Vector tmpBankAccountsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = getIClientBankAccountsSelect();
        select.setParameterFromString("CLIENT_ID", iClient);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs > 0) {
            select.firstRow();
            for (int i = 0; i < numrecs; i++) {
                String tmpAccountsBRANCH_ID = (String) select.getColumnValue("ACCOUNTS.BRANCH_ID");
                String tmpAccountsACCOUNT = (String) select.getColumnValue("ACCOUNTS.ACCOUNT");
                BankAccount tmpbnkacct = BankAccountTransactionMgr.findWithBankAccountPK(tmpAccountsBRANCH_ID, tmpAccountsACCOUNT);
                // add the new Recipient to the vector holding all recipients associated with
                // this IClient.
                tmpBankAccountsAll.addElement(tmpbnkacct);
                select.nextRow();
            }
        }
        
        //return new Vector(tmpBankAccountsAll);
        return tmpBankAccountsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }    
   }
   /**
    * Return the BankAccountUpdate property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E00419300F1
    */
   private static com.ibm.ivj.db.uibeans.Modify getBankAccountUpdate() 
   {
	if (ivjBankAccountUpdate == null) {
		try {
			ivjBankAccountUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjBankAccountUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(BankAccountDAB.connToIBank(), BankAccountDAB.BankAccountUpdateSQL()));
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
    * Return the IClientBankAccountsSelect property value.
    * @return com.ibm.ivj.db.uibeans.Select
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041A20110
    */
   private static com.ibm.ivj.db.uibeans.Select getIClientBankAccountsSelect() 
   {
	if (ivjIClientBankAccountsSelect == null) {
		try {
			ivjIClientBankAccountsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientBankAccountsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(BankAccountDAB.connToIBank(), BankAccountDAB.IClientBankAccountsSelectSQL()));
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
    * Called whenever the part throws an exception.
    * @param exception java.lang.Throwable
    * @roseuid 3E00419301B9
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
 * @roseuid 3E0041930227
 */
public static void main(java.lang.String[] args) {
    try {
        BankAccount tempBankAccount;
        String branch_id = "BRANCH_ID1";
        String account = "ACC_tempST";
        BankAccount.BankAccountPK id = new BankAccount.BankAccountPK(branch_id, account);
        Integer client_id = new Integer("3");
        java.sql.Date create_date = new java.sql.Date(System.currentTimeMillis());
        Money create_amount = new Money("1000.0");

        System.out.println("Make new BankAccount for IClient:" + client_id + " with key " + id + "\n");
        //tempBankAccount = new RunningAccount(id, client_id, create_date, create_amount);
        //tempBankAccount = new TransientAccount(id, client_id, create_date, create_amount);
        //tempBankAccount = new SettlementAccount(id, client_id, create_date, create_amount);
        tempBankAccount = new SpecTransientAccount(id, client_id, create_date, create_amount);
        BankAccountTransactionMgr.storeBankAccount(tempBankAccount);
        tempBankAccount = BankAccountTransactionMgr.findWithBankAccountPK(id);
        System.out.println(tempBankAccount);
        System.out.println("______________________________________");
        System.out.println();
        ////////////////////////////////////////////////////////////////

        //Счета:
        System.out.println("Счета для IClient:" + client_id + "\n");
        Vector bankAccounts = getBankAccountsForIClient(client_id.toString());
        System.out.println(bankAccounts);
        System.out.println("______________________________________");
        System.out.println();
        //Удаление счета:
        branch_id = "BRANCH_ID1";
        account = "ACC_tempST";
        id = new BankAccount.BankAccountPK(branch_id, account);
        System.out.println("Удаление счета:" + id + " для IClient:" + client_id + "\n");
        deleteWithBankAccountPK(id);
        System.out.println( "Счета для IClient:" + client_id +" :\n"+getBankAccountsForIClient(client_id.toString()) );
        System.out.println("______________________________________");
        System.out.println();
    }
    catch (Throwable exception) {
        System.err.println("Exception occurred in main() of java.lang.Object");
        exception.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 13:03:13)
 * @return com.overstar.ildar.ibank.model.BankAccount
 * @param anId com.overstar.ildar.ibank.model.BankAccount.BankAccountPK
 * @return BankAccount
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0EEA0703D0
 */
private static synchronized BankAccount searchExistingFor(BankAccount.BankAccountPK anId) throws PersistenceException {
    try {
        BankAccount tempBankAccount = null;
        com.ibm.ivj.db.uibeans.Select select = getBankAccountSelect();

        select.setParameter("BRNCH_ID", anId.getId1AsString());
        select.setParameter("ACCOUNT", anId.getId2AsString());

        select.execute();
        if (select.getRowCount() <= 0) {
            return null;
        }

        select.firstRow();

        int tmptype = Integer.parseInt((String) select.getColumnValue("ACCOUNTS.TYPE_ACCOUNT"));
        Integer accCLIENT_ID = (Integer) select.getColumnValue("ACCOUNTS.CLIENT_ID");
        Date accCREATE_DATE = (Date) select.getColumnValue("ACCOUNTS.CREATE_DATE");
        BigDecimal accCREATE_AMOUNT = (BigDecimal) select.getColumnValue("ACCOUNTS.CREATE_AMOUNT");
        String accCURRENCY = (String) select.getColumnValue("ACCOUNTS.CURRENCY");

        if (tmptype == RUNNING) {
            tempBankAccount =
                new RunningAccount(anId, accCLIENT_ID, accCREATE_DATE, new Money(accCREATE_AMOUNT.toString()), accCURRENCY);
        }
        else if (tmptype == SETTLEMENT) {
            tempBankAccount =
                new SettlementAccount(anId, accCLIENT_ID, accCREATE_DATE, new Money(accCREATE_AMOUNT.toString()), accCURRENCY);
        }

        else if (tmptype == SPEC_TRANSIENT) {
            tempBankAccount =
                new SpecTransientAccount(anId, accCLIENT_ID, accCREATE_DATE, new Money(accCREATE_AMOUNT.toString()), accCURRENCY);
        }
        else if (tmptype == TRANSIENT) {
            tempBankAccount =
                new TransientAccount(anId, accCLIENT_ID, accCREATE_DATE, new Money(accCREATE_AMOUNT.toString()), accCURRENCY);
        }

        else {
            throw new PersistenceException("Invalid Account Type found in table");
        }
        return tempBankAccount;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Store the current BankAccount object in the database. Use the
 * Visual Age for Java 4.0 Data Access Beans. If the account already
 * exists in the database, update the account record. If the account is
 * not in the database, insert it.
 * 
 * Creation date: (31.10.2002 15:38:19)
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0EEA08007E
 */
public static synchronized void storeBankAccount(BankAccount aBankAccount) throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists(aBankAccount)) {
            modify = getBankAccountUpdate();
            modify.setParameter("ID1_BRANCH_ID", aBankAccount.getId().getId1AsString());
            modify.setParameter("ID2_ACCOUNT", aBankAccount.getId().getId2AsString());
        }
        else {
            modify = getBankAccountInsert();
        }

        // set the SQL parameters.
        modify.setParameter("BRANCH_ID", aBankAccount.getId().getId1AsString());
        modify.setParameter("ACCOUNT", aBankAccount.getId().getId2AsString());
        modify.setParameter("CLIENT_ID", aBankAccount.rtClient_id());
        modify.setParameter("CREATE_DATE", aBankAccount.rtCreate_date());
        modify.setParameter("CREATE_AMOUNT", aBankAccount.rtCreate_amount());
        modify.setParameter("CURRENCY", aBankAccount.rtCurrency());

        if (aBankAccount instanceof RunningAccount) {
            modify.setParameter("TYPE_ACCOUNT", String.valueOf(RUNNING));
        }
        else if (aBankAccount instanceof SettlementAccount) {
            modify.setParameter("TYPE_ACCOUNT", String.valueOf(SETTLEMENT));
        }
        else if (aBankAccount instanceof TransientAccount) {
            modify.setParameter("TYPE_ACCOUNT", String.valueOf(TRANSIENT));
        }
        else if (aBankAccount instanceof SpecTransientAccount) {
            modify.setParameter("TYPE_ACCOUNT", String.valueOf(SPEC_TRANSIENT));
        }
        else {
            throw new PersistenceException("Invalid Account Type. Valid types are RunningAccount, SettlementAccount, SpecTransientAccount and TransientAccount");
        }

        // execute the SQL statement.
        modify.execute();
        // refresh the current BankAccount object.
        //load();
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
}
