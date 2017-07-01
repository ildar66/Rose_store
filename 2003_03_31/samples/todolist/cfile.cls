VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "CFile"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = " Class Name:   CFile\r\n Author:       Deborah Kurata, InStep Technologies\r\n Date:         1/25/97\r\n Description:  Generic file processing class.\r\n Revisions:"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"348430F701E0"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
' Class Name:   CFile
' Author:       Deborah Kurata, InStep Technologies
' Date:         1/25/97
' Description:  Generic file processing class.
' Revisions:

Option Explicit

' PUBLIC: *****************************************
' Public data members

' PRIVATE: *****************************************
' Private data members

' Path and name of the file to open
'##ModelId=348430F7035C
Private m_sFileName As String
Attribute m_sFileName.VB_VarDescription = " Path and name of the file to open"

' File number opened
'##ModelId=348430F7038E
Private m_iFileNumber As Integer
Attribute m_iFileNumber.VB_VarDescription = " File number opened"

'Error constants
'##ModelId=362DF6500094
Public Enum FileError
    '##ModelId=362DF6500184
    fileOpenError = vbObjectError + 512 + 2
    '##ModelId=362DF65001AD
    fileEOFError = vbObjectError + 512 + 3
    '##ModelId=362DF65001DF
    fileReadError = vbObjectError + 512 + 4
    '##ModelId=362DF6500207
    fileWriteError = vbObjectError + 512 + 5
End Enum


'##ModelId=34CCF68D0168
Private Sub Class_Initialize()
    #If DebugMode Then
        'get the next available class ID, and print out
        'that the class was created successfully
        mlClassDebugID = GetNextClassDebugID()
        Debug.Print "'" & TypeName(Me) & "' instance " & CStr(mlClassDebugID) & " created"
    #End If
End Sub

'##ModelId=34CCF68D02E4
Private Sub Class_Terminate()
    #If DebugMode Then
    'the class is being destroyed
    Debug.Print "'" & TypeName(Me) & "' instance " & CStr(mlClassDebugID) & " is terminating"
    #End If
End Sub

'##ModelId=348430F703CA
Public Property Get FileName() As String
    FileName = m_sFileName
End Property
'##ModelId=348430F80050
Public Property Let FileName(sFileName As String)
    ' Should validate valid path here
    m_sFileName = sFileName
End Property

' Reads all objects from a file into the defined object
' Parameters:
'   obj         Object to read
'##ModelId=348430F800BE
Public Sub ReadFile(obj As Object)
Attribute ReadFile.VB_Description = " Reads all objects from a file into the defined object\r\n Parameters:\r\n   obj         Object to read"

    ' Enable error handling
    On Error Resume Next
    
    ' Get the file number
    m_iFileNumber = FreeFile
    
    ' Open the file and trap any errors
    Open m_sFileName For Binary Access Read As #m_iFileNumber
    Select Case Err.Number
        Case 0  ' No error
            ' Get the data
            obj.ReadObjects
        
        Case 53    ' File not found
            ' Do nothing
            
        Case Else
            ' Turn off error handling here
            On Error GoTo 0
            
            ' Pass the error out
            Err.Raise fileOpenError, "CFile::ReadFile", "Error opening file."
            
    End Select

    ' Close the file
    Close #m_iFileNumber
End Sub

' Reads a field from the file
' Parameters:
'   vField      field read from the file
'##ModelId=348430F8012C
Public Sub ReadField(vField As Variant)
Attribute ReadField.VB_Description = " Reads a field from the file\r\n Parameters:\r\n   vField      field read from the file"
    ' Set the error handler
    On Error GoTo ERR_HANDLER
    
    Get #m_iFileNumber, , vField
    
    If EOF(m_iFileNumber) Then
        ' Reached end of file
        Err.Raise fileEOFError
    End If
Exit Sub

ERR_HANDLER:
    ' Pass the error out
    If Err.Number = fileEOFError Then
        Err.Raise Err.Number, "CFile::ReadField", "EOF"
    Else
        Err.Raise fileReadError, "CFile::ReadField", Err.Description
    End If
End Sub

' Writes all objects to the file.
' Parameters:
'   obj         Object
'##ModelId=348430F803C0
Public Sub WriteFile(obj As Object)
Attribute WriteFile.VB_Description = " Writes all objects to the file.\r\n Parameters:\r\n   obj         Object"

    ' Enable error handling
    On Error Resume Next

    ' Kill the existing file
    Kill m_sFileName
    Err.Clear

    ' Get the file number
    m_iFileNumber = FreeFile

    ' Open the file and trap any errors
    Open m_sFileName For Binary As #m_iFileNumber
    Select Case Err.Number
        Case 0  ' No error
            ' Write the data
            obj.WriteObjects

        Case Else
            ' Turn off error handling here
            On Error GoTo 0
            
            ' Pass the error out
            Err.Raise fileOpenError, "CFile::WriteFile", "Error opening file: " & Err.Description

    End Select

    ' Close the file
    Close #m_iFileNumber
End Sub

' Write a field to the file
' Parameters:
'   vField      field to write to the file
'##ModelId=348430F901C2
Public Sub WriteField(vField As Variant)
Attribute WriteField.VB_Description = " Write a field to the file\r\n Parameters:\r\n   vField      field to write to the file"
' Set the error handler
On Error GoTo ERR_HANDLER

    Put #m_iFileNumber, , vField

Exit Sub
ERR_HANDLER:
    Err.Raise fileWriteError, "CFile::WriteField", "Write Error: " & Err.Descpription
End Sub
