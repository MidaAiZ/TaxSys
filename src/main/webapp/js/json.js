LIMIT = 10;
CONDITION = "2010-09-09"

//获取json数据
function getJson(page, limit,CONDITION) {
    var siteList={"incomeList":[]};
    var page = page  ? page : 1;
    var limit = limit ? limit : 10;

    $.ajax({
        type: "get",
        url: "/incomes/list?page="+ page +"&limit=" + limit + "&beginTime=" + CONDITION,
        dataType: "json",
        success : function(data) {
            var result = "select distinct inType from income"
            siteList = data.incomeList;
            var type = "进项";
            if (siteList) {
                OutputHtml(siteList);
            }
            else {  // 沒有插入数据
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

    $(".pagination").on("click", "a", function() {
        $this = $(this)
        Gotopage($this.data("value"), LIMIT,CONDITION);
        $(this).addClass('active').siblings().removeClass('active');
    })
}

//生成翻页表
function createdPre(page,limit,CONDITION) {

    var count =26;
    var pages = Math.ceil(count/limit);
    if(page < 1)page = 1;  //如果当前页码小于1
    if(page > pages)page = pages; //如果当前页码大于总数

    if(!(page <= pages)) page = pages;
    // 分页
    if(page > 1 && page !== 1){Temp ="<a href='javascript:void(0)' onclick='Gotopage(1,LIMIT,CONDITION)'>&lt;&lt;Index</a> <a href='javascript:void(0)' onclick='Gotopage(" + Math.ceil((page - 1)) + " ," + LIMIT+ " ," + CONDITION  +  ")'>previous</a>&nbsp;"}else{Temp = "&lt;&lt;Index previous&nbsp;"};
    // 完美的翻页列表
    var pageFrontSum = 3; //当页前显示个数
    var pageBackSum = 3; //当页后显示个数

    var pageFront = pageFrontSum - (page - 1);
    var pageBack = pageBackSum - (pages - page);
    if(pageFront > 0 && pageBack < 0)pageBackSum += pageFront; //前少后多，前剩余空位给后
    if(pageBack > 0 && pageFront < 0)pageFrontSum += pageBack; //后少前多，后剩余空位给前
    var pageFrontBegin = page - pageFrontSum;
    if(pageFrontBegin < 1)pageFrontBegin = 1;
    var pageFrontEnd = page + pageBackSum;
    if(pageFrontEnd > pages)pageFrontEnd = pages;

    if(pageFrontBegin != 1) Temp += '<a href="javascript:void(0)" onclick="Gotopage(' + Math.ceil((page - 10)) + " ," + LIMIT+ " ," + CONDITION + ')" title="前10页">..</a>';

    for(var i = pageFrontBegin;i < page;i ++){
        Temp += " <a href='javascript:void(0)' onclick='Gotopage(" + Math.ceil(i)  + ',' + LIMIT+ ',' + CONDITION  + ")'>" + i + "</a>";
    }

    Temp += " <strong class='f90'>" + page + "</strong>";
    for(var i = page + 1;i <= pageFrontEnd;i ++){
        Temp += " <a href='javascript:void(0)' onclick='Gotopage(" + Math.ceil(i)  + ',' + LIMIT+ ',' + CONDITION  + ")'>" + i + "</a>";
    }

    if(pageFrontEnd != pages) Temp += " <a href='javascript:void(0)' onclick='Gotopage(" + Math.ceil((page + 10)) + ',' + LIMIT + ',' + CONDITION + ")' title='后10页'>..</a>";
    if(page != pages){Temp += "&nbsp;&nbsp;<a href='javascript:void(0)' onclick='Gotopage(" + Math.ceil((page + 1)) + ',' + LIMIT + ',' + CONDITION  + ")'>Next</a> <a href='javascript:void(0)' onclick='Gotopage(" + Math.ceil(pages) + ',' + LIMIT+ ',' + CONDITION  + ")'>Last&gt;&gt;</a>"}else{Temp += "&nbsp;&nbsp;Next Last&gt;&gt;"}
    $("#pagelist").append(Temp);

}

//翻页
function Gotopage(num, limit ,CONDITION ){ //跳转页
    page = num;
    $("#pagelist").empty();
    getJson(page, limit,CONDITION)
    createdPre(page, limit, CONDITION);
}

//增加表格数据
function OutputHtml(sites) {

    $content = $("#content");
    $("td").remove()
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


$(document).ready(function() {
    getJson(1, LIMIT, "2010-09-09");
    createdPre(1, LIMIT, "2010-09-09");

    //ajax获取下拉表商品类型



    $("#require-btn").on("click",function () {
        $("#pagelist").empty();
        getJson(1, LIMIT, "2010-09-09");
        createdPre(1, LIMIT, "2010-09-09");
        var message = "<h3>导入成功！</h3><br/>";
        alertify.alert(message);
    })
})



    // var obj = eval(siteList);  //获取JSON
    // var sites = obj.incomeList;

    //获取分页总数
    // var pages = Math.floor((sites.length - 1) / limit) + 1;
    //
    // if(page < 1)page = 1;  //如果当前页码小于1
    // if(page > pages)page = pages; //如果当前页码大于总数
    // var Temp = "";
    //
    // var BeginNO = (page - 1) * limit + 1; //开始编号
    // var EndNO = page * limit; //结束编号
    // if(EndNO > sites.length) EndNO = sites.length;
    // if(EndNO == 0) BeginNO = 0;
    //
    // if(!(page <= pages)) page = pages;
    // $("total").innerHTML = "Total:<strong class='f90'>" + sites.length + "</strong>&nbsp;&nbsp;Show:<strong class='f90'>" + BeginNO + "-" + EndNO + "</strong>";
    //
    // //分页
    // if(page > 1 && page !== 1){Temp ="<a href='javascript:void(0)' onclick='Gotopage(1)'>&lt;&lt;Index</a> <a href='javascript:void(0)' onclick='Gotopage(" + (page - 1) + ")'>previous</a>&nbsp;"}else{Temp = "&lt;&lt;Index previous&nbsp;"};
    //
    //完美的翻页列表
    // var pageFrontSum = 3; //当页前显示个数
    // var pageBackSum = 3; //当页后显示个数
    //
    // var pageFront = pageFrontSum - (page - 1);
    // var pageBack = pageBackSum - (pages - page);
    // if(pageFront > 0 && pageBack < 0)pageBackSum += pageFront; //前少后多，前剩余空位给后
    // if(pageBack > 0 && pageFront < 0)pageFrontSum += pageBack; //后少前多，后剩余空位给前
    // var pageFrontBegin = page - pageFrontSum;
    // if(pageFrontBegin < 1)pageFrontBegin = 1;
    // var pageFrontEnd = page + pageBackSum;
    // if(pageFrontEnd > pages)pageFrontEnd = pages;
    //
    // if(pageFrontBegin != 1) Temp += '<a href="javascript:void(0)" onclick="Gotopage(' + (page - 10) + ')" title="前10页">..</a>';
    // for(var i = pageFrontBegin;i < page;i ++){
    //     Temp += " <a href='javascript:void(0)' onclick='Gotopage(" + i + ")'>" + i + "</a>";
    // }
    // Temp += " <strong class='f90'>" + page + "</strong>";
    // for(var i = page + 1;i <= pageFrontEnd;i ++){
    //     Temp += " <a href='javascript:void(0)' onclick='Gotopage(" + i + ")'>" + i + "</a>";
    // }
    // if(pageFrontEnd != pages) Temp += " <a href='javascript:void(0)' onclick='Gotopage(" + (page + 10) + ")' title='后10页'>..</a>";
    //
    // if(page != pages){Temp += "&nbsp;&nbsp;<a href='javascript:void(0)' onclick='Gotopage(" + (page + 1) + ");'>Next</a> <a href='javascript:void(0)' onclick='Gotopage(" + pages + ")'>Last&gt;&gt;</a>"}else{Temp += "&nbsp;&nbsp;Next Last&gt;&gt;"}
    //
    // $("pagelist").innerHTML = Temp;
    //
    // //输出数据
    //
    // if(EndNO == 0){ //如果为空
    //     $("content").innerHTML += "<h1>No Images</h1>";
    //     return;
    // }
    // var html = "";
    // var type = "进项";
    //
    // for(var i = BeginNO - 1;i < EndNO;i ++){
    //     html += "<div class='entry' style='width: 100%'>";
    //     html +=  "<tr><td>" +
    //         (sites[i].taxDate).substring(0,4) +
    //         "</td><td>" +
    //         (sites[i].taxDate).substring(5,7) +
    //         "</td><td>" +
    //         sites[i].inType+
    //         "</td><td>" +
    //         type  +
    //         "</td><td>" +
    //         sites[i].money +
    //         "</td></tr>"
    //     html += "</div>";
    //
    // }
    // $("content").innerHTML = html;
    // clickShow(); //调用鼠标点击事件
    //
    // //键盘左右键翻页
    // document.onkeydown=function(e){
    //     var theEvent = window.event || e;
    //     var code = theEvent.keyCode || theEvent.which;
    //     if(code==37){
    //         if(page > 1 && page !== 1){
    //             Gotopage(page - 1);
    //
    //         }
    //     }
    //     if(code==39){
    //         if(page != pages){
    //             Gotopage(page + 1);
    //         }
    //     }
    // }
    //
    //
    // //鼠标滚轮翻页
    // function handle(delta){
    //     if (delta > 0){
    //         if(page > 1 && page !== 1){
    //             Gotopage(page - 1);
    //         }
    //     }
    //     else{
    //         if(page != pages){
    //             Gotopage(page + 1);
    //         }
    //     }
    // }
    //
    // function wheel(event){
    //     var delta = 0;
    //     if (!event) /* For IE. */
    //         event = window.event;
    //     if (event.wheelDelta) { /* IE或者Opera. */
    //         delta = event.wheelDelta / 120;
    //         /** 在Opera9中，事件处理不同于IE
    //          */
    //         if (window.opera)
    //             delta = -delta;
    //     } else if (event.detail) { /** 兼容Mozilla. */
    //         /** In Mozilla, sign of delta is different than in IE.
    //          * Also, delta is multiple of 3.
    //          */
    //         delta = -event.detail / 3;
    //     }
    //     /** 如果 增量不等于0则触发
    //      * 主要功能为测试滚轮向上滚或者是向下
    //      */
    //     if (delta)
    //         handle(delta);
    // }
    //
    // /** 初始化 */
    // if (window.addEventListener)
    //     /** Mozilla的基于DOM的滚轮事件 **/
    //     window.addEventListener("DOMMouseScroll", wheel, false);
    // /** IE/Opera. */
    // window.onmousewheel = document.onmousewheel = wheel;
    //

//
// var siteList = {"incomeList":[
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"},
//     {"id": "E5619E478E9E41AA", "taxId": "42432", "inType": "纯净水", "money": 4324.0, "taxDate": "2017-01-31"},
//     {"id":"4731D0DCD2DD41EA","taxId":"123123","inType":"花生油","money":123324.0,"taxDate":"2017-01-23"}
// ]}