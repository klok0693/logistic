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
            /*'viewport > clientGrid dataview': {
                itemdblclick: this.editClient
            },*/
            'editClient button[action=save]': {
                click: this.updateClient
            },
            'clientGrid button[action=add]': {
                click: this.addClient
            }
        });
    },

    editClient: function(grid, record) {
        var edit = Ext.create('client.view.EditClient').show();

        edit.down('form').loadRecord(record);
    },

    updateClient: function(button) {
        var win    = button.up('window'),
            store  = Ext.create('client.store.Clients'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        store.add(form.getValues());
        //store.sync();
        win.close();
        //this.getClientsStore().sync();
    },

    addClient: function() {
        Ext.widget('editClient');
    }
});