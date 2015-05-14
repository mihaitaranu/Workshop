/**
 * Created by Taranu on 13/05/15.
 */
hrApp.controller('UserController',['$scope','$location','UsersList', function($scope, $location, UsersList){
    $scope.goBack=function(){
        $location.url('/');
    };
    $scope.reset= function(){
        $scope.firstName="";
        $scope.lastName="";
        $scope.cnp="";
        $scope.age="";
    };
    $scope.saveUser=function(){
      var user={};
        user.firstName=$scope.firstName;
        user.lastName=$scope.lastName;
        user.cnp=$scope.cnp;
        user.age=$scope.age;
        UsersList.push(user);
    };
    $scope.showUserList=false;
    $scope.toggleUserList= function(){
        if($scope.showUserList){
            $scope.showUserList=false;
        }else{
            $scope.showUserList=true;
        }
    }
    $scope.UsersList=UsersList;



}]);