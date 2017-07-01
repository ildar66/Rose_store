package com.overstar.bank.database;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class IClientDAB extends DatabaseAccess {
public static com.ibm.db.StatementMetaData SelectClientInfoSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.database.IClientDAB.SelectClientInfoSQL";
  String statement = "SELECT QRSDTTST.CLIENT.SERVICEKIND, QRSDTTST.CLIENT.STARTDATE, QRSDTTST.CLIENT.FINISHDATE FROM QRSDTTST.CLIENT WHERE ( ( QRSDTTST.CLIENT.PARTYID = :PARTYID ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("QRSDTTST.CLIENT");
	aSpec.addColumn("CLIENT.SERVICEKIND", 5,5);
	aSpec.addColumn("CLIENT.STARTDATE", 91,91);
	aSpec.addColumn("CLIENT.FINISHDATE", 91,91);
	aSpec.addParameter("PARTYID", 4, 4);
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
504b030414g08g08gf94d262bgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060629a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66a6c60146f54c220131814ece218e218121ca2e7ece3e9ea17a2e7
e6e9e719ec011474c5d0g34461a5343708863500856f506250cb258d4bb0685793abb7a7bfab920eb603732b08837ge941
73aaa18131485410c32414554606962055ac698939c5a96832a660530dd044893095d9121c74c6c8628c6640ac8a22625ac2
c08d30c71ac51e4b504083043830840d4102dc18c20620013e146718633a83d9d0c0083da8806286583c6a06f2289311bab0
0948983dg1879919e2e6872e0b86329292a4d458b22734814715861d1c76c01b21e4317d053c6a0b4c6646988216c885d18
145da6g504b07081ad9e6743801gg0f03gg504b010214g14g08g08gf94d262b1ad9e6743801gg0f03gg0cg
gggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg7201gggg

**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectCurdateSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.database.IClientDAB.SelectCurdateSQL";
  String statement = "SELECT QRSDTTST.CURDATE.CURDATE FROM QRSDTTST.CURDATE";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("QRSDTTST.CURDATE");
	aSpec.addColumn("CURDATE.CURDATE", 91,91);
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
504b030414g08g08g4d73252bgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606066ea042612cead65e0a7bfe52b6
da1da68ea98481d5d8c028dea084412a3028d8c531c431243844cf393408c87485d1a5850c750c4c50e58606c620e54298ca
9195315b1a189630301a228b319a01b12a8a8869090337c2206b148b2c41ee0209b0a2186c8c6930b3a181111631903a0314
310b90184b4951692a9a4d602f31591a02g504b0708cb3c0ce6b0ggg6401gg504b010214g14g08g08g4d73252b
cb3c0ce6b0ggg6401gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg
01g01g3agggeaggggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectIClientSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.database.IClientDAB.SelectIClientSQL";
  String statement = "SELECT IBANK.ICLIENTS.NAME, IBANK.ICLIENTS.PARTYID, IBANK.ICLIENTS.PASSWORD FROM IBANK.ICLIENTS WHERE ( ( IBANK.ICLIENTS.NAME = :NAME ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("IBANK.ICLIENTS");
	aSpec.addColumn("ICLIENTS.NAME", 1,1);
	aSpec.addColumn("ICLIENTS.PARTYID", 4,4);
	aSpec.addColumn("ICLIENTS.PASSWORD", 1,1);
	aSpec.addParameter("NAME", 1, 1);
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
504b030414g08g08g27610f2bgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060619a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66a6c60146f54c220eee9e4e8e7ade7e9ece3e9ea1712ac17e0181c
1cee1fe482a11668821886daa090484f4ca506250cc2684afd1c7d5d91d5b11b1958c41b8054a239cbd0c01824ca87aa1f45
8991812548096b5a624e712a9a8c29d8480334514246325b8203c818598cd11cdd6d8c6640ac8a22625ac2c00636d61ac546
4b50d882043830840d4102dc18c20620013e14371963ba89d902ecf11047271f94d06436343042772d50cc104b5098814c60
324217360109b3a0c71250021c9b2c2545a5a968d1670e893e562b744dcc16208b31b4gbd691c8fe14ab028c89d2618a2e0
b401g504b0708e91b35fd3701gg1203gg504b010214g14g08g08g27610f2be91b35fd3701gg1203gg0cgg
ggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg7101gggg
**end of SQL Assist data**/
}
}
