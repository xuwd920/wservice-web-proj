package com.it.webui.mapper;

import java.util.List;

import com.it.webui.model.SonarProjectReportDaily;
import com.it.webui.util.MyMapper;
import com.it.webui.vo.ChartProjectVo;

import org.apache.ibatis.annotations.Param;

public interface SonarProjectReportDailyMapper extends MyMapper<SonarProjectReportDaily> {
	/**
	 * 获取项目图表分析
	 * @return
	 */
	public List<ChartProjectVo> getProjectChart();

	public List<ChartProjectVo> getProjectChartByGroupId(@Param(value = "groupId") int groupId);
}