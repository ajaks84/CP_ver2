angular.module('line', [])

 .component('lines', {
 templateUrl : 'js/line/lines.template.html',
 bindings : {
 line: '<'
 },
 controller: function(store) {
		this.save = function (){
			store.line = this.line
		}}
 })

.controller('line', function($http,store) {
	var self = this;
	self.factory = store.factory
	self.country = store.country
//	console.log(self.factory)
//	console.log(store.country)

	 $http.get('/lines/by'+store.factory.id).then(function(response) {
	 self.lines = response.data;
//	 console.log(self.lines)
	 });
	
	self.edit = function() {
//		console.log(store)
		store.editorData = self.lines
		store.path = 'lines'
//		console.log(store)
	}

});
