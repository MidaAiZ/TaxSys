/**
 * Created by Vodka on 2017/6/19.
 */
LIMIT = 6;
CONDITION = "2010-09-09"


$(function() {
    var limit = 6;
    var url = "/incomes/list?beginTime=2011-01-01&";
    var myPage = new myPaginate(limit, url, callb,"#pagelist");
    myPage.init();
})

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

//进项
// function getJson_income(page, limit,CONDITION) {
//     var siteList={"incomeList":[]};
//     var page = page  ? page : 1;
//     $.ajax({
//         type: "get",
//         url: "/incomes/list?page="+ page +"&limit=" + limit + "&beginTime=" + CONDITION,
//         dataType: "json",
//         success : function(data) {
//             var result = "select distinct inType from income"
//             siteList = data.incomeList;
//             var type = "进项";
//             if (siteList) {
//                 OutputHtml_income(siteList);
//             }
//             else {  // 沒有插入数据
//                 alert("没有导入任何数据！");
//             }
//         },
//         error : function() {
//             alert( result.error);
//         },
//         cache : false,
//         contentType : false,
//         processData : false
//     });
//     //
//     // $(".pagination").on("click", "a", function() {
//     //     $this = $(this)
//     //     Gotopage_income($this.data("value"), LIMIT,CONDITION);
//     //     $(this).addClass('active').siblings().removeClass('active');
//     // })
// }
//
// function createdPre_income(page,limit,CONDITION) {
//
//     var count =26;
//     var pages = Math.ceil(count/limit);
//     if(page < 1)page = 1;  //如果当前页码小于1
//     if(page > pages)page = pages; //如果当前页码大于总数
//
//     if(!(page <= pages)) page = pages;
//     // 分页
//     if(page > 1 && page !== 1){Temp ="<a href='javascript:void(0)' onclick='Gotopage_income(1,LIMIT,CONDITION)'>&lt;&lt;Index</a> <a href='javascript:void(0)' onclick='Gotopage_income(" + Math.ceil((page - 1)) + " ," + LIMIT+ " ," + CONDITION  +  ")'>previous</a>&nbsp;"}else{Temp = "&lt;&lt;Index previous&nbsp;"};
//     // 完美的翻页列表
//     var pageFrontSum = 3; //当页前显示个数
//     var pageBackSum = 3; //当页后显示个数
//
//     var pageFront = pageFrontSum - (page - 1);
//     var pageBack = pageBackSum - (pages - page);
//     if(pageFront > 0 && pageBack < 0)pageBackSum += pageFront; //前少后多，前剩余空位给后
//     if(pageBack > 0 && pageFront < 0)pageFrontSum += pageBack; //后少前多，后剩余空位给前
//     var pageFrontBegin = page - pageFrontSum;
//     if(pageFrontBegin < 1)pageFrontBegin = 1;
//     var pageFrontEnd = page + pageBackSum;
//     if(pageFrontEnd > pages)pageFrontEnd = pages;
//
//     if(pageFrontBegin != 1) Temp += '<a href="javascript:void(0)" onclick="Gotopage_income(' + Math.ceil((page - 10)) + " ," + LIMIT+ " ," + CONDITION + ')" title="前10页">..</a>';
//
//     for(var i = pageFrontBegin;i < page;i ++){
//         Temp += " <a href='javascript:void(0)' onclick='Gotopage_income(" + Math.ceil(i)  + ',' + LIMIT+ ',' + CONDITION  + ")'>" + i + "</a>";
//     }
//
//     Temp += " <strong class='f90'>" + page + "</strong>";
//     for(var i = page + 1;i <= pageFrontEnd;i ++){
//         Temp += " <a href='javascript:void(0)' onclick='Gotopage_income(" + Math.ceil(i)  + ',' + LIMIT+ ',' + CONDITION  + ")'>" + i + "</a>";
//     }
//
//     if(pageFrontEnd != pages) Temp += " <a href='javascript:void(0)' onclick='Gotopage_income(" + Math.ceil((page + 10)) + ',' + LIMIT + ',' + CONDITION + ")' title='后10页'>..</a>";
//     if(page != pages){Temp += "&nbsp;&nbsp;<a href='javascript:void(0)' onclick='Gotopage_income(" + Math.ceil((page + 1)) + ',' + LIMIT + ',' + CONDITION  + ")'>Next</a> <a href='javascript:void(0)' onclick='Gotopage_income(" + Math.ceil(pages) + ',' + LIMIT+ ',' + CONDITION  + ")'>Last&gt;&gt;</a>"}else{Temp += "&nbsp;&nbsp;Next Last&gt;&gt;"}
//     $("#pagelist").append(Temp);
//
// }
//
// function Gotopage_income(num, limit ,CONDITION ){ //跳转页
//     page = num;
//     $("#pagelist").empty();
//     getJson_income(page, limit,CONDITION)
//     createdPre_income(page, limit, CONDITION);
// }

$(function() {
    var limit = 6;
    var url = "/outcomes/list?beginTime=2011-01-01&";
    var myPage_outcome = new myPaginate(limit, url, callbb,"#pagelist_outcome");
    myPage_outcome.init();
})

function callbb(data) {
    siteList_outcome = data.outcomeList;
    if (siteList_outcome) {
        OutputHtml_outcome(siteList_outcome);
    }
    else {  // 沒有插入数据
        alert("没有导入任何数据！");
    }
}

// function ChangeHtml_income() {
//     $("#pagelist").empty();
//     var str = $("select[name=year_form]").val();
//     var strr= $("select[name=month_form]").val();
//     var str1= str +"-"+ strr +"-" + "1";
//     var str2= str +"-"+ strr +"-" + "31";
//     CONDITION = str1+"&endTime="+str2
//     getJson_income(1, LIMIT, CONDITION);
//     createdPre_income(1, LIMIT, CONDITION);
// }

//销项
// function getJson_outcome(page, limit,CONDITION) {
//     var siteList={"outcomeList":[]};
//     var page = page  ? page : 1;
//     var limit = limit ? limit : 10;
//     $.ajax({
//         type: "get",
//         url: "/outcomes/list?page="+ page +"&limit=" + limit + "&beginTime=" + CONDITION,
//         dataType: "json",
//         success : function(data) {
//             var result = "select distinct outType from outcome"
//             siteList = data.outcomeList;
//             var type = "销项";
//             if (siteList) {
//                 OutputHtml_outcome(siteList);
//             }
//             else {  // 沒有插入数据
//                 alert("没有导入任何数据！");
//             }
//         },
//         error : function() {
//             alert( result.error);
//         },
//         cache : false,
//         contentType : false,
//         processData : false
//     });
//
//     $(".pagination").on("click", "a", function() {
//         $this = $(this)
//         Gotopage_outcome($this.data("value"), LIMIT,CONDITION);
//         $(this).addClass('active').siblings().removeClass('active');
//     })
// }
//
// function createdPre_outcome(page,limit,CONDITION) {
//
//     var count =6;
//     var pages = Math.ceil(count/limit);
//     if(page < 1)page = 1;  //如果当前页码小于1
//     if(page > pages)page = pages; //如果当前页码大于总数
//
//     if(!(page <= pages)) page = pages;
//     // 分页
//     if(page > 1 && page !== 1){Temp ="<a href='javascript:void(0)' onclick='Gotopage_outcome(1,LIMIT,CONDITION)'>&lt;&lt;Index</a> <a href='javascript:void(0)' onclick='Gotopage_outcome(" + Math.ceil((page - 1)) + " ," + LIMIT+ " ," + CONDITION  +  ")'>previous</a>&nbsp;"}else{Temp = "&lt;&lt;Index previous&nbsp;"};
//     // 完美的翻页列表
//     var pageFrontSum = 3; //当页前显示个数
//     var pageBackSum = 3; //当页后显示个数
//
//     var pageFront = pageFrontSum - (page - 1);
//     var pageBack = pageBackSum - (pages - page);
//     if(pageFront > 0 && pageBack < 0)pageBackSum += pageFront; //前少后多，前剩余空位给后
//     if(pageBack > 0 && pageFront < 0)pageFrontSum += pageBack; //后少前多，后剩余空位给前
//     var pageFrontBegin = page - pageFrontSum;
//     if(pageFrontBegin < 1)pageFrontBegin = 1;
//     var pageFrontEnd = page + pageBackSum;
//     if(pageFrontEnd > pages)pageFrontEnd = pages;
//
//     if(pageFrontBegin != 1) Temp += '<a href="javascript:void(0)" onclick="Gotopage_outcome(' + Math.ceil((page - 10)) + " ," + LIMIT+ " ," + CONDITION + ')" title="前10页">..</a>';
//
//     for(var i = pageFrontBegin;i < page;i ++){
//         Temp += " <a href='javascript:void(0)' onclick='Gotopage_outcome(" + Math.ceil(i)  + ',' + LIMIT+ ',' + CONDITION  + ")'>" + i + "</a>";
//     }
//
//     Temp += " <strong class='f90'>" + page + "</strong>";
//     for(var i = page + 1;i <= pageFrontEnd;i ++){
//         Temp += " <a href='javascript:void(0)' onclick='Gotopage_outcome(" + Math.ceil(i)  + ',' + LIMIT+ ',' + CONDITION  + ")'>" + i + "</a>";
//     }
//
//     if(pageFrontEnd != pages) Temp += " <a href='javascript:void(0)' onclick='Gotopage_outcome(" + Math.ceil((page + 10)) + ',' + LIMIT + ',' + CONDITION + ")' title='后10页'>..</a>";
//     if(page != pages){Temp += "&nbsp;&nbsp;<a href='javascript:void(0)' onclick='Gotopage_outcome(" + Math.ceil((page + 1)) + ',' + LIMIT + ',' + CONDITION  + ")'>Next</a> <a href='javascript:void(0)' onclick='Gotopage_outcome(" + Math.ceil(pages) + ',' + LIMIT+ ',' + CONDITION  + ")'>Last&gt;&gt;</a>"}else{Temp += "&nbsp;&nbsp;Next Last&gt;&gt;"}
//     $("#pagelist_outcome").append(Temp);
//
// }
//
// function Gotopage_outcome(num, limit ,CONDITION ){ //跳转页
//     page = num;
//     $("#pagelist_outcome").empty();
//     getJson_outcome(page, limit,CONDITION)
//     createdPre_outcome(page, limit, CONDITION);
// }

function OutputHtml_outcome(sites) {

    $content = $("#content_outcome");
    $("#content_outcome td").remove()
    for (var i in sites ) {
        $content.append("<tr>" +
            "<td>" + sites[i].created_at.substring(0, 4) + "</td>"
            + "<td>" + sites[i].created_at.substring(5, 7) + "</td>"
            + "<td>" + sites[i].outType + "</td>"
            + "<td>" + "销项" + "</td>"
            + "<td>" + sites[i].money + "</td>"
            + "</tr>")
    }
}
//
// function ChangeHtml_outcome() {
//     $("#pagelist_outcome").empty();
//     var str = $("select[name=year_form_outcome]").val();
//     var strr= $("select[name=month_form_outcome]").val();
//     var str1= str +"-"+ strr +"-" + "1";
//     var str2= str +"-"+ strr +"-" + "31";
//     CONDITION = str1+"&endTime="+str2
//     getJson_outcome(1, LIMIT, CONDITION);
//     createdPre_outcome(1, LIMIT, CONDITION);
// }



$(document).ready(function() {
    getJson_income(1, LIMIT, "2010-09-09");
    createdPre_income(1, LIMIT, "2010-09-09");
    getJson_outcome(1, LIMIT, "2010-09-09");
    createdPre_outcome(1, LIMIT, "2010-09-09");


    var select_year = $("select[name=year_form]");
    var select_month = $("select[name=month_form]");
    var select_year_outcome = $("select[name=year_form_outcome]");
    var select_month_outcome = $("select[name=month_form_outcome]");

    $(select_year_outcome).on("change",ChangeHtml_outcome);
    $(select_month_outcome).on("change",ChangeHtml_outcome);
    $(select_year).on("change",ChangeHtml_income);
    $(select_month).on("change",ChangeHtml_income);
})