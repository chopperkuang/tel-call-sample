<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="telApp">
<head>
    <title>电CALL系统-演示</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <script src="/js/angular.min.js"></script>
    <script src="http://cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
    <script src="/js/socket.js"></script>
    <script src="/js/tel.js"></script>
</head>

<body ng-controller="TelController">
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="../" class="navbar-brand">电CALL系统-演示</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">

            <ul class="nav navbar-nav navbar-right">
                <li><a href="javascript:void(0);" target="_blank" ng-click="add();"><span class="glyphicon glyphicon-arrow-up"></span>导入数据</a></li>
                <li><a href="javascript:void(0);" target="_blank" ng-click=""><span class="glyphicon glyphicon-arrow-up"></span>开始拨打!</a></li>
            </ul>

        </div>
    </div>
</div>
<div class="container">

    <div class="bs-docs-section">

        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h3 id="tables">呼叫列表</h3>
                </div>

                <div class="bs-component">
                    <table class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>姓名</th>
                            <th>电话号码</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="phone in phones">
                                <td>{{phone.id}}</td>
                                <td>{{phone.name}}</td>
                                <td>{{phone.phoneGo}}</td>
                                <td>未接通</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>
