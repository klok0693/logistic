Ext.define('app.store.Cr', {
    extend: 'Ext.data.Store',
    model: 'app.model.Owner',
    autoLoad: true,
    autoSync: false,
    proxy: {
            //type: 'ajax',
            type: 'rest',
            url: 'http://localhost:8082/client/single',
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