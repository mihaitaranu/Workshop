/**
 * Created by Taranu on 14/05/15.
 */
hrApp.service('jobService', ['$http', 'commonResourcesFactory', function ($http, commonResourcesFactory) {
        return {
            findById: function (id) {
                $http.get(commonResourcesFactory.findOneJobUrl + id)
                    .success(function (data) {
                        return data;
                    })
                    .error(function (data) {
                        return {
                            "jobId":"0",
                            "jobtitle":"Not a valid Job",
                            "minSlary": "Tray again!",
                            "maxSalary": "Contact Administrator"
                        };
                    })
            }
        }
    }]
);