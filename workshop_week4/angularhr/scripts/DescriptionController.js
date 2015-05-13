/**
 * Created by Taranu on 12/05/15.
 */

hrApp.controller("DescriptionController", ['$scope', '$rootScope', function ($scope, $rootScope) {
    $scope.title = 'Two Way Binding Demo';
    $scope.childtemplate = 'templates/main.html';
    $scope.resetFirstVariable = function () {
        $scope.firstVariable = undefined;
    };
    $scope.setFirstVariable = function (val) {
        $scope.firstVariable = val;
    };
    $scope.descriptionShow = true;
    $scope.toggleDescriptionShow = function(){
        if($scope.descriptionShow==true){
            $scope.descriptionShow=false;
        }else{$scope.descriptionShow=true;}
    }
}]);
