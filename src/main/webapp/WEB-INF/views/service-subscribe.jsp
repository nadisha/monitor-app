
	<h2>Subscribers</h2>
	<span style="color:#FF0000"><strong>{{message}}</strong></span>	
	<hr/>
	<form class="uk-form-horizontal uk-form uk-form-stacked" name="registerForm">
    	<fieldset data-uk-margin>
      		<div class="uk-form-row">
          		<label class="uk-form-label" for="service">Service</label>
          		<div class="uk-form-controls">
	                <select name="serviceName" ng-model="subscription.service" required="required"    >
	                   <option value="">Select Service</option>
	                   <option ng-value="s" ng-repeat="s in services">
	                  			{{s.name}} - {{s.host}}:{{s.port}} 
	                  	 </option> 
	                </select>
          		</div>
      		</div>
      		
      		<div class="uk-form-row">
          		<label class="uk-form-label" for="caller">Caller</label>
          		<div class="uk-form-controls">
	                <select name="callerName" ng-model="subscription.caller" required="required"    >
	                   <option value="">Select Caller</option>
	                   <option ng-value="c" ng-repeat="c in callers">
	                  			{{c.name}} 
	                  	 </option> 
	                </select>
          		</div>
      		</div>      		

      		<div class="uk-form-row">
          		<label class="uk-form-label" for="pollFrequency">Polling Frequency</label>
          		<div class="uk-form-controls">
              		<input type="text" id="pollFrequency" name="pollFrequency" placeholder="" ng-model="subscription.pollFrequency" > (seconds)
          		</div>
      		</div>

          	<div class="uk-form-row">
              	<label class="uk-form-label" for="gracePeriod">Grace Time</label>
              	<div class="uk-form-controls">
                  	<input type="text" id="gracePeriod" name="gracePeriod" placeholder="" ng-model="subscription.gracePeriod" > (seconds)
              	</div>
          	</div>   
          	
			<div class="uk-form-row uk-margin-top">
				<div class="uk-form-controls">
					<button type="button" class="uk-button uk-button-large uk-button-primary" 
						ng-disabled="registerForm.$error.required || registerForm.$error.pattern" ng-click="add()">Add</button>
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
                	<th>Service Name</th>
                	<th>Caller Name</th>
                    <th>Polling Frequency</th>
                    <th>Grace Time</th>
                    <th>Status</th>
                    <!-- <th></th> -->
				</tr>
			</thead>
            <tbody>
            	<tr ng-repeat="sub in subscriptions">
					<td>{{sub.service.name}}</td>
                    <td>{{sub.caller.name}}</td>
                    <td>{{sub.pollFrequency}}</td>
                    <td>{{sub.gracePeriod}}</td>
                    <td>{{sub.status}}</td>
<!--                     <td>
                    	<div class="uk-button-group" ng-if="sub.status == 'RUNNING'">
                    		<a href="" class="uk-button uk-button-link" ng-click="stop(sub.service.name, sub.caller.name)">STOP</a>                    		
                    	</div>                     			
                   	</td> -->
				</tr>
			</tbody>
		</table>
	</div>
         	