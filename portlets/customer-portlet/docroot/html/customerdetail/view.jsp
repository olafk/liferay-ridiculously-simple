<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="org.xmlportletfactory.olafk.customer.model.Customer"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
	Customer customer = (Customer) request.getAttribute("customer");
	if(customer != null) {
		customer = customer.toEscapedModel();
%>
	<h2><%=customer.getName() %></h2>
	<p>
	Street: <%=customer.getStreet() %><br/>
	City: <%=customer.getZip() %> <%=customer.getCity() %><br/>
	</p>
<%	
	}
%>