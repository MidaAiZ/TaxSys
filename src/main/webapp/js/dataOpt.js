$(document).ready(function(){
    var $context = getContext();
    var $delModal = getDelModal($context);
    var $editModal = getEditModal($context);

    $("body").on("click", function() {
        $context.hide();
        $("table").find("tr[data-id=" + $context.data("id") +"]").css("background", $context.data("bg"));
    }).append($context).append($editModal).append($delModal);

    $("table").on("contextmenu", "tr[data-id]", function(e) {
        var X = e.pageX;
        var Y = e.pageY;
        var _this = $(this);
        $("table").find("tr[data-id=" + $context.data("id") +"]").css("background", $context.data("bg"));
        $context.css({
            left: X,
            top: Y
        }).data("id", _this.data("id")).data("urltype", _this.data("urltype")).show();
        $context.data("bg", _this.css("background"));
        _this.css("background", "#b1d0ff")
        return false;
    })
});


function getDelModal($context) {
    var $this =  $("\
                <div class='modal fade' id='delModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>\
                    <div class='modal-dialog modal-sm' role='document'>\
                        <div class='modal-content'>\
                            <div class='modal-body'>\
                                <span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>是否确认删除？</span>\
                            </div>\
                           <div class='modal-footer'>\
                                <a href='javascript: void(0)' class='btn-sm btn-default' data-dismiss='modal' aria-label='Close'>取消</a>\
                                <a href='javascript: void(0)' class='btn-sm btn-danger' data-role='del' data-dismiss='modal' aria-label='Close'>删除</a>\
                            </div>\
                        </div>\
                    </div>\
                </div>\
        ").on("click", function (e) {
            event.stopPropagation();
        });;
        $this.find("a[data-role=del]").click(function() {
            $.ajax({
                url: $context.data("urltype") + "/" + $context.data("id"),
                type: "DELETE",
                dataType: "json",
                success: function(res) {
                    if(res.success) {
                        $(".pagination." + $context.data("urltype")).find("li.active").find("a").trigger("click");
                    } else {
                        $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>" + res.error +"</span>").siblings("#f-loading").hide().end().end().modal("show");
                    }
                },
                error: function() {
                    $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>删除失败！</span>").siblings("#f-loading").hide().end().end().modal("show");
                }
            })
        });
    $context.on("click", "#con-option-del", function() {
        $this.modal("show");
        $context.hide();
    })
    return $this;
}

function getEditModal($context) {
    var $this = $("\
                <div class='modal fade' id='editModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>\
                    <div class='modal-dialog modal-sm' role='document'>\
                        <div class='modal-content'>\
                            <div class='modal-body'>\
                                <p style='text-align: center;'><span class='glyphicon glyphicon-pencil'>修改信息</span></p>\
                                <form action='javascript: void(0)'>\
                                    <div class='field'>\
                                        <label for=''>发票</label>\
                                        <input type='text' name='taxId' class='form-control' placeholder='请输入发票号'><br>\
                                        <label for=''>类型</label>\
                                        <input type='text' name='type' class='form-control' placeholder='请输入类型'><br>\
                                        <label for=''>金额</label>\
                                        <input type='text' name='money' class='form-control' placeholder='请输入金额'><br>\
                                        <label for=''>日期</label>\
                                        <input type='date' name='taxDate' class='form-control' placeholder='请输入日期'>\
                                    </div>\
                                </form>\
                            </div>\
                            <div class='modal-footer'>\
                                <a href='javascript: void(0)' class='btn-sm btn-default' data-dismiss='modal' aria-label='Close'>取消</a>\
                                <a href='javascript: void(0)' class='btn-sm btn-primary' data-role='edit' data-dismiss='modal' aria-label='Close'>修改</a>\
                            </div>\
                        </div>\
                    </div>\
                </div>\
        ").on("click", function (e) {
            event.stopPropagation();
        });
    var $form = $this.find("form");
    $this.find("a[data-role=edit]").click(function() {
        $.ajax({
            url: $context.data("urltype") + "/" + $context.data("id")  + "?" + $form.serialize(),
            type: "PUT",
            // data: $form.serialize(),
            dataType: "json",
            success: function(res) {
                if(res.income || res.outcome) {
                    $(".pagination." + $context.data("urltype")).find("li.active").find("a").trigger("click");
                } else {
                    $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>" + res.error +"</span>").siblings("#f-loading").hide().end().end().modal("show");
                }
            },
            error: function() {
                $this.modal("hide");
                $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>修改失败！ </span>").siblings("#f-loading").hide().end().end().modal("show");
            }
        })
        $context.data("id");
    });
    $context.on("click", "#con-option-edit", function() {
        var $tr = $("table").find("tr[data-id=" + $context.data("id") +"]");
        $this.find("input[name=taxId]").val($tr.find("td[data-role=tax-id]").data("value"));
        $this.find("input[name=taxDate]").val($tr.find("td[data-role=tax-date]").data("value"));
        $this.find("input[name=type]").val($tr.find("td[data-role=type]").data("value"));
        $this.find("input[name=money]").val($tr.find("td[data-role=money]").data("value"));
        $this.modal("show");

        $context.hide();
    });
    return $this;
}

function getContext() {
    var $this = $("<div id='context-menu'>" +
                "<div class='context header' id='con-header'>操作</div>" +
                "<div class='context option' id='con-option-edit'><span class='glyphicon glyphicon-edit'>修改</span></div>" +
                "<div  class='context option' id='con-option-del'><span class='glyphicon glyphicon-remove-sign'>删除</span></div>" +
            "</div>"
    ).on("click", function (e) {
        event.stopPropagation();
    });
    return $this;
}