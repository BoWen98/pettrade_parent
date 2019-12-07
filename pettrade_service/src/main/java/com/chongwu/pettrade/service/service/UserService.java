package com.chongwu.pettrade.service.service;

import com.chongwu.pettrade.service.entity.User;

public interface UserService {

	/**
	 * 客户注册
	 */
	void registerUser(User user);

	/**
	 * 判断客户是否存在
	 * 
	 * @param userName
	 * @return
	 */
	User existUser(String userName);
	/**
	 * 通过用户名和密码查询用户
	 * @param user
	 * @return
	 */
	User findByUserNameAndPassword(User user);

}
