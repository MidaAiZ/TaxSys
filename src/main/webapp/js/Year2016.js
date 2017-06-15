/**
 * Created by Vodka on 2017/6/2.
 */
$(document).ready(function() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('baobiao2'));
    myChart.showLoading({text: '正在努力的读取数据中...'  });
    var Jan_income=0,Jan_outcome=0,
        Feb_income=0,Feb_outcome=0,
        Mar_income=0,Mar_outcome=0,
        Apr_income=0,Apr_outcome=0,
        May_income=0,May_outcome=0,
        June_income=0,June_outcome=0,
        July_income=0,July_outcome=0,
        Aug_income=0,Aug_outcome=0,
        Sep_income=0,Sep_outcome=0,
        Oct_income=0,Oct_outcome=0,
        Nov_income=0,Nov_outcome=0,
        Dec_income=0,Dec_outcome=0;
    $.ajax({
        type: "get",
        url: "/incomes/list?beginTime=2016-01-01&endTime=2016-12-31",
        dataType: "json",
        success: function(data) {
            var list = data.incomeList;
            $.each(list,function(i,p){
                // console.log(p.created_at);
                var  str = p.created_at;
                var  d   = new Date(str.replace(/-/, "/"));
                // console.log(d.getMonth());
                var  mm  = d.getMonth();
                switch(mm){
                    case 0:{
                        Jan_income += p.money;
                        break;
                    }
                    case 1:{
                        Feb_income += p.money;
                        break;
                    }
                    case 2:{
                        Mar_income += p.money;
                        break;
                    }
                    case 3:{
                        Apr_income += p.money;
                        break;
                    }
                    case 4:{
                        May_income += p.money;
                        break;
                    }
                    case 5:{
                        June_income += p.money;
                        break;
                    }
                    case 6:{
                        July_income += p.money;
                        break;
                    }
                    case 7:{
                        Oct_income += p.money;
                        break;
                    }
                    case 8:{
                        Sep_income += p.money;
                        break;
                    }
                    case 9:{
                        Oct_income += p.money;
                        break;
                    }
                    case 10:{
                        Nov_income += p.money;
                        break;
                    }
                    case 11:{
                        Dec_income += p.money;
                        break;
                    }
                    default:break;
                }
            });
        }
    })
    $.ajax({
        type: "get",
        url: "/outcomes/list?beginTime=2016-01-01&endTime=2016-12-31",
        dataType: "json",
        success: function(data) {
            var list = data.outcomeList;
            $.each(list,function(i,p){
                // console.log(p.created_at);
                var  str = p.created_at;
                var  d   = new Date(str.replace(/-/, "/"));
                // console.log(d.getMonth());
                var  mm  = d.getMonth();
                switch(mm){
                    case 0:{
                        Jan_outcome += p.money;
                        break;
                    }
                    case 1:{
                        Feb_outcome += p.money;
                        break;
                    }
                    case 2:{
                        Mar_outcome += p.money;
                        break;
                    }
                    case 3:{
                        Apr_outcome += p.money;
                        break;
                    }
                    case 4:{
                        May_outcome += p.money;
                        break;
                    }
                    case 5:{
                        June_outcome += p.money;
                        break;
                    }
                    case 6:{
                        July_outcome += p.money;
                        break;
                    }
                    case 7:{
                        Oct_outcome += p.money;
                        break;
                    }
                    case 8:{
                        Sep_outcome += p.money;
                        break;
                    }
                    case 9:{
                        Oct_outcome += p.money;
                        break;
                    }
                    case 10:{
                        Nov_outcome += p.money;
                        break;
                    }
                    case 11:{
                        Dec_outcome += p.money;
                        break;
                    }
                    default:break;
                }
            });
        }
    })
    $.ajax({
        type: "get",
        url: "/outcomes/list?beginTime=2016-01-01&endTime=2016-12-31",
        dataType: "json",
        success: function(data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart1 = echarts.init(document.getElementById('baobiao2'));
            var xData = function () {
                var data = [];
                for (var i = 1; i < 13; i++) {
                    data.push(i + "月份");
                }
                return data;
            }();
            myChart.hideLoading();
            var option = {
                "title": {
                    "text": "2016年进销项数据对比",
                    x: "4%",

                    textStyle: {
                        color: '#90979c',
                        fontSize: '22'
                    },
                    subtextStyle: {
                        color: '#90979c',
                        fontSize: '16',

                    },
                },
                "tooltip": {
                    "trigger": "axis",
                    "axisPointer": {
                        "type": "shadow",
                        textStyle: {
                            color: "#fff"
                        }

                    },
                },
                "grid": {
                    "borderWidth": 0,
                    "top": 110,
                    "bottom": 95,
                    textStyle: {
                        color: "#fff"
                    }
                },
                "legend": {
                    x: '4%',
                    top: '11%',
                    textStyle: {
                        color: '#90979c',
                    },
                    "data": ['进项', '销项', '平均']
                },


                "calculable": true,
                "xAxis": [{
                    "type": "category",
                    "axisLine": {
                        lineStyle: {
                            color: '#90979c'
                        }
                    },
                    "splitLine": {
                        "show": false
                    },
                    "axisTick": {
                        "show": false
                    },
                    "splitArea": {
                        "show": false
                    },
                    "axisLabel": {
                        "interval": 0,

                    },
                    "data": xData,
                }],
                "yAxis": [{
                    "type": "value",
                    "splitLine": {
                        "show": false
                    },
                    "axisLine": {
                        lineStyle: {
                            color: '#90979c'
                        }
                    },
                    "axisTick": {
                        "show": false
                    },
                    "axisLabel": {
                        "interval": 0,

                    },
                    "splitArea": {
                        "show": false
                    },

                }],
                "dataZoom": [{
                    "show": true,
                    "height": 30,
                    "xAxisIndex": [
                        0
                    ],
                    bottom: 30,
                    "start": 10,
                    "end": 80,
                    handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
                    handleSize: '110%',
                    handleStyle: {
                        color: "#d3dee5",

                    },
                    textStyle: {
                        color: "#fff"
                    },
                    borderColor: "#90979c"


                }, {
                    "type": "inside",
                    "show": true,
                    "height": 15,
                    "start": 1,
                    "end": 35
                }],
                "series": [{
                    "name": "进项",
                    "type": "bar",
                    "stack": "总金额",
                    "barMaxWidth": 35,
                    "barGap": "10%",
                    "itemStyle": {
                        "normal": {
                            "color": "rgba(255,144,128,1)",
                            "label": {
                                "show": true,
                                "textStyle": {
                                    "color": "#fff"
                                },
                                "position": "insideTop",
                                formatter: function (p) {
                                    return p.value > 0 ? (p.value) : '';
                                }
                            }
                        }
                    },
                    "data": [
                        Jan_income,
                        Feb_income,
                        Mar_income,
                        Apr_income,
                        May_income,
                        June_income,
                        July_income,
                        Aug_income,
                        Sep_income,
                        Oct_income,
                        Nov_income,
                        Dec_income
                    ],
                },

                    {
                        "name": "销项",
                        "type": "bar",
                        "stack": "总金额",
                        "itemStyle": {
                            "normal": {
                                "color": "rgba(0,191,183,1)",
                                "barBorderRadius": 0,
                                "label": {
                                    "show": true,
                                    "position": "top",
                                    formatter: function (p) {
                                        return p.value > 0 ? (p.value) : '';
                                    }
                                }
                            }
                        },
                        "data": [
                            Jan_outcome,
                            Feb_outcome,
                            Mar_outcome,
                            Apr_outcome,
                            May_outcome,
                            June_outcome,
                            July_outcome,
                            Aug_outcome,
                            Sep_outcome,
                            Oct_outcome,
                            Nov_outcome,
                            Dec_outcome
                        ]
                    }, {
                        "name": "成交总金额",
                        "type": "line",
                        "stack": "总金额",
                        symbolSize: 10,
                        symbol: 'circle',
                        "itemStyle": {
                            "normal": {
                                "color": "rgba(252,230,48,1)",
                                "barBorderRadius": 0,
                                "label": {
                                    "show": true,
                                    "position": "top",
                                    formatter: function (p) {
                                        return p.value > 0 ? (p.value) : '';
                                    }
                                }
                            }
                        },
                        "data": [
                            Jan_income+Jan_outcome,
                            Feb_income+Feb_outcome,
                            Mar_income+Mar_outcome,
                            Apr_income+Apr_outcome,
                            May_income+May_outcome,
                            June_income+June_outcome,
                            July_income+July_outcome,
                            Aug_income+Aug_outcome,
                            Sep_income+Sep_outcome,
                            Oct_income+Oct_outcome,
                            Nov_income+Nov_outcome,
                            Dec_income+Dec_outcome
                        ]
                    },
                ]
            }

// 使用刚指定的配置项和数据显示图表。
            myChart1.setOption(option);
        }
    })
})
