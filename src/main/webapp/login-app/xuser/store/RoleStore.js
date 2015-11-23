Ext.define("APP.xuser.store.RoleStore", {
    extend: 'Ext.data.Store',
    model: 'APP.xuser.model.RoleModel',

    proxy: {
        type: 'ajax',
        reader: {
            root: 'data',
            type: 'json',
            idProperty: 'id',
            totalProperty: "total",
            successProperty: "success"
        },
        api: {
            create  : '/x/role/create',
            read    : '/x/role/list',
            update  : '/x/role/update',
            destroy : '/x/role/delete'
        }
    }

});