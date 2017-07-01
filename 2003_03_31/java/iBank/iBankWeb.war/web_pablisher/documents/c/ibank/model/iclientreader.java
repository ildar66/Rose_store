//Source file: C:\\Program Files\\Rational\\Rose\\java\\iBank\\com\\overstar\\ildar\\ibank\\model\\IClientReader.java

package com.overstar.ildar.ibank.model;


/**
 * IClientReader models instances of the IClient reading device of an IBank.
 * To indicate what is happening, these instances write messages
 * on the console (OUT).
 * Creation date: (18.09.2002 16:31:02)
 * @author: Shafigullin Ildar
 */
class IClientReader 
{
   private IClient currentIClient;
   
   /**
    * Accept a IClient inserted in the IBank,
    * or reject it by throwing an InvalidIClientException.
    * This implementation simply checks if the primary key
    * of the IClient represents a number (client_id).
    * Creation date: (18.09.2002 16:50:57)
    * @param aIClient com.overstar.ildar.ibank.model.IClient
    * @throws com.overstar.ildar.ibank.model.InvalidIClientException
    * @exception com.overstar.ildar.ibank.model.InvalidIClientException The exception 
    * description.
    * @roseuid 3E0041AC00D9
    */
   void acceptIClient(IClient aIClient) throws InvalidIClientException 
   {
    try {
        Integer.parseInt(aIClient.getClient_id().getIdAsString());
        currentIClient = aIClient;
//        System.out.println("IClientReader: Accepted  " + currentIClient + "\n");
    }
    catch (NumberFormatException ex) {
        throw new InvalidIClientException("The given IClient is not recognised.");
    }
    catch (NullPointerException ex) {
        throw new InvalidIClientException("The given IClient is not recognised.");
    }    
   }
   
   /**
    * Consumes current IClient.
    * NOTE: Crude implementation.
    * Creation date: (18.09.2002 16:56:34)
    * @roseuid 3E0041AC013D
    */
   void consumeCurrentIClient() 
   {
    if (currentIClient != null)
        System.out.println("IClientReader: Consuming  " + currentIClient + "\n");
    currentIClient = null;    
   }
   
   /**
    * Ejects current IClient.
    * NOTE: Crude implementation.
    * Creation date: (18.09.2002 16:59:27)
    * @roseuid 3E0041AC0147
    */
   void ejectCurrentIClient() 
   {
//    if (currentIClient != null)
//        System.out.println("IClientReader: Ejecting " + currentIClient + "\n");
    currentIClient = null;    
   }
   
   /**
    * Insert the method's description here.
    * Creation date: (18.09.2002 17:00:57)
    * @return com.overstar.ildar.ibank.model.IClient
    * @roseuid 3E0041AC015B
    */
   IClient getCurrentIClient() 
   {
	return currentIClient;    
   }
}
