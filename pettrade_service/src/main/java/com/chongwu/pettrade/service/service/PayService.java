package com.chongwu.pettrade.service.service;

import com.chongwu.pettrade.service.entity.Orders;

/**
 * ֧������ӿ�
 * @author zhaoxianhai
 *
 */
public interface PayService {
	/**
	 * Ǯ��֧��
	 * @param order
	 * @param addr
	 * @param name
	 * @param phone
	 * @param total
	 * @return
	 */
	int payOrderByWallet(Orders order, String addr, String name, String phone, String total);
}
