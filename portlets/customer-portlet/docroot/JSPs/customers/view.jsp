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

<%@ page import="org.xmlportletfactory.olafk.customer.model.Customer" %>
<%@ page import="org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil" %>

<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="org.xmlportletfactory.olafk.customer.CustomerComparator" %>
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>


<jsp:useBean id="addCustomerURL" class="java.lang.String" scope="request" />
<jsp:useBean id="customersFilterURL" class="java.lang.String" scope="request" />
<jsp:useBean id="customersFilter" class="java.lang.String" scope="request" />
<liferay-ui:success key="prefs-success" message="prefs-success" />
<liferay-ui:success key="customers-added-successfully" message="customers-added-successfully" />
<liferay-ui:success key="customers-deleted-successfully" message="customers-deleted-successfully" />
<liferay-ui:success key="customers-updated-successfully" message="customers-updated-successfully" />
<liferay-ui:error key="customers-error-deleting" message="customers-error-deleting" />
<liferay-ui:error key="permission-error" message="permission-error" />


<aui:nav-bar>
	<aui:nav>		
<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasAddPermission") %>'>
		<aui:nav-item name="addcustomersButton" href="<%=addCustomerURL %>" label="customers-add"/>
	</c:when>
</c:choose>

<c:choose>
	<c:when test='<%= (Boolean)request.getAttribute("hasModelPermissions") %>'>
		<liferay-security:permissionsURL
			modelResource="org.xmlportletfactory.olafk.customer.Customer"
			modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
			resourcePrimKey="<%= String.valueOf(themeDisplay.getScopeGroupId()) %>"
			var="modelPermissionsURL"
		/>
		<aui:nav-item name="addcustomersButton" href="<%= modelPermissionsURL %>" label="permissions"/>
	</c:when>
</c:choose>
	</aui:nav>

<aui:form name="customersFilterForm" action="<%=customersFilterURL %>" method="post">
	<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search id="customersFilter" name="customersFilter" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
				</div>
	</aui:nav-bar-search>
</aui:form>
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
		portalPrefs.setValue("customers_order", "customers-order-by-col", orderByCol);
		portalPrefs.setValue("customers_order", "customers-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("customers_order", "customers-order-by-col", "customerId");
		orderByType = portalPrefs.getValue("customers_order", "customers-order-by-type", "asc");
	}

	List<Customer> tempResults = (List<Customer>)request.getAttribute("tempResults");
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
<liferay-ui:search-container deltaConfigurable="false" delta='<%= rows_per_page %>' emptyResultsMessage="customers-empty-results-message" orderByCol="<%= orderByCol%>" orderByType="<%= orderByType%>">
	<liferay-ui:search-container-results total="<%= totalCount %>" results="<%= tempResults %>">

		<%
		request.setAttribute("containerStart",String.valueOf(containerStart));
		request.setAttribute("containerEnd",String.valueOf(containerEnd));
		request.setAttribute("orderByCol", orderByCol);
		request.setAttribute("orderByType", orderByType);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="org.xmlportletfactory.olafk.customer.model.Customer"
		keyProperty="customerId"
		modelVar="customer"
	>

            <liferay-ui:search-container-column-jsp
                    align="left"
                    path="/JSPs/customers/view_action.jsp"
            />
		<liferay-ui:search-container-column-text
			name="Id"
		    property="customerId"
			orderable="true"
			orderableProperty="customerId"
			align="right"
		/>
		<liferay-ui:search-container-column-text
			name="Name"
		    property="name"
			orderable="true"
			orderableProperty="name"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="Street"
		    property="street"
			orderable="true"
			orderableProperty="street"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="City"
		    property="city"
			orderable="true"
			orderableProperty="city"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="Zip"
		    property="zip"
			orderable="true"
			orderableProperty="zip"
			align="left"
		/>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/JSPs/customers/edit_actions.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
