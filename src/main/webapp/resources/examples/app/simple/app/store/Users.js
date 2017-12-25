Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',
    model: 'AM.model.User',
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'data/clients.json',
            //update: 'data/.json'
        },
        reader: {
            type: 'json',
            root: 'clients',
            successProperty: 'success'
        }
    }
});