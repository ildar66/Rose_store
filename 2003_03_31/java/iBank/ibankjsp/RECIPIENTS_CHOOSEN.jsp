<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/iBank/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Банк Клиент Онлайн - Справочники.</TITLE>
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
<%
//Execute Bean Methods 
String operation = "Добавление"; 
boolean isNew = true; 
String name = "";
String inn = "";
String bic = "";
String bill = "";
String comments = "";
String bank_name = "";
String bill_corr = "";
Recipient curRecipient = userIBank.getCurrentRecipient();
Bank curBank = null; 
if(curRecipient != null) {
  isNew = false;
  operation = "Редактирование";
  curBank = BankTransactionMgr.findWithBankPK(curRecipient.rtBank_Bic());
  name = curRecipient.rtName();
  inn = curRecipient.rtInn();
  bic = curRecipient.rtBank_Bic();
  bill = curRecipient.rtBill();
  comments = curRecipient.rtComments();
  bank_name = curBank.rtBank_name();
  bill_corr = curBank.rtBill_corr();
}  
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
            <TD class=menu width=110 bgColor=#dcdee0>
            <A href="/iBank/ibankjsp/CLIENT_INFO.jsp">Клиент</A><BR>
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
            <DIV class=title>Клиент</DIV>
            <DIV class=body><!-- -->
            <SCRIPT language=javascript src="/iBank/ibankjsp/common/validate.js" type=text/javascript></SCRIPT> 
            <SCRIPT language=javascript src="/iBank/ibankjsp/common/form.js" type=text/javascript></SCRIPT>
            <SCRIPT language=javascript>
function Check(theForm)
{
	if(theForm.BIC.value.length == 8) theForm.BIC.value = '0' + theForm.BIC.value;
	
	if(!field_check(theForm.Title, null, 8, true)) return false;
	if(!field_check(theForm.INN, null, 8, true)) return false;
	if(!field_check(theForm.Account, null, 8, true)) return false;
	if(!field_check(theForm.BIC, null, 8, true)) return false;

	if(!isINN(theForm.INN.value))
		if(!warn_field(theForm.INN, 'Неверное значение в поле \'%title%\'.\nНеправильный ключ.'))
			return false;

	if(!isAccount(theForm.BIC.value, theForm.Account.value))
		return alert_field(theForm.Account, 'Неверное значение в поле \'%title%\'.\nНеправильный ключ.');

	return true;

}

function Save(e)
{
	if(Check(e.form))
	{
		e.form.btnaction.value = "Save";
		e.form.submit();
	}
}

function Delete(e)
{
	e.form.btnaction.value = "Delete";
	e.form.submit();
}

function Cancel(e)
{
	e.form.btnaction.value = "Cancel";
	e.form.submit();
}

function AddNew(e)
{
	if(Check(e.form))
	{
		e.form.btnaction.value = "AddNew";
		e.form.submit();
	}
}
	
function CallRefBanks(theForm)
{
	var url = '/iBank/ibankjsp/BANKS_RESULTS.jsp?formname=' + theForm.name + '&BIC=' + theForm.BIC.value + '&bankname=' + theForm.bankname.value + '&sort=bik' + '&operation=and' + '&fieldnames=BIC|bankname|bankacc';
	var wnd = window.open(url, 'ref', 'width=630,height=318,resizable=yes,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes');
	wnd.focus();
}

</SCRIPT>

            <FORM name=detailform action="/iBank/ChooseRecipientActionServlet" method=post>
            
            <!--Hidden Variables-->
            <INPUT TYPE="hidden" NAME="sort" value='<%=request.getParameter("sort")%>'>
            <INPUT type=hidden name=btnaction> 
            
            <H5>Справочник Корреспондентов - <%=operation%></H5>
            <TABLE class=inputbar>
                <TBODY>
                    <TR>
                        <TD class=label>Наименование</TD>
                        <TD class=input><TEXTAREA onkeypress="if(this.value.length>160) event.returnValue=false;" title=Наименование name=Title cols=50 onchange=this.value=this.value.substr(0,160);><%=name %></TEXTAREA></TD>
                    </TR>
                    <TR>
                        <TD class=label>ИНН</TD>
                        <TD class=input><INPUT title=ИНН maxLength=10 size=12 value="<%=inn%>" name=INN></TD>
                    </TR>
                    <TR>
                        <TD class=label>Расчетный счет</TD>
                        <TD class=input><INPUT title="Расчетный счет" maxLength=20 size=23 value="<%=bill%>" name=Account></TD>
                    </TR>
                    <TR>
                        <TD class=label>БИК</TD>
                        <TD class=input><INPUT title=БИК maxLength=9 size=10 value="<%=bic%>" name=BIC>&nbsp;<INPUT class=ref id=bicref title="Справочник Банков" onclick="CallRefBanks(this.form)" type=button value=">"></TD>
                    </TR>
                    <TR>
                        <TD class=label>Банк</TD>
                        <TD class=input><TEXTAREA class=disabled title=Банк name=bankname readOnly cols=50><%=bank_name%></TEXTAREA></TD>
                    </TR>
                    <TR>
                        <TD class=label>Кор. счет</TD>
                        <TD class=input><INPUT class=disabled title="Кор. счет" readOnly maxLength=20 size=23 name=bankacc value="<%=bill_corr%>"></TD>
                    </TR>
                    <TR>
                        <TD class=label>Комментарий</TD>
                        <TD class=input><TEXTAREA onkeypress="if(this.value.length>210) event.returnValue=false;" title=Комментарий name=comment cols=50 onchange=this.value=this.value.substr(0,210);><%=comments %></TEXTAREA></TD>
                    </TR>
                    
                </TBODY>
            </TABLE>
            <BR>
            <%if(!isNew) { %>
            <INPUT onclick=Save(this) type=button value="Сохранить" > 
            <INPUT onclick=Delete(this) type=button value="Удалить" > 
            <%} else {%>
            <INPUT onclick=AddNew(this) type=button value="Добавить" >
            <%}%>
            <INPUT onclick=Cancel(this) type=button value="Отменить" >
            
            </FORM>
            <!-- --></DIV>
            </TD>
        </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
