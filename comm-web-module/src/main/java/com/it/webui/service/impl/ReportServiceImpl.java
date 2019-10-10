package com.it.webui.service.impl;

import com.it.webui.mapper.SonarFileinfoMapper;
import com.it.webui.mapper.SonarFileruleMapper;
import com.it.webui.mapper.SonarUserReportDailyMapper;
import com.it.webui.model.SonarUserReportDaily;
import com.it.webui.service.ReportService;
import com.it.webui.vo.FileRuleVo;
import com.it.webui.vo.TotalDataVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private SonarFileinfoMapper fileinfoMapper;
    @Autowired
    private SonarFileruleMapper fileruleMapper;
    @Autowired
    private SonarUserReportDailyMapper userReportMapper;

    public List<TotalDataVo> getGroupTotalDatas(){
        return fileinfoMapper.getGroupTotalData();
    }

    @Override
	public List<SonarUserReportDaily> getUserTotalDatas() {
		return userReportMapper.getUserNewestDatas();
	}
      
    @Override
	public List<SonarUserReportDaily> getUserChart(){
		return userReportMapper.getUserChart();
	}
    
	@Override
	public List<FileRuleVo> getTopViolas(String severity) {
		return fileruleMapper.getTopViolas(severity);
	}

	@Override
	public List<FileRuleVo> getTopFiles(String severity) {
		List<FileRuleVo> list =  fileruleMapper.getTopFiles(severity);
		List<FileRuleVo> listFiles = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			FileRuleVo fileRule = list.get(i);
			String fileName = fileRule.getFilename();
			String viewNames = fileName.substring(fileName.lastIndexOf("/"),fileName.length());
			fileRule.setFilename(".."+viewNames);
			listFiles.add(fileRule);
		}
		return listFiles;
	}

	
}
