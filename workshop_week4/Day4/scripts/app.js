// TODO load ngRoute module
//var hrApp = angular.module('hrApp', []);
var hrApp = angular.module('hrApp', ['ngRoute']);

// TODO add default route for main page
// TODO add route for Employees List page
// TODO add route for Employee View page


hrApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/numbers', {
                redirectTo: '/math'
            })
            .when('/math', {
                templateUrl: 'views/demo/math.html',
                controller: 'MathController'
            })
            .when('/user', {
                templateUrl: 'views/demo/user.html',
                controller: 'UserController'
            })
            .when('/colors', {
                templateUrl: 'views/demo/colors.html',
                controller: 'Colors'
            })
            .when('/forms', {
                templateUrl: 'views/demo/form.html',
                controller: 'Form'
            })
            .when('/employeeslist', {
                templateUrl: 'views/employeelist.html',
                controller: 'EmployeeListController'
            })
            .when('/employeeview/:employeeid', {
                templateUrl: 'views/employeeview.html',
                controller: 'EmployeeViewController'
            })
            .when('/employeeadd', {
                templateUrl: 'views/employeeadd.html',
                controller: 'EmployeeAddController'
            }).
            when('/employeeedit/:employeeid', {
                templateUrl: 'views/employeeedit.html',
                controller: 'EmployeeEditController'
            }).
            when('/jobslist', {
                templateUrl: 'views/joblist.html',
                controller: 'JobListController'
            })
            .when('/jobview/:jobid', {
                templateUrl: 'views/jobview.html',
                controller: 'JobViewController'
            })
            .when('/jobadd', {
                templateUrl: 'views/jobadd.html',
                controller: 'JobAddController'
            }).
            when('/jobedit/:jobid', {
                templateUrl: 'views/jobedit.html',
                controller: 'JobEditController'
            }).
            when('/departmentslist', {
                templateUrl: 'views/departmentlist.html',
                controller: 'DepartmentListController'
            })
            .when('/departmentview/:departmentid', {
                templateUrl: 'views/departmentview.html',
                controller: 'DepartmentViewController'
            })
            .when('/departmentadd', {
                templateUrl: 'views/departmentadd.html',
                controller: 'DepartmentAddController'
            }).
            when('/departmentedit/:departmentid', {
                templateUrl: 'views/departmentedit.html',
                controller: 'DepartmentEditController'
            }).
            when('/locationslist', {
                templateUrl: 'views/locationlist.html',
                controller: 'LocationListController'
            })
            .when('/locationview/:locationid', {
                templateUrl: 'views/locationview.html',
                controller: 'LocationViewController'
            })
            .when('/locationadd', {
                templateUrl: 'views/locationadd.html',
                controller: 'LocationAddController'
            }).
            when('/locationedit/:locationid', {
                templateUrl: 'views/locationedit.html',
                controller: 'LocationEditController'
            }).
            otherwise({
                templateUrl: 'views/main.html',
                controller: 'MainController'
            });
    }])
    .
    run(['$rootScope',
        function ($rootScope) {

            // TODO

        }
    ]);