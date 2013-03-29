<%@page import="jp.co.ksi.sap.incubator.DestinationAuth"%>
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
<%--
viewFunction.jsp
2013/03/29
 --%>
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
<jsp:include page="inc/error.jsp" flush="true"/>

<!-- importList -->
<html:form action="/execFunction" method="post">
<input type="hidden" name="functionName" value="<bean:write name="functionName"/>">
<logic:notEmpty name="importList" scope="request">
<jsp:useBean id="importList" scope="request" type="com.sap.conn.jco.JCoParameterList"/>
<%
JCoListMetaData md= importList.getListMetaData();
%><p><%=md.getName() %>(<%=md.getFieldCount() %>)</p>
<table border="1">
 <tr>
  <th>Name</th>
  <th>Description</th>
  <th>ClassName</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">AbapObj</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Changing</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Exception</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Export</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Import</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Nested...</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Optional</th>
  <th>Value</th>
 </tr>
<%
for( int i= 0; i < md.getFieldCount(); i++ )
{
%> <tr>
  <td><%=md.getName( i ) %></td>
  <td><%=md.getDescription( i ) %></td>
  <td><%=md.getClassNameOfField( i ) %></td>
  <td><%=md.isAbapObject( i )?"○":"&nbsp;" %></td>
  <td><%=md.isChanging( i )?"○":"&nbsp;" %></td>
  <td><%=md.isException( i )?"○":"&nbsp;" %></td>
  <td><%=md.isExport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isImport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isNestedType1Structure( i ) ?"○":"&nbsp;" %></td>
  <td><%=md.isOptional( i )?"○":"&nbsp;" %></td>
  <td>
<%
	if( md.isTable( i ) )
	{//	JCoTable
		JCoTable	table= importList.getTable( i );
%>  <%=table %>
<%
	}
	else if( md.isStructure( i ) )
	{//	JCoStructure
		JCoStructure	strusture= importList.getStructure( i );
%>   <table border="1">
<%
		for( Iterator<JCoField> it= strusture.iterator(); it.hasNext(); )
		{
			JCoField	field= it.next();
			String	value= "";
			if( field.isInitialized() )
			{
				Object	obj= field.getValue();
				if( obj != null )
				{
					value= obj.toString();
				}
			}
%>    <tr>
     <td><%=field.getName() %></td>
     <td><%=field.getDescription() %></td>
     <td><%=field.getClassNameOfValue() %></td>
     <td><input type="text" name="<%=md.getName( i ) %>.<%=field.getName() %>" value="<%=value %>"></td>
    </tr>
<%
		}
%>   </table>
<%
	}
	else
	{
%>   <input type="text" name="<%=md.getName( i ) %>" value="<%=importList.isInitialized( i ) ? importList.getValue( i ) : "" %>">
<%
	}
%>  </td>
 </tr>
<%
}
%></table>
</logic:notEmpty>
<html:checkbox property="flgCommit" >コミット処理を行う</html:checkbox><br/>
<input type="submit" name="submit.execFunction" value="実行">
</html:form>
<hr/>

<!-- tableList -->
<logic:notEmpty name="tableList" scope="request">
<jsp:useBean id="tableList" scope="request" type="com.sap.conn.jco.JCoParameterList"/>
<%
JCoListMetaData md= tableList.getListMetaData();
%><p><%=md.getName() %>(<%=md.getFieldCount() %>)</p>
<table border="1">
 <tr>
  <th>Name</th>
  <th>Description</th>
  <th>ClassName</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">AbapObj</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Changing</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Exception</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Export</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Import</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Nested...</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Optional</th>
  <th>Value</th>
 </tr>
<%
for( int i= 0; i < md.getFieldCount(); i++ )
{
	if( md.isTable( i ) )
	{//	JCoTable
		JCoTable	table= tableList.getTable( i );
		JCoMetaData	tableMd= table.getMetaData();
%> <tr>
  <td><%=md.getName( i ) %></td>
  <td><%=md.getDescription( i ) %></td>
  <td><%=md.getClassNameOfField( i ) %><br/>
   <%=table.getFieldCount() %>, <%=table.getNumColumns() %>, <%=table.getNumRows() %>
  </td>
  <td><%=md.isAbapObject( i )?"○":"&nbsp;" %></td>
  <td><%=md.isChanging( i )?"○":"&nbsp;" %></td>
  <td><%=md.isException( i )?"○":"&nbsp;" %></td>
  <td><%=md.isExport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isImport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isNestedType1Structure( i ) ?"○":"&nbsp;" %></td>
  <td><%=md.isOptional( i )?"○":"&nbsp;" %></td>
  <td colspan="2">
   <table border="1">
    <tr>
<%
		for( int j= 0; j < tableMd.getFieldCount(); j++ )
		{
%>     <th><%=tableMd.getName( j ) %></th>
<%			
		}
%>    </tr>
    <tr>
<%
		for( int j= 0; j < tableMd.getFieldCount(); j++ )
		{
%>     <th><%=tableMd.getDescription( j ) %></th>
<%			
		}
%>    </tr>
    <tr>
<%
		for( int j= 0; j < tableMd.getFieldCount(); j++ )
		{
%>     <th><%=tableMd.getClassNameOfField( j ) %></th>
<%			
		}
%>    </tr>
<%
		do
		{
%>    <tr>
<%
			for( Iterator<JCoField>	it= table.iterator(); it.hasNext(); )
			{
				JCoField	field= it.next();
%>     <td><%=field.isInitialized() ? field.getValue() : "" %></td>
<%
			}
%>    </tr>
<%
		}while( table.nextRow() );
%>
   </table>
  </td>
 </tr>
<%
	}
	else if( md.isStructure( i ) )
	{//	JCoStructure
		JCoStructure	strusture= tableList.getStructure( i );
		for( Iterator<JCoField>	i2= strusture.iterator(); i2.hasNext(); )
		{
			JCoField	field= i2.next();
%> <tr>
  <td><%=md.getName( i ) %></td>
  <td><%=md.getDescription( i ) %></td>
  <td><%=md.isAbapObject( i )?"○":"&nbsp;" %></td>
  <td><%=md.isChanging( i )?"○":"&nbsp;" %></td>
  <td><%=md.isException( i )?"○":"&nbsp;" %></td>
  <td><%=md.isExport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isImport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isNestedType1Structure( i ) ?"○":"&nbsp;" %></td>
  <td><%=md.isOptional( i )?"○":"&nbsp;" %></td>
  <td><%=field.getName() %></td>
  <td><%=field.getDescription() %></td>
  <td><%=field.getClassNameOfValue() %></td>
  <td><%=field.isInitialized() ? field.getValue() : "" %></td>
 </tr>
<%
			}
	}
	else
	{
%> <tr>
  <td><%=md.getName( i ) %></td>
  <td><%=md.getDescription( i ) %></td>
  <td><%=md.getClassNameOfField( i ) %></td>
  <td><%=md.isAbapObject( i )?"○":"&nbsp;" %></td>
  <td><%=md.isChanging( i )?"○":"&nbsp;" %></td>
  <td><%=md.isException( i )?"○":"&nbsp;" %></td>
  <td><%=md.isExport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isImport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isNestedType1Structure( i ) ?"○":"&nbsp;" %></td>
  <td><%=md.isOptional( i )?"○":"&nbsp;" %></td>
  <td><input type="text" name="<%=md.getName( i ) %>" value="<%=tableList.isInitialized( i ) ? tableList.getValue( i ) : "" %>"></td>
 </tr>
<%
	}
}
%></table>
</logic:notEmpty>
<hr/>

<!-- changingList -->
<logic:notEmpty name="changingList" scope="request">
<jsp:useBean id="changingList" scope="request" type="com.sap.conn.jco.JCoParameterList"/>
<%
JCoListMetaData md= changingList.getListMetaData();
%><p><%=md.getName() %>(<%=md.getFieldCount() %>)</p>
<table border="1">
 <tr>
  <th>Name</th>
  <th>Description</th>
  <th>ClassName</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">AbapObj</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Changing</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Exception</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Export</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Import</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Nested...</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Optional</th>
  <th>Value</th>
 </tr>
<%
for( int i= 0; i < md.getFieldCount(); i++ )
{
%> <tr>
  <td><%=md.getName( i ) %></td>
  <td><%=md.getDescription( i ) %></td>
  <td><%=md.getClassNameOfField( i ) %></td>
  <td><%=md.isAbapObject( i )?"○":"&nbsp;" %></td>
  <td><%=md.isChanging( i )?"○":"&nbsp;" %></td>
  <td><%=md.isException( i )?"○":"&nbsp;" %></td>
  <td><%=md.isExport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isImport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isNestedType1Structure( i ) ?"○":"&nbsp;" %></td>
  <td><%=md.isOptional( i )?"○":"&nbsp;" %></td>
  <td>
<%
	if( md.isTable( i ) )
	{//	JCoTable
		JCoTable	table= changingList.getTable( i );
%>  <%=table %>
<%
	}
	else if( md.isStructure( i ) )
	{//	JCoStructure
		JCoStructure	strusture= changingList.getStructure( i );
%>   <table border="1">
<%
		for( Iterator<JCoField> it= strusture.iterator(); it.hasNext(); )
		{
			JCoField	field= it.next();
%>    <tr>
     <td><%=field.getName() %></td>
     <td><%=field.getDescription() %></td>
     <td><%=field.getClassNameOfValue() %></td>
     <td><%=field.isInitialized() ? field.getValue() : "" %></td>
    </tr>
<%
		}
%>   </table>
<%
	}
	else
	{
%>  <%=changingList.isInitialized( i ) ? changingList.getValue( i ) : "" %>
<%
	}
%>  </td>
 </tr>
<%
}
%></table>
</logic:notEmpty>
<hr/>

<!-- exportList -->
<logic:notEmpty name="exportList" scope="request">
<jsp:useBean id="exportList" scope="request" type="com.sap.conn.jco.JCoParameterList"/>
<%
JCoListMetaData md= exportList.getListMetaData();
%><p><%=md.getName() %>(<%=md.getFieldCount() %>)</p>
<table border="1">
 <tr>
  <th>Name</th>
  <th>Description</th>
  <th>ClassName</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">AbapObj</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Changing</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Exception</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Export</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Import</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Nested...</th>
  <th style="width:1em;font-size:80%;min-width:1em; word-break:break-all;">Optional</th>
  <th>Value</th>
 </tr>
<%
for( int i= 0; i < md.getFieldCount(); i++ )
{
%> <tr>
  <td><%=md.getName( i ) %></td>
  <td><%=md.getDescription( i ) %></td>
  <td><%=md.getClassNameOfField( i ) %></td>
  <td><%=md.isAbapObject( i )?"○":"&nbsp;" %></td>
  <td><%=md.isChanging( i )?"○":"&nbsp;" %></td>
  <td><%=md.isException( i )?"○":"&nbsp;" %></td>
  <td><%=md.isExport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isImport( i )?"○":"&nbsp;" %></td>
  <td><%=md.isNestedType1Structure( i ) ?"○":"&nbsp;" %></td>
  <td><%=md.isOptional( i )?"○":"&nbsp;" %></td>
  <td>
<%
	if( md.isTable( i ) )
	{//	JCoTable
		JCoTable	table= exportList.getTable( i );
%>  <%=table %>
<%
	}
	else if( md.isStructure( i ) )
	{//	JCoStructure
		JCoStructure	strusture= exportList.getStructure( i );
%>   <table border="1">
<%
		for( Iterator<JCoField> it= strusture.iterator(); it.hasNext(); )
		{
			JCoField	field= it.next();
%>    <tr>
     <td><%=field.getName() %></td>
     <td><%=field.getDescription() %></td>
     <td><%=field.getClassNameOfValue() %></td>
     <td><%=field.isInitialized() ? field.getValue() : "" %></td>
    </tr>
<%
		}
%>   </table>
<%
	}
	else
	{
%>  <%=exportList.isInitialized( i ) ? exportList.getValue( i ) : "" %>
<%
	}
%>  </td>
 </tr>
<%
}
%></table>
</logic:notEmpty>
<hr/>

<%
DestinationAuth	auth= (DestinationAuth)session.getAttribute( Login.SESS_ATTR_NAME_AUTH );
if( auth != null )
{
%><textarea style="width:100%; height:20em;"><%=auth.getDestination().getAttributes().getSSOTicket() %></textarea>
<%
}
%>

</body>
</html>