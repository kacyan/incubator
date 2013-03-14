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
BAPIファンクションのメタデータからサービスクラスの雛型を作ってみる習作
2013/02/14 Kac
TODO メソッドパラメータの型がJCoStructureの場合は、独自クラス名に変換する必要がある。
 --%>
<bean:parameter name="functionName" id="functionName" value=""/>
<bean:parameter name="packageName" id="packageName" value=""/>
<%
String	packageString= packageName;
if( !packageString.equals("") )
{
	packageString+= ".";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
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

	//	クラス名は、先頭大文字、_を除去、_の次を大文字、残りは小文字
	String	clsName= function.getName().toLowerCase();
	String[]	elm= clsName.split( "_" );
	clsName= "";
	for( int i= 0; i < elm.length; i++ )
	{
		if( elm[i].length() == 0 )	continue;

		clsName+= elm[i].substring(0,1).toUpperCase() + elm[i].substring(1);
	}
	//	メソッド名は、先頭小文字、_を除去、_の次を大文字、残りは小文字
	String	methodName= function.getName().toLowerCase();
	elm= clsName.split( "_" );
	methodName= elm[0];
	for( int i= 1; i < elm.length; i++ )
	{
		if( elm[i].length() == 0 )	continue;

		methodName+= elm[i].substring(0,1).toUpperCase() + elm[i].substring(1);
	}

	JCoFunctionTemplate	template= function.getFunctionTemplate();
	StringBuffer	paramsBuff= new StringBuffer();	//	メソッドのパラメータ文字列
%>
<pre>
<logic:notEmpty name="packageName">
import <%=packageName %>;
</logic:notEmpty>
/**
 * <%=packageString %><%=clsName %>
 */
public interface <%=clsName %> {

	/**
	 * <%=methodName %>
<%	//	inパラメータ
	JCoListMetaData	md= template.getImportParameterList();
	if( md != null )
	{
		for( int i= 0; i < md.getFieldCount(); i++ )
		{//
			if( md.isStructure(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else if( md.isTable(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else
			{
				paramsBuff.append( md.getClassNameOfField(i) +" "+ md.getName(i) +", " );
			}
%>	 * @param <%=md.getName(i) %> <%=md.getDescription(i) %> <%=md.isImport(i)?"(in) ":"" %><%=md.isExport(i)?"(out) ":"" %><%=md.isOptional(i)?"(option) ":"(must) " %><%=md.isChanging(i)?"(changing) ":"" %>
<%
		}
	}
	//	outパラメータのメタデータからフィールド変数を生成する
	md= template.getExportParameterList();
	if( md != null )
	{
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			if( md.isStructure(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else if( md.isTable(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else
			{
				paramsBuff.append( md.getClassNameOfField(i) +" "+ md.getName(i) +", " );
			}
%>	 * @param <%=md.getName(i) %> <%=md.getDescription(i) %> <%=md.isImport(i)?"(in) ":"" %><%=md.isExport(i)?"(out) ":"" %><%=md.isOptional(i)?"(option) ":"(must) " %><%=md.isChanging(i)?"(changing) ":"" %>
<%
		}
	}
	//	changeパラメータからフィールド変数を生成する
	md= template.getChangingParameterList();
	if( md != null )
	{
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			if( md.isStructure(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else if( md.isTable(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else
			{
				paramsBuff.append( md.getClassNameOfField(i) +" "+ md.getName(i) +", " );
			}
%>	 * @param <%=md.getName(i) %> <%=md.getDescription(i) %> <%=md.isImport(i)?"(in) ":"" %><%=md.isExport(i)?"(out) ":"" %><%=md.isOptional(i)?"(option) ":"(must) " %><%=md.isChanging(i)?"(changing) ":"" %>
<%
		}
	}
	//	tableパラメータからフィールド変数を生成する
	md= template.getTableParameterList();
	if( md != null )
	{
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			if( md.isStructure(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else if( md.isTable(i) )
			{//	JCoStructure
				paramsBuff.append( packageString + md.getName(i) +" "+ md.getName(i) +", " );
			}
			else
			{
				paramsBuff.append( md.getClassNameOfField(i) +" "+ md.getName(i) +", " );
			}
%>	 * @param <%=md.getName(i) %> <%=md.getDescription(i) %> <%=md.isImport(i)?"(in) ":"" %><%=md.isExport(i)?"(out) ":"" %><%=md.isOptional(i)?"(option) ":"(must) " %><%=md.isChanging(i)?"(changing) ":"" %>
<%
		}
	}
	String	params= paramsBuff.toString().replaceFirst( ", \\z", "" );

%>	 * @since <%=new java.util.Date() %>
	 */
	public void <%=methodName %>( <%=params %> );
</pre>
}
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