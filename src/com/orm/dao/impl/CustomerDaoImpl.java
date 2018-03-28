package com.orm.dao.impl;

import com.orm.dao.CustomerDao;
import com.orm.domain.Customer;
import com.orm.utils.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(customer);
    }
}
