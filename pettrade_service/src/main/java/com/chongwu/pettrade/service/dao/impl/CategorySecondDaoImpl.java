package com.chongwu.pettrade.service.dao.impl;


import com.chongwu.pettrade.service.dao.CategorySecondDao;
import com.chongwu.pettrade.service.entity.CategorySecond;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categorySecondDao")
public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao {

	@Override
	public Integer countCategorySecond() {
		String hql = "select count(*) from CategorySecond";
        return count(hql);
	}

	@Override
	public List<CategorySecond> findAll(Integer page) {
		String hql = "from CategorySecond";
        int rows = 10;
        int page1 = page;
        return find(hql, page1, rows);
	}

	@Override
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return find(hql);
	}

}
