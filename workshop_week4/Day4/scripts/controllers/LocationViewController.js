hrApp.controller('LocationViewController', ['$scope', '$http', '$routeParams', '$location', 'locationService',
    function($scope, $http, $routeParams, $location, locationService) {
        $scope.location={};

        // TODO get location by id
        $http({url: 'http://hrapp-zth.rhcloud.com/hrapp/locations/'+$routeParams.locationid, method: 'GET'}).
            success(function (data) {
                $scope.location = data;
            });

        // TODO back to Location List page
        $scope.back = function() {
            $location.url('/locationslist');
        }

    }]);