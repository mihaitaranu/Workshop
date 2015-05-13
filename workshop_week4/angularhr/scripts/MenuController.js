/**
 * Created by Taranu on 13/05/15.
 */
hrApp.controller("MenuController", ['$scope', function ($scope) {
    $scope.demoActionList = [
        {
            label: "OtherScope",
            url: "views/childscope.html"
        },
        {
            label:"Demo Math",
            url:"views/demomath.html"
        }
    ];

}]);