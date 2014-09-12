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

import java.util.Date;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.xmlportletfactory.olafk.customer.model.Invoices;

public class InvoicesComparator {

	public static String ORDER_BY_ASC =  " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getInvoicesOrderByComparator(String orderByCol,String orderByType) {

		boolean orderByAsc = false;
		if(orderByType==null) {
			orderByAsc = true;
		} else if (orderByType.trim().equalsIgnoreCase(ORDER_BY_ASC.trim())){
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
			if(orderByCol==null) {
			orderByComparator = new OrderByInvoicesInvoiceId(orderByAsc);
			} else if(orderByCol.equals("invoiceId")){
			orderByComparator = new OrderByInvoicesInvoiceId(orderByAsc);
			} else if(orderByCol.equals("customerId")){
			orderByComparator = new OrderByInvoicesCustomerId(orderByAsc);
			} else if(orderByCol.equals("date")){
			orderByComparator = new OrderByInvoicesDate(orderByAsc);
			} else if(orderByCol.equals("amount")){
			orderByComparator = new OrderByInvoicesAmount(orderByAsc);
		    }
	    return orderByComparator;
	}
}

class OrderByInvoicesInvoiceId extends OrderByComparator {
	public static String ORDER_BY_FIELD = "invoiceId";

	public OrderByInvoicesInvoiceId(){
		this(false);
	}

	public OrderByInvoicesInvoiceId(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		Long lo1 = 0L;
		Long lo2 = 0L;

		if(o1!=null) lo1 = (Long)o1;
		if(o2!=null) lo2 = (Long)o2;

		return lo1.compareTo(lo2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderByInvoicesCustomerId extends OrderByComparator {
	public static String ORDER_BY_FIELD = "customerId";

	public OrderByInvoicesCustomerId(){
		this(false);
	}

	public OrderByInvoicesCustomerId(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		Long lo1 = 0L;
		Long lo2 = 0L;

		if(o1!=null) lo1 = (Long)o1;
		if(o2!=null) lo2 = (Long)o2;

		return lo1.compareTo(lo2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderByInvoicesDate extends OrderByComparator {
	public static String ORDER_BY_FIELD = "date";

	public OrderByInvoicesDate(){
		this(false);
	}

	public OrderByInvoicesDate(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		Date date1 = new Date();
		Date date2 = new Date();

		if(o1!=null) date1 = (Date)o1;
		if(o2!=null) date2 = (Date)o2;

		return date1.compareTo(date2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderByInvoicesAmount extends OrderByComparator {
	public static String ORDER_BY_FIELD = "amount";

	public OrderByInvoicesAmount(){
		this(false);
	}

	public OrderByInvoicesAmount(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		Long lo1 = 0L;
		Long lo2 = 0L;

		if(o1!=null) lo1 = (Long)o1;
		if(o2!=null) lo2 = (Long)o1;

		return lo1.compareTo(lo2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + InvoicesComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}




