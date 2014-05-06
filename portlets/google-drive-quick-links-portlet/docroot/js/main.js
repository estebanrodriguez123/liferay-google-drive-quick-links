/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

YUI.add('picker-module', function (Y) {
	
    var developerKey = "",
    	clientId = "",
    	GOOGLE_API_URL = 'https://www.googleapis.com/auth/drive', 
    	scope = [GOOGLE_API_URL],
    	pickerApiLoaded = false,
    	oauthToken = "",
    	portletNamespace = "";
	
    Y.namespace('MyGooglePicker');
    
    // Use the API Loader script to load google.picker and gapi.auth.
    Y.MyGooglePicker.onApiLoad = function(devKey,cId,pns) {
        developerKey=devKey;
        clientId=cId;
        portletNamespace=pns;
		
        gapi.load('auth', {'callback': Y.MyGooglePicker.onAuthApiLoad});
        gapi.load('picker', {'callback': Y.MyGooglePicker.onPickerApiLoad});
    },
    Y.MyGooglePicker.onAuthApiLoad = function() {
        window.gapi.auth.authorize(
		        {
		            'client_id': clientId,
		            'scope': scope,
		            'immediate': false
		        },
		        Y.MyGooglePicker.handleAuthResult);
    },
    
    Y.MyGooglePicker.onPickerApiLoad = function() {
        pickerApiLoaded = true;
        Y.MyGooglePicker.createPicker();
    },
    Y.MyGooglePicker.handleAuthResult = function(authResult) {
        if (authResult && !authResult.error) {
	        oauthToken = authResult.access_token;
	        Y.MyGooglePicker.createPicker();
	    }
    },
    Y.MyGooglePicker.createPicker = function() {
        if (pickerApiLoaded && oauthToken) {
            var picker = new google.picker.PickerBuilder().
		        addView(google.picker.ViewId.DOCS).
		        addView(new google.picker.DocsUploadView()).
		        setOAuthToken(oauthToken).
		        setDeveloperKey(developerKey).
		        setCallback(Y.MyGooglePicker.pickerCallback).
		        build();
		    picker.setVisible(true);
        }
    },
    // A simple callback implementation.
    Y.MyGooglePicker.pickerCallback = function(data) {
        if (data[google.picker.Response.ACTION] == google.picker.Action.PICKED) {
	        var doc = data[google.picker.Response.DOCUMENTS][0],
	        	name = doc[google.picker.Document.NAME],
	        	id = doc[google.picker.Document.ID],
	        	url = doc[google.picker.Document.URL],
	        	form = Y.one("#"+portletNamespace+"form");
	        
	        form.one("#"+portletNamespace+"documentUrl").set('value', url);
	        form.one("#"+portletNamespace+"documentName").set('value', name);
	        form.one("#"+portletNamespace+"documentId").set('value', id);
	        
	        form.submit();
	    }
    };	
}, '1.0', {
    requires: ['google-picker-api', 'aui-modal', 'aui-io']
});
