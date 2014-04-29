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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rivetlogic.portlet.service.ClpSerializer;
import com.rivetlogic.portlet.service.DriveLinksLocalServiceUtil;
import com.rivetlogic.portlet.service.persistence.DriveLinksPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author charlesrodriguez
 */
public class DriveLinksClp extends BaseModelImpl<DriveLinks>
	implements DriveLinks {
	public DriveLinksClp() {
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
	public DriveLinksPK getPrimaryKey() {
		return new DriveLinksPK(_USER_ID, _DOCUMENT_ID);
	}

	@Override
	public void setPrimaryKey(DriveLinksPK primaryKey) {
		setUSER_ID(primaryKey.USER_ID);
		setDOCUMENT_ID(primaryKey.DOCUMENT_ID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new DriveLinksPK(_USER_ID, _DOCUMENT_ID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((DriveLinksPK)primaryKeyObj);
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

	@Override
	public String getUSER_ID() {
		return _USER_ID;
	}

	@Override
	public void setUSER_ID(String USER_ID) {
		_USER_ID = USER_ID;

		if (_driveLinksRemoteModel != null) {
			try {
				Class<?> clazz = _driveLinksRemoteModel.getClass();

				Method method = clazz.getMethod("setUSER_ID", String.class);

				method.invoke(_driveLinksRemoteModel, USER_ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDOCUMENT_ID() {
		return _DOCUMENT_ID;
	}

	@Override
	public void setDOCUMENT_ID(String DOCUMENT_ID) {
		_DOCUMENT_ID = DOCUMENT_ID;

		if (_driveLinksRemoteModel != null) {
			try {
				Class<?> clazz = _driveLinksRemoteModel.getClass();

				Method method = clazz.getMethod("setDOCUMENT_ID", String.class);

				method.invoke(_driveLinksRemoteModel, DOCUMENT_ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNAME() {
		return _NAME;
	}

	@Override
	public void setNAME(String NAME) {
		_NAME = NAME;

		if (_driveLinksRemoteModel != null) {
			try {
				Class<?> clazz = _driveLinksRemoteModel.getClass();

				Method method = clazz.getMethod("setNAME", String.class);

				method.invoke(_driveLinksRemoteModel, NAME);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getURL() {
		return _URL;
	}

	@Override
	public void setURL(String URL) {
		_URL = URL;

		if (_driveLinksRemoteModel != null) {
			try {
				Class<?> clazz = _driveLinksRemoteModel.getClass();

				Method method = clazz.getMethod("setURL", String.class);

				method.invoke(_driveLinksRemoteModel, URL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDriveLinksRemoteModel() {
		return _driveLinksRemoteModel;
	}

	public void setDriveLinksRemoteModel(BaseModel<?> driveLinksRemoteModel) {
		_driveLinksRemoteModel = driveLinksRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _driveLinksRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_driveLinksRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DriveLinksLocalServiceUtil.addDriveLinks(this);
		}
		else {
			DriveLinksLocalServiceUtil.updateDriveLinks(this);
		}
	}

	@Override
	public DriveLinks toEscapedModel() {
		return (DriveLinks)ProxyUtil.newProxyInstance(DriveLinks.class.getClassLoader(),
			new Class[] { DriveLinks.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DriveLinksClp clone = new DriveLinksClp();

		clone.setUSER_ID(getUSER_ID());
		clone.setDOCUMENT_ID(getDOCUMENT_ID());
		clone.setNAME(getNAME());
		clone.setURL(getURL());

		return clone;
	}

	@Override
	public int compareTo(DriveLinks driveLinks) {
		DriveLinksPK primaryKey = driveLinks.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DriveLinksClp)) {
			return false;
		}

		DriveLinksClp driveLinks = (DriveLinksClp)obj;

		DriveLinksPK primaryKey = driveLinks.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{USER_ID=");
		sb.append(getUSER_ID());
		sb.append(", DOCUMENT_ID=");
		sb.append(getDOCUMENT_ID());
		sb.append(", NAME=");
		sb.append(getNAME());
		sb.append(", URL=");
		sb.append(getURL());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.portlet.model.DriveLinks");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>USER_ID</column-name><column-value><![CDATA[");
		sb.append(getUSER_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DOCUMENT_ID</column-name><column-value><![CDATA[");
		sb.append(getDOCUMENT_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NAME</column-name><column-value><![CDATA[");
		sb.append(getNAME());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>URL</column-name><column-value><![CDATA[");
		sb.append(getURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _USER_ID;
	private String _DOCUMENT_ID;
	private String _NAME;
	private String _URL;
	private BaseModel<?> _driveLinksRemoteModel;
}