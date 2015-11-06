app.controller('HomeController', function($scope, $http) {
	console.log("Hello World");
        $scope.Enclosure = function() {
            console.log("Going to enclosures");
            window.location = "#/enclosure";
        }
	$scope.Animal = function() {
            console.log("Going to animals");
            window.location = "#/animal";
        }
        $scope.Food = function() {
            console.log("Going to foods");
            window.location = "#/food";
        }
  });