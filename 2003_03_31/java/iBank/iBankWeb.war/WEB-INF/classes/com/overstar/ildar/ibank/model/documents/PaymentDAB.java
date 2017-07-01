package com.overstar.ildar.ibank.model.documents;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;

/**
 * @author  Shafigullin Ildar
 */
public class PaymentDAB extends DatabaseAccess 
{
   
   /**
    * @return com.ibm.db.DatabaseConnection
    * @throws java.lang.Throwable
    * @throws com.ibm.db.DataException
    * @roseuid 3E0041B5004F
    */
   public static com.ibm.db.DatabaseConnection connToIBank() throws java.lang.Throwable, com.ibm.db.DataException 
   {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("com.overstar.ildar.ibank.model.PaymentDAB.connToIBank");
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
    * @roseuid 3E0041AA0284
    */
   public static com.ibm.db.StatementMetaData IClientPaymentsSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.IClientDAB.IClientDocumentsSelectSQL";
  String statement = "SELECT ILDAR.PAYMENTS.DOC_ID, ILDAR.PAYMENTS.CLIENT_ID, ILDAR.PAYMENTS.DATE_DOC, ILDAR.PAYMENTS.NUM_DOC, ILDAR.PAYMENTS.PAYMENT_TYPE, ILDAR.PAYMENTS.PAYER_INN, ILDAR.PAYMENTS.PAYER_NAME, ILDAR.PAYMENTS.PAYER_ACCOUNT, ILDAR.PAYMENTS.AMOUNT, ILDAR.PAYMENTS.PAYER_BANK_NAME, ILDAR.PAYMENTS.PAYER_BANK_BIC, ILDAR.PAYMENTS.PAYER_BANK_ACC, ILDAR.PAYMENTS.RCPT_INN, ILDAR.PAYMENTS.RCPT_NAME, ILDAR.PAYMENTS.RCPT_ACCOUNT, ILDAR.PAYMENTS.RCPT_BANK_NAME, ILDAR.PAYMENTS.RCPT_BANK_BIC, ILDAR.PAYMENTS.RCPT_BANK_ACC, ILDAR.PAYMENTS.TYPE_OPER, ILDAR.PAYMENTS.QUEUE, ILDAR.PAYMENTS.TERM, ILDAR.PAYMENTS.PAYMENT_DETAILS, ILDAR.PAYMENTS.KPP, ILDAR.PAYMENTS.STATUS_DOC, ILDAR.PAYMENTS.SIGNERS FROM ILDAR.PAYMENTS WHERE ( ( ILDAR.PAYMENTS.CLIENT_ID = :CLIENT_ID ) AND ( ILDAR.PAYMENTS.DATE_DOC between :FROMDATE and :TODATE ) ) ORDER BY ILDAR.PAYMENTS.DATE_DOC";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.PAYMENTS");
    aSpec.addColumn("PAYMENTS.DOC_ID", 12,12);
    aSpec.addColumn("PAYMENTS.CLIENT_ID", 4,4);
    aSpec.addColumn("PAYMENTS.DATE_DOC", 91,91);
    aSpec.addColumn("PAYMENTS.NUM_DOC", 12,12);
    aSpec.addColumn("PAYMENTS.PAYMENT_TYPE", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_INN", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_ACCOUNT", 1,1);
    aSpec.addColumn("PAYMENTS.AMOUNT", 3,3);
    aSpec.addColumn("PAYMENTS.PAYER_BANK_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_BANK_BIC", 1,1);
    aSpec.addColumn("PAYMENTS.PAYER_BANK_ACC", 1,1);
    aSpec.addColumn("PAYMENTS.RCPT_INN", 12,12);
    aSpec.addColumn("PAYMENTS.RCPT_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.RCPT_ACCOUNT", 1,1);
    aSpec.addColumn("PAYMENTS.RCPT_BANK_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.RCPT_BANK_BIC", 1,1);
    aSpec.addColumn("PAYMENTS.RCPT_BANK_ACC", 1,1);
    aSpec.addColumn("PAYMENTS.TYPE_OPER", 1,1);
    aSpec.addColumn("PAYMENTS.QUEUE", 1,1);
    aSpec.addColumn("PAYMENTS.TERM", 91,91);
    aSpec.addColumn("PAYMENTS.PAYMENT_DETAILS", 12,12);
    aSpec.addColumn("PAYMENTS.KPP", 12,12);
    aSpec.addColumn("PAYMENTS.STATUS_DOC", 1,1);
    aSpec.addColumn("PAYMENTS.SIGNERS", 1,1);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("FROMDATE", 91, 91);
    aSpec.addParameter("TODATE", 91, 91);
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
504b030414g08g08gcb83522dgggggggggggg0cggg6275696c64657220646174618d96dd6a134114c7
2749d3a45e08da6afdaa08a220489cd9dd7c6cbdda266b094d3671b3514a2f965cd4520945eb4604c12b5f441004b120085e
09be83cf208817be8373ce50c8ce39ad5e25fcf23f7366ce39f39f7cfa23cab343b1b2b3d37b3a7939a94d27077bb55176b8
7fb077dfe92f1dbd757e3e2e0af1ea9910625f0b9719ddd18f47bf7eafbdde3cd61533b1e84a2755ad4c5ceaf63a415c1b06
dbfd304a46b5647b18a6836118cf9e8b37a238af6e66e29aa58edbc324dd08a2ad3468b7e723ca8ef453a53f9f4ca62f76e7
7fa938b299ca5466e2cc7abbd7d5cba4dd0e4dd6382dd9469726935c32b3563d136b27ae1505fd90867899b8ca85e8630ec6
5142035c5a4a0ce0977732b1caa9bb5144c58a6e5f7f0963b6f026449e1a62956fd1d7218e3ef1452b64d4dd8cc27844b5fa
b0976d6d1224e351da19304bebd39eb7e45bc321d5e9835ea7bb862f69274c826e8fd98a3ee9b23dc261dc9f175661e21416
a5b29e0c3a41125ad3e3f0a38abfe8a885ec70b64b522b3f132b56ea87e3701c52650b4899f226902ae50d20e7acad346093
454752791dc82a91cb13e41e902b94bb40d6287780dca05c01b949b904727b9e973ca9f75e50c407146c7269fd413ce8db6d
d16bb93895f930835d1eeb412b2a2797b90599b906ba386f96dc70289cafac7aba50feb3f97e13893c5de299792ad84d7171
989813814373b8c9e3868d4b4a3abcb44e4ba5b049ccdef82680e571e553b40b8693113058dab80c53e4b35e70ec60b6ab62
88aed5052b24e8db6e8d4ae625338b33f68e010d6a782680dd489dbe05466dd93b8a9997e6d8f4e02d267a97fa7434eedbc6
8b52e695815b666b4bbe4467a99305143d08fb64a358d2f2eb449652dffa9679fd0bf605f3205d95db20fe0846c127f7ccc5
fbafa33a38e3b9e12cc0adb99523ba810b07b3e93497061e561fc03b82d1dfdf138cf6fe816074f78f04a38b1f118c6efd99
6034eb2f04a3577fcd61f56f5fc2ff0cgbe118c66fedd6ab60bd7d3bae388c1ae5c42895b216d9025aa301c8a770437a58e
85d8e3313527c40eb576df587bc123545223c31a634bee508e3db94b3936e51ee55872667dac79ee36564c65b86b53c7cd37
0825ef4cc965aeb9f9bb88631dfc05504b0708eb98b5f23703gg6b0cgg504b010214g14g08g08gcb83522deb98b5
f23703gg6b0cgg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01
g3aggg7103gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041B501EA
    */
   public static com.ibm.db.SQLStatementMetaData PaymentDeleteSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.PaymentDAB.PaymentDeleteSQL";
  String statement = "DELETE FROM ILDAR.PAYMENTS WHERE ( ( ILDAR.PAYMENTS.DOC_ID = :DOC_ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("DOC_ID", 12, 12);
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
504b030414g08g08g568f502dgggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c12e5f3f471710cd20b708cf475
f50b0946516264600952c29a9698539c8a26630a36d2g4d9490918c6640ac8a22625ac2c092579a93832cc86c686084ee60
a018c8732668369a816c6432427788094898cdc5df39ded3054dca0824c55252549a8a164ee6907062b7c2d4c66c01b21cac
09g504b0708966d7921d2gggbc01gg504b010214g14g08g08g568f502d966d7921d2gggbc01gg0cggg
gggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0c01gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041B502DA
    */
   public static com.ibm.db.SQLStatementMetaData PaymentInsertSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.PaymentDAB.PaymentInsertSQL";
  String statement = "INSERT INTO ILDAR.PAYMENTS ( DOC_ID, CLIENT_ID, DATE_DOC, NUM_DOC, PAYMENT_TYPE, PAYER_INN, PAYER_NAME, PAYER_ACCOUNT, AMOUNT, PAYER_BANK_NAME, PAYER_BANK_BIC, PAYER_BANK_ACC, RCPT_INN, RCPT_NAME, RCPT_ACCOUNT, RCPT_BANK_NAME, RCPT_BANK_BIC, RCPT_BANK_ACC, TYPE_OPER, QUEUE, TERM, PAYMENT_DETAILS, KPP, STATUS_DOC, SIGNERS ) VALUES ( :DOC_ID, :CLIENT_ID, :DATE_DOC, :NUM_DOC, :PAYMENT_TYPE, :PAYER_INN, :PAYER_NAME, :PAYER_ACCOUNT, :AMOUNT, :PAYER_BANK_NAME, :PAYER_BANK_BIC, :PAYER_BANK_ACC, :RCPT_INN, :RCPT_NAME, :RCPT_ACCOUNT, :RCPT_BANK_NAME, :RCPT_BANK_BIC, :RCPT_BANK_ACC, :TYPE_OPER, :QUEUE, :TERM, :PAYMENT_DETAILS, :KPP, :STATUS_DOC, :SIGNERS )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("DOC_ID", 12, 12);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("DATE_DOC", 91, 91);
    aSpec.addParameter("NUM_DOC", 12, 12);
    aSpec.addParameter("PAYMENT_TYPE", 12, 12);
    aSpec.addParameter("PAYER_INN", 12, 12);
    aSpec.addParameter("PAYER_NAME", 12, 12);
    aSpec.addParameter("PAYER_ACCOUNT", 1, 1);
    aSpec.addParameter("AMOUNT", 3, 3);
    aSpec.addParameter("PAYER_BANK_NAME", 12, 12);
    aSpec.addParameter("PAYER_BANK_BIC", 1, 1);
    aSpec.addParameter("PAYER_BANK_ACC", 1, 1);
    aSpec.addParameter("RCPT_INN", 12, 12);
    aSpec.addParameter("RCPT_NAME", 12, 12);
    aSpec.addParameter("RCPT_ACCOUNT", 1, 1);
    aSpec.addParameter("RCPT_BANK_NAME", 12, 12);
    aSpec.addParameter("RCPT_BANK_BIC", 1, 1);
    aSpec.addParameter("RCPT_BANK_ACC", 1, 1);
    aSpec.addParameter("TYPE_OPER", 1, 1);
    aSpec.addParameter("QUEUE", 1, 1);
    aSpec.addParameter("TERM", 91, 91);
    aSpec.addParameter("PAYMENT_DETAILS", 12, 12);
    aSpec.addParameter("KPP", 12, 12);
    aSpec.addParameter("STATUS_DOC", 1, 1);
    aSpec.addParameter("SIGNERS", 1, 1);
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
504b030414g08g08g168f502dgggggggggggg0cggg6275696c64657220646174617d55cd6ed34010de
8696fce1d46db9f6c835b2370a82e1e43aabca6aec18ff80aa1eac1c50058a22881c8484c489c7a12fc33320210ebc03bbfe
59af674d0e516666bf9ddd99efdbf18fbfe464bf234fefee961fd69fd7d3cd7a7b3f8df3ddfbedfd2bea0f1fbed35f6f7b84
7cf9480879c981171db8879f6f7effb9fc7a5de37a39399b5b348bdc30c9ae9ce026bbf2dc9c4ca015d87f22df48af84f705
fc260c73720cfc4f5d1acfad59167bd7018be29c1cd9eadab9580b9d5b1629c7b421230159acdccc5be0a5b366b7e3baab34
48306228aef53a6529cbc963280c2d4153134f82139cd81c61f1d2bde5c289a6fc309f0549ac422e500d81e3339c662cee11
a4be28242703a84c15f2a4a8d349588969ef37241b65f6114807e5a8605e10f0eaa1b61155b392aaf61993a68eae12ce456e
4cd529b423281fcde2c449d2b82c690c8da715e72e3dded882e4114807914531db1368053438e25615300fa870534ae13f52
aa6916fc670b9638de529373a155c7efda6eaadb93db50ebefd173fe7bd68accf96bdaee379b432fa643b3862ca58bc74773
cb16eea526be463868876dd18e98cd63547be852e41de252c5d07165450287a557d4dc921e22b350946872b60a592414251d
441795a3a50fa5a535bb914c573b8de66e45eb46201d6dgc8213880ca4402a3fa1c31018590a82812ad01aa7f60d8758c5a
b3ba81a25103545f2305f7e614da1175c3a02085453e9faa20feb5c9d54cbf21d4b6a612855624c9174292c7f96eff0e1d3b
ab8ed51e2b958fb50fa5a51da750abcd03aacf031350087d8d66f5d7487b1eb4357bc7d078ffg504b070831bc93445502g
ge207gg504b010214g14g08g08g168f502d31bc93445502gge207gg0cgggggggggggggggg
g6275696c6465722064617461504b0506gggg01g01g3aggg8f02gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.StatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041B503C1
    */
   public static com.ibm.db.StatementMetaData PaymentSelectSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.PaymentDAB.PaymentSelectSQL";
  String statement = "SELECT ILDAR.PAYMENTS.DOC_ID, ILDAR.PAYMENTS.CLIENT_ID, ILDAR.PAYMENTS.DATE_DOC, ILDAR.PAYMENTS.NUM_DOC, ILDAR.PAYMENTS.PAYMENT_TYPE, ILDAR.PAYMENTS.PAYER_INN, ILDAR.PAYMENTS.PAYER_NAME, ILDAR.PAYMENTS.PAYER_ACCOUNT, ILDAR.PAYMENTS.AMOUNT, ILDAR.PAYMENTS.PAYER_BANK_NAME, ILDAR.PAYMENTS.PAYER_BANK_BIC, ILDAR.PAYMENTS.PAYER_BANK_ACC, ILDAR.PAYMENTS.RCPT_INN, ILDAR.PAYMENTS.RCPT_NAME, ILDAR.PAYMENTS.RCPT_ACCOUNT, ILDAR.PAYMENTS.RCPT_BANK_NAME, ILDAR.PAYMENTS.RCPT_BANK_BIC, ILDAR.PAYMENTS.RCPT_BANK_ACC, ILDAR.PAYMENTS.TYPE_OPER, ILDAR.PAYMENTS.QUEUE, ILDAR.PAYMENTS.TERM, ILDAR.PAYMENTS.PAYMENT_DETAILS, ILDAR.PAYMENTS.KPP, ILDAR.PAYMENTS.STATUS_DOC, ILDAR.PAYMENTS.SIGNERS FROM ILDAR.PAYMENTS WHERE ( ( ILDAR.PAYMENTS.DOC_ID = :DOC_ID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.PAYMENTS");
    aSpec.addColumn("PAYMENTS.DOC_ID", 12,12);
    aSpec.addColumn("PAYMENTS.CLIENT_ID", 4,4);
    aSpec.addColumn("PAYMENTS.DATE_DOC", 91,91);
    aSpec.addColumn("PAYMENTS.NUM_DOC", 12,12);
    aSpec.addColumn("PAYMENTS.PAYMENT_TYPE", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_INN", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_ACCOUNT", 1,1);
    aSpec.addColumn("PAYMENTS.AMOUNT", 3,3);
    aSpec.addColumn("PAYMENTS.PAYER_BANK_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.PAYER_BANK_BIC", 1,1);
    aSpec.addColumn("PAYMENTS.PAYER_BANK_ACC", 1,1);
    aSpec.addColumn("PAYMENTS.RCPT_INN", 12,12);
    aSpec.addColumn("PAYMENTS.RCPT_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.RCPT_ACCOUNT", 1,1);
    aSpec.addColumn("PAYMENTS.RCPT_BANK_NAME", 12,12);
    aSpec.addColumn("PAYMENTS.RCPT_BANK_BIC", 1,1);
    aSpec.addColumn("PAYMENTS.RCPT_BANK_ACC", 1,1);
    aSpec.addColumn("PAYMENTS.TYPE_OPER", 1,1);
    aSpec.addColumn("PAYMENTS.QUEUE", 1,1);
    aSpec.addColumn("PAYMENTS.TERM", 91,91);
    aSpec.addColumn("PAYMENTS.PAYMENT_DETAILS", 12,12);
    aSpec.addColumn("PAYMENTS.KPP", 12,12);
    aSpec.addColumn("PAYMENTS.STATUS_DOC", 1,1);
    aSpec.addColumn("PAYMENTS.SIGNERS", 1,1);
    aSpec.addParameter("DOC_ID", 12, 12);
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
504b030414g08g08ga48c502dgggggggggggg0cggg6275696c64657220646174618596cf6b134114c7
274953f5d283add65f114114048933b3f9b57ada264b599a6c63b2b1940a4b0eb528a168dd882078f222088220088227c18b
fd67fc1b04f1e0ffe0bcb714baf31deb6df9f07d8f37efbdf9ce7eff23aaf303b1b2b3d37f327d31adcfa6fb7bf57176f078
7fef9e1e9c397ca37f6e958578f95408f1d008971dbac31f0f7efdaebd5a3fd29533b1e8499daa4e262e44fd5e30aa0f83ed
411827e37ab23d0cd3cd61389a3f13af45f9b8ba9d892b967ad41d26e95a106fa441b77b3ce29496ed54a6d27cdded6d76d3
a887f95a27e55b8b0af9aa5afa94adfa683a7bbe8bb99a99a8fd33571c0c420c6964e2b22bc49c6473122718e061b738c09d
5e6762d5a58ee218c50acb371fe1c8d9db3c449e1862b56fd13721da9cf8bc15328ed6e3703446ad39ec455b9b04c9649c9a
71a2dc9cf6ac25df180e51670e7a15aba68fb4172641d47794624eba6c6f69381a58eba1693d16b283f92e64507e2656ac0c
f727e1244465874815799bc869e42d224b56292d2aa5ac25ca9b4456903788ac22f7885c42ae89d4902b22d7904b22d72dee
f146941462cf8dcd90cb4a1fe7958e54eeae7b3c6b4b9e736a8eafac9e79d4b3a5e290209406e9288c7ccc85db6edcb27145
49ed9636f1c48a4e5cb267ebb19fb85278ee2e286c66ce953b8db4719506eb3bafd39109d8c6c421a657e7ac9060601b1e2b
1d7e9f2777382407b4d033f2g67214db4d35c6d39248b1d667de41bf46281de43ab8b2703dbbb58ea30ea5e9084b6b6e2d3
e0cbba0909141ea4db8fa8b4e2abc76289edc7f7d1bc9e9dfcf52cd9f7a4417411432a5ac2e69468d36f148869fac2fe7c36
2b64a5f7c427f01630fbe13bc06c87ef01b31b7egccaef711309bde27c0ec799f01b3e57d2960f55fd7e04836c5af80d913
bf5903f2e84a59f79231598c07141c8669cb9d02cd8471c38dd137186b344ff607534803a8448fe15672e76f22e7d6df42ce
bdbf8d9c3b7b0739b7565b9bdbe47d2e1867c573dca9fcf786f7b1f317504b0708cc77e839e102ggfe0agg504b010214
g14g08g08ga48c502dcc77e839e102ggfe0agg0cggggggggggggggggg6275696c6465722064
617461504b0506gggg01g01g3aggg1b03gggg
**end of SQL Assist data**/    
   }
   /**
    * @return com.ibm.db.SQLStatementMetaData
    * @throws java.lang.Throwable
    * @roseuid 3E0041B600BF
    */
   public static com.ibm.db.SQLStatementMetaData PaymentUpdateSQL() throws java.lang.Throwable 
   {
  String name = "com.overstar.ildar.ibank.model.PaymentDAB.PaymentUpdateSQL";
  String statement = "UPDATE ILDAR.PAYMENTS SET DOC_ID = :DOC_ID, CLIENT_ID = :CLIENT_ID, DATE_DOC = :DATE_DOC, NUM_DOC = :NUM_DOC, PAYMENT_TYPE = :PAYMENT_TYPE, PAYER_INN = :PAYER_INN, PAYER_NAME = :PAYER_NAME, PAYER_ACCOUNT = :PAYER_ACCOUNT, AMOUNT = :AMOUNT, PAYER_BANK_NAME = :PAYER_BANK_NAME, PAYER_BANK_BIC = :PAYER_BANK_BIC, PAYER_BANK_ACC = :PAYER_BANK_ACC, RCPT_INN = :RCPT_INN, RCPT_NAME = :RCPT_NAME, RCPT_ACCOUNT = :RCPT_ACCOUNT, RCPT_BANK_NAME = :RCPT_BANK_NAME, RCPT_BANK_BIC = :RCPT_BANK_BIC, RCPT_BANK_ACC = :RCPT_BANK_ACC, TYPE_OPER = :TYPE_OPER, QUEUE = :QUEUE, TERM = :TERM, PAYMENT_DETAILS = :PAYMENT_DETAILS, KPP = :KPP, STATUS_DOC = :STATUS_DOC, SIGNERS = :SIGNERS WHERE ( ( ILDAR.PAYMENTS.DOC_ID = :ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("DOC_ID", 12, 12);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("DATE_DOC", 91, 91);
    aSpec.addParameter("NUM_DOC", 12, 12);
    aSpec.addParameter("PAYMENT_TYPE", 12, 12);
    aSpec.addParameter("PAYER_INN", 12, 12);
    aSpec.addParameter("PAYER_NAME", 12, 12);
    aSpec.addParameter("PAYER_ACCOUNT", 1, 1);
    aSpec.addParameter("AMOUNT", 3, 3);
    aSpec.addParameter("PAYER_BANK_NAME", 12, 12);
    aSpec.addParameter("PAYER_BANK_BIC", 1, 1);
    aSpec.addParameter("PAYER_BANK_ACC", 1, 1);
    aSpec.addParameter("RCPT_INN", 12, 12);
    aSpec.addParameter("RCPT_NAME", 12, 12);
    aSpec.addParameter("RCPT_ACCOUNT", 1, 1);
    aSpec.addParameter("RCPT_BANK_NAME", 12, 12);
    aSpec.addParameter("RCPT_BANK_BIC", 1, 1);
    aSpec.addParameter("RCPT_BANK_ACC", 1, 1);
    aSpec.addParameter("TYPE_OPER", 1, 1);
    aSpec.addParameter("QUEUE", 1, 1);
    aSpec.addParameter("TERM", 91, 91);
    aSpec.addParameter("PAYMENT_DETAILS", 12, 12);
    aSpec.addParameter("KPP", 12, 12);
    aSpec.addParameter("STATUS_DOC", 1, 1);
    aSpec.addParameter("SIGNERS", 1, 1);
    aSpec.addParameter("ID", 12, 12);
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
504b030414g08g08g0f91502dgggggggggggg0cggg6275696c64657220646174618555cd6ed34010de
a44df347d2b4e1ca911b8a1c9784b29c1cc7aaacc68e891d50d583950354455104c14148489c781cfa323c0312e2c03bb0b3
1baf77674d3944d9197f33bbf3ed37b3dfff90da6e4b1e5e5fcfdead3ead06ebd5e6661067dbdbcdcd0b3b68de7db37fbeae
12f2f93d2164c280fd12dcdd8f57bf7e3ffa7291e3aa19698d2d2b9dceddd49f66a44ec56af7817c25550138b0ad61462a43
d5d785a0c8b9f21669e8045e46dab4b054600780eeccf7c2846fd0a2d2306022831f86g93860aebef610164987a89e3cfe2
8cf42872a921ed917596c6fe45e82d625cc5297c131b4d9cf0329df8ae01290e56408ea9ee51035a9033a753cf75526ce7b8
ee7c1926a588851b252235436144ddb6ce532bb5b0bf366491ccdbf567536731d813a231d147d58a8bd3d3b4a15cc95683ee
97da190182ced8a59a43853fe07c388907a4e0ed1a902bf116012b80c2bf562a445e4691a1bda28eb212b89e9d40d05ba762
a551655bcf81aadadbd5fae31bedacb2342ec226cdd7287cc4f9b70c0127579197ce236f010296060afedf35f5a406fe2192
fc1ef526403281e370ee0e29fb33049af3a347f5d4cc707e0ca88cd9efb1e619b12d36bbf5fabebe2ad131ee2b0ed1fa0ae9
a8236929bbf493229d64ad4b358721cae2a2f55c4dc8f572e92dd92e47942fb47138b46c1cc27c3022cf8cc1132e8332dd73
09c789932ce3b2cfbc56656896f4a84cdca0fba521e4a2e99a345f1bb754f46d19ada77aaf0bc831d53dc6bba016d6a685a5
494d6696f7d5a1aa6d80755d76a86adf33434b663a9a601ca14e3034d159cf8ea167abb6d6f17da460414e8f2217caf41432
1d998f2cfb64c3a7c36cbbd36652471e566cd0a2d240efc233f12e1c50f4b4021fca6442ca3d07e51abb3678101fcc25d254
1e6a948d1d16cc275a3f41c8be9f2ac3bf504b0708f7b2acaca302ggc608gg504b010214g14g08g08g0f91502df7
b2acaca302ggc608gg0cggggggggggggggggg6275696c6465722064617461504b0506gggg01
g01g3agggdd02gggg
**end of SQL Assist data**/    
   }
}
