hrApp.controller('DepartmentListController', ['$scope', '$http', '$location', 'commonResourcesFactory',
    function ($scope, $http, $location, commonResourcesFactory) {

        $scope.departments = [];


        $http({url: commonResourcesFactory.findAllDepartmentsUrl, method: 'GET'}).
            success(function (data, status, headers, config) {
                $scope.departments = data;
            });



        $scope.viewDepartment = function (departmentId) {
            $location.url('/departmentview/' + departmentId);
        };

        $scope.editDepartment = function (departmentId) {
            $location.url('/departmentedit/' + departmentId);
        };
        $scope.deleteDepartment = function (departmentId) {
            $http({url: commonResourcesFactory.deleteDepartmentUrl+departmentId, method: 'DELETE'}).
                success(function (data) {
                    $location.url('/departmentslist');
                });
        };

    }]);