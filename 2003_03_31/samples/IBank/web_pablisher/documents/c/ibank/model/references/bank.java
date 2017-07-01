package com.overstar.ildar.ibank.model.references;

/**
 * Insert the type's description here.
 * Creation date: (16.09.2002 15:34:46)
 * @author: Shafigullin Ildar
 */
import com.overstar.ildar.ibank.model.PrimaryKey;

/**
 * @author  Shafigullin Ildar
 */
public class Bank {

   /**
    * PrimaryKey class to be used for instances of type Bank.
    */
   public static class BankPK extends PrimaryKey 
   {
      
      /**
       * @param anId
       * @roseuid 3E00418C021D
       */
      public BankPK(String anId) 
      {
            super(anId);       
      }
   }
   private String bank_name;
   private Bank.BankPK bik;
   private String bill_corr;
   private String city;
   private String delivery;
/**
 * @roseuid 3E00418A03D3
 */
public Bank() {
    super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2002 16:46:38)
 * @param anBik Bank.BankPK
 * @param anBill_corr java.lang.String
 * @param anBank_name java.lang.String
 * @param anCity java.lang.String
 * @param anDelivery java.lang.String
 * @roseuid 3E00418A03DD
 */
public Bank(Bank.BankPK anBik, String anBill_corr, String anBank_name, String anCity, String anDelivery) {
    bik = anBik;
    initBill_corr(anBill_corr);
    initBank_name(anBank_name);
    initCity(anCity);
    initDelivery(anDelivery);
}
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @return com.overstar.ildar.ibank.model.refererences.Bank.BankPK
    * @roseuid 3E00418B02EE
    */
   public Bank.BankPK getBik() 
   {
	return bik;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @param newBank_name java.lang.String
    * @roseuid 3E00418B03A2
    */
   void initBank_name(java.lang.String newBank_name) 
   {
	bank_name = newBank_name;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @param newBill_corr java.lang.String
    * @roseuid 3E00418B03D4
    */
   void initBill_corr(java.lang.String newBill_corr) 
   {
	bill_corr = newBill_corr;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @param newCity java.lang.String
    * @roseuid 3E00418C001E
    */
   void initCity(java.lang.String newCity) 
   {
	city = newCity;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @param newDelivery java.lang.String
    * @roseuid 3E00418C005A
    */
   void initDelivery(java.lang.String newDelivery) 
   {
	delivery = newDelivery;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @return java.lang.String
    * @roseuid 3E00418C00C9
    */
   public String rtBank_name() 
   {
	return bank_name;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @return java.lang.String
    * @roseuid 3E00418C0119
    */
   public String rtBill_corr() 
   {
	return bill_corr;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @return java.lang.String
    * @roseuid 3E00418C015F
    */
   public String rtCity() 
   {
	return city;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 16:59:29)
    * @return java.lang.String
    * @roseuid 3E00418C01A5
    */
   public String rtDelivery() 
   {
	return delivery;    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 17:51:16)
    * @return java.lang.String
    * @roseuid 3E00418C01D7
    */
   public String toString() 
   {
    return "\nBank.BIK(" + bik + ")" + ".\n ";    
   }
   /**
    * Insert the method's description here.
    * Creation date: (16.09.2002 17:52:52)
    * @return java.lang.String
    * @roseuid 3E00418C01E1
    */
   public String toStringFull() 
   {
	 return "\nBank : bIK (" + bik + ")" + ".\n " + 
        " bill_corr (" + bill_corr + ")" + ".\n " + 
        " bank_name  (" + bank_name + ")" + ".\n " + 
        " city (" + city + ")" + ".\n " +
        " delivery (" + delivery + ")" + ".\n " ;    
   }
}
