/**
 * Copyright (c) 2014 Rivet Logic Corporation. All rights reserved.
 */

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

package com.rivetlogic.portlet.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rivetlogic.portlet.model.DriveLinks;
import com.rivetlogic.portlet.service.base.DriveLinksLocalServiceBaseImpl;
import com.rivetlogic.portlet.service.persistence.DriveLinksPK;

/**
 * The implementation of the drive links local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.portlet.service.DriveLinksLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author charlesrodriguez
 * @see com.rivetlogic.portlet.service.base.DriveLinksLocalServiceBaseImpl
 * @see com.rivetlogic.portlet.service.DriveLinksLocalServiceUtil
 */
public class DriveLinksLocalServiceImpl extends DriveLinksLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.portlet.service.DriveLinksLocalServiceUtil} to access the drive links local service.
	 */
	
    private static final Log LOG = 
	    LogFactoryUtil.getLog(DriveLinksLocalServiceImpl.class);
	
    @Override
    public DriveLinks addDriveLinks(DriveLinks newLink) throws SystemException{
        DriveLinksPK dlPK = new DriveLinksPK();
		
        DriveLinks driveLink = driveLinksPersistence.create(dlPK);
        driveLink.setDOCUMENT_ID(newLink.getDOCUMENT_ID());
        driveLink.setNAME(newLink.getNAME());
        driveLink.setURL(newLink.getURL());
        driveLink.setUSER_ID(newLink.getUSER_ID());
		
        driveLinksPersistence.update(driveLink);
	
        return driveLink;
    }
	
    public DriveLinks deleteDriveLink(DriveLinks driveLink) throws SystemException {
        driveLinksPersistence.remove(driveLink);
        
        return driveLink;
    }
	
    //Returns all elements in the DriveLinks table, that have the same user
    public List<DriveLinks> userDriveLinks(String userId,int start,int end) {		
	    List<DriveLinks> driveLinks = new ArrayList<DriveLinks>();
	    try {
		    driveLinks = driveLinksPersistence.findByUserId(userId, start, end);
        } catch (SystemException e) {
            LOG.error(e);
        }
        return driveLinks;
    }
	
    //Returns the number of elements in the DriveLinks table, with the same userId
    public int userDriveLinksCount(String userId) {
        int count = 0;
		
        try {
            count = driveLinksPersistence.countByUserId(userId);
        } catch (SystemException e) {
            LOG.error(e);
        }
        return count;
    }
	
    public boolean linkExist(DriveLinks driveLink) throws SystemException {
        DriveLinksPK dlPK = new DriveLinksPK();
        dlPK.setDOCUMENT_ID(driveLink.getDOCUMENT_ID());
        dlPK.setUSER_ID(driveLink.getUSER_ID());
		
        if(driveLinksPersistence.fetchByPrimaryKey(dlPK) != null){
            return true;
        }
        return false;
    }
}