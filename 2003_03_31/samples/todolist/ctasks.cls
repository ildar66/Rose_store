VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "CTasks"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = " Class Name:   CTasks\r\n Author:       Deborah Kurata\r\n Date:         1/9/97\r\n Description:  Maintains the collection of CTask objects.\r\n"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"348430FF0294"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
' Class Name:   CTasks
' Author:       Deborah Kurata
' Date:         1/9/97
' Description:  Maintains the collection of CTask objects.
'

Option Explicit

' PRIVATE: *****************************************
' Private data members

' Define the collection of tasks
'##ModelId=348431000140
Private m_colTasks As Collection
Attribute m_colTasks.VB_VarDescription = " Define the collection of tasks"

' Reference to the File processing class
'##ModelId=3484310001B0
Private m_File As CFile
Attribute m_File.VB_VarDescription = " Reference to the File processing class"

'Define error values
'##ModelId=362DF6540068
Public Enum TasksError
    '##ModelId=362DF6540194
    tasksInvalidIndexError = vbObjectError + 512 + 10
End Enum


' Provide the count of the number in the collection
'##ModelId=34843100021C
Public Property Get Count() As Long
Attribute Count.VB_Description = " Provide the count of the number in the collection"
    Count = m_colTasks.Count
End Property

' Initialize event
'##ModelId=34843100028A
Private Sub Class_Initialize()
Attribute Class_Initialize.VB_Description = " Initialize event"
    ' Create the collection object
    Set m_colTasks = New Collection
    
    ' Read any existing data from the file
    Set m_File = New CFile
    m_File.FileName = App.Path & "\task.bin"
    m_File.ReadFile Me
End Sub

' Terminate event
'##ModelId=3484310002BC
Private Sub Class_Terminate()
Attribute Class_Terminate.VB_Description = " Terminate event"
On Error GoTo ERR_ROUTINE
    ' Save the data
    m_File.WriteFile Me

    ' Clear the reference
    Set m_colTasks = Nothing

Exit Sub
ERR_ROUTINE:
    ' Cannot raise errors from
    ' the Terminate event
    ' so do logging here
    Resume Next
End Sub

' Add a task to the collection
' Parameters:
'   iPriority       priority of the task
'   sDescription    string description of the task
'   sDue            time the task is due
' Returns:
'   Task            task object
'##ModelId=34843100032A
Public Function Add(iPriority As Integer, sDescription As String, sDue As String) As CTask
Attribute Add.VB_Description = " Add a task to the collection\r\n Parameters:\r\n   iPriority       priority of the task\r\n   sDescription    string description of the task\r\n   sDue            time the task is due\r\n Returns:\r\n   Task            task object"
On Error GoTo ERR_ROUTINE
Dim newTask As CTask

    ' Create the instance
    Set newTask = New CTask

    With newTask
        ' Set a unique ID
        .id = NextID

        ' Set the properties
        .Priority = iPriority
        .Description = sDescription
        .Due = sDue
        
        ' Add the member to the collection
        m_colTasks.Add newTask, .id
    End With

    ' Return the one that was added
    Set Add = newTask
Exit Function

ERR_ROUTINE:
    ' Pass any error up to the calling class from the lower level object
    Err.Raise Err.Number, Err.Source, Err.Description
End Function

' Clear the collection
'##ModelId=34843101001E
Public Sub Clear()
Attribute Clear.VB_Description = " Clear the collection"
    Set m_colTasks = New Collection
End Sub

' Displays the defined member
' Parameters:
'   vkey         key or index of member to get
'##ModelId=34843101008C
Public Function Item(vKey As Variant) As CTask
Attribute Item.VB_Description = " Displays the defined member\r\n Parameters:\r\n   vkey         key or index of member to get"
Attribute Item.VB_UserMemId = 0
On Error GoTo ERR_ROUTINE
    Set Item = m_colTasks.Item(vKey)

Exit Function
ERR_ROUTINE:
    Err.Raise tasksInvalidIndexError, "CTasks::Item", "Collection key or index is invalid"
End Function

' Exposes the enumeration object
' to allow the For Each...Next syntax
'##ModelId=3484310100FA
Public Function NewEnum() As IUnknown
Attribute NewEnum.VB_Description = " Exposes the enumeration object\r\n to allow the For Each...Next syntax"
Attribute NewEnum.VB_UserMemId = -4
    Set NewEnum = m_colTasks.[_NewEnum]
End Function

' Provides the next available ID
' Returns:
'   NextID      Next unique Task ID
'##ModelId=348431010136
Private Function NextID() As String
Attribute NextID.VB_Description = " Provides the next available ID\r\n Returns:\r\n   NextID      Next unique Task ID"
Static iID As Integer

    iID = iID + 1
    NextID = "T" & Format$(iID, "00000")

End Function

' Read the data from the file
'##ModelId=3484310101A4
Public Sub ReadObjects()
Attribute ReadObjects.VB_Description = " Read the data from the file"
Dim newTask As CTask

    ' Read in the object
    Do Until Err.Number <> 0
        Set newTask = New CTask
        newTask.ReadObjectData m_File
        
        If Err.Number = 0 Then
            ' Set a unique ID
            newTask.id = NextID
        
            ' Add the member to the collection
            m_colTasks.Add newTask, newTask.id
        End If
    Loop
End Sub

' Remove the member from the collection.
' Parameters:
'   vkey         key or index of member to delete
'##ModelId=3484310101D6
Public Sub Remove(vKey As Variant)
Attribute Remove.VB_Description = " Remove the member from the collection.\r\n Parameters:\r\n   vkey         key or index of member to delete"
On Error GoTo ERR_ROUTINE
    ' Remove the member from the collection
    m_colTasks.Remove vKey

Exit Sub
ERR_ROUTINE:
    Err.Raise tasksInvalidIndexError, "CTasks::Remove", "Collection key or index is invalid"
End Sub

' Write the data to a file
'##ModelId=348431010244
Public Sub WriteObjects()
Attribute WriteObjects.VB_Description = " Write the data to a file"
Dim tmpTask As CTask

    ' Write each object's properties
    For Each tmpTask In m_colTasks
        tmpTask.WriteObjectData m_File
    Next
End Sub


