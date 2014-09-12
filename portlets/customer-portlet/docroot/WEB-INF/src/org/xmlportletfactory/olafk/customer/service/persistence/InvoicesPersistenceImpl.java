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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.xmlportletfactory.olafk.customer.NoSuchInvoicesException;
import org.xmlportletfactory.olafk.customer.model.Invoices;
import org.xmlportletfactory.olafk.customer.model.impl.InvoicesImpl;
import org.xmlportletfactory.olafk.customer.model.impl.InvoicesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the invoices service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see InvoicesPersistence
 * @see InvoicesUtil
 * @generated
 */
public class InvoicesPersistenceImpl extends BasePersistenceImpl<Invoices>
	implements InvoicesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InvoicesUtil} to access the invoices persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InvoicesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			InvoicesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invoiceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Invoices> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Invoices> list = (List<Invoices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invoices invoices : list) {
				if ((groupId != invoices.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invoices>(list);
				}
				else {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Invoices findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByGroupId_First(groupId, orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the first invoices in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByGroupId_Last(groupId, orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the last invoices in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Invoices> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices[] findByGroupId_PrevAndNext(long invoiceId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, invoices, groupId,
					orderByComparator, true);

			array[1] = invoices;

			array[2] = getByGroupId_PrevAndNext(session, invoices, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices getByGroupId_PrevAndNext(Session session,
		Invoices invoices, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InvoicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the invoiceses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching invoiceses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<Invoices> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(InvoicesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, InvoicesImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, InvoicesImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Invoices>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Invoices[] filterFindByGroupId_PrevAndNext(long invoiceId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(invoiceId, groupId,
				orderByComparator);
		}

		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, invoices,
					groupId, orderByComparator, true);

			array[1] = invoices;

			array[2] = filterGetByGroupId_PrevAndNext(session, invoices,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices filterGetByGroupId_PrevAndNext(Session session,
		Invoices invoices, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(InvoicesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, InvoicesImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, InvoicesImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoiceses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Invoices invoices : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(invoices);
		}
	}

	/**
	 * Returns the number of invoiceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of invoiceses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching invoiceses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "invoices.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			InvoicesModelImpl.USERID_COLUMN_BITMASK |
			InvoicesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDGROUPID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the invoiceses where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> findByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		return findByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> findByUserIdGroupId(long userId, long groupId,
		int start, int end) throws SystemException {
		return findByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<Invoices> findByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Invoices> list = (List<Invoices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invoices invoices : list) {
				if ((userId != invoices.getUserId()) ||
						(groupId != invoices.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invoices>(list);
				}
				else {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Invoices findByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByUserIdGroupId_First(userId, groupId,
				orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
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
	@Override
	public Invoices fetchByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = findByUserIdGroupId(userId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices findByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByUserIdGroupId_Last(userId, groupId,
				orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
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
	@Override
	public Invoices fetchByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<Invoices> list = findByUserIdGroupId(userId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices[] findByUserIdGroupId_PrevAndNext(long invoiceId,
		long userId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(session, invoices,
					userId, groupId, orderByComparator, true);

			array[1] = invoices;

			array[2] = getByUserIdGroupId_PrevAndNext(session, invoices,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices getByUserIdGroupId_PrevAndNext(Session session,
		Invoices invoices, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InvoicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching invoiceses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> filterFindByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		return filterFindByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> filterFindByUserIdGroupId(long userId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<Invoices> filterFindByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId(userId, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(InvoicesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, InvoicesImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, InvoicesImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			return (List<Invoices>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Invoices[] filterFindByUserIdGroupId_PrevAndNext(long invoiceId,
		long userId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(invoiceId, userId, groupId,
				orderByComparator);
		}

		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(session, invoices,
					userId, groupId, orderByComparator, true);

			array[1] = invoices;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(session, invoices,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices filterGetByUserIdGroupId_PrevAndNext(Session session,
		Invoices invoices, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(InvoicesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, InvoicesImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, InvoicesImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoiceses where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		for (Invoices invoices : findByUserIdGroupId(userId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(invoices);
		}
	}

	/**
	 * Returns the number of invoiceses where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDGROUPID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of invoiceses that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching invoiceses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 = "invoices.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 = "invoices.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			InvoicesModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invoiceses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Invoices> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Invoices> list = (List<Invoices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invoices invoices : list) {
				if ((userId != invoices.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invoices>(list);
				}
				else {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Invoices findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByUserId_First(userId, orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the first invoices in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByUserId_Last(userId, orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the last invoices in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Invoices> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices[] findByUserId_PrevAndNext(long invoiceId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = getByUserId_PrevAndNext(session, invoices, userId,
					orderByComparator, true);

			array[1] = invoices;

			array[2] = getByUserId_PrevAndNext(session, invoices, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices getByUserId_PrevAndNext(Session session,
		Invoices invoices, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InvoicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoiceses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (Invoices invoices : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(invoices);
		}
	}

	/**
	 * Returns the number of invoiceses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "invoices.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			InvoicesModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invoiceses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Invoices> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<Invoices> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Invoices> list = (List<Invoices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invoices invoices : list) {
				if ((companyId != invoices.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invoices>(list);
				}
				else {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Invoices findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByCompanyId_First(companyId, orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the first invoices in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByCompanyId_Last(companyId, orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the last invoices in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Invoices> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices[] findByCompanyId_PrevAndNext(long invoiceId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, invoices, companyId,
					orderByComparator, true);

			array[1] = invoices;

			array[2] = getByCompanyId_PrevAndNext(session, invoices, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices getByCompanyId_PrevAndNext(Session session,
		Invoices invoices, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InvoicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoiceses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Invoices invoices : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(invoices);
		}
	}

	/**
	 * Returns the number of invoiceses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "invoices.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomerId",
			new String[] { Long.class.getName() },
			InvoicesModelImpl.CUSTOMERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the invoiceses where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> findByCustomerId(long customerId)
		throws SystemException {
		return findByCustomerId(customerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> findByCustomerId(long customerId, int start, int end)
		throws SystemException {
		return findByCustomerId(customerId, start, end, null);
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
	@Override
	public List<Invoices> findByCustomerId(long customerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID;
			finderArgs = new Object[] { customerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERID;
			finderArgs = new Object[] { customerId, start, end, orderByComparator };
		}

		List<Invoices> list = (List<Invoices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invoices invoices : list) {
				if ((customerId != invoices.getCustomerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				if (!pagination) {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invoices>(list);
				}
				else {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Invoices findByCustomerId_First(long customerId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByCustomerId_First(customerId,
				orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerId=");
		msg.append(customerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the first invoices in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByCustomerId_First(long customerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Invoices> list = findByCustomerId(customerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices findByCustomerId_Last(long customerId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByCustomerId_Last(customerId, orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerId=");
		msg.append(customerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
	}

	/**
	 * Returns the last invoices in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoices, or <code>null</code> if a matching invoices could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByCustomerId_Last(long customerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCustomerId(customerId);

		if (count == 0) {
			return null;
		}

		List<Invoices> list = findByCustomerId(customerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices[] findByCustomerId_PrevAndNext(long invoiceId,
		long customerId, OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = getByCustomerId_PrevAndNext(session, invoices,
					customerId, orderByComparator, true);

			array[1] = invoices;

			array[2] = getByCustomerId_PrevAndNext(session, invoices,
					customerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices getByCustomerId_PrevAndNext(Session session,
		Invoices invoices, long customerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InvoicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(customerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoiceses where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCustomerId(long customerId) throws SystemException {
		for (Invoices invoices : findByCustomerId(customerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(invoices);
		}
	}

	/**
	 * Returns the number of invoiceses where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCustomerId(long customerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMERID;

		Object[] finderArgs = new Object[] { customerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2 = "invoices.customerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERIDGROUPID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomerIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDGROUPID =
		new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, InvoicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCustomerIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			InvoicesModelImpl.CUSTOMERID_COLUMN_BITMASK |
			InvoicesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERIDGROUPID = new FinderPath(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCustomerIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the invoiceses where customerId = &#63; and groupId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param groupId the group ID
	 * @return the matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> findByCustomerIdGroupId(long customerId, long groupId)
		throws SystemException {
		return findByCustomerIdGroupId(customerId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> findByCustomerIdGroupId(long customerId,
		long groupId, int start, int end) throws SystemException {
		return findByCustomerIdGroupId(customerId, groupId, start, end, null);
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
	@Override
	public List<Invoices> findByCustomerIdGroupId(long customerId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDGROUPID;
			finderArgs = new Object[] { customerId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERIDGROUPID;
			finderArgs = new Object[] {
					customerId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Invoices> list = (List<Invoices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Invoices invoices : list) {
				if ((customerId != invoices.getCustomerId()) ||
						(groupId != invoices.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_CUSTOMERID_2);

			query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invoices>(list);
				}
				else {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Invoices findByCustomerIdGroupId_First(long customerId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByCustomerIdGroupId_First(customerId, groupId,
				orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerId=");
		msg.append(customerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
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
	@Override
	public Invoices fetchByCustomerIdGroupId_First(long customerId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Invoices> list = findByCustomerIdGroupId(customerId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices findByCustomerIdGroupId_Last(long customerId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByCustomerIdGroupId_Last(customerId, groupId,
				orderByComparator);

		if (invoices != null) {
			return invoices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerId=");
		msg.append(customerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInvoicesException(msg.toString());
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
	@Override
	public Invoices fetchByCustomerIdGroupId_Last(long customerId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCustomerIdGroupId(customerId, groupId);

		if (count == 0) {
			return null;
		}

		List<Invoices> list = findByCustomerIdGroupId(customerId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Invoices[] findByCustomerIdGroupId_PrevAndNext(long invoiceId,
		long customerId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = getByCustomerIdGroupId_PrevAndNext(session, invoices,
					customerId, groupId, orderByComparator, true);

			array[1] = invoices;

			array[2] = getByCustomerIdGroupId_PrevAndNext(session, invoices,
					customerId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices getByCustomerIdGroupId_PrevAndNext(Session session,
		Invoices invoices, long customerId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_CUSTOMERID_2);

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(InvoicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(customerId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param groupId the group ID
	 * @return the matching invoiceses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> filterFindByCustomerIdGroupId(long customerId,
		long groupId) throws SystemException {
		return filterFindByCustomerIdGroupId(customerId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Invoices> filterFindByCustomerIdGroupId(long customerId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByCustomerIdGroupId(customerId, groupId, start, end,
			null);
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
	@Override
	public List<Invoices> filterFindByCustomerIdGroupId(long customerId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCustomerIdGroupId(customerId, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_CUSTOMERID_2);

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(InvoicesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, InvoicesImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, InvoicesImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(customerId);

			qPos.add(groupId);

			return (List<Invoices>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Invoices[] filterFindByCustomerIdGroupId_PrevAndNext(
		long invoiceId, long customerId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInvoicesException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCustomerIdGroupId_PrevAndNext(invoiceId, customerId,
				groupId, orderByComparator);
		}

		Invoices invoices = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoices[] array = new InvoicesImpl[3];

			array[0] = filterGetByCustomerIdGroupId_PrevAndNext(session,
					invoices, customerId, groupId, orderByComparator, true);

			array[1] = invoices;

			array[2] = filterGetByCustomerIdGroupId_PrevAndNext(session,
					invoices, customerId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoices filterGetByCustomerIdGroupId_PrevAndNext(
		Session session, Invoices invoices, long customerId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_CUSTOMERID_2);

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(InvoicesModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(InvoicesModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, InvoicesImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, InvoicesImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(customerId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(invoices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Invoices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoiceses where customerId = &#63; and groupId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCustomerIdGroupId(long customerId, long groupId)
		throws SystemException {
		for (Invoices invoices : findByCustomerIdGroupId(customerId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(invoices);
		}
	}

	/**
	 * Returns the number of invoiceses where customerId = &#63; and groupId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param groupId the group ID
	 * @return the number of matching invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCustomerIdGroupId(long customerId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMERIDGROUPID;

		Object[] finderArgs = new Object[] { customerId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INVOICES_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_CUSTOMERID_2);

			query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of invoiceses that the user has permission to view where customerId = &#63; and groupId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param groupId the group ID
	 * @return the number of matching invoiceses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCustomerIdGroupId(long customerId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCustomerIdGroupId(customerId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_INVOICES_WHERE);

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_CUSTOMERID_2);

		query.append(_FINDER_COLUMN_CUSTOMERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Invoices.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(customerId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_CUSTOMERIDGROUPID_CUSTOMERID_2 = "invoices.customerId = ? AND ";
	private static final String _FINDER_COLUMN_CUSTOMERIDGROUPID_GROUPID_2 = "invoices.groupId = ?";

	public InvoicesPersistenceImpl() {
		setModelClass(Invoices.class);
	}

	/**
	 * Caches the invoices in the entity cache if it is enabled.
	 *
	 * @param invoices the invoices
	 */
	@Override
	public void cacheResult(Invoices invoices) {
		EntityCacheUtil.putResult(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesImpl.class, invoices.getPrimaryKey(), invoices);

		invoices.resetOriginalValues();
	}

	/**
	 * Caches the invoiceses in the entity cache if it is enabled.
	 *
	 * @param invoiceses the invoiceses
	 */
	@Override
	public void cacheResult(List<Invoices> invoiceses) {
		for (Invoices invoices : invoiceses) {
			if (EntityCacheUtil.getResult(
						InvoicesModelImpl.ENTITY_CACHE_ENABLED,
						InvoicesImpl.class, invoices.getPrimaryKey()) == null) {
				cacheResult(invoices);
			}
			else {
				invoices.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invoiceses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InvoicesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InvoicesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invoices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Invoices invoices) {
		EntityCacheUtil.removeResult(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesImpl.class, invoices.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Invoices> invoiceses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Invoices invoices : invoiceses) {
			EntityCacheUtil.removeResult(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
				InvoicesImpl.class, invoices.getPrimaryKey());
		}
	}

	/**
	 * Creates a new invoices with the primary key. Does not add the invoices to the database.
	 *
	 * @param invoiceId the primary key for the new invoices
	 * @return the new invoices
	 */
	@Override
	public Invoices create(long invoiceId) {
		Invoices invoices = new InvoicesImpl();

		invoices.setNew(true);
		invoices.setPrimaryKey(invoiceId);

		return invoices;
	}

	/**
	 * Removes the invoices with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceId the primary key of the invoices
	 * @return the invoices that was removed
	 * @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices remove(long invoiceId)
		throws NoSuchInvoicesException, SystemException {
		return remove((Serializable)invoiceId);
	}

	/**
	 * Removes the invoices with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invoices
	 * @return the invoices that was removed
	 * @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices remove(Serializable primaryKey)
		throws NoSuchInvoicesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Invoices invoices = (Invoices)session.get(InvoicesImpl.class,
					primaryKey);

			if (invoices == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvoicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(invoices);
		}
		catch (NoSuchInvoicesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Invoices removeImpl(Invoices invoices) throws SystemException {
		invoices = toUnwrappedModel(invoices);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invoices)) {
				invoices = (Invoices)session.get(InvoicesImpl.class,
						invoices.getPrimaryKeyObj());
			}

			if (invoices != null) {
				session.delete(invoices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (invoices != null) {
			clearCache(invoices);
		}

		return invoices;
	}

	@Override
	public Invoices updateImpl(
		org.xmlportletfactory.olafk.customer.model.Invoices invoices)
		throws SystemException {
		invoices = toUnwrappedModel(invoices);

		boolean isNew = invoices.isNew();

		InvoicesModelImpl invoicesModelImpl = (InvoicesModelImpl)invoices;

		Session session = null;

		try {
			session = openSession();

			if (invoices.isNew()) {
				session.save(invoices);

				invoices.setNew(false);
			}
			else {
				session.merge(invoices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InvoicesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((invoicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invoicesModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { invoicesModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((invoicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invoicesModelImpl.getOriginalUserId(),
						invoicesModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);

				args = new Object[] {
						invoicesModelImpl.getUserId(),
						invoicesModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);
			}

			if ((invoicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invoicesModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { invoicesModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((invoicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invoicesModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { invoicesModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((invoicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invoicesModelImpl.getOriginalCustomerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID,
					args);

				args = new Object[] { invoicesModelImpl.getCustomerId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID,
					args);
			}

			if ((invoicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						invoicesModelImpl.getOriginalCustomerId(),
						invoicesModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDGROUPID,
					args);

				args = new Object[] {
						invoicesModelImpl.getCustomerId(),
						invoicesModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
			InvoicesImpl.class, invoices.getPrimaryKey(), invoices);

		return invoices;
	}

	protected Invoices toUnwrappedModel(Invoices invoices) {
		if (invoices instanceof InvoicesImpl) {
			return invoices;
		}

		InvoicesImpl invoicesImpl = new InvoicesImpl();

		invoicesImpl.setNew(invoices.isNew());
		invoicesImpl.setPrimaryKey(invoices.getPrimaryKey());

		invoicesImpl.setInvoiceId(invoices.getInvoiceId());
		invoicesImpl.setCompanyId(invoices.getCompanyId());
		invoicesImpl.setGroupId(invoices.getGroupId());
		invoicesImpl.setUserId(invoices.getUserId());
		invoicesImpl.setUserName(invoices.getUserName());
		invoicesImpl.setCreateDate(invoices.getCreateDate());
		invoicesImpl.setModifiedDate(invoices.getModifiedDate());
		invoicesImpl.setCustomerId(invoices.getCustomerId());
		invoicesImpl.setDate(invoices.getDate());
		invoicesImpl.setAmount(invoices.getAmount());
		invoicesImpl.setPaid(invoices.isPaid());

		return invoicesImpl;
	}

	/**
	 * Returns the invoices with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the invoices
	 * @return the invoices
	 * @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvoicesException, SystemException {
		Invoices invoices = fetchByPrimaryKey(primaryKey);

		if (invoices == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvoicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return invoices;
	}

	/**
	 * Returns the invoices with the primary key or throws a {@link org.xmlportletfactory.olafk.customer.NoSuchInvoicesException} if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoices
	 * @return the invoices
	 * @throws org.xmlportletfactory.olafk.customer.NoSuchInvoicesException if a invoices with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices findByPrimaryKey(long invoiceId)
		throws NoSuchInvoicesException, SystemException {
		return findByPrimaryKey((Serializable)invoiceId);
	}

	/**
	 * Returns the invoices with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invoices
	 * @return the invoices, or <code>null</code> if a invoices with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Invoices invoices = (Invoices)EntityCacheUtil.getResult(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
				InvoicesImpl.class, primaryKey);

		if (invoices == _nullInvoices) {
			return null;
		}

		if (invoices == null) {
			Session session = null;

			try {
				session = openSession();

				invoices = (Invoices)session.get(InvoicesImpl.class, primaryKey);

				if (invoices != null) {
					cacheResult(invoices);
				}
				else {
					EntityCacheUtil.putResult(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
						InvoicesImpl.class, primaryKey, _nullInvoices);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InvoicesModelImpl.ENTITY_CACHE_ENABLED,
					InvoicesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return invoices;
	}

	/**
	 * Returns the invoices with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoices
	 * @return the invoices, or <code>null</code> if a invoices with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invoices fetchByPrimaryKey(long invoiceId) throws SystemException {
		return fetchByPrimaryKey((Serializable)invoiceId);
	}

	/**
	 * Returns all the invoiceses.
	 *
	 * @return the invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invoices> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Invoices> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Invoices> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Invoices> list = (List<Invoices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INVOICES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVOICES;

				if (pagination) {
					sql = sql.concat(InvoicesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invoices>(list);
				}
				else {
					list = (List<Invoices>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the invoiceses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Invoices invoices : findAll()) {
			remove(invoices);
		}
	}

	/**
	 * Returns the number of invoiceses.
	 *
	 * @return the number of invoiceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INVOICES);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the invoices persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.xmlportletfactory.olafk.customer.model.Invoices")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Invoices>> listenersList = new ArrayList<ModelListener<Invoices>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Invoices>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(InvoicesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INVOICES = "SELECT invoices FROM Invoices invoices";
	private static final String _SQL_SELECT_INVOICES_WHERE = "SELECT invoices FROM Invoices invoices WHERE ";
	private static final String _SQL_COUNT_INVOICES = "SELECT COUNT(invoices) FROM Invoices invoices";
	private static final String _SQL_COUNT_INVOICES_WHERE = "SELECT COUNT(invoices) FROM Invoices invoices WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "invoices.invoiceId";
	private static final String _FILTER_SQL_SELECT_INVOICES_WHERE = "SELECT DISTINCT {invoices.*} FROM customer_Invoices invoices WHERE ";
	private static final String _FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {customer_Invoices.*} FROM (SELECT DISTINCT invoices.invoiceId FROM customer_Invoices invoices WHERE ";
	private static final String _FILTER_SQL_SELECT_INVOICES_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN customer_Invoices ON TEMP_TABLE.invoiceId = customer_Invoices.invoiceId";
	private static final String _FILTER_SQL_COUNT_INVOICES_WHERE = "SELECT COUNT(DISTINCT invoices.invoiceId) AS COUNT_VALUE FROM customer_Invoices invoices WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "invoices";
	private static final String _FILTER_ENTITY_TABLE = "customer_Invoices";
	private static final String _ORDER_BY_ENTITY_ALIAS = "invoices.";
	private static final String _ORDER_BY_ENTITY_TABLE = "customer_Invoices.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Invoices exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Invoices exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InvoicesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static Invoices _nullInvoices = new InvoicesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Invoices> toCacheModel() {
				return _nullInvoicesCacheModel;
			}
		};

	private static CacheModel<Invoices> _nullInvoicesCacheModel = new CacheModel<Invoices>() {
			@Override
			public Invoices toEntityModel() {
				return _nullInvoices;
			}
		};
}