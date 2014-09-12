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

<%@ page import="org.xmlportletfactory.olafk.customer.model.Customer"%>
<%@ page import="org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil"%>
<%@ page import="org.xmlportletfactory.olafk.customer.service.permission.CustomerEntryPermission"%>

<%
String containerStart = (String) request.getAttribute("containerStart");
String containerEnd =  (String) request.getAttribute("containerEnd");
String orderByType = (String) request.getAttribute("orderByType");
String orderByCol =  (String) request.getAttribute("orderByCol");
Integer cur          =  (Integer) request.getAttribute("cur");
String customerFilter = ParamUtil.getString(request, "CustomerFilter");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Customer customer = (Customer)row.getObject();

long groupId = customer.getGroupId();
String name = Customer.class.getName();
String primKey = String.valueOf(customer.getPrimaryKey());
String customerIdStr = customer.getCustomerId() + "";

%>
<c:if test="<%= CustomerEntryPermission.contains(permissionChecker, customer, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="eventCustomer" var="eventCustomerURL">
        <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
        <portlet:param name="containerStart" value="<%= containerStart %>" />
        <portlet:param name="containerEnd" value="<%= containerEnd %>" />
		<portlet:param name="cur" value="<%= String.valueOf(cur)  %>" />
        <portlet:param name="CustomerFilter" value="<%= customerFilter %>" />
        <portlet:param name="customerId" value="<%= customerIdStr %>" />
    </portlet:actionURL>
<%
	if (primKey.equalsIgnoreCase((String)request.getAttribute("highlightRowWithKey"))) {
%>
    <liferay-ui:icon image="forward" url="<%=eventCustomerURL.toString() %>" />
<%
	} else {
%>
    <liferay-ui:icon image="view" url="<%=eventCustomerURL.toString() %>" />
<%
	}
%>
</c:if>
