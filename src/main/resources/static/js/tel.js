angular.module('telApp', ['bd.sockjs'])
    .factory('mySocket', function (socketFactory) {
        return socketFactory({
            url: '/socket'
        });
    })
    .controller('TelController', ['$scope', '$http', 'mySocket', function($scope, $http, mySocket) {


        $http.get('/phones').success(function(data) {
            $scope.phones =  data;
        });


        $scope.add = function(){
            $http.post('/call/add').success(function(data){
                console.log(data);
                $http.get('/phones').success(function(data) {
                    $scope.phones =  data;
                });
            });
        };

    }]);
