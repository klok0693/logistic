Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources/extjs');
Ext.require([
             'app.view.Viewport',
             'app.view.welcome_page.WelcomePage',
             'app.view.welcome_page.Login',
             'app.controller.Controller',
             'app.model.Cargo',
             'app.model.Owner',
             'app.model.Company',
             'app.model.StoreHouse',
             'app.store.Cargos',
             'app.view.ClientGrid',
             'app.view.EditClient',
             'app.view.SelectStoreHouse',
             'app.view.SearchCargo',
             'app.store.Cr'
]);

Ext.application({
    name: 'app',
    controllers: ['Controller'],
    autoCreateViewport : true
});