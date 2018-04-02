Ext.define('app.view.EditClient', {
    extend: 'Ext.window.Window',
    alias: 'widget.editClient',
    autoShow: true,
    layout: 'fit',
    modal: true,
    items: [
        {
            bodyPadding: 10,
            xtype: 'form',
            items: [
                {
                    xtype: 'textfield',
                    name: 'type',
                    fieldLabel: 'name',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'datefield',
                    name: 'productionDate',
                    fieldLabel: 'production date',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'datefield',
                    name: 'shelfLife',
                    fieldLabel: 'shelf life',
                    regex: /^([0-9]{1,20})*$/,
                    //regexText: 'Цена должна состоять из цифр',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'numberfield',
                    name: 'size',
                    fieldLabel: 'amount',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'textfield',
                    name: 'format',
                    fieldLabel: 'format',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'combo',
                    fieldLabel: 'cargo type',
                    name: 'name',
                    store: new Ext.data.Store({
                        fields: [{name: 'key'},{name: 'value'}],
                        data: [
                            {'key':'product', 'value':'ProductCargo'},
                            {'key':'box', 'value':'BoxCargo'},
                            {'key':'oil', 'value':'OilCargo'}
                        ]
                    }),
                    displayField: 'key',
                    valueField: 'value'
                },
                {
                    xtype: 'combo',
                    fieldLabel: 'store',
                    name: 'store',
                    store: new Ext.data.Store({
                        fields: [{name: 'key'},{name: 'value'}],
                        data: [
                            {'key':'gomel', 'value':'1'},
                            {'key':'minsk', 'value':'2'}
                        ]
                    }),
                    displayField: 'key',
                    valueField: 'value'
                }
            ]
        }
    ],

    buttons: [
        {
            text: 'Save',
            action: 'save'
            //disabled: true
        },
        {
            text: 'Cancel',
            handler: function () {
                this.up('window').close();
            }
        }
    ]
});

