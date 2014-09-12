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
 * This class is a wrapper for {@link Invoices}.
 * </p>
 *
 * @author Jack A. Rider
 * @see Invoices
 * @generated
 */
public class InvoicesWrapper implements Invoices, ModelWrapper<Invoices> {
	public InvoicesWrapper(Invoices invoices) {
		_invoices = invoices;
	}

	@Override
	public Class<?> getModelClass() {
		return Invoices.class;
	}

	@Override
	public String getModelClassName() {
		return Invoices.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invoiceId", getInvoiceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("date", getDate());
		attributes.put("amount", getAmount());
		attributes.put("paid", getPaid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invoiceId = (Long)attributes.get("invoiceId");

		if (invoiceId != null) {
			setInvoiceId(invoiceId);
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

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Boolean paid = (Boolean)attributes.get("paid");

		if (paid != null) {
			setPaid(paid);
		}
	}

	/**
	* Returns the primary key of this invoices.
	*
	* @return the primary key of this invoices
	*/
	@Override
	public long getPrimaryKey() {
		return _invoices.getPrimaryKey();
	}

	/**
	* Sets the primary key of this invoices.
	*
	* @param primaryKey the primary key of this invoices
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_invoices.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the invoice ID of this invoices.
	*
	* @return the invoice ID of this invoices
	*/
	@Override
	public long getInvoiceId() {
		return _invoices.getInvoiceId();
	}

	/**
	* Sets the invoice ID of this invoices.
	*
	* @param invoiceId the invoice ID of this invoices
	*/
	@Override
	public void setInvoiceId(long invoiceId) {
		_invoices.setInvoiceId(invoiceId);
	}

	/**
	* Returns the company ID of this invoices.
	*
	* @return the company ID of this invoices
	*/
	@Override
	public long getCompanyId() {
		return _invoices.getCompanyId();
	}

	/**
	* Sets the company ID of this invoices.
	*
	* @param companyId the company ID of this invoices
	*/
	@Override
	public void setCompanyId(long companyId) {
		_invoices.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this invoices.
	*
	* @return the group ID of this invoices
	*/
	@Override
	public long getGroupId() {
		return _invoices.getGroupId();
	}

	/**
	* Sets the group ID of this invoices.
	*
	* @param groupId the group ID of this invoices
	*/
	@Override
	public void setGroupId(long groupId) {
		_invoices.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this invoices.
	*
	* @return the user ID of this invoices
	*/
	@Override
	public long getUserId() {
		return _invoices.getUserId();
	}

	/**
	* Sets the user ID of this invoices.
	*
	* @param userId the user ID of this invoices
	*/
	@Override
	public void setUserId(long userId) {
		_invoices.setUserId(userId);
	}

	/**
	* Returns the user uuid of this invoices.
	*
	* @return the user uuid of this invoices
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoices.getUserUuid();
	}

	/**
	* Sets the user uuid of this invoices.
	*
	* @param userUuid the user uuid of this invoices
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_invoices.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this invoices.
	*
	* @return the user name of this invoices
	*/
	@Override
	public java.lang.String getUserName() {
		return _invoices.getUserName();
	}

	/**
	* Sets the user name of this invoices.
	*
	* @param userName the user name of this invoices
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_invoices.setUserName(userName);
	}

	/**
	* Returns the create date of this invoices.
	*
	* @return the create date of this invoices
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _invoices.getCreateDate();
	}

	/**
	* Sets the create date of this invoices.
	*
	* @param createDate the create date of this invoices
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_invoices.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this invoices.
	*
	* @return the modified date of this invoices
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _invoices.getModifiedDate();
	}

	/**
	* Sets the modified date of this invoices.
	*
	* @param modifiedDate the modified date of this invoices
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_invoices.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the customer ID of this invoices.
	*
	* @return the customer ID of this invoices
	*/
	@Override
	public long getCustomerId() {
		return _invoices.getCustomerId();
	}

	/**
	* Sets the customer ID of this invoices.
	*
	* @param customerId the customer ID of this invoices
	*/
	@Override
	public void setCustomerId(long customerId) {
		_invoices.setCustomerId(customerId);
	}

	/**
	* Returns the date of this invoices.
	*
	* @return the date of this invoices
	*/
	@Override
	public java.util.Date getDate() {
		return _invoices.getDate();
	}

	/**
	* Sets the date of this invoices.
	*
	* @param date the date of this invoices
	*/
	@Override
	public void setDate(java.util.Date date) {
		_invoices.setDate(date);
	}

	/**
	* Returns the amount of this invoices.
	*
	* @return the amount of this invoices
	*/
	@Override
	public long getAmount() {
		return _invoices.getAmount();
	}

	/**
	* Sets the amount of this invoices.
	*
	* @param amount the amount of this invoices
	*/
	@Override
	public void setAmount(long amount) {
		_invoices.setAmount(amount);
	}

	/**
	* Returns the paid of this invoices.
	*
	* @return the paid of this invoices
	*/
	@Override
	public boolean getPaid() {
		return _invoices.getPaid();
	}

	/**
	* Returns <code>true</code> if this invoices is paid.
	*
	* @return <code>true</code> if this invoices is paid; <code>false</code> otherwise
	*/
	@Override
	public boolean isPaid() {
		return _invoices.isPaid();
	}

	/**
	* Sets whether this invoices is paid.
	*
	* @param paid the paid of this invoices
	*/
	@Override
	public void setPaid(boolean paid) {
		_invoices.setPaid(paid);
	}

	@Override
	public boolean isNew() {
		return _invoices.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_invoices.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _invoices.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_invoices.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _invoices.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _invoices.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_invoices.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _invoices.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_invoices.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_invoices.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_invoices.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InvoicesWrapper((Invoices)_invoices.clone());
	}

	@Override
	public int compareTo(Invoices invoices) {
		return _invoices.compareTo(invoices);
	}

	@Override
	public int hashCode() {
		return _invoices.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Invoices> toCacheModel() {
		return _invoices.toCacheModel();
	}

	@Override
	public Invoices toEscapedModel() {
		return new InvoicesWrapper(_invoices.toEscapedModel());
	}

	@Override
	public Invoices toUnescapedModel() {
		return new InvoicesWrapper(_invoices.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _invoices.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _invoices.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_invoices.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InvoicesWrapper)) {
			return false;
		}

		InvoicesWrapper invoicesWrapper = (InvoicesWrapper)obj;

		if (Validator.equals(_invoices, invoicesWrapper._invoices)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Invoices getWrappedInvoices() {
		return _invoices;
	}

	@Override
	public Invoices getWrappedModel() {
		return _invoices;
	}

	@Override
	public void resetOriginalValues() {
		_invoices.resetOriginalValues();
	}

	private Invoices _invoices;
}