Ext.require('app.model.CatalogModel');

Ext.define('app.store.CatalogStore', {
    extend: 'Ext.data.Store',
    model: 'app.model.CatalogModel',
    autoLoad: true,
    autoSync: true,
    proxy: {
            type: 'rest',
            api: {
                create: 'client',
                read: 'client',
                destroy: 'client',
                update: 'client'
            },
            reader: {
                type: 'json',
                root: 'data',
                successProperty: 'success'
            },
            writer: {
                type: 'json',
                writeAllFields: true
            }

        }
});