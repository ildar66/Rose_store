package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (24.01.2003 11:12:04)
 * @author: Shafigullin Ildar
 */
public class BusinessPartner {

    /**
     * 'ИНН партнера';
     */
    private String inn;

    /**
      * 'Наименование партнера';
      */
    private String name;
    
    /**
    * 'Счет партнера';
    */
    private String bill;

    /**
     * 'Наименование банка партнера';
     */
    private String bank_name;

    /**
     * 'БИК банка партнера';
     */
    private String bank_bic;

    /**
     * 'Корсчет банка партнера';
     */
    private String bank_acc;
/**
 * BusinessPartner constructor comment.
 */
public BusinessPartner() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 11:45:06)
 * @param aINN java.lang.String
 * @param aName java.lang.String
 * @param aBill java.lang.String
 * @param aBank_bic java.lang.String 
 * @param aBank_name java.lang.String
 * @param aBank_acc java.lang.String
 */
public BusinessPartner(String aINN, String aName, String aBill,  String aBank_bic, String aBank_name, String aBank_acc) {
    initInn(aINN);
    initName(aName);
    initBill(aBill);
    initBank_Bic(aBank_bic);
    initBank_name(aBank_name);
    initBank_acc(aBank_acc);
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 11:39:15)
 * @param newBank_acc java.lang.String
 */
void initBank_acc(java.lang.String newBank_acc) {
	bank_acc = newBank_acc;
}
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @param newBic java.lang.String
    * @roseuid 3E0041BA0133
    */
   void initBank_Bic(java.lang.String newBic) 
   {
	bank_bic = newBic;    
   }
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 11:39:15)
 * @param newBank_name java.lang.String
 */
void initBank_name(java.lang.String newBank_name) {
	bank_name = newBank_name;
}
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @param newBill java.lang.String
    * @roseuid 3E0041BA0165
    */
   void initBill(java.lang.String newBill) 
   {
	bill = newBill;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @param newInn java.lang.String
    * @roseuid 3E0041BA0219
    */
   void initInn(java.lang.String newInn) 
   {
	inn = newInn;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @param newName java.lang.String
    * @roseuid 3E0041BA024B
    */
   void initName(java.lang.String newName) 
   {
	name = newName;    
   }
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 11:39:15)
 * @return java.lang.String
 */
public java.lang.String rtBank_acc() {
	return bank_acc;
}
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @return java.lang.String
    * @roseuid 3E0041BA02F6
    */
   public String rtBank_Bic() 
   {
	return bank_bic;    
   }
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 11:39:15)
 * @return java.lang.String
 */
public java.lang.String rtBank_name() {
	return bank_name;
}
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @return java.lang.String
    * @roseuid 3E0041BA033C
    */
   public String rtBill() 
   {
	return bill;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @return java.lang.String
    * @roseuid 3E0041BB0030
    */
   public String rtInn() 
   {
	return inn;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (23.09.2002 17:48:23)
    * @return java.lang.String
    * @roseuid 3E0041BB0076
    */
   public String rtName() 
   {
	return name;    
   }
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 11:06:23)
 * @return java.lang.String
 */
public String toString() {
    return "\nBusiness Partner : name ("
        + name
        + ")"
        + ".\n "
        + " inn ("
        + inn
        + ")"
        + ".\n "
        + " bill ("
        + bill
        + ")"
        + ".\n "
        + " bank_name  ("
        + bank_name
        + ")"
        + ".\n "
        + " bank_bic ("
        + bank_bic
        + ")"
        + ".\n "
        + " bank_acc ("
        + bank_acc
        + ")"
        + ".\n ";
}
}
