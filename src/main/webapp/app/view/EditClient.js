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
                    fieldLabel: 'Наименование',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'datefield',
                    name: 'productionDate',
                    fieldLabel: 'Дата производства',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'datefield',
                    name: 'shelfLife',
                    fieldLabel: 'Срок годности',
                    regex: /^([0-9]{1,20})*$/,
                    //regexText: 'Цена должна состоять из цифр',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'numberfield',
                    name: 'size',
                    fieldLabel: 'Кол-во',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'textfield',
                    name: 'format',
                    fieldLabel: 'Ед. изм.',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'combo',
                    fieldLabel: 'type',
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
                }
            ]
        }
    ],

    buttons: [
        {
            text: 'Сохранить',
            action: 'save'
            //disabled: true
        },
        {
            text: 'Отменить',
            handler: function () {
                this.up('window').close();
            }
        }
    ]
});

