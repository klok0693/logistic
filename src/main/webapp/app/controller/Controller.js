Ext.define('app.controller.Controller', {
    extend: 'Ext.app.Controller',

    stores: ['Cargos', 'Cr'],

    models: ['Cargo'],

    views: [
            'ClientView',
            'EditClient',
            'ClientGrid',
            'welcome_page.Login',
            'Viewport',
            'welcome_page.WelcomePage',
            'SelectStoreHouse',
            'SearchCargo'
    ],

    refs: [
        {ref:'welcomePage',       selector:'welcomePage'},
        {ref: 'viewport',         selector: 'viewport'},
        {ref: 'clientView',       selector: 'clientView'},
        {ref: 'clientsPanel',     selector: 'panel'},
        {ref: 'clientGrid',       selector:'clientGrid'},
        {ref: 'login',            selector:'login'},
        {ref: 'editClient',       selector: 'editClient'},
        {ref: 'selectStoreHouse', selector: 'selectStoreHouse'},
        {ref: 'searchCargo',      selector: 'searchCargo'}
    ],

    init: function() {
        this.control({
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
            },
            'selectStoreHouse button[action=go]': {
                click: this.changeStore
            },
            'searchCargo button[action=search]': {
                click: this.findCargo
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
              //var obj = Ext.getStore('Cr').load().getAt(0);
              var obj = Ext.create(Ext.getStore('Cr').model);
              var object = Ext.getStore('Cr').load().getAt(0);

              console.log('loaded obj', object.getData().owner);
              console.log('form',form.getValues());

              var frm = form.getForm();

              obj.set('format',           frm.findField('format').getValue());
              //obj.set('id', form.getForm().findField('id').getValue());
              obj.set('name',             frm.findField('name').getValue());
              obj.set('owner',            object.getData().owner);
              obj.set('productionDate',   frm.findField('productionDate').getValue());
              obj.set('shelfLife',        frm.findField('shelfLife').getValue());
              obj.set('size',             frm.findField('size').getValue());
              obj.set('type',             frm.findField('type').getValue());

              console.log('obj after', obj);

              this.getClientGrid().store.add(obj);
          }
        win.close();
    },

    addClient: function() {
        Ext.widget('editClient');
    },

    deleteClient: function() {
        var grid       = this.getClientGrid(),
            selection  = grid.getSelectionModel().getSelection();

        grid.store.remove(selection[0]);
        grid.store.commitChanges();
    },

    loginUser: function(button) {
        //var form = button.up('form').getForm();
        button.up('form').getForm().submit({
                        url: 'http://localhost:8082/j_spring_security_check',
                        success: function(form, action){
                                   var view      = Ext.create('app.view.ClientView'),
                                       viewport  = button.up('viewport');

                                   viewport.getLayout().setActiveItem(view)
                        },
                        failure: function(form, action){
                                    Ext.MessageBox.alert('Authoriation failed');//,action.result.message
                                }
                    });
    },

    changeStore: function(button) {
        var store = this.getClientGrid().store,
            store_id = button.up('form').down('combo').getValue();

        //
        store.load({params:{store:store_id}});
    },

    findCargo: function(button) {
        var store = this.getClientGrid().store,
            name = button.up('form').down('textfield').getValue(),
            cargo = store.findRecord('type', name);

        if (cargo !== null) {

            var edit = Ext.create('app.view.EditClient').show();
            edit.down('form').loadRecord(cargo);
        }
        else Ext.MessageBox.alert('Cant find Cargo');
    }
});