package com.overstar.ildar.ibank.model.documents;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class AccreditivDAB extends DatabaseAccess {
public static com.ibm.db.SQLStatementMetaData AccreditivDeleteSQL() throws java.lang.Throwable {
  String name = "com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivDeleteSQL";
  String statement = "DELETE FROM ILDAR.ACCREDITIVS WHERE ( ( ILDAR.ACCREDITIVS.DOC_ID = :DOC_ID ) )";

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
504b030414g08g08g435f4d2egggggggggggg0cggg6275696c64657220646174615bf39681b5b48841
243ada272bb12c512f27312f5d2fb8a428332fdddac897736d8bd193702606868a020606067ea042612cead65e0a7bfe52b6
da1da68ea98481d9c8c0b08481d1b0b490a18e810922c66e6460116f106f802ece6a68600c1215f4f471710cd27374760e72
75f10cf10c0b46516564600952c59a9698539c8a26630a36d5g4d94085319cd80581545c4b4848125af3427075990d9d0c0
08ddd9403190174dd02c350359ca6484ee161390309b8bbf73bca70b9a9411488aa5a4a834152db4cc21a1c56e85a98dd902
64395813g504b07081c8d882bd5gggc201gg504b010214g14g08g08g435f4d2e1c8d882bd5gggc201gg0c
ggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg0f01ggg
g
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData AccreditivInsertSQL() throws java.lang.Throwable {
  String name = "com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivInsertSQL";
  String statement = "INSERT INTO ILDAR.ACCREDITIVS ( DOC_ID, CLIENT_ID, DATE_DOC, NUM_DOC, ACCREDITIV_TYPE, PAYER_INN, PAYER_NAME, PAYER_ACCOUNT, AMOUNT, PAYER_BANK_NAME, PAYER_BANK_BIC, PAYER_BANK_ACC, RCPT_INN, RCPT_NAME, RCPT_ACCOUNT, RCPT_BANK_NAME, RCPT_BANK_BIC, RCPT_BANK_ACC, ACCOUNT_40901, TYPE_OPER, TERM, TYPE_ACCREDITIV1, TYPE_ACCREDITIV2, CONDITION_PAY, ACCREDITIV_DETAILS, ACCREDITIV_DOCS, ADD_CONDITION, STATUS_DOC, SIGNERS ) VALUES ( :DOC_ID, :CLIENT_ID, :DATE_DOC, :NUM_DOC, :ACCREDITIV_TYPE, :PAYER_INN, :PAYER_NAME, :PAYER_ACCOUNT, :AMOUNT, :PAYER_BANK_NAME, :PAYER_BANK_BIC, :PAYER_BANK_ACC, :RCPT_INN, :RCPT_NAME, :RCPT_ACCOUNT, :RCPT_BANK_NAME, :RCPT_BANK_BIC, :RCPT_BANK_ACC, :ACCOUNT_40901, :TYPE_OPER, :TERM, :TYPE_ACCREDITIV1, :TYPE_ACCREDITIV2, :CONDITION_PAY, :ACCREDITIV_DETAILS, :ACCREDITIV_DOCS, :ADD_CONDITION, :STATUS_DOC, :SIGNERS )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("DOC_ID", 12, 12);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("DATE_DOC", 91, 91);
    aSpec.addParameter("NUM_DOC", 12, 12);
    aSpec.addParameter("ACCREDITIV_TYPE", 12, 12);
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
    aSpec.addParameter("ACCOUNT_40901", 12, 12);
    aSpec.addParameter("TYPE_OPER", 1, 1);
    aSpec.addParameter("TERM", 91, 91);
    aSpec.addParameter("TYPE_ACCREDITIV1", 12, 12);
    aSpec.addParameter("TYPE_ACCREDITIV2", 12, 12);
    aSpec.addParameter("CONDITION_PAY", 12, 12);
    aSpec.addParameter("ACCREDITIV_DETAILS", 12, 12);
    aSpec.addParameter("ACCREDITIV_DOCS", 12, 12);
    aSpec.addParameter("ADD_CONDITION", 12, 12);
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
504b030414g08g08g175d4d2egggggggggggg0cggg6275696c64657220646174618555cb6ed340149d
8656cd83a44913b1eb926d644f0882e9cab5adca22b123db29aabab0b24015288a4ae4a04a48acf81cfa337c031262c13f30
633b9e997b87761165e6faccdcd7b9677efc2547bb2d19dddccc3eadbeacc6ebd5e6769ce4db8f9bdb733a6f3d7ca7bfde37
08b9bf2384381c3834e01e7e5efdfe73f6f5728f6be46430b56816bb8b34bb70c277d945e0e6a4c734c3ee33f9461a0adc71
dd6819a6d92bebad650bb86650e19da935c992e032f4e3242707dab753f16de15cfbb1e25a87b405c48bdc2cf0e0a7813c5d
7987889140a4d70b5fg62df0bd2e08a1aaf91d97224441cd91c61716430f39c782cef4a9e7266c3ab8620e3d099fb10d311
050e977391764e9aac5aaa90e745559cd42f31faf96eddcff2f636ab37286f370a45a051288232548677daf324aae8b46ag
41557e8390235b6cbf56413d59g53ee2f2a7255f5cb3c3f75821927ce90612ba01245543a61ba057442f714b9dc4d9f0113
889d6649eaa4cba4ac7b87c91dea803b0b7c3e1082b76d566f507d01817b4c33203820aa3aa7dc80a8a66423a809cbddafb9
ff9f092ac6cf999b3e15e1gfef4986650e107aff9efa56699e6e470b35baf1f9304c33876eba04d0c7a36b56cb13d43f322
a9094ed81612056e13b34b9192d573a9e30b5aabd43084ac1002c92045396bdc05ad1d890358d7060cda10290b40b4f06341
ca7a033a4e6bc13d66e5ea29e7b6c139567a495553e3bab20a4593daacde2075acdf9326ab9648d9806e1964180d3fc2502c
d57d064c609c2818a72e53f78fbc3b86b7ef541ff8328013a65b807a4e8ceaa9dfdb2c3ae8c773feb431f18f8ba73fef86c2
2061d1945398d0d320dfab16dbafd19028040513f9464472986f771f402e932a17a45cb456ae6356ae903b856f68a0a9f64e
7598dcfd03504b0708cc41cd329702gg8909gg504b010214g14g08g08g175d4d2ecc41cd329702gg8909gg0c
ggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3agggd102ggg
g
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData AccreditivSelectSQL() throws java.lang.Throwable {
  String name = "com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivSelectSQL";
  String statement = "SELECT ILDAR.ACCREDITIVS.DOC_ID, ILDAR.ACCREDITIVS.CLIENT_ID, ILDAR.ACCREDITIVS.DATE_DOC, ILDAR.ACCREDITIVS.NUM_DOC, ILDAR.ACCREDITIVS.ACCREDITIV_TYPE, ILDAR.ACCREDITIVS.PAYER_INN, ILDAR.ACCREDITIVS.PAYER_NAME, ILDAR.ACCREDITIVS.PAYER_ACCOUNT, ILDAR.ACCREDITIVS.AMOUNT, ILDAR.ACCREDITIVS.PAYER_BANK_NAME, ILDAR.ACCREDITIVS.PAYER_BANK_BIC, ILDAR.ACCREDITIVS.PAYER_BANK_ACC, ILDAR.ACCREDITIVS.RCPT_INN, ILDAR.ACCREDITIVS.RCPT_NAME, ILDAR.ACCREDITIVS.RCPT_ACCOUNT, ILDAR.ACCREDITIVS.RCPT_BANK_NAME, ILDAR.ACCREDITIVS.RCPT_BANK_BIC, ILDAR.ACCREDITIVS.RCPT_BANK_ACC, ILDAR.ACCREDITIVS.ACCOUNT_40901, ILDAR.ACCREDITIVS.TYPE_OPER, ILDAR.ACCREDITIVS.TERM, ILDAR.ACCREDITIVS.TYPE_ACCREDITIV1, ILDAR.ACCREDITIVS.TYPE_ACCREDITIV2, ILDAR.ACCREDITIVS.CONDITION_PAY, ILDAR.ACCREDITIVS.ACCREDITIV_DETAILS, ILDAR.ACCREDITIVS.ACCREDITIV_DOCS, ILDAR.ACCREDITIVS.ADD_CONDITION, ILDAR.ACCREDITIVS.STATUS_DOC, ILDAR.ACCREDITIVS.SIGNERS FROM ILDAR.ACCREDITIVS WHERE ( ( ILDAR.ACCREDITIVS.DOC_ID = :DOC_ID ) )";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.ACCREDITIVS");
    aSpec.addColumn("ACCREDITIVS.DOC_ID", 12,12);
    aSpec.addColumn("ACCREDITIVS.CLIENT_ID", 4,4);
    aSpec.addColumn("ACCREDITIVS.DATE_DOC", 91,91);
    aSpec.addColumn("ACCREDITIVS.NUM_DOC", 12,12);
    aSpec.addColumn("ACCREDITIVS.ACCREDITIV_TYPE", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_INN", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_ACCOUNT", 1,1);
    aSpec.addColumn("ACCREDITIVS.AMOUNT", 3,3);
    aSpec.addColumn("ACCREDITIVS.PAYER_BANK_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_BANK_BIC", 1,1);
    aSpec.addColumn("ACCREDITIVS.PAYER_BANK_ACC", 1,1);
    aSpec.addColumn("ACCREDITIVS.RCPT_INN", 12,12);
    aSpec.addColumn("ACCREDITIVS.RCPT_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.RCPT_ACCOUNT", 1,1);
    aSpec.addColumn("ACCREDITIVS.RCPT_BANK_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.RCPT_BANK_BIC", 1,1);
    aSpec.addColumn("ACCREDITIVS.RCPT_BANK_ACC", 1,1);
    aSpec.addColumn("ACCREDITIVS.ACCOUNT_40901", 12,12);
    aSpec.addColumn("ACCREDITIVS.TYPE_OPER", 1,1);
    aSpec.addColumn("ACCREDITIVS.TERM", 91,91);
    aSpec.addColumn("ACCREDITIVS.TYPE_ACCREDITIV1", 12,12);
    aSpec.addColumn("ACCREDITIVS.TYPE_ACCREDITIV2", 12,12);
    aSpec.addColumn("ACCREDITIVS.CONDITION_PAY", 12,12);
    aSpec.addColumn("ACCREDITIVS.ACCREDITIV_DETAILS", 12,12);
    aSpec.addColumn("ACCREDITIVS.ACCREDITIV_DOCS", 12,12);
    aSpec.addColumn("ACCREDITIVS.ADD_CONDITION", 12,12);
    aSpec.addColumn("ACCREDITIVS.STATUS_DOC", 1,1);
    aSpec.addColumn("ACCREDITIVS.SIGNERS", 1,1);
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
504b030414g08g08g85594d2egggggggggggg0cggg6275696c64657220646174618d96dd6a135110c7
4f92a6ea8d20163faad5fa0982d4f391a4590bc236bb94c5641336db4ae9c5928b5a9550b46e4410bcf2450441100b82e095
e03bf80c8278e13b7866b66a7366d2f62ef931ff396767e6fccff9f85b54473b626663a3fd64f062b0301c6c6f2df4f39dc7
db5b4bba7362f78dfef1a02cc4cba742884736f03413b7fb7dede7afb9572b7fe3cab998365267aa998bcb513bf09305bfd5
4ac2204aa3b53efceeaec66956939e54a367e2b528ef172db2a2a4d54bb3653fbe9f59ba5f744ccbc54c66d2feba1b745b59
14d0948d43522e476329ab5a7a90b0fa70307cbe49d3d573317f50bad8ef845455cbc5a509aabd8a508dc9c585091a7e119d
8bd90982288e69bc623fa5e7af87095bed42250f5339059df6ac4adb69384f55fd68250e933e0db7737091094ffd74b59fd9
4e5305df663f08b25637867fdd988a6c33afb033baf71b96627667bb79fd605998fa519b511a7697ff7698d9325291edeb55
2a4ad77b61f61f68aa5347d129aab31d3ec3e8c2a4e31c140d07652adf196d9224ca63a71717eff6c2840a9a40aa942f0239
4e7903c849caeb40669c9d3660a7652d69780dc859ca0d9059ca359039ca159079ca25906b0e3778204a6eed0d0e3e87ed74
9795db628303ccf2da046e26704d78a52915df5c8393c5a681227bcaa9bd81da9f22b340d43032ccb7c345c22da6f85281df
8fe38a929a0fa5d5b3b1f6db4aee9c1874702ec584822a5ad0822b3e8d74711586c763ed699fd5baf7gaa6cbdce31eed471
6f190ce62fdc6209e666424d8335e742c3eea8ce7a4121706e268caf1d66cb60234465d82b265eedb8170646f39765e0a7a1
1b5ef16026cada233914fb5dad7614da17cef85b04e325db19fa70b1cf9a66f1ac29b987a906749a4a2a5a92d12ac151b831
466c27a6b647c3e15856b8d63dg6f0946537e47307af27b82d1923f108c8ebc4b303aef2782d1783f138cbefb650caba358
0b8ad19cbf128cdefccd69938163e79c5dc4e0d88650e24248a95f23a6868398ba3562c65bb012d8949b245c13f32dc2b159
b748388c4b8d46630f6f936839612fd8db3b9463739978ec6e9d726c6f9372ecdc12e5d8ba7bcee1a8e3911933ef8a610e6f
f190c5910ffeg504b0708420e2d9a2f03gg040dgg504b010214g14g08g08g85594d2e420e2d9a2f03gg040dg
g0cggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3aggg6903g
ggg
**end of SQL Assist data**/
}
public static com.ibm.db.SQLStatementMetaData AccreditivUpdateSQL() throws java.lang.Throwable {
  String name = "com.overstar.ildar.ibank.model.documents.AccreditivDAB.AccreditivUpdateSQL";
  String statement = "UPDATE ILDAR.ACCREDITIVS SET DOC_ID = :DOC_ID, CLIENT_ID = :CLIENT_ID, DATE_DOC = :DATE_DOC, NUM_DOC = :NUM_DOC, ACCREDITIV_TYPE = :ACCREDITIV_TYPE, PAYER_INN = :PAYER_INN, PAYER_NAME = :PAYER_NAME, PAYER_ACCOUNT = :PAYER_ACCOUNT, AMOUNT = :AMOUNT, PAYER_BANK_NAME = :PAYER_BANK_NAME, PAYER_BANK_BIC = :PAYER_BANK_BIC, PAYER_BANK_ACC = :PAYER_BANK_ACC, RCPT_INN = :RCPT_INN, RCPT_NAME = :RCPT_NAME, RCPT_ACCOUNT = :RCPT_ACCOUNT, RCPT_BANK_NAME = :RCPT_BANK_NAME, RCPT_BANK_BIC = :RCPT_BANK_BIC, RCPT_BANK_ACC = :RCPT_BANK_ACC, ACCOUNT_40901 = :ACCOUNT_40901, TYPE_OPER = :TYPE_OPER, TERM = :TERM, TYPE_ACCREDITIV1 = :TYPE_ACCREDITIV1, TYPE_ACCREDITIV2 = :TYPE_ACCREDITIV2, CONDITION_PAY = :CONDITION_PAY, ACCREDITIV_DETAILS = :ACCREDITIV_DETAILS, ACCREDITIV_DOCS = :ACCREDITIV_DOCS, ADD_CONDITION = :ADD_CONDITION, STATUS_DOC = :STATUS_DOC, SIGNERS = :SIGNERS WHERE ( ( ILDAR.ACCREDITIVS.DOC_ID = :ID ) )";

  SQLStatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.SQLStatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addParameter("DOC_ID", 12, 12);
    aSpec.addParameter("CLIENT_ID", 4, 4);
    aSpec.addParameter("DATE_DOC", 91, 91);
    aSpec.addParameter("NUM_DOC", 12, 12);
    aSpec.addParameter("ACCREDITIV_TYPE", 12, 12);
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
    aSpec.addParameter("ACCOUNT_40901", 12, 12);
    aSpec.addParameter("TYPE_OPER", 1, 1);
    aSpec.addParameter("TERM", 91, 91);
    aSpec.addParameter("TYPE_ACCREDITIV1", 12, 12);
    aSpec.addParameter("TYPE_ACCREDITIV2", 12, 12);
    aSpec.addParameter("CONDITION_PAY", 12, 12);
    aSpec.addParameter("ACCREDITIV_DETAILS", 12, 12);
    aSpec.addParameter("ACCREDITIV_DOCS", 12, 12);
    aSpec.addParameter("ADD_CONDITION", 12, 12);
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
504b030414g08g08ged5e4d2egggggggggggg0cggg6275696c64657220646174618d56cd6eda4010de
4028040a8110e5d663af6871024db627c7b622b760906d524539581cd22815422d3555a54a3df5719a97e93354aa7ae83bd4
bb1bd6bb332ee901b13bfe6676e7ef9bfdfe8754d62b72787d3d7a37ff34ef2de6cbdb5e94aeee96b72fadf1defd37ebe79b
12219fdf13425e65c06e01eefec7e5afdfcfbe5c6c70a594d4879426eec4497c3725552657eb0fe42b294940d9a2fd94ecf4
75598b2b4ded2b2f4c027beca5a4c1f29d0e6c72a033f2bd201607d499da2098b4e0070187a98d0eeb7098edba8933095c3f
f62719b4c50c810eef0ab8e3841eff76c9bd8c52d26640a4ab3406f43889fc8bc00b23e8f401ff26ef756e07af9373df4190
dc8f1cb2cf4c89ae50e73637d1376d75f2e3b20b4f66410c11871c115f4d3dcd49abd04ce84c63797e868488aa454f139a50
28aff433cd4cdaf147ae1df6f233a2c72e81eaa50b42278bc6c43478ec54e86bec6189f20f7c693143a0c39f8ae0dab1c723
0c8f3b82c5e1c5b63fca4eee322c450155f5c6bd82a66bdc74ec85e32c868cff1bad9387a2280aa21dedb14c7795c9959115
8b9ef1ac54dece171f6f0c775574440fedb1cd1a65427390670e25dea203510e14f5a848f464ea85bc47d50628ff47d5b455
55fea3b645636ce2607eda1966bfe786649092dde57ab1d8d6ae05950fdb55408c760515d554d72eca5d2737a7bc6a314380
ca33cf9769abdca7a8953319efac634458c16c5c54e2a2d4a2d88e6751d167715d50c82d660890ef1a95032e52d561705187
41d9634afd0225cc13cae31a7b58a24ec81b7f8f6dd6a83e72ee284ae881c93712b2cf4c099a8b7ac41b2cdf6d1b4db20d8d
d1c4458877c0f02b605934ef4c4c5bb9a44ab4c9f4fd96d95130f0g230b84cec860dc65e430e4e450b2288a061a0f6d0644
c0d209b7f4043f588e601836cc8e58cee21676d3d5fa06075a462339a167f8f9d3545ecb9bd699dae0e78a69a8c50c0198c3
2fe41c2e33f03c523356522fa085536e18b951134a620a81dbe7c458443cd9a5f9d6fa0b504b0708b35b0b15e802gg700a
gg504b010214g14g08g08ged5e4d2eb35b0b15e802gg700agg0cggggggggggggggggg6275
696c6465722064617461504b0506gggg01g01g3aggg2203gggg
**end of SQL Assist data**/
}
public static com.ibm.db.DatabaseConnection connToIBank() throws java.lang.Throwable, com.ibm.db.DataException {
  com.ibm.db.DatabaseConnection connection = null;
  try{ 
    connection = new com.ibm.db.DatabaseConnection();
    connection.setConnectionAlias("com.overstar.ildar.ibank.model.documents.AccreditivDAB.connToIBank");
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
public static com.ibm.db.StatementMetaData IClientAccreditivsSelectSQL() throws java.lang.Throwable {
  String name = "com.overstar.ildar.ibank.model.documents.AccreditivDAB.IClientAccreditivsSelectSQL";
  String statement = "SELECT ILDAR.ACCREDITIVS.DOC_ID, ILDAR.ACCREDITIVS.CLIENT_ID, ILDAR.ACCREDITIVS.DATE_DOC, ILDAR.ACCREDITIVS.NUM_DOC, ILDAR.ACCREDITIVS.ACCREDITIV_TYPE, ILDAR.ACCREDITIVS.PAYER_INN, ILDAR.ACCREDITIVS.PAYER_NAME, ILDAR.ACCREDITIVS.PAYER_ACCOUNT, ILDAR.ACCREDITIVS.AMOUNT, ILDAR.ACCREDITIVS.PAYER_BANK_NAME, ILDAR.ACCREDITIVS.PAYER_BANK_BIC, ILDAR.ACCREDITIVS.PAYER_BANK_ACC, ILDAR.ACCREDITIVS.RCPT_INN, ILDAR.ACCREDITIVS.RCPT_NAME, ILDAR.ACCREDITIVS.RCPT_ACCOUNT, ILDAR.ACCREDITIVS.RCPT_BANK_NAME, ILDAR.ACCREDITIVS.RCPT_BANK_BIC, ILDAR.ACCREDITIVS.RCPT_BANK_ACC, ILDAR.ACCREDITIVS.ACCOUNT_40901, ILDAR.ACCREDITIVS.TYPE_OPER, ILDAR.ACCREDITIVS.TERM, ILDAR.ACCREDITIVS.TYPE_ACCREDITIV1, ILDAR.ACCREDITIVS.TYPE_ACCREDITIV2, ILDAR.ACCREDITIVS.CONDITION_PAY, ILDAR.ACCREDITIVS.ACCREDITIV_DETAILS, ILDAR.ACCREDITIVS.ACCREDITIV_DOCS, ILDAR.ACCREDITIVS.ADD_CONDITION, ILDAR.ACCREDITIVS.STATUS_DOC, ILDAR.ACCREDITIVS.SIGNERS FROM ILDAR.ACCREDITIVS WHERE ( ( ILDAR.ACCREDITIVS.CLIENT_ID = :CLIENT_ID ) AND ( ILDAR.ACCREDITIVS.DATE_DOC between :FROMDATE and :TODATE ) ) ORDER BY ILDAR.ACCREDITIVS.DATE_DOC";

  StatementMetaData aSpec = null;
  try{
    aSpec = new com.ibm.db.StatementMetaData();
    aSpec.setName(name);
    aSpec.setSQL(statement);
    aSpec.addTable("ILDAR.ACCREDITIVS");
    aSpec.addColumn("ACCREDITIVS.DOC_ID", 12,12);
    aSpec.addColumn("ACCREDITIVS.CLIENT_ID", 4,4);
    aSpec.addColumn("ACCREDITIVS.DATE_DOC", 91,91);
    aSpec.addColumn("ACCREDITIVS.NUM_DOC", 12,12);
    aSpec.addColumn("ACCREDITIVS.ACCREDITIV_TYPE", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_INN", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_ACCOUNT", 1,1);
    aSpec.addColumn("ACCREDITIVS.AMOUNT", 3,3);
    aSpec.addColumn("ACCREDITIVS.PAYER_BANK_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.PAYER_BANK_BIC", 1,1);
    aSpec.addColumn("ACCREDITIVS.PAYER_BANK_ACC", 1,1);
    aSpec.addColumn("ACCREDITIVS.RCPT_INN", 12,12);
    aSpec.addColumn("ACCREDITIVS.RCPT_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.RCPT_ACCOUNT", 1,1);
    aSpec.addColumn("ACCREDITIVS.RCPT_BANK_NAME", 12,12);
    aSpec.addColumn("ACCREDITIVS.RCPT_BANK_BIC", 1,1);
    aSpec.addColumn("ACCREDITIVS.RCPT_BANK_ACC", 1,1);
    aSpec.addColumn("ACCREDITIVS.ACCOUNT_40901", 12,12);
    aSpec.addColumn("ACCREDITIVS.TYPE_OPER", 1,1);
    aSpec.addColumn("ACCREDITIVS.TERM", 91,91);
    aSpec.addColumn("ACCREDITIVS.TYPE_ACCREDITIV1", 12,12);
    aSpec.addColumn("ACCREDITIVS.TYPE_ACCREDITIV2", 12,12);
    aSpec.addColumn("ACCREDITIVS.CONDITION_PAY", 12,12);
    aSpec.addColumn("ACCREDITIVS.ACCREDITIV_DETAILS", 12,12);
    aSpec.addColumn("ACCREDITIVS.ACCREDITIV_DOCS", 12,12);
    aSpec.addColumn("ACCREDITIVS.ADD_CONDITION", 12,12);
    aSpec.addColumn("ACCREDITIVS.STATUS_DOC", 1,1);
    aSpec.addColumn("ACCREDITIVS.SIGNERS", 1,1);
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
504b030414g08g08ga15b4d2egggggggggggg0cggg6275696c64657220646174618d575d6b135110bd
491a9bfa56143faad5fa0982d47bf76ed26c0bc23659cb62b229c9b652fab0e4a1162514ad1b11049ffc39f6070882200882
e08308fe01417cf03f7867b66a7267b6e953d393397766ef9999b379f35b9487fbe2f4f676eb71ff797f71d0dfdb5deca5fb
8ff676579cf6ccc16be7c783a2102f9e08218626f0141377f075f3e7aff9976b7fe38aa938a1a593a87a2a2e87ada6df5df4
1b8d6ed00ce370b3079f3b1b519cb8d2936af854bc12c551d2124bea36d6e364d58fee27061d25951de925cafc7dd81f3cdb
19fd66da914b894c642a4e2e375a616052864d9aaf3621df6a48f3492e5f765c35150b471d17f9ed80b2dc545cca611d5e17
e5e8545cc8e1f0499c54cce510c228a2f18a7d94757f2be8b252642c3989655de809cfb01cd32ae729ab17ae4541b747c34d
935c64c2633fdee825cd0e938097d96f3693462782ff3a11251931afb00d7cf8195231d51935af1f4d0b623f6c314ccd56f9
afc2c45c2325195daf5252bcb51e24ff0187f2d471788af28cc267185ed06d8fc65660fc14f6c3f472dc69fa7160cd91c3cf
2d7e635853e9fe708764571edbf65875673de852421d9032c597ga950bc06c8ac55510d6a2d3a92865701394bc2654eb80b
c81cc53520f31477g59a0b802e41ac525203747f1922b4ded853121a733714c9133cbf7ba9db6ad8e394be350166cfd350e
1f079b092b2abbcd340e118bbb39b8cec11d8297eaf0645c9f68ec6ef61810c653965e1ae49d256d45a2e4c428376bde822d
bdc6ce65ee0d5c922b54f1d70c7e350e979474f8507af32656f1c5b9fc113962282a4686934ecb6069c36568568f5daf2356
61fb18b2cc7d9d63b66bdb76490ce6df26b2148cb322a7c69a4bc6612baab22b292358ce8af1ee245b816d46589ab5c868a3
6d1b1e46f3660f736e87973c89bbcd236728f6b9d877298c97ac32269d156cb64f3d7b332bd883e842d20a57267e090b8bcf
ef66d379dc6776700ec61ab8g9375630c31c24eed0d0783b14cf096e301f096c06835ef088c4ef39ec068341f088c86f291
c0681c9f088cbef199c0681b5fc66075acfd85ef70g7c23305acb774b750d536cad0284c13c3441c95243945a47055a44f1
8b432774b1214c1d05616687e115a15ab748b8430c220b47156f9370e8239746a3b87748b4cca90545677054bd4a7194bd4e
71d47d85e228e95d8aa3a63e194ec50e67151fb64650e27725cdac94ece7014e4efb0f504b07081df9f5137d03gg770eg
g504b010214g14g08g08ga15b4d2e1df9f5137d03gg770egg0cggggggggggggggggg627569
6c6465722064617461504b0506gggg01g01g3agggb703gggg
**end of SQL Assist data**/
}
}
