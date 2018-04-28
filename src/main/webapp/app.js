Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources/extjs');
Ext.require([
             'app.controller.Controller',
             'app.model.Cargo',
             'app.model.Owner',
             'app.model.Company',
             'app.model.StoreHouse',
             'app.store.Cargos',
             'app.store.Owners',
             'app.store.StoreHouses',
             'app.view.Viewport',
             'app.view.welcome_page.WelcomePage',
             'app.view.welcome_page.Login',
             'app.view.CargoGrid',
             'app.view.EditCargo',
             'app.view.SelectStoreHouse',
             'app.view.SearchCargo'
]);

Ext.application({
    name: 'app',
    controllers: ['Controller'],
    autoCreateViewport : true
});