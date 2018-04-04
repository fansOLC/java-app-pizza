package org.project.controller.datasearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataSearch {
	@RequestMapping(value="/data_search",method=RequestMethod.GET)
	public String getDataRegister(){
		return "jcjgl/dataSearch";
	}
}
