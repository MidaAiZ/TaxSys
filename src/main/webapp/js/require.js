LIMIT = 8;
CONDITION = "beginTime=2011-01-01&orderBy=taxDate&"
INCOMEURL = "/incomes/list?"
OUTCOMEURL = "/outcomes/list?"

//下载
function download_Income() {
    var url = "/incomes/exportExcel?"+"getTaxId=true&getTaxDate=true&getMoney=true&getType=true&beginTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-01&"
        + "endTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-31&"
        +"type="+ $("select[name=type_form]").val()+"&";
    document.download_income.action =url;
    $("#download_income").submit();
}
function download_Outcome() {
    var url = "/outcomes/exportExcel?"+"getTaxId=true&getTaxDate=true&getMoney=true&getType=true&beginTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-01&"
        + "endTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-31&"
        +"type="+ $("select[name=type_form_outcome]").val()+"&";
    document.download_outcome.action = url;
    $("#download_outcome").submit();
}

//进项
function loadingIncome() {
    var limit = 8;
    var url = INCOMEURL+CONDITION;
    var myPage = new myPaginate(limit, url, callb,"#pagelist");
    myPage.init();
    return myPage;
}

function callb(res) {
    var list = res.incomeList;
    var $tbody = $("#content");
    $tbody.empty();
    if (!list) {
        return true;
    }
    for (var i in list) {
        var type = list[i].inType;
        var $tr = setTr(list[i], type, "incomes");
        $tbody.append($tr);
    }
}

//销项
function loadingOutcome() {
    var limit = 8;
    var url = OUTCOMEURL+CONDITION;
    var myPage_outcome = new myPaginate(limit, url, callbb,"#pagelist_outcome");
    setTimeout(myPage_outcome.init, 2000);
    return myPage_outcome;
}

function callbb(res) {
    var list = res.outcomeList;
    var $tbody = $("#content_outcome");
    $tbody.empty();
    if (!list) {
        return true;
    }
    for (var i in list) {
        var type = list[i].outType;
        var $tr = setTr(list[i], type, "outcomes");
        $tbody.append($tr);
    }
}

function setTr(obj, type, urlType) {
    var $tr =  $("<tr data-urltype='" + urlType + "' data-id='" + obj.id + "'>" +
        "<td data-role='tax-date' data-value='" + obj.taxDate + "'>" +
        obj.taxDate.substring(0, 4) +
        "</td><td>" + obj.taxDate.substring(5, 7) + "</td>" +
        "<td data-role='tax-id' data-value='" + obj.taxId + "'>" +
        (obj.taxId || "无") +
        "</td><td data-role='type' data-value='" + type + "'>" +
        type +
        "</td><td data-role='money' data-value='" + obj.money + "'>" +
        obj.money +
        "</td></tr>");
    return $tr;
}

$(document).ready(function() {
    var incomePage = loadingIncome();
    var outcomePage = loadingOutcome();

    $("#require-outcome").on("click",function () {
        var newCDT = "beginTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-01&"
            + "endTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-31&"
            +"type="+ $("select[name=type_form_outcome]").val()+"&";
        outcomePage.changeUrl(OUTCOMEURL + newCDT)
    });
    $("#require-income").on("click",function () {
        var newCDT = "beginTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-01&"
            + "endTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-31&"
            +"type="+ $("select[name=type_form]").val()+"&";
        incomePage.changeUrl(INCOMEURL + newCDT);
    });

    setTimeout(initType, 3000);
})

function initType() {
    $.ajax({
        type: "POST",
        url: "/incomes/types",
        dataType: "json",
        success: function(data) {
            var sites = data.types;
            $.each(sites,function(i,p){
                $content = $("select[name=type_form]");
                $content.empty();
                for (var i in sites ) {
                    $content.append("<option value="+sites[i]+">"+sites[i]+"</option>>")
                }
            });
        }
    });
    $.ajax({
        type: "POST",
        url: "/outcomes/types",
        dataType: "json",
        success: function(data) {
            var sites = data.types;
            $.each(sites,function(i,p){
                $content = $("select[name=type_form_outcome]");
                $content.empty();
                for (var i in sites ) {
                    $content.append("<option value="+sites[i]+">"+sites[i]+"</option>>")
                }
            });
        }
    });
}