Ext.define('app.view.CargoGrid', {
    extend: 'Ext.grid.Panel',
    alias:  'widget.cargoGrid',
    store: 'Cargos',
    width: 400,
    height: 300,
    frame: true,
    //iconCls: 'icon-user',
    viewConfig:{
        markDirty: false
    },
    columns: [
        {
            text: 'id',
            flex: 1,
            sortable: true,
            dataIndex: 'id',
            editor: {
                xtype: 'textfield',
                regex: /^([0-9]{1,20})*$/,
                regexText: '№ должен состоять из цифр',
                allowBlank: false,
                blankText: 'Укажите номер товара'
            }
        },
        {
            text: 'name',
            flex: 1,
            sortable: true,
            dataIndex: 'type',
            editor: {
                xtype: 'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }
        },
        {
            text: 'production date',
            flex: 1,
            sortable: true,
            dataIndex: 'productionDate'
        },
        {
            text: 'shelf life',
            flex: 1,
            sortable: true,
            dataIndex: 'shelfLife'
        },
        {
            text: 'amount',
            flex: 1,
            sortable: true,
            dataIndex: 'size',
            editor: {
                xtype: 'textfield',
                regex: /^([0-9]{1,20})*$/,
                regexText: 'Только цифры!',
                allowBlank: false,
                blankText: 'Укажите кол-во товара'
            }
        },
        {
            text: 'format',
            flex: 1,
            sortable: true,
            dataIndex: 'format',
            editor: {
                xtype: 'textfield',
                allowBlank: false,
                blankText: 'Необходимо указать формат'
            }
        }
    ],
    /*plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
        clicksToEdit: 2,
        saveBtnText: 'Сохранить',
        cancelBtnText: 'Отмена'
        })
    ],*/
    selType: 'rowmodel',
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'add',
                    action: 'add',
                    iconCls: 'icon-add',
                },
                '-',
                {
                    text: 'delete',
                    action: 'delete',
                    iconCls: 'icon-delete'
                }
            ]
        }
    ]
});



