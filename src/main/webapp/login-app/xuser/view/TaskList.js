/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.TaskList", {
    extend: 'Ext.grid.Panel',
    alias: 'widget.tasklist',

    requires: [
        'APP.xuser.store.TaskStore',
        'APP.xuser.view.TaskEdit'
    ],

    columns: [
        {header: 'ID', dataIndex: 'id'},
        {header: 'Name', dataIndex: 'taskName'},
        {header: 'TaskDescription', dataIndex: 'taskDescription'},
        {header: 'User', dataIndex: 'userName'},
        {header: 'Project', dataIndex: 'projectName'}
    ]

    ,
    initComponent: function () {
        var store = this.getTaskStore();
        var userStore = Ext.create('APP.xuser.store.XUserComboStore', {});
        var projectStore = Ext.create('APP.xuser.store.ProjectComboStore', {});
        userStore.load();
        projectStore.load();
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
                            text: 'Add Task',
                            modal: true,
                            handler: function () {
                                var win = Ext.widget("window", {
                                    title: 'Add User',
                                    layout: 'fit',

                                    items: {
                                        xtype: 'taskedit',
                                        frame: true,

                                        onCancel: function () {
                                            win.close();
                                        },

                                        onSave: function (values) {
                                            store.add(values);
                                            store.sync();
                                            win.close();
                                        }
                                    }
                                });
                                win.show();
                            }
                        }

                    ]
                },
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
                        title: 'Update Task',
                        modal: true,
                        items: [
                            {
                                xtype: 'taskedit',
                                userStore: userStore,
                                projectStore: projectStore,
                                activeRecord: record,
                                onCancel: function () {
                                    mywin.close();
                                },
                                onUpdate: function () {
                                    store.sync();
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

    getTaskStore: function () {
        var store = Ext.data.StoreManager.lookup('task');
        if (store == null) {
            store = Ext.create('APP.xuser.store.TaskStore', {
                storeId: 'task',
                autoLoad: true
            });
        }
        return store;
    }
});