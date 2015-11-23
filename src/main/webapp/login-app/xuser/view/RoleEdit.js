/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.RoleEdit", {
   extend: 'Ext.form.Panel',
    alias: 'widget.roleedit',

    items: [
        {
            xtype: 'textfield',
            name: 'name',
            fieldLabel: 'Role Name',
            allowBlank: false  // 表单项非空
        },
        {
            xtype: 'textfield',
            name: 'description',
            fieldLabel: 'Description'
        }
    ],

    buttons: [
        {
            text: 'Save',
            formBind: true, //only enabled once the form is valid
            disabled: true,
            handler: function(btn) {
                var formPanel = btn.up('form');
                var form = formPanel.getForm();
                if (form.isValid()) {
                    if(formPanel.activeRecord) {
                        // update
                        form.updateRecord(formPanel.activeRecord);
                        formPanel.onUpdate();
                    }else{
                        // create new
                        formPanel.onSave(form.getValues());
                    }
                }
            }
        },{
            text: 'Cancel',
            handler: function(btn) {
                var formPanel = btn.up('form');
                formPanel.onCancel();
            }
        }
    ],
    onUpdate: Ext.emptyFn,
    onSave: Ext.emptyFn,
    onCancel: Ext.emptyFn,
    initComponent: function(){
        this.callParent();
        if(this.activeRecord)
            this.loadRecord(this.activeRecord);
    }
});