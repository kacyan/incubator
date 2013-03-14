<%@page import="java.io.PrintWriter"%>
<%@page import="com.sap.conn.jco.ext.Environment"%>
<%@page import="jp.co.ksi.sap.incubator.UserDestinationDataProvider"%>
<%@	page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="ksi.tld" prefix="ksi" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<h1>registered=<%=Environment.isDestinationDataProviderRegistered() %></h1>

<hr>
<%
UserDestinationDataProvider	provider= new UserDestinationDataProvider();
provider.setLang( "ja" );
try
{
	//	データプロバイダを登録する
	Environment.registerDestinationDataProvider( provider );
	
}
catch( Exception e )
{
%><pre>
<% e.printStackTrace( new PrintWriter(out) );
%></pre>
<%
}
%>
<hr>

</body>
</html>
