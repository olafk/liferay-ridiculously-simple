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

import com.liferay.portal.service.persistence.BasePersistence;

import org.xmlportletfactory.olafk.customer.model.Invoices;

/**
 * The persistence interface for the invoices service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see InvoicesPersistenceImpl
 * @see InvoicesUtil
 * @generated
 */
public interface InvoicesPersistence extends BasePersistence<Invoices> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvoicesUtil} to access the invoices persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the invoiceses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the first invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the last invoices in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] findByGroupId_PrevAndNext(
		long invoiceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns all the invoiceses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] filterFindByGroupId_PrevAndNext(
		long invoiceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Removes all the invoiceses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invoiceses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the first invoices in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the last invoices in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] findByUserIdGroupId_PrevAndNext(
		long invoiceId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns all the invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] filterFindByUserIdGroupId_PrevAndNext(
		long invoiceId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Removes all the invoiceses where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invoiceses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the first invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the last invoices in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] findByUserId_PrevAndNext(
		long invoiceId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Removes all the invoiceses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invoiceses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the first invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the last invoices in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] findByCompanyId_PrevAndNext(
		long invoiceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Removes all the invoiceses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invoiceses where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerId(
		long customerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerId(
		long customerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerId(
		long customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerId_First(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the first invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerId_First(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerId_Last(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the last invoices in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerId_Last(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] findByCustomerId_PrevAndNext(
		long invoiceId, long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Removes all the invoiceses where customerId = &#63; from the database.
	*
	* @param customerId the customer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invoiceses where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerIdGroupId(
		long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerIdGroupId(
		long customerId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findByCustomerIdGroupId(
		long customerId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerIdGroupId_First(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the first invoices in the ordered set where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerIdGroupId_First(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices findByCustomerIdGroupId_Last(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the last invoices in the ordered set where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByCustomerIdGroupId_Last(
		long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] findByCustomerIdGroupId_PrevAndNext(
		long invoiceId, long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns all the invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByCustomerIdGroupId(
		long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByCustomerIdGroupId(
		long customerId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> filterFindByCustomerIdGroupId(
		long customerId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.xmlportletfactory.olafk.customer.model.Invoices[] filterFindByCustomerIdGroupId_PrevAndNext(
		long invoiceId, long customerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Removes all the invoiceses where customerId = &#63; and groupId = &#63; from the database.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCustomerIdGroupId(long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the number of matching invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCustomerIdGroupId(long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	*
	* @param customerId the customer ID
	* @param groupId the group ID
	* @return the number of matching invoiceses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCustomerIdGroupId(long customerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the invoices in the entity cache if it is enabled.
	*
	* @param invoices the invoices
	*/
	public void cacheResult(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices);

	/**
	* Caches the invoiceses in the entity cache if it is enabled.
	*
	* @param invoiceses the invoiceses
	*/
	public void cacheResult(
		java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> invoiceses);

	/**
	* Creates a new invoices with the primary key. Does not add the invoices to the database.
	*
	* @param invoiceId the primary key for the new invoices
	* @return the new invoices
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices create(
		long invoiceId);

	/**
	* Removes the invoices with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices that was removed
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices remove(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	public org.xmlportletfactory.olafk.customer.model.Invoices updateImpl(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invoices with the primary key or throws a {@link org.xmlportletfactory.olafk.customer.NoSuchInvoicesException} if it could not be found.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices
	* @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices findByPrimaryKey(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;

	/**
	* Returns the invoices with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param invoiceId the primary key of the invoices
	* @return the invoices, or <code>null</code> if a invoices with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.xmlportletfactory.olafk.customer.model.Invoices fetchByPrimaryKey(
		long invoiceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invoiceses.
	*
	* @return the invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.xmlportletfactory.olafk.customer.model.Invoices> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the invoiceses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invoiceses.
	*
	* @return the number of invoiceses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}