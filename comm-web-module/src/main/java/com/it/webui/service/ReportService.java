package com.it.webui.service;

import com.it.webui.model.SonarUserReportDaily;
import com.it.webui.vo.FileRuleVo;
import com.it.webui.vo.TotalDataVo;

import java.util.List;

public interface ReportService {
    public List<TotalDataVo> getGroupTotalDatas();

	public List<FileRuleVo> getTopViolas(String severity);

	public List<FileRuleVo> getTopFiles(String severity);

	public List<SonarUserReportDaily> getUserTotalDatas();
	
	public List<SonarUserReportDaily> getUserChart();
}
