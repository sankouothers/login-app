/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.RoleList", {
    extend: 'Ext.grid.Panel',
    alias: 'widget.rolelist',

    requires: [
        'APP.xuser.store.RoleStore',
        'APP.xuser.view.RoleEdit'
    ],

    columns: [
        {header: 'ID', dataIndex: 'id'},
        {header: 'Name', dataIndex: 'name'},
        {header: 'Description', dataIndex: 'description'}
    ]

    ,
    initComponent: function () {
        var grid = this;
        var store = this.getRoleStore();
        Ext.apply(this, {
            store: store,
            dockedItems: [{
                xtype: 'pagingtoolbar',
                store: store,   // same store GridPanel is using
                dock: 'bottom',
                displayInfo: true,
                prevText: "上一页",
                beforePageText: "第",
                afterPageText: "页 - 共{0}页",
                nextText: "下一页",
                lastText: "最后一页",
                firstText: "第一页",
                refreshText: "刷新",
                displayMsg: '第{0}条--第{1}条数据   一共{2}条数据'
            }],
            tbar: [
                {
                    xtype: 'buttongroup',
                    items: [
                        {
                            text: 'Add Role',
                            modal: true,
                            handler: function () {
                                var win = Ext.widget("window", {
                                    title: 'Add Role',
                                    layout: 'fit',

                                    items: {
                                        xtype: 'roleedit',
                                        frame: true,

                                        onCancel: function () {
                                            win.close();
                                        },

                                        onSave: function (values) {
                                            store.add(values);
                                            store.sync();
                                            win.close();
                                            store.load();
                                        }
                                    }
                                });
                                win.show();
                            }
                        }

                    ]
                },
                //{
                //    xtype: 'buttongroup',
                //    items: {
                //        xtype: 'button',
                //        text: 'Delete Role',
                //        handler: function () {
                //            if (grid.getSelectionModel().hasSelection()) {
                //                store.remove(grid.getSelectionModel().getSelection());
                //                store.sync();
                //                store.load();
                //            }
                //        }
                //    }
                //},
                "->",
                {
                    xtype: 'buttongroup',
                    items: {
                        text: "Refresh",
                        handler: function(){
                            store.load();
                        }
                    }
                }

            ],
            listeners: {
                'itemdblclick': function (view, record) {
                    var mywin = Ext.widget("window", {
                        title: 'Update Role',
                        modal: true,
                        items: [
                            {
                                xtype: 'roleedit',
                                activeRecord: record,
                                onCancel: function () {
                                    mywin.close();
                                },
                                onUpdate: function () {
                                    store.save();
                                    mywin.close();
                                }

                            }
                        ]
                    });
                    mywin.show();
                }
            }
        });

        this.callParent(arguments); // super.initComponent(arguments)
    },

    getRoleStore: function () {
        var store = Ext.data.StoreManager.lookup('role');
        if (store == null) {
            store = Ext.create('APP.xuser.store.RoleStore', {
                storeId: 'role',
                pageSize:10,
                autoLoad: true
            });
        }
        return store;
    }
});