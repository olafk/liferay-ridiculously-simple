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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jack A. Rider
 * @generated
 */
public class InvoicesSoap implements Serializable {
	public static InvoicesSoap toSoapModel(Invoices model) {
		InvoicesSoap soapModel = new InvoicesSoap();

		soapModel.setInvoiceId(model.getInvoiceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setDate(model.getDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setPaid(model.getPaid());

		return soapModel;
	}

	public static InvoicesSoap[] toSoapModels(Invoices[] models) {
		InvoicesSoap[] soapModels = new InvoicesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvoicesSoap[][] toSoapModels(Invoices[][] models) {
		InvoicesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InvoicesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvoicesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvoicesSoap[] toSoapModels(List<Invoices> models) {
		List<InvoicesSoap> soapModels = new ArrayList<InvoicesSoap>(models.size());

		for (Invoices model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvoicesSoap[soapModels.size()]);
	}

	public InvoicesSoap() {
	}

	public long getPrimaryKey() {
		return _invoiceId;
	}

	public void setPrimaryKey(long pk) {
		setInvoiceId(pk);
	}

	public long getInvoiceId() {
		return _invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		_invoiceId = invoiceId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public long getAmount() {
		return _amount;
	}

	public void setAmount(long amount) {
		_amount = amount;
	}

	public boolean getPaid() {
		return _paid;
	}

	public boolean isPaid() {
		return _paid;
	}

	public void setPaid(boolean paid) {
		_paid = paid;
	}

	private long _invoiceId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _customerId;
	private Date _date;
	private long _amount;
	private boolean _paid;
}