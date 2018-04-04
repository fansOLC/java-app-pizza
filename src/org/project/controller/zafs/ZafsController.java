package org.project.controller.zafs;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.project.service.zafs.ZafsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZafsController {
	
	@Resource(name="ZafsService")
	ZafsService zafsService;
	
	@RequestMapping(value="/getZafs",method=RequestMethod.GET)
	@ResponseBody
	public String getZafs() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(zafsService.getZafs());
	}
}
