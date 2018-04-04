package org.project.controller.suspect_register;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.project.service.suspect.SuspectRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SuspectRegister {
	
	@Resource(name="SuspectRegisterService")
	private SuspectRegisterService suspectRegisterService;
	
	@RequestMapping(value="/suspect_register")
	public String suspectRegister(){
		return "xyrgl/suspect_register";
	}
	@ResponseBody
	@RequestMapping(value="/add_suspect",method=RequestMethod.POST)
	public Map<String,Object> addInfo(@RequestParam MultipartFile file,HttpServletRequest req){
		
		Map resultMap=new HashMap<String, Object>();
		
		int flag=suspectRegisterService.suspectDataregister(file,req);
		
		if(flag==1){
			resultMap.put("state", "success");
		}else{
			resultMap.put("state", "failed");
		}	
		return resultMap;
	}
}
