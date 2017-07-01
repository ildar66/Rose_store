package com.overstar.ildar.ibank.model.references;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;

/**
 * @author  Shafigullin Ildar
 */
public class RecipientDAB extends DatabaseAccess 
{
   
   /**
    * @return com.ibm.db.DatabaseConnection
    * @throws java.lang.Throwable
    * @throws com.ibm.db.DataException
    * @roseuid 3E0041BC0212
    */
   public static com.ibm.db.DatabaseConnection connToIBank() throws java.lang.Throwable, com.ibm.db.DataException 
   {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("com.overstar.ildar.ibank.model.RecipientDAB.connToIBank");
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
    * @roseuid 3E0041AB0073
    */
   public static com.ibm.db.StatementMetaData IClientRecipientsSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.IClientDAB.IClientRecipientsSelectSQL";
  String statement = "SELECT ILDAR.RECIPIENTS.ID, ILDAR.RECIPIENTS.CLIENT_ID, ILDAR.RECIPIENTS.INN, ILDAR.RECIPIENTS.NAME, ILDAR.RECIPIENTS.BIC, ILDAR.RECIPIENTS.BILL, ILDAR.RECIPIENTS.COMMENTS FROM ILDAR.RECIPIENTS WHERE ( ( ILDAR.RECIPIENTS.CLIENT_ID = :CLIENT_ID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.RECIPIENTS");
    aSpec.addColumn("RECIPIENTS.ID", 1,1);
    aSpec.addColumn("RECIPIENTS.CLIENT_ID", 4,4);
    aSpec.addColumn("RECIPIENTS.INN", 12,12);
    aSpec.addColumn("RECIPIENTS.NAME", 12,12);
    aSpec.addColumn("RECIPIENTS.BIC", 1,1);
    aSpec.addColumn("RECIPIENTS.BILL", 12,12);
    aSpec.addColumn("RECIPIENTS.COMMENTS", 12,12);
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
504b030414g08g08gd583382dgggggggggggg0cggg6275696c64657220646174618593cd4ac34010c7
a7498b56419456c482473d86fd48faa1a7da160924515ad1430f25875a94506add882078f271eccbf80c8278f01dccb40866
67c153c22fbf9ddd99fde7ed1b4ae91caac36170173fc64e124f27ce40cd6fa79313119617afe2e3da02789a01c05126560c
dee2fdeaf3ebe0f9ecd7b314d8827105059edec30b582b56924c8cea0af6fda0dbee3bfd5ec7bff07bd1e5c0e99c8721be10
db53b04bec533f0888e92aa81acc0e11a5a964d40e7bc414a6927e141131ebb4467b0af039f2bb44670a2ab46ece5b13ac39
62686a23e44c22ddd6d7e724c15a28956ee2e461ac7df196459946ff2f6ab79617dac82d6ce185225827d843b049b08b60eb
2f2e6489281c125122d8c98959188ad33449882b105409e608f60866086ab9de24edcde64ce8d3cf18370caf8ec3b3848e5d
c465730cc42a0645354fc7da0125fe221617047b04672969ac52b2716cde07d7b9a48d26b661de5b9af716668cd370095da6
f607504b0708af85g326801gg5804gg504b010214g14g08g08gd583382daf85g326801gg5804gg0cggg
gggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggga201gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041BC03B7
    */
   public static com.ibm.db.SQLStatementMetaData RecipientDeleteSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.RecipientDAB.RecipientDeleteSQL";
  String statement = "DELETE FROM ILDAR.RECIPIENTS WHERE ( ( ILDAR.RECIPIENTS.ID = :ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("ID", 1, 1);
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
504b030414g08g08g6b85372dgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c1215f0f471710cd20b7275f60c
f074f50b0946516464600952c49a9698539c8a26630a36d4g4d94b0a18c6640ac8a22625ac2c092579a93832cc86c686084
ee68a018c8832668769a81ec643242778a0958d8d3054dd80824cc5252549a8a164ee6907062b642d5c26c01b214ac01g50
4b07082504396bcfgggb801gg504b010214g14g08g08g6b85372d2504396bcfgggb801gg0cgggggg
ggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0901gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041BD00B5
    */
   public static com.ibm.db.SQLStatementMetaData RecipientInsertSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.RecipientDAB.RecipientInsertSQL";
  String statement = "INSERT INTO ILDAR.RECIPIENTS ( ID, CLIENT_ID, INN, NAME, BIC, BILL, COMMENTS ) VALUES ( :ID, :CLIENT_ID, :INN, :NAME, :BIC, :BILL, :COMMENTS )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("ID", 1, 1);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("INN", 12, 12);
    aSpec.addParameter("NAME", 12, 12);
    aSpec.addParameter("BIC", 1, 1);
    aSpec.addParameter("BILL", 12, 12);
    aSpec.addParameter("COMMENTS", 12, 12);
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
504b030414g08g08g2985372dgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a0206060651a042612cead65e0a7bfe52b6
da1da68ea98481c3d4c038dec9d3c7a78481d1b0b490a18e810922c1666a6014efe952c2c06ce5e9822cc103d2e1ecefebeb
ea17128c4597315817aa30ab2150d8a08441c0d3c7c531482fc8d5d933c013a41f59113bc429cee89a39402ef173f475059a
6305a29125794192ce3e20c3c0f67259c13968661843cd40359cd10c885551444c4b1858f24a73729005994d0d0c415c4114
4143032374f380628640312334371a23bb1155073b38a0fdfc80b65a0129b4a036420a6a4e2b181b23d8c0fad15c62017209
4b4951692a8675e05066b1025218010d490bac56201ag504b07088c8335d01901gg7402gg504b010214g14g08g08
g2985372d8c8335d01901gg7402gg0cggggggggggggggggg6275696c6465722064617461504b05
06gggg01g01g3aggg5301gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041BD019B
    */
   public static com.ibm.db.StatementMetaData RecipientSelectIClientSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.RecipientDAB.RecipientSelectIClientSQL";
  String statement = "SELECT ILDAR.RECIPIENTS.ID, ILDAR.RECIPIENTS.CLIENT_ID, ILDAR.RECIPIENTS.INN, ILDAR.RECIPIENTS.NAME, ILDAR.RECIPIENTS.BIC, ILDAR.RECIPIENTS.BILL, ILDAR.RECIPIENTS.COMMENTS FROM ILDAR.RECIPIENTS WHERE ( ( ILDAR.RECIPIENTS.CLIENT_ID = :CLIENT_ID ) AND ( ILDAR.RECIPIENTS.NAME like '%'||:NAME||'%' ) AND ( ILDAR.RECIPIENTS.INN like '%'||:INN||'%' ) AND ( ILDAR.RECIPIENTS.BILL like '%'||:BILL||'%' ) AND ( ILDAR.RECIPIENTS.BIC like '%'||:BIC||'%' ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.RECIPIENTS");
    aSpec.addColumn("RECIPIENTS.ID", 1,1);
    aSpec.addColumn("RECIPIENTS.CLIENT_ID", 4,4);
    aSpec.addColumn("RECIPIENTS.INN", 12,12);
    aSpec.addColumn("RECIPIENTS.NAME", 12,12);
    aSpec.addColumn("RECIPIENTS.BIC", 1,1);
    aSpec.addColumn("RECIPIENTS.BILL", 12,12);
    aSpec.addColumn("RECIPIENTS.COMMENTS", 12,12);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("NAME", 12, 12);
    aSpec.addParameter("INN", 12, 12);
    aSpec.addParameter("BILL", 12, 12);
    aSpec.addParameter("BIC", 1, 1);
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
504b030414g08g08g725b6c2dgggggggggggg0cggg6275696c64657220646174618d95cd4ac34010c7
b7498b5f208a8a2878f45a766793d6d693b65502699556f4e021f4a0a294a2351541f0e4e3e8cbf80c8278f01ddcd920d89d
897a6af9cd7fe7637766f2fc294ae391583e3d8daffa77fdf2a03fbc28f7d2d1e5f0621bda332f4ff076e209717f2d84d833
c22546f7f27afcfeb1f1b0ffadf352e18354a92884e31bf128bc8c95b484a4928ab5286eee74cbdd56233a8c5a9da35eb971
d06ee31fa20e53b142d4bb511c1365908a6546d92042cdb9ececb45b3f955320b7922091a604453cg172aea7488d0dcc03a
ad35c6df246a12b989b644fd36495e40f3b25c32f92aa9912eb87e2744206b787fa5f3fee0f68c5874ae05722d2ad722732c
216650a812aa590a0cd5e8e1af42434c8d39aaff7314af5792a3f0f7518d517f159907ac26f6a94a75d2dff08f47b40e54e6
c0ed66bf2669d5351c4604d3048708e6080e10ccffc40533cd854d22d40816278466908bc3f16040b48060956085609d6089
6063a2364d6bf3950477120c53eef3d9a9d139d3a498690259c126f3c0ed820a36108781c3013af1dde58472c5cb8df322d3
15154c91d39ba8bebb90205b92ecf00518b8c82cc16ab6048b759a2ce42e067b6486df7390ed4ff61cf06bc3a601591a5c51
684847e333a759347e6a3c05048704db08767bced6f9b46bd976715a6a0b5b8a8fadf9d8c063eccc8050db7f5f504b07083e
d9b86bf701gga007gg504b010214g14g08g08g725b6c2d3ed9b86bf701gga007gg0cgggggggggg
ggggggg6275696c6465722064617461504b0506gggg01g01g3aggg3102gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041BD028C
    */
   public static com.ibm.db.StatementMetaData RecipientSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.RecipientDAB.RecipientSelectSQL";
  String statement = "SELECT ILDAR.RECIPIENTS.ID, ILDAR.RECIPIENTS.CLIENT_ID, ILDAR.RECIPIENTS.INN, ILDAR.RECIPIENTS.NAME, ILDAR.RECIPIENTS.BIC, ILDAR.RECIPIENTS.BILL, ILDAR.RECIPIENTS.COMMENTS FROM ILDAR.RECIPIENTS WHERE ( ( ILDAR.RECIPIENTS.ID = :ID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.RECIPIENTS");
    aSpec.addColumn("RECIPIENTS.ID", 1,1);
    aSpec.addColumn("RECIPIENTS.CLIENT_ID", 4,4);
    aSpec.addColumn("RECIPIENTS.INN", 12,12);
    aSpec.addColumn("RECIPIENTS.NAME", 12,12);
    aSpec.addColumn("RECIPIENTS.BIC", 1,1);
    aSpec.addColumn("RECIPIENTS.BILL", 12,12);
    aSpec.addColumn("RECIPIENTS.COMMENTS", 12,12);
    aSpec.addParameter("ID", 1, 1);
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
504b030414g08g08g1c84372dgggggggggggg0cggg6275696c64657220646174618593cd4ac3401080
a7498b8a204a2b62c1a31ec3fe24fdd1536d8b049228ade8a18792432d4a28b66e44103cf938f6657c06413cf80e665204b3
b3e029e1cbb7333b3f79fb864aba80da6814dcc58fb193c4b3a933548bdbd9f444841bcb57f1716d013cdd03c05126560dde
f2fdeaf3ebe0f9ecd7b314d8827105259ecee105ac15ab4826c60d05fb7ed0eb0c9c41bfeb5ff8fde872e874cfc3105f88ed
29d825f6a91f04c47415d40c669788d21432ea847d620a53483f8a8898555aa73505f81cfb3da23305551ab7e0ad09d61a33
34b5167226916eebe70b92606d942a3771f230d1be787950a6d1ff83daed7ca0cdc2c1360e14c13ac11e824d825d045b7f71
29db88d2211125829d82982d43799626097105821ac11cc11ec10c41bd509ba4b5d99c09bdfb19e386e635b07996d0b19b63
6dfe6235ffb25aa413ed6612ff0d8b0b823d82b3f568aed6c33ed612e001975cbc8517372795e6a4c28cb17e97d07c4f7fg
504b070882d3a2g6601gg4a04gg504b010214g14g08g08g1c84372d82d3a2g6601gg4a04gg0cggggg
gggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggga001gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041BD0372
    */
   public static com.ibm.db.SQLStatementMetaData RecipientUpdateSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.RecipientDAB.RecipientUpdateSQL";
  String statement = "UPDATE ILDAR.RECIPIENTS SET ID = :ID, CLIENT_ID = :CLIENT_ID, INN = :INN, NAME = :NAME, BIC = :BIC, BILL = :BILL, COMMENTS = :COMMENTS WHERE ( ( ILDAR.RECIPIENTS.ID = :RECIPIENTS_ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("ID", 1, 1);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("INN", 12, 12);
    aSpec.addParameter("NAME", 12, 12);
    aSpec.addParameter("BIC", 1, 1);
    aSpec.addParameter("BILL", 12, 12);
    aSpec.addParameter("COMMENTS", 12, 12);
    aSpec.addParameter("RECIPIENTS_ID", 1, 1);
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
504b030414g08g08gf485372dgggggggggggg0cggg6275696c646572206461746185524d4bc340109d
e6435ba922e8b5debc86cdd6d4ba9e6a1a24904469440f3d841c6a5142d19a882078f2e7d83fe36f10c483ffc19d0dfdd84d
c14398ec9b796f67f6cdc72f98c514f687c3e03e7d4ead2c9d8cad389fde4dc6a7346cccdee9d78d06f0f2gg07bc706f4d
ddecf3fafba7f57a3eafd372a83ba49d9cf9419043cd2e1ee10db432a15362abd8768790c40d7c2fba4afc7e0e5b6c71582d
dbc032cceb4c4e34f132f7220c392756c537052b8a7230180f9220f250506150d24d484254dcb479394777fda0df1b5803cf
f52fb1cd58229783bb1532252748366fd3ec69b49aa96383e553990c63a57b2167f09cab283aa24922a9e1fd512ff4d634f0
7ff7b50eff0e25c4e1574f8a2c934cb40955f59bc2c485090d36ff5788e87e5b725fb8b7745f9615af53ce63328cca4c1d9c
49a344818f042caf098729c2463e2d4615cfc48a5416e1b85c841db67c2f652bf52e8e54d1d479df786cfd01504b0708513a
82936001gg6103gg504b010214g14g08g08gf485372d513a82936001gg6103gg0cggggggggggg
gggggg6275696c6465722064617461504b0506gggg01g01g3aggg9a01gggg
**end of SQL Assist data**/    
   }
}
