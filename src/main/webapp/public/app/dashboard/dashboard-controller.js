define(['./module', './service'], function(dashboardModule){

	dashboardModule.controller('DashboardCtrl', ['$scope' , 'DashboardService', function($scope, DashboardService){

		console.log("Loading dashboard.....")
//        $scope.searchByDriverNameTxt ='';
        fetchNotifications();
//
//
//
//        //Pagination
//        $scope.fetchPage = function(pageNumber) {
//            fetchDriverNameByPageNumber(pageNumber , $scope.searchByDriverNameTxt);
//        };
//
        function fetchNotifications() {            
			DashboardService.getNotifications().
            then(
                function(payload){
                    $scope.notifications = payload.data;
                }
            );
        }

    }]);
});