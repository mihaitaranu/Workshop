/**
 * Created by Taranu on 14/05/15.
 */
hrApp.service('departmentService', ['$http', 'commonResourcesFactory', function ($http, commonResourcesFactory) {
        return {
            findById: function (id) {
                $http.get(commonResourcesFactory.findOneDepartmentUrl + id)
                    .success(function (data) {
                        return data;
                    })
                    .error(function (data) {
                        return {};
                    })
            }
        }
    }]
);