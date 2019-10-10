package com.it.webui.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "svn_project_group")
public class SvnProjectGroup {
    /**
     * 项目组id
     */
    @Id
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * 项目组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 项目组目录路径
     */
    @Column(name = "group_path")
    private String groupPath;
    /**
     * 项目组描述
     */
    private String description;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * 获取项目组id
     *
     * @return group_id - 项目组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置项目组id
     *
     * @param groupId 项目组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取项目组名称
     *
     * @return group_name - 项目组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置项目组名称
     *
     * @param groupName 项目组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取项目组目录路径
     *
     * @return group_path - 项目组目录路径
     */
    public String getGroupPath() {
        return groupPath;
    }

    /**
     * 设置项目组目录路径
     *
     * @param groupPath 项目组目录路径
     */
    public void setGroupPath(String groupPath) {
        this.groupPath = groupPath;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}