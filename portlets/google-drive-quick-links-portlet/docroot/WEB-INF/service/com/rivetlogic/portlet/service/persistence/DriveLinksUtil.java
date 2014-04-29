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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.portlet.model.DriveLinks;

import java.util.List;

/**
 * The persistence utility for the drive links service. This utility wraps {@link DriveLinksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charlesrodriguez
 * @see DriveLinksPersistence
 * @see DriveLinksPersistenceImpl
 * @generated
 */
public class DriveLinksUtil {
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
	public static void clearCache(DriveLinks driveLinks) {
		getPersistence().clearCache(driveLinks);
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
	public static List<DriveLinks> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DriveLinks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DriveLinks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DriveLinks update(DriveLinks driveLinks)
		throws SystemException {
		return getPersistence().update(driveLinks);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DriveLinks update(DriveLinks driveLinks,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(driveLinks, serviceContext);
	}

	/**
	* Returns all the drive linkses where USER_ID = &#63;.
	*
	* @param USER_ID the u s e r_ i d
	* @return the matching drive linkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.portlet.model.DriveLinks> findByUserId(
		java.lang.String USER_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(USER_ID);
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
	public static java.util.List<com.rivetlogic.portlet.model.DriveLinks> findByUserId(
		java.lang.String USER_ID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(USER_ID, start, end);
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
	public static java.util.List<com.rivetlogic.portlet.model.DriveLinks> findByUserId(
		java.lang.String USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(USER_ID, start, end, orderByComparator);
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
	public static com.rivetlogic.portlet.model.DriveLinks findByUserId_First(
		java.lang.String USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.portlet.NoSuchDriveLinksException {
		return getPersistence().findByUserId_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the first drive links in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the u s e r_ i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching drive links, or <code>null</code> if a matching drive links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.portlet.model.DriveLinks fetchByUserId_First(
		java.lang.String USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(USER_ID, orderByComparator);
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
	public static com.rivetlogic.portlet.model.DriveLinks findByUserId_Last(
		java.lang.String USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.portlet.NoSuchDriveLinksException {
		return getPersistence().findByUserId_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the last drive links in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the u s e r_ i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching drive links, or <code>null</code> if a matching drive links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.portlet.model.DriveLinks fetchByUserId_Last(
		java.lang.String USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(USER_ID, orderByComparator);
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
	public static com.rivetlogic.portlet.model.DriveLinks[] findByUserId_PrevAndNext(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK,
		java.lang.String USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.portlet.NoSuchDriveLinksException {
		return getPersistence()
				   .findByUserId_PrevAndNext(driveLinksPK, USER_ID,
			orderByComparator);
	}

	/**
	* Removes all the drive linkses where USER_ID = &#63; from the database.
	*
	* @param USER_ID the u s e r_ i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(java.lang.String USER_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(USER_ID);
	}

	/**
	* Returns the number of drive linkses where USER_ID = &#63;.
	*
	* @param USER_ID the u s e r_ i d
	* @return the number of matching drive linkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(java.lang.String USER_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(USER_ID);
	}

	/**
	* Caches the drive links in the entity cache if it is enabled.
	*
	* @param driveLinks the drive links
	*/
	public static void cacheResult(
		com.rivetlogic.portlet.model.DriveLinks driveLinks) {
		getPersistence().cacheResult(driveLinks);
	}

	/**
	* Caches the drive linkses in the entity cache if it is enabled.
	*
	* @param driveLinkses the drive linkses
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.portlet.model.DriveLinks> driveLinkses) {
		getPersistence().cacheResult(driveLinkses);
	}

	/**
	* Creates a new drive links with the primary key. Does not add the drive links to the database.
	*
	* @param driveLinksPK the primary key for the new drive links
	* @return the new drive links
	*/
	public static com.rivetlogic.portlet.model.DriveLinks create(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK) {
		return getPersistence().create(driveLinksPK);
	}

	/**
	* Removes the drive links with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param driveLinksPK the primary key of the drive links
	* @return the drive links that was removed
	* @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a drive links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.portlet.model.DriveLinks remove(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.portlet.NoSuchDriveLinksException {
		return getPersistence().remove(driveLinksPK);
	}

	public static com.rivetlogic.portlet.model.DriveLinks updateImpl(
		com.rivetlogic.portlet.model.DriveLinks driveLinks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(driveLinks);
	}

	/**
	* Returns the drive links with the primary key or throws a {@link com.rivetlogic.portlet.NoSuchDriveLinksException} if it could not be found.
	*
	* @param driveLinksPK the primary key of the drive links
	* @return the drive links
	* @throws com.rivetlogic.portlet.NoSuchDriveLinksException if a drive links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.portlet.model.DriveLinks findByPrimaryKey(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.portlet.NoSuchDriveLinksException {
		return getPersistence().findByPrimaryKey(driveLinksPK);
	}

	/**
	* Returns the drive links with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param driveLinksPK the primary key of the drive links
	* @return the drive links, or <code>null</code> if a drive links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.portlet.model.DriveLinks fetchByPrimaryKey(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(driveLinksPK);
	}

	/**
	* Returns all the drive linkses.
	*
	* @return the drive linkses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.portlet.model.DriveLinks> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rivetlogic.portlet.model.DriveLinks> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.rivetlogic.portlet.model.DriveLinks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the drive linkses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of drive linkses.
	*
	* @return the number of drive linkses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DriveLinksPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DriveLinksPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.portlet.service.ClpSerializer.getServletContextName(),
					DriveLinksPersistence.class.getName());

			ReferenceRegistry.registerReference(DriveLinksUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DriveLinksPersistence persistence) {
	}

	private static DriveLinksPersistence _persistence;
}