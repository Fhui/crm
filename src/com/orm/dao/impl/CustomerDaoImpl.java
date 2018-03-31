package com.orm.dao.impl;

import com.orm.dao.CustomerDao;
import com.orm.domain.Customer;
import com.orm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(customer);
    }

    public List getAllList() {
        String HQL = "from Customer ";
        Session currentSession = HibernateUtils.getCurrentSession();
        Query query = currentSession.createQuery(HQL);
        return query.list();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return HibernateUtils.getCurrentSession().get(Customer.class, id);
    }
}
