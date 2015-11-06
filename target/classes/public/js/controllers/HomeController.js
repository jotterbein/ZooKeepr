app.controller('HomeController', function($scope, $http) {
	console.log("Hello World");
        $scope.Enclosure = function() {
            window.location = "#/enclosure";
        }
	$scope.Animal = function() {
            window.location = "#/animal";
        }
        $scope.Food = function() {
            window.location = "#/food";
        }
  });