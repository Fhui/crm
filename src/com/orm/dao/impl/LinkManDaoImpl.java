package com.orm.dao.impl;

import com.orm.dao.LinkManDao;
import com.orm.domain.LinkMan;
import com.orm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by harry.feng on 2018/3/31 .
 */
public class LinkManDaoImpl implements LinkManDao {


    @Override
    public void save(LinkMan linkMan) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(linkMan);
    }

    @Override
    public List getLinkManList() {
        Session session = HibernateUtils.getSession();
        String hql = "from LinkMan ";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
