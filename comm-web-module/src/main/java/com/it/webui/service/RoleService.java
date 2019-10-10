package com.it.webui.service;

import com.it.webui.model.SysPermission;
import com.it.webui.model.SysRole;
import com.it.webui.model.SysUser;
import com.it.webui.vo.base.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * @version V1.0
 * @date 2018年7月11日
 *  
 */
public interface RoleService {

    /**
     * 根据用户id查询角色集合
     * @param userId
     * @return set
     */
    Set<String> findRoleByUserId(String userId);

    /**
     * 根据条件查询角色列表
     * @param role
     * @return list
     */
    List<SysRole> selectRoles(SysRole role);

    /**
     * 插入角色
     * @param role
     * @return int
     */
    int insert(SysRole role);

    /**
     * 批量更新状态
     * @param roleIds
     * @param status
     * @return int
     */
    int updateStatusBatch(List<String> roleIds, Integer status);

    /**
     * 根据id查询角色
     * @param id
     * @return role
     */
    SysRole findById(Integer id);

    /**
     * 根据角色id更新角色信息
     * @param role
     * @return int
     */
    int updateByRoleId(SysRole role);

    /**
     * 根据角色id查询权限集合
     * @param roleId
     * @return list
     */
    List<SysPermission> findPermissionsByRoleId(String roleId);

    /**
     * 根据角色id保存分配权限
     * @param roleId
     * @param permissionIdsList
     * @return list
     */
    ResponseVo addAssignPermission(String roleId, List<String> permissionIdsList);

    /**
     * 根据角色id下的所有用户
     * @param roleId
     * @return list
     */
    List<SysUser> findByRoleId(String roleId);

    /**
     * 根据角色id下的所有用户
     * @param roleIds
     * @return list
     */
    List<SysUser> findByRoleIds(List<String> roleIds);


}
