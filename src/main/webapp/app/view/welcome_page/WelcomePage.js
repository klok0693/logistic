Ext.define('app.view.welcome_page.WelcomePage', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.welcomePage',
    width: 500,
    height: 360,
    padding: 10,
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

