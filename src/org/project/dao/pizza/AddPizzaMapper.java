package org.project.dao.pizza;

import java.util.List;


import org.project.pojo.Pizza;

public interface AddPizzaMapper {
	//登记pizza信息
	public int addPizza(Pizza pizza);
	//查询pizza
	public List<Pizza> searchPizza();
	//删除pizza
	public int deletePizza(int id);
}
