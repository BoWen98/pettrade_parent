package com.chongwu.pettrade.service.service.impl;


import com.chongwu.pettrade.service.entity.*;
import com.chongwu.pettrade.service.service.OrderService;
import com.chongwu.pettrade.service.service.PayService;
import com.chongwu.pettrade.service.service.PetService;
import com.chongwu.pettrade.service.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("payService")
@Transactional
public class PayServiceImpl implements PayService {
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public int payOrderByWallet(Orders order, String addr, String name, String phone, String total) {
		order.setAddr(addr);
		order.setName(name);
		order.setPhone(phone);
		//ͨ���������ҿͻ�
		User user  =order.getUser();
		//ͨ���ͻ�����Ǯ��
		Wallet wallet = user.getWallet();
		//ͨ��Ǯ�������
		Float money  = wallet.getMoney();
		//�����۸�
		Float totalMoney = Float.parseFloat(total);
		if(money >= totalMoney) {
			//�������ж�����
			for(OrderItem orderItem : order.getOrderItems()) {
				Integer inventory = orderItem.getPet().getInventory();
				Pet pet = orderItem.getPet();
				pet.setInventory(inventory - orderItem.getCount());
				//���³�����
				petService.updatePet(pet);
			}
			wallet.setMoney(money - totalMoney);
			walletService.update(wallet);
			//�Ѹ���޸Ķ���״̬Ϊ2
			order.setState(2);
			//���¶�����Ϣ
			orderService.update(order);
			//֧���ɹ�����0
			return 0;
		}else {
			//֧��ʧ�ܷ���1
			return 1;
		}
	}

}
