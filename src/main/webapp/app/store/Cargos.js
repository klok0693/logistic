Ext.define('app.store.Cargos', {
    extend: 'Ext.data.Store',
    model: 'app.model.Cargo',
    autoLoad: true,
    autoSync: false,
    proxy: {
            //type: 'ajax',
            type: 'rest',
            //url: 'http://localhost:8082/cargo',
            api: {
                  create: 'http://localhost:8082/cargo/*',
                  read:   'http://localhost:8082/cargo/all',
                  update: 'http://localhost:8082/cargo',
                  destroy: 'http://localhost:8082/cargo'
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