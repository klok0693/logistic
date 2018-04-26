Ext.define('app.store.StoreHouses', {
    extend: 'Ext.data.Store',
    model: 'app.model.StoreHouse',
    autoLoad: true,
    autoSync: false,
    proxy: {
            //type: 'ajax',
            type: 'rest',
            url: 'http://localhost:8082/storehouse/all',
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