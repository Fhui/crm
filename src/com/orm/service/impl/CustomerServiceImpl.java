package com.orm.service.impl;

import com.orm.dao.CustomerDao;
import com.orm.dao.impl.CustomerDaoImpl;
import com.orm.domain.Customer;
import com.orm.service.CustomerService;
import com.orm.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerDao.save(customer);
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
            list = customerDao.getAllList();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.commit();
        }
        transaction.commit();
        return list;
    }

    @Override
    public List getAllList(DetachedCriteria detachedCriteria) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List list = new ArrayList();
        try{
            list = customerDao.getAllList(detachedCriteria);
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        transaction.commit();
        return list;
    }

    @Test
    public void testQuery() {
        List allList = getAllList();
        System.out.println(allList);
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }
}
