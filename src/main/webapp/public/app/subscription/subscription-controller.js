define(['./module', './service'], function(ServiceSubscriptionModule){

	ServiceSubscriptionModule.controller('ServiceSubscriptionCtrl', 
			['$scope' , 'SubscriptionService', 'CallerService', 'ServiceModuleService',
			 	function($scope, SubscriptionService, CallerService, ServiceModuleService){

		console.log("Loading Service Subscription module .....")
		
        fetchAllServiceSubscriptions();
		
		fetchAllCallers();
		
		fetchAllServices();
		
		$scope.subscription = {
			service: '',
			caller: ''	
		};
		
		$scope.message = "";
		
		$scope.add = function(){
			SubscriptionService.createServiceSubscription($scope.subscription).then(
					function(payload) {
						if (payload.status != 200) {
							console.log('Error in add service');
							$scope.message = "Error in add service";
						} else if(payload.data.message != undefined){
							$scope.message = payload.data.message;
							$scope.subscription ={};
						} else{
								console.log('success ');
								// AppSharedService.saveMessage($scope, 'done', 'User has been saved.');
							    $scope.subscription ={};
							    $scope.message = "New subscriber has been registered with a service";
							    // $scope.userForm.$setPristine(true);
							    //$location.path('/users');
							    fetchAllServiceSubscriptions();
							
						}
					}
				);			
		};
		
		$scope.stop = function(serviceName, callerName) {
			SubscriptionService.stopMonitoring(serviceName, callerName).then(
				function(payload) {
					if (payload.status == 200) {
						console.log('Monitoring has stopped.......');
						$scope.message = 'Monitoring has stopped';
					}
				}
			);
		}

		function fetchAllServiceSubscriptions() {
			SubscriptionService.getServiceSubscriptions().
            then(
                function(payload){
                    $scope.subscriptions = payload.data;
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