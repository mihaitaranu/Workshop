/**
 * Created by Taranu on 16/05/15.
 */
hrApp.service('locationService', ['$http', 'commonResourcesFactory', function ($http, commonResourcesFactory) {
        return {
            findById: function (id) {
                $http.get(commonResourcesFactory.findOneLocationUrl + id)
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