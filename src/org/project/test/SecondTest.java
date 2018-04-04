package org.project.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.pojo.RegisterData;
import org.project.service.registerData.RegisterDataService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-mybatis.xml"})
public class SecondTest {
	 private static Logger logger = Logger.getLogger(SecondTest.class);
	
	@Resource
	public RegisterDataService registerDataService=null;
	
	@Test
	public void test() {
		//RegisterData registerData=new RegisterData();
		//RegisterData num=registerDataService.getInfoById(40);
		//System.out.println(registerDataService.searchData(registerData).toString());
		//System.out.println(num);
		logger.debug("num---------------------");
		//System.out.println("sys===="+num);
	}

}
