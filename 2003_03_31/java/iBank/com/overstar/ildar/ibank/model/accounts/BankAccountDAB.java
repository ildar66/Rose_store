package com.overstar.ildar.ibank.model.accounts;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;

/**
 * @author  Shafigullin Ildar
 */
public class BankAccountDAB extends DatabaseAccess {

   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041900024
    */
   public static com.ibm.db.SQLStatementMetaData BankAccountDeleteSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountDeleteSQL";
  String statement = "DELETE FROM ILDAR.ACCOUNTS WHERE ( ( ILDAR.ACCOUNTS.BRANCH_ID = :BRANCH_ID ) AND ( ILDAR.ACCOUNTS.ACCOUNT = :ACCOUNT ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("BRANCH_ID", 12, 12);
    aSpec.addParameter("ACCOUNT", 1, 1);
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
504b030414g08g08g498e5e2dgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060671a042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1a8b490a18e810922c66e6460116f106fg14374416673534300689f279fab83806e9393a
3bfb87fa8504a3283132b08c071ac89a9698539c8a21638043c614a487d1g43d4g8ba831482d7e27107225d083e6f18620
451c5650796469463320564511312d6160c92bcdc9411664363430420f22a018c8272618c1698825388d0ccc407e613242f7
a2194831a6b00948353b160783e5805a389d821cfd9c3de23d5dd0648d70c68911481f4b4951692a46g8153g9715563399
2d40fe04eb03g504b0708ed7b517e0901gg9902gg504b010214g14g08g08g498e5e2ded7b517e0901gg9902g
g0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg4301g
ggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E004190010B
    */
   public static com.ibm.db.SQLStatementMetaData BankAccountInsertSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountInsertSQL";
  String statement = "INSERT INTO ILDAR.ACCOUNTS ( BRANCH_ID, ACCOUNT, CLIENT_ID, TYPE_ACCOUNT, CREATE_DATE, CREATE_AMOUNT, CURRENCY ) VALUES ( :BRANCH_ID, :ACCOUNT, :CLIENT_ID, :TYPE_ACCOUNT, :CREATE_DATE, :CREATE_AMOUNT, :CURRENCY )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("BRANCH_ID", 12, 12);
    aSpec.addParameter("ACCOUNT", 1, 1);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("TYPE_ACCOUNT", 1, 1);
    aSpec.addParameter("CREATE_DATE", 91, 91);
    aSpec.addParameter("CREATE_AMOUNT", 3, 3);
    aSpec.addParameter("CURRENCY", 12, 12);
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
504b030414g08g08gee8d5e2dgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060651a042612cead65e0a7bfe52b6
da1da68ea98441d0d4c028de39c8d531c435ded1d73fd42fa48481cf0a45a0b490a18e8109a29cd5d0c038dega8c4d3c7c5
3148cfd1d919a4221859092fc844a720473f678f784f9712062e2b380759193f92c52e40a28481c70a898b61a2b38fa7ab5f
08d44438075919b729d06d50179530301a22cbf1808d080d0a72f5738e2c61e0b482b19115319a01b12a9acdc6c87e413594
d1b4848125af3427075990d9d4c010c4e5401134343042d70d1433048a19a1058a316aa0a0ea11449287c516aa0ab08b91c2
0a5556g241b1219e08a2b9c0440e184aa80d70a998f16a8c648818ae63d0b90f7584a8a4a53d122c908613687159409g50
4b07088852220c3301ggde02gg504b010214g14g08g08gee8d5e2d8852220c3301ggde02gg0cgggggg
ggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg6d01gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E00419001FB
    */
   public static com.ibm.db.StatementMetaData BankAccountSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountSelectSQL";
  String statement = "SELECT ILDAR.ACCOUNTS.BRANCH_ID, ILDAR.ACCOUNTS.ACCOUNT, ILDAR.ACCOUNTS.CLIENT_ID, ILDAR.ACCOUNTS.TYPE_ACCOUNT, ILDAR.ACCOUNTS.CREATE_DATE, ILDAR.ACCOUNTS.CREATE_AMOUNT, ILDAR.ACCOUNTS.CURRENCY FROM ILDAR.ACCOUNTS WHERE ( ( ILDAR.ACCOUNTS.BRANCH_ID = :BRNCH_ID ) AND ( ILDAR.ACCOUNTS.ACCOUNT = :ACCOUNT ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.ACCOUNTS");
    aSpec.addColumn("ACCOUNTS.BRANCH_ID", 12,12);
    aSpec.addColumn("ACCOUNTS.ACCOUNT", 1,1);
    aSpec.addColumn("ACCOUNTS.CLIENT_ID", 4,4);
    aSpec.addColumn("ACCOUNTS.TYPE_ACCOUNT", 1,1);
    aSpec.addColumn("ACCOUNTS.CREATE_DATE", 91,91);
    aSpec.addColumn("ACCOUNTS.CREATE_AMOUNT", 3,3);
    aSpec.addColumn("ACCOUNTS.CURRENCY", 12,12);
    aSpec.addParameter("BRNCH_ID", 12, 12);
    aSpec.addParameter("ACCOUNT", 1, 1);
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
504b030414g08g08ge08c5e2dgggggggggggg0cggg6275696c64657220646174618594dd4a024114c7
675745251022c9b0baec76990fbfbb5ad7a504b558d742bc58bc302944cac60882ae7a9c7c999e21882e7a87e6ac04ed9eb1
6e84fdcdef9c9d39f35f5fbf486ab920f9d1a873337e185bb3f17c6af5e5e27a3e3de6ddecea85bf5f9a843cde12422c25ee
68bcd5dbc5c7e7e1d3c98f674a92e0944962f0e51d7926e69aa504e541459242bbd3b23dcb769cb341cfef5bcec0f3dc9e33
446e599283b8ebb9b6ef0676171e51414992a2bea0a57e902e24d98fe9fef05c755f3f219f4bb2176fdf69bb3d3f68b790ac
8ebf1b9337f5a5b86fd3b37bce69ac6f9ad35a40413758a409a302682eda24a2705a872da5aec6b3fb095aa11b56ca506350
44a9860a70ffdec27fbb5407ac060ca44c4333ac443d0c5535d2b50ea1029041b80c600be11280dc6f6ca8541a474814gb6
23a28a6472be9ccd90cb01e41166g0a0853gc5c8d9043e5b82511ebf6bc5d09584b9609a5c705a814b3179fcae2a20635c
023bad8b29aca992ac36976a956f0c5718efa45c2c27b12908f82f30194758cdd810281661eeb38da6a7793f54a96fdfac47
47558351e95f2dd0ac80c2b44b8832ad4bc3cd7f03504b07080beba55bad01gg3f05gg504b010214g14g08g08ge0
8c5e2d0beba55bad01gg3f05gg0cggggggggggggggggg6275696c6465722064617461504b0506g
ggg01g01g3aggge701gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E00419002EB
    */
   public static com.ibm.db.SQLStatementMetaData BankAccountUpdateSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.BankAccountDAB.BankAccountUpdateSQL";
  String statement = "UPDATE ILDAR.ACCOUNTS SET BRANCH_ID = :BRANCH_ID, ACCOUNT = :ACCOUNT, CLIENT_ID = :CLIENT_ID, TYPE_ACCOUNT = :TYPE_ACCOUNT, CREATE_DATE = :CREATE_DATE, CREATE_AMOUNT = :CREATE_AMOUNT, CURRENCY = :CURRENCY WHERE ( ( ILDAR.ACCOUNTS.BRANCH_ID = :ID1_BRANCH_ID ) AND ( ILDAR.ACCOUNTS.ACCOUNT = :ID2_ACCOUNT ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("BRANCH_ID", 12, 12);
    aSpec.addParameter("ACCOUNT", 1, 1);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("TYPE_ACCOUNT", 1, 1);
    aSpec.addParameter("CREATE_DATE", 91, 91);
    aSpec.addParameter("CREATE_AMOUNT", 3, 3);
    aSpec.addParameter("CURRENCY", 12, 12);
    aSpec.addParameter("ID1_BRANCH_ID", 12, 12);
    aSpec.addParameter("ID2_ACCOUNT", 1, 1);
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
504b030414g08g08g4c8f5e2dgggggggggggg0cggg6275696c64657220646174617d53cb4ec240149d
160802e515ddbad425990e52b1ae6a69b40954538a86b098748144d310c5d69898b8f273e467fc0613e3c27f70668466da29
2c20bde79c7b7b1fa71fbfa0102dc0de64d2bff79ffd56e0cf67ad61b8b89bcf4ed1a0b47c475f3732g2f0fg804322dccd
d02d3fafbf7ff65fcfd73a39043904d51048287a046f40fec7aa1a84d8ecdb96e361bb1782b21e07bcac426586695e8e1c2f
043bfaea91971411ec6288217983cae30515b6295ab3fb3dc36dad3287bc44614d8c5cd772cc71084afafa395107c1134cfa
2fdcfac1d35460e006a643732428a0308d563aa4cf78c4d40c8870ead6199864fb986443c758a52245b77b08672c51d2c8ef
207120dad6996b38e6053b50b231a91382fc3c0a021ecca910a58504a37b680bb7e74a97f538e06575da81e95a8667e11ef9
4b97aeb3ebf1bca273212f6d72a58c41d6a6d9b89c1f936c83b2def8cada74a806ed2529a8ea7c2c3856151dabb01e623b0a
56d0a8156494f694462b89f0115517335ecf389252cadc3a61d146bb239a970f17d154f017fb026bc45f2aceac9beb522308
b94dee88ebcbd4f40490a842e4346cfe01504b0708659c7826a901ggab04gg504b010214g14g08g08g4c8f5e2d65
9c7826a901ggab04gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01
g01g3aggge301gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.DatabaseConnection
    * @throws java.lang.Throwable
    * @throws com.ibm.db.DataException
    * @roseuid 3E00419003D2
    */
   public static com.ibm.db.DatabaseConnection connToIBank() throws java.lang.Throwable, com.ibm.db.DataException 
   {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("com.overstar.ildar.ibank.model.BankAccountDAB.connToIBank");
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
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041A903B9
    */
   public static com.ibm.db.StatementMetaData IClientBankAccountsSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.IClientDAB.IClientBankAccountsSelectSQL";
  String statement = "SELECT ILDAR.ACCOUNTS.BRANCH_ID, ILDAR.ACCOUNTS.ACCOUNT, ILDAR.ACCOUNTS.CLIENT_ID, ILDAR.ACCOUNTS.TYPE_ACCOUNT, ILDAR.ACCOUNTS.CREATE_DATE, ILDAR.ACCOUNTS.CREATE_AMOUNT, ILDAR.ACCOUNTS.CURRENCY FROM ILDAR.ACCOUNTS WHERE ( ( ILDAR.ACCOUNTS.CLIENT_ID = :CLIENT_ID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.ACCOUNTS");
    aSpec.addColumn("ACCOUNTS.BRANCH_ID", 12,12);
    aSpec.addColumn("ACCOUNTS.ACCOUNT", 1,1);
    aSpec.addColumn("ACCOUNTS.CLIENT_ID", 4,4);
    aSpec.addColumn("ACCOUNTS.TYPE_ACCOUNT", 1,1);
    aSpec.addColumn("ACCOUNTS.CREATE_DATE", 91,91);
    aSpec.addColumn("ACCOUNTS.CREATE_AMOUNT", 3,3);
    aSpec.addColumn("ACCOUNTS.CURRENCY", 12,12);
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
504b030414g08g08g2855612dgggggggggggg0cggg6275696c64657220646174618593cd4ac3401485
27698b56a120162b5597ba0c9349fa135dc53468a18d92a64ae92264518b128ad68908822b1fc7be8ccf20880bdfc1b90d82
991b7113982fe79e997be7cceb17292573521d8f7b37d143a4c5d16caa0df8fc7a363d62fdf2e285bd5faa843cde12420e84
703347b778bbf8f8dc7b3af9d1a99c1418d53951f4e48e3c1335652583b2b0c949addbebd8be663bced9d00b069a33f47dd7
734648dbe06457d6faae1db8a1dd87252a3039a9e71774c407c90d4e762479303a17eee90ae91927dbb27dafeb7a41d8ed20
b1687f4b12ffe54bb1efb16f7bcea9e4bbc2683ba4209706ab530368256b9291306a81a47415c5f713e94f63694925fa9f65
c15a5e712b5366c115035845b801601d611340e537564446947d2434g6c64842220c55912c748cbg5411d601d410a6gea
99de0cdc5b41a74c9ebc607acee89a303a95c9d8045cce8f0c4b7350e4f364221dd08047a3ea0c61d1be62480169a501593b
ccdf06cac42b51ad6c1b6d68237f6f03a50d284cc244143f792b8d9138fd37504b070882bd74298501gg6904gg504b01
0214g14g08g08g2855612d82bd74298501gg6904gg0cggggggggggggggggg6275696c646572
2064617461504b0506gggg01g01g3agggbf01gggg
**end of SQL Assist data**/    
   }
}
