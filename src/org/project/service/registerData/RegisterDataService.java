package org.project.service.registerData;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.project.pojo.RegisterData;

public interface RegisterDataService {
	//登记接警信息
	public int registerData(HttpServletRequest req);
	//获取登记数据总条目数
	public int getRegisterCount(RegisterData registerData);
	//查询数据
	public List<RegisterData> searchData(RegisterData registerData);
	//根据id查询案件信息
	public RegisterData getInfoById(int id);
	//根据id删除案件信息
	public int deleteData(int id);
	//更新数据
	public int updateData(RegisterData registerData);
}
