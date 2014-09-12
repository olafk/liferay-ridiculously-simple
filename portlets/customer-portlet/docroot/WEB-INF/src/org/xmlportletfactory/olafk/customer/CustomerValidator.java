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

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;

import org.xmlportletfactory.olafk.customer.model.Customer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.ParamUtil;

public class CustomerValidator {

	public static ArrayList<String> validateCustomer(Customer customer, ActionRequest request) throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		Properties props = new Properties();
		ClassLoader classLoader = CustomerValidator.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("regexp.properties");
		props.load(is);


	//Field name
	
	
		if(!validateName(props, ParamUtil.getString(request, "name"))){
		    errors.add("error");
		}
		if (Validator.isNull(customer.getName())) {
			errors.add("customers-name-required");
		}

	//Field street
	
	
		if(!validateStreet(props, ParamUtil.getString(request, "street"))){
		    errors.add("error");
		}

	//Field city
	
	
		if(!validateCity(props, ParamUtil.getString(request, "city"))){
		    errors.add("error");
		}

	//Field zip
	
	
		if(!validateZip(props, ParamUtil.getString(request, "zip"))){
		    errors.add("error");
		}
		return errors;
	}

	public static boolean validateEditCustomer(
		String rowsPerPage, String dateFormat, String datetimeFormat, List errors) {
		boolean valid = true;
		if (Validator.isNull(rowsPerPage)) {
			errors.add("rows-per-page-required");
			valid = false;
		} else if (!Validator.isNumber(rowsPerPage)) {
			errors.add("rows-per-page-invalid");
			valid = false;
		} else if (Validator.isNull(dateFormat)) {
			errors.add("date-format-required");
			valid = false;
		} else if (Validator.isNull(datetimeFormat)) {
			errors.add("datetime-format.required");
			valid = false;
		}
		return valid;
	}

	//Field customerId
	private static boolean validateCustomerId(Properties props,String field) {
		boolean valid = true;
		try {
			Double.parseDouble(field);
		} catch (NumberFormatException nfe) {
		    valid = false;
		}
		return valid;
	}
	//Field name
	private static boolean validateName(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field street
	private static boolean validateStreet(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field city
	private static boolean validateCity(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field zip
	private static boolean validateZip(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
}
