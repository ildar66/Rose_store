Attribute VB_Name = "modClassIdGenerator"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3626371A0082"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Debug.ClassIdGenerator"
'
Option Explicit

'Class ID generator
'##ModelId=36263726028A
Public Function GetNextClassDebugID() As Long
Attribute GetNextClassDebugID.VB_Description = "Class ID generator"
    Static lClassDebugID As Long
    lClassDebugID = lClassDebugID + 1
    GetNextClassDebugID = lClassDebugID
End Function
