/**
 * Created by Vodka on 2017/5/30.
 */
$(document).ready(function() {

    //进项选择option
    var _select1 = $("select[name=item1]");
    setFormone(_select1);
    $(_select1).on("change", function() {
       setFormone($(this));
    });

    //销项选择option
    var _select2 = $("select[name=item2]");
    setFormtwo(_select2);
    $(_select2).on("change", function() {
        setFormtwo($(this));
    });


    //进项导入反馈
    $('#import-1_btn').click(function() {
        $.ajax({
                url: '/incomes/createIncome',
                data: $('#form1-1').serialize(),
                type: 'post',
                dataType: 'json'
            }
        ).done(function(res) {
            if(res.income) {
                $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-ok-sign' style='color: green;'>导入成功！</span>").siblings("#f-loading").hide().end().end().modal("show");
            } else {
                $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-alert' style='color: red;'>" + res.error + "</span>").siblings("#f-loading").hide().end().end().modal("show");
            }
        }).fail(function(err) {
            $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>导入失败！</span>").siblings("#f-loading").hide().end().end().modal("show");
        });
        return false;
    })
    $('#form1-1').submit(function() {
        return false
    })

    //销项导入反馈
    $('#import-2_btn').click(function() {
        $.ajax({
                url: '/outcomes/createOutcome',
                data: $('#form2-1').serialize(),
                type: 'post',
                dataType: 'json'
            }
        ).done(function(res) {
            if(res.outcome) {
                $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-ok-sign' style='color: green;'>导入成功！</span>").siblings("#f-loading").hide().end().end().modal("show");
            } else {
                $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-alert' style='color: red;'>" + res.error + "</span>").siblings("#f-loading").hide().end().end().modal("show");
            }
        }).fail(function(err) {
            $("#uploadModal").find("#upload-tip").html("<span class='glyphicon glyphicon-exclamation-sign' style='color: red;'>导入失败！ </span>").siblings("#f-loading").hide().end().end().modal("show");
        });
        return false;
    })
    $('#form2-1').submit(function() {
        return false
    })
})

//进项变换option
function setFormone(_ele) {
    var isPoi = _ele.val();
    // console.log(isPoi);
    if (isPoi==0) {
        $("#form1-1").css("display", 'none');
        $("#form1-2").css("display", "inline-block");
    } else {
        $("#form1-2").css("display", 'none');
        $("#form1-1").css("display", "inline-block");
        $("#result1").css("display", 'none');
    }
}

//销项变换option
function setFormtwo(_ele) {
    var isPoi = _ele.val();
    // console.log(isPoi);
    if (isPoi==0) {
        $("#form2-1").css("display", 'none');
        $("#form2-2").css("display", "inline-block");
    } else {
        $("#form2-2").css("display", 'none');
        $("#form2-1").css("display", "inline-block");
        $("#result2").css("display", 'none');
    }
}

// 分页以及近期数据
$(function() {
    var limit = 12;
    var incomeUrl = '/incomes/list?orderBy=created_at&createdBegin=' + (getDate(-90)) + "&";
    var outcomeUrl = '/outcomes/list?orderBy=created_at&createdBegin=' + (getDate(-90)) +"&";
    var inPage = new myPaginate(limit, incomeUrl, incomeCK, "#in-page");
    var outPage = new myPaginate(limit, outcomeUrl, outcomeCK, "#out-page");
    inPage.init();
    outPage.init();

    $("a[href=#incomeList], a[href=#home]").on("click", inPage.update)
    $("a[href=#outcomeList]").on("click", outPage.update)
});
function getDate(n)
{
    var uom = new Date();
    uom.setDate(uom.getDate()+n);
    uom = uom.getFullYear() + "-" + (uom.getMonth()+1) + "-" + uom.getDate();
    return uom;
}

function incomeCK(res) {
    var list = res.incomeList
    if (!list) {
        return true;
    }
    var $tbody = $("#recent-table-in").find("tbody");
    $tbody.empty();
    for (var i in list) {
        var type = list[i].inType;
        var $tr = setTr(list[i], type, "incomes");

        $tbody.append($tr);
    }
}

function outcomeCK(res) {
    var list = res.outcomeList
    if (!list) {
        return true;
    }
    var $tbody = $("#recent-table-out").find("tbody");
    $tbody.empty();
    for (var i in list) {
        var type = list[i].outType;
        var $tr = setTr(list[i], type, "outcomes");
        $tbody.append($tr);
    }
}

function setTr(obj, type, urlType) {
    var $tr =  $("<tr data-urltype='" + urlType + "' data-id='" + obj.id + "'>" +
        "<td data-role='tax-id' data-value='" + obj.taxId + "'>" +
        (obj.taxId || "无") +
        "</td><td data-role='type' data-value='" + type + "'>" +
        type +
        "</td><td data-role='money' data-value='" + obj.money + "'>" +
        obj.money +
        "</td><td data-role='tax-date' data-value='" + obj.taxDate + "'>" +
        obj.taxDate +
        "</td><td data-role='created-at'>" +
        obj.created_at.substr(0, 19) +
        "</td></tr>");
    return $tr;
}

