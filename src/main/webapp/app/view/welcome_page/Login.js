Ext.define('app.view.welcome_page.Login', {
    extend: 'Ext.form.Panel',
    alias: 'widget.login',
    title: 'авторизация',
    wight: 300,
    height: 115,
    layout: 'anchor',
     defaults: {
        anchor: '80%'
    },
    items: [
        {
          xtype: 'textfield',
          fieldLabel: 'логин',
          name: 'login',
          labelAlign: 'top',
          cls: 'field-margin',
          flex: 1
        },
        {
          xtype: 'textfield',
          fieldLabel: 'пароль',
          name: 'password',
          labelAlign: 'top',
          cls: 'field-margin',
          flex: 2
        }
    ],
    buttons: [
        {
        text: 'login',
        handler: function() {
            /*if(this.getForm().submit)
               url: 'http://localhost:8082/client'*/
               /*Ext.Ajax.request({
                   url: 'http://localhost:8082/client'
               });*/
            }
        }
    ]
    ,renderTo: Ext.getBody()
});