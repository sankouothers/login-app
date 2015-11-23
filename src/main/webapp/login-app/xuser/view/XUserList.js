/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.XUserList", {
    extend: 'Ext.grid.Panel',
    alias: 'widget.xuserlist',

    requires: [
        'APP.xuser.store.XUserStore',
        'APP.xuser.view.XUserEdit',
        'APP.xuser.view.UploadImg'
    ],

    columns: [
        {header: 'ID', dataIndex: 'id'},
        {header: 'Name', dataIndex: 'username'},
        {header: 'Email', dataIndex: 'email'},
        {header: 'Age', dataIndex: 'age'},
        {header: 'Gender', dataIndex: 'gender'},
        {header: 'PhoneNumber', dataIndex: 'phoneNumber'},
        {header: 'BirthDate', dataIndex: 'birthDateString'},
        {header: 'Role', dataIndex: 'roleName'}
    ],
    onUpload: Ext.emptyFn,
    initComponent: function () {
        var grid = this;
        var store = this.getXUserStore();

        var roleStore = Ext.create("APP.xuser.store.RoleComboStore", {});
        roleStore.load();
        Ext.apply(this, {
            store: store,
            dockedItems: [{
                xtype: 'pagingtoolbar',
                store: store,   // same store GridPanel is using
                dock: 'bottom',
                displayInfo: true,
                prevText: "上一页",
                beforePageText: "第",
                nextText: "下一页",
                afterPageText: "页 - 共{0}页",
                lastText: "最后一页",
                firstText: "第一页 ",
                refreshText: "刷新",
                displayMsg: '第{0}条--第{1}条数据   一共{2}条数据'
            }],
            tbar: [
                {
                    xtype: 'buttongroup',
                    items: [
                        {
                            text: 'Add User',
                            modal: true,
                            handler: function () {
                                var win = Ext.widget("window", {
                                    title: 'Add User',
                                    layout: 'fit',
                                    //draggable:false,
                                    modal: true,
                                    items: {
                                        xtype: 'xuseredit',
                                        roleStore: roleStore,
                                        frame: true,

                                        onCancel: function () {
                                            win.close();
                                        },

                                        onSave: function (values) {
                                            store.add(values);
                                            store.sync();
                                            store.load();
                                            win.close();
                                        }
                                    }
                                });
                                win.show();
                            }
                        }

                    ]
                },
                {
                    xtype: 'buttongroup',
                    items: {
                        xtype: 'button',
                        text: 'Delete User',
                        handler: function () {
                            if (grid.getSelectionModel().hasSelection()) {
                                store.remove(grid.getSelectionModel().getSelection());
                                store.sync();
                                store.load();
                            }
                        }
                    }
                },
                {
                    xtype: 'buttongroup',
                    items: {
                        text: "UpLoad img",
                        handler: function () {
                            var userid = grid.getSelectionModel().getLastSelected().get("id");
                            console.log(userid);
                            if (grid.getSelectionModel().hasSelection()) {
                                Ext.widget("window", {
                                    title: '上传图片',
                                    width: 300,
                                    height: 200,
                                    minWidth: 300,
                                    minHeight: 100,
                                    layout: 'fit',
                                    items:{
                                        xtype:'uploadimg',
                                        frame: true,
                                        fileUpload: true,
                                        style: 'margin:10px',
                                        userID:userid
                                    }
                                }).show();
                            }
                        }
                    }
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
                },
                {
                    xtype: 'textfield',
                    fieldLabel: '搜索姓名',
                    id: 'queryUser'
                },
                {
                    xtype: 'buttongroup',
                    items: [
                        {
                            text: 'Query',
                            handler: function () {
                                var value = Ext.getCmp('queryUser').getValue();
                                store.getProxy().setExtraParam("query", value);
                                store.loadPage(1);
                            }
                        }
                    ]
                }
            ],
            listeners: {
                'itemdblclick': function (view, record) {
                    var mywin = Ext.widget("window", {
                        title: 'Update User',
                        modal: true,
                        //draggable:false,
                        items: [
                            {
                                xtype: 'xuseredit',
                                roleStore: roleStore,
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

    //afterRender: function(){
    //    this.callParent(arguments); // super.initComponent(arguments)
    //
    //    var store = this.getXUserStore();
    //    store.load();
    //},

    getXUserStore: function () {
        var store = Ext.data.StoreManager.lookup('xUser');
        if (store == null) {
            store = Ext.create('APP.xuser.store.XUserStore', {
                storeId: 'xUser',
                autoLoad: true
            });
        }
        return store;
    }
});