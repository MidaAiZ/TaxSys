/**
 * Created by Vodka on 2017/6/7.
 */
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

        data:['花生油','鸡肉','鱼肉','玻璃','铁皮 ','食品添加剂','纯净水','包装纸','猪肉'],
        textStyle: {
            color: '#424956'
        }
    },
    series: [
        {
            name:'访问来源',
            type:'pie',
            hoverAnimation: false,
            legendHoverLink:false,
            radius: ['40%', '42%'],
            color: ['#915872', '#3077b7', '#9a8169', '#3f8797','#915872', '#3077b7', '#9a8169', '#3f8797',"#915872"],
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
                {value:435, name:''},
                {value:679, name:''},
                {value:848, name:''},
                {value:348, name:''},
                {value:436, name:''},
                {value:680, name:''},
                {value:849, name:''},
                {value:349, name:''},
                {value:437, name:''},
            ]
        },
        {
            name:'访问来源',
            type:'pie',
            radius: ['42%', '55%'],
            color: ['#d74e67', '#0092ff', '#eba954', '#21b6b9','#d74e67', '#0092ff', '#eba954', '#21b6b9','#d74e67'],
            label: {
                normal: {
                    formatter: '{b}\n{d}%'
                }
            },
            data:[
                {value:435, name:'花生油'},
                {value:679, name:'鸡肉'},
                {value:848, name:'鱼肉'},
                {value:348, name:'玻璃'},
                {value:436, name:'铁皮'},
                {value:680, name:'食品添加剂'},
                {value:849, name:'纯净水'},
                {value:349, name:'包装纸'},
                {value:437, name:'猪肉'},
            ]
        }
    ]
};
myChart3.setOption(option3);