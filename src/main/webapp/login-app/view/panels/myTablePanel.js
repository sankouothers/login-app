Ext.define('APP.view.panels.MyTablePanel', {
    requires: ['APP.view.list.UserList',
        'APP.view.list.RoleList'],
    extend: 'Ext.tab.Panel',
    alias: 'widget.MyTablePanel',
    items: [
        {
            title: 'User List',
            xtype: 'UserList'
        },
        {
            title: 'Role List',
            xtype: 'RoleList'
        },
        //{
        //    title: 'Project List',
        //    xtype: 'ProjectList'
        //},
        //{
        //    title: 'Task List' ,
        //    xtype: 'TaskList'
        //}
    ]
});
