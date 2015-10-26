Ext.define('APP.view.AppViewPort', {
    extend: 'Ext.container.Viewport',
    requires:[
        "APP.view.panels.myTablePanel",
        "APP.view.panels.myToolPanel",
        "APP.view.panels.myTreePanel"
    ],
    layout: 'border',
    items:[
        {
            region: 'north',
            xtype: 'myToolPanel'
        },
        {
            region: 'west',
            xtype: 'myTreePanel',
            width: '20%'
        },
        {
            region: 'center',
            title:'3',
            xtype:'myTablePanel',
            height: '40%',
            width: '60%'
        }
    ]
});