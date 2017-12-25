var staticData = [
        {
         number: 1,
         name: 'Boris',
         organization: 'OOO'
         },
         {
          number: 2,
          name: 'Gena',
          organization: 'FFF'
          }
    ];

 var fields = [
     {name: 'number', type: 'int'},
     {name: 'name'},
     {name: 'organization'}
 ];

var store = Ext.create('Ext.data.Store', {
    //extend: 'Ext.data.Store',
    fields: fields
    //alias: 'store.catalogStore',
    //data: staticData
    //model: 'app.model.CatalogModel',
    ,autoLoad: true
    //,autoSync: true
    ,proxy: {
            type: 'ajax',
            api: {
                create: 'http://localhost:8082/client',
                read: 'http://localhost:8082/client'
                //create: 'app/clients.json',
                //read: 'app/clients.json'
                //destroy: 'client',
                //update: 'client'
            },
            reader: {
                type: 'json',
                root: '',
                successProperty: 'success'
            }
            /* ,writer: {
                type: 'json',
                writeAllFields: true
            }*/

        }
});

Ext.define('app.view.catalog.GridView', {
    extend: 'Ext.grid.Panel',
    alias:  'widget.gridView',
    //store: Ext.getStore('app.store.CatalogStore'),
    //store: Ext.StoreMgr.lookup('mStore'),
    store: store,
    //store: 'CatalogStore',
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
            //name: 'id',
            flex: 1,
            //sortable: true,
            dataIndex: 'id'
            /*,editor: {
                xtype: 'textfield',
                regex: /^([0-9]{1,20})*$/,
                regexText: '№ должен состоять из цифр',
                allowBlank: false,
                blankText: 'Укажите номер клиента'
            }*/
        },
        {
            text: 'ФИО',
            flex: 1,
            //sortable: true,
            dataIndex: 'name'
            /*,editor: {
                xtype: 'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }*/
        } ,
        {
            text: 'Организация',
            //name: 'organization',
            flex: 1,
            //sortable: true,
            dataIndex: 'organization'
            /*,editor: {
                xtype: 'textfield',
                allowBlank: false,
                blankText: 'Необходимо указать организацию'
            }*/
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