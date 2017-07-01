package com.overstar.ildar.ibank.model.documents;

import java.sql.*;
import com.overstar.ildar.ibank.model.exceptions.*;
import com.overstar.ildar.ibank.model.PrimaryKey;
/**
 * This class is the parent of all sorts of Documents.
 * Creation date: (15.10.2002 16:52:16)
 * @author: Shafigullin Ildar
 */
public abstract class Document {

    /**
     * Идентификатор документа.
     */
    private Document.DocumentPK doc_id;

    /**
     * 'Идентификатор клиента из таблицы Clients';
     */
    private Integer client_id;

    /**
     * Дата создания документа клиентом.
     */
    private Date date_doc;

    /**
     * Номер созданного клиентом документа.
     */
    private String num_doc;

    /**
     * Содержит признак наличия подписи документа.
     */
    private String signers;

    /**
     * Последнее состояние документа:
     */
    private DocumentStatus status_doc;

    /**
     * новый.
     */
    public static final DocumentStatus NEW = new DocumentStatus("0", "новый");

    /**
     * подписан.
     */
    public static final DocumentStatus SIGNED = new DocumentStatus("1", "подписан");

    /**
     * доставлен.
     */
    public static final DocumentStatus DELIVERED = new DocumentStatus("2", "доставлен");

    /**
     * на обработке.
     */
    public static final DocumentStatus PROCESSING = new DocumentStatus("3", "на обработке");

    /**
     * на исполнении.
     */
    public static final DocumentStatus EXECUTION = new DocumentStatus("4", "на исполнении");

    /**
     * исполнен.
     */
    public static final DocumentStatus EXECUTED = new DocumentStatus("5", "исполнен");

    /**
     * отвергнут.
     */
    public static final DocumentStatus DISCARDED = new DocumentStatus("6", "отвергнут");

    /**
     * удален.
     */
    public static final DocumentStatus DELETION = new DocumentStatus("7", "удален");

    public static class DocumentPK extends PrimaryKey {

        /**
         * @param anId
         * @roseuid 3E10274B0147
         */
        public DocumentPK(String anId) {
            super(anId);
        }

        /**
         * @roseuid 3E10274B0133
         */
        public DocumentPK() {
            super();
        }
    }

    public static class DocumentStatus {
        private String id;
        private String statusDescription;

        /**
         * @param aID
         * @param aStatusDescription
         * @roseuid 3E00419D0037
         */
        private DocumentStatus(String aID, String aStatusDescription) {
            statusDescription = aStatusDescription;
            id = aID;
        }

        /**
         * @return java.lang.String
         * @roseuid 3E00419D0042
         */
        public String toString() {
            return statusDescription;
        }
        
        /**
         * @return java.lang.String
         */
        public String getID() {
            return id;
        }
    }

/**
 * Payment constructor comment.
 * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
 * @param anClient_id java.lang.Integer
 * @param anDate_doc java.sql.Date
 * @param anNum_doc java.lang.String
 * @param anStatus_doc java.lang.String
 * @param anSigners java.lang.String
 * @param anDoc_type int
 * @roseuid 3E102749036B
 */
public Document(
    Document.DocumentPK anId,
    Integer anClient_id,
    java.sql.Date anDate_doc,
    String anNum_doc,
    DocumentStatus anStatus_doc,
    String anSigners) {
    doc_id = anId;
    initClient_id(anClient_id);
    initDate_doc(anDate_doc);
    initNum_doc(anNum_doc);
    initStatus_doc(anStatus_doc);
    initSigners(anSigners);
}
/**
 * Payment constructor comment.
 * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
 * @param anClient_id java.lang.Integer
 * @param anDate_doc java.sql.Date
 * @param anNum_doc java.lang.String
 * @param anStatus_doc java.lang.String
 * @param anSigners java.lang.String
 * @param anDoc_type int
 * @throws InvalidDocumentStatusException
 * @roseuid 3E102749036B
 */
public Document(
    Document.DocumentPK anId,
    Integer anClient_id,
    java.sql.Date anDate_doc,
    String anNum_doc,
    String anStatus_doc,
    String anSigners) throws InvalidDocumentStatusException {
    doc_id = anId;
    initClient_id(anClient_id);
    initDate_doc(anDate_doc);
    initNum_doc(anNum_doc);
    initStatus_doc(anStatus_doc); 
    initSigners(anSigners);
}
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @return java.lang.String
    * @roseuid 3E10274A0091
    */
   public Document.DocumentPK getDoc_id() 
   {
	return doc_id;    
   }
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 17:01:59)
 * @return java.lang.String
 * @roseuid 3E10274A013B
 */
public abstract String getType();
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newClient_id java.lang.Integer
    * @roseuid 3E10274A0163
    */
   private void initClient_id(java.lang.Integer newClient_id) 
   {
	client_id = newClient_id;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newDate_doc java.sql.Date
    * @roseuid 3E10274A01BE
    */
   private void initDate_doc(java.sql.Date newDate_doc) 
   {
	date_doc = newDate_doc;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newNum_doc java.lang.String
    * @roseuid 3E10274A0240
    */
   private void initNum_doc(java.lang.String newNum_doc) 
   {
	num_doc = newNum_doc;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newSigners java.lang.String
    * @roseuid 3E10274A0290
    */
   private void initSigners(java.lang.String newSigners) 
   {
	signers = newSigners;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newStatus_doc java.lang.String
    * @roseuid 3E10274A02E0
    */
   private void initStatus_doc(DocumentStatus newStatus_doc) 
   {
	status_doc = newStatus_doc;    
   }
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @param newStatus_doc java.lang.String
 * @roseuid 3E10274A02E0
 */
private void initStatus_doc(String statusID) throws InvalidDocumentStatusException {
    if (statusID.equals(Document.NEW.getID()))
        status_doc = Document.NEW;
    else if (statusID.equals(Document.SIGNED.getID()))
        status_doc = Document.SIGNED;
    else if (statusID.equals(Document.DELIVERED.getID()))
        status_doc = Document.DELIVERED;
    else if (statusID.equals(Document.PROCESSING.getID()))
        status_doc = Document.PROCESSING;
    else if (statusID.equals(Document.EXECUTION.getID()))
        status_doc = Document.EXECUTION;
    else if (statusID.equals(Document.EXECUTED.getID()))
        status_doc = Document.EXECUTED;
    else if (statusID.equals(Document.DISCARDED.getID()))
        status_doc = Document.DISCARDED;
    else if (statusID.equals(Document.DELETION.getID()))
        status_doc = Document.DELETION;
    else
        throw new InvalidDocumentStatusException("Valid DocumentStatus:\"1\"-\"7\"");
}
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @return java.lang.Integer
    * @roseuid 3E10274A034E
    */
   public Integer rtClient_id() 
   {
	return client_id;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @return java.sql.Date
    * @roseuid 3E10274A039E
    */
   public Date rtDate_doc() 
   {
	return date_doc;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @return java.lang.String
    * @roseuid 3E10274B001A
    */
   public String rtNum_doc() 
   {
	return num_doc;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @return java.lang.String
    * @roseuid 3E10274B006A
    */
   public String rtSigners() 
   {
	return signers;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @return java.lang.String
    * @roseuid 3E10274B00BB
    */
   public DocumentStatus rtStatus_doc() 
   {
	return status_doc;    
   }
   /**
    * Specific implementation for toString().
    * Creation date: (23.09.2002 19:11:03)
    * @return java.lang.String
    * @roseuid 3E10274B00ED
    */
   public String toString() 
   {
    return "Document ("
        + doc_id
        + ")"
        + ".\n "
        + " client_id  ("
        + client_id
        + ")"
        + ".\n "
        + " date_doc ("
        + date_doc
        + ")"
        + ".\n "
        + " Status_doc ("
        + status_doc
        + ")"
        + ".\n "
        + " num_doc ("
        + num_doc
        + ")"
        + ".\n "
        + " signers ("
        + signers
        + ")"
        + ".\n ";    
   }
}
