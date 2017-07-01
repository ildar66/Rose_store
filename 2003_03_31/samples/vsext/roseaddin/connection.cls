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

Private Const cName = "VSExtRose"                               'The component name for debugging purposes
Private mRoseApp As RationalRose.RoseApplication                'Parent Rose Applicaiton object
Private mAddIn As RationalRose.RoseAddIn                        'Parent Addin object
Private mUpdateCodeCommand As RationalRose.RoseContextMenuItem  'The Update Code command

'*********************************************************************************
'Class Members

Private Sub Class_Terminate()
    Set mRoseApp = Nothing
    Set mAddIn = Nothing
    Set mUpdateCodeCommand = Nothing
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
    Set mAddIn = GetAddIn(RoseApp, cName)
    
    Set mUpdateCodeCommand = mAddIn.AddContextMenuItem(rose_mnu_it_Class, vse_mnu_caption_UpdateCode, vse_mnu_id_UpdateCode)
End Sub

Public Sub OnDeactivate(RoseApp As RationalRose.IRoseApplication)
    '(nothing)
End Sub
'*********************************************************************************

'*********************************************************************************
'Implementation of Rose Add-In context menu callback methods

'OnEnableContextMenuItems methods is called just before the context menu opens
Public Sub OnEnableContextMenuItems(RoseApp As RationalRose.RoseApplication, ItemType As Integer)
    'Check for at least one class assigned to a Visual Studio language (VB or VC).
    Dim index As Integer
    Dim lSelectedClasses As RationalRose.RoseClassCollection
    Set lSelectedClasses = RoseApp.CurrentModel.GetSelectedClasses
    For index = 1 To lSelectedClasses.Count
        Select Case lSelectedClasses.GetAt(index).GetAssignedLanguage
        Case "Visual Basic", "VC"
            'Enable context menu.
            mUpdateCodeCommand.MenuState = RationalRose.RoseMenuState.rsEnabled
            Exit Sub
        End Select
    Next
    'No Visual Studio classes selected. Disable menu.
    mUpdateCodeCommand.MenuState = RationalRose.RoseMenuState.rsDisabled
End Sub

'OnSelectedContextMenuItem method is called after a conext menu items has been chosen
Public Function OnSelectedContextMenuItem(RoseApp As RationalRose.RoseApplication, internalName As String) As Boolean
    Select Case internalName
    Case vse_mnu_id_UpdateCode
        UpdateCodeCommand
    Case Else
    End Select
End Function

'Local method to look up the parent add-in object from Rose Add-In manager
Private Function GetAddIn(aRoseApp As RoseApplication, anAddInName As String) As RoseAddIn
    On Error GoTo Error
    Dim theAddIns As RoseAddInCollection
    Dim anAddInIndex As Integer
    'Get all add-ins from Add-In Manager
    Set theAddIns = aRoseApp.AddInManager.AddIns
    'Iterate the add-in collection to find the parent object
    For anAddInIndex = 1 To theAddIns.Count
        Set GetAddIn = theAddIns.GetAt(anAddInIndex)
        'Look for my name
        If (GetAddIn.Name = anAddInName) Then
            Exit Function
        End If
    Next
Error:
    'Unexpected
    Set GetAddIn = Nothing
End Function
'*********************************************************************************

'*********************************************************************************
'Implementation of Code Update Command

'CoudeUpdate menu command handler
Private Sub UpdateCodeCommand()
    Dim lCodeUpdate As New rvsRTE.CodeUpdate
    Dim Reporter As rvsRTE.IReporter
    Dim lDict As New Scripting.Dictionary
    mRoseApp.WriteErrorLog "Generating"
    Dim index As Integer
    For index = 1 To RoseApp.CurrentModel.GetSelectedClasses.Count
        Select Case RoseApp.CurrentModel.GetSelectedClasses.GetAt(index).GetAssignedLanguage
        'Only add Visual Studio classes
        Case "Visual Basic", "VC"
            lDict.Add index, RoseApp.CurrentModel.GetSelectedClasses.GetAt(index)
            mRoseApp.WriteErrorLog "   " & RoseApp.CurrentModel.GetSelectedClasses.GetAt(index).Name
        End Select
    Next
    'Only call CodeUpdate if any classes were selected.
    If lDict.Count > 0 Then
        Set Reporter = lCodeUpdate.Start(RoseApp, lDict, Me)
    Else
        mRoseApp.WriteErrorLog "No Visual Studio language classes selected."
    End If
End Sub

'UpdateCode callback OnSynchronize method
'   Method is called after code has been updated
'   The Selection collection will contains code items that was not found in the model.
'   Items remaining in collection will be removed by the CodeUpdate tool
Public Sub OnSynchronize(RoseApp As RoseApplication, Selection As Object, Reporter As IReporter)
    'Do not remove items. Raplace with a new, empty, collecyion
    Set Selection = New Collection
End Sub

'UpdateCode callback OnCompleted method.
'   Method is called when the CodeUpdate tool is compleated.
'   May be used to for reporting, to release objects, or other cleanup's
Public Sub OnCompleted(Reporter As IReporter)
    mRoseApp.WriteErrorLog _
        "Errors:" & Reporter.Errors.Count & " " & _
        "Warnings:" & Reporter.Errors.Count
End Sub

'*********************************************************************************

