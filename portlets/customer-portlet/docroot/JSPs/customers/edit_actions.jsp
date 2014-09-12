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
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@ page import="org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil" %>
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Customer customer = (Customer)row.getObject();

long groupId = customer.getGroupId();
String name = Customer.class.getName();
String primKey = String.valueOf(customer.getPrimaryKey());
boolean noDetailsRows = true;
String customerIdStr = customer.getCustomerId() + "";

	if(!InvoicesLocalServiceUtil.findAllIncustomerId(customer.getPrimaryKey()).isEmpty()) {
		noDetailsRows = false;
	}


%>
<liferay-ui:icon-menu cssClass="">

	<c:if test="<%= CustomerEntryPermission.contains(permissionChecker, customer, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="editCustomer" var="editCustomerURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey %>" />
			<portlet:param name="customerId" value="<%= customerIdStr %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="edit" url="<%=editCustomerURL.toString() %>" />
	</c:if>
	<c:if test="<%= CustomerEntryPermission.contains (permissionChecker, customer, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteCustomer" var="deleteCustomerURL">
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>
		<c:choose>
			<c:when test="<%= !noDetailsRows %>">
			<%
			String deleteUrl = null;
			deleteUrl = "javascript:if(confirm('" + UnicodeLanguageUtil.get(pageContext, "confirm-delete") + "')){submitForm(document.hrefFm, '" + HttpUtil.encodeURL(deleteCustomerURL) + "');}";
			 
			%>
			<liferay-ui:icon image="delete" url="<%=deleteUrl %>" />

			</c:when>
			<c:otherwise>
		    		<liferay-ui:icon image="delete" url="<%=deleteCustomerURL.toString() %>" />
		        </c:otherwise>
		</c:choose>
	</c:if>



<c:if test="<%= CustomerEntryPermission.contains(permissionChecker, customer, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="org.xmlportletfactory.olafk.customer.model.Customer"
			modelResourceDescription="Customer"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon
			image="permissions"
			url="<%= permissionsEntryURL %>"
		/>
</c:if>
</liferay-ui:icon-menu>
