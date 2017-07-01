package com.overstar.ildar.ibank.model;

/**
 * Insert the type's description here.
 * Creation date: (31.01.2003 15:52:30)
 * @author: Shafigullin Ildar
 */
public class IBankTest {
   /**
    * Starts the application.
    * @param args an array of command-line arguments
    * @roseuid 3E00419B0323
    */
   public static void main(java.lang.String[] args) 
   {
    try {
        System.out.println("Main() started at: " + new java.util.Date());
        //testIBankRetrieval();
        testInsertIClientScenario();
        // другие тесты !

    }
    catch (Throwable ex) {
        System.out.println("An exception occured while testing:\n" + ex.toString());
        ex.printStackTrace();
    }

    System.out.println("Main() ended at: " + new java.util.Date());    
   }
   /**
    * Insert the method's description here.
    * Creation date: (19.09.2002 10:15:47)
    * @throws java.lang.Throwable
    * @exception java.lang.Throwable The exception description.
    * @roseuid 3E00419C02A2
    */
   private static void testIBankRetrieval() throws java.lang.Throwable 
   {
    IBank tempIBank;

    System.out.println("Test retrieval of an IBank.\n");

    System.out.println("Make new IBank with key 123.\n");
    tempIBank = new IBank(new IBank.IBankPK("123"));
    System.out.println(tempIBank);
    System.out.println("______________________________________");
    System.out.println();

    System.out.println("Find the IBank with key 123.\n");
    tempIBank = IBank.findWithIBankPK("123");
    System.out.println(tempIBank);
    System.out.println("______________________________________");
    System.out.println();    
   }
   /**
    * Insert the method's description here.
    * Creation date: (19.09.2002 10:42:27)
    * @throws java.lang.Throwable
    * @exception java.lang.Throwable The exception description.
    * @roseuid 3E00419C02FC
    */
   private static void testInsertIClientScenario() throws java.lang.Throwable 
   {
	IBank tempIBank;
	IClient tempIClient;

	System.out.println("InsertIClientScenario.\n");

	System.out.println("Get the IBank with key 123.\n");
	tempIBank = IBank.findWithIBankPK("123");
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
    String iClientStr = "1"; //заполните !
	System.out.println("Find a IClient with key" + iClientStr +".\n");
	tempIClient = IClientTransactionMgr.findWithIClientPK(iClientStr);
	System.out.println(tempIClient.toStringFull());
	System.out.println("______________________________________");
	System.out.println();

	System.out.println("Start the IBank.\n");
	tempIBank.initialize();
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Insert the IClient.\n");
	tempIBank.insertIClient(tempIClient);
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Enter PIN = 1.\n");
	tempIBank.enterPIN("1");
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();
	
	System.out.println("Stop this session.\n");
	tempIBank.stop();
	System.out.println(tempIBank);
	System.out.println("______________________________________");
	System.out.println();    
   }
}
