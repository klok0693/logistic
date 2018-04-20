 var fields = [
     {name: 'id',              type: 'int'},
     {name: 'type'},
     {name: 'productionDate',  type: 'date'},
     {name: 'shelfLife',       type: 'date'},
     {name: 'size',            type: 'int'},
     {name: 'format'},
     {name: 'name'},
     {name: 'owner', model: 'app.model.Owner'}
 ];

Ext.define('app.model.Cargo', {
    extend: 'Ext.data.Model',
    fields: fields,
    belongsTo: 'app.model.Owner'
});


Ext.define('app.model.Owner', {
    extend: 'Ext.data.Model',
    fields: [
        {name:'id', type:'int'},
        {name:'name', type:'string'},
        {name:'organization', model: 'app.model.Organization'} //persist:true
        ],
    belongsTo:'app.model.Organization'
});

Ext.define('app.model.StoreHouse', {
    extend: 'Ext.data.Model',
    fields: {
        name: 'id', type: 'int',
        name: 'address',
        name: 'name'
    },
    belongsTo:'app.model.Cargo'
});

Ext.define('app.model.Organization', {
    extend: 'Ext.data.Model',
    fields: {
        name:'id', type:'int',
        name:'name', type:'string',
        name:'owner', type:'string'
    },
    belongsTo:'app.model.Owner'
});