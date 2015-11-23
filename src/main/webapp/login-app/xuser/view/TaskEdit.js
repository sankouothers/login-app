/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.TaskEdit", {
    extend: 'Ext.form.Panel',
    alias: 'widget.taskedit',

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
        }, {
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
            items: [
                {
                    xtype: 'textfield',
                    name: 'taskName',
                    fieldLabel: 'Task Name',
                    allowBlank: false  // 表单项非空
                },
                {
                    xtype: 'textfield',
                    name: 'taskDescription',
                    fieldLabel: 'Description',
                    allowBlank: false  // 表单项非空
                },
                {
                    xtype: 'combobox',
                    name: 'userId',
                    fieldLabel: 'User',
                    store: this.userStore,
                    queryMode: 'local',
                    triggerAction: 'all',
                    displayField: 'username',
                    valueField: 'userId'
                },
                {
                    xtype:'combobox',
                    name:'projectId',
                    fieldLabel: 'Project',
                    store: this.projectStore,
                    queryMode:'local',
                    triggerAction:'all',
                    displayField:'projectName',
                    valueField:'projectId'
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