Ext.Loader.setConfig({enabled:true});

Ext.application({
      name: 'Catalog',
      views: ['CatalogView','GridView'],
      launch: function(){
          Ext.create('Ext.container.Viewport', {
              layout: 'fit',
              renderTo: Ext.getBody(),
              items: {
                  region: 'center',
                  xtype: 'catalogView'
                  //,html: '<h2>!!!</h2>'
                 }
          });
    }
});
