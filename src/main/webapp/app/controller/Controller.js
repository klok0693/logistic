Ext.define('app.controller.Controller', {
    extend: 'Ext.app.Controller',

    stores: ['Cargos', 'Owners', 'StoreHouses'],

    models: ['Cargo','Owner','Company','StoreHouse'],

    views: [
            'ClientView',
            'EditCargo',
            'CargoGrid',
            'welcome_page.Login',
            'Viewport',
            'welcome_page.WelcomePage',
            'SelectStoreHouse',
            'SearchCargo'
    ],

    refs: [
        {ref:'welcomePage',       selector: 'welcomePage'},
        {ref: 'viewport',         selector: 'viewport'},
        {ref: 'clientView',       selector: 'clientView'},
        {ref: 'clientsPanel',     selector: 'panel'},
        {ref: 'cargoGrid',        selector: 'cargoGrid'},
        {ref: 'login',            selector: 'login'},
        {ref: 'editCargo',        selector: 'editCargo'},
        {ref: 'selectStoreHouse', selector: 'selectStoreHouse'},
        {ref: 'searchCargo',      selector: 'searchCargo'}
    ],

    init: function() {
        this.control({
            'cargoGrid': {
                itemdblclick: this.updateCargo
            },
            'editCargo button[action=save]': {
                click: this.editCargo
            },
            'cargoGrid button[action=add]': {
                click: this.addCargo
            },
            'cargoGrid button[action=delete]': {
                click: this.deleteCargo
            },
            'login button[action=login]': {
                click: this.loginUser
            },
            'selectStoreHouse button[action=go]': {
                click: this.changeStore
            },
            'searchCargo button[action=search]': {
                click: this.findCargo
            }
        });
    },

    updateCargo: function(grid, record) {
        var edit = Ext.create('app.view.EditCargo').show();
        edit.down('form').loadRecord(record);
    },

    editCargo: function(button) {
        var win    = button.up('window'),
            form   = win.down('form').getForm(),
            values = form.getValues();

        var cargo,
            owner = Ext.getStore('Owners').load().getAt(0),
            store = Ext.getStore('StoreHouses').load({params:{id:1}}).getAt(0);

        console.log('owner', owner);
        console.log('store', store);
        console.log('form',  form.getValues());


        var record = form.getRecord();
         if(record !== undefined) {
             cargo = Ext.getStore('Cargos').findRecord('id', form.findField('id').getValue());
         }
         else {
             cargo = Ext.create(Ext.getStore('Cargos').model);
         }

         cargo.set('format',           form.findField('format').getValue());
         //cargo.set('id', form.getForm().findField('id').getValue());
         cargo.set('name',             form.findField('name').getValue());
         cargo.set('owner',            owner.getData());
         cargo.set('productionDate',   form.findField('productionDate').getValue());
         cargo.set('shelfLife',        form.findField('shelfLife').getValue());
         cargo.set('size',             form.findField('size').getValue());
         cargo.set('type',             form.findField('type').getValue());
         cargo.set('store',            store.getData());

         console.log('obj after', cargo);

         if(record === undefined) {
             this.getCargoGrid().store.add(cargo);
         }
         this.getCargoGrid().store.sync();

         win.close();
    },


    addCargo: function() {
        Ext.widget('editCargo');
    },


    deleteCargo: function() {
        var grid       = this.getCargoGrid(),
            store      = grid.store,
            selection  = grid.getSelectionModel().getSelection();

        console.log('selection', selection[[0]]);

        var cargo = Ext.getStore('Cargos').findRecord('id', selection[0].getData().id);

        cargo.set('owner', Ext.getStore('Owners').load().getAt(0).getData());
        cargo.set('store', Ext.getStore('StoreHouses').load().getAt(0).getData());

        store.remove(selection[0]);
        //store.commitChanges();
        store.sync();
    },


    loginUser: function(button) {
        //var form = button.up('form').getForm();
        button.up('form').getForm().submit({
                        url: 'http://localhost:8082/j_spring_security_check',
                        success: function(form, action){
                                   var view      = Ext.create('app.view.ClientView'),
                                       viewport  = button.up('viewport');

                                   viewport.getLayout().setActiveItem(view)
                        },
                        failure: function(form, action){
                                    Ext.MessageBox.alert('Authoriation failed');//,action.result.message
                                }
                    });
    },


    changeStore: function(button) {
        var store = this.getCargoGrid().store,
            store_id = button.up('form').down('combo').getValue();

        //
        store.load({params:{store:store_id}});
    },


    findCargo: function(button) {
        var store = this.getCargoGrid().store,
            name  = button.up('form').down('textfield').getValue(),
            cargo = store.findRecord('type', name);

        if (cargo !== null) {

            var edit = Ext.create('app.view.EditCargo').show();
            edit.down('form').loadRecord(cargo);
        }
        else Ext.MessageBox.alert('Cant find Cargo');
    }
});