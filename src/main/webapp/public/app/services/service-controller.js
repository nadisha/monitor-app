define(['./module', './service'], function(serviceModule){

	serviceModule.controller('ServiceModuleCtrl', ['$scope' , 'ServiceModuleService', function($scope, ServiceModuleService){

		console.log("Loading Service module .....")
		
        fetchAllServices();
		
		$scope.service = {};
		
		$scope.message = "";
		
		$scope.add = function(){
			ServiceModuleService.createService($scope.service).then(
					function(payload) {
						if (payload.status != 200) {
							console.log('Error in add service');
							$scope.message = "Error in add service";
						} else {
								console.log('success ');
								// AppSharedService.saveMessage($scope, 'done', 'User has been saved.');
							    $scope.service ={};
							    $scope.message = "New service has been added";
							    // $scope.userForm.$setPristine(true);
							    //$location.path('/users');
							    fetchAllServices();
							
						}
					}
				);			
		}

		function fetchAllServices() {
            ServiceModuleService.getServices().
            then(
                function(payload){
                    $scope.services = payload.data;
                }
            );
        }

    }]);
});