package com.it.webui.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sonar_fileinfo")
public class SonarFileinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Integer projectId;

    private String filename;

    /**
     * 提交人
     */
    private String author;

    /**
     * 本次提交时间
     */
    @Column(name = "commit_time")
    private Date commitTime;

    /**
     * 上次提交时间
     */
    @Column(name = "lastcommit_time")
    private Date lastcommitTime;

    /**
     * 提交版本
     */
    @Column(name = "commit_revision")
    private String commitRevision;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 代码行数
     */
    private Integer filelines;

    /**
     * 有效代码行数
     */
    private Integer ncloc;

    /**
     * 注释行数
     */
    @Column(name = "comment_lines")
    private Integer commentLines;

    /**
     * 注释率
     */
    @Column(name = "comment_lines_density")
    private Float commentLinesDensity;

    /**
     * 目录数
     */
    private Integer directories;

    /**
     * 类数
     */
    private Integer classes;

    /**
     * 声明个数
     */
    private Integer statements;

    /**
     * 方法数
     */
    private Integer functions;

    /**
     * 坏味道
     */
    @Column(name = "code_smells")
    private Integer codeSmells;

    /**
     * bug数
     */
    private Integer bugs;

    /**
     * 漏洞数
     */
    private Integer vulnerabilities;

    /**
     * 覆盖率
     */
    private Float coverage;

    /**
     * 行覆盖率
     */
    @Column(name = "line_coverage")
    private Float lineCoverage;

    /**
     * 单元测试成功率
     */
    @Column(name = "test_success_density")
    private Float testSuccessDensity;

    /**
     * 需要覆盖的代码行
     */
    @Column(name = "lines_to_cover")
    private Integer linesToCover;

    /**
     * 未覆盖的代码行
     */
    @Column(name = "uncovered_lines")
    private Integer uncoveredLines;

    /**
     * 单元测试失败数
     */
    @Column(name = "test_failures")
    private Integer testFailures;

    /**
     * 单元测试错误数
     */
    @Column(name = "test_errors")
    private Integer testErrors;

    /**
     * 单元测试忽略数
     */
    @Column(name = "skipped_tests")
    private Integer skippedTests;

    /**
     * 重复密度
     */
    @Column(name = "duplicated_lines_density")
    private Float duplicatedLinesDensity;

    /**
     * 重复块
     */
    @Column(name = "duplicated_blocks")
    private Integer duplicatedBlocks;

    /**
     * 重复文件
     */
    @Column(name = "duplicated_files")
    private Integer duplicatedFiles;

    /**
     * 重复行
     */
    @Column(name = "duplicated_lines")
    private Integer duplicatedLines;

    /**
     * 阻断违规
     */
    @Column(name = "blocker_violations")
    private Integer blockerViolations;

    /**
     * 严重违规
     */
    @Column(name = "critical_violations")
    private Integer criticalViolations;

    /**
     * 主要违规
     */
    @Column(name = "major_violations")
    private Integer majorViolations;

    /**
     * 次要违规
     */
    @Column(name = "minor_violations")
    private Integer minorViolations;

    /**
     * 提示违规
     */
    @Column(name = "info_violations")
    private Integer infoViolations;

    /**
     * 新增行数
     */
    @Column(name = "new_lines")
    private Integer newLines;

    /**
     * 违规总数
     */
    private Integer violations;

    /**
     * 技术债务
     */
    @Column(name = "sqale_index")
    private Integer sqaleIndex;

    /**
     * 复杂度
     */
    private Integer complexity;

    /**
     * 认知复杂度
     */
    @Column(name = "cognitive_complexity")
    private Integer cognitiveComplexity;

    /**
     * 提交类型
     */
    private String modifytype;

    /**
     * 新增次要违规数
     */
    @Column(name = "new_minor_violations")
    private Integer newMinorViolations;

    /**
     * 新增严重违规数
     */
    @Column(name = "new_critical_violations")
    private Integer newCriticalViolations;

    /**
     * 新增主要违规数
     */
    @Column(name = "new_major_violations")
    private Integer newMajorViolations;

    /**
     * 新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     */
    @Column(name = "new_reliability_rating")
    private Float newReliabilityRating;

    /**
     * 新增阻断违规数
     */
    @Column(name = "new_blocker_violations")
    private Integer newBlockerViolations;

    /**
     * 新增需要覆盖的代码行
     */
    @Column(name = "new_lines_to_cover")
    private Integer newLinesToCover;

    /**
     * 新增技术债务
     */
    @Column(name = "new_technical_debt")
    private Integer newTechnicalDebt;

    /**
     * 新增提示违规数
     */
    @Column(name = "new_info_violations")
    private Integer newInfoViolations;

    /**
     * 新增未覆盖的代码行
     */
    @Column(name = "new_uncovered_lines")
    private Integer newUncoveredLines;

    /**
     * 新代码的可靠性修复工作
     */
    @Column(name = "new_reliability_remediation_effort")
    private Integer newReliabilityRemediationEffort;

    /**
     * 新增违规数
     */
    @Column(name = "new_violations")
    private Integer newViolations;

    /**
     * 新增重复块
     */
    @Column(name = "new_duplicated_blocks")
    private Integer newDuplicatedBlocks;

    /**
     * 新的或更新代码的条件覆盖数 
     */
    @Column(name = "new_conditions_to_cover")
    private Integer newConditionsToCover;

    /**
     * 新代码的技术债务比率
     */
    @Column(name = "new_sqale_debt_ratio")
    private Float newSqaleDebtRatio;

    /**
     * 新的或更新代码中未覆盖的条件数
     */
    @Column(name = "new_uncovered_conditions")
    private Integer newUncoveredConditions;

    /**
     * 新代码安全评级
     */
    @Column(name = "new_security_rating")
    private Float newSecurityRating;

    /**
     * 新增漏洞数
     */
    @Column(name = "new_vulnerabilities")
    private Integer newVulnerabilities;

    /**
     * 新增bug数
     */
    @Column(name = "new_bugs")
    private Integer newBugs;

    /**
     * 新增重复行
     */
    @Column(name = "new_duplicated_lines")
    private Integer newDuplicatedLines;

    /**
     * 新增坏味道
     */
    @Column(name = "new_code_smells")
    private Integer newCodeSmells;

    /**
     * 新增代码可靠性评级
     */
    @Column(name = "new_maintainability_rating")
    private Float newMaintainabilityRating;

    /**
     * 新增代码安全修复工作
     */
    @Column(name = "new_security_remediation_effort")
    private Integer newSecurityRemediationEffort;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
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
     * 获取提交人
     *
     * @return author - 提交人
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置提交人
     *
     * @param author 提交人
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取本次提交时间
     *
     * @return commit_time - 本次提交时间
     */
    public Date getCommitTime() {
        return commitTime;
    }

    /**
     * 设置本次提交时间
     *
     * @param commitTime 本次提交时间
     */
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    /**
     * 获取上次提交时间
     *
     * @return lastcommit_time - 上次提交时间
     */
    public Date getLastcommitTime() {
        return lastcommitTime;
    }

    /**
     * 设置上次提交时间
     *
     * @param lastcommitTime 上次提交时间
     */
    public void setLastcommitTime(Date lastcommitTime) {
        this.lastcommitTime = lastcommitTime;
    }

    /**
     * 获取提交版本
     *
     * @return commit_revision - 提交版本
     */
    public String getCommitRevision() {
        return commitRevision;
    }

    /**
     * 设置提交版本
     *
     * @param commitRevision 提交版本
     */
    public void setCommitRevision(String commitRevision) {
        this.commitRevision = commitRevision;
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
     * 获取代码行数
     *
     * @return filelines - 代码行数
     */
    public Integer getFilelines() {
        return filelines;
    }

    /**
     * 设置代码行数
     *
     * @param filelines 代码行数
     */
    public void setFilelines(Integer filelines) {
        this.filelines = filelines;
    }

    /**
     * 获取有效代码行数
     *
     * @return ncloc - 有效代码行数
     */
    public Integer getNcloc() {
        return ncloc;
    }

    /**
     * 设置有效代码行数
     *
     * @param ncloc 有效代码行数
     */
    public void setNcloc(Integer ncloc) {
        this.ncloc = ncloc;
    }

    /**
     * 获取注释行数
     *
     * @return comment_lines - 注释行数
     */
    public Integer getCommentLines() {
        return commentLines;
    }

    /**
     * 设置注释行数
     *
     * @param commentLines 注释行数
     */
    public void setCommentLines(Integer commentLines) {
        this.commentLines = commentLines;
    }

    /**
     * 获取注释率
     *
     * @return comment_lines_density - 注释率
     */
    public Float getCommentLinesDensity() {
        return commentLinesDensity;
    }

    /**
     * 设置注释率
     *
     * @param commentLinesDensity 注释率
     */
    public void setCommentLinesDensity(Float commentLinesDensity) {
        this.commentLinesDensity = commentLinesDensity;
    }

    /**
     * 获取目录数
     *
     * @return directories - 目录数
     */
    public Integer getDirectories() {
        return directories;
    }

    /**
     * 设置目录数
     *
     * @param directories 目录数
     */
    public void setDirectories(Integer directories) {
        this.directories = directories;
    }

    /**
     * 获取类数
     *
     * @return classes - 类数
     */
    public Integer getClasses() {
        return classes;
    }

    /**
     * 设置类数
     *
     * @param classes 类数
     */
    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    /**
     * 获取声明个数
     *
     * @return statements - 声明个数
     */
    public Integer getStatements() {
        return statements;
    }

    /**
     * 设置声明个数
     *
     * @param statements 声明个数
     */
    public void setStatements(Integer statements) {
        this.statements = statements;
    }

    /**
     * 获取方法数
     *
     * @return functions - 方法数
     */
    public Integer getFunctions() {
        return functions;
    }

    /**
     * 设置方法数
     *
     * @param functions 方法数
     */
    public void setFunctions(Integer functions) {
        this.functions = functions;
    }

    /**
     * 获取坏味道
     *
     * @return code_smells - 坏味道
     */
    public Integer getCodeSmells() {
        return codeSmells;
    }

    /**
     * 设置坏味道
     *
     * @param codeSmells 坏味道
     */
    public void setCodeSmells(Integer codeSmells) {
        this.codeSmells = codeSmells;
    }

    /**
     * 获取bug数
     *
     * @return bugs - bug数
     */
    public Integer getBugs() {
        return bugs;
    }

    /**
     * 设置bug数
     *
     * @param bugs bug数
     */
    public void setBugs(Integer bugs) {
        this.bugs = bugs;
    }

    /**
     * 获取漏洞数
     *
     * @return vulnerabilities - 漏洞数
     */
    public Integer getVulnerabilities() {
        return vulnerabilities;
    }

    /**
     * 设置漏洞数
     *
     * @param vulnerabilities 漏洞数
     */
    public void setVulnerabilities(Integer vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    /**
     * 获取覆盖率
     *
     * @return coverage - 覆盖率
     */
    public Float getCoverage() {
        return coverage;
    }

    /**
     * 设置覆盖率
     *
     * @param coverage 覆盖率
     */
    public void setCoverage(Float coverage) {
        this.coverage = coverage;
    }

    /**
     * 获取行覆盖率
     *
     * @return line_coverage - 行覆盖率
     */
    public Float getLineCoverage() {
        return lineCoverage;
    }

    /**
     * 设置行覆盖率
     *
     * @param lineCoverage 行覆盖率
     */
    public void setLineCoverage(Float lineCoverage) {
        this.lineCoverage = lineCoverage;
    }

    /**
     * 获取单元测试成功率
     *
     * @return test_success_density - 单元测试成功率
     */
    public Float getTestSuccessDensity() {
        return testSuccessDensity;
    }

    /**
     * 设置单元测试成功率
     *
     * @param testSuccessDensity 单元测试成功率
     */
    public void setTestSuccessDensity(Float testSuccessDensity) {
        this.testSuccessDensity = testSuccessDensity;
    }

    /**
     * 获取需要覆盖的代码行
     *
     * @return lines_to_cover - 需要覆盖的代码行
     */
    public Integer getLinesToCover() {
        return linesToCover;
    }

    /**
     * 设置需要覆盖的代码行
     *
     * @param linesToCover 需要覆盖的代码行
     */
    public void setLinesToCover(Integer linesToCover) {
        this.linesToCover = linesToCover;
    }

    /**
     * 获取未覆盖的代码行
     *
     * @return uncovered_lines - 未覆盖的代码行
     */
    public Integer getUncoveredLines() {
        return uncoveredLines;
    }

    /**
     * 设置未覆盖的代码行
     *
     * @param uncoveredLines 未覆盖的代码行
     */
    public void setUncoveredLines(Integer uncoveredLines) {
        this.uncoveredLines = uncoveredLines;
    }

    /**
     * 获取单元测试失败数
     *
     * @return test_failures - 单元测试失败数
     */
    public Integer getTestFailures() {
        return testFailures;
    }

    /**
     * 设置单元测试失败数
     *
     * @param testFailures 单元测试失败数
     */
    public void setTestFailures(Integer testFailures) {
        this.testFailures = testFailures;
    }

    /**
     * 获取单元测试错误数
     *
     * @return test_errors - 单元测试错误数
     */
    public Integer getTestErrors() {
        return testErrors;
    }

    /**
     * 设置单元测试错误数
     *
     * @param testErrors 单元测试错误数
     */
    public void setTestErrors(Integer testErrors) {
        this.testErrors = testErrors;
    }

    /**
     * 获取单元测试忽略数
     *
     * @return skipped_tests - 单元测试忽略数
     */
    public Integer getSkippedTests() {
        return skippedTests;
    }

    /**
     * 设置单元测试忽略数
     *
     * @param skippedTests 单元测试忽略数
     */
    public void setSkippedTests(Integer skippedTests) {
        this.skippedTests = skippedTests;
    }

    /**
     * 获取重复密度
     *
     * @return duplicated_lines_density - 重复密度
     */
    public Float getDuplicatedLinesDensity() {
        return duplicatedLinesDensity;
    }

    /**
     * 设置重复密度
     *
     * @param duplicatedLinesDensity 重复密度
     */
    public void setDuplicatedLinesDensity(Float duplicatedLinesDensity) {
        this.duplicatedLinesDensity = duplicatedLinesDensity;
    }

    /**
     * 获取重复块
     *
     * @return duplicated_blocks - 重复块
     */
    public Integer getDuplicatedBlocks() {
        return duplicatedBlocks;
    }

    /**
     * 设置重复块
     *
     * @param duplicatedBlocks 重复块
     */
    public void setDuplicatedBlocks(Integer duplicatedBlocks) {
        this.duplicatedBlocks = duplicatedBlocks;
    }

    /**
     * 获取重复文件
     *
     * @return duplicated_files - 重复文件
     */
    public Integer getDuplicatedFiles() {
        return duplicatedFiles;
    }

    /**
     * 设置重复文件
     *
     * @param duplicatedFiles 重复文件
     */
    public void setDuplicatedFiles(Integer duplicatedFiles) {
        this.duplicatedFiles = duplicatedFiles;
    }

    /**
     * 获取重复行
     *
     * @return duplicated_lines - 重复行
     */
    public Integer getDuplicatedLines() {
        return duplicatedLines;
    }

    /**
     * 设置重复行
     *
     * @param duplicatedLines 重复行
     */
    public void setDuplicatedLines(Integer duplicatedLines) {
        this.duplicatedLines = duplicatedLines;
    }

    /**
     * 获取阻断违规
     *
     * @return blocker_violations - 阻断违规
     */
    public Integer getBlockerViolations() {
        return blockerViolations;
    }

    /**
     * 设置阻断违规
     *
     * @param blockerViolations 阻断违规
     */
    public void setBlockerViolations(Integer blockerViolations) {
        this.blockerViolations = blockerViolations;
    }

    /**
     * 获取严重违规
     *
     * @return critical_violations - 严重违规
     */
    public Integer getCriticalViolations() {
        return criticalViolations;
    }

    /**
     * 设置严重违规
     *
     * @param criticalViolations 严重违规
     */
    public void setCriticalViolations(Integer criticalViolations) {
        this.criticalViolations = criticalViolations;
    }

    /**
     * 获取主要违规
     *
     * @return major_violations - 主要违规
     */
    public Integer getMajorViolations() {
        return majorViolations;
    }

    /**
     * 设置主要违规
     *
     * @param majorViolations 主要违规
     */
    public void setMajorViolations(Integer majorViolations) {
        this.majorViolations = majorViolations;
    }

    /**
     * 获取次要违规
     *
     * @return minor_violations - 次要违规
     */
    public Integer getMinorViolations() {
        return minorViolations;
    }

    /**
     * 设置次要违规
     *
     * @param minorViolations 次要违规
     */
    public void setMinorViolations(Integer minorViolations) {
        this.minorViolations = minorViolations;
    }

    /**
     * 获取提示违规
     *
     * @return info_violations - 提示违规
     */
    public Integer getInfoViolations() {
        return infoViolations;
    }

    /**
     * 设置提示违规
     *
     * @param infoViolations 提示违规
     */
    public void setInfoViolations(Integer infoViolations) {
        this.infoViolations = infoViolations;
    }

    /**
     * 获取新增行数
     *
     * @return new_lines - 新增行数
     */
    public Integer getNewLines() {
        return newLines;
    }

    /**
     * 设置新增行数
     *
     * @param newLines 新增行数
     */
    public void setNewLines(Integer newLines) {
        this.newLines = newLines;
    }

    /**
     * 获取违规总数
     *
     * @return violations - 违规总数
     */
    public Integer getViolations() {
        return violations;
    }

    /**
     * 设置违规总数
     *
     * @param violations 违规总数
     */
    public void setViolations(Integer violations) {
        this.violations = violations;
    }

    /**
     * 获取技术债务
     *
     * @return sqale_index - 技术债务
     */
    public Integer getSqaleIndex() {
        return sqaleIndex;
    }

    /**
     * 设置技术债务
     *
     * @param sqaleIndex 技术债务
     */
    public void setSqaleIndex(Integer sqaleIndex) {
        this.sqaleIndex = sqaleIndex;
    }

    /**
     * 获取复杂度
     *
     * @return complexity - 复杂度
     */
    public Integer getComplexity() {
        return complexity;
    }

    /**
     * 设置复杂度
     *
     * @param complexity 复杂度
     */
    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    /**
     * 获取认知复杂度
     *
     * @return cognitive_complexity - 认知复杂度
     */
    public Integer getCognitiveComplexity() {
        return cognitiveComplexity;
    }

    /**
     * 设置认知复杂度
     *
     * @param cognitiveComplexity 认知复杂度
     */
    public void setCognitiveComplexity(Integer cognitiveComplexity) {
        this.cognitiveComplexity = cognitiveComplexity;
    }

    /**
     * 获取提交类型
     *
     * @return modifytype - 提交类型
     */
    public String getModifytype() {
        return modifytype;
    }

    /**
     * 设置提交类型
     *
     * @param modifytype 提交类型
     */
    public void setModifytype(String modifytype) {
        this.modifytype = modifytype;
    }

    /**
     * 获取新增次要违规数
     *
     * @return new_minor_violations - 新增次要违规数
     */
    public Integer getNewMinorViolations() {
        return newMinorViolations;
    }

    /**
     * 设置新增次要违规数
     *
     * @param newMinorViolations 新增次要违规数
     */
    public void setNewMinorViolations(Integer newMinorViolations) {
        this.newMinorViolations = newMinorViolations;
    }

    /**
     * 获取新增严重违规数
     *
     * @return new_critical_violations - 新增严重违规数
     */
    public Integer getNewCriticalViolations() {
        return newCriticalViolations;
    }

    /**
     * 设置新增严重违规数
     *
     * @param newCriticalViolations 新增严重违规数
     */
    public void setNewCriticalViolations(Integer newCriticalViolations) {
        this.newCriticalViolations = newCriticalViolations;
    }

    /**
     * 获取新增主要违规数
     *
     * @return new_major_violations - 新增主要违规数
     */
    public Integer getNewMajorViolations() {
        return newMajorViolations;
    }

    /**
     * 设置新增主要违规数
     *
     * @param newMajorViolations 新增主要违规数
     */
    public void setNewMajorViolations(Integer newMajorViolations) {
        this.newMajorViolations = newMajorViolations;
    }

    /**
     * 获取新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     *
     * @return new_reliability_rating - 新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     */
    public Float getNewReliabilityRating() {
        return newReliabilityRating;
    }

    /**
     * 设置新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     *
     * @param newReliabilityRating 新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     */
    public void setNewReliabilityRating(Float newReliabilityRating) {
        this.newReliabilityRating = newReliabilityRating;
    }

    /**
     * 获取新增阻断违规数
     *
     * @return new_blocker_violations - 新增阻断违规数
     */
    public Integer getNewBlockerViolations() {
        return newBlockerViolations;
    }

    /**
     * 设置新增阻断违规数
     *
     * @param newBlockerViolations 新增阻断违规数
     */
    public void setNewBlockerViolations(Integer newBlockerViolations) {
        this.newBlockerViolations = newBlockerViolations;
    }

    /**
     * 获取新增需要覆盖的代码行
     *
     * @return new_lines_to_cover - 新增需要覆盖的代码行
     */
    public Integer getNewLinesToCover() {
        return newLinesToCover;
    }

    /**
     * 设置新增需要覆盖的代码行
     *
     * @param newLinesToCover 新增需要覆盖的代码行
     */
    public void setNewLinesToCover(Integer newLinesToCover) {
        this.newLinesToCover = newLinesToCover;
    }

    /**
     * 获取新增技术债务
     *
     * @return new_technical_debt - 新增技术债务
     */
    public Integer getNewTechnicalDebt() {
        return newTechnicalDebt;
    }

    /**
     * 设置新增技术债务
     *
     * @param newTechnicalDebt 新增技术债务
     */
    public void setNewTechnicalDebt(Integer newTechnicalDebt) {
        this.newTechnicalDebt = newTechnicalDebt;
    }

    /**
     * 获取新增提示违规数
     *
     * @return new_info_violations - 新增提示违规数
     */
    public Integer getNewInfoViolations() {
        return newInfoViolations;
    }

    /**
     * 设置新增提示违规数
     *
     * @param newInfoViolations 新增提示违规数
     */
    public void setNewInfoViolations(Integer newInfoViolations) {
        this.newInfoViolations = newInfoViolations;
    }

    /**
     * 获取新增未覆盖的代码行
     *
     * @return new_uncovered_lines - 新增未覆盖的代码行
     */
    public Integer getNewUncoveredLines() {
        return newUncoveredLines;
    }

    /**
     * 设置新增未覆盖的代码行
     *
     * @param newUncoveredLines 新增未覆盖的代码行
     */
    public void setNewUncoveredLines(Integer newUncoveredLines) {
        this.newUncoveredLines = newUncoveredLines;
    }

    /**
     * 获取新代码的可靠性修复工作
     *
     * @return new_reliability_remediation_effort - 新代码的可靠性修复工作
     */
    public Integer getNewReliabilityRemediationEffort() {
        return newReliabilityRemediationEffort;
    }

    /**
     * 设置新代码的可靠性修复工作
     *
     * @param newReliabilityRemediationEffort 新代码的可靠性修复工作
     */
    public void setNewReliabilityRemediationEffort(Integer newReliabilityRemediationEffort) {
        this.newReliabilityRemediationEffort = newReliabilityRemediationEffort;
    }

    /**
     * 获取新增违规数
     *
     * @return new_violations - 新增违规数
     */
    public Integer getNewViolations() {
        return newViolations;
    }

    /**
     * 设置新增违规数
     *
     * @param newViolations 新增违规数
     */
    public void setNewViolations(Integer newViolations) {
        this.newViolations = newViolations;
    }

    /**
     * 获取新增重复块
     *
     * @return new_duplicated_blocks - 新增重复块
     */
    public Integer getNewDuplicatedBlocks() {
        return newDuplicatedBlocks;
    }

    /**
     * 设置新增重复块
     *
     * @param newDuplicatedBlocks 新增重复块
     */
    public void setNewDuplicatedBlocks(Integer newDuplicatedBlocks) {
        this.newDuplicatedBlocks = newDuplicatedBlocks;
    }

    /**
     * 获取新的或更新代码的条件覆盖数 
     *
     * @return new_conditions_to_cover - 新的或更新代码的条件覆盖数 
     */
    public Integer getNewConditionsToCover() {
        return newConditionsToCover;
    }

    /**
     * 设置新的或更新代码的条件覆盖数 
     *
     * @param newConditionsToCover 新的或更新代码的条件覆盖数 
     */
    public void setNewConditionsToCover(Integer newConditionsToCover) {
        this.newConditionsToCover = newConditionsToCover;
    }

    /**
     * 获取新代码的技术债务比率
     *
     * @return new_sqale_debt_ratio - 新代码的技术债务比率
     */
    public Float getNewSqaleDebtRatio() {
        return newSqaleDebtRatio;
    }

    /**
     * 设置新代码的技术债务比率
     *
     * @param newSqaleDebtRatio 新代码的技术债务比率
     */
    public void setNewSqaleDebtRatio(Float newSqaleDebtRatio) {
        this.newSqaleDebtRatio = newSqaleDebtRatio;
    }

    /**
     * 获取新的或更新代码中未覆盖的条件数
     *
     * @return new_uncovered_conditions - 新的或更新代码中未覆盖的条件数
     */
    public Integer getNewUncoveredConditions() {
        return newUncoveredConditions;
    }

    /**
     * 设置新的或更新代码中未覆盖的条件数
     *
     * @param newUncoveredConditions 新的或更新代码中未覆盖的条件数
     */
    public void setNewUncoveredConditions(Integer newUncoveredConditions) {
        this.newUncoveredConditions = newUncoveredConditions;
    }

    /**
     * 获取新代码安全评级
     *
     * @return new_security_rating - 新代码安全评级
     */
    public Float getNewSecurityRating() {
        return newSecurityRating;
    }

    /**
     * 设置新代码安全评级
     *
     * @param newSecurityRating 新代码安全评级
     */
    public void setNewSecurityRating(Float newSecurityRating) {
        this.newSecurityRating = newSecurityRating;
    }

    /**
     * 获取新增漏洞数
     *
     * @return new_vulnerabilities - 新增漏洞数
     */
    public Integer getNewVulnerabilities() {
        return newVulnerabilities;
    }

    /**
     * 设置新增漏洞数
     *
     * @param newVulnerabilities 新增漏洞数
     */
    public void setNewVulnerabilities(Integer newVulnerabilities) {
        this.newVulnerabilities = newVulnerabilities;
    }

    /**
     * 获取新增bug数
     *
     * @return new_bugs - 新增bug数
     */
    public Integer getNewBugs() {
        return newBugs;
    }

    /**
     * 设置新增bug数
     *
     * @param newBugs 新增bug数
     */
    public void setNewBugs(Integer newBugs) {
        this.newBugs = newBugs;
    }

    /**
     * 获取新增重复行
     *
     * @return new_duplicated_lines - 新增重复行
     */
    public Integer getNewDuplicatedLines() {
        return newDuplicatedLines;
    }

    /**
     * 设置新增重复行
     *
     * @param newDuplicatedLines 新增重复行
     */
    public void setNewDuplicatedLines(Integer newDuplicatedLines) {
        this.newDuplicatedLines = newDuplicatedLines;
    }

    /**
     * 获取新增坏味道
     *
     * @return new_code_smells - 新增坏味道
     */
    public Integer getNewCodeSmells() {
        return newCodeSmells;
    }

    /**
     * 设置新增坏味道
     *
     * @param newCodeSmells 新增坏味道
     */
    public void setNewCodeSmells(Integer newCodeSmells) {
        this.newCodeSmells = newCodeSmells;
    }

    /**
     * 获取新增代码可靠性评级
     *
     * @return new_maintainability_rating - 新增代码可靠性评级
     */
    public Float getNewMaintainabilityRating() {
        return newMaintainabilityRating;
    }

    /**
     * 设置新增代码可靠性评级
     *
     * @param newMaintainabilityRating 新增代码可靠性评级
     */
    public void setNewMaintainabilityRating(Float newMaintainabilityRating) {
        this.newMaintainabilityRating = newMaintainabilityRating;
    }

    /**
     * 获取新增代码安全修复工作
     *
     * @return new_security_remediation_effort - 新增代码安全修复工作
     */
    public Integer getNewSecurityRemediationEffort() {
        return newSecurityRemediationEffort;
    }

    /**
     * 设置新增代码安全修复工作
     *
     * @param newSecurityRemediationEffort 新增代码安全修复工作
     */
    public void setNewSecurityRemediationEffort(Integer newSecurityRemediationEffort) {
        this.newSecurityRemediationEffort = newSecurityRemediationEffort;
    }
}