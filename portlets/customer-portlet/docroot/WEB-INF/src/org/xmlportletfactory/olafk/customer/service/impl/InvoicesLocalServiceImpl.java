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
 
 
package org.xmlportletfactory.olafk.customer.service.impl;

import java.util.List;

import org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;
import org.xmlportletfactory.olafk.customer.model.Invoices;
import org.xmlportletfactory.olafk.customer.service.base.InvoicesLocalServiceBaseImpl;
import org.xmlportletfactory.olafk.customer.util.InvoicesIndexer;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.kernel.exception.PortalException;
import java.util.Date;


/**
 * @author Jack A. Rider
 * @author Juan Gonzalez P.
 */
public class InvoicesLocalServiceImpl extends InvoicesLocalServiceBaseImpl {

	@SuppressWarnings("unchecked")
	public List<Invoices> getCompanyEntries(
			long companyId, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		return invoicesPersistence.findByCompanyId(
				companyId, start, end, obc);
	}

	@SuppressWarnings("unchecked")
	public List<Invoices> getCompanyEntries(
			long companyId, int start, int end)
		throws SystemException {

		return invoicesPersistence.findByCompanyId(
				companyId, start, end);
	}

	@SuppressWarnings("unchecked")
	public int getCompanyEntriesCount(
			long companyId)
		throws SystemException {

		return invoicesPersistence.countByCompanyId(companyId);
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId)throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.findByUserId(userId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUser(long userId)throws SystemException {
		int count = invoicesPersistence.countByUserId(userId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, OrderByComparator orderByComparator) throws SystemException {

		List<Invoices> list = (List<Invoices>) findAllInUser(userId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.findByUserId(userId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId) throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.filterFindByGroupId(groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInGroup(long groupId) throws SystemException {
		int count = invoicesPersistence.filterCountByGroupId(groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, OrderByComparator orderByComparator) throws SystemException{
		List <Invoices> list = (List<Invoices>) findAllInGroup (groupId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException{
		List <Invoices> list = (List<Invoices>) invoicesPersistence.filterFindByGroupId(groupId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId) throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.filterFindByUserIdGroupId(userId, groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUserAndGroup(long userId, long groupId) throws SystemException {
		int count = invoicesPersistence.filterCountByUserIdGroupId(userId, groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, OrderByComparator orderByComparator) throws SystemException {

		List<Invoices> list = (List<Invoices>) findAllInUserAndGroup(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.filterFindByUserIdGroupId(userId, groupId, start, end, orderByComparator);
		return list;
	}



	@SuppressWarnings("unchecked")
	public List findAllIncustomerIdGroup(long customerId, long groupId)	throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.filterFindByCustomerIdGroupId(customerId, groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllIncustomerId(long customerId)	throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.findByCustomerId(customerId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllIncustomerIdGroup(long customerId, long groupId, OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = (List<Invoices>) invoicesPersistence.filterFindByCustomerIdGroupId(customerId, groupId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	public Invoices addInvoices (Invoices validInvoices, ServiceContext serviceContext) throws PortalException, SystemException {
	    Invoices retVal = _addInvoices (validInvoices, serviceContext);

		// Resources
		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addEntryResources(
				retVal, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}
		else {
			addEntryResources(
				retVal, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}


		// Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(Invoices.class);

		indexer.reindex(retVal);
		return retVal;
	}

	public Invoices updateInvoices (Invoices validInvoices, ServiceContext serviceContext) throws PortalException, SystemException {
	
		Invoices entry = invoicesPersistence.findByPrimaryKey(validInvoices.getPrimaryKey());
		validInvoices.setCreateDate(entry.getCreateDate());	
     	User user = userPersistence.findByPrimaryKey(validInvoices.getUserId());
		validInvoices.setUserName(user.getFullName());	

		validInvoices.setModifiedDate(serviceContext.getModifiedDate(null));

		Invoices retVal = invoicesPersistence.update(validInvoices);

		// Resources

		if ((serviceContext.getGroupPermissions() != null) ||
				(serviceContext.getGuestPermissions() != null)) {

			updateEntryResources(
				retVal, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		
		//Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(Invoices.class);

		indexer.reindex(retVal);

		return retVal;
	}

	private Invoices _addInvoices (Invoices validInvoices, ServiceContext serviceContext) throws PortalException, SystemException {
		Invoices fileobj = invoicesPersistence.create(counterLocalService.increment(Invoices.class.getName()));

	     	User user = userPersistence.findByPrimaryKey(validInvoices.getUserId());

	     	Date now =new Date();
	    	fileobj.setCompanyId(validInvoices.getCompanyId());
	    	fileobj.setGroupId(validInvoices.getGroupId());
	    	fileobj.setUserId(user.getUserId());
	    	fileobj.setUserName(user.getFullName());
	    	fileobj.setCreateDate(now);
	    	fileobj.setModifiedDate(now);


	    	fileobj.setCustomerId(validInvoices.getCustomerId());
	    	fileobj.setDate(validInvoices.getDate());
	    	fileobj.setAmount(validInvoices.getAmount());
	    	fileobj.setPaid(validInvoices.isPaid());

	 		return invoicesPersistence.update(fileobj);
	}

	public void deleteInvoicesEntry (Invoices fileobj) throws PortalException, SystemException {

		invoicesPersistence.remove(fileobj.getPrimaryKey());

		// Resources

		resourceLocalService.deleteResource(
			fileobj.getCompanyId(), Invoices.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, fileobj.getPrimaryKey());

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Invoices.class);

		indexer.delete(fileobj);


	}



	public void addEntryResources(
			Invoices entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			Invoices.class.getName(), entry.getPrimaryKey(), false,
			addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			Invoices entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			Invoices.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		Invoices entry = invoicesPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			long entryId, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		Invoices entry = invoicesPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, groupPermissions, guestPermissions);
	}

	public void updateEntryResources(
			Invoices entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.updateResources(
			entry.getCompanyId(), entry.getGroupId(),
			Invoices.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}
}
