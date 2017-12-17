Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources');
Ext.require('app.view.welcome_page.WelcomePage');

Ext.application({
      name: 'Catalog',
      views: 'WelcomePage',
      launch: function(){
            Ext.create('Ext.container.Viewport', {
              layout: 'fit',
              items:
                      {
                      xtype: 'welcome'
                      //html: '<h2>!!!</h2>'
                     }
                });
      }
});
