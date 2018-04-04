package org.project.service.registerData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.project.dao.registerdata.RegisterDataMapper;
import org.project.pojo.Pagenation;
import org.project.pojo.RegisterData;
import org.springframework.stereotype.Service;

@Service(value="RegisterDataService")
public class RegisterDataServiceImpl implements RegisterDataService {
	
	@Resource
	private RegisterDataMapper registerDataMapper;
	
	@Override
	public int registerData(HttpServletRequest req) {
		RegisterData registerData=new RegisterData();
		registerData.setJjdbh(req.getParameter("jjdbh"));
		registerData.setBpzje(req.getParameter("bpzje"));
		registerData.setZafs(req.getParameter("zafs"));
		registerData.setZasdfl(req.getParameter("zasdfl"));
		registerData.setZasddl(req.getParameter("zasddl"));
		registerData.setZasdxl(req.getParameter("zasdxl"));
		registerData.setGjz(req.getParameter("gjz"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	    Date date;
		try {
			date = sdf.parse(req.getParameter("bjsj"));
			registerData.setBjsj(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		registerData.setJjy(req.getParameter("jjy"));
		registerData.setBjdh(req.getParameter("bjdh"));
		registerData.setBjrxm(req.getParameter("bjrxm"));
		registerData.setBjrxb(req.getParameter("bjrxb"));
		registerData.setDw(req.getParameter("dw"));
		registerData.setAfdz(req.getParameter("afdz"));
		registerData.setBjnr(req.getParameter("bjnr"));
		return registerDataMapper.registerData(registerData);
	}

	
	@Override
	public List<RegisterData> searchData(RegisterData registerData) {
		// TODO Auto-generated method stub
		return registerDataMapper.searchData(registerData);
	}



	@Override
	public int getRegisterCount(RegisterData registerData) {
		// TODO Auto-generated method stub
		return registerDataMapper.getRegisterCount(registerData);
	}


	@Override
	public RegisterData getInfoById(int id) {
		// TODO Auto-generated method stub
		return registerDataMapper.getInfoById(id);
	}


	@Override
	public int deleteData(int id) {
		// TODO Auto-generated method stub
		return registerDataMapper.deleteData(id);
	}


	@Override
	public int updateData(RegisterData registerData) {
		// TODO Auto-generated method stub
		return registerDataMapper.updateData(registerData);
	}

}
