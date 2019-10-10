package com.it.webui.service;

import com.it.webui.model.SysUser;
import com.it.webui.vo.UserOnlineVo;
import com.it.webui.vo.base.ResponseVo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * @version V1.0
 * @date 2018年7月11日
 *  
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return user
     */
    SysUser selectByUsername(String username);

    /**
     * 注册用户
     * @param user
     * @return int
     */
    int register(SysUser user);

    /**
     * 更新最后登录时间
     * @param user
     */
    void updateLastLoginTime(SysUser user);

    /**
     * 根据条件查询用户列表
     * @param user
     * @return list
     */
    List<SysUser> selectUsers(SysUser user);

    /**
     * 根据用户id查询用户
     * @param userId
     * @return user
     */
    SysUser selectByUserId(String userId);

    /**
     * 根据用户id更新用户信息
     * @param user
     * @return int
     */
    int updateByUserId(SysUser user);

    /**
     * 根据用户id集合批量更新用户状态
     * @param userIds
     * @param status
     * @return int
     */
    int updateStatusBatch(List<String> userIds, Integer status);

    /**
     * 根据用户id分配角色集合
     * @param userId
     * @param roleIds
     * @return int
     */
    ResponseVo addAssignRole(String userId, List<String> roleIds);

    /**
     * 根据主键更新用户信息
     * @param user
     * @return int
     */
    int updateUserByPrimaryKey(SysUser user);

    /**
     * 查询在线用户
     * @param userOnlineVo
     * @return list
     */
    List<UserOnlineVo> selectOnlineUsers(UserOnlineVo userOnlineVo);

    /**
     * 踢出用户
     * @param sessionId 会话id
     * @param username 用户名
     */
    void kickout(Serializable sessionId, String username);

}
