/**
 * 图表数据加载
 */
var dom1 = document.getElementById("container1");
var dom2 = document.getElementById("container2");
var dom3 = document.getElementById("container3");
var myChart1 = echarts.init(dom1);
var myChart2 = echarts.init(dom2);
var myChart3 = echarts.init(dom3);

//折线图
var option = {
		 	title: {
		        text: '人员bug统计'
		    },
		    tooltip: {
		        trigger: 'axis' //坐标轴触发提示框，多用于柱状、折线图中
		    },
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
			    min: 0
			}
			};
			
	//数据加载完之前先显示一段简单的loading动画
	myChart1.showLoading(); myChart2.showLoading(); myChart3.showLoading(); 
	

	//加载数据
	$.ajax({
		url:"chart/userReport",
		type:'post',
		async : true,
		data : {author:""},
		dataType:'json',
		success:function(result){
			console.log(result);

			 var users=result.users;//人员数组
			 var dates=result.dates;
			if (result == null || dates.length < 1) {
				//返回的数据为空时显示提示信息
                alert("图表请求数据为空，请稍后再试！");
                myChart1.hideLoading(); myChart2.hideLoading(); myChart3.hideLoading();
			}else{
				
				var userDatas = result.userDatas;
				

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
			        data:users
			    };
				//图表重新赋值
				var xAxis = { type: 'category', data: dates };
				//symbol:'circle',设置折线图中每个坐标点的符号；emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
				var series1 = [],series2 = [],series3 = [];
				for (var i = 0; i < users.length; i++) {
					 var bugs=[];//bugs数组
					 var cods=[];//坏味道数组
					 var vuls=[];//漏洞数数组
					for (var j = 0; j < userDatas.length; j++) {
						var data = userDatas[j];
						if(users[i]==data.author){
							bugs.push(data.bugsCount);
							cods.push(data.codeSmellsCount);
							vuls.push(data.vulnerabilitiesCount);

						}
					}
					var item1 = {name:users[i],data:bugs,type:'bar'};
					var item2 = {name:users[i],data:vuls,type:'bar'};
					var item3 = {name:users[i],data:cods,type:'bar'};
					series1.push(item1); series2.push(item2); series3.push(item3);
					console.log(item3);
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
	option.title = {text: '新增代码异味趋势'};
	myChart3.setOption(option);