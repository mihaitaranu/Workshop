hrApp.controller('MenuController', ['$scope', 'employeeActionsService', 'jobActionsService','departmentActionsService','locationActionsService',function($scope, employeeActionsService,jobActionsService,departmentActionsService,locationActionsService ){

    $scope.employeeActionList = employeeActionsService;

    $scope.jobActionList= jobActionsService;

    $scope.departmentActionList= departmentActionsService;

    $scope.locationActionList=locationActionsService;

    $scope.currentDate = new Date();

}]);
