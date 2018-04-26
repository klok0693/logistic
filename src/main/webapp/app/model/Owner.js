Ext.define('app.model.Owner', {
    extend: 'Ext.data.Model',
    fields: [
        {name:'id', type:'int'},
        {name:'name', type:'string'},
        {name:'type'},
        {name:'organization', model: 'app.model.Organization'} //persist:true
        ],
    belongsTo:'app.model.Company'
});