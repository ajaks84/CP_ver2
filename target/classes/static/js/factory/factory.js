angular.module('factory', [])
       .component('factories', {
	templateUrl : 'js/factory/factories.template.html',
	bindings : {
		factory : '<'
	},
	controller : function(store) {
		this.save = function() {
			store.factory = this.factory
		}
	}
})

.controller('factory', function($http, store) {
	var self = this;
	self.country = store.country
	$http.get('/Factories/by' + store.country.id).then(function(response) {
		self.factories = response.data;
	});

	self.edit = function() {
		store.editorData = self.factories
		store.path = 'factories'
	}
});
