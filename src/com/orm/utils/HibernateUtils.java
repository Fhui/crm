package com.orm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * hibernate utils
 * Created by harry.feng on 2018/3/26 .
 */
public class HibernateUtils {

    private static SessionFactory mSessionFactory;

    static {
        Configuration configuration = new Configuration().configure();
        mSessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return mSessionFactory.openSession();
    }

    public static Session getCurrentSession() {
        return mSessionFactory.getCurrentSession();
    }


}
