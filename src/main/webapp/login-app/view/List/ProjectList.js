Ext.define('APP.view.list.UserList', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.UserList',
    requires: ['APP.model.UserModel'],

    viewConfig: {
        forceFit: true
    },

    columns: [
        {header: 'Name', dataIndex: 'name'},
        {header: 'Gender', dataIndex: 'gender'},
        {header: 'Age', dataIndex: 'age'},
        {header: 'BirthDay', dataIndex: 'birthDate'},
        {header: 'Email', dataIndex: 'email'},
        {header: 'Phone', dataIndex: 'phoneNumber'}
    ],
    initComponent: function () {
        var store = this.getUserStore();
        Ext.apply(this, {
            store: store,
            tbar: [
                {
                    xtype: 'buttongroup',
                    items: {
                        xtype: "button",
                        text: 'Update User'
                    }
                },
                '-',
                {
                    xtype: 'buttongroup',
                    items: {
                        xtype: "button",
                        text: 'Delete User'
                    }
                },
                '-',
                '->',
                {
                    xtype: "button",
                    text: 'Refresh'
                }
            ]

        });

        this.callParent(arguments);
    },
    getUserStore: function () {
        var store = Ext.data.StoreManager.lookup('UserStore');
        if (!store) {
            store = Ext.create("APP.store.UserStore", {
                storeId: 'UserStore'
            });
        }
        return store;
    }
});