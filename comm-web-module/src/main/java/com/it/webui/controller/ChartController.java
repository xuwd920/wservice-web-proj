package com.it.webui.controller;
import	java.util.ArrayList;
import java.util.Arrays;
import	java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.webui.model.SonarUserReportDaily;
import com.it.webui.service.ChartService;
import com.it.webui.service.ProjectService;
import com.it.webui.service.ReportService;
import com.it.webui.util.PageUtil;
import com.it.webui.util.ResultUtil;
import com.it.webui.vo.ChartProjectVo;
import com.it.webui.vo.FileRuleVo;
import com.it.webui.vo.TotalDataVo;
import com.it.webui.vo.base.PageResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 图表功能
 * 
 * @version v1.0
 * @date 2019年7月16日  
 * @author yangzz  
 *
 */
@Controller
@RequestMapping("/chart")
public class ChartController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ChartService chartService;
	@Autowired
	private ReportService reportService;
	
	@PostMapping("/projectData")
	@ResponseBody
	public PageResultVo getProjectData(Integer limit, Integer offset) throws InterruptedException{
		PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
		List<TotalDataVo> groupDatas = reportService.getGroupTotalDatas();
		PageInfo<TotalDataVo> pages = new PageInfo<>(groupDatas);
		return ResultUtil.table(groupDatas, pages.getTotal());
	}
	
	@PostMapping("/userData")
	@ResponseBody
	public PageResultVo getUserData(Integer limit, Integer offset) throws InterruptedException{
		PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
		List<SonarUserReportDaily> userDatas = reportService.getUserTotalDatas();
		PageInfo<SonarUserReportDaily> pages = new PageInfo<>(userDatas);
		return ResultUtil.table(userDatas, pages.getTotal());
	}
	
	@PostMapping("/wholeData")
	@ResponseBody
	public Map<String,Object> getWholeReportData(){
		//返回map
		Map<String,Object> map = new HashMap<> ();
		List<ChartProjectVo> charts = chartService.getProjectChart();
		map.put("datas", charts);
		return map;
	}

	/**
	 * 新增问题趋势图表返回数据
	 * @return
	 * @throws InterruptedException 
	 */
	@PostMapping("/projectReport")
	@ResponseBody
	public Map<String,Object> getProjectReportData(String groupId) {
		//返回map
		Map<String,Object> map = new HashMap<> ();
		//折线图数据
		List<ChartProjectVo> charts = new ArrayList<>();
		//定义各个项目对应的bugs,漏洞,坏味道
		Map<String,Object> bugsMap = new HashMap<>();
		Map<String,Object> vulnMap = new HashMap<>();
		Map<String,Object> cosmMap = new HashMap<>();
		//定义项目组
		Set<String> groupSet = new HashSet<>();
		//定义日期坐标轴
		Set<String> dateSet = new HashSet<>();
		
		if(StringUtils.isBlank(groupId)){
			charts = chartService.getProjectChart();
			generateChartDatas(charts, bugsMap, vulnMap, cosmMap, groupSet, dateSet,1);
			
		}else{
			charts = chartService.getProjectChartByGroupId(Integer.parseInt(groupId));
			generateChartDatas(charts, bugsMap, vulnMap, cosmMap, groupSet, dateSet,2);
		}

		map.put("groups", groupSet.toArray());
		map.put("dates",dateSet.toArray());
		map.put("bugCharts", bugsMap);
		map.put("vulnCharts", vulnMap);
		map.put("cosmCharts", cosmMap);

		return map;
	}
	
	/**
	 * 最新人员问题统计
	 * @return
	 */
	@PostMapping("/userReport")
	@ResponseBody
	public Map<String,Object> getUserReportData(String author){
		Map<String,Object> map = new HashMap<> ();
		List<SonarUserReportDaily> userDatas = reportService.getUserChart();
		Set<String> dates = new TreeSet<>();
		Set<String> users = new TreeSet<>();
		for (int i = 0; i < userDatas.size(); i++) {
			dates.add(userDatas.get(i).getCollectDate());
			users.add(userDatas.get(i).getAuthor());
		}
		map.put("dates",dates.toArray());
		map.put("users",users.toArray());
		map.put("userDatas", userDatas);
		return map;
	}
	
	/**
	 * 项目严重程度分布图表返回数据
	 * @return
	 * @throws InterruptedException 
	 */
	@PostMapping("/severityReport")
	@ResponseBody
	public Map<String,Object> getSeverityReportData(String groupId) {
		//返回map
		Map<String,Object> map = new HashMap<> ();


		return map;
	}
	
	@PostMapping("/getTopViolas")
	@ResponseBody
	public PageResultVo getTopViolas(String severity,Integer limit, Integer offset){
		PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
		List<FileRuleVo> rules = reportService.getTopViolas(severity);
		PageInfo<FileRuleVo> pages = new PageInfo<>(rules);
		return ResultUtil.table(rules, pages.getTotal());
	}

	
	@PostMapping("/getTopFiles")
	@ResponseBody
	public PageResultVo getTopFiles(String severity,Integer limit, Integer offset){
		PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
		List<FileRuleVo> rules = reportService.getTopFiles(severity);

		PageInfo<FileRuleVo> pages = new PageInfo<>(rules);
		return ResultUtil.table(rules, pages.getTotal());
	}
	
	
	/**
	 * 生成折线图数据集
	 * @param charts 数据库源数据
	 * @param bugsMap 
	 * @param vulnMap
	 * @param cosmMap
	 * @param groupSet 
	 * @param dateSet
	 * @param type 图表类型，1:项目组;2:子项目
	 */
	private void generateChartDatas(List<ChartProjectVo> charts, Map<String, Object> bugsMap, Map<String, Object> vulnMap,
			Map<String, Object> cosmMap, Set<String> groupSet, Set<String> dateSet,int type) {
		for (ChartProjectVo cp:charts) {
			if(type==1){				
				groupSet.add(cp.getGroupName());
			}else{
				groupSet.add(cp.getProjectName());
			}
			dateSet.add(cp.getCollectDate());
		}	
		String[] groupArr =  groupSet.toArray(new String[0]);
		for (int i = 0; i < groupArr.length; i++) {
			int[] bugs = new int[dateSet.size()];
			int[] vuln = new int[dateSet.size()];
			int[] cosm = new int[dateSet.size()];
			int j = 0;
			for (ChartProjectVo cp:charts) {
				String name = "";
				if(type==1){				
					name=cp.getGroupName();
				}else{
					name=cp.getProjectName();
				}		
				if(name.equals(groupArr[i])){
					bugs[j]=cp.getBugs();
					vuln[j]=cp.getVulnerabilities();
					cosm[j]=cp.getCodeSmells();
					j++;
				}
			}
			bugsMap.put(groupArr[i], bugs);
			vulnMap.put(groupArr[i], vuln);
			cosmMap.put(groupArr[i], cosm);
		}
	}
	
}
