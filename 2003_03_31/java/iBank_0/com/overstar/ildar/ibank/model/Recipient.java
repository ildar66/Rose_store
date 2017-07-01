package com.overstar.ildar.ibank.model;

import java.util.Vector;
/**
 * Класс "Контрагентов".
 *
 * Creation date: (23.09.2002 15:30:56)
 * @author: Shafigullin Ildar
 */
public class Recipient {

    /**
     * PrimaryKey class to be used for instances of type Recipient.
     */
    public static class RecipientPK extends PrimaryKey {
        public RecipientPK(String anId) {
            super(anId);
        }
        public RecipientPK() {
            super();
        }    }
    private RecipientPK id; //'Уникальный идентификатор получателя';
    private Integer client_id; //'Идентификатор клиента';
    private String inn; //'ИНН получателя';
    private String name; //'Наименование получателя';
    private String bic; //'БИК банка получателя';
    private String bill; //'Счет получателя';
    private String comments; //'Текст назначения платежа';
	private com.ibm.ivj.db.uibeans.Select ivjRecipientSelect = null;
	private com.ibm.ivj.db.uibeans.Modify ivjRecipientInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjRecipientDelete = null;
	private com.ibm.ivj.db.uibeans.Modify ivjRecipientUpdate = null;
	private static com.ibm.ivj.db.uibeans.Select ivjRecipientsSelectIClient = null;
/**
 * Constructor.
 *
 * Creation date: (23.09.2002 18:29:52)
 */
public Recipient() {
    super();
    initialize();
}
/**
 * Recipient constructor comment.
 */
public Recipient(RecipientPK anId, Integer anCLIENT_ID, String anINN, String anNAME, String anBIC, String anBILL, String anCOMMENTS, boolean isStore) throws PersistenceException {
    id = anId;
    initClient_id(anCLIENT_ID);
    initInn(anINN);
    initName(anNAME);
    initBic(anBIC);
    initBill(anBILL);
    initComments(anCOMMENTS);
    if(isStore)
      store();
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2002 12:56:39)
 * @return com.overstar.ildar.ibank.model.Recipient
 * @param anId com.overstar.ildar.ibank.model.Recipient.RecipientPK
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static void deleteWithRecipientPK(Recipient.RecipientPK anId) throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        Recipient tempRecipient = new Recipient();
        modify = tempRecipient.getRecipientDelete();
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
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected boolean exists() throws PersistenceException {
		try{	
		com.ibm.ivj.db.uibeans.Select select = getRecipientSelect();
		
		select.setParameter("ID", getId().getIdAsString());
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
 *
 * Creation date: (23.09.2002 17:05:59)
 * @return com.overstar.ildar.ibank.model.Recipient
 * @param anId com.overstar.ildar.ibank.model.Recipient.RecipientPK
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static Recipient findWithRecipientPK(Recipient.RecipientPK anId) throws PersistenceException {
    try {
        Recipient tempRecipient = new Recipient();
        com.ibm.ivj.db.uibeans.Select select = tempRecipient.getRecipientSelect();

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

        tempRecipient =
            new Recipient(
                (new Recipient.RecipientPK(tmpRecipientID)),
                tmpRecipientCLIENT_ID,
                tmpRecipientINN,
                tmpRecipientNAME,
                tmpRecipientBIC,
                tmpRecipientBILL,
                tmpRecipientCOMMENTS, false);

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
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static Recipient findWithRecipientPK(String anIdStr) throws PersistenceException {
	return findWithRecipientPK(new Recipient.RecipientPK(anIdStr));
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @return com.overstar.ildar.ibank.model.Recipient.RecipientPK
 */
public Recipient.RecipientPK getId() {
    return id;
}
/**
 * Return the RecipientDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getRecipientDelete() {
	if (ivjRecipientDelete == null) {
		try {
			ivjRecipientDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjRecipientDelete.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.RecipientDAB.connToIBank(), com.overstar.ildar.ibank.model.RecipientDAB.RecipientDeleteSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
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
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getRecipientInsert() {
	if (ivjRecipientInsert == null) {
		try {
			ivjRecipientInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjRecipientInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.RecipientDAB.connToIBank(), com.overstar.ildar.ibank.model.RecipientDAB.RecipientInsertSQL()));
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
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
public static Vector getRecipients(
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
                + " (ILDAR.RECIPIENTS.BIC like '%'||:BIC||'%')) )";
        select.getStatementMetaData().setSQL(statement + " order by " + aSortBy);

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
                        tmpRecipientCOMMENTS,
                        false);

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
    catch (java.lang.Throwable exception) {
        /* Uncomment the following lines to print uncaught exceptions to stdout */
        // System.out.println("--------- UNCAUGHT EXCEPTION ---------");
        exception.printStackTrace(System.out);
        throw new PersistenceException("java.lang.Throwable: " + exception.toString());
    }
}
/**
 * Return the RecipientSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getRecipientSelect() {
	if (ivjRecipientSelect == null) {
		try {
			ivjRecipientSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjRecipientSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.RecipientDAB.connToIBank(), com.overstar.ildar.ibank.model.RecipientDAB.RecipientSelectSQL()));
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
 * Return the RecipientsSelectIClient property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private static com.ibm.ivj.db.uibeans.Select getRecipientsSelectIClient() throws java.lang.Throwable {
	if (ivjRecipientsSelectIClient == null) {
		try {
			ivjRecipientsSelectIClient = new com.ibm.ivj.db.uibeans.Select();
			ivjRecipientsSelectIClient.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.RecipientDAB.connToIBank(), com.overstar.ildar.ibank.model.RecipientDAB.RecipientSelectIClientSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			throw ivjExc;
			// user code end
			//handleException(ivjExc); 
		}
	}
	return ivjRecipientsSelectIClient;
}
/**
 * Return the RecipientUpdate property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getRecipientUpdate() {
	if (ivjRecipientUpdate == null) {
		try {
			ivjRecipientUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjRecipientUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.ildar.ibank.model.RecipientDAB.connToIBank(), com.overstar.ildar.ibank.model.RecipientDAB.RecipientUpdateSQL()));
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
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @param newBic java.lang.String
 */
void initBic(java.lang.String newBic) {
	bic = newBic;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @param newBill java.lang.String
 */
void initBill(java.lang.String newBill) {
	bill = newBill;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @param newClient_id java.lang.Integer
 */
void initClient_id(java.lang.Integer newClient_id) {
	client_id = newClient_id;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @param newComments java.lang.String
 */
void initComments(java.lang.String newComments) {
	comments = newComments;
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
 * Creation date: (23.09.2002 17:48:23)
 * @param newInn java.lang.String
 */
void initInn(java.lang.String newInn) {
	inn = newInn;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @param newName java.lang.String
 */
void initName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 18:08:18)
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
protected void load() throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getRecipientSelect();
        select.setParameter("ID", getId().getIdAsString());

        select.execute();
        select.firstRow();
        String tmpRecipientID = (String) select.getColumnValue("RECIPIENTS.ID");
        Integer tmpRecipientCLIENT_ID = (Integer) select.getColumnValue("RECIPIENTS.CLIENT_ID");
        String tmpRecipientINN = (String) select.getColumnValue("RECIPIENTS.INN");
        String tmpRecipientNAME = (String) select.getColumnValue("RECIPIENTS.NAME");
        String tmpRecipientBIC = (String) select.getColumnValue("RECIPIENTS.BIC");
        String tmpRecipientBILL = (String) select.getColumnValue("RECIPIENTS.BILL");
        String tmpRecipientCOMMENTS = (String) select.getColumnValue("RECIPIENTS.COMMENTS");

        initClient_id(tmpRecipientCLIENT_ID);
        initInn(tmpRecipientINN);
        initName(tmpRecipientNAME);
        initBic(tmpRecipientBIC);
        initBill(tmpRecipientBILL);
        initComments(tmpRecipientCOMMENTS);
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
    Recipient tempRecipient;

    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        String newRecipientIDstr = "7"; // определите newRecipientIDstr !!!
        String newClientIDstr = "3"; // определите newClientIDstr !!!
        Integer newClient_ID = new Integer(newClientIDstr);
        System.out.println("Make new Recipient with key " + newRecipientIDstr + "\n");
        tempRecipient =
            new Recipient(
                new Recipient.RecipientPK(newRecipientIDstr),//Может убить существующую запись в базе!!!
                newClient_ID,
                "INN" + newRecipientIDstr,
                "NAME" + newRecipientIDstr,
                "BIC" + newRecipientIDstr,
                "BILL" + newRecipientIDstr,
                "COMMENTS" + newRecipientIDstr, true);
        System.out.println(tempRecipient.toStringFull());
        System.out.println("______________________________________");
        System.out.println();
////////////////////////////////////////////////////////////////
        String getRecipientIDstr = "7";
        System.out.println("Find Recipient with key " + getRecipientIDstr + ".\n");
        tempRecipient = findWithRecipientPK(getRecipientIDstr);
        System.out.println(tempRecipient.toStringFull());
        System.out.println("______________________________________");
        System.out.println();
///////////////////////////////////////////////////////////////
        System.out.println("Make new Recipient with unique key  \n");
        tempRecipient =
            new Recipient(
                new Recipient.RecipientPK(),  //заранее уникальный :)
                newClient_ID,
                "INN" ,
                "NAME" ,
                "BIC" , 
                "BILL" ,
                "COMMENTS", true );
        System.out.println(tempRecipient.toStringFull());
        System.out.println("______________________________________");
        System.out.println();
////////////////////////////////////////////////////////////////
        System.out.println("Find Recipient with unique key " + tempRecipient.getId() + ".\n");
        tempRecipient = findWithRecipientPK(tempRecipient.getId().getIdAsString());
        System.out.println(tempRecipient.toStringFull());
        System.out.println("______________________________________");
        System.out.println();
////////////////////////////////////////////////////////////////
        String iClient = "1";
        System.out.println("Find Recipients for iClient="+iClient+":\n");
        Vector recipients = getRecipients(iClient, "%", "%", "%", "%", "and", "name");
        System.out.println("recipients: "+recipients.size()+ ":" + recipients);
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
 * Creation date: (23.09.2002 17:48:23)
 * @return java.lang.String
 */
public java.lang.String rtBic() {
	return bic;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @return java.lang.String
 */
public java.lang.String rtBill() {
	return bill;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @return java.lang.Integer
 */
public java.lang.Integer rtClient_id() {
	return client_id;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @return java.lang.String
 */
public java.lang.String rtComments() {
	return comments;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @return java.lang.String
 */
public java.lang.String rtInn() {
	return inn;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:48:23)
 * @return java.lang.String
 */
public java.lang.String rtName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (23.09.2002 17:39:14)
 * @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
 */
private void store() throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;

    try {
        if (exists()) {
            modify = getRecipientUpdate();
            modify.setParameter("RECIPIENTS_ID", this.getId().getIdAsString());

        }
        else {
            //record doesn't exist.
            modify = getRecipientInsert();
        }

        modify.setParameterFromString("ID", this.getId().getIdAsString());
        modify.setParameter("CLIENT_ID", rtClient_id());
        modify.setParameter("INN", rtInn());
        modify.setParameter("NAME", rtName());
        modify.setParameter("BIC", rtBic());
        modify.setParameter("BILL", rtBill());
        modify.setParameter("COMMENTS", rtComments());
       
        modify.execute();
        load();

    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Specific implementation for toString().
 * 
 * Creation date: (23.09.2002 19:11:03)
 * @return java.lang.String
 */
public String toString() {
    return "Recipient ("
        + id
        + ")"
        + ".\n "
        + " client_id ("
        + client_id
        + ")"
        + ".\n "
        + " inn  ("
        + inn
        + ")"
        + ".\n "
        + " name ("
        + name
        + ")"
        + ".\n "
        + " bic ("
        + bic
        + ")"
        + ".\n "
        + " bill ("
        + bill
        + ")"
        + ".\n "
        + " comments ("
        + comments
        + ")"
        + ".\n ";
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */

    public String toStringFull() {
        // Insert code to print the receiver here.
        // This implementation forwards the message to super. You may replace or supplement this.
        return "Recipient (" + id + ")" + ".\n " + 
               " client_id (" + client_id + ")" + ".\n " + 
               " inn  (" + inn + ")" + ".\n " + 
               " name (" + name + ")" + ".\n " +
               " bic (" + bic + ")" + ".\n " +
               " bill (" + bill + ")" + ".\n " +
               " comments (" + comments + ")" + ".\n "   ;
    }
}
