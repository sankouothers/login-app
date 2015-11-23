Ext.define("APP.xuser.model.ProjectModel", {
    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'id',
            type: 'int'
        },
        {
            name: 'projectName',
            type: 'string',
            mapping: 'projectName'
        },
        {
            name: 'username',
            type: 'string',
            mapping: 'username',
            persist : false
        },
        {
            name: 'userId',
            mapping: 'userId'
        }
    ]
});