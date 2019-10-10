package com.it.webui.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sonar_filerule")
public class SonarFilerule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_id")
    private Integer projectId;

    private String filename;

    /**
     * 规则id
     */
    private String rule;

    /**
     * 严重程度
     */
    private String severity;

    /**
     * 问题类型
     */
    private String issuetype;

    /**
     * 规则描述
     */
    private String message;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * sonar中对应的问题key
     */
    private String key;

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
     * @return project_id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 获取规则id
     *
     * @return rule - 规则id
     */
    public String getRule() {
        return rule;
    }

    /**
     * 设置规则id
     *
     * @param rule 规则id
     */
    public void setRule(String rule) {
        this.rule = rule;
    }

    /**
     * 获取严重程度
     *
     * @return severity - 严重程度
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * 设置严重程度
     *
     * @param severity 严重程度
     */
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * 获取问题类型
     *
     * @return issuetype - 问题类型
     */
    public String getIssuetype() {
        return issuetype;
    }

    /**
     * 设置问题类型
     *
     * @param issuetype 问题类型
     */
    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    /**
     * 获取规则描述
     *
     * @return message - 规则描述
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置规则描述
     *
     * @param message 规则描述
     */
    public void setMessage(String message) {
        this.message = message;
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
     * 获取sonar中对应的问题key
     *
     * @return key - sonar中对应的问题key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置sonar中对应的问题key
     *
     * @param key sonar中对应的问题key
     */
    public void setKey(String key) {
        this.key = key;
    }
}