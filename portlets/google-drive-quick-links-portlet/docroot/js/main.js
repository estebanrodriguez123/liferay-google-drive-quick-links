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

AUI().use('aui-modal', 'aui-io','picker-module', function (A) {
    function UtilityClass() {
        this.portletNamespace;
        this.developerKey;
        this.clientId;
        this.scope = ['https://www.googleapis.com/auth/drive'];
        this.pickerApiLoaded = false;
        this.oauthToken;
    }

    UtilityClass.prototype = {
        formSubmit: function (pns) {
            this.portletNamespace = pns;
            A.one("#"+ this.portletNamespace +"form").submit();
        },
        selectFile: function (devKey,cId,pns) {
            A.MyGooglePicker.onApiLoad(devKey, cId, pns);
        }
    };
    window.UtilityClass = new UtilityClass();
});