<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Банк Клиент Онлайн - Документы</TITLE>
<!--META http-equiv=Content-Type content="text/html; charset=windows-1251"-->
<%@ page contentType="text/html; charset=windows-1251"%>
<LINK href="/iBank/theme/Master.css" rel="stylesheet" type="text/css">
<SCRIPT language=javascript src="/iBank/ibankjsp/common/common.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript1.2 type=text/javascript>
window.onbeforeunload = unloadCheck;
window.setTimeout('window.onbeforeunload=null', 60000 * 10);
function unloadCheck()
{
	if(event.clientX > document.body.clientWidth && event.clientY < 0)
		return 'Внимание!\nДля выхода из системы \'IBank \' воспользуйтесь пунктом меню \'Выход\'.';
	else
		return;
}
</SCRIPT>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
</HEAD>
<BODY>
<%@ page import="com.overstar.ildar.ibank.model.*" %>
<%@ page import="com.overstar.ildar.ibank.model.documents.*" %>
<jsp:useBean id="userIBank" scope="session" class="com.overstar.ildar.ibank.model.IBank" type="com.overstar.ildar.ibank.model.IBank"/>
<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name))
  { if(aSort.endsWith("desc")) 
     return (" <IMG width=8 height=7 hspace=3 src='/iBank/ibankjsp/images/down.gif' alt='по убыванию'> ");
    else
     return (" <IMG width=8 height=7 hspace=3 src='/iBank/ibankjsp/images/up.gif' alt='по возрастанию'> "); 
  }
 else return ("");      
}

private String checked(java.util.List aStatuses, String name) {
if(aStatuses.contains(name))
  return (" CHECKED ");
else
  return ("");  
} 

private String selected(String name1, String name2) {
if(name1.equals(name2))
  return (" SELECTED ");
else
  return ("");  
}
%>
<%
//Execute Bean Methods 
java.util.Vector documents = userIBank.getCurrentIClient().getDocumentsAll();
Document curDocument = null;
//определение типа, статусов, сортировки документа:
String doc_type = String.valueOf( userIBank.getDocTransMgr().getDoc_type() ) ;
java.util.List statuses = java.util.Arrays.asList(userIBank.getDocTransMgr().getStatuses());
String sortBy = userIBank.getDocTransMgr().getSortBy();
//установка дат("от" и "до"):
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
String fromDateStr = userIBank.getDocTransMgr().getFromDate();
java.util.Date fromDate = formatter.parse(fromDateStr);
java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
calendar.setTime(fromDate);
String fromDateDD = String.valueOf(calendar.get(java.util.Calendar.DATE));
String fromDateMM = String.valueOf( (calendar.get(java.util.Calendar.MONTH)+1) );
String fromDateYY = String.valueOf(calendar.get(java.util.Calendar.YEAR));
String toDateStr = userIBank.getDocTransMgr().getToDate();
java.util.Date toDate = formatter.parse(toDateStr);
calendar.setTime(toDate);
String toDateDD = String.valueOf(calendar.get(java.util.Calendar.DATE));
String toDateMM = String.valueOf( (calendar.get(java.util.Calendar.MONTH)+1) );
String toDateYY = String.valueOf(calendar.get(java.util.Calendar.YEAR));
//Определение периодов дат:
calendar = new java.util.GregorianCalendar();
String todayStr=formatter.format(calendar.getTime());
String period1 = todayStr+","+todayStr;
int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
calendar.add( java.util.Calendar.DATE, -(dayOfWeek-calendar.getFirstDayOfWeek()) );
String firstDayOfWeekStr=formatter.format(calendar.getTime());
String period2 = firstDayOfWeekStr+","+todayStr;
calendar = new java.util.GregorianCalendar();
calendar.set(java.util.Calendar.DATE, 1);
String firstDayOfMonth=formatter.format(calendar.getTime());
String period3 = firstDayOfMonth+","+todayStr;
int month = calendar.get(java.util.Calendar.MONTH)+1;
if(month<4)
  calendar.set(java.util.Calendar.MONTH , 0);
if( (month>=4)&&(month<=6))
  calendar.set(java.util.Calendar.MONTH , 3);
if( (month>=7)&&(month<=9))
  calendar.set(java.util.Calendar.MONTH , 6);
  if(month>9)
  calendar.set(java.util.Calendar.MONTH , 9);
String firstDayOfQuarter=formatter.format(calendar.getTime()); 
String period4 = firstDayOfQuarter+","+todayStr;     
%>
<TABLE cellSpacing=0 cellPadding=0 width="100%" background="/iBank/ibankjsp/images/bgtop.gif" border=0>
    <TBODY>
        <TR>
            <TD width=120><IMG height=51 alt="IBANK logo" src="/iBank/ibankjsp/images/logo.gif" width=120 border=0></TD>
            <TD class=toptitle>• IBANK - Клиент Онлайн • Тест • <%=userIBank.getCurrentIClient().rtName_cln()%></TD>
            <TD class=toptitle align=right>• <A class=topmenu href="javascript:openHelp(window.location,'');">справка</A>&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="100%" background="/iBank/ibankjsp/images/hr2.gif" border=0>
    <TBODY>
        <TR>
            <TD width=120 background="/iBank/ibankjsp/images/hr1.gif"><IMG height=15 alt="" src="/iBank/ibankjsp/images/zagl1.gif" width=18></TD>
            <TD>&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
        <TR vAlign=top>
            <TD width=10 bgColor=#dcdee0>&nbsp;</TD>
            <TD class=menu width=110 bgColor=#dcdee0><A href="/iBank/ibankjsp/CLIENT_INFO.jsp">Клиент</A><BR>
            <A href="/iBank/ibankjsp/ACCOUNTS.jsp">Счета</A><BR>
            <A class=current href="/iBank/ChooseActionServlet?action=ListDocuments">Документы</A><BR>
            <A href="/iBank/ibankjsp/STATEMENTS.jsp">Выписки</A><BR>
            <A href="/iBank/ibankjsp/REFERENCES.jsp">Справочники</A><BR>
            <A href="/iBank/ibankjsp/MESSAGES.jsp">Сообщения</A><BR>
            <A href="/iBank/ibankjsp/REPORTS.jsp">Отчеты</A><BR>
            <A href="/iBank/ibankjsp/SETUP.jsp">Настройки</A><BR>
            <A href="/iBank/StopServlet">Выход</A><BR>
            </TD>
            <TD>
            <DIV class=title>Документы</DIV>
            <DIV class=body><!-- --> <SCRIPT language=javascript src="/iBank/ibankjsp/common/validate.js" type=text/javascript></SCRIPT> <SCRIPT language=javascript type=text/javascript>
function ToggleStatus(n)
{
	var e = document.docform.status;
	for(var i = 0; i < e.length; i++)
		if(e[i].value == n)
			e[i].checked = !e[i].checked;
}

function SortBy(field) 
{
	var e = document.docform.sort;
	e.form.action.value = "SortBy";
	e.value = (e.value == field)?field + ' desc':field;
	e.form.submit();
}
function Read(e)
{
    var theForm = e.form;
	theForm.action.value = "Read";
	if(field_check(theForm.todate, 'Дата по', 7, true) && field_check(theForm.fromdate, 'Дата с', 7, true))
	  theForm.submit();
}
function AddNew(e)
{
	e.form.action.value = "AddNew";
	e.form.submit();	
}	
function isChoice()
{
  var e = document.docform.elements;
  for(var i=0; i < e.length; i++)
    if(e[i].name=='documentID' && e[i].checked == true)
	  return true;
  return false;
}
function Edit(e)
{
	if(isChoice())
	 {
	   e.form.action.value = "Edit";
	   e.form.submit();	
	 }
	else
		alert('Выберите строку для изменения.');
}
function EditN(id)
{
   var theForm = document.docform;
   theForm.action.value = "Edit";
   var e = document.docform.elements;
   for(var i=0; i < e.length; i++)
	if(e[i].name=='documentID' && e[i].value==id)
	  e[i].checked = true;
   theForm.submit();	
}
function Delete(e)
{
	if(isChoice())
	 {
	   e.form.action.value = "Delete";
	   e.form.submit();	
	 }
	else
		alert('Выберите строку для удаления.');
}
function ViewDocum(e)
{
	if(isChoice())
	 {
       var docid ;
       var elems = e.form.elements;
       for(var i=0; i < elems.length; i++)
       if(elems[i].name=='documentID' && elems[i].checked == true)
         docid = elems[i].value;
       var wnd;
       if(e.form.doc_type.value =='1')  
	     wnd = window.open('/iBank/ibankjsp/PAYMENT_VIEW.jsp?docID=' + docid, 'report', 'width=660,top=0,height='+(window.screen.availHeight-100)+',resizable=yes,status=no,toolbar=no,menubar=yes,location=no,scrollbars=yes');
       else if(e.form.doc_type.value =='8')  
	     wnd = window.open('/iBank/ibankjsp/ACCREDITIVE_VIEW.jsp?docID=' + docid, 'report', 'width=660,top=0,height='+(window.screen.availHeight-100)+',resizable=yes,status=no,toolbar=no,menubar=yes,location=no,scrollbars=yes');
	   wnd.focus();
	 }
	else
		alert('Выберите строку для просмотра.');
}
function ViewDocumN(docid)
{
   var theForm = document.docform;;
   var elems = theForm.elements;
   for(var i=0; i < elems.length; i++)
     if(elems[i].name=='documentID' && elems[i].value==docid)
        elems[i].checked = true;
   var wnd;
   if(theForm.doc_type.value =='1')  
	 wnd = window.open('/iBank/ibankjsp/PAYMENT_VIEW.jsp?docID=' + docid, 'report', 'width=660,top=0,height='+(window.screen.availHeight-100)+',resizable=yes,status=no,toolbar=no,menubar=yes,location=no,scrollbars=yes');
   else if(theForm.doc_type.value =='8')  
     wnd = window.open('/iBank/ibankjsp/ACCREDITIVE_VIEW.jsp?docID=' + docid, 'report', 'width=660,top=0,height='+(window.screen.availHeight-100)+',resizable=yes,status=no,toolbar=no,menubar=yes,location=no,scrollbars=yes');
   wnd.focus();
}
</SCRIPT>

            <FORM name=docform action="/iBank/ChooseDocumentsServlet" method=post>
            <!--Hidden Variables--> 
            <INPUT TYPE="hidden" NAME="sort" value='<%=sortBy%>'> 
            <INPUT TYPE="hidden" NAME="doc_type" value='<%=doc_type%>'> 
            <INPUT type=hidden name=action>

            <P class=gridtitle>Параметры документов</P>
            <TABLE class=inputbar>
                <TBODY>
                    <TR>
                        <TD class=label>Тип</TD>
                        <TD class=input><SELECT title="Тип документа" name=formid>
                            <OPTION value="1" <%=selected(doc_type, "1")%>>Платежное поручение</OPTION>
                            <OPTION value="7" <%=selected(doc_type, "7")%>>Платежное требование</OPTION>
                            <OPTION value="8" <%=selected(doc_type, "8")%>>Аккредитив</OPTION>
                            <OPTION value="9" <%=selected(doc_type, "9")%>>Инкассовое поручение</OPTION>
                            <OPTION value="10"<%=selected(doc_type,"10")%>>Заявление об отказе от акцепта</OPTION>
                        </SELECT></TD>
                        <TD class=button rowSpan=2><INPUT onclick=Read(this) type=button value=Показать>&nbsp; <INPUT type=reset value=Сбросить name=btnreset></TD>
                    </TR>
                    <TR>
                        <TD class=label>Период</TD>
                        <TD class=input>
                          <INPUT title="Начальная дата" type=hidden value='<%=fromDateStr%>' name=fromdate>
                          <INPUT title="Начальная дата.День"  maxLength=2 onchange=date_onchange(this) size=2 value='<%=fromDateDD%>' name=fromdatedd> 
                          <INPUT title="Начальная дата.Месяц" maxLength=2 onchange=date_onchange(this) size=2 value='<%=fromDateMM%>' name=fromdatemm> 
                          <INPUT title="Начальная дата.Год"   maxLength=4 onchange=date_onchange(this) size=4 value='<%=fromDateYY%>' name=fromdateyy>&nbsp;&nbsp;-
                          <INPUT title="Конечная дата"  type=hidden value='<%=toDateStr%>' name=todate> 
                          <INPUT title="Конечная дата.День"   maxLength=2 onchange=date_onchange(this) size=2 value='<%=toDateDD%>' name=todatedd> 
                          <INPUT title="Конечная дата.Месяц"  maxLength=2 onchange=date_onchange(this) size=2 value='<%=toDateMM%>' name=todatemm> 
                          <INPUT title="Конечная дата.Год"    maxLength=4 onchange=date_onchange(this) size=4 value='<%=toDateYY%>' name=todateyy> &nbsp; 
                          <SELECT onchange="period_onchange(this, 'fromdate', 'todate')" name=period>
                            <OPTION selected>( установить период )</OPTION>
                            <OPTION value=<%=period1%>>за текущий день</OPTION>
                            <OPTION value=<%=period2%>>за текущую неделю</OPTION>
                            <OPTION value=<%=period3%>>за текущий месяц</OPTION>
                            <OPTION value=<%=period4%>>за текущий квартал</OPTION>
                          </SELECT></TD>
                    </TR>
                    <TR>
                        <TD class=label>Статус</TD>
                        <TD class=input colSpan=2>
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(0)"><INPUT type=checkbox <%=checked(statuses,"0")%> value=0 name=status>новый</A>
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(1)"><INPUT type=checkbox <%=checked(statuses,"1")%> value=1 name=status>подписан</A>
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(2)"><INPUT type=checkbox <%=checked(statuses,"2")%> value=2 name=status>доставлен</A> 
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(3)"><INPUT type=checkbox <%=checked(statuses,"3")%> value=3 name=status>на обработке</A> 
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(4)"><INPUT type=checkbox <%=checked(statuses,"4")%> value=4 name=status>на исполнении</A> 
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(5)"><INPUT type=checkbox <%=checked(statuses,"5")%> value=5 name=status>исполнен</A> 
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(6)"><INPUT type=checkbox <%=checked(statuses,"6")%> value=6 name=status>отвергнут</A> 
                         |<A style="COLOR: black; TEXT-DECORATION: none" href="javascript:ToggleStatus(7)"><INPUT type=checkbox <%=checked(statuses,"7")%> value=7 name=status>удален</A>|
                        </TD>
                    </TR>
                </TBODY>
            </TABLE>
            <P class=gridtitle>Список документов</P>
            <TABLE class=grid>
                <TBODY>
                    <TR>
                        <TH noWrap><A title="Сортировать по полю 'Статус'" href="javascript:SortBy('status_doc')">Статус</A>              <%=isUp(sortBy, "status_doc")%> </TH>
                        <TH noWrap><A title="Сортировать по полю 'Тип'" href="javascript:SortBy('type_oper')">Тип</A>                     <%=isUp(sortBy, "type_oper")%>  </TH>
                        <TH noWrap><A title="Сортировать по полю 'Дата'" href="javascript:SortBy('date_doc')">Дата</A>                    <%=isUp(sortBy, "date_doc")%>   </TH>
                        <TH noWrap><A title="Сортировать по полю 'Номер'" href="javascript:SortBy('num_doc')">Номер</A>                   <%=isUp(sortBy, "num_doc")%>    </TH>
                        <TH noWrap><A title="Сортировать по полю 'Корреспондент'" href="javascript:SortBy('rcpt_name')">Корреспондент</A> <%=isUp(sortBy, "rcpt_name")%>  </TH>
                        <TH noWrap><A title="Сортировать по полю 'Сумма'" href="javascript:SortBy('amount')">Сумма</A>                    <%=isUp(sortBy, "amount")%>     </TH>
                    </TR>
                     
                     <%if(documents.size() > 0) {
                        for (int i=0; i  <  documents.size(); i++){ curDocument = (Document)documents.elementAt(i); %>
                        <TR>
                        
                         <TD width=102><INPUT type="radio" name="documentID" value="<%=curDocument.getDoc_id().getIdAsString()%>"><%= curDocument.rtStatus_doc()%></TD>
                         <TD width=32><A title=Изменить href="javascript:EditN('<%=curDocument.getDoc_id().getIdAsString()%>')"><%= curDocument.getType()%></A></TD>
                         <TD width=70><%= curDocument.rtDate_doc() %></TD>
                         <TD align=right width=48><A title="Просмотр документа" href="javascript:ViewDocumN('<%=curDocument.getDoc_id().getIdAsString()%>')"><%= curDocument.rtNum_doc() %></A></TD>
                         <%if(curDocument instanceof Payment) { %>
                           <TD><%= ((Payment)curDocument).rtRecipient().rtName() %></TD>
                           <TD align=right><%= ((Payment)curDocument).rtAmount() %></TD>
                         <%} else if (curDocument instanceof Accreditive){%>
                           <TD><%= ((Accreditive)curDocument).rtRecipient().rtName() %></TD>
                           <TD align=right><%= ((Accreditive)curDocument).rtAmount() %></TD>
                         <%}%>  
                        </TR>
                      <%}
                     } else { %>
                       <TR>
                        <TD align=center colspan="6">Нет данных для показа</TD>
                    </TR>            
                   <%} %>
                  
                </TBODY>
            </TABLE>
            <TABLE class=gridfoot>
                <TBODY>
                    <TR>
                         <TD align=right>Всего <%=documents.size()%> документ(ов).</TD> 
                    </TR>
                </TBODY>
            </TABLE>
            <BR>
              <INPUT onclick=AddNew(this) type=button value=Создать> 
              <INPUT onclick=Edit(this) type=button value=Изменить>  
              <INPUT onclick=Delete(this) type=button value=Удалить>
              <INPUT onclick=SetAction(this) type=button value=Подпись> 
              <INPUT onclick=SetAction(this) type=button value=Отправить> 
              <INPUT onclick=SetAction(this) type=button value=Отозвать> 
              <INPUT onclick=ViewDocum(this) type=button value=Просмотр>
            </FORM>
            <P></P>
            <A href="http://it-ildar/iBank/ibankjsp/DOCEXPORT.jsp?formid=0&amp;fromdate=17/09/2002&amp;todate=18/09/2002&amp;statusmask=2047&amp;sort=DocDate">Экспорт данных</A>
            <P class=tips>В разделе <B>Документы</B> Вам доступны все Ваши документы за всю историю обслуживания в системе. Для просмотра списка документов выберите тип документа, его статус и период дат и нажмите <B>Показать</B>. Для создания нового документа выберите тип документа и нажмите <B>Создать</B>. Вы можете <B>Изменить</B> существующий документ, <B>Удалить</B> документ, сформировать его <B>Подпись</B>, <B>Отправить</B> в банк. Для печати документа (реестра) выберите отчет и нажмите <B>Просмотр</B>.</P>
            <!-- --></DIV>
            </TD>
        </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
