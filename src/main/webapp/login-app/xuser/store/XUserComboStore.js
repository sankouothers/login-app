/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.store.XUserComboStore", {
    extend: 'Ext.data.Store',
    model: 'APP.xuser.model.XUserComboModel',
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
            create: '/x/user/create',
            read: '/x/user/list',
            update: '/x/user/update',
            destroy: '/x/user/delete'
        }
    }
});