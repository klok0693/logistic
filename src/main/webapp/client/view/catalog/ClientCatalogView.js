Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources/extjs');
//Ext.require('app.view.catalog.ClientGridView');

Ext.application({
    name: 'clientGrid',
    views: ['clientGridView', 'addClientFormView'],
    controllers: controller,
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

var controller = Ext.create('Ext.app.Controller', {

    refs: [
        {selector: 'clientGridView',
            ref: 'clientGridView'},
        {selector: 'clientGridView button[action="add"]',
            ref: 'clientGridAdd'},
        {selector: 'clientGridView button[action="delete"]',
            ref: 'clientGridDelete'},
        /*{selector: 'searchCarView button[action="search"]',
            ref: 'searchCar'},*/
        {selector: 'addClientFormView',
            ref: 'addClientFormView'},
        {selector: 'clientCatalogView',
            ref: 'clientCatalogView'},
        /*{selector: 'addClientFormView textfield[name=name] ',
            ref: 'addCarFormName'},
        {selector: 'addCarFormView textfield[name=price]',
            ref: 'addCarFormPrice'},*/
        {selector: 'addClientFormView button[action=save]',
            ref: 'addClientFormSave'}
    ],

    init: function () {
        this.control({
            'clientGridView  button[action=add]': {
                click: this.onAddClient
            },
            'clientGridView  button[action=delete]': {
                click: this.onDelClient
            },
            /*'searchCarView  textfield[name="search"]': {
                change: this.onChangeText
            },*/
            'clientGridView': {
                cellclick: this.onLineGrid
            },
            'addClientFormView  button[action=save]': {
                click: this.onSaveClient
            }
            /*'addCarFormView  textfield[name=name]': {
                change: this.onValidation
            },
            'addCarFormView  textfield[name=price]': {
                change: this.onValidation
            }*/
        });
    },

    onSaveClient: function (button) {
        /*var me = this;
        var model = Ext.create('app.view.catalog.ClientGridView');
        model.set(this.getAddClientFormView().down('form').getValues());
        model.save({
            success: function (operation, response) {
                var objAjax = operation.data;
                //Ext.getStore('CarCatalogStore').add(objAjax);
                store.add(objAjax);
                me.getAddCarFormView().close();
            },
            failure: function (dummy, result) {
                Ext.MessageBox.show({
                    title: 'Ошибка!',
                    msg: 'Не удалось сохранить объект',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }

        });*/
            var win = button.up('window'),
            form = win.down('form'),
            values = form.getValues();
            store = this.getClientsStore();
            if(form.getForm().isValid()) {
                store.add(values);
                win.close();
            }
    },

    onAddClient: function () {
        Ext.widget('addClientFormView');
    },

    onDelClient: function () {
        var sm = this.getClientGridView().getSelectionModel();
        var rs = sm.getSelection();
        this.getClientGridView().store.remove(rs[0]);
        this.getClientGridView().store.commitChanges();
        this.getClientGridDelete().disable();
    },

    /*onChangeText: function () {
        Ext.getStore('CarCatalogStore').load({
            params: {
                search: this.getCarCatalogView().down('searchCarView').getValues()
            }
        });
    },*/

    onLineGrid: function () {
        this.getClientGridDelete().enable();
    }

    /*onValidation: function () {
        if (this.getAddCarFormName().validate() && this.getAddCarFormPrice().validate()) {
            this.getAddCarFormSave().enable();
        } else {
            this.getAddCarFormSave().disable();
        }
    }*/

});



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