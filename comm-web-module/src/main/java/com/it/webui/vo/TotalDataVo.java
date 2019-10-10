package com.it.webui.vo;

public class TotalDataVo {
	private String groupName;
	private String username;
	private int files;
	private int ncloc;//有效代码行数
	private int bugs;
	private int vulnerabilities;//漏洞数
	private int codeSmells;
	private int complexity;//复杂度
	private int cognitiveComplexity;//认知复杂度
	private int sqaleIndex;
	private String sqaleTime;
	private int violations;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSqaleTime() {
		return sqaleTime;
	}

	public void setSqaleTime(String sqaleTime) {
		this.sqaleTime = sqaleTime;
	}

	public int getNcloc() {
		return ncloc;
	}

	public void setNcloc(int ncloc) {
		this.ncloc = ncloc;
	}

	public int getViolations() {
		return violations;
	}

	public void setViolations(int violations) {
		this.violations = violations;
	}

	public int getFiles() {
		return files;
	}

	public void setFiles(int files) {
		this.files = files;
	}

	public int getBugs() {
		return bugs;
	}

	public void setBugs(int bugs) {
		this.bugs = bugs;
	}

	public int getVulnerabilities() {
		return vulnerabilities;
	}

	public void setVulnerabilities(int vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}

	public int getCodeSmells() {
		return codeSmells;
	}

	public void setCodeSmells(int codeSmells) {
		this.codeSmells = codeSmells;
	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public int getCognitiveComplexity() {
		return cognitiveComplexity;
	}

	public void setCognitiveComplexity(int cognitiveComplexity) {
		this.cognitiveComplexity = cognitiveComplexity;
	}

	public int getSqaleIndex() {
		return sqaleIndex;
	}

	public void setSqaleIndex(int sqaleIndex) {
		this.sqaleIndex = sqaleIndex;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
