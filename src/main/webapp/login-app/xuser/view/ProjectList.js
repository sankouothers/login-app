/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.ProjectList", {
    extend: 'Ext.grid.Panel',
    alias: 'widget.projectlist',

    requires: [
        'APP.xuser.store.ProjectStore',
        'APP.xuser.view.ProjectEdit'
    ],

    columns: [
        {header: 'ID', dataIndex: 'id'},
        {header: 'Name', dataIndex: 'projectName'},
        {header: 'username', dataIndex: 'username'}
    ]

    ,
    initComponent: function () {
        var store = this.getProjectStore();
        var userStore = Ext.create("APP.xuser.store.XUserComboStore",{});
        userStore.load();
        Ext.apply(this, {
            store: store,
            dockedItems: [{
                xtype: 'pagingtoolbar',
                store: store,   // same store GridPanel is using
                dock: 'bottom',
                displayInfo: true,
                prevText: "上一页",
                nextText: "下一页",
                beforePageText: "第",
                afterPageText: "页 - 共{0}页",
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
                            text: 'Add Project',
                            modal: true,
                            handler: function () {
                                var win = Ext.widget("window", {
                                    title: 'Add Project',
                                    layout: 'fit',

                                    items: {
                                        xtype: 'projectedit',
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
                //        text: 'Delete Project',
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
                        handler: function () {
                            store.load();
                        }
                    }
                }

            ],
            listeners: {
                'itemdblclick': function (view, record) {
                    var mywin = Ext.widget("window", {
                        title: 'Update Project',
                        modal: true,
                        items: [
                            {
                                xtype: 'projectedit',
                                userStore:userStore,
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

    getProjectStore: function () {
        var store = Ext.data.StoreManager.lookup('project');
        if (store == null) {
            store = Ext.create('APP.xuser.store.ProjectStore', {
                storeId: 'project',
                autoLoad: true
            });
        }
        return store;
    }
});