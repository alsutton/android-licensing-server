<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>LifeFeed.Info : <decorator:title/></title>
<decorator:head />
<link href="<%=request.getContextPath()%>/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="maincontainer">
	<div id="pageheader">
		<div id="headercontent">
			<div id="logo"><img src="<s:url value='/header.gif'/>" /></div>
		</div>
	</div>
	<div id="content">
		<decorator:body />
	</div>
	<div id="pagefooter">Website design and software are (c)Copyright 2008 Al Sutton, All Rights Reserved.</div>
</div>
</body>
</html>
