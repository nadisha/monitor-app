define(['./module', './service'], function(CallerModule){

	CallerModule.controller('CallerCtrl', ['$scope' , 'CallerService', function($scope, CallerService){

		console.log("Loading Subscriber module .....")

		fetchAllCallers();
		
		$scope.caller = {};
		
		$scope.message = "";
		
		$scope.add = function() {
			CallerService.createCaller($scope.caller).
				then(
					function(payload){
						if (payload.status != 200) {
							console.log('Error in add Caller');
							$scope.message = "Error in add caller";
						} else {
								console.log('success ');
								// AppSharedService.saveMessage($scope, 'done', 'User has been saved.');
							    $scope.caller ={};
							    $scope.message = "New caller has been added";
							    // $scope.userForm.$setPristine(true);
							    //$location.path('/users');
							    fetchAllCallers();
							
						}					
					}
				);
		}

        function fetchAllCallers() {            
        	CallerService.getCallers().
            then(
                function(payload){
                    $scope.callers = payload.data;
                }
            );
        }

    }]);
});