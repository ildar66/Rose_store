package com.overstar.bank.atm.database;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class CardDAB extends DatabaseAccess {
public static com.ibm.db.StatementMetaData CardAcctSelectSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.CardDAB.CardAcctSelectSQL";
  String statement = "SELECT * FROM OSAMURS2.CARDACCT WHERE ( ( OSAMURS2.CARDACCT.CARD_NUM = :CARDNUM ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("CARDACCT");
	aSpec.addColumn("CARDACCT.CARD_NUM", 12,12);
	aSpec.addColumn("CARDACCT.ACCT_NUM", 12,12);
	aSpec.addParameter("CARDNUM", 12, 12);
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
504b030414g08g08ga589ed2agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060611a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c1215f40f76f40d0d0a36d27376
0c727174760e41516564600952c59a9698539c8a26630a36d5g4d940853992dc1ee34421663340362551411d312064e9839
d628b6581a18c5034d90c2b0450f44c4fb85fa622837c0aa1cc44057ce6c6860841e5a4031432c7e350319cb64842e6c0212
e6c066365012ec149692a2d254b4683287441387154823ba9b2c40f66389054b60780365980c8d30840dc0c2g504b070849
709802fdggg6b02gg504b010214g14g08g08ga589ed2a49709802fdggg6b02gg0cgggggggggg
ggggggg6275696c6465722064617461504b0506gggg01g01g3aggg3701gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData CardAssociateAcctSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.CardDAB.CardAssociateAcctSQL";
  String statement = "INSERT INTO OSAMURS2.CARDACCT ( CARD_NUM, ACCT_NUM ) VALUES ( :CARDNUM, :ACCTNUM )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("CARDNUM", 12, 12);
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
504b030414g08g08g3288ed2agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606066ea042612cead65e0a7bfe52b6
da1da68ea98481c7d4c028ded931c825de2fd4b78481c30ac406324b0b19ea1898e06a8ce31d9d9d43206a180d9125590d81
9206250c82fec18ebea141c1467a201340aa318c4058836a04a31910aba28898963070c20cb44696613635300471b951040d
0d8cd00d058a1902c58cd05c6184e4110e2b101bcdb3cc16207dac698939c5a9g504b07088e9ad763bfggg7401gg50
4b010214g14g08g08g3288ed2a8e9ad763bfggg7401gg0cggggggggggggggggg6275696c64
65722064617461504b0506gggg01g01g3agggf9ggggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData CardDeleteAttatchedSQL() throws java.lang.Throwable {
  String name = "com.ibm.itso.sg245264.atm.database.CardDAB.CardDeleteAttatchedSQL";
  String statement = "DELETE FROM CARDACCT WHERE ( ( CARDACCT.CARD_NUM = :CARDNUM OR CARDACCT.CARD_NUM = :ACCTNUM ) )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("CARDNUM", 12, 12);
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
504b030414g08g08g868e572agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060641a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f108f4bdcg5d9cd5d0c018242ae8e264e4e8e2ebe9a7
e7ec18e4e2e8ec1c82a2cac8c012a48a352d31a738154dc6146caa019a2811a6329a01b12a8a88690903274c8f35b20cb3a1
8111badb8162207f9aa0d96c06b299c908dd412620610e903be2fd427dd1248d40922c2545a5a96881660e094c0e2b90e3d1
f441a541c65a81cc459366b6g390f1264g504b0708f291b93fe2ggg0202gg504b010214g14g08g08g868e572a
f291b93fe2ggg0202gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg
01g01g3aggg1c01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData CardDeleteSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.CardDAB.CardDeleteSQL";
  String statement = "DELETE FROM OSAMURS2.CARDS WHERE ( ( OSAMURS2.CARDS.CARD_NUM = :CARDNUM ) )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("CARDNUM", 12, 12);
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
504b030414g08g08gb388ed2agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c12e5f30f76f40d0d0a36d27376
0c720946516264600952c29a9698539c8a26630a36d2g4d9490918c6640ac8a22625ac2c009d3608d2cc36c686084ee6aa0
18c8872668d69a81ac653242778d09489803e48878bf505f34492390244b4951692a5a709943828bc30aa4114d1fb305c87e
b02eg504b07083cf0f18dd3gggc401gg504b010214g14g08g08gb388ed2a3cf0f18dd3gggc401gg0cgg
ggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0d01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData CardInsertSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.CardDAB.CardInsertSQL";
  String statement = "INSERT INTO OSAMURS2.CARDS ( CARD_NUM, OWNER, PIN ) VALUES ( :CARDNUM, :OWNER, :PIN )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("CARDNUM", 12, 12);
	aSpec.addParameter("OWNER", 12, 12);
	aSpec.addParameter("PIN", 12, 12);
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
504b030414g08g08gc183d92agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606065ea042612cead65e0a7bfe52b6
da1da68ea98481c7d4c028ded931c825de2fd4b78481c30ac406324b0b19ea1898206a580d0d8ce30d4a18f8fc831d7d4383
828df4408a829195g8d31463286d1105992d10c885551444c4b183861a65923cb309b1a1882b81c2882860646e88602c50c
816246c862ec20cf0478fa9530b058012964294e9003fdc3fd5c83d00d6207c98035a18a73820c83ea60b3023350ecb7gd9
cf9a9698539c0ag504b0708e62b91b0d8ggg9c01gg504b010214g14g08g08gc183d92ae62b91b0d8ggg9c01
gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg1201
gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData CardSelectAll() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.CardDAB.CardSelectAll";
  String statement = "SELECT OSAMURS2.CARDS.CARD_NUM, OSAMURS2.CARDS.OWNER, OSAMURS2.CARDS.PIN FROM OSAMURS2.CARDS";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("CARDS");
	aSpec.addColumn("CARDS.CARD_NUM", 12,12);
	aSpec.addColumn("CARDS.OWNER", 12,12);
	aSpec.addColumn("CARDS.PIN", 12,12);
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
504b030414g08g08g8a86ed2agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060641a042612cead65e0a7bfe52b6
da1da68ea98481d5d8c028dea88441c83fd8d1373428d848cfd931c825582fc0d3afb490a18e81094999610983089a32ff70
3fd7200c8506250ce2680a4164bc5fa82f8a5a430363905a3e54b5c84a982d0d80b6321a238b319a01b12a8a8869090327cc
106b142b2c41de0309b062081b82043830840d4002dc288e30c67404b3a10130d4180dd1c440ea0c50c42c4062ac698939c5
a968561983c29dc9d00843d810bbb0015818g504b0708a157d2c9e3ggg0802gg504b010214g14g08g08g8a86ed
2aa157d2c9e3ggg0802gg0cggggggggggggggggg6275696c6465722064617461504b0506ggg
g01g01g3aggg1d01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData CardSelectSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.CardDAB.CardSelectSQL";
  String statement = "SELECT DISTINCT OSAMURS2.CARDS.CARD_NUM, OSAMURS2.CARDS.OWNER, OSAMURS2.CARDS.PIN FROM OSAMURS2.CARDS WHERE ( ( CAST ( OSAMURS2.CARDS.CARD_NUM AS VARCHAR(32) ) = :CARDNUM ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("CARDS");
	aSpec.addColumn("CARDS.CARD_NUM", 12,12);
	aSpec.addColumn("CARDS.OWNER", 12,12);
	aSpec.addColumn("CARDS.PIN", 12,12);
	aSpec.addParameter("CARDNUM", 12, 12);
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
504b030414g08g08gb382d92agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060629a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66a6c60146f54c220e41fece81b1a146ca4e7ec18e412ac17e0e987
a10ca859044d997fb89f6b1086428312067134852032de2fd417592dbb918145bc0148359a9b0c0d8c41a27ca866a0283132
b004296129292a4d459330059b6880264ac844664b70e018238b319a01b12a8a8869090327cc106b142b2c41010912e0c010
3604097063081b8004f8501c618ce90866430323f410028a61c6a4918119c88f4c46e85e37010973608b01a0a411d6600446
8d39246a38ac401ad1f4315b80ec674d4bcc294e45f39631283531191a61081b621736g0b03g504b07081a07edb12901g
gf202gg504b010214g14g08g08gb382d92a1a07edb12901ggf202gg0cgggggggggggggggg
g6275696c6465722064617461504b0506gggg01g01g3aggg6301gggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData CardUpdateSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.atm.database.CardDAB.CardUpdateSQL";
  String statement = "UPDATE OSAMURS2.CARDS SET CARD_NUM = :CARDNUM, OWNER = :OWNER, PIN = :PIN WHERE ( ( OSAMURS2.CARDS.CARD_NUM = :CARD_NUM ) )";

  SQLStatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.SQLStatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addParameter("CARDNUM", 12, 12);
	aSpec.addParameter("OWNER", 12, 12);
	aSpec.addParameter("PIN", 12, 12);
	aSpec.addParameter("CARD_NUM", 12, 12);
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
504b030414g08g08g2685d92agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060631a042612cead65e0a7bfe52b6
da1da68ea98481ddccc0203ec0d3af8481c50a48951632d4313041a4988d0c0c4b18180d91c57840ca9d1d835ce2fd427d4b
1838ac406c2013590dbb918145bc41bc01ba5e5643036390289f7fb0a36f6850b0911e4873308af1a6402508e3d1f41b1958
82f4b3a625e614a722cb70825ce51feee71a54c2c0660566a06934053bc7g4d94907318cd80581545c414681b4c83354a68
191a18a1bb1828060a416314b782bc08752b86ffcc400e62324271273b4803388630949b809473c0c20b4dd20824c9525254
9a8a1639e690c8e1b4c2a691d902e464cc2066060631882b08g504b070816fa64ef1c01gg8802gg504b010214g14g
08g08g2685d92a16fa64ef1c01gg8802gg0cggggggggggggggggg6275696c6465722064617461
504b0506gggg01g01g3aggg5601gggg
**end of SQL Assist data**/
}
public static com.ibm.db.DatabaseConnection conn1() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
	connection = new com.ibm.db.DatabaseConnection();
	connection.setConnectionAlias("com.overstar.bank.atm.database.CardDAB.conn1");
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
}