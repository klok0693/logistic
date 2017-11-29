Ext.define('Catalog.view.CatalogView', {
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
        }
    ],
    //renderTo: Ext.getBody()
})