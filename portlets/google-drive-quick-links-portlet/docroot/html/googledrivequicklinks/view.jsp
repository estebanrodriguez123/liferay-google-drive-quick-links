<%--
/*
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
--%>

<%@include file="/html/init.jsp" %>

<% 
String userId = themeDisplay.getRealUser().getUuid();
    				
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/html/googledrivequicklinks/view.jsp");
iteratorURL.setParameter("userId", userId);
%>

<portlet:actionURL name="addDriveLink" var="addDriveLinkUrl">
    <portlet:param name="developerKey" value="${developerKey}"/>
    <portlet:param name="clientId" value="${clientId}"/>
    <portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(request) %>"/>
</portlet:actionURL>

<liferay-ui:error key="portlet-user-not-logged" message="portlet-user-not-logged" />
<liferay-ui:error key="add-link-error" message="add-link-error" />
<liferay-ui:error key="delete-link-error" message="delete-link-error" />

<c:if test="<%= themeDisplay.isSignedIn()%>">
	<aui:form action="${addDriveLinkUrl}" name="form" method="POST">
		<liferay-ui:search-container delta="10" iteratorURL="<%= iteratorURL %>"
		    emptyResultsMessage="no-links-message">
		
		    <liferay-ui:search-container-results
		        total="<%=DriveLinksLocalServiceUtil.userDriveLinksCount(userId)%>"
		        results="<%=DriveLinksLocalServiceUtil.userDriveLinks(userId,
		        		searchContainer.getStart(),searchContainer.getEnd()) %>"
		    />
		
		    <liferay-ui:search-container-row modelVar="content" keyProperty="NAME"
		        className="com.rivetlogic.portlet.model.DriveLinks">
		 	
		        <liferay-ui:search-container-column-text 
		            name="file-name" value="${content.NAME}" 
		            href="${content.URL}" target="_blank" />
		        <liferay-ui:search-container-column-jsp 
		            path="/html/googledrivequicklinks/include/driveLinks_actions.jsp" />
		            
		    </liferay-ui:search-container-row>
		    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		</liferay-ui:search-container>
		
		<aui:input name="documentUrl" id="documentUrl" type="hidden" />
		<aui:input name="documentName" id="documentName" type="hidden" />
		<aui:input name="documentId" id="documentId" type="hidden" />
		<aui:fieldset>
		    <aui:button-row>
		        <aui:button name="selectFile" value="select-button" type="button" 
		        	cssClass="btn-primary" icon="icon-plus"/>
		    </aui:button-row>
		</aui:fieldset>
	</aui:form>	
</c:if>


<c:if test="<%= themeDisplay.isSignedIn()%>">
<aui:script >
	function onApiLoad() {
	      gapi.load('auth', {'callback': function() { }});
	      gapi.load('picker', {'callback': function() { }});
	}

	AUI().applyConfig({
	    groups : {
	        'google-api' : {
	            base : '<%= request.getContextPath()%>/js/',
	            async : false,
	            modules : {
	        		'google-picker-api': {
	        			path: 'api.js?onload=onApiLoad'
	        		}
	            }
	        }
	    }
	});

</aui:script >

<aui:script use="picker-module">
	A.one("#${pns}selectFile").on("click", function(e){
		A.MyGooglePicker.onApiLoad('${developerKey}','${clientId}','${pns}');
	});
</aui:script>
    
</c:if>	
