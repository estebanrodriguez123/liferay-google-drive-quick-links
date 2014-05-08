/**
* Copyright (C) 2005-2014 Rivet Logic Corporation.
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; version 2
* of the License.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor,
* Boston, MA 02110-1301, USA.
*/

package com.rivetlogic.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.portlet.model.impl.DriveLinksImpl;
import com.rivetlogic.portlet.service.DriveLinksLocalServiceUtil;
import com.rivetlogic.portlet.util.Constants;
import com.rivetlogic.portlet.util.GoogleDriveKeys;

/**
 * The Class GoogleDriveQuickLinks.
 */
public class GoogleDriveQuickLinks extends MVCPortlet {
    
    /** The Constant LOG. */
    private static final Log LOG = 
	        LogFactoryUtil.getLog(GoogleDriveQuickLinks.class);
 
    /* (non-Javadoc)
     * @see javax.portlet.GenericPortlet#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    @Override
    public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException{

    	addDriveParamsToRequest(request);
    	super.render(request, response);
    }
    
    /* (non-Javadoc)
     * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    @Override
    public void doView(RenderRequest request, RenderResponse response) 
            throws IOException, PortletException {
		
    	addDriveParamsToRequest(request);
    	
    	ThemeDisplay themeDisplay = 
    			(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	if(!themeDisplay.isSignedIn()){
    		SessionMessages.add(request, request.getAttribute(WebKeys.PORTLET_ID) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    		SessionErrors.add(request, Constants.PORTLET_USER_NOT_LOGGED);
    	}
        super.doView(request, response);
    }
	
	/**
	 * Adds the drive link.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws PortletException the portlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void addDriveLink(ActionRequest request, ActionResponse response)
            throws PortletException, IOException{
		
		String documentId = ParamUtil.getString(request, Constants.DOCUMENT_ID);
        String documentName = ParamUtil.getString(request, Constants.DOCUMENT_NAME);
        String documentUrl = ParamUtil.getString(request, Constants.DOCUMENT_URL);
		
        ThemeDisplay themeDisplay = 
                (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
        DriveLinksImpl driveLink = new DriveLinksImpl();
        driveLink.setDOCUMENT_ID(documentId);
        driveLink.setNAME(documentName);
        driveLink.setURL(documentUrl);
        driveLink.setUSER_ID(themeDisplay.getRealUser().getUuid());
		
        try {
            if(!DriveLinksLocalServiceUtil.linkExist(driveLink)){
                DriveLinksLocalServiceUtil.addDriveLinks(driveLink);
            }
        } catch (SystemException e) {
            LOG.error(e);
            SessionErrors.add(request, Constants.ADD_LINK_ERROR);
        }
    }

    /**
     * Delete drive link.
     *
     * @param request the request
     * @param response the response
     * @throws PortletException the portlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void deleteDriveLink(ActionRequest request, ActionResponse response)
            throws PortletException, IOException{
		
        String linkId = ParamUtil.getString(request, Constants.LINK_ID);
        String linkUser = ParamUtil.getString(request, Constants.LINK_USER);
		
        DriveLinksImpl driveLink = new DriveLinksImpl();
        driveLink.setDOCUMENT_ID(linkId);
        driveLink.setUSER_ID(linkUser);
		
        try {
            DriveLinksLocalServiceUtil.deleteDriveLink(driveLink);
        } catch (SystemException e) { 
            LOG.error(e);
            SessionErrors.add(request, Constants.DELETE_LINK_ERROR);
        }
    }
    
    /**
     * Adds the drive params to request.
     *
     * @param request the request
     */
    private void addDriveParamsToRequest(RenderRequest request) {
    	
    	ThemeDisplay themeDisplay = 
    			(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	
    	String googleClientId = ""; 
    	String googleDeveloperKey = "";
    	
    	try {
    		googleClientId = GoogleDriveKeys.getClientId(themeDisplay.getCompanyId());
    		googleDeveloperKey = GoogleDriveKeys.getDevKey(themeDisplay.getCompanyId());
    	} catch (SystemException e) {
    		LOG.error(e);
    	}
    	
    	request.setAttribute(Constants.USER_ID, themeDisplay.getRealUser().getUuid());
    	request.setAttribute(Constants.DEVELOPER_KEY, googleDeveloperKey);
    	request.setAttribute(Constants.CLIENT_ID, googleClientId);
    }
}
