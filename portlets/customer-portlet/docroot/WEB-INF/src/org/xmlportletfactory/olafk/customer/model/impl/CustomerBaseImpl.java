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

package org.xmlportletfactory.olafk.customer.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.xmlportletfactory.olafk.customer.model.Customer;
import org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil;

/**
 * The extended model base implementation for the Customer service. Represents a row in the &quot;customer_Customer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CustomerImpl}.
 * </p>
 *
 * @author Jack A. Rider
 * @see CustomerImpl
 * @see org.xmlportletfactory.olafk.customer.model.Customer
 * @generated
 */
public abstract class CustomerBaseImpl extends CustomerModelImpl
	implements Customer {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a customer model instance should use the {@link Customer} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CustomerLocalServiceUtil.addCustomer(this);
		}
		else {
			CustomerLocalServiceUtil.updateCustomer(this);
		}
	}
}