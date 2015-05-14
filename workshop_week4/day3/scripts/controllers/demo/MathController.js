hrApp.controller('MathController', ['$scope','mathFunction', function ($scope, mathFunction) {

    $scope.calculate = function () {
        var a= $scope.a;
        var b=$scope.b;
        $scope.op1 = mathFunction.add(a,b);
        $scope.op2 = mathFunction.substract(a,b);
        $scope.op3 = mathFunction.multiply(a,b);
        $scope.op4 = mathFunction.divide(a,b);
//        TODO #8 calculate op1, op2, op3, op4

//        TODO #13 refactor your calculations using MathService
    }

}]);
