Ext.define('app.view.ClientView', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.clientView',
    width: 500,
    height: 360,
    padding: 10,
    style: {
            'background': 'url(resources/image/truck.jpg) !important',
            'background-size': 'cover !important'
    },
    bodyStyle: 'opacity:0.91;',
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
                         //flex: 0.5,
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
