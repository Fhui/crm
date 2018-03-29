package com.orm.service.impl;

import com.orm.dao.CustomerDao;
import com.orm.dao.impl.CustomerDaoImpl;
import com.orm.domain.Customer;
import com.orm.service.CustomerService;
import com.orm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao = new CustomerDaoImpl();

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

    @Override
    public List getAllList() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List list = new ArrayList<>();
        try {
            list = dao.getAllList();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.commit();
        }
        transaction.commit();
        return list;
    }

    @Test
    public void testQuery() {
        List allList = getAllList();
        System.out.println(allList);
    }
}
