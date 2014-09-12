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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Invoices. This utility wraps
 * {@link org.xmlportletfactory.olafk.customer.service.impl.InvoicesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jack A. Rider
 * @see InvoicesLocalService
 * @see org.xmlportletfactory.olafk.customer.service.base.InvoicesLocalServiceBaseImpl
 * @see org.xmlportletfactory.olafk.customer.service.impl.InvoicesLocalServiceImpl
 * @generated
 */
public class InvoicesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.xmlportletfactory.olafk.customer.service.impl.InvoicesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the invoices to the database. Also notifies the appropriate model listeners.
	*
	* @param invoices the invoices
	* @return the invoices that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices addInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addInvoices(invoices);
	}

	/**
	* Creates a new invoices with the primary key. Does not add the invoices to the database.
	*
	* @param invoiceId the primary key for the new invoices
	* @return the new invoices
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices createInvoices(
		long invoiceId) {
		return getService().createInvoices(invoiceId);
	}

	/**
	* Deletes the invoices with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices that was removed
	* @throws PortalException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices deleteInvoices(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInvoices(invoiceId);
	}

	/**
	* Deletes the invoices from the database. Also notifies the appropriate model listeners.
	*
	* @param invoices the invoices
	* @return the invoices that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices deleteInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInvoices(invoices);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchInvoices(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchInvoices(invoiceId);
	}

	/**
	* Returns the invoices with the primary key.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices
	* @throws PortalException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices getInvoices(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getInvoices(invoiceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> getInvoiceses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInvoiceses(start, end);
	}

	/**
	* Returns the number of invoiceses.
	*
	* @return the number of invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int getInvoicesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInvoicesesCount();
	}

	/**
	* Updates the invoices in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invoices the invoices
	* @return the invoices that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices updateInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInvoices(invoices);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> getCompanyEntries(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyEntries(companyId, start, end, obc);
	}

	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> getCompanyEntries(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyEntries(companyId, start, end);
	}

	public static int getCompanyEntriesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyEntriesCount(companyId);
	}

	public static java.util.List findAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInUser(userId);
	}

	public static int countAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAllInUser(userId);
	}

	public static java.util.List findAllInUser(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInUser(userId, orderByComparator);
	}

	public static java.util.List findAllInUser(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInUser(userId, start, end, orderByComparator);
	}

	public static java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInGroup(groupId);
	}

	public static int countAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAllInGroup(groupId);
	}

	public static java.util.List findAllInGroup(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInGroup(groupId, orderByComparator);
	}

	public static java.util.List findAllInGroup(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllInGroup(groupId, start, end, orderByComparator);
	}

	public static java.util.List findAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllInUserAndGroup(userId, groupId);
	}

	public static int countAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAllInUserAndGroup(userId, groupId);
	}

	public static java.util.List findAllInUserAndGroup(long userId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllInUserAndGroup(userId, groupId, orderByComparator);
	}

	public static java.util.List findAllInUserAndGroup(long userId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllInUserAndGroup(userId, groupId, start, end,
			orderByComparator);
	}

	public static java.util.List findAllIncustomerIdGroup(long customerId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllIncustomerIdGroup(customerId, groupId);
	}

	public static java.util.List findAllIncustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllIncustomerId(customerId);
	}

	public static java.util.List findAllIncustomerIdGroup(long customerId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllIncustomerIdGroup(customerId, groupId,
			orderByComparator);
	}

	public static org.xmlportletfactory.olafk.customer.model.Invoices addInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices validInvoices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addInvoices(validInvoices, serviceContext);
	}

	public static org.xmlportletfactory.olafk.customer.model.Invoices updateInvoices(
		org.xmlportletfactory.olafk.customer.model.Invoices validInvoices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInvoices(validInvoices, serviceContext);
	}

	public static void deleteInvoicesEntry(
		org.xmlportletfactory.olafk.customer.model.Invoices fileobj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteInvoicesEntry(fileobj);
	}

	public static void addEntryResources(
		org.xmlportletfactory.olafk.customer.model.Invoices entry,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	public static void addEntryResources(
		org.xmlportletfactory.olafk.customer.model.Invoices entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addEntryResources(entry, groupPermissions, guestPermissions);
	}

	public static void addEntryResources(long entryId,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entryId, addGroupPermissions, addGuestPermissions);
	}

	public static void addEntryResources(long entryId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entryId, groupPermissions, guestPermissions);
	}

	public static void updateEntryResources(
		org.xmlportletfactory.olafk.customer.model.Invoices entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateEntryResources(entry, groupPermissions, guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static InvoicesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					InvoicesLocalService.class.getName());

			if (invokableLocalService instanceof InvoicesLocalService) {
				_service = (InvoicesLocalService)invokableLocalService;
			}
			else {
				_service = new InvoicesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(InvoicesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(InvoicesLocalService service) {
	}

	private static InvoicesLocalService _service;
}