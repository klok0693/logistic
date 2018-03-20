var fields = [
     {name: 'id', type: 'int'},
     {name: 'name'},
     {name: 'organization'}
 ];

Ext.define('app.store.CatalogStore', {
    extend: 'Ext.data.Store',
    fields: fields,
    storeId: 'catalogStore',
    autoLoad: true,
    //,autoSync: true
    proxy: {
            type: 'ajax',
            api: {
                create: 'http://localhost:8082/client',
                read: 'http://localhost:8082/client'
                //destroy: '',
                //update: ''
            },
            reader: {
                type: 'json',
                root: '',
                successProperty: 'success'
            }
            /*writer: {
                type: 'json',
                writeAllFields: true
            }*/

        }
});