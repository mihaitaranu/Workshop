hrApp.controller('EmployeeViewController', ['$scope', '$http', '$routeParams', '$location','commonResourcesFactory',
    function($scope, $http, $routeParams, $location, commonResourcesFactory) {

        $scope.employee = {};

        $http.get(commonResourcesFactory.findOneEmployeeUrl+ $routeParams.employeeid)
            //TODO #HR3 Load employee list from server using commonResourcesFactory
            .success(function(data, status, headers, config) {
                $scope.employee = data;
            })
            .error (function(data, status, headers, config){
            alert("Error: " + status);
        });

        // TODO #HR6 get employee by id



        $scope.back = function() {
            // TODO back to Employee List page\
            var url='/employeeslist'
            $location.url(url);


        }

    }]);