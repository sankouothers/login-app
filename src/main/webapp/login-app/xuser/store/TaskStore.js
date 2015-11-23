Ext.define("APP.xuser.store.TaskStore", {
    extend: 'Ext.data.Store',
    model: 'APP.xuser.model.TaskModel',
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
            create  : '/x/task/create',
            read    : '/x/task/list',
            update  : '/x/task/update',
            destroy : '/x/task/delete'
        }
    }

});