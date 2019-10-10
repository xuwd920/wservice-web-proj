package com.it.webui.controller;

import com.it.webui.model.SysPermission;
import com.it.webui.model.SysRole;
import com.it.webui.model.SysUser;
import com.it.webui.service.PermissionService;
import com.it.webui.service.RoleService;
import com.it.webui.shiro.MyShiroRealm;
import com.it.webui.util.CoreConst;
import com.it.webui.util.PageUtil;
import com.it.webui.util.ResultUtil;
import com.it.webui.vo.PermissionTreeListVo;
import com.it.webui.vo.base.PageResultVo;
import com.it.webui.vo.base.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version V1.0
 * @date 2018年7月11日
 *  
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MyShiroRealm myShiroRealm;

    /*角色列表数据*/
    @PostMapping("/list")
    @ResponseBody
    public PageResultVo pageRoles(SysRole role, Integer limit, Integer offset) {
        try {
            PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
            List<SysRole> roleList = roleService.selectRoles(role);
            PageInfo<SysRole> pages = new PageInfo<>(roleList);
            return ResultUtil.table(roleList,pages.getTotal());
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }

    }

    /*新增角色*/
    @PostMapping("/add")
    @ResponseBody
    public ResponseVo addRole(SysRole role) {
        try {
            int a = roleService.insert(role);
            if (a > 0) {
                return ResultUtil.success("添加角色成功");
            } else {
                return ResultUtil.error("添加角色失败");
            }
        } catch (Exception e) {
            logger.error(String.format("RoleController.addRole%s", e));
            throw e;
        }
    }

    /*删除角色*/
    @GetMapping("/delete")
    @ResponseBody
    public ResponseVo deleteRole(String roleId) {
        if(roleService.findByRoleId(roleId).size()>0){
            return ResultUtil.error("删除失败,该角色下存在用户");
        }
        List<String> roleIdsList = Arrays.asList(roleId);
        int a = roleService.updateStatusBatch(roleIdsList, CoreConst.STATUS_INVALID);
        if (a > 0) {
            return ResultUtil.success("删除角色成功");
        } else {
            return ResultUtil.error("删除角色失败");
        }
    }

    /*批量删除角色*/
    @GetMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteRole(String roleIdStr) {
        String[] roleIds = roleIdStr.split(",");
        List<String> roleIdsList = Arrays.asList(roleIds);
        if(roleService.findByRoleIds(roleIdsList).size()>0){
            return ResultUtil.error("删除失败,选择的角色下存在用户");
        }
        int a = roleService.updateStatusBatch(roleIdsList, CoreConst.STATUS_INVALID);
        if (a > 0) {
            return ResultUtil.success("删除角色成功");
        } else {
            return ResultUtil.error("删除角色失败");
        }
    }

    /*编辑角色详情*/
    @GetMapping("/edit")
    public String detail(Model model, Integer id) {
        SysRole role = roleService.findById(id);
        model.addAttribute("role", role);
        return "role/detail";
    }

    /*编辑角色*/
    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo editRole(@ModelAttribute("role") SysRole role) {
        int a = roleService.updateByRoleId(role);
        if (a > 0) {
            return ResultUtil.success("编辑角色成功");
        } else {
            return ResultUtil.error("编辑角色失败");
        }
    }

    /*分配权限列表查询*/
    @PostMapping("/assign/permission/list")
    @ResponseBody
    public List<PermissionTreeListVo> assignRole(String roleId){
        List<PermissionTreeListVo> listVos = new ArrayList<>();
        List<SysPermission> allPermissions = permissionService.selectAll(CoreConst.STATUS_VALID);
        List<SysPermission> hasPermissions = roleService.findPermissionsByRoleId(roleId);
        for(SysPermission permission : allPermissions){
            PermissionTreeListVo vo = new PermissionTreeListVo();
            vo.setId(permission.getId());
            vo.setPermissionId(permission.getPermissionId());
            vo.setName(permission.getName());
            vo.setParentId(permission.getParentId());
            for(SysPermission hasPermission:hasPermissions){
                //有权限则选中
                if(hasPermission.getPermissionId().equals(permission.getPermissionId())){
                    vo.setChecked(true);
                    break;
                }
            }
            listVos.add(vo);
        }
        return listVos;
    }


    /*分配权限*/
    @PostMapping("/assign/permission")
    @ResponseBody
    public ResponseVo assignRole(String roleId, String permissionIdStr){
        List<String> permissionIdsList = new ArrayList<>();
        if(StringUtils.isNotBlank(permissionIdStr)){
            String[] permissionIds = permissionIdStr.split(",");
            permissionIdsList = Arrays.asList(permissionIds);
        }
        ResponseVo responseVo = roleService.addAssignPermission(roleId,permissionIdsList);
        /*重新加载角色下所有用户权限*/
        List<SysUser> userList = roleService.findByRoleId(roleId);
        if(userList.size()>0){
            List<String> userIds = new ArrayList<>();
            for(SysUser user : userList){
                userIds.add(user.getUserId());
            }
            myShiroRealm.clearAuthorizationByUserId(userIds);
        }
        return responseVo;
    }

}
