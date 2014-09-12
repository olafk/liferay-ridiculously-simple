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
 
 

package org.xmlportletfactory.olafk.customer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletConfig;
import javax.xml.namespace.QName;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.dao.search.SearchContainer;

import org.xmlportletfactory.olafk.customer.model.Customer;
import org.xmlportletfactory.olafk.customer.model.impl.CustomerImpl;
import org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil;
import org.xmlportletfactory.olafk.customer.service.permission.CustomerPermission;
import org.xmlportletfactory.olafk.customer.service.permission.CustomerEntryPermission;
// needed for Customer detail-file Invoices
import org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil;


import org.xmlportletfactory.olafk.customer.util.CustomerUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class Customer
 */
public class CustomerPortlet extends MVCPortlet {

	@ProcessEvent(qname="{http://liferay.com/events}Customer.customerId")
	public void recieveEvent(EventRequest request, EventResponse response) throws Exception {
		Event event = request.getEvent();
		String customerId = (String)event.getValue();
		request.getPortletSession().setAttribute("customerId",customerId);
		response.setRenderParameter("highlightRowWithKey", customerId);
	}

	public void init() throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		helpJSP = getInitParameter("help-jsp");

		// View Mode Pages
		viewJSP = getInitParameter("view-jsp");

		// View Mode Edit Customer
		editcustomersJSP = getInitParameter("edit-customers-jsp");

		// View Mode Entry Customer
		viewcustomersJSP = getInitParameter("view-customers-jsp");
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			// do nothing
			// _log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String jsp = (String) renderRequest.getParameter("view");
		if (jsp == null || jsp.equals("")) {
			showViewDefault(renderRequest, renderResponse);
		} else if (jsp.equalsIgnoreCase("editCustomer")) {
			try {
				showViewEditCustomer(renderRequest, renderResponse);
			} catch (Exception ex) {
				_log.debug(ex);
				try {
					showViewDefault(renderRequest, renderResponse);
				} catch (Exception ex1) {
					_log.debug(ex1);
				}
			}
		}
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		showEditDefault(renderRequest, renderResponse);
	}

	public void doHelp(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		include(helpJSP, renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	public void showViewDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		boolean hasAddPermission = CustomerPermission.contains(permissionChecker, groupId, "ADD_CUSTOMER");

		boolean hasModelPermissions = CustomerPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS);

		List<Customer> tempResults = Collections.EMPTY_LIST;

		PortletPreferences prefs = renderRequest.getPreferences();

		String customersFilter = ParamUtil.getString(renderRequest, "customersFilter");

		String rowsPerPage = prefs.getValue("rows-per-page","5");
		String viewType = prefs.getValue("view-type", "0");

		Integer cur = 1;
		int containerStart = 0;
		int containerEnd = 0;
		String orderByType = renderRequest.getParameter("orderByType");
		String orderByCol = renderRequest.getParameter("orderByCol");
		try{
			cur = ParamUtil.getInteger(renderRequest, "cur");

		}catch (Exception e){
			cur = 1;
		}

		if (cur < 1){
			cur = 1;
		}

		if (Validator.isNotNull(customersFilter) || !customersFilter.equalsIgnoreCase("")) {
			rowsPerPage = "100";
			cur = 1;
		}

		containerStart = (cur - 1) * Integer.parseInt(rowsPerPage);
		containerEnd = containerStart + Integer.parseInt(rowsPerPage);

		int total = 0;
		try {
			PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			if (Validator.isNull(orderByCol) && Validator.isNull(orderByType)) {
				orderByCol = portalPrefs.getValue("Customer_order", "Customer-order-by-col", "customerId");
				orderByType = portalPrefs.getValue("Customer_order", "Customer-order-by-type", "asc");
			}
			OrderByComparator comparator = CustomerComparator.getCustomerOrderByComparator(orderByCol,orderByType);


			if (customersFilter.equalsIgnoreCase("")) {

				if (viewType.equals("0")){
					tempResults = CustomerLocalServiceUtil.findAllInGroup(groupId, containerStart, containerEnd, comparator);
					total = CustomerLocalServiceUtil.countAllInGroup(groupId);								
				}else if (viewType.equals("1")){
					tempResults = CustomerLocalServiceUtil.findAllInUser(themeDisplay.getUserId(), containerStart, containerEnd, comparator);
					total = CustomerLocalServiceUtil.countAllInUser(themeDisplay.getUserId());
				}else{
					tempResults = CustomerLocalServiceUtil.findAllInUserAndGroup(themeDisplay.getUserId(), groupId, containerStart, containerEnd, comparator);
					total = CustomerLocalServiceUtil.countAllInUserAndGroup(themeDisplay.getUserId(), groupId);
				}

			} else {

				Indexer indexer = IndexerRegistryUtil.getIndexer(Customer.class);

				SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));

				searchContext.setEnd(containerEnd);
				searchContext.setKeywords(customersFilter);
				searchContext.setStart(containerStart);

				Hits results = indexer.search(searchContext);

				total = results.getLength();

				if (total > 0) {
					tempResults = new ArrayList<Customer>(total);
				}
				for (int i = 0; i < results.getDocs().length; i++) {
					Document doc = results.doc(i);

					Customer resReg = null;

					// Entry
					long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

					try {
						resReg = CustomerLocalServiceUtil.getCustomer(entryId);

						resReg = resReg.toEscapedModel();

						tempResults.add(resReg);
					}
					catch (Exception e) {
						if (_log.isWarnEnabled()) {
							_log.warn("Customer search index is stale and contains entry " + entryId);
						}

						continue;
					}
				}
			}

		} catch (Exception e) {
			_log.debug(e);
		}
		renderRequest.setAttribute("highlightRowWithKey", renderRequest.getParameter("highlightRowWithKey"));
		renderRequest.setAttribute("containerStart", containerStart);
		renderRequest.setAttribute("containerEnd", containerEnd);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("tempResults", tempResults);
		renderRequest.setAttribute("totalCount", total);
		renderRequest.setAttribute("rowsPerPage", rowsPerPage);
		renderRequest.setAttribute("hasAddPermission", hasAddPermission);
		renderRequest.setAttribute("hasModelPermissions", hasModelPermissions);
		renderRequest.setAttribute("orderByType", orderByType);
		renderRequest.setAttribute("orderByCol", orderByCol);		
		renderRequest.setAttribute("customersFilter", customersFilter);

		PortletURL addCustomerURL = renderResponse.createActionURL();
		addCustomerURL.setParameter("javax.portlet.action", "newCustomer");
		renderRequest.setAttribute("addCustomerURL", addCustomerURL.toString());

		PortletURL customersFilterURL = renderResponse.createRenderURL();
		customersFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("customersFilterURL", customersFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void showViewEditCustomer(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		PortletURL editCustomerURL = renderResponse.createActionURL();
		String editType = (String) renderRequest.getParameter("editType");

		Customer customer = null;
		boolean viewEntryMode=false;
		if (editType.equalsIgnoreCase("edit")) {
			
			editCustomerURL.setParameter("javax.portlet.action", "updateCustomer");

			long $fname = Long.parseLong(renderRequest.getParameter("customerId"));
			customer = CustomerLocalServiceUtil.getCustomer($fname);

			if (!CustomerEntryPermission.contains(
				permissionChecker, customer, ActionKeys.UPDATE)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}

            	     	renderRequest.setAttribute("customer", customer);
		} else if (editType.equalsIgnoreCase("view")) {

			viewEntryMode= true;

			long $fname = Long.parseLong(renderRequest.getParameter("customerId"));
			customer = CustomerLocalServiceUtil.getCustomer($fname);


			if (!CustomerEntryPermission.contains(
				permissionChecker, customer, ActionKeys.VIEW)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}
			
			renderRequest.setAttribute("customer", customer);
		} else {

			if (!CustomerPermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_CUSTOMER")){	
						SessionErrors.add(renderRequest, "permission-error");
						return;
	    		}

			editCustomerURL.setParameter("javax.portlet.action", "addCustomer");
			Customer errorCustomer = (Customer) renderRequest.getAttribute("errorCustomer");
			if (errorCustomer != null) {
				if (editType.equalsIgnoreCase("update")) {
					editCustomerURL.setParameter("javax.portlet.action", "updateCustomer");
                		}
				renderRequest.setAttribute("customer", errorCustomer);

			} else {				
				
				Customer addCustomer = null;


				if (Validator.isNull(renderRequest.getParameter("addErrors"))){
				
					addCustomer = new CustomerImpl();
					addCustomer.setCustomerId(0);
					addCustomer.setName("");
					addCustomer.setStreet("");
					addCustomer.setCity("");
					addCustomer.setZip("");
				}else{
					addCustomer = CustomerFromRequest(renderRequest);
				}
				renderRequest.setAttribute("customer", addCustomer);
			}

		}		

        renderRequest.setAttribute("editType", editType);

		if (!viewEntryMode){
			renderRequest.setAttribute("editCustomerURL", editCustomerURL.toString());		
			include(editcustomersJSP, renderRequest, renderResponse);
		}else{
			include(viewcustomersJSP, renderRequest, renderResponse);
		}
	}

	private String dateToJsp(ActionRequest request, Date date) {
		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}
	private String dateToJsp(RenderRequest request, Date date) {
		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}
	private String dateToJsp(PortletPreferences prefs, Date date) {
		SimpleDateFormat format = new SimpleDateFormat(prefs.getValue("date-format", "yyyy/MM/dd"));
		String stringDate = format.format(date);
		return stringDate;
	}
	private String dateTimeToJsp(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String stringDate = format.format(date);
		return stringDate;
	}

	public void showEditDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		include(editJSP, renderRequest, renderResponse);
	}

	/* Portlet Actions */

	@ProcessAction(name = "newCustomer")
	public void newCustomer(ActionRequest request, ActionResponse response) throws Exception{
		CustomerUtil.addParametersForAdd(response);
		response.setRenderParameter("customerId", "0");
        	QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
        	response.setEvent(qNameCustomer, ParamUtil.getString(request, "customerId"));
	}

	@ProcessAction(name = "addCustomer")
	public void addCustomer(ActionRequest request, ActionResponse response) throws Exception {
            Customer customer = CustomerFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!CustomerPermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_CUSTOMER")){	
				CustomerUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	    }
            ArrayList<String> errors = CustomerValidator.validateCustomer(customer, request);

            if (errors.isEmpty()) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Customer.class.getName(), request);
			CustomerLocalServiceUtil.addCustomer(customer, serviceContext);

			CustomerUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "customers-added-successfully");
		        response.setRenderParameter("customerId", "0");
                	QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
                	response.setEvent(qNameCustomer, ParamUtil.getString(request, "customerId"));

            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
			PortalUtil.copyRequestParameters(request, response);			
			CustomerUtil.addParametersForAddWithErrors(response);		
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
		PortalUtil.copyRequestParameters(request, response);			
		CustomerUtil.addParametersForAddWithErrors(response);	
            }
	}

	@ProcessAction(name = "eventCustomer")
	public void eventCustomer(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		int containerStart = ParamUtil.getInteger(request, "containerStart");
		int containerEnd = ParamUtil.getInteger(request, "containerEnd");
		int cur = ParamUtil.getInteger(request, "cur");
		String orderByType = ParamUtil.getString(request, "orderByType");
		String orderByCol = ParamUtil.getString(request, "orderByCol");
		String customerFilter = ParamUtil.getString(request, "CustomerFilter");
		if (Validator.isNotNull(key)) {
            		response.setRenderParameter("highlightRowWithKey", Long.toString(key));
            		response.setRenderParameter("containerStart", Integer.toString(containerStart));
            		response.setRenderParameter("containerEnd", Integer.toString(containerEnd));
			response.setRenderParameter("cur", Integer.toString(cur));
			response.setRenderParameter("orderByType", orderByType);
			response.setRenderParameter("orderByCol", orderByCol);
			response.setRenderParameter("CustomerFilter", customerFilter);
            		QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
            		response.setEvent(qNameCustomer, ParamUtil.getString(request, "customerId"));
		}
	}

	@ProcessAction(name = "editCustomer")

	public void editCustomer(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(key)) {
			CustomerUtil.addParametersForEdit(response, key);
			
            		QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
            		response.setEvent(qNameCustomer, ParamUtil.getString(request, "customerId"));
		}
	}

	@ProcessAction(name = "deleteCustomer")
	public void deleteCustomer(ActionRequest request, ActionResponse response)throws Exception {		

		long id = ParamUtil.getLong(request, "resourcePrimKey");

		if (Validator.isNotNull(id)) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

			if (!CustomerEntryPermission.contains(
					permissionChecker, id, ActionKeys.DELETE)){	
				CustomerUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
			}

			Customer customer = CustomerLocalServiceUtil.getCustomer(id);
			CustomerLocalServiceUtil.deleteCustomerEntry(customer);
			SessionMessages.add(request, "customers-deleted-successfully");
            		response.setRenderParameter("customerId", "0");
            		QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
            		response.setEvent(qNameCustomer, ParamUtil.getString(request, "customerId"));
		} else {
			SessionErrors.add(request, "customers-error-deleting");
		}
	}


	@ProcessAction(name = "updateCustomer")
	public void updateCustomer(ActionRequest request, ActionResponse response) throws Exception {
            Customer customer = CustomerFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!CustomerEntryPermission.contains(
				permissionChecker, customer, ActionKeys.UPDATE)){	
				CustomerUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	     }

            ArrayList<String> errors = CustomerValidator.validateCustomer(customer, request);

            if (errors.isEmpty()) {
            	try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Customer.class.getName(), request);
                	CustomerLocalServiceUtil.updateCustomer(customer, serviceContext);

			CustomerUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "customers-updated-successfully");

		        response.setRenderParameter("customerId", "0");
                	QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
                	response.setEvent(qNameCustomer, ParamUtil.getString(request, "customerId"));
            	} catch (Exception cvex) {
            	    SessionErrors.add(request, "please-enter-a-unique-code");
		    		CustomerUtil.addParametersForEdit(response, null);
					request.setAttribute("customer",customer);
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
				CustomerUtil.addParametersForEdit(response, Long.toString(customer.getPrimaryKey()));
				request.setAttribute("customer",customer);
            }
	    	QName qNameCustomer = new QName("http://liferay.com/events", "Customer.customerId");
            response.setEvent(qNameCustomer, ParamUtil.getString(request, "0"));
        }

	@ProcessAction(name = "setCustomerPref")
	public void setCustomerPref(ActionRequest request, ActionResponse response) throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rows-per-page");
		String viewType = ParamUtil.getString(request, "view-type");
		String dateFormat = ParamUtil.getString(request, "date-format");
		String datetimeFormat = ParamUtil.getString(request, "datetime-format");

		ArrayList<String> errors = new ArrayList();
		if (CustomerValidator.validateEditCustomer(rowsPerPage, dateFormat, datetimeFormat, errors)) {
			response.setRenderParameter("rows-per-page", "");
			response.setRenderParameter("date-format", "");
			response.setRenderParameter("datetime-format", "");
			response.setRenderParameter("view-type", "");

			PortletPreferences prefs = request.getPreferences();

			prefs.setValue("rows-per-page", rowsPerPage);
			prefs.setValue("view-type", viewType);
			prefs.setValue("date-format", dateFormat);
			prefs.setValue("datetime-format", datetimeFormat);
			prefs.store();

			SessionMessages.add(request, "prefs-success");
		}
	}

	private Customer CustomerFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		CustomerImpl customer = new CustomerImpl();
        	try {
            		customer.setCustomerId(ParamUtil.getLong(request, "customerId"));
        	} catch (Exception nfe) {
		    //Controled en Validator
        	}
		customer.setName(ParamUtil.getString(request, "name"));
		customer.setStreet(ParamUtil.getString(request, "street"));
		customer.setCity(ParamUtil.getString(request, "city"));
		customer.setZip(ParamUtil.getString(request, "zip"));
		try {
		    	customer.setPrimaryKey(ParamUtil.getLong(request,"resourcePrimKey"));
		} catch (NumberFormatException nfe) {
			//Controled en Validator
        	}

		customer.setCompanyId(themeDisplay.getCompanyId());
		customer.setGroupId(themeDisplay.getScopeGroupId());
		customer.setUserId(themeDisplay.getUserId());
		return customer;
	}



	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		resourceResponse.setContentType("text/javascript");
		String resourceId = resourceRequest.getResourceID();

		if (Validator.isNotNull(resourceId) && resourceId.length() != 0) {

			if(resourceId.equalsIgnoreCase("exportFullCustomerResourceURL")) {

		    		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    		Locale locale = themeDisplay.getLocale();
		    		PortletConfig portletConfig = (PortletConfig)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		    		resourceResponse.setContentType("application/vnd.ms-excel");
		    		resourceResponse.setProperty("expires","-1d");
		    		resourceResponse.setProperty("Pragma","no-cache");
		    		resourceResponse.setProperty("Cache-control","no-cache");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" Customer\"");

				try {
					Workbook book = CustomerExporter.generateFullExcel(themeDisplay.getScopeGroupId(), portletConfig, locale);
					OutputStream out = resourceResponse.getPortletOutputStream();
					book.write(out);
					out.flush();
					out.close();
				} catch (SystemException e) {
					e.printStackTrace();
					throw new PortletException("Export Excel Error",e);
				}
			}

		}
	}

	protected String editcustomersJSP;
	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;
	protected String viewcustomersJSP;

	private static Log _log = LogFactoryUtil.getLog(CustomerPortlet.class);

}
