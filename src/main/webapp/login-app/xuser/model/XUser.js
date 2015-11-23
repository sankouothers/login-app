/**
 * Created by Administrator on 2015/10/29.
 */
Ext.define("APP.xuser.model.XUser", {

    extend: 'Ext.data.Model',

    fields: [
        {
            name: 'id',
            type: 'int'
        },
        {
            name: 'username',
            type: 'string',
            mapping: 'username'
        },
        {
            name: 'password',
            type: 'string',
            mapping: 'password'
        },
        {
            name: 'age',
            type: 'int'
        },
        {
            name: 'gender',
            type: 'string'
        },
        {
            name: 'phoneNumber',
            type: 'string'
        },
        {
            name: 'birthDateString',
            mapping:'birthDateString'
        },
        {
            name: 'roleName',
            mapping: 'roleName',
            persist : false
        },
        {
            name: 'roleId',
            mapping: 'roleId'
        },
        'email'

    ]
});