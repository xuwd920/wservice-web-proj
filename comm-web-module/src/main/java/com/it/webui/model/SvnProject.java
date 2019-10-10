package com.it.webui.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "svn_project")
public class SvnProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目在sonar中的标识，maven项目为pom.xml中的name部分，c项目为sonar-project.properties 中的sonar.projectName配置
     */
    @Column(name = "artifactId")
    private String artifactid;

    /**
     * 项目在svn中的路径，不包含svn_url部分
     */
    @Column(name = "svn_path")
    private String svnPath;

    /**
     * 1：maven项目
2：c项目

     */
    @Column(name = "project_type")
    private Integer projectType;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 扫描周期，单位为天
     */
    @Column(name = "check_cycle")
    private String checkCycle;

    /**
     * 项目在编译环境上的路径
     */
    @Column(name = "remote_path")
    private String remotePath;

    /**
     * 编译主机
     */
    @Column(name = "remote_ip")
    private String remoteIp;

    /**
     * 编译主机ssh端口
     */
    @Column(name = "remote_port")
    private String remotePort;

    /**
     * 用户名
     */
    @Column(name = "remote_user")
    private String remoteUser;

    /**
     * 密码
     */
    @Column(name = "remote_password")
    private String remotePassword;

    /**
     * 环境变量文件，java项目需要
     */
    @Column(name = "env_file")
    private String envFile;

    /**
     * 上次扫描时间
     */
    @Column(name = "last_checktime")
    private Date lastChecktime;

    private String creator;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 项目组id
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return project_name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取项目在sonar中的标识，maven项目为pom.xml中的name部分，c项目为sonar-project.properties 中的sonar.projectName配置
     *
     * @return artifactId - 项目在sonar中的标识，maven项目为pom.xml中的name部分，c项目为sonar-project.properties 中的sonar.projectName配置
     */
    public String getArtifactid() {
        return artifactid;
    }

    /**
     * 设置项目在sonar中的标识，maven项目为pom.xml中的name部分，c项目为sonar-project.properties 中的sonar.projectName配置
     *
     * @param artifactid 项目在sonar中的标识，maven项目为pom.xml中的name部分，c项目为sonar-project.properties 中的sonar.projectName配置
     */
    public void setArtifactid(String artifactid) {
        this.artifactid = artifactid;
    }

    /**
     * 获取项目在svn中的路径，不包含svn_url部分
     *
     * @return svn_path - 项目在svn中的路径，不包含svn_url部分
     */
    public String getSvnPath() {
        return svnPath;
    }

    /**
     * 设置项目在svn中的路径，不包含svn_url部分
     *
     * @param svnPath 项目在svn中的路径，不包含svn_url部分
     */
    public void setSvnPath(String svnPath) {
        this.svnPath = svnPath;
    }

    /**
     * 获取1：maven项目
2：c项目

     *
     * @return project_type - 1：maven项目
2：c项目

     */
    public Integer getProjectType() {
        return projectType;
    }

    /**
     * 设置1：maven项目
2：c项目

     *
     * @param projectType 1：maven项目
2：c项目

     */
    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    /**
     * 获取项目描述
     *
     * @return description - 项目描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置项目描述
     *
     * @param description 项目描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取扫描周期，单位为天
     *
     * @return check_cycle - 扫描周期，单位为天
     */
    public String getCheckCycle() {
        return checkCycle;
    }

    /**
     * 设置扫描周期，单位为天
     *
     * @param checkCycle 扫描周期，单位为天
     */
    public void setCheckCycle(String checkCycle) {
        this.checkCycle = checkCycle;
    }

    /**
     * 获取项目在编译环境上的路径
     *
     * @return remote_path - 项目在编译环境上的路径
     */
    public String getRemotePath() {
        return remotePath;
    }

    /**
     * 设置项目在编译环境上的路径
     *
     * @param remotePath 项目在编译环境上的路径
     */
    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    /**
     * 获取编译主机
     *
     * @return remote_ip - 编译主机
     */
    public String getRemoteIp() {
        return remoteIp;
    }

    /**
     * 设置编译主机
     *
     * @param remoteIp 编译主机
     */
    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    /**
     * 获取编译主机ssh端口
     *
     * @return remote_port - 编译主机ssh端口
     */
    public String getRemotePort() {
        return remotePort;
    }

    /**
     * 设置编译主机ssh端口
     *
     * @param remotePort 编译主机ssh端口
     */
    public void setRemotePort(String remotePort) {
        this.remotePort = remotePort;
    }

    /**
     * 获取用户名
     *
     * @return remote_user - 用户名
     */
    public String getRemoteUser() {
        return remoteUser;
    }

    /**
     * 设置用户名
     *
     * @param remoteUser 用户名
     */
    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser;
    }

    /**
     * 获取密码
     *
     * @return remote_password - 密码
     */
    public String getRemotePassword() {
        return remotePassword;
    }

    /**
     * 设置密码
     *
     * @param remotePassword 密码
     */
    public void setRemotePassword(String remotePassword) {
        this.remotePassword = remotePassword;
    }

    /**
     * 获取环境变量文件，java项目需要
     *
     * @return env_file - 环境变量文件，java项目需要
     */
    public String getEnvFile() {
        return envFile;
    }

    /**
     * 设置环境变量文件，java项目需要
     *
     * @param envFile 环境变量文件，java项目需要
     */
    public void setEnvFile(String envFile) {
        this.envFile = envFile;
    }

    /**
     * 获取上次扫描时间
     *
     * @return last_checktime - 上次扫描时间
     */
    public Date getLastChecktime() {
        return lastChecktime;
    }

    /**
     * 设置上次扫描时间
     *
     * @param lastChecktime 上次扫描时间
     */
    public void setLastChecktime(Date lastChecktime) {
        this.lastChecktime = lastChecktime;
    }

    /**
     * @return creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}