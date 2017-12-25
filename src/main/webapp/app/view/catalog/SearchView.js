Et.define('app.view.catalog.SearchView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.searchView',
    //bodyPadding: 10,
    wight: 300,
    height: 115,
    /*layout: 'anchor',
    defaults: {
       anchor: '80%'
    },*/
    items: {
        xtype: 'textfield',
        name: 'search',
        fieldLabel: 'Название организации',
        //maxLength: 200
    }
    ,renderTo: Ext.getBody()
});