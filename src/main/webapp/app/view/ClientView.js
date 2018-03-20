Ext.define('app.view.ClientView', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.clientView',
    width: 500,
    height: 360,
    padding: 10,
    layout: 'border',
    items: [
                        {
                         xtype: 'panel',
                         region: 'north',
                         html: '<div style="font: normal 18px cursive"><center><font size = "10">Grid</font></center></div>',
                         height: 130
                        },
                        {
                         //TODO: text in textfield
                         xtype: 'panel',
                         region: 'west',
                         title: 'Наименивание',
                         width: 150,
                         items: {
                                 xtype: 'textfield',
                                 name: 'Наименование',
                                 //fieldLabel: '',
                                 maxLength: 50
                             }
                        },
                       {
                         xtype: 'clientGrid',
                         region: 'center'
                        }
                ]
});
