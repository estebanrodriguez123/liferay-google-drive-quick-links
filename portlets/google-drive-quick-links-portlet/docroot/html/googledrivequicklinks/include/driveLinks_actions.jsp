<%--
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
--%>

<%@include file="/html/init.jsp" %>

<% 
ResultRow row = (ResultRow)request.getAttribute(com.liferay.portal.kernel.util.WebKeys.SEARCH_CONTAINER_RESULT_ROW);
DriveLinks link = (DriveLinks)row.getObject();
%>

<portlet:actionURL name="deleteDriveLink" var="deleteDriveLinkUrl">
    <portlet:param name="linkId" value="<%=link.getDOCUMENT_ID()%>"/>
    <portlet:param name="linkUser" value="<%=link.getUSER_ID()%>"/>
    <portlet:param name="redirectTo" value="<%= PortalUtil.getCurrentURL(request) %>"/>
</portlet:actionURL>

<liferay-ui:icon-delete url="${deleteDriveLinkUrl}" />
