angular.module('home', []).controller('home', function($http,store) {
	var self = this;
	$http.get('/user/').then(function(response) {
		self.user = response.data.name;
	});
});
