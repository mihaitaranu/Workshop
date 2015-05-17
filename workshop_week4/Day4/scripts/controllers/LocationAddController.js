hrApp.controller('LocationAddController', ['$scope', '$http', '$location', 'commonResourcesFactory',
    function ($scope, $http, $location, commonResourcesFactory) {
    $scope.location = {};
    $scope.requiredErrorMessage = "Please fill out this form!";

    /**
     * Reset form
     */
    $scope.resetForm = function () {
        $scope.location = {};
    };


    /**
     * Persist an location
     * @param addLocation - location to be persisted
     */
    $scope.create = function (addLocation) {
        $http({url: commonResourcesFactory.addLocationUrl, method: 'POST',data:addLocation}).
            success(function (data) {
                $scope.location = data;
                $location.url('/locationview/'+$scope.location.locationId);
            });
    };

}]);