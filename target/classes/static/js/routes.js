angular.module('hello', [ 'ngRoute','ngStorage','auth', 'home', 'country','factory', 'navigation','line','report','editor' ])
	   .config(
	   function($routeProvider, $httpProvider, $locationProvider) {

					$locationProvider.html5Mode(true);

					$routeProvider.when('/', {
						templateUrl : 'js/home/home.html',
						controller : 'home',
						controllerAs : 'ctrl',
						params : {
							params : null
						}
					}).when('/Countries', {
						templateUrl : 'js/country/country.html',
						controller : 'country',
						controllerAs : 'ctrl'
					}).when('/Factories', {		//:countryName	
						templateUrl : 'js/factory/factory.html',
						controller : 'factory',
						controllerAs : 'ctrl'
					}).when('/Lines', {
						templateUrl : 'js/line/line.html',
						controller : 'line',
						controllerAs : 'ctrl'
					}).when('/Reports', {
						templateUrl : 'js/report/report.html',
						controller : 'report',
						controllerAs : 'rptCtrl'
					}).when('/ReportData', {
						templateUrl : 'js/report/report.data.html',
						controller : 'reportData',
						controllerAs : 'ctrl'
					}).when('/editor', {
						templateUrl : 'js/editor/editor.html',
						controller : 'editor',
						controllerAs : 'ctrl'
					}).when('/login', {
						templateUrl : 'js/navigation/login.html',
						controller : 'navigation',
						controllerAs : 'controller'
					}).otherwise('/');

					$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

				}).run(function(auth) {

			// Initialize auth module with the home page and login/logout path
			// respectively
			auth.init('/', '/login', '/logout');
			
				
				});




		
		
