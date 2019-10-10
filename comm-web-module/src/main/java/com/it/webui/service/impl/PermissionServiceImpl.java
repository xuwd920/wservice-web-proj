package com.it.webui.service.impl;

import com.it.webui.mapper.SysPermissionMapper;
import com.it.webui.model.SysPermission;
import com.it.webui.service.PermissionService;
import com.it.webui.util.CoreConst;
import com.it.webui.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
/**
 * @version V1.0
 * @date 2018年7月11日
 *  
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public Set<String> findPermsByUserId(String userId) {
        return permissionMapper.findPermsByUserId(userId);
    }

    @Override
    public List<SysPermission> selectAll(Integer status) {
        return permissionMapper.selectAllPerms(status);
    }

    @Override
    public List<SysPermission> selectAllMenuName(Integer status) {
        return permissionMapper.selectAllMenuName(status);
    }

    @Override
    public List<SysPermission> selectMenuByUserId(String userId) {
        return permissionMapper.selectMenuByUserId(userId);
    }

    @Override
    public int insert(SysPermission permission) {
        Date date = new Date();
        permission.setPermissionId(UUIDUtil.getUniqueIdByUUId());
        permission.setStatus(CoreConst.STATUS_VALID);
        permission.setCreateTime(date);
        permission.setUpdateTime(date);
        return permissionMapper.insert(permission);
    }

    @Override
    public int updateStatus(String  permissionId,Integer status) {
        return permissionMapper.updateStatusByPermissionId(permissionId,status);
    }

    @Override
    public SysPermission findByPermissionId(String permissionId) {
        return permissionMapper.selectByPermissionId(permissionId);
    }

    @Override
    public SysPermission findById(Integer id) {
        SysPermission permission = new SysPermission();
        permission.setId(id);
        return permissionMapper.selectByPrimaryKey(permission);
    }

    @Override
    public int updateByPermissionId(SysPermission permission) {
        return permissionMapper.updateByPermissionId(permission);
    }

    @Override
    public int selectSubPermsByPermissionId(String permissionId) {
        return permissionMapper.selectSubPermsByPermissionId(permissionId);
    }
}
