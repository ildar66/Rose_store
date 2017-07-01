<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>IBank - Просмотр аккредитива.</TITLE>
<!--META http-equiv=Content-Type content="text/html; charset=windows-1251"--> 
<%@ page contentType="text/html; charset=windows-1251"%>
<STYLE type=text/css>BODY {
	MARGIN: 3px 0px 0px 3px; COLOR: black; BACKGROUND-COLOR: white
}
BIG {
	FONT: bold 10pt Arial,sans-serif
}
SMALL {
	FONT: 8pt "Times New Roman",serif
}
P {
	FONT: 11pt "Times New Roman",serif
}
TD {
	BORDER-RIGHT: black 0pt solid; BORDER-TOP: black 0pt solid; FONT: 10pt "Times New Roman",serif; VERTICAL-ALIGN: top; BORDER-LEFT: black 0pt solid; BORDER-BOTTOM: black 0pt solid
}
TABLE {
	BORDER-RIGHT: medium none; BORDER-TOP: medium none; BORDER-LEFT: medium none; WIDTH: 100%; BORDER-BOTTOM: medium none
}
.b1234 {
	BORDER-TOP-WIDTH: 1pt; BORDER-LEFT-WIDTH: 1pt; BORDER-BOTTOM-WIDTH: 1pt; BORDER-RIGHT-WIDTH: 1pt
}
.b13 {
	BORDER-TOP-WIDTH: 1pt; BORDER-LEFT-WIDTH: 0pt; BORDER-BOTTOM-WIDTH: 1pt; BORDER-RIGHT-WIDTH: 0pt
}
.b23 {
	BORDER-TOP-WIDTH: 0pt; BORDER-LEFT-WIDTH: 0pt; BORDER-BOTTOM-WIDTH: 1pt; BORDER-RIGHT-WIDTH: 1pt
}
.b3 {
	BORDER-TOP-WIDTH: 0pt; BORDER-LEFT-WIDTH: 0pt; BORDER-BOTTOM-WIDTH: 1pt; BORDER-RIGHT-WIDTH: 0pt
}
.b2 {
	BORDER-TOP-WIDTH: 0pt; BORDER-LEFT-WIDTH: 0pt; BORDER-BOTTOM-WIDTH: 0pt; BORDER-RIGHT-WIDTH: 1pt
}
.b1 {
	BORDER-TOP-WIDTH: 1pt; BORDER-LEFT-WIDTH: 0pt; BORDER-BOTTOM-WIDTH: 0pt; BORDER-RIGHT-WIDTH: 0pt
}
</STYLE>

<STYLE type=text/css media=screen>DIV.eop {
	BORDER-RIGHT: black 0px solid; BORDER-TOP: black 0px solid; MARGIN: 3px -1px 3px -4px; BORDER-LEFT: black 0px solid; BORDER-BOTTOM: black 2px solid
}
</STYLE>

<STYLE type=text/css media=print>DIV.eop {
	VISIBILITY: hidden; PAGE-BREAK-AFTER: always
}
</STYLE>

<META content="MSHTML 6.00.2800.1126" name=GENERATOR></HEAD>
<BODY>
<%@ page import="com.overstar.ildar.ibank.model.documents.*" %>
<%
//Execute Bean Methods 
String docID = request.getParameter("docID");
Accreditive curAccreditive = AccreditiveTransactionMgr.findWithAccreditivePK(docID);
%>

<CENTER>
<DIV style="WIDTH: 175mm">
<TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR>
    <TD width="40%" rowSpan=2><BIG>АККРЕДИТИВ № <%= curAccreditive.rtNum_doc() %></BIG></TD>
    <TD align=middle width="20%">
      <P><%= curAccreditive.rtDate_doc() %></P></TD>
    <TD width="1%" rowSpan=2></TD>
    <TD align=middle width="20%">
      <P><%= curAccreditive.rtAccreditiv_type() %></P></TD>
    <TD width="11%" rowSpan=2></TD>
    <TD class=b1234 align=middle width="8%">0401063</TD></TR>
  <TR align=middle>
    <TD class=b1><SMALL>Дата</SMALL></TD>
    <TD class=b1><SMALL>Вид платежа</SMALL></TD>
    <TD></TD></TR></TBODY></TABLE><BR>
<TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR style="HEIGHT: 15mm">
    <TD class=b23 width="11%">Сумма<BR>прописью</TD>
    <TD class=b3>
      <P>&nbsp;<%= curAccreditive.rtAmount() %> </P></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR style="HEIGHT: 15mm">
    <TD class=b2 width="55%" rowSpan=2>
      <P>ИНН <%= curAccreditive.rtPayer().rtInn() %><BR><%= curAccreditive.rtPayer().rtName() %></P></TD>
    <TD class=b23 width="9%">&nbsp;Сумма</TD>
    <TD class=b3 colSpan=3>
      <P>&nbsp;<%= curAccreditive.rtAmount() %></P></TD></TR>
  <TR style="HEIGHT: 5mm">
    <TD class=b2>&nbsp;Сч. №</TD>
    <TD colSpan=3 rowSpan=2>
      <P>&nbsp;<%= curAccreditive.rtPayer().rtBill() %></P></TD></TR>
  <TR>
    <TD class=b23>Плательщик</TD>
    <TD class=b23>&nbsp;</TD></TR>
  <TR>
    <TD class=b2 rowSpan=2>
      <P><%= curAccreditive.rtPayer().rtBank_name() %></P></TD>
    <TD class=b23>&nbsp;БИК</TD>
    <TD colSpan=3>
      <P>&nbsp;<%= curAccreditive.rtPayer().rtBank_Bic() %></P></TD></TR>
  <TR>
    <TD class=b2>&nbsp;Сч. №</TD>
    <TD colSpan=3>
      <P>&nbsp;<%= curAccreditive.rtPayer().rtBank_acc()%></P></TD></TR>
  <TR>
    <TD class=b23>Банк плательщика</TD>
    <TD class=b23>&nbsp;</TD>
    <TD class=b3 colSpan=3>&nbsp;</TD></TR>
  <TR>
    <TD class=b2 rowSpan=2>
      <P><%= curAccreditive.rtRecipient().rtBank_name() %></P></TD>
    <TD class=b23>&nbsp;БИК</TD>
    <TD colSpan=3>
      <P>&nbsp;<%= curAccreditive.rtRecipient().rtBank_Bic() %></P></TD></TR>
  <TR>
    <TD class=b2>&nbsp;Сч. №</TD>
    <TD colSpan=3>
      <P>&nbsp;<%= curAccreditive.rtRecipient().rtBank_acc() %></P></TD></TR>
  <TR>
    <TD class=b23>Банк получателя</TD>
    <TD class=b23>&nbsp;</TD>
    <TD colSpan=3></TD></TR>
  <TR style="HEIGHT: 10mm">
    <TD class=b2 rowSpan=3>
      <P>ИНН <%= curAccreditive.rtRecipient().rtInn() %><BR><%= curAccreditive.rtRecipient().rtName() %></P></TD>
    <TD class=b23>&nbsp;Сч. №<BR>&nbsp;(40901)</TD>
    <TD class=b3 colSpan=3>
      <P>&nbsp;<%= curAccreditive.rtAccount_40901() %></P></TD></TR>
  <TR>
    <TD class=b23 width="9%">&nbsp;Вид. оп.</TD>
    <TD class=b2 width="11%">
      <P>&nbsp;<%= curAccreditive.rtType_oper() %></P></TD>
    <TD class=b23 width="11%" 
      rowSpan=2>&nbsp;Срок&nbsp;действ.<BR>&nbsp;аккредит.</TD>
    <TD width="14%" rowSpan=2>
      <P>&nbsp;<%= curAccreditive.rtTerm() %></P></TD></TR>
  <TR>
    <TD class=b23>&nbsp;Наз. пл.</TD>
    <TD class=b2>
      <P>&nbsp;</P></TD></TR>
  <TR>
    <TD class=b23 style="VERTICAL-ALIGN: bottom">Получатель</TD>
    <TD class=b23>&nbsp;Код</TD>
    <TD class=b23>
      <P>&nbsp;</P></TD>
    <TD class=b23>&nbsp;Рез. поле&nbsp;</TD>
    <TD class=b3>
      <P>&nbsp;</P></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR>
    <TD class=b23 width="14%">Вид<BR>аккредитива</TD>
    <TD>
      <P>&nbsp;<%= curAccreditive.rtType_accreditiv1() %>, <%= curAccreditive.rtType_accreditiv2() %></P></TD></TR>
  <TR>
    <TD class=b23>Условие<BR>оплаты</TD>
    <TD class=b3>
      <P>&nbsp;<%= curAccreditive.rtCondition_pay() %></P></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR>
    <TD>Наименование товаров (работ, услуг), № и дата договора, срок отгрузки 
      товаров (выполнения работ, оказания услуг), грузополучатель и место 
      назначения</TD></TR>
  <TR style="HEIGHT: 10mm">
    <TD>
      <P><%= curAccreditive.rtAccreditiv_details() %> </P></TD></TR>
  <TR>
    <TD>Платеж по представлению (вид документа)</TD></TR>
  <TR style="HEIGHT: 7mm">
    <TD>
      <P><%= curAccreditive.rtAccreditiv_docs() %></P></TD></TR>
  <TR>
    <TD>Дополнительные условия</TD></TR>
  <TR style="HEIGHT: 7mm">
    <TD><%= curAccreditive.rtAdd_condition() %></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR>
    <TD width="16%">№ сч. получателя</TD>
    <TD>
      <P><%= curAccreditive.rtRecipient().rtBill() %></P></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR align=middle>
    <TD class=b1 width="30%" rowSpan=2><BR><BR><BR>М.П.</TD>
    <TD class=b13 width="40%">Подписи<BR><BR>&nbsp;</TD>
    <TD class=b1 colSpan=2 rowSpan=2>Отметки банка</TD></TR>
  <TR>
    <TD 
class=b3><BR><BR>&nbsp;</TD></TR></TBODY></TABLE><BR></DIV></CENTER></BODY></HTML>
