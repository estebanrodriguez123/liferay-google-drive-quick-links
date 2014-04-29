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

package com.rivetlogic.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DriveLinks}.
 * </p>
 *
 * @author charlesrodriguez
 * @see DriveLinks
 * @generated
 */
public class DriveLinksWrapper implements DriveLinks, ModelWrapper<DriveLinks> {
	public DriveLinksWrapper(DriveLinks driveLinks) {
		_driveLinks = driveLinks;
	}

	@Override
	public Class<?> getModelClass() {
		return DriveLinks.class;
	}

	@Override
	public String getModelClassName() {
		return DriveLinks.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("USER_ID", getUSER_ID());
		attributes.put("DOCUMENT_ID", getDOCUMENT_ID());
		attributes.put("NAME", getNAME());
		attributes.put("URL", getURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String USER_ID = (String)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		String DOCUMENT_ID = (String)attributes.get("DOCUMENT_ID");

		if (DOCUMENT_ID != null) {
			setDOCUMENT_ID(DOCUMENT_ID);
		}

		String NAME = (String)attributes.get("NAME");

		if (NAME != null) {
			setNAME(NAME);
		}

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}
	}

	/**
	* Returns the primary key of this drive links.
	*
	* @return the primary key of this drive links
	*/
	@Override
	public com.rivetlogic.portlet.service.persistence.DriveLinksPK getPrimaryKey() {
		return _driveLinks.getPrimaryKey();
	}

	/**
	* Sets the primary key of this drive links.
	*
	* @param primaryKey the primary key of this drive links
	*/
	@Override
	public void setPrimaryKey(
		com.rivetlogic.portlet.service.persistence.DriveLinksPK primaryKey) {
		_driveLinks.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the u s e r_ i d of this drive links.
	*
	* @return the u s e r_ i d of this drive links
	*/
	@Override
	public java.lang.String getUSER_ID() {
		return _driveLinks.getUSER_ID();
	}

	/**
	* Sets the u s e r_ i d of this drive links.
	*
	* @param USER_ID the u s e r_ i d of this drive links
	*/
	@Override
	public void setUSER_ID(java.lang.String USER_ID) {
		_driveLinks.setUSER_ID(USER_ID);
	}

	/**
	* Returns the d o c u m e n t_ i d of this drive links.
	*
	* @return the d o c u m e n t_ i d of this drive links
	*/
	@Override
	public java.lang.String getDOCUMENT_ID() {
		return _driveLinks.getDOCUMENT_ID();
	}

	/**
	* Sets the d o c u m e n t_ i d of this drive links.
	*
	* @param DOCUMENT_ID the d o c u m e n t_ i d of this drive links
	*/
	@Override
	public void setDOCUMENT_ID(java.lang.String DOCUMENT_ID) {
		_driveLinks.setDOCUMENT_ID(DOCUMENT_ID);
	}

	/**
	* Returns the n a m e of this drive links.
	*
	* @return the n a m e of this drive links
	*/
	@Override
	public java.lang.String getNAME() {
		return _driveLinks.getNAME();
	}

	/**
	* Sets the n a m e of this drive links.
	*
	* @param NAME the n a m e of this drive links
	*/
	@Override
	public void setNAME(java.lang.String NAME) {
		_driveLinks.setNAME(NAME);
	}

	/**
	* Returns the u r l of this drive links.
	*
	* @return the u r l of this drive links
	*/
	@Override
	public java.lang.String getURL() {
		return _driveLinks.getURL();
	}

	/**
	* Sets the u r l of this drive links.
	*
	* @param URL the u r l of this drive links
	*/
	@Override
	public void setURL(java.lang.String URL) {
		_driveLinks.setURL(URL);
	}

	@Override
	public boolean isNew() {
		return _driveLinks.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_driveLinks.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _driveLinks.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_driveLinks.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _driveLinks.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _driveLinks.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_driveLinks.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _driveLinks.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_driveLinks.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_driveLinks.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_driveLinks.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DriveLinksWrapper((DriveLinks)_driveLinks.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.portlet.model.DriveLinks driveLinks) {
		return _driveLinks.compareTo(driveLinks);
	}

	@Override
	public int hashCode() {
		return _driveLinks.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.portlet.model.DriveLinks> toCacheModel() {
		return _driveLinks.toCacheModel();
	}

	@Override
	public com.rivetlogic.portlet.model.DriveLinks toEscapedModel() {
		return new DriveLinksWrapper(_driveLinks.toEscapedModel());
	}

	@Override
	public com.rivetlogic.portlet.model.DriveLinks toUnescapedModel() {
		return new DriveLinksWrapper(_driveLinks.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _driveLinks.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _driveLinks.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_driveLinks.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DriveLinksWrapper)) {
			return false;
		}

		DriveLinksWrapper driveLinksWrapper = (DriveLinksWrapper)obj;

		if (Validator.equals(_driveLinks, driveLinksWrapper._driveLinks)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DriveLinks getWrappedDriveLinks() {
		return _driveLinks;
	}

	@Override
	public DriveLinks getWrappedModel() {
		return _driveLinks;
	}

	@Override
	public void resetOriginalValues() {
		_driveLinks.resetOriginalValues();
	}

	private DriveLinks _driveLinks;
}