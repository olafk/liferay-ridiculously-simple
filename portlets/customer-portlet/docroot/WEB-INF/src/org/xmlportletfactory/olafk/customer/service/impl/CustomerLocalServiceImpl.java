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

import org.xmlportletfactory.olafk.customer.NoSuchCustomerException;
import org.xmlportletfactory.olafk.customer.model.Customer;
import org.xmlportletfactory.olafk.customer.service.base.CustomerLocalServiceBaseImpl;
import org.xmlportletfactory.olafk.customer.util.CustomerIndexer;
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

// needed for Customer detail-file Invoices
import org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil;
import org.xmlportletfactory.olafk.customer.model.Invoices;

/**
 * @author Jack A. Rider
 * @author Juan Gonzalez P.
 */
public class CustomerLocalServiceImpl extends CustomerLocalServiceBaseImpl {

	@SuppressWarnings("unchecked")
	public List<Customer> getCompanyEntries(
			long companyId, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		return customerPersistence.findByCompanyId(
				companyId, start, end, obc);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCompanyEntries(
			long companyId, int start, int end)
		throws SystemException {

		return customerPersistence.findByCompanyId(
				companyId, start, end);
	}

	@SuppressWarnings("unchecked")
	public int getCompanyEntriesCount(
			long companyId)
		throws SystemException {

		return customerPersistence.countByCompanyId(companyId);
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId)throws SystemException {
		List<Customer> list = (List<Customer>) customerPersistence.findByUserId(userId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUser(long userId)throws SystemException {
		int count = customerPersistence.countByUserId(userId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, OrderByComparator orderByComparator) throws SystemException {

		List<Customer> list = (List<Customer>) findAllInUser(userId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<Customer> list = (List<Customer>) customerPersistence.findByUserId(userId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId) throws SystemException {
		List<Customer> list = (List<Customer>) customerPersistence.filterFindByGroupId(groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInGroup(long groupId) throws SystemException {
		int count = customerPersistence.filterCountByGroupId(groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, OrderByComparator orderByComparator) throws SystemException{
		List <Customer> list = (List<Customer>) findAllInGroup (groupId, QueryUtil.ALL_POS,QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException{
		List <Customer> list = (List<Customer>) customerPersistence.filterFindByGroupId(groupId, start, end, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId) throws SystemException {
		List<Customer> list = (List<Customer>) customerPersistence.filterFindByUserIdGroupId(userId, groupId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public int countAllInUserAndGroup(long userId, long groupId) throws SystemException {
		int count = customerPersistence.filterCountByUserIdGroupId(userId, groupId);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, OrderByComparator orderByComparator) throws SystemException {

		List<Customer> list = (List<Customer>) findAllInUserAndGroup(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		List<Customer> list = (List<Customer>) customerPersistence.filterFindByUserIdGroupId(userId, groupId, start, end, orderByComparator);
		return list;
	}




	public Customer addCustomer (Customer validCustomer, ServiceContext serviceContext) throws PortalException, SystemException {
	    Customer retVal = _addCustomer (validCustomer, serviceContext);

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
		Indexer indexer = IndexerRegistryUtil.getIndexer(Customer.class);

		indexer.reindex(retVal);
		return retVal;
	}

	public Customer updateCustomer (Customer validCustomer, ServiceContext serviceContext) throws PortalException, SystemException {
	
		Customer entry = customerPersistence.findByPrimaryKey(validCustomer.getPrimaryKey());
		validCustomer.setCreateDate(entry.getCreateDate());	
     	User user = userPersistence.findByPrimaryKey(validCustomer.getUserId());
		validCustomer.setUserName(user.getFullName());	

		validCustomer.setModifiedDate(serviceContext.getModifiedDate(null));

		Customer retVal = customerPersistence.update(validCustomer);

		// Resources

		if ((serviceContext.getGroupPermissions() != null) ||
				(serviceContext.getGuestPermissions() != null)) {

			updateEntryResources(
				retVal, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		
		//Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(Customer.class);

		indexer.reindex(retVal);

		return retVal;
	}

	private Customer _addCustomer (Customer validCustomer, ServiceContext serviceContext) throws PortalException, SystemException {
		Customer fileobj = customerPersistence.create(counterLocalService.increment(Customer.class.getName()));

	     	User user = userPersistence.findByPrimaryKey(validCustomer.getUserId());

	     	Date now =new Date();
	    	fileobj.setCompanyId(validCustomer.getCompanyId());
	    	fileobj.setGroupId(validCustomer.getGroupId());
	    	fileobj.setUserId(user.getUserId());
	    	fileobj.setUserName(user.getFullName());
	    	fileobj.setCreateDate(now);
	    	fileobj.setModifiedDate(now);


	    	fileobj.setName(validCustomer.getName());
	    	fileobj.setStreet(validCustomer.getStreet());
	    	fileobj.setCity(validCustomer.getCity());
	    	fileobj.setZip(validCustomer.getZip());

	 		return customerPersistence.update(fileobj);
	}

	public void deleteCustomerEntry (Customer fileobj) throws PortalException, SystemException {

		customerPersistence.remove(fileobj.getPrimaryKey());

		// Resources

		resourceLocalService.deleteResource(
			fileobj.getCompanyId(), Customer.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, fileobj.getPrimaryKey());

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Customer.class);

		indexer.delete(fileobj);

    	deleteDetailInvoices(fileobj);

	}


	public void deleteDetailInvoices(Customer fileobj)  throws PortalException, SystemException {
		long entityId = fileobj.getCustomerId();
		List<Invoices> listEntities = InvoicesLocalServiceUtil.findAllIncustomerId(entityId);
		for(Invoices entity: listEntities){
			InvoicesLocalServiceUtil.deleteInvoicesEntry(entity);
		}
	}


	public void addEntryResources(
			Customer entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			Customer.class.getName(), entry.getPrimaryKey(), false,
			addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			Customer entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(),
			Customer.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}

	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		Customer entry = customerPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(
			long entryId, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		Customer entry = customerPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, groupPermissions, guestPermissions);
	}

	public void updateEntryResources(
			Customer entry, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.updateResources(
			entry.getCompanyId(), entry.getGroupId(),
			Customer.class.getName(), entry.getPrimaryKey(), groupPermissions,
			guestPermissions);
	}
}
