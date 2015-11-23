Ext.define('APP.view.panels.MyToolPanel', {
    requires: ['APP.view.LoginPanel'],

    extend: 'Ext.panel.Panel',
    alias: 'widget.MyToolPanel',
    height: '30%',
    layout: 'hbox',
    items: [
        {

            xtype: 'button',
            text: '添加用户',
            handler: function () {
                Ext.widget('window', {
                    title: "添加用户",
                    resizable: false,
                    modal: true,
                    layout: 'fit',
                    items: [
                        {
                            frame: true,
                            xtype: 'LoginPanel'
                        }
                    ]
                }).show();
            }
        },
        {
            //这个button是要有一个  监听操作  监听是否有用户已经登录  如果有就显示为当前用户名
            xtype:'button',
            text:'登录'
        }
    ]
});
