package com.chongwu.pettrade.service.dao;

import com.chongwu.pettrade.service.entity.Admin;

/**
 * 系统用户dao类接口
 * @author zhaoxianhai
 *
 */
public interface AdminDao extends BaseDao<Admin> {
	
	 Admin findByUsernameAndPassword(String username, String password);
	/**
	 * 通过管理员id查找管理员
	 * @param uid
	 * @return
	 */
	 Admin findOne(Integer uid);
}
