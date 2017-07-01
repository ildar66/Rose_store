package com.overstar.ildar.ibank.model.references;

import java.util.Vector;
import com.overstar.ildar.ibank.model.exceptions.*;
/**
 * Insert the type's description here.
 * Creation date: (20.01.2003 11:47:41)
 * @author: Shafigullin Ildar
 */
public class RecipientTransactionMgr {
    private static com.ibm.ivj.db.uibeans.Select ivjRecipientSelect = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjRecipientInsert = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjRecipientDelete = null;
    private static com.ibm.ivj.db.uibeans.Modify ivjRecipientUpdate = null;
    private static com.ibm.ivj.db.uibeans.Select ivjRecipientsSelectIClient = null;
    private static com.ibm.ivj.db.uibeans.Select ivjIClientRecipientsSelect = null;
/**
 * RecipientTransactionMgr constructor comment.
 */
public RecipientTransactionMgr() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2002 12:56:39)
 * @return com.overstar.ildar.ibank.model.Recipient
 * @param anId com.overstar.ildar.ibank.model.Recipient.RecipientPK
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041B90041
 */
public static synchronized void deleteWithRecipientPK(Recipient.RecipientPK anId) throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        modify = getRecipientDelete(); 
        modify.setParameter("ID", anId.getIdAsString());
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 18:22:16)
    * @return boolean
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041B900A5
    */
   private static synchronized boolean exists(Recipient aRecipient) throws PersistenceException 
   {
		try{	
		com.ibm.ivj.db.uibeans.Select select = getRecipientSelect();
		
		select.setParameter("ID", aRecipient.getId().getIdAsString());
		select.execute();
		if (select.getNumRows() > 0) {
			return true;
		}
		else{
			return false;
		}
	}
	catch(Exception exp){
		throw new PersistenceException(exp.toString());
	}    
   }
/**
 * This finder will search for the Recipient with the given
 * primary key and return it.
 * Creation date: (23.09.2002 17:05:59)
 * @return com.overstar.ildar.ibank.model.Recipient
 * @param anId com.overstar.ildar.ibank.model.Recipient.RecipientPK
 * @return Recipient
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041B900E1
 */
public static synchronized Recipient findWithRecipientPK(Recipient.RecipientPK anId) throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getRecipientSelect();

        select.setParameter("ID", anId.getIdAsString());

        select.execute();

        if (select.getRowCount() <= 0) {
            throw new RecipientNotFoundException("The Recipient with primary key " + anId.getIdAsString() + " was not found.");
        }

        select.firstRow();
        String tmpRecipientID = (String) select.getColumnValue("RECIPIENTS.ID");
        Integer tmpRecipientCLIENT_ID = (Integer) select.getColumnValue("RECIPIENTS.CLIENT_ID");
        String tmpRecipientINN = (String) select.getColumnValue("RECIPIENTS.INN");
        String tmpRecipientNAME = (String) select.getColumnValue("RECIPIENTS.NAME");
        String tmpRecipientBIC = (String) select.getColumnValue("RECIPIENTS.BIC");
        String tmpRecipientBILL = (String) select.getColumnValue("RECIPIENTS.BILL");
        String tmpRecipientCOMMENTS = (String) select.getColumnValue("RECIPIENTS.COMMENTS");

        Recipient tempRecipient =
            new Recipient(
                (new Recipient.RecipientPK(tmpRecipientID)),
                tmpRecipientCLIENT_ID,
                tmpRecipientINN,
                tmpRecipientNAME,
                tmpRecipientBIC,
                tmpRecipientBILL,
                tmpRecipientCOMMENTS
                );

        return tempRecipient;
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:31:06)
    * @return com.overstar.ildar.ibank.model.Recipient
    * @param anId java.lang.String
    * @param anIdStr
    * @return Recipient
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041B90146
    */
   public static synchronized Recipient findWithRecipientPK(String anIdStr) throws PersistenceException 
   {
	return findWithRecipientPK(new Recipient.RecipientPK(anIdStr));    
   }
   /**
    * Return the IClientRecipientsSelect property value.
    * @return com.ibm.ivj.db.uibeans.Select
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041A2034B
    */
   private static com.ibm.ivj.db.uibeans.Select getIClientRecipientsSelect() 
   {
	if (ivjIClientRecipientsSelect == null) {
		try {
			ivjIClientRecipientsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjIClientRecipientsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(RecipientDAB.connToIBank(), RecipientDAB.IClientRecipientsSelectSQL()));
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
 * Return the RecipientDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 * WARNING: THIS METHOD WILL BE REGENERATED.
 * @roseuid 3E0041B901DC
 */
private static com.ibm.ivj.db.uibeans.Modify getRecipientDelete() {
    if (ivjRecipientDelete == null) {
        try {
            ivjRecipientDelete = new com.ibm.ivj.db.uibeans.Modify();
            ivjRecipientDelete.setAction(
                new com.ibm.ivj.db.uibeans.Query(RecipientDAB.connToIBank(), RecipientDAB.RecipientDeleteSQL()));
            // user code begin {1}
            // user code end
        }
        catch (java.lang.Throwable ivjExc) {
            // user code begin {2}
            // user code end
            handleException(ivjExc);
        }
    }
    return ivjRecipientDelete;
}
   /**
    * Return the RecipientInsert property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041B9024A
    */
   private static com.ibm.ivj.db.uibeans.Modify getRecipientInsert() 
   {
	if (ivjRecipientInsert == null) {
		try {
			ivjRecipientInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjRecipientInsert.setAction(new com.ibm.ivj.db.uibeans.Query(RecipientDAB.connToIBank(), RecipientDAB.RecipientInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRecipientInsert;    
   }
   /**
    * Return the RecipientSelect property value.
    * @return com.ibm.ivj.db.uibeans.Select
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041B9033A
    */
   private static com.ibm.ivj.db.uibeans.Select getRecipientSelect() 
   {
	if (ivjRecipientSelect == null) {
		try {
			ivjRecipientSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjRecipientSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(RecipientDAB.connToIBank(), RecipientDAB.RecipientSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRecipientSelect;    
   }
/**
 * Insert the method's description here.
 * Creation date: (24.09.2002 16:09:21)
 * @return java.util.Vector
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041A301BC
 */
public static synchronized Vector  getRecipientsForIClient(String iClient) throws PersistenceException {
    try {
        Vector tmpRecipientsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = getIClientRecipientsSelect();

        select.setParameterFromString("CLIENT_ID", iClient);
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
                        tmpRecipientCOMMENTS);

                tmpRecipientsAll.addElement(tmpRecipient);
                select.nextRow();
            }
        }

        //return new Vector(tmpRecipientsAll);
        return tmpRecipientsAll;
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
 * @return java.util.Vector
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041A301EE
 */
public static synchronized Vector getRecipientsForIClient(String iClient, String aSortBy) throws PersistenceException {
    try {
        Vector tmpRecipientsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = getIClientRecipientsSelect();
        String statement =
            "SELECT ILDAR.RECIPIENTS.ID, ILDAR.RECIPIENTS.CLIENT_ID, ILDAR.RECIPIENTS.INN, ILDAR.RECIPIENTS.NAME, ILDAR.RECIPIENTS.BIC, ILDAR.RECIPIENTS.BILL, ILDAR.RECIPIENTS.COMMENTS FROM ILDAR.RECIPIENTS WHERE ( ( ILDAR.RECIPIENTS.CLIENT_ID = :CLIENT_ID ) )";

        select.getStatementMetaData().setSQL(statement + " order by " + aSortBy);

        select.setParameterFromString("CLIENT_ID", iClient);
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
                        tmpRecipientCOMMENTS);

                tmpRecipientsAll.addElement(tmpRecipient);
                select.nextRow();
            }
        }

        //return new Vector(tmpRecipientsAll);
        return tmpRecipientsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 11:36:26)
 * @return java.util.Vector
 * @param iClient java.lang.String
 * @param anName java.lang.String
 * @param anInn java.lang.String
 * @param anBill java.lang.String
 * @param anBic java.lang.String
 * @param aOperation java.lang.String
 * @param aSortBy java.lang.String
 * @return java.util.Vector
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
 * description.
 * @roseuid 3E0041B902A4
 */
public static synchronized Vector getRecipientsForIClient(
    String iClient,
    String anName,
    String anInn,
    String anBill,
    String anBic,
    String aOperation,
    String aSortBy)
    throws PersistenceException {
    try {
        Vector tmpRecipientsAll = new Vector(0); // lazy init.
        com.ibm.ivj.db.uibeans.Select select = getRecipientsSelectIClient();
        String statement =
            "SELECT ILDAR.RECIPIENTS.ID, ILDAR.RECIPIENTS.CLIENT_ID, ILDAR.RECIPIENTS.INN, ILDAR.RECIPIENTS.NAME, ILDAR.RECIPIENTS.BIC, ILDAR.RECIPIENTS.BILL, ILDAR.RECIPIENTS.COMMENTS FROM ILDAR.RECIPIENTS WHERE( (ILDAR.RECIPIENTS.CLIENT_ID = :CLIENT_ID) AND ((ILDAR.RECIPIENTS.NAME like '%'||:NAME||'%') "
                + aOperation
                + " (ILDAR.RECIPIENTS.INN like '%'||:INN||'%') "
                + aOperation
                + " (ILDAR.RECIPIENTS.BILL like '%'||:BILL||'%') "
                + aOperation
                + " (ILDAR.RECIPIENTS.BIC like '%'||:BIC||'%')) ) order by "
                + aSortBy;
        select.getStatementMetaData().setSQL(statement);

        select.setParameterFromString("CLIENT_ID", iClient);
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
                        tmpRecipientCOMMENTS);

                tmpRecipientsAll.addElement(tmpRecipient);
                select.nextRow();
            }
        }

        //return new Vector(recipientsAll);
        return tmpRecipientsAll;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Return the RecipientsSelectIClient property value.
 * @return com.ibm.ivj.db.uibeans.Select
 * @roseuid 3E0041B903A8
 */
private static com.ibm.ivj.db.uibeans.Select getRecipientsSelectIClient() {
    if (ivjRecipientsSelectIClient == null) {
        try {
            ivjRecipientsSelectIClient = new com.ibm.ivj.db.uibeans.Select();
            ivjRecipientsSelectIClient.setQuery(
                new com.ibm.ivj.db.uibeans.Query(RecipientDAB.connToIBank(), RecipientDAB.RecipientSelectIClientSQL()));
            // user code begin {1}
            // user code end
        }
        catch (java.lang.Throwable ivjExc) {
            // user code begin {2}
            // user code end
            handleException(ivjExc);
        }
    }
    return ivjRecipientsSelectIClient;
}
   /**
    * Return the RecipientUpdate property value.
    * @return com.ibm.ivj.db.uibeans.Modify
    * WARNING: THIS METHOD WILL BE REGENERATED.
    * @roseuid 3E0041BA007F
    */
   private static com.ibm.ivj.db.uibeans.Modify getRecipientUpdate() 
   {
	if (ivjRecipientUpdate == null) {
		try {
			ivjRecipientUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjRecipientUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(RecipientDAB.connToIBank(), RecipientDAB.RecipientUpdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjRecipientUpdate;    
   }
   /**
    * Called whenever the part throws an exception.
    * @param exception java.lang.Throwable
    * @roseuid 3E0041BA00CF
    */
   private static void handleException(java.lang.Throwable exception) 
   {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	 exception.printStackTrace(System.out);    
   }
/**
 * Starts the application.
 * @param args an array of command-line arguments
 * @roseuid 3E0041BA02C4
 */
public static void main(java.lang.String[] args) {
    Recipient tempRecipient;

    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        String newRecipientIDstr = "7"; // определите newRecipientIDstr !!!
        String newClientIDstr = "4"; // определите newClientIDstr !!!
        Integer newClient_ID = new Integer(newClientIDstr);
        System.out.println("Make new Recipient with key " + newRecipientIDstr + "\n");
        tempRecipient =
            new Recipient(
                new Recipient.RecipientPK(newRecipientIDstr),
                newClient_ID,
                "INN" + newRecipientIDstr,
                "NAME" + newRecipientIDstr,
                "BIC" + newRecipientIDstr,
                "BILL" + newRecipientIDstr,
                "COMMENTS" + newRecipientIDstr);
        storeRecipient(tempRecipient); //ћожет убить существующую запись в базе!!!
        System.out.println(tempRecipient);
        System.out.println("______________________________________");
        System.out.println();
        ////////////////////////////////////////////////////////////////
        String getRecipientIDstr = "7";
        System.out.println("Find Recipient with key " + getRecipientIDstr + ".\n");
        tempRecipient = findWithRecipientPK(getRecipientIDstr);
        System.out.println(tempRecipient);
        System.out.println("______________________________________");
        System.out.println();
        ///////////////////////////////////////////////////////////////
        System.out.println("Make new Recipient with unique key  \n");
        tempRecipient =
            new Recipient(new Recipient.RecipientPK(), newClient_ID, "INN", "NAME", "BIC", "BILL", "COMMENTS");
        //заранее уникальный :)
        storeRecipient(tempRecipient);
        System.out.println(tempRecipient);
        System.out.println("______________________________________");
        System.out.println();
        ////////////////////////////////////////////////////////////////
        System.out.println("Find Recipient with unique key " + tempRecipient.getId() + ".\n");
        tempRecipient = findWithRecipientPK(tempRecipient.getId().getIdAsString());
        System.out.println(tempRecipient);
        System.out.println("______________________________________");
        System.out.println();
        ////////////////////////////////////////////////////////////////
        String iClient = "4";
        System.out.println("Find Recipients for iClient(like)=" + iClient + ":\n");
        Vector recipients = getRecipientsForIClient(iClient, "%", "%", "%", "%", "and", "name desc");
        System.out.println("recipients: " + recipients.size() + ":\n" + recipients);
        System.out.println("______________________________________");
        System.out.println("Find Recipients for iClient=" + iClient + ":\n");
        recipients = getRecipientsForIClient(iClient,"name");
        System.out.println("recipients: " + recipients.size() + ":\n" + recipients);
        System.out.println("______________________________________");
        System.out.println();
    }
    catch (Throwable ex) {
        System.out.println("An exception occured while testing:\n");
        ex.printStackTrace();
    }

    System.out.println("Main() ended at: " + new java.util.Date());
}
public static synchronized void storeRecipient(Recipient aRecipient) throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists(aRecipient)) {
            modify = getRecipientUpdate();
            modify.setParameter("RECIPIENTS_ID", aRecipient.getId().getIdAsString());

        }
        else {
            //record doesn't exist.
            modify = getRecipientInsert();
        }

        modify.setParameterFromString("ID", aRecipient.getId().getIdAsString());
        modify.setParameter("CLIENT_ID", aRecipient.rtClient_id());
        modify.setParameter("INN", aRecipient.rtInn());
        modify.setParameter("NAME", aRecipient.rtName());
        modify.setParameter("BIC", aRecipient.rtBank_Bic());
        modify.setParameter("BILL", aRecipient.rtBill());
        modify.setParameter("COMMENTS", aRecipient.rtComments());

        modify.execute();
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
}
