//Ext.require('app.model.mModel');

Ext.define('app.store.mStore', {
    extend: 'Ext.data.Store',
    model: 'app.model.mModel',
    storeId: 'mStore',
    //fields: fields,
    //data: staticData
    //,alias: 'store.catalogStore'
    autoLoad: true
    //,autoSync: true
    ,proxy: {
                type: 'ajax',
                //url: 'http://localhost:8082/client',
                api: {
                    //create:   'client',
                    read:     'app/clients.json',
                    //destroy:  'client',
                    update:   'app/clients.json'
                },
                reader: {
                    type: 'json',
                    root: 'clients'
                    ,successProperty: 'success'
                } /*,
                writer: {
                    type: 'json',
                    writeAllFields: false
                }*/
            }
});