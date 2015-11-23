Ext.define('APP.view.AppViewPort', {
    extend: 'Ext.container.Viewport',

    requires:[
        "APP.view.panels.MyTablePanel",
        "APP.view.panels.MyToolPanel"
    ],
    layout: {
        type: 'vbox'
    },
    items:[
        {
            xtype: 'MyToolPanel',
            title:'My Extjs Project',
            width: '100%',
            flex: 4
        },
        {
            xtype:'MyTablePanel',
            width: '100%',
            flex: 4
        }
    ]
});