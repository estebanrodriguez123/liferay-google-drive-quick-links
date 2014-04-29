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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author charlesrodriguez
 */
public class DriveLinksPK implements Comparable<DriveLinksPK>, Serializable {
	public String USER_ID;
	public String DOCUMENT_ID;

	public DriveLinksPK() {
	}

	public DriveLinksPK(String USER_ID, String DOCUMENT_ID) {
		this.USER_ID = USER_ID;
		this.DOCUMENT_ID = DOCUMENT_ID;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}

	public String getDOCUMENT_ID() {
		return DOCUMENT_ID;
	}

	public void setDOCUMENT_ID(String DOCUMENT_ID) {
		this.DOCUMENT_ID = DOCUMENT_ID;
	}

	@Override
	public int compareTo(DriveLinksPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = USER_ID.compareTo(pk.USER_ID);

		if (value != 0) {
			return value;
		}

		value = DOCUMENT_ID.compareTo(pk.DOCUMENT_ID);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DriveLinksPK)) {
			return false;
		}

		DriveLinksPK pk = (DriveLinksPK)obj;

		if ((USER_ID.equals(pk.USER_ID)) &&
				(DOCUMENT_ID.equals(pk.DOCUMENT_ID))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(USER_ID) + String.valueOf(DOCUMENT_ID)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("USER_ID");
		sb.append(StringPool.EQUAL);
		sb.append(USER_ID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("DOCUMENT_ID");
		sb.append(StringPool.EQUAL);
		sb.append(DOCUMENT_ID);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}