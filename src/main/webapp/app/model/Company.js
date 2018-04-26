Ext.define('app.model.Company', {//Organization
    extend: 'Ext.data.Model',
    fields: [
        {name:'id', type:'int'},
        {name:'name', type:'string'},
        {name:'owner', type:'string'},
        {name:'type', type:'string'}
    ]
    //belongsTo:'app.model.Owner'
});