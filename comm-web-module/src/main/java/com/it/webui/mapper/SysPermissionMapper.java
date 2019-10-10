package com.it.webui.mapper;

import com.it.webui.model.SysPermission;
import com.it.webui.util.MyMapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;
/**
 * @version V1.0
 * @date 2018年7月11日
 *  
 */
public interface SysPermissionMapper extends MyMapper<SysPermission> {

    /**
     * 根据状态查询全部资源
     * @param status 状态
     * @return the list
     */
    List<SysPermission> selectAllPerms(Integer status);

    /**
     * 根据状态查询全部菜单
     * @param status 状态
     * @return the list
     */
    List<SysPermission> selectAllMenuName(Integer status);

    /**
     * 根据用户id查询权限集合
     * @param userId 状态
     * @return set
     */
    Set<String> findPermsByUserId(String userId);

    /**
     * 根据角色id查询权限
     * @param id 角色id
     * @return the list
     */
    List<SysPermission> findByRoleId(String id);

    /**
     * 根据用户id查询权限
     * @param userId 用户id
     * @return the list
     */
    List<SysPermission> selectByUserId(String userId);

    /**
     * 根据用户id查询菜单
     * @param userId 用户id
     * @return the list
     */
    List<SysPermission> selectMenuByUserId(String userId);

    /**
     * 根据权限id修改状态
     * @param permissionId 权限id
     * @param status 状态
     * @return int
     */
    int updateStatusByPermissionId(@Param("permissionId") String permissionId, @Param("status") Integer status);

    /**
     * 根据权限id查询权限
     * @param permissionId 权限id
     * @return permission
     */
    SysPermission selectByPermissionId(String permissionId);

    /**
     * 根据权限bean修改权限
     * @param permission 权限
     * @return int
     */
    int updateByPermissionId(SysPermission permission);

    /**
     * 根据权限id查询有几个子资源
     * @param permissionId 权限id
     * @return int
     */
    int selectSubPermsByPermissionId(String permissionId);
}