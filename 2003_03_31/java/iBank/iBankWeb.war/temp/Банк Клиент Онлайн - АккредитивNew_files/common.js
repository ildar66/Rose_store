document.onmouseover = onmouseover;
document.onmouseout = onmouseout;

function onmouseover()
{
	var e = window.event.srcElement;
	var s = e.title.toString();
	if(s == '' && e.tagName == 'A')
		s = e.innerText;
	if(s != '')
		window.setTimeout('window.status=\''+s.split('\'').join('\\\'')+'\'', 1);
}

function onmouseout()
{
	var e = window.event.srcElement;
	var s = e.title.toString();
	if(s == '' && e.tagName == 'A')
		s = e.innerText;
	if(s != '')
		window.status = '';
}

document.onhelp = onhelp;
function onhelp()
{
	var e = window.event.srcElement;
	openHelp(window.location, e.name!=''?e.name:e.id);
	event.returnValue = false;
	return false;
}

function openHelp(url, id)
{
	var wnd = window.open('help/help.asp?path='+escape(url)+'&id='+escape(id), 'help', 'left='+(window.screen.width-400-10)+',width=400,top=0,height=480,resizable=yes,status=no,toolbar=no,menubar=no,location=no,scrollbars=yes');
	wnd.focus();
}

function popup(url, name)
{
	var width = window.screen.availWidth>680?680:window.screen.availWidth;
	var height = (window.screen.availHeight-100);
	var wnd = window.open(url,name,'width='+width+',top=0,height='+height+',resizable=yes,status=no,toolbar=no,menubar=yes,location=no,scrollbars=yes');
	if((document.window != null) && (!wnd.opener))
		wnd.opener = document.window;
	wnd.focus();
	return wnd;
}
