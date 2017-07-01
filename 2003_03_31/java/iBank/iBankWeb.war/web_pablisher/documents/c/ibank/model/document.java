//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\overstar\\ildar\\ibank\\model\\Document.java

package com.overstar.ildar.ibank.model;

import java.sql.*;

/**
 * This class is the parent of all sorts of Documents.
 * Creation date: (15.10.2002 16:52:16)
 * @author: Shafigullin Ildar
 */
public abstract class Document 
{
   
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
   private String status_doc;
   
   /**
    * новый.
    */
   public static final String NEW = "0";
   
   /**
    * подписан.
    */
   public static final String SIGNED = "1";
   
   /**
    * доставлен.
    */
   public static final String DELIVERED = "2";
   
   /**
    * на обработке.
    */
   public static final String PROCESSING = "3";
   
   /**
    * на исполнении.
    */
   public static final String EXECUTION = "4";
   
   /**
    * исполнен.
    */
   public static final String EXECUTED = "5";
   
   /**
    * отвергнут.
    */
   public static final String DISCARDED = "6";
   
   /**
    * удален.
    */
   public static final String DELETION = "7";
   
   /**
    * тип документа - объект дествия:
    */
   private int doc_type;
   
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
   
   /**
    * Payment constructor comment.
    * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
    * @param anClient_id java.lang.Integer
    * @param anDate_doc java.sql.Date
    * @param anNum_doc java.lang.String
    * @param anStatus_doc java.lang.String
    * @param anSigners java.lang.String
    * @param anDoc_type int
    * @throws com.overstar.ildar.ibank.model.PersistenceException
    * @exception com.overstar.ildar.ibank.model.PersistenceException The exception 
    * description.
    * @roseuid 3E102749036B
    */
   public Document(Document.DocumentPK anId, Integer anClient_id, java.sql.Date anDate_doc, String anNum_doc, String anStatus_doc, String anSigners, int anDoc_type) throws PersistenceException 
   {
     doc_id = anId;
     initClient_id(anClient_id);
     initDate_doc(anDate_doc);
     initNum_doc(anNum_doc);
     initStatus_doc(anStatus_doc);
     initSigners(anSigners);
     initDoc_type(anDoc_type);    
   }
   
   /**
    * Document constructor comment.
    * @roseuid 3E1027490357
    */
   public Document() 
   {
	super();    
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
    * Creation date: (15.10.2002 18:20:31)
    * @param aDocument
    * @return java.lang.String
    * @roseuid 3E10274A00F5
    */
   public static String getStatus_docFull(Document aDocument) 
   {
    String status = aDocument.rtStatus_doc();
    if (status.equals(Document.NEW))
        return "новый";
    else if (status.equals(Document.SIGNED))
        return "подписан";
    else if (status.equals(Document.DELIVERED))
        return "доставлен";
    else if (status.equals(Document.PROCESSING))
        return "на обработке";
    else if (status.equals(Document.EXECUTION))
        return "на исполнении";
    else if (status.equals(Document.EXECUTED))
        return "исполнен";
    else if (status.equals(Document.DISCARDED))
        return "отвергнут";
    else if (status.equals(Document.DELETION))
        return "подписан";
    else
        return "неизвестный статус документа:" + status;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (13.11.2002 17:01:59)
    * @return java.lang.String
    * @param anDocument com.overstar.ildar.ibank.model.Document@return 
    * java.lang.String
    * @roseuid 3E10274A013B
    */
   public static String getType(Document anDocument) 
   {
    if (anDocument instanceof Payment) {
        return "п/п"; 
    }
/* 
else if (anDocument instanceof Accreditive) {
        return "аккртв";
    }
    else if (anDocument instanceof ) {
        return "";
    }
    else if (anDocument instanceof SpecTransientAccount) {
        return "";
    }
*/    
    else {
        return "неизвестный тип документа";
    }    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newClient_id java.lang.Integer
    * @roseuid 3E10274A0163
    */
   void initClient_id(java.lang.Integer newClient_id) 
   {
	client_id = newClient_id;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newDate_doc java.sql.Date
    * @roseuid 3E10274A01BE
    */
   void initDate_doc(java.sql.Date newDate_doc) 
   {
	date_doc = newDate_doc;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newDoc_type int
    * @roseuid 3E10274A020E
    */
   void initDoc_type(int newDoc_type) 
   {
	doc_type = newDoc_type;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newNum_doc java.lang.String
    * @roseuid 3E10274A0240
    */
   void initNum_doc(java.lang.String newNum_doc) 
   {
	num_doc = newNum_doc;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newSigners java.lang.String
    * @roseuid 3E10274A0290
    */
   void initSigners(java.lang.String newSigners) 
   {
	signers = newSigners;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (15.10.2002 18:20:31)
    * @param newStatus_doc java.lang.String
    * @roseuid 3E10274A02E0
    */
   void initStatus_doc(java.lang.String newStatus_doc) 
   {
	status_doc = newStatus_doc;    
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
    * @return int
    * @roseuid 3E10274A03D0
    */
   public int rtDoc_type() 
   {
	return doc_type;    
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
   public String rtStatus_doc() 
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
        + " doc_type ("
        + doc_type
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
   
   public static class DocumentPK extends PrimaryKey 
   {
      
      /**
       * @param anId
       * @roseuid 3E10274B0147
       */
      public DocumentPK(String anId) 
      {
            super(anId);       
      }
      
      /**
       * @roseuid 3E10274B0133
       */
      public DocumentPK() 
      {
            super();       
      }
   }
}
