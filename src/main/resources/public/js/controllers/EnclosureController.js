app.controller('EnclosureController',["$scope", "$http", function($scope, $http) {
	$scope.enclosures = [];
    $scope.newEnclosure;
    $scope.animals = [];
    $scope.time;

     $scope.loadEnclosures = function() {
        var request = $http.get('/getEn');
           request.success(function(data, status, headers, config) {
              if (data) {
                	$scope.enclosures = data;
                 }
             });
    }
    $scope.loadAnimals = function() {
	   var request = $http.get('/getAnimals');
           request.success(function(data, status, headers, config) {
              if (data) {
                	$scope.animals = data;
                 }
             });
    }
    $scope.loadAnimals();
    $scope.loadEnclosures();
    
    $scope.selectEnclosure = function(enclosure) {
        console.log(enclosure);
        $scope.newEnclosure = enclosure;
        for(var i = 0; i < $scope.animals.length; i++) {
            if(enclosure.animal == $scope.animals[i].id) {
                $scope.animal = $scope.animals[i];
            }
        }
        $scope.time = new Date(0,0,0, enclosure.hour, enclosure.minute, 0);
        
    }
    
    $scope.update = function() {
        $scope.newEnclosure.animal = $scope.animal.id;
        $scope.newEnclosure.hour = $scope.time.getHours();
        $scope.newEnclosure.minute = $scope.time.getMinutes();
        console.log($scope.newEnclosure);
        if($scope.createNew){
            $scope.postPromise = $http.post("/addEn",JSON.stringify($scope.newEnclosure));
        	$scope.postPromise.then( function(data){
                $scope.error = "";
                $scope.newEnclosure = null;
                $scope.animal = null;
                $scope.time = null;
                $scope.loadEnclosures();
            });
            $scope.postPromise.catch(function(data) {
                $scope.error = "You have an invalid enclosure.";
            });
        }
        else {
            $scope.postPromise = $http.put("/updateEn",JSON.stringify($scope.newEnclosure));
        	$scope.postPromise.then( function(data){
                $scope.error = "";
            });
            $scope.postPromise.catch(function(data) {
                $scope.error = "You have an invald enclosure";
            });
        }
    }
    
    $scope.delete = function() {
        if($scope.newEnclosure.id != null) {
            $scope.postPromise = $http.delete("/En/"+$scope.newEnclosure.id);
        	$scope.postPromise.then( function(data){
                $scope.newEnclosure = null;
                $scope.animal = null;
                $scope.time = null;
                $scope.loadEnclosures();
            });
        }
    }
    
    $scope.createNewEnclosure = function() {
        $scope.newEnclosure = null;
        $scope.animal = null;
        $scope.time = null;
    }
    
    $scope.cancel = function() {
        window.location = '#/home';
    }
}]);