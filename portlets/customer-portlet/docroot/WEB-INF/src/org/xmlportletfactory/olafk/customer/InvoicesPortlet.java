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

import org.xmlportletfactory.olafk.customer.model.Invoices;
import org.xmlportletfactory.olafk.customer.model.impl.InvoicesImpl;
import org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil;
import org.xmlportletfactory.olafk.customer.service.permission.InvoicesPermission;
import org.xmlportletfactory.olafk.customer.service.permission.InvoicesEntryPermission;

import org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil;
import org.xmlportletfactory.olafk.customer.model.Customer;

import org.xmlportletfactory.olafk.customer.util.InvoicesUtil;

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
 * Portlet implementation class Invoices
 */
public class InvoicesPortlet extends MVCPortlet {



	public void init() throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		helpJSP = getInitParameter("help-jsp");

		// View Mode Pages
		viewJSP = getInitParameter("view-jsp");

		// View Mode Edit Invoices
		editinvoicesJSP = getInitParameter("edit-invoices-jsp");

		// View Mode Entry Invoices
		viewinvoicesJSP = getInitParameter("view-invoices-jsp");
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
		} else if (jsp.equalsIgnoreCase("editInvoices")) {
			try {
				showViewEditInvoices(renderRequest, renderResponse);
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

		boolean hasAddPermission = InvoicesPermission.contains(permissionChecker, groupId, "ADD_INVOICES");

		boolean hasModelPermissions = InvoicesPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS);

		List<Invoices> tempResults = Collections.EMPTY_LIST;

		PortletPreferences prefs = renderRequest.getPreferences();

		String invoicesFilter = ParamUtil.getString(renderRequest, "invoicesFilter");

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

		if (Validator.isNotNull(invoicesFilter) || !invoicesFilter.equalsIgnoreCase("")) {
			rowsPerPage = "100";
			cur = 1;
		}

		containerStart = (cur - 1) * Integer.parseInt(rowsPerPage);
		containerEnd = containerStart + Integer.parseInt(rowsPerPage);

		int total = 0;
		long customerId = 0;
		String customerIdStr = renderRequest.getPortletSession().getAttribute("customerId")+ "";

		try {
			Customer customer = CustomerLocalServiceUtil.fetchCustomer(Long.parseLong(customerIdStr));
			if (!customerIdStr.trim().equalsIgnoreCase("") && Validator.isNotNull(customer)){
				customerId = Long.parseLong(customerIdStr);
			}
		} catch (Exception e) {
			customerId = 0;
		}

		try {
			OrderByComparator comparator = InvoicesComparator.getInvoicesOrderByComparator(orderByCol,orderByType);
			tempResults = InvoicesLocalServiceUtil.findAllIncustomerIdGroup(customerId, groupId,comparator);
		} catch (Exception e) {
			_log.debug(e);
		}
        	if (customerId == 0) {
            		hasAddPermission = false;
        	} else {
            		renderRequest.getPortletSession().setAttribute("INVOICEScustomerId", customerId);
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
		renderRequest.setAttribute("invoicesFilter", invoicesFilter);

		PortletURL addInvoicesURL = renderResponse.createActionURL();
		addInvoicesURL.setParameter("javax.portlet.action", "newInvoices");
		renderRequest.setAttribute("addInvoicesURL", addInvoicesURL.toString());

		PortletURL invoicesFilterURL = renderResponse.createRenderURL();
		invoicesFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("invoicesFilterURL", invoicesFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void showViewEditInvoices(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		PortletURL editInvoicesURL = renderResponse.createActionURL();
		String editType = (String) renderRequest.getParameter("editType");

		Invoices invoices = null;
		boolean viewEntryMode=false;
		if (editType.equalsIgnoreCase("edit")) {
			
			editInvoicesURL.setParameter("javax.portlet.action", "updateInvoices");

			long $fname = Long.parseLong(renderRequest.getParameter("invoiceId"));
			invoices = InvoicesLocalServiceUtil.getInvoices($fname);

			if (!InvoicesEntryPermission.contains(
				permissionChecker, invoices, ActionKeys.UPDATE)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}

            	     	renderRequest.setAttribute("invoices", invoices);
		} else if (editType.equalsIgnoreCase("view")) {

			viewEntryMode= true;

			long $fname = Long.parseLong(renderRequest.getParameter("invoiceId"));
			invoices = InvoicesLocalServiceUtil.getInvoices($fname);


			if (!InvoicesEntryPermission.contains(
				permissionChecker, invoices, ActionKeys.VIEW)){							
				SessionErrors.add(renderRequest, "permission-error");
				return;
	     		}
			
			renderRequest.setAttribute("invoices", invoices);
		} else {

			if (!InvoicesPermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_INVOICES")){	
						SessionErrors.add(renderRequest, "permission-error");
						return;
	    		}

			editInvoicesURL.setParameter("javax.portlet.action", "addInvoices");
			Invoices errorInvoices = (Invoices) renderRequest.getAttribute("errorInvoices");
			if (errorInvoices != null) {
				if (editType.equalsIgnoreCase("update")) {
					editInvoicesURL.setParameter("javax.portlet.action", "updateInvoices");
                		}
				renderRequest.setAttribute("invoices", errorInvoices);

			} else {				
				
				Invoices addInvoices = null;


				if (Validator.isNull(renderRequest.getParameter("addErrors"))){
				
					addInvoices = new InvoicesImpl();
					addInvoices.setInvoiceId(0);
					addInvoices.setCustomerId((Long) renderRequest.getPortletSession().getAttribute("INVOICEScustomerId"));
					addInvoices.setDate(new Date());				
					addInvoices.setAmount(0);
					addInvoices.setPaid(true);
            			String customerIdStr = (String) renderRequest.getPortletSession().getAttribute("claseId");
					renderRequest.setAttribute("customerId", customerIdStr);
				}else{
					addInvoices = InvoicesFromRequest(renderRequest);
				}
				renderRequest.setAttribute("invoices", addInvoices);
			}

		}		

        renderRequest.setAttribute("editType", editType);

		if (!viewEntryMode){
			renderRequest.setAttribute("editInvoicesURL", editInvoicesURL.toString());		
			include(editinvoicesJSP, renderRequest, renderResponse);
		}else{
			include(viewinvoicesJSP, renderRequest, renderResponse);
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

	@ProcessAction(name = "newInvoices")
	public void newInvoices(ActionRequest request, ActionResponse response) throws Exception{
		InvoicesUtil.addParametersForAdd(response);
	}

	@ProcessAction(name = "addInvoices")
	public void addInvoices(ActionRequest request, ActionResponse response) throws Exception {
            Invoices invoices = InvoicesFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!InvoicesPermission.contains(
					permissionChecker, themeDisplay.getScopeGroupId(), "ADD_INVOICES")){	
				InvoicesUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	    }
            ArrayList<String> errors = InvoicesValidator.validateInvoices(invoices, request);

            if (errors.isEmpty()) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Invoices.class.getName(), request);
			InvoicesLocalServiceUtil.addInvoices(invoices, serviceContext);

			InvoicesUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "invoices-added-successfully");

            	} catch (Exception cvex) {
            		SessionErrors.add(request, "please-enter-a-unique-code");
			PortalUtil.copyRequestParameters(request, response);			
			InvoicesUtil.addParametersForAddWithErrors(response);		
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
		PortalUtil.copyRequestParameters(request, response);			
		InvoicesUtil.addParametersForAddWithErrors(response);	
            }
	}

	@ProcessAction(name = "eventInvoices")
	public void eventInvoices(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		int containerStart = ParamUtil.getInteger(request, "containerStart");
		int containerEnd = ParamUtil.getInteger(request, "containerEnd");
		int cur = ParamUtil.getInteger(request, "cur");
		String orderByType = ParamUtil.getString(request, "orderByType");
		String orderByCol = ParamUtil.getString(request, "orderByCol");
		String invoicesFilter = ParamUtil.getString(request, "InvoicesFilter");
		if (Validator.isNotNull(key)) {
            		response.setRenderParameter("highlightRowWithKey", Long.toString(key));
            		response.setRenderParameter("containerStart", Integer.toString(containerStart));
            		response.setRenderParameter("containerEnd", Integer.toString(containerEnd));
			response.setRenderParameter("cur", Integer.toString(cur));
			response.setRenderParameter("orderByType", orderByType);
			response.setRenderParameter("orderByCol", orderByCol);
			response.setRenderParameter("InvoicesFilter", invoicesFilter);
		}
	}

	@ProcessAction(name = "editInvoices")

	public void editInvoices(ActionRequest request, ActionResponse response)
			throws Exception {
		long key = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(key)) {
			InvoicesUtil.addParametersForEdit(response, key);
			
		}
	}

	@ProcessAction(name = "deleteInvoices")
	public void deleteInvoices(ActionRequest request, ActionResponse response)throws Exception {		

		long id = ParamUtil.getLong(request, "resourcePrimKey");

		if (Validator.isNotNull(id)) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

			if (!InvoicesEntryPermission.contains(
					permissionChecker, id, ActionKeys.DELETE)){	
				InvoicesUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
			}

			Invoices invoices = InvoicesLocalServiceUtil.getInvoices(id);
			InvoicesLocalServiceUtil.deleteInvoicesEntry(invoices);
			SessionMessages.add(request, "invoices-deleted-successfully");
            		response.setRenderParameter("invoiceId", "0");
		} else {
			SessionErrors.add(request, "invoices-error-deleting");
		}
	}


	@ProcessAction(name = "updateInvoices")
	public void updateInvoices(ActionRequest request, ActionResponse response) throws Exception {
            Invoices invoices = InvoicesFromRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

	    if (!InvoicesEntryPermission.contains(
				permissionChecker, invoices, ActionKeys.UPDATE)){	
				InvoicesUtil.addParametersForDefaultView(response);						
				SessionErrors.add(request, "permission-error");
				return;
	     }

            ArrayList<String> errors = InvoicesValidator.validateInvoices(invoices, request);

            if (errors.isEmpty()) {
            	try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Invoices.class.getName(), request);
                	InvoicesLocalServiceUtil.updateInvoices(invoices, serviceContext);

			InvoicesUtil.addParametersForDefaultView(response);
                	SessionMessages.add(request, "invoices-updated-successfully");

            	} catch (Exception cvex) {
            	    SessionErrors.add(request, "please-enter-a-unique-code");
		    		InvoicesUtil.addParametersForEdit(response, null);
					request.setAttribute("invoices",invoices);
            	}
            } else {
                for (String error : errors) {
                        SessionErrors.add(request, error);
                }
				InvoicesUtil.addParametersForEdit(response, Long.toString(invoices.getPrimaryKey()));
				request.setAttribute("invoices",invoices);
            }
        }

	@ProcessAction(name = "setInvoicesPref")
	public void setInvoicesPref(ActionRequest request, ActionResponse response) throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rows-per-page");
		String viewType = ParamUtil.getString(request, "view-type");
		String dateFormat = ParamUtil.getString(request, "date-format");
		String datetimeFormat = ParamUtil.getString(request, "datetime-format");

		ArrayList<String> errors = new ArrayList();
		if (InvoicesValidator.validateEditInvoices(rowsPerPage, dateFormat, datetimeFormat, errors)) {
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

	private Invoices InvoicesFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		InvoicesImpl invoices = new InvoicesImpl();
        	try {
            		invoices.setInvoiceId(ParamUtil.getLong(request, "invoiceId"));
        	} catch (Exception nfe) {
		    //Controled en Validator
        	}
        	try {
            		invoices.setCustomerId(ParamUtil.getLong(request, "customerId"));
        	} catch (Exception nfe) {
		    //Controled en Validator
        	}
	    	PortletPreferences prefs = request.getPreferences();
        	SimpleDateFormat format = new SimpleDateFormat(prefs.getValue("date-format", "yyyy/MM/dd"));
        	int dateAno = ParamUtil.getInteger(request, "dateYear");
        	int dateMes = ParamUtil.getInteger(request, "dateMonth")+1;
        	int dateDia = ParamUtil.getInteger(request, "dateDay");
        	try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            		invoices.setDate(formatter.parse(dateAno + "/" + dateMes + "/" + dateDia));
       	 	} catch (ParseException e) {
			invoices.setDate(new Date());
        	}
        	try {
            		invoices.setAmount(ParamUtil.getLong(request, "amount"));
        	} catch (Exception nfe) {
		    //Controled en Validator
        	}
        	invoices.setPaid(ParamUtil.getBoolean(request, "paid"));
		try {
		    	invoices.setPrimaryKey(ParamUtil.getLong(request,"resourcePrimKey"));
		} catch (NumberFormatException nfe) {
			//Controled en Validator
        	}

		invoices.setCompanyId(themeDisplay.getCompanyId());
		invoices.setGroupId(themeDisplay.getScopeGroupId());
		invoices.setUserId(themeDisplay.getUserId());
		return invoices;
	}

	@ProcessEvent(qname="{http://liferay.com/events}Customer.customerId")
	public void recieveEvent(EventRequest request, EventResponse response) throws Exception {
		Event event = request.getEvent();
		String customerId = (String)event.getValue();
		request.getPortletSession().setAttribute("customerId",customerId);
		response.setRenderParameter("customerId", customerId);
		QName qNameInvoices = new QName("http://liferay.com/events", "Invoices.${detailfile2.getConnectionFieldName()}");
		response.setEvent(qNameInvoices, "0");
	}


	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		resourceResponse.setContentType("text/javascript");
		String resourceId = resourceRequest.getResourceID();

		if (Validator.isNotNull(resourceId) && resourceId.length() != 0) {

			if(resourceId.equalsIgnoreCase("exportFullInvoicesResourceURL")) {

		    		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    		Locale locale = themeDisplay.getLocale();
		    		PortletConfig portletConfig = (PortletConfig)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		    		resourceResponse.setContentType("application/vnd.ms-excel");
		    		resourceResponse.setProperty("expires","-1d");
		    		resourceResponse.setProperty("Pragma","no-cache");
		    		resourceResponse.setProperty("Cache-control","no-cache");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" Invoices\"");

				try {
					Workbook book = InvoicesExporter.generateFullExcel(themeDisplay.getScopeGroupId(), portletConfig, locale);
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

	protected String editinvoicesJSP;
	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;
	protected String viewinvoicesJSP;

	private static Log _log = LogFactoryUtil.getLog(InvoicesPortlet.class);

}
