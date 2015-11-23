/**
 * Created by Administrator on 2015/10/29.
 */

Ext.define("APP.xuser.view.ProjectEdit", {
   extend: 'Ext.form.Panel',
    alias: 'widget.projectedit',
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
        },
        {
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
        Ext.apply(this,{
            items: [
                {
                    xtype: 'textfield',
                    name: 'projectName',
                    fieldLabel: 'Project Name',
                    allowBlank: false
                },
                {
                    xtype:'combobox',
                    name:'userId',
                    fieldLabel: 'Creator',
                    store: this.userStore,
                    queryMode:'local',
                    triggerAction:'all',
                    displayField:'username',
                    valueField:'userId'
                }
            ]
        });
        this.callParent();
    },
    afterRender:function(){
        this.callParent();
        if(this.activeRecord)
        this.loadRecord(this.activeRecord);
    }
});