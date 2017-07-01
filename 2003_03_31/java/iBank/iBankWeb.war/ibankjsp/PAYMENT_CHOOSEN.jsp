<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Банк Клиент Онлайн - Платежное поручение</TITLE>
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
<%@ page import="com.overstar.ildar.ibank.model.accounts.*" %> 
<%@ page import="java.util.*" %>
<jsp:useBean id="userIBank" scope="session" class="com.overstar.ildar.ibank.model.IBank" type="com.overstar.ildar.ibank.model.IBank"/>
<%!
private String selected(String name1, String name2) {
if(name1.equals(name2))
  return (" SELECTED ");
else
  return ("");  
}
%>
<%
//Execute Bean Methods 
String operation = "Добавление"; 
boolean isNew = true;
String num_docStr = "";
GregorianCalendar calendar = new GregorianCalendar();
String date_docDD = String.valueOf(calendar.get(java.util.Calendar.DATE));
String date_docMM = String.valueOf(calendar.get(java.util.Calendar.MONTH)+1);
String date_docYY = String.valueOf(calendar.get(java.util.Calendar.YEAR));
String date_docStr = date_docYY +"-"+ date_docMM +"-"+ date_docDD ;
String payment_type = " ";
String payer_inn = userIBank.getCurrentIClient().rtInn_cln();
String payer_name = userIBank.getCurrentIClient().rtName_cln();
String payer_account = "Тут должен быть счет";
Money amount = new Money("0.00");
String payer_bank_name = "ООО КБ \"АЛЬЯНСИНВЕСТ\", Г. МОСКВА";
String payer_bank_bic = "044585409";
String payer_bank_acc = "30101810000000000409";
String rcpt_bank_name = "";
String rcpt_bank_bic = "";
String rcpt_bank_acc = "";
String rcpt_inn = "";
String rcpt_name = ""; 
String rcpt_account = "";
String queue = "06";
String termDD = date_docDD;//TEMP
String termMM = date_docMM;//TEMP
String termYY = date_docYY;//TEMP
String termStr = termYY +"-"+ termMM +"-"+ termDD ;
String payment_details = "";
String status_doc = "новый";

Vector bankAccounts = userIBank.getCurrentIClient().getBankAccountsAll();
BankAccount curBankAccount = null;

Payment curDocument = (Payment)userIBank.getCurrentDocument();
if(curDocument != null) {
  isNew = false;
  operation = "Редактирование";
  //BankBean = Bank.findWithBankPK(curRecipient.rtBic());
  num_docStr = curDocument.rtNum_doc();
  java.sql.Date date_doc = curDocument.rtDate_doc();
  calendar.setTime(date_doc);
  date_docDD = String.valueOf(calendar.get(java.util.Calendar.DATE));
  date_docMM = String.valueOf(calendar.get(java.util.Calendar.MONTH)+1);
  date_docYY = String.valueOf(calendar.get(java.util.Calendar.YEAR));
  date_docStr = date_docYY +"-"+ date_docMM +"-"+ date_docDD ;
  payment_type = curDocument.rtPayment_type();
  payer_inn = curDocument.rtPayer().rtInn();
  payer_name = curDocument.rtPayer().rtName();
  payer_account = curDocument.rtPayer().rtBill();
  amount = curDocument.rtAmount();
  payer_bank_name = curDocument.rtPayer().rtBank_name();
  payer_bank_bic = curDocument.rtPayer().rtBank_Bic();
  payer_bank_acc = curDocument.rtPayer().rtBank_acc();
  rcpt_bank_name = curDocument.rtRecipient().rtBank_name();
  rcpt_bank_bic = curDocument.rtRecipient().rtBank_Bic();
  rcpt_bank_acc = curDocument.rtRecipient().rtBank_acc();
  rcpt_inn = curDocument.rtRecipient().rtInn();
  rcpt_name = curDocument.rtRecipient().rtName();
  rcpt_account = curDocument.rtRecipient().rtBill();
  queue = curDocument.rtQueue();
  java.sql.Date term = curDocument.rtTerm();
  calendar.setTime(term);
  termDD = String.valueOf(calendar.get(java.util.Calendar.DATE));
  termMM = String.valueOf(calendar.get(java.util.Calendar.MONTH)+1);
  termYY = String.valueOf(calendar.get(java.util.Calendar.YEAR));
  termStr = termYY +"-"+ termMM +"-"+ termDD ;
  payment_details = curDocument.rtPayment_details();
  status_doc = curDocument.rtStatus_doc().toString();
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
            <A class=current href="/iBank/ChooseActionServlet?action=ListDocuments">Документы</A><BR>
            <A href="/iBank/ibankjsp/STATEMENTS.jsp">Выписки</A><BR>
            <A href="/iBank/ibankjsp/REFERENCES.jsp">Справочники</A><BR>
            <A href="/iBank/ibankjsp/MESSAGES.jsp">Сообщения</A><BR>
            <A href="/iBank/ibankjsp/REPORTS.jsp">Отчеты</A><BR>
            <A href="/iBank/ibankjsp/SETUP.jsp">Настройки</A><BR>
            <A href="/iBank/StopServlet">Выход</A><BR>
            </TD>
            <TD>
            <DIV class=title>Платежное поручение - <%=operation%></DIV>
            <DIV class=body><!-- -->
            <SCRIPT language=javascript src="/iBank/ibankjsp/common/validate.js" type=text/javascript></SCRIPT> 
            <SCRIPT language=javascript src="/iBank/ibankjsp/common/form.js" type=text/javascript></SCRIPT>

            <FORM name=docform action="/iBank/ChoosePaymentsActionServlet" method=post ><!-- BEGIN BACKGROUND TABLE -->
            
            <!--Hidden Variables-->
            <INPUT type=hidden value=1 name=formid> 
            <INPUT type=hidden value="<%=userIBank.getCurrentIClient().getClient_id().getIdAsString()%>" name=currentIClientID> 
            <INPUT type=hidden name=btnsubmit>
            <INPUT type=hidden value=<%=payment_type%> name="payment_type"> 
                       
            <TABLE cellSpacing=0 cellPadding=0 border=0>
                <TBODY>
                    <TR>
                        <TD class=docbg><!-- BEGIN LAYOUT TABLE -->
                        <TABLE class=doclayout cellSpacing=1 cellPadding=2 border=0>
                            <TBODY>
                                <TR>
                                    <TD colSpan=5>
                                    <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                        <TBODY>
                                            <TR>
                                                <TD noWrap rowSpan=2>ПЛАТЕЖНОЕ ПОРУЧЕНИЕ №&nbsp;<INPUT title=Номер maxLength=10 size=10 value="<%=num_docStr%>" name=docnum type="text"></TD>
                                                <TD align="center"><INPUT title=Дата type=hidden value=<%=date_docStr%> name=docdate><INPUT title=Дата.День maxLength=2 onchange=date_onchange(this) size=2 value="<%=date_docDD%>" name=docdatedd type="text"><INPUT title=Дата.Месяц maxLength=2 onchange=date_onchange(this) size=2 value="<%=date_docMM%>" name=docdatemm><INPUT title=Дата.Год maxLength=4 onchange=date_onchange(this) size=4 value="<%=date_docYY%>" name=docdateyy></TD>
                                                <TD align="center"><SELECT title="Вид платежа" size=1 name=paykind>
                                                    <OPTION <%=selected(payment_type," ")%> value=" "> </OPTION>
                                                    <OPTION <%=selected(payment_type,"электронно")%> value="электронно">электронно</OPTION>
                                                    <OPTION <%=selected(payment_type,"телеграфом")%> value="телеграфом">телеграфом</OPTION>
                                                    <OPTION <%=selected(payment_type,"почтой")%> value="почтой">почтой</OPTION>
                                                </SELECT></TD>
                                            </TR>
                                            <TR>
                                                <TD align="center">Дата</TD>
                                                <TD align="center">Вид платежа</TD>
                                            </TR>
                                        </TBODY>
                                    </TABLE>
                                    </TD>
                                </TR>
                                <TR>
                                    <TD rowSpan=2>ИНН&nbsp;<INPUT class=disabled title="ИНН Плательщика" maxLength=12 size=14 value="<%=payer_inn%>" name=payerinn type="text"><BR>
                                    <TEXTAREA onkeypress="if(this.value.length>=160) event.returnValue=false;" onpaste="this.value=(this.value+window.clipboardData.getData('Text')).substr(0,160);;event.returnValue=false;" title="Наименование Плательщика" name=payer rows=3 cols=30 onchange="this.value=this.value.substr(0,160);"><%=payer_name%></TEXTAREA><BR>
                                    Плательщик</TD>
                                    <TD>Сумма</TD>
                                    <TD colSpan=3><INPUT title=Сумма maxLength=18 size=18 value="<%=amount%>" name=docsum type="text"></TD>
                                </TR>
                                <TR>
                                    <TD>Сч. №</TD>
                                    <TD colSpan=3><SELECT title="Счет Плательщика" size=1 name=payeracc>
                                      <% for (int i=0; i  <  bankAccounts.size(); i++){ curBankAccount = (BankAccount)bankAccounts.elementAt(i); %>
                                        <OPTION <%if(payer_account.equals(curBankAccount.getId().getId2AsString())) {%>selected<%}%>><%=curBankAccount.getId().getId2AsString()%></OPTION>
                                      <% } %>  
                                    </SELECT><INPUT id=knfout style="BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BACKGROUND-COLOR: transparent; BORDER-BOTTOM-STYLE: none" disabled size=1></TD>
                                </TR>
                                <TR>
                                    <TD rowSpan=2><TEXTAREA class=disabled title="Наименование Банка плательщика" name=payerbank rows=3 readOnly cols=30><%=payer_bank_name%></TEXTAREA><BR>
                                    Банк плательщика</TD>
                                    <TD>БИК</TD>
                                    <TD colSpan=3><INPUT class=disabled title="БИК Банка плательщика" readOnly maxLength=9 size=10 value="<%=payer_bank_bic%>" name=payerbic type="text"></TD>
                                </TR>
                                <TR>
                                    <TD>Сч. №</TD>
                                    <TD colSpan=3><INPUT class=disabled title="Корсчет Банка плательщика" readOnly maxLength=20 size=23 value="<%=payer_bank_acc%>" name=payercoracc type="text"></TD>
                                </TR>
                                <TR>
                                    <TD rowSpan=2><TEXTAREA class=disabled title="Наименование Банка получателя" name=receiverbank rows=3 readOnly cols=30><%=rcpt_bank_name%></TEXTAREA><BR>
                                    Банк получателя</TD>
                                    <TD>БИК</TD>
                                    <TD colSpan=3><INPUT title="БИК Банка получателя" maxLength=9 size=10 value="<%=rcpt_bank_bic%>" name=receiverbic type="text">&nbsp;<INPUT class=ref id=receiverbicref title="Справочник Банков" onclick="CallRefBanks(this.form)" type=button value=">"></TD>
                                </TR>
                                <TR>
                                    <TD>Сч. №</TD>
                                    <TD colSpan=3><INPUT class=disabled title="Корсчет Банка получателя" readOnly maxLength=20 size=23 value="<%=rcpt_bank_acc%>" name=receivercoracc type="text"></TD>
                                </TR>
                                <TR>
                                    <TD vAlign=bottom rowSpan=4>ИНН&nbsp;<INPUT title="ИНН Получателя" maxLength=12 size=14 value="<%=rcpt_inn%>" name=receiverinn type="text">&nbsp;<INPUT class=ref id=receiverref title="Справочник Корреспондентов" onclick="CallRefRecipients(this.form)" type=button value=">"><BR>
                                    <TEXTAREA onkeypress="if(this.value.length>=160) event.returnValue=false;" onpaste="this.value=(this.value+window.clipboardData.getData('Text')).substr(0,160);;event.returnValue=false;" title="Наименование Получателя" name=receiver rows=3 cols=30 onchange=this.value=this.value.substr(0,160);><%=rcpt_name%></TEXTAREA><BR>
                                    Получатель</TD>
                                    <TD>Сч. №</TD>
                                    <TD colSpan=3><INPUT title="Счет получателя" maxLength=20 size=23 value="<%=rcpt_account%>" name=receiveracc type="text"><INPUT id=knfin style="BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BACKGROUND-COLOR: transparent; BORDER-BOTTOM-STYLE: none" disabled size=1></TD>
                                </TR>
                                <TR>
                                    <TD>Вид. оп.&nbsp;</TD>
                                    <TD><INPUT class=disabled readOnly size=2 value=01 name=opkind type="text"></TD>
                                    <TD>Срок плат.</TD>
                                    <TD><INPUT title="Срок платежа" type=hidden name="term" value="<%=termStr%>"><INPUT class=disabled title="Срок платежа.День" readOnly maxLength=2 onchange=date_onchange(this) size=2 type="text" name="termdd" value="<%=termDD%>"><INPUT class=disabled title="Срок платежа.Месяц" readOnly maxLength=2 onchange=date_onchange(this) size=2 type="text" name="termmm" value="<%=termMM%>"><INPUT class=disabled title="Срок платежа.Год" readOnly maxLength=4 onchange=date_onchange(this) size=4 type="text" name="termyy" value="<%=termYY%>"></TD>
                                </TR>
                                <TR>
                                    <TD>Наз. пл.</TD>
                                    <TD>&nbsp;</TD>
                                    <TD>Очер. плат.</TD>
                                    <TD><SELECT size=1 name=paypriority>
                                        <OPTION <%=selected(queue,"01")%>>01</OPTION>
                                        <OPTION <%=selected(queue,"02")%>>02</OPTION>
                                        <OPTION <%=selected(queue,"03")%>>03</OPTION>
                                        <OPTION <%=selected(queue,"04")%>>04</OPTION>
                                        <OPTION <%=selected(queue,"05")%>>05</OPTION>
                                        <OPTION <%=selected(queue,"06")%>>06</OPTION>
                                    </SELECT></TD>
                                </TR>
                                <TR>
                                    <TD>Код</TD>
                                    <TD>&nbsp;</TD>
                                    <TD>Рез. поле</TD>
                                    <TD>&nbsp;</TD>
                                </TR>
                                <TR>
                                    <TD colSpan=5>
                                    <TABLE cellSpacing=0 cellPadding=0 border=0>
                                        <TBODY>
                                            <TR>
                                                <TD>Ставка НДС&nbsp;</TD>
                                                <TD><INPUT maxLength=6 onchange=tax_calc() size=6 value=20.00 name=taxrate></TD>
                                                <TD>&nbsp;Сумма НДС&nbsp;</TD>
                                                <TD><INPUT maxLength=18 size=18 value=0.00 name=taxsum></TD>
                                                <TD>&nbsp;<INPUT class=btn onclick=addtax_onclick() type=button value=Вставить name=addtax></TD>
                                            </TR>
                                        </TBODY>
                                    </TABLE>
                                    </TD>
                                </TR>
                                <TR>
                                    <TD colSpan=5>Назначение платежа<BR>
                                    <TABLE id=knfdiv style="DISPLAY: none" cellSpacing=0 cellPadding=0 border=0>
                                        <TBODY>
                                            <TR>
                                                <TD>Цифровое обозначение операции&nbsp;(KNF)&nbsp;</TD>
                                                <TD><INPUT class=disabled title="Цифровое обозначение операции согласно инструкции ЦБР № 93-И" readOnly maxLength=3 size=3 name=knf>&nbsp;<INPUT class=ref id=knfref title="Справочник операций по счетам типа К, Н, Ф" onclick="CallRef(document.docform,15,'knf,,*knfin,*knfout')" type=button value=">"></TD>
                                            </TR>
                                        </TBODY>
                                    </TABLE>
                                    <TEXTAREA onkeypress="if(this.value.length>=210) event.returnValue=false;" onpaste="this.value=(this.value+window.clipboardData.getData('Text')).substr(0,210);;event.returnValue=false;" title="Назначение платежа" name=paypurpose rows=3 cols=63 onchange="this.value=this.value.substr(0,210);"><%=payment_details%></TEXTAREA></TD>
                                </TR>
                                <TR>
                                    <TD colSpan=5>Комментарий к документу<BR>
                                    <TEXTAREA onkeypress="if(this.value.length>=200) event.returnValue=false;" onpaste="this.value=(this.value+window.clipboardData.getData('Text')).substr(0,200);;event.returnValue=false;" title=Комментарий name=attention rows=1 cols=63"></TEXTAREA></TD>
                                </TR>
                            </TBODY>
                        </TABLE>
                        <!-- END LAYOUT TABLE --><INPUT type=hidden value=RUR name=curcode></TD>
                    </TR>
                    <TR>
                        <TD align="center">статус документа: <%=status_doc%></TD>
                    </TR>
                </TBODY>
            </TABLE>
            <!-- END BACKGROUND TABLE -->
            <%if(!isNew) { %>
            <INPUT onclick=Save(this) type=button value="Сохранить" > 
            <INPUT onclick=Delete(this) type=button value="Удалить" > 
            <%} else {%>
            <INPUT onclick=AddNew(this) type=button value="Добавить" >
            <%}%>
            <INPUT onclick=Cancel(this) type=button value="Отменить" >

<!-- <INPUT class=btn type=button value="Копировать" onclick="document_copy(this);">   -->
<INPUT class=btn style="WIDTH: 180px" onclick=pattern_save(this); type=button value="Сохранить как шаблон"> <INPUT maxLength=255 name=patterntitle> 
</FORM>

<SCRIPT language=javascript>
var theForm = document.docform;

var knfacc = new Array();knfacc[30122] = 'К';knfacc[30123] = 'Н';knfacc[40813] = 'Ф';knfacc[40814] = 'К';knfacc[40815] = 'Н';

function getknfacc(acc, knf)
{
	var s = knfacc[field_get(acc).substr(0, 5)];
	var tmpknf = knf.value;
	knf.value = s?s:'';
	return (tmpknf != knf.value);
}

// payeracc
theForm.payeracc.onchange = payeracc_onchange;
getknfacc(theForm.payeracc, theForm.knfout);
function payeracc_onchange()
{
	if(getknfacc(theForm.payeracc, theForm.knfout))
		knfacc_change();
}

// receiveracc
theForm.receiveracc.onchange = receiveracc_onchange;
getknfacc(theForm.receiveracc, theForm.knfin);
function receiveracc_onchange()
{
	if(getknfacc(theForm.receiveracc, theForm.knfin))
		knfacc_change();
}

// knfacc_change
function knfacc_change()
{
	with(theForm)
	{
	var b = knfin.value == '' && knfout.value == '';
	knfdiv.style.display = b?'none':'block';
	knf.value = '';
	}
}

// refselect
theForm.onrefselect = refselect;
function refselect(id)
{
	if(id == 2) receiveracc_onchange();
}

// tax +Вычисление процентов:
theForm.docsum.onchange = tax_calc;
tax_calc();
function tax_calc()
{
	with(theForm)
	{
	var sum = parseFloat(docsum.value) * parseFloat(taxrate.value) / (100 + parseFloat(taxrate.value));
	if(!isNaN(sum))
		taxsum.value = money_format(sum, '.');
	}
}

// addtax +Добавление прим.(payment_details).
function addtax_onclick()
{
	with(theForm)
	{
	var sum = parseFloat(docsum.value);
	var tax = parseFloat(taxsum.value);
	var rate = parseFloat(taxrate.value);
	var text = 'Сумма: ' + money_format(sum, '-') +  ', ';
	if(tax > 0)
		text += 'в т.ч. НДС(' + money_format(rate, '.') + '%): ' + money_format(tax, '-');
	else
		text += 'НДС не облагается';
	if(!isNaN(sum) && !isNaN(tax) && !isNaN(rate))
		paypurpose.value += ' ' + text + '.';
	}
}

function docform_onsubmit()
{
	with(theForm)
	{
	with(payerbic) if(value.length == 8) value = '0' + value;
	with(receiverbic) if(value.length == 8) value = '0' + value;
	if(!field_check(theForm.docnum,null,3,true)) return false;
	if(!field_check(theForm.docdate,null,7,true)) return false;
	if(!field_check(theForm.paykind,null,8,false)) return false;
	if(!field_check(theForm.docsum,null,6,true)) return false;
	if(!field_check(theForm.payerinn,null,8,false)) return false;
	if(!field_check(theForm.payeracc,null,8,true)) return false;
	if(!field_check(theForm.payer,null,8,true)) return false;
	if(!field_check(theForm.payerbic,null,8,true)) return false;
	if(!field_check(theForm.payercoracc,null,8,true)) return false;
	if(!field_check(theForm.payerbank,null,8,true)) return false;
	if(!field_check(theForm.receiverbic,null,8,true)) return false;
	if(!field_check(theForm.receivercoracc,null,8,false)) return false;
	if(!field_check(theForm.receiverbank,null,8,true)) return false;
	if(!field_check(theForm.receiverinn,null,8,false)) return false;
	if(!field_check(theForm.receiveracc,null,8,true)) return false;
	if(!field_check(theForm.receiver,null,8,true)) return false;
	if(!field_check(theForm.opkind,null,3,true)) return false;
	if(!field_check(theForm.paydate,null,7,false)) return false;
	if(!field_check(theForm.paypriority,null,3,true)) return false;
	if(!field_check(theForm.paypurpose,null,8,true)) return false;
	if(!field_check(theForm.curcode,null,8,false)) return false;
	if(!field_check(theForm.attention,null,8,false)) return false;

	if(parseInt(docnum.value) == 0)
		return field_alert(docnum, 'Поле должно быть больше нуля.');

	if(field_get(payerbic).substr(0,4) == field_get(receiverbic).substr(0,4) && paykind.selectedIndex != 0)
		return field_alert(paykind);

	if(!docdate_check(docdate))
		return false;
	
	if(parseFloat(docsum.value) == 0)
		return field_alert(docsum, 'Поле должно быть больше нуля.');
	
	var errkey = 'Неправильный ключ.';
	
	if(!isINN(payerinn.value))
		if(!field_warn(payerinn, errkey)) return false;

	if(!isAccount(payerbic.value, field_get(payeracc)))
		return field_alert(payeracc, errkey);
	
	if(!isINN(receiverinn.value))
		if(!field_warn(receiverinn, errkey)) return false;

	var re = /[^ -~А-я\n\r]+/;

	if(receiver.value.length < 2)
			return field_alert(receiver);
	if(re.exec(receiver.value) != null)
			return field_alert(receiver, 'Недопустимый символ \'' + RegExp.input.charAt(RegExp.index) + '\'.');
	
	if(receiveracc.value.length > 0)
	{
		if(!isAccount(receiverbic.value, field_get(receiveracc)))
			return field_alert(receiveracc, errkey);
		if(field_get(receiveracc).substring(5, 8) != '810')
			return field_alert(receiveracc, 'Укажите рублевый счет.');
		if(field_get(receiveracc) == field_get(payeracc))
			return field_alert(receiveracc, 'Счет получателя должен отличатся от счета плательщика.');
	}

	if(paypurpose.value.length < 2)
		return field_alert(paypurpose);
	if(re.exec(paypurpose.value) != null)
		return field_alert(paypurpose, 'Недопустимый символ \'' + RegExp.input.charAt(RegExp.index) + '\'.');

	var knfflag = knfin.value != '' || knfout.value != '';
	if(knfflag)
		if(!field_check(knf,null,3,true))
			return false;
	if(knfflag && paypurpose.value.search(/knf/i) >= 0)
		return field_alert(paypurpose, '\'' + knf.title + '\' необходимо указывать в соответсвующем поле.');
	if(knf.value != '')
		paypurpose.value = knf.value + 'KNF ' + paypurpose.value.replace(/^ +/, '');

	}
	return true;
}

function Check(theForm)
{
	return docform_onsubmit();
}

function Save(e)
{
	if(Check(e.form))
	{
		e.form.btnsubmit.value = "Save";
		e.form.submit();
	}
}

function Delete(e)
{
	e.form.btnsubmit.value = "Delete";
	e.form.submit();
}

function Cancel(e)
{
	e.form.btnsubmit.value = "Cancel";
	e.form.submit();
}

function AddNew(e)
{
	if(Check(e.form))
	{
		e.form.btnsubmit.value = "AddNew";
		e.form.submit();
	}
}
	
function CallRefBanks(theForm)
{
	var url = '/iBank/ibankjsp/BANKS_RESULTS.jsp?formname=' + theForm.name + '&BIC=' + theForm.receiverbic.value + '&bankname=' + theForm.receiverbank.value + '&sort=bik' + '&operation=and' + '&fieldnames=receiverbic|receiverbank|receivercoracc|paykind';
	var wnd = window.open(url, 'ref', 'width=630,height=318,resizable=yes,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes');
	wnd.focus();
}
function CallRefRecipients(theForm)
{
	var url = '/iBank/ibankjsp/RECIPIENTS_RESULTS.jsp?formname=' + theForm.name + '&currentIClientID=' + theForm.currentIClientID.value + '&NAME=' + theForm.receiver.value+ '&INN=' + theForm.receiverinn.value+ '&BILL=' + theForm.receiveracc.value + '&BIC=' + theForm.receiverbic.value  + '&sort=NAME' + '&operation=and' + '&fieldnames=receiver|receiverinn|receiveracc|receiverbic|receiverbank|receivercoracc';
	var wnd = window.open(url, 'ref', 'width=630,height=318,resizable=yes,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes,dependent=yes');
	wnd.focus();
}

</SCRIPT>            
            <!-- --></DIV>
            </TD>
        </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>
