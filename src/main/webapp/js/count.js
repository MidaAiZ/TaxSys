/**
 * Created by Vodka on 2017/6/7.
 */
$(document).ready(function() {

    //月度进项扇形图
    var myChart3 = echarts.init(document.getElementById('main1'));
    var option3 = {
        backgroundColor: '',
        title: {
            text: '进项数据扇形图'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {

            orient: 'vertical',
            x: 'right',
            itemWidth: 14,
            itemHeight: 14,
            align: 'left',

            data:['花生油','鸡肉','鱼肉','玻璃','铁皮 ','纯净水'],
            textStyle: {
                color: '#424956'
            }
        },
        series: [
            {
                name:'进项金额',
                type:'pie',
                hoverAnimation: false,
                legendHoverLink:false,
                radius: ['40%', '42%'],
                color: ['#ffffff','#ffffff','#ffffff','#ffffff','#ffffff'],
                label: {
                    normal: {
                        position: 'inner'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                tooltip: {
                    show:false,
                },

                data:[
                    {value: 0,name:''},
                    // {value:679, name:''},
                    // {value:848, name:''},
                    // {value:348, name:''},
                    // {value:436, name:''},
                    // {value:680, name:''},
                    // {value:849, name:''},
                    // {value:349, name:''},
                    // {value:437, name:''},
                ]
            },
            {
                name:'进项金额',
                type:'pie',
                radius: ['42%', '55%'],
                color: [],
                label: {
                    normal: {
                        formatter: '{b}\n{d}%'
                    }
                },
                data:[
                    {value:0, name:''},
                    // {value:679, name:'鸡肉'},
                    // {value:848, name:'鱼肉'},
                    // {value:348, name:'玻璃'},
                    // {value:436, name:'铁皮'},
                    // {value:680, name:'食品添加剂'},
                    // {value:849, name:'纯净水'},
                    // {value:349, name:'包装纸'},
                    // {value:437, name:'猪肉'},
                ]
            }
        ]
    };
    myChart3.setOption(option3);


    //月度销项扇形图
    var myChart4 = echarts.init(document.getElementById('main2'));
    var option4 = {
        backgroundColor: '',
        title: {
            text: '销项数据扇形图'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {

            orient: 'vertical',
            x: 'right',
            itemWidth: 14,
            itemHeight: 14,
            align: 'left',

            data:['鸡肉罐头','鱼肉罐头','猪肉罐头'],
            textStyle: {
                color: '#424956'
            }
        },
        series: [
            {
                name:'销项金额',
                type:'pie',
                hoverAnimation: false,
                legendHoverLink:false,
                radius: ['40%', '42%'],
                color: ['#915872', '#3077b7', '#9a8169'],
                label: {
                    normal: {
                        position: 'inner'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }

                },
                tooltip: {
                    show:false,


                },

                data:[
                    {value:0, name:''},
                    // {value:679, name:''},
                    // {value:848, name:''},
                ]
            },
            {
                name:'销项金额',
                type:'pie',
                radius: ['42%', '55%'],
                color: ['#d74e67', '#0092ff', '#eba954'],
                label: {
                    normal: {
                        formatter: '{b}\n{d}%'
                    }

                },
                data:[
                    {value:0, name:''},
                    // {value:679, name:'鱼肉罐头'},
                    // {value:848, name:'猪肉罐头'},
                ]
            }
        ]
    };
    myChart4.setOption(option4);


    //xxxx年xx月 进销项统计
    var myChart = echarts.init(document.getElementById('baobiao1'));
    var oil=0,chicken=0,fish=0,glass=0,iron=0,water=0,chicken_can=0,fish_can=0,pork_can=0;
    var option = {
        title: {
            text: '月度进销项统计图'
        },
        tooltip: {},
        legend: {
            data: ['进项','销项']
        },
        xAxis: {
            data: ["花生油", "鸡肉", "鱼肉", "玻璃", "铁皮", "纯净水","鸡肉罐头","鱼肉罐头","猪肉罐头"]
        },
        yAxis: {},
        series: [{
            name: '进项',
            type: 'bar',
            // data: [6.5, 0.8, 1.3, 0.15, 0.85, 1.2,0,0,0]
        },{
            name: '销项',
            type: 'bar',
            // data: [0,0,0,0,0,0,8,27,12]
        }]
    };
    myChart.setOption(option);


    //xxxx年xx月 进销项总额统计
    var myChart1 = echarts.init(document.getElementById('baobiao11'));

    var option1 = {
        title: {
            text: '总额'
        },
        tooltip: {},
        legend: {
            data: ['总额']
        },
        xAxis: {
            data: ["进项","销项"]
        },
        yAxis: {},
        series: [{
            name: '总额',
            type: 'bar',
            // data: [10.8,47]
        }]
    };
    myChart1.setOption(option1);


    var _select1 = $("select[name=year_one]");
    var _select2 = $("select[name=month]");
    // var _select3 = $("select[name=year_two]")
    //年月图改变
    $(_select1).on("change", function(){
        myChart.showLoading({text: '正在努力的读取数据中...'  });
        myChart1.showLoading({text: '正在努力的读取数据中...'  });
        myChart3.showLoading({text: '正在努力的读取数据中...'  });
        myChart4.showLoading({text: '正在努力的读取数据中...'  });
        var str = $("select[name=year_one]").val();
        var strr= $("select[name=month]").val();
        var str1= str +"-"+ strr +"-" + "1";
        var str2= str +"-"+ strr +"-" + "31";
        // var _date1 = new Date(str1.replace(/-/, "/"));
        // var _date2 = new Date(str2.replace(/-/, "/"));
        // alert(str1+str2);
        $.ajax({
            type: "get",
            url: "/incomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                oil=0;chicken=0;fish=0;glass=0;iron=0;water=0;
                var list = data.incomeList;
                $.each(list,function(i,p){
                    if(p.inType=="花生油"){
                        oil += p.money;
                        // console.log(oil);
                    }
                    else if(p.inType=="鸡肉"){
                        chicken = chicken +p.money;
                    }
                    else if(p.inType=="鱼肉"){
                        fish = fish +p.money;
                    }
                    else if(p.inType=="玻璃"){
                        glass = glass +p.money;
                    }
                    else if(p.inType=="铁皮") {
                        iron = iron + p.money;
                    }
                    else if(p.inType=="纯净水"){
                        water = water +p.money;
                    }
                });
            }
        })

        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                chicken_can=0;
                fish_can=0;
                pork_can=0;
                var list = data.outcomeList;
                $.each(list,function(i,p){
                    if(p.outType=="鸡肉罐头"){
                        chicken_can += p.money;
                        // console.log(oil);
                    }
                    else if(p.outType=="鱼肉罐头"){
                        fish_can += p.money;
                    }
                    else if(p.outType=="猪肉罐头"){
                        pork_can += p.money;
                    }
                });
            }
        })

        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                myChart.hideLoading();
                myChart1.hideLoading();
                myChart3.hideLoading();
                myChart4.hideLoading();
                //月度进项扇形图
                option3 = {
                    backgroundColor: '',
                    title: {
                        text: '进项数据扇形图'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {

                        orient: 'vertical',
                        x: 'right',
                        itemWidth: 14,
                        itemHeight: 14,
                        align: 'left',

                        data:['花生油','鸡肉','鱼肉','玻璃','铁皮 ','纯净水'],
                        textStyle: {
                            color: '#424956'
                        }
                    },
                    series: [
                        {
                            name:'进项金额',
                            type:'pie',
                            hoverAnimation: false,
                            legendHoverLink:false,
                            radius: ['40%', '42%'],
                            color: ['#ffffff','#ffffff','#ffffff','#ffffff','#ffffff'],
                            label: {
                                normal: {
                                    position: 'inner'
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            tooltip: {
                                show:false,
                            },

                            data:[
                                {value:oil, name:''},
                                {value:chicken, name:''},
                                {value:fish, name:''},
                                {value:glass, name:''},
                                {value:iron, name:''},
                                {value:water, name:''},
                            ]
                        },
                        {
                            name:'进项金额',
                            type:'pie',
                            radius: ['42%', '55%'],
                            color: [ '#d74e67', '#0092ff', '#eba954', '#21b6b9','#d74e67'],
                            label: {
                                normal: {
                                    formatter: '{b}\n{d}%'
                                }
                            },
                            data:[
                                {value:oil, name:'花生油'},
                                {value:chicken, name:'鸡肉'},
                                {value:fish, name:'鱼肉'},
                                {value:glass, name:'玻璃'},
                                {value:iron, name:'铁皮'},
                                {value:water, name:'纯净水'},
                            ]
                        }
                    ]
                };
                myChart3.setOption(option3);


                //月度销项扇形图
                option4 = {
                    backgroundColor: '',
                    title: {
                        text: '销项数据扇形图'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {

                        orient: 'vertical',
                        x: 'right',
                        itemWidth: 14,
                        itemHeight: 14,
                        align: 'left',

                        data:['鸡肉罐头','鱼肉罐头','猪肉罐头'],
                        textStyle: {
                            color: '#424956'
                        }
                    },
                    series: [
                        {
                            name:'销项金额',
                            type:'pie',
                            hoverAnimation: false,
                            legendHoverLink:false,
                            radius: ['40%', '42%'],
                            color: ['#915872', '#3077b7', '#9a8169'],
                            label: {
                                normal: {
                                    position: 'inner'
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }

                            },
                            tooltip: {
                                show:false,


                            },

                            data:[
                                // {value:435, name:''},
                                // {value:679, name:''},
                                // {value:848, name:''},
                            ]
                        },
                        {
                            name:'销项金额',
                            type:'pie',
                            radius: ['42%', '55%'],
                            color: ['#d74e67', '#0092ff', '#eba954'],
                            label: {
                                normal: {
                                    formatter: '{b}\n{d}%'
                                }

                            },
                            data:[
                                {value:chicken_can, name:'鸡肉罐头'},
                                {value:fish_can, name:'鱼肉罐头'},
                                {value:pork_can, name:'猪肉罐头'},
                            ]
                        }
                    ]
                };
                myChart4.setOption(option4);


                //月度进销项图
                var option = {
                    title: {
                        text: '月度进销项统计图'
                    },
                    tooltip: {},
                    legend: {
                        data: ['进项','销项']
                    },
                    xAxis: {
                        data: ["花生油", "鸡肉", "鱼肉", "玻璃", "铁皮", "纯净水","鸡肉罐头","鱼肉罐头","猪肉罐头"]
                    },
                    yAxis: {},
                    series: [{
                        name: '进项',
                        type: 'bar',
                        data: [oil, chicken,fish, glass, iron, water,0,0,0]
                    },{
                        name: '销项',
                        type: 'bar',
                        data: [0,0,0,0,0,0,chicken_can,fish_can,pork_can]
                    }]
                };
                myChart.setOption(option);

                //进销项总额
                option1 = {
                    title: {
                        text: '总额'
                    },
                    tooltip: {},
                    legend: {
                        data: ['总额']
                    },
                    xAxis: {
                        data: ["进项","销项"]
                    },
                    yAxis: {},
                    series: [{
                        name: '总额',
                        type: 'bar',
                        data: [chicken+oil+fish+glass+iron+water,chicken_can+fish_can+pork_can]
                    }]
                };
                myChart1.setOption(option1);
            }
        })

    })
    $(_select2).on("change", function(){
        myChart.showLoading({text: '正在努力的读取数据中...'  });
        myChart1.showLoading({text: '正在努力的读取数据中...'  });
        myChart3.showLoading({text: '正在努力的读取数据中...'  });
        myChart4.showLoading({text: '正在努力的读取数据中...'  });
        var str = $("select[name=year_one]").val();
        var strr= $("select[name=month]").val();
        var str1= str +"-"+ strr +"-" + "1";
        var str2= str +"-"+ strr +"-" + "31";
        // var _date1 = new Date(str1.replace(/-/, "/"));
        // var _date2 = new Date(str2.replace(/-/, "/"));
        // alert(str1+str2);
        $.ajax({
            type: "get",
            url: "/incomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                oil=0;chicken=0;fish=0;glass=0;iron=0;water=0;
                var list = data.incomeList;
                $.each(list,function(i,p){
                    if(p.inType=="花生油"){
                        oil += p.money;
                        // console.log(oil);
                    }
                    else if(p.inType=="鸡肉"){
                        chicken = chicken +p.money;
                    }
                    else if(p.inType=="鱼肉"){
                        fish = fish +p.money;
                    }
                    else if(p.inType=="玻璃"){
                        glass = glass +p.money;
                    }
                    else if(p.inType=="铁皮") {
                        iron = iron + p.money;
                    }
                    else if(p.inType=="纯净水"){
                        water = water +p.money;
                    }
                });
            }
        })

        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                chicken_can=0;
                fish_can=0;
                pork_can=0;
                var list = data.outcomeList;
                $.each(list,function(i,p){
                    if(p.outType=="鸡肉罐头"){
                        chicken_can += p.money;
                        // console.log(oil);
                    }
                    else if(p.outType=="鱼肉罐头"){
                        fish_can += p.money;
                    }
                    else if(p.outType=="猪肉罐头"){
                        pork_can += p.money;
                    }
                });
            }
        })

        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                myChart.hideLoading();
                myChart1.hideLoading();
                myChart3.hideLoading();
                myChart4.hideLoading();
                //月度进项扇形图
                option3 = {
                    backgroundColor: '',
                    title: {
                        text: '进项数据扇形图'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {

                        orient: 'vertical',
                        x: 'right',
                        itemWidth: 14,
                        itemHeight: 14,
                        align: 'left',

                        data:['花生油','鸡肉','鱼肉','玻璃','铁皮 ','纯净水'],
                        textStyle: {
                            color: '#424956'
                        }
                    },
                    series: [
                        {
                            name:'进项金额',
                            type:'pie',
                            hoverAnimation: false,
                            legendHoverLink:false,
                            radius: ['40%', '42%'],
                            color: ['#ffffff','#ffffff','#ffffff','#ffffff','#ffffff'],
                            label: {
                                normal: {
                                    position: 'inner'
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            tooltip: {
                                show:false,
                            },

                            data:[
                                {value:oil, name:''},
                                {value:chicken, name:''},
                                {value:fish, name:''},
                                {value:glass, name:''},
                                {value:iron, name:''},
                                {value:water, name:''},
                            ]
                        },
                        {
                            name:'进项金额',
                            type:'pie',
                            radius: ['42%', '55%'],
                            color: [ '#d74e67', '#0092ff', '#eba954', '#21b6b9','#d74e67'],
                            label: {
                                normal: {
                                    formatter: '{b}\n{d}%'
                                }
                            },
                            data:[
                                {value:oil, name:'花生油'},
                                {value:chicken, name:'鸡肉'},
                                {value:fish, name:'鱼肉'},
                                {value:glass, name:'玻璃'},
                                {value:iron, name:'铁皮'},
                                {value:water, name:'纯净水'},
                            ]
                        }
                    ]
                };
                myChart3.setOption(option3);


                //月度销项扇形图
                option4 = {
                    backgroundColor: '',
                    title: {
                        text: '销项数据扇形图'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {

                        orient: 'vertical',
                        x: 'right',
                        itemWidth: 14,
                        itemHeight: 14,
                        align: 'left',

                        data:['鸡肉罐头','鱼肉罐头','猪肉罐头'],
                        textStyle: {
                            color: '#424956'
                        }
                    },
                    series: [
                        {
                            name:'销项金额',
                            type:'pie',
                            hoverAnimation: false,
                            legendHoverLink:false,
                            radius: ['40%', '42%'],
                            color: ['#915872', '#3077b7', '#9a8169'],
                            label: {
                                normal: {
                                    position: 'inner'
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }

                            },
                            tooltip: {
                                show:false,


                            },

                            data:[
                                // {value:435, name:''},
                                // {value:679, name:''},
                                // {value:848, name:''},
                            ]
                        },
                        {
                            name:'销项金额',
                            type:'pie',
                            radius: ['42%', '55%'],
                            color: ['#d74e67', '#0092ff', '#eba954'],
                            label: {
                                normal: {
                                    formatter: '{b}\n{d}%'
                                }

                            },
                            data:[
                                {value:chicken_can, name:'鸡肉罐头'},
                                {value:fish_can, name:'鱼肉罐头'},
                                {value:pork_can, name:'猪肉罐头'},
                            ]
                        }
                    ]
                };
                myChart4.setOption(option4);


                //月度进销项图
                var option = {
                    title: {
                        text: '月度进销项统计图'
                    },
                    tooltip: {},
                    legend: {
                        data: ['进项','销项']
                    },
                    xAxis: {
                        data: ["花生油", "鸡肉", "鱼肉", "玻璃", "铁皮", "纯净水","鸡肉罐头","鱼肉罐头","猪肉罐头"]
                    },
                    yAxis: {},
                    series: [{
                        name: '进项',
                        type: 'bar',
                        data: [oil, chicken,fish, glass, iron, water,0,0,0]
                    },{
                        name: '销项',
                        type: 'bar',
                        data: [0,0,0,0,0,0,chicken_can,fish_can,pork_can]
                    }]
                };
                myChart.setOption(option);

                //进销项总额
                option1 = {
                    title: {
                        text: '总额'
                    },
                    tooltip: {},
                    legend: {
                        data: ['总额']
                    },
                    xAxis: {
                        data: ["进项","销项"]
                    },
                    yAxis: {},
                    series: [{
                        name: '总额',
                        type: 'bar',
                        data: [chicken+oil+fish+glass+iron+water,chicken_can+fish_can+pork_can]
                    }]
                };
                myChart1.setOption(option1);
            }
        })

    })

})




