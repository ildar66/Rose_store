package com.overstar.ildar.ibank.model;

import com.overstar.ildar.ibank.model.exceptions.*;
/**
 * IClientReader models instances of the IClient reading device of an IBank.
 * To indicate what is happening, these instances write messages
 * on the console (OUT).
 * Creation date: (18.09.2002 16:31:02)
 * @author: Shafigullin Ildar
 */
public class IClientTransactionMgr {
    private IClient currentIClient;
    private static com.ibm.ivj.db.uibeans.Select ivjIClientSelect = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjIClientInsert = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjIClientDelete = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjIClientUpdate = null;

   /**
    * Accept a IClient inserted in the IBank,
    * or reject it by throwing an InvalidIClientException.
    * This implementation simply checks if the primary key
    * of the IClient represents a number (client_id).
    * Creation date: (18.09.2002 16:50:57)
    * @param aIClient com.overstar.ildar.ibank.model.IClient
    * @throws com.overstar.ildar.ibank.model.InvalidIClientException
    * @exception com.overstar.ildar.ibank.model.InvalidIClientException The exception 
    * description.
    * @roseuid 3E0041AC00D9
    */
   void acceptIClient(IClient aIClient) throws InvalidIClientException 
   {
    try {
        Integer.parseInt(aIClient.getClient_id().getIdAsString());
        currentIClient = aIClient;
//        System.out.println("IClientReader: Accepted  " + currentIClient + "\n");
    }
    catch (NumberFormatException ex) {
        throw new InvalidIClientException("The given IClient is not recognised.");
    }
    catch (NullPointerException ex) {
        throw new InvalidIClientException("The given IClient is not recognised.");
    }    
   }
   /**
    * Consumes current IClient.
    * NOTE: Crude implementation.
    * Creation date: (18.09.2002 16:56:34)
    * @roseuid 3E0041AC013D
    */
   void consumeCurrentIClient() 
   {
    if (currentIClient != null)
        System.out.println("IClientTransactionMgr: Consuming  " + currentIClient + "\n");
    currentIClient = null;    
   }
   /**
    * Ejects current IClient.
    * NOTE: Crude implementation.
    * Creation date: (18.09.2002 16:59:27)
    * @roseuid 3E0041AC0147
    */
   void ejectCurrentIClient() 
   {
//    if (currentIClient != null)
//        System.out.println("IClientTransactionMgr: Ejecting " + currentIClient + "\n");
    currentIClient = null;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (12.09.2002 16:32:22)
    * @return boolean
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041A10245
    */
   private static boolean exists(IClient anIClient) throws PersistenceException 
   {
    try {
        com.ibm.ivj.db.uibeans.Select select = getIClientSelect();

        select.setParameterFromString("CLIENT_ID", anIClient.getClient_id().getIdAsString());
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
 * Creation date: (12.09.2002 11:31:09)
 * @return com.overstar.ildar.ibank.model.IClient
 * @param anId com.overstar.ildar.ibank.model.IClient.IClientPK
 * @return IClient
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041A10281
 */
public static synchronized IClient findWithIClientPK(IClient.IClientPK anId) throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getIClientSelect();
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
        IClient tempIClient =
            new IClient(
                (new IClient.IClientPK(tmpIClientCLIENT_ID)),
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
    * @return IClient
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041A102E6
    */
   public static synchronized IClient findWithIClientPK(String anIdStr) throws PersistenceException 
   {
	return findWithIClientPK(new IClient.IClientPK(anIdStr));    
   }
   /**
    * Insert the method's description here.
    * Creation date: (18.09.2002 17:00:57)
    * @return com.overstar.ildar.ibank.model.IClient
    * @roseuid 3E0041AC015B
    */
   IClient getCurrentIClient() 
   {
	return currentIClient;    
   }
   /**
    * Return the IClientDelete property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041A2017F
    */
   private static com.ibm.ivj.db.uibeans.Modify getIClientDelete() 
   {
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
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041A201F7
    */
   private static com.ibm.ivj.db.uibeans.Modify getIClientInsert() 
   {
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
    * Return the IClientSelect property value.
    * @return com.ibm.ivj.db.uibeans.Select
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041A203C3
    */
   private static com.ibm.ivj.db.uibeans.Select getIClientSelect() 
   {
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
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041A3004A
    */
   private static com.ibm.ivj.db.uibeans.Modify getIClientUpdate() 
   {
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
    * Called whenever the part throws an exception.
    * @param exception java.lang.Throwable
    * @roseuid 3E0041A302FD
    */
   private static void handleException(java.lang.Throwable exception) 
   {

        /* Uncomment the following lines to print uncaught exceptions to stdout */
        // System.out.println("--------- UNCAUGHT EXCEPTION ---------");
        // exception.printStackTrace(System.out);    
   }
/**
 * Starts the application.
 * @param args an array of command-line arguments
 * @roseuid 3E0041A50129
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

    }
    catch (Throwable ex) {
        System.out.println("An exception occured while testing:\n");
        ex.printStackTrace();
    }

    System.out.println("Main() ended at: " + new java.util.Date());
}
   /**
    * Insert the method's description here.
    * Creation date: (12.09.2002 15:05:12)
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041A700C7
    */
   public static synchronized void storeIClient(IClient anIClient) throws PersistenceException 
   {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists(anIClient)) {
            modify = getIClientUpdate();
            modify.setParameterFromString("ID", anIClient.getClient_id().getIdAsString());

        }
        else { 
            //record doesn't exist.
            modify = getIClientInsert();
        }
        modify.setParameterFromString("CLIENT_ID", anIClient.getClient_id().getIdAsString());
        modify.setParameter("INN_CLN", anIClient.rtInn_cln());
        modify.setParameter("OKPO", anIClient.rtOkpo());
        modify.setParameter("NAME_CLN", anIClient.rtName_cln());
        modify.setParameter("FIO_CLN", anIClient.rtFio_cln());
        modify.setParameter("PHONE_CLN", anIClient.rtPhone_cln());
        modify.setParameter("FAX_CLN", anIClient.rtFax_cln());
        modify.setParameter("EMAIL_CLN", anIClient.rtEmail_cln());
        modify.setParameter("ADDR_CLN", anIClient.rtAddr_cln());
        modify.setParameter("NUM_DOGOV", anIClient.rtNum_dogov());
        modify.setParameter("REG_DATE", anIClient.rtReg_date());
        modify.setParameter("PERMS", anIClient.rtPerms());
        modify.setParameter("LOCK_WORD", anIClient.rtLock_word());
        modify.setParameter("ORD_CUST", anIClient.rtOrdering_customer());
        modify.setParameter("STATUS", anIClient.rtStatus());
        modify.setParameter("CLN_TYPE", anIClient.rtCln_type());
        modify.setParameter("KPP", anIClient.rtKpp());
        modify.setParameter("DOC_SIGN_NUM", anIClient.rtDoc_sign_num());
        modify.setParameter("EXT_CLIENT_ID", anIClient.rtExt_client_id());
        modify.setParameter("COUNTRY_CODE", anIClient.rtCountry_code());
        modify.setParameter("CITY", anIClient.rtCity());
        modify.setParameter("CITY_LATIN", anIClient.rtCity_latin());
        modify.setParameter("ADDRESS_LATIN", anIClient.rtAddress_latin());
        modify.setParameter("SOATO", anIClient.rtSoato());
        modify.setParameter("RESIDENT_FLAG", anIClient.rtResident_flag());
       
        modify.execute();
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }    
   }
}
