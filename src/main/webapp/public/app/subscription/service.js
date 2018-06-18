define(['./module'], function(ServiceSubscriptionModule) {

	ServiceSubscriptionModule.factory('SubscriptionService', ['$http', function($http){
		return {
			// ================= Services Subscription Rest APIs =====================
			getServiceSubscriptions: function() {
				return $http.get(contextPath + '/api/service-registries');
			},
			createServiceSubscription: function(serviceSubscription) {
				return $http.post(contextPath + '/api/service-registries', serviceSubscription);
			},
			stopMonitoring: function(serviceName, callerName) {
				return $http.get(contextPath + '/api/service-registries/' + serviceName + '/' + callerName + '/stop');
			}
		}
	}]);
});