VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "ProjectFileEvents"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit

Private Const cAppName = "VS Extensibility VB Add-In"
Private Const cErrortext = "Model cannot be updated."
'VBProject file events
Private WithEvents mFileControlEvents As VBIDE.FileControlEvents
Attribute mFileControlEvents.VB_VarHelpID = -1

'*********************************************************************************
'Class Members
'
Private Sub Class_Terminate()
 Set mFileControlEvents = Nothing
End Sub

'*********************************************************************************
'Class Properties

'Add-in FileControlEvents property
Public Property Set FileControlEvents(RHS As FileControlEvents)
    Set mFileControlEvents = RHS
End Property

Public Property Get FileControlEvents() As FileControlEvents
    Set FileControlEvents = mFileControlEvents
End Property

'*********************************************************************************
'FileControlEvents Event Handlers
'
Private Sub mFileControlEvents_AfterWriteFile(ByVal VBProject As VBIDE.VBProject, ByVal FileType As VBIDE.vbext_FileType, ByVal FileName As String, ByVal Result As Integer)
    Select Case FileType
    Case _
    VBIDE.vbext_FileType.vbext_ft_Class, _
    VBIDE.vbext_FileType.vbext_ft_Designers, _
    VBIDE.vbext_FileType.vbext_ft_DocObject, _
    VBIDE.vbext_FileType.vbext_ft_Form, _
    VBIDE.vbext_FileType.vbext_ft_Module, _
    VBIDE.vbext_FileType.vbext_ft_PropertyPage, _
    VBIDE.vbext_FileType.vbext_ft_UserControl
        Dim ProjectItem As VBIDE.VBComponent
        Set ProjectItem = GetProjectItem(VBProject, FileName)
        If Not (ProjectItem Is Nothing) Then
            If MsgBox("Do you want to update the Rose model with the saved changes?", vbOKCancel, cAppName) = vbOK Then
                UpdateModelCommand VBProject, ProjectItem
            End If
        End If
    End Select
End Sub

Private Function GetProjectItem(VBProject As VBIDE.VBProject, FileName As String) As VBIDE.VBComponent
    Dim index As Integer
    Dim lProjectItem As VBIDE.VBComponent
    For Each lProjectItem In VBProject.VBComponents
        For index = 1 To lProjectItem.FileCount
            If lProjectItem.FileNames(index) = FileName Then
                Set GetProjectItem = lProjectItem
                Exit Function
            End If
        Next
    Next
    Set GetProjectItem = Nothing
End Function

'*********************************************************************************
'Implementation of Update Model Command
'
Private Sub UpdateModelCommand(VBProject As VBIDE.VBProject, VBComponent As VBIDE.VBComponent)
    On Error GoTo Error
    'Check if the vb project is connected to a model
    '   The "RVB_UniqueId" property on projects and classes indicate that an item has been
    '   synchronized with a model
    If _
    VBProject.ReadProperty("RVB", "RVB_UniqueId") = vbNullString Or _
    VBComponent.ReadProperty("RVB_UniqueId") = vbNullString _
    Then
        'Project is not attached to a model
        MsgBox cErrortext
        Exit Sub
    End If
    
    Dim lRoseApp As RationalRose.RoseApplication
    'Get the running Rose application instance
    Set lRoseApp = GetObject(, "Rose.Application")
    If lRoseApp Is Nothing Then
        'No Rose application found
        MsgBox cErrortext
        Exit Sub
    End If

    'Get the corresponding component and class in Rose
    Dim lRoseProject As RationalRose.RoseModule
    Dim lRoseClass As RationalRose.RoseClass
    Set lRoseProject = lRoseApp.CurrentModel.GetAllModules.GetFirst(VBProject.Name)
    If lRoseProject Is Nothing Then
        'The component was not found in model
        MsgBox cErrortext
        Exit Sub
    End If
    Set lRoseClass = lRoseProject.GetAssignedClasses.GetFirst(VBComponent.Name)
    If lRoseClass Is Nothing Then
        'The class was not found in model
        MsgBox cErrortext
        Exit Sub
    End If
    
    'Turn off reference importing
    '   First store the current setting and reset to false
    Dim lImportReferences As String
    lImportReferences = lRoseProject.GetPropertyValue("Visual Basic", "ImportReferences")
    Call lRoseProject.OverrideProperty("Visual Basic", "ImportReferences", CStr(False))
    
    Dim lUpdateModel As rvsRTE.ModelUpdate
    Dim lDict As New Scripting.Dictionary
    'Add the class to the selections collection and call UpdateModel
    Dim lPath As String
    lPath = lRoseProject.Name & "\" & lRoseClass.Name
    'lDict.Add lPath, lPath
    lDict.Add lRoseClass.Name, lRoseClass
    Set lUpdateModel = New rvsRTE.ModelUpdate
    Call lUpdateModel.Start(lRoseApp, lDict, Me)
    
    'Restore the reference import setting
    Call lRoseProject.OverrideProperty("Visual Basic", "ImportReferences", lImportReferences)
    Exit Sub
Error:
    MsgBox cErrortext
End Sub

'UpdateModel callback OnSynchronize method
'   Method is called after model has been updated
'   The Selection collection will contains code items that was not found in the code.
'   Items remaining in collection will be removed by the UpdateModel tool
Public Sub OnSynchronize(RoseApp As RoseApplication, Selection As Object, Reporter As IReporter)
    'Do not remove items. Raplace with a new, empty, collection
    Set Selection = New Collection
End Sub

'UpdateModel callback OnCompleted method.
'   Method is called when the UpdateModel tool is compleated.
'   May be used to for reporting, to release objects, or other cleanup's
Public Sub OnCompleted(Reporter As IReporter)
    '(nothing)
End Sub

