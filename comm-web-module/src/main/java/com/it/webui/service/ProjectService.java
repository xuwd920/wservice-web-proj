package com.it.webui.service;

import java.util.List;

import com.it.webui.model.SvnProject;
import com.it.webui.model.SvnProjectGroup;
/**
 * 项目管理service
 * 
 * @version v1.0
 * @date 2019年7月8日  
 * @author yangzz  
 *
 */
public interface ProjectService {
	
	int addProject(SvnProject project);


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
    
    int deleteProject(Integer id);


	List<SvnProject> selectProjectGroups(SvnProjectGroup group);


	int addProjectGroup(SvnProjectGroup group);


	SvnProjectGroup selectByGroupId(Integer groupId);


	int deleteProjectGroup(Integer groupId);


	int updateByGroupId(SvnProjectGroup group);
    
}
