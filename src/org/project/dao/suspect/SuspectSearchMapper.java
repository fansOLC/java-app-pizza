package org.project.dao.suspect;

import java.util.List;
import java.util.Map;

import org.project.pojo.SuspectRegister;


public interface SuspectSearchMapper {
	//查询嫌疑人列表
	public List<SuspectRegister> searchList(SuspectRegister suspectRegister);
	
	//查询列表数据总条数
	public int count(SuspectRegister suspectRegister); 
	
	//根据susid查询附件名称及地址
	public Map<String,Object> searchFile(int susId);
}
