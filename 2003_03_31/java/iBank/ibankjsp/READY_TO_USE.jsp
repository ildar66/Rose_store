<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Банк Клиент Онлайн - Вход</TITLE>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<!--META http-equiv=Content-Type content="text/html; charset=windows-1251"-->
<%@ page contentType="text/html; charset=windows-1251"%>
<LINK href="/iBank/theme/Master.css" rel="stylesheet" type="text/css">
<SCRIPT language=javascript src="/iBank/ibankjsp/common/common.js" type=text/javascript></SCRIPT>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" background="/iBank/ibankjsp/images/bgtop.gif" border=0>
    <TBODY>
        <TR>
            <TD width="120"><IMG height="51" alt="logo БАНК" src="/iBank/ibankjsp/images/logo.gif" width="120" border=0></TD>
            <TD class=toptitle width="539">• IBANK - Клиент Онлайн • Тест •</TD>
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
            <TD class=menu width=110 bgColor=#dcdee0></TD>
            <TD>
            <DIV class=title>Вход в систему:</DIV>
            <DIV class=body><!-- --> <SCRIPT language=javascript>
function loginform_onsubmit(e) 
{
	if(e.IClientnum.value.length == 0)
	{
		alert("Bведите свое 'Имя'.");
		e.IClientnum.focus();
		return false;
	}
	if(e.PIN.value.length == 0)
	{
		alert("Bведите свой 'Пароль'.");
		e.PIN.focus();
		return false;
	}
	return true;
}

window.onload = window_onload;

function window_onload()
{
	if(document.loginform.IClientnum != null)
		document.loginform.IClientnum.focus();
}
</SCRIPT> <BR>
            <BR>
            <BR>
            <BR>
            <H5>Вход в cистему IBANK</H5>
            <FORM name=loginform onsubmit="return loginform_onsubmit(this);" action="/iBank/InsertIClientServlet" method="POST">
            <TABLE cellSpacing=1 cellPadding=1 border=0>
                <TBODY>
                    <TR>
                        <TD align=right><B>Пользователь:</B>&nbsp;</TD>
                        <TD><INPUT maxLength=50 size=21 name=IClientnum></TD>
                    </TR>
                    <TR>
                        <TD align=right><B>Пароль:</B>&nbsp;</TD>
                        <TD><INPUT type=password maxLength=50 size=21 name="PIN"></TD>
                    </TR>
                    <TR>
                        <TD>&nbsp;</TD>
                        <TD><INPUT type=submit value="Вход в IBANK" name=submit></TD>
                    </TR>
                </TBODY>
            </TABLE>
            <INPUT type=hidden name=starturl></FORM>
            <P class=tips>Для регистрации введите имя пользователя и его пароль.<BR>
            После нескольких неудачных попыток ввод будет заблокирован.</P>
            <!-- --></DIV>
            </TD>
        </TR>
    </TBODY>
</TABLE>

</BODY>
</HTML>
