Attribute VB_Name = "modErrorHandling"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3626371A00B4"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Debug.ErrorHandling"
'
Option Explicit

'##ModelId=3626372603D8
Public Const MyObjectError1 = 1000

'##ModelId=3626372603D9
Public Const MyObjectError2 = 1010

'##ModelId=362637270028
Public Const MyObjectErrorN = 1234

'##ModelId=362637270029
Public Const MyUnhandledError = 9999

'There are a number of methods for retrieving the error
'message.  The following method uses a resource file to
'retrieve strings indexed by the error number you are
'raising.
'##ModelId=3626372603D5
Public Sub RaiseError(ErrorNumber As Long, Source As String)
Attribute RaiseError.VB_Description = "There are a number of methods for retrieving the error\r\nmessage.  The following method uses a resource file to\r\nretrieve strings indexed by the error number you are\r\nraising."
      Dim strErrorText As String

      strErrorText = GetErrorTextFromResource(ErrorNumber)

      'raise an error back to the client
      Err.Raise vbObjectError + ErrorNumber, Source, strErrorText
End Sub

' This function will retrieve an error description from a resource
' file (.RES).  The ErrorNum is the index of the string
' in the resource file.  Called by RaiseError
'##ModelId=3626372603A2
Private Function GetErrorTextFromResource(ErrorNum As Long) As String
Attribute GetErrorTextFromResource.VB_Description = " This function will retrieve an error description from a resource\r\n file (.RES).  The ErrorNum is the index of the string\r\n in the resource file.  Called by RaiseError"
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
