package com.overstar.bank.atm.database;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class TransactionDAB extends DatabaseAccess {
public static com.ibm.db.DatabaseConnection conn1() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
	connection = new com.ibm.db.DatabaseConnection();
	connection.setConnectionAlias("com.overstar.bank.atm.database.TransactionDAB.conn1");
	connection.setInitialContextFactory("com.ibm.ejs.ns.jndi.CNInitialContextFactory");
	connection.setJndiDataSource("jdbc/jdbcdb2plant");
	connection.setUserID("admin");
	connection.setPromptUID(false);
	connection.setAutoCommit(true);
	connection.setPassword("acedg0574g0431303130", true);
  }
  catch(com.ibm.db.DataException e){throw e;}
  catch(java.lang.Throwable e){throw e;}
  return connection;
}
public static com.ibm.db.SQLStatementMetaData TransactionInsertSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.TransactionDAB.TransactionInsertSQL";
  String statement = "INSERT INTO OSAMURS2.TRANS ( REF_NUM, AMOUNT, SRC_ACT, TGT_ACT, DATE, TMESTAMP ) VALUES ( :REF_NUM, :AMOUNT, :SRC_ACT, :TGT_ACT, :DATE, :TMESTAMP )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("REF_NUM", 12, 12);
	aSpec.addParameter("AMOUNT", 8, 3);
	aSpec.addParameter("SRC_ACT", 1, 1);
	aSpec.addParameter("TGT_ACT", 1, 1);
	aSpec.addParameter("DATE", 91, 91);
	aSpec.addParameter("TMESTAMP", 93, 93);
	// user code begin {1} 
	// user code end {1}
  }
  catch(java.lang.Throwable e){
	// user code begin {2} 
	// user code end {2}
	throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g815df12agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060661a042612cead65e0a7bfe52b6
da1da68ea98481c7d4c0283ec4d73538c4d137a08481d30ac62e2d64a863608228e23635308e0f0e728e77740e2961603444
96633504ca199430f0f9073bfa8606051be9850439fa05232be1016947d881aa9f0b24e9e8eb1fea876134a31910ab623824
c43d049b43184d81ce8739c21a5986d9d4c010c4e54611343430423702286608143342b3d2283ec8d52dde2fd4b78481c30a
cac450020f1e0e2b28134309dce11c565026b2120e901217c7105760985a8168344963a8249a932d404e6629292a4d450b55
2378a8b25b4158182109f716a321g504b07085db4cc171101gg5f02gg504b010214g14g08g08g815df12a5db4cc
171101gg5f02gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01
g3aggg4b01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData TransactionSelectSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.TransactionDAB.TransactionSelectSQL";
  String statement = "SELECT OSAMURS2.TRANS.REF_NUM, OSAMURS2.TRANS.AMOUNT, OSAMURS2.TRANS.SRC_ACT, OSAMURS2.TRANS.TGT_ACT, OSAMURS2.TRANS.DATE, OSAMURS2.TRANS.TMESTAMP FROM OSAMURS2.TRANS WHERE ( ( OSAMURS2.TRANS.TGT_ACT = :TGT_ACT ) OR ( OSAMURS2.TRANS.SRC_ACT = :SRS_ACT ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("OSAMURS2.TRANS");
	aSpec.addColumn("TRANS.REF_NUM", 12,12);
	aSpec.addColumn("TRANS.AMOUNT", 8,3);
	aSpec.addColumn("TRANS.SRC_ACT", 1,1);
	aSpec.addColumn("TRANS.TGT_ACT", 1,1);
	aSpec.addColumn("TRANS.DATE", 91,91);
	aSpec.addColumn("TRANS.TMESTAMP", 93,93);
	aSpec.addParameter("TGT_ACT", 1, 1);
	aSpec.addParameter("SRS_ACT", 1, 1);
	// user code begin {1} 
	// user code end {1}
  }
  catch(java.lang.Throwable e){
	// user code begin {2} 
	// user code end {2}
	throw e;
  }
  return aSpec;
/*V2.0
**start of SQL Assist data**
504b030414g08g08g1d63f12agggggggggggg0cggg6275696c64657220646174618593cd4ac3401080
37a9a52d42415aedc9a32721ec4f1a1b7b0ab5f6625ac9a67ae821e4a04529456b2282e0c9c7b12fe33308e2c1777027a5d0
64563de4f2ed37b3b33393b76f524e17a439999cddc68fb1358be7534b268b9bf9b4cbfddaf2957f5c9a843cdd11420e95d8
d078cbf78bcfaffde7c1da331352e29425c4e0e93d7921e68a9505e5513b21ad91f4fc7120b91506de505aa1df97a1e79f23
d74e48a3e09e78611f7922217bc59c8330f27a2152395665d0d3aaaafedd82eaf9a3f1109b14270dfaa7d170ec6faa154e3b
1105d960b9148c0aa0f57c8a9cc2a90bf594afe3d9c3153aa1bf9cb421c6a088520d15e0fe5dc27f55aa071e450ca4eab10c
64b1a925375b092797d58595g5045d806b0bd890d477d074814gea39516d596d5d68170570g3b0833g4d84298056ee25
02bfa4c4282f4e563134806c0b98660b38756004262f4ec60119631bec8a6e79e14c855474ffg5f2df656b2488bdb92ed31
3e70d5dc553b4d57a059d3d5ac75f740940d51f98674a8f672b005ea0850d4d38c42573b88429b18ff01504b0708f87fa2ce
9001ggd104gg504b010214g14g08g08g1d63f12af87fa2ce9001ggd104gg0cggggggggggggg
gggg6275696c6465722064617461504b0506gggg01g01g3agggca01gggg
**end of SQL Assist data**/
}
}
