Ext.define("APP.xuser.model.RoleModel", {
    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'id',
            type: 'int'
        },
        {
            name: 'name',
            type: 'string',
            mapping: 'name'
        },
        {
            name: 'description',
            type: 'string',
            mapping: 'description'
        }
    ]
});