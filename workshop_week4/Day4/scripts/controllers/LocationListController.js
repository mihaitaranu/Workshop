hrApp.controller('LocationListController', ['$scope', '$http', '$location', 'commonResourcesFactory',
    function ($scope, $http, $location, commonResourcesFactory) {

        $scope.locations = [];


        $http({url: commonResourcesFactory.findAllLocationsUrl, method: 'GET'}).
            success(function (data, status, headers, config) {
                $scope.locations = data;
            });

        $scope.viewLocation = function (locationId) {
            $location.url('/locationview/' + locationId);
        };

        $scope.editLocation = function (locationId) {
            $location.url('/locationedit/' + locationId);
        };

        $scope.deleteLocation = function (locationId) {
            $http({url: commonResourcesFactory.deleteLocationUrl+locationId, method: 'DELETE'}).
                success(function (data) {
                    $location.url('/locationslist');
                });
        };

    }]);