package com.overstar.bank.database;

/**
 * Insert the type's description here.
 * Creation date: (10.08.2001 15:51:50)
 * @author: Shafigullin Ildar
 */
public class IClient {
	private int fieldPartyID = 0;
	private java.lang.String fieldName = new String();
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private java.lang.String fieldPassword = new String();
	private com.ibm.ivj.db.uibeans.Select ivjSelectIClient = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private java.lang.String[] fieldRow = null;
	private int fieldRowCount = 0;
	private BankAccount fieldBankAccount = new BankAccount();
	private com.ibm.ivj.db.uibeans.Select ivjSelectCurdate = null;
	private java.lang.String fieldCurdate = new String();
	private com.ibm.ivj.db.uibeans.Select ivjSelectClientInfo = null;
	private java.util.Date fieldStartDate = new java.util.Date();
	private java.util.Date fieldFinishDate = new java.util.Date();

class IvjEventHandler implements com.ibm.ivj.db.uibeans.DataAfterListener, java.beans.PropertyChangeListener {
		public void addedNewRow(com.ibm.db.DataEvent arg1) {};
		public void cacheRowsChanged(com.ibm.db.DataEvent arg1) {};
		public void closed(com.ibm.db.DataEvent arg1) {};
		public void committed(com.ibm.db.DataEvent arg1) {};
		public void connected(com.ibm.db.DataEvent arg1) {};
		public void deletedRow(com.ibm.db.DataEvent arg1) {};
		public void disconnected(com.ibm.db.DataEvent arg1) {};
		public void executed(com.ibm.db.DataEvent arg1) {
			if (arg1.getSource() == IClient.this.getSelectCurdate()) 
				connEtoM1(arg1);
		};
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == IClient.this && (evt.getPropertyName().equals("name"))) 
				connPtoP1SetTarget();
		};
		public void rolledBack(com.ibm.db.DataEvent arg1) {};
		public void updatedRow(com.ibm.db.DataEvent arg1) {};
	};
/**
 * IClient constructor comment.
 */
public IClient() {
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
 * Insert the method's description here.
 * Creation date: (15.08.2001 13:17:53)
 */
public boolean checkPassword() throws com.ibm.db.DataException {
	//System.out.println("password:" + password);
	//System.out.println("parameter:" + getSelect1().getParameter(1));
	//getSelect1().execute();
	//System.out.println("post executed : password from Select:" + getSelect1().getColumnValue(0));
	return (getPassword().equals(getSelectIClient().getColumnValueToString(2).trim()) );
}
/**
 * connEtoM1:  (SelectCurdate.dataAfter.executed(com.ibm.db.DataEvent) --> IClient.curdate)
 * @param arg1 com.ibm.db.DataEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoM1(com.ibm.db.DataEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.setCurdate(getSelectCurdate().getColumnValueToString("CURDATE.CURDATE"));
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP1SetTarget:  (IClient.name <--> SelectIClient.Parm_NAME_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP1SetTarget() {
	/* Set the target from the source */
	try {
		getSelectIClient().setParameterFromString("NAME", this.getName());
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
 * Gets the bankAccount property (com.overstar.bank.database.BankAccount) value.
 * @return The bankAccount property value.
 */
public BankAccount getBankAccount() {
	return fieldBankAccount;
}
/**
 * Gets the curdate property (java.lang.String) value.
 * @return The curdate property value.
 * @see #setCurdate
 */
public java.lang.String getCurdate() {
	return fieldCurdate;
}
/**
 * Gets the finishDate property (java.util.Date) value.
 * @return The finishDate property value.
 */
public java.util.Date getFinishDate() {
	return fieldFinishDate;
}
/**
 * Gets the name property (java.lang.String) value.
 * @return The name property value.
 * @see #setName
 */
public java.lang.String getName() {
	return fieldName;
}
/**
 * Gets the partyID property (int) value.
 * @return The partyID property value.
 */
public int getPartyID() {
	return fieldPartyID;
}
/**
 * Gets the password property (java.lang.String) value.
 * @return The password property value.
 * @see #setPassword
 */
public java.lang.String getPassword() {
	return fieldPassword;
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
		 getSelectIClient().setCurrentRow(index);
		 fieldName =getSelectIClient().getColumnValueToString(0);
		 fieldPartyID =((Integer)getSelectIClient().getColumnValue(1)).intValue();
		 fieldPassword =getSelectIClient().getColumnValueToString(2);
		 return fieldName+"</td><td>"+fieldPartyID+"</td><td>"+fieldPassword+"</td>";
}
catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Gets the rowCount property (int) value.
 * @return The rowCount property value.
 */
public int getRowCount() {
	return fieldRowCount;
}
/**
 * Return the SelectClient property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectClientInfo() {
	if (ivjSelectClientInfo == null) {
		try {
			ivjSelectClientInfo = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectClientInfo.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.IClientDAB.SelectClientInfoSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectClientInfo;
}
/**
 * Return the SelectCurdate property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectCurdate() {
	if (ivjSelectCurdate == null) {
		try {
			ivjSelectCurdate = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectCurdate.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.IClientDAB.SelectCurdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectCurdate;
}
/**
 * Return the Select1 property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelectIClient() {
	if (ivjSelectIClient == null) {
		try {
			ivjSelectIClient = new com.ibm.ivj.db.uibeans.Select();
			ivjSelectIClient.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.bank.database.IClientDAB.SelectIClientSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelectIClient;
}
/**
 * Gets the startDate property (java.util.Date) value.
 * @return The startDate property value.
 */
public java.util.Date getStartDate() {
	return fieldStartDate;
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
 * Insert the method's description here.
 * Creation date: (06.09.2001 10:00:07)
 */
public void initClient() {
	try {
//System.out.println("initClient fieldPartyID: " + fieldPartyID);//temp		
//System.out.println("initClient partyID: " + getSelectClientInfo().getParameter(1));//temp	
	  getSelectClientInfo().setParameterFromString(1, String.valueOf(fieldPartyID));	
	  getSelectClientInfo().execute();
	  fieldStartDate = (java.util.Date)getSelectClientInfo().getColumnValue(1);
	  fieldFinishDate = (java.util.Date)getSelectClientInfo().getColumnValue(2);
//System.out.println("initClient: " + fieldStartDate +" ; "+ fieldFinishDate);//temp	  
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
	getSelectCurdate().addDataAfterListener(ivjEventHandler);
	connPtoP1SetTarget();
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
		IClient aIClient;
		aIClient = new IClient();
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
public void selectCurdateExecute() throws com.ibm.db.DataException {
		getSelectCurdate().execute();
//System.out.println("cUrdate:" + getCurdate());//temp
}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void selectIClientExecute() throws com.ibm.db.DataException {
		getSelectIClient().execute();
		fieldRowCount=getSelectIClient().getNumRows();
		fieldRow =new java.lang.String [ getRowCount() ];
		if(getRowCount()==1)
		   fieldPartyID =((Integer)getSelectIClient().getColumnValue(1)).intValue();
		//fieldRow =new java.lang.String [ getSelectIClient().getNumRows() ];
}
/**
 * Sets the curdate property (java.lang.String) value.
 * @param curdate The new value for the property.
 * @see #getCurdate
 */
public void setCurdate(java.lang.String curdate) {
	fieldCurdate = curdate;
}
/**
 * Sets the name property (java.lang.String) value.
 * @param name The new value for the property.
 * @see #getName
 */
public void setName(java.lang.String name) {
	String oldValue = fieldName;
	fieldName = name;
	firePropertyChange("name", oldValue, name);
}
/**
 * Sets the password property (java.lang.String) value.
 * @param password The new value for the property.
 * @see #getPassword
 */
public void setPassword(java.lang.String password) {
	String oldValue = fieldPassword;
	fieldPassword = password;
	firePropertyChange("password", oldValue, password);
}
}
