package com.orm.service.impl;

import com.orm.dao.impl.CustomerDaoImpl;
import com.orm.domain.Customer;
import com.orm.service.CustomerService;
import com.orm.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDaoImpl dao = new CustomerDaoImpl();
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            dao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
    }

    @Test
    public void testSave(){

    }
}
