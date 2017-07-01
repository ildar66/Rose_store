VERSION 1.0 CLASS
BEGIN
  MultiUse = 0   'False
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Article"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Description = "An article in stock, uniquely identified by an article\r\nnumber."
Attribute VB_Ext_KEY = "RVB_UniqueId" ,"3237F8CD024E"
Attribute VB_Ext_KEY = "RVB_ModelStereotype" ,"Class Module"
'An article in stock, uniquely identified by an article
'number.
Option Explicit


'A unique article identifier. Also the article number used
'for identifying articles in stock.
'##ModelId=3237F8CD032E
Private mArticleId As Variant
Attribute mArticleId.VB_VarDescription = "A unique article identifier. Also the article number used\r\nfor identifying articles in stock."

'The name of the article. The name must not be unique but should describe the
'article.
'##ModelId=3237F8CD032F
Private mName As Variant
Attribute mName.VB_VarDescription = "The name of the article. The name must not be unique but should describe the\r\narticle."

'The number of articles currently in stock.
'##ModelId=3237F8CD0330
Private mQuantity As Variant
Attribute mQuantity.VB_VarDescription = "The number of articles currently in stock."

'The price paid by a customer when ordering an item of the
'article.
'##ModelId=3237F8CD035C
Private mPrice As Variant
Attribute mPrice.VB_VarDescription = "The price paid by a customer when ordering an item of the\r\narticle."

'The time for a producer to deliver backlogged items.
'##ModelId=3237F8CD035D
Private mDeliveryTime As Variant
Attribute mDeliveryTime.VB_VarDescription = "The time for a producer to deliver backlogged items."

'The number of items reserved for unfilled orders.
'##ModelId=3237F8CD035E
Private mBacklog As Variant
Attribute mBacklog.VB_VarDescription = "The number of items reserved for unfilled orders."

'A descriptive text of the article and its characteristics.
'##ModelId=3237F8CD0398
Private mDescription As Variant
Attribute mDescription.VB_VarDescription = "A descriptive text of the article and its characteristics."

'##ModelId=3237F8CB02D2
Private Storage As Persistence

'##ModelId=3237F8CD0280
Public Sub Article(Id As Variant, Backlog As Variant, Delivery_Time As Variant, Description As Variant, Name As Variant, Price As Variant, Quantity As Variant)
    On Error GoTo Article_Article__exception
    mArticleId = Id
    mBacklog = Backlog
    mDeliveryTime = DeliveryTime
    mDescription = Description
    mName = Name
    mPrice = Price
    mQuantity = Quantity
    Exit Sub
Article_Article__exception:
    Resume Article_Article__end
Article_Article__end:
    Exit Sub
End Sub

'Fetches the article referenced article from the database.
'##ModelId=3237F8CD0288
Public Sub Fetch(Id As Variant)
Attribute Fetch.VB_Description = "Fetches the article referenced article from the database."
    On Error GoTo Article_Fetch__exception
    Exit Sub
Article_Fetch__exception:
    Resume Article_Fetch__end
Article_Fetch__end:
    Exit Sub
End Sub

'A unique article identifier. Also the article number used
'for identifying articles in stock.
'##ModelId=3237F8CD028A
Public Property Get ArticleId() As Variant
Attribute ArticleId.VB_Description = "A unique article identifier. Also the article number used for identifying\r\narticles in stock."
    On Error GoTo Article_ArticleId__exception
    ArticleId = mArticleId
    Exit Property
Article_ArticleId__exception:
    Resume Article_ArticleId__end
Article_ArticleId__end:
    Exit Property
End Property

'A unique article identifier. Also the article number used for identifying
'articles in stock.
'##ModelId=3237F8CD028B
Public Property Let ArticleId(value As Variant)
    On Error GoTo Article_ArticleId__exception
    Let mArticleId = value
    Exit Property
Article_ArticleId__exception:
    Resume Article_ArticleId__end
Article_ArticleId__end:
    Exit Property
End Property

'The name of the article. The name must not be unique but
'should describe the article.
'##ModelId=3237F8CD02BC
Public Property Get Name() As Variant
Attribute Name.VB_Description = "The name of the article. The name must not be unique but should describe the\r\narticle."
    On Error GoTo Article_Name__exception
    Name = mName
    Exit Property
Article_Name__exception:
    Resume Article_Name__end
Article_Name__end:
    Exit Property
End Property

'The name of the article. The name must not be unique but should describe the
'article.
'##ModelId=3237F8CD02BD
Public Property Let Name(value As Variant)
    On Error GoTo Article_Name__exception
    Let mName = value
    Exit Property
Article_Name__exception:
    Resume Article_Name__end
Article_Name__end:
    Exit Property
End Property

'The number of articles currently in stock.
'##ModelId=3237F8CD02BF
Public Property Get Quantity() As Variant
    On Error GoTo Article_Quantity__exception
    Quantity = mQuantity
    Exit Property
Article_Quantity__exception:
    Resume Article_Quantity__end
Article_Quantity__end:
    Exit Property
End Property

'The number of articles currently in stock.
'##ModelId=3237F8CD02C0
Public Property Let Quantity(value As Variant)
Attribute Quantity.VB_Description = "The number of articles currently in stock."
    On Error GoTo Article_Quantity__exception
    Let mQuantity = value
    Exit Property
Article_Quantity__exception:
    Resume Article_Quantity__end
Article_Quantity__end:
    Exit Property
End Property

'The price paid by a customer when ordering an item of the
'article.
'##ModelId=3237F8CD02C2
Public Property Get Price() As Variant
    On Error GoTo Article_Price__exception
    Price = mPrice
    Exit Property
Article_Price__exception:
    Resume Article_Price__end
Article_Price__end:
    Exit Property
End Property

'The price paid by a customer when ordering an item of the
'article.
'##ModelId=3237F8CD02C3
Public Property Let Price(value As Variant)
Attribute Price.VB_Description = "The price paid by a customer when ordering an item of the\r\narticle."
    On Error GoTo Article_Price__exception
    Let mPrice = value
    Exit Property
Article_Price__exception:
    Resume Article_Price__end
Article_Price__end:
    Exit Property
End Property

'The time for a producer to deliver backlogged items.
'##ModelId=3237F8CD02EF
Public Property Get DeliveryTime() As Variant
    On Error GoTo Article_DeliveryTime__exception
    DeliveryTime = mDeliveryTime
    Exit Property
Article_DeliveryTime__exception:
    Resume Article_DeliveryTime__end
Article_DeliveryTime__end:
    Exit Property
End Property

'The time for a producer to deliver backlogged items.
'##ModelId=3237F8CD02F0
Public Property Let DeliveryTime(value As Variant)
Attribute DeliveryTime.VB_Description = "The time for a producer to deliver backlogged items."
    On Error GoTo Article_DeliveryTime__exception
    Let mDeliveryTime = value
    Exit Property
Article_DeliveryTime__exception:
    Resume Article_DeliveryTime__end
Article_DeliveryTime__end:
    Exit Property
End Property

'The number of items reserved for unfilled orders.
'##ModelId=3237F8CD02F2
Public Property Get Backlog() As Variant
    On Error GoTo Article_Backlog__exception
    Backlog = mBacklog
    Exit Property
Article_Backlog__exception:
    Resume Article_Backlog__end
Article_Backlog__end:
    Exit Property
End Property

'The number of items reserved for unfilled orders.
'##ModelId=3237F8CD02F3
Public Property Let Backlog(value As Variant)
Attribute Backlog.VB_Description = "The number of items reserved for unfilled orders."
    On Error GoTo Article_Backlog__exception
    Let mBacklog = value
    Exit Property
Article_Backlog__exception:
    Resume Article_Backlog__end
Article_Backlog__end:
    Exit Property
End Property

'A descriptive text of the article and its characteristics.
'##ModelId=3237F8CD02F5
Public Property Get Description() As Variant
    On Error GoTo Article_Description__exception
    Description = mDescription
    Exit Property
Article_Description__exception:
    Resume Article_Description__end
Article_Description__end:
    Exit Property
End Property

'A descriptive text of the article and its characteristics.
'##ModelId=3237F8CD032A
Public Property Let Description(value As Variant)
Attribute Description.VB_Description = "A descriptive text of the article and its characteristics."
    On Error GoTo Article_Description__exception
    Let mDescription = value
    Exit Property
Article_Description__exception:
    Resume Article_Description__end
Article_Description__end:
    Exit Property
End Property

'##ModelId=3237F8CD032C
Private Sub Class_Initialize()
    On Error GoTo Article_Class_Initialize__exception
    Exit Sub
Article_Class_Initialize__exception:
    Resume Article_Class_Initialize__end
Article_Class_Initialize__end:
    Exit Sub
End Sub

'##ModelId=3237F8CD032D
Private Sub Class_Terminate()
    On Error GoTo Article_Class_Terminate__exception
    Exit Sub
Article_Class_Terminate__exception:
    Resume Article_Class_Terminate__end
Article_Class_Terminate__end:
    Exit Sub
End Sub

