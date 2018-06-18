define(['./module'], function(CallerModule) {

	CallerModule.factory('CallerService', ['$http', function($http){
		return {
			// ================= Subscriber Rest APIs =====================
			getCallers: function() {
				return $http.get(contextPath + '/api/callers');
			},
			createCaller: function(caller) {
				return $http.post(contextPath + '/api/callers', caller);
			}

		}
	}]);
});