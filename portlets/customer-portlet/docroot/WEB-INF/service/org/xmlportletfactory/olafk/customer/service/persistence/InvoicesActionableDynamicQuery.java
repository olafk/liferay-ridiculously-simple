/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package org.xmlportletfactory.olafk.customer.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.xmlportletfactory.olafk.customer.model.Invoices;
import org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil;

/**
 * @author Jack A. Rider
 * @generated
 */
public abstract class InvoicesActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public InvoicesActionableDynamicQuery() throws SystemException {
		setBaseLocalService(InvoicesLocalServiceUtil.getService());
		setClass(Invoices.class);

		setClassLoader(org.xmlportletfactory.olafk.customer.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("invoiceId");
	}
}