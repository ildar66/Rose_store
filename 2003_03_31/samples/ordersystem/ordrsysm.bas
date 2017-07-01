Attribute VB_Name = "OrderSys_Main"
Attribute VB_Description = "Main program in VB"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3237F8CC0300"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Module"
'Main program in VB
Option Explicit


' Main program in the ordersys example
'##ModelId=3237F8CC0334
Public Sub main()
Attribute main.VB_Description = " Main program in the ordersys example"
    On Error GoTo OrderSys_Main_main__exception
    If Db_Open("") Then
        dlg_Order.Show
    Else
        MsgBox ("The database file ORDERSYS.MDB could not be opened.")
        End
    End If
    Exit Sub
OrderSys_Main_main__exception:
    Resume OrderSys_Main_main__end
OrderSys_Main_main__end:
    Exit Sub
End Sub

