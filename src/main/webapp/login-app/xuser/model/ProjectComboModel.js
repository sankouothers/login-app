Ext.define("APP.xuser.model.ProjectComboModel", {
    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'projectId',
            type: 'int',
            mapping:'id'
        },
        {
            name: 'projectName',
            type: 'string',
            mapping: 'projectName'
        }
    ]
});