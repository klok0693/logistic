Ext.define('app.store.Cargos', {
    extend: 'Ext.data.Store',
    model: 'app.model.Cargo',
    autoLoad: true,
    autoSync: true,
    proxy: {
            //type: 'ajax',
            type: 'rest',
            url: 'http://localhost:8082/cargo',
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