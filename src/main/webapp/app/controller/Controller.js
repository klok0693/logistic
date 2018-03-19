Ext.define('app.controller.Controller', {
    extend: 'Ext.app.Controller',

    stores: ['Clients'],

    models: ['Client'],

    views: ['ClientView', 'EditClient', 'ClientGrid', 'welcome_page.Login', 'Viewport',
            'welcome_page.WelcomePage'],

    refs: [
        {ref:'welcomePage', selector:'welcomePage'},
        {ref: 'viewport', selector: 'viewport'},
        {ref: 'clientView', selector: 'clientView'},
        {ref: 'clientsPanel', selector: 'panel'},
        {ref: 'clientGrid', selector:'clientGrid'},
        {ref: 'login', selector:'login'},
        {ref: 'editClient', selector: 'editClient'}
    ],

    init: function() {
        this.control({
            /*'viewport > clientGrid dataview': {
                itemdblclick: this.editClient
            },*/
            'clientGrid': {
                itemdblclick: this.editClient
            },
            'editClient button[action=save]': {
                click: this.updateClient
            },
            'clientGrid button[action=add]': {
                click: this.addClient
            },
            'clientGrid button[action=delete]': {
                click: this.deleteClient
            },
            'login button[action=login]': {
                click: this.loginUser
            }
        });
    },

    editClient: function(grid, record) {

        var edit = Ext.create('app.view.EditClient').show();
        edit.down('form').loadRecord(record);
    },

    updateClient: function(button) {

        var win    = button.up('window'),
            form   = win.down('form'),
            values = form.getValues();

         var record = form.getRecord();
          if(record !== undefined) {
              record.set(values);
          }
          else {
              Ext.create('app.store.Clients').add(form.getValues());
          }
        win.close();
    },

    addClient: function() {
        Ext.widget('editClient');
    },

    deleteClient: function() {
        var sm = this.getClientGrid().getSelectionModel();
        var rs = sm.getSelection();

        this.getClientGrid().store.remove(rs[0]);
        this.getClientGrid().store.commitChanges();

    },

    loginUser: function(button) {
        //var form = button.up('form').getForm();
        button.up('form').getForm().submit({
                        url: 'http://localhost:8082/j_spring_security_check',
                        success: function(form, action){
                                   var v = Ext.create('app.view.ClientView');
                                   var g = button.up('viewport');
                                   g.getLayout().setActiveItem(v)
                        },
                        failure: function(form, action){
                                    Ext.MessageBox.alert('Ошибка авторизации. ');//,action.result.message
                                }
                    });
    }
});