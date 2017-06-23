$(document).ready(function() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('baobiao1'));
    myChart.showLoading({text: '正在努力的读取数据中...'  });
    var types = new Set;
    var incomeArray
    var incomeData;
    var date=new Date;
    var year=date.getFullYear();
    var month=date.getMonth()+1;
    month =(month<10 ? "0"+month:month);
    $.ajax({
        type: "get",
        url: "/incomes/list?beginTime=2017-"+ month+"-01&endTime=2017-"+month+"-31",
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
            myChart.hideLoading();
            var option = {
                title: {
                    text: '当前月份进项数据（金额/万元）'
                },
                tooltip: {},
                legend: {
                    data: ['销量']
                },
                xAxis: {
                    data: Array.from(types)
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: incomeData
                }]
            };
            myChart.setOption(option);
        }
    })
})

