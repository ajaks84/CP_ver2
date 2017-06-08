angular
		.module('country', [])
		.component(
				'countries',
				{
					template : '<div class="col-md-6 col-sm-12 col-xs-12"><a href="/Factories/{{$ctrl.country.name}}" ng-click="$ctrl.save()"><button>{{$ctrl.country.name}}</button></a></div>',
					bindings : {
						country : '<'
					},
					controller : function(store) {
						this.save = function() {
							store.country = this.country
						};
					}
				})

		.controller('country', function($http, store) {
			var self = this;
			$http.get('/countries/').then(function(response) {
				self.countries = response.data;
				// console.log(self.countries)
			});

			self.edit = function() {
				store.editorData = self.countries
				store.path = 'countries'
			}

		});
