Ext.define('client.store.Clients', {
    extend: 'Ext.data.Store',
    model: 'client.model.Client',
    autoLoad: true,
    //,autoSync: true
    proxy: {
            type: 'ajax',
            //type: 'rest',
            api: {
                create:  'http://localhost:8082/cargo',
                read:    'http://localhost:8082/cargo',
                destroy: 'http://localhost:8082/cargo',
                update:  'http://localhost:8082/cargo'
            },
            reader: {
                type: 'json',
                root: '',
                successProperty: 'success'
            }
            ,writer: {
                type: 'json',
                writeAllFields: true
            }

        }
});