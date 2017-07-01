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
<%@ page import="com.overstar.ildar.ibank.servlets.util.*" %>
<jsp:useBean id="userIBank" scope="session" class="com.overstar.ildar.ibank.model.IBank" type="com.overstar.ildar.ibank.model.IBank"/>

<%
//Execute Bean Methods 
String sort = request.getParameter("sort");
String operation = request.getParameter("operation");
String bic = request.getParameter("BIC");
String bankname = request.getParameter("bankname");
int pagenumber = 1;
String pagenumberStr = request.getParameter("pagenumber");
if(pagenumberStr != null)
  pagenumber = Integer.parseInt(pagenumberStr);
if(bic==null) {
  bic = "";
  bankname = "";
  sort = "bik";
  operation = "and";
}
bankname = ServletUtilities.encode(request, bankname);
java.util.Vector banks = BankTransactionMgr.getBanks(bic, bankname , sort, operation);
int bankssize = banks.size();
int pagesize = 20;
int pagecount = ( (bankssize%pagesize == 0) ? bankssize/pagesize : (bankssize/pagesize + 1) ); 
pagenumber = Math.max(1, Math.min(pagenumber, pagecount));

Bank curBank = null;
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
function MoveTo(n)
{ 
	var theForm = document.refform;
	theForm.pagenumber.value = n;
	theForm.submit();
}

function SortBy(field)
{
	var e = document.refform.sort;
	e.value = (e.value == field)?field + ' desc':field;
	e.form.submit();
}
</SCRIPT>
            <FORM action="/iBank/ibankjsp/BANKS_LISTED.jsp" method=post name=refform>

            <p class="gridtitle">Параметры поиска</p>
            <table class="inputbar">
                <CAPTION><B>Фильтр для Справочника &quot;Российские банки&quot;</B></CAPTION>
                <TBODY>
                <TR>
                    <TD class=label>БИК</TD>
                    <TD class=input><INPUT name=BIC size=10 maxlength=9 value='<%=bic%>' title="БИК"></TD>
                    <TD class=label align="right">и<INPUT type="radio" name="operation" value="and" <%=ServletUtilities.checked(operation,"and")%>></TD>
                    <TD class=button rowspan="2"><INPUT type=submit value="Показать" name=btnfind>&nbsp;<INPUT type=reset value="Сбросить" name=btnreset>&nbsp;</TD>
                </TR>
                <TR>
                    <TD class=label>Наименование</TD>
                    <TD class=input><INPUT name=bankname size=34 maxlength=30 value='<%=bankname%>' title="Наименование"></TD>
                    <TD class=label align="right">или<INPUT type="radio" name="operation" value="or" <%=ServletUtilities.checked(operation,"or")%>></TD>
                </TR>
                </TBODY>
            </TABLE>
            <!--hidden field--> 
            <INPUT TYPE="hidden" NAME="sort" value='<%=sort%>'> 
            <INPUT TYPE="hidden" NAME="operation" value='<%=operation%>'>
            <INPUT TYPE="hidden" NAME="pagenumber" value='<%=pagenumber%>'>
            </FORM>

            <p class="gridtitle">Справочник Банков</p>

            <TABLE class="grid" border="1">
                <CAPTION><B>Результат запроса фильтра</B></CAPTION>
                <TBODY>
                    <TR>
                        <TH nowrap><a href="javascript:SortBy('bik')" title="Сортировать по полю 'БИК'">Бик</a>                         <%=ServletUtilities.isUp(sort, "bik")%>      </TH>
                        <TH nowrap><a href="javascript:SortBy('bill_corr')" title="Сортировать по полю 'Кор. счет'">Кор. счет</a>       <%=ServletUtilities.isUp(sort, "bill_corr")%></TH>
                        <TH nowrap><a href="javascript:SortBy('bank_name')" title="Сортировать по полю 'Наименование'">Наименование</a> <%=ServletUtilities.isUp(sort, "bank_name")%></TH>
                        <TH nowrap><a href="javascript:SortBy('city')" title="Сортировать по полю 'Местонахождение'">Местонахождение</a><%=ServletUtilities.isUp(sort, "city")%>     </TH>
                        <TH nowrap><a href="javascript:SortBy('delivery')" title="Сортировать по полю 'Вид платежа'">Вид платежа</a>    <%=ServletUtilities.isUp(sort, "delivery")%> </TH>
                    </TR>
                    <% if(banks.size() > 0) {
                         int start = (pagenumber-1)*20;
                         int end = Math.min(pagenumber*20, bankssize); 
                         for (int i=start; i  <  end; i++){ curBank = (Bank)banks.elementAt(i); %>
                          <TR>
                             <TD><%= curBank.getBik().getIdAsString() %></TD>
                             <TD><%= curBank.rtBill_corr() %></TD>
                             <TD><%= curBank.rtBank_name() %></TD>
                             <TD><%= curBank.rtCity() %></TD>
                             <TD><%= curBank.rtDelivery() %></TD>
                          </TR>
                      <% }
                       } else { %>
                          <TR> <TD align=center colspan=5>Нет данных для показа</TD>   </TR>
                    <% } %>
                </TBODY>
            </TABLE>
           <% if(pagecount > 0) { %>
            <TABLE class="gridfoot">
             <TBODY>
              <TR>
               <TD>
	             <INPUT type=button value="  &lt;&lt;  " onclick="MoveTo(1)" <%=ServletUtilities.disabled(pagenumber, 1)%>>
	             <INPUT type=button value="  &lt;   "    onclick="MoveTo(<%=(pagenumber-1)%>)" <%=ServletUtilities.disabled(pagenumber, 1)%>>
	             <INPUT type=button value="   &gt;  "    onclick="MoveTo(<%=(pagenumber+1)%>)" <%=ServletUtilities.disabled(pagenumber, pagecount)%>>
	             <INPUT type=button value="  &gt;&gt;  " onclick="MoveTo(<%=pagecount%>)" <%=ServletUtilities.disabled(pagenumber, pagecount)%>>
	           </TD>
               <TD align=right>	Страница <%=pagenumber%> из <%=pagecount%>. </TD>
              </TR>
             </TBODY>
            </TABLE>
          <%}%>
            <P align=right>Всего записей <%=banks.size()%>.</P>
            <!-- --></DIV>
            </TD>
        </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
