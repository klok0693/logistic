Ext.require('app.view.welcome_page.Login');

Ext.define('app.view.welcome_page.WelcomePage', {
    extend: 'Ext.form.Panel',
    alias: 'widget.welcome',
    width: 500,
    height: 360,
    padding: 10,
    layout: 'border',
    items: [
           {
            xtype: 'panel',
            html: '<div style="font: normal 18px cursive"><center><font size = "10">Logistic</font></center></div>',
            region: 'north',
            height: 115,
            layout: 'border',
            items: [
                 {
                 xtype: 'login',
                 region: 'east',
                 height: 115
                 }]
            },
            {
            xtype: 'panel',
            html: '<div style="font: normal 18px cursive"><center><font size = "3">Welcome Page</font></center></div>',
            region: 'center',
            height: 300
            }
    ]
});