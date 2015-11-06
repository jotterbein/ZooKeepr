app.controller('EnclosureController',["$scope", "$http", function($scope, $http) {

	var request = $http.get('/getEn');
         request.success(function(data, status, headers, config) {
             if (data) {
             	$scope.users = data;
             }
         });
}]);

