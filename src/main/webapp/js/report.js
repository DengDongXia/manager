 $().ready(function() {
    getUserData();  //获取用户信息，并对用户进行判断是否登录
});

//获取用户信息，并对用户进行判断是否登录
var userId;  //保存用户id
function getUserData() {
    $.ajax({
            // url: 'data/getUserMessage.json',
            url: 'http://localhost:8080/manager/user/getUserMessage',
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify({
            }),
        })
    .done(function(data) {
        if(data.userId == 0){
            alert('请先登录');
            window.location.href="http://localhost:8080/manager/login.jsp";
        }else{
            userId = data.userId;    //保存id
            // 判断是哪一级代理
            if(data.type = 2){
                $('#personalLink').attr('href', 'agent.jsp');
            }else if(data.type = 3){
                $('#personalLink').attr('href', 'nextAgent.jsp');
            }else if(data.type = 4){
                $('#personalLink').attr('href', 'retail.jsp');
            }else{
                window.location.href="http://localhost:8080/manager/login.jsp";
            }
            // getReportForm();  //获取报表信息
        }
    })
    .fail(function() {
        alert('请求出错');
    })
    .always(function() {
        // console.log("complete");
    });
}

// 给查询按钮绑定事件
$('#checkButton').click(function(event) {
    if($('#searchFilter').val() != ''){
        getReportForm();  //获取报表信息
    }else{
        alert('请输入筛选条件');
    }
});

//获取报表信息
function getReportForm() {
    $.ajax({
            // url: 'data/showGoodsOrderMessage.json',
            url: 'http://localhost:8080/manager/data/getAgentGoodsMessage',
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify({
                "userId":userId,
                "year": $("#sel").find("option:selected").text(),
                "type":$("input[name='searchType']:checked").attr('value'),
                "goodsId":$('#searchFilter').val()
            }),
        })
    .done(function(data) {
        if(data.userId == 0){
            alert('请先登录');
            window.location.href="http://localhost:8080/manager/login.jsp";
        }else{
            userId = data.userId;    //保存id
            setReportForm(data);  //获取报表信息
        }
    })
    .fail(function() {
        alert('请求出错');
    })
    .always(function() {
        // console.log("complete");
    });
}

//获取报表信息
var time=[];
var numbers = [];
var pieData = [];
function setReportForm(data) {
    var i = 0;
     $.each(data.content, function(index, val) {
        time.push(val.time); 
        numbers.push(val.number); 
        var obj = {  name: val.time,                                             
                     y: val.number,                                                    
                     color: Highcharts.getOptions().colors[i]
                 };
        i++;
        pieData.push(obj);
    });  
    $('#report').highcharts({                                          
        chart: {                                                          
        },                                                                
        title: {                                                          
            text: data.goodsName+'数据的统计情况报表'                                     
        },  
        //x轴
        xAxis: {                                                        
            categories: time
        },                                                                
        tooltip: {                                                        
            formatter: function() {                                       
                var s;                                                    
                if (this.point.name) {                    
                    s = ''+                                               
                        this.point.name +': '+ this.y +' 件';         
                } else {                                                  
                    s = ''+                                               
                        this.x  +': '+ this.y;                            
                }                                                         
                return s;                                                 
            }                                                             
        },                                                                
        labels: {                                                         
            items: [{                                                     
                html: '',                          
                style: {                                                  
                    left: '40px',                                         
                    top: '0px',                                           
                    color: 'black'                                        
                }                                                         
            }]                                                            
        },                                                                
        series: [{                                                        
            type: 'column',                                               
            name: '总销量',                                                 
            data: numbers                                         
        },{                                                              
            type: 'spline',                                               
            name: '不同时间段的销量变化',                                              
            data: numbers,                               
            marker: {                                                     
                lineWidth: 2,                                               
                lineColor: Highcharts.getOptions().colors[3],               
                fillColor: 'white'                                          
            }                                                             
        }, {                                                              
            type: 'pie',                                                  
            name: '总销量',                                    
            data: pieData,                                                           
            center: [1000, 0],                                            
            size: 80,                                                    
            showInLegend: false,                                          
            dataLabels: {                                                 
                enabled: false                                            
            }                                                             
        }]                                                                
    });            
}
