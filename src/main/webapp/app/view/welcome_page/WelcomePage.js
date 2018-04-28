Ext.define('app.view.welcome_page.WelcomePage', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.welcomePage',
    width: 500,
    height: 360,
    padding: 10,
    layout: 'border',
    defaults: {
        //collapsible: true
        //split: true
    },
            items: [
               {
                xtype: 'panel',
                html: '<div style="font: normal 18px cursive"><center><font size = "10">Logistic</font></center></div>',
                region: 'north',
                //flex: 1,
                height: 150,
                layout: 'border',
                //bodyStyle: 'opacity:0.75;',
                //bodyStyle: 'background:none; background-color:none;',
                items: [
                     {
                     xtype: 'login',
                     region: 'east',
                     //bodyStyle: 'opacity:1.0; background:white !important;',
                     height: 150
                     }
                ],
                },
                {
                xtype: 'panel',
                html: '<div style="font: normal 18px cursive"><center><font size = "3">Welcome Page</font></center></div>',
                region: 'center',
                style: {
                        'background': 'url(resources/image/truck.jpg) !important',
                        'background-size': 'cover !important'
                },
                bodyStyle: 'opacity:0.35;',
                //frame:false,
                //border: false,
                /*bodyStyle: {
                    background:'transparent'
                },*/
                //bodyStyle: 'background:transparent !important;',
                //flex: 1,
                height: 300
                }
        ]
});

