package com.overstar.bank.database;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class BankAccountDAB extends DatabaseAccess {
public static com.ibm.db.StatementMetaData SelectAccounts$SQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.database.BankAccountDAB.SelectAccounts$SQL";
  String statement = "SELECT QRSDTTST.ACCOUNT$.ACCOUNT, QRSDTTST.ACCOUNT$.CLIENT, QRSDTTST.ACCOUNT$.USERTYPEACCOUNT, QRSDTTST.ACCOUNT$.OPEN_DATE, QRSDTTST.ACCOUNT$.CLOSE_DATE, QRSDTTST.ACCOUNT$.NAMEACCOUNT, QRSDTTST.ACCOUNT$.CODE_CURRENCY, QRSDTTST.ACCOUNT$.BALANCE FROM QRSDTTST.ACCOUNT$ WHERE ( ( QRSDTTST.ACCOUNT$.CLIENT = :CLIENT ) )";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("QRSDTTST.ACCOUNT$");
	aSpec.addColumn("ACCOUNT$.ACCOUNT", 1,1);
	aSpec.addColumn("ACCOUNT$.CLIENT", 4,4);
	aSpec.addColumn("ACCOUNT$.USERTYPEACCOUNT", 1,1);
	aSpec.addColumn("ACCOUNT$.OPEN_DATE", 91,91);
	aSpec.addColumn("ACCOUNT$.CLOSE_DATE", 91,91);
	aSpec.addColumn("ACCOUNT$.NAMEACCOUNT", 1,1);
	aSpec.addColumn("ACCOUNT$.CODE_CURRENCY", 4,4);
	aSpec.addColumn("ACCOUNT$.BALANCE", 1,1);
	aSpec.addParameter("CLIENT", 4, 4);
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
504b030414g08g08g3864112bgggggggggggg0cggg6275696c64657220646174618d93514bc25014c7
8f33b3108250080c8ba81e7a1977774e5d3ead3922d0cdb659880fe283492152768d20e8a98f935fa6cf10440f7d87766691
de7b851ef7dbff7fee39e7feefeb17a42663c8753af59bde434f1df646033560e3ebd1a04a1bebd317fa7ea9g3cde02c051
24cc4a74d3b78b8fcfc2d3e9af4e6190a4446390d02677f00cca8ca57442bb6506dbe77e50b3422b0c42d5b26dafe58607ea
8955b75cdb11f425067b32bdedd59caeddf27dc7b5db82cb60b02b73b956c3f9f9103c45063bd293ea5ee074232c36a73328
c82c5ed371e50eca605fe668058e1fb69b4b9b8b9699973777e648e464c99625e5d39454ba041ddc6d6944479a95d459d051
62a22e75d51bdef7b93f465c9770f47f754d4c0b82b5799c34e360550469094146c006820d0117116ccee34494b4c4a120d4
11e4168451b8327fcd57050b45b025600d415ec004416161445d1c31a911cadf50c434c9764bb85d85f2b888785592173acb
cb0a1b4ffa5c773a3e572e1648715545811abc368a567916adf4b1e460f4448f4e3117a7aae054f26e74411d63613331d5a4
4dc639ff06504b0708d1d5560c9d01ggf504gg504b010214g14g08g08g3864112bd1d5560c9d01ggf504gg0c
ggggggggggggggggg6275696c6465722064617461504b0506gggg01g01g3agggd701ggg
g
**end of SQL Assist data**/
}
public static com.ibm.db.StatementMetaData SelectAccountsSQL() throws java.lang.Throwable {
  String name = "com.overstar.bank.database.BankAccountDAB.SelectAccountsSQL";
  String statement = "SELECT QRSDTTST.ACCOUNT.ACCOUNT, QRSDTTST.ACCOUNT.CLIENT, QRSDTTST.ACCOUNT.USERTYPEACCOUNT, QRSDTTST.ACCOUNT.OPEN_DATE, QRSDTTST.ACCOUNT.CLOSE_DATE, QRSDTTST.ACCOUNT.NAMEACCOUNT, QRSDTTST.ACCOUNT.CODE_CURRENCY, QRSDTTST.ACCOUNT.BALANCE FROM QRSDTTST.ACCOUNT WHERE ( ( QRSDTTST.ACCOUNT.CLIENT = :CLIENT ) ) ORDER BY QRSDTTST.ACCOUNT.ACCOUNT";

  StatementMetaData aSpec = null;
  try{
	aSpec = new com.ibm.db.StatementMetaData();
	aSpec.setName(name);
	aSpec.setSQL(statement);
	aSpec.addTable("QRSDTTST.ACCOUNT");
	aSpec.addColumn("ACCOUNT.ACCOUNT", 1,1);
	aSpec.addColumn("ACCOUNT.CLIENT", 4,4);
	aSpec.addColumn("ACCOUNT.USERTYPEACCOUNT", 1,1);
	aSpec.addColumn("ACCOUNT.OPEN_DATE", 91,91);
	aSpec.addColumn("ACCOUNT.CLOSE_DATE", 91,91);
	aSpec.addColumn("ACCOUNT.NAMEACCOUNT", 1,1);
	aSpec.addColumn("ACCOUNT.CODE_CURRENCY", 4,4);
	aSpec.addColumn("ACCOUNT.BALANCE", 1,1);
	aSpec.addParameter("CLIENT", 4, 4);
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
504b030414g08g08g16900f2bgggggggggggg0cggg6275696c64657220646174619593cb4ac3401486
4f536b1141f002a2582982db3099496fba8a318850536d52455c842e549452b44e45105cf938fa323e83202e7c0773d28a26
e708ba0b5ffe7fe65cfe79fa80c270g0b2727cdcbee6dd7ec75fbe766a00717fdf34db937f5fc285f8f0c80bb2bg3063e1
3ca37b7e397c7b2fddef7ce90c0d795b581a72d6f01a1ec018334959410919d5342c1fb4836d2774c220341dd76d75fcd0dc
729a8eef7a445ed55066e46e6bdb8bdc4ebbedf9ee31315534ac3226dfd9f3c6dfc4626b2871f7345b8117c59456a634ac30
8ed6bee7f306a9618d317402af1d1eefff5a593cc625b6b25d8f510b7ebccce14529ea914043664b965048e7e8312999140d
9415cebabd9bd3d41f7b54474e64f41596fee9b2062607c1742a648d24647522ad229821b88260f627ced548fb28b4112ca4
8471100d679d281582c594324edff4773b9bc422112c136c2128112c1094535d2bda75be9eec2274b69aa9e0e52d21c9d3b4
12bfc8ec4cfd233bf1daaa283764769b36e249269c72148a093d189e669a5411b705856f3f67135ac96ae320d746412e6e30
17a3277edd46233d843a0e81af46117582c920136ab14526afea13504b070847fa8825b301gg6f05gg504b010214g14
g08g08g16900f2b47fa8825b301gg6f05gg0cggggggggggggggggg6275696c64657220646174
61504b0506gggg01g01g3aggged01gggg
**end of SQL Assist data**/
}
}
