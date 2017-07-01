VERSION 5.00
Begin VB.Form frmToDo 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "To Do List"
   ClientHeight    =   3795
   ClientLeft      =   1080
   ClientTop       =   1425
   ClientWidth     =   6840
   Icon            =   "ToDo.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   PaletteMode     =   1  'UseZOrder
   ScaleHeight     =   3795
   ScaleWidth      =   6840
   Begin VB.CommandButton cmdDelete 
      Caption         =   "D&elete Task"
      Height          =   372
      Left            =   2880
      TabIndex        =   8
      Top             =   3240
      Width           =   1275
   End
   Begin VB.ListBox lstTasks 
      Height          =   2010
      Left            =   120
      TabIndex        =   6
      Top             =   960
      Width           =   6615
   End
   Begin VB.CommandButton cmdClose 
      Cancel          =   -1  'True
      Caption         =   "&Close"
      Height          =   372
      Left            =   4560
      TabIndex        =   9
      Top             =   3240
      Width           =   1275
   End
   Begin VB.CommandButton cmdAdd 
      Caption         =   "&Add Task"
      Default         =   -1  'True
      Height          =   372
      Left            =   1200
      TabIndex        =   7
      Top             =   3240
      Width           =   1275
   End
   Begin VB.TextBox txtDue 
      Height          =   315
      Left            =   5520
      TabIndex        =   5
      Top             =   360
      Width           =   1095
   End
   Begin VB.TextBox txtPriority 
      Height          =   288
      Left            =   60
      TabIndex        =   1
      Top             =   360
      Width           =   372
   End
   Begin VB.TextBox txtDescription 
      Height          =   492
      Left            =   840
      MultiLine       =   -1  'True
      TabIndex        =   3
      Top             =   360
      Width           =   4452
   End
   Begin VB.Label Label1 
      Caption         =   "&Due:"
      Height          =   255
      Index           =   2
      Left            =   5520
      TabIndex        =   4
      Top             =   120
      Width           =   855
   End
   Begin VB.Label Label1 
      Caption         =   "&Priority:"
      Height          =   252
      Index           =   1
      Left            =   60
      TabIndex        =   0
      Top             =   120
      Width           =   672
   End
   Begin VB.Label Label1 
      Caption         =   "&To Do:"
      Height          =   252
      Index           =   0
      Left            =   840
      TabIndex        =   2
      Top             =   120
      Width           =   612
   End
End
Attribute VB_Name = "frmToDo"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Attribute VB_Description = " Form Name:    frmToDo\r\n Author:       Deborah Kurata, InStep Technologies\r\n Date:         1/8/97\r\n Description:  Displays a set of tasks in a to do list.\r\n Revisions:\r\n"
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"348430E10078"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Form"
' Form Name:    frmToDo
' Author:       Deborah Kurata, InStep Technologies
' Date:         1/8/97
' Description:  Displays a set of tasks in a to do list.
' Revisions:
'
Option Explicit

' Define the instance of the collection class
'##ModelId=348430E201EA
Private m_Tasks As CTasks
Attribute m_Tasks.VB_VarDescription = " Define the instance of the collection class"

'##ModelId=34CCF6830136
Private Sub Form_Initialize()
    #If DebugMode Then
        'get the next available class ID, and print out
        'that the class was created successfully
        mlClassDebugID = GetNextClassDebugID()
        Debug.Print "'" & TypeName(Me) & "' instance " & CStr(mlClassDebugID) & " created"
    #End If
End Sub

'##ModelId=34CCF6830320
Private Sub Form_Terminate()
    #If DebugMode Then
    'the class is being destroyed
    Debug.Print "'" & TypeName(Me) & "' instance " & CStr(mlClassDebugID) & " is terminating"
    #End If
End Sub

' Add the defined task to the collection and to the list box
'##ModelId=348430E202C6
Private Sub cmdAdd_Click()
Attribute cmdAdd_Click.VB_Description = " Add the defined task to the collection and to the list box"
Dim index As Integer
On Error GoTo ERR_ROUTINE
    
    ' Add the task to the collection
    m_Tasks.Add Val(txtPriority.Text), txtDescription.Text, txtDue.Text
    
    ' Add the task to the list box
    lstTasks.AddItem Format$(txtPriority.Text, "000") & Space(2) & txtDescription.Text & Space(2) & "Due: " & txtDue.Text
    
    ' Clear the fields on the form for entry of another task
    txtPriority.Text = ""
    txtDescription.Text = ""
    txtDue.Text = ""
    txtPriority.SetFocus
Exit Sub

ERR_ROUTINE:
    Select Case Err.Number
        Case taskPriorityValueError
            MsgBox "Please enter a valid priority value. " & "Valid values range from: " & taskUrgent & " to " & taskLow
            txtPriority.SetFocus
            
        Case taskInvalidTimeError
            MsgBox "Please enter a time defining when the task is due."
            txtDue.SetFocus
            
        Case Else
            ' If it was some other error, display it
            MsgBox "Error in application: " & Err.Description
    End Select
End Sub

'##ModelId=348430E20302
Private Sub cmdClose_Click()
    ' Unload the form
    Unload Me
End Sub

' Delete the task from the collection and list box
'##ModelId=348430E20370
Private Sub cmdDelete_Click()
Attribute cmdDelete_Click.VB_Description = " Delete the task from the collection and list box"
Dim ix As Integer
On Error GoTo ERR_ROUTINE
    ' Determine the index number
    ' It is one more than the list index because
    ' list boxes are 0-based and collections are 1-based
    ix = lstTasks.ListIndex + 1
    
    If ix > 0 Then
        ' Remove the task from the collection
        m_Tasks.Remove ix
        
        ' Remove the task from the list box
        lstTasks.RemoveItem lstTasks.ListIndex
    End If
Exit Sub
ERR_ROUTINE:
    MsgBox "Error in application: " & Err.Description
End Sub

'##ModelId=348430E203DE
Private Sub Form_Load()
Dim tempTask As CTask
    
    ' Create the instance of the collection class
    Set m_Tasks = New CTasks
    
    ' Fill the list box with the items from the collection
    ' Shows the For Each...Next syntax!
    For Each tempTask In m_Tasks
        lstTasks.AddItem Format$(tempTask.Priority, "000") & Space(2) & tempTask.Description & Space(2) & "Due: " & tempTask.Due
    Next
End Sub

'##ModelId=348430E30028
Private Sub Form_Unload(Cancel As Integer)
    ' Clear all of our object references
    Set m_Tasks = Nothing
    Set frmToDo = Nothing
    End
End Sub
