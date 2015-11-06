app.controller('HomeController', function($scope, $http) {
	console.log("Hello World");
        $scope.Enclosure = function() {
            console.log("Going to enclosures");
            window.location = "#/enclosure";
        }
	$scope.Animal = function() {
            console.log("Going to animals");
        }
        $scope.Food = function() {
            console.log("Going to foods");
        }
  });