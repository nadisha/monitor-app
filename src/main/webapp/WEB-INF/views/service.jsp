
	<h2>Services</h2>
	<span style="color:#FF0000"><strong>{{message}}</strong></span>
	<hr/>
	<form class="uk-form-horizontal uk-form uk-form-stacked">
    	<fieldset data-uk-margin>
      		<div class="uk-form-row">
          		<label class="uk-form-label" for="name">Service Name</label>
          		<div class="uk-form-controls">
              		<input type="text" id="name" ng-model="service.name" name="name" placeholder="">
          		</div>
      		</div>

      		<div class="uk-form-row">
          		<label class="uk-form-label" for="host">Host</label>
          		<div class="uk-form-controls">
              		<input type="text" id="host" ng-model="service.host" name="host" placeholder="">
          		</div>
      		</div>

          	<div class="uk-form-row">
              	<label class="uk-form-label" for="port">Port</label>
              	<div class="uk-form-controls">
                  	<input type="text" id="port" ng-model="service.port" name="port" placeholder="">
              	</div>
          	</div> 

          	<div class="uk-form-row">
              	<label class="uk-form-label">Service Outage - In 24 hours, hhmm (ex: 1310)</label>
          	</div> 

          	<div class="uk-form-row">
              	<div class="uk-form-controls">
                	<label class="uk-form-label" for="outageStartTime">Start Time</label>
                	<input type="text" id="outageStartTime" ng-model="service.outageStartTime" name="outageStartTime" placeholder="">                
              	</div>
              	<div class="uk-form-controls">
                	<label class="uk-form-label" for="outageEndTime">End Time</label>
                	<input type="text" id="outageEndTime" ng-model="service.outageEndTime" name="outageEndTime" placeholder="">              
              	</div>
          	</div>   
          	
			<div class="uk-form-row uk-margin-top">
				<div class="uk-form-controls">
					<button type="button" class="uk-button uk-button-large uk-button-primary" ng-click="add()">Add</button>
			    	<button type="reset" class="uk-button uk-button-large uk-button-primary">Cancel</button>
			    </div>
			</div>          	                 
    	</fieldset>
	</form>	
	
	<hr/>
	
	<div class="uk-panel uk-panel-box">
        <table class="uk-table uk-table-hover uk-table-striped">
        	<thead>
            	<tr>
            		<th>Id</th>
                	<th>Service Name</th>
                    <th>Host</th>
                    <th>Port</th>
                    <th>Start Time (HHMM)</th>
                    <th>End Time (HHMM)</th>
                    <th>Status</th>
                    <th>Subscribed Names</th>
                </tr>
			</thead>
			
            <tbody>
				<tr ng-repeat="s in services">
					<td>{{s.id}}</td>
                    <td>{{s.name}}</td>
                    <td>{{s.host}}</td>
                    <td>{{s.port}}</td>
                    <td>{{s.outageStartTime}}</td>
                    <td>{{s.outageEndTime}}</td>
                    <td>{{s.status}}</td>
                    <td>{{s.subscribeCallerNames}}</td>
               	</tr>
			</tbody>
		</table>
	</div>         