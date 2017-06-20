/**
 * Created by Vodka on 2017/6/8.
 */

$(document).ready(function () {

    $.ajax({
        type: "get",
        url: "/incomes/list?beginTime=2015-01-01",
        dataType: "json",
        success: function (data) {
            var list = data.incomeList;
            var type = "进项";
            if (list) {
                for (var i in list) {
                    $tr = $(
                        "<tr><td>" +
                        (list[i].created_at).substring(0, 4) +
                        "</td><td>" +
                        (list[i].created_at).substring(5, 7) +
                        "</td><td>" +
                        list[i].inType +
                        "</td><td>" +
                        type +
                        "</td><td>" +
                        list[i].money +
                        "</td></tr>"
                    );
                    // console.log($tr);
                    $(list).append($tr);
                }
            } else {  // 沒有插入数据
                alert("没有导入任何数据！");
            }
        },
        error: function () {
            alert(result.error);
        },
        cache: false,
        contentType: false,
        processData: false
        // });
    })
})

    // $.ajax({
    //     type: "get",
    //     url: "/outcomes/list?beginTime=2015-01-01",
    //     dataType: "json",
    //     success : function(data) {
    //         var $result = $("#result");
    //         var $list = $result.find("tbody");
    //         var list = data.outcomeList;
    //         var type = "销项";
    //         $result.show()
    //         if (list) {
    //             for(var i in list) {
    //                 $tr = $(
    //                     "<tr><td>" +
    //                     (list[i].created_at).substring(0,4) +
    //                     "</td><td>" +
    //                     (list[i].created_at).substring(5,7) +
    //                     "</td><td>" +
    //                     list[i].inType+
    //                     "</td><td>" +
    //                     type +
    //                     "</td><td>" +
    //                     list[i].money +
    //                     "</td></tr>"
    //                 );
    //                 console.log($tr);
    //                 $list.append($tr);
    //             }
    //         } else {  // 沒有插入数据
    //             alert("没有导入任何数据！");
    //         }
    //     },
    //     error : function() {
    //         alert( result.error);
    //     },
    //     cache : false,
    //     contentType : false,
    //     processData : false
    // });

    // $ele.on("click", "p", function() {
    //     alert($(this).data("value"))
    // })

    // var page = $(".pagination");
    // page.on("click", "a", function() {
    //     alert(window.location.href + "&page=" + $(this).html());
    // })
// })
//
//
// var User1 = function(){
//
//     var _ensure = $("input[name=submit]");
//     $(_ensure).on("click", function(){
//         alert("!!!")
//         var url;
//         var start_year="",end_year="",start_month="",end_month="",things_type="",start_time="",end_time="";
//         var str4 = $("select[name=item]").val();//进销项
//         var str3 = $("select[name=type]").val();//类型
//         if(str3!=0)
//         var str2 = $("select[name=month]").val();//月份
//         if(str2!=0)start_month = str2;
//         var str1 = $("select[name=year]").val();//年份
//         if(str1!=0){
//             start_year = str1;
//             if(str2=0){
//                 start_time = start_year + "-" + "01" + "-" + "01";
//                 end_time   = start_year + "-" + "12" + "-" + "31";
//             }
//             else{
//                 start_time = start_year + "-" + str2 + "-" + "01";
//                 end_time   = start_year + "-" + str2 + "-" + "31";
//             }
//         }
//         switch (str4){
//             case 0:{// 进项和销项都有
//                 str4 =
//                 $.ajax({
//                     url : url,
//                     type : "get",
//                     dataType : "json",
//                     success : function(result) {
//                         var $result = $("#result");
//                         var $list = $result.find("tbody");
//                         var list = result.incomes || result.outcomes;
//                         var type = "";
//                         $result.show()
//                         if (list) {
//                             for(var i in list) {
//                                 if (result.incomes) {
//                                     console.log(list[i]);
//                                     type = list[i].inType;
//                                 }else if (result.outcomes) {
//                                     console.log(list[i]);
//                                     type = list[i].outType;
//                                 }
//                                 $tr = $(
//                                     "<tr><td>" +
//                                     list[i].taxId +
//                                     "</td><td>" +
//                                     type        +
//                                     "</td><td>" +
//                                     list[i].money +
//                                     "</td><td>" +
//                                     list[i].created_at +
//                                     "</td></tr>"
//                                 );
//                                 console.log($tr);
//                                 $list.append($tr);
//                             }
//                         } else {  // 沒有插入数据
//                             alert("没有导入任何数据！");
//                         }
//                     },
//                     error : function() {
//                         alert( result.error);
//                     },
//                     cache : false,
//                     contentType : false,
//                     processData : false
//                 });
//             }
//             case 1:{// 只有进项
//                 url = "/incomes/list?beginTime="+start_time+"&endTime="+end_time;
//                 $.ajax({
//                     url : url,
//                     type : 'get',
//                     data : formData,
//                     success : function(result) {
//                         var $result = $("#result2");
//                         var $list = $result.find("tbody");
//                         var list = result.incomes || result.outcomes;
//                         var type = "";
//                         $result.show()
//                         if (list) {
//                             for(var i in list) {
//                                 if (result.incomes) {
//                                     console.log(list[i]);
//                                     type = list[i].inType;
//                                 }else if (result.outcomes) {
//                                     console.log(list[i]);
//                                     type = list[i].outType;
//                                 }
//                                 $tr = $(
//                                     "<tr><td>" +
//                                     list[i].taxId +
//                                     "</td><td>" +
//                                     type        +
//                                     "</td><td>" +
//                                     list[i].money +
//                                     "</td><td>" +
//                                     list[i].created_at +
//                                     "</td></tr>"
//                                 );
//                                 console.log($tr);
//                                 $list.append($tr);
//                             }
//                         } else {  // 沒有插入数据
//                             alert("没有导入任何数据！");
//                         }
//                     },
//                     error : function() {
//                         alert( result.error);
//                     },
//                     cache : false,
//                     contentType : false,
//                     processData : false
//                 });
//             }
//             case 2:{
//
//             }
//         }
//
//
//     })
//
//
//
//
//     // this.init = function(){
//     //
//     //     //模拟上传excel
//     //     $("#uploadEventBtn1").unbind("click").bind("click",function(){
//     //         $("#uploadEventFile1").click();
//     //     });
//     //     $("#uploadEventFile1").bind("change",function(){
//     //         $("#uploadEventPath1").attr("value",$("#uploadEventFile1").val());
//     //     });
//     //
//     // };
//     // //点击上传按钮
//     // this.uploadBtn = function(){
//     //     var uploadEventFile = $("#uploadEventFile1").val();
//     //     if(uploadEventFile == ''){
//     //         alert("请选择excel,再上传");
//     //     }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
//     //         alert("只能上传Excel文件");
//     //     }else{
//     //         var url = '/incomes/upload/';
//     //         var formData = new FormData($('#form1-2')[0]);
//     //         user1.sendAjaxRequest(url,'POST',formData);
//     //     }
//     // };
//     //
//     // this.sendAjaxRequest = function(url,type,data){
//     //     $.ajax({
//     //         url : url,
//     //         type : type,
//     //         data : data,
//     //         success : function(result) {
//     //             var $result = $("#result1");
//     //             var $list = $result.find("tbody");
//     //             var list = result.incomes || result.outcomes;
//     //             var type = "";
//     //             $result.show()
//     //             if (list) {
//     //                 for(var i in list) {
//     //                     if (result.incomes) {
//     //                         console.log(list[i]);
//     //                         type = list[i].inType;
//     //                     }else if (result.outcomes) {
//     //                         console.log(list[i]);
//     //                         type = list[i].outType;
//     //                     }
//     //                     $tr = $(
//     //                         "<tr><td>" +
//     //                         list[i].taxId +
//     //                         "</td><td>" +
//     //                         type        +
//     //                         "</td><td>" +
//     //                         list[i].money +
//     //                         "</td><td>" +
//     //                         list[i].created_at +
//     //                         "</td></tr>"
//     //                     );
//     //                     console.log($tr);
//     //                     $list.append($tr);
//     //                 }
//     //             } else {  // 沒有插入数据
//     //                 alert("没有导入任何数据！");
//     //             }
//     //         },
//     //         error : function() {
//     //             alert( result.error);
//     //         },
//     //         cache : false,
//     //         contentType : false,
//     //         processData : false
//     //     });
//     // };
// }
//
// var user1;
// $(function(){
//     user1 = new User1();
// });
