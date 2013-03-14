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
<%--
レコードのメタデータJCoRecordMetaDataを使ってデータクラスを生成する習作
2013/02/14 Kac
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<bean:parameter name="recordName" id="recordName" value=""/>
<bean:parameter name="packageName" id="packageName" value=""/>
<jsp:useBean id="appConfig" beanName="appConfig" type="java.util.Properties" scope="application"/>
<%
String	jcoDestinationFile= appConfig.getProperty( "jcoDestinationFile", "sap" );
if( recordName.equals("") )	return;
try
{
	//	実行時カレントフォルダの sap.jcoDestication というファイルから接続情報を読み込む
	JCoDestination	destination= JCoDestinationManager.getDestination( jcoDestinationFile );

	//	functionName には汎用モジュール名を指定する
	JCoRecordMetaData md= destination.getRepository().getRecordMetaData( recordName );
	if( md == null )
	{//	レコードが見つからない
		throw new RuntimeException( "["+ recordName +"] not found in SAP.");
	}

%>
<pre>
<logic:notEmpty name="packageName">
import <%=packageName %>;
</logic:notEmpty>
/**
 * <%=packageName %><%=packageName.equals("")?"":"." %><%=md.getName() %>
 */
</pre>
<pre>
public class <%=md.getName() %> {
<%
	for( int i= 0; i < md.getFieldCount(); i++ )
	{
%>
	/**
	 * <%=md.getDescription(i) %> length=<%=md.getLength(i) %> <%=md.getRecordTypeName(i) %>
	 */
	private <%=md.getClassNameOfField(i) %> <%=md.getName(i) %>;
<%
	}
%>
}
</pre>
<hr/>
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