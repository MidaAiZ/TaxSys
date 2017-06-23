/**
 * Created by Vodka on 2017/6/2.
 */
$(document).ready(function() {
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('baobiao2'));
    myChart1.showLoading({text: '正在努力的读取数据中...'  });
    var incomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);
    var outcomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);
    var date=new Date;
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    var endTime = year +"-"+ month +"-31";
    var startTime;
    if(month==12)startTime = year +"-01-01";
    else startTime = (year-1) + "-" + (month+1) + "-01";
    $.ajax({
        type: "get",
        url: "/incomes/list?beginTime="+startTime+"&endTime="+endTime,
        dataType: "json",
        success: function(data) {
            incomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);
            outcomeArray = new Array(0,0,0,0,0,0,0,0,0,0,0,0);
            var list = data.incomeList;
            $.each(list,function(i,p){
                // console.log(p.taxDate);
                var  str = p.taxDate;
                var  d   = new Date(str.replace(/-/, "/"));
                // console.log(d.getMonth());
                var  mm  = d.getMonth();
                incomeArray[mm]+=p.money;
            });
        }
    })
    $.ajax({
        type: "get",
        url: "/outcomes/list?beginTime="+startTime+"&endTime="+endTime,
        dataType: "json",
        success: function(data) {
            var list = data.outcomeList;
            $.each(list,function(i,p){
                // console.log(p.taxDate);
                var  str = p.taxDate;
                var  d   = new Date(str.replace(/-/, "/"));
                // console.log(d.getMonth());
                var  mm  = d.getMonth();
                outcomeArray[mm]+=p.money;
            });
        }
    })
    $.ajax({
        type: "get",
        url: "/outcomes/list?beginTime="+startTime+"&endTime="+endTime,
        dataType: "json",
        success: function(data) {

            var dataArr = new Array(12);//总额
            var dataArr_1 = new Array(12);//进项
            var dataArr_2 = new Array(12);//销项
            for (var i = 11;i >=0; i--) {
                if((((month-i)+12)%12)!=0){
                    dataArr[11-i]=incomeArray[(((month-i)+12)%12)-1]+outcomeArray[(((month-i)+12)%12)-1];
                    dataArr_1[11-i]=incomeArray[(((month-i)+12)%12)-1];
                    dataArr_2[11-i]=outcomeArray[(((month-i)+12)%12)-1];
                }
                else{
                    dataArr[11-i] = incomeArray[11]+outcomeArray[11];
                    dataArr_1[11-i] = incomeArray[11];
                    dataArr_2[11-i] = outcomeArray[11];
                }
            }

            var myChart1 = echarts.init(document.getElementById('baobiao2'));
            var xData = function () {
                var data = [];
                for (var i = 11;i >=0; i--) {
                    if(((month-i)+12)%12!=0) data.push(((month-i)+12)%12+ "月份");
                    else data.push(12+ "月份");
                }
                return data;
            }()
            var option = {
                "title": {
                    "text": "近12月份进销项数据对比（金额/万元）",
                    x: "4%",

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
                    "data": dataArr_1
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
                        "data":dataArr_2
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
                        "data": dataArr,
                    },
                ]
            }
            myChart1.hideLoading();
            myChart1.setOption(option);
        }
    })
})
