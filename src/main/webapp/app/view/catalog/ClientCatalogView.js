Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources/extjs');
Ext.require('app.view.catalog.ClientGridView');

Ext.application({
    name: 'clientGrid',
    views: 'clientGridView',
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
                         xtype: 'clientGridView',
                         region: 'center'
                        }
                ]
            });
    }
});