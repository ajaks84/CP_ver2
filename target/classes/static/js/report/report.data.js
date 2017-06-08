angular.module('report').component('consumption', {
	  templateUrl: 'js/report/consumption.template.html',
	  bindings: {
	    consumption: '<',
	  }
	})
.controller(
		'reportData',
		function($http, store, $scope) {
			var self = this;
			self.factory = store.factory
			self.country = store.country
			self.line = store.line
			self.reportData = store.reportData
//			console.log(self.reportData)
			$http.get('/consumption/by' + store.reportData.id).then(function(response) {
//				console.log(response.data)
				self.consumptionList = response.data;
//				console.log(self.recentShifts)
			});
			
			self.editReport = function() {
				var arr = [self.reportData]
//				console.log(store)
				store.editorData = arr
				store.path = 'reports'
//				console.log(store)
			}
			self.editCons = function() {
//				console.log(store)
				store.editorData = self.consumptionList
				store.path = 'consumption'
//				console.log(store)
			}
			
		});