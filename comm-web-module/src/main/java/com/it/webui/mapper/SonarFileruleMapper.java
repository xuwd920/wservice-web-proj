package com.it.webui.mapper;

import java.util.List;

import com.it.webui.model.SonarFilerule;
import com.it.webui.util.MyMapper;
import com.it.webui.vo.FileRuleVo;
import org.apache.ibatis.annotations.Param;

public interface SonarFileruleMapper extends MyMapper<SonarFilerule> {

	List<FileRuleVo> getTopViolas(@Param(value = "severity") String severity);

	List<FileRuleVo> getTopFiles(@Param(value = "severity") String severity);
}