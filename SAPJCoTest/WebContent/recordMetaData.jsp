<%@page import="jp.co.ksi.sap.incubator.bl.Login"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<bean:parameter name="recordName" id="recordName" value=""/>
<form action="recordMetaData.jsp" method="post">
レコード名：<input type="text" name="recordName" value="<bean:write name="recordName"/>" size="40">
<br/><input type="submit">
</form>
<hr/>
<jsp:useBean id="appConfig" beanName="appConfig" type="java.util.Properties" scope="application"/>
<%
String	jcoDestinationFile= appConfig.getProperty( "jcoDestinationFile", "sap" );
if( recordName.equals("") )	return;
try
{
	//	セッションから取得する
	JCoDestination	destination= (JCoDestination)session.getAttribute( Login.SESS_ATTR_NAME_AUTH );
	if( destination == null )
	{
		pageContext.forward( "jcoLogin.jsp" );
	}

	//	functionName には汎用モジュール名を指定する
	JCoRecordMetaData md= destination.getRepository().getRecordMetaData( recordName );
	if( md == null )
	{//	レコードが見つからない
		throw new RuntimeException( "["+ recordName +"] not found in SAP.");
	}

%><h3><%=md.getName() %></h3>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th>
 </tr>
<%
	for( int i= 0; i < md.getFieldCount(); i++ )
	{
%> <tr>
  <td><%=md.getName(i) %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=md.getRecordTypeName(i) %></td>
 </tr>
<%
	}
%></table>
<hr/>
<form action="bapiDataClass.jsp" method="post">
レコード名：<input type="text" name="recordName" value="<%=recordName %>"><br/>
パッケージ名：<input type="text" name="packageName" value=""><br/>
<input type="submit" value="データクラス生成">
</form>
<%
}
catch( Exception e )
{
	out.println("<pre>");
	e.printStackTrace( new PrintWriter(out) );
	out.println("</pre>");
}
%>
</body>
</html>