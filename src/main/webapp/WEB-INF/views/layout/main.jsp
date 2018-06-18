<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<spring:url value="/resources" var="resourceUrl"/>

<!Doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Service Monitor</title>

    <!-- UIKit styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.26.3/css/uikit.almost-flat.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.26.3/css/components/accordion.almost-flat.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.26.3/css/components/sticky.almost-flat.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.26.3/css/components/slideshow.almost-flat.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.26.3/css/components/slidenav.almost-flat.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.26.3/css/components/dotnav.almost-flat.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.26.3/css/components/slider.almost-flat.min.css">

    <!-- Custom styles -->
    <link rel="stylesheet" href="${resourceUrl}/css/main.css">
  </head>
  <body>
    <header>
      <nav id="main-mav" class="uk-navbar uk-navbar-attached" data-uk-sticky>
        <a class="uk-navbar-toggle uk-visible-small" data-uk-offcanvas="{target:'#mobile-topnav'}"></a>

        <a href="/" class="uk-navbar-brand uk-clearfix">
          <img class="uk-align-medium-left" src="https://yukon.cv.ua/sites/default/files/logo.png" alt="">
        </a>

        <div class="uk-navbar-content uk-text-large uk-hidden-small">
          <span class="uk-hidden-small uk-text-bold">Monitor Service</span>
        </div>
        
      </nav>
    </header>
	
    <section class="uk-container uk-container-center uk-margin-bottom uk-margin-top">
    	<main>
    		<div class="uk-margin-top uk-margin-large-bottom">
    			<div class="uk-grid">
          			<div class="uk-width-medium-1-4">
            			<ul class="uk-tab uk-tab-left">
                			<!-- <li class="uk-active"> -->
                			<li>
                				<a href="#!/dashboard">Dashboard</a>
                			</li>
                			<li>
                				<a href="#!/service">Services</a>
                			</li>
                			<li>
                				<a href="#!/caller">Callers</a>
                			</li>
                			<li>
                				<a href="#!/service-subscription">Service Subscription</a>
                			</li>                                			                			
            			</ul>
          			</div>  
          			
					<div class="uk-width-medium-3-4">   
						<div ng-view class="width-100"></div>
					</div>
					          			  				
    			</div>
    		</div>
    	</main>
    </section>

    <footer>
      <div class="uk-container uk-container-center">
        <ul class="uk-subnav uk-subnav-line uk-margin-bottom-remove uk-align-medium-right">
          <li><a href="">FAQ</a></li>
          <li><a href="">Contact</a></li>
          <li><a href="">Terms</a></li>
          <li><a href="">Privacy</a></li>
        </ul>
        <p class="uk-margin-remove">2018 &copy; Company Name</p>
      </div>
    </footer>

    <!-- Modals -->
    <div id="shopping-cart-modal" class="uk-modal">
        <div class="uk-modal-dialog">
            <a class="uk-modal-close uk-close"></a>
            <div class="uk-modal-header"><h2>Shopping Cart</h2></div>

            <div class="uk-overflow-container">
              <table class="uk-table uk-table-striped uk-table-hover">
                  <thead>
                      <tr>
                          <th>Product</th>
                          <th>Price</th>
                          <th>Quantity</th>
                          <th>Subtotal</th>
                      </tr>
                  </thead>
                  <tfoot>
                      <tr>
                          <td></td>
                          <td></td>
                          <td class="uk-text-large uk-text-bold">3</td>
                          <td class="uk-text-large uk-text-bold">Rs 500.00</td>
                      </tr>
                  </tfoot>
                  <tbody>
                      <tr>
                          <td>Some product</td>
                          <td>Rs 100.00</td>
                          <td>2</td>
                          <td>Rs 200.00</td>
                      </tr>
                      <tr>
                          <td>Another product</td>
                          <td>Rs 300.00</td>
                          <td>1</td>
                          <td>Rs 300.00</td>
                      </tr>
                  </tbody>
              </table>
            </div>

            <div class="uk-modal-footer uk-text-right">
                <button type="button" class="uk-button uk-modal-close uk-button-large">Continue</button>
                <a href="/cart.html" class="uk-button uk-button-primary uk-button-large">Checkout</a>
            </div>
        </div>
    </div>

    <div id="user-account-modal" class="uk-modal">
        <div class="uk-modal-dialog">
            <a class="uk-modal-close uk-close"></a>
            <div class="uk-modal-header"><h2>My Account</h2></div>

            <form class="uk-form uk-form-stacked">
                <div class="uk-form-row">
                    <label class="uk-form-label" for="">Email</label>
                    <div class="uk-form-controls">
                      <input type="email" name="email" class="uk-form-large uk-width-1-1" required>
                    </div>
                </div>

                <div class="uk-form-row">
                    <label class="uk-form-label" for="">Password</label>
                    <div class="uk-form-controls">
                      <input type="password" name="password" class="uk-form-large uk-width-1-1" required>
                    </div>
                </div>

                <p><a href="">Forgot password?</a></p>
            </form>

            <div class="uk-modal-footer uk-text-right">
                <a href="/auth.html" class="uk-float-left">Create new account &rarr;</a>
                <button type="button" class="uk-button uk-button-primary uk-button-large">Log in</button>
            </div>
        </div>
    </div>

	<script type="text/javascript">
			    var contextPath='${contextPath}';
	</script>
	
	<script src="${resourceUrl}/app/assets/js/require.js" data-main='${resourceUrl}/app/main'></script>
	    
    <!-- <script src="scripts/main.js"></script> -->
    <!-- endbuild -->

  </body>
</html>
