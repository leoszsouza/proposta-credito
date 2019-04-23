var app = angular.module("todoApp", ["ngRoute"]);

app.config(['$routeProvider', function($routeProvider) {

	$routeProvider
		.when('/', {
			templateUrl : 'html/home.html',
			controller: 'homeController'
		})
		.when('/add', {
			templateUrl : 'html/todo.html',
			controller: 'todoController'
		})		
		.otherwise({
			redirectTo: '/'
		});
}]);