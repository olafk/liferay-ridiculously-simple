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

<%@ page import="org.xmlportletfactory.olafk.customer.model.Invoices" %>
<%@ page import="org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil" %>

<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="org.xmlportletfactory.olafk.customer.InvoicesComparator" %>
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>


<jsp:useBean id="addInvoicesURL" class="java.lang.String" scope="request" />
<jsp:useBean id="invoicesFilterURL" class="java.lang.String" scope="request" />
<jsp:useBean id="invoicesFilter" class="java.lang.String" scope="request" />
<liferay-ui:success key="prefs-success" message="prefs-success" />
<liferay-ui:success key="invoices-added-successfully" message="invoices-added-successfully" />
<liferay-ui:success key="invoices-deleted-successfully" message="invoices-deleted-successfully" />
<liferay-ui:success key="invoices-updated-successfully" message="invoices-updated-successfully" />
<liferay-ui:error key="invoices-error-deleting" message="invoices-error-deleting" />
<liferay-ui:error key="permission-error" message="permission-error" />


<aui:nav-bar>
	<aui:nav>		
<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasAddPermission") %>'>
		<aui:nav-item name="addinvoicesButton" href="<%=addInvoicesURL %>" label="invoices-add"/>
	</c:when>
</c:choose>

<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasModelPermissions") %>'>
		<liferay-security:permissionsURL
			modelResource="org.xmlportletfactory.olafk.customer.Invoices"
			modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
			resourcePrimKey="<%= String.valueOf(themeDisplay.getScopeGroupId()) %>"
			var="modelPermissionsURL"
		/>
		<aui:nav-item name="addinvoicesButton" href="<%= modelPermissionsURL %>" label="permissions"/>
	</c:when>
</c:choose>
	</aui:nav>

</aui:nav-bar>
<%
	String iconChecked = "checked";
	String iconUnchecked = "unchecked";
	int rows_per_page = Integer.parseInt((String)request.getAttribute("rowsPerPage"));

	SimpleDateFormat dateFormat = new SimpleDateFormat(prefs.getValue("date-format", "yyyy/MM/dd"));
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat(prefs.getValue("datetime-format","yyyy/MM/dd HH:mm"));

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");

	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("invoices_order", "invoices-order-by-col", orderByCol);
		portalPrefs.setValue("invoices_order", "invoices-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("invoices_order", "invoices-order-by-col", "invoiceId");
		orderByType = portalPrefs.getValue("invoices_order", "invoices-order-by-type", "asc");
	}

	List<Invoices> tempResults = (List<Invoices>)request.getAttribute("tempResults");
	Integer totalCount = (Integer)request.getAttribute("totalCount");

	int containerStart;
	int containerEnd;
	try {
		containerStart = ParamUtil.getInteger(request, "containerStart");
		containerEnd = ParamUtil.getInteger(request, "containerEnd");
	} catch (Exception e) {
		containerStart = 0;
		containerEnd = rows_per_page;
	}

%>
<liferay-ui:search-container deltaConfigurable="false" delta='<%= rows_per_page %>' emptyResultsMessage="invoices-empty-results-message" orderByCol="<%= orderByCol%>" orderByType="<%= orderByType%>">
	<liferay-ui:search-container-results total="<%= totalCount %>" results="<%= tempResults %>">

		<%
		request.setAttribute("containerStart",String.valueOf(containerStart));
		request.setAttribute("containerEnd",String.valueOf(containerEnd));
		request.setAttribute("orderByCol", orderByCol);
		request.setAttribute("orderByType", orderByType);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="org.xmlportletfactory.olafk.customer.model.Invoices"
		keyProperty="invoiceId"
		modelVar="invoices"
	>

		<liferay-ui:search-container-column-text
			name="Id"
		    property="invoiceId"
			align="right"
		/>
		<liferay-ui:search-container-column-text
			name="Date"
			value="<%= dateFormat.format(invoices.getDate()) %>"
			align="center"
		/>
		<liferay-ui:search-container-column-text
			name="Amount"
		    property="amount"
			align="right"
		/>
		<liferay-ui:search-container-column-text name="Paid"	align="center" >
			 <%
 				String paidIcon = iconUnchecked;
  				if (invoices.isPaid()) {
 					paidIcon = iconChecked;
 				}
 			  %>
			<liferay-ui:icon image="<%=paidIcon %>"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/JSPs/invoices/edit_actions.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
