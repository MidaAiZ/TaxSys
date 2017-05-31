/**
 * Created by Sinner on 2017/5/31.
 */
var User = function(){

    this.init = function(){

        //模拟上传excel
        $("#uploadEventBtn").unbind("click").bind("click",function(){
            $("#uploadEventFile").click();
        });
        $("#uploadEventFile").bind("change",function(){
            $("#uploadEventPath").attr("value",$("#uploadEventFile").val());
        });

    };
    //点击上传按钮
    this.uploadBtn = function(){
        var uploadEventFile = $("#uploadEventFile").val();
        if(uploadEventFile == ''){
            alert("请选择excel,再上传");
        }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
            alert("只能上传Excel文件");
        }else{
            var url = "";
            if($("input[name=type]:checked").val() === "outcome" ) {
                url = '/outcomes/upload/';
            } else {
                url =  '/incomes/upload/';
            }
            var formData = new FormData($('form')[0]);
            user.sendAjaxRequest(url,'POST',formData);
        }
    };

    this.sendAjaxRequest = function(url,type,data){
        $.ajax({
            url : url,
            type : type,
            data : data,
            success : function(result) {
                var $result = $("#result");
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
                    alert("没有导入任何数据！");
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


var user;
$(function(){
    user = new User();
    user.init();
});


