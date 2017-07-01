package com.overstar.ildar.ibank.model.documents;

import java.sql.Date;
import com.overstar.ildar.ibank.model.exceptions.*;
import com.overstar.ildar.ibank.model.*;

/**
 * Insert the type's description here.
 * Creation date: (16.10.2002 15:34:04)
 * @author: Shafigullin Ildar
 */
public class Payment extends Document {

    /**
    * 'Вид платежа, может принимать значения:
    */
    private String payment_type;

    /**
     * отсутствует.
     */
    public static final String EMPTY = " ";

    /**
     * "Почтой".
     */
    public static final String POST = "Почтой";

    /**
     * "Телеграфом",.
     */
    public static final String TELEGRAPH = "Телеграфом";

    /**
     * "Электронно".
     */
    public static final String ELECTRONIC = "Электронно";

    /**
     * 'Вид операции, для платежных поручений "01"';
     */
    private String type_oper = "01";

    /**
     * 'Код очередности платежа. Может принимать значения "01", "02", "03", "04", "05" 
     * или "06", или отсутствовать';
     */
    private String queue;

    /**
     * 'Назначение платежа';
     */
    private String payment_details;

    /**
     * 'КПП плательщика';
     */
    private String kpp;

    /**
     * 'Срок платежа';
     */
    private Date term;

    /**
     * 'Сумма платежа (в единицах валюты - рублях)';
     */
    private Money amount;
    
    //плательщик
    private BusinessPartner payer;

    //получатель
    private BusinessPartner recipient;
/**
 * Payment constructor comment.
 * @param anId com.overstar.ildar.ibank.model.Document.DocumentPK
 * @param anClient_id java.lang.Integer
 * @param anDate_doc java.sql.Date
 * @param anNum_doc java.lang.String
 * @param anStatus_doc java.lang.String
 * @param anSigners java.lang.String
 * @param anPayment_type
 * @param anPayer BusinessPartner
 * @param anAmount
 * @param anRecipient BusinessPartner
 * @param anType_oper
 * @param anQueue
 * @param anTerm
 * @param anPayment_details
 * @param anKpp
 * @throws com.overstar.ildar.ibank.model.exceptions.InvalidDocumentStatusException
 * @roseuid 3E09AFE100FC
 */
public Payment(
    Document.DocumentPK anId,
    Integer anClient_id,
    java.sql.Date anDate_doc,
    String anNum_doc,
    String anStatus_doc,
    String anSigners,
    String anPayment_type,
    BusinessPartner anPayer,
    Money anAmount,
    BusinessPartner anRecipient,
    String anType_oper,
    String anQueue,
    java.sql.Date anTerm,
    String anPayment_details,
    String anKpp)
    throws InvalidDocumentStatusException {
    super(anId, anClient_id, anDate_doc, anNum_doc, anStatus_doc, anSigners);
    initPayment_type(anPayment_type);
    initPayer(anPayer);
    initAmount(anAmount);
    initRecipient(anRecipient);
    initType_oper(anType_oper);
    initQueue(anQueue);
    initTerm(anTerm);
    initPayment_details(anPayment_details);
    initKpp(anKpp);
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:41:38)
 * @return java.lang.String
 */
public String getType() {
	return "п/п";
}
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @param newAmount com.overstar.ildar.ibank.model.Money
    * @roseuid 3E09AFE102B5
    */
   void initAmount(Money newAmount) 
   {
	amount = newAmount;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @param newKpp java.lang.String
    * @roseuid 3E09AFE102DD
    */
   void initKpp(java.lang.String newKpp) 
   {
	kpp = newKpp;    
   }
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 11:01:34)
 * @param newPayer com.overstar.ildar.ibank.model.BusinessPartner
 */
void initPayer(com.overstar.ildar.ibank.model.BusinessPartner newPayer) {
	payer = newPayer;
}
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @param newPayment_details java.lang.String
    * @roseuid 3E09AFE10373
    */
   void initPayment_details(java.lang.String newPayment_details) 
   {
	payment_details = newPayment_details;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @param newPayment_type java.lang.String
    * @roseuid 3E09AFE10387
    */
   void initPayment_type(java.lang.String newPayment_type) 
   {
	payment_type = newPayment_type;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @param newQueue java.lang.String
    * @roseuid 3E09AFE1039B
    */
   void initQueue(java.lang.String newQueue) 
   {
	queue = newQueue;    
   }
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 11:01:34)
 * @param newRecipient com.overstar.ildar.ibank.model.BusinessPartner
 */
void initRecipient(com.overstar.ildar.ibank.model.BusinessPartner newRecipient) {
	recipient = newRecipient;
}
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @param newTerm java.sql.Date
    * @roseuid 3E09AFE20049
    */
   void initTerm(java.sql.Date newTerm) 
   {
	term = newTerm;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @param newType_oper java.lang.String
    * @roseuid 3E09AFE2005D
    */
   void initType_oper(java.lang.String newType_oper) 
   {
	type_oper = newType_oper;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @return com.overstar.ildar.ibank.model.Money
    * @roseuid 3E09AFE20085
    */
   public Money rtAmount() 
   {
	return amount;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @return java.lang.String
    * @roseuid 3E09AFE20099
    */
   public String rtKpp() 
   {
	return kpp;    
   }
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 11:01:34)
 * @return com.overstar.ildar.ibank.model.BusinessPartner
 */
public BusinessPartner rtPayer() {
	return payer;
}
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @return java.lang.String
    * @roseuid 3E09AFE200E0
    */
   public String rtPayment_details() 
   {
	return payment_details;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @return java.lang.String
    * @roseuid 3E09AFE200F4
    */
   public String rtPayment_type() 
   {
	return payment_type;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @return java.lang.String
    * @roseuid 3E09AFE200FE
    */
   public String rtQueue() 
   {
	return queue;    
   }
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 11:01:34)
 * @return com.overstar.ildar.ibank.model.BusinessPartner
 */
public BusinessPartner rtRecipient() {
	return recipient;
}
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @return java.sql.Date
    * @roseuid 3E09AFE20144
    */
   public Date rtTerm() 
   {
	return term;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.10.2002 16:40:52)
    * @return java.lang.String
    * @roseuid 3E09AFE20158
    */
   public String rtType_oper() 
   {
	return type_oper;    
   }
   /**
    * Specific implementation for toString().
    * Creation date: (23.09.2002 19:11:03)
    * @return java.lang.String
    * @roseuid 3E09AFE20176
    */
   public String toString() 
   {
    return "Payment ("
        + super.toString()
        + " Amount ("
        + rtAmount()
        + ")"
        + ".\n "
        + " Payer ("
        + rtPayer()
        + ")"
        + ".\n "
        + " Recipient ("
        + rtRecipient()
        + ")"        
        + ".\n ";    
   }
}
