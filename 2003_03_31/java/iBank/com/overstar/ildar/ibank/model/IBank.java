package com.overstar.ildar.ibank.model;

import java.math.*;
import java.sql.*;
import java.util.Vector;
import java.util.HashMap;
import com.overstar.ildar.ibank.model.references.*;
import com.overstar.ildar.ibank.model.exceptions.*;
import com.overstar.ildar.ibank.model.documents.*;
import com.overstar.ildar.ibank.model.accounts.*;

/**
 * This class models real world iBank.
 * As controller, it interacts with the other main classes
 * in this package.
 * @see Bank
 * @see IClient
 * @see Money
 * @see // дописать после :)
 * Creation date: (18.09.2002 16:07:46)
 * @author: Shafigullin Ildar
 */
public class IBank 
{
   
   /**
    * This attribute contains the primary key of the IBank.
    * An IBank can be retrieved by searching on this value.
    */
   private IBank.IBankPK id;
   
   /**
    * This attribute contains the state of the IBank system.
    * See the two IBank state diagrams for more information.
    * We flattened the two diagrams: The 'In Use' state is not retained, 
    * instead we promote the substates of it to become states of the IBank.
    * IBankState is an innerclass, all possible values for 'state' are static fields 
    * on the IBank.
    */
   private IBank.IBankState state;
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState OUT_OF_ORDER = new IBankState ("The IBank is out of order: OUT_OF_ORDER.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState READY_TO_USE = new IBankState ("The IClient reader of the IBank is currently empty, but the IBank is ready to accept a IClient: READY_TO_USE.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState NOT_LOGGED_ON = new IBankState ("The IBank has a IClient but Person didn't authenticated yet: NOT_LOGGED_ON.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState CLIENT_INFO = new IBankState ("The IClient info associated with the inserted IClient: CLIENT_INFO.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState RECIPIENTS_LISTED = new IBankState ("The IBank lists the Recipients associated with the inserted IClient: RECIPIENTS_LISTED.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState RECIPIENTS_CHOOSEN = new IBankState ("The IBank is working with a current recipient specified: RECIPIENTS_CHOOSEN.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState BANKS_LISTED = new IBankState ("The IBank is working with a lists banks: BANKS_LISTED.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState DOCUMENTS_LISTED = new IBankState ("The IBank is working with a lists documents: DOCUMENTS_LISTED.");
   
   /**
    * This is one of the possible states of the IBank machine.
    */
   public static IBank.IBankState DOCUMENTS_CHOOSEN = new IBankState ("The IBank is working with a current document specified: DOCUMENTS_CHOOSEN.");
   private IClientTransactionMgr iClientReader;
   private Recipient currentRecipient = null;
   private Document currentDocument = null;
   
   /**
    * This allows a simple -persistenceless- implementation.
    */
   private static HashMap allIBanks = new HashMap ();
   
   public static class IBankPK extends PrimaryKey 
   {
      
      /**
       * @param anId
       * @roseuid 3E00419D000F
       */
      public IBankPK(String anId) 
      {
            super(anId);       
      }
      
      /**
       * @roseuid 3E00419D0005
       */
      public IBankPK() 
      {
            super();       
      }
   }
   
   public static class IBankState 
   {
      private String stateDescription;
      
      /**
       * @param aStateDescription
       * @roseuid 3E00419D0037
       */
      private IBankState(String aStateDescription) 
      {
            stateDescription = aStateDescription;       
      }
      
      /**
       * @return java.lang.String
       * @roseuid 3E00419D0042
       */
      public synchronized String toString() 
      {
            return stateDescription;       
      }
   }
	private com.overstar.ildar.ibank.model.documents.DocumentTransactionMgr docTransMgr;
   /**
    * This constructor will create a new instance
    * creating a primary key by itself.
    * Its associated IClientReader, ...
    * instances are also created.
    * The created IBank is in the OUT_OF_ORDER state.
    * Creation date: (18.09.2002 17:32:06)
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041980397
    */
   public IBank() throws PersistenceException 
   {
    this(new IBankPK());    
   }
   /**
    * Insert the method's description here.
    * Creation date: (18.09.2002 17:36:53)
    * @param anId com.overstar.ildar.ibank.model.IBank.IBankPK
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E00419803C9
    */
   public IBank(IBank.IBankPK anId) throws PersistenceException 
   {
      id = anId;
      state = OUT_OF_ORDER;
      iClientReader = new IClientTransactionMgr();
      docTransMgr = new DocumentTransactionMgr();
      //IBankAccount = (IBankAccount) IBankAccount.findWithBankAccountPK(new IBankAccount.BankAccountPK(anId.getIdAsString()));
      allIBanks.put(anId, this); // ATTENTION: This might silently override existing instance with given key...    
   }
   /**
    * Insert the method's description here.
    * Creation date: (24.10.2002 16:50:02)
    * @param aDocument com.overstar.ildar.ibank.model.Document
    * @throws java.lang.IllegalStateException
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E00419900D2
    */
   public void chooseDocument(Document aDocument) throws java.lang.IllegalStateException 
   {
    if (state == DOCUMENTS_LISTED) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        setCurrentDocument(aDocument);
        setState(DOCUMENTS_CHOOSEN);
    }
    else {
        throw new IllegalStateException("You cannot choose an Document when the IBank is not in the DOCUMENTS_LISTED state.");
    }    
   }
   /**
    * Insert the method's description here.
    * Creation date: (25.09.2002 15:44:14)
    * @param aRecipient com.overstar.ildar.ibank.model.Recipient
    * @throws java.lang.IllegalStateException
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E004199015E
    */
   public void chooseRecipient(Recipient aRecipient) throws java.lang.IllegalStateException 
   {
    if (state == RECIPIENTS_LISTED) {
        // NOTE: Not bullet proof: We assume the given Recipient is one of the Recipients associated with the current IClient...
        setCurrentRecipient(aRecipient);
        setState(RECIPIENTS_CHOOSEN);
    }
    else {
        throw new IllegalStateException("You cannot choose an recipient when the IBank is not in the RECIPIENTS_LISTED state.");
    }    
   }
   /**
    * Enter the PIN code for the current IClient.
    * If incorrect, an InvalidPINException is thrown.
    * NOTE: The case when there too many attempts to guess the PIN is not implemented.
    * Creation date: (20.09.2002 11:55:52)
    * @param aPINStr java.lang.String
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @throws java.lang.IllegalStateException
    * @throws com.overstar.ildar.ibank.model.InvalidPINException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @exception java.lang.IllegalStateException The exception description.
    * @exception com.overstar.ildar.ibank.model.InvalidPINException The exception 
    * description.
    * @roseuid 3E00419A005B
    */
   public void enterPIN(String aPINStr) throws PersistenceException, java.lang.IllegalStateException, InvalidPINException 
   {
	if (state == NOT_LOGGED_ON) {
		IClient curIClient = getIClientReader().getCurrentIClient();
		curIClient.validatePIN(aPINStr);	// can throw exception, state should remain NOT_LOGGED_ON
		setState(CLIENT_INFO);
		Vector allAccounts = BankAccountTransactionMgr.getBankAccountsForIClient(curIClient.getClient_id().getIdAsString());
		curIClient.setBankAccountsAll(allAccounts);
		/*
		if (assAccountsV.size() > 1) {
			setState(BANK_ACCOUNTS_LISTED);
		} else {
			if (assAccountsV.size() == 1) {
				setCurrentBankAccount((BankAccount) assAccountsV.firstElement());
				setState(BANK_ACCOUNT_CHOOSEN);
			} else {
				throw new RuntimeException("A IClient instance must have at least one associated BankAccount instance.");
			}
		}
		*/
	} else {
		throw new IllegalStateException("The IBank cannot accept PIN when it's not in the NOT_LOGGED_ON state.");
	}    
   }
   /**
    * This finder will search for the IBank with the given
    * primary key and return it. 
    * It will create a new IBank with the given primary key 
    * if it didn't found an existing IBank with that primary key. 
    * The newly created IBank is in the OUT_OF_ORDER state.
    * Creation date: (18.09.2002 17:47:41)
    * @return com.overstar.ildar.ibank.model.IBank
    * @param anId com.overstar.ildar.ibank.model.IBank.IBankPK
    * @return IBank
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E00419A0105
    */
   public static IBank findWithIBankPK(IBank.IBankPK anId) throws PersistenceException 
   {
      IBank tempIBank;
      if ((tempIBank = (IBank) allIBanks.get(anId)) == null) {
          tempIBank = new IBank(anId);
      }
      return tempIBank;    
   }
   /**
    * This finder converts String to key and uses the other one. 
    * Convenience method of {@link #findWithIBankPK()}.
    * Creation date: (18.09.2002 17:51:01)
    * @return com.overstar.ildar.ibank.model.IBank
    * @param anIdStr java.lang.String
    * @return IBank
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E00419A0169
    */
   public static IBank findWithIBankPK(String anIdStr) throws PersistenceException 
   {
	return findWithIBankPK(new IBankPK(anIdStr));    
   }
   /**
    * Insert the method's description here.
    * Creation date: (18.10.2002 15:27:54)
    * @return com.overstar.ildar.ibank.model.Document
    * @roseuid 3E00419A01A5
    */
   public Document getCurrentDocument() 
   {
	return currentDocument;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (20.09.2002 17:21:56)
    * @return com.overstar.ildar.ibank.model.IClient
    * @roseuid 3E00419A01E1
    */
   public IClient getCurrentIClient() 
   {
	return getIClientReader().getCurrentIClient();    
   }
   /**
    * Insert the method's description here.
    * Creation date: (24.09.2002 15:54:04)
    * @return com.overstar.ildar.ibank.model.Recipient
    * @roseuid 3E00419A021D
    */
   public Recipient getCurrentRecipient() 
   {
	return currentRecipient;    
   }
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 16:13:52)
 * @return com.overstar.ildar.ibank.model.documents.DocumentTransactionMgr
 */
public com.overstar.ildar.ibank.model.documents.DocumentTransactionMgr getDocTransMgr() {
	return docTransMgr;
}
   /**
    * Get the IClientReader instance for this IBank.
    * Creation date: (18.09.2002 17:57:50)
    * @return com.overstar.ildar.ibank.model.IClientReader
    * @roseuid 3E00419A029F
    */
   protected IClientTransactionMgr getIClientReader() 
   {
    return iClientReader;    
   }
   /**
    * Get the primary key of the IBank.
    * Creation date: (18.09.2002 18:01:37)
    * @return com.overstar.ildar.ibank.model.IBank.IBankPK
    * @roseuid 3E00419A02D2
    */
   public IBank.IBankPK getId() 
   {
	return id;    
   }
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 14:38:52)
 * @return java.util.Vector
 * @param anDoc_type int
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 * @exception java.lang.IllegalStateException The exception description.
 * @exception com.overstar.ildar.ibank.model.exceptions.InvalidDocumentStatusException The exception description.
 */
public Vector getListDocuments()
    throws PersistenceException, IllegalStateException, InvalidDocumentStatusException {
    DocumentTransactionMgr mgr = getDocTransMgr();
    return getListDocuments(mgr.getDoc_type(), mgr.getFromDate(), mgr.getToDate(), mgr.getStatuses(), mgr.getSortBy());
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 15:15:29)
 * @param anDoc_type
 * @param anFromdate
 * @param anToDate
 * @param anStatutes
 * @param aSortBy
 * @return java.util.Vector
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @throws java.lang.IllegalStateException
 * @throws InvalidDocumentStatusException
 * @roseuid 3E00419A030E
 */
public Vector getListDocuments(int anDoc_type, String anFromdate, String anToDate, String[] anStatutes, String aSortBy)
    throws PersistenceException, java.lang.IllegalStateException, InvalidDocumentStatusException  {
    if ((state != OUT_OF_ORDER) && (state != READY_TO_USE) && (state != NOT_LOGGED_ON)) {
        setCurrentDocument(null);
        setState(DOCUMENTS_LISTED);
    }
    if (state == DOCUMENTS_LISTED) {
   	    IClient curIClient =  getIClientReader().getCurrentIClient();
   	    Vector allDocuments = getDocTransMgr().getDocumentsForIClient(curIClient.getClient_id().getIdAsString(), anDoc_type, anFromdate, anToDate, anStatutes, aSortBy);
   	    curIClient.setDocumentsAll(allDocuments);
        return allDocuments;
    }
    else {
        throw new IllegalStateException("The IBank cannot list Documents when it's not in the DOCUMENTS_LISTED state.");
    }
}
   /**
    * Insert the method's description here.
    * Creation date: (30.09.2002 16:19:00)
    * @param aSortBy java.lang.String
    * @return java.util.Vector
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @throws java.lang.IllegalStateException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E00419B0048
    */
   public Vector getListRecipients(String aSortBy) throws PersistenceException, java.lang.IllegalStateException 
   {
    if ((state != OUT_OF_ORDER) && (state != READY_TO_USE) && (state != NOT_LOGGED_ON)) {
        setCurrentRecipient(null);
        setState(RECIPIENTS_LISTED);
    }
    if (state == RECIPIENTS_LISTED) {
	    IClient curIClient =  getIClientReader().getCurrentIClient();
	    Vector allRecipients = RecipientTransactionMgr.getRecipientsForIClient(curIClient.getClient_id().getIdAsString(), aSortBy);
	    curIClient.setRecipientsAll(allRecipients);
        return curIClient.getRecipientsAll();
    }
    else {
        throw new IllegalStateException("The IBank cannot list recipients when it's not in the RECIPIENTS_LISTED state.");
    }    
   }
   /**
    * Get the state of the IBank.
    * Creation date: (18.09.2002 18:10:41)
    * @return com.overstar.ildar.ibank.model.IBank.IBankState
    * @roseuid 3E00419B011A
    */
   public IBank.IBankState getState() 
   {
	return state;    
   }
   /**
    * Start the IBank.
    * Call this method to make a new IBank READY_TO_USE.
    * Creation date: (18.09.2002 18:15:43)
    * @throws java.lang.IllegalStateException
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E00419B020B
    */
   public void initialize() throws java.lang.IllegalStateException 
   {
    if (state == OUT_OF_ORDER) {
        resetIBank();
    }
    else {
        throw new IllegalStateException("The IBank can only be initialized when it is in the OUT_OF_ORDER state.");
    }    
   }
   /**
    * Insert the IClient in the IBank.
    * Creation date: (18.09.2002 18:21:52)
    * @param aIClient com.overstar.ildar.ibank.model.IClient
    * @throws java.lang.IllegalStateException
    * @throws com.overstar.ildar.ibank.model.InvalidIClientException
    * @exception java.lang.IllegalStateException The exception description.
    * @exception com.overstar.ildar.ibank.model.InvalidIClientException The exception 
    * description.
    * @roseuid 3E00419B0265
    */
   public void insertIClient(IClient aIClient) throws java.lang.IllegalStateException, InvalidIClientException 
   {
    if (state == READY_TO_USE) {
        getIClientReader().acceptIClient(aIClient); // can throw exception, state should remain READY_TO_USE
        setState(NOT_LOGGED_ON);
    }
    else {
        throw new IllegalStateException("The IBank cannot accept IClients when it's not in the READY_TO_USE state.");
    }    
   }
   /**
    * Interrupt the IBank.
    * Call this method to put the IBank OUT_OF_ORDER.
    * Creation date: (18.09.2002 18:24:04)
    * @roseuid 3E00419B0319
    */
   public void interrupt() 
   {
    setState(OUT_OF_ORDER); // broader then specs, no testing, example purposes only    
   }
   /**
    * Resets the session variable(s).
    * Creation date: (18.09.2002 18:26:11)
    * @roseuid 3E00419C003F
    */
   private void resetIBank() 
   {
    //setCurrentBankAccount(null);
    getIClientReader().ejectCurrentIClient();
    setState(READY_TO_USE);    
   }
   /**
    * Insert the method's description here.
    * Creation date: (18.10.2002 15:27:54)
    * @param newCurrentDocument com.overstar.ildar.ibank.model.Document
    * @roseuid 3E00419C0053
    */
   public void setCurrentDocument(Document newCurrentDocument) 
   {
	currentDocument = newCurrentDocument;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (24.09.2002 15:54:04)
    * @param newCurrentRecipient com.overstar.ildar.ibank.model.Recipient
    * @roseuid 3E00419C0090
    */
   public void setCurrentRecipient(Recipient newCurrentRecipient) 
   {
	currentRecipient = newCurrentRecipient;    
   }
   /**
    * State setter.
    * Creation date: (18.09.2002 18:10:41)
    * @param newState com.overstar.ildar.ibank.model.IBank.IBankState
    * @roseuid 3E00419C013A
    */
   private void setState(IBank.IBankState newState) 
   {
     state = newState;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (08.10.2002 15:25:17)
    * @return java.util.Vector
    * @param aSortBy java.lang.String
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @throws java.lang.IllegalStateException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E00419C0176
    */
   public void setStateListBanks() throws PersistenceException, java.lang.IllegalStateException 
   {
    if ((state != OUT_OF_ORDER) && (state != READY_TO_USE) && (state != NOT_LOGGED_ON)) {
        setState(BANKS_LISTED);
    }
    else {
        throw new IllegalStateException("The IBank cannot list BANKs when it's not in the BANKS_LISTED state.");
    }    
   }
   /**
    * Stop the IBank session.
    * A call to this method makes the IClientReader
    * eject the IClient and will make the IBank READY_TO_USE again.
    * Creation date: (18.09.2002 18:28:55)
    * @throws java.lang.IllegalStateException
    * @exception java.lang.IllegalStateException The IBank is not in the proper state
    * @roseuid 3E00419C0248
    */
   public void stop() throws java.lang.IllegalStateException 
   {
	if ((state == OUT_OF_ORDER) || (state == READY_TO_USE)) {
		throw new IllegalStateException("You cannot stop, because there's nothing to stop.");
	} else {
		resetIBank();
	}    
   }
   /**
    * Signal that the IBank has timed out.
    * NOTE: A better implementation of IBank would keep track of timeouts itself.
    * A call to this method makes the IClientreader
    * eject the IClient and will make the IBank READY_TO_USE again.
    * Creation date: (18.09.2002 18:31:54)
    * @throws java.lang.IllegalStateException
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E00419C0357
    */
   public void timeout() throws java.lang.IllegalStateException 
   {
    if (state == OUT_OF_ORDER) {
        throw new IllegalStateException("The IBank cannot time out when it's not in use...");
    }
    else {
        resetIBank();
    }    
   }
   /**
    * Specific implementation for toString().
    * @return a string representation of the receiver
    * @roseuid 3E00419C03B1
    */
   public String toString() 
   {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
		return ("\nIBank (" + getId() + ").\n" 
				+ getState() + "\nCurrent iClient="
				+ getIClientReader().getCurrentIClient() + "\n"
				);    
   }
}
