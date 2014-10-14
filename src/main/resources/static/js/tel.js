angular.module('telApp', ['bd.sockjs'])
    .factory('mySocket', function (socketFactory) {
        return socketFactory({
            url: '/socket'
        });
    })
    .controller('TelController', ['$scope', '$http', 'mySocket', function($scope, $http, mySocket) {

        $scope.add = function(){
            $http.post('/call/add').success(function(data){
                console.log(data);
                $http.get('/phones').success(function(data) {
                    $scope.phones =  data;
                });
            });
        };

        $scope.start = function() {
            $http.get("/call/toSubmit").success(function(data){
                console.log(data);
            });
        }

        $http.get('/phones').success(function(data) {
            $scope.phones =  data;
        });



        //start socket
        mySocket.setHandler('open', function () {
            console.log("socket open ok.");
        });

        mySocket.setHandler('message', function (e) {
            var msg = angular.fromJson(e.data);
            console.log("message: id => " + msg.id);

            angular.forEach($scope.phones, function(phone, key){
                phone.calling = false;

                if(angular.equals(phone.id, msg.id)) {
                    phone.calling = true;
                    if(msg.type === "answered") {
                        phone.status = "被叫接听";
                    } else if (msg.type === "ticket") {
                        if(msg.keepTime == 0) {
                            phone.status = "未接通";
                        } else {
                            phone.status = "通话时长 " + msg.keepTime + "s";
                        }
                    } else {
                        phone.status = "正在呼叫";
                    }
                }
            });

        });





    }]);
