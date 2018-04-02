Ext.define('app.view.SearchCargo',{
    extend: 'Ext.form.Panel',
    alias: 'widget.searchCargo',
    //wight: 200,
    height: 57,
    items: [
            {
            xtype: 'textfield',
            name: 'search by name',
            //fieldLabel: 'Введите название модели',
            maxLength: 200
            }
    ],
    buttons: [{
               text: 'Search',
               action: 'search'
    }]
});