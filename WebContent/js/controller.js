angular.module('bizSpark', []);


angular.module('bizSpark', [], function($routeProvider, $locationProvider) {
  $routeProvider.when('/sendCoupon', {templateUrl: 'partials/sendCoupon.html', controller: CoreController }).
              when('/redeemCoupon', {templateUrl: 'partials/redeemCoupon.html', controller: CoreController }).
              when('/insights', {templateUrl: 'partials/insights.html', controller: CoreController }).
              when('/customers', {templateUrl: 'partials/customers.html', controller: CoreController}).
              when('/howitworks', {templateUrl: 'partials/howItWorks.html', controller: CoreController}).
              otherwise({redirectTo : 'partials/temp.html'});

  //$locationProvider.html5Mode(true);
});


angular.module('bizSpark').directive('ngFocus', function($timeout) {
    return {
        link: function ( scope, element, attrs ) {
              scope.$watch( attrs.ngFocus, function ( val ) {
                if ( angular.isDefined( val ) && val ) {
                    alert('hfe');
                    $timeout( function () { element[0].focus(); } );
                }
              }, true);

              element.bind('blur', function () {
                if ( angular.isDefined( attrs.ngFocusLost ) ) {
                    scope.$apply( attrs.ngFocusLost );
                }
              });
            }
          };
      });


function MainController($scope) {

  $scope.projectName = "Biz Spark";
  $scope.menu_more = "More<span class='caret'></span>";
  $scope.labelEmail = "Email";
  $scope.labelpassword = "Password";
  $scope.labelReEnterPassword = "Re-Enter Password";
   
 
  var slides = $scope.slides = [];
  $scope.myInterval = 5000;
  slides.push({image:"../assets/images/slide-01.jpg", title:"Looking for New customers ?", content: "Existing loyal customers will recommend your business to their friends and colleagues and drive new business", active: true}); 
  slides.push({image:"../assets/images/slide-02.jpg", title:"Reward your Loyal Customers ", content: "Dont lose your customers to a competitor by rewarding your customers with discounts and offers !", active: false}); 
  slides.push({image:"../assets/images/slide-03.jpg", title:"Track your deals and Improve", content: "Our recommendation engine will track all your deals and get insightful reports on how your business is growing", active: false}); 

  var menuOptions = $scope.menuOptions = [];
  menuOptions.push({state:"enabled", name:"Sign In", url : "#signin"});
  menuOptions.push({state:"enabled", name:"Help", url : "#help"});
  menuOptions.push({state:"disabled", name:"Pricing", url : "#pricing"});
  menuOptions.push({state:"divider", name:""}); 
  menuOptions.push({state:"disabled", name:"How To Videos", url : "#video"});
  menuOptions.push({state:"disabled", name:"Live Community", url : "#community"});

  var menus = $scope.menus = [];
  menus.push({name:"Home", url : "#home"});
  menus.push({name:"About", url : "#about"});
  menus.push({name:"Contact", url : "#contact"});
  menus.push({name:"Question ? Call us at +91 988 661 8989", url : "#contact"});
  

  var features = $scope.features = [];
  features.push({image: "../assets/images/browser-icon-chrome.png", title:"Get New customers", subtitle: "Existing customers will recommend your business to their friends", description: "Easy way to issue referral based discounts and coupons which will grow your customer base multi-fold."});
  features.push({image: "../assets/images/browser-icon-firefox.png",  title:"Reward Loyal customers", subtitle: "Your loyal customers are bound to get some special treats",  description: "We help you in efficiently  engaging with your regular customers and providing jaw dropping deals which gets them back to your store"});
  features.push({image: "../assets/images/browser-icon-safari.png", title:"Great Insighst", subtitle: "Efficiently track deals and growing customer base",  description: "Our smart algorigthms will provide you insightful data and ensure you are a step ahead of your neighbour "});

    $scope.signupEmailFocus = false;
    $scope.initiateSignUp = function() {
      $scope.signupEmailFocus = true;

    };
};  


function CoreController($scope,  $route, $routeParams, $location) {

  var cmenus = $scope.cmenus = [];
  cmenus.push({name:"Biz Spark", class:"brand span9" , link : "#"});
  cmenus.push({name:"My Account" ,class:"", link:"#"});
  cmenus.push({name:"Signout", class:"span1", link:"#"});
  
  var leftNavs = $scope.leftNavs =  [];
  leftNavs.push({title:"Send a coupon", link:"#sendCoupon", class:"active"});
  leftNavs.push({title:"Redeem a coupon", link:"#redeemCoupon", class:"inactive"});
  leftNavs.push({title:"Insights", link:"#insights", class:"inactive"});
  leftNavs.push({title:"Manage customers", link:"#customers", class:"inactive"});
  leftNavs.push({title:"See how it works", link:"#howitworks", class:"inactive"});

  
  $scope.leftNavClicked = function($event, selectedIndex) {
    for(i = 0 ; i < leftNavs.length; i++) {
      if(i === selectedIndex) 
          $scope.leftNavs[i].class="active";
      else
          $scope.leftNavs[i].class="inactve";
      
    }
    
  }

};



