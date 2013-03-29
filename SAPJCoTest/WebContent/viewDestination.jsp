<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="jp.co.ksi.sap.incubator.DestinationAuth"%>
<%@ page import="jp.co.ksi.sap.incubator.bl.Login"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.sap.conn.jco.JCoDestination"%>
<%@ taglib uri="ksi.tld" prefix="ksi" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<%--
viewDestination.jsp
2013/03/28
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="appConfig" beanName="appConfig" type="java.util.Properties" scope="application"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<logic:notEmpty name="auth" scope="session">
<bean:define id="destination" name="auth" property="destination" type="com.sap.conn.jco.JCoDestination"/>
<table border="1">
 <tr>
  <th>applicationServerHost</th>
  <td><bean:write name="destination" property="applicationServerHost"/></td>
 </tr>
 <tr>
  <th>systemNumber</th>
  <td><bean:write name="destination" property="systemNumber"/></td>
 </tr>
 <tr>
  <th>client</th>
  <td><bean:write name="destination" property="client"/></td>
 </tr>
 <tr>
  <th>user</th>
  <td><bean:write name="destination" property="user"/></td>
 </tr>
 <tr>
  <th>language</th>
  <td><bean:write name="destination" property="language"/></td>
 </tr>
</table>
<pre>
<%
Properties	props= destination.getProperties();
props.list( new PrintWriter(out) );
%>
</pre>
</logic:notEmpty>
</body>
</html>