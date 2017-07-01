<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page isErrorPage="true" import="java.io.*" %>
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<!--META HTTP-EQUIV="Content-Type" content="text/html; charset=WINDOWS-1251"-->
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>error.jsp</TITLE>
</HEAD>
<BODY>

<CENTER>

<TABLE width="620" border="0">
    <TR>
        <TD>

        <H2>An Error Occurred While Processing Your Request...</H2>
        <H2>Ошибочка вышла...</H2>

        <P>The following error has been detected:</P>
        <P>Следующая ошибочка была замечена блин :) :</P>
        <P><B><%= exception %></B></P>


        <P>Full Stack Trace:</P>
        <FORM><% if (exception != null) { 
            StringWriter writer = new StringWriter();
            exception.printStackTrace(new PrintWriter(writer));
        %> <TEXTAREA ROWS=20 COLS=100> <%= writer.getBuffer() %> </TEXTAREA> <% } else { %> <TEXTAREA ROWS=2 COLS=100>None</TEXTAREA> <% } %></FORM>
        </TD>
    </TR>
</TABLE>
<P><A HREF='/iBank/StopServlet'>Restart</A></P>
</CENTER>

</BODY>
</HTML>
