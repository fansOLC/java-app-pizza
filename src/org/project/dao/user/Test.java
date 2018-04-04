package org.project.dao.user;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
	public static void test(){
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/springmvcdb");
		dataSource.setUsername("root");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setPassword("root");
		jdbcTemplate.setDataSource(dataSource);
		List list=jdbcTemplate.queryForList("SELECT * FROM USER");
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		test();
	}
}
