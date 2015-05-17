hrApp.controller('JobAddController', ['$scope', '$http', '$location', 'commonResourcesFactory',
    function ($scope, $http, $location, commonResourcesFactory) {
        $scope.job = {};
        $scope.requiredErrorMessage = "Please fill out this form!";

        /**
         * Reset form
         */
        $scope.resetForm = function () {
            $scope.job = {};
        };


        /**
         * Persist an job
         * @param addJob - job to be persisted
         */
        $scope.create = function (addJob) {
            $http({url: commonResourcesFactory.addJobUrl, method: 'POST', data: addJob}).
                success(function (data) {
                    $scope.job = data;
                    $location.url('/jobview/' + $scope.job.jobId);
                });
        };
    }]);