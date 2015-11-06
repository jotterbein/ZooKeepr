app.controller('FoodController',["$scope", "$http", function($scope, $http) {

    $scope.foods = [];
    $scope.newFood;
    $scope.categories = ["Fruit", "Meat", "Vegtables", "Other"];

    $scope.loadFood = function() {
	   var request = $http.get('/getFood');
           request.success(function(data, status, headers, config) {
              if (data) {
                	$scope.foods = data;
                 }
             });
    }
    $scope.loadFood();
    
    $scope.selectFood = function(food) {
        $scope.newFood = food;
        for(var i = 0; i < $scope.categories.length; i++) {
            if($scope.categories[i] == food.category) {
                $scope.category = $scope.categories[i];
            }
        }
    }
    
    $scope.createNewFood = function(){
        $scope.newFood = null;
        $scope.category = null;
    }
    
    $scope.update = function (){
        $scope.newFood.category = $scope.category;
        if($scope.createNew){
            $scope.postPromise = $http.post("/addFood",JSON.stringify($scope.newFood));
        	$scope.postPromise.then( function(data){
            });
        }
        else {
            $scope.postPromise = $http.put("/updateFood",JSON.stringify($scope.newFood));
        	$scope.postPromise.then( function(data){
            });
        }
        
    }
}]);