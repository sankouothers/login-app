/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.XUserEdit", {
    extend: 'Ext.form.Panel',
    alias: 'widget.xuseredit',

    padding: '5,5,5,5',
    buttons: [
        {
            text: 'Save',
            formBind: true, //only enabled once the form is valid
            disabled: true,
            handler: function (btn) {
                var formPanel = btn.up('form');
                var form = formPanel.getForm();
                if (form.isValid()) {
                    if (formPanel.activeRecord) {
                        // update
                        form.updateRecord(formPanel.activeRecord);
                        formPanel.onUpdate();
                    } else {
                        // create new
                        formPanel.onSave(form.getValues());
                    }
                }
            }
        },
        {
            text: 'Cancel',
            handler: function (btn) {
                var formPanel = btn.up('form');
                formPanel.onCancel();
            }
        }
    ],
    onUpdate: Ext.emptyFn,
    onSave: Ext.emptyFn,
    onCancel: Ext.emptyFn,
    initComponent: function () {
        Ext.apply(this, {
            default: {
                anchor: '90%'
            },
            items: [
                {
                    xtype: 'textfield',
                    name: 'username',
                    fieldLabel: 'User Name',
                    blankText: "用户名不能为空",
                    allowBlank: false, // 表单项非空
                    validator: function (val) {
                        var a = val.replace(/^[A-Za-z]*\w+$/g),
                            errMsg = "用户名必须是字母开头，后接数字字母或下划线";
                        return a ? true : errMsg;
                    }
                },
                {
                    xtype: 'textfield',
                    inputType: 'password',
                    name: 'password',
                    fieldLabel: 'Password',
                    blankText: "密码不能为空",
                    allowBlank: false  // 表单项非空
                },
                {
                    xtype: 'numberfield',
                    name: 'age',
                    fieldLabel: 'Age'
                },
                {
                    xtype: 'textfield',
                    name: 'email',
                    fieldLabel: 'Email Address',
                    validator: function (val) {
                        if (!val) {
                            return true;
                        } else {
                            var a = val.replace(/\w+([-+.]\w+)*@*\.\w+([-.]\w+)*/g, ''),
                                errMsg = "必须输入正确格式的邮箱";
                            return a ? true : errMsg;
                        }
                    }
                },
                {
                    xtype: 'radiogroup',
                    id: 'genderRadio',
                    fieldLabel: 'Gender',
                    columns: 2,
                    items: [
                        {
                            boxLabel: '男',
                            name: 'gender',
                            inputValue: 'man'
                        },
                        {
                            boxLabel: '女',
                            name: 'gender',
                            inputValue: 'male'
                        }
                    ]
                },
                {
                    xtype: 'textfield',
                    name: 'phoneNumber',
                    fieldLabel: 'PhoneNumber',
                    validator: function (val) {
                        // remove non-numeric characters
                        var tn = val.replace(/[^0-9]/g),
                            errMsg = "必须输入长度为11的手机号码";
                        // if the numeric value is not 10 digits return an error message
                        return (tn.length == 11) ? true : errMsg;
                    }
                },
                {
                    xtype: 'datefield',
                    name: 'birthDateString',
                    fieldLabel: 'BirthDate',
                    format: 'Y-m-d'
                },
                {
                    xtype: 'combobox',
                    name: 'roleId',
                    fieldLabel: 'Role',
                    store: this.roleStore,
                    queryMode: 'local',
                    triggerAction: 'all',
                    displayField: 'name',
                    valueField: 'roleId'
                }
            ]
        });
        this.callParent();
    },
    afterRender: function () {
        this.callParent();
        if (this.activeRecord)
            this.loadRecord(this.activeRecord);
    }
});

