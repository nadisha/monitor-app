define([ './module'], function(CommonModule) {
	CommonModule.config(['$routeProvider', function($routeProvider){
		$routeProvider
			.when('/dashboard', {
				templateUrl : contextPath + '/dashboard',
				controller: 'DashboardCtrl'
			})
			.when('/service', {
				templateUrl : contextPath + '/service',
				controller: 'ServiceModuleCtrl'
			})
			.when('/caller', {
				templateUrl : contextPath + '/caller',
				controller: 'CallerCtrl'
			})
			.when('/service-subscription', {
				templateUrl : contextPath + '/service-subscription',
				controller: 'ServiceSubscriptionCtrl'
			})			
			.otherwise({
				templateUrl : contextPath + '/dashboard'
			}); 
	}]);
});