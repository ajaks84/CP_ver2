angular.module('editor', [])

.controller('editor', function($http, store, $scope, $window, $localStorage) {
	var self = this;

	console.log($localStorage.editorData)
    if ($localStorage.editorData.length > 0){
	self.editorData = $localStorage.editorData
	self.fields = Object.getOwnPropertyNames(self.editorData[0]);
	self.fields.pop();}
    else {
    	self.empty = 1}
	self.path = $localStorage.path;
	self.goBack = function() {
		$window.history.back();
	};

	self.insertEntry = function() {
		self.saveMethod(self.entry);
	};
	
	self.setParam = function(entry) {
		self.edit = true;
		self.editEntry = entry;
		delete self.editEntry.$$hashKey;
		self.index = self.editorData.indexOf(entry);
	};

	self.updateEntry = function() {
		self.saveMethod(self.editEntry);
		self.edit = false;
	};
	
	self.deleteEntry = function(entry) {
		var index = self.editorData.indexOf(entry);
		if (entry.id != 'n/a') {
			$http.delete('/' + self.path + '/'+entry.id).then(function(response) {
// console.log(response.data)
			});
		}
		if (index > -1) {
			self.editorData.splice(index, 1);
		}
	};
	
	self.saveMethod = function(entry) {
		var json = JSON.stringify(entry);
		$http.post('/' + self.path + '/', json).then(function(response) {
// console.log(response.data)
		});
		if (entry.id == undefined) {
			self.editorData.push(self.addIdField(entry));
		}
	}
	self.addIdField = function(obj) {
		var newObj = {
			id : "n/a"
		};
		for ( var key in obj) {
			newObj[key] = obj[key];
		}
		return newObj;
	}

});
