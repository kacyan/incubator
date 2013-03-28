<%@page import="com.sap.conn.jco.JCoTable"%>
<%@page import="com.sap.conn.jco.JCoStructure"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.sap.conn.jco.JCoRecordMetaData"%>
<%@page import="com.sap.conn.jco.JCoExtendedFieldMetaData"%>
<%@page import="com.sap.conn.jco.JCoFunctionTemplate"%>
<%@page import="com.sap.conn.jco.JCoListMetaData"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.sap.conn.jco.JCoMetaData"%>
<%@page import="com.sap.conn.jco.JCoParameterList"%>
<%@page import="com.sap.conn.jco.JCoFunction"%>
<%@page import="com.sap.conn.jco.JCoDestinationManager"%>
<%@page import="com.sap.conn.jco.JCoDestination"%>
<%@ taglib uri="ksi.tld" prefix="ksi" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<%--
jcoLogin.jsp
2013/03/27
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="appConfig" beanName="appConfig" type="java.util.Properties" scope="application"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<bean:parameter name="host" id="host" value=""/>
<bean:parameter name="systemNumber" id="systemNumber" value=""/>
<bean:parameter name="clientNumber" id="clientNumber" value=""/>
<bean:parameter name="uid" id="uid" value=""/>
<bean:parameter name="pwd" id="pwd" value=""/>
<bean:parameter name="host" id="host" value=""/>
<bean:parameter name="submit" id="submit" value=""/>
<logic:present name="javax.servlet.forward.request_uri" scope="request">
 <bean:define id="requestURI" name="javax.servlet.forward.request_uri"/>
</logic:present>
<logic:notPresent name="javax.servlet.forward.request_uri" scope="request">
 <bean:define id="requestURI" value=""/>
</logic:notPresent>
<html:form action="/login" method="post" >
<input type="hidden" name="requestURI" value="<bean:write name="requestURI"/>"><bean:write name="requestURI"/>
<table>
 <tr>
  <th>サーバ</th>
  <td><input type="text" name="host" value="<bean:write name="host"/>" size="40"></td>
 </tr>
 <tr>
  <th>システム番号</th>
  <td><input type="text" name="systemNumber" value="<bean:write name="systemNumber"/>" size="4"></td>
 </tr>
 <tr>
  <th>クライアント番号</th>
  <td><input type="text" name="clientNumber" value="<bean:write name="clientNumber"/>" size="4"></td>
 </tr>
 <tr>
  <th>ユーザ</th>
  <td><input type="text" name="uid" value="<bean:write name="uid"/>" size="20"></td>
 </tr>
 <tr>
  <th>パスワード</th>
  <td><input type="password" name="pwd" value="<bean:write name="pwd"/>" size="20"></td>
 </tr>
 <tr>
  <th>SSOチケット</th>
  <td><input type="checkbox" name="type" value="getsso2">GETSSO2</td>
 </tr>
</table>
<br/><input type="submit" name="submit" value="Login">
</html:form>
<hr/>
</body>
</html>