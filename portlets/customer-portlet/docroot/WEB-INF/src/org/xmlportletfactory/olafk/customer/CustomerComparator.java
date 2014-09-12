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
import org.xmlportletfactory.olafk.customer.model.Customer;

public class CustomerComparator {

	public static String ORDER_BY_ASC =  " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getCustomerOrderByComparator(String orderByCol,String orderByType) {

		boolean orderByAsc = false;
		if(orderByType==null) {
			orderByAsc = true;
		} else if (orderByType.trim().equalsIgnoreCase(ORDER_BY_ASC.trim())){
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
			if(orderByCol==null) {
			orderByComparator = new OrderByCustomerCustomerId(orderByAsc);
			} else if(orderByCol.equals("customerId")){
			orderByComparator = new OrderByCustomerCustomerId(orderByAsc);
			} else if(orderByCol.equals("name")){
			orderByComparator = new OrderByCustomerName(orderByAsc);
			} else if(orderByCol.equals("street")){
			orderByComparator = new OrderByCustomerStreet(orderByAsc);
			} else if(orderByCol.equals("city")){
			orderByComparator = new OrderByCustomerCity(orderByAsc);
			} else if(orderByCol.equals("zip")){
			orderByComparator = new OrderByCustomerZip(orderByAsc);
	    }
	    return orderByComparator;
	}
}

class OrderByCustomerCustomerId extends OrderByComparator {
	public static String ORDER_BY_FIELD = "customerId";

	public OrderByCustomerCustomerId(){
		this(false);
	}

	public OrderByCustomerCustomerId(boolean asc){
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
		if(_asc) return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderByCustomerName extends OrderByComparator {
	public static String ORDER_BY_FIELD = "name";

	public OrderByCustomerName(){
		this(false);
	}

	public OrderByCustomerName(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderByCustomerStreet extends OrderByComparator {
	public static String ORDER_BY_FIELD = "street";

	public OrderByCustomerStreet(){
		this(false);
	}

	public OrderByCustomerStreet(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderByCustomerCity extends OrderByComparator {
	public static String ORDER_BY_FIELD = "city";

	public OrderByCustomerCity(){
		this(false);
	}

	public OrderByCustomerCity(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderByCustomerZip extends OrderByComparator {
	public static String ORDER_BY_FIELD = "zip";

	public OrderByCustomerZip(){
		this(false);
	}

	public OrderByCustomerZip(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + CustomerComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}



