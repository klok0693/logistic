

var staticData = [
        {
         number: 1,
         name: 'Boris',
         organization: 'OOO'
         },
         {
          number: 2,
          name: 'Gena',
          organization: 'FFF'
          }
    ];

 var fields = [
     {name: 'number', type: 'int'},
     {name: 'name'},
     {name: 'organization'}
 ];

Ext.define('app.store.CatalogStore', {
    extend: 'Ext.data.Store',
    fields: fields,
    //alias: 'store.catalogStore',
    data: staticData
    //model: 'app.model.CatalogModel',
    ,autoLoad: true
    //,autoSync: true
    /*proxy: {
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

        }*/
});