/**
 * 
 */
package com.it.webui.service;

import java.util.List;

import com.it.webui.vo.ChartProjectVo;

/** 
 * 图标业务
 * @version v1.0
 * @date 2019年7月17日  
 * @author yangzz  
 *   
 */
public interface ChartService {
	
	/**
	 * 获取项目图表分析
	 * @return
	 */
	public List<ChartProjectVo> getProjectChart();
	
	public List<ChartProjectVo> getProjectChartByGroupId(int groupId);

}
