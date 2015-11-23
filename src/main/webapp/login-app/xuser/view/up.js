/**
 * Created by Administrator on 2015/11/23.
 */
var imagebox = new Ext.BoxComponent({
    autoEl: {
        style: 'width:150px;height:150px;margin:0px auto;border:1px solid #ccc; text-align:center;padding-top:20px;margin-bottom:10px',
        tag: 'div',
        id: 'imageshow',
        html: '����ͼƬ'
    }
});
//�����ı��ϴ���
var file = new Ext.form.TextField({
    name: 'imgFile',
    fieldLabel: '�ļ��ϴ�',
    inputType: 'file',
    allowBlank: false,
    blankText: '�����ͼƬ'
});
//�ύ��ť������
var btnsubmitclick = function () {
    if (form.getForm().isValid()) {
        form.getForm().submit({
            waitTitle: "���Ժ�",
            waitMsg: '�����ϴ�...',
            success: function (form, action) {
                Ext.MessageBox.alert("��ʾ", "�ϴ��ɹ���");
                document.getElementById('imageshow').innerHTML = '<img style="width:150px;height:150px" src="' + action.result.path + '"/>';
            },
            failure: function () {
                Ext.MessageBox.alert("��ʾ", "�ϴ�ʧ�ܣ�");
            }
        });
    }
}
//���ð�ť"���ʱ"������
var btnresetclick = function () {
    form.getForm().reset();
}
//��
var form = new Ext.form.FormPanel({
    frame: true,
    fileUpload: true,
    url: '/App_Ashx/Demo/Upload.ashx',
    title: '������',
    style: 'margin:10px',
    items: [imagebox, file],
    buttons: [{
        text: '����',
        handler: btnsubmitclick
    }, {
        text: '����',
        handler: btnresetclick
    }]
});
//����
var win = new Ext.Window({
    title: '����',
    width: 476,
    height: 374,
    resizable: true,
    modal: true,
    closable: true,
    maximizable: true,
    minimizable: true,
    buttonAlign: 'center',
    items: form
});