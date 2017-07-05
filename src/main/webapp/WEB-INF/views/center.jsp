<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <srcipt src="js/center.js"></srcipt>
    <script src="js/bootstrap.min.js"></script>
    <style>
    body{
        background-image: url('image/bg.png')
    }
    </style>
</head>
<body>
<h3 style="margin-left: 100px;margin-top: 50px">个人中心</h3>
<div class="container" style="margin-top: 20px;">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#information" aria-expanded="true">个人信息</a></li>
        <li class=""><a data-toggle="tab" href="#modify" aria-expanded="false">修改密码</a></li>
    </ul>
    <div class="tab-content" style="text-align: center;">
        <div id="information" class="tab-pane fade active in" style="text-align: center">
            <div>
                <div class="qfyuser-label" style="margin-top: 125px;margin-left: 200px">
                    <div style="font-size: medium;width: 120px;float: left">用户名：</div>
                        <div id="name" style="font-size: medium;width: 120px;float: left;margin-left: 50px"></div><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">手机号：</div>
                        <div id="tel" style="font-size: medium;width: 120px;float: left;margin-left: 50px"></div><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">角色：</div>
                        <div id="role" style="font-size: medium;width: 120px;float: left;margin-left: 50px"></div><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">用户注册日期：</div>
                        <div id="date" style="font-size: medium;width: 120px;float: left;margin-left: 50px"></div><br><br><br>
                </div>
            </div>
        </div>
        <div id="modify" class="tab-pane fade" style="text-align: center;">
            <div>
                <form action="" class="qfyuser-label" style="margin-top: 125px;margin-left: 200px;">
                    <div style="font-size: medium;width: 120px;float: left;">原始密码：</div>
                    <input class="form-control" type="password" style="font-size: medium;width: 200px;float: left;margin-left: 50px"><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">新的密码：</div>
                    <input class="form-control" type="password" style="font-size: medium;width: 200px;float: left;margin-left: 50px"><br><br><br>
                    <div style="font-size: medium;width: 120px;float: left">确认密码：</div>
                    <input class="form-control" type="password" style="font-size: medium;width: 200px;float: left;margin-left: 50px"><br><br><br>
                    <input class="btn-xs btn-primary form-control" style="font-size: medium;width: 200px;float: left;margin-left: 50px" type="submit" value="确定">
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
