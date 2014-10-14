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
                <li><a href="javascript:void(0);" target="_blank" ng-click="add();"><span class="glyphicon glyphicon-plus"></span> 导入数据</a></li>
                <li><a href="javascript:void(0);" target="_blank" ng-click=""><span class="glyphicon glyphicon-play"></span> 开始拨打!</a></li>
                <li><a href="javascript:void(0);" target="_blank" ng-click=""><span class="glyphicon glyphicon-cog"></span> 系统设置</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">
    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1 id="forms">系统设置</h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-6">
                <div class="well bs-component">
                    <form class="form-horizontal">
                        <fieldset>
                            <div class="form-group">
                                <label for="inputPhoneCome" class="col-lg-2 control-label">座机</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputPhoneCome" placeholder="phoneCome" value="51585229">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputphoneView" class="col-lg-2 control-label">显示号码</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputphoneView" placeholder="phoneView" value="15601622811">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">方式</label>
                                <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                            自动
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                                            手动
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button class="btn btn-default">取消</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
