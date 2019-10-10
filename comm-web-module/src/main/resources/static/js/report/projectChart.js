/**
 * 图表数据加载
 */
var dom1 = document.getElementById("container1");
var dom2 = document.getElementById("container2");
var dom3 = document.getElementById("container3");
var myChart1 = echarts.init(dom1);
var myChart2 = echarts.init(dom2);
var myChart3 = echarts.init(dom3);
//柱状图
var barChart1 = echarts.init(document.getElementById("barContainer1"));
var barChart2 = echarts.init(document.getElementById("barContainer2"));
var barChart3 = echarts.init(document.getElementById("barContainer3"));
//折线图
var option = {
		 	title: {
		        text: '新增bug趋势'
		    },
		    tooltip: {
		        trigger: 'axis' //坐标轴触发提示框，多用于柱状、折线图中
		    },
		    dataZoom: [
		                 {
		                     type: 'slider',    //支持鼠标滚轮缩放
		                     start: 0,            //默认数据初始缩放范围为10%到90%
		                     end: 100
		                 },
		                 {
		                     type: 'inside',    //支持单独的滑动条缩放
		                     start: 0,            //默认数据初始缩放范围为10%到90%
		                     end: 100
		                 }
		    ],
		    grid: {
		        left: '3%',
		        right: '10%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {    //工具栏显示             
	            show: true,
	            feature: {                
	                saveAsImage: {}        //显示“另存为图片”工具
	            }
	        },
			xAxis: {
			    type: 'category',
			    name:"日期"
			},
			yAxis: {
			    type: 'value',
			    //name : '数量',
			    min: 0
			}
			};
	//饼图
	var barOption = {
		    title : {
		        text: 'Bug严重程度分布',
		        subtext: '总体统计'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		    	left: 'center',
   	 			bottom:'bottom',
                show:true
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : ['日志留存']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ]
		};

			
			
	//数据加载完之前先显示一段简单的loading动画
	myChart1.showLoading(); myChart2.showLoading();myChart3.showLoading();  
	barChart1.showLoading();barChart2.showLoading();barChart3.showLoading();
	
	/**
	 * load折线图数据
	 */
	 var bugs=[];//bugs数组
	 var cods=[];//坏味道数组
	 var vuls=[];//漏洞数数组
	 var dates=[];//时间数组
	//加载数据
	$.ajax({
		url:"chart/projectReport",
		type:'post',
		async : true,
		data : {groupId:""},
		dataType:'json',
		success:function(result){

			if (result == null || result.groups.length < 1) {
				//返回的数据为空时显示提示信息
                alert("图表请求数据为空，请稍后再试！");
                myChart1.hideLoading(); myChart2.hideLoading(); myChart3.hideLoading();
			}else{
				console.log(result);
				//获取bugs,漏洞，坏味道对应的map
				var bugCharts=result.bugCharts;
				var vulnCharts=result.vulnCharts;
				var cosmCharts=result.cosmCharts;
				//显示项目组名
				var groups = result.groups;
				//x轴坐标
				var dates = result.dates;

				myChart1.hideLoading();    //隐藏加载动画
				myChart2.hideLoading();
				myChart3.hideLoading();
				var option1 = myChart1.getOption();
				var option2 = myChart2.getOption();
				var option3 = myChart3.getOption();
				//图表上方的类别显示
				var legend={
	                orient:'horizontal',
	                left: 'center',
	   	 			top:'top',
	                show:true,
			        data:groups
			    };
				//图表重新赋值
				var xAxis = { type: 'category', data: dates };
				//symbol:'circle',设置折线图中每个坐标点的符号；emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
				var series1 = [],series2 = [],series3 = [];
				//动态设置series
				for(var i=0;i<groups.length;i++){
					var item1 = {name:groups[i],data:bugCharts[groups[i]],type:'line'};
					var item2 = {name:groups[i],data:vulnCharts[groups[i]],type:'line'};
					var item3 = {name:groups[i],data:cosmCharts[groups[i]],type:'line'};
					series1.push(item1); series2.push(item2); series3.push(item3);
				}
				option1.legend = legend; option2.legend = legend; option3.legend = legend;
				option1.xAxis=xAxis; option2.xAxis=xAxis; option3.xAxis=xAxis;
				option1.series=series1; option2.series=series2; option3.series=series3;
		        myChart1.setOption(option1);
		 		myChart2.setOption(option2);
		 		myChart3.setOption(option3);	
			}

		},
		error:function(){
			//请求失败时执行该函数
            alert("图表请求数据失败，可能是服务器开小差了");
            myChart1.hideLoading(); 
            myChart2.hideLoading();  
            myChart3.hideLoading();  
		}
	});
	//初次加载图表(无数据) 
	myChart1.setOption(option); 
	option.title = {text: '新增缺陷趋势'};
	myChart2.setOption(option);
	option.title = {text: '新增坏味道趋势'};
	myChart3.setOption(option);

	/**
	*load柱状图数据
	*/
	$.ajax({
		url:"chart/severityReport",
		type:'post',
		async : true,
		data : {groupId:""},
		dataType:'json',
		success:function(result){
			//隐藏加载动画
			barChart1.hideLoading();    
			barChart2.hideLoading();
			barChart3.hideLoading();
			var option1 = barChart1.getOption();
			var option2 = barChart2.getOption();
			var option3 = barChart3.getOption();
			var series1 = [],series2 = [],series3 = [];
			//动态设置series
			var item1 = {name:'阻断',data:[113],type:'bar'};
			var item2 = {name:'严重',data:[56],type:'bar'};
			var item3 = {name:'主要',data:[113],type:'bar'};
			var item4 = {name:'次要',data:[178],type:'bar'};
			var item5 = {name:'提示',data:[47],type:'bar'};
			series1.push(item1); series1.push(item2); series1.push(item3);series1.push(item4);series1.push(item5);
			option1.series=series1; 
		    barChart1.setOption(option1);
		
		var item12 = {name:'阻断',data:[113],type:'bar'};
		var item22 = {name:'严重',data:[560],type:'bar'};
		var item32 = {name:'主要',data:[13],type:'bar'};
		var item42 = {name:'次要',data:[78],type:'bar'};
		var item52 = {name:'提示',data:[47],type:'bar'};
		series2.push(item12); series2.push(item22); series2.push(item32);series2.push(item42);series2.push(item52);
		option2.series=series2; 
			barChart2.setOption(option2);
			
			var item13 = {name:'阻断',data:[55],type:'bar'};
			var item23 = {name:'严重',data:[234],type:'bar'};
			var item33 = {name:'主要',data:[155],type:'bar'};
			var item43 = {name:'次要',data:[66],type:'bar'};
			var item53 = {name:'提示',data:[147],type:'bar'};
			series3.push(item13); series3.push(item23); series3.push(item33);series3.push(item43);series3.push(item53);
			option3.series=series3; 
			barChart3.setOption(option3);	

		},
		error:function(){
			//请求失败时执行该函数
            alert("图表请求数据失败，可能是服务器开小差了");
            barChart1.hideLoading(); 
            barChart2.hideLoading();  
            barChart3.hideLoading();  
		}
	});
	//初次加载柱状图表(无数据) 
	barChart1.setOption(barOption); 
	barOption.title = {text: '缺陷严重程度分布'};
	barChart2.setOption(barOption);
	barOption.title = {text: '代码异味严重程度分布'};
	barChart3.setOption(barOption);