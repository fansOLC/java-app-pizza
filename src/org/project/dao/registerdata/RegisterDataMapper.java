package org.project.dao.registerdata;

import java.sql.Types;
import java.util.List;

import org.project.pojo.RegisterData;

public interface RegisterDataMapper {
	//登记接警信息
	public int registerData(RegisterData registerData);
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
