package com.chongwu.pettrade.service.service;

import com.chongwu.pettrade.service.entity.Orders;

import java.util.List;

/**
 * 订单接口
 * 
 * @author zhaoxianhai
 *
 */
public interface OrderService {
	/**
	 * 保存订单
	 * 
	 * @param order
	 */
	void save(Orders order);

	/**
	 * 根据oid查询订单
	 */
	Orders findByOid(Integer oid);

	/**
	 * 修改订单
	 */
	void update(Orders order);

	/**
	 * 订单列表的页码
	 */
	Integer findCountByUid(Integer uid);

	/**
	 * 根据用户ID与当前页查询订单列表
	 */
	List<Orders> findByUid(Integer uid, Integer page);

}
