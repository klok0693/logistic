Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources');
Ext.require(
    'app.view.catalog.GridView'
    //'app.controller.CatalogController',
    //,'app.store.CatalogStore'
);

Ext.application({
    name: 'catalog',
    views: 'GridView',
    width: 500,
    height: 360,
    padding: 10,
    //layout: 'border',
    //extend: 'Ext.panel.Panel',
    //width: 500,
    //height: 360,
    //padding: 10,
    launch: function(){
            Ext.create('Ext.container.Viewport', {
            layout: 'border',
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
                        }
                ]
            });
    }
});