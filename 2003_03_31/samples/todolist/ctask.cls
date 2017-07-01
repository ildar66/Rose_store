VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "CTask"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = " Class Name:   CTask\r\n Author:       Deborah Kurata, InStep Technologies\r\n Date:         1/6/97\r\n Description:  Define task objects that have a description,\r\n               priority, and time due.\r\n Revisions:"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"348430EC01EA"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
' Class Name:   CTask
' Author:       Deborah Kurata, InStep Technologies
' Date:         1/6/97
' Description:  Define task objects that have a description,
'               priority, and time due.
' Revisions:

Option Explicit
' PUBLIC: ******************************************
' Public data members

' PRIVATE: *****************************************
' Private data members

'##ModelId=348430EC03A2
Private m_dtCreated As Date
'##ModelId=348430EC03D4
Private m_sDescription As String
'##ModelId=348430ED0028
Private m_sDue As String
'##ModelId=348430ED0398
Private m_sID As String
'##ModelId=348430EE0050
Private m_iPriority As Integer

'Define constant priority values
'##ModelId=362DF64901D4
Public Enum taskPriority
    '##ModelId=362DF64903BF
    taskEmpty = 0
    '##ModelId=362DF64903E7
    taskUrgent = 1
    '##ModelId=362DF64A0027
    taskHigh = 2
    '##ModelId=362DF64A0059
    taskMedium = 3
    '##ModelId=362DF64A0081
    taskLow = 4
End Enum

'Define error values
'##ModelId=362DF64A00BE
Public Enum TaskError
    '##ModelId=362DF64A01A4
    taskPriorityValueError = vbObjectError + 512 + 2
    '##ModelId=362DF64A01CC
    taskInvalidTimeError = vbObjectError + 512 + 3
End Enum




'##ModelId=34CD0F3E023A
Private Sub Class_Terminate()
    #If DebugMode Then
    'the class is being destroyed
    Debug.Print "'" & TypeName(Me) & "' instance " & CStr(mlClassDebugID) & " is terminating"
    #End If
End Sub

' PUBLIC: *****************************************
' Public property procedures

' Read-only creation date
'##ModelId=348430EE008C
Public Property Get Created() As Date
Attribute Created.VB_Description = " Read-only creation date"
    Created = m_dtCreated
End Property

' Description of the task
'##ModelId=348430EE00FA
Public Property Get Description() As String
    Description = m_sDescription
End Property
'##ModelId=348430EE012C
Public Property Let Description(sDescription As String)
Attribute Description.VB_Description = " Description of the task"
    m_sDescription = sDescription
End Property

' Time the task is due
'##ModelId=348430EE01D6
Public Property Get Due() As String
    Due = m_sDue
End Property
'##ModelId=348430EE0208
Public Property Let Due(sDue As String)
Attribute Due.VB_Description = " Time the task is due"
    If Not (IsDate(sDue)) Then
        Err.Raise taskInvalidTimeError, "CTask::Due", "Invalid date in time due property."
    End If
    m_sDue = sDue
End Property

' ID within the collection
' NOTE: it must be a unique string that is only set once
'##ModelId=348430EF023A
Public Property Let id(sID As String)
Attribute id.VB_Description = " ID within the collection\r\n NOTE: it must be a unique string that is only set once"
Static bAlreadySet As Boolean

    If Not bAlreadySet Then
        m_sID = sID
        bAlreadySet = True
    End If
End Property
'##ModelId=348430EF00B4
Public Property Get id() As String
    id = m_sID
End Property

' Priority of the task
'##ModelId=348430F000E6
Public Property Get Priority() As taskPriority
    Priority = m_iPriority
End Property
'##ModelId=348430F00154
Public Property Let Priority(iPriority As taskPriority)
Attribute Priority.VB_Description = " Priority of the task"
    ' Prevent invalid values
    If iPriority < taskEmpty Or iPriority > taskLow Then
        Err.Raise taskPriorityValueError, "CTask::Priority", "Priority value out of range."
    End If
    
    m_iPriority = iPriority
    
End Property

' Initialize event
'##ModelId=34CD0F4101AE
Private Sub Class_Initialize()
Attribute Class_Initialize.VB_Description = " Initialize event"
    ' Set the creation date
    m_dtCreated = Now
End Sub

' PUBLIC: *****************************************
' Public methods

' Clear the task
'##ModelId=348430F0033E
Public Sub Clear()
Attribute Clear.VB_Description = " Clear the task"
    Description = ""
    Priority = taskEmpty
    Due = ""
End Sub

' Read the data from the file
'##ModelId=348430F003DE
Public Sub ReadObjectData(File As CFile)
Attribute ReadObjectData.VB_Description = " Read the data from the file"
Dim lInt As Long
Dim sStr As String
    On Error GoTo ERR_ROUTINE
    
    ' Retrieve the priority
    File.ReadField lInt
    Priority = lInt

    ' Retrieve the description
    File.ReadField sStr
    Description = sStr
    
    ' Retrieve the time due
    File.ReadField sStr
    Due = sStr
Exit Sub

ERR_ROUTINE:
    Err.Raise Err.Number, Err.Source, Err.Description

End Sub

' Write the data to a file
'##ModelId=348430F100A0
Public Sub WriteObjectData(File As CFile)
Attribute WriteObjectData.VB_Description = " Write the data to a file"

    File.WriteField Priority
    File.WriteField Description
    File.WriteField Due
End Sub



