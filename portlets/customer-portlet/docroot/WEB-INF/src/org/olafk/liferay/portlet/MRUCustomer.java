package org.olafk.liferay.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.xmlportletfactory.olafk.customer.model.Customer;
import org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil;

/**
 * Portlet implementation class MRUCustomer
 */
public class MRUCustomer extends MVCPortlet {
 
	@ProcessEvent(qname="{http://liferay.com/events}Customer.customerId")
	public void recieveEvent(EventRequest request, EventResponse response) throws Exception {
		Event event = request.getEvent();
		String customerId = (String)event.getValue();
		PortletSession portletSession = request.getPortletSession();
		List<String>mruCustomers = (List<String>) portletSession.getAttribute("mruCustomerIds");
		if(mruCustomers == null) {
			mruCustomers = new LinkedList<String>();
		}
		mruCustomers.remove(customerId);
		
		mruCustomers.add(0, customerId);
		if(mruCustomers.size()>5) {
			mruCustomers.remove(mruCustomers.size()-1);
		}
		portletSession.setAttribute("mruCustomerIds", mruCustomers);
	}
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletSession portletSession = renderRequest.getPortletSession();
		List<String>mruCustomers = (List<String>) portletSession.getAttribute("mruCustomerIds");
		if(mruCustomers == null) {
			mruCustomers = new LinkedList<String>();
		}
		ArrayList<Customer> customers = new ArrayList<Customer>();
		for(String customerId : mruCustomers) {
			try {
				customers.add(CustomerLocalServiceUtil.getCustomer(Long.valueOf(customerId)));
			} catch (NumberFormatException | PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
		renderRequest.setAttribute("customers", customers);
		super.doView(renderRequest, renderResponse);
	}

	// Code added after the Broadcast:
	
	// Action Handler
	public void chooseCustomer(ActionRequest request,
			ActionResponse response) {
    	QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
    	response.setEvent(qNameCustomer, ParamUtil.getString(request, "customerId"));
	}

	
}
