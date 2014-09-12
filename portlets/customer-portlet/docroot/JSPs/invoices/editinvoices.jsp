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
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>



<jsp:useBean class="java.lang.String" id="editInvoicesURL" scope="request" />
<jsp:useBean id="invoices" type="org.xmlportletfactory.olafk.customer.model.Invoices" scope="request"/>
<jsp:useBean id="editType" class="java.lang.String" scope="request"/>


<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>


<liferay-ui:success key="invoices-added-successfully" message="invoices-added-successfully" />
<aui:form name="addInvoices" action="<%=editInvoicesURL %>" method="post">

	<aui:input type="hidden" name="resourcePrimKey" value="<%=invoices.getPrimaryKey() %>"/>
	<c:if test='<%= "add".equals(editType) %>'>
    	<aui:input type="hidden" name="addGuestPermissions" value="true"/>
    	<aui:input type="hidden" name="addGroupPermissions" value="true"/>
	</c:if>
	<aui:input type="hidden" name="customerId" value="<%=invoices.getCustomerId() %>"/>

	<aui:model-context bean="<%= invoices %>" model="<%= Invoices.class %>" />

	<aui:fieldset>


<% String requiredLabel=""; %>


			<aui:input name="customerId" disabled="true" label='<%= LanguageUtil.get(pageContext, "invoices-customerid") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="invoices-customerid-required" message="invoices-customerid-required" />
				<liferay-ui:error key="error_number_format" message="error_number_format" />

	<% requiredLabel ="*"; %>
			<aui:input name="date" disabled="false" label='<%= LanguageUtil.get(pageContext, "invoices-date") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="invoices-date-required" message="invoices-date-required" />

	<% requiredLabel ="*"; %>
			<aui:input name="amount" disabled="false" label='<%= LanguageUtil.get(pageContext, "invoices-amount") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="invoices-amount-required" message="invoices-amount-required" />
				<liferay-ui:error key="error_number_format" message="error_number_format" />

			<aui:input name="paid" disabled="false" label='<%= LanguageUtil.get(pageContext, "invoices-paid") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="invoices-paid-required" message="invoices-paid-required" />

   
	<!-- </table> -->

	<aui:button-row>
<% String publishButtonLabel = "submit"; %>

		<aui:button type="submit" value="<%=publishButtonLabel %>" />
		<aui:button onClick="<%= redirect %>" type="cancel"/>
	</aui:button-row>

	</aui:fieldset>

</aui:form>


