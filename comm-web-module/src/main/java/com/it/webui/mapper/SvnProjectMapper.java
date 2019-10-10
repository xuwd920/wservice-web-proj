package com.it.webui.mapper;

import java.util.List;

import com.it.webui.model.SvnProject;
import com.it.webui.util.MyMapper;

public interface SvnProjectMapper extends MyMapper<SvnProject> {
	/**
     * 根据条件查询项目列表
     * @param project
     * @return list
     */
    List<SvnProject> selectProjects(SvnProject project);

    /**
     * 根据id查询项目
     * @param id
     * @return project
     */
    SvnProject selectByProjectId(Integer id);

    /**
     * 根据id更新项目信息
     * @param project
     * @return int
     */
    int updateByProjectId(SvnProject project);

    /**
     * 根据id集合批量删除项目
     * @param projectIds
     * @return int
     */
    int deleteProjectBatch(List<Integer> projectIds);
}