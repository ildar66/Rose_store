package com.overstar.bank.database;

import java.text.*;
/**
 * Insert the type's description here.
 * Creation date: (21.08.2001 10:01:17)
 * @author: Shafigullin Ildar
 */
public class Document {
	private com.ibm.ivj.db.uibeans.Select ivjSelectDocuments = null;
	private java.util.Date fieldDate_Carry = new java.util.Date();
	private java.lang.String fieldCode_Payer = new String();
	private java.lang.String fieldReal_Payer = new String();
	private java.lang.String fieldCode_Receiver = new String();
	private java.lang.String fieldReal_Receiver = new String();
	private java.lang.String fieldIApplicationKey = new String();
	private java.lang.String fieldPayer = new String();
	private java.lang.String fieldReceiver = new String();
	private java.lang.String fieldGround = new String();
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private java.util.Date fieldDate1 = new java.util.Date();
	private java.util.Date fieldDate2 = new java.util.Date();
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private java.lang.String fieldAccount = new String();
	private java.lang.String fieldDate1String = new String();
	private java.lang.String fieldDate2String = new String();
	private java.lang.String[] fieldRow = null;
	private java.lang.String fieldSum = new String();
	private java.lang.String fieldKindCode_Payer = new String();
	private java.lang.String fieldKindCode_Receiver = new String();
	private java.lang.String fieldIApplicationKind = new String();
	private com.ibm.ivj.db.uibeans.Select ivjSelectPaymentID = null;
	private com.ibm.ivj.db.uibeans.Select ivjSelectBIK = null;
	private com.ibm.ivj.db.uibeans.Select ivjSelectAmount = null;
	private com.ibm.ivj.db.uibeans.Select ivjSelectCorrAccount = null;
	private java.lang.String fieldCorAcc_Receiver = new String();
	private java.lang.String fieldCorAcc_Payer = new String();
	private java.lang.String fieldAccount_Receiver = new String();
	private java.lang.String fieldAccount_Payer = new String();
	private com.ibm.ivj.db.uibeans.Select ivjSelectCheckData = null;
	private com.ibm.ivj.db.uibeans.Select ivjSelectRest = null;
	private java.lang.String fieldRest = new String();
	private java.util.Vector fieldAll_Documents = new java.util.Vector();
	private com.ibm.ivj.db.uibeans.Select ivjSelectDocuments$ = null;

class IvjEventHandler implements java.beans.PropertyChangeListener {
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("date1String"))) 
				connPtoP1SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("date2String"))) 
				connPtoP2SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("account"))) 
				connPtoP3SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("account"))) 
				connPtoP4SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("date1String"))) 
				connPtoP5SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("account"))) 
				connPtoP6SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("date1String"))) 
				connPtoP7SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("date2String"))) 
				connPtoP8SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("account"))) 
				connPtoP9SetTarget();
			if (evt.getSource() == Document.this && (evt.getPropertyName().equals("account"))) 
				connPtoP10SetTarget();
		};
	};
	private java.lang.String fieldIncludeDocuments = new String();
	private java.lang.String fieldIncludeRest = new String();
/**
 * Document constructor comment.
 */
public Document() {
	super();
	initialize();
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void addPropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(propertyName, listener);
}
/**
 * connPtoP10SetTarget:  (Document.account <--> SelectDocuments$.Parm_ACCOUNT1_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP10SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments$().setParameterFromString("ACCOUNT1", this.getAccount());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP1SetTarget:  (Document.date1 <--> SelectDocuments.Parm_DATE1_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP1SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments().setParameterFromString("DATE1", this.getDate1String());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP2SetTarget:  (Document.date2 <--> SelectDocuments.Parm_DATE2_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP2SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments().setParameterFromString("DATE2", this.getDate2String());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP3SetTarget:  (Document.account <--> SelectDocuments.Parm_ACCOUNT_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP3SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments().setParameterFromString("ACCOUNT", this.getAccount());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP4SetTarget:  (Document.account <--> SelectDocuments.Parm_ACCOUNT1_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP4SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments().setParameterFromString("ACCOUNT1", this.getAccount());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP5SetTarget:  (Document.date1String <--> SelectRest.Parm_DATE1_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP5SetTarget() {
	/* Set the target from the source */
	try {
		getSelectRest().setParameterFromString("DATE1", this.getDate1String());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP6SetTarget:  (Document.account <--> SelectRest.Parm_ACCOUNT_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP6SetTarget() {
	/* Set the target from the source */
	try {
		getSelectRest().setParameterFromString("ACCOUNT", this.getAccount());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP7SetTarget:  (Document.date1String <--> SelectDocuments$.Parm_DATE1_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP7SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments$().setParameterFromString("DATE1", this.getDate1String());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP8SetTarget:  (Document.date2String <--> SelectDocuments$.Parm_DATE2_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP8SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments$().setParameterFromString("DATE2", this.getDate2String());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP9SetTarget:  (Document.account <--> SelectDocuments$.Parm_ACCOUNT_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP9SetTarget() {
	/* Set the target from the source */
	try {
		getSelectDocuments$().setParameterFromString("ACCOUNT", this.getAccount());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.beans.PropertyChangeEvent evt) {
	getPropertyChange().firePropertyChange(evt);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.lang.String propertyName, int oldValue, int newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.lang.String propertyName, java.lang.Object oldValue, java.lang.Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 */
public void firePropertyChange(java.lang.String propertyName, boolean oldValue, boolean newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * Gets the account property (java.lang.String) value.
 * @return The account property value.
 * @see #setAccount
 */
public java.lang.String getAccount() {
	return fieldAccount;
}
/**
 * Gets the account_Payer property (java.lang.String) value.
 * @return The account_Payer property value.
 */
public java.lang.String getAccount_Payer() {
	return fieldAccount_Payer;
}
/**
 * Gets the account_Receiver property (java.lang.String) value.
 * @return The account_Receiver property value.
 */
public java.lang.String getAccount_Receiver() {
	return fieldAccount_Receiver;
}
/**
 * Gets the all_Documents property (java.util.Vector) value.
 * @return The all_Documents property value.
 */
public java.util.Vector getAll_Documents() {
	return fieldAll_Documents;
}
/**
 * Gets the code_Payer property (java.lang.String) value.
 * @return The code_Payer property value.
 */
public java.lang.String getCode_Payer() {
	return fieldCode_Payer;
}
/**
 * Gets the code_Receiver property (java.lang.String) value.
 * @return The code_Receiver property value.
 */
public java.lang.String getCode_Receiver() {
	return fieldCode_Receiver;
}
/**
 * Gets the corAcc_Payer property (java.lang.String) value.
 * @return The corAcc_Payer property value.
 */
public java.lang.String getCorAcc_Payer() {
	return fieldCorAcc_Payer;
}
/**
 * Gets the corAcc_Receiver property (java.lang.String) value.
 * @return The corAcc_Receiver property value.
 */
public java.lang.String getCorAcc_Receiver() {
	return fieldCorAcc_Receiver;
}
/**
 * Gets the date_Carry property (java.util.Date) value.
 * @return The date_Carry property value.
 * @see #setDate_Carry
 */
public java.util.Date getDate_Carry() {
	return fieldDate_Carry;
}
/**
 * Gets the date1 property (java.util.Date) value.
 * @return The date1 property value.
 * @see #setDate1
 */
public java.util.Date getDate1() {
	return fieldDate1;
}
/**
 * Gets the date1String property (java.lang.String) value.
 * @return The date1String property value.
 * @see #setDate1String
 */
public java.lang.String getDate1String() {
	return fieldDate1String;
}
/**
 * Gets the date2 property (java.util.Date) value.
 * @return The date2 property value.
 * @see #setDate2
 */
public java.util.Date getDate2() {
	return fieldDate2;
}
/**
 * Gets the date2String property (java.lang.String) value.
 * @return The date2String property value.
 * @see #setDate2String
 */
public java.lang.String getDate2String() {
	return fieldDate2String;
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
 //только для русских счетов!!!
private DocView getDocumView(int index) {
  try {	
	getSelectDocuments().setCurrentRow(index);
//п.10)
  //поле ДАТА = fieldDate_Carry
	fieldDate_Carry= (java.util.Date)getSelectDocuments().getColumnValue(0);
	
  //определяем направление платежа :
	boolean is_debit = false;//направление платежа
	fieldReal_Payer=getSelectDocuments().getColumnValueToString(3);
	if(getAccount().equals(fieldReal_Payer.trim()+"%"))
	  is_debit = true;  
  //переменные ViewBeance	  	
  	String paymentID="";     //ключ 
	String bankCode ="";     //"БИК" 
	String accountContr = "";//"Счет контрагента"
	String credit = "";      //"Кредит"
	String debit = "";       //"Дебит"
	java.math.BigDecimal creditNum = null;      //"Кредит"
	java.math.BigDecimal debitNum = null;       //"Дебит"
	String corrAccount = ""; //"Коррсчет"
	String nameContr = "";   //"Наименование контрагента"
	String ground = "";      //"Назначение платежа" 
  //ищем paymentID from PMDOCS.DBT :	
  	fieldIApplicationKey=getSelectDocuments().getColumnValueToString(9);
  	getSelectPaymentID().setParameterFromString("KEY",fieldIApplicationKey);
	fieldIApplicationKind=getSelectDocuments().getColumnValueToString(8);
  	getSelectPaymentID().setParameterFromString("KIND",fieldIApplicationKind);
  	getSelectPaymentID().execute();
  	if (getSelectPaymentID().getRowCount() != 0)
  	  {
  	  	paymentID = getSelectPaymentID().getColumnValueToString(0);
//п.11)В таблице PMPROP.DBT по ключу PaymentID находим bankCode(БИК):
		getSelectBIK().setParameterFromString("PAYMENTID",paymentID);
		getSelectBIK().execute();
		if(getSelectBIK().getRowCount() != 0)
		  bankCode = getSelectBIK().getColumnValueToString(0);
//п.12)В таблице PMPAYM.DBT по PaymentID: ищется "Счет контрагента",
	   //"Дебит"("Кредит")
		getSelectAmount().setParameterFromString("PAYMENTID", paymentID);
		getSelectAmount().execute();
		if(getSelectAmount().getRowCount() != 0)
		  {
			if(is_debit)
			 {
				debit = getSelectAmount().getColumnValueToString(0);
				debitNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);
				accountContr = getSelectAmount().getColumnValueToString(1); 
			 }
			else
			 {
				credit = getSelectAmount().getColumnValueToString(0);
				creditNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);				 
				accountContr = getSelectAmount().getColumnValueToString(2); 				 
			 } 
		  }
//п.13)	В таблице PMRMPROP.DBT по ключу PaymentID ищется "Коррсчет" и
		//"Наименование контрагента"
		getSelectCorrAccount().setParameterFromString("PAYMENTID", paymentID);
		getSelectCorrAccount().execute();
		if(getSelectCorrAccount().getRowCount() != 0)
		  {
			 if(is_debit)
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(2);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(3);
			  }
			 else
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(0);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(1);
			  } 
		  }
		//"Назначение платежа" 
		ground = getSelectCorrAccount().getColumnValueToString(4); 
  	  }
	else //ключ paymentID не найден:
	  {
//п.14)
	//"Коррсчет":
	    fieldCorAcc_Receiver = getSelectDocuments().getColumnValueToString(13);
	    fieldCorAcc_Payer = getSelectDocuments().getColumnValueToString(14);
//System.out.println("fieldCorAcc_Receiver:" + fieldCorAcc_Receiver);//tmp
//System.out.println("fieldCorAcc_Payer:" + fieldCorAcc_Payer);//tmp		  
	    if(is_debit)
		  corrAccount =fieldCorAcc_Receiver;  //ARHDOC*.CorAcc_Receiver;
		else
		  corrAccount =fieldCorAcc_Payer;     //ARHDOC*.CorAcc_Payer;
	//"БИК"
		fieldKindCode_Payer=getSelectDocuments().getColumnValueToString(1);
		fieldKindCode_Receiver=getSelectDocuments().getColumnValueToString(4);
		fieldCode_Receiver=getSelectDocuments().getColumnValueToString(5);
		fieldCode_Payer=getSelectDocuments().getColumnValueToString(2);
//System.out.println("KindCode_Payer:" + fieldKindCode_Payer);//tmp
//System.out.println("KindCode_Receiver:" + fieldKindCode_Receiver);//tmp
		if ( is_debit && (fieldKindCode_Receiver.equals("3")) )
		  bankCode = fieldCode_Receiver;
		else if ( !is_debit && (fieldKindCode_Payer.equals("3")) )
		  bankCode = fieldCode_Payer;
		else{
			//в противном случае в таблице BANKDPRT.DBT ищется запись,
			//для которой BANKDPRT.CorAcc = "Коррсчет", 
			//и выводится BANKDPRT.CheckData в этой записи;
			getSelectCheckData().setParameterFromString("CORACC",corrAccount);
			getSelectCheckData().execute();
			if(getSelectCheckData().getRowCount()==1)//соответствие с corrAccount???
			  bankCode = getSelectCheckData().getColumnValueToString(0);
			}
	//"Счет контрагента":
	    fieldAccount_Receiver = getSelectDocuments().getColumnValueToString(15);
	    fieldAccount_Payer = getSelectDocuments().getColumnValueToString(16);
	    if(is_debit)
	       accountContr = fieldAccount_Receiver; //ARHDOC*.Account_Receiver;
	    else
	       accountContr = fieldAccount_Payer;    //ARHDOC*.Account _Payer;
	//"Дебет"("Кредит")
	    fieldSum=getSelectDocuments().getColumnValueToString(7);
	    if (is_debit){
		  debitNum = (java.math.BigDecimal)getSelectDocuments().getColumnValue(7);		    
	      debit = fieldSum;
	    }  
	    else {
	      credit= fieldSum;
	      creditNum=(java.math.BigDecimal)getSelectDocuments().getColumnValue(7);	      
	    }  
	//"Наименование контрагента":
	    fieldReceiver=getSelectDocuments().getColumnValueToString(11);
	    fieldPayer=getSelectDocuments().getColumnValueToString(10);
	    if (is_debit)
	      nameContr = fieldReceiver;
	    else
	      nameContr = fieldPayer;
	//"Назначение платежа" 
	    fieldGround=getSelectDocuments().getColumnValueToString(12);
	    ground=fieldGround;
	  }
//System.out.println("count row: "+getSelectPaymentID().getRowCount());

//System.out.println("undo field1");
//	fieldKindCode_Payer=getSelectDocuments().getColumnValueToString(1);
//System.out.println("undo field2");	
//	fieldCode_Payer=getSelectDocuments().getColumnValueToString(2);
//System.out.println("undo field3");
//	fieldReal_Payer=getSelectDocuments().getColumnValueToString(3);
//System.out.println("undo field4");
//	fieldKindCode_Receiver=getSelectDocuments().getColumnValueToString(4);
//System.out.println("undo field5");	
//	fieldCode_Receiver=getSelectDocuments().getColumnValueToString(5);
//System.out.println("undo field6");
//	fieldReal_Receiver=getSelectDocuments().getColumnValueToString(6);
//System.out.println("undo field7");
//	fieldSum=getSelectDocuments().getColumnValueToString(7);
//System.out.println("undo field8");	
//	fieldIApplicationKind=getSelectDocuments().getColumnValueToString(8);
//System.out.println("undo field9");	
//	fieldIApplicationKey=getSelectDocuments().getColumnValueToString(9);
//System.out.println("undo field10");	
//	fieldPayer=getSelectDocuments().getColumnValueToString(10);
//System.out.println("undo field11");	
//	fieldReceiver=getSelectDocuments().getColumnValueToString(11);
//System.out.println("undo field12");	
//	fieldGround=getSelectDocuments().getColumnValueToString(12);

//System.out.println("rest:"+getRest());
		
/*	return	""+index+" Дата:"+fieldDate_Carry+
	         " is_debit:" + is_debit +
	         " paymentID:"+paymentID +
	         " БИК:" + bankCode +
	         " debit:" + debit +
	         " credit:" + credit +
	         " debitNum:" + debitNum +
	         " creditNum:" + creditNum +	         
	         " Счет контрагента:" +accountContr +
	         " Коррсчет:" + corrAccount +
	         " Наименование контрагента:" + nameContr +
	         " Назначение платежа:" + ground;         */
	 return new DocView(fieldDate_Carry, bankCode, corrAccount, nameContr,
	                    accountContr, creditNum, debitNum, ground);	         
  }
  catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
private DocView getDocumView(int index, com.ibm.ivj.db.uibeans.Select select) {
  try {	
	select.setCurrentRow(index);
//п.10)
  //поле ДАТА = fieldDate_Carry
	fieldDate_Carry= (java.util.Date)select.getColumnValue(0);
	
  //определяем направление платежа :
	boolean is_debit = false;//направление платежа
	fieldReal_Payer=select.getColumnValueToString(3);
	if(getAccount().equals(fieldReal_Payer.trim()+"%"))
	  is_debit = true;  
  //переменные ViewBeance	  	
  	String paymentID="";        //ключ 
	String bankCode ="";        //"БИК" 
	String accountContr = "";   //"Счет контрагента"
	String credit = "";         //"Кредит"
	String debit = "";          //"Дебит"
	java.math.BigDecimal creditNum = null;      //"Кредит"
	java.math.BigDecimal debitNum = null;       //"Дебит"
	String corrAccount = "";    //"Коррсчет"
	String nameContr = "";      //"Наименование контрагента"
	String ground = "";         //"Назначение платежа" 
  //ищем paymentID from PMDOCS.DBT :	
  	fieldIApplicationKey=select.getColumnValueToString(9);
  	getSelectPaymentID().setParameterFromString("KEY",fieldIApplicationKey);
	fieldIApplicationKind=select.getColumnValueToString(8);
  	getSelectPaymentID().setParameterFromString("KIND",fieldIApplicationKind);
  	getSelectPaymentID().execute();
//Thread.currentThread().sleep(50); // NOTE: We hardcode that it will take 0.05 seconds to give a execute

  	if (getSelectPaymentID().getRowCount() != 0) //ключ paymentID найден:
  	  {
  	  	paymentID = getSelectPaymentID().getColumnValueToString(0);
//п.11)В таблице PMPROP.DBT по ключу PaymentID находим bankCode(БИК):
		getSelectBIK().setParameterFromString("PAYMENTID",paymentID);
		getSelectBIK().execute();
		if(getSelectBIK().getRowCount() != 0)
		  bankCode = getSelectBIK().getColumnValueToString(0);
//п.12)В таблице PMPAYM.DBT по PaymentID: ищется "Счет контрагента",
	   //"Дебит"("Кредит")
		getSelectAmount().setParameterFromString("PAYMENTID", paymentID);
		getSelectAmount().execute();
		if(getSelectAmount().getRowCount() != 0)
		  {
			if(is_debit)
			 {
				debit = getSelectAmount().getColumnValueToString(0);
				debitNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);
				accountContr = getSelectAmount().getColumnValueToString(1); 
			 }
			else
			 {
				credit = getSelectAmount().getColumnValueToString(0);
				creditNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);				 
				accountContr = getSelectAmount().getColumnValueToString(2); 				 
			 } 
		  }
//п.13)В таблице PMRMPROP.DBT по ключу PaymentID ищется "Коррсчет" и
		//"Наименование контрагента"
		getSelectCorrAccount().setParameterFromString("PAYMENTID", paymentID);
		getSelectCorrAccount().execute();
		if(getSelectCorrAccount().getRowCount() != 0)
		  {
			 if(is_debit)
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(2);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(3);
			  }
			 else
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(0);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(1);
			  } 
		  }
		//"Назначение платежа" 
		ground = getSelectCorrAccount().getColumnValueToString(4); 
  	  }

  	  
	else //ключ paymentID не найден:
	  {
//п.14)
	//"Коррсчет":
	    fieldCorAcc_Receiver = select.getColumnValueToString(13);
	    fieldCorAcc_Payer = select.getColumnValueToString(14);
//System.out.println("fieldCorAcc_Receiver:" + fieldCorAcc_Receiver);//tmp
//System.out.println("fieldCorAcc_Payer:" + fieldCorAcc_Payer);//tmp		  
	    if(is_debit)
		  corrAccount =fieldCorAcc_Receiver;  //ARHDOC*.CorAcc_Receiver;
		else
		  corrAccount =fieldCorAcc_Payer;     //ARHDOC*.CorAcc_Payer;
	//"БИК"
		fieldKindCode_Payer=select.getColumnValueToString(1);
		fieldKindCode_Receiver=select.getColumnValueToString(4);
		fieldCode_Receiver=select.getColumnValueToString(5);
		fieldCode_Payer=select.getColumnValueToString(2);
//System.out.println("KindCode_Payer:" + fieldKindCode_Payer);//tmp
//System.out.println("KindCode_Receiver:" + fieldKindCode_Receiver);//tmp
		if ( is_debit && (fieldKindCode_Receiver.equals("3")) )
		  bankCode = fieldCode_Receiver;
		else if ( !is_debit && (fieldKindCode_Payer.equals("3")) )
		  bankCode = fieldCode_Payer;
//System.out.println("undo bankCode: " + bankCode);//tmp		  
		if (bankCode.trim() == ""){
			//в противном случае в таблице BANKDPRT.DBT ищется запись,
			//для которой BANKDPRT.CorAcc = "Коррсчет", 
			//и выводится BANKDPRT.CheckData в этой записи;
			getSelectCheckData().setParameterFromString("CORACC",corrAccount);
			getSelectCheckData().execute();
			if(getSelectCheckData().getRowCount()==1)//соответствие с corrAccount???
			  bankCode = getSelectCheckData().getColumnValueToString(0);
			}
//System.out.println("after bankCode: " + bankCode);//tmp		  		
	//"Счет контрагента":
	    fieldAccount_Receiver = select.getColumnValueToString(15);
	    fieldAccount_Payer = select.getColumnValueToString(16);
//System.out.println("Account_Receiver:" + fieldAccount_Receiver);  //tmp
//System.out.println("Account_Payer:" + fieldAccount_Payer);        //tmp	    
	    if(is_debit)
	       accountContr = fieldAccount_Receiver; //ARHDOC*.Account_Receiver;
	    else
	       accountContr = fieldAccount_Payer;    //ARHDOC*.Account_Payer;
	//"Дебет"("Кредит")
	    fieldSum=select.getColumnValueToString(7);
	    if (is_debit){
		  debitNum = (java.math.BigDecimal)select.getColumnValue(7);		    
	      debit = fieldSum;
	    }  
	    else {
	      credit= fieldSum;
	      creditNum=(java.math.BigDecimal)select.getColumnValue(7);	      
	    }  
	//"Наименование контрагента":
	    fieldReceiver=select.getColumnValueToString(11);
	    fieldPayer=select.getColumnValueToString(10);
	    if (is_debit)
	      nameContr = fieldReceiver;
	    else
	      nameContr = fieldPayer;
	//"Назначение платежа" 
	    fieldGround=select.getColumnValueToString(12);
	    ground=fieldGround;
	  }
//System.out.println("count row: "+getSelectPaymentID().getRowCount());

//System.out.println("undo field1");
//	fieldKindCode_Payer=select.getColumnValueToString(1);
//System.out.println("undo field2");	
//	fieldCode_Payer=select.getColumnValueToString(2);
//System.out.println("undo field3");
//	fieldReal_Payer=select.getColumnValueToString(3);
//System.out.println("undo field4");
//	fieldKindCode_Receiver=select.getColumnValueToString(4);
//System.out.println("undo field5");	
//	fieldCode_Receiver=select.getColumnValueToString(5);
//System.out.println("undo field6");
//	fieldReal_Receiver=select.getColumnValueToString(6);
//System.out.println("undo field7");
//	fieldSum=select.getColumnValueToString(7);
//System.out.println("undo field8");	
//	fieldIApplicationKind=select.getColumnValueToString(8);
//System.out.println("undo field9");	
//	fieldIApplicationKey=select.getColumnValueToString(9);
//System.out.println("undo field10");	
//	fieldPayer=select.getColumnValueToString(10);
//System.out.println("undo field11");	
//	fieldReceiver=select.getColumnValueToString(11);
//System.out.println("undo field12");	
//	fieldGround=select.getColumnValueToString(12);

//System.out.println("rest:"+getRest());
		
/*	return	""+index+" Дата:"+fieldDate_Carry+
	         " is_debit:" + is_debit +
	         " paymentID:"+paymentID +
	         " БИК:" + bankCode +
	         " debit:" + debit +
	         " credit:" + credit +
	         " debitNum:" + debitNum +
	         " creditNum:" + creditNum +	         
	         " Счет контрагента:" +accountContr +
	         " Коррсчет:" + corrAccount +
	         " Наименование контрагента:" + nameContr +
	         " Назначение платежа:" + ground;         */
	 return new DocView(fieldDate_Carry, bankCode, corrAccount, nameContr,
	                    accountContr, creditNum, debitNum, ground);	         
  }
  catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
public String getDocView$(int index) {
  try {	
	getSelectDocuments$().setCurrentRow(index);
//п.10)
  //поле ДАТА = fieldDate_Carry
	fieldDate_Carry= (java.util.Date)getSelectDocuments$().getColumnValue(0);
	
  //определяем направление платежа :
	boolean is_debit = false;//направление платежа
	fieldReal_Payer=getSelectDocuments$().getColumnValueToString(3);
	if(getAccount().equals(fieldReal_Payer.trim()+"%"))
	  is_debit = true;  
  //переменные ViewBeance	  	
  	String paymentID="";     //ключ 
	String bankCode ="";     //"БИК" 
	String accountContr = "";//"Счет контрагента"
	String credit = "";      //"Кредит"
	String debit = "";       //"Дебит"
	java.math.BigDecimal creditNum = null;      //"Кредит"
	java.math.BigDecimal debitNum = null;       //"Дебит"
	String corrAccount = ""; //"Коррсчет"
	String nameContr = "";   //"Наименование контрагента"
	String ground = "";      //"Назначение платежа" 
  //ищем paymentID from PMDOCS.DBT :	
  	fieldIApplicationKey=getSelectDocuments$().getColumnValueToString(9);
  	getSelectPaymentID().setParameterFromString("KEY",fieldIApplicationKey);
	fieldIApplicationKind=getSelectDocuments$().getColumnValueToString(8);
  	getSelectPaymentID().setParameterFromString("KIND",fieldIApplicationKind);
  	getSelectPaymentID().execute();
  	if (getSelectPaymentID().getRowCount() != 0)
  	  {
  	  	paymentID = getSelectPaymentID().getColumnValueToString(0);
//п.11)В таблице PMPROP.DBT по ключу PaymentID находим bankCode(БИК):
		getSelectBIK().setParameterFromString("PAYMENTID",paymentID);
		getSelectBIK().execute();
		if(getSelectBIK().getRowCount() != 0)
		  bankCode = getSelectBIK().getColumnValueToString(0);
//п.12)В таблице PMPAYM.DBT по PaymentID: ищется "Счет контрагента",
	   //"Дебит"("Кредит")
		getSelectAmount().setParameterFromString("PAYMENTID", paymentID);
		getSelectAmount().execute();
		if(getSelectAmount().getRowCount() != 0)
		  {
			if(is_debit)
			 {
				debit = getSelectAmount().getColumnValueToString(0);
				debitNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);
				accountContr = getSelectAmount().getColumnValueToString(1); 
			 }
			else
			 {
				credit = getSelectAmount().getColumnValueToString(0);
				creditNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);				 
				accountContr = getSelectAmount().getColumnValueToString(2); 				 
			 } 
		  }
//п.13)	В таблице PMRMPROP.DBT по ключу PaymentID ищется "Коррсчет" и
		//"Наименование контрагента"
		getSelectCorrAccount().setParameterFromString("PAYMENTID", paymentID);
		getSelectCorrAccount().execute();
		if(getSelectCorrAccount().getRowCount() != 0)
		  {
			 if(is_debit)
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(2);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(3);
			  }
			 else
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(0);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(1);
			  } 
		  }
		//"Назначение платежа" 
		ground = getSelectCorrAccount().getColumnValueToString(4); 
  	  }
	else //ключ paymentID не найден:
	  {
//п.14)
	//"Коррсчет":
	    fieldCorAcc_Receiver = getSelectDocuments$().getColumnValueToString(13);
	    fieldCorAcc_Payer = getSelectDocuments$().getColumnValueToString(14);
//System.out.println("fieldCorAcc_Receiver:" + fieldCorAcc_Receiver);//tmp
//System.out.println("fieldCorAcc_Payer:" + fieldCorAcc_Payer);//tmp		  
	    if(is_debit)
		  corrAccount =fieldCorAcc_Receiver;  //ARHDOC*.CorAcc_Receiver;
		else
		  corrAccount =fieldCorAcc_Payer;     //ARHDOC*.CorAcc_Payer;
	//"БИК"
		fieldKindCode_Payer=getSelectDocuments$().getColumnValueToString(1);
		fieldKindCode_Receiver=getSelectDocuments$().getColumnValueToString(4);
		fieldCode_Receiver=getSelectDocuments$().getColumnValueToString(5);
		fieldCode_Payer=getSelectDocuments$().getColumnValueToString(2);
//System.out.println("KindCode_Payer:" + fieldKindCode_Payer);//tmp
//System.out.println("KindCode_Receiver:" + fieldKindCode_Receiver);//tmp
		if ( is_debit && (fieldKindCode_Receiver.equals("3")) )
		  bankCode = fieldCode_Receiver;
		else if ( !is_debit && (fieldKindCode_Payer.equals("3")) )
		  bankCode = fieldCode_Payer;
		else{
			//в противном случае в таблице BANKDPRT.DBT ищется запись,
			//для которой BANKDPRT.CorAcc = "Коррсчет", 
			//и выводится BANKDPRT.CheckData в этой записи;
			getSelectCheckData().setParameterFromString("CORACC",corrAccount);
			getSelectCheckData().execute();
			if(getSelectCheckData().getRowCount()==1)//соответствие с corrAccount???
			  bankCode = getSelectCheckData().getColumnValueToString(0);
			}
	//"Счет контрагента":
	    fieldAccount_Receiver = getSelectDocuments$().getColumnValueToString(15);
	    fieldAccount_Payer = getSelectDocuments$().getColumnValueToString(16);
	    if(is_debit)
	       accountContr = fieldAccount_Receiver; //ARHDOC*.Account_Receiver;
	    else
	       accountContr = fieldAccount_Payer;    //ARHDOC*.Account _Payer;
	//"Дебет"("Кредит")
	    fieldSum=getSelectDocuments$().getColumnValueToString(7);
	    if (is_debit){
		  debitNum = (java.math.BigDecimal)getSelectDocuments$().getColumnValue(7);		    
	      debit = fieldSum;
	    }  
	    else {
	      credit= fieldSum;
	      creditNum=(java.math.BigDecimal)getSelectDocuments$().getColumnValue(7);	      
	    }  
	//"Наименование контрагента":
	    fieldReceiver=getSelectDocuments$().getColumnValueToString(11);
	    fieldPayer=getSelectDocuments$().getColumnValueToString(10);
	    if (is_debit)
	      nameContr = fieldReceiver;
	    else
	      nameContr = fieldPayer;
	//"Назначение платежа" 
	    fieldGround=getSelectDocuments$().getColumnValueToString(12);
	    ground=fieldGround;
	  }
//System.out.println("count row: "+getSelectPaymentID().getRowCount());

//System.out.println("undo field1");
//	fieldKindCode_Payer=getSelectDocuments$().getColumnValueToString(1);
//System.out.println("undo field2");	
//	fieldCode_Payer=getSelectDocuments$().getColumnValueToString(2);
//System.out.println("undo field3");
//	fieldReal_Payer=getSelectDocuments$().getColumnValueToString(3);
//System.out.println("undo field4");
//	fieldKindCode_Receiver=getSelectDocuments$().getColumnValueToString(4);
//System.out.println("undo field5");	
//	fieldCode_Receiver=getSelectDocuments$().getColumnValueToString(5);
//System.out.println("undo field6");
//	fieldReal_Receiver=getSelectDocuments$().getColumnValueToString(6);
//System.out.println("undo field7");
//	fieldSum=getSelectDocuments$().getColumnValueToString(7);
//System.out.println("undo field8");	
//	fieldIApplicationKind=getSelectDocuments$().getColumnValueToString(8);
//System.out.println("undo field9");	
//	fieldIApplicationKey=getSelectDocuments$().getColumnValueToString(9);
//System.out.println("undo field10");	
//	fieldPayer=getSelectDocuments$().getColumnValueToString(10);
//System.out.println("undo field11");	
//	fieldReceiver=getSelectDocuments$().getColumnValueToString(11);
//System.out.println("undo field12");	
//	fieldGround=getSelectDocuments$().getColumnValueToString(12);

//System.out.println("rest:"+getRest());
		
	return	""+index+" Дата:"+fieldDate_Carry+
	         " is_debit:" + is_debit +
	         " paymentID:"+paymentID +
	         " БИК:" + bankCode +
	         " debit:" + debit +
	         " credit:" + credit +
	         " debitNum:" + debitNum +
	         " creditNum:" + creditNum +	         
	         " Счет контрагента:" +accountContr +
	         " Коррсчет:" + corrAccount +
	         " Наименование контрагента:" + nameContr +
	         " Назначение платежа:" + ground;         
//	 return new DocView(fieldDate_Carry, bankCode, corrAccount, nameContr,
//	                    accountContr, creditNum, debitNum, ground);	         
  }
  catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
public String getDocView(int index) {
  try {	
	getSelectDocuments().setCurrentRow(index);
//п.10)
  //поле ДАТА = fieldDate_Carry
	fieldDate_Carry= (java.util.Date)getSelectDocuments().getColumnValue(0);
	
  //определяем направление платежа :
	boolean is_debit = false;//направление платежа
	fieldReal_Payer=getSelectDocuments().getColumnValueToString(3);
	if(getAccount().equals(fieldReal_Payer.trim()+"%"))
	  is_debit = true;  
  //переменные ViewBeance	  	
  	String paymentID="";     //ключ 
	String bankCode ="";     //"БИК" 
	String accountContr = "";//"Счет контрагента"
	String credit = "";      //"Кредит"
	String debit = "";       //"Дебит"
	java.math.BigDecimal creditNum = null;      //"Кредит"
	java.math.BigDecimal debitNum = null;       //"Дебит"
	String corrAccount = ""; //"Коррсчет"
	String nameContr = "";   //"Наименование контрагента"
	String ground = "";      //"Назначение платежа" 
  //ищем paymentID from PMDOCS.DBT :	
  	fieldIApplicationKey=getSelectDocuments().getColumnValueToString(9);
  	getSelectPaymentID().setParameterFromString("KEY",fieldIApplicationKey);
	fieldIApplicationKind=getSelectDocuments().getColumnValueToString(8);
  	getSelectPaymentID().setParameterFromString("KIND",fieldIApplicationKind);
  	getSelectPaymentID().execute();
  	if (getSelectPaymentID().getRowCount() != 0)
  	  {
  	  	paymentID = getSelectPaymentID().getColumnValueToString(0);
//п.11)В таблице PMPROP.DBT по ключу PaymentID находим bankCode(БИК):
		getSelectBIK().setParameterFromString("PAYMENTID",paymentID);
		getSelectBIK().execute();
		if(getSelectBIK().getRowCount() != 0)
		  bankCode = getSelectBIK().getColumnValueToString(0);
//п.12)В таблице PMPAYM.DBT по PaymentID: ищется "Счет контрагента",
	   //"Дебит"("Кредит")
		getSelectAmount().setParameterFromString("PAYMENTID", paymentID);
		getSelectAmount().execute();
		if(getSelectAmount().getRowCount() != 0)
		  {
			if(is_debit)
			 {
				debit = getSelectAmount().getColumnValueToString(0);
				debitNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);
				accountContr = getSelectAmount().getColumnValueToString(1); 
			 }
			else
			 {
				credit = getSelectAmount().getColumnValueToString(0);
				creditNum = (java.math.BigDecimal)getSelectAmount().getColumnValue(0);				 
				accountContr = getSelectAmount().getColumnValueToString(2); 				 
			 } 
		  }
//п.13)	В таблице PMRMPROP.DBT по ключу PaymentID ищется "Коррсчет" и
		//"Наименование контрагента"
		getSelectCorrAccount().setParameterFromString("PAYMENTID", paymentID);
		getSelectCorrAccount().execute();
		if(getSelectCorrAccount().getRowCount() != 0)
		  {
			 if(is_debit)
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(2);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(3);
			  }
			 else
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(0);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(1);
			  } 
		  }
		//"Назначение платежа" 
		ground = getSelectCorrAccount().getColumnValueToString(4); 
  	  }
	else //ключ paymentID не найден:
	  {
//п.14)
	//"Коррсчет":
	    fieldCorAcc_Receiver = getSelectDocuments().getColumnValueToString(13);
	    fieldCorAcc_Payer = getSelectDocuments().getColumnValueToString(14);
//System.out.println("fieldCorAcc_Receiver:" + fieldCorAcc_Receiver);//tmp
//System.out.println("fieldCorAcc_Payer:" + fieldCorAcc_Payer);//tmp		  
	    if(is_debit)
		  corrAccount =fieldCorAcc_Receiver;  //ARHDOC*.CorAcc_Receiver;
		else
		  corrAccount =fieldCorAcc_Payer;     //ARHDOC*.CorAcc_Payer;
	//"БИК"
		fieldKindCode_Payer=getSelectDocuments().getColumnValueToString(1);
		fieldKindCode_Receiver=getSelectDocuments().getColumnValueToString(4);
		fieldCode_Receiver=getSelectDocuments().getColumnValueToString(5);
		fieldCode_Payer=getSelectDocuments().getColumnValueToString(2);
//System.out.println("KindCode_Payer:" + fieldKindCode_Payer);//tmp
//System.out.println("KindCode_Receiver:" + fieldKindCode_Receiver);//tmp
		if ( is_debit && (fieldKindCode_Receiver.equals("3")) )
		  bankCode = fieldCode_Receiver;
		else if ( !is_debit && (fieldKindCode_Payer.equals("3")) )
		  bankCode = fieldCode_Payer;
		else{
			//в противном случае в таблице BANKDPRT.DBT ищется запись,
			//для которой BANKDPRT.CorAcc = "Коррсчет", 
			//и выводится BANKDPRT.CheckData в этой записи;
			getSelectCheckData().setParameterFromString("CORACC",corrAccount);
			getSelectCheckData().execute();
			if(getSelectCheckData().getRowCount()==1)//соответствие с corrAccount???
			  bankCode = getSelectCheckData().getColumnValueToString(0);
			}
	//"Счет контрагента":
	    fieldAccount_Receiver = getSelectDocuments().getColumnValueToString(15);
	    fieldAccount_Payer = getSelectDocuments().getColumnValueToString(16);
	    if(is_debit)
	       accountContr = fieldAccount_Receiver; //ARHDOC*.Account_Receiver;
	    else
	       accountContr = fieldAccount_Payer;    //ARHDOC*.Account _Payer;
	//"Дебет"("Кредит")
	    fieldSum=getSelectDocuments().getColumnValueToString(7);
	    if (is_debit){
		  debitNum = (java.math.BigDecimal)getSelectDocuments().getColumnValue(7);		    
	      debit = fieldSum;
	    }  
	    else {
	      credit= fieldSum;
	      creditNum=(java.math.BigDecimal)getSelectDocuments().getColumnValue(7);	      
	    }  
	//"Наименование контрагента":
	    fieldReceiver=getSelectDocuments().getColumnValueToString(11);
	    fieldPayer=getSelectDocuments().getColumnValueToString(10);
	    if (is_debit)
	      nameContr = fieldReceiver;
	    else
	      nameContr = fieldPayer;
	//"Назначение платежа" 
	    fieldGround=getSelectDocuments().getColumnValueToString(12);
	    ground=fieldGround;
	  }
//System.out.println("count row: "+getSelectPaymentID().getRowCount());

//System.out.println("undo field1");
//	fieldKindCode_Payer=getSelectDocuments().getColumnValueToString(1);
//System.out.println("undo field2");	
//	fieldCode_Payer=getSelectDocuments().getColumnValueToString(2);
//System.out.println("undo field3");
//	fieldReal_Payer=getSelectDocuments().getColumnValueToString(3);
//System.out.println("undo field4");
//	fieldKindCode_Receiver=getSelectDocuments().getColumnValueToString(4);
//System.out.println("undo field5");	
//	fieldCode_Receiver=getSelectDocuments().getColumnValueToString(5);
//System.out.println("undo field6");
//	fieldReal_Receiver=getSelectDocuments().getColumnValueToString(6);
//System.out.println("undo field7");
//	fieldSum=getSelectDocuments().getColumnValueToString(7);
//System.out.println("undo field8");	
//	fieldIApplicationKind=getSelectDocuments().getColumnValueToString(8);
//System.out.println("undo field9");	
//	fieldIApplicationKey=getSelectDocuments().getColumnValueToString(9);
//System.out.println("undo field10");	
//	fieldPayer=getSelectDocuments().getColumnValueToString(10);
//System.out.println("undo field11");	
//	fieldReceiver=getSelectDocuments().getColumnValueToString(11);
//System.out.println("undo field12");	
//	fieldGround=getSelectDocuments().getColumnValueToString(12);

//System.out.println("rest:"+getRest());
		
	return	""+index+" Дата:"+fieldDate_Carry+
	         " is_debit:" + is_debit +
	         " paymentID:"+paymentID +
	         " БИК:" + bankCode +
	         " debit:" + debit +
	         " credit:" + credit +
	         " debitNum:" + debitNum +
	         " creditNum:" + creditNum +	         
	         " Счет контрагента:" +accountContr +
	         " Коррсчет:" + corrAccount +
	         " Наименование контрагента:" + nameContr +
	         " Назначение платежа:" + ground;         
//	 return new DocView(fieldDate_Carry, bankCode, corrAccount, nameContr,
//	                    accountContr, creditNum, debitNum, ground);	         
  }
  catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the ground property (java.lang.String) value.
 * @return The ground property value.
 */
public java.lang.String getGround() {
	return fieldGround;
}
/**
 * Gets the iApplicationKey property (java.lang.String) value.
 * @return The iApplicationKey property value.
 */
public java.lang.String getIApplicationKey() {
	return fieldIApplicationKey;
}
/**
 * Gets the iApplicationKind property (java.lang.String) value.
 * @return The iApplicationKind property value.
 */
public java.lang.String getIApplicationKind() {
	return fieldIApplicationKind;
}
/**
 * Gets the includeDocuments property (java.lang.String) value.
 * @return The includeDocuments property value.
 * @see #setIncludeDocuments
 */
public java.lang.String getIncludeDocuments() {
	return fieldIncludeDocuments;
}
/**
 * Gets the includeRest property (java.lang.String) value.
 * @return The includeRest property value.
 * @see #setIncludeRest
 */
public java.lang.String getIncludeRest() {
	return fieldIncludeRest;
}
/**
 * Gets the kindCode_Payer property (java.lang.String) value.
 * @return The kindCode_Payer property value.
 */
public java.lang.String getKindCode_Payer() {
	return fieldKindCode_Payer;
}
/**
 * Gets the kindCode_Reseiver property (java.lang.String) value.
 * @return The kindCode_Reseiver property value.
 */
public java.lang.String getKindCode_Receiver() {
	return fieldKindCode_Receiver;
}
/**
 * Gets the payer property (java.lang.String) value.
 * @return The payer property value.
 */
public java.lang.String getPayer() {
	return fieldPayer;
}
/**
 * Accessor for the propertyChange field.
 */
protected java.beans.PropertyChangeSupport getPropertyChange() {
	if (propertyChange == null) {
		propertyChange = new java.beans.PropertyChangeSupport(this);
	};
	return propertyChange;
}
/**
 * Gets the real_Payer property (java.lang.String) value.
 * @return The real_Payer property value.
 */
public java.lang.String getReal_Payer() {
	return fieldReal_Payer;
}
/**
 * Gets the real_Receiver property (java.lang.String) value.
 * @return The real_Receiver property value.
 */
public java.lang.String getReal_Receiver() {
	return fieldReal_Receiver;
}
/**
 * Gets the receiver property (java.lang.String) value.
 * @return The receiver property value.
 */
public java.lang.String getReceiver() {
	return fieldReceiver;
}
/**
 * Gets the rest property (java.lang.String) value.
 * @return The rest property value.
 */
public java.lang.String getRest(){
	try {
//	     System.out.println("from getRest:Documentparm0"+getSelectRest().getParameterToString(1));
//	     System.out.println("from getRest:Documentparm1"+getSelectRest().getParameterToString(2));	     	     		     	
//		 getSelectRest().execute();
	     if(getSelectRest().getRowCount() > 0)
	      {
		   getSelectRest().firstRow();
	       fieldRest = getSelectRest().getColumnValueToString(0);
	      } 
	     else
	       fieldRest = "0.0000";
//	     System.out.println("from getRest:Document countROW" + getSelectRest().getRowCount());  
	     return fieldRest;
	}
   catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
	     
}
/**
 * Gets the row property (java.lang.String[]) value.
 * @return The row property value.
 */
public java.lang.String[] getRow() {
	return fieldRow;
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
public java.lang.String getRow(int index) {
  try {	
	getSelectDocuments().setCurrentRow(index);
//System.out.println("undo field0");
	fieldDate_Carry= (java.util.Date)getSelectDocuments().getColumnValue(0);
//System.out.println("undo field1");
	fieldKindCode_Payer=getSelectDocuments().getColumnValueToString(1);
//System.out.println("undo field2");	
	fieldCode_Payer=getSelectDocuments().getColumnValueToString(2);
//System.out.println("undo field3");
	fieldReal_Payer=getSelectDocuments().getColumnValueToString(3);
//System.out.println("undo field4");
	fieldKindCode_Receiver=getSelectDocuments().getColumnValueToString(4);
//System.out.println("undo field5");	
	fieldCode_Receiver=getSelectDocuments().getColumnValueToString(5);
//System.out.println("undo field6");
	fieldReal_Receiver=getSelectDocuments().getColumnValueToString(6);
//System.out.println("undo field7");
	fieldSum=getSelectDocuments().getColumnValueToString(7);
//System.out.println("undo field8");	
	fieldIApplicationKind=getSelectDocuments().getColumnValueToString(8);
//System.out.println("undo field9");	
	fieldIApplicationKey=getSelectDocuments().getColumnValueToString(9);
//System.out.println("undo field10");	
	fieldPayer=getSelectDocuments().getColumnValueToString(10);
//System.out.println("undo field11");	
	fieldReceiver=getSelectDocuments().getColumnValueToString(11);
//System.out.println("undo field12");	
	fieldGround=getSelectDocuments().getColumnValueToString(12);
		
	return ""+index+":"+fieldDate_Carry+";"+fieldReal_Payer+";"+fieldSum+";"+
	       fieldReal_Receiver+":"+fieldKindCode_Payer;
  }
  catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
public java.lang.String getRowView(int index) {
  try {	
	getSelectDocuments().setCurrentRow(index);
//п.10)
  //поле ДАТА = fieldDate_Carry
	fieldDate_Carry= (java.util.Date)getSelectDocuments().getColumnValue(0);
  //определяем направление платежа :
	boolean is_debit = false;//направление платежа
	fieldReal_Payer=getSelectDocuments().getColumnValueToString(3);
	if(getAccount().equals(fieldReal_Payer.trim()+"%"))
	  is_debit = true;  
  //переменные ViewBeance	  	
  	String paymentID="";     //ключ 
	String bankCode ="";     //"БИК" 
	String accountContr = "";//"Счет контрагента"
	String credit = "";      //"Кредит"
	String debit = "";       //"Дебит"
	String corrAccount = ""; //"Коррсчет"
	String nameContr = "";   //"Наименование контрагента"
	String ground = "";      //"Назначение платежа" 
  //ищем paymentID from PMDOCS.DBT :	
  	fieldIApplicationKey=getSelectDocuments().getColumnValueToString(9);
  	getSelectPaymentID().setParameterFromString("KEY",fieldIApplicationKey);
	fieldIApplicationKind=getSelectDocuments().getColumnValueToString(8);
  	getSelectPaymentID().setParameterFromString("KIND",fieldIApplicationKind);
  	getSelectPaymentID().execute();
  	if (getSelectPaymentID().getRowCount() != 0)
  	  {
  	  	paymentID = getSelectPaymentID().getColumnValueToString(0);
//п.11)В таблице PMPROP.DBT по ключу PaymentID находим bankCode(БИК):
		getSelectBIK().setParameterFromString("PAYMENTID",paymentID);
		getSelectBIK().execute();
		if(getSelectBIK().getRowCount() != 0)
		  bankCode = getSelectBIK().getColumnValueToString(0);
//п.12)В таблице PMPAYM.DBT по PaymentID: ищется "Счет контрагента",
	   //"Дебит"("Кредит")
		getSelectAmount().setParameterFromString("PAYMENTID", paymentID);
		getSelectAmount().execute();
		if(getSelectAmount().getRowCount() != 0)
		  {
			if(is_debit)
			 {
				debit = getSelectAmount().getColumnValueToString(0);
				accountContr = getSelectAmount().getColumnValueToString(1); 
			 }
			else
			 {
				credit = getSelectAmount().getColumnValueToString(0); 
				accountContr = getSelectAmount().getColumnValueToString(2); 				 
			 } 
		  }
//п.13)	В таблице PMRMPROP.DBT по ключу PaymentID ищется "Коррсчет" и
		//"Наименование контрагента"
		getSelectCorrAccount().setParameterFromString("PAYMENTID", paymentID);
		getSelectCorrAccount().execute();
		if(getSelectCorrAccount().getRowCount() != 0)
		  {
			 if(is_debit)
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(2);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(3);
			  }
			 else
			  {
				  corrAccount = getSelectCorrAccount().getColumnValueToString(0);
				  nameContr   = getSelectCorrAccount().getColumnValueToString(1);
			  } 
		  }
		//"Назначение платежа" 
		ground = getSelectCorrAccount().getColumnValueToString(4); 
  	  }
	else //ключ paymentID не найден:
	  {
//п.14)
	//"Коррсчет":
	    fieldCorAcc_Receiver = getSelectDocuments().getColumnValueToString(13);
	    fieldCorAcc_Payer = getSelectDocuments().getColumnValueToString(14);
		System.out.println("fieldCorAcc_Receiver:" + fieldCorAcc_Receiver);//tmp
		System.out.println("fieldCorAcc_Payer:" + fieldCorAcc_Payer);//tmp		  
	    if(is_debit)
		  corrAccount =fieldCorAcc_Receiver;  //ARHDOC*.CorAcc_Receiver;
		else
		  corrAccount =fieldCorAcc_Payer;     //ARHDOC*.CorAcc_Payer;
	//"БИК"
		fieldKindCode_Payer=getSelectDocuments().getColumnValueToString(1);
		fieldKindCode_Receiver=getSelectDocuments().getColumnValueToString(4);
		fieldCode_Receiver=getSelectDocuments().getColumnValueToString(5);
		fieldCode_Payer=getSelectDocuments().getColumnValueToString(2);
		System.out.println("KindCode_Payer:" + fieldKindCode_Payer);//tmp
		System.out.println("KindCode_Receiver:" + fieldKindCode_Receiver);//tmp
		if ( is_debit && (fieldKindCode_Receiver.equals("3")) )
		  bankCode = fieldCode_Receiver;
		else if ( !is_debit && (fieldKindCode_Payer.equals("3")) )
		  bankCode = fieldCode_Payer;
		else{
			//в противном случае в таблице BANKDPRT.DBT ищется запись,
			//для которой BANKDPRT.CorAcc = "Коррсчет", 
			//и выводится BANKDPRT.CheckData в этой записи;
			getSelectCheckData().setParameterFromString("CORACC",corrAccount);
			getSelectCheckData().execute();
			if(getSelectCheckData().getRowCount()==1)//соответствие с corrAccount???
			  bankCode = getSelectCheckData().getColumnValueToString(0);
			}
	//"Счет контрагента":
	    fieldAccount_Receiver = getSelectDocuments().getColumnValueToString(15);
	    fieldAccount_Payer = getSelectDocuments().getColumnValueToString(16);
	    if(is_debit)
	       accountContr = fieldAccount_Receiver; //ARHDOC*.Account_Receiver;
	    else
	       accountContr = fieldAccount_Payer;    //ARHDOC*.Account _Payer;
	//"Дебет"("Кредит")
	    fieldSum=getSelectDocuments().getColumnValueToString(7);
	    if (is_debit)
	      debit = fieldSum;
	    else
	      credit= fieldSum;
	//"Наименование контрагента":
	    fieldReceiver=getSelectDocuments().getColumnValueToString(11);
	    fieldPayer=getSelectDocuments().getColumnValueToString(10);
	    if (is_debit)
	      nameContr = fieldReceiver;
	    else
	      nameContr = fieldPayer;
	//"Назначение платежа" 
	    fieldGround=getSelectDocuments().getColumnValueToString(12);
	    ground=fieldGround;
	  }
//System.out.println("count row: "+getSelectPaymentID().getRowCount());

//System.out.println("undo field1");
//	fieldKindCode_Payer=getSelectDocuments().getColumnValueToString(1);
//System.out.println("undo field2");	
//	fieldCode_Payer=getSelectDocuments().getColumnValueToString(2);
//System.out.println("undo field3");
//	fieldReal_Payer=getSelectDocuments().getColumnValueToString(3);
//System.out.println("undo field4");
//	fieldKindCode_Receiver=getSelectDocuments().getColumnValueToString(4);
//System.out.println("undo field5");	
//	fieldCode_Receiver=getSelectDocuments().getColumnValueToString(5);
//System.out.println("undo field6");
//	fieldReal_Receiver=getSelectDocuments().getColumnValueToString(6);
//System.out.println("undo field7");
//	fieldSum=getSelectDocuments().getColumnValueToString(7);
//System.out.println("undo field8");	
//	fieldIApplicationKind=getSelectDocuments().getColumnValueToString(8);
//System.out.println("undo field9");	
//	fieldIApplicationKey=getSelectDocuments().getColumnValueToString(9);
//System.out.println("undo field10");	
//	fieldPayer=getSelectDocuments().getColumnValueToString(10);
//System.out.println("undo field11");	
//	fieldReceiver=getSelectDocuments().getColumnValueToString(11);
//System.out.println("undo field12");	
//	fieldGround=getSelectDocuments().getColumnValueToString(12);

//System.out.println("rest:"+getRest());
		
	return ""+index+" Дата:"+fieldDate_Carry+
	         " is_debit:" + is_debit +
	         " paymentID:"+paymentID +
	         " БИК:" + bankCode +
	         " debit:" + debit +
	         " credit:" + credit +
	         " Счет контрагента:" +accountContr +
	         " Коррсчет:" + corrAccount +
	         " Наименование контрагента:" + nameContr +
	         " Назначение платежа:" + ground;
  }
  catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Return the SelectAmount property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectAmount() {
	if (ivjSelectAmount == null) {
		try {
			ivjSelectAmount = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectAmount.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.SelectAmountSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectAmount;
}
/**
 * Return the SelectBIK property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectBIK() {
	if (ivjSelectBIK == null) {
		try {
			ivjSelectBIK = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectBIK.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.SelectBankCodeSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectBIK;
}
/**
 * Return the SelectCheckData property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectCheckData() {
	if (ivjSelectCheckData == null) {
		try {
			ivjSelectCheckData = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectCheckData.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.SelectCheckDataSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectCheckData;
}
/**
 * Return the SelectCorrAccount property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectCorrAccount() {
	if (ivjSelectCorrAccount == null) {
		try {
			ivjSelectCorrAccount = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectCorrAccount.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.SelectCorrAccountSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectCorrAccount;
}
/**
 * Return the SelectDocuments$ property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectDocuments$() {
	if (ivjSelectDocuments$ == null) {
		try {
			ivjSelectDocuments$ = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectDocuments$.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.SelectDocument$SQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectDocuments$;
}
/**
 * Return the SelectDocuments property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectDocuments() {
	if (ivjSelectDocuments == null) {
		try {
			ivjSelectDocuments = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectDocuments.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.SelectDocumentSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectDocuments;
}
/**
 * Return the SelectPaymentID property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectPaymentID() {
	if (ivjSelectPaymentID == null) {
		try {
			ivjSelectPaymentID = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectPaymentID.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.PaymentIDSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectPaymentID;
}
/**
 * Return the SelectRest property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectRest() {
	if (ivjSelectRest == null) {
		try {
			ivjSelectRest = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectRest.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.DocumentDAB.SelectRestSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectRest;
}
/**
 * Gets the sum property (java.lang.String) value.
 * @return The sum property value.
 */
public java.lang.String getSum() {
	return fieldSum;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * The hasListeners method was generated to support the propertyChange field.
 */
public synchronized boolean hasListeners(java.lang.String propertyName) {
	return getPropertyChange().hasListeners(propertyName);
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	this.addPropertyChangeListener(ivjEventHandler);
	connPtoP1SetTarget();
	connPtoP2SetTarget();
	connPtoP3SetTarget();
	connPtoP4SetTarget();
	connPtoP5SetTarget();
	connPtoP6SetTarget();
	connPtoP7SetTarget();
	connPtoP8SetTarget();
	connPtoP9SetTarget();
	connPtoP10SetTarget();
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		Document aDocument;
		aDocument = new Document();
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of java.lang.Object");
		exception.printStackTrace(System.out);
	}
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 */
public synchronized void removePropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(propertyName, listener);
}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void selectDocumentsExecute() throws com.ibm.db.DataException {
	getSelectDocuments().execute();
//	System.out.println("ay from selectDocumentsExecute");
	fieldRow =new java.lang.String [ getSelectDocuments().getNumRows()];	

}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void selectDocumentsExecute(String code_currency) throws com.ibm.db.DataException {

//	System.out.println("ay from selectDocumentsExecute");
	
	try{
	   com.ibm.ivj.db.uibeans.Select select;
	   fieldAll_Documents = new java.util.Vector(0);

	   if(code_currency.equals("0"))  
	     select = getSelectDocuments();
	   else 
		 select = getSelectDocuments$();
		 
	   fieldRow =new java.lang.String [ select.getNumRows()];	
		
	   select.execute() ;
	   int numrecs  = select.getNumRows();	
	   if (numrecs > 0)
	     select.firstRow();
	   for(int i=0; i< numrecs; i++){ 
		 fieldAll_Documents.add(getDocumView(i, select));   
	   }
//System.out.println("from Document:selectDocumentsExecute fieldAll_Documents.size(): "+fieldAll_Documents.size());	   	
	}  catch(com.ibm.db.DataException exp) {
		System.out.println(exp.toString());
	   }
}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void selectRestExecute() throws com.ibm.db.DataException {
		getSelectRest().execute();
}
/**
 * Sets the account property (java.lang.String) value.
 * @param account The new value for the property.
 * @see #getAccount
 */
public void setAccount(java.lang.String account) {
	
//System.out.println("from setAccount: " + account);//temp

	String oldValue = fieldAccount;
	fieldAccount = account + "%";//исправлено: + "%"
	firePropertyChange("account", oldValue, account+ "%" );//исправлено: + "%"
}
/**
 * Sets the date_Carry property (java.util.Date) value.
 * @param date_Carry The new value for the property.
 * @see #getDate_Carry
 */
public void setDate_Carry(java.util.Date date_Carry) {
	fieldDate_Carry = date_Carry;
}
/**
 * Sets the date1 property (java.util.Date) value.
 * @param date1 The new value for the property.
 * @see #getDate1
 */
public void setDate1(java.util.Date date1) {
	java.util.Date oldValue = fieldDate1;
	fieldDate1 = date1;
	firePropertyChange("date1", oldValue, date1);
}
/**
 * Sets the date1String property (java.lang.String) value.
 * @param date1String The new value for the property.
 * @see #getDate1String
 */
public void setDate1String(java.lang.String date1String) {
	String oldValue = fieldDate1String;
	fieldDate1String = date1String;
	firePropertyChange("date1String", oldValue, date1String);
}
/**
 * Sets the date2 property (java.util.Date) value.
 * @param date2 The new value for the property.
 * @see #getDate2
 */
public void setDate2(java.util.Date date2) {
	java.util.Date oldValue = fieldDate2;
	fieldDate2 = date2;
	firePropertyChange("date2", oldValue, date2);
}
/**
 * Sets the date2String property (java.lang.String) value.
 * @param date2String The new value for the property.
 * @see #getDate2String
 */
public void setDate2String(java.lang.String date2String) {
	String oldValue = fieldDate2String;
	fieldDate2String = date2String;
	firePropertyChange("date2String", oldValue, date2String);
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2001 11:55:19)
 * @param date1 java.util.Date
 * @param date2 java.util.Date
 * @param startDate java.util.Date
 * @param finishDate java.util.Date
 * @param openDate java.util.Date
 */
public String setDates(java.util.Date date1, java.util.Date date2, java.util.Date startDate, java.util.Date finishDate, java.util.Date openDate, java.util.Date closeDate, java.util.Date curDate) {
  String message = null;
  SimpleDateFormat formatter  = new SimpleDateFormat ("yyyy-MM-dd");
  String dateString1 = formatter.format(date1);
  String dateString2 = formatter.format(date2);
 
//System.out.println("date1: "+date1+" date2: "+date2+" startDate: "+startDate+" finishDate: "+finishDate+" openDate: "+openDate+" closeDate: "+closeDate+" curDate:"+curDate);  //tmp

  if(date1.after(date2))
	date1 = date2;
  if(date1.after(curDate))
	date1 = date2 = curDate;
	
  if(date1.before(startDate))
	date1 = startDate;
  if(date1.before(openDate))
	date1 = openDate; 
  if(date1.after(date2))
	message = "Отказано в доступе к указанному счету";	
	 
//  if((finishDate != null)&&(date2.after(finishDate))) //уточнить представление в БД
//	date2 = finishDate; 
  if(date1.after(date2))
	message = "Ошибка целостности данных. Обратитесь к администратору БД";

  dateString1 = formatter.format(date1);
  dateString2 = formatter.format(date2);
  //установка периода дат:
  setDate1String(dateString1);
  setDate2String(dateString2);
  	
//System.out.println(" dateString1: "+dateString1+" dateString2: "+dateString2 + " message: " +message);  //tmp

  return message; 
}
/**
 * Sets the includeDocuments property (java.lang.String) value.
 * @param includeDocuments The new value for the property.
 * @see #getIncludeDocuments
 */
public void setIncludeDocuments(java.lang.String includeDocuments) {
	fieldIncludeDocuments = includeDocuments;
}
/**
 * Sets the includeRest property (java.lang.String) value.
 * @param includeRest The new value for the property.
 * @see #getIncludeRest
 */
public void setIncludeRest(java.lang.String includeRest) {
	fieldIncludeRest = includeRest;
}
}
