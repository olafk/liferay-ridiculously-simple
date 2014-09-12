<%@page import="org.xmlportletfactory.olafk.customer.model.Customer"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h2>Recently Used:</h2>

<ul>
	<% List<Customer> customers = (List<Customer>)request.getAttribute("customers");
	for(Customer customer: customers) {
		customer = customer.toEscapedModel();
%>

<!-- added after the broadcast: Generate a link to the portlet action
     and make use of it in the li tag -->
	<portlet:actionURL name="chooseCustomer" var="chooseCustomerURL">
		<portlet:param name="customerId" value="<%=String.valueOf(customer.getCustomerId()) %>"/>
	</portlet:actionURL>

	<li>
		<a href="<%=chooseCustomerURL %>">
			<%=customer.getName() + ", " + customer.getCity() %>
		</a>
	</li>

<%		
	}
%>
</ul>