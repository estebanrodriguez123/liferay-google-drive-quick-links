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

import com.rivetlogic.portlet.service.persistence.DriveLinksPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rivetlogic.portlet.service.http.DriveLinksServiceSoap}.
 *
 * @author charlesrodriguez
 * @see com.rivetlogic.portlet.service.http.DriveLinksServiceSoap
 * @generated
 */
public class DriveLinksSoap implements Serializable {
	public static DriveLinksSoap toSoapModel(DriveLinks model) {
		DriveLinksSoap soapModel = new DriveLinksSoap();

		soapModel.setUSER_ID(model.getUSER_ID());
		soapModel.setDOCUMENT_ID(model.getDOCUMENT_ID());
		soapModel.setNAME(model.getNAME());
		soapModel.setURL(model.getURL());

		return soapModel;
	}

	public static DriveLinksSoap[] toSoapModels(DriveLinks[] models) {
		DriveLinksSoap[] soapModels = new DriveLinksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DriveLinksSoap[][] toSoapModels(DriveLinks[][] models) {
		DriveLinksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DriveLinksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DriveLinksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DriveLinksSoap[] toSoapModels(List<DriveLinks> models) {
		List<DriveLinksSoap> soapModels = new ArrayList<DriveLinksSoap>(models.size());

		for (DriveLinks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DriveLinksSoap[soapModels.size()]);
	}

	public DriveLinksSoap() {
	}

	public DriveLinksPK getPrimaryKey() {
		return new DriveLinksPK(_USER_ID, _DOCUMENT_ID);
	}

	public void setPrimaryKey(DriveLinksPK pk) {
		setUSER_ID(pk.USER_ID);
		setDOCUMENT_ID(pk.DOCUMENT_ID);
	}

	public String getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		_USER_ID = USER_ID;
	}

	public String getDOCUMENT_ID() {
		return _DOCUMENT_ID;
	}

	public void setDOCUMENT_ID(String DOCUMENT_ID) {
		_DOCUMENT_ID = DOCUMENT_ID;
	}

	public String getNAME() {
		return _NAME;
	}

	public void setNAME(String NAME) {
		_NAME = NAME;
	}

	public String getURL() {
		return _URL;
	}

	public void setURL(String URL) {
		_URL = URL;
	}

	private String _USER_ID;
	private String _DOCUMENT_ID;
	private String _NAME;
	private String _URL;
}