Ext.define('APP.xuser.view.UploadImg', {
    extend: 'Ext.form.Panel',
    alias: 'widget.uploadimg',

    bodyPadding: 10,
    frame: true,
    userID: null,

    buttons: [{
        text: 'Upload',
        handler: function (btn) {
            var form = this.up('form').getForm();

            if (form.isValid()) {
                form.submit({
                    url: 'x/user/upload',
                    waitMsg: '正在上传图片',
                    success: function (fp, o) {
                        alert("图片已上传");
                        btn.up("window").close()
                    },
                    failure: function (form, action) {
                        Ext.Msg.alert("文件上传失败");
                    }
                });
            }
        }
    }],
    initComponent: function () {
        var a = this.userID;
        Ext.apply(this, {

            items: [
                {
                    xtype: 'textfield',
                    hidden: true,
                    hideLabel: true,
                    name: "id",
                    value: a,
                    fieldLabel: 'Name'
                },
                    {
                    xtype: 'filefield',
                    name: 'photo',
                    fieldLabel: '图片',
                    labelWidth: 50,
                    msgTarget: 'side',
                    allowBlank: false,
                    anchor: '100%',
                    buttonText: '选择图片'
                },
                {
                    xtype: 'box',
                    id: 'browseImage',
                    fieldLabel: "预览图片",
                    html: "<img src='/x/user/photo?id="+a+"' width='200px' height='150px' />"
                    //autoEl: {
                    //    width: 300,
                    //    height: 350,
                    //    tag: 'img',
                    //    type: 'image',
                    //    src: '/x/user/photo?id='+a,
                    //    complete: 'off'
                    //}
                }
            ]
        });
        this.callParent(arguments);
    }
});
