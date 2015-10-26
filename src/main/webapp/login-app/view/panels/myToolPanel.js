Ext.define('APP.view.panels.myToolPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.myToolPanel',
    height: '30%',
    layout: 'hbox',
    items: [
        {

            xtype: 'button',
            glyph: 72,
            scale: 'large',
            text: '添加用户',
            handler: function () {
                //取到当前的整个网页页面  创建一个 window
                Ext.widget('window', {
                    title: "添加用户",
                    resizable: false,
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
