package com.it.webui.controller;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.webui.model.SvnProject;
import com.it.webui.model.SvnProjectGroup;
import com.it.webui.model.SysUser;
import com.it.webui.service.ProjectService;
import com.it.webui.service.UserService;
import com.it.webui.util.DateUtils;
import com.it.webui.util.PageUtil;
import com.it.webui.util.ResultUtil;
import com.it.webui.vo.base.PageResultVo;
import com.it.webui.vo.base.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/list")
	@ResponseBody
	public PageResultVo getProjectList(SvnProject project, Integer limit, Integer offset){
		PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
		List<SvnProject> list = projectService.selectProjects(project);
		PageInfo<SvnProject> pages = new PageInfo<>(list);
		return ResultUtil.table(list, pages.getTotal());
	}
	
	@PostMapping("/listGroup")
	@ResponseBody
	public PageResultVo getProjectGroupList(SvnProjectGroup group, Integer limit, Integer offset){
		PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
		List<SvnProject> list = projectService.selectProjectGroups(group);
		PageInfo<SvnProject> pages = new PageInfo<>(list);
		return ResultUtil.table(list, pages.getTotal());
	}
	
	@PostMapping("/loadAllGroup")
	@ResponseBody
	public List<SvnProject> getAllProjectGroups(SvnProjectGroup group){
		List<SvnProject> list = projectService.selectProjectGroups(group);
		return list;
	}
	 
	@PostMapping("/add")
	@ResponseBody
	public ResponseVo<?> addProject(SvnProject project){
		int num = projectService.addProject(project);
        if(num > 0){
            return ResultUtil.success("添加项目成功");
        }else {
            return ResultUtil.error("添加项目失败");
        }
	}
	
	@PostMapping("/addGroup")
	@ResponseBody
	public ResponseVo<?> addProjectGroup(SvnProjectGroup group){
		SysUser loginUser = userService.selectByUserId(((SysUser) SecurityUtils.getSubject().getPrincipal()).getUserId());
		group.setCreator(loginUser.getUsername());
		group.setCreateTime(new Date());
		int num = projectService.addProjectGroup(group);
        if(num > 0){
            return ResultUtil.success("新增项目组成功");
        }else {
            return ResultUtil.error("新增项目组失败");
        }
	}
	
	@GetMapping("/edit")
	public String projectDetail(Model model,String projectId){
		SvnProject project = projectService.selectByProjectId(Integer.parseInt(projectId));
		model.addAttribute("project", project);
		return "/project/projectDetail";
	}
	
	@GetMapping("/editGroup")
	public String projectGroupDetail(Model model,String groupId){
		SvnProjectGroup group = projectService.selectByGroupId(Integer.parseInt(groupId));
		model.addAttribute("group", group);
		return "/project/groupDetail";
	}
	
	@PostMapping("/toEdit")
	@ResponseBody
	public ResponseVo<?> editProject(SvnProject project){
		int num = projectService.updateByProjectId(project);
        if(num > 0){
            return ResultUtil.success("修改项目成功");
        }else {
            return ResultUtil.error("修改项目失败");
        }
	}
	
	@PostMapping("/toEditGroup")
	@ResponseBody
	public ResponseVo<?> editProjectGroup(SvnProjectGroup group){
		int num = projectService.updateByGroupId(group);
        if(num > 0){
            return ResultUtil.success("修改项目成功");
        }else {
            return ResultUtil.error("修改项目失败");
        }
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public ResponseVo<?> deleteProject(Integer projectId){
		int num = projectService.deleteProject(projectId);
        if(num > 0){
            return ResultUtil.success("删除项目成功");
        }else {
            return ResultUtil.error("删除项目失败");
        }
	}

	@GetMapping("/deleteGroup")
	@ResponseBody
	public ResponseVo<?> deleteProjectGroup(Integer groupId){
		int num = projectService.deleteProjectGroup(groupId);
        if(num > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.error("删除失败");
        }
	}
}
