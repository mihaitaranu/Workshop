hrApp.controller('DepartmentEditController', ['$scope', '$http', '$routeParams', '$location', 'commonResourcesFactory', '$filter'
    , function ($scope, $http, $routeParams, $location, commonResourcesFactory, $filter) {
        $scope.department={};
    $scope.requiredErrorMessage = "Please fill out this form!";

        $scope.locations={};
        $http({url: commonResourcesFactory.findAllLocationsUrl, method: 'GET'}).
            success(function (data, status, headers, config) {
                $scope.locations = data;
            });
        $http({url: 'http://hrapp-zth.rhcloud.com/hrapp/departments/'+$routeParams.departmentid, method: 'GET'}).
            success(function (data) {
                $scope.department = data;
            });
    /**
     * Reset form
     */
    $scope.reset = function () {
        $scope.department = {};
    };

    /**
     * Persist an department
     * @param addDepartment - department to be persisted
     */
    $scope.create = function (addDepartment) {
        $http({url: commonResourcesFactory.editDepartmentUrl, method: 'PUT', data:addDepartment}).
            success(function (data) {
                $scope.department = data;
                $location.url('/departmentview/'+$scope.department.departmentId);
            });
    }

}]);