/**
 * Created by Sinner on 2017/5/31.
 */
var Export = function(id){
    this.init = function(){
        //模拟上传excel
        $("#uploadEventBtn" + id).unbind("click").bind("click",function(){
            $("#uploadEventFile" + id).click();
        });
        $("#uploadEventFile" + id).bind("change",function(){
            $("#uploadEventPath" + id).attr("value",$("#uploadEventFile" + id).val());
        });
    };
    //点击上传按钮
    this.uploadBtn = function(){
        var uploadEventFile = $("#uploadEventFile" + id).val();
        var $tipEle = $("#upload-tip");
        if(uploadEventFile == ''){
            $tipEle.html("<span class='glyphicon glyphicon-alert' style='color: red;'>请选择excel,再上传</span>").siblings("#f-loading").hide();
        }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
            $tipEle.html("<span class='glyphicon glyphicon-floppy-remove' style='color: red;'>只能上传Excel文件</span>").siblings("#f-loading").hide();
        }else{
            var url = id == 2 ? '/outcomes/upload/' : 'incomes/upload';
            var formData = new FormData($("#form" + id + "-" + 2)[0]);
            sendAjaxRequest(url,'POST',formData, id);
            $tipEle.html("<span class='glyphicon glyphicon-cloud-upload' style='color: green;'>上传中...</span>").siblings("#f-loading").show();
        }
        $('#uploadModal').modal('show');
    };
}

function sendAjaxRequest(url, type, data, id){
    $.ajax({
        url : url,
        type : type,
        data : data,
        success : function(result) {
            var $result = $("#result" + id);
            var $list = $result.find("tbody");
            var successList = result.successList;
            var failList = result.failList;
            var error = result.error;
            $list.empty(); //清除原有数据
            $result.show(); // 显示结果
            if(error) {
                errorHandle(error, $list);
            }
            else {
               $('#uploadModal').find("#f-loading").end().modal('hide');
                successHandle(successList, $list);
                failHandle(failList, $list)
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

function errorHandle(error, $list) {
    $("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>" + error +"</span>").siblings("#f-loading").hide();
    $('#uploadModal').modal('show');
}

function successHandle(successList, $list, text) {
    var text = text || '导入成功';
    for(var i in successList) {
        var type = successList[i].inType || successList[i].outType;
        var $tr = $(
            "<tr><td>" +
            successList[i].taxId +
            "</td><td>" +
            type        +
            "</td><td>" +
            successList[i].money +
            "</td><td>" +
            successList[i].taxDate +
            "</td><td style='color: green'>" +
            "<span class='glyphicon glyphicon-ok-sign'>" + text + "</span>" +
            "</td><td data-role='opt'>" +
            "</td></tr>"
        );
        $list.append($tr);
    }
}

function failHandle(failList, $list) {
    if(failList.length == 0) {
        $list.siblings("thead").find("[data-role=opt]").remove();
        $(".operator").hide();
        return true;
    } else {
        $list.siblings("thead").find("tr").find("[data-role=opt]").remove()
             .end().append("<td width='10%'' data-role='opt'>操作<input type='checkbox' data-role='all'></td>");
        $(".operator").show();
        $list.parents(".result").find("[data-role=force-btn]").show();
    }
    for(var i in failList) {
        var item = failList[i].income || failList[i].outcome
        var type = item.inType || item.outType;
        var $tr = $(
            "<tr data-res='fail' data-id='" + i +
            "'><td data-c='taxId'>" +
            item.taxId +
            "</td><td data-c='type'>" +
            type        +
            "</td><td data-c='money'>" +
            item.money +
            "</td><td data-c='taxDate'>" +
            item.taxDate +
            "</td><td data-role='result'>" +
            "<span class='glyphicon glyphicon-exclamation-sign'></span>" + failList[i].error +
            "</td><td data-role='opt'>" +
            "</td></tr>"
        ).css("color", "red");
        if(failList[i].error.lastIndexOf("已存在") != -1) {
            $tr.find("[data-role=opt]").html("<input type='checkbox' class='fail'>");
        }
        $list.append($tr);
    }
}

var exportIn;
var exportOut;
window.ForceFailList = [];

$(function(){
    exportIn = new Export(1);
    exportOut = new Export(2);
    exportIn.init();
    exportOut.init();

    $("table").on("click", "input[data-role=all]", function () {
        var _this = $(this);
        var _table = $(this).parents("table");
        window.ForceFailList = [];

        if(_this.attr("checked")) {
            _this.removeAttr("checked");
            _table.find("input[type=checkbox]").removeAttr("checked");
            return true;
        }
        _table.find("tr[data-res=fail]").each(function(i, ele) {
            var e = $(ele);
            e.find("input.fail").removeAttr("checked").trigger("click");
        });
        _this.attr("checked", true);
    });

   $("table").on("click", "input.fail", forceAdd);
   $("[data-role=force-btn]").on("click", function() {
       var  $this = $(this);
       var $table =  $("table[data-type="+ $this.data("type") + "]");;
       for(var i in window.ForceFailList) {
           var current = i;
           $.ajax({
               url: $this.data("url"),
               type: "POST",
               dataType: "json",
               data: window.ForceFailList[i],
               async: false,
               error: function() {
                   $table.find("tr[data-id=" + window.ForceFailList[i].id +"]")
                         .find("[data-role=result]").html("<span class='glyphicon glyphicon-exclamation-sign'>导入失败</span>");
                   $('#uploadModal').find("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign'>系统错误</span>")
                       .end().find("#f-loading").hide()
                       .end().modal('show');
               },
               success: function(res) {
                   if(res.income || res.outcome) {
                       $table.find("tr[data-id=" + window.ForceFailList[current].id +"]").css("color", "#8d9095")
                             .attr("data-res", "suc")
                             .find("input").remove()
                             .end().find("[data-role=result]").html("<span class='glyphicon glyphicon-ok-sign'>导入成功</span>").css("color", "#f9e403");
                   } else {
                       $table.find("tr[data-id=" + window.ForceFailList[i].id +"]")
                             .find("[data-role=result]").html("<span class='glyphicon glyphicon-exclamation-sign'>导入失败</span>");
                   }
                   if($table.find("tr[data-res='fail']").length == 0) {
                       $table.find("td[data-role=opt]").remove();
                       $this.hide();
                   }
               }
           })
       }
       window.ForceFailList = [];
   })
});

function forceAdd(e) {
    var _this = $(e.target);

    if(_this.attr("checked")) {
        _this.removeAttr("checked");
        for(var i in window.ForceFailList){
          if(window.ForceFailList[i].id == _this.parents("tr").data("id")) {
              window.ForceFailList.pop(i);
          }
        };
        return true;
    }
    var _tr = _this.parents("tr");
    var obj = {
        id: _tr.data("id"),
        taxId: _tr.find("td[data-c=taxId]").text(),
        taxDate: _tr.find("td[data-c=taxDate]").text(),
        money: _tr.find("td[data-c=money]").text(),
        type: _tr.find("td[data-c=type]").text(),
    };
    window.ForceFailList.push(obj);
    _this.attr("checked", true);
}
