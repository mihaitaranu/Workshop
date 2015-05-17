hrApp.controller('JobEditController', ['$scope', '$http', '$routeParams', '$location', 'commonResourcesFactory', '$filter'
    , function ($scope, $http, $routeParams, $location, commonResourcesFactory, $filter) {
        $scope.job = {};
        $scope.requiredErrorMessage = "Please fill out this form!";

        $http({url: 'http://hrapp-zth.rhcloud.com/hrapp/jobs/' + $routeParams.jobid, method: 'GET'}).
            success(function (data) {
                $scope.job = data;
                $scope.job.hireDate = $filter('date')($scope.job.hireDate, 'yyyy-mm-dd');
            });
        /**
         * Reset form
         */
        $scope.reset = function () {
            $scope.job = {};
        };

        /**
         * Persist an job
         * @param addJob - job to be persisted
         */
        $scope.create = function (addJob) {
            $http({url: commonResourcesFactory.editJobUrl, method: 'PUT', data: addJob}).
                success(function (data) {
                    $scope.job = data;
                    $location.url('/jobview/' + $scope.job.jobId);
                });
        }

    }]);