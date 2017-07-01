package com.overstar.ildar.ibank.model.references;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;

/**
 * @author Shafigullin Ildar
 */
public class BankDAB extends DatabaseAccess 
{
   
   /**
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E00419401F7
    */
   public static com.ibm.db.StatementMetaData BankSelectBikNameSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.BankDAB.BankSelectBikNameSQL";
  String statement = "SELECT ILDAR.BANKS.BIK, ILDAR.BANKS.BILL_CORR, ILDAR.BANKS.BANK_NAME, ILDAR.BANKS.CITY, ILDAR.BANKS.DELIVERY FROM ILDAR.BANKS WHERE ( ( ILDAR.BANKS.BIK like '%'||:BIK||'%' ) AND ( ILDAR.BANKS.BANK_NAME like '%'||:BANK_NAME||'%' ) ) ORDER BY ILDAR.BANKS.BANK_NAME";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.BANKS");
    aSpec.addColumn("BANKS.BIK", 1,1);
    aSpec.addColumn("BANKS.BILL_CORR", 1,1);
    aSpec.addColumn("BANKS.BANK_NAME", 12,12);
    aSpec.addColumn("BANKS.CITY", 12,12);
    aSpec.addColumn("BANKS.DELIVERY", 12,12);
    aSpec.addParameter("BIK", 1, 1);
    aSpec.addParameter("BANK_NAME", 12, 12);
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
504b030414g08g08g6b5a312dgggggggggggg0cggg6275696c64657220646174618d94cd4ac3401080
b7498bd4823f58f1e4d193506637696beaa9b64542d30aa954a48790432d4a285a3722089e7c1cfb323e83201e7c0733ab42
36d3160fc9e1db6f86d999495ebf58219eb1f268e4dd840f61250aa793ca40ceaea79363d12bce5fc4fb85c1d8e32d63ec30
11771678f3b7e1c7e7fed3e99f674866dac025cbf1f88e3d33e39709c5449a152c10812d59d9f5da4dbf72d2ec77079576c7
73871dff928896645b69b1e59e534948b69b96f01df49bbd0e3179d6743d2f689df93e3141b24dddeca69d35014701a0a5df
b8c0c1425a4ac56ae7021caca2701546f76372024b4eaa1893ab6bd4fea93207c405e28aa42abeb2aa955527b7ad071c8df5
c6c2e69a8e1a74554beae0a01194d238574b9e03225a083634b12a597e1a47117105826d82398232c180604fabd6a2d59a1c
04595fae3c2083e70b062fa0862d360464a6a43afb8ffdc404401308b0316f7159908d4166663d132e96ae995a9bbc9cc563
3263b5d1f946369b935c22f9640dae7dc9e611b6872452b6456c85c5624c7e1c8aaa1e7f03504b070847dd3c0c8b01ggae
04gg504b010214g14g08g08g6b5a312d47dd3c0c8b01ggae04gg0cggggggggggggggggg62
75696c6465722064617461504b0506gggg01g01g3agggc501gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E00419402DD
    */
   public static com.ibm.db.StatementMetaData BankSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.BankDAB.BankSelectSQL";
  String statement = "SELECT ILDAR.BANKS.BIK, ILDAR.BANKS.BILL_CORR, ILDAR.BANKS.BANK_NAME, ILDAR.BANKS.CITY, ILDAR.BANKS.DELIVERY FROM ILDAR.BANKS WHERE ( ( ILDAR.BANKS.BIK = :BIK ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.BANKS");
    aSpec.addColumn("BANKS.BIK", 1,1);
    aSpec.addColumn("BANKS.BILL_CORR", 1,1);
    aSpec.addColumn("BANKS.BANK_NAME", 12,12);
    aSpec.addColumn("BANKS.CITY", 12,12);
    aSpec.addColumn("BANKS.DELIVERY", 12,12);
    aSpec.addParameter("BIK", 1, 1);
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
504b030414g08g08ge77e302dgggggggggggg0cggg6275696c64657220646174617d93cb4ac3401486
4f2e45a5e005e35270e336cca5ad8dae6a5b2434ad904a45ba0859d4a284a2e94404c1958f635fc66710c485efe09c042199
292e92c577be339cf94ff2fe03b52c05673a0deee3a7d84de2c5dc1d8bf46e313f63c3add51bfbbc36019e1fge0488afb6b
bcd5c7e4ebfbf0e5e2cf3305588c500106cd1ee115cc82d53861514380e307bd4ee89e774683b1dbeb07fea41fde682217b0
5b16bbfe952e3101076509dfd1a833ec6b26554d3f08a2ee65186a2611b0533507656783917644d0526e4709475a2ff556ea
8c7858afddc6c972a6549af97944a1ff9e677979c2cd4a8f870923d82c63a3259f634de408ea15b129c05e6449a2b90cc1b6
8629823d0d13044e655aae4f6b51c2d41425a36b9268611226537103b1a52c48f27c89b648b399b2b9936273f6a9dae3c9b0
e5a769525699a68dd36807e536d7ec1cb3f558ff19bc62bd06fd05504b07085c74c6b54f01gg8203gg504b010214g14
g08g08ge77e302d5c74c6b54f01gg8203gg0cggggggggggggggggg6275696c64657220646174
61504b0506gggg01g01g3aggg8901gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.DatabaseConnection
    * @throws java.lang.Throwable
    * @throws com.ibm.db.DataException
    * @roseuid 3E00419403C3
    */
   public static com.ibm.db.DatabaseConnection connToIBank() throws java.lang.Throwable, com.ibm.db.DataException 
   {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("com.overstar.ildar.ibank.model.BankDAB.connToIBank");
    connection.setInitialContextFactory("com.ibm.ejs.ns.jndi.CNInitialContextFactory");
    connection.setJndiDataSource("jdbc/iBank");
    connection.setUserID("");
    connection.setPromptUID(false);
    connection.setAutoCommit(true);
    connection.setPassword("", true);
  }
  catch(com.ibm.db.DataException e){throw e;}
  catch(java.lang.Throwable e){throw e;}
  return connection;    
   }
}
