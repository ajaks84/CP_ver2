angular.module('factory', [])
       .component('factories', {
	templateUrl : 'js/factory/factories.template.html',
	bindings : {
		factory : '<'
	},
	controller : function($localStorage) {
		this.save = function() {
			$localStorage.factory = this.factory
		}
	}
})

.controller('factory', function($http, store, $localStorage) {
	var self = this;
	console.log($localStorage.country)

	self.country = $localStorage.country
//	console.log(self.country)

	$http.get('/factories/by' + self.country.id).then(function(response) {
		self.factories = response.data;
	});

	self.edit = function() {
		$localStorage.editorData = self.factories
		$localStorage.path = 'factories'
	}
});
