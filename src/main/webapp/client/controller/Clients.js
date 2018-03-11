Ext.define('client.controller.Clients', {
    extend: 'Ext.app.Controller',

    stores: ['Clients'],

    models: ['Client'],

    views: ['EditClient', 'ClientGrid'],

    refs: [
        {ref: 'clientsPanel', selector: 'panel'},
        {ref: 'clientGrid', selector:'clientGrid'}
    ],

    init: function() {
        this.control({
            'viewport > clientGrid dataview': {
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
            }
        });
    },

    editClient: function(grid, record) {

        var edit = Ext.create('client.view.EditClient').show();
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
              Ext.create('client.store.Clients').add(form.getValues());
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

    }
});