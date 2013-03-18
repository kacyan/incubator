<%@page import="java.io.PrintWriter"%>
<%@page import="com.sap.conn.jco.ext.Environment"%>
<%@page import="jp.co.ksi.sap.incubator.UserDestinationDataProvider"%>
<%@	page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="ksi.tld" prefix="ksi" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<%--
2013/03/15
Environmentを表示します。
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<h1>Environment</h1>

<table>
 <tr>
  <th>inDW</th>
  <td><%=Environment.inDW() %></td>
 </tr>
 <tr>
  <th>inDWJ</th>
  <td><%=Environment.inDWJ() %></td>
 </tr>
 <tr>
  <th>inEclipsePlugin</th>
  <td><%=Environment.inEclipsePlugin() %></td>
 </tr>
 <tr>
  <th>inJStartup</th>
  <td><%=Environment.inJStartup() %></td>
 </tr>
 <tr>
  <th>inJTS</th>
  <td><%=Environment.inJTS() %></td>
 </tr>
 <tr>
  <th>inSAPJ2EE</th>
  <td><%=Environment.inSAPJ2EE() %></td>
 </tr>
 <tr>
  <th>inSAPVM</th>
  <td><%=Environment.inSAPVM() %></td>
 </tr>
 <tr>
  <th>inStandalone</th>
  <td><%=Environment.inStandalone() %></td>
 </tr>
 <tr>
  <th>isClientPassportManagerRegistered</th>
  <td><%=Environment.isClientPassportManagerRegistered() %></td>
 </tr>
 <tr>
  <th>isDestinationDataProviderRegistered</th>
  <td><%=Environment.isDestinationDataProviderRegistered() %></td>
 </tr>
 <tr>
  <th>isPasswordChangeHandlerRegistered</th>
  <td><%=Environment.isPasswordChangeHandlerRegistered() %></td>
 </tr>
 <tr>
  <th>isServerDataProviderRegistered</th>
  <td><%=Environment.isServerDataProviderRegistered() %></td>
 </tr>
 <tr>
  <th>isServerPassportManagerRegistered</th>
  <td><%=Environment.isServerPassportManagerRegistered() %></td>
 </tr>
 <tr>
  <th>isSessionReferenceProviderRegistered</th>
  <td><%=Environment.isSessionReferenceProviderRegistered() %></td>
 </tr>
</table>

</body>
</html>
