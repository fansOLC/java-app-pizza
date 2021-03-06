package org.project.dao.Zpsd;

import java.util.List;

import org.project.pojo.Zpsd;

public interface ZpsdMapper {
	//获取诈骗手段分类
	public List<Zpsd> getZpsdfl();
	
	//根据诈骗手段分类获取诈骗手段大类
	public List<Zpsd> getZpsddl(Zpsd zpsd);
	
	//根据诈骗手段分类获取诈骗手段大类
	public List<Zpsd> getZpsdxl(Zpsd zpsd);
}
