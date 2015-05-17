hrApp.controller('EmployeeViewController', ['$scope', '$http', '$routeParams', '$location', 'employeeService',
    function($scope, $http, $routeParams, $location, employeeService) {



        // TODO get employee by id
        $http({url: 'http://hrapp-zth.rhcloud.com/hrapp/employees/'+$routeParams.employeeid, method: 'GET'}).
            success(function (data) {
                $scope.employee = data;
            });

        // TODO back to Employee List page
        $scope.back = function() {
            $location.url('/employeeslist');
        }

    }]);