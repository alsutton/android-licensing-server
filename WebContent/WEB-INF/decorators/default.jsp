<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>AndAppStore : <decorator:title/></title>
<decorator:head />
<link href="/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="maincontainer">
	<div id="pageheader">
		<div id="logo"><a href="http://andappstore.com/"><img src="/header.gif" /></a></div>
	</div>
	<div id="content">
		<div id="maincontent">
			<s:if test="!actionMessages.isEmpty">
				<div class="roundedcornr_box_806808">
   					<div class="roundedcornr_top_806808"><div></div></div>
      					<div class="roundedcornr_content_806808">
							<s:actionmessage theme="aas"/>
				        </div>
				   <div class="roundedcornr_bottom_806808"><div></div></div>
				</div>							
			</s:if>
			
			<s:if test="!actionErrors.isEmpty">
				<div class="roundedcornr_box_152726">
   					<div class="roundedcornr_top_152726"><div></div></div>
      					<div class="roundedcornr_content_152726">
							<s:actionerror theme="aas"/>
						</div>
				   <div class="roundedcornr_bottom_152726"><div></div></div>
				</div>							
			</s:if>
			<decorator:body/>
		</div>
	 	<div id="sidebar">
		 	<s:if test="#session.userId neq null">
		 		<div id="sidebarheadercontainer" >
					<div id="sidebarheader">You are logged in as;<br/><b><s:property value="#session.userName"/></b></div>
				</div>
		 		<center>
			 		<div id="menu">
			 			<ul>
			 				<li><h2>Menu</h2>		 				
								<ul>
									<li><a href="<s:url value='/profile!edit'/>">My Profile</a></li>
									<li><a href="<s:url value='/apps/'/>">Latest Releases</a></li>
									<li><a href="<s:url value='/apps/!list'/>">All Apps</a></li>
									<li><a href="<s:url value='/category/'/>">Categories</a></li>
									<li><a href="<s:url value='/subs'/>">My Submissions</a></li>
									<li><a href="<s:url value='/session!destroy'/>">Logout</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</center>
			</s:if>
			<s:else>
				<div class="roundedcornr_box_254934">
				   <div class="roundedcornr_top_254934"><div></div></div>
				      <div class="roundedcornr_content_254934">
						<form action="https://<%=request.getServerName()%><%=request.getContextPath()%>/session!create" method="POST">
							<s:hidden name="uri" value="%{#context['com.opensymphony.xwork2.dispatcher.HttpServletRequest'].requestURI}" theme="simple"/>
							<p>Your Email Address<br/>
							<s:textfield name="email" label="Email" theme="simple"/></p>
							<p>Your Password<br/>
							<s:password name="password" label="Password" theme="simple"/></p>
							<p><s:submit value="Sign In" theme="simple"/></p>
						</form>					
				      </div>
				   <div class="roundedcornr_bottom_254934"><div></div></div>
				</div>
				<p align="center">If you do not have an account you can register for one by clicking <a href="<s:url value='/register.jsp'/>">here</a>.</p>
				<p align="center">If you have forgotten your password please click <a href="<s:url value='/forgotten_password.jsp'/>">here</a>.</p>
				<center>
			</s:else>
<br/>
			<div class="advert">
<script type="text/javascript"><!--
google_ad_client = "pub-5731005708532982";
/* AndAppStore - Web */
google_ad_slot = "1349478495";
google_ad_width = 120;
google_ad_height = 240;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>
			</div>
		</div>
	</div>
	<div id="pagefooter">
		<div id="pagefootercontent">
			Website design and software are (c)Copyright 2008 <a href="http://www.alsutton.com/" target="_blank">Al Sutton</a>, All Rights Reserved.<br/>
			If you wish to contact the site operators please <a href="<s:url value='/contact.jsp'/>">click here</a>.<br/>
			<br/>
			This website is powered by <a href="http://struts.apache.org/" target="_blank">Struts 2</a>, <a href="http://www.opensymphony.com/sitemesh/" target="_blank">SiteMesh</a>, <a href="http://www.hibernate.org/" target="_blank">Hibernate</a>, <a href="http://www.postgresql.org/" target="_blank">PostgreSQL</a>, <a href="http://tomcat.apache.org/" target="_blank">Tomcat</a>, <a href="http://httpd.apache.org/" target="_blank">Apache HTTPd</a>, and <a href="http://www.opensuse.org/" target="_blank">OpenSUSE</a>.<br/>
			Some of the icons are from the <a href="http://www.ndesign-studio.com/resources/mini-pixel-icons/">n.Design Studio Mini Pixel Icons</a> collection, and boxes were made using <a href="http://www.roundedcornr.com/" target="_blank">RoundedCornr</a>.
		</div>
	</div>
</div>
</body>
</html>
