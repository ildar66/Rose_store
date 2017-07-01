VERSION 1.0 CLASS
BEGIN
  MultiUse = 0   'False
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Articles"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = "A set of articles restored from the article database.\r\nArticles objects are based on the database table\r\n""tbl_article"" and the ""query_articles"" stored query\r\ndefinition:\r\n""PARAMETERS [ArticleId] TEXT, [Name] TEXT; SELECT * FROM\r\ntbl_article WHERE article_id LIKE [ArticleId] AND name"""
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3237F8CD0399"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
'A set of articles restored from the article database.
'Articles objects are based on the database table
'"tbl_article" and the "query_articles" stored query
'definition:
'"PARAMETERS [ArticleId] TEXT, [Name] TEXT; SELECT * FROM
'tbl_article WHERE article_id LIKE [ArticleId] AND name"
Option Explicit


'##ModelId=3237F8CB02D5
Private Storage As Persistence

'Returns the an article from the set.
'Index syntax.
' <nothing> = Returns the current article
' Number = Returns the article indexed by number.  Range:
'1..Count
'##ModelId=3237F8CD039A
Public Function Item(Optional index As Variant) As Article
Attribute Item.VB_Description = "Returns the an article from the set.\r\nIndex syntax.\r\n <nothing> = Returns the current article\r\n Number = Returns the article indexed by number.  Range:\r\n1..Count"
    On Error GoTo Articles_Item__exception
    'Move to the indexed position
    'Note: Item is indexed 1..Count, Recordset is indexed 0..Count-1
    If Not IsMissing(index) Then
        Storage.Recordset.AbsolutePosition = index - 1
    End If
    'Allocate and return the current article object
    Set Item = New Article
    Item.Article Id:=Storage.Recordset!Article_Id, Backlog:=Storage.Recordset!Backlog, Delivery_Time:=Storage.Recordset!Delivery_Time, Description:=Storage.Recordset!Description, Name:=Storage.Recordset!Name, Price:=Storage.Recordset!Price, Quantity:=Storage.Recordset!Quantity
    Exit Function
Articles_Item__exception:
    Resume Articles_Item__end
Articles_Item__end:
    Exit Function
End Function

'Returns the number of items in the set.
'##ModelId=3237F8CD039C
Public Property Get Count() As Long
Attribute Count.VB_Description = "Returns the number of items in the set."
    On Error GoTo Articles_Count__exception
    If Storage.RecordsExists Then
        Storage.Recordset.MoveLast
        Count = Storage.Recordset.RecordCount
    Else
        Count = 0
    End If
    Exit Property
Articles_Count__exception:
    Resume Articles_Count__end
Articles_Count__end:
    Exit Property
End Property

'Sets the criterion for fetching a set of articles.
'Id Syntax:
'  ignore or "*" for all.
'  "100-*" for all articles in the "100" group.
'Name Syntax:
'  ignore or  "*" for all.
'  "S*" for all articles starting with "S".
'##ModelId=3237F8CD039D
Public Sub Fetch(Optional Id As Variant, Optional Name As Variant)
Attribute Fetch.VB_Description = "Sets the criterion for fetching a set of articles.\r\nId Syntax:\r\n  ignore or ""*"" for all.\r\n  ""100-*"" for all articles in the ""100"" group.\r\nName Syntax:\r\n  ignore or  ""*"" for all.\r\n  ""S*"" for all articles starting with ""S""."
    On Error GoTo Articles_Fetch__exception
    'Set the Article Id query parameter
    If Not IsMissing(Id) Then
        Storage.QueryDef.Parameters!ArticleId = Id
    Else
        Storage.QueryDef.Parameters!ArticleId = "*"
    End If
    'Set the Name query parameter
    If Not IsMissing(Name) Then
        Storage.QueryDef.Parameters!Name = Name
    Else
        Storage.QueryDef.Parameters!Name = "*"
    End If
    Storage.Execute
    Exit Sub
Articles_Fetch__exception:
    Resume Articles_Fetch__end
Articles_Fetch__end:
    Exit Sub
End Sub

'Returns the previous article from the set.
'##ModelId=3237F8CD03A0
Public Function MovePrevious() As Article
Attribute MovePrevious.VB_Description = "Returns the previous article from the set."
    On Error GoTo Articles_MovePrevious__exception
    If Storage.RecordsExists Then
        'Move to the previous item in the recordset
        Storage.Recordset.MovePrevious
        'Return the current article by calling the Item method
        Set MovePrevious = Item
    End If
    Exit Function
Articles_MovePrevious__exception:
    Resume Articles_MovePrevious__end
Articles_MovePrevious__end:
    Exit Function
End Function

'Returns the next article from the set.
'##ModelId=3237F8CD03A1
Public Function MoveNext() As Article
Attribute MoveNext.VB_Description = "Returns the next article from the set."
    On Error GoTo Articles_MoveNext__exception
    If Storage.RecordsExists And Not Storage.Recordset.EOF Then
        'Move to the next item in the recordset
        Storage.Recordset.MoveNext
        'Return the current article by calling the Item method
        Set MoveNext = Item
    End If
    Exit Function
Articles_MoveNext__exception:
    Resume Articles_MoveNext__end
Articles_MoveNext__end:
    Exit Function
End Function

'Returns the first article from the set.
'##ModelId=3237F8CD03CA
Public Function MoveFirst() As Article
Attribute MoveFirst.VB_Description = "Returns the first article from the set."
    On Error GoTo Articles_MoveFirst__exception
    If Storage.RecordsExists Then
        'Move to the first item in the recordset
        Storage.Recordset.MoveFirst
        'Return the current article by calling the Item method
        Set MoveFirst = Item
    End If
    Exit Function
Articles_MoveFirst__exception:
    Resume Articles_MoveFirst__end
Articles_MoveFirst__end:
    Exit Function
End Function

'##ModelId=3237F8CD03CB
Private Sub Class_Initialize()
    On Error GoTo Articles_Class_Initialize__exception
    'Setup the persistence object
    Set Storage = New Persistence
    Storage.Connect ("Query_Articles")
    Exit Sub
Articles_Class_Initialize__exception:
    Resume Articles_Class_Initialize__end
Articles_Class_Initialize__end:
    Exit Sub
End Sub

'##ModelId=3237F8CD03CC
Private Sub Class_Terminate()
    On Error GoTo Articles_Class_Terminate__exception
    Set Storage = Nothing
    Exit Sub
Articles_Class_Terminate__exception:
    Resume Articles_Class_Terminate__end
Articles_Class_Terminate__end:
    Exit Sub
End Sub

