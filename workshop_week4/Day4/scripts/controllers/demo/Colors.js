hrApp.controller('Colors', ['$scope', function ($scope) {

    //TODO #1
    $scope.colors=[
        {
            "text":"muted",
            "class":"text-muted"
        },
        {
            "text":"primary",
            "class":"text-primary"
        },
        {
            "text":"success",
            "class":"text-success"
        },
        {
            "text":"info",
            "class":"text-info"
        },
        {
            "text":"warning",
            "class":"text-warning"
        },
        {
            "text":"danger",
            "class":"text-danger"
        }

    ];
    $scope.selectedItem={"text":"muted", "class":"text-muted"};

    $scope.changeColor = function(){
        //TODO #3
        $scope.selectedI= $scope.selectedItem;
    };

    $scope.searchText='';
    $scope.orderByText='';
}]);