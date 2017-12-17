Ext.require('app.view.catalog.GridView');

Ext.define('app.view.catalog.CatalogView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.catalogView',
    views: ['GridView'],
    width: 500,
    height: 360,
    padding: 10,
    layout: 'border',
    //extend: 'Ext.panel.Panel',
    //width: 500,
    //height: 360,
    //padding: 10,
    //alias: 'widget.catalogView',
    //layout: 'border',
    items: [
            {
            xtype: 'panel',
            region: 'north',
            html: '<div style="font: normal 18px cursive"><center><font size = "10">Grid</font></center></div>',
            height: 130
            },
            {
            xtype: 'panel',
            region: 'west',
            title: 'search',
            width: 150
            },
           {
            xtype: 'gridView',
            region: 'center'
            //html: '<h2>!!!</h2>'
            }
           ]
});