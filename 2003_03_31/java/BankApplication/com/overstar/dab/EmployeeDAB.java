package com.overstar.dab;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class EmployeeDAB extends DatabaseAccess {
public static com.ibm.db.DatabaseConnection connToAS400() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
	connection = new com.ibm.db.DatabaseConnection();
	connection.setConnectionAlias("com.overstar.dab.EmployeeDAB.connToAS400");
	connection.setInitialContextFactory("com.ibm.ejs.ns.jndi.CNInitialContextFactory");
	connection.setJndiDataSource("jdbc/dev400");
	connection.setUserID("ildar");
	connection.setPromptUID(false);
	connection.setAutoCommit(true);
	connection.setPassword("acedg0574g0a68776f646e3339666835", true);
  }
  catch(com.ibm.db.DataException e){throw e;}
  catch(java.lang.Throwable e){throw e;}
  return connection;
}
public static com.ibm.db.DatabaseConnection connToPlant() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
	connection = new com.ibm.db.DatabaseConnection();
	connection.setConnectionAlias("com.overstar.dab.EmployeeDAB.connToPlant");
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
public static com.ibm.db.StatementMetaData getEmployees() throws java.lang.Throwable {
  String name = "com.overstar.dab.EmployeeDAB.getEmployees";
  String statement = "SELECT ANDY.BILLS.USERNAME, ANDY.BILLS.NUMBILL, ANDY.BILLS.DATETIME, ANDY.BILLS.TOCOMPANY, ANDY.BILLS.SUM FROM ANDY.BILLS WHERE ( ( ANDY.BILLS.USERNAME = :USERNAME ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("ANDY.BILLS");
	aSpec.addColumn("BILLS.USERNAME", 1,1);
	aSpec.addColumn("BILLS.NUMBILL", 4,4);
	aSpec.addColumn("BILLS.DATETIME", 93,93);
	aSpec.addColumn("BILLS.TOCOMPANY", 1,1);
	aSpec.addColumn("BILLS.SUM", 4,4);
	aSpec.addParameter("USERNAME", 1, 1);
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
504b030414g08g08g2074e92agggggggggggg0cggg6275696c64657220646174617d92cd4ac3401080
27a9c556a1a0ed55f0e235ec4f5b1b7b8a3648a149c5a44ae9a1e4508b528ab65b11044f3e8e7d199f41100fbe833b296276
377808846fbe9d9d9d99b76f28ae16501b8d7a77c963e2cc92f9d489c4e2763e6db3a0bc7e651fd736c0d33dg1c4ab19ae3
addfaf3ebf0e9ecf7f3d5b4081112ac0a2ab0778017bc38a9cb0715d40c50b3b43e7b4dbeb454e34080c850ba86594b87fd6
0f2ebc7068884c40352376bcd88fbb816f78b292fd8c170e02fc3134a2a61b44fe65e8a9e9b619698d099adad328e14877fe
ce2b61465c0c176f92d972a2451a693aa2d1ffd215dcb4b90de5888bcd4550ca62ab29bf2343e4087615b12143785ddb9019
828a8129823d03130435a55c6e965ba084e94d948ce674a2899db0998eeb884b794392c174985b62b19a68d33bde4caf7c92
7bd0956d970b6ad595b25a5896912c95b9b10848e5cb6c971b98ea99539aeed20f504b0708dd04575e5501gg8603gg50
4b010214g14g08g08g2074e92add04575e5501gg8603gg0cggggggggggggggggg6275696c64
65722064617461504b0506gggg01g01g3aggg8f01gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData getPassword() throws java.lang.Throwable {
  String name = "com.overstar.dab.EmployeeDAB.getPassword";
  String statement = "SELECT ANDY.USERS.PASSWORD FROM ANDY.USERS WHERE ( ( ANDY.USERS.USERNAME = :USER_NAME ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("ANDY.USERS");
	aSpec.addColumn("USERS.PASSWORD", 1,1);
	aSpec.addParameter("USER_NAME", 1, 1);
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
504b030414g08g08g3b5dea2agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060611a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66a6c60146f50c220ece8e712a9171aec1a14ac17e0181c1cee1fe4
82ac8eddc8c022dega4124dbfa1813148940ba11f45dac8c01224cd9a9698539c8a26630a36ceg4d149f71cc96983e6034
036255141153a0412003ac518cb604f91424c08162a431a691cc86064658c40cb1b8d60ce45a2623746113903007c8fd7e8e
beae6892e0g6729292a4d450b6173480873598134c6a3eb64b6gb9g431fd05fc6907801g504b07088dc11570f6ggg
3702gg504b010214g14g08g08g3b5dea2a8dc11570f6ggg3702gg0cggggggggggggggggg
6275696c6465722064617461504b0506gggg01g01g3aggg3001gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData getPasswordUser() throws java.lang.Throwable {
  String name = "com.overstar.dab.EmployeeDAB.getPasswordUser";
  String statement = "SELECT ANDY.USERS.PASSWORD FROM ANDY.USERS WHERE ( ( ANDY.USERS.USERNAME = :USER_NAME ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("ANDY.USERS");
	aSpec.addColumn("USERS.PASSWORD", 1,1);
	aSpec.addParameter("USER_NAME", 1, 1);
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
504b030414g08g08gb45cf42agggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060611a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66a6c60146f50c220ece8e712a9171aec1a14ac17e0181c1cee1fe4
82ac8eddc8c022dega4124dbfa1813148940ba11f45dac8c01224cd9a9698539c8a26630a36ceg4d149f71cc96983e6034
036255141153a0412003ac518cb604f91424c08162a431a691cc86064658c40cb1b8d60ce45a2623746113903007c8fd7e8e
beae6892e0g6729292a4d450b6173480873598134c6a3eb64b6gb9g431fd05fc6907801g504b07088dc11570f6ggg
3702gg504b010214g14g08g08gb45cf42a8dc11570f6ggg3702gg0cggggggggggggggggg
6275696c6465722064617461504b0506gggg01g01g3aggg3001gggg
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData getUser() throws java.lang.Throwable {
  String name = "com.overstar.dab.EmployeeDAB.getUser";
  String statement = "SELECT ANDY.BILLS.USERNAME, ANDY.BILLS.NUMBILL, ANDY.BILLS.DATETIME, ANDY.BILLS.TOCOMPANY, ANDY.BILLS.SUM FROM ANDY.BILLS WHERE ( ( ANDY.BILLS.USERNAME = :USERNAME ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("ANDY.BILLS");
	aSpec.addColumn("BILLS.USERNAME", 1,1);
	aSpec.addColumn("BILLS.NUMBILL", 4,4);
	aSpec.addColumn("BILLS.DATETIME", 93,93);
	aSpec.addColumn("BILLS.TOCOMPANY", 1,1);
	aSpec.addColumn("BILLS.SUM", 4,4);
	aSpec.addParameter("USERNAME", 1, 1);
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
504b030414g08g08gb35bf42agggggggggggg0cggg6275696c64657220646174617d92cd4ac3401080
27a9c556a1a0ed55f0e235ec4f5b1b7b8a3648a149c5a44ae9a1e4508b528ab65b11044f3e8e7d199f41100fbe833b296276
377808846fbe9d9d9d99b76f28ae16501b8d7a77c963e2cc92f9d489c4e2763e6db3a0bc7e651fd736c0d33dg1c4ab19ae3
addfaf3ebf0e9ecf7f3d5b4081112ac0a2ab0778017bc38a9cb0715d40c50b3b43e7b4dbeb454e34080c850ba86594b87fd6
0f2ebc7068884c40352376bcd88fbb816f78b292fd8c170e02fc3134a2a61b44fe65e8a9e9b619698d099adad328e14877fe
ce2b61465c0c176f92d972a2451a693aa2d1ffd215dcb4b90de5888bcd4550ca62ab29bf2343e4087615b12143785ddb9019
828a8129823d03130435a55c6e965ba084e94d948ce674a2899db0998eeb884b794392c174985b62b19a68d33bde4caf7c92
7bd0956d970b6ad595b25a5896912c95b9b10848e5cb6c971b98ea99539aeed20f504b0708dd04575e5501gg8603gg50
4b010214g14g08g08gb35bf42add04575e5501gg8603gg0cggggggggggggggggg6275696c64
65722064617461504b0506gggg01g01g3aggg8f01gggg
**end of SQL Assist data**/
}
}
