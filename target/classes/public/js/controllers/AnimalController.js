app.controller('AnimalController',["$scope", "$http", function($scope, $http) {
	$scope.animals = [];
    $scope.newAnimal;
    $scope.foods = [];
    $scope.error = "";

    $scope.loadAnimals = function() {
	   var request = $http.get('/getAnimals');
           request.success(function(data, status, headers, config) {
              if (data) {
                	$scope.animals = data;
                 }
             });
    }
    $scope.loadFood = function() {
        var request = $http.get('/getFood');
           request.success(function(data, status, headers, config) {
              if (data) {
                	$scope.foods = data;
                 }
             });
    }
    $scope.loadAnimals();
    $scope.loadFood();
    
    $scope.selectAnimal = function(animal) {
        $scope.newAnimal = animal;
        for(var i = 0; i < $scope.foods.length; i++) {
            if(animal.food == $scope.foods[i].id) {
                $scope.food = $scope.foods[i];
            }
        }
    }
    
    $scope.update = function() {
        $scope.newAnimal.food = $scope.food.id;
        if($scope.createNew){
            $scope.postPromise = $http.post("/addAnimal",JSON.stringify($scope.newAnimal));
        	$scope.postPromise.then( function(data){
                $scope.error = "";
            });
            $scope.postPromise.catch(function(data) {
                $scope.error = "You have an invald enclosure";
            });
        }
        else {
            $scope.postPromise = $http.put("/updateAnimal",JSON.stringify($scope.newAnimal));
        	$scope.postPromise.then( function(data){
                $scope.error = "";
            });
            $scope.postPromise.catch(function(data) {
                $scope.error = "You have an invald enclosure";
            });
        }
    }
    
    $scope.cancel = function() {
        window.location = '#/home';
    }
}]);