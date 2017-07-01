<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/iBank/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>IBANK - Клиент Онлайн - Справочники.</TITLE>
<!--META http-equiv=Content-Type content="text/html; charset=windows-1251"-->
<%@ page contentType="text/html; charset=windows-1251"%>
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
</HEAD>
<BODY> 
<%@ page import="com.overstar.ildar.ibank.model.references.*" %>
<jsp:useBean id="userIBank" scope="session" class="com.overstar.ildar.ibank.model.IBank" type="com.overstar.ildar.ibank.model.IBank"/>
<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name))
  { if(aSort.endsWith("desc")) 
     return (" <IMG width=8 height=7 hspace=3 src='/iBank/ibankjsp/images/down.gif'  alt='по убыванию'> ");
    else
     return (" <IMG width=8 height=7 hspace=3 src='/iBank/ibankjsp/images/up.gif' alt='по возрастанию'> "); 
  }
 else return ("");      
}
%> 
<%
//Execute Bean Methods 
String sort = request.getParameter("sort");
java.util.Vector recipients = userIBank.getCurrentIClient().getRecipientsAll();
Recipient curRecipient = null;
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
            <A href="/iBank/ChooseActionServlet?action=ListDocuments">Документы</A><BR>
            <A href="/iBank/ibankjsp/STATEMENTS.jsp">Выписки</A><BR>
            <A class=current href="/iBank/ibankjsp/REFERENCES.jsp">Справочники</A><BR>
            <A href="/iBank/ibankjsp/MESSAGES.jsp">Сообщения</A><BR>
            <A href="/iBank/ibankjsp/REPORTS.jsp">Отчеты</A><BR>
            <A href="/iBank/ibankjsp/SETUP.jsp">Настройки</A><BR>
            <A href="/iBank/StopServlet">Выход</A><BR>
            </TD>
            <TD>
            <DIV class=title>Справочники</DIV>
            <DIV class=body><!-- --> 
<SCRIPT language=javascript src="/iBank/ibankjsp/common/validate.js" type=text/javascript></SCRIPT> 
<SCRIPT language=javascript>
function SortBy(field)
{
    var theForm = document.navform;
	theForm.sort.value = theForm.sort.value == field ? field + ' desc' : field;
	theForm.btnaction.value = "SortBy";
	theForm.submit();
}

function isChoice()
{
  var e = document.navform.elements;
  for(var i=0; i < e.length; i++)
    if(e[i].name=='recipientID' && e[i].checked == true)
	  return true;
  return false;
}
function AddNew(e)
{
	e.form.btnaction.value = "AddNew";
	e.form.submit();	
}	
function Delete(e)
{
	if(isChoice())
	 {
	   e.form.btnaction.value = "Delete";
	   e.form.submit();	
	 }
	else
		alert('Выберите строку для удаления.');
}
function Edit(e)
{
	if(isChoice())
	 {
	   e.form.btnaction.value = "Edit"; 
	   e.form.submit();	
	 }
	else
		alert('Выберите строку для изменения.');
}
function EditN(id)
{
  var theForm = document.navform;
  var e = theForm.elements;
  for(var i=0; i < e.length; i++)
    if(e[i].name=='recipientID' && e[i].value==id)
	  e[i].checked = true;
  theForm.btnaction.value = "Edit";	  
  theForm.submit();
}
function Refresh(e)
{
	e.form.btnaction.value = "Refresh";
	e.form.submit();	
}

</SCRIPT>
            <FORM name=navform action="/iBank/ChooseRecipientServlet" method=post>
 
            <!--Hidden Variables-->
            <INPUT TYPE="hidden" NAME="sort" value='<%=sort%>'>
            <INPUT type=hidden name=btnaction> 
            
            <P class=gridtitle>Справочник Корреспондентов</P>
            <TABLE class=grid>
                <TBODY>
                    <TR>
                        <TH noWrap><A title="Сортировать по полю 'Наименование'" href="javascript:SortBy('NAME')">Наименование</A>     <%=isUp(sort, "NAME")%> </TH>
                        <TH noWrap><A title="Сортировать по полю 'ИНН'" href="javascript:SortBy('INN')">ИНН</A>                        <%=isUp(sort, "INN")%>  </TH>
                        <TH noWrap><A title="Сортировать по полю 'Расчетный счет'" href="javascript:SortBy('BILL')">Расчетный счет</A> <%=isUp(sort, "BILL")%> </TH>
                        <TH noWrap><A title="Сортировать по полю 'БИК'" href="javascript:SortBy('BIC')">БИК</A>                        <%=isUp(sort, "BIC")%>  </TH>
                    </TR>
                    <% for (int i=0; i  <  recipients.size(); i++){ curRecipient = (Recipient)recipients.elementAt(i); %>
                    <TR>
                        <TD><INPUT type="radio" name="recipientID" value="<%=curRecipient.getId().getIdAsString()%>"><A title=Изменить href="javascript:EditN('<%=curRecipient.getId().getIdAsString()%>')"><%= curRecipient.rtName() %></A></TD>
                        <TD><%= curRecipient.rtInn() %></TD>
                        <TD><%= curRecipient.rtBill() %></TD>
                        <TD><%= curRecipient.rtBank_Bic() %></TD>
                    </TR>
                    <% } %>

                </TBODY>
            </TABLE>
            <BR>
            <TABLE class=gridfoot>
                <TBODY>
                    <TR>
                        <TD>
                        <INPUT onclick=AddNew(this) type=button value=Добавить> 
                        <INPUT onclick=Edit(this) type=button value=Изменить> 
                        <INPUT onclick=Delete(this) type=button value=Удалить>
                        <INPUT onclick=Refresh(this) type=button value=Обновить>
                        </TD>
                        
                        <TD align=right>Всего записей: <%=recipients.size()%>.</TD>
                    </TR>
                </TBODY>
            </TABLE>
            </FORM>
            <P></P>
            <!-- --></DIV>
            </TD>
        </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
