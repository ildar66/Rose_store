VERSION 1.0 CLASS
BEGIN
  MultiUse = 0   'False
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Authors"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"36B5AD8B00E6"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"ADO Class"
Option Explicit

'##ModelId=36B5AFEA02BE
'Private constant with database connection string. Default from
'template parameter $ConnectionString (which defaults to an empty
'string).
'##ModelId=36B5AFEA02BE
Private Const ConnectionString As String = ""
Attribute ConnectionString.VB_VarDescription = "##ModelId=36B5AFEA02BE\r\nPrivate constant with database connection string. Default from\r\ntemplate parameter $ConnectionString (which defaults to an empty\r\nstring)."

'##ModelId=36B5AFEA032C
Private mrs As Recordset

'Public Function to get an empty ADO Recordset from the database
'table, add a new record and return the resulting ADO Recordset
'(containing only the new added record). This method uses the
'Private Query method to do actual updates to database. There is an
'option (marked in code as comments) to translate database table
'field names into more readable Property names by using AS in
'the SQL statement. The database table name gets its value from the
'template parameter TableName (which defaults to an empty string).
'##ModelId=38329B3B0149
Private Function GetNew() As Recordset
Attribute GetNew.VB_Description = "Public Function to get an empty ADO Recordset from the database\r\ntable, add a new record and return the resulting ADO Recordset\r\n(containing only the new added record). This method uses the\r\nPrivate Query method to do actual updates to database. There is an\r\noption (marked in code as comments) to translate database table\r\nfield names into more readable Property names by using AS in\r\nthe SQL statement. The database table name gets its value from the\r\ntemplate parameter TableName (which defaults to an empty string)."
    Dim rs As Recordset

    ' To rename fieldnames from database, use:
    ' Set rs = Query("SELECT <FieldName> AS <PropertyName>, ... FROM Authors WHERE 1=2")
    Set rs = Query("SELECT * FROM Authors WHERE 1=2")
    rs.AddNew

    Set GetNew = rs

End Function

'##ModelId=36B5B0B400E7
Public Property Get Contract() As Variant
    Contract = mrs!Contract
End Property

'##ModelId=36B5B0A80321
Public Property Get Zip() As Variant
    Zip = mrs!Zip
End Property

'##ModelId=36B5B09E0105
Public Property Get City() As Variant
    City = mrs!City
End Property

'##ModelId=36B5B0930033
Public Property Get Address() As Variant
    Address = mrs!Address
End Property

'##ModelId=36B5B08802DB
Public Property Get Phone() As Variant
    Phone = mrs!Phone
End Property

'##ModelId=36B5B07E0349
Friend Property Get LName() As Variant
    LName = mrs!LName
End Property

'##ModelId=36B5B06D024F
Friend Property Get FName() As Variant
    FName = mrs!FName
End Property

'##ModelId=36B5B0650051
Public Property Get ID() As Variant
    ID = mrs!ID
End Property

'##ModelId=36B5B050032B
Public Property Get Name() As Variant
    Name = Me.FName & " " & Me.LName
End Property

'##ModelId=36B5AFEA032D
'Public Property Get to get a reference to the private ADO
'Recordset (mrs).
'##ModelId=36B5AFEA032D
Public Property Get Recordset() As Recordset
Attribute Recordset.VB_Description = "##ModelId=36B5AFEA032D\r\nPublic Property Get to get a reference to the private ADO\r\nRecordset (mrs)."
    Set Recordset = mrs
End Property

'##ModelId=36B5AFEA02FA
'Private Function to return ADO Recordset from query sent as SQL
'string input parameter. Creates a Connection and a Recordset.
'Connects Recordset to the Connection, queries the database (with
'the SQL string) which fills the recordset with the result.
'Disconnects the Recordset from the Connection and closes the
'Connection. Returns the created, queried and filled Recordset.
'Uses the module level constant ConnectionString as connection
'string on connection. Uses client side cursors on Connection.
'##ModelId=36B5AFEA02FA
Private Function Query(ByVal SQL As String) As Recordset
Attribute Query.VB_Description = "##ModelId=36B5AFEA02FA\r\nPrivate Function to return ADO Recordset from query sent as SQL\r\nstring input parameter. Creates a Connection and a Recordset.\r\nConnects Recordset to the Connection, queries the database (with\r\nthe SQL string) which fills the recordset with the result.\r\nDisconnects the Recordset from the Connection and closes the\r\nConnection. Returns the created, queried and filled Recordset.\r\nUses the module level constant ConnectionString as connection\r\nstring on connection. Uses client side cursors on Connection."

    Dim err As Error
    Dim aco As Connection
    Dim ars As Recordset

    ' Create objects
    Set aco = CreateObject("ADODB.Connection")
    Set ars = CreateObject("ADODB.Recordset")

    ' Open Connection
    aco.CursorLocation = adUseClient
    aco.ConnectionString = ConnectionString
    aco.Open

    ' Open Recordset
    ars.CursorType = adOpenKeyset
    ars.LockType = adLockBatchOptimistic
    ars.ActiveConnection = aco
    ars.Open SQL

    ' Return Recordset
    Set Query = ars

    ' Disconnect Recordset from Connection
    Set ars.ActiveConnection = Nothing

    ' Close Connection
    aco.Close

End Function

'##ModelId=36B5AFEA028B
'Public Sub to reposition the private ADO Recordset to the previous record.
'##ModelId=36B5AFEA028B
Public Sub MovePrevious()
Attribute MovePrevious.VB_Description = "##ModelId=36B5AFEA028B\r\nPublic Sub to reposition the private ADO Recordset to the previous record."
    mrs.MovePrevious
End Sub

'##ModelId=36B5AFEA028A
'Public Sub to reposition the private ADO Recordset to the next record.
'##ModelId=36B5AFEA028A
Public Sub MoveNext()
Attribute MoveNext.VB_Description = "##ModelId=36B5AFEA028A\r\nPublic Sub to reposition the private ADO Recordset to the next record."
    mrs.MoveNext
End Sub

'##ModelId=36B5AFEA0250
'Public Sub to position the private ADO Recordset on the last record.
'##ModelId=36B5AFEA0250
Public Sub MoveLast()
Attribute MoveLast.VB_Description = "##ModelId=36B5AFEA0250\r\nPublic Sub to position the private ADO Recordset on the last record."
    mrs.MoveLast
End Sub

'##ModelId=36B5AFEA024F
'Public Sub to position the private ADO Recordset on the first record.
'##ModelId=36B5AFEA024F
Public Sub MoveFirst()
Attribute MoveFirst.VB_Description = "##ModelId=36B5AFEA024F\r\nPublic Sub to position the private ADO Recordset on the first record."
    mrs.MoveFirst
End Sub

'##ModelId=36B5AFEA021C
'Public Sub to load all records from the database table into the
'private ADO Recordset. This method uses the Private Query method
'to do actual update to database. There is an option (marked in
'code as comments) to translate database table field names into
'more readable Property names by using AS in the SQL statement.
'The database table name the gets value from the template parameter
'Authors (which defaults to an empty string).
'##ModelId=36B5AFEA021C
Public Sub GetAll()
Attribute GetAll.VB_Description = "##ModelId=36B5AFEA021C\r\nPublic Sub to load all records from the database table into the\r\nprivate ADO Recordset. This method uses the Private Query method\r\nto do actual update to database. There is an option (marked in\r\ncode as comments) to translate database table field names into\r\nmore readable Property names by using AS in the SQL statement.\r\nThe database table name the gets value from the template parameter\r\nAuthors (which defaults to an empty string)."

    ' Get Recordset
    ' To rename fieldnames from database, use:
    ' Set GetAll = Query("SELECT <FieldName> AS <PropertyName>, ... FROM Authors")
    Set mrs = Query("SELECT au_id AS id, au_lname AS lname, au_fname AS fname, Phone, Address, City, State, Zip, Contract FROM Authors")

End Sub

'##ModelId=36B5AFEA01E2
'Public Property Get to get if private ADO Recordset is positioned
'at the end of the recordset.
'##ModelId=36B5AFEA01E2
Public Function EOF() As Boolean
Attribute EOF.VB_Description = "##ModelId=36B5AFEA01E2\r\nPublic Property Get to get if private ADO Recordset is positioned\r\nat the end of the recordset."
    EOF = mrs.EOF
End Function

'##ModelId=36B5AFEA01AE
'Public Property Get to get if private ADO Recordset is positioned
'at the beginning of the recordset.
'##ModelId=36B5AFEA01AE
Public Function BOF() As Boolean
Attribute BOF.VB_Description = "##ModelId=36B5AFEA01AE\r\nPublic Property Get to get if private ADO Recordset is positioned\r\nat the beginning of the recordset."
    BOF = mrs.BOF
End Function

'##ModelId=36B5AFEA017C
'Public Function to add new record to private ADO Recordset. The
'actual insertion (INSERT) into the database table will happen the
'next time the public Sub Update is invoked.
'##ModelId=36B5AFEA017C
Public Function AddNew() As Recordset
Attribute AddNew.VB_Description = "##ModelId=36B5AFEA017C\r\nPublic Function to add new record to private ADO Recordset. The\r\nactual insertion (INSERT) into the database table will happen the\r\nnext time the public Sub Update is invoked."

    ' Create an empty recordset if needed
    If mrs Is Nothing Then Set mrs = GetNew

    mrs.AddNew

End Function
