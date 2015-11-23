Ext.define("APP.xuser.model.RoleComboModel", {
    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'roleId',
            type: 'int',
            mapping:'id'
        },
        {
            name: 'name',
            type: 'string',
            mapping: 'name'
        }
    ]
});