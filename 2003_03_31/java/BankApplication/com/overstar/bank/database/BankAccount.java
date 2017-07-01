package com.overstar.bank.database;

/**
 * Insert the type's description here.
 * Creation date: (15.08.2001 17:15:31)
 * @author: Shafigullin Ildar
 */
public class BankAccount {
	private java.lang.String fieldAccount = new String();
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private int fieldClient = 0;
	private java.lang.String fieldUserTypeAccount = new String();
	private java.util.Date fieldOpen_Date = new java.util.Date();
	private java.util.Date fieldClose_Date = new java.util.Date();
	private java.lang.String fieldNameAccount = new String();
	private java.lang.String fieldCode_Currency = new String();
	private com.ibm.ivj.db.uibeans.Select ivjSelectAccounts = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private java.lang.String[] fieldRow = null;
	private java.lang.String fieldBalance = new String();
	private com.ibm.ivj.db.uibeans.Select ivjSelectAccounts$ = null;

class IvjEventHandler implements java.beans.PropertyChangeListener {
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == BankAccount.this && (evt.getPropertyName().equals("client"))) 
				connPtoP1SetTarget();
			if (evt.getSource() == BankAccount.this && (evt.getPropertyName().equals("client"))) 
				connPtoP2SetTarget();
		};
	};
	private java.lang.String[] fieldCode = null;
	private Document fieldDocument = new Document();
	private java.lang.String fieldCurrentCodeCurrency = new String();
/**
 * BankAccount constructor comment.
 */
public BankAccount() {
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
 * connPtoP1SetTarget:  (BankAccount.client <--> SelectAccounts.Parm_CLIENT_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP1SetTarget() {
	/* Set the target from the source */
	try {
		getSelectAccounts().setParameterFromString("CLIENT", String.valueOf(this.getClient()));
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP2SetTarget:  (BankAccount.client <--> SelectAccounts$.Parm_CLIENT_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP2SetTarget() {
	/* Set the target from the source */
	try {
		getSelectAccounts$().setParameterFromString("CLIENT", String.valueOf(this.getClient()));
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
 */
public java.lang.String getAccount() {
	return fieldAccount;
}
/**
 * Gets the balance property (java.lang.String) value.
 * @return The balance property value.
 */
public java.lang.String getBalance() {
	return fieldBalance;
}
/**
 * Gets the client property (int) value.
 * @return The client property value.
 * @see #setClient
 */
public int getClient() {
	return fieldClient;
}
/**
 * Gets the close_Date property (java.util.Date) value.
 * @return The close_Date property value.
 */
public java.util.Date getClose_Date() {
	return fieldClose_Date;
}
/**
 * Gets the code property (java.lang.String[]) value.
 * @return The code property value.
 */
public java.lang.String[] getCode() {
	return fieldCode;
}
/**
 * Gets the code index property (java.lang.String) value.
 * @return The code property value.
 * @param index The index value into the property array.
 */
public java.lang.String getCode(int index) {
	return getCode()[index];
}
/**
 * Gets the code_Currency property (java.lang.String) value.
 * @return The code_Currency property value.
 */
public java.lang.String getCode_Currency() {
	return fieldCode_Currency;
}
/**
 * Gets the currentCodeCurrency property (java.lang.String) value.
 * @return The currentCodeCurrency property value.
 * @see #setCurrentCodeCurrency
 */
public java.lang.String getCurrentCodeCurrency() {
	return fieldCurrentCodeCurrency;
}
/**
 * Gets the document property (com.overstar.bank.database.Document) value.
 * @return The document property value.
 */
public Document getDocument() {
	return fieldDocument;
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
public java.lang.String getInfoFull$(int index) {
  try {
	    getSelectAccounts$().setCurrentRow(index);
		fieldAccount =getSelectAccounts$().getColumnValueToString(0);
		fieldClient =((Integer)getSelectAccounts$().getColumnValue(1)).intValue();
		fieldUserTypeAccount =getSelectAccounts$().getColumnValueToString(2);
		fieldOpen_Date =(java.util.Date)getSelectAccounts$().getColumnValue(3);
		fieldClose_Date =(java.util.Date)getSelectAccounts$().getColumnValue(4);
		fieldNameAccount =getSelectAccounts$().getColumnValueToString(5);
		fieldCode_Currency =getSelectAccounts$().getColumnValueToString(6);
		fieldBalance =getSelectAccounts$().getColumnValueToString(7);

		return fieldAccount+"</td><td>"+fieldClient+"</td><td>"+
			   fieldUserTypeAccount+"</td><td>"+fieldOpen_Date+"</td><td>"+
			   fieldClose_Date+"</td><td>"+fieldNameAccount+"</td><td>"+
			   fieldCode_Currency+"</td><td>"+fieldBalance;
}
catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
public java.lang.String getInfoFull(int index) {
  try {
	    getSelectAccounts().setCurrentRow(index);
		fieldAccount =getSelectAccounts().getColumnValueToString(0);
		fieldClient =((Integer)getSelectAccounts().getColumnValue(1)).intValue();
		fieldUserTypeAccount =getSelectAccounts().getColumnValueToString(2);
		fieldOpen_Date =(java.util.Date)getSelectAccounts().getColumnValue(3);
		fieldClose_Date =(java.util.Date)getSelectAccounts().getColumnValue(4);
		fieldNameAccount =getSelectAccounts().getColumnValueToString(5);
		fieldCode_Currency =getSelectAccounts().getColumnValueToString(6);
		fieldBalance =getSelectAccounts().getColumnValueToString(7);

		return fieldAccount+"</td><td>"+fieldClient+"</td><td>"+
			   fieldUserTypeAccount+"</td><td>"+fieldOpen_Date+"</td><td>"+
			   fieldClose_Date+"</td><td>"+fieldNameAccount+"</td><td>"+
			   fieldCode_Currency+"</td><td>"+fieldBalance;
}
catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the nameAccount property (java.lang.String) value.
 * @return The nameAccount property value.
 */
public java.lang.String getNameAccount() {
	return fieldNameAccount;
}
/**
 * Gets the open_Date property (java.util.Date) value.
 * @return The open_Date property value.
 */
public java.util.Date getOpen_Date() {
	return fieldOpen_Date;
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
	    getSelectAccounts().setCurrentRow(index);
		fieldAccount =getSelectAccounts().getColumnValueToString(0);
		fieldClient =((Integer)getSelectAccounts().getColumnValue(1)).intValue();
		fieldUserTypeAccount =getSelectAccounts().getColumnValueToString(2);
		fieldOpen_Date =(java.util.Date)getSelectAccounts().getColumnValue(3);
		fieldClose_Date =(java.util.Date)getSelectAccounts().getColumnValue(4);
		fieldNameAccount =getSelectAccounts().getColumnValueToString(5);
		fieldCode_Currency =getSelectAccounts().getColumnValueToString(6);
		fieldBalance =getSelectAccounts().getColumnValueToString(7);
//		fieldRow[index] = ":" + fieldAccount + " : " + fieldNameAccount;
		return fieldAccount+"</td><td>"+fieldClient+"</td><td>"+
			   fieldUserTypeAccount+"</td><td>"+fieldOpen_Date+"</td><td>"+
			   fieldClose_Date+"</td><td>"+fieldNameAccount+"</td><td>"+
			   fieldCode_Currency+"</td><td>"+fieldBalance;
}
catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Return the SelectAccounts$ property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectAccounts$() {
	if (ivjSelectAccounts$ == null) {
		try {
			ivjSelectAccounts$ = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectAccounts$.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.BankAccountDAB.SelectAccounts$SQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectAccounts$;
}
/**
 * Return the SelectAccounts property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectAccounts() {
	if (ivjSelectAccounts == null) {
		try {
			ivjSelectAccounts = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectAccounts.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.BankAccountDAB.SelectAccountsSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectAccounts;
}
/**
 * Gets the userTypeAccount property (java.lang.String) value.
 * @return The userTypeAccount property value.
 */
public java.lang.String getUserTypeAccount() {
	return fieldUserTypeAccount;
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
 * Gets the row index property (java.lang.String) value.
 * @return The row property value.
 * @param index The index value into the property array.
 */
public java.lang.String initAccount(String account) {
  try {
	    com.ibm.ivj.db.uibeans.Select select;
	    if(getCurrentCodeCurrency().equals("0"))
	       select = getSelectAccounts();
	    else
	       select = getSelectAccounts$();
		int countRow  = select.getNumRows();   
	    for(int i=0; i<countRow; i++) {
		  select.setCurrentRow(i);  
	      fieldAccount =select.getColumnValueToString(0);		    
		  if(account.equals(fieldAccount.trim()))
		   {
		    //fieldAccount =select.getColumnValueToString(0);
			fieldClient =((Integer)select.getColumnValue(1)).intValue();
		    fieldUserTypeAccount =select.getColumnValueToString(2);
		    fieldOpen_Date =(java.util.Date)select.getColumnValue(3);
		    fieldClose_Date =(java.util.Date)select.getColumnValue(4);
		    fieldNameAccount =select.getColumnValueToString(5);
		    fieldCode_Currency =select.getColumnValueToString(6);
		    fieldBalance =select.getColumnValueToString(7);
// System.out.println("initAccount sycsessfull");
		    break;
		   }
	    }   
		return fieldAccount+"</td><td>"+fieldClient+"</td><td>"+
			   fieldUserTypeAccount+"</td><td>"+fieldOpen_Date+"</td><td>"+
			   fieldClose_Date+"</td><td>"+fieldNameAccount+"</td><td>"+
			   fieldCode_Currency+"</td><td>"+fieldBalance;
}
catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
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
		BankAccount aBankAccount;
		aBankAccount = new BankAccount();
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
public void selectAccountsExecute() throws com.ibm.db.DataException {
		getSelectAccounts().execute();
		getSelectAccounts$().execute();
		fieldRow =new java.lang.String [ getSelectAccounts().getNumRows()];
}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void selectAccountsExecute(String code_currency) throws com.ibm.db.DataException {
		//getSelectAccounts().execute();
		//getSelectAccounts$().execute();
		//fieldRow =new java.lang.String [ getSelectAccounts().getNumRows()];
//запись кода валюты:
	setCurrentCodeCurrency(code_currency);	

// заполняем списки account по code_Currency:
  try{
	java.util.Vector allaccts = new java.util.Vector(0);
	java.util.Vector all_code = new java.util.Vector(0);
	com.ibm.ivj.db.uibeans.Select select;
//проверка счетов:		
	select = getSelectAccounts();
	select.execute();
	int numrecs  = select.getNumRows();
//System.out.println("Count row:" + numrecs);	//temp!!!
//	if (numrecs <= 0){ 
//		throw new AccountNotFoundException("No accounts were found.");
//	}
	if (numrecs > 0)
	  select.firstRow();
	for(int i=0; i< numrecs; i++){
			fieldAccount =select.getColumnValueToString(0);
			fieldCode_Currency =select.getColumnValueToString(6);
//System.out.print("fieldAccount:" + fieldAccount);//temp!!!
//System.out.println(" fieldCode_Currency:" + fieldCode_Currency);//temp!!!	
			if(fieldCode_Currency.equals(code_currency)) {
			   allaccts.addElement(fieldAccount);	            
	          }
			
			if(!all_code.contains(fieldCode_Currency)) {
			   all_code.addElement(fieldCode_Currency);	            
	          }
			
			select.nextRow();
	}
//проверка валютных счетов:
	select = getSelectAccounts$();
	select.execute();
	int numcode  = select.getNumRows();
//System.out.println("Count row$:" + numcode);//temp!!!
	if(numcode > 0)
	  select.firstRow();
	for(int i=0; i< numcode; i++){
			fieldAccount =select.getColumnValueToString(0);
			fieldCode_Currency =select.getColumnValueToString(6);
//System.out.print("fieldAccount:" + fieldAccount);//temp!!!
//System.out.println(" fieldCode_Currency:" + fieldCode_Currency);//temp!!!
			if(fieldCode_Currency.equals(code_currency)) {
			   allaccts.addElement(fieldAccount);	            
	          }
			
			if(!all_code.contains(fieldCode_Currency)) {
			   all_code.addElement(fieldCode_Currency);	            
	          }
			
			select.nextRow();
	}
//считывание содержимых векторов(init property[]):		
	fieldRow =new java.lang.String [ allaccts.size()];
	for (int i=0; i<allaccts.size(); i++) {
	  fieldRow[i] = (String)allaccts.elementAt(i);
	}  
	 
	fieldCode =new java.lang.String [ all_code.size()];
	for (int i=0; i<all_code.size(); i++) {
	  fieldCode[i] = (String)all_code.elementAt(i);	
	}

  }  catch(com.ibm.db.DataException exp){
		//throw new PersistenceException(exp.toString());
	 }
}
	
/**
 * Sets the client property (int) value.
 * @param client The new value for the property.
 * @see #getClient
 */
public void setClient(int client) {
	int oldValue = fieldClient;
	fieldClient = client;
	firePropertyChange("client", new Integer(oldValue), new Integer(client));
}
/**
 * Sets the currentCodeCurrency property (java.lang.String) value.
 * @param currentCodeCurrency The new value for the property.
 * @see #getCurrentCodeCurrency
 */
public void setCurrentCodeCurrency(java.lang.String currentCodeCurrency) {
	fieldCurrentCodeCurrency = currentCodeCurrency;
}
}
