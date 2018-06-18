define(['./module'], function(serviceModule) {

	serviceModule.factory('ServiceModuleService', ['$http', function($http){
		return {
			// ================= Services Rest APIs =====================
			getServices: function() {
				return $http.get(contextPath + '/api/services');
			},
			createService: function(srv) {
				return $http.post(contextPath + '/api/services', srv)
			}

		}
	}]);
});