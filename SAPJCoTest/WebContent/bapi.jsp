<%@page import="jp.co.ksi.sap.incubator.bl.Login"%>
<%@page import="com.sap.conn.jco.JCoCustomDestination"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.sap.conn.jco.JCoTable"%>
<%@ page import="com.sap.conn.jco.JCoStructure"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="com.sap.conn.jco.JCoRecordMetaData"%>
<%@ page import="com.sap.conn.jco.JCoExtendedFieldMetaData"%>
<%@ page import="com.sap.conn.jco.JCoFunctionTemplate"%>
<%@ page import="com.sap.conn.jco.JCoListMetaData"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.sap.conn.jco.JCoMetaData"%>
<%@ page import="com.sap.conn.jco.JCoParameterList"%>
<%@ page import="com.sap.conn.jco.JCoFunction"%>
<%@ page import="com.sap.conn.jco.JCoDestinationManager"%>
<%@ page import="com.sap.conn.jco.JCoDestination"%>
<%@ taglib uri="ksi.tld" prefix="ksi" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="appConfig" beanName="appConfig" type="java.util.Properties" scope="application"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<bean:parameter name="functionName" id="functionName" value=""/>
<bean:parameter name="submit" id="submit" value=""/>
<form action="" method="post">
<table>
 <tr>
  <th>汎用モジュール名</th>
  <td><input type="text" name="functionName" value="<bean:write name="functionName"/>" size="40"></td>
 </tr>
</table>
<input type="submit" name="submit" value="getImportParameterList">
<hr/>
<%
if( functionName.equals("") )	return;
try
{
	//	セッションのdestinationを取得する
	JCoDestination	destination= (JCoDestination)session.getAttribute( Login.SESS_ATTR_NAME_AUTH );
	if( destination == null )
	{
		pageContext.forward( "jcoLogin.jsp" );
	}

	//	functionName には汎用モジュール名を指定する
	JCoFunction	function= destination.getRepository().getFunction( functionName );
	if( function == null )
	{//	ファンクションが見つからない
		throw new RuntimeException( "["+ functionName +"] not found in SAP.");
	}
%>
<%	//	inパラメータを表示してみる
	JCoParameterList	inParameterList= function.getImportParameterList();
	if( inParameterList != null )
	{
		JCoMetaData	md= inParameterList.getMetaData();
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th><th>Value</th>
 </tr>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	recordTypeName= md.getRecordTypeName(i);
			if( md.isStructure(i) )
			{
				recordTypeName= "<a href=\"recordMetaData.jsp?recordName="+ md.getRecordTypeName(i) +"\">"+ md.getRecordTypeName(i) +"</a>";
			}
			String	paramName= md.getName( i );
			String	paramValue= request.getParameter( paramName );
%> <tr>
  <td><%=paramName %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=recordTypeName %></td>
  <td><input type="text" name="<%=paramName %>" value="<%=paramValue %>"></td>
 </tr>
<%
		}
%></table>
<%
		if( submit.equals("execute") )
		{
			//	inパラメータに値をセットしてみる
			for( int i= 0; i < md.getFieldCount(); i++ )
			{
				String	paramName= md.getName( i );
				String	paramValue= request.getParameter( paramName );
				if( ( paramValue != null ) && !paramValue.equals("") )
				{
					inParameterList.setValue( paramName, paramValue );
				}
			}
		}

	}//	if( inParameterList != null ) end
%>
<%	//	tableパラメータを表示してみる
	JCoParameterList	tableParameterList= function.getTableParameterList();
	if( tableParameterList != null )
	{
		JCoMetaData	md= tableParameterList.getMetaData();
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th><th>Value</th>
 </tr>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	paramName= md.getName( i );
			String	paramValue= request.getParameter( paramName );
%> <tr>
  <td><%=paramName %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=md.getRecordTypeName(i) %></td>
<%
			if( md.isStructure(i) || md.isTable(i) )
			{//	構造体の中を表示する
%> </tr>
<%
				JCoRecordMetaData	rmd= md.getRecordMetaData(i);
				for( int j= 0; j < rmd.getFieldCount(); j++ )
				{
					String	subName= paramName +"."+ rmd.getName(j);
					String	subValue= request.getParameter( subName );
%> <tr>
  <td><%=subName %></td>
  <td><%=rmd.getType(j) %></td>
  <td><%=rmd.getTypeAsString(j) %></td>
  <td><%=rmd.getClassNameOfField(j) %></td>
  <td><%=rmd.getLength(j) %></td>
  <td><%=rmd.getDescription(j) %></td>
  <td><%=rmd.getRecordTypeName(j) %></td>
  <td><input type="text" name="<%=subName %>" value="<%=subValue %>"></td>
 </tr>
<%
				}
			}
			else
			{//
%>  <td><input type="text" name="<%=paramName %>" value="<%=paramValue %>"></td>
 </tr>
<%
			}
		}
%></table>
<%
		if( submit.equals("execute") )
		{
			//	inパラメータに値をセットしてみる
			for( int i= 0; i < md.getFieldCount(); i++ )
			{
				String	paramName= md.getName( i );
				String	paramValue= request.getParameter( paramName );
				if( ( paramValue != null ) && !paramValue.equals("") )
				{
					inParameterList.setValue( paramName, paramValue );
				}
			}
		}

	}//	if( inParameterList != null ) end
%>
<%	//	changingParameterListパラメータを表示してみる
	JCoParameterList	changingParameterList= function.getChangingParameterList();
	if( changingParameterList != null )
	{
		JCoMetaData	md= changingParameterList.getMetaData();
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th><th>Value</th>
 </tr>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	recordTypeName= md.getRecordTypeName(i);
			if( md.isStructure(i) )
			{
				recordTypeName= "<a href=\"recordMetaData.jsp?recordName="+ md.getRecordTypeName(i) +"\">"+ md.getRecordTypeName(i) +"</a>";
			}
			String	paramName= md.getName( i );
			String	paramValue= request.getParameter( paramName );
%> <tr>
  <td><%=paramName %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=recordTypeName %></td>
  <td><input type="text" name="<%=paramName %>" value="<%=paramValue %>"></td>
 </tr>
<%
		}
%></table>
<%
		if( submit.equals("execute") )
		{
			//	changingパラメータに値をセットしてみる
			for( int i= 0; i < md.getFieldCount(); i++ )
			{
				String	paramName= md.getName( i );
				String	paramValue= request.getParameter( paramName );
				if( ( paramValue != null ) && !paramValue.equals("") )
				{
					changingParameterList.setValue( paramName, paramValue );
				}
			}
		}

	}//	if( changingParameterList != null ) end
%>
<input type="submit" name="submit" value="execute"/>
</form>
<hr/>
<%
	if( submit.equals("execute") )
	{
		//	実行してみる
		function.execute( destination );
	}
	else
	{
		return;
	}
%>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th><th>Value</th>
 </tr>
<%
//	outパラメータを表示してみる
	JCoParameterList	outParameterList= function.getExportParameterList();
	if( outParameterList != null )
	{
		JCoMetaData md= outParameterList.getMetaData();
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	name= md.getName(i);
			Object	value= outParameterList.getValue( name );
%> <tr>
  <td><%=name %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=md.getRecordTypeName(i) %></td>
<% if( value instanceof JCoStructure ){ %>
<% }else{ %>  <td><%=value %></td>
<% } %> </tr>
<%
			if( value instanceof JCoStructure )
			{//	構造体の中を表示する
				JCoStructure	st= (JCoStructure)value;
				JCoMetaData	stmd= st.getMetaData();
				String	stName= stmd.getName();
				for( int j= 0; j < stmd.getFieldCount(); j++ )
				{
%> <tr>
  <td><%=name %>.<%=stmd.getName(j) %></td>
  <td><%=stmd.getType(j) %></td>
  <td><%=stmd.getTypeAsString(j) %></td>
  <td><%=stmd.getClassNameOfField(j) %></td>
  <td><%=stmd.getLength(j) %></td>
  <td><%=stmd.getDescription(j) %></td>
  <td><%=stmd.getRecordTypeName(j) %></td>
  <td><%=st.getValue(j) %></td>
 </tr>
<%
				}
			}
		}//	for end
	}//	if( outParameterList != null ) end
%></table>
<hr/>
<table border="1">
 <tr>
  <th>Name</th><th>Type</th><th>TypeAsString</th><th>ClassName</th><th>Length</th><th>Description</th><th>RecordType</th><th>Value</th>
 </tr>
<%
//	tableパラメータを表示してみる
	tableParameterList= function.getTableParameterList();
	if( tableParameterList != null )
	{
		JCoMetaData md= tableParameterList.getMetaData();
%>
<%=md.getName() %>
<%=md.getFieldCount() %>
<%
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	name= md.getName(i);
			Object	value= tableParameterList.getValue( name );
%> <tr>
  <td><%=name %></td>
  <td><%=md.getType(i) %></td>
  <td><%=md.getTypeAsString(i) %></td>
  <td><%=md.getClassNameOfField(i) %></td>
  <td><%=md.getLength(i) %></td>
  <td><%=md.getDescription(i) %></td>
  <td><%=md.getRecordTypeName(i) %></td>
<% if( value instanceof JCoStructure ){ %>
<% }else if( value instanceof JCoTable ){ %>  <td><%=value %></td>
<% }else{ %>  <td><%=value %></td>
<% } %> </tr>
<%
			if( value instanceof JCoStructure )
			{//	構造体の中を表示する
				JCoStructure	st= (JCoStructure)value;
				JCoMetaData	stmd= st.getMetaData();
				String	stName= stmd.getName();
				for( int j= 0; j < stmd.getFieldCount(); j++ )
				{
%> <tr>
  <td><%=name %>.<%=stmd.getName(j) %></td>
  <td><%=stmd.getType(j) %></td>
  <td><%=stmd.getTypeAsString(j) %></td>
  <td><%=stmd.getClassNameOfField(j) %></td>
  <td><%=stmd.getLength(j) %></td>
  <td><%=stmd.getDescription(j) %></td>
  <td><%=stmd.getRecordTypeName(j) %></td>
  <td><%=st.getValue(j) %></td>
 </tr>
<%
				}
			}
			else if( value instanceof JCoTable )
			{//	テーブルの中を表示する
				JCoTable	st= (JCoTable)value;
				JCoMetaData	stmd= st.getMetaData();
				String	stName= stmd.getName();
				for( int j= 0; j < stmd.getFieldCount(); j++ )
				{
%> <tr>
  <td><%=name %>.<%=stmd.getName(j) %></td>
  <td><%=stmd.getType(j) %></td>
  <td><%=stmd.getTypeAsString(j) %></td>
  <td><%=stmd.getClassNameOfField(j) %></td>
  <td><%=stmd.getLength(j) %></td>
  <td><%=stmd.getDescription(j) %></td>
  <td><%=stmd.getRecordTypeName(j) %></td>
  <td><%=st.getValue(j) %></td>
 </tr>
<%
				}
			}
		}//	for end
	}//	if( tableParameterList != null ) end
%></table>
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