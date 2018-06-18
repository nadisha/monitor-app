<!-- Right Panel -->
        			
          				<h2>Dashboard</h2>
	                  	<div class="uk-overflow-container">
	                    	<div class="uk-panel uk-panel-box">
	                      		<table class="uk-table uk-table-hover uk-table-striped">
	                        		<thead>
	                            		<tr>
	                                		<th>Subscriber</th>
	                                		<th>Service</th>
	                                		<th>Message</th>
	                                		<th>Notification Type</th>
	                                		<th>Notify Time</th>
	                            		</tr>
	                        		</thead>
	                        		<tbody>
	                            		<tr ng-repeat="n in notifications">
			                                <td>{{n.callerName}}</td>
			                                <td>{{n.serviceName}}</td>
			                                <td>{{n.message}}</td>
			                                <td>{{n.notifyType}}</td>
			                                <td>{{n.notifyDate}}</td>
	                            		</tr>
									</tbody>
	                      		</table>
	                    	</div>
	                  	</div>          				