package com.overstar.dab;

/**
 * Insert the type's description here.
 * Creation date: (09.07.2001 14:18:17)
 * @author: Shafigullin Ildar
 */
public class EmployeeBean {
	private java.lang.String fieldUsername = new String();
	protected transient java.beans.PropertyChangeSupport propertyChange;
	private java.lang.String fieldNumbill = new String();
	private java.lang.String fieldDateTime = new String();
	private java.lang.String fieldTocompany = new String();
	private java.lang.String fieldSum = new String();
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private com.ibm.ivj.db.uibeans.Select ivjSelect = null;
	private java.lang.String[] fieldRow = null;
	private com.ibm.ivj.db.uibeans.Select ivjSelect1 = null;

class IvjEventHandler implements java.beans.PropertyChangeListener {
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == EmployeeBean.this && (evt.getPropertyName().equals("username"))) 
				connPtoP1SetTarget();
			if (evt.getSource() == EmployeeBean.this.getSelect() && (evt.getPropertyName().equals("BILLS.USERNAME_String"))) 
				connEtoC1(evt);
			if (evt.getSource() == EmployeeBean.this.getSelect() && (evt.getPropertyName().equals("BILLS.NUMBILL_String"))) 
				connEtoC2(evt);
			if (evt.getSource() == EmployeeBean.this.getSelect() && (evt.getPropertyName().equals("BILLS.TOCOMPANY_String"))) 
				connEtoC3(evt);
			if (evt.getSource() == EmployeeBean.this.getSelect() && (evt.getPropertyName().equals("BILLS.DATETIME_String"))) 
				connEtoC4(evt);
			if (evt.getSource() == EmployeeBean.this.getSelect() && (evt.getPropertyName().equals("BILLS.SUM_String"))) 
				connEtoC5(evt);
			if (evt.getSource() == EmployeeBean.this && (evt.getPropertyName().equals("username"))) 
				connPtoP2SetTarget();
		};
	};
/**
 * EmployeeBean constructor comment.
 */
public EmployeeBean() {
	super();
	initialize();
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}
/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void addPropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(propertyName, listener);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2001 12:27:55)
 * @return boolean
 */
public boolean checkPassword(String password) throws com.ibm.db.DataException {
	//System.out.println("password:" + password);
	//System.out.println("parameter:" + getSelect1().getParameter(1));
	getSelect1().execute();
	//System.out.println("post executed : password from Select:" + getSelect1().getColumnValue(0));
	return ( password.equals(getSelect1().getColumnValueToString(0).trim()) );
}
/**
 * connEtoC1:  (Select.BILLS.USERNAME_String --> EmployeeBean.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("selectBILLS.USERNAME_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (Select.BILLS.NUMBILL_String --> EmployeeBean.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("selectBILLS.NUMBILL_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC3:  (Select.BILLS.TOCOMPANY_String --> EmployeeBean.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("selectBILLS.TOCOMPANY_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  (Select.BILLS.DATETIME_String --> EmployeeBean.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("selectBILLS.DATETIME_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (Select.BILLS.SUM_String --> EmployeeBean.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("selectBILLS.SUM_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP1SetTarget:  (EmployeeBean.username <--> Select.Parm_USERNAME_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP1SetTarget() {
	/* Set the target from the source */
	try {
		getSelect().setParameterFromString("USERNAME", this.getUsername());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connPtoP2SetTarget:  (EmployeeBean.username <--> Select1.Parm_USER_NAME_String)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connPtoP2SetTarget() {
	/* Set the target from the source */
	try {
		getSelect1().setParameterFromString("USER_NAME", this.getUsername());
		// user code begin {1}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void execute() throws com.ibm.db.DataException {
	    //System.out.println("undo Select.execute()");
	    //System.out.println("parameter :"  + getSelect().getParameterToString(1));
		getSelect().execute();
		fieldRow =new java.lang.String [ getSelect().getNumRows()];
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param evt java.beans.PropertyChangeEvent
 */
public void firePropertyChange(java.beans.PropertyChangeEvent evt) {
	getPropertyChange().firePropertyChange(evt);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue int
 * @param newValue int
 */
public void firePropertyChange(java.lang.String propertyName, int oldValue, int newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue java.lang.Object
 * @param newValue java.lang.Object
 */
public void firePropertyChange(java.lang.String propertyName, java.lang.Object oldValue, java.lang.Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue boolean
 * @param newValue boolean
 */
public void firePropertyChange(java.lang.String propertyName, boolean oldValue, boolean newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}
/**
 * Gets the dateTime property (java.lang.String) value.
 * @return The dateTime property value.
 */
public java.lang.String getDateTime() {
	return fieldDateTime;
}
/**
 * Gets the numbill property (java.lang.String) value.
 * @return The numbill property value.
 */
public java.lang.String getNumbill() {
	return fieldNumbill;
}
/**
 * Accessor for the propertyChange field.
 * @return java.beans.PropertyChangeSupport
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
		  getSelect().setCurrentRow(index);
		  fieldDateTime =getSelect().getColumnValueToString(2);
		  fieldNumbill =getSelect().getColumnValueToString(1);
		  fieldSum =getSelect().getColumnValueToString(4);
		  fieldTocompany =getSelect().getColumnValueToString(3);
		  fieldUsername =getSelect().getColumnValueToString(0);
		  return fieldUsername+"</td><td>"+fieldDateTime+"</td><td>"
							   +fieldNumbill+"</td><td>"+fieldTocompany
							   +"</td><td>"+fieldSum;
	}
   catch (Exception e){throw new ArrayIndexOutOfBoundsException();}
}
/**
 * Return the Select property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelect() {
	if (ivjSelect == null) {
		try {
			ivjSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.dab.EmployeeDAB.getUser()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelect;
}
/**
 * Return the Select1 property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getSelect1() {
	if (ivjSelect1 == null) {
		try {
			ivjSelect1 = new com.ibm.ivj.db.uibeans.Select();
			ivjSelect1.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.dab.EmployeeDAB.connToAS400(), com.overstar.dab.EmployeeDAB.getPasswordUser()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjSelect1;
}
/**
 * Method generated to support the promotion of the selectBILLS.DATETIME_String attribute.
 * @return java.lang.String
 */
public java.lang.String getSelectBILLSDATETIME_String() {
	return getSelect().getColumnValueToString("BILLS.DATETIME");
}
/**
 * Method generated to support the promotion of the selectBILLS.NUMBILL_String attribute.
 * @return java.lang.String
 */
public java.lang.String getSelectBILLSNUMBILL_String() {
	return getSelect().getColumnValueToString("BILLS.NUMBILL");
}
/**
 * Method generated to support the promotion of the selectBILLS.SUM_String attribute.
 * @return java.lang.String
 */
public java.lang.String getSelectBILLSSUM_String() {
	return getSelect().getColumnValueToString("BILLS.SUM");
}
/**
 * Method generated to support the promotion of the selectBILLS.TOCOMPANY_String attribute.
 * @return java.lang.String
 */
public java.lang.String getSelectBILLSTOCOMPANY_String() {
	return getSelect().getColumnValueToString("BILLS.TOCOMPANY");
}
/**
 * Method generated to support the promotion of the selectBILLS.USERNAME_String attribute.
 * @return java.lang.String
 */
public java.lang.String getSelectBILLSUSERNAME_String() {
	return getSelect().getColumnValueToString("BILLS.USERNAME");
}
/**
 * Method generated to support the promotion of the selectNumRows attribute.
 * @return int
 */
public int getSelectNumRows() {
	return getSelect().getNumRows();
}
/**
 * Gets the sum property (java.lang.String) value.
 * @return The sum property value.
 */
public java.lang.String getSum() {
	return fieldSum;
}
/**
 * Gets the tocompany property (java.lang.String) value.
 * @return The tocompany property value.
 */
public java.lang.String getTocompany() {
	return fieldTocompany;
}
/**
 * Gets the username property (java.lang.String) value.
 * @return The username property value.
 * @see #setUsername
 */
public java.lang.String getUsername() {
	return fieldUsername;
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
 * @return boolean
 * @param propertyName java.lang.String
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
	getSelect().addPropertyChangeListener(ivjEventHandler);
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
		EmployeeBean aEmployeeBean;
		aEmployeeBean = new EmployeeBean();
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of java.lang.Object");
		exception.printStackTrace(System.out);
	}
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}
/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void removePropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(propertyName, listener);
}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void selectFirstRow() throws com.ibm.db.DataException {
		getSelect().firstRow();
}
/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */
public void selectNextRow() throws com.ibm.db.DataException {
		getSelect().nextRow();
}
/**
 * Method generated to support the promotion of the selectBILLS.DATETIME_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */
public void setSelectBILLSDATETIME_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getSelect().setColumnValueFromString("BILLS.DATETIME", arg1);
}
/**
 * Method generated to support the promotion of the selectBILLS.NUMBILL_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */
public void setSelectBILLSNUMBILL_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getSelect().setColumnValueFromString("BILLS.NUMBILL", arg1);
}
/**
 * Method generated to support the promotion of the selectBILLS.SUM_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */
public void setSelectBILLSSUM_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getSelect().setColumnValueFromString("BILLS.SUM", arg1);
}
/**
 * Method generated to support the promotion of the selectBILLS.TOCOMPANY_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */
public void setSelectBILLSTOCOMPANY_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getSelect().setColumnValueFromString("BILLS.TOCOMPANY", arg1);
}
/**
 * Method generated to support the promotion of the selectBILLS.USERNAME_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */
public void setSelectBILLSUSERNAME_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getSelect().setColumnValueFromString("BILLS.USERNAME", arg1);
}
/**
 * Sets the username property (java.lang.String) value.
 * @param username The new value for the property.
 * @see #getUsername
 */
public void setUsername(java.lang.String username) {
	String oldValue = fieldUsername;
	fieldUsername = username;
	firePropertyChange("username", oldValue, username);
}
}
