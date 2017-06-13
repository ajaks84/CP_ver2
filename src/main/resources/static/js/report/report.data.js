angular.module('report').component('consumption', {
	templateUrl : 'js/report/consumption.template.html',
	bindings : {
		consumption : '<',
	}
}).controller(
		'reportData',
		function($http, store, $scope,$localStorage) {
			var self = this;
			self.factory = $localStorage.factory
			self.country = $localStorage.country
			self.line = $localStorage.line
//			if (store.reportData.length <= 0) {
				self.reportData = $localStorage.reportData
//			} else {
//				self.empty = 1
//			}
			// console.log(self.reportData)
			if ($localStorage.reportData.id != undefined) {
				$http.get('/consumption/by' + $localStorage.reportData.id).then(
						function(response) {
							 console.log(response.data)
							self.consumptionList = response.data;
							// console.log(self.recentShifts)
							

							for (i = 0; i < self.consumptionList.length; i++) { 
								 
								self.consumptionList[i].name = self.consumptionList[i].material.name;
								self.consumptionList[i].unit = self.consumptionList[i].material.unit;
								delete self.consumptionList[i].material

//								 console.log(self.consumptionList[i].material.name)
//								 								 console.log(self.consumptionList[i].material.unit)

							   
							}
							
						});
			}

			self.editReport = function() {
				var arr = [ self.reportData ]
				// console.log(store)
				$localStorage.editorData = arr
				$localStorage.path = 'reports'
				// console.log(store)
			}
			self.editCons = function() {
				// console.log(store)
				$localStorage.editorData = self.consumptionList
				$localStorage.path = 'consumption'
				// console.log(store)
			}

		});