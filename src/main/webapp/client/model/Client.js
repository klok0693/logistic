 var fields = [
     {name: 'id',              type: 'int'},
     {name: 'type'},
     {name: 'productionDate',  type: 'date'},
     {name: 'shelfLife',       type: 'date'},

     /*{name: 'ownerid', type: 'int',mapping:'owner.id'},
     {name: 'ownername',type:'string',mapping:'owner.name'},
     {name: 'orgid', type:'int', mapping:'owner.organization.id'},
     {name: 'orgname',type:'string',mapping:'owner.organization.name'},
     {name: 'orgowner',type:'string',mapping:'owner.organization.owner'},*/

     {name: 'owner', persist:true},

     {name: 'size',            type: 'int'},
     {name: 'format'},
     {name: 'name'}
 ];

Ext.define('client.model.Client', {
    extend: 'Ext.data.Model',
    fields: fields,
    hasMany:[{
        model:'client.model.Owner', name:'owner'
    }]
});


Ext.define('client.model.Owner', {
    extend: 'Ext.data.Model',
    fields: {
        name:'id', type:'int',
        name:'name', type:'string',
        name:'organization', persist:true
        },
        hasMany:[{
            model:'client.model.Organization', name:'organization'
        }]
    ,
    belongsTo:'client.model.Client'
});

Ext.define('client.model.Organization', {
    extend: 'Ext.data.Model',
    fields: {
        name:'id', type:'int',
        name:'name', type:'string',
        name:'owner', type:'string'
    },
    belongsTo:'client.model.Owner'
});