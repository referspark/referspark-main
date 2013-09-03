angular.module('bizSpark', ['ui.bootstrap']);



function MainController($scope, $http) {

  $scope.projectName = "Refer Spark";
  $scope.menu_more = "More<span class='caret'></span>";
  $scope.labelEmail = "Email Address";
  $scope.labelpassword = "Password";
  $scope.labelReEnterPassword = "Re-Enter Password";
  $scope.labelPhone = "Phone Number (optional)";
   
 
  var slides = $scope.slides = [];
  $scope.myInterval = 5000;
  slides.push({image:"assets/images/mkting.jpeg", title:"Get New customers", content: "Existing loyal customers will recommend your business to their friends and colleagues and drive new business", active: true}); 
  slides.push({image:"assets/images/mkting.jpeg", title:"Reward your Loyal Customers ", content: "Dont lose your customers to a competitor by rewarding your customers with discounts and offers !", active: false}); 
  slides.push({image:"assets/images/mkting.jpeg", title:"Track your deals and Improve", content: "Our recommendation engine will track all your deals and get insightful reports on how your business is growing", active: false}); 

  var menuOptions = $scope.menuOptions = [];
  menuOptions.push({state:"disabled", name:"Sign In", url : "#signin"});
  menuOptions.push({state:"disabled", name:"Help", url : "#help"});
  menuOptions.push({state:"disabled", name:"Pricing", url : "#pricing"});
  menuOptions.push({state:"divider", name:""}); 
  menuOptions.push({state:"disabled", name:"How To Videos", url : "#video"});
  menuOptions.push({state:"disabled", name:"Live Community", url : "#community"});

  var menus = $scope.menus = [];
  menus.push({name:"Blog", url : "#blogs"});
  menus.push({name:"Contact Us", url : "mailto:referspark@gmail.com?subject=Help Needed"});
  //menus.push({name:"Sign In", url : "#contact"});
  

  var features = $scope.features = [];
  features.push({image: "assets/images/browser-icon-chrome.png", title:"Get New customers", subtitle: "Existing customers will recommend your business to their friends", description: "Easy way to issue referral based discounts and coupons which will grow your customer base multi-fold."});
  features.push({image: "assets/images/browser-icon-firefox.png",  title:"Reward Loyal customers", subtitle: "Your loyal customers are bound to get some special treats",  description: "We help you in efficiently  engaging with your regular customers and providing jaw dropping deals which gets them back to your store"});
  features.push({image: "assets/images/browser-icon-safari.png", title:"Great Insighst", subtitle: "Efficiently track deals and growing customer base",  description: "Our smart algorigthms will provide you insightful data and ensure you are a step ahead of your neighbour "});

    $scope.signupEmailFocus = false;
    $scope.initiateSignUp = function() {
      $scope.signupEmailFocus = true;

    };
    
    $scope.user = {};
    $scope.registeruser = function() {
    	//alert($scope.user.email);
    	//alert($scope.user.number);
    	
    	$http({
    		method : 'GET',
    		url : '../api/addPotentialCustomer.json' + '?' + 'email=' + $scope.user.email + '&mobile=' + $scope.user.number + '&businessname=' + $scope.user.businessName 
    	}).success(function(data, status, headers){
    		alert('User Added succesfully... Beautify me');
    	}).error(function(data, status, header){
    		alert('Error in creating user');
    	});
    	
    };
};  



function CoreController($scope) {

  var cmenus = $scope.cmenus = [];
  cmenus.push({name:"Biz Spark", class:"brand span9" , link : "#"});
  cmenus.push({name:"My Account" ,class:"", link:"#"});
  cmenus.push({name:"Signout", class:"span1", link:"#"});
  
  var leftNavs = $scope.leftNavs =  [];
  leftNavs.push({title:"<i class='icon-envelope'></i>&nbsp;Send a coupon", link:"#sendCoupon", class:"active"});
  //leftNavs.push({title:"Insights", link:"#insights", class:"inactive"});
  leftNavs.push({title:"<i class='icon-share'></i>&nbsp;Redeem a coupon", link:"#redeemCoupon", class:"inactive"});
  leftNavs.push({title:"<i class='icon-user'></i>&nbsp;Manage customers", link:"#customers", class:"inactive"});
  leftNavs.push({title:"<i class='icon-facetime-video'></i>&nbsp;See how it works", link:"#howitworks", class:"inactive"});
  
  
  $scope.leftNavClicked = function($event, selectedIndex) {
     for(var i = 0 ; i < leftNavs.length; i++) {
      if(i === selectedIndex) 
          $scope.leftNavs[i].class="active";
      else
          $scope.leftNavs[i].class="inactve";
      
    }
  };



};


function CustomerController($scope) {

  var customers = $scope.customers = [];
  customers.push({name:"Manish", email:"Manish_kumar@intuit.com", phone:"9886618989", loyaltyPoints:"20"});
 customers.push({name:"Ajay", email:"Manish_kumar@intuit.com", phone:"123455353", loyaltyPoints:"20"});
 customers.push({name:"Manas", email:"Manish_kumar@intuit.com", phone:"1234567890", loyaltyPoints:"75"});
 customers.push({name:"Fazil", email:"Manish_kumar@intuit.com", phone:"2222222222", loyaltyPoints:"200"});
 customers.push({name:"Siva", email:"Manish_kumar@intuit.com", phone:"7654324332", loyaltyPoints:"10"});
 customers.push({name:"Ajit", email:"Manish_kumar@intuit.com", phone:"454312313", loyaltyPoints:"0"});
  customers.push({name:"Ajay", email:"Manish_kumar@intuit.com", phone:"123455353", loyaltyPoints:"20"});
 customers.push({name:"Manas", email:"Manish_kumar@intuit.com", phone:"1234567890", loyaltyPoints:"75"});
 customers.push({name:"Fazil", email:"Manish_kumar@intuit.com", phone:"2222222222", loyaltyPoints:"200"});
 customers.push({name:"Siva", email:"Manish_kumar@intuit.com", phone:"7654324332", loyaltyPoints:"10"});
 customers.push({name:"Ajit", email:"Manish_kumar@intuit.com", phone:"454312313", loyaltyPoints:"0"});
 
 $scope.myData = [{name: "Moroni", age: 50},
                 {name: "Tiancum", age: 43},
                 {name: "Jacob", age: 27},
                 {name: "Nephi", age: 29},
                 {name: "Enos", age: 34}];

  $scope.gridOptions = { data: 'myData' };
  

  $scope.noOfPages = 7;
  $scope.currentPage = 4;
  $scope.maxSize = 5;
  
  $scope.setPage = function (pageNo) {
    $scope.currentPage = pageNo;
  };

  $scope.bigNoOfPages = 18;
  $scope.bigCurrentPage = 1;

  function selectCustomer($event) {
    alert('selected');
  }

};


function CouponController($scope) {
  $scope.isCollapsed = false;

};

//To make core.html working uncomment the following lines. The main.html is breaking if i add this. So commenting it for time being.
/*
angular.module('bizSpark', []).config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/sendCoupon', {templateUrl: 'partials/sendCoupon.html', controller: CoreController }).
	              when('/redeemCoupon', {templateUrl: 'partials/redeemCoupon.html', controller: CouponController }).
	              when('/insights', {templateUrl: 'partials/insights.html', controller: CoreController }).
	              when('/customers', {templateUrl: 'partials/customers.html', controller: CustomerController}).
	              when('/howitworks', {templateUrl: 'partials/howItWorks.html', controller: CoreController}).
	              otherwise({redirectTo : '/sendCoupon'});

	  //$locationProvider.html5Mode(true);
}]);


*/




