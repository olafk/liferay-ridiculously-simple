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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.xmlportletfactory.olafk.customer.model.Invoices;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Invoices in entity cache.
 *
 * @author Jack A. Rider
 * @see Invoices
 * @generated
 */
public class InvoicesCacheModel implements CacheModel<Invoices>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{invoiceId=");
		sb.append(invoiceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", date=");
		sb.append(date);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", paid=");
		sb.append(paid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Invoices toEntityModel() {
		InvoicesImpl invoicesImpl = new InvoicesImpl();

		invoicesImpl.setInvoiceId(invoiceId);
		invoicesImpl.setCompanyId(companyId);
		invoicesImpl.setGroupId(groupId);
		invoicesImpl.setUserId(userId);

		if (userName == null) {
			invoicesImpl.setUserName(StringPool.BLANK);
		}
		else {
			invoicesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			invoicesImpl.setCreateDate(null);
		}
		else {
			invoicesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			invoicesImpl.setModifiedDate(null);
		}
		else {
			invoicesImpl.setModifiedDate(new Date(modifiedDate));
		}

		invoicesImpl.setCustomerId(customerId);

		if (date == Long.MIN_VALUE) {
			invoicesImpl.setDate(null);
		}
		else {
			invoicesImpl.setDate(new Date(date));
		}

		invoicesImpl.setAmount(amount);
		invoicesImpl.setPaid(paid);

		invoicesImpl.resetOriginalValues();

		return invoicesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		invoiceId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		customerId = objectInput.readLong();
		date = objectInput.readLong();
		amount = objectInput.readLong();
		paid = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(invoiceId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(customerId);
		objectOutput.writeLong(date);
		objectOutput.writeLong(amount);
		objectOutput.writeBoolean(paid);
	}

	public long invoiceId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long date;
	public long amount;
	public boolean paid;
}