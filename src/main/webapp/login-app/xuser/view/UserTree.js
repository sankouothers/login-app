Ext.define("APP.xuser.view.UserTree", {
    extend: 'Ext.tree.Panel',
    alias: 'widget.usertree',

    border: false,//表框
    autoScroll: true,//自动滚动条
    animate: true,//动画效果
    rootVisible: false,//根节点是否可见
    root: {
        text: 'Users',
        id: 'root'
    },

    initComponent: function () {
        var store = this.getUserTreeStore();
        var tree = this;

        Ext.apply(this, {
            store: store,
            listeners: {
                'itemcontextmenu': function(tree, record, item, index, e, eOpts){
                    var nodemenu = new Ext.menu.Menu({
                        items: [{
                            text: "刷新页面",
                            handler: function () {
                                store.load();
                            }
                        }]
                    });
                    nodemenu.showAt(e.getPoint());
                    e.preventDefault()
                //},
                //'cellcontextmenu': function () {
                //    var nodemenu = new Ext.menu.Menu({
                //        items: [{
                //            text: "刷新页面",
                //            handler: function () {
                //                store.load();
                //            }
                //        }]
                //    });
                //    nodemenu.showAt();
                //    return false;
                }
            },
            tbar: [
                {
                    xtype: 'buttongroup',
                    items: {
                        xtype: 'button',
                        text: '刷新当前节点',
                        handler: function () {
                            var node = tree.getSelectionModel().getLastSelected();
                            store.load({
                                node: node
                            })
                        }
                    }
                }

            ]
        });
        this.callParent(arguments);
    },
    getUserTreeStore: function () {
        var store = Ext.data.StoreManager.lookup('UserTree');
        if (store == null) {
            store = Ext.create('APP.xuser.store.UserTreeStore', {
                storeId: 'UserTree'
            });
        }
        return store;
    }
});