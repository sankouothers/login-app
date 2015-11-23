/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.store.QueryStore", {
    extend: 'Ext.data.Store',
    model: 'APP.xuser.model.QueryStore',

    pageSize: 10,

    proxy: {
        type: 'ajax',

        reader: {
            type: 'json',
            idProperty: 'id',
            totalProperty: 'total',
            successProperty: 'success',
            messageProperty: 'msg',
            root: 'data'
        },
        api: {
            read: '/x/user/query'
        }
    }
});