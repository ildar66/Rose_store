VERSION 1.0 CLASS
BEGIN
  MultiUse = 0   'False
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Customers"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = "A set of items restored from the database.\r\nCustomers objects are based on a database table or dynaset\r\nand a stored query definition:\r\n""PARAMETERS...; SELECT * FROM ... WHERE ... """
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3237F8CE0135"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
'A set of items restored from the database.
'Customers objects are based on a database table or dynaset
'and a stored query definition:
'"PARAMETERS...; SELECT * FROM ... WHERE ... "
Option Explicit


'##ModelId=3237F8CB02D8
Private Storage As Persistence

'Returns the an item from the set.
'Index syntax.
' <nothing> = Returns the current item
' Number = Returns the item indexed by number.   Range:
'1..Count.
'##ModelId=3237F8CE0168
Public Function Item(Optional index As Variant) As Customer
Attribute Item.VB_Description = "Returns the an item from the set.\r\nIndex syntax.\r\n <nothing> = Returns the current item\r\n Number = Returns the item indexed by number.   Range:\r\n1..Count."
    On Error GoTo Customers_Item__exception
    If Not IsMissing(index) Then
        Storage.Recordset.AbsolutePosition = index - 1
    End If
    'Allocate and return the current object
    Dim New_Customer As New Customer
    New_Customer.Customer CustomerId:=Storage.Recordset!Customer_Id, Name:=Storage.Recordset!Name, Address:=Storage.Recordset!Address
    Set Item = New_Customer
    Exit Function
Customers_Item__exception:
    Resume Customers_Item__end
Customers_Item__end:
    Exit Function
End Function

'Returns the number of items in the set.
'##ModelId=3237F8CE016A
Public Property Get Count() As Long
Attribute Count.VB_Description = "Returns the number of items in the set."
    On Error GoTo Customers_Count__exception
    If Storage.RecordsExists Then
        Storage.Recordset.MoveLast
        Count = Storage.Recordset.RecordCount
    Else
        Count = 0
    End If
    Exit Property
Customers_Count__exception:
    Resume Customers_Count__end
Customers_Count__end:
    Exit Property
End Property

'Sets the criterion for fetching a set of items.
'##ModelId=3237F8CE016B
Public Sub Fetch(Optional Id As Variant, Optional Name As Variant)
Attribute Fetch.VB_Description = "Sets the criterion for fetching a set of items."
    On Error GoTo Customers_Fetch__exception
    'Set the Customer_Id query parameter
    If Not IsMissing(Id) Then
        Storage.QueryDef.Parameters!Id = Id
    Else
        Storage.QueryDef.Parameters!Id = "*"
    End If
    'Set the Name query parameter
    If Not IsMissing(Name) Then
        Storage.QueryDef.Parameters!Name = Name
    Else
        Storage.QueryDef.Parameters!Name = "*"
    End If
    Storage.Execute
    Exit Sub
Customers_Fetch__exception:
    Resume Customers_Fetch__end
Customers_Fetch__end:
    Exit Sub
End Sub

'Returns the previous item from the set.
'##ModelId=3237F8CE019C
Public Function MovePrevious() As Customer
Attribute MovePrevious.VB_Description = "Returns the previous item from the set."
    On Error GoTo Customers_MovePrevious__exception
    If Storage.RecordsExists Then
        'Move to the previous item in the recordset
        Storage.Recordset.MovePrevious
        'Return the current customer by calling the Item method
        Set MovePrevious = Item
    End If
    Exit Function
Customers_MovePrevious__exception:
    Resume Customers_MovePrevious__end
Customers_MovePrevious__end:
    Exit Function
End Function

'Returns the next item from the set.
'##ModelId=3237F8CE019D
Public Function MoveNext() As Customer
Attribute MoveNext.VB_Description = "Returns the next item from the set."
    On Error GoTo Customers_MoveNext__exception
    If Storage.RecordsExists And Not Storage.Recordset.EOF Then
        'Move to the next item in the recordset
        Storage.Recordset.MoveNext
        'Return the current customer by calling the Item method
        Set MoveNext = Item
    End If
    Exit Function
Customers_MoveNext__exception:
    Resume Customers_MoveNext__end
Customers_MoveNext__end:
    Exit Function
End Function

'Returns the first item from the set.
'##ModelId=3237F8CE019E
Public Function MoveFirst() As Customer
Attribute MoveFirst.VB_Description = "Returns the first item from the set."
    On Error GoTo Customers_MoveFirst__exception
    If Storage.RecordsExists Then
        'Move to the first item in the recordset
        Storage.Recordset.MoveFirst
        'Return the current customer by calling the Item method
        Set MoveFirst = Item
    End If
    Exit Function
Customers_MoveFirst__exception:
    Resume Customers_MoveFirst__end
Customers_MoveFirst__end:
    Exit Function
End Function

'Returns true when the last customer is indexed.
'##ModelId=3237F8CE019F
Public Function Last() As Boolean
Attribute Last.VB_Description = "Returns true when the last customer is indexed."
    On Error GoTo Customers_Last__exception
    If Storage.RecordsExists Then
        Last = Storage.Recordset.EOF
    Else
        Last = True
    End If
    Exit Function
Customers_Last__exception:
    Resume Customers_Last__end
Customers_Last__end:
    Exit Function
End Function

'##ModelId=3237F8CE01A0
Private Sub Class_Initialize()
    On Error GoTo Customers_Class_Initialize__exception
    'Setup the persistence object
    Set Storage = New Persistence
    Storage.Connect ("Query_Customers")
    Exit Sub
Customers_Class_Initialize__exception:
    Resume Customers_Class_Initialize__end
Customers_Class_Initialize__end:
    Exit Sub
End Sub

'##ModelId=3237F8CE01A1
Private Sub Class_Terminate()
    On Error GoTo Customers_Class_Terminate__exception
    Set Storage = Nothing
    Exit Sub
Customers_Class_Terminate__exception:
    Resume Customers_Class_Terminate__end
Customers_Class_Terminate__end:
    Exit Sub
End Sub

