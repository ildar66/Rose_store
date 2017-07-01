package com.overstar.bank.atm;

/**
 * Insert the type's description here.
 * Creation date: (12/5/00 2:50:20 PM)
 * @author: 
 */

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
 
public class CreateTablesBank {
	private static Connection con = null;  

/**
 * Insert the method's description here.
 * Creation date: (12/5/00 2:51:18 PM)
 */
public static void createAcctTable() throws Exception {
	
	Statement stmt= null;
	String crttablestr="create table OSAMURS2.ACCNTS " +
						"(ACCT_NUM VARCHAR(32) NOT NULL, " +
						"BALANCE INTEGER NOT NULL , " +
						"CTYPE VARCHAR(100) NOT NULL , " +
						"OVRDRAFT INTEGER , " +
						"MINBALANCE INTEGER , " +
						"INITCASH INTEGER , " +
						"PRIMARY KEY (ACCT_NUM)  )";

	String deltablestr="drop table OSAMURS2.ACCNTS ";
	String insertstr1 = "INSERT INTO OSAMURS2.ACCNTS (ACCT_NUM, BALANCE, CTYPE, OVRDRAFT)" +
						"VALUES ('11111' , 200, 'CheckingAccount', -300)";
						
	String insertstr2 = "INSERT INTO OSAMURS2.ACCNTS (ACCT_NUM, BALANCE, CTYPE, MINBALANCE )" +
						"VALUES ('22222' , 500, 'SavingsAccount', 200)";	
	
	String insertstr3 = "INSERT INTO OSAMURS2.ACCNTS (ACCT_NUM, BALANCE, CTYPE, INITCASH )" +
						"VALUES ('123' , 0, 'ATMAccount', 5000)";
							
	stmt = con.createStatement();

	try{
		// If ACCNTS table exists, delete it.
		stmt.executeUpdate(deltablestr);
	}
	catch(Exception exp){
		System.out.println(exp);
	}
	stmt.executeUpdate(crttablestr);
	//add some records to the table.
	stmt.executeUpdate(insertstr1);
	stmt.executeUpdate(insertstr2);
	stmt.executeUpdate(insertstr3);
	stmt.close();
	}
/**
 * Insert the method's description here.
 * Creation date: (12/5/00 2:51:18 PM)
 */
public static void createCardAccntTable() throws Exception {
	
	Statement stmt= null;
	String crttablestr="create table OSAMURS2.CARDACCT " +
						"(CARD_NUM VARCHAR(32) NOT NULL, " +
						"ACCT_NUM VARCHAR(32) NOT NULL, " +
						"PRIMARY KEY (CARD_NUM , ACCT_NUM)  )";

	String deltablestr="drop table OSAMURS2.CARDACCT ";
	String insertstr1 = "INSERT INTO OSAMURS2.CARDACCT (CARD_NUM , ACCT_NUM )" +
						"VALUES ('123', '11111')";
						
	String insertstr2 = "INSERT INTO OSAMURS2.CARDACCT (CARD_NUM , ACCT_NUM )" +
						"VALUES ('123', '22222')";
	String insertstr3 = "INSERT INTO OSAMURS2.CARDACCT (CARD_NUM , ACCT_NUM )" +
						"VALUES ('124', '22222')";	
	

	stmt = con.createStatement();

	try{
		// If ACCNTS table exists, delete it.
		stmt.executeUpdate(deltablestr);
	}
	catch(Exception exp){
		System.out.println(exp);
	}
	stmt.executeUpdate(crttablestr);
	stmt.executeUpdate(insertstr1);
	stmt.executeUpdate(insertstr2);
	stmt.executeUpdate(insertstr3);
	stmt.close();
	}
/**
 * Insert the method's description here.
 * Creation date: (12/5/00 2:51:18 PM)
 */
public static void createCardTable() throws Exception {
	
	Statement stmt= null;
	String crttablestr="create table OSAMURS2.CARDS " +
						"(CARD_NUM VARCHAR(32) NOT NULL, " +
						"OWNER VARCHAR(32) , " +
						"PIN VARCHAR(6) , " + 
						"PRIMARY KEY (CARD_NUM)  )";

	String deltablestr="drop table OSAMURS2.CARDS ";
	String insertstr1 = "INSERT INTO OSAMURS2.CARDS (CARD_NUM, OWNER, PIN )" +
						"VALUES ('123', 'Sarah Poger', '123')";
						
	String insertstr2 = "INSERT INTO OSAMURS2.CARDS (CARD_NUM, OWNER, PIN )" +
						"VALUES ('124', 'Mitchell Gladstone', '124')";
						
	String insertstr3 = "INSERT INTO OSAMURS2.CARDS (CARD_NUM, OWNER, PIN )" +
						"VALUES ('125', 'Dali C. Gladstone', '125')";
						
	String insertstr4 = "INSERT INTO OSAMURS2.CARDS (CARD_NUM, OWNER, PIN )" +
						"VALUES ('126', 'Sally C. Gladstone', '126')";					

	stmt = con.createStatement();

	try{
		// If ACCNTS table exists, delete it.
		stmt.executeUpdate(deltablestr);
	}
	catch(Exception exp){
		System.out.println(exp);
	}
	stmt.executeUpdate(crttablestr);

	//add some records to the table.
	stmt.executeUpdate(insertstr1);
	stmt.executeUpdate(insertstr2);
	stmt.executeUpdate(insertstr3);
	stmt.executeUpdate(insertstr4);
	stmt.close();
	}
/**
 * Insert the method's description here.
 * Creation date: (12/5/00 2:51:18 PM)
 */
public static void createTranTable() throws Exception {
	
	Statement stmt= null;
	String crttablestr="create table OSAMURS2.TRANS " +
						"(REF_NUM VARCHAR(32) NOT NULL, " +
						"AMOUNT DECIMAL (7, 2)  NOT NULL , " +
						"SRC_ACT CHARACTER (10)  NOT NULL , " +
						"TGT_ACT CHARACTER (10)  NOT NULL , " +
						"DATE DATE  NOT NULL , " +
						"TMESTAMP TIMESTAMP  NOT NULL , " + 
						"PRIMARY KEY (REF_NUM)  )";

	String deltablestr="drop table OSAMURS2.TRANS ";
	

	stmt = con.createStatement();

	try{
		// If trans table exists, delete it.
		stmt.executeUpdate(deltablestr);
	}
	catch(Exception exp){
		System.out.println(exp);
	}
	stmt.executeUpdate(crttablestr);

	stmt.close();
	}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	try{	
		//Context ctx = new InitialContext();
		//DataSource ds = (DataSource)ctx.lookup("jdbc/ATMDB");
		//con = ds.getConnection("db2admin", "db2admin");
		Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
		con  = DriverManager.getConnection("jdbc:db2:plant", "admin", "1010");

		

		createTranTable();
		createAcctTable();
		createCardTable();
		createCardAccntTable();

		con.close();
		System.out.println("Tables succesfully created.");
		
	}
	catch(Exception exp){

		//System.out.println("Error: " + exp);
		exp.printStackTrace();
	}
	
}
/**
 * CreateTables constructor comment.
 */
public CreateTablesBank() {
	super();
}}