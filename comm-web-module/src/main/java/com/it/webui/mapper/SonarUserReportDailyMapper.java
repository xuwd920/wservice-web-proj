package com.it.webui.mapper;

import java.util.List;

import com.it.webui.model.SonarUserReportDaily;
import com.it.webui.util.MyMapper;

public interface SonarUserReportDailyMapper extends MyMapper<SonarUserReportDaily> {
	
	public List<SonarUserReportDaily> getUserNewestDatas();
	
	public List<SonarUserReportDaily> getUserChart();
}