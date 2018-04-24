Ext.define('app.model.Owner', {
    extend: 'Ext.data.Model',
    fields: [
        {name:'id', type:'int'},
        {name:'name', type:'string'},
        {name:'type'},
        {name:'organization', model: 'app.model.Organization'} //persist:true
        ],
    belongsTo:'app.model.Organization'
});

Ext.define('app.model.Organization', {
    extend: 'Ext.data.Model',
    fields: [
        {name:'id', type:'int'},
        {name:'name', type:'string'},
        {name:'owner', type:'string'},
        {name:'type', type:'string'}
    ],
    belongsTo:'app.model.Owner'
});