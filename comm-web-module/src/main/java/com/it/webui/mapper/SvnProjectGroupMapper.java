package com.it.webui.mapper;

import java.util.List;

import com.it.webui.model.SvnProject;
import com.it.webui.model.SvnProjectGroup;
import com.it.webui.util.MyMapper;

public interface SvnProjectGroupMapper extends MyMapper<SvnProjectGroup> {

	/**
	 * 查询项目组列表信息
	 * @param group
	 * @return
	 */
	List<SvnProject> selectProjectGroups(SvnProjectGroup group);
}