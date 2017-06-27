LIMIT = 8;
CONDITION = "beginTime=2011-01-01&"

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
    var url = "/incomes/list?"+CONDITION;
    var myPage = new myPaginate(limit, url, callb,"#pagelist");
    myPage.init();
}

function callb(data) {
    siteList = data.incomeList;
    if (siteList) {
        OutputHtml_income(siteList);
    }
    else {  // 沒有插入数据
        alert("没有导入任何数据！");
    }
}

function OutputHtml_income(sites) {

    $content = $("#content");
    $("#content").empty();
    for (var i in sites ) {
        $content.append("<tr>" +
            "<td>" + sites[i].taxDate.substring(0, 4) + "</td>"
            + "<td>" + sites[i].taxDate.substring(5, 7) + "</td>"
            + "<td>" + sites[i].inType + "</td>"
            + "<td>" + "进项" + "</td>"
            + "<td>" + sites[i].money + "</td>"
            + "</tr>")
    }
}

//销项
function loadingOutcome() {
    var limit = 8;
    var url = "/outcomes/list?"+CONDITION;
    var myPage_outcome = new myPaginate(limit, url, callbb,"#pagelist_outcome");
    myPage_outcome.init();
}

function callbb(data) {
    siteList_outcome = data.outcomeList;
    if (siteList_outcome) {
        OutputHtml_outcome(siteList_outcome);
    }
    else {  // 沒有插入数据
        alert("没有导入任何数据！");
    }
}

function OutputHtml_outcome(sites) {

    $content = $("#content_outcome");
    $("#content_outcome").empty()
    for (var i in sites ) {
        $content.append("<tr>" +
            "<td>" + sites[i].taxDate.substring(0, 4) + "</td>"
            + "<td>" + sites[i].taxDate.substring(5, 7) + "</td>"
            + "<td>" + sites[i].outType + "</td>"
            + "<td>" + "销项" + "</td>"
            + "<td>" + sites[i].money + "</td>"
            + "</tr>")
    }
}

$(document).ready(function() {
    loadingIncome();
    loadingOutcome();

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

    $("#require-outcome").on("click",function () {
        CONDITION = "beginTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-01&"
            + "endTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-31&"
            +"type="+ $("select[name=type_form_outcome]").val()+"&";
        loadingOutcome();
    });
    $("#require-income").on("click",function () {
        CONDITION = "beginTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-01&"
            + "endTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-31&"
            +"type="+ $("select[name=type_form]").val()+"&";
        loadingIncome();
    });
})
