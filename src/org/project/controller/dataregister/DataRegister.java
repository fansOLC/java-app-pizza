package org.project.controller.dataregister;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.project.pojo.Pagenation;
import org.project.pojo.RegisterData;
import org.project.service.registerData.RegisterDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

@Controller
public class DataRegister {
	@Resource(name="RegisterDataService")
	private RegisterDataService registerDataService;
	
	//登记页面
	@RequestMapping(value="/data_register",method=RequestMethod.GET)
	public String getDataRegisterPage(){
		return "jcjgl/dataRegister";
	}
	
	//获取详情页面
	@RequestMapping(value="/publicData",method=RequestMethod.GET)
	public String getpublicData(String id,Model model){
		model.addAttribute("infoId",id);
		return "jcjgl/dataDetail";
	}
	
	//获取编辑页面
	@RequestMapping(value="/editData",method=RequestMethod.GET)
	public String editData(String id,Model model){
		model.addAttribute("infoId",id);
		return "jcjgl/dataEdit";
	}
	
	//获取登记数据
	@RequestMapping(value="/dataRegister",method=RequestMethod.POST)
	@ResponseBody
	public Map dataRegister(HttpServletRequest req,HttpServletResponse res){
		/*HashMap<String, String> map=new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper(); 
		RegisterData registerData=new RegisterData();
		registerData.setJjdbh(req.getParameter("jjdbh"));
		registerData.setBpzje(req.getParameter("bpzje"));
		registerData.setZafs(req.getParameter("zafs"));
		registerData.setZasdfl(req.getParameter("zasdfl"));
		registerData.setZasddl(req.getParameter("zasddl"));
		registerData.setZasdxl(req.getParameter("zasdxl"));
		registerData.setGjz(req.getParameter("gjz"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	    Date date = sdf.parse(req.getParameter("bjsj"));  
		
		registerData.setBjsj(date);
		registerData.setJjy(req.getParameter("jjy"));
		registerData.setBjdh(req.getParameter("bjdh"));
		registerData.setBjrxm(req.getParameter("bjrxm"));
		registerData.setBjrxb(req.getParameter("bjrxb"));
		registerData.setDw(req.getParameter("dw"));
		registerData.setAfdz(req.getParameter("afdz"));
		registerData.setBjnr(req.getParameter("bjnr"));
		int flag=registerDataService.registerData(registerData);*/
		HashMap<String, String> map=new HashMap<String, String>();
		//ObjectMapper mapper = new ObjectMapper();//web.xml配置了json格式 
		int flag=registerDataService.registerData(req);
		if(flag==1){
			map.put("state", "success");
		}else{
			map.put("state", "failed");
		}	
		return map;
	}
	
	//查询页面 查询登记数据（无条件）
	@RequestMapping(value="/dataSearch",method=RequestMethod.POST)
	@ResponseBody
	public String dataSearch(HttpServletRequest req,HttpServletResponse res) throws JsonGenerationException, JsonMappingException, IOException{
		Pagenation pagenation =new Pagenation();
		RegisterData registerData=new RegisterData(); 
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		int pageSize=Integer.parseInt(req.getParameter("pageSize"));
		int pageNo=Integer.parseInt(req.getParameter("pageNo"));
		registerData.setJjdbh(req.getParameter("jjdbh"));
		registerData.setBjdh(req.getParameter("bjdh"));
		registerData.setBjrxm(req.getParameter("bjrxm"));
		registerData.setJjy(req.getParameter("jjy"));
		int startNo=(pageNo-1)*pageSize;
		pagenation.setPageNo(pageNo);
		pagenation.setPageSize(pageSize);
		pagenation.setStartNo(startNo);
		ObjectMapper mapper = new ObjectMapper();
		List<RegisterData> list=new ArrayList<RegisterData>();
		int count=registerDataService.getRegisterCount(registerData);
		int pageCount = 0;
		if (count % pageSize == 0) {
			pageCount = count / pageSize;
		} else {
			pageCount = count / pageSize + 1;
		}
		pagenation.setCount(count);
		pagenation.setPageCount(pageCount);
		PageHelper.startPage(pageNo, pageSize);//分页工具
		list=registerDataService.searchData(registerData);
		resultMap.put("page", pagenation);
		resultMap.put("content", list);
		return mapper.writeValueAsString(resultMap);
	}
	
	//根据id查询信息
	@RequestMapping(value="/getInfoById",method=RequestMethod.POST)
	@ResponseBody
	public String getInfoById(int infoId) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(infoId);
		return mapper.writeValueAsString(registerDataService.getInfoById(infoId));
	}
	
	//根据id删除信息
	@RequestMapping(value="/deleteInfoById",method=RequestMethod.POST)
	@ResponseBody
	public String deleteInfoById(int infoId) throws JsonGenerationException, JsonMappingException, IOException{
		HashMap<String, String> map=new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		int flag=registerDataService.deleteData(infoId);
		if(flag==1){
			map.put("state", "success");
		}else{
			map.put("state", "failed");
		}	
		return mapper.writeValueAsString(map);
	}
	
	//获取修改数据
	@RequestMapping(value="/updateData",method=RequestMethod.POST)
	@ResponseBody
	public String updateData(HttpServletRequest req,HttpServletResponse res) throws ParseException, JsonGenerationException, JsonMappingException, IOException{
		HashMap<String, String> map=new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		
		RegisterData registerData=new RegisterData();
		registerData.setId(Integer.parseInt(req.getParameter("id")));
		registerData.setJjdbh(req.getParameter("jjdbh"));
		registerData.setBpzje(req.getParameter("bpzje"));
		registerData.setZafs(req.getParameter("zafs"));
		registerData.setZasdfl(req.getParameter("zasdfl"));
		registerData.setZasddl(req.getParameter("zasddl"));
		registerData.setZasdxl(req.getParameter("zasdxl"));
		registerData.setGjz(req.getParameter("gjz"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	    Date date = sdf.parse(req.getParameter("bjsj"));  
		
		registerData.setBjsj(date);
		registerData.setJjy(req.getParameter("jjy"));
		registerData.setBjdh(req.getParameter("bjdh"));
		registerData.setBjrxm(req.getParameter("bjrxm"));
		registerData.setBjrxb(req.getParameter("bjrxb"));
		registerData.setDw(req.getParameter("dw"));
		registerData.setAfdz(req.getParameter("afdz"));
		registerData.setBjnr(req.getParameter("bjnr"));
		int flag=registerDataService.updateData(registerData);
		if(flag==1){
			map.put("state", "success");
			map.put("msg", "修改成功");
		}else{
			map.put("state", "failed");
			map.put("msg", "修改失败");
		}	
		return mapper.writeValueAsString(map);
	}
}
