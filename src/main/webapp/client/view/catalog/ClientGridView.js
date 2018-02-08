 var fields = [
     {name: 'id',              type: 'int'},
     {name: 'name'},
     {name: 'productionDate',  type: 'date'},
     {name: 'shelfLife',       type: 'date'},
     {name: 'size',            type: 'int'},
     {name: 'format'}
 ];


var store = Ext.create('Ext.data.Store', {
    fields: fields,
    autoLoad: true,
    //,autoSync: true
    proxy: {
            //type: 'ajax',
            type: 'rest',
            api: {
                create:  'http://localhost:8082/cargo',
                read:    'http://localhost:8082/cargo',
                destroy: 'http://localhost:8082/cargo',
                update:  'http://localhost:8082/cargo'
            },
            reader: {
                type: 'json',
                root: '',
                successProperty: 'success'
            }
            ,writer: {
                type: 'json',
                writeAllFields: true
            }

        }
});

Ext.define('app.view.catalog.ClientGridView', {
    extend: 'Ext.grid.Panel',
    alias:  'widget.clientGridView',
    store: store,
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
            text: 'Наименование',
            flex: 1,
            sortable: true,
            dataIndex: 'name',
            editor: {
                xtype: 'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }
        },
        {
            text: 'Дата производства',
            flex: 1,
            sortable: true,
            dataIndex: 'productionDate'
        },
        {
            text: 'Годен до',
            flex: 1,
            sortable: true,
            dataIndex: 'shelfLife'
        },
        {
            text: 'Кол-во',
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
            text: 'Ед. измерени',
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
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
        clicksToEdit: 2,
        saveBtnText: 'Сохранить',
        cancelBtnText: 'Отмена'
        })
    ],
    selType: 'rowmodel',
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Добавить',
                    action: 'add',
                    iconCls: 'icon-add',
                    /*handler: function() {
                            //var me = this;
                            //var carModel = Ext.create('CarCatalog.model.CarCatalogModel');
                            //carModel.set(this.getAddCarFormView().down('form').getValues());
                            (this.up('panel').getValues).save({
                                success: function (operation, response) {
                                    var objAjax = operation.data;
                                    store.add(objAjax);
                                    //me.getAddCarFormView().close();
                                },
                                failure: function (dummy, result) {
                                    Ext.MessageBox.show({
                                        title: 'Ошибка!',
                                        msg: 'Не удалось сохранит запись',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.Msg.ERROR
                                    });
                                }

                            });
                    }*/
                },
                '-',
                {
                    text: 'Удалить',
                    action: 'delete',
                    iconCls: 'icon-delete'
                }
            ]
        }
    ]
});

Ext.define('app.view.catalog.ClientGridView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addClientFormView',
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
                    name: 'name',
                    fieldLabel: 'Название модели',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'textfield',
                    name: 'price',
                    fieldLabel: 'Цена',
                    regex: /^([0-9]{1,20})*$/,
                    regexText: 'Цена должна состоять из цифр',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
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

