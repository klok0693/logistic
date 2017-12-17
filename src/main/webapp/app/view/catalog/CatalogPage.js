Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources');
Ext.require('app.view.catalog.CatalogView');

Ext.application({
    name: 'catalog',
    views: 'CatalogView',
    launch: function(){
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items:
                 {
                 xtype: 'catalogView'
                 }
        });
    }
});