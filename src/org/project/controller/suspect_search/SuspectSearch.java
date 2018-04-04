package org.project.controller.suspect_search;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.project.pojo.SuspectRegister;
import org.project.service.suspect.SuspectSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SuspectSearch {
	
	@Resource(name="suspectSearchService")
	private SuspectSearchService suspectSearchService;
	
	@RequestMapping(value="/suspect_search")
	public String getSearchPage(){
		return "xyrgl/suspect_search";
	}
	
	/*
	 * 查询嫌疑人列表
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/suspect_searchData")
	@ResponseBody
	public Map<String,Object> resultList(HttpServletRequest request){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap=suspectSearchService.searchList(request);
		return resultMap;
	}
	
	/**
	 * 文件下载
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping(value="/ttest/{id}")
	public void test(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		int susId=Integer.valueOf(id);
		Map resultMap=suspectSearchService.searchFile(susId);
		String file_addr=(String) resultMap.get("file_addr");
		String file_name=(String) resultMap.get("file_name");
		File file=new File(file_addr);
		InputStream is=null;
		OutputStream os=null;
		String browserType=request.getHeader("User-Agent").toLowerCase();
		if(browserType.indexOf("msie")>=0){
			file_name=URLEncoder.encode(file_name, "utf-8");
		}else{
			file_name=new String(file_name.getBytes(),"iso-8859-1");
		}
		//response.setContentType("text/plain");//根据不同文件类型设置文件格式
		//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
        response.setContentType("multipart/form-data");  
        //2.设置文件头：最后一个参数是设置下载文件名
		response.setHeader("Content-Disposition", "attachment;filename="+file_name);//filename表示文件下载的名称
		try{
			is=new FileInputStream(file);
			os=response.getOutputStream();
			IOUtils.copy(is, os);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(os!=null){
				try{
					os.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(is!=null){
				try{
					is.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
