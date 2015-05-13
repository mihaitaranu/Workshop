/**
 * Created by Taranu on 13/05/15.
 */
hrApp.controller('OtherController',['$scope',function($scope){
    $scope.title="Page title";
    $scope.setTitle= function(){
        $scope.title = "New page title";
    };
}]);