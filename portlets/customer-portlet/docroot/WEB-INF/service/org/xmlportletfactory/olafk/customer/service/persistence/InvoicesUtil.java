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

package org.xmlportletfactory.olafk.customer.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.xmlportletfactory.olafk.customer.model.Invoices;

import java.util.List;

/**
 * The persistence utility for the invoices service. This utility wraps {@link InvoicesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see InvoicesPersistence
 * @see InvoicesPersistenceImpl
 * @generated
 */
public class InvoicesUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Invoices invoices) {
		getPersistence().clearCache(invoices);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Invoices> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Invoices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Invoices> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Invoices update(Invoices invoices) throws SystemException {
		return getPersistence().update(invoices);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Invoices update(Invoices invoices,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(invoices, serviceContext);
	}

	/**
	* Returns all the invoiceses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the invoiceses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set where groupId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] findByGroupId_PrevAndNext(
		long invoiceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(invoiceId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the invoiceses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the invoiceses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set of invoiceses that the user has permission to view where groupId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] filterFindByGroupId_PrevAndNext(
		long invoiceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(invoiceId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the invoiceses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of invoiceses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of invoiceses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the invoiceses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the invoiceses where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByUserIdGroupId_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupId_First(userId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] findByUserIdGroupId_PrevAndNext(
		long invoiceId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByUserIdGroupId_PrevAndNext(invoiceId, userId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses that the user has permissions to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set of invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] filterFindByUserIdGroupId_PrevAndNext(
		long invoiceId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .filterFindByUserIdGroupId_PrevAndNext(invoiceId, userId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the invoiceses where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of invoiceses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns all the invoiceses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the invoiceses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set where userId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] findByUserId_PrevAndNext(
		long invoiceId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByUserId_PrevAndNext(invoiceId, userId,
			orderByComparator);
	}

	/**
	* Removes all the invoiceses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of invoiceses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the invoiceses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the invoiceses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set where companyId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] findByCompanyId_PrevAndNext(
		long invoiceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(invoiceId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the invoiceses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of invoiceses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the invoiceses where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerId(
		long customerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCustomerId(customerId);
	}

	/**
	* Returns a range of all the invoiceses where customerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerId(
		long customerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCustomerId(customerId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses where customerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerId(
		long customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCustomerId(customerId, start, end, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerId_First(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCustomerId_First(customerId, orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerId_First(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCustomerId_First(customerId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerId_Last(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCustomerId_Last(customerId, orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerId_Last(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCustomerId_Last(customerId, orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set where customerId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] findByCustomerId_PrevAndNext(
		long invoiceId, long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCustomerId_PrevAndNext(invoiceId, customerId,
			orderByComparator);
	}

	/**
	* Removes all the invoiceses where customerId = &#63; from the database.
	*
	* @param customerId the customer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCustomerId(customerId);
	}

	/**
	* Returns the number of invoiceses where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCustomerId(customerId);
	}

	/**
	* Returns all the invoiceses where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerIdGroupId(
		long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCustomerIdGroupId(customerId, groupId);
	}

	/**
	* Returns a range of all the invoiceses where customerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerIdGroupId(
		long customerId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCustomerIdGroupId(customerId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses where customerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerIdGroupId(
		long customerId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCustomerIdGroupId(customerId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerIdGroupId_First(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCustomerIdGroupId_First(customerId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first invoices in the ordered set where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerIdGroupId_First(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCustomerIdGroupId_First(customerId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerIdGroupId_Last(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCustomerIdGroupId_Last(customerId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last invoices in the ordered set where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerIdGroupId_Last(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCustomerIdGroupId_Last(customerId, groupId,
			orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set where customerId = &#63; and groupId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] findByCustomerIdGroupId_PrevAndNext(
		long invoiceId, long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .findByCustomerIdGroupId_PrevAndNext(invoiceId, customerId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByCustomerIdGroupId(
		long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCustomerIdGroupId(customerId, groupId);
	}

	/**
	* Returns a range of all the invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @return the range of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByCustomerIdGroupId(
		long customerId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCustomerIdGroupId(customerId, groupId, start,
			end);
	}

	/**
	* Returns an ordered range of all the invoiceses that the user has permissions to view where customerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByCustomerIdGroupId(
		long customerId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCustomerIdGroupId(customerId, groupId, start,
			end, orderByComparator);
	}

	/**
	* Returns the invoiceses before and after the current invoices in the ordered set of invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	*
	* @param invoiceId the primary key of the current invoices
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices[] filterFindByCustomerIdGroupId_PrevAndNext(
		long invoiceId, long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence()
				   .filterFindByCustomerIdGroupId_PrevAndNext(invoiceId,
			customerId, groupId, orderByComparator);
	}

	/**
	* Removes all the invoiceses where customerId = &#63; and groupId = &#63; from the database.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCustomerIdGroupId(long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCustomerIdGroupId(customerId, groupId);
	}

	/**
	* Returns the number of invoiceses where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCustomerIdGroupId(long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCustomerIdGroupId(customerId, groupId);
	}

	/**
	* Returns the number of invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the number of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCustomerIdGroupId(long customerId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCustomerIdGroupId(customerId, groupId);
	}

	/**
	* Caches the invoices in the entity cache if it is enabled.
	*
	* @param invoices the invoices
	*/
	public static void cacheResult(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices) {
		getPersistence().cacheResult(invoices);
	}

	/**
	* Caches the invoiceses in the entity cache if it is enabled.
	*
	* @param invoiceses the invoiceses
	*/
	public static void cacheResult(
		java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> invoiceses) {
		getPersistence().cacheResult(invoiceses);
	}

	/**
	* Creates a new invoices with the primary key. Does not add the invoices to the database.
	*
	* @param invoiceId the primary key for the new invoices
	* @return the new invoices
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices create(
		long invoiceId) {
		return getPersistence().create(invoiceId);
	}

	/**
	* Removes the invoices with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices that was removed
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices remove(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence().remove(invoiceId);
	}

	public static org.xmlportletfactory.olafk.customer.model.Invoices updateImpl(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(invoices);
	}

	/**
	* Returns the invoices with the primary key or throws a {@link org.xmlportletfactory.olafk.customer.NoSuchInvoicesException} if it could not be found.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices findByPrimaryKey(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException {
		return getPersistence().findByPrimaryKey(invoiceId);
	}

	/**
	* Returns the invoices with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices, or <code>null</code> if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.xmlportletfactory.olafk.customer.model.Invoices fetchByPrimaryKey(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(invoiceId);
	}

	/**
	* Returns all the invoiceses.
	*
	* @return the invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the invoiceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invoiceses
	* @param end the upper bound of the range of invoiceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the invoiceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of invoiceses.
	*
	* @return the number of invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InvoicesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InvoicesPersistence)PortletBeanLocatorUtil.locate(org.xmlportletfactory.olafk.customer.service.ClpSerializer.getServletContextName(),
					InvoicesPersistence.class.getName());

			ReferenceRegistry.registerReference(InvoicesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(InvoicesPersistence persistence) {
	}

	private static InvoicesPersistence _persistence;
}