package com.it.webui.service.impl;

import com.it.webui.mapper.SysPermissionMapper;
import com.it.webui.mapper.SysRoleMapper;
import com.it.webui.mapper.SysRolePermissionMapper;
import com.it.webui.mapper.SysUserMapper;
import com.it.webui.model.SysPermission;
import com.it.webui.model.SysRole;
import com.it.webui.model.SysRolePermission;
import com.it.webui.model.SysUser;
import com.it.webui.service.RoleService;
import com.it.webui.util.ResultUtil;
import com.it.webui.util.UUIDUtil;
import com.it.webui.vo.base.ResponseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @version V1.0
 * @date 2018年7月11日
 *  
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysPermissionMapper permissionMapper;
    @Autowired
    private SysRolePermissionMapper rolePermissionMapper;
    @Autowired
    private SysUserMapper userMapper;

    @Override
    public Set<String> findRoleByUserId(String userId) {
        return roleMapper.findRoleByUserId(userId);
    }

    @Override
    public List<SysRole> selectRoles(SysRole role) {
        return roleMapper.selectRoles(role);
    }

    @Override
    public int insert(SysRole role) {
        role.setRoleId(UUIDUtil.getUniqueIdByUUId());
        role.setStatus(1);
        role.setCreateTime(new Date());
        return roleMapper.insert(role);
    }

    @Override
    public int updateStatusBatch(List<String> roleIds, Integer status) {
        Map<String,Object> params = new HashMap<String,Object>(2);
        params.put("roleIds",roleIds);
        params.put("status",status);
        return roleMapper.updateStatusBatch(params);
    }

    @Override
    public SysRole findById(Integer id) {
        SysRole role = new SysRole();
        role.setId(id);
        return roleMapper.selectByPrimaryKey(role);
    }

    @Override
    public int updateByRoleId(SysRole role) {
        Map<String,Object> params  = new HashMap<>(3);
        params.put("name",role.getName());
        params.put("description",role.getDescription());
        params.put("role_id",role.getRoleId());
        return roleMapper.updateByRoleId(params);
    }

    @Override
    public List<SysPermission> findPermissionsByRoleId(String roleId) {
        return permissionMapper.findByRoleId(roleId);
    }

    @Override
    public ResponseVo addAssignPermission(String roleId, List<String> permissionIds) {
        try{
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRoleId(roleId);
            rolePermissionMapper.delete(rolePermission);
            for(String permissionId : permissionIds){
                rolePermission.setId(null);
                rolePermission.setPermissionId(permissionId);
                rolePermissionMapper.insert(rolePermission);
            }
            return ResultUtil.success("分配权限成功");
        }catch(Exception e){
            return ResultUtil.error("分配权限失败");
        }
    }

    @Override
    public List<SysUser> findByRoleId(String roleId) {
        return userMapper.findByRoleId(roleId);
    }

    @Override
    public List<SysUser> findByRoleIds(List<String> roleIds) {
        return userMapper.findByRoleIds(roleIds);
    }

}
