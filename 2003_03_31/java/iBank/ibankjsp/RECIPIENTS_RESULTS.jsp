<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<!--META HTTP-EQUIV="Content-Type" content="text/html; charset=windows-1251"-->
<%@ page contentType="text/html; charset=WINDOWS-1251"%>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/iBank/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Справочник Корреспондентов</TITLE>
<SCRIPT language=javascript src="/iBank/ibankjsp/common/common.js" type=text/javascript></SCRIPT>
<script language="javascript" type="text/javascript">
function Go(strval) {
	var thisform = document.refform;
	var outform = window.opener.document.forms[thisform.formname.value];
	
	if(outform != null)
	{
		var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
		for(var i in names)
			if(names[i].length > 0)
				outform[names[i]].value = unescape(values[i]);
	}
	Close();
}

function Close()
{
	if(window.opener)
		window.opener.focus();
	window.close();
}

function SortBy(field)
{
	var e = document.refform.sort;
	e.value = (e.value == field)?field + ' desc':field;
	e.form.submit();
}
</script>

</HEAD>
<BODY>
<%@ page import="com.overstar.ildar.ibank.model.references.*" %>
<%@ page import="com.overstar.ildar.ibank.servlets.util.*" %> 
<jsp:useBean id="BankBean" scope="session" class="com.overstar.ildar.ibank.model.references.Bank" type="com.overstar.ildar.ibank.model.references.Bank"/>
<%!
private String encode(HttpServletRequest request , String name) throws Exception {
  String clientEnc = request.getCharacterEncoding();
  if (clientEnc == null) {
    String requestEnc = "ISO-8859-5";
    clientEnc = "Cp1251";
    name = new String(name.getBytes(requestEnc), clientEnc); 
  }
  return name;
}

private String checked(String name1, String name2) { 
if(name1.equals(name2))
  return (" CHECKED ");
else
  return ("");  
}

private String isUp(String aSort, String name) {
 if(aSort.startsWith(name))
  { if(aSort.endsWith("desc")) 
     return (" <IMG width=8 height=7 hspace=3 src='/iBank/ibankjsp/images/down.gif' alt='по убыванию'> ");
    else
     return (" <IMG width=8 height=7 hspace=3 src='/iBank/ibankjsp/images/up.gif' alt='по возрастанию'> "); 
  }
 else return ("");      
}
%>
<%
//Execute Bean Methods 
String sort = request.getParameter("sort");
String operation = request.getParameter("operation");
String fieldnames = request.getParameter("fieldnames"); //"receiver|receiverinn|receiveracc|receiverbic|receiverbank|receivercoracc"
String formname = request.getParameter("formname"); 
    
String currentIClientID = request.getParameter("currentIClientID");

String name = request.getParameter("NAME");
name = encode(request, name);
String inn = request.getParameter("INN");
String bill = request.getParameter("BILL");
String bic = request.getParameter("BIC"); 
java.util.Vector recipients = RecipientTransactionMgr.getRecipientsForIClient(currentIClientID, name, inn, bill, bic, operation, sort);
Recipient curRecipient = null;
%>

<FORM action="/iBank/ibankjsp/RECIPIENTS_RESULTS.jsp" method=post name=refform>

<p class="gridtitle">Параметры поиска</p>
<table class="inputbar">
    <CAPTION><B>Фильтр для &quot;Справочника Корреспондентов&quot;</B></CAPTION>
    <TR>
        <TD class=label>Наименование</TD>
        <TD class=input><INPUT name="NAME" size=53 maxlength=80 title="Наименование" type="text" value="<%=name%>"></TD>
            <TD rowspan="2" align="right">И<INPUT type="radio" name="operation" value="and" <%=checked(operation,"and")%>></TD>
            <TD class=button rowspan="4"><INPUT type=submit value="Показать" name=btnfind>&nbsp;<INPUT type=reset value="Сбросить" name=btnreset>&nbsp;<INPUT type=button value="Закрыть" onclick="Close();"></TD>
    </TR>
    <TR>
        <TD class=label>ИНН</TD>
        <TD class=input><INPUT name=INN size=14 maxlength=12 title="ИНН" type="text" value="<%=inn%>"></TD>
        </TR>
    <TR>
        <TD class=label>Расчетный счет</TD>
        <TD class=input><INPUT name="BILL" size=23 maxlength=20 title="Расчетный счет" type="text" value="<%=bill%>"></TD>
            <TD rowspan="2" align="right">ИЛИ<INPUT type="radio" name="operation" value="or" <%=checked(operation, "or")%>></TD>
        </TR>
    <TR>
        <TD class=label>БИК</TD>
        <TD class=input><INPUT name=BIC size=10 maxlength=9 title="БИК" type="text" value="<%=bic%>"></TD>
        </TR>
</TBODY>
</TABLE>
<!--hidden field-->
<INPUT type="hidden" name="fieldnames" value="<%=fieldnames%>"> 
<INPUT type="hidden" name="formname" value="<%=formname%>"> 
<INPUT type="hidden" name="sort" value="<%=sort%>">
<INPUT TYPE="hidden" NAME="operation" value='<%=operation%>'>
<INPUT type="hidden" name="currentIClientID" value="<%=currentIClientID%>">
</FORM>

<p class="gridtitle">Справочник Корреспондентов</p>
<table class="grid">
    <TR>
        <th nowrap><a href="javascript:SortBy('NAME')" title="Сортировать по полю 'Наименование'">Наименование</a>     <%=isUp(sort, "NAME")%> </th>
        <th nowrap><a href="javascript:SortBy('INN')" title="Сортировать по полю 'ИНН'">ИНН</a>                        <%=isUp(sort, "INN")%>  </th>
        <th nowrap><a href="javascript:SortBy('BILL')" title="Сортировать по полю 'Расчетный счет'">Расчетный счет</a> <%=isUp(sort, "BILL")%> </th>
        <th nowrap><a href="javascript:SortBy('BIC')" title="Сортировать по полю 'БИК'">БИК</a>                        <%=isUp(sort, "BIC")%>  </th>
    </TR>
    <%if(recipients.size() > 0) {
       for (int i=0; i  <  recipients.size(); i++){ curRecipient = (Recipient)recipients.elementAt(i); BankBean = BankTransactionMgr.findWithBankPK(curRecipient.rtBank_Bic());%>
    <TR>
        <TD><A href="javascript:Go('<%=curRecipient.rtName()%>|<%=curRecipient.rtInn()%>|<%=curRecipient.rtBill()%>|<%=curRecipient.rtBank_Bic()%>|<%=ServletUtilities.filter(BankBean.rtBank_name())%>|<%=BankBean.rtBill_corr()%>')" title="Выберите запись"><%= curRecipient.rtName() %></A></TD>
        <TD><%= curRecipient.rtInn() %></TD>
        <TD><%= curRecipient.rtBill() %></TD>
        <TD><%= curRecipient.rtBank_Bic() %></TD>
    </TR>
    <% }
    } else { %>
    <TR><TD align=center colspan=5>Нет данных для показа</TD></TR>
    <% } %>
</TABLE>

<P align=right>Всего записей <%=recipients.size()%>.</P>

</BODY>
</HTML>
