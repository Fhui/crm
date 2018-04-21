package com.orm.dao.impl;

import com.orm.dao.UserDao;
import com.orm.domain.User;
import com.orm.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by harry.feng on 2018/4/21 .
 */
public class UserDaoImpl implements UserDao {
    @Override
    @SuppressWarnings("all")
    public User getUserById(String userCode) {
        Session session = HibernateUtils.getCurrentSession();
        String sql = "select * from sys_user where user_code = ?";
        List<User> list = session.createSQLQuery(sql)
                .addEntity(User.class)
                .setParameter(0, userCode)
                .list();
        return list.size() > 0 ? list.get(0) : null;
    }
}
