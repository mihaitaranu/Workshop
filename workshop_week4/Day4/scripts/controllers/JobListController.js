hrApp.controller('JobListController', ['$scope', '$http', '$location', 'commonResourcesFactory',
    function ($scope, $http, $location, commonResourcesFactory) {

        $scope.jobs = [];

        //TODO Load job list from server
        $http({url: commonResourcesFactory.findAllJobsUrl, method: 'GET'}).
            success(function (data, status, headers, config) {
                $scope.jobs = data;
            });


        // TODO add viewJob function using $location
        $scope.viewJob = function (jobId) {
            $location.url('/jobview/' + jobId);
        };

        $scope.editJob = function (jobId) {
            $location.url('/jobedit/' + jobId);
        };
        $scope.deleteJob = function (jobId) {
            $http({url: commonResourcesFactory.deleteJobUrl+jobId, method: 'DELETE'}).
                success(function (data) {
                    $location.url('/jobslist');
                });
        };

    }]);