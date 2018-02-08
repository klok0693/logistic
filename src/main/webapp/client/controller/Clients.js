Ext.define('client.controller.Clients', {
    extend: 'Ext.app.Controller',

    stores: ['Clients'],

    models: ['Client'],

    views: ['EditClient', 'ClientGrid'],

    refs: [
        {
            ref: 'clientsPanel',
            selector: 'panel'
        }
    ],

    init: function() {
        this.control({
            'viewport > clientGrid dataview': {
                itemdblclick: this.editClient
            },
            'editClient button[action=save]': {
                click: this.updateClient
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
            record = form.getRecord(),
            values = form.getValues();

        record.set(values);
        win.close();
        this.getClientsStore().sync();
    }
});