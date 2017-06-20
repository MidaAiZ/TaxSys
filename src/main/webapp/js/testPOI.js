/**
 * Created by Sinner on 2017/5/31.
 */
var User1 = function(){

    this.init = function(){

        //模拟上传excel
        $("#uploadEventBtn1").unbind("click").bind("click",function(){
            $("#uploadEventFile1").click();
        })
        ;
        $("#uploadEventFile1").bind("change",function(){
            $("#uploadEventPath1").attr("value",$("#uploadEventFile1").val());
        });

    };
    //点击上传按钮
    this.uploadBtn = function(){
        var uploadEventFile = $("#uploadEventFile1").val();
        if(uploadEventFile == ''){
            var message = "<h3>请选择excel,再上传!</h3><br/>";
            alertify.alert(message);
        }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
            var message = "<h3>只能上传Excel文件!</h3><br/>";
            alertify.alert(message);
        }else{
            var url = '/incomes/upload/';
            var formData = new FormData($('#form1-2')[0]);
            user1.sendAjaxRequest(url,'POST',formData);
        }
    };

    this.sendAjaxRequest = function(url,type,data){
        $.ajax({
            url : url,
            type : type,
            data : data,
            success : function(result) {
                var $result = $("#result1");
                var $list = $result.find("tbody");
                var list = result.incomes || result.outcomes;
                var type = "";
                $result.show()
                if (list) {
                    for(var i in list) {
                        if (result.incomes) {
                            console.log(list[i]);
                            type = list[i].inType;
                        }else if (result.outcomes) {
                            console.log(list[i]);
                            type = list[i].outType;
                        }
                        $tr = $(
                            "<tr><td>" +
                                list[i].taxId +
                                "</td><td>" +
                                type        +
                                "</td><td>" +
                                list[i].money +
                                "</td><td>" +
                                list[i].created_at +
                            "</td></tr>"
                            );
                        console.log($tr);
                        $list.append($tr);
                    }
                } else {  // 沒有插入数据
                    var message = "<h3>没有导入任何数据！</h3><br/>";
                    alertify.alert(message);
                }
            },
            error : function() {
                alert( result.error);
            },
            cache : false,
            contentType : false,
            processData : false
        });
    };
}

var User2 = function(){

    this.init = function(){

        //模拟上传excel
        $("#uploadEventBtn2").unbind("click").bind("click",function(){
            $("#uploadEventFile2").click();
        });
        $("#uploadEventFile2").bind("change",function(){
            $("#uploadEventPath2").attr("value",$("#uploadEventFile2").val());
        });

    };
    //点击上传按钮
    this.uploadBtn = function(){
        var uploadEventFile = $("#uploadEventFile2").val();
        if(uploadEventFile == ''){
            var message = "<h3>请选择excel,再上传!</h3><br/>";
            alertify.alert(message);
        }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
            var message = "<h3>只能上传Excel文件!</h3><br/>";
            alertify.alert(message);
        }else{
            var url = '/outcomes/upload/';
            var formData = new FormData($('#form2-2')[0]);
            user2.sendAjaxRequest(url,'POST',formData);
        }
    };

    this.sendAjaxRequest = function(url,type,data){
        $.ajax({
            url : url,
            type : type,
            data : data,
            success : function(result) {
                var $result = $("#result2");
                var $list = $result.find("tbody");
                var list = result.incomes || result.outcomes;
                var type = "";
                $result.show()
                if (list) {
                    for(var i in list) {
                        if (result.incomes) {
                            console.log(list[i]);
                            type = list[i].inType;
                        }else if (result.outcomes) {
                            console.log(list[i]);
                            type = list[i].outType;
                        }
                        $tr = $(
                            "<tr><td>" +
                            list[i].taxId +
                            "</td><td>" +
                            type        +
                            "</td><td>" +
                            list[i].money +
                            "</td><td>" +
                            list[i].created_at +
                            "</td></tr>"
                        );
                        console.log($tr);
                        $list.append($tr);
                    }
                } else {  // 沒有插入数据
                    var message = "<h3>没有导入任何数据！</h3><br/>";
                    alertify.alert(message);
                }
            },
            error : function() {
                alert( result.error);
            },
            cache : false,
            contentType : false,
            processData : false
        });
    };
}

var user1,user2;
$(function(){
    user1 = new User1();
    user2 = new User2();
    user1.init();
    user2.init();
});
