package com.overstar.ildar.ibank.model;

import java.sql.*;
/**
 * This class is the parent of all sorts of Documents.
 * Creation date: (15.10.2002 16:52:16)
 * @author: Shafigullin Ildar
 */
public abstract class Document {
public static class DocumentPK extends PrimaryKey {
    public DocumentPK() {
        super();
    }
    public DocumentPK(String anId) {
        super(anId);
    }
}
	private DocumentPK doc_id;//Идентификатор документа.
	private java.lang.Integer client_id;//'Идентификатор клиента из таблицы Clients';
	private java.sql.Date date_doc;//Дата создания документа клиентом.
	private java.lang.String num_doc;//Номер созданного клиентом документа.
	private java.lang.String signers;//Содержит признак наличия подписи документа.
	
	private java.lang.String status_doc;//Последнее состояние документа:
	public final static String NEW = "0";//новый.
	public final static String SIGNED = "1";//подписан.
	public final static String DELIVERED = "2";//доставлен.
	public final static String PROCESSING = "3";//на обработке.
	public final static String EXECUTION = "4";// на исполнении.
	public final static String EXECUTED = "5"; //исполнен.
	public final static String DISCARDED = "6";//отвергнут.
	public final static String DELETION = "7";//удален.
	
	private int doc_type;//тип документа - объект дествия:
	public final static int PAYMENTS = 1;//Платежное поручение.
	public final static int ENCASHED_CONTRACTS = 9;//Инкассовое поручение.
	public final static int PAYMENT_REQUESTS = 7;//Платежное требование.
	public final static int ACCREDITIVS = 8;//Аккредитив.
	public final static int REFUSE_ACCEPT = 10;//Заявление об отказе от акцепта.
	
/**
 * Document constructor comment.
 */
public Document() {
	super();
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
* @exception com.overstar.ildar.ibank.model.PersistenceException The exception description.
*/
public Document(
    DocumentPK anId,
    Integer anClient_id,
    Date anDate_doc,
    String anNum_doc,
    String anStatus_doc,
    String anSigners,
    int anDoc_type)
    throws PersistenceException {
    doc_id = anId;
    initClient_id(anClient_id);
    initDate_doc(anDate_doc);
    initNum_doc(anNum_doc);
    initStatus_doc(anStatus_doc);
    initSigners(anSigners);
    initDoc_type(anDoc_type);
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return java.lang.String
 */
public DocumentPK getDoc_id() {
	return doc_id;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return java.lang.String
 */
public static java.lang.String getStatus_docFull(Document aDocument) {
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
 * @param anDocument com.overstar.ildar.ibank.model.Document
 */
public static String getType(Document anDocument) {
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
 */
void initClient_id(java.lang.Integer newClient_id) {
	client_id = newClient_id;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @param newDate_doc java.sql.Date
 */
void initDate_doc(java.sql.Date newDate_doc) {
	date_doc = newDate_doc;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @param newDoc_type int
 */
void initDoc_type(int newDoc_type) {
	doc_type = newDoc_type;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @param newNum_doc java.lang.String
 */
void initNum_doc(java.lang.String newNum_doc) {
	num_doc = newNum_doc;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @param newSigners java.lang.String
 */
void initSigners(java.lang.String newSigners) {
	signers = newSigners;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @param newStatus_doc java.lang.String
 */
void initStatus_doc(java.lang.String newStatus_doc) {
	status_doc = newStatus_doc;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return java.lang.Integer
 */
public java.lang.Integer rtClient_id() {
	return client_id;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return java.sql.Date
 */
public java.sql.Date rtDate_doc() {
	return date_doc;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return int
 */
public int rtDoc_type() {
	return doc_type;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return java.lang.String
 */
public java.lang.String rtNum_doc() {
	return num_doc;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return java.lang.String
 */
public java.lang.String rtSigners() {
	return signers;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2002 18:20:31)
 * @return java.lang.String
 */
public java.lang.String rtStatus_doc() {
	return status_doc;
}
/**
 * Specific implementation for toString().
 * 
 * Creation date: (23.09.2002 19:11:03)
 * @return java.lang.String
 */
public String toString() {
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
}
