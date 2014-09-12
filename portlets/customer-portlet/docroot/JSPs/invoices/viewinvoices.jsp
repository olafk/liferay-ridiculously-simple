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
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>	


<jsp:useBean class="java.lang.String" id="editInvoicesURL" scope="request" />
<jsp:useBean id="invoices" type="org.xmlportletfactory.olafk.customer.model.Invoices" scope="request"/>


<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>

<div class="entry">




			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="invoices-customerid" />
				</label>
				<span class="aui-field-element">
					<%= invoices.getCustomerId() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="invoices-date" />
				</label>
				<span class="aui-field-element">
					<%= invoices.getDate() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="invoices-amount" />
				</label>
				<span class="aui-field-element">
					<%= invoices.getAmount() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="invoices-paid" />
				</label>
				<span class="aui-field-element">
					<%= invoices.getPaid() %>
				</span>
			</span>



</div>
