package org.olafk.liferay.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.xmlportletfactory.olafk.customer.model.Customer;
import org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil;

/**
 * Portlet implementation class CustomerDetailPortlet
 */
public class CustomerDetailPortlet extends MVCPortlet {
	
	@ProcessEvent(qname="{http://liferay.com/events}Customer.customerId")
	public void recieveEvent(EventRequest request, EventResponse response) throws Exception {
		Event event = request.getEvent();
		String customerId = (String)event.getValue();
		request.getPortletSession().setAttribute("customerId",customerId);
		response.setRenderParameter("customerId", customerId);
	}

	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String customerId = renderRequest.getParameter("customerId");
		if(customerId != null) {
			try {
				Customer customer = CustomerLocalServiceUtil.getCustomer(Long.valueOf(customerId));
				renderRequest.setAttribute("customer", customer);
			} catch (NumberFormatException | PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
		
		super.doView(renderRequest, renderResponse);
	}
}
