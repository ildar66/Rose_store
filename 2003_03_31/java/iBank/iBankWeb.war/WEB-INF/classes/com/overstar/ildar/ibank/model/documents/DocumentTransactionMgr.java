package com.overstar.ildar.ibank.model.documents;

import com.overstar.ildar.ibank.model.exceptions.*;
import java.util.Vector;
import java.sql.Date;
/**
 * Insert the type's description here.
 * Creation date: (24.01.2003 14:55:20)
 * @author: Shafigullin Ildar
 */
public class DocumentTransactionMgr {
    /**
     * Платежное поручение.
     */
    public static final int PAYMENTS = 1;

    /**
     * Инкассовое поручение.
     */
    public static final int ENCASHED_CONTRACTS = 9;

    /**
     * Платежное требование.
     */
    public static final int PAYMENT_REQUESTS = 7;

    /**
     * Аккредитив.
     */
    public static final int ACCREDITIVS = 8;

    /**
     * Заявление об отказе от акцепта.
     */
    public static final int REFUSE_ACCEPT = 10;
    
    private String fromDate;
    private String toDate;
    private String statuses[];
    private String sortBy;
	private int doc_type;
/**
 * DocumentTransactionMgr constructor comment.
 */
public DocumentTransactionMgr() {
	super();
	setDoc_type(PAYMENTS);
	setSortBy(" date_doc");
	setStatuses(new String[]{"0","1","2","3","4","5","6","7"});
	setFromDate(new Date(System.currentTimeMillis()).toString());
	setToDate(getFromDate());
}
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 15:13:22)
 * @param anId com.overstar.ildar.ibank.model.documents.Document.DocumentPK
 * @exception com.overstar.ildar.ibank.model.exceptions.PersistenceException The exception description.
 */
public static synchronized void deleteWithDocumentPK(int anDoc_type, Document.DocumentPK anId)
    throws com.overstar.ildar.ibank.model.exceptions.PersistenceException {
    if (anDoc_type == PAYMENTS) {
        PaymentTransactionMgr.deleteWithPaymentPK(anId);
    }
    else if (anDoc_type == ACCREDITIVS) {
	    AccreditiveTransactionMgr.deleteWithAccreditivePK(anId);
    }
    else if (anDoc_type == PAYMENT_REQUESTS) {
    }
    else if (anDoc_type == ENCASHED_CONTRACTS) {
    }
    else if (anDoc_type == REFUSE_ACCEPT) {
    }
    else {
        throw new IllegalStateException("You cannot delete Document when documentType wrong:" + anDoc_type);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 13:46:34)
 * @return int
 */
public int getDoc_type() {
	return doc_type;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2002 15:31:18)
 * @param anDoc_type
 * @param anFromDate
 * @param anToDate
 * @param anStatuses
 * @param anSortBy
 * @return java.util.Vector
 * @throws com.overstar.ildar.ibank.model.PersistenceException
 * @roseuid 3E0041A20034
 */
public Vector getDocumentsForIClient(
    String iClient,
    int anDoc_type,
    String anFromDate,
    String anToDate,
    String[] anStatuses,
    String anSortBy)
    throws PersistenceException, InvalidDocumentStatusException {
    setDoc_type(anDoc_type);
    setFromDate(anFromDate);
    setToDate(anToDate);
    setStatuses(anStatuses);
    setSortBy(anSortBy);
    if (anDoc_type == PAYMENTS) {
        return PaymentTransactionMgr.getPaymentsForIClient(iClient, anFromDate, anToDate, anStatuses, anSortBy);
    }
    else if (anDoc_type == ACCREDITIVS) {
        return AccreditiveTransactionMgr.getAccreditivsForIClient(iClient, anFromDate, anToDate, anStatuses, anSortBy);
    }
    else
        return new Vector(); //дописать для др доков.
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
 * Insert the method's description here.
 * Creation date: (27.01.2003 15:13:42)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        //Документы:
        String newClient_ID = "2";
        System.out.println("Find Documents for iClient=" + newClient_ID + ":\n");
        String fromDate = "2001-1-1";
        String toDate = "2003-10-23";
        String sortBy = "date_doc"; //-сортировки по полю - amount, status_doc, num_doc, rcpt_name
        DocumentTransactionMgr mgr = new DocumentTransactionMgr();
        Vector documents =
            mgr.getDocumentsForIClient(
                newClient_ID.toString(),
                //DocumentTransactionMgr.PAYMENTS,
                DocumentTransactionMgr.ACCREDITIVS,
                fromDate,
                toDate,
                new String[] { "0", "1", "2", "3" },
                sortBy);
        System.out.println("Documents: " + documents.size() + ":\n" + documents);
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
 * Creation date: (29.01.2003 13:46:34)
 * @param newDoc_type int
 */
public  void setDoc_type(int newDoc_type) {
	doc_type = newDoc_type;
}
   /**
    * Insert the method's description here.
    * Creation date: (23.10.2002 10:36:47)
    * @param newFromDate java.lang.String
    * @roseuid 3E00419C00CC
    */
   private void setFromDate(java.lang.String newFromDate) 
   {
	fromDate = newFromDate;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (24.10.2002 11:13:07)
    * @param newSortBy java.lang.String
    * @roseuid 3E00419C00FE
    */
   private void setSortBy(java.lang.String newSortBy) 
   {
	sortBy = newSortBy;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.10.2002 18:17:08)
    * @param newStatuses java.lang.String[]
    * @roseuid 3E00419C0202
    */
   private void setStatuses(java.lang.String[] newStatuses) 
   {
	statuses = newStatuses;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.10.2002 10:36:47)
    * @param newToDate java.lang.String
    * @roseuid 3E00419C0216
    */
   private void setToDate(java.lang.String newToDate) 
   {
	toDate = newToDate;    
   }
}
