LIMIT = 6;
CONDITION = "beginTime=2011-01-01&"

function loadingIncome() {
    var limit = 6;
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


function loadingOutcome() {
    var limit = 6;
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
    $(".slide").css("display", "block");

    var select_year = $("select[name=year_form]");
    var select_month = $("select[name=month_form]");
    var select_year_outcome = $("select[name=year_form_outcome]");
    var select_month_outcome = $("select[name=month_form_outcome]");

    $(select_year_outcome).on("change",function () {
        CONDITION = "beginTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-01&"
            + "endTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-31&";
        loadingOutcome();
    });
    $(select_month_outcome).on("change",function () {
        CONDITION = "beginTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-01&"
            + "endTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-31&";
        loadingOutcome();
    });
    $(select_year).on("change",function () {
        CONDITION = "beginTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-01&"
            + "endTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-31&";
        loadingIncome();
    });
    $(select_month).on("change",function () {
        CONDITION = "beginTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-01&"
            + "endTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-31&";
        loadingIncome();
    });
})