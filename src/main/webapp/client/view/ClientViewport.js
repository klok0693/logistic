Ext.define('client.view.ClientViewport', {
    extend: 'Ext.container.Viewport',
    width: 500,
    height: 360,
    padding: 10,
    launch: function(){
            Ext.create('Ext.container.Viewport', {
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
    }
});