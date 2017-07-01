VERSION 1.0 CLASS
BEGIN
  MultiUse = 0   'False
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Order"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = "The order class represent an order, placed by a customer,\r\nand persistently stored in the OrderSystem data base.\r\nAn order is uniquely identified using an order id number.\r\nAn order consists of order rows, enumerating the\r\nquantities of each article ordered."
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3237F8CD03CD"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
'The order class represent an order, placed by a customer,
'and persistently stored in the OrderSystem data base.
'An order is uniquely identified using an order id number.
'An order consists of order rows, enumerating the
'quantities of each article ordered.
Option Explicit


'##ModelId=3237F8CE01A3
Private Orderrows As Collection

'##ModelId=3237F8CC021E
Private mPurchaser As Customer

'##ModelId=3237F8CE0053
Private mOrderId As Variant

'Stores the order, initiates shipping and invoice.
'##ModelId=3237F8CD03CE
Public Sub Register()
Attribute Register.VB_Description = "Stores the order, initiates shipping and invoice."
    On Error GoTo Order_Register__exception
    MsgBox "Order: " & mOrderId & " registered."
    Exit Sub
Order_Register__exception:
    Resume Order_Register__end
Order_Register__end:
    Exit Sub
End Sub

'Calculates the total sum of the order.
'##ModelId=3237F8CE001E
Public Property Get Sum() As Currency
Attribute Sum.VB_Description = "Calculates the total sum of the order."
    On Error GoTo Order_Sum__exception
    Dim temp_sum As Currency
    Dim an_orderrow As OrderRow
    'Initilize the sum
    temp_sum = 0
    'Iterate over the order rows and calculate the sum
    For Each an_orderrow In Orderrows
        temp_sum = temp_sum + an_orderrow.Sum
    Next
    'Return the calculated sum
    Sum = temp_sum
    Exit Property
Order_Sum__exception:
    Resume Order_Sum__end
Order_Sum__end:
    Exit Property
End Property

'Adds an order row to the order.
'##ModelId=3237F8CE001F
Public Sub AddOrderRow(new_order_row As OrderRow)
Attribute AddOrderRow.VB_Description = "Adds an order row to the order."
    On Error GoTo Order_AddOrderRow__exception
    Orderrows.Add new_order_row
    Exit Sub
Order_AddOrderRow__exception:
    Resume Order_AddOrderRow__end
Order_AddOrderRow__end:
    Exit Sub
End Sub

'##ModelId=3237F8CE0021
Public Property Get Purchaser() As Customer
    On Error GoTo Order_Purchaser__exception
    Purchaser = mPurchaser
    Exit Property
Order_Purchaser__exception:
    Resume Order_Purchaser__end
Order_Purchaser__end:
    Exit Property
End Property

'##ModelId=3237F8CE0022
Public Property Set Purchaser(value As Customer)
    On Error GoTo Order_Purchaser__exception
    Set mPurchaser = value
    Exit Property
Order_Purchaser__exception:
    Resume Order_Purchaser__end
Order_Purchaser__end:
    Exit Property
End Property

'##ModelId=3237F8CE0024
Public Property Get OrderId() As Variant
    On Error GoTo Order_OrderId__exception
    OrderId = mOrderId
    Exit Property
Order_OrderId__exception:
    Resume Order_OrderId__end
Order_OrderId__end:
    Exit Property
End Property

'##ModelId=3237F8CE0025
Public Property Let OrderId(value As Variant)
    On Error GoTo Order_OrderId__exception
    mOrderId = value
    Exit Property
Order_OrderId__exception:
    Resume Order_OrderId__end
Order_OrderId__end:
    Exit Property
End Property

'##ModelId=3237F8CE0051
Private Sub Class_Initialize()
    On Error GoTo Order_Class_Initialize__exception
    'allocate the object attributes
    Set Orderrows = New Collection
    'set the order id to something
    mOrderId = 123
    Exit Sub
Order_Class_Initialize__exception:
    Resume Order_Class_Initialize__end
Order_Class_Initialize__end:
    Exit Sub
End Sub

'##ModelId=3237F8CE0052
Private Sub Class_Terminate()
    On Error GoTo Order_Class_Terminate__exception
    'Deallocate the orderrows
    Set Orderrows = Nothing
    Exit Sub
Order_Class_Terminate__exception:
    Resume Order_Class_Terminate__end
Order_Class_Terminate__end:
    Exit Sub
End Sub

