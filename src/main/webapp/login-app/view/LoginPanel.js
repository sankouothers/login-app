Ext.define('APP.view.LoginPanel', {
    extend: 'Ext.form.Panel',
    alias: 'widget.LoginPanel',
    padding: '10 10 10 10',

    url: 'login',

    defaults: {
        anchor: '90%'
    },

    defaultType: 'textfield',
    items: [
        {
            fieldLabel: 'User Name',
            name: 'username',
            allowBlank: false,
            blankText: '用户名不能为空'
        }, {
            fieldLabel: 'Pass Word',
            name: 'password',
            allowBlank: false,
            blankText: '密码不能为空'
        }],

    buttons: [{
        text: 'Login',
        handler: function () {
            var formPanel = this.up("form");
            var form = formPanel.getForm();
            form.submit(
                {
                    success: function (form, action) {
                        window.location.href = "xDesktop";
                    },
                    failure: function (form, action) {
                        window.location.href = "login";
                    }
                }
            );
        }
    }]
});