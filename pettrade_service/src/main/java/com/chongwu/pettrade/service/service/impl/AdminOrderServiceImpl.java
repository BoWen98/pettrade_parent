package com.chongwu.pettrade.service.service.impl;


import com.chongwu.pettrade.service.dao.OrdersDao;
import com.chongwu.pettrade.service.entity.Orders;
import com.chongwu.pettrade.service.service.AdminOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台订单处理服务层
 * @author zhaoxianhai
 * 2018-3-21
 *
 */
@Transactional
@Service("adminOrderService")
public class AdminOrderServiceImpl implements AdminOrderService {

    @Resource
    private OrdersDao ordersDao;

    public Integer countOrder() {
        Integer count = ordersDao.findCount();
        return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
    }

    public Orders findOrder(Integer oid) {
        return ordersDao.findByOid(oid);
    }

    public List<Orders> listOrder(Integer page, Integer rows) {
        return ordersDao.findByPage(page, rows);
    }

    public void saveOrUpdateOrder(Orders order) {
        ordersDao.saveOrUpdate(order);
    }

    public void deleteOrder(Orders order) {
        ordersDao.delete(order);
    }

}
