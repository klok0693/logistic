 var fields = [
     {name: 'id',              type: 'int'},
     {name: 'type'},
     {name: 'productionDate',  type: 'date'},
     {name: 'shelfLife',       type: 'date'},
     {name: 'size',            type: 'int'},
     {name: 'format'},
     {name: 'name'}
 ];

Ext.define('app.model.Client', {
    extend: 'Ext.data.Model',
    fields: fields,
    hasMany:[{
        model:'app.model.Owner', name:'owner'
    }]
});


Ext.define('app.model.Owner', {
    extend: 'Ext.data.Model',
    fields: {
        name:'id', type:'int',
        name:'name', type:'string',
        name:'organization', persist:true
        },
        hasMany:[{
            model:'app.model.Organization', name:'organization'
        }]
    ,
    belongsTo:'app.model.Client'
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