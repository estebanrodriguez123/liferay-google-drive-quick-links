/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.portlet.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.portlet.NoSuchDriveLinksException;
import com.rivetlogic.portlet.model.DriveLinks;
import com.rivetlogic.portlet.model.impl.DriveLinksImpl;
import com.rivetlogic.portlet.model.impl.DriveLinksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the drive links service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charlesrodriguez
 * @see DriveLinksPersistence
 * @see DriveLinksUtil
 * @generated
 */
public class DriveLinksPersistenceImpl extends BasePersistenceImpl<DriveLinks>
	implements DriveLinksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DriveLinksUtil} to access the drive links persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DriveLinksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksModelImpl.FINDER_CACHE_ENABLED, DriveLinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksModelImpl.FINDER_CACHE_ENABLED, DriveLinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksModelImpl.FINDER_CACHE_ENABLED, DriveLinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksModelImpl.FINDER_CACHE_ENABLED, DriveLinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { String.class.getName() },
			DriveLinksModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the drive linkses where USER_ID = &#63;.
	 *
	 * @param USER_ID the u s e r_ i d
	 * @return the matching drive linkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DriveLinks> findByUserId(String USER_ID)
		throws SystemException {
		return findByUserId(USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drive linkses where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.portlet.model.impl.DriveLinksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the u s e r_ i d
	 * @param start the lower bound of the range of drive linkses
	 * @param end the upper bound of the range of drive linkses (not inclusive)
	 * @return the range of matching drive linkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DriveLinks> findByUserId(String USER_ID, int start, int end)
		throws SystemException {
		return findByUserId(USER_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the drive linkses where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.portlet.model.impl.DriveLinksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the u s e r_ i d
	 * @param start the lower bound of the range of drive linkses
	 * @param end the upper bound of the range of drive linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drive linkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DriveLinks> findByUserId(String USER_ID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { USER_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { USER_ID, start, end, orderByComparator };
		}

		List<DriveLinks> list = (List<DriveLinks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DriveLinks driveLinks : list) {
				if (!Validator.equals(USER_ID, driveLinks.getUSER_ID())) {
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

			query.append(_SQL_SELECT_DRIVELINKS_WHERE);

			boolean bindUSER_ID = false;

			if (USER_ID == null) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_1);
			}
			else if (USER_ID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_3);
			}
			else {
				bindUSER_ID = true;

				query.append(_FINDER_COLUMN_USERID_USER_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DriveLinksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUSER_ID) {
					qPos.add(USER_ID);
				}

				if (!pagination) {
					list = (List<DriveLinks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DriveLinks>(list);
				}
				else {
					list = (List<DriveLinks>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first drive links in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the u s e r_ i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drive links
	 * @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a matching drive links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks findByUserId_First(String USER_ID,
		OrderByComparator orderByComparator)
		throws NoSuchDriveLinksException, SystemException {
		DriveLinks driveLinks = fetchByUserId_First(USER_ID, orderByComparator);

		if (driveLinks != null) {
			return driveLinks;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDriveLinksException(msg.toString());
	}

	/**
	 * Returns the first drive links in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the u s e r_ i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drive links, or <code>null</code> if a matching drive links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks fetchByUserId_First(String USER_ID,
		OrderByComparator orderByComparator) throws SystemException {
		List<DriveLinks> list = findByUserId(USER_ID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last drive links in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the u s e r_ i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drive links
	 * @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a matching drive links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks findByUserId_Last(String USER_ID,
		OrderByComparator orderByComparator)
		throws NoSuchDriveLinksException, SystemException {
		DriveLinks driveLinks = fetchByUserId_Last(USER_ID, orderByComparator);

		if (driveLinks != null) {
			return driveLinks;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDriveLinksException(msg.toString());
	}

	/**
	 * Returns the last drive links in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the u s e r_ i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drive links, or <code>null</code> if a matching drive links could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks fetchByUserId_Last(String USER_ID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(USER_ID);

		if (count == 0) {
			return null;
		}

		List<DriveLinks> list = findByUserId(USER_ID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the drive linkses before and after the current drive links in the ordered set where USER_ID = &#63;.
	 *
	 * @param driveLinksPK the primary key of the current drive links
	 * @param USER_ID the u s e r_ i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drive links
	 * @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a drive links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks[] findByUserId_PrevAndNext(DriveLinksPK driveLinksPK,
		String USER_ID, OrderByComparator orderByComparator)
		throws NoSuchDriveLinksException, SystemException {
		DriveLinks driveLinks = findByPrimaryKey(driveLinksPK);

		Session session = null;

		try {
			session = openSession();

			DriveLinks[] array = new DriveLinksImpl[3];

			array[0] = getByUserId_PrevAndNext(session, driveLinks, USER_ID,
					orderByComparator, true);

			array[1] = driveLinks;

			array[2] = getByUserId_PrevAndNext(session, driveLinks, USER_ID,
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

	protected DriveLinks getByUserId_PrevAndNext(Session session,
		DriveLinks driveLinks, String USER_ID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DRIVELINKS_WHERE);

		boolean bindUSER_ID = false;

		if (USER_ID == null) {
			query.append(_FINDER_COLUMN_USERID_USER_ID_1);
		}
		else if (USER_ID.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERID_USER_ID_3);
		}
		else {
			bindUSER_ID = true;

			query.append(_FINDER_COLUMN_USERID_USER_ID_2);
		}

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
			query.append(DriveLinksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUSER_ID) {
			qPos.add(USER_ID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(driveLinks);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DriveLinks> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drive linkses where USER_ID = &#63; from the database.
	 *
	 * @param USER_ID the u s e r_ i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(String USER_ID) throws SystemException {
		for (DriveLinks driveLinks : findByUserId(USER_ID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(driveLinks);
		}
	}

	/**
	 * Returns the number of drive linkses where USER_ID = &#63;.
	 *
	 * @param USER_ID the u s e r_ i d
	 * @return the number of matching drive linkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(String USER_ID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { USER_ID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DRIVELINKS_WHERE);

			boolean bindUSER_ID = false;

			if (USER_ID == null) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_1);
			}
			else if (USER_ID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USER_ID_3);
			}
			else {
				bindUSER_ID = true;

				query.append(_FINDER_COLUMN_USERID_USER_ID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUSER_ID) {
					qPos.add(USER_ID);
				}

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

	private static final String _FINDER_COLUMN_USERID_USER_ID_1 = "driveLinks.id.USER_ID IS NULL";
	private static final String _FINDER_COLUMN_USERID_USER_ID_2 = "driveLinks.id.USER_ID = ?";
	private static final String _FINDER_COLUMN_USERID_USER_ID_3 = "(driveLinks.id.USER_ID IS NULL OR driveLinks.id.USER_ID = '')";

	public DriveLinksPersistenceImpl() {
		setModelClass(DriveLinks.class);
	}

	/**
	 * Caches the drive links in the entity cache if it is enabled.
	 *
	 * @param driveLinks the drive links
	 */
	@Override
	public void cacheResult(DriveLinks driveLinks) {
		EntityCacheUtil.putResult(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksImpl.class, driveLinks.getPrimaryKey(), driveLinks);

		driveLinks.resetOriginalValues();
	}

	/**
	 * Caches the drive linkses in the entity cache if it is enabled.
	 *
	 * @param driveLinkses the drive linkses
	 */
	@Override
	public void cacheResult(List<DriveLinks> driveLinkses) {
		for (DriveLinks driveLinks : driveLinkses) {
			if (EntityCacheUtil.getResult(
						DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
						DriveLinksImpl.class, driveLinks.getPrimaryKey()) == null) {
				cacheResult(driveLinks);
			}
			else {
				driveLinks.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all drive linkses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DriveLinksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DriveLinksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the drive links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DriveLinks driveLinks) {
		EntityCacheUtil.removeResult(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksImpl.class, driveLinks.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DriveLinks> driveLinkses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DriveLinks driveLinks : driveLinkses) {
			EntityCacheUtil.removeResult(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
				DriveLinksImpl.class, driveLinks.getPrimaryKey());
		}
	}

	/**
	 * Creates a new drive links with the primary key. Does not add the drive links to the database.
	 *
	 * @param driveLinksPK the primary key for the new drive links
	 * @return the new drive links
	 */
	@Override
	public DriveLinks create(DriveLinksPK driveLinksPK) {
		DriveLinks driveLinks = new DriveLinksImpl();

		driveLinks.setNew(true);
		driveLinks.setPrimaryKey(driveLinksPK);

		return driveLinks;
	}

	/**
	 * Removes the drive links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driveLinksPK the primary key of the drive links
	 * @return the drive links that was removed
	 * @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a drive links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks remove(DriveLinksPK driveLinksPK)
		throws NoSuchDriveLinksException, SystemException {
		return remove((Serializable)driveLinksPK);
	}

	/**
	 * Removes the drive links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the drive links
	 * @return the drive links that was removed
	 * @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a drive links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks remove(Serializable primaryKey)
		throws NoSuchDriveLinksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DriveLinks driveLinks = (DriveLinks)session.get(DriveLinksImpl.class,
					primaryKey);

			if (driveLinks == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDriveLinksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(driveLinks);
		}
		catch (NoSuchDriveLinksException nsee) {
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
	protected DriveLinks removeImpl(DriveLinks driveLinks)
		throws SystemException {
		driveLinks = toUnwrappedModel(driveLinks);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(driveLinks)) {
				driveLinks = (DriveLinks)session.get(DriveLinksImpl.class,
						driveLinks.getPrimaryKeyObj());
			}

			if (driveLinks != null) {
				session.delete(driveLinks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (driveLinks != null) {
			clearCache(driveLinks);
		}

		return driveLinks;
	}

	@Override
	public DriveLinks updateImpl(
		com.rivetlogic.portlet.model.DriveLinks driveLinks)
		throws SystemException {
		driveLinks = toUnwrappedModel(driveLinks);

		boolean isNew = driveLinks.isNew();

		DriveLinksModelImpl driveLinksModelImpl = (DriveLinksModelImpl)driveLinks;

		Session session = null;

		try {
			session = openSession();

			if (driveLinks.isNew()) {
				session.save(driveLinks);

				driveLinks.setNew(false);
			}
			else {
				session.merge(driveLinks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DriveLinksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((driveLinksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						driveLinksModelImpl.getOriginalUSER_ID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { driveLinksModelImpl.getUSER_ID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
			DriveLinksImpl.class, driveLinks.getPrimaryKey(), driveLinks);

		return driveLinks;
	}

	protected DriveLinks toUnwrappedModel(DriveLinks driveLinks) {
		if (driveLinks instanceof DriveLinksImpl) {
			return driveLinks;
		}

		DriveLinksImpl driveLinksImpl = new DriveLinksImpl();

		driveLinksImpl.setNew(driveLinks.isNew());
		driveLinksImpl.setPrimaryKey(driveLinks.getPrimaryKey());

		driveLinksImpl.setUSER_ID(driveLinks.getUSER_ID());
		driveLinksImpl.setDOCUMENT_ID(driveLinks.getDOCUMENT_ID());
		driveLinksImpl.setNAME(driveLinks.getNAME());
		driveLinksImpl.setURL(driveLinks.getURL());

		return driveLinksImpl;
	}

	/**
	 * Returns the drive links with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the drive links
	 * @return the drive links
	 * @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a drive links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDriveLinksException, SystemException {
		DriveLinks driveLinks = fetchByPrimaryKey(primaryKey);

		if (driveLinks == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDriveLinksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return driveLinks;
	}

	/**
	 * Returns the drive links with the primary key or throws a {@link com.rivetlogic.portlet.NoSuchDriveLinksException} if it could not be found.
	 *
	 * @param driveLinksPK the primary key of the drive links
	 * @return the drive links
	 * @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a drive links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks findByPrimaryKey(DriveLinksPK driveLinksPK)
		throws NoSuchDriveLinksException, SystemException {
		return findByPrimaryKey((Serializable)driveLinksPK);
	}

	/**
	 * Returns the drive links with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the drive links
	 * @return the drive links, or <code>null</code> if a drive links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DriveLinks driveLinks = (DriveLinks)EntityCacheUtil.getResult(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
				DriveLinksImpl.class, primaryKey);

		if (driveLinks == _nullDriveLinks) {
			return null;
		}

		if (driveLinks == null) {
			Session session = null;

			try {
				session = openSession();

				driveLinks = (DriveLinks)session.get(DriveLinksImpl.class,
						primaryKey);

				if (driveLinks != null) {
					cacheResult(driveLinks);
				}
				else {
					EntityCacheUtil.putResult(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
						DriveLinksImpl.class, primaryKey, _nullDriveLinks);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DriveLinksModelImpl.ENTITY_CACHE_ENABLED,
					DriveLinksImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return driveLinks;
	}

	/**
	 * Returns the drive links with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driveLinksPK the primary key of the drive links
	 * @return the drive links, or <code>null</code> if a drive links with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DriveLinks fetchByPrimaryKey(DriveLinksPK driveLinksPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)driveLinksPK);
	}

	/**
	 * Returns all the drive linkses.
	 *
	 * @return the drive linkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DriveLinks> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drive linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.portlet.model.impl.DriveLinksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of drive linkses
	 * @param end the upper bound of the range of drive linkses (not inclusive)
	 * @return the range of drive linkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DriveLinks> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the drive linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.portlet.model.impl.DriveLinksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of drive linkses
	 * @param end the upper bound of the range of drive linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of drive linkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DriveLinks> findAll(int start, int end,
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

		List<DriveLinks> list = (List<DriveLinks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DRIVELINKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DRIVELINKS;

				if (pagination) {
					sql = sql.concat(DriveLinksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DriveLinks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DriveLinks>(list);
				}
				else {
					list = (List<DriveLinks>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the drive linkses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DriveLinks driveLinks : findAll()) {
			remove(driveLinks);
		}
	}

	/**
	 * Returns the number of drive linkses.
	 *
	 * @return the number of drive linkses
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

				Query q = session.createQuery(_SQL_COUNT_DRIVELINKS);

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

	/**
	 * Initializes the drive links persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.portlet.model.DriveLinks")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DriveLinks>> listenersList = new ArrayList<ModelListener<DriveLinks>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DriveLinks>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DriveLinksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DRIVELINKS = "SELECT driveLinks FROM DriveLinks driveLinks";
	private static final String _SQL_SELECT_DRIVELINKS_WHERE = "SELECT driveLinks FROM DriveLinks driveLinks WHERE ";
	private static final String _SQL_COUNT_DRIVELINKS = "SELECT COUNT(driveLinks) FROM DriveLinks driveLinks";
	private static final String _SQL_COUNT_DRIVELINKS_WHERE = "SELECT COUNT(driveLinks) FROM DriveLinks driveLinks WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "driveLinks.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DriveLinks exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DriveLinks exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DriveLinksPersistenceImpl.class);
	private static DriveLinks _nullDriveLinks = new DriveLinksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DriveLinks> toCacheModel() {
				return _nullDriveLinksCacheModel;
			}
		};

	private static CacheModel<DriveLinks> _nullDriveLinksCacheModel = new CacheModel<DriveLinks>() {
			@Override
			public DriveLinks toEntityModel() {
				return _nullDriveLinks;
			}
		};
}