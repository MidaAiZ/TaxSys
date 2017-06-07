$(document).ready(function() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('baobiao1'));
    myChart.showLoading({text: '正在努力的读取数据中...'  });
    var oil=0,chicken=0,fish=0,glass=0,iron=0,water=0;
    $.ajax({
        type: "get",
        url: "/incomes/list?beginTime=2017-01-01&endTime=2017-01-31",
        dataType: "json",
        success: function(data) {
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
            myChart.hideLoading();
            var option = {
                title: {
                    text: '1月份进项数据'
                },
                tooltip: {},
                legend: {
                    data: ['销量']
                },
                xAxis: {
                    data: ["花生油", "鸡肉", "鱼肉", "玻璃", "铁皮", "纯净水"]
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: [(oil), (chicken), fish, glass, iron, water]
                }]
            };
            console.log(option);
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    })
})

