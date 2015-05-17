hrApp.controller('DepartmentViewController', ['$scope', '$http', '$routeParams', '$location', 'departmentService',
    function($scope, $http, $routeParams, $location, departmentService) {



        // TODO get department by id
        $http({url: 'http://hrapp-zth.rhcloud.com/hrapp/departments/'+$routeParams.departmentid, method: 'GET'}).
            success(function (data) {
                $scope.department = data;
            });

        // TODO back to Department List page
        $scope.back = function() {
            $location.url('/departmentslist');
        }

    }]);