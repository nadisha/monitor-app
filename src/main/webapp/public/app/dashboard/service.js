define(['./module'], function(dashboardModule) {

	dashboardModule.factory('DashboardService', ['$http', function($http){
		return {
			// ================= Notifications Rest APIs =====================
			getNotifications: function() {
				return $http.get(contextPath + '/api/notifications');
			}
		}
	}]);
});