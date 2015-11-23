Ext.define("APP.xuser.model.TaskModel", {
    extend: 'Ext.data.Model',
    fields: [
        {
            name: 'id',
            type:'int'
        },
        {
            name:'taskName',
            type:'string',
            mapping:'taskName'
        },
        {
            name:'taskDescription',
            type:'string',
            mapping:'taskDescription'
        },
        {
            name: 'userId',
            mapping: 'userId'
        },
        {
            name: 'projectId',
            mapping: 'projectId'
        },
        {
            name: 'userName',
            mapping: 'userName',
            persist : false
        },
        {
            name: 'projectName',
            mapping: 'projectName',
            persist : false
        }
    ]
});