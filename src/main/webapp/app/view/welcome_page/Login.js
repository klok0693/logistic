Ext.define('app.view.welcome_page.Login', {
    extend: 'Ext.form.Panel',
    alias: 'widget.login',
    title: 'авторизация',
    wight: 300,
    height: 150,
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
            /*handler: function() {
                this.up('form').getForm().submit({
                    url: 'http://localhost:8082/j_spring_security_check',
                    success: function(form, action){
                                //Ext.MessageBox.alert('Авторизация пройдена.');
                                var redirect = 'http://localhost:8082/grid';
                                window.location = redirect;
                    },
                    failure: function(form, action){
                                Ext.MessageBox.alert('Ошибка авторизации. ');//,action.result.message
                            }
                });
            }*/
        },
        {
        text: 'reset',
        handler: function() {
            this.up('form').getForm().reset();
            }
        }
    ]
});