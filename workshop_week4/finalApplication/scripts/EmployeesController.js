/**
 * Created by Taranu on 13/05/15.
 */
hrApp.controller("EmployeesController", ['$scope', function ($scope) {
    $scope.employeesOptions = [
        {
            label: "List Employees",
            url: "views/list_employees.html"
        }
    ];

}]);