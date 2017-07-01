Attribute VB_Name = "modErrorHandling"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"36421A8F004A"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Module"
'The modErrorHandling module is used by the automatically generated error-handling
'code.

' Define your custom errors here.  Be sure to use numbers
' greater than 512, to avoid conflicts with OLE error numbers.
'##ModelId=362DF65A0392
Public Const MyObjectError1 = 1000
Attribute MyObjectError1.VB_VarDescription = " Define your custom errors here.  Be sure to use numbers\r\n greater than 512, to avoid conflicts with OLE error numbers."
'##ModelId=362DF65A0323
Public Const MyObjectError2 = 1010
'##ModelId=362DF65A02C9
Public Const MyObjectErrorN = 1234
'##ModelId=362DF65A0265
Public Const MyUnhandledError = 9999

' This function will retrieve an error description from a resource
' file (.RES).  The ErrorNum is the index of the string
' in the resource file.  Called by RaiseError
'##ModelId=362DF65A020B
Private Function GetErrorTextFromResource(ErrorNum As Long) As String
Attribute GetErrorTextFromResource.VB_Description = " This function will retrieve an error description from a resource\r\n file (.RES).  The ErrorNum is the index of the string\r\n in the resource file.  Called by RaiseError"
Attribute GetErrorTextFromResource.VB_UserMemId = 1610612736
      On Error GoTo GetErrorTextFromResourceError
      Dim strMsg As String
     
      ' get the string from a resource file
      GetErrorTextFromResource = LoadResString(ErrorNum)

      Exit Function
GetErrorTextFromResourceError:
      If Err.Number <> 0 Then
            GetErrorTextFromResource = "An unknown error has occurred!"
      End If
End Function

'There are a number of methods for retrieving the error
'message.  The following method uses a resource file to
'retrieve strings indexed by the error number you are
'raising.
'##ModelId=362DF65A019D
Public Sub RaiseError(ErrorNumber As Long, Source As String)
Attribute RaiseError.VB_Description = "There are a number of methods for retrieving the error\r\nmessage.  The following method uses a resource file to\r\nretrieve strings indexed by the error number you are\r\nraising."
Attribute RaiseError.VB_UserMemId = 1610612737
      Dim strErrorText As String

      strErrorText = GetErrorTextFromResource(ErrorNumber)

      'raise an error back to the client
      Err.Raise vbObjectError + ErrorNumber, Source, strErrorText
End Sub


