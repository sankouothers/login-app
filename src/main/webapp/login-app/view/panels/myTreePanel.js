Ext.define('APP.view.panels.myTreePanel',{
    extend: 'Ext.panel.Panel',
    alias: 'widget.myTreePanel',
    defaultType:'treepanel',
    layout:'accordion',
    items: [
        {
            title: 'User List',
            store:'usersName',
        },
        {
            title: 'Role List',
            store:'',
        },
        {
            title: 'Project List',
            store:'',
        },
        {
            title: 'Task List',
            store:'',
        }
    ]
});