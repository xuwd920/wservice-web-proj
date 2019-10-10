package com.it.webui.mapper;

import java.util.List;

import com.it.webui.model.SonarFileinfo;
import com.it.webui.util.MyMapper;
import com.it.webui.vo.TotalDataVo;

public interface SonarFileinfoMapper extends MyMapper<SonarFileinfo> {
	
	
	public List<TotalDataVo> getGroupTotalData();



}