package com.orm.service.impl;

import com.orm.dao.CustomerDao;
import com.orm.dao.LinkManDao;
import com.orm.dao.impl.CustomerDaoImpl;
import com.orm.dao.impl.LinkManDaoImpl;
import com.orm.domain.Customer;
import com.orm.domain.LinkMan;
import com.orm.service.LinkManService;
import com.orm.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by harry.feng on 2018/3/31 .
 */
public class LinkManServiceImpl implements LinkManService {

    private LinkManDao linkManDao;


    @Override
    public void save(LinkMan linkMan) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.getCustomerById(linkMan.getCustom_id());
        linkMan.setCustomer(customer);
        try {
            linkManDao.save(linkMan);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        transaction.commit();
    }

    @Override
    public List getLinkManList() {
        return linkManDao.getLinkManList();
    }

    @Override
    public List getLinkManList(DetachedCriteria detachedCriteria) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List list = null;
        try {
            list = linkManDao.getLinkManList(detachedCriteria);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        transaction.commit();
        return list;
    }

    public LinkManDao getLinkManDao() {
        return linkManDao;
    }

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }
}
