<%
/**
 *     Copyright (C) 2009-2014  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */
%> 
<%@include file="../init.jsp" %>

<%@ page import="org.xmlportletfactory.olafk.customer.model.Invoices"%>
<%@ page import="org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil"%>
<%@ page import="org.xmlportletfactory.olafk.customer.service.permission.InvoicesEntryPermission"%>

<%
String containerStart = (String) request.getAttribute("containerStart");
String containerEnd =  (String) request.getAttribute("containerEnd");
String orderByType = (String) request.getAttribute("orderByType");
String orderByCol =  (String) request.getAttribute("orderByCol");
Integer cur          =  (Integer) request.getAttribute("cur");
String invoicesFilter = ParamUtil.getString(request, "InvoicesFilter");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Invoices invoices = (Invoices)row.getObject();

long groupId = invoices.getGroupId();
String name = Invoices.class.getName();
String primKey = String.valueOf(invoices.getPrimaryKey());

%>
<c:if test="<%= InvoicesEntryPermission.contains(permissionChecker, invoices, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="eventInvoices" var="eventInvoicesURL">
        <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
        <portlet:param name="containerStart" value="<%= containerStart %>" />
        <portlet:param name="containerEnd" value="<%= containerEnd %>" />
		<portlet:param name="cur" value="<%= String.valueOf(cur)  %>" />
        <portlet:param name="InvoicesFilter" value="<%= invoicesFilter %>" />
    </portlet:actionURL>
<%
	if (primKey.equalsIgnoreCase((String)request.getAttribute("highlightRowWithKey"))) {
%>
    <liferay-ui:icon image="forward" url="<%=eventInvoicesURL.toString() %>" />
<%
	} else {
%>
    <liferay-ui:icon image="view" url="<%=eventInvoicesURL.toString() %>" />
<%
	}
%>
</c:if>
