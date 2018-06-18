
	<h2>Subscribers</h2>
	<span style="color:#FF0000"><strong>{{message}}</strong></span>
	<hr/>
	<form class="uk-form-horizontal uk-form uk-form-stacked">
    	<fieldset data-uk-margin>
      		<div class="uk-form-row">
          		<label class="uk-form-label" for="name">Name</label>
          		<div class="uk-form-controls">
              		<input type="text" id="name" ng-model="caller.name" name="name" placeholder="">
          		</div>
      		</div>

      		<div class="uk-form-row">
          		<label class="uk-form-label" for="host">Email</label>
          		<div class="uk-form-controls">
              		<input type="email" id="email" ng-model="caller.email" name="email" placeholder="">
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
                	<th>Name</th>
                    <th>Email</th>
                    <th>Subscribe Services</th>
                </tr>
			</thead>
			
            <tbody>
				<tr ng-repeat="c in callers">
					<td>{{c.id}}</td>
                    <td>{{c.name}}</td>
                    <td>{{c.email}}</td>
                    <td>{{c.serviceSubscriptionNames}}</td>
               	</tr>
			</tbody>
		</table>
	</div>         