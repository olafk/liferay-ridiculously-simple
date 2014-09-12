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

package org.xmlportletfactory.olafk.customer.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Customer service. Represents a row in the &quot;customer_Customer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.xmlportletfactory.olafk.customer.model.impl.CustomerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.xmlportletfactory.olafk.customer.model.impl.CustomerImpl}.
 * </p>
 *
 * @author Jack A. Rider
 * @see Customer
 * @see org.xmlportletfactory.olafk.customer.model.impl.CustomerImpl
 * @see org.xmlportletfactory.olafk.customer.model.impl.CustomerModelImpl
 * @generated
 */
public interface CustomerModel extends BaseModel<Customer>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a customer model instance should use the {@link Customer} interface instead.
	 */

	/**
	 * Returns the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this customer.
	 *
	 * @param primaryKey the primary key of this customer
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the customer ID of this customer.
	 *
	 * @return the customer ID of this customer
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this customer.
	 *
	 * @param customerId the customer ID of this customer
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the company ID of this customer.
	 *
	 * @return the company ID of this customer
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this customer.
	 *
	 * @param companyId the company ID of this customer
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this customer.
	 *
	 * @return the group ID of this customer
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this customer.
	 *
	 * @param groupId the group ID of this customer
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this customer.
	 *
	 * @return the user ID of this customer
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this customer.
	 *
	 * @param userId the user ID of this customer
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this customer.
	 *
	 * @return the user uuid of this customer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this customer.
	 *
	 * @param userUuid the user uuid of this customer
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this customer.
	 *
	 * @return the user name of this customer
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this customer.
	 *
	 * @param userName the user name of this customer
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this customer.
	 *
	 * @return the create date of this customer
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this customer.
	 *
	 * @param createDate the create date of this customer
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this customer.
	 *
	 * @return the modified date of this customer
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this customer.
	 *
	 * @param modifiedDate the modified date of this customer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this customer.
	 *
	 * @return the name of this customer
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this customer.
	 *
	 * @param name the name of this customer
	 */
	public void setName(String name);

	/**
	 * Returns the street of this customer.
	 *
	 * @return the street of this customer
	 */
	@AutoEscape
	public String getStreet();

	/**
	 * Sets the street of this customer.
	 *
	 * @param street the street of this customer
	 */
	public void setStreet(String street);

	/**
	 * Returns the city of this customer.
	 *
	 * @return the city of this customer
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this customer.
	 *
	 * @param city the city of this customer
	 */
	public void setCity(String city);

	/**
	 * Returns the zip of this customer.
	 *
	 * @return the zip of this customer
	 */
	@AutoEscape
	public String getZip();

	/**
	 * Sets the zip of this customer.
	 *
	 * @param zip the zip of this customer
	 */
	public void setZip(String zip);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Customer customer);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Customer> toCacheModel();

	@Override
	public Customer toEscapedModel();

	@Override
	public Customer toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}