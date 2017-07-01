VERSION 1.0 CLASS
BEGIN
  MultiUse = 0   'False
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Persistence"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = "Reuse pattern for persistent storage of business object\r\nstates and values. The persistence class is based on\r\nexisting database tables and a set of predefined queries."
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3237F8CE0359"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
'Reuse pattern for persistent storage of business object
'states and values. The persistence class is based on
'existing database tables and a set of predefined queries.
Option Explicit


'##ModelId=3237F8CC025A
Private mRecordset As DAO.Recordset

'##ModelId=3237F8CC025D
Private mQueryDef As DAO.QueryDef

'Flag indicating the existence of records.
'##ModelId=3237F8CE03C1
Private mRecordsExists As Boolean
Attribute mRecordsExists.VB_VarDescription = "Flag indicating the existence of records."

'##ModelId=330248950398
Public Property Get Recordset() As Recordset
    Set Recordset = mRecordset
End Property

'##ModelId=3302489602EE
Public Property Get QueryDef() As QueryDef
    Set QueryDef = mQueryDef
End Property

'Connects to an existing QueryDef object in the database.
'##ModelId=3237F8CE038E
Public Sub Connect(Query_Name As String)
Attribute Connect.VB_Description = "Connects to an existing QueryDef object in the database."
    On Error GoTo Persistence_Connect__exception
    Set mQueryDef = OrderSys_Db.QueryDefs(Query_Name)
    Exit Sub
Persistence_Connect__exception:
    Resume Persistence_Connect__end
Persistence_Connect__end:
    Exit Sub
End Sub

'Runs the SQL query and builds the recordset. Modifies the
'records_exists flag.
'##ModelId=3237F8CE0390
Public Sub Execute()
Attribute Execute.VB_Description = "Runs the SQL query and builds the recordset. Modifies the\r\nrecords_exists flag."
    On Error GoTo Persistence_Execute__exception
    Set mRecordset = mQueryDef.OpenRecordset()
    mRecordset.MoveFirst
    If Not mRecordset.EOF Then
        mRecordsExists = True
    Else
        mRecordsExists = False
    End If
    Exit Sub
Persistence_Execute__exception:
    Resume Persistence_Execute__end
Persistence_Execute__end:
    Exit Sub
End Sub

'Flag indicating the existence of records.
'##ModelId=3237F8CE0391
Public Property Get RecordsExists() As Boolean
Attribute RecordsExists.VB_Description = "Flag indicating the existence of records."
    On Error GoTo Persistence_RecordsExists__exception
    RecordsExists = mRecordsExists
    Exit Property
Persistence_RecordsExists__exception:
    Resume Persistence_RecordsExists__end
Persistence_RecordsExists__end:
    Exit Property
End Property

'##ModelId=3237F8CE0392
Private Sub Class_Initialize()
    On Error GoTo Persistence_Class_Initialize__exception
    Set mQueryDef = New QueryDef
    mRecordsExists = False
    Exit Sub
Persistence_Class_Initialize__exception:
    Resume Persistence_Class_Initialize__end
Persistence_Class_Initialize__end:
    Exit Sub
End Sub

'##ModelId=3237F8CE03C0
Private Sub Class_Terminate()
    On Error GoTo Persistence_Class_Terminate__exception
    Exit Sub
Persistence_Class_Terminate__exception:
    Resume Persistence_Class_Terminate__end
Persistence_Class_Terminate__end:
    Exit Sub
End Sub

