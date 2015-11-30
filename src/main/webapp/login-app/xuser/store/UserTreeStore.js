/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.store.UserTreeStore", {
    extend: 'Ext.data.TreeStore',

    proxy: {
        type: 'ajax',
        url: '/usertree/list',
        reader: {
            type: 'json',
            root: 'data',
        },



    }
});