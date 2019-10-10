/**
 * 
 */
package com.it.webui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.webui.mapper.SonarProjectReportDailyMapper;
import com.it.webui.service.ChartService;
import com.it.webui.vo.ChartProjectVo;

/** 
 * 
 * @version v1.0
 * @date 2019年7月17日  
 * @author yangzz  
 *   
 */
@Service
public class ChartServiceImpl implements ChartService{
	@Autowired
	private SonarProjectReportDailyMapper projectReportMapper;

	@Override
	public List<ChartProjectVo> getProjectChart() {

		return projectReportMapper.getProjectChart();
	}

	@Override
	public List<ChartProjectVo> getProjectChartByGroupId(int groupId) {
		return projectReportMapper.getProjectChartByGroupId(groupId);
	}

	
}
