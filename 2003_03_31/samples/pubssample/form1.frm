VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Author details"
   ClientHeight    =   6525
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   6510
   LinkTopic       =   "Form1"
   ScaleHeight     =   6525
   ScaleWidth      =   6510
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      Caption         =   "Show authors"
      Height          =   495
      Left            =   4920
      TabIndex        =   1
      Top             =   5880
      Width           =   1455
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Show author"
      Height          =   495
      Left            =   4920
      TabIndex        =   0
      Top             =   5280
      Width           =   1455
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"36B5AD7902C6"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Form"
Option Explicit

'##ModelId=36B5B136026C
Public Sub Command2_Click()
    Dim lAuthors As New Authors
    lAuthors.GetAll
    Cls
    Print "ID", "NAME", "                        ADDRESS", "                       CITY"
    Do Until lAuthors.EOF
        Print lAuthors.ID, lAuthors.Name, lAuthors.Address, lAuthors.City
        lAuthors.MoveNext
    Loop
    Set lAuthors = Nothing
End Sub

'##ModelId=36B5B12400DC
Public Sub Command1_Click()
    Dim lAuthor As New Author
    Cls
    lAuthor.GetOne InputBox("Author name?", , "White")
    If Not lAuthor.EOF Then
        Print "NAME", "                        ADDRESS", "                       CITY"
        Print lAuthor.Name, lAuthor.Address, lAuthor.City
        Set lAuthor = Nothing
    End If
End Sub
