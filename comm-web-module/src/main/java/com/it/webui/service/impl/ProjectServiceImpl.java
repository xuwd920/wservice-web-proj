package com.it.webui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.webui.mapper.SvnProjectGroupMapper;
import com.it.webui.mapper.SvnProjectMapper;
import com.it.webui.model.SvnProject;
import com.it.webui.model.SvnProjectGroup;
import com.it.webui.model.SysUser;
import com.it.webui.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private SvnProjectMapper projectMapper;
	@Autowired
	private SvnProjectGroupMapper projectGroupMapper;

	@Override
	public List<SvnProject> selectProjects(SvnProject project) {
		return projectMapper.selectProjects(project);
	}

	@Override
	public SvnProject selectByProjectId(Integer id) {
		return projectMapper.selectByProjectId(id);
	}

	@Override
	public int updateByProjectId(SvnProject project) {
		return projectMapper.updateByProjectId(project);
	}

	@Override
	public int deleteProjectBatch(List<Integer> projectIds) {
		return projectMapper.deleteProjectBatch(projectIds);
	}

	@Override
	public int addProject(SvnProject project) {
		int count = projectMapper.insert(project);
		return count;
	}

	@Override
	public int deleteProject(Integer id) {
		return projectMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SvnProject> selectProjectGroups(SvnProjectGroup group) {
		return projectGroupMapper.selectProjectGroups(group);
	}

	@Override
	public int addProjectGroup(SvnProjectGroup group) {
		int result = projectGroupMapper.insert(group);
		return result;
	}

	@Override
	public SvnProjectGroup selectByGroupId(Integer groupId) {
		return projectGroupMapper.selectByPrimaryKey(groupId);
	}

	@Override
	public int deleteProjectGroup(Integer groupId) {
		return projectGroupMapper.deleteByPrimaryKey(groupId);
	}

	@Override
	public int updateByGroupId(SvnProjectGroup group) {
		return projectGroupMapper.updateByPrimaryKey(group);
	}


}
