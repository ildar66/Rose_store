package com.overstar.bank.atm.database;

/**
 * Insert the type's description here.
 * Creation date: (12/7/00 4:39:10 PM)
 * @author: 
 */
public class BankAccountData {
	private com.ibm.ivj.db.uibeans.Select ivjAccountSelect = null;
	private com.ibm.ivj.db.uibeans.Modify ivjAccountUpdate = null;
	private com.ibm.ivj.db.uibeans.Modify ivjAccountInsert = null;
	private com.ibm.ivj.db.uibeans.Select ivjAccountSelectAll = null;
/**
 * AccountData constructor comment.
 */
public BankAccountData() {
	super();
	initialize();
}
/**
 * Return the AccountInsert property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getAccountInsert() {
	if (ivjAccountInsert == null) {
		try {
			ivjAccountInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjAccountInsert.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.BankAccountDAB.conn1(), com.overstar.bank.atm.database.BankAccountDAB.AccountInsertSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccountInsert;
}

/**
 * Insert the method's description here.
 * Creation date: (12/7/00 5:21:23 PM)
 * @return com.ibm.ivj.db.uibeans.Select
 */
com.ibm.ivj.db.uibeans.Modify getAccountInsert_W() {
	return getAccountInsert();
}
/**
 * Return the AccountSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getAccountSelect() {
	if (ivjAccountSelect == null) {
		try {
			ivjAccountSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjAccountSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.BankAccountDAB.conn1(), com.overstar.bank.atm.database.BankAccountDAB.AccountSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccountSelect;
}

/**
 * Insert the method's description here.
 * Creation date: (12/7/00 5:21:23 PM)
 * @return com.ibm.ivj.db.uibeans.Select
 */
com.ibm.ivj.db.uibeans.Select getAccountSelect_W() {
	return getAccountSelect();
}
/**
 * Return the AccountSelectAll property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getAccountSelectAll() {
	if (ivjAccountSelectAll == null) {
		try {
			ivjAccountSelectAll = new com.ibm.ivj.db.uibeans.Select();
			ivjAccountSelectAll.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.BankAccountDAB.conn1(), com.overstar.bank.atm.database.BankAccountDAB.AccountSelectAllSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccountSelectAll;
}

/**
 * Insert the method's description here.
 * Creation date: (12/7/00 5:21:23 PM)
 * @return com.ibm.ivj.db.uibeans.Select
 */
com.ibm.ivj.db.uibeans.Select getAccountSelectAll_W() {
	return getAccountSelectAll();
}
/**
 * Return the AccountModify property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getAccountUpdate() {
	if (ivjAccountUpdate == null) {
		try {
			ivjAccountUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjAccountUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.BankAccountDAB.conn1(), com.overstar.bank.atm.database.BankAccountDAB.AccountUpdateSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjAccountUpdate;
}

/**
 * Insert the method's description here.
 * Creation date: (12/7/00 5:21:23 PM)
 * @return com.ibm.ivj.db.uibeans.Select
 */
com.ibm.ivj.db.uibeans.Modify getAccountUpdate_W() {
	return getAccountUpdate();
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
		BankAccountData aAccountData;
		aAccountData = new BankAccountData();
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of java.lang.Object");
		exception.printStackTrace(System.out);
	}
}
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private com.ibm.ivj.db.uibeans.Select ivjTransactionsSelect = null;
	protected transient java.beans.PropertyChangeSupport propertyChange;
	
	class IvjEventHandler implements java.beans.PropertyChangeListener {
		public void propertyChange(java.beans.PropertyChangeEvent evt) {
			if (evt.getSource() == BankAccountData.this.getTransactionsSelect() && (evt.getPropertyName().equals("TRANS.SRC_ACT_String"))) 
				connEtoC1(evt);
			if (evt.getSource() == BankAccountData.this.getTransactionsSelect() && (evt.getPropertyName().equals("TRANS.AMOUNT_String"))) 
				connEtoC2(evt);
			if (evt.getSource() == BankAccountData.this.getTransactionsSelect() && (evt.getPropertyName().equals("TRANS.REF_NUM_String"))) 
				connEtoC3(evt);
			if (evt.getSource() == BankAccountData.this.getTransactionsSelect() && (evt.getPropertyName().equals("TRANS.TGT_ACT_String"))) 
				connEtoC4(evt);
			if (evt.getSource() == BankAccountData.this.getTransactionsSelect() && (evt.getPropertyName().equals("TRANS.TMESTAMP_String"))) 
				connEtoC5(evt);
		};
	}/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */
public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(listener);
}/**
 * The addPropertyChangeListener method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param listener java.beans.PropertyChangeListener
 */ 
public synchronized void addPropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().addPropertyChangeListener(propertyName, listener);
}/**
 * connEtoC1:  (TransactionsSelect.TRANS.SRC_ACT_String --> BankAccountData.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */ 
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("transactionsSelectTRANS.SRC_ACT_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}/**
 * connEtoC2:  (TransactionsSelect.TRANS.AMOUNT_String --> BankAccountData.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */ 
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("transactionsSelectTRANS.AMOUNT_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}/**
 * connEtoC3:  (TransactionsSelect.TRANS.REF_NUM_String --> BankAccountData.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */ 
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC3(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("transactionsSelectTRANS.REF_NUM_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}/**
 * connEtoC4:  (TransactionsSelect.TRANS.TGT_ACT_String --> BankAccountData.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */ 
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("transactionsSelectTRANS.TGT_ACT_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}/**
 * connEtoC5:  (TransactionsSelect.TRANS.TMESTAMP_String --> BankAccountData.firePropertyChange(Ljava.lang.String;Ljava.lang.Object;Ljava.lang.Object;)V)
 * @param arg1 java.beans.PropertyChangeEvent
 */ 
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.beans.PropertyChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.firePropertyChange("transactionsSelectTRANS.TMESTAMP_String", arg1.getOldValue(), arg1.getNewValue());
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param evt java.beans.PropertyChangeEvent
 */ 
public void firePropertyChange(java.beans.PropertyChangeEvent evt) {
	getPropertyChange().firePropertyChange(evt);
}/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue int
 * @param newValue int
 */ 
public void firePropertyChange(java.lang.String propertyName, int oldValue, int newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue java.lang.Object
 * @param newValue java.lang.Object
 */ 
public void firePropertyChange(java.lang.String propertyName, java.lang.Object oldValue, java.lang.Object newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}/**
 * The firePropertyChange method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param oldValue boolean
 * @param newValue boolean
 */ 
public void firePropertyChange(java.lang.String propertyName, boolean oldValue, boolean newValue) {
	getPropertyChange().firePropertyChange(propertyName, oldValue, newValue);
}/**
 * Accessor for the propertyChange field.
 * @return java.beans.PropertyChangeSupport
 */ 
protected java.beans.PropertyChangeSupport getPropertyChange() {
	if (propertyChange == null) {
		propertyChange = new java.beans.PropertyChangeSupport(this);
	};
	return propertyChange;
}/**
 * Return the TransactionsSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */ 
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getTransactionsSelect() {
	if (ivjTransactionsSelect == null) {
		try {
			ivjTransactionsSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjTransactionsSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(com.overstar.bank.atm.database.BankAccountDAB.conn1(), com.overstar.bank.atm.database.BankAccountDAB.TransactionsSelectSQL()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTransactionsSelect;
}/**
 * Insert the method's description here.
 * Creation date: (12/7/00 5:21:23 PM)
 * @return com.ibm.ivj.db.uibeans.Select
 */ 
com.ibm.ivj.db.uibeans.Select getTransactionsSelect_W() {
	return getTransactionsSelect();
}/**
 * Method generated to support the promotion of the transactionsSelectParm_SRC_ACT_String attribute.
 * @return java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */ 
public java.lang.String getTransactionsSelectParm_SRC_ACT_String() throws com.ibm.db.DataException {
	return getTransactionsSelect().getParameterToString("SRC_ACT");
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.AMOUNT_String attribute.
 * @return java.lang.String
 */ 
public java.lang.String getTransactionsSelectTRANSAMOUNT_String() {
	return getTransactionsSelect().getColumnValueToString("TRANS.AMOUNT");
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.REF_NUM_String attribute.
 * @return java.lang.String
 */ 
public java.lang.String getTransactionsSelectTRANSREF_NUM_String() {
	return getTransactionsSelect().getColumnValueToString("TRANS.REF_NUM");
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.SRC_ACT_String attribute.
 * @return java.lang.String
 */ 
public java.lang.String getTransactionsSelectTRANSSRC_ACT_String() {
	return getTransactionsSelect().getColumnValueToString("TRANS.SRC_ACT");
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.TGT_ACT_String attribute.
 * @return java.lang.String
 */ 
public java.lang.String getTransactionsSelectTRANSTGT_ACT_String() {
	return getTransactionsSelect().getColumnValueToString("TRANS.TGT_ACT");
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.TMESTAMP_String attribute.
 * @return java.lang.String
 */ 
public java.lang.String getTransactionsSelectTRANSTMESTAMP_String() {
	return getTransactionsSelect().getColumnValueToString("TRANS.TMESTAMP");
}/**
 * The hasListeners method was generated to support the propertyChange field.
 * @return boolean
 * @param propertyName java.lang.String
 */ 
public synchronized boolean hasListeners(java.lang.String propertyName) {
	return getPropertyChange().hasListeners(propertyName);
}/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */ 
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getTransactionsSelect().addPropertyChangeListener(ivjEventHandler);
}/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param listener java.beans.PropertyChangeListener
 */ 
public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(listener);
}/**
 * The removePropertyChangeListener method was generated to support the propertyChange field.
 * @param propertyName java.lang.String
 * @param listener java.beans.PropertyChangeListener
 */ 
public synchronized void removePropertyChangeListener(java.lang.String propertyName, java.beans.PropertyChangeListener listener) {
	getPropertyChange().removePropertyChangeListener(propertyName, listener);
}/**
 * Method generated to support the promotion of the transactionsSelectParm_SRC_ACT_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void setTransactionsSelectParm_SRC_ACT_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getTransactionsSelect().setParameterFromString("SRC_ACT", arg1);
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.AMOUNT_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void setTransactionsSelectTRANSAMOUNT_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getTransactionsSelect().setColumnValueFromString("TRANS.AMOUNT", arg1);
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.REF_NUM_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void setTransactionsSelectTRANSREF_NUM_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getTransactionsSelect().setColumnValueFromString("TRANS.REF_NUM", arg1);
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.SRC_ACT_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void setTransactionsSelectTRANSSRC_ACT_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getTransactionsSelect().setColumnValueFromString("TRANS.SRC_ACT", arg1);
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.TGT_ACT_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void setTransactionsSelectTRANSTGT_ACT_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getTransactionsSelect().setColumnValueFromString("TRANS.TGT_ACT", arg1);
}/**
 * Method generated to support the promotion of the transactionsSelectTRANS.TMESTAMP_String attribute.
 * @param arg1 java.lang.String
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void setTransactionsSelectTRANSTMESTAMP_String(java.lang.String arg1) throws com.ibm.db.DataException {
	getTransactionsSelect().setColumnValueFromString("TRANS.TMESTAMP", arg1);
}/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void transactionsSelectExecute() throws com.ibm.db.DataException {
		getTransactionsSelect().execute();
}/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void transactionsSelectFirstRow() throws com.ibm.db.DataException {
		getTransactionsSelect().firstRow();
}/**
 * 
 * @exception com.ibm.db.DataException The exception description.
 */ 
public void transactionsSelectNextRow() throws com.ibm.db.DataException {
		getTransactionsSelect().nextRow();
};
}