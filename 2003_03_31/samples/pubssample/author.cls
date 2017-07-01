VERSION 1.0 CLASS
BEGIN
  MultiUse = 0   'False
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Author"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"36B5AD860122"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"ADO Class"
Option Explicit

'##ModelId=36B5AE7B02B2
'Private constant with database connection string. Default from
'template parameter $ConnectionString (which defaults to an empty
'string).
'##ModelId=36B5AE7B02B2
Private Const ConnectionString As String = ""
Attribute ConnectionString.VB_VarDescription = "##ModelId=36B5AE7B02B2\r\nPrivate constant with database connection string. Default from\r\ntemplate parameter $ConnectionString (which defaults to an empty\r\nstring)."

'##ModelId=36B5AE7B0320
Private mrs As Recordset

'Public Function to get an empty ADO Recordset from the database
'table, add a new record and return the resulting ADO Recordset
'(containing only the new added record). This method uses the
'Private Query method to do actual updates to database. There is an
'option (marked in code as comments) to translate database table
'field names into more readable Property names by using AS in
'the SQL statement. The database table name gets its value from the
'template parameter TableName (which defaults to an empty string).
'##ModelId=38329B270281
Private Function GetNew() As Recordset
Attribute GetNew.VB_Description = "Public Function to get an empty ADO Recordset from the database\r\ntable, add a new record and return the resulting ADO Recordset\r\n(containing only the new added record). This method uses the\r\nPrivate Query method to do actual updates to database. There is an\r\noption (marked in code as comments) to translate database table\r\nfield names into more readable Property names by using AS in\r\nthe SQL statement. The database table name gets its value from the\r\ntemplate parameter TableName (which defaults to an empty string)."
    Dim rs As Recordset

    ' To rename fieldnames from database, use:
    ' Set rs = Query("SELECT <FieldName> AS <PropertyName>, ... FROM Authors WHERE 1=2")
    Set rs = Query("SELECT * FROM Authors WHERE 1=2")
    rs.AddNew

    Set GetNew = rs

End Function

'##ModelId=36B5AF9E0245
Public Property Get Contract() As Variant
    Contract = mrs!Contract
End Property

'##ModelId=36B5AF96003D
Public Property Get Zip() As Variant
    Zip = mrs!Zip
End Property

'##ModelId=36B5AF8B0385
Public Property Get State() As Variant
    State = mrs!State
End Property

'##ModelId=36B5AF7E0231
Public Property Get City() As Variant
    City = mrs!City
End Property

'##ModelId=36B5AF6E019B
Public Property Get Address() As Variant
    Address = mrs!Address
End Property

'##ModelId=36B5AF5E0097
Public Property Get Phone() As Variant
    Phone = mrs!Phone
End Property

'##ModelId=36B5AF50008D
Friend Property Get LName() As Variant
    LName = mrs!LName
End Property

'##ModelId=36B5AF36010F
Friend Property Get FName() As Variant
    FName = mrs!FName
End Property

'##ModelId=36B5AF2B0123
Public Property Get ID() As Variant
    ID = mrs!ID
End Property

'##ModelId=36B5AF1B0137
Public Property Get Name() As Variant
    Name = Me.FName & " " & Me.LName
End Property

'##ModelId=36B5AE7B0321
'Public Property Get to get a reference to the private ADO
'Recordset (mrs).
'##ModelId=36B5AE7B0321
Public Property Get Recordset() As Recordset
Attribute Recordset.VB_Description = "##ModelId=36B5AE7B0321\r\nPublic Property Get to get a reference to the private ADO\r\nRecordset (mrs)."
    Set Recordset = mrs
End Property

'##ModelId=36B5AE7B02EE
'Private Function to return ADO Recordset from query sent as SQL
'string input parameter. Creates a Connection and a Recordset.
'Connects Recordset to the Connection, queries the database (with
'the SQL string) which fills the recordset with the result.
'Disconnects the Recordset from the Connection and closes the
'Connection. Returns the created, queried and filled Recordset.
'Uses the module level constant ConnectionString as connection
'string on connection. Uses client side cursors on Connection.
'##ModelId=36B5AE7B02EE
Private Function Query(ByVal SQL As String) As Recordset
Attribute Query.VB_Description = "##ModelId=36B5AE7B02EE\r\nPrivate Function to return ADO Recordset from query sent as SQL\r\nstring input parameter. Creates a Connection and a Recordset.\r\nConnects Recordset to the Connection, queries the database (with\r\nthe SQL string) which fills the recordset with the result.\r\nDisconnects the Recordset from the Connection and closes the\r\nConnection. Returns the created, queried and filled Recordset.\r\nUses the module level constant ConnectionString as connection\r\nstring on connection. Uses client side cursors on Connection."

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

'##ModelId=36B5AE7B0212
'Public Sub to load one record from the database table into the
'private ADO Recordset. This method uses the Private Query method
'to do actual updates to database. The selection of the record is
'done by a parameter (ID) sent to the method, which assumes the
'database table has an unique primary key field with the type Variant
'(usually a Counter type). There is an option (marked in code as
'comments) to translate database table field names into more
'readable Property names by using AS in the SQL statement. The
'primary key field name gets the value from the template parameter
'ID (which defaults to ID). The database table
'name gets the value from the template parameter Authors (which
'defaults to an empty string).
'##ModelId=36B5AE7B0212
Public Sub GetOne(ByVal ID As Variant)
Attribute GetOne.VB_Description = "##ModelId=36B5AE7B0212\r\nPublic Sub to load one record from the database table into the\r\nprivate ADO Recordset. This method uses the Private Query method\r\nto do actual updates to database. The selection of the record is\r\ndone by a parameter (ID) sent to the method, which assumes the\r\ndatabase table has an unique primary key field with the type Variant\r\n(usually a Counter type). There is an option (marked in code as\r\ncomments) to translate database table field names into more\r\nreadable Property names by using AS in the SQL statement. The\r\nprimary key field name gets the value from the template parameter\r\nID (which defaults to ID). The database table\r\nname gets the value from the template parameter Authors (which\r\ndefaults to an empty string)."

    ' To rename fieldnames from database, use:
    ' Set mrs = Query("SELECT ID As Id, <FieldName> AS <PropertyName>, ... FROM Authors WHERE ID = " & ID)
    Set mrs = Query("SELECT au_id AS id, au_lname AS lname, au_fname AS fname, Phone, Address, City, State, Zip, Contract FROM Authors WHERE (au_lname = '" & ID & "')")
  
End Sub

'##ModelId=36B5AE7B01A6
'Public Property Get to get if private ADO Recordset is positioned
'at the end of the recordset.
'##ModelId=36B5AE7B01A6
Public Function EOF() As Boolean
Attribute EOF.VB_Description = "##ModelId=36B5AE7B01A6\r\nPublic Property Get to get if private ADO Recordset is positioned\r\nat the end of the recordset."

    EOF = mrs.EOF

End Function
