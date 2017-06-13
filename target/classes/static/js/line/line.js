angular.module('line', [])

 .component('lines', {
 templateUrl : 'js/line/lines.template.html',
 bindings : {
 line: '<'
 },
 controller: function($localStorage) {
		this.save = function (){
			$localStorage.line = this.line
		}}
 })

.controller('line', function($http,store,$localStorage) {
	var self = this;
	self.factory = $localStorage.factory
	self.country = $localStorage.country
	console.log($localStorage)

//	console.log(self.factory)
//	console.log(store.country)

	 $http.get('/lines/by'+self.factory.id).then(function(response) {
	 self.lines = response.data;
//	 console.log(self.lines)
	 });
	
	self.edit = function() {
//		console.log(store)
		$localStorage.editorData = self.lines
		$localStorage.path = 'lines'
//		console.log(store)
	}

});
