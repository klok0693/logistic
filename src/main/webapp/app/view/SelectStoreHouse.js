Ext.define('app.view.SelectStoreHouse',{
    extend: 'Ext.form.Panel',
    alias: 'widget.selectStoreHouse',
    //wight: 200,
    height: 57,
    items: [
            {
             xtype: 'combo',
             store: new Ext.data.Store({
                 fields: [{name: 'key'},{name: 'value'}],
                 data: [
                       {'key':'all',    'value':'0'},
                       {'key':'store1', 'value':'1'},
                       {'key':'store2', 'value':'2'}
                 ]
             }),
             displayField: 'key',
             valueField: 'value'
            }
    ],
    buttons: [{
               text: 'Go',
               action: 'go'
    }]
});