package com.chongwu.pettrade.service.service.impl;


import com.chongwu.pettrade.service.dao.WalletDao;
import com.chongwu.pettrade.service.entity.Wallet;
import com.chongwu.pettrade.service.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("walletService")
public class WalletServiceImpl implements WalletService {

	@Autowired
    private WalletDao walletDao;
	
	/**
	 * 更新钱包余额
	 */
	@Override
	public void update(Wallet wallet) {
		walletDao.update(wallet);
	}

}
