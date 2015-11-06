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
	.otherwise({
        redirectTo: '/home'
    });
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});
