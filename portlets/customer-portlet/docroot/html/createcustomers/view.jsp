<%@page import="org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL var="actionURL"/>

<aui:form action="<%=actionURL%>" method="post">
	<aui:fieldset>
		<aui:input type="text" name="count" value="10" label="Create how many random customers?"/>
		<aui:button type="submit" />
	</aui:fieldset>
</aui:form>

Currently we have <%=CustomerLocalServiceUtil.getCustomersCount()%> Customers in the database.