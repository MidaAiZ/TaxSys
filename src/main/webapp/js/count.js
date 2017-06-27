/**
 * Created by Vodka on 2017/6/7.
 */
//下载
function download_Income() {
    var url = "/incomes/exportExcel?"+"getTaxId=true&getTaxDate=true&getMoney=true&getType=true&beginTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-01&"
        + "endTime="+ $("select[name=year_form]").val()+ "-" + $("select[name=month_form]").val() + "-31&";
    document.download_income.action =url;
    $("#download_income").submit();
}
function download_Outcome() {
    var url = "/outcomes/exportExcel?"+"getTaxId=true&getTaxDate=true&getMoney=true&getType=true&beginTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-01&"
        + "endTime="+ $("select[name=year_form_outcome]").val()+ "-" + $("select[name=month_form_outcome]").val() + "-31&";
    document.download_outcome.action = url;
    $("#download_outcome").submit();
}


$(document).ready(function() {

    //月度进项扇形图
    var myChart3 = echarts.init(document.getElementById('main1'));
    var option3 = {
        backgroundColor: '',
        title: {
            text: '单月进项数据统计（金额/万元）',
            left: '25%'
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

            data:[],
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
            text: '单月销项数据统计（金额/万元）',
            left: '25%'
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

            data:[],
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
            text: '月度进销项（金额/万元）'
        },
        tooltip: {},
        legend: {
            data: ['进项','销项']
        },
        xAxis: {
            data: []
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
            text: '总额（金额/万元）'
        },
        tooltip: {},
        legend: {
        },
        xAxis: {
            data: []
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
    var _select3 = $("select[name=year_two]");
    var _select4 = $("select[name=month_two]");
    //年月图改变
    //柱状年份改变
    $(_select1).on("change", function(){
        myChart.showLoading({text: '正在努力的读取数据中...'  });
        myChart1.showLoading({text: '正在努力的读取数据中...'  });
        var str = $("select[name=year_one]").val();
        var strr= $("select[name=month]").val();
        var str1= str +"-"+ strr +"-" + "1";
        var str2= str +"-"+ strr +"-" + "31";
        // var _date1 = new Date(str1.replace(/-/, "/"));
        // var _date2 = new Date(str2.replace(/-/, "/"));
        // alert(str1+str2);

        //进项
        var types = new Set;
        var incomeArray
        var incomeData;
        $.ajax({
            type: "get",
            url: "/incomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var list = data.incomeList;
                $.each(list,function(i,p){
                    types.add(p.inType);
                });
                incomeArray  = Array.from(types);
                incomeData = new Array(incomeArray.length);
                for(var i=0;i<incomeData.length;i++){
                    incomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<incomeArray.length;i++){
                        if(p.inType==incomeArray[i]){
                            incomeData[i]+=p.money;
                            break;
                        }
                    }
                });
            }
        })

        //销项
        var typess = new Set;
        var outcomeArray
        var outcomeData;
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var list = data.outcomeList;
                $.each(list,function(i,p){
                    typess.add(p.outType);
                });
                outcomeArray  = Array.from(typess);
                outcomeData = new Array(outcomeArray.length);
                for(var i=0;i<outcomeData.length;i++){
                    outcomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<outcomeArray.length;i++){
                        if(p.outType==outcomeArray[i]){
                            outcomeData[i]+=p.money;
                            break;
                        }
                    }
                });
            }
        })


        //合并展示
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var totalArray = incomeArray.concat(outcomeArray)
                var totalData_1 = new Array();
                var totalData_2 = new Array();
                for(var i=0;i<incomeData.length;i++)totalData_1[i]=incomeData[i];
                for(var i=0;i<outcomeData.length;i++)totalData_1[i+incomeData.length]=0;
                for(var i=0;i<incomeData.length;i++)totalData_2[i]=0;
                for(var i=0;i<outcomeData.length;i++)totalData_2[i+incomeData.length]=outcomeData[i];

                // console.log("income:"+incomeArray,"ouutcome"+outcomeArray,"total"+totalArray)

                //月度进销项图
                var option = {
                    title: {
                        text: '月度进销项（金额/万元）'
                    },
                    tooltip: {},
                    legend: {
                        data: ['进项','销项']
                    },
                    xAxis: {
                        data: totalArray
                    },
                    yAxis: {},
                    series: [{
                        name: '进项',
                        type: 'bar',
                        data: totalData_1
                    },{
                        name: '销项',
                        type: 'bar',
                        data: totalData_2
                    }]
                };
                myChart.hideLoading();
                myChart.setOption(option);

                var res_1 =0;
                for(var i=0;i<incomeData.length;i++)res_1+=incomeData[i];

                var res_2 =0;
                for(var i=0;i<outcomeData.length;i++)res_2+=outcomeData[i];

                //进销项总额
                option1 = {
                    title: {
                        text: '总额（金额/万元）'
                    },
                    tooltip: {},
                    legend: {
                    },
                    xAxis: {
                        data: ["进项","销项"]
                    },
                    yAxis: {},
                    series: [{
                        name: '总额',
                        type: 'bar',
                        data: [res_1,res_2]
                    }]
                };
                myChart1.hideLoading();
                myChart1.setOption(option1);
            }
        })

    })
    //扇形年份改变
    $(_select3).on("change", function(){
        myChart3.showLoading({text: '正在努力的读取数据中...'  });
        myChart4.showLoading({text: '正在努力的读取数据中...'  });
        var str = $("select[name=year_two]").val();
        var strr= $("select[name=month_two]").val();
        var str1= str +"-"+ strr +"-" + "1";
        var str2= str +"-"+ strr +"-" + "31";
        // var _date1 = new Date(str1.replace(/-/, "/"));
        // var _date2 = new Date(str2.replace(/-/, "/"));
        // alert(str1+str2);

        //进项
        var types = new Set;
        var incomeArray
        var incomeData;
        var flag=1;
        $.ajax({
            type: "get",
            url: "/incomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var list = data.incomeList;
                $.each(list,function(i,p){
                    types.add(p.inType);
                });
                incomeArray  = Array.from(types);
                incomeData = new Array(incomeArray.length);
                for(var i=0;i<incomeData.length;i++){
                    incomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<incomeArray.length;i++){
                        if(p.inType==incomeArray[i]){
                            incomeData[i]+=p.money;
                            break;
                        }
                    }
                });
                if(incomeArray.length==0)flag=0;
            }
        })


        //销项
        var typess = new Set;
        var outcomeArray
        var outcomeData;
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
                    typess.add(p.outType);
                });
                outcomeArray  = Array.from(typess);
                outcomeData = new Array(outcomeArray.length);
                for(var i=0;i<outcomeData.length;i++){
                    outcomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<outcomeArray.length;i++){
                        if(p.outType==outcomeArray[i]){
                            outcomeData[i]+=p.money;
                            break;
                        }
                    }
                });
            }
        })


        //合并展示
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {

                //月度进项扇形图
                var ObjectArray = new Array();
                for(var i=0;i<incomeArray.length;i++){
                    ObjectArray[i]={value:incomeData[i],name:incomeArray[i]}
                }
                if(ObjectArray.length==0){
                    option3 = {
                        backgroundColor: '',
                        title: {
                            text: '单月进项数据统计（金额/万元）'
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

                            data:[{value:0,name:'无数据'}],
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

                                data:[]
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
                                data:[{value:0,name:'无数据'}],
                            }
                        ]
                    };
                }
                else{
                    option3 = {
                        backgroundColor: '',
                        title: {
                            text: '单月进项数据统计（金额/万元）'
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

                            data:incomeArray,
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

                                data:[]
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
                                data:ObjectArray
                            }
                        ]
                    };
                }
                myChart3.hideLoading();
                myChart3.setOption(option3);


                //月度销项扇形图
                var ObjectArray = new Array();
                for(var i=0;i<outcomeArray.length;i++){
                    ObjectArray[i]={value:outcomeData[i],name:outcomeArray[i]}
                }
                if(ObjectArray.length==0){
                    option4 = {
                        backgroundColor: '',
                        title: {
                            text: '单月销项数据统计（金额/万元）'
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

                            data:outcomeArray,
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
                                data:[{value:0,name:'无数据'}]
                            }
                        ]
                    };
                }
                else{
                    option4 = {
                        backgroundColor: '',
                        title: {
                            text: '单月销项数据统计（金额/万元）'
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

                            data:outcomeArray,
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
                                data:ObjectArray
                            }
                        ]
                    };
                }
                myChart4.hideLoading();
                myChart4.setOption(option4);
            }
        })

    })
    //柱状月份改变
    $(_select2).on("change", function(){
        myChart.showLoading({text: '正在努力的读取数据中...'  });
        myChart1.showLoading({text: '正在努力的读取数据中...'  });
        var str = $("select[name=year_one]").val();
        var strr= $("select[name=month]").val();
        var str1= str +"-"+ strr +"-" + "1";
        var str2= str +"-"+ strr +"-" + "31";
        // var _date1 = new Date(str1.replace(/-/, "/"));
        // var _date2 = new Date(str2.replace(/-/, "/"));
        // alert(str1+str2);

        //进项
        var types = new Set;
        var incomeArray
        var incomeData;
        $.ajax({
            type: "get",
            url: "/incomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var list = data.incomeList;
                $.each(list,function(i,p){
                    types.add(p.inType);
                });
                incomeArray  = Array.from(types);
                incomeData = new Array(incomeArray.length);
                for(var i=0;i<incomeData.length;i++){
                    incomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<incomeArray.length;i++){
                        if(p.inType==incomeArray[i]){
                            incomeData[i]+=p.money;
                            break;
                        }
                    }
                });
            }
        })

        //销项
        var typess = new Set;
        var outcomeArray
        var outcomeData;
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var list = data.outcomeList;
                $.each(list,function(i,p){
                    typess.add(p.outType);
                });
                outcomeArray  = Array.from(typess);
                outcomeData = new Array(outcomeArray.length);
                for(var i=0;i<outcomeData.length;i++){
                    outcomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<outcomeArray.length;i++){
                        if(p.outType==outcomeArray[i]){
                            outcomeData[i]+=p.money;
                            break;
                        }
                    }
                });
            }
        })


        //合并展示
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var totalArray = incomeArray.concat(outcomeArray)
                var totalData_1 = new Array();
                var totalData_2 = new Array();
                for(var i=0;i<incomeData.length;i++)totalData_1[i]=incomeData[i];
                for(var i=0;i<outcomeData.length;i++)totalData_1[i+incomeData.length]=0;
                for(var i=0;i<incomeData.length;i++)totalData_2[i]=0;
                for(var i=0;i<outcomeData.length;i++)totalData_2[i+incomeData.length]=outcomeData[i];

                // console.log("income:"+incomeArray,"ouutcome"+outcomeArray,"total"+totalArray)

                //月度进销项图
                var option = {
                    title: {
                        text: '月度进销项（金额/万元）'
                    },
                    tooltip: {},
                    legend: {
                        data: ['进项','销项']
                    },
                    xAxis: {
                        data: totalArray
                    },
                    yAxis: {},
                    series: [{
                        name: '进项',
                        type: 'bar',
                        data: totalData_1
                    },{
                        name: '销项',
                        type: 'bar',
                        data: totalData_2
                    }]
                };
                myChart.hideLoading();
                myChart.setOption(option);

                var res_1 =0;
                for(var i=0;i<incomeData.length;i++)res_1+=incomeData[i];

                var res_2 =0;
                for(var i=0;i<outcomeData.length;i++)res_2+=outcomeData[i];

                //进销项总额
                option1 = {
                    title: {
                        text: '总额（金额/万元）'
                    },
                    tooltip: {},
                    legend: {
                    },
                    xAxis: {
                        data: ["进项","销项"]
                    },
                    yAxis: {},
                    series: [{
                        name: '总额',
                        type: 'bar',
                        data: [res_1,res_2]
                    }]
                };
                myChart1.hideLoading();
                myChart1.setOption(option1);
            }
        })

    })
    //扇形月份改变
    $(_select4).on("change", function(){
        myChart3.showLoading({text: '正在努力的读取数据中...'  });
        myChart4.showLoading({text: '正在努力的读取数据中...'  });
        var str = $("select[name=year_two]").val();
        var strr= $("select[name=month_two]").val();
        var str1= str +"-"+ strr +"-" + "1";
        var str2= str +"-"+ strr +"-" + "31";
        // var _date1 = new Date(str1.replace(/-/, "/"));
        // var _date2 = new Date(str2.replace(/-/, "/"));
        // alert(str1+str2);

        //进项
        var types = new Set;
        var incomeArray
        var incomeData;
        var flag=1;
        $.ajax({
            type: "get",
            url: "/incomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {
                var list = data.incomeList;
                $.each(list,function(i,p){
                    types.add(p.inType);
                });
                incomeArray  = Array.from(types);
                incomeData = new Array(incomeArray.length);
                for(var i=0;i<incomeData.length;i++){
                    incomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<incomeArray.length;i++){
                        if(p.inType==incomeArray[i]){
                            incomeData[i]+=p.money;
                            break;
                        }
                    }
                });
                if(incomeArray.length==0)flag=0;
            }
        })


        //销项
        var typess = new Set;
        var outcomeArray
        var outcomeData;
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
                    typess.add(p.outType);
                });
                outcomeArray  = Array.from(typess);
                outcomeData = new Array(outcomeArray.length);
                for(var i=0;i<outcomeData.length;i++){
                    outcomeData[i]=0;
                }
                $.each(list,function(i,p){
                    for(var i=0;i<outcomeArray.length;i++){
                        if(p.outType==outcomeArray[i]){
                            outcomeData[i]+=p.money;
                            break;
                        }
                    }
                });
            }
        })


        //合并展示
        $.ajax({
            type: "get",
            url: "/outcomes/list?beginTime="+str1+"&endTime="+str2,
            dataType: "json",
            success: function(data) {

                //月度进项扇形图
                var ObjectArray = new Array();
                for(var i=0;i<incomeArray.length;i++){
                    ObjectArray[i]={value:incomeData[i],name:incomeArray[i]}
                }
                if(ObjectArray.length==0){
                    option3 = {
                        backgroundColor: '',
                        title: {
                            text: '单月进项数据统计（金额/万元）'
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

                            data:[{value:0,name:'无数据'}],
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

                                data:[]
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
                                data:[{value:0,name:'无数据'}],
                            }
                        ]
                    };
                }
                else{
                    option3 = {
                        backgroundColor: '',
                        title: {
                            text: '单月进项数据统计（金额/万元）'
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

                            data:incomeArray,
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

                                data:[]
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
                                data:ObjectArray
                            }
                        ]
                    };
                }
                myChart3.hideLoading();
                myChart3.setOption(option3);


                //月度销项扇形图
                var ObjectArray = new Array();
                for(var i=0;i<outcomeArray.length;i++){
                    ObjectArray[i]={value:outcomeData[i],name:outcomeArray[i]}
                }
                if(ObjectArray.length==0){
                    option4 = {
                        backgroundColor: '',
                        title: {
                            text: '单月销项数据统计（金额/万元）'
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

                            data:outcomeArray,
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
                                data:[{value:0,name:'无数据'}]
                            }
                        ]
                    };
                }
                else{
                    option4 = {
                        backgroundColor: '',
                        title: {
                            text: '单月销项数据统计（金额/万元）'
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

                            data:outcomeArray,
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
                                data:ObjectArray
                            }
                        ]
                    };
                }
                myChart4.hideLoading();
                myChart4.setOption(option4);
            }
        })

    })
})




