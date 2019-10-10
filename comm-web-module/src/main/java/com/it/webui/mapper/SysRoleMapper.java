package com.it.webui.mapper;

import com.it.webui.model.SysRole;
import com.it.webui.util.MyMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @version V1.0
 * @date 2018年7月11日
 *  
 */
public interface SysRoleMapper extends MyMapper<SysRole> {
    /**
     * 根据用户id查询角色集合
     * @param userId 用户id
     * @return set
     */
    Set<String> findRoleByUserId(String userId);

    /**
     * 根据role参数查询角色列表
     * @param role role
     * @return list
     */
    List<SysRole> selectRoles(SysRole role);

    /**
     * 根据参数批量更新状态
     * @param params
     * @return int
     */
    int updateStatusBatch(Map<String, Object> params);

    /**
     * 根据roleId更新角色信息
     * @param params
     * @return int
     */
    int updateByRoleId(Map<String, Object> params);



}