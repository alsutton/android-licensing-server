<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.io.BufferedReader,
                 java.io.InputStreamReader,
                 java.io.IOException,
                 java.io.UnsupportedEncodingException,
                 java.net.URL,
                 java.net.URLEncoder" %>
<%!

private static final String PAGEAD =
    "http://pagead2.googlesyndication.com/pagead/ads?";

private void googleAppendUrl(StringBuilder url, String param, String value)
    throws UnsupportedEncodingException {
  if (value != null) {
    String encodedValue = URLEncoder.encode(value, "UTF-8");
    url.append("&").append(param).append("=").append(encodedValue);
  }
}

private void googleAppendScreenRes(StringBuilder url, String uaPixels,
    String xUpDevcapScreenpixels) {
  String screenRes = uaPixels;
  String delimiter = "x";
  if (uaPixels == null) {
    screenRes = xUpDevcapScreenpixels;
    delimiter = ",";
  }
  if (screenRes != null) {
    String[] resArray = screenRes.split(delimiter);
    if (resArray.length == 2) {
      url.append("&u_w=").append(resArray[0]);
      url.append("&u_h=").append(resArray[1]);
    }
  }
}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>AndAppStore : <decorator:title/></title>
<decorator:head />
<link href="/android-style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="header" align="center">AndAppStore</div>
<div id="loginmessage">
<s:if test="#session.userId neq null">
You are logged in as <s:property value="#session.userName"/><br/>
[<a href="<s:url value='/apps/'/>">Latest Releases</a>][<a href="<s:url value='/apps/!list'/>">All Apps</a>][<a href="<s:url value='/category/'/>">Categories</a>]<br/>
[<a href="<s:url value='/profile!edit'/>">Profile</a>][<a href="<s:url value='/subs'/>">Submissions</a>][<a href="<s:url value='/session!destroy'/>">Logout</a>]
</s:if>
<s:else>Please <a href="<s:url value='/login.jsp'/>">log in</a> or <a href="<s:url value='/register.jsp'/>">register</a></s:else>
</div>
<div class="advert" align="center">
<%

long googleDt = System.currentTimeMillis();
String googleHost = (request.isSecure() ? "https://" : "http://")
    + request.getHeader("Host");

StringBuilder googleAdUrlStr = new StringBuilder(PAGEAD);
googleAdUrlStr.append("ad_type=text");
googleAdUrlStr.append("&channel=6261957536");
googleAdUrlStr.append("&client=ca-mb-pub-5731005708532982");
googleAdUrlStr.append("&dt=").append(googleDt);
googleAdUrlStr.append("&format=mobile_single");
googleAppendUrl(googleAdUrlStr, "host", googleHost);
googleAppendUrl(googleAdUrlStr, "ip", request.getRemoteAddr());
googleAdUrlStr.append("&markup=xhtml");
googleAdUrlStr.append("&oe=utf8");
googleAdUrlStr.append("&output=xhtml");
googleAppendUrl(googleAdUrlStr, "ref", request.getHeader("Referer"));
String googleUrl = request.getRequestURL().toString();
if (request.getQueryString() != null) {
  googleUrl += "?" + request.getQueryString().toString();
}
googleAppendUrl(googleAdUrlStr, "url", googleUrl);
googleAppendUrl(googleAdUrlStr, "useragent", request.getHeader("User-Agent"));
googleAppendScreenRes(googleAdUrlStr, request.getHeader("UA-pixels"),
    request.getHeader("x-up-devcap-screenpixels"));

try {
  URL googleAdUrl = new URL(googleAdUrlStr.toString());
  BufferedReader reader = new BufferedReader(
      new InputStreamReader(googleAdUrl.openStream(), "UTF-8"));
  for (String line; (line = reader.readLine()) != null;) {
    out.println(line);
  }
} catch (IOException e) {}

%>
</div>

<br/>

<s:if test="#session.userId eq null">
	<s:if test="#session.unknownSourceWarning eq null">
		<s:set var="unknownSourceWarning" value="'X'" scope="session"/>
		<div class="roundedcornr_box_230349">
		   <div class="roundedcornr_top_230349"><div></div></div>
		      <div class="roundedcornr_content_230349">
				<b>Please Note</b><br/>
		         If you are installing applications directly to your phone please ensure that
				the "Unknown Sources" option in "Application Settings" has been ticked.
		      </div>
		   <div class="roundedcornr_bottom_230349"><div></div></div>
		</div>
		
		<br/>
	</s:if>
</s:if>

<s:actionerror/>
<s:actionmessage/>

<decorator:body/>

<div id="pagefooter"><div id="pagefootercontent">
(c)Copyright 2008 <a href="http://www.alsutton.com/" target="_blank">Al Sutton</a>, All Rights Reserved.
</div></div>
</body>
</html>
