package org.project.controller.pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.pojo.Pizza;
import org.project.service.pizza.AddPizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddPizza {
	@Resource(name="AddPizzaService")
	private AddPizzaService addPizzaService;
	
		//获取登记pizza数据
		@RequestMapping(value="/addPizza",method=RequestMethod.POST)
		@ResponseBody
		public Map dataRegister(HttpServletRequest req,HttpServletResponse res){
			HashMap<String, String> map=new HashMap<String, String>();
			int flag=addPizzaService.addPizza(req);
			if(flag==1){
				map.put("state", "success");
			}else{
				map.put("state", "failed");
			}	
			return map;
		}
		
		//查询pizza数据
		@RequestMapping(value="/searchPizza",method=RequestMethod.GET)
		@ResponseBody
		public Map searchPizza(){
			HashMap<String, Object> map=new HashMap<String, Object>();
			List<Pizza> pizzas=new ArrayList<Pizza>();
			pizzas=addPizzaService.searchPizza();
			map.put("state", "success");
			map.put("content",pizzas);	
			return map;
		}
		
		//根据id删除相应pizza
		@RequestMapping(value="/deletePizza",method=RequestMethod.GET)
		@ResponseBody
		public Map deletePizza(int id){
			HashMap<String, Object> map=new HashMap<String, Object>();
			int flag=addPizzaService.deletePizza(id);
			if(flag==1){
				map.put("state", "success");
				map.put("msg", "删除成功！");
			}else{
				map.put("state", "fail");
				map.put("msg", "删除失败！");
			}
			return map;
		}
}
