VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Connection"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit
Option Compare Text

Private Const cName = "VSExtDD"                    'The component name for debugging purposes
Private mRoseApp As RationalRose.RoseApplication   'Parent Rose Application object
Private mAddIn As RationalRose.RoseAddIn           'Parent Addin object

'*********************************************************************************
'Class Members

Private Sub Class_Terminate()
    Set mRoseApp = Nothing
    Set mAddIn = Nothing
End Sub

'*********************************************************************************
'Class Properties

'Add-in Name property
Public Property Get Name() As String
    Name = cName
End Property

'Parent Rose Application property
Public Property Get RoseApp() As RationalRose.IRoseApplication
    Set RoseApp = mRoseApp
End Property

'*********************************************************************************
'Implementation of Rose Add-In callback event methods

Public Sub OnActivate(RoseApp As RationalRose.IRoseApplication)
    Set mRoseApp = RoseApp
End Sub

Public Sub OnDeactivate(RoseApp As RationalRose.IRoseApplication)
    '(nothing)
End Sub
'*********************************************************************************

'*********************************************************************************
'Implementation of Rose Drag-Drop event methods
'
'Rose CanDropFileOnDiagram callback
Public Function CanDropFileOnDiagram(theDiagram As RoseDiagram, xPos As Integer, yPos As Integer, FileName As String) As Integer
    CanDropFileOnDiagram = CanDropFile(FileName)
End Function

'Rose DropFileOnDiagram callback
Public Function DropFileOnDiagram(theDiagram As RoseDiagram, xPos As Integer, yPos As Integer, FileName As String) As Boolean
    DropFileOnDiagram = DropFile(FileName)
End Function

'Rose CanDropFileOnItem callback
Public Function CanDropFileOnItem(theItem As RoseItem, FileName As String) As Integer
    CanDropFileOnItem = CanDropFile(FileName)
End Function

'Rose DropFileOnItem callback
Public Function DropFileOnItem(theItem As RoseItem, FileName As String) As Boolean
    DropFileOnItem = DropFile(FileName)
End Function

Private Function CanDropFile(FileName As String) As Integer
    Dim lFileSystem As New Scripting.FileSystemObject
    Dim lFile As Scripting.File
    Set lFile = lFileSystem.GetFile(FileName)
    Select Case FileExt(lFile.Path)
    Case "vbp", "vbg", "dsp"
        CanDropFile = DROPEFFECT_COPY
    Case Else
        CanDropFile = DROPEFFECT_NONE
    End Select
    CanDropFile = 1
End Function

Private Function DropFile(FileName As String) As Boolean
    DropProject FileName
    DropFile = True
End Function

'*********************************************************************************
'Implementation of DropProject Command
'
Private Sub DropProject(FileName As String)
    Dim lFileSystem As New Scripting.FileSystemObject
    Dim lFile As Scripting.File
    Set lFile = lFileSystem.GetFile(FileName)
    Dim lComponent As RationalRose.RoseModule
    Dim lDict As New Scripting.Dictionary
    Select Case FileExt(lFile.Path)
    'VB Project file
    Case "vbp"
        'add a new component to component view
        Set lComponent = mRoseApp.CurrentModel.RootSubsystem.AddModule(lFile.Name)
        'set the magic "ProjectFile" property to the project file path.
        '   this is how the ModelUpdate command locates the project
        Call lComponent.OverrideProperty("Visual Basic", "ProjectFile", lFile.Path)
        'set the language to VB
        lComponent.AssignedLanguage = "Visual Basic"
        'add the component to the selection collection
        lDict.Add lComponent.Name, lComponent
    'VB Group file
    Case "vbg"
        Dim lProjectFiles As New Collection
        Set lProjectFiles = GetProjectsFromGroup(lFile)
        Dim lProjectFile As Scripting.File
        For Each lProjectFile In lProjectFiles
            Set lComponent = mRoseApp.CurrentModel.RootSubsystem.AddModule(lProjectFile.Name)
            Call lComponent.OverrideProperty("Visual Basic", "ProjectFile", lProjectFile.Path)
            lComponent.AssignedLanguage = "Visual Basic"
            lDict.Add lComponent.Name, lComponent
        Next
    'VC++ Project file
    Case "dsp"
        Set lComponent = mRoseApp.CurrentModel.RootSubsystem.AddModule(lFile.Name)
        Call lComponent.OverrideProperty("VC++", "ProjectFile", lFile.Path)
        lComponent.AssignedLanguage = "VC++"
        lDict.Add lComponent.Name, lComponent
    End Select
    
    If lDict.Count > 0 Then
        Dim lModelUpdate As New rvsrte.ModelUpdate
        Call lModelUpdate.StartVisible(mRoseApp, lDict)
    End If
End Sub

'*********************************************************************************
' Helpers

'Get the file extension for a file
Private Function FileExt(FilePath As String) As String
    Dim Pos As Integer
    Pos = InStrRev(FilePath, ".", , vbTextCompare)
    If Pos > 0 Then
        FileExt = Right(FilePath, Len(FilePath) - Pos)
    Else
        FileExt = vbNullString
    End If
End Function

'Builds a collection of file objects from a VB Group file
Private Function GetProjectsFromGroup(File As Scripting.File) As Collection
    On Error Resume Next
    Dim lFileSystem As New Scripting.FileSystemObject
    Dim lCol As New Collection
    Dim lStream As Scripting.TextStream
    Set lStream = File.OpenAsTextStream
    Dim lLine As String
    Do While Not lStream.AtEndOfStream
        lLine = lStream.ReadLine
        If InStr(1, lLine, "Project=", vbTextCompare) = 1 Then
            Dim lFilePath As String
            lFilePath = Mid(lLine, Len("Project1="))
            lCol.Add lFileSystem.GetFile(File.ParentFolder + "\" + lFilePath)
        End If
    Loop
    Set GetProjectsFromGroup = lCol
End Function
'*********************************************************************************

