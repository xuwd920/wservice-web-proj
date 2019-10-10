package com.it.webui.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sonar_user_report_daily")
public class SonarUserReportDaily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Integer projectId;

    private String author;

    @Column(name = "collect_date")
    private String collectDate;

    /**
     * 文件数
     */
    @Column(name = "files_count")
    private Integer filesCount;

    /**
     * 行数
     */
    @Column(name = "lines_count")
    private Integer linesCount;

    /**
     * 有效代码行数
     */
    @Column(name = "ncloc_count")
    private Integer nclocCount;

    /**
     * 注释行数
     */
    @Column(name = "comment_lines_count")
    private Integer commentLinesCount;

    /**
     * 注释率
     */
    @Column(name = "comment_lines_density_avg")
    private Float commentLinesDensityAvg;

    /**
     * 目录数
     */
    @Column(name = "directories_count")
    private Integer directoriesCount;

    /**
     * 类数
     */
    @Column(name = "classes_count")
    private Integer classesCount;

    /**
     * 声明个数
     */
    @Column(name = "statements_count")
    private Integer statementsCount;

    /**
     * 方法数
     */
    @Column(name = "functions_count")
    private Integer functionsCount;

    /**
     * 坏味道
     */
    @Column(name = "code_smells_count")
    private Integer codeSmellsCount;

    /**
     * bug数
     */
    @Column(name = "bugs_count")
    private Integer bugsCount;

    /**
     * 漏洞数
     */
    @Column(name = "vulnerabilities_count")
    private Integer vulnerabilitiesCount;

    /**
     * 覆盖率
     */
    @Column(name = "coverage_avg")
    private Float coverageAvg;

    /**
     * 行覆盖率
     */
    @Column(name = "line_coverage_avg")
    private Float lineCoverageAvg;

    /**
     * 单元测试成功率
     */
    @Column(name = "test_success_density_avg")
    private Float testSuccessDensityAvg;

    /**
     * 需要覆盖的代码行
     */
    @Column(name = "lines_to_cover_count")
    private Integer linesToCoverCount;

    /**
     * 未覆盖的代码行
     */
    @Column(name = "uncovered_lines_count")
    private Integer uncoveredLinesCount;

    /**
     * 单元测试失败数
     */
    @Column(name = "test_failures_count")
    private Integer testFailuresCount;

    /**
     * 单元测试错误数
     */
    @Column(name = "test_errors_count")
    private Integer testErrorsCount;

    /**
     * 单元测试忽略数
     */
    @Column(name = "skipped_tests_count")
    private Integer skippedTestsCount;

    /**
     * 重复密度
     */
    @Column(name = "duplicated_lines_density_avg")
    private Float duplicatedLinesDensityAvg;

    /**
     * 重复块
     */
    @Column(name = "duplicated_blocks_count")
    private Integer duplicatedBlocksCount;

    /**
     * 重复文件
     */
    @Column(name = "duplicated_files_count")
    private Integer duplicatedFilesCount;

    /**
     * 重复行
     */
    @Column(name = "duplicated_lines_count")
    private Integer duplicatedLinesCount;

    /**
     * 阻断违规
     */
    @Column(name = "blocker_violations_count")
    private Integer blockerViolationsCount;

    /**
     * 严重违规
     */
    @Column(name = "critical_violations_count")
    private Integer criticalViolationsCount;

    /**
     * 主要违规
     */
    @Column(name = "major_violations_count")
    private Integer majorViolationsCount;

    /**
     * 次要违规
     */
    @Column(name = "minor_violations_count")
    private Integer minorViolationsCount;

    /**
     * 提示违规
     */
    @Column(name = "info_violations_count")
    private Integer infoViolationsCount;

    /**
     * 新增行数
     */
    @Column(name = "new_lines_count")
    private Integer newLinesCount;

    /**
     * 违规总数
     */
    @Column(name = "violations_count")
    private Integer violationsCount;

    /**
     * 技术债务
     */
    @Column(name = "sqale_index_count")
    private Integer sqaleIndexCount;

    /**
     * 复杂度
     */
    @Column(name = "complexity_count")
    private Integer complexityCount;

    /**
     * 认知复杂度
     */
    @Column(name = "cognitive_complexity_count")
    private Integer cognitiveComplexityCount;

    /**
     * 新增主要违规数
     */
    @Column(name = "new_major_violations_count")
    private Integer newMajorViolationsCount;

    /**
     * 新增次要违规数
     */
    @Column(name = "new_minor_violations_count")
    private Integer newMinorViolationsCount;

    /**
     * 新增严重违规数
     */
    @Column(name = "new_critical_violations_count")
    private Integer newCriticalViolationsCount;

    /**
     * 新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     */
    @Column(name = "new_reliability_rating_avg")
    private Float newReliabilityRatingAvg;

    /**
     * 新增阻断违规数
     */
    @Column(name = "new_blocker_violations_count")
    private Integer newBlockerViolationsCount;

    /**
     * 新增需要覆盖的代码行
     */
    @Column(name = "new_lines_to_cover_count")
    private Integer newLinesToCoverCount;

    /**
     * 新增技术债务
     */
    @Column(name = "new_technical_debt_count")
    private Integer newTechnicalDebtCount;

    /**
     * 新增提示违规数
     */
    @Column(name = "new_info_violations_count")
    private Integer newInfoViolationsCount;

    /**
     * 新增未覆盖的代码行
     */
    @Column(name = "new_uncovered_lines_count")
    private Integer newUncoveredLinesCount;

    /**
     * 新代码的可靠性修复工作
     */
    @Column(name = "new_reliability_remediation_effort_count")
    private Integer newReliabilityRemediationEffortCount;

    /**
     * 新增违规数
     */
    @Column(name = "new_violations_count")
    private Integer newViolationsCount;

    /**
     * 新增重复块
     */
    @Column(name = "new_duplicated_blocks_count")
    private Integer newDuplicatedBlocksCount;

    /**
     * 新的或更新代码的条件覆盖数 
     */
    @Column(name = "new_conditions_to_cover_count")
    private Integer newConditionsToCoverCount;

    /**
     * 新代码的技术债务比率
     */
    @Column(name = "new_sqale_debt_ratio_avg")
    private Float newSqaleDebtRatioAvg;

    /**
     * 新的或更新代码中未覆盖的条件数
     */
    @Column(name = "new_uncovered_conditions_count")
    private Integer newUncoveredConditionsCount;

    /**
     * 新代码安全评级
     */
    @Column(name = "new_security_rating_avg")
    private Float newSecurityRatingAvg;

    /**
     * 新增漏洞数
     */
    @Column(name = "new_vulnerabilities_count")
    private Integer newVulnerabilitiesCount;

    /**
     * 新增bug数
     */
    @Column(name = "new_bugs_count")
    private Integer newBugsCount;

    /**
     * 新增重复行
     */
    @Column(name = "new_duplicated_lines_count")
    private Integer newDuplicatedLinesCount;

    /**
     * 新增坏味道
     */
    @Column(name = "new_code_smells_count")
    private Integer newCodeSmellsCount;

    /**
     * 新增代码可靠性评级
     */
    @Column(name = "new_maintainability_rating_avg")
    private Float newMaintainabilityRatingAvg;

    /**
     * 新增代码安全修复工作
     */
    @Column(name = "new_security_remediation_effort_count")
    private Integer newSecurityRemediationEffortCount;

    @Column(name = "update_time")
    private Date updateTime;

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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return collect_date
     */
    public String getCollectDate() {
        return collectDate;
    }

    /**
     * @param collectDate
     */
    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }

    /**
     * 获取文件数
     *
     * @return files_count - 文件数
     */
    public Integer getFilesCount() {
        return filesCount;
    }

    /**
     * 设置文件数
     *
     * @param filesCount 文件数
     */
    public void setFilesCount(Integer filesCount) {
        this.filesCount = filesCount;
    }

    /**
     * 获取行数
     *
     * @return lines_count - 行数
     */
    public Integer getLinesCount() {
        return linesCount;
    }

    /**
     * 设置行数
     *
     * @param linesCount 行数
     */
    public void setLinesCount(Integer linesCount) {
        this.linesCount = linesCount;
    }

    /**
     * 获取有效代码行数
     *
     * @return ncloc_count - 有效代码行数
     */
    public Integer getNclocCount() {
        return nclocCount;
    }

    /**
     * 设置有效代码行数
     *
     * @param nclocCount 有效代码行数
     */
    public void setNclocCount(Integer nclocCount) {
        this.nclocCount = nclocCount;
    }

    /**
     * 获取注释行数
     *
     * @return comment_lines_count - 注释行数
     */
    public Integer getCommentLinesCount() {
        return commentLinesCount;
    }

    /**
     * 设置注释行数
     *
     * @param commentLinesCount 注释行数
     */
    public void setCommentLinesCount(Integer commentLinesCount) {
        this.commentLinesCount = commentLinesCount;
    }

    /**
     * 获取注释率
     *
     * @return comment_lines_density_avg - 注释率
     */
    public Float getCommentLinesDensityAvg() {
        return commentLinesDensityAvg;
    }

    /**
     * 设置注释率
     *
     * @param commentLinesDensityAvg 注释率
     */
    public void setCommentLinesDensityAvg(Float commentLinesDensityAvg) {
        this.commentLinesDensityAvg = commentLinesDensityAvg;
    }

    /**
     * 获取目录数
     *
     * @return directories_count - 目录数
     */
    public Integer getDirectoriesCount() {
        return directoriesCount;
    }

    /**
     * 设置目录数
     *
     * @param directoriesCount 目录数
     */
    public void setDirectoriesCount(Integer directoriesCount) {
        this.directoriesCount = directoriesCount;
    }

    /**
     * 获取类数
     *
     * @return classes_count - 类数
     */
    public Integer getClassesCount() {
        return classesCount;
    }

    /**
     * 设置类数
     *
     * @param classesCount 类数
     */
    public void setClassesCount(Integer classesCount) {
        this.classesCount = classesCount;
    }

    /**
     * 获取声明个数
     *
     * @return statements_count - 声明个数
     */
    public Integer getStatementsCount() {
        return statementsCount;
    }

    /**
     * 设置声明个数
     *
     * @param statementsCount 声明个数
     */
    public void setStatementsCount(Integer statementsCount) {
        this.statementsCount = statementsCount;
    }

    /**
     * 获取方法数
     *
     * @return functions_count - 方法数
     */
    public Integer getFunctionsCount() {
        return functionsCount;
    }

    /**
     * 设置方法数
     *
     * @param functionsCount 方法数
     */
    public void setFunctionsCount(Integer functionsCount) {
        this.functionsCount = functionsCount;
    }

    /**
     * 获取坏味道
     *
     * @return code_smells_count - 坏味道
     */
    public Integer getCodeSmellsCount() {
        return codeSmellsCount;
    }

    /**
     * 设置坏味道
     *
     * @param codeSmellsCount 坏味道
     */
    public void setCodeSmellsCount(Integer codeSmellsCount) {
        this.codeSmellsCount = codeSmellsCount;
    }

    /**
     * 获取bug数
     *
     * @return bugs_count - bug数
     */
    public Integer getBugsCount() {
        return bugsCount;
    }

    /**
     * 设置bug数
     *
     * @param bugsCount bug数
     */
    public void setBugsCount(Integer bugsCount) {
        this.bugsCount = bugsCount;
    }

    /**
     * 获取漏洞数
     *
     * @return vulnerabilities_count - 漏洞数
     */
    public Integer getVulnerabilitiesCount() {
        return vulnerabilitiesCount;
    }

    /**
     * 设置漏洞数
     *
     * @param vulnerabilitiesCount 漏洞数
     */
    public void setVulnerabilitiesCount(Integer vulnerabilitiesCount) {
        this.vulnerabilitiesCount = vulnerabilitiesCount;
    }

    /**
     * 获取覆盖率
     *
     * @return coverage_avg - 覆盖率
     */
    public Float getCoverageAvg() {
        return coverageAvg;
    }

    /**
     * 设置覆盖率
     *
     * @param coverageAvg 覆盖率
     */
    public void setCoverageAvg(Float coverageAvg) {
        this.coverageAvg = coverageAvg;
    }

    /**
     * 获取行覆盖率
     *
     * @return line_coverage_avg - 行覆盖率
     */
    public Float getLineCoverageAvg() {
        return lineCoverageAvg;
    }

    /**
     * 设置行覆盖率
     *
     * @param lineCoverageAvg 行覆盖率
     */
    public void setLineCoverageAvg(Float lineCoverageAvg) {
        this.lineCoverageAvg = lineCoverageAvg;
    }

    /**
     * 获取单元测试成功率
     *
     * @return test_success_density_avg - 单元测试成功率
     */
    public Float getTestSuccessDensityAvg() {
        return testSuccessDensityAvg;
    }

    /**
     * 设置单元测试成功率
     *
     * @param testSuccessDensityAvg 单元测试成功率
     */
    public void setTestSuccessDensityAvg(Float testSuccessDensityAvg) {
        this.testSuccessDensityAvg = testSuccessDensityAvg;
    }

    /**
     * 获取需要覆盖的代码行
     *
     * @return lines_to_cover_count - 需要覆盖的代码行
     */
    public Integer getLinesToCoverCount() {
        return linesToCoverCount;
    }

    /**
     * 设置需要覆盖的代码行
     *
     * @param linesToCoverCount 需要覆盖的代码行
     */
    public void setLinesToCoverCount(Integer linesToCoverCount) {
        this.linesToCoverCount = linesToCoverCount;
    }

    /**
     * 获取未覆盖的代码行
     *
     * @return uncovered_lines_count - 未覆盖的代码行
     */
    public Integer getUncoveredLinesCount() {
        return uncoveredLinesCount;
    }

    /**
     * 设置未覆盖的代码行
     *
     * @param uncoveredLinesCount 未覆盖的代码行
     */
    public void setUncoveredLinesCount(Integer uncoveredLinesCount) {
        this.uncoveredLinesCount = uncoveredLinesCount;
    }

    /**
     * 获取单元测试失败数
     *
     * @return test_failures_count - 单元测试失败数
     */
    public Integer getTestFailuresCount() {
        return testFailuresCount;
    }

    /**
     * 设置单元测试失败数
     *
     * @param testFailuresCount 单元测试失败数
     */
    public void setTestFailuresCount(Integer testFailuresCount) {
        this.testFailuresCount = testFailuresCount;
    }

    /**
     * 获取单元测试错误数
     *
     * @return test_errors_count - 单元测试错误数
     */
    public Integer getTestErrorsCount() {
        return testErrorsCount;
    }

    /**
     * 设置单元测试错误数
     *
     * @param testErrorsCount 单元测试错误数
     */
    public void setTestErrorsCount(Integer testErrorsCount) {
        this.testErrorsCount = testErrorsCount;
    }

    /**
     * 获取单元测试忽略数
     *
     * @return skipped_tests_count - 单元测试忽略数
     */
    public Integer getSkippedTestsCount() {
        return skippedTestsCount;
    }

    /**
     * 设置单元测试忽略数
     *
     * @param skippedTestsCount 单元测试忽略数
     */
    public void setSkippedTestsCount(Integer skippedTestsCount) {
        this.skippedTestsCount = skippedTestsCount;
    }

    /**
     * 获取重复密度
     *
     * @return duplicated_lines_density_avg - 重复密度
     */
    public Float getDuplicatedLinesDensityAvg() {
        return duplicatedLinesDensityAvg;
    }

    /**
     * 设置重复密度
     *
     * @param duplicatedLinesDensityAvg 重复密度
     */
    public void setDuplicatedLinesDensityAvg(Float duplicatedLinesDensityAvg) {
        this.duplicatedLinesDensityAvg = duplicatedLinesDensityAvg;
    }

    /**
     * 获取重复块
     *
     * @return duplicated_blocks_count - 重复块
     */
    public Integer getDuplicatedBlocksCount() {
        return duplicatedBlocksCount;
    }

    /**
     * 设置重复块
     *
     * @param duplicatedBlocksCount 重复块
     */
    public void setDuplicatedBlocksCount(Integer duplicatedBlocksCount) {
        this.duplicatedBlocksCount = duplicatedBlocksCount;
    }

    /**
     * 获取重复文件
     *
     * @return duplicated_files_count - 重复文件
     */
    public Integer getDuplicatedFilesCount() {
        return duplicatedFilesCount;
    }

    /**
     * 设置重复文件
     *
     * @param duplicatedFilesCount 重复文件
     */
    public void setDuplicatedFilesCount(Integer duplicatedFilesCount) {
        this.duplicatedFilesCount = duplicatedFilesCount;
    }

    /**
     * 获取重复行
     *
     * @return duplicated_lines_count - 重复行
     */
    public Integer getDuplicatedLinesCount() {
        return duplicatedLinesCount;
    }

    /**
     * 设置重复行
     *
     * @param duplicatedLinesCount 重复行
     */
    public void setDuplicatedLinesCount(Integer duplicatedLinesCount) {
        this.duplicatedLinesCount = duplicatedLinesCount;
    }

    /**
     * 获取阻断违规
     *
     * @return blocker_violations_count - 阻断违规
     */
    public Integer getBlockerViolationsCount() {
        return blockerViolationsCount;
    }

    /**
     * 设置阻断违规
     *
     * @param blockerViolationsCount 阻断违规
     */
    public void setBlockerViolationsCount(Integer blockerViolationsCount) {
        this.blockerViolationsCount = blockerViolationsCount;
    }

    /**
     * 获取严重违规
     *
     * @return critical_violations_count - 严重违规
     */
    public Integer getCriticalViolationsCount() {
        return criticalViolationsCount;
    }

    /**
     * 设置严重违规
     *
     * @param criticalViolationsCount 严重违规
     */
    public void setCriticalViolationsCount(Integer criticalViolationsCount) {
        this.criticalViolationsCount = criticalViolationsCount;
    }

    /**
     * 获取主要违规
     *
     * @return major_violations_count - 主要违规
     */
    public Integer getMajorViolationsCount() {
        return majorViolationsCount;
    }

    /**
     * 设置主要违规
     *
     * @param majorViolationsCount 主要违规
     */
    public void setMajorViolationsCount(Integer majorViolationsCount) {
        this.majorViolationsCount = majorViolationsCount;
    }

    /**
     * 获取次要违规
     *
     * @return minor_violations_count - 次要违规
     */
    public Integer getMinorViolationsCount() {
        return minorViolationsCount;
    }

    /**
     * 设置次要违规
     *
     * @param minorViolationsCount 次要违规
     */
    public void setMinorViolationsCount(Integer minorViolationsCount) {
        this.minorViolationsCount = minorViolationsCount;
    }

    /**
     * 获取提示违规
     *
     * @return info_violations_count - 提示违规
     */
    public Integer getInfoViolationsCount() {
        return infoViolationsCount;
    }

    /**
     * 设置提示违规
     *
     * @param infoViolationsCount 提示违规
     */
    public void setInfoViolationsCount(Integer infoViolationsCount) {
        this.infoViolationsCount = infoViolationsCount;
    }

    /**
     * 获取新增行数
     *
     * @return new_lines_count - 新增行数
     */
    public Integer getNewLinesCount() {
        return newLinesCount;
    }

    /**
     * 设置新增行数
     *
     * @param newLinesCount 新增行数
     */
    public void setNewLinesCount(Integer newLinesCount) {
        this.newLinesCount = newLinesCount;
    }

    /**
     * 获取违规总数
     *
     * @return violations_count - 违规总数
     */
    public Integer getViolationsCount() {
        return violationsCount;
    }

    /**
     * 设置违规总数
     *
     * @param violationsCount 违规总数
     */
    public void setViolationsCount(Integer violationsCount) {
        this.violationsCount = violationsCount;
    }

    /**
     * 获取技术债务
     *
     * @return sqale_index_count - 技术债务
     */
    public Integer getSqaleIndexCount() {
        return sqaleIndexCount;
    }

    /**
     * 设置技术债务
     *
     * @param sqaleIndexCount 技术债务
     */
    public void setSqaleIndexCount(Integer sqaleIndexCount) {
        this.sqaleIndexCount = sqaleIndexCount;
    }

    /**
     * 获取复杂度
     *
     * @return complexity_count - 复杂度
     */
    public Integer getComplexityCount() {
        return complexityCount;
    }

    /**
     * 设置复杂度
     *
     * @param complexityCount 复杂度
     */
    public void setComplexityCount(Integer complexityCount) {
        this.complexityCount = complexityCount;
    }

    /**
     * 获取认知复杂度
     *
     * @return cognitive_complexity_count - 认知复杂度
     */
    public Integer getCognitiveComplexityCount() {
        return cognitiveComplexityCount;
    }

    /**
     * 设置认知复杂度
     *
     * @param cognitiveComplexityCount 认知复杂度
     */
    public void setCognitiveComplexityCount(Integer cognitiveComplexityCount) {
        this.cognitiveComplexityCount = cognitiveComplexityCount;
    }

    /**
     * 获取新增主要违规数
     *
     * @return new_major_violations_count - 新增主要违规数
     */
    public Integer getNewMajorViolationsCount() {
        return newMajorViolationsCount;
    }

    /**
     * 设置新增主要违规数
     *
     * @param newMajorViolationsCount 新增主要违规数
     */
    public void setNewMajorViolationsCount(Integer newMajorViolationsCount) {
        this.newMajorViolationsCount = newMajorViolationsCount;
    }

    /**
     * 获取新增次要违规数
     *
     * @return new_minor_violations_count - 新增次要违规数
     */
    public Integer getNewMinorViolationsCount() {
        return newMinorViolationsCount;
    }

    /**
     * 设置新增次要违规数
     *
     * @param newMinorViolationsCount 新增次要违规数
     */
    public void setNewMinorViolationsCount(Integer newMinorViolationsCount) {
        this.newMinorViolationsCount = newMinorViolationsCount;
    }

    /**
     * 获取新增严重违规数
     *
     * @return new_critical_violations_count - 新增严重违规数
     */
    public Integer getNewCriticalViolationsCount() {
        return newCriticalViolationsCount;
    }

    /**
     * 设置新增严重违规数
     *
     * @param newCriticalViolationsCount 新增严重违规数
     */
    public void setNewCriticalViolationsCount(Integer newCriticalViolationsCount) {
        this.newCriticalViolationsCount = newCriticalViolationsCount;
    }

    /**
     * 获取新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     *
     * @return new_reliability_rating_avg - 新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     */
    public Float getNewReliabilityRatingAvg() {
        return newReliabilityRatingAvg;
    }

    /**
     * 设置新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     *
     * @param newReliabilityRatingAvg 新代码可靠性评级
A = 0错误
B =至少1次轻微错误
C =至少1次重大错误
D =至少1次严重错误
E =至少1次阻止程序错误
     */
    public void setNewReliabilityRatingAvg(Float newReliabilityRatingAvg) {
        this.newReliabilityRatingAvg = newReliabilityRatingAvg;
    }

    /**
     * 获取新增阻断违规数
     *
     * @return new_blocker_violations_count - 新增阻断违规数
     */
    public Integer getNewBlockerViolationsCount() {
        return newBlockerViolationsCount;
    }

    /**
     * 设置新增阻断违规数
     *
     * @param newBlockerViolationsCount 新增阻断违规数
     */
    public void setNewBlockerViolationsCount(Integer newBlockerViolationsCount) {
        this.newBlockerViolationsCount = newBlockerViolationsCount;
    }

    /**
     * 获取新增需要覆盖的代码行
     *
     * @return new_lines_to_cover_count - 新增需要覆盖的代码行
     */
    public Integer getNewLinesToCoverCount() {
        return newLinesToCoverCount;
    }

    /**
     * 设置新增需要覆盖的代码行
     *
     * @param newLinesToCoverCount 新增需要覆盖的代码行
     */
    public void setNewLinesToCoverCount(Integer newLinesToCoverCount) {
        this.newLinesToCoverCount = newLinesToCoverCount;
    }

    /**
     * 获取新增技术债务
     *
     * @return new_technical_debt_count - 新增技术债务
     */
    public Integer getNewTechnicalDebtCount() {
        return newTechnicalDebtCount;
    }

    /**
     * 设置新增技术债务
     *
     * @param newTechnicalDebtCount 新增技术债务
     */
    public void setNewTechnicalDebtCount(Integer newTechnicalDebtCount) {
        this.newTechnicalDebtCount = newTechnicalDebtCount;
    }

    /**
     * 获取新增提示违规数
     *
     * @return new_info_violations_count - 新增提示违规数
     */
    public Integer getNewInfoViolationsCount() {
        return newInfoViolationsCount;
    }

    /**
     * 设置新增提示违规数
     *
     * @param newInfoViolationsCount 新增提示违规数
     */
    public void setNewInfoViolationsCount(Integer newInfoViolationsCount) {
        this.newInfoViolationsCount = newInfoViolationsCount;
    }

    /**
     * 获取新增未覆盖的代码行
     *
     * @return new_uncovered_lines_count - 新增未覆盖的代码行
     */
    public Integer getNewUncoveredLinesCount() {
        return newUncoveredLinesCount;
    }

    /**
     * 设置新增未覆盖的代码行
     *
     * @param newUncoveredLinesCount 新增未覆盖的代码行
     */
    public void setNewUncoveredLinesCount(Integer newUncoveredLinesCount) {
        this.newUncoveredLinesCount = newUncoveredLinesCount;
    }

    /**
     * 获取新代码的可靠性修复工作
     *
     * @return new_reliability_remediation_effort_count - 新代码的可靠性修复工作
     */
    public Integer getNewReliabilityRemediationEffortCount() {
        return newReliabilityRemediationEffortCount;
    }

    /**
     * 设置新代码的可靠性修复工作
     *
     * @param newReliabilityRemediationEffortCount 新代码的可靠性修复工作
     */
    public void setNewReliabilityRemediationEffortCount(Integer newReliabilityRemediationEffortCount) {
        this.newReliabilityRemediationEffortCount = newReliabilityRemediationEffortCount;
    }

    /**
     * 获取新增违规数
     *
     * @return new_violations_count - 新增违规数
     */
    public Integer getNewViolationsCount() {
        return newViolationsCount;
    }

    /**
     * 设置新增违规数
     *
     * @param newViolationsCount 新增违规数
     */
    public void setNewViolationsCount(Integer newViolationsCount) {
        this.newViolationsCount = newViolationsCount;
    }

    /**
     * 获取新增重复块
     *
     * @return new_duplicated_blocks_count - 新增重复块
     */
    public Integer getNewDuplicatedBlocksCount() {
        return newDuplicatedBlocksCount;
    }

    /**
     * 设置新增重复块
     *
     * @param newDuplicatedBlocksCount 新增重复块
     */
    public void setNewDuplicatedBlocksCount(Integer newDuplicatedBlocksCount) {
        this.newDuplicatedBlocksCount = newDuplicatedBlocksCount;
    }

    /**
     * 获取新的或更新代码的条件覆盖数 
     *
     * @return new_conditions_to_cover_count - 新的或更新代码的条件覆盖数 
     */
    public Integer getNewConditionsToCoverCount() {
        return newConditionsToCoverCount;
    }

    /**
     * 设置新的或更新代码的条件覆盖数 
     *
     * @param newConditionsToCoverCount 新的或更新代码的条件覆盖数 
     */
    public void setNewConditionsToCoverCount(Integer newConditionsToCoverCount) {
        this.newConditionsToCoverCount = newConditionsToCoverCount;
    }

    /**
     * 获取新代码的技术债务比率
     *
     * @return new_sqale_debt_ratio_avg - 新代码的技术债务比率
     */
    public Float getNewSqaleDebtRatioAvg() {
        return newSqaleDebtRatioAvg;
    }

    /**
     * 设置新代码的技术债务比率
     *
     * @param newSqaleDebtRatioAvg 新代码的技术债务比率
     */
    public void setNewSqaleDebtRatioAvg(Float newSqaleDebtRatioAvg) {
        this.newSqaleDebtRatioAvg = newSqaleDebtRatioAvg;
    }

    /**
     * 获取新的或更新代码中未覆盖的条件数
     *
     * @return new_uncovered_conditions_count - 新的或更新代码中未覆盖的条件数
     */
    public Integer getNewUncoveredConditionsCount() {
        return newUncoveredConditionsCount;
    }

    /**
     * 设置新的或更新代码中未覆盖的条件数
     *
     * @param newUncoveredConditionsCount 新的或更新代码中未覆盖的条件数
     */
    public void setNewUncoveredConditionsCount(Integer newUncoveredConditionsCount) {
        this.newUncoveredConditionsCount = newUncoveredConditionsCount;
    }

    /**
     * 获取新代码安全评级
     *
     * @return new_security_rating_avg - 新代码安全评级
     */
    public Float getNewSecurityRatingAvg() {
        return newSecurityRatingAvg;
    }

    /**
     * 设置新代码安全评级
     *
     * @param newSecurityRatingAvg 新代码安全评级
     */
    public void setNewSecurityRatingAvg(Float newSecurityRatingAvg) {
        this.newSecurityRatingAvg = newSecurityRatingAvg;
    }

    /**
     * 获取新增漏洞数
     *
     * @return new_vulnerabilities_count - 新增漏洞数
     */
    public Integer getNewVulnerabilitiesCount() {
        return newVulnerabilitiesCount;
    }

    /**
     * 设置新增漏洞数
     *
     * @param newVulnerabilitiesCount 新增漏洞数
     */
    public void setNewVulnerabilitiesCount(Integer newVulnerabilitiesCount) {
        this.newVulnerabilitiesCount = newVulnerabilitiesCount;
    }

    /**
     * 获取新增bug数
     *
     * @return new_bugs_count - 新增bug数
     */
    public Integer getNewBugsCount() {
        return newBugsCount;
    }

    /**
     * 设置新增bug数
     *
     * @param newBugsCount 新增bug数
     */
    public void setNewBugsCount(Integer newBugsCount) {
        this.newBugsCount = newBugsCount;
    }

    /**
     * 获取新增重复行
     *
     * @return new_duplicated_lines_count - 新增重复行
     */
    public Integer getNewDuplicatedLinesCount() {
        return newDuplicatedLinesCount;
    }

    /**
     * 设置新增重复行
     *
     * @param newDuplicatedLinesCount 新增重复行
     */
    public void setNewDuplicatedLinesCount(Integer newDuplicatedLinesCount) {
        this.newDuplicatedLinesCount = newDuplicatedLinesCount;
    }

    /**
     * 获取新增坏味道
     *
     * @return new_code_smells_count - 新增坏味道
     */
    public Integer getNewCodeSmellsCount() {
        return newCodeSmellsCount;
    }

    /**
     * 设置新增坏味道
     *
     * @param newCodeSmellsCount 新增坏味道
     */
    public void setNewCodeSmellsCount(Integer newCodeSmellsCount) {
        this.newCodeSmellsCount = newCodeSmellsCount;
    }

    /**
     * 获取新增代码可靠性评级
     *
     * @return new_maintainability_rating_avg - 新增代码可靠性评级
     */
    public Float getNewMaintainabilityRatingAvg() {
        return newMaintainabilityRatingAvg;
    }

    /**
     * 设置新增代码可靠性评级
     *
     * @param newMaintainabilityRatingAvg 新增代码可靠性评级
     */
    public void setNewMaintainabilityRatingAvg(Float newMaintainabilityRatingAvg) {
        this.newMaintainabilityRatingAvg = newMaintainabilityRatingAvg;
    }

    /**
     * 获取新增代码安全修复工作
     *
     * @return new_security_remediation_effort_count - 新增代码安全修复工作
     */
    public Integer getNewSecurityRemediationEffortCount() {
        return newSecurityRemediationEffortCount;
    }

    /**
     * 设置新增代码安全修复工作
     *
     * @param newSecurityRemediationEffortCount 新增代码安全修复工作
     */
    public void setNewSecurityRemediationEffortCount(Integer newSecurityRemediationEffortCount) {
        this.newSecurityRemediationEffortCount = newSecurityRemediationEffortCount;
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
}