package com.overstar.bank.atm.database;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class BankAccountDAB extends DatabaseAccess {
public static com.ibm.db.SQLStatementMetaData AccountInsertSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.BankAccountDAB.AccountInsertSQL";
  String statement = "INSERT INTO OSAMURS2.ACCNTS ( ACCT_NUM, BALANCE, CTYPE, OVRDRAFT, MINBALANCE, INITCASH ) VALUES ( :ACCTNUM, :BALANCE, :CTYPE, :OVRDRAFT, :MINBALANCE, :INITCASH )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("ACCTNUM", 12, 12);
	aSpec.addParameter("BALANCE", 4, 4);
	aSpec.addParameter("CTYPE", 12, 12);
	aSpec.addParameter("OVRDRAFT", 4, 4);
	aSpec.addParameter("MINBALANCE", 4, 4);
	aSpec.addParameter("INITCASH", 4, 4);
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
504b030414g08g08g9685ed2agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060661a042612cead65e0a7bfe52b6
da1da68ea98481d3d4c038de392432c0b58481d1b0b490a18e810922c303927174760e89f70bf54597046a33826963b30233
90a5590d817a0d4a18f8fd831d7d4383828df48006f9850423abe10399efebe9e7e4e8e3e8e78c613d37c806b81c87159489
e642a378ffb020972047b710a09bac606c64458c6640ac8aa1cdd3cf33c4d931d803a40dc646d1660a9481b9de1a5986d9d4
c010c4e5431134343042f70150cc1028668411a808276378d9381e47708035221c8d21698414551c5620369089e21a0b906b
584a8a4a53d162c1082516b8ad103cg504b07081d4c48901201gg7402gg504b010214g14g08g08g9685ed2a1d4c
48901201gg7402gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g
01g3aggg4c01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData AccountSelectAllSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.BankAccountDAB.AccountSelectAllSQL";
  String statement = "SELECT OSAMURS2.ACCNTS.ACCT_NUM, OSAMURS2.ACCNTS.BALANCE, OSAMURS2.ACCNTS.CTYPE, OSAMURS2.ACCNTS.OVRDRAFT, OSAMURS2.ACCNTS.MINBALANCE, OSAMURS2.ACCNTS.INITCASH FROM OSAMURS2.ACCNTS";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("OSAMURS2.ACCNTS");
	aSpec.addColumn("ACCNTS.ACCT_NUM", 12,12);
	aSpec.addColumn("ACCNTS.BALANCE", 4,4);
	aSpec.addColumn("ACCNTS.CTYPE", 12,12);
	aSpec.addColumn("ACCNTS.OVRDRAFT", 4,4);
	aSpec.addColumn("ACCNTS.MINBALANCE", 4,4);
	aSpec.addColumn("ACCNTS.INITCASH", 4,4);
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
504b030414g08g08g0887ed2agggggggggggg0cggg6275696c64657220646174617592cb4ac3401486
4f12031641112b4ac1a5db3097582c5d8df116685249d28a7451b290a248d1302982e0cac7b12fe33308e2c2777046282473
e26218f8f8ce99ffccccfb0fb86501edc964709f2f72ef219fcfbc541677f3599f45ade51bfbbcb6019e1f01a0a3c49d066f
f931fefa3e78b95879b6049713363d92b03f4c45344a52e6892088b3d40be3300b447a593ec12bd815d997d031e5288c4fc4
40c4c119d27943efe138394dc47986642661d79483ece60ab7a512f64cf3bf08a42182dab2693c8a6a32255ccb5b865c759c
1e51475bdd5a5d4fdfa1062ec2be06eb556c75d53a4422d760a326aa6769ada2f45101d3601361aac136c24483766d128e27
7128514f605183698f182db9fe35968fa86f52e758d7afc9a2bc45326f6ca122d894214c1b65f227ff02504b070894adbf0b
2c01gg1e03gg504b010214g14g08g08g0887ed2a94adbf0b2c01gg1e03gg0cggggggggggggg
gggg6275696c6465722064617461504b0506gggg01g01g3aggg6601gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData AccountSelectSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.BankAccountDAB.AccountSelectSQL";
  String statement = "SELECT DISTINCT OSAMURS2.ACCNTS.ACCT_NUM, OSAMURS2.ACCNTS.BALANCE, OSAMURS2.ACCNTS.CTYPE, OSAMURS2.ACCNTS.OVRDRAFT, OSAMURS2.ACCNTS.MINBALANCE, OSAMURS2.ACCNTS.INITCASH FROM OSAMURS2.ACCNTS WHERE ( ( OSAMURS2.ACCNTS.ACCT_NUM = :ACCTNUM ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("OSAMURS2.ACCNTS");
	aSpec.addColumn("ACCNTS.ACCT_NUM", 12,12);
	aSpec.addColumn("ACCNTS.BALANCE", 4,4);
	aSpec.addColumn("ACCNTS.CTYPE", 12,12);
	aSpec.addColumn("ACCNTS.OVRDRAFT", 4,4);
	aSpec.addColumn("ACCNTS.MINBALANCE", 4,4);
	aSpec.addColumn("ACCNTS.INITCASH", 4,4);
	aSpec.addParameter("ACCTNUM", 12, 12);
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
504b030414g08g08gg7ddc2agggggggggggg0cggg6275696c64657220646174618592cb4ac3401440
a789c51641112b15c195b80df3486b6b5731be0a4d2a4d5a912e4a16b528a5689c8a20b8f273eccff80d82b8f01f9c9b5268
ee445c84c09973efdcc7bcff90fc3426a57ebf75173d45d6389a8cac40c6b79351837bc5d91bffbc320879be2784ec2b712b
c39b7df4bebef75ece179e2189c9299324c7a60fe49518739617940f2a92ecb403c7eb76026e39aeeb8781d5f49ba1eb0417
9a6c4bb28b65afe91f3b2dc7774f355d64e46ef73a271de72cd4642ec93696ddf0fa524fab1a2963f3af12684609ea170efc
aeb72caf725a1b50d0d18c18154037509294c3691d9cfc4d347e1ca2934a929322fa6f4eb39eecab9a8aabc3beg14346c03
585bc6b9aafa0e3451g584f89ea091417a534b4g0e6053c30c4049c3144039d589d03b3119e578d28ae92f94d32a4ccae0
788036e042d626d561b2f615194f87a83e01cf3d67a3c51fce175f388274381b04d938c8ac41add937082c2754b56b30ae61
9629d344fe05504b07086c847b956c01gg0a04gg504b010214g14g08g08gg7ddc2a6c847b956c01gg0a04gg
0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggga601gg
gg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData AccountUpdateSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.BankAccountDAB.AccountUpdateSQL";
  String statement = "UPDATE OSAMURS2.ACCNTS SET ACCT_NUM = :ACCT_NUM, BALANCE = :BALANCE, CTYPE = :CTYPE, OVRDRAFT = :OVRDRAFT, MINBALANCE = :MINBALANCE, INITCASH = :INITCASH WHERE ( ( OSAMURS2.ACCNTS.ACCT_NUM = :ACCTNUM ) )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("ACCT_NUM", 12, 12);
	aSpec.addParameter("BALANCE", 4, 4);
	aSpec.addParameter("CTYPE", 12, 12);
	aSpec.addParameter("OVRDRAFT", 4, 4);
	aSpec.addParameter("MINBALANCE", 4, 4);
	aSpec.addParameter("INITCASH", 4, 4);
	aSpec.addParameter("ACCTNUM", 12, 12);
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
504b030414g08g08ga985ed2agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060619a042612cead65e0a7bfe52b6
da1da68ea98481d3d4c038de392432c0b58481d1b0b490a18e810922c36c6460882ec663666010ef1f16e412e4e81602d46c
0563a3280219e9e8ec1c12ef17ea8b6e02bb918145bc41bc01ba38ab2150135094df3fd8d1373428d8480f68825f4830b21a
3e90c1be9e7e4e8e3e8e7ece180e663532b00419c19a9698539c8a26630ab6d2gc5389067908de3b642f0d0b413741ba319
10aba28898020308a6c31a25640d0d8cb086aca79f6788b363b0072864616c64459c2045d0c862b30233d0cc05c598314664
20620cd5526e90248ed0046b4438084d23c821708d1c56d803cd0c14684c460668c22620610e58024193340249b2941495a6
a2a51a7348aae1b0026944d3c76c01f238862e7098221222a715363b99818a405c11g504b07081940c9a35701gg6103g
g504b010214g14g08g08ga985ed2a1940c9a35701gg6103gg0cggggggggggggggggg627569
6c6465722064617461504b0506gggg01g01g3aggg9101gggg
**end of SQL Assist data**/
}
public static com.ibm.db.DatabaseConnection conn1() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
	connection = new com.ibm.db.DatabaseConnection();
	connection.setConnectionAlias("com.overstar.bank.atm.database.BankAccountDAB.conn1");
	connection.setDriverName("COM.ibm.db2.jdbc.app.DB2Driver");
	connection.setDataSourceName("jdbc:db2:plant");
	connection.setUserID("admin");
	connection.setPromptUID(false);
	connection.setAutoCommit(true);
	connection.setPassword("acedg0574g0431303130", true);
  }
  catch(com.ibm.db.DataException e){throw e;}
  catch(java.lang.Throwable e){throw e;}
  return connection;
}
public static com.ibm.db.StatementMetaData TransactionsSelectSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.BankAccountDAB.TransactionsSelectSQL";
  String statement = "SELECT OSAMURS2.TRANS.REF_NUM, OSAMURS2.TRANS.AMOUNT, OSAMURS2.TRANS.SRC_ACT, OSAMURS2.TRANS.TGT_ACT, OSAMURS2.TRANS.DATE, OSAMURS2.TRANS.TMESTAMP FROM OSAMURS2.TRANS WHERE ( ( OSAMURS2.TRANS.SRC_ACT = :SRC_ACT ) )";

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
	aSpec.addParameter("SRC_ACT", 1, 1);
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
504b030414g08g08g4473f22agggggggggggg0cggg6275696c64657220646174618592bd4ec2501480
0f4502c484c480323919d7e6fe14a43235882c164c5b7460683a20d110a2706b4c4c9c7c1c79199fc1c438f80ef69490d07b
9a3874f9fa9d73cfdfc72f94e225342693ab87e83932e7d16266fa6a79bf9875855b5dbf8baf5b03e0e511g4e12b19ee3ad
3f6fbe7f8e5f075bcf5050148c2b28f0f809dec0d8b09264226c29688e7cc71d7bbe3003cf19fa66e0f6fdc071af896b29a8
6bee8513f48927151ce9390741e8f402a20aaafa5e2f574dea3fd454c71d8d87d46434a9d7bf0c876377572d0bd60919cada
583893486bd9141945301b95d25d345f4db53fad3425d3e87f298b76baa07626ccc60521a8106c21d8dfc58576f29d125122
a865c464e7d56d255d1220101c10cc11340866089a994e24eda4c899d0e79c309e33a8360eca103ab61097f36e436c36bea7
96f1542b4fe2791bb6d4d67eb6597be53c2f1d465918952db683c5e6bf21c9052125fda6143bee108a1d73f107504b070805
49fe8d6101ggfb03gg504b010214g14g08g08g4473f22a0549fe8d6101ggfb03gg0cgggggggggg
ggggggg6275696c6465722064617461504b0506gggg01g01g3aggg9b01gggg
**end of SQL Assist data**/
}}