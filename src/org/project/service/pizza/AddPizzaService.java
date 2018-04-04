package org.project.service.pizza;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.project.pojo.Pizza;


public interface AddPizzaService {
	//登记pizza信息
	public int addPizza(HttpServletRequest req);
	
	//查询数据
	public List<Pizza> searchPizza();
	
	//删除pizza
	public int deletePizza(int id);
}
