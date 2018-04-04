package org.project.service.pizza;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.project.dao.pizza.AddPizzaMapper;
import org.project.pojo.Pizza;
import org.springframework.stereotype.Service;

@Service(value="AddPizzaService")
public class AddPizzaServiceImpl implements AddPizzaService {
	
	@Resource
	private AddPizzaMapper addPizzaMapper;
	
	@Override
	public int addPizza(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Pizza pizza=new Pizza();
		pizza.setType(req.getParameter("type"));
		pizza.setDescription(req.getParameter("description"));
		pizza.setPrice1(req.getParameter("price1"));
		pizza.setSize1(req.getParameter("size1"));
		pizza.setSize2(req.getParameter("size2"));
		pizza.setPrice2(req.getParameter("price2"));
		return addPizzaMapper.addPizza(pizza);
	}

	@Override
	public List<Pizza> searchPizza() {
		// TODO Auto-generated method stub
		return addPizzaMapper.searchPizza();
	}

	@Override
	public int deletePizza(int id) {
		// TODO Auto-generated method stub
		return addPizzaMapper.deletePizza(id);
	}

}
