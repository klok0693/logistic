Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources');
Ext.require(
    'app.view.catalog.CatalogView',
    'app.controller.CatalogController',
    'app.store.CatalogStore');

Ext.application({
    name: 'catalog',
    views: 'CatalogView',
    controllers: ['CatalogController'],
    stores: ['CatalogStore'],
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