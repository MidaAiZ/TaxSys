$(document).ready(function() {
    var incomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);
    var outcomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);

    //
    //
    // var myChart = echarts.init(document.getElementById('baobiao'));
    // var colors = ['#5793f3', '#d14a61', '#675bba'];
    // var  option = {
    //     color: colors,
    //     title: {
    //         "text": "年度进销项数据报表",
    //     },
    //     tooltip: {
    //         trigger: 'axis',
    //         axisPointer: {type: 'cross'}
    //     },
    //     grid: {
    //         right: '20%'
    //     },
    //     toolbox: {
    //         feature: {
    //             dataView: {show: true, readOnly: false},
    //             restore: {show: true},
    //             saveAsImage: {show: true}
    //         }
    //     },
    //     legend: {
    //         data:['进项','销项','利润']
    //     },
    //     xAxis: [
    //         {
    //             type: 'category',
    //             axisTick: {
    //                 alignWithLabel: true
    //             },
    //             data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
    //         }
    //     ],
    //     yAxis: [
    //         {
    //             type: 'value',
    //             name: '进项',
    //             // min: 0,
    //             // max: 20,
    //             position: 'right',
    //             axisLine: {
    //                 lineStyle: {
    //                     color: colors[0]
    //                 }
    //             },
    //             axisLabel: {
    //                 formatter: '{value} '
    //             }
    //         },
    //         {
    //             type: 'value',
    //             name: '销项',
    //             // min: 0,
    //             // max: 100,
    //             position: 'right',
    //             offset: 80,
    //             axisLine: {
    //                 lineStyle: {
    //                     color: colors[1]
    //                 }
    //             },
    //             axisLabel: {
    //                 formatter: '{value} '
    //             }
    //         },
    //         {
    //             type: 'value',
    //             name: '利润',
    //             // min: 0,
    //             // max: 50,
    //             position: 'left',
    //             axisLine: {
    //                 lineStyle: {
    //                     color: colors[2]
    //                 }
    //             },
    //             axisLabel: {
    //                 formatter: '{value}'
    //             }
    //         }
    //     ],
    //     series: [
    //         {
    //             name:'进项',
    //             type:'bar',
    //             // data:[10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8]
    //         },
    //         {
    //             name:'销项',
    //             type:'bar',
    //             yAxisIndex: 1,
    //             // data:[47,45.4,48.3,47.3,60.4,50.2,50.2,60.4,47.3,48.3,45.4,47]
    //         },
    //         {
    //             name:'利润',
    //             type:'line',
    //             yAxisIndex: 2,
    //             // data:[36.2, 34.6, 37.5, 36.5, 49.6, 39.4, 39.4, 49.6, 36.5, 37.5, 34.6, 36.2]
    //         }
    //     ]
    // };
    // myChart.setOption(option);
    //
    //
    // var _select = $("select[name=year_two]");
    // //年度图改变
    // $(_select).on("change", function(){
    //     myChart.showLoading({text: '正在努力的读取数据中...'  });
    //     var str = $("select[name=year_two]").val();
    //     // var strr= $("select[name=month]").val();
    //     var str1= str +"-"+ "01" +"-" + "1";
    //     var str2= str +"-"+ "12" +"-" + "31";
    //     Jan_income = 0;Jan_outcome = 0;
    //     Feb_income = 0;Feb_outcome = 0;
    //     Mar_income = 0;Mar_outcome = 0;
    //     Apr_income = 0;Apr_outcome = 0;
    //     May_income = 0;May_outcome = 0;
    //     June_income = 0;June_outcome = 0;
    //     July_income = 0;July_outcome = 0;
    //     Aug_income = 0;Aug_outcome = 0;
    //     Sep_income = 0;Sep_outcome = 0;
    //     Oct_income = 0;Oct_outcome = 0;
    //     Nov_income = 0;Nov_outcome = 0;
    //     Dec_income = 0;Dec_outcome = 0;
    //     $.ajax({
    //         type: "get",
    //         url: "/incomes/list?beginTime="+str1+"&endTime="+str2,
    //         dataType: "json",
    //         success: function(data) {
    //             var list = data.incomeList;
    //             $.each(list,function(i,p){
    //                 // console.log(p.taxDate);
    //                 var  str = p.taxDate;
    //                 var  d   = new Date(str.replace(/-/, "/"));
    //                 // console.log(d.getMonth());
    //                 var  mm  = d.getMonth();
    //                 switch(mm){
    //                     case 0:{
    //                         Jan_income += p.money;
    //                         break;
    //                     }
    //                     case 1:{
    //                         Feb_income += p.money;
    //                         break;
    //                     }
    //                     case 2:{
    //                         Mar_income += p.money;
    //                         break;
    //                     }
    //                     case 3:{
    //                         Apr_income += p.money;
    //                         break;
    //                     }
    //                     case 4:{
    //                         May_income += p.money;
    //                         break;
    //                     }
    //                     case 5:{
    //                         June_income += p.money;
    //                         break;
    //                     }
    //                     case 6:{
    //                         July_income += p.money;
    //                         break;
    //                     }
    //                     case 7:{
    //                         Oct_income += p.money;
    //                         break;
    //                     }
    //                     case 8:{
    //                         Sep_income += p.money;
    //                         break;
    //                     }
    //                     case 9:{
    //                         Oct_income += p.money;
    //                         break;
    //                     }
    //                     case 10:{
    //                         Nov_income += p.money;
    //                         break;
    //                     }
    //                     case 11:{
    //                         Dec_income += p.money;
    //                         break;
    //                     }
    //                     default:break;
    //                 }
    //             });
    //         }
    //     })
    //     $.ajax({
    //         type: "get",
    //         url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
    //         dataType: "json",
    //         success: function(data) {
    //             var list = data.outcomeList;
    //             $.each(list,function(i,p){
    //                 // console.log(p.taxDate);
    //                 var  str = p.taxDate;
    //                 var  d   = new Date(str.replace(/-/, "/"));
    //                 // console.log(d.getMonth());
    //                 var  mm  = d.getMonth();
    //                 switch(mm){
    //                     case 0:{
    //                         Jan_outcome += p.money;
    //                         break;
    //                     }
    //                     case 1:{
    //                         Feb_outcome += p.money;
    //                         break;
    //                     }
    //                     case 2:{
    //                         Mar_outcome += p.money;
    //                         break;
    //                     }
    //                     case 3:{
    //                         Apr_outcome += p.money;
    //                         break;
    //                     }
    //                     case 4:{
    //                         May_outcome += p.money;
    //                         break;
    //                     }
    //                     case 5:{
    //                         June_outcome += p.money;
    //                         break;
    //                     }
    //                     case 6:{
    //                         July_outcome += p.money;
    //                         break;
    //                     }
    //                     case 7:{
    //                         Oct_outcome += p.money;
    //                         break;
    //                     }
    //                     case 8:{
    //                         Sep_outcome += p.money;
    //                         break;
    //                     }
    //                     case 9:{
    //                         Oct_outcome += p.money;
    //                         break;
    //                     }
    //                     case 10:{
    //                         Nov_outcome += p.money;
    //                         break;
    //                     }
    //                     case 11:{
    //                         Dec_outcome += p.money;
    //                         break;
    //                     }
    //                     default:break;
    //                 }
    //             });
    //         }
    //     })
    //     $.ajax({
    //         type: "get",
    //         url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
    //         dataType: "json",
    //         success: function(data) {
    //             myChart.hideLoading();
    //             option = {
    //                 color: colors,
    //
    //                 tooltip: {
    //                     trigger: 'axis',
    //                     axisPointer: {type: 'cross'}
    //                 },
    //                 grid: {
    //                     right: '20%'
    //                 },
    //                 toolbox: {
    //                     feature: {
    //                         dataView: {show: true, readOnly: false},
    //                         restore: {show: true},
    //                         saveAsImage: {show: true}
    //                     }
    //                 },
    //                 legend: {
    //                     data:['进项','销项','利润']
    //                 },
    //                 xAxis: [
    //                     {
    //                         type: 'category',
    //                         axisTick: {
    //                             alignWithLabel: true
    //                         },
    //                         data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
    //                     }
    //                 ],
    //                 yAxis: [],
    //                 series: [
    //                     {
    //                         name:'进项',
    //                         type:'bar',
    //                         data:[ Jan_income,
    //                             Feb_income,
    //                             Mar_income,
    //                             Apr_income,
    //                             May_income,
    //                             June_income,
    //                             July_income,
    //                             Aug_income,
    //                             Sep_income,
    //                             Oct_income,
    //                             Nov_income,
    //                             Dec_income
    //                         ]
    //                     },
    //                     {
    //                         name:'销项',
    //                         type:'bar',
    //                         yAxisIndex: 1,
    //                         data:[ Jan_outcome,
    //                             Feb_outcome,
    //                             Mar_outcome,
    //                             Apr_outcome,
    //                             May_outcome,
    //                             June_outcome,
    //                             July_outcome,
    //                             Aug_outcome,
    //                             Sep_outcome,
    //                             Oct_outcome,
    //                             Nov_outcome,
    //                             Dec_outcome
    //                         ]
    //                     },
    //                     {
    //                         name:'利润',
    //                         type:'line',
    //                         yAxisIndex: 2,
    //                         data:[  Jan_income-Jan_outcome,
    //                             Feb_income-Feb_outcome,
    //                             Mar_income-Mar_outcome,
    //                             Apr_income-Apr_outcome,
    //                             May_income-May_outcome,
    //                             June_income-June_outcome,
    //                             July_income-July_outcome,
    //                             Aug_income-Aug_outcome,
    //                             Sep_income-Sep_outcome,
    //                             Oct_income-Oct_outcome,
    //                             Nov_income-Nov_outcome,
    //                             Dec_income-Dec_outcome
    //                         ]
    //                     }
    //                 ]
    //             };
    //             myChart.setOption(option);
    //         }
    //     })
    //
    // })
    //

    //xxxx年度进销项统计
    var myChart2 = echarts.init(document.getElementById('baobiao2'));
    var option2 = {
        title: {
            text: '年度进销项统计表（金额/万元）'
        },
        tooltip: {},
        legend: {
            data: ['进项', '销项','利润']
        },
        xAxis: {
            data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
        },
        yAxis: {},
        series: [{
            name: '进项',
            type: 'bar',
            // data: [10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8,10.8]
        }, {
            name: '销项',
            type: 'bar',
            // data: [47,45.4,48.3,47.3,60.4,50.2,50.2,60.4,47.3,48.3,45.4,47]
        },{
            name:'利润',
            type:'line',
            // data:[  Jan_income-Jan_outcome,
            //     Feb_income-Feb_outcome,
            //     Mar_income-Mar_outcome,
            //     Apr_income-Apr_outcome,
            //     May_income-May_outcome,
            //     June_income-June_outcome,
            //     July_income-July_outcome,
            //     Aug_income-Aug_outcome,
            //     Sep_income-Sep_outcome,
            //     Oct_income-Oct_outcome,
            //     Nov_income-Nov_outcome,
            //     Dec_income-Dec_outcome
            // ]
        }]
    };
    myChart2.setOption(option2);

    var _select3 = $("select[name=year_two]")

    //年度图改变
    $(_select3).on("change", function () {
        myChart2.showLoading({text: '正在努力的读取数据中...'});
        var str = $("select[name=year_two]").val();
        // var strr= $("select[name=month]").val()
        var str1 = str + "-" + "01" + "-" + "1";
        var str2 = str + "-" + "12" + "-" + "31";
        // var _date1 = new Date(str1.replace(/-/, "/"));
        // var _date2 = new Date(str2.replace(/-/, "/"));
        // alert(_date1 + _date2);
        incomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);
        outcomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);

        $.ajax({
            type: "get",
            url: "/incomes/list?beginTime=" + str1 + "&endTime=" + str2,
            dataType: "json",
            success: function (data) {
                var list = data.incomeList;
                $.each(list, function (i, p) {
                    // console.log(p.taxDate);
                    var str = p.taxDate;
                    var d = new Date(str.replace(/-/, "/"));
                    // console.log(d.getMonth());
                    var mm = d.getMonth();
                    incomeArray[mm]+=p.money;
                });
            }
        })
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime=" + str1 + "&endTime=" + str2,
            dataType: "json",
            success: function (data) {
                var list = data.outcomeList;
                $.each(list, function (i, p) {
                    // console.log(p.taxDate);
                    var str = p.taxDate;
                    var d = new Date(str.replace(/-/, "/"));
                    // console.log(d.getMonth());
                    var mm = d.getMonth();
                    outcomeArray[mm]+=p.money;
                });
            }
        })
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime=" + str1 + "&endTime=" + str2,
            dataType: "json",
            success: function (data) {
                option2 = {
                    title: {
                        text: '年度进销项统计表（金额/万元）'
                    },
                    tooltip: {},
                    legend: {
                        data: ['进项', '销项','利润']
                    },
                    xAxis: {
                        data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
                    },
                    yAxis: {},
                    series: [{
                        name: '进项',
                        type: 'bar',
                        data: incomeArray,
                    }, {
                        name: '销项',
                        type: 'bar',
                        data: outcomeArray,
                    },
                    {
                        name:'利润',
                        type:'line',
                        data:[
                            outcomeArray[0] -incomeArray[0],
                            outcomeArray[1] -incomeArray[1],
                            outcomeArray[2] -incomeArray[2],
                            outcomeArray[3] -incomeArray[3],
                            outcomeArray[4] -incomeArray[4],
                            outcomeArray[5] -incomeArray[5],
                            outcomeArray[6] -incomeArray[6],
                            outcomeArray[7] -incomeArray[7],
                            outcomeArray[8] -incomeArray[8],
                            outcomeArray[9] -incomeArray[9],
                            outcomeArray[10]-incomeArray[10],
                            outcomeArray[11]-incomeArray[11]
                        ]
                    }]
                };
                myChart2.hideLoading();
                myChart2.setOption(option2);
            }
        })
    })

})