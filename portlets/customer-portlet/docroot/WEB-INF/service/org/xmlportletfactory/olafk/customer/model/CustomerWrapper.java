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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author Jack A. Rider
 * @see Customer
 * @generated
 */
public class CustomerWrapper implements Customer, ModelWrapper<Customer> {
	public CustomerWrapper(Customer customer) {
		_customer = customer;
	}

	@Override
	public Class<?> getModelClass() {
		return Customer.class;
	}

	@Override
	public String getModelClassName() {
		return Customer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerId", getCustomerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("street", getStreet());
		attributes.put("city", getCity());
		attributes.put("zip", getZip());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}
	}

	/**
	* Returns the primary key of this customer.
	*
	* @return the primary key of this customer
	*/
	@Override
	public long getPrimaryKey() {
		return _customer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this customer.
	*
	* @param primaryKey the primary key of this customer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_customer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the customer ID of this customer.
	*
	* @return the customer ID of this customer
	*/
	@Override
	public long getCustomerId() {
		return _customer.getCustomerId();
	}

	/**
	* Sets the customer ID of this customer.
	*
	* @param customerId the customer ID of this customer
	*/
	@Override
	public void setCustomerId(long customerId) {
		_customer.setCustomerId(customerId);
	}

	/**
	* Returns the company ID of this customer.
	*
	* @return the company ID of this customer
	*/
	@Override
	public long getCompanyId() {
		return _customer.getCompanyId();
	}

	/**
	* Sets the company ID of this customer.
	*
	* @param companyId the company ID of this customer
	*/
	@Override
	public void setCompanyId(long companyId) {
		_customer.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this customer.
	*
	* @return the group ID of this customer
	*/
	@Override
	public long getGroupId() {
		return _customer.getGroupId();
	}

	/**
	* Sets the group ID of this customer.
	*
	* @param groupId the group ID of this customer
	*/
	@Override
	public void setGroupId(long groupId) {
		_customer.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this customer.
	*
	* @return the user ID of this customer
	*/
	@Override
	public long getUserId() {
		return _customer.getUserId();
	}

	/**
	* Sets the user ID of this customer.
	*
	* @param userId the user ID of this customer
	*/
	@Override
	public void setUserId(long userId) {
		_customer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this customer.
	*
	* @return the user uuid of this customer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customer.getUserUuid();
	}

	/**
	* Sets the user uuid of this customer.
	*
	* @param userUuid the user uuid of this customer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_customer.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this customer.
	*
	* @return the user name of this customer
	*/
	@Override
	public java.lang.String getUserName() {
		return _customer.getUserName();
	}

	/**
	* Sets the user name of this customer.
	*
	* @param userName the user name of this customer
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_customer.setUserName(userName);
	}

	/**
	* Returns the create date of this customer.
	*
	* @return the create date of this customer
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _customer.getCreateDate();
	}

	/**
	* Sets the create date of this customer.
	*
	* @param createDate the create date of this customer
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_customer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this customer.
	*
	* @return the modified date of this customer
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _customer.getModifiedDate();
	}

	/**
	* Sets the modified date of this customer.
	*
	* @param modifiedDate the modified date of this customer
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_customer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this customer.
	*
	* @return the name of this customer
	*/
	@Override
	public java.lang.String getName() {
		return _customer.getName();
	}

	/**
	* Sets the name of this customer.
	*
	* @param name the name of this customer
	*/
	@Override
	public void setName(java.lang.String name) {
		_customer.setName(name);
	}

	/**
	* Returns the street of this customer.
	*
	* @return the street of this customer
	*/
	@Override
	public java.lang.String getStreet() {
		return _customer.getStreet();
	}

	/**
	* Sets the street of this customer.
	*
	* @param street the street of this customer
	*/
	@Override
	public void setStreet(java.lang.String street) {
		_customer.setStreet(street);
	}

	/**
	* Returns the city of this customer.
	*
	* @return the city of this customer
	*/
	@Override
	public java.lang.String getCity() {
		return _customer.getCity();
	}

	/**
	* Sets the city of this customer.
	*
	* @param city the city of this customer
	*/
	@Override
	public void setCity(java.lang.String city) {
		_customer.setCity(city);
	}

	/**
	* Returns the zip of this customer.
	*
	* @return the zip of this customer
	*/
	@Override
	public java.lang.String getZip() {
		return _customer.getZip();
	}

	/**
	* Sets the zip of this customer.
	*
	* @param zip the zip of this customer
	*/
	@Override
	public void setZip(java.lang.String zip) {
		_customer.setZip(zip);
	}

	@Override
	public boolean isNew() {
		return _customer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_customer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _customer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_customer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _customer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _customer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_customer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _customer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_customer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_customer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_customer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CustomerWrapper((Customer)_customer.clone());
	}

	@Override
	public int compareTo(Customer customer) {
		return _customer.compareTo(customer);
	}

	@Override
	public int hashCode() {
		return _customer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Customer> toCacheModel() {
		return _customer.toCacheModel();
	}

	@Override
	public Customer toEscapedModel() {
		return new CustomerWrapper(_customer.toEscapedModel());
	}

	@Override
	public Customer toUnescapedModel() {
		return new CustomerWrapper(_customer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _customer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _customer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_customer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomerWrapper)) {
			return false;
		}

		CustomerWrapper customerWrapper = (CustomerWrapper)obj;

		if (Validator.equals(_customer, customerWrapper._customer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Customer getWrappedCustomer() {
		return _customer;
	}

	@Override
	public Customer getWrappedModel() {
		return _customer;
	}

	@Override
	public void resetOriginalValues() {
		_customer.resetOriginalValues();
	}

	private Customer _customer;
}