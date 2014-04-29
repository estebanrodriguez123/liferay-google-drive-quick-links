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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.rivetlogic.portlet.service.DriveLinksLocalServiceUtil" %>
<%@ page import="com.rivetlogic.portlet.model.DriveLinks" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="java.util.List" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects />

<c:set var="pns"><portlet:namespace/></c:set>
<c:set var="developerKey" value="${developerKey}"/>
<c:set var="clientId" value="${clientId}"/>
