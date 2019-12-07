package com.chongwu.pettrade.service.dao.impl;

import com.chongwu.pettrade.service.dao.AdminDao;
import com.chongwu.pettrade.service.entity.Admin;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        String hql = "from Admin a where a.username = ? and a.password = ?";
        Query q = this.getCurrentSession().createQuery(hql);
        q.setParameter(0, username);
        q.setParameter(1, password);
        return (Admin) q.uniqueResult();
    }

    @Override
    public Admin findOne(Integer uid) {
        String hql = "from Admin where uid=?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        return (Admin) query.uniqueResult();
    }

}
