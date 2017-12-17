Ext.define('app.model.CatalogModel', {
    extend: 'Ext.data.Model',
    fields: ['number', 'name', 'organization'],
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