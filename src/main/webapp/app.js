Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath('Ext', '/main/webapp/resources/extjs');
Ext.require([
             'app.view.Viewport',
             'app.view.welcome_page.WelcomePage',
             'app.view.welcome_page.Login',
             'app.controller.Controller',
             'app.model.Cargo',
             'app.store.Cargos',
             'app.view.ClientGrid',
             'app.view.EditClient',
             'app.view.SelectStoreHouse',
             'app.view.SearchCargo'
]);

Ext.application({
    name: 'app',
    controllers: ['Controller'],
    autoCreateViewport : true
});