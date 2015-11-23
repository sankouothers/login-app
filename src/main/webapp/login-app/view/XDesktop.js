/**
 * Created by Administrator on 2015/10/29.
 */
Ext.define('APP.view.XDesktop', {
    extend: 'Ext.container.Viewport',
    requires:[
        'APP.xuser.view.XUserList',
        'APP.xuser.view.ProjectList',
        'APP.xuser.view.TaskList',
        'APP.xuser.view.RoleList'
    ],

    layout: 'fit',

    items: {
        xtype: 'tabpanel',
        items: [
            {
                title: 'XUser',
                xtype:'xuserlist'

            },
            {
                title: 'Role',
                xtype:'rolelist'
            },
            {
                title: 'Project',
                xtype:'projectlist'
            },
            {
                title: 'Task',
                xtype:'tasklist'
            }

        ]
    }
});