hrApp.controller('JobViewController', ['$scope', '$http', '$routeParams', '$location', 'jobService',
    function($scope, $http, $routeParams, $location, jobService) {

        // TODO get job by id
        $http({url: 'http://hrapp-zth.rhcloud.com/hrapp/jobs/'+$routeParams.jobid, method: 'GET'}).
            success(function (data) {
                $scope.job = data;
            });

        // TODO back to Job List page
        $scope.back = function() {
            $location.url('/jobslist');
        }

    }]);