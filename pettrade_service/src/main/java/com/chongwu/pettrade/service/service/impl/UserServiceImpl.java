package com.chongwu.pettrade.service.service.impl;


import com.chongwu.common.MD5Utils;
import com.chongwu.common.StringTools;
import com.chongwu.pettrade.service.dao.UserDao;
import com.chongwu.pettrade.service.entity.User;
import com.chongwu.pettrade.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void registerUser(User user) {
		String key = StringTools.getStringRamdom(6);
		user.setState(1);
		user.setCode(StringTools.getUUID());
		user.setKey(key);
		//Md5增强加密(密码和key混合加密)
		String pwd = MD5Utils.getMD5Str(user.getPassword() + user.getKey());
		user.setPassword(pwd);
		userDao.save(user);
	}

	@Override
	public User existUser(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public User findByUserNameAndPassword(User user) {
		//user是多页面传入的参数的user对象
		//exuser是数据库中存在的user,利用参数中的password和数据库中的key结合比对加密后的密文看是否相同
		User exser = existUser(user.getUserName());
		String pwd = MD5Utils.getMD5Str(user.getPassword() + exser.getKey());
		return userDao.findByUserNameAndPassword(user.getUserName(), pwd);
	}

}
