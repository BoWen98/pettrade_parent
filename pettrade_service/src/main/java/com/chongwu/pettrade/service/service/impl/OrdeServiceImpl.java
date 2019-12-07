package com.chongwu.pettrade.service.service.impl;

import com.chongwu.pettrade.service.dao.OrdersDao;
import com.chongwu.pettrade.service.entity.Orders;
import com.chongwu.pettrade.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class OrdeServiceImpl implements OrderService {

	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void save(Orders order) {
		ordersDao.save(order);
	}

	@Override
	public Orders findByOid(Integer oid) {
		return ordersDao.get(oid);
	}

	@Override
	public void update(Orders order) {
		ordersDao.update(order);
	}

	@Override
	public Integer findCountByUid(Integer uid) {
		Integer count = ordersDao.findCountByUid(uid);
		return (count % 6 == 0 ? (count / 6) : (count % 6 + 1));
	}

	@Override
	public List<Orders> findByUid(Integer uid, Integer page) {
		// ÿҳ��6��
		int rows = 6;
		return ordersDao.findPageByUid(uid, page, rows);
	}

}
