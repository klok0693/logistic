Ext.define('app.view.catalog.GridView', {
    extend: 'Ext.grid.Panel',
    alias:  'widget.gridView',
    width: 400,
    height: 300,
    frame: true,
    //iconCls: 'icon-user',
    viewConfig:{
        markDirty: false
    },
    columns: [
        {
            text: '№',
            flex: 1,
            sortable: true,
            dataIndex: 'number',
            editor: {
                xtype: 'textfield',
                regex: /^([0-9]{1,20})*$/,
                regexText: '№ должен состоять из цифр',
                allowBlank: false,
                blankText: 'Укажите номер клиента'
            }
        },
        {
            text: 'ФИО',
            flex: 2,
            sortable: true,
            dataIndex: 'name',
            editor: {
                xtype: 'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }
        },
        {
            text: 'Организация',
            flex: 3,
            sortable: true,
            dataIndex: 'organization',
            editor: {
                xtype: 'textfield',
                allowBlank: false,
                blankText: 'Необходимо указать организацию'
            }
        }
    ],
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
        clicksToEdit: 2,
        saveBtnText: 'Сохранить',
        cancelBtnText: 'Отмена'
        })
    ]
    //selType: 'rowmodel',
    /*dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Добавить',
                    action: 'add',
                    iconCls: 'icon-add'
                },
                '-',
                {
                    text: 'Удалить',
                    action: 'delete',
                    iconCls: 'icon-delete',
                    disabled: true
                }
            ]
        }
    ]*/
});