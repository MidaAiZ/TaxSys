<%--
  Created by IntelliJ IDEA.
  User: Sinner
  Date: 2017/5/31
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testPOI</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/testPOI.js"></script>
</head>
<body>
<div  style="padding: 50px; text-align: center;">
<form enctype="multipart/form-data" id="batchUpload" method="post" class="form-horizontal">
    <button class="btn btn-success btn-xs" id="uploadEventBtn" style="height:26px;"  type="button" >选择文件</button>
    <br>
    <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile">
    <input id="uploadEventPath"  disabled="disabled"  type="text" placeholder="请选择excel表" style="border: 1px solid #e6e6e6; height: 26px;width: 200px;margin-top: 10px;" >
    <br>
    <label for="income">进项</label><input type="radio" name="type" id="income" value="income">
    <label for="outcome">销项</label><input type="radio" name="type" id="outcome" value="outcome">
</form>
<button type="button" class="btn btn-success btn-sm"  onclick="user.uploadBtn()" >上传</button>
<div id="result" style="display: none">
    <br>
    <p style="display: block; width: 100%; text-align: left;">导入结果：</p>
    <table class="table">
        <thead>
            <tr>
                <td>发票号</td>
                <td>类型</td>
                <td>金额</td>
                <td>日期</td>
           </tr>
        </thead>
        <tbody>

        </tbody>

    </table>
</div>
</div>
</body>
</html>
