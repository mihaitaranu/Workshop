hrApp.controller('LocationEditController', ['$scope', '$http', '$routeParams', '$location', 'commonResourcesFactory', '$filter'
    , function ($scope, $http, $routeParams, $location, commonResourcesFactory, $filter) {
        $scope.location = {};
        /**
         * Reset form
         */
        $scope.reset = function () {
            $scope.location = {};
        };

        $http({url: 'http://hrapp-zth.rhcloud.com/hrapp/locations/' + $routeParams.locationid, method: 'GET'}).
            success(function (data) {
                $scope.location = data;
            });

        /**
         * Persist an location
         * @param addLocation - location to be persisted
         */
        $scope.create = function (addLocation) {
            $http({url: commonResourcesFactory.editLocationbUrl, method: 'PUT', data: addLocation}).
                success(function (data) {
                    $scope.location = data;
                    $location.url('/locationview/' + $scope.location.locationId);
                });
        }

    }]);