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

package com.rivetlogic.portlet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.portlet.model.DriveLinks;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DriveLinks in entity cache.
 *
 * @author charlesrodriguez
 * @see DriveLinks
 * @generated
 */
public class DriveLinksCacheModel implements CacheModel<DriveLinks>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{USER_ID=");
		sb.append(USER_ID);
		sb.append(", DOCUMENT_ID=");
		sb.append(DOCUMENT_ID);
		sb.append(", NAME=");
		sb.append(NAME);
		sb.append(", URL=");
		sb.append(URL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DriveLinks toEntityModel() {
		DriveLinksImpl driveLinksImpl = new DriveLinksImpl();

		if (USER_ID == null) {
			driveLinksImpl.setUSER_ID(StringPool.BLANK);
		}
		else {
			driveLinksImpl.setUSER_ID(USER_ID);
		}

		if (DOCUMENT_ID == null) {
			driveLinksImpl.setDOCUMENT_ID(StringPool.BLANK);
		}
		else {
			driveLinksImpl.setDOCUMENT_ID(DOCUMENT_ID);
		}

		if (NAME == null) {
			driveLinksImpl.setNAME(StringPool.BLANK);
		}
		else {
			driveLinksImpl.setNAME(NAME);
		}

		if (URL == null) {
			driveLinksImpl.setURL(StringPool.BLANK);
		}
		else {
			driveLinksImpl.setURL(URL);
		}

		driveLinksImpl.resetOriginalValues();

		return driveLinksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		USER_ID = objectInput.readUTF();
		DOCUMENT_ID = objectInput.readUTF();
		NAME = objectInput.readUTF();
		URL = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (USER_ID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(USER_ID);
		}

		if (DOCUMENT_ID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(DOCUMENT_ID);
		}

		if (NAME == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(NAME);
		}

		if (URL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(URL);
		}
	}

	public String USER_ID;
	public String DOCUMENT_ID;
	public String NAME;
	public String URL;
}