Attribute VB_Name = "modClassIDGenerator"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"362DFF020302"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Module"

'The modClassIDGenerator is used by the automatically generated debug code.
'##ModelId=362DFF030028
Function GetNextClassDebugID() As Long
Attribute GetNextClassDebugID.VB_Description = "The modClassIDGenerator is used by the automatically generated debug code."
Attribute GetNextClassDebugID.VB_UserMemId = 1610612736
    'class ID generator
    Static lClassDebugID As Long
    lClassDebugID = lClassDebugID + 1
    GetNextClassDebugID = lClassDebugID
End Function

