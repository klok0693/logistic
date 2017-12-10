Ext.Loader.setConfig({enabled:true});
Ext.require('app.view.GridView');

Ext.define('app.view.CatalogView', {
    extend: 'Ext.panel.Panel',
    width: 500,
    height: 360,
    padding: 10,
    alias: 'widget.catalogView',
    layout: 'border',
    items: [
        {
            xtype: 'gridView',
            region: 'center'
            //,html: '<h2> &&& </h2>'
        }
    ],
    //renderTo: Ext.getBody()
})