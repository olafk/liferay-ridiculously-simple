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

package org.xmlportletfactory.olafk.customer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvoicesLocalService}.
 *
 * @author Jack A. Rider
 * @see InvoicesLocalService
 * @generated
 */
public class InvoicesLocalServiceWrapper implements InvoicesLocalService,
	ServiceWrapper<InvoicesLocalService> {
	public InvoicesLocalServiceWrapper(
		InvoicesLocalService invoicesLocalService) {
		_invoicesLocalService = invoicesLocalService;
	}

	/**
	* Adds the invoices to the database. Also notifies the appropriate model listeners.
	*
	* @param invoices the invoices
	* @return the invoices that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices addInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.addInvoices(invoices);
	}

	/**
	* Creates a new invoices with the primary key. Does not add the invoices to the database.
	*
	* @param invoiceId the primary key for the new invoices
	* @return the new invoices
	*/
	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices createInvoices(
		long invoiceId) {
		return _invoicesLocalService.createInvoices(invoiceId);
	}

	/**
	* Deletes the invoices with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices that was removed
	* @throws PortalException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices deleteInvoices(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.deleteInvoices(invoiceId);
	}

	/**
	* Deletes the invoices from the database. Also notifies the appropriate model listeners.
	*
	* @param invoices the invoices
	* @return the invoices that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices deleteInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.deleteInvoices(invoices);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invoicesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchInvoices(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.fetchInvoices(invoiceId);
	}

	/**
	* Returns the invoices with the primary key.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices
	* @throws PortalException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices getInvoices(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.getInvoices(invoiceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the invoiceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of invoiceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> getInvoiceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.getInvoiceses(start, end);
	}

	/**
	* Returns the number of invoiceses.
	*
	* @return the number of invoiceses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getInvoicesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.getInvoicesesCount();
	}

	/**
	* Updates the invoices in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invoices the invoices
	* @return the invoices that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices updateInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.updateInvoices(invoices);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _invoicesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_invoicesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _invoicesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> getCompanyEntries(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.getCompanyEntries(companyId, start, end,
			obc);
	}

	@Override
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> getCompanyEntries(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.getCompanyEntries(companyId, start, end);
	}

	@Override
	public int getCompanyEntriesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.getCompanyEntriesCount(companyId);
	}

	@Override
	public java.util.List findAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.countAllInUser(userId);
	}

	@Override
	public java.util.List findAllInUser(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInUser(userId, orderByComparator);
	}

	@Override
	public java.util.List findAllInUser(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInUser(userId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.countAllInGroup(groupId);
	}

	@Override
	public java.util.List findAllInGroup(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInGroup(groupId, orderByComparator);
	}

	@Override
	public java.util.List findAllInGroup(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInGroup(groupId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List findAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInUserAndGroup(userId, groupId,
			orderByComparator);
	}

	@Override
	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllInUserAndGroup(userId, groupId,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List findAllIncustomerIdGroup(long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllIncustomerIdGroup(customerId,
			groupId);
	}

	@Override
	public java.util.List findAllIncustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllIncustomerId(customerId);
	}

	@Override
	public java.util.List findAllIncustomerIdGroup(long customerId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.findAllIncustomerIdGroup(customerId,
			groupId, orderByComparator);
	}

	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices addInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices validInvoices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.addInvoices(validInvoices, serviceContext);
	}

	@Override
	public org.xmlportletfactory.olafk.customer.model.Invoices updateInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices validInvoices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invoicesLocalService.updateInvoices(validInvoices,
			serviceContext);
	}

	@Override
	public void deleteInvoicesEntry(
		org.xmlportletfactory.olafk.customer.model.Invoices fileobj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_invoicesLocalService.deleteInvoicesEntry(fileobj);
	}

	@Override
	public void addEntryResources(
		org.xmlportletfactory.olafk.customer.model.Invoices entry,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_invoicesLocalService.addEntryResources(entry, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addEntryResources(
		org.xmlportletfactory.olafk.customer.model.Invoices entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_invoicesLocalService.addEntryResources(entry, groupPermissions,
			guestPermissions);
	}

	@Override
	public void addEntryResources(long entryId, boolean addGroupPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_invoicesLocalService.addEntryResources(entryId, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addEntryResources(long entryId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_invoicesLocalService.addEntryResources(entryId, groupPermissions,
			guestPermissions);
	}

	@Override
	public void updateEntryResources(
		org.xmlportletfactory.olafk.customer.model.Invoices entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_invoicesLocalService.updateEntryResources(entry, groupPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InvoicesLocalService getWrappedInvoicesLocalService() {
		return _invoicesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInvoicesLocalService(
		InvoicesLocalService invoicesLocalService) {
		_invoicesLocalService = invoicesLocalService;
	}

	@Override
	public InvoicesLocalService getWrappedService() {
		return _invoicesLocalService;
	}

	@Override
	public void setWrappedService(InvoicesLocalService invoicesLocalService) {
		_invoicesLocalService = invoicesLocalService;
	}

	private InvoicesLocalService _invoicesLocalService;
}