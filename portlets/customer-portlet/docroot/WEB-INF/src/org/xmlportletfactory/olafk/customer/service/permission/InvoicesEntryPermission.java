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
 
 
package org.xmlportletfactory.olafk.customer.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import org.xmlportletfactory.olafk.customer.model.Invoices;
import org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil;


/**
 * @author Juan Gonzalez P. 
 */
public class InvoicesEntryPermission {

	public static void check(
			PermissionChecker permissionChecker, Invoices entry,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, entry, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, entryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Invoices entry,
		String actionId) {		
		

		if (permissionChecker.hasOwnerPermission(
				entry.getCompanyId(), Invoices.class.getName(),
				entry.getPrimaryKey(), entry.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			entry.getGroupId(), Invoices.class.getName(), entry.getPrimaryKey(),
			actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException, SystemException {

		Invoices entry = InvoicesLocalServiceUtil.getInvoices(entryId);

		return contains(permissionChecker, entry, actionId);
	}
}
