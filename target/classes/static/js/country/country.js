angular
		.module('country', [])
		.component(
				'countries',
				{
					template : '<div class="col-md-6 col-sm-12 col-xs-12"><a href="/Factories" ng-click="$ctrl.save()"><button>{{$ctrl.country.name}}</button></a></div>',
					bindings : {
						country : '<'
					},
					controller : function(store,$localStorage) {
						this.save = function() {
							$localStorage.country = this.country
						};
					}
				})

		.controller('country', function($http, store,$localStorage) {
			var self = this;
			
			$http.get('/countries/').then(function(response) {
				self.countries = response.data;
				// console.log(self.countries)
			});

			self.edit = function() {
				$localStorage.editorData = self.countries
				$localStorage.path = 'countries'
			}

		});
