package com.chongwu.pettrade.service.dao.impl;

import com.chongwu.pettrade.service.dao.CategorysDao;
import com.chongwu.pettrade.service.entity.Categorys;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public class CategorysDaoImpl extends BaseDaoImpl<Categorys> implements CategorysDao {

	@Override
	public Integer countCategory() {
		String hql = "select count(*) from Categorys";
		return count(hql);
	}

	@Override
	public List<Categorys> findAll(Integer page) {
		String hql = "from Categorys";
        int rows = 10;
        return find(hql, page, rows);
	}

	@Override
	public List<Categorys> findAll() {
		String hql = "from Categorys";
		return find(hql);
	}


}
