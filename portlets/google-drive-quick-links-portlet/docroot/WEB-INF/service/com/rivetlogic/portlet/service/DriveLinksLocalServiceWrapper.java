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

package com.rivetlogic.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DriveLinksLocalService}.
 *
 * @author charlesrodriguez
 * @see DriveLinksLocalService
 * @generated
 */
public class DriveLinksLocalServiceWrapper implements DriveLinksLocalService,
	ServiceWrapper<DriveLinksLocalService> {
	public DriveLinksLocalServiceWrapper(
		DriveLinksLocalService driveLinksLocalService) {
		_driveLinksLocalService = driveLinksLocalService;
	}

	/**
	* Adds the drive links to the database. Also notifies the appropriate model listeners.
	*
	* @param driveLinks the drive links
	* @return the drive links that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.portlet.model.DriveLinks addDriveLinks(
		com.rivetlogic.portlet.model.DriveLinks driveLinks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.addDriveLinks(driveLinks);
	}

	/**
	* Creates a new drive links with the primary key. Does not add the drive links to the database.
	*
	* @param driveLinksPK the primary key for the new drive links
	* @return the new drive links
	*/
	@Override
	public com.rivetlogic.portlet.model.DriveLinks createDriveLinks(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK) {
		return _driveLinksLocalService.createDriveLinks(driveLinksPK);
	}

	/**
	* Deletes the drive links with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param driveLinksPK the primary key of the drive links
	* @return the drive links that was removed
	* @throws PortalException if a drive links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.portlet.model.DriveLinks deleteDriveLinks(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.deleteDriveLinks(driveLinksPK);
	}

	/**
	* Deletes the drive links from the database. Also notifies the appropriate model listeners.
	*
	* @param driveLinks the drive links
	* @return the drive links that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.portlet.model.DriveLinks deleteDriveLinks(
		com.rivetlogic.portlet.model.DriveLinks driveLinks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.deleteDriveLinks(driveLinks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _driveLinksLocalService.dynamicQuery();
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
		return _driveLinksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.portlet.model.impl.DriveLinksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _driveLinksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.portlet.model.impl.DriveLinksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _driveLinksLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _driveLinksLocalService.dynamicQueryCount(dynamicQuery);
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
		return _driveLinksLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.portlet.model.DriveLinks fetchDriveLinks(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.fetchDriveLinks(driveLinksPK);
	}

	/**
	* Returns the drive links with the primary key.
	*
	* @param driveLinksPK the primary key of the drive links
	* @return the drive links
	* @throws PortalException if a drive links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.portlet.model.DriveLinks getDriveLinks(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK driveLinksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.getDriveLinks(driveLinksPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rivetlogic.portlet.model.DriveLinks> getDriveLinkses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.getDriveLinkses(start, end);
	}

	/**
	* Returns the number of drive linkses.
	*
	* @return the number of drive linkses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDriveLinksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.getDriveLinksesCount();
	}

	/**
	* Updates the drive links in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param driveLinks the drive links
	* @return the drive links that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.portlet.model.DriveLinks updateDriveLinks(
		com.rivetlogic.portlet.model.DriveLinks driveLinks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.updateDriveLinks(driveLinks);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _driveLinksLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_driveLinksLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _driveLinksLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rivetlogic.portlet.model.DriveLinks deleteDriveLink(
		com.rivetlogic.portlet.model.DriveLinks driveLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.deleteDriveLink(driveLink);
	}

	@Override
	public java.util.List<com.rivetlogic.portlet.model.DriveLinks> userDriveLinks(
		java.lang.String userId, int start, int end) {
		return _driveLinksLocalService.userDriveLinks(userId, start, end);
	}

	@Override
	public int userDriveLinksCount(java.lang.String userId) {
		return _driveLinksLocalService.userDriveLinksCount(userId);
	}

	@Override
	public boolean linkExist(com.rivetlogic.portlet.model.DriveLinks driveLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _driveLinksLocalService.linkExist(driveLink);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DriveLinksLocalService getWrappedDriveLinksLocalService() {
		return _driveLinksLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDriveLinksLocalService(
		DriveLinksLocalService driveLinksLocalService) {
		_driveLinksLocalService = driveLinksLocalService;
	}

	@Override
	public DriveLinksLocalService getWrappedService() {
		return _driveLinksLocalService;
	}

	@Override
	public void setWrappedService(DriveLinksLocalService driveLinksLocalService) {
		_driveLinksLocalService = driveLinksLocalService;
	}

	private DriveLinksLocalService _driveLinksLocalService;
}