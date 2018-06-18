define(['angular', 'angular-message', 'angular-route' ,'$' , 'uikit', './common/index', './dashboard/index', './services/index',
        './caller/index', './subscription/index'
        ], function(angular) {

    'use strict';
    
    var app = angular.module('MonitorApp', [
                                         'ngMessages', 
                                         'ngRoute',
                                         'MonitorApp.Dashboard',
                                         'MonitorApp.Service',
                                         'MonitorApp.Caller',
                                         'MonitorApp.ServiceSubscription',
                                         'common'
                                         ]);
            
    app.init = function () {
        angular.bootstrap(document, ['MonitorApp']);
    }
    
    return app;
});