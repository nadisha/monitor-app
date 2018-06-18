require.config({
	paths: {
		'angular' : 'assets/js/angular.min',
		'angular-message' : 'assets/js/angular-messages',
		'angular-route' : 'assets/js/angular-route',
		'_': 'assets/js/underscore-min',
		'$': 'assets/js/jquery.min',
		'uikit': 'assets/js/uikit.min'
	},
	shim: {
		'angular-message': {
			deps: ['angular']
		},
		'angular-route': {
			deps: ['angular']
		},
		'angular' : {
			exports : 'angular'
		},
		'uikit': {
            deps : ['$']
        }
	}
});

require(['app'], function(app){
	app.init();
});