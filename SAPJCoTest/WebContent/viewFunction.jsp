<%@page import="jp.co.ksi.sap.incubator.bl.Login"%>
<%@page import="com.sap.conn.jco.JCoField"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.sap.conn.jco.JCoTable"%>
<%@ page import="com.sap.conn.jco.JCoStructure"%>
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
<form action="getFunction.do" method="post">
<table>
 <tr>
  <th>汎用モジュール名</th>
  <td><input type="text" name="functionName" value="<bean:write name="functionName"/>" size="40"></td>
 </tr>
</table>
<input type="submit" name="submit" value="getParameterList">
</form>
<hr/>

<logic:notEmpty name="importList" scope="request">
<table border="1">
 <tr>
  <th>Name</th>
  <th>Name</th>
  <th>ClassName</th>
  <th>Value</th>
 </tr>
<%
JCoParameterList	importList= (JCoParameterList)request.getAttribute( "importList" );
for( Iterator<JCoField> i= importList.iterator(); i.hasNext(); )
{
	JCoField	field= i.next();
	if( field.isTable() )
	{//	JCoTable
		JCoTable	table= field.getTable();
			for( Iterator<JCoField>	i2= table.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else if( field.isStructure() )
	{//	JCoStructure
		JCoStructure	strusture= field.getStructure();
			for( Iterator<JCoField>	i2= strusture.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else
	{
%> <tr>
  <td><%=field.getName() %></td>
  <td></td>
  <td><%=field.getClassNameOfValue() %></td>
  <td><%=field.isInitialized() ? field.getValue() : "" %></td>
 </tr>
<%
	}
}%></table>
</logic:notEmpty>
<hr/>

<logic:notEmpty name="tableList" scope="request">
<table border="1">
 <tr>
  <th>Name</th>
  <th>Name</th>
  <th>ClassName</th>
  <th>Value</th>
 </tr>
<%
JCoParameterList	tableList= (JCoParameterList)request.getAttribute( "tableList" );
for( Iterator<JCoField> i= tableList.iterator(); i.hasNext(); )
{
	JCoField	field= i.next();
	if( field.isTable() )
	{//	JCoTable
		JCoTable	table= field.getTable();
			for( Iterator<JCoField>	i2= table.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else if( field.isStructure() )
	{//	JCoStructure
		JCoStructure	strusture= field.getStructure();
			for( Iterator<JCoField>	i2= strusture.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else
	{
%> <tr>
  <td><%=field.getName() %></td>
  <td></td>
  <td><%=field.getClassNameOfValue() %></td>
  <td><%=field.isInitialized() ? field.getValue() : "" %></td>
 </tr>
<%
	}
}
%></table>
</logic:notEmpty>
<hr/>

<logic:notEmpty name="changingList" scope="request">
<table border="1">
 <tr>
  <th>Name</th>
  <th>Name</th>
  <th>ClassName</th>
  <th>Value</th>
 </tr>
<%
JCoParameterList	changingList= (JCoParameterList)request.getAttribute( "changingList" );
for( Iterator<JCoField> i= changingList.iterator(); i.hasNext(); )
{
	JCoField	field= i.next();
	if( field.isTable() )
	{//	JCoTable
		JCoTable	table= field.getTable();
			for( Iterator<JCoField>	i2= table.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else if( field.isStructure() )
	{//	JCoStructure
		JCoStructure	strusture= field.getStructure();
			for( Iterator<JCoField>	i2= strusture.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else
	{
%> <tr>
  <td><%=field.getName() %></td>
  <td></td>
  <td><%=field.getClassNameOfValue() %></td>
  <td><%=field.isInitialized() ? field.getValue() : "" %></td>
 </tr>
<%
	}
}
%></table>
</logic:notEmpty>
<hr/>

<logic:notEmpty name="exoprtList" scope="request">
<table border="1">
 <tr>
  <th>Name</th>
  <th>Name</th>
  <th>ClassName</th>
  <th>Value</th>
 </tr>
<%
JCoParameterList	exoprtList= (JCoParameterList)request.getAttribute( "exoprtList" );
for( Iterator<JCoField> i= exoprtList.iterator(); i.hasNext(); )
{
	JCoField	field= i.next();
	if( field.isTable() )
	{//	JCoTable
		JCoTable	table= field.getTable();
			for( Iterator<JCoField>	i2= table.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else if( field.isStructure() )
	{//	JCoStructure
		JCoStructure	strusture= field.getStructure();
			for( Iterator<JCoField>	i2= strusture.iterator(); i2.hasNext(); )
			{
				JCoField	field2= i2.next();
%> <tr>
  <td><%=field.getName() %></td>
  <td><%=field2.getName() %></td>
  <td><%=field2.getClassNameOfValue() %></td>
  <td><%=field2.isInitialized() ? field2.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else
	{
%> <tr>
  <td><%=field.getName() %></td>
  <td></td>
  <td><%=field.getClassNameOfValue() %></td>
  <td><%=field.isInitialized() ? field.getValue() : "" %></td>
 </tr>
<%
	}
}
%></table>
</logic:notEmpty>
<hr/>

<%
JCoDestination	destination= (JCoDestination)session.getAttribute( Login.SESS_ATTR_NAME_AUTH );
if( destination != null )
{
%><textarea style="width:100%; height:20em;"><%=destination.getAttributes().getSSOTicket() %></textarea>
<%
}
%>

</body>
</html>