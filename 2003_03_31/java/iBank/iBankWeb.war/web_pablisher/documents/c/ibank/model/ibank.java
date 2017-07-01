//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\overstar\\ildar\\ibank\\model\\IBank.java

package com.overstar.ildar.ibank.model;

import java.math.*;
import java.sql.*;
import java.util.Vector;
import java.util.HashMap;

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
   private String fromDate;
   private String toDate;
   private String statuses[];
   private String sortBy;
   private IClientReader iClientReader;
   private Recipient currentRecipient = null;
   private Document currentDocument = null;
   
   /**
    * This allows a simple -persistenceless- implementation.
    */
   private static HashMap allIBanks = new HashMap ();
   
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
      iClientReader = new IClientReader();
      //IBankAccount = (IBankAccount) IBankAccount.findWithBankAccountPK(new IBankAccount.BankAccountPK(anId.getIdAsString()));
      allIBanks.put(anId, this); // ATTENTION: This might silently override existing instance with given key...    
   }
   
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
    * Creation date: (04.11.2002 15:24:23)
    * @param docType int
    * @param aDocumentIDstr java.lang.String
    * @throws java.lang.IllegalStateException
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E0041990045
    */
   public void chooseDocument(int docType, String aDocumentIDstr) throws java.lang.IllegalStateException, PersistenceException 
   {
    if (state == DOCUMENTS_LISTED) {
        Document userDocument = null;
        if (docType == Document.PAYMENTS) {
            userDocument = Payment.findWithPaymentPK(aDocumentIDstr);
        }
        else if (docType == Document.PAYMENT_REQUESTS) {
        }
        else if (docType == Document.ACCREDITIVS) {
        }
        else if (docType == Document.ENCASHED_CONTRACTS) {
        }
        else if (docType == Document.REFUSE_ACCEPT) {
        }
        else { 
            throw new IllegalStateException("You cannot choose an Document when documentType wrong:" + docType);
        }
        chooseDocument(userDocument);
    }
    else {
        throw new IllegalStateException("You cannot choose an Document when the IBank is not in the DOCUMENTS_LISTED state.");
    }    
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
    * Insert the method's description here.
    * Creation date: (04.11.2002 17:01:53)
    * @param anDocType int
    * @param newClient_ID java.lang.String
    * @param newDate_doc java.sql.Date
    * @param newNum_doc java.lang.String
    * @param newSigners java.lang.String
    * @param newPayment_type java.lang.String
    * @param newPayer_inn java.lang.String
    * @param newPayer_name java.lang.String
    * @param newPayer_account java.lang.String
    * @param newPayer_bank_name java.lang.String
    * @param newPayer_bank_bic java.lang.String
    * @param newPayer_bank_acc java.lang.String
    * @param newAmount Money
    * @param newRcpt_inn java.lang.String
    * @param newRcpt_name java.lang.String
    * @param newRcpt_account java.lang.String
    * @param newRcpt_bank_name java.lang.String
    * @param newRcpt_bank_bic java.lang.String
    * @param newRcpt_bank_acc java.lang.String
    * @param newType_oper java.lang.String
    * @param newQueue java.lang.String
    * @param newTerm java.util.Date
    * @param newPayment_details java.lang.String
    * @param newKpp java.lang.String
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E00419901EA
    */
   public void documentADD(int anDocType, java.sql.Date newDate_doc, String newNum_doc, String newSigners, String newPayment_type, String newPayer_inn, String newPayer_name, String newPayer_account, String newPayer_bank_name, String newPayer_bank_bic, String newPayer_bank_acc, Money newAmount, String newRcpt_inn, String newRcpt_name, String newRcpt_account, String newRcpt_bank_name, String newRcpt_bank_bic, String newRcpt_bank_acc, String newType_oper, String newQueue, java.sql.Date newTerm, String newPayment_details, String newKpp) throws PersistenceException 
   {
      if (state == DOCUMENTS_CHOOSEN) {
          // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
          Document curDocument = null;
          if (anDocType == Document.PAYMENTS)
              curDocument =
                  new Payment(
                      new Document.DocumentPK(),
                      new Integer(getCurrentIClient().getClient_id().getIdAsString()),
                      newDate_doc,
                      newNum_doc,
                      Document.NEW,
                      newSigners,
                      Document.PAYMENTS,
                      newPayment_type,
                      newPayer_inn,
                      newPayer_name,
                      newPayer_account,
                      newPayer_bank_name,
                      newPayer_bank_bic,
                      newPayer_bank_acc,
                      newAmount,
                      newRcpt_inn,
                      newRcpt_name,
                      newRcpt_account,
                      newRcpt_bank_name,
                      newRcpt_bank_bic,
                      newRcpt_bank_acc,
                      newType_oper,
                      newQueue,
                      newTerm,
                      newPayment_details,
                      newKpp,
                      true);
          else if (anDocType == Document.PAYMENT_REQUESTS) {
          }
          else if (anDocType == Document.ACCREDITIVS) {
          }
          else if (anDocType == Document.ENCASHED_CONTRACTS) {
          }
          else if (anDocType == Document.REFUSE_ACCEPT) {
          }
          else {
              throw new IllegalStateException("You cannot add Document when documentType wrong:" + anDocType);
          }
          setCurrentDocument(curDocument);
      }
      else {
          throw new IllegalStateException("You cannot add an document when the IBank is not in the DOCUMENTS_CHOOSEN state.");
      }    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (24.10.2002 18:29:55)
    * @param aDocType int
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E00419902F8
    */
   public void documentDELETE(int aDocType) throws PersistenceException 
   {
    if (state == DOCUMENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
        if (aDocType == Document.PAYMENTS) 
            Payment.deleteWithPaymentPK(getCurrentDocument().getDoc_id());
        else if(aDocType == Document.PAYMENT_REQUESTS) {} 
        else if(aDocType == Document.ACCREDITIVS) {}
        else if(aDocType == Document.ENCASHED_CONTRACTS) {}
        else if(aDocType == Document.REFUSE_ACCEPT) {}
        else {} 
        setCurrentDocument(null);
    }
    else {
        throw new IllegalStateException("You cannot delete an Document when the IBank is not in the DOCUMENTS_CHOOSEN state.");
    }    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (05.11.2002 12:34:23)
    * @param anDocType int
    * @param anDate_doc java.sql.Date
    * @param anNum_doc java.lang.String
    * @param anSigners java.lang.String
    * @param anPayment_type java.lang.String
    * @param anPayer_inn java.lang.String
    * @param anPayer_name java.lang.String
    * @param anPayer_account java.lang.String
    * @param anPayer_bank_name java.lang.String
    * @param anPayer_bank_bic java.lang.String
    * @param anPayer_bank_acc java.lang.String
    * @param anAmount com.overstar.ildar.ibank.model.Money
    * @param anRcpt_inn java.lang.String
    * @param anRcpt_name java.lang.String
    * @param anRcpt_account java.lang.String
    * @param anRcpt_bank_name java.lang.String
    * @param anRcpt_bank_bic java.lang.String
    * @param anRcpt_bank_acc java.lang.String
    * @param anType_oper java.lang.String
    * @param anQueue java.lang.String
    * @param anTerm java.sql.Date
    * @param anPayment_details java.lang.String
    * @param anKpp java.lang.String
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E0041990334
    */
   public void documentUPDATE(int anDocType, java.sql.Date anDate_doc, String anNum_doc, String anSigners, String anPayment_type, String anPayer_inn, String anPayer_name, String anPayer_account, String anPayer_bank_name, String anPayer_bank_bic, String anPayer_bank_acc, Money anAmount, String anRcpt_inn, String anRcpt_name, String anRcpt_account, String anRcpt_bank_name, String anRcpt_bank_bic, String anRcpt_bank_acc, String anType_oper, String anQueue, java.sql.Date anTerm, String anPayment_details, String anKpp) throws PersistenceException 
   {
       if (state == DOCUMENTS_CHOOSEN) {
          // NOTE: Not bullet proof: We assume the given Document is one of the Documents associated with the current IClient...
          Document curDocument = getCurrentDocument();
          if (anDocType == Document.PAYMENTS)
              curDocument =
                  new Payment(
                      curDocument.getDoc_id(),
                     new Integer(getCurrentIClient().getClient_id().getIdAsString()),
                      anDate_doc,
                      anNum_doc,
                      Document.NEW,
                      anSigners,
                      Document.PAYMENTS,
                      anPayment_type,
                      anPayer_inn,
                      anPayer_name,
                      anPayer_account,
                      anPayer_bank_name,
                      anPayer_bank_bic,
                      anPayer_bank_acc,
                      anAmount,
                      anRcpt_inn,
                      anRcpt_name,
                      anRcpt_account,
                      anRcpt_bank_name,
                      anRcpt_bank_bic,
                      anRcpt_bank_acc,
                      anType_oper,
                      anQueue,
                      anTerm,
                      anPayment_details,
                      anKpp,
                      true);
          else if (anDocType == Document.PAYMENT_REQUESTS) {
          }
          else if (anDocType == Document.ACCREDITIVS) {
          }
          else if (anDocType == Document.ENCASHED_CONTRACTS) {
          }
          else if (anDocType == Document.REFUSE_ACCEPT) {
          }
          else {
              throw new IllegalStateException("You cannot add Document when documentType wrong:" + anDocType);
          }
          setCurrentDocument(curDocument);
      }
      else {
          throw new IllegalStateException("You cannot add an document when the IBank is not in the DOCUMENTS_CHOOSEN state.");
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
		getIClientReader().getCurrentIClient().validatePIN(aPINStr);	// can throw exception, state should remain NOT_LOGGED_ON
		setState(CLIENT_INFO);// ?-после введения счетов удалить и посылать клиента на его счета !!!
		Vector assAccountsV = getIClientReader().getCurrentIClient().getBankAccounts();
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
    * Creation date: (23.10.2002 10:36:47)
    * @return java.lang.String
    * @roseuid 3E00419A026D
    */
   public String getFromDate() 
   {
	return fromDate;    
   }
   
   /**
    * Get the IClientReader instance for this IBank.
    * Creation date: (18.09.2002 17:57:50)
    * @return com.overstar.ildar.ibank.model.IClientReader
    * @roseuid 3E00419A029F
    */
   protected IClientReader getIClientReader() 
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
    * Creation date: (18.10.2002 15:15:29)
    * @param anDoc_type
    * @param anFromdate
    * @param anToDate
    * @param anStatutes
    * @param aSortBy
    * @return java.util.Vector
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @throws java.lang.IllegalStateException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @exception java.lang.IllegalStateException The exception description.
    * @roseuid 3E00419A030E
    */
   public Vector getListDocuments(int anDoc_type, String anFromdate, String anToDate, String[] anStatutes, String aSortBy) throws PersistenceException, java.lang.IllegalStateException 
   {
    if ((state != OUT_OF_ORDER) && (state != READY_TO_USE) && (state != NOT_LOGGED_ON)) {
        setCurrentDocument(null);
        setState(DOCUMENTS_LISTED);
    }
    if (state == DOCUMENTS_LISTED) {
        setFromDate(anFromdate);
        setToDate(anToDate);
        setStatuses(anStatutes);
        setSortBy(aSortBy);
        return getIClientReader().getCurrentIClient().getDocuments(anDoc_type, getFromDate(), getToDate(), getStatuses(), getSortBy());
    }
    else {
        throw new IllegalStateException("The IBank cannot list Documents when it's not in the DOCUMENTS_LISTED state.");
    }    
   }
   
   /**
    * Get the list of recipients that are associated with the current IClient.
    * Creation date: (24.09.2002 15:28:10)
    * @return java.util.Vector
    * @throws java.lang.IllegalStateException
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception java.lang.IllegalStateException The IBank is not in the proper state
    * @roseuid 3E00419A03AE
    */
   public Vector getListRecipients() throws java.lang.IllegalStateException, PersistenceException 
   {
    if ((state != OUT_OF_ORDER) && (state != READY_TO_USE) && (state != NOT_LOGGED_ON)) {
        setCurrentRecipient(null);
        setState(RECIPIENTS_LISTED);
    }
    if (state == RECIPIENTS_LISTED) {
        return getIClientReader().getCurrentIClient().getRecipients();
    }
    else {
        throw new IllegalStateException("The IBank cannot list recipients when it's not in the RECIPIENTS_LISTED state.");
    }    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (30.09.2002 16:19:00)
    * @return java.util.Vector
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
        return getIClientReader().getCurrentIClient().getRecipients(aSortBy);
    }
    else {
        throw new IllegalStateException("The IBank cannot list recipients when it's not in the RECIPIENTS_LISTED state.");
    }    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (24.10.2002 11:13:07)
    * @return java.lang.String
    * @roseuid 3E00419B00F2
    */
   public String getSortBy() 
   {
	return sortBy;    
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
    * Insert the method's description here.
    * Creation date: (23.10.2002 18:17:08)
    * @return java.lang.String[]
    * @roseuid 3E00419B0174
    */
   public String[] getStatuses() 
   {
	return statuses;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (23.10.2002 10:36:47)
    * @return java.lang.String
    * @roseuid 3E00419B01D9
    */
   public String getToDate() 
   {
	return toDate;    
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
    * Starts the application.
    * @param args an array of command-line arguments
    * @roseuid 3E00419B0323
    */
   public static void main(java.lang.String[] args) 
   {
    try {
        System.out.println("Main() started at: " + new java.util.Date());
        //testIBankRetrieval();
        testInsertIClientScenario();
        // другие тесты !

    }
    catch (Throwable ex) {
        System.out.println("An exception occured while testing:\n" + ex.toString());
        ex.printStackTrace();
    }

    System.out.println("Main() ended at: " + new java.util.Date());    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (27.09.2002 12:42:04)
    * @param innStr java.lang.String
    * @param nameStr java.lang.String
    * @param billStr java.lang.String
    * @param bicStr java.lang.String
    * @param commentStr java.lang.String
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception PersistenceException. The exception description.
    * @roseuid 3E00419B0337
    */
   public void recipientADD(String innStr, String nameStr, String billStr, String bicStr, String commentStr) throws PersistenceException 
   {
    if (state == RECIPIENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Recipient is one of the Recipients associated with the current IClient...
        setCurrentRecipient(
            new Recipient(
                new Recipient.RecipientPK(),
                new Integer(getCurrentIClient().getClient_id().getIdAsString()),
                innStr,
                nameStr,
                bicStr,
                billStr,
                commentStr, true));
    }
    else {
        throw new IllegalStateException("You cannot add an recipient when the IBank is not in the RECIPIENTS_CHOOSEN state.");
    }    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (27.09.2002 12:48:15)
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception PersistenceException. The exception description.
    * @roseuid 3E00419B0391
    */
   public void recipientDELETE() throws PersistenceException 
   {
    if (state == RECIPIENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Recipient is one of the Recipients associated with the current IClient...
        Recipient.deleteWithRecipientPK(getCurrentRecipient().getId());
        setCurrentRecipient(null);
    }
    else {
        throw new IllegalStateException("You cannot delete an recipient when the IBank is not in the RECIPIENTS_CHOOSEN state.");
    }    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (27.09.2002 12:21:05)
    * @param innStr java.lang.String
    * @param nameStr java.lang.String
    * @param billStr java.lang.String
    * @param bicStr java.lang.String
    * @param commentStr java.lang.String
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception PersistenceException. The exception description.
    * @roseuid 3E00419B03CD
    */
   public void recipientUPDATE(String innStr, String nameStr, String billStr, String bicStr, String commentStr) throws PersistenceException 
   {

    if (state == RECIPIENTS_CHOOSEN) {
        // NOTE: Not bullet proof: We assume the given Recipient is one of the Recipients associated with the current IClient...
        Recipient tmpRecipient = getCurrentRecipient();
        if (tmpRecipient != null)
            setCurrentRecipient(
                new Recipient(tmpRecipient.getId(), tmpRecipient.rtClient_id(), innStr, nameStr, bicStr, billStr, commentStr, true));
    }
    else {
        throw new IllegalStateException("You cannot update an recipient when the IBank is not in the RECIPIENTS_CHOOSEN state.");
    }    
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
   private void setCurrentDocument(Document newCurrentDocument) 
   {
	currentDocument = newCurrentDocument;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (24.09.2002 15:54:04)
    * @param newCurrentRecipient com.overstar.ildar.ibank.model.Recipient
    * @roseuid 3E00419C0090
    */
   private void setCurrentRecipient(Recipient newCurrentRecipient) 
   {
	currentRecipient = newCurrentRecipient;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (23.10.2002 10:36:47)
    * @param newFromDate java.lang.String
    * @roseuid 3E00419C00CC
    */
   void setFromDate(java.lang.String newFromDate) 
   {
	fromDate = newFromDate;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (24.10.2002 11:13:07)
    * @param newSortBy java.lang.String
    * @roseuid 3E00419C00FE
    */
   void setSortBy(java.lang.String newSortBy) 
   {
	sortBy = newSortBy;    
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
    * Insert the method's description here.
    * Creation date: (23.10.2002 18:17:08)
    * @param newStatuses java.lang.String[]
    * @roseuid 3E00419C0202
    */
   void setStatuses(java.lang.String[] newStatuses) 
   {
	statuses = newStatuses;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (23.10.2002 10:36:47)
    * @param newToDate java.lang.String
    * @roseuid 3E00419C0216
    */
   void setToDate(java.lang.String newToDate) 
   {
	toDate = newToDate;    
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
    * Insert the method's description here.
    * Creation date: (19.09.2002 10:15:47)
    * @throws java.lang.Throwable
    * @exception java.lang.Throwable The exception description.
    * @roseuid 3E00419C02A2
    */
   private static void testIBankRetrieval() throws java.lang.Throwable 
   {
    IBank tempIBank;

    System.out.println("Test retrieval of an IBank.\n");

    System.out.println("Make new IBank with key 123.\n");
    tempIBank = new IBank(new IBankPK("123"));
    System.out.println(tempIBank);
    System.out.println("______________________________________");
    System.out.println();

    System.out.println("Find the IBank with key 123.\n");
    tempIBank = IBank.findWithIBankPK("123");
    System.out.println(tempIBank);
    System.out.println("______________________________________");
    System.out.println();    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (19.09.2002 10:42:27)
    * @throws java.lang.Throwable
    * @exception java.lang.Throwable The exception description.
    * @roseuid 3E00419C02FC
    */
   private static void testInsertIClientScenario() throws java.lang.Throwable 
   {
	IBank tempIBank;
	IClient tempIClient;

	System.out.println("InsertIClientScenario.\n");

	System.out.println("Get the IBank with key 123.\n");
	tempIBank = IBank.findWithIBankPK("123");
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
    String iClientStr = "1"; //заполните !
	System.out.println("Find a IClient with key" + iClientStr +".\n");
	tempIClient = IClient.findWithIClientPK(iClientStr);
	System.out.println(tempIClient.toStringFull());
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Start the IBank.\n");
	tempIBank.initialize();
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Insert the IClient.\n");
	tempIBank.insertIClient(tempIClient);
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Enter PIN = 1.\n");
	tempIBank.enterPIN("1");
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Stop this session.\n");
	tempIBank.stop();
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();    
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
}
