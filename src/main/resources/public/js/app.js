var app = angular.module('app', ['ngRoute', 'ngMaterial', 'ngMessages']);


app.config(function($routeProvider, $httpProvider) {
    $routeProvider
    .when('/home', {
        templateUrl: '../pages/home.html',
        controller: 'HomeController'
    })
    .when('/enclosure', {
        templateUrl: '../pages/enclosure.html',
        controller: 'EnclosureController'
    })
    .when('/food', {
        templateUrl: '../pages/food.html',
        controller: 'FoodController'
    })
    .when('/animal',{
        templateUrl: '../pages/animal.html',
        controller: 'AnimalController'
    })
	.otherwise({
        redirectTo: '/home'
    });
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});
