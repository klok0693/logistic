Ext.define('app.view.Viewport',{
    extend: 'Ext.container.Viewport',
    alias: 'widget.viewport',
    layout: 'card',
    /*width: 500,
    height: 360,
    padding: 10,
    launch: function(){
        Ext.create('Ext.container.Viewport', {*/
        items: [
               {
               xtype: 'welcomePage',
               region: 'center'
               }
        ]
        /*});
    }*/
});