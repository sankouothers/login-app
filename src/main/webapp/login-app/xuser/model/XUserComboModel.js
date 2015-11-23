/**
 * Created by Administrator on 2015/10/29.
 */
Ext.define("APP.xuser.model.XUserComboModel", {

    extend: 'Ext.data.Model',

    fields: [
        {
            name: 'userId',
            type: 'int',
            mapping:'id'
        },
        {
            name: 'username',
            type: 'string',
            mapping: 'username'
        }
    ]
});