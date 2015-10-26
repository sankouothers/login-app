Ext.define('APP.view.AppViewPort', {
    extend: 'Ext.container.Viewport',
    requires:[],
    layout: 'border',
    items:[
        {
            title:'1',
            region: 'north',
            xtype: 'myToolPanel',
            text:'asdfasdf',
            height: '30%',
            layout:'hbox',
            //items:[
            //    {
            //        xtype:'button',
            //        text:'添加用户',
            //        handler:function(){
            //            window.location.href="user/add";
            //        }
            //    }
            //]
        },
        {
            region: 'west',
            title:'2',
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