package com.it.webui.vo;

/**
 * 项目图表数据模型
 *
 * @author yangzz
 * @version v1.0
 * @date 2019年7月17日
 */
public class ChartProjectVo {

    private String collectDate;
    private int groupId;
    private String groupName;
    private int projectId;
    private String projectName;
    private int bugs;
    private int codeSmells;
    private int vulnerabilities;
    private int blockerViolations;
    private int criticalViolations;
    private int majorViolations;
    private int minorViolations;
    private int infoViolations;
    private int violations;

    public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getBlockerViolations() {
        return blockerViolations;
    }

    public void setBlockerViolations(int blockerViolations) {
        this.blockerViolations = blockerViolations;
    }

    public int getCriticalViolations() {
        return criticalViolations;
    }

    public void setCriticalViolations(int criticalViolations) {
        this.criticalViolations = criticalViolations;
    }

    public int getMajorViolations() {
        return majorViolations;
    }

    public void setMajorViolations(int majorViolations) {
        this.majorViolations = majorViolations;
    }

    public int getMinorViolations() {
        return minorViolations;
    }

    public void setMinorViolations(int minorViolations) {
        this.minorViolations = minorViolations;
    }

    public int getInfoViolations() {
        return infoViolations;
    }

    public void setInfoViolations(int infoViolations) {
        this.infoViolations = infoViolations;
    }

    public int getViolations() {
        return violations;
    }

    public void setViolations(int violations) {
        this.violations = violations;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getBugs() {
        return bugs;
    }

    public void setBugs(int bugs) {
        this.bugs = bugs;
    }

    public int getCodeSmells() {
        return codeSmells;
    }

    public void setCodeSmells(int codeSmells) {
        this.codeSmells = codeSmells;
    }

    public int getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(int vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }


}
