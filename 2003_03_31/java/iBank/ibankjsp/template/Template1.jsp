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
<jsp:useBean id="userIBank" scope="session" class="com.overstar.ildar.ibank.model.IBank" type="com.overstar.ildar.ibank.model.IBank"/>

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
            <TD class=menu width=110 bgColor=#dcdee0><A class=current href="/iBank/ibankjsp/CLIENT_INFO.jsp">Клиент</A><BR>
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
            <DIV class=title>Клиент</DIV>
            <DIV class=body><!-- -->
            
            
            
            
            
            
            
            
            
            
            
            
            
            <!-- --></DIV>
            </TD>
        </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
