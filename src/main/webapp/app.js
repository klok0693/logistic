Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources/extjs');
Ext.require([
             'app.view.Viewport',
             'app.view.welcome_page.WelcomePage',
             'app.view.welcome_page.Login',
             'app.controller.Controller',
             'app.model.Client',
             'app.store.Clients',
             'app.view.ClientGrid',
             'app.view.EditClient'
]);

Ext.application({
    name: 'app',
    controllers: ['Controller'],
    autoCreateViewport : true
    /*launch: function(){
                Ext.create('Ext.container.Viewport', {
                alias: 'widget.viewport',
                layout: 'card',
                items: [
                     {
                        xtype: 'panel',
                        html: '<div style="font: normal 18px cursive"><center><font size = "10">Logistic</font></center></div>',
                        region: 'north',
                         //flex: 1,
                        height: 150,
                        layout: 'border',
                        items: [
                            {
                             xtype: 'login',
                             region: 'east',
                            height: 150
                              }]
                     },
                    {
                        xtype: 'panel',
                        html: '<div style="font: normal 18px cursive"><center><font size = "3">Welcome Page</font></center></div>',
                        region: 'center',
                        //flex: 1,
                        height: 300
                    },
                       {
                         xtype: 'WelcomePage',
                         region: 'center'
                        }
        ]
    });
    }*/
});