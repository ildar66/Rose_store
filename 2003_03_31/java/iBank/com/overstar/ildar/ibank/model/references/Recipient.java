package com.overstar.ildar.ibank.model.references;

import java.util.Vector;
import com.overstar.ildar.ibank.model.*;

/**
 * Класс "Контрагентов".
 * Creation date: (23.09.2002 15:30:56)
 * @author: Shafigullin Ildar
 */
public class Recipient extends BusinessPartner{

    /**
     * PrimaryKey class to be used for instances of type Recipient.
     */
    public static class RecipientPK extends PrimaryKey {
	    
        /**
         * @roseuid 3E0041BB012B
         */
        public RecipientPK() {
            super();
        }

        /**
         * @param anId
         * @roseuid 3E0041BB0120
         */
        public RecipientPK(String anId) {
            super(anId);
        }
    }
    
    /**
    * 'Уникальный идентификатор получателя';
    */
    private Recipient.RecipientPK id;
    
    /**
     * 'Идентификатор клиента';
     */
    private Integer client_id;
    
    /**
     * 'Текст назначения платежа';
     */
    private String comments;
/**
 * Constructor.
 * Creation date: (23.09.2002 18:29:52)
 * @roseuid 3E0041B80375
 */
public Recipient() {
	super();
}
/**
 * Recipient constructor comment.
 * @param anId
 * @param anCLIENT_ID
 * @param anINN
 * @param anNAME
 * @param anBIC
 * @param anBILL
 * @param anCOMMENTS
 * @roseuid 3E0041B8037F
 */
public Recipient(
    Recipient.RecipientPK anId,
    Integer anCLIENT_ID,
    String anINN,
    String anNAME,
    String anBIC,
    String anBILL,
    String anCOMMENTS) {
	super(anINN, anNAME, anBILL, anBIC, null, null);    
    id = anId;
    initClient_id(anCLIENT_ID);
    initComments(anCOMMENTS);
}
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @return com.overstar.ildar.ibank.model.Recipient.RecipientPK
    * @roseuid 3E0041B90182
    */
   public Recipient.RecipientPK getId() 
   {
    return id;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @param newClient_id java.lang.Integer
    * @roseuid 3E0041BA01A1
    */
   void initClient_id(java.lang.Integer newClient_id) 
   {
	client_id = newClient_id;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @param newComments java.lang.String
    * @roseuid 3E0041BA01D3
    */
   void initComments(java.lang.String newComments) 
   {
	comments = newComments;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @return java.lang.Integer
    * @roseuid 3E0041BA0382
    */
   public Integer rtClient_id() 
   {
	return client_id;    
   }
   /**
    * 'Текст назначения платежа'
    * Creation date: (23.09.2002 17:48:23)
    * @return java.lang.String
    * @roseuid 3E0041BA03C8
    */
   public String rtComments() 
   {
	return comments;    
   }
   /**
    * Specific implementation for toString().
    * Creation date: (23.09.2002 19:11:03)
    * @return java.lang.String
    * @roseuid 3E0041BB00D0
    */
   public String toString() 
   {
    return "Recipient ("
        + id
        + ")"
        + ".\n "
        + " client_id ("
        + client_id
        + ")"
        + ".\n "
        + " inn  ("
        + rtInn()
        + ")"
        + ".\n "
        + " name ("
        + rtName()
        + ")"
        + ".\n "
        + " bic ("
        + rtBank_Bic()
        + ")"
        + ".\n "
        + " bill ("
        + rtBill()
        + ")"
        + ".\n "
        + " comments ("
        + comments
        + ")"
        + ".\n ";    
   }
}
