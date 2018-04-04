package org.project.service.login;

import javax.annotation.Resource;

import org.project.dao.user.UserMapper;
import org.project.pojo.User;
import org.springframework.stereotype.Service;

@Service(value="login")
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUser(User user){
		return userMapper.getUser(user);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
