hrApp.controller('EmployeeAddController', ['$scope', '$http', '$location', 'commonResourcesFactory',
    function ($scope, $http, $location, commonResourcesFactory) {
    $scope.employee = {};
    $scope.requiredErrorMessage = "Please fill out this form!";
    $scope.patternDateNotRespectedMessage = "The date format should be yyyy-mm-dd";
    $scope.patternCommisionNotRespectedMessage = "Commission should be in the format 0.XX";

    //TODO#HR1
        $scope.departments={};
        $http({url: commonResourcesFactory.findAllDepartmentsUrl, method: 'GET'}).
            success(function (data, status, headers, config) {
                $scope.departments = data;
            });
        $scope.jobs={};
        $http({url: commonResourcesFactory.findAllJobsUrl, method: 'GET'}).
            success(function (data, status, headers, config) {
                $scope.jobs = data;
            });
        $scope.managers={};
        $http({url: commonResourcesFactory.findAllEmployeesUrl, method: 'GET'}).
            success(function (data, status, headers, config) {
                $scope.managers = data;
            });
    /**
     * Reset form
     */
    $scope.resetForm = function () {
        $scope.employee = {};
    };


    /**
     * Persist an employee
     * @param addEmployee - employee to be persisted
     */
    $scope.create = function (addEmployee) {
        $http({url: commonResourcesFactory.addEmployeeUrl, method: 'POST',data:addEmployee}).
            success(function (data) {
                $scope.employee = data;
                $location.url('/employeeview/'+$scope.employee.employeeId);
            });
    };

    $scope.datePattern = /^\d{4}-\d{2}-\d{2}$/;
    $scope.commissionPattern = /^[0]\.\d{1}(\d)?$/;
}]);