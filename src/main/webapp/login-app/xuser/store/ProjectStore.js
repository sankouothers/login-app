Ext.define("APP.xuser.store.ProjectStore", {
    extend: 'Ext.data.Store',
    model: 'APP.xuser.model.ProjectModel',
    pageSize:10,
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
            create  : '/x/project/create',
            read    : '/x/project/list',
            update  : '/x/project/update',
            destroy : '/x/project/delete'
        }
    }

});