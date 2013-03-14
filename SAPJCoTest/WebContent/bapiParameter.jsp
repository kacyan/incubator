<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.sap.conn.jco.JCoRecordMetaData"%>
<%@page import="com.sap.conn.jco.JCoExtendedFieldMetaData"%>
<%@page import="com.sap.conn.jco.JCoFunctionTemplate"%>
<%@page import="com.sap.conn.jco.JCoListMetaData"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.sap.conn.jco.JCoMetaData"%>
<%@page import="jp.co.ksi.sap.incubator.TestKac"%>
<%@page import="com.sap.conn.jco.JCoParameterList"%>
<%@page import="com.sap.conn.jco.JCoFunction"%>
<%@page import="com.sap.conn.jco.JCoDestinationManager"%>
<%@page import="com.sap.conn.jco.JCoDestination"%>
<%@ taglib uri="ksi.tld" prefix="ksi" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<bean:parameter name="functionName" id="functionName" value=""/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<form action="bapiParameter.jsp" method="post">
汎用モジュール名：<input type="text" name="functionName" value="<bean:write name="functionName"/>" size="40">
<br/><input type="submit">
</form>
<hr/>
<jsp:useBean id="appConfig" beanName="appConfig" type="java.util.Properties" scope="application"/>
<%
String	jcoDestinationFile= appConfig.getProperty( "jcoDestinationFile", "sap" );
if( functionName.equals("") )	return;
try
{
	//	実行時カレントフォルダの sap.jcoDestication というファイルから接続情報を読み込む
	JCoDestination	destination= JCoDestinationManager.getDestination( jcoDestinationFile );

	//	functionName には汎用モジュール名を指定する
	JCoFunction	function= destination.getRepository().getFunction( functionName );
	if( function == null )
	{//	ファンクションが見つからない->ERR終了
		throw new RuntimeException( "["+ functionName +"] not found in SAP.");
	}

	JCoFunctionTemplate	template= function.getFunctionTemplate();
%><h3><%=template.getName() %></h3>
<%
	//	inパラメータのメタデータを表示してみる
	JCoListMetaData	md= template.getImportParameterList();
	if( md != null )
	{
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th><th>Default</th>
  <th>abap</th><th>Changing</th><th>Exception</th><th>Export</th><th>Import</th><th>Locked</th><th>Nested</th><th>Optional</th><th>Structure</th><th>Table</th>
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
  <td><%=md.getDefault(i) %></td>
  <td><%=md.isAbapObject(i) %></td>
  <td><%=md.isChanging(i) %></td>
  <td><%=md.isException(i) %></td>
  <td><%=md.isExport(i) %></td>
  <td><%=md.isImport(i) %></td>
  <td><%=md.isLocked() %></td>
  <td><%=md.isNestedType1Structure(i) %></td>
  <td><%=md.isOptional(i) %></td>
  <td><%=md.isStructure(i) %></td>
  <td><%=md.isTable(i) %></td>
 </tr>
<%
		}
%></table>
<hr/>
<%
	}
//	outパラメータのメタデータを表示してみる
	md= template.getExportParameterList();
	if( md != null )
	{
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th>
 </tr>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	recordTypeName= md.getRecordTypeName(i);
			if( md.isStructure(i) )
			{
				recordTypeName= "<a href=\"recordMetaData.jsp?recordName="+ md.getRecordTypeName(i) +"\">"+ md.getRecordTypeName(i) +"</a>";
			}
%> <tr>
  <td><%=md.getName(i) %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=recordTypeName %></td>
  <td><%=md.isAbapObject(i) %></td>
  <td><%=md.isNestedType1Structure(i) %></td>
  <td><%=md.isStructure(i) %></td>
  <td><%=md.isTable(i) %>
  <td><%=md.isOptional(i) %>
 </tr>
<%
		}
%></table>
<hr/>
<%
	}
//	changeパラメータ
	md= template.getChangingParameterList();
	if( md != null )
	{
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th>
 </tr>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	recordTypeName= md.getRecordTypeName(i);
			if( md.isStructure(i) )
			{
				recordTypeName= "<a href=\"recordMetaData.jsp?recordName="+ md.getRecordTypeName(i) +"\">"+ md.getRecordTypeName(i) +"</a>";
			}
%> <tr>
  <td><%=md.getName(i) %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=recordTypeName %></td>
 </tr>
<%
		}
%></table>
<hr/>
<%
	}
//	tableパラメータ
	md= template.getTableParameterList();
	if( md != null )
	{
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th>
 </tr>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	recordTypeName= md.getRecordTypeName(i);
			if( md.isStructure(i) || md.isTable(i) )
			{
				recordTypeName= "<a href=\"recordMetaData.jsp?recordName="+ md.getRecordTypeName(i) +"\">"+ md.getRecordTypeName(i) +"</a>";
			}
%> <tr>
  <td><%=md.getName(i) %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=recordTypeName %></td>
 </tr>
<%
		}
%></table>
<hr/>
<%
	}
%>
<form action="bapiServiceClass.jsp" method="post">
汎用モジュール名：<input type="text" name="functionName" value="<%=function.getName() %>"><br/>
パッケージ名：<input type="text" name="packageName" value=""><br/>
<input type="submit" value="サービスクラス生成">
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