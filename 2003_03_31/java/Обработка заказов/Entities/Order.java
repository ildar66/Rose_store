//Source file: C:\\Program Files\\Rational\\Rose\\java\\Обработка заказов\\Entities\\Order.java

/**
 * Copyright
 * Автор Шафигуллин Илдар
 */

package Entities;


public class Order 
{
   private Integer OrderNumber;
   private String CustomerName;
   private java.util.Date OrderDate;
   private java.util.Date OrderFillDate;
   public OrderItem theOrderItem[];
   
   /**
    * @roseuid 3D49082C00D0
    */
   public Order() 
   {
    
   }
   
   /**
    * @return Boolean
    * @roseuid 3D3E59A00299
    */
   public Boolean Create() 
   {
    return null;
   }
   
   /**
    * @param OrderNum
    * @param Customer
    * @param OrderDate
    * @param FillDate
    * @return Boolean
    * @roseuid 3D3E59BE0108
    */
   public Boolean SetInfo(Integer OrderNum, String Customer, java.util.Date OrderDate, java.util.Date FillDate) 
   {
    return null;
   }
   
   /**
    * @return String
    * @roseuid 3D3E690001E6
    */
   public String GetInfo() 
   {
    return null;
   }
}
