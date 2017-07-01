//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\overstar\\ildar\\ibank\\model\\IClientDAB.java

package com.overstar.ildar.ibank.model;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;

/**
 * @author  Shafigullin Ildar
 */
public class IClientDAB extends DatabaseAccess 
{
   
   /**
    * @return com.ibm.db.DatabaseConnection
    * @throws java.lang.Throwable
    * @throws com.ibm.db.DataException
    * @roseuid 3E0041A9021F
    */
   public static com.ibm.db.DatabaseConnection connToIBank() throws java.lang.Throwable, com.ibm.db.DataException 
   {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("com.overstar.ildar.ibank.model.IClientDAB.connToIBank");
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
   
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041AA00B8
    */
   public static com.ibm.db.SQLStatementMetaData IClientDeleteSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.IClientDAB.IClientDeleteSQL";
  String statement = "DELETE FROM ILDAR.CLIENTS WHERE ( ( ILDAR.CLIENTS.CLIENT_ID = :CLIENT_ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("CLIENT_ID", 4, 4);
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
504b030414g08g08gce9a2b2dgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c12e5f5f471710cd273f6f174f5
0b0946516164600952c19a9698539c8a26630a36d1g4d9480898c6640ac8a22620ac4d6c822cc860646e86e058a81fc6582
669b19c836262374479880843921d6c77bbaa0c91a8164594a8a4a53d142c91c124a5c565875325b809cgd607g504b0708
0e2fbd44ccgggbd01gg504b010214g14g08g08gce9a2b2d0e2fbd44ccgggbd01gg0cggggggggg
gggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0601gggg
**end of SQL Assist data**/    
   }
   
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041AA019E
    */
   public static com.ibm.db.SQLStatementMetaData IClientInsertSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.IClientDAB.IClientInsertSQL";
  String statement = "INSERT INTO ILDAR.CLIENTS ( CLIENT_ID, INN_CLN, OKPO, NAME_CLN, FIO_CLN, PHONE_CLN, FAX_CLN, EMAIL_CLN, ADDR_CLN, NUM_DOGOV, REG_DATE, PERMS, LOCK_WORD, ORDERING_CUSTOMER, STATUS, CLN_TYPE, KPP, DOC_SIGN_NUM, EXT_CLIENT_ID, COUNTRY_CODE, CITY, CITY_LATIN, ADDRESS_LATIN, SOATO, RESIDENT_FLAG ) VALUES ( :CLIENT_ID, :INN_CLN, :OKPO, :NAME_CLN, :FIO_CLN, :PHONE_CLN, :FAX_CLN, :EMAIL_CLN, :ADDR_CLN, :NUM_DOGOV, :REG_DATE, :PERMS, :LOCK_WORD, :ORD_CUST, :STATUS, :CLN_TYPE, :KPP, :DOC_SIGN_NUM, :EXT_CLIENT_ID, :COUNTRY_CODE, :CITY, :CITY_LATIN, :ADDRESS_LATIN, :SOATO, :RESIDENT_FLAG )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("INN_CLN", 12, 12);
    aSpec.addParameter("OKPO", 12, 12);
    aSpec.addParameter("NAME_CLN", 12, 12);
    aSpec.addParameter("FIO_CLN", 12, 12);
    aSpec.addParameter("PHONE_CLN", 12, 12);
    aSpec.addParameter("FAX_CLN", 12, 12);
    aSpec.addParameter("EMAIL_CLN", 12, 12);
    aSpec.addParameter("ADDR_CLN", 12, 12);
    aSpec.addParameter("NUM_DOGOV", 12, 12);
    aSpec.addParameter("REG_DATE", 91, 91);
    aSpec.addParameter("PERMS", 1, 1);
    aSpec.addParameter("LOCK_WORD", 12, 12);
    aSpec.addParameter("ORD_CUST", 12, 12);
    aSpec.addParameter("STATUS", 4, 4);
    aSpec.addParameter("CLN_TYPE", 1, 1);
    aSpec.addParameter("KPP", 12, 12);
    aSpec.addParameter("DOC_SIGN_NUM", 1, 1);
    aSpec.addParameter("EXT_CLIENT_ID", 12, 12);
    aSpec.addParameter("COUNTRY_CODE", 1, 1);
    aSpec.addParameter("CITY", 12, 12);
    aSpec.addParameter("CITY_LATIN", 12, 12);
    aSpec.addParameter("ADDRESS_LATIN", 12, 12);
    aSpec.addParameter("SOATO", 12, 12);
    aSpec.addParameter("RESIDENT_FLAG", 1, 1);
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
504b030414g08g08g43992b2dgggggggggggg0cggg6275696c64657220646174616d54cd8ed33010f6
96fd6bbaadb602c48923d7aa4d5504de53946483d5fc297177b7da83d5035a81562ba8528484c489c7615f866740421c7807
3c4e9cdab10f5166c633e399f9bef1cf7fe868b745cf6e6fe38f9b2f9bc9fde6e16e5256db0f0f77176ed27ffce1febeee21
f4f51342e82d777c6af17bfc75f5e7efcb6f91f4eb55e8643175d932cf2b7488f96ff7197d47bdfae80c8ebc2028981fa715
ea6329ab4e0370baf46e6a9f53dc88aacb70319db338f397ec3a2b820a1dcc3ab7cc59ea25619d413f7c0ed9795058903462
feaaa4591216500b370a5df53e9af154537e218903af98f83109535aaa1e63b80cda08cb92c51e25c68d63b831bca1ac8e66
84173cc29a41753f87847eb64a69b1e6ff20ece63b151d2cf38c9787e16f440799cf4a12a52c5d2596e87913ad1f9cc08180
4db79fc3757ac62156f50e30aedaa783ad3d9ec9a1d9101a4b9228131d61cd60708aa761749d8780a3943ba8cf6da8eb370b
5ae5efb2d4ca1c31779fd035cc1dfe46e37c187c525176058db78ac16d92a692db8da8ba38e052528fae4a0e0aae25d5e1e0
35ff5e699605ff2e544b1f3a29338f1a308b4295d57170ab186e61e291b82ed5c1ad62b09fe34202gf932f6222bdfeaa9e9
07033868d75c3f7bb298ce407d61be0b246bdf855ad4e26653d7f21ab8bcc488051e15fc90722770c6035dd53692784b120e
f05e333644dfd82156758363ca86e8c5f605f8356ec75808c6b83b4f89e5eddb6f8365b33a688db066304a55386d94ca9725
2c92d2ba460a772c045496ccc1ad6234b287cd82e9fe85ef63291b046b774d4f3092acb43fd98e589f66072d08356d1f6321
98ac9624edb0fa0d90ecb0daeedeff07504b070879564d5d7002gg7b07gg504b010214g14g08g08g43992b2d7956
4d5d7002gg7b07gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g
01g3agggaa02gggg
**end of SQL Assist data**/    
   }
   
   /**
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041AB0159
    */
   public static com.ibm.db.StatementMetaData IClientSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.IClientDAB.IClientSelectSQL";
  String statement = "SELECT ILDAR.CLIENTS.CLIENT_ID, ILDAR.CLIENTS.INN_CLN, ILDAR.CLIENTS.OKPO, ILDAR.CLIENTS.NAME_CLN, ILDAR.CLIENTS.FIO_CLN, ILDAR.CLIENTS.PHONE_CLN, ILDAR.CLIENTS.FAX_CLN, ILDAR.CLIENTS.EMAIL_CLN, ILDAR.CLIENTS.ADDR_CLN, ILDAR.CLIENTS.NUM_DOGOV, ILDAR.CLIENTS.REG_DATE, ILDAR.CLIENTS.PERMS, ILDAR.CLIENTS.LOCK_WORD, ILDAR.CLIENTS.ORDERING_CUSTOMER, ILDAR.CLIENTS.STATUS, ILDAR.CLIENTS.CLN_TYPE, ILDAR.CLIENTS.KPP, ILDAR.CLIENTS.DOC_SIGN_NUM, ILDAR.CLIENTS.EXT_CLIENT_ID, ILDAR.CLIENTS.COUNTRY_CODE, ILDAR.CLIENTS.CITY, ILDAR.CLIENTS.CITY_LATIN, ILDAR.CLIENTS.ADDRESS_LATIN, ILDAR.CLIENTS.SOATO, ILDAR.CLIENTS.RESIDENT_FLAG FROM ILDAR.CLIENTS WHERE ( ( ILDAR.CLIENTS.CLIENT_ID = :CLIENT_ID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.CLIENTS");
    aSpec.addColumn("CLIENTS.CLIENT_ID", 4,4);
    aSpec.addColumn("CLIENTS.INN_CLN", 12,12);
    aSpec.addColumn("CLIENTS.OKPO", 12,12);
    aSpec.addColumn("CLIENTS.NAME_CLN", 12,12);
    aSpec.addColumn("CLIENTS.FIO_CLN", 12,12);
    aSpec.addColumn("CLIENTS.PHONE_CLN", 12,12);
    aSpec.addColumn("CLIENTS.FAX_CLN", 12,12);
    aSpec.addColumn("CLIENTS.EMAIL_CLN", 12,12);
    aSpec.addColumn("CLIENTS.ADDR_CLN", 12,12);
    aSpec.addColumn("CLIENTS.NUM_DOGOV", 12,12);
    aSpec.addColumn("CLIENTS.REG_DATE", 91,91);
    aSpec.addColumn("CLIENTS.PERMS", 1,1);
    aSpec.addColumn("CLIENTS.LOCK_WORD", 12,12);
    aSpec.addColumn("CLIENTS.ORDERING_CUSTOMER", 12,12);
    aSpec.addColumn("CLIENTS.STATUS", 4,4);
    aSpec.addColumn("CLIENTS.CLN_TYPE", 1,1);
    aSpec.addColumn("CLIENTS.KPP", 12,12);
    aSpec.addColumn("CLIENTS.DOC_SIGN_NUM", 1,1);
    aSpec.addColumn("CLIENTS.EXT_CLIENT_ID", 12,12);
    aSpec.addColumn("CLIENTS.COUNTRY_CODE", 1,1);
    aSpec.addColumn("CLIENTS.CITY", 12,12);
    aSpec.addColumn("CLIENTS.CITY_LATIN", 12,12);
    aSpec.addColumn("CLIENTS.ADDRESS_LATIN", 12,12);
    aSpec.addColumn("CLIENTS.SOATO", 12,12);
    aSpec.addColumn("CLIENTS.RESIDENT_FLAG", 1,1);
    aSpec.addParameter("CLIENT_ID", 4, 4);
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
504b030414g08g08g63892b2dgggggggggggg0cggg6275696c646572206461746185964f8bd34018c6
a7ed565d41417775656551100541ea6492b48d9e4292ad61d3a424e9fe6185a1877551caa26b2a82e0c98b20088220089e04
2fee97f13308e2c1efe0cc146127cfa8b7f2e379dfbc7f669ee9d75fa43d3b24cbbbbbc9a3c9b349673a39d8ef14d5e1c383
fdbb6cb878f48a7ddf6a12f2fc3121e4be102e197447df367ffc5c7b31f8a36b56e4844d19b7fa15b91c27a19f7782248ed2
b2e844db259fffe671387b425e92e6f1805e4556f580300b78110f529e8e87c7f52719ed71ca69454edff947c26e45cee909
3746a3e3b236a39eccd27e30993eddc3046e452eea098224e5e5ce2842ad5391655d5b947e392e506957e48aaeccf230cae3
74c083715166c328c7205691153d28c9820dbe2542516c556449178fa27c68288542837934e0a15fea0d7a42cb1cd8671e15
712887bf9ef8030cb0a18a22f3cb0c850c32fb612892173cf1cb38c5gd1dfa5da5ee272e76f6ad1e47954d7ce0193e760a1
3a9ced4102cb83831964e3b4cc777890853829ab2f491b794f9253c8bb929cad15d49505351945b92bc93272479215e4b624
abc899246bc82d49ae22a7925cab715b1d8c868558acbf6931e40c78ab4f2df3f06db56b631a0a5c0ccd96433ba3ed0a22e5
3a0df54abf327d48da9249dec5362ccacc5ab78e8554f4d5a82fd75636d27010ff6598160e73ce2d732172689ec6db72b51e
988b305c1e66836c13b47db00c795985afa720ed41da68e8c789512bc67941d7aefbdb46a50b5947f7b234326a1dcc1a6746
a50d6da5fed09c94819f641b23cdd65a9e5c6f93b9106b4141719a1abf42a14de34b279ec2fefc29d4f72d2e8323e9a231aa
c5289c90865841e3ba46c4a8170e66d3a996583e1c9e04af012be37b0358f9de5bc0caf6de0156f6f61eb072b70f8095b97d
04acbced9386adffb9830a54e6f719b0f2be2fb525d9f2e2d44d4862b412857b668c4ea2b06bc68e19a341288cfea0309aaa
c214cc47cd528dfe067235fb9bc8d5f06f2157b3bd8d5c0db76ee5aeaa4673c8966db856f33f32ea40f67f03504b07083fe1
cb02f002ggd00agg504b010214g14g08g08g63892b2d3fe1cb02f002ggd00agg0cggggggggggg
gggggg6275696c6465722064617461504b0506gggg01g01g3aggg2a03gggg
**end of SQL Assist data**/    
   }
   
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041AB024A
    */
   public static com.ibm.db.SQLStatementMetaData IClientUpdateSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.IClientDAB.IClientUpdateSQL";
  String statement = "UPDATE ILDAR.CLIENTS SET CLIENT_ID = :CLIENT_ID, INN_CLN = :INN_CLN, OKPO = :OKPO, NAME_CLN = :NAME_CLN, FIO_CLN = :FIO_CLN, PHONE_CLN = :PHONE_CLN, FAX_CLN = :FAX_CLN, EMAIL_CLN = :EMAIL_CLN, ADDR_CLN = :ADDR_CLN, NUM_DOGOV = :NUM_DOGOV, REG_DATE = :REG_DATE, PERMS = :PERMS, LOCK_WORD = :LOCK_WORD, ORDERING_CUSTOMER = :ORD_CUST, STATUS = :STATUS, CLN_TYPE = :CLN_TYPE, KPP = :KPP, DOC_SIGN_NUM = :DOC_SIGN_NUM, EXT_CLIENT_ID = :EXT_CLIENT_ID, COUNTRY_CODE = :COUNTRY_CODE, CITY = :CITY, CITY_LATIN = :CITY_LATIN, ADDRESS_LATIN = :ADDRESS_LATIN, SOATO = :SOATO, RESIDENT_FLAG = :RESIDENT_FLAG WHERE ( ( ILDAR.CLIENTS.CLIENT_ID = :ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("INN_CLN", 12, 12);
    aSpec.addParameter("OKPO", 12, 12);
    aSpec.addParameter("NAME_CLN", 12, 12);
    aSpec.addParameter("FIO_CLN", 12, 12);
    aSpec.addParameter("PHONE_CLN", 12, 12);
    aSpec.addParameter("FAX_CLN", 12, 12);
    aSpec.addParameter("EMAIL_CLN", 12, 12);
    aSpec.addParameter("ADDR_CLN", 12, 12);
    aSpec.addParameter("NUM_DOGOV", 12, 12);
    aSpec.addParameter("REG_DATE", 91, 91);
    aSpec.addParameter("PERMS", 1, 1);
    aSpec.addParameter("LOCK_WORD", 12, 12);
    aSpec.addParameter("ORD_CUST", 12, 12);
    aSpec.addParameter("STATUS", 4, 4);
    aSpec.addParameter("CLN_TYPE", 1, 1);
    aSpec.addParameter("KPP", 12, 12);
    aSpec.addParameter("DOC_SIGN_NUM", 1, 1);
    aSpec.addParameter("EXT_CLIENT_ID", 12, 12);
    aSpec.addParameter("COUNTRY_CODE", 1, 1);
    aSpec.addParameter("CITY", 12, 12);
    aSpec.addParameter("CITY_LATIN", 12, 12);
    aSpec.addParameter("ADDRESS_LATIN", 12, 12);
    aSpec.addParameter("SOATO", 12, 12);
    aSpec.addParameter("RESIDENT_FLAG", 1, 1);
    aSpec.addParameter("ID", 4, 4);
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
504b030414g08g08g7b7f2d2dgggggggggggg0cggg6275696c64657220646174618555cd6ed34010de
260d891312b5821e3921ae91e39250b62763bbc68ae38d6ca76dd4c32a075a81aa0a8283909038f138f465780624c4817760
671d3bfb8738583b7f3b3b3fdf8cbfff41adcd1a3dbeba8adfad3ead86b7abbb9b6156acdfdedd9c3a33ebfe9bf3f3a281d0
e7f708a157ccf091c1eefec7f9afdf4fbe84955da3408713dba6c1654ebd380a929c467e810658126c3ea0afa8519a5b609e
113727057a803921aa9b8e3d2ad0de4894f5e18ae0bd8b8d9efb63fb98c6c49bd20b92faaa9387a04ddc59c03c25aab2cb83
cadd7c9115a88d4b4aba5d8690d07c390f5812b8a2b53893c58cfa2424e71067cd88666dc73ea136b5d5205a23162193f6a3
d877d36199a314c521e4e0fa7e1a64198ddd3cd212e1210835e8e29a11cd0ec0914716499e2ed9e907aa1fde54e5a5019604
a2790fcccfdccbb2b61dbc25b5277de2d12c0a13a892fae401f8900dfa58e445e30e7823d33951bdb441319dcfb5f683f734
08a9efe6bc8115ad61731ea4b30cb0c909a9418efd121ad4ba5edd7e7ca3810baa630217bb36e6ddb615e97fba7dc4734cfd
208d92907a8b2c27b320d53a0e56f3d7243102bb0d19f172ec637688aabd09fb9e499231fb4ea58280f3edb02ag010d0343
e4c3209ec56ea85af0167951be54153d50d46031e04e713bc0924083bb907c17d78cb45446b663849b3c027d2cf2522e605c
c2ad85e154bcc3ca3ad6e0b6db3616ae68ad75c25e93031cf0g59fdaaf9ebe11da7b54259c086ddb7db5e06g095b4bd672
046c47c2702f98b9516c6a64a78a1e2a06a716cf6e180d93ba9b250b57b486a12849fe316f1398ac86636b5811e2ede29a91
ca5ec1d6bc608f3812f4a1b43013725e09e5398462197f587c6bd64974f096541c38e060bf586fa48dd3e593b9fd6399e62b
22c67de0d82fca7f4f13cbc1344fgc5da3be566af9cb1cd5e92d24d6602ecd3bf504b07084f6a6a2cb302gg6108gg50
4b010214g14g08g08g7b7f2d2d4f6a6a2cb302gg6108gg0cggggggggggggggggg6275696c64
65722064617461504b0506gggg01g01g3aggged02gggg
**end of SQL Assist data**/    
   }
}
