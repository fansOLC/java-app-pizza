package org.project.controller.zpsd;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.project.pojo.Zpsd;
import org.project.service.zpsd.ZpsdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZpsdController {
	
	@Resource(name="ZpsdService")
	ZpsdService zpsdService;
	
	@RequestMapping(value="/getZpsdfl",method=RequestMethod.GET)
	@ResponseBody
	public String getZpsdfl() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(zpsdService.getZpsdfl());
	}
	
	/**
	 * 根据诈骗手段分类获取诈骗手段大类
	 * */
	@RequestMapping(value="/getZpsddl",method=RequestMethod.GET)
	@ResponseBody
	public String getZpsddl(String zpsdCode) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Zpsd zpsd=new Zpsd();
		zpsd.setZpsdCode(zpsdCode);
		return mapper.writeValueAsString(zpsdService.getZpsddl(zpsd));
	}
	
	/**
	 * 根据诈骗手段分类获取诈骗手段小类
	 * */
	@RequestMapping(value="/getZpsdxl",method=RequestMethod.GET)
	@ResponseBody
	public String getZpsdxl(String zpsdCode) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Zpsd zpsd=new Zpsd();
		zpsd.setZpsdCode(zpsdCode);
		return mapper.writeValueAsString(zpsdService.getZpsdxl(zpsd));
	}
	
}
