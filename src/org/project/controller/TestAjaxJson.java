package org.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.project.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAjaxJson {
	@RequestMapping(value="/testAjax")
	@ResponseBody
	public Map testAjaxJson(){
		Map map=new HashMap();
		List list=new ArrayList();
		for(int i=0;i<3;i++){
			User user = new User();
			user.setUserName("oooolc");
			user.setPassword("88831870");
			list.add(user);
		}
		map.put("content", list);
		return map;
	}
}
