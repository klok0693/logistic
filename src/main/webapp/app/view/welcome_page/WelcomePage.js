Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources/extjs');
Ext.require('app.view.welcome_page.Login');

Ext.application({
    name: 'app',
    width: 500,
    height: 360,
    padding: 10,
    launch: function(){
                Ext.create('Ext.container.Viewport', {
    layout: 'border',
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
                }
        ]
    });
    }
});

