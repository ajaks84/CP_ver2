angular.module('report', [ 'ui.date' ])

.component('shiftButton', {
	templateUrl : 'js/report/shift.button.template.html',
	bindings : {
		date : '<',
		shiftData : '<'
	},
	controller : function($localStorage) {
		this.save = function() {
			$localStorage.reportData = this.shiftData
		}
	}
})

.controller(
		'report',
		function($http, store, $scope, $location,$localStorage) {
			var self = this;
//			console.log($localStorage)
			self.factory = $localStorage.factory
			self.country = $localStorage.country
			self.line = $localStorage.line
//			console.log(self.line)

			$scope.dateOptions = {
				dateFormat : "yy-mm-dd",
			};

			var MyDate = new Date();

			self.curDayDate = formatDate(MyDate, 0);
			self.prvDayDate = formatDate(MyDate, -1);

			function formatDate(date, correction) {
				var formatedDate = date.getFullYear() + '-'
						+ ('0' + (date.getMonth() + 1)).slice(-2) + '-'
						+ ('0' + (date.getDate() + correction)).slice(-2);
				return formatedDate;
			}

			$http.get('/reports/by' + self.line.id + '/' + self.curDayDate)
					.then(function(response) {
						self.currentShifts = response.data;
//						console.log(self.currentShifts)
					});

			$http.get('/reports/by' + self.line.id + '/' + self.prvDayDate)
					.then(function(response) {
						self.recentShifts = response.data;
						// console.log(self.recentShifts)
					});
			
			$http.get('/products/' + self.line.productId )
			.then(function(response) {
				self.product = response.data;
				// console.log(self.recentShifts)
			});
			
			

			$scope.getDataForReport = function() {
				// console.log($scope.pDate)
				self.reportDate = formatDate($scope.pDate, 0)
				self.shift = $scope.shift
				self.search = true;

				// console.log(self.reportDate)
				// console.log(self.shift)

				$http.get(
						'/reports/by' + self.line.id + '/' + self.reportDate
								+ '/' + self.shift).then(function(response) {
									$localStorage.reportData = response.data;
					$location.path("ReportData" );   //+ self.reportDate
				});
			};
			

		});
