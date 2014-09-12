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
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>



<jsp:useBean class="java.lang.String" id="editCustomerURL" scope="request" />
<jsp:useBean id="customer" type="org.xmlportletfactory.olafk.customer.model.Customer" scope="request"/>
<jsp:useBean id="editType" class="java.lang.String" scope="request"/>


<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>


<liferay-ui:success key="customers-added-successfully" message="customers-added-successfully" />
<aui:form name="addCustomer" action="<%=editCustomerURL %>" method="post">

	<aui:input type="hidden" name="resourcePrimKey" value="<%=customer.getPrimaryKey() %>"/>
	<c:if test='<%= "add".equals(editType) %>'>
    	<aui:input type="hidden" name="addGuestPermissions" value="true"/>
    	<aui:input type="hidden" name="addGroupPermissions" value="true"/>
	</c:if>

	<aui:model-context bean="<%= customer %>" model="<%= Customer.class %>" />

	<aui:fieldset>


<% String requiredLabel=""; %>


	<% requiredLabel ="*"; %>
			<aui:input name="name" disabled="false" label='<%= LanguageUtil.get(pageContext, "customers-name") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="customers-name-required" message="customers-name-required" />

			<aui:input name="street" disabled="false" label='<%= LanguageUtil.get(pageContext, "customers-street") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="customers-street-required" message="customers-street-required" />

			<aui:input name="city" disabled="false" label='<%= LanguageUtil.get(pageContext, "customers-city") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="customers-city-required" message="customers-city-required" />

			<aui:input name="zip" disabled="false" label='<%= LanguageUtil.get(pageContext, "customers-zip") + requiredLabel %>'/>



<% requiredLabel =""; %>


				<liferay-ui:error key="customers-zip-required" message="customers-zip-required" />

   
	<!-- </table> -->

	<aui:button-row>
<% String publishButtonLabel = "submit"; %>

		<aui:button type="submit" value="<%=publishButtonLabel %>" />
		<aui:button onClick="<%= redirect %>" type="cancel"/>
	</aui:button-row>

	</aui:fieldset>

</aui:form>


