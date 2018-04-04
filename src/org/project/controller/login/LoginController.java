package org.project.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.project.pojo.User;
import org.project.service.login.LoginService;
import org.project.service.login.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@Resource(name="login")
	private LoginService loginService; 
	
	//登录到首页
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String getHome(HttpSession session){
		if (session != null &&  session.getAttribute("userInfo")!=null) {       
			return "home";
        }else {
            //没有登录过 直接重定向到登录页
        	return "redirect:/index.jsp"; 
        }
	}
	
	//注销
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp"; 
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam String uname,@RequestParam String password,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper(); 
		Map<String, String> map=new HashMap<String, String>();
		User user=new User();
		user.setUserName(uname);
		user.setPassword(password);
		String jsonStr=null;
		jsonStr=mapper.writeValueAsString(loginService.getUser(user));
		if(jsonStr.equals("null")){
			map.put("message", "用户名或密码错误");
			return mapper.writeValueAsString(map);
		}else{
			session.setAttribute("userInfo", loginService.getUser(user));
			return jsonStr;
		}
	}
}
