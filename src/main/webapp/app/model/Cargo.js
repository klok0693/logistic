 var fields = [
     {name: 'id',              type: 'int'},
     {name: 'type'},
     {name: 'productionDate',  type: 'date'},
     {name: 'shelfLife',       type: 'date'},
     {name: 'size',            type: 'int'},
     {name: 'format'},
     {name: 'name'},
     {name: 'owner', model: 'app.model.Owner'},
     {name: 'store', model: 'app.model.StoreHouse'}
 ];

Ext.define('app.model.Cargo', {
    extend: 'Ext.data.Model',
    fields: fields,
    belongsTo: ['app.model.Owner', 'app.model.StoreHouse']
});
