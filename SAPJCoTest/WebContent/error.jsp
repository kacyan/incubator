<%@page import="java.io.PrintWriter"%>
<%@	page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isErrorPage="true"%>
<%@ taglib uri="ksi.tld" prefix="ksi" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<%@page import="java.io.File"%>
<%@page import="java.util.Arrays"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<h3><%= exception.toString() %></h3>

<hr>
<pre>
<%
exception.printStackTrace( new PrintWriter(out) );
%>
</pre>
<hr>

</body>
</html>
