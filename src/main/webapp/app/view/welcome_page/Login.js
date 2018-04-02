Ext.define('app.view.welcome_page.Login', {
    extend: 'Ext.form.Panel',
    alias: 'widget.login',
    title: 'Account',
    wight: 300,
    height: 150,
    //style:{'background-color':'white'},
    //bodyStyle: 'opacity:1.0;',
    layout: 'anchor',
     defaults: {
        anchor: '80%'
    },
    items: [
        {
          xtype: 'textfield',
          fieldLabel: 'Login',
          name: 'j_username',
          labelAlign: 'top',
          cls: 'field-margin',
          flex: 1
        },
        {
          xtype: 'textfield',
          fieldLabel: 'Password',
          name: 'j_password',
          labelAlign: 'top',
          cls: 'field-margin',
          flex: 2
        }
    ],
    buttons: [{
            text: 'login',
            action: 'login'
        },
        {
        text: 'reset',
        handler: function() {
            this.up('form').getForm().reset();
            }
        }
    ]
});