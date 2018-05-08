package com.orm.service.impl;

import com.orm.dao.UserDao;
import com.orm.domain.User;
import com.orm.service.UserService;
import com.orm.utils.HibernateUtils;

/**
 * Created by harry.feng on 2018/4/21 .
 */
public class UserServiceImpl implements UserService {
    UserDao userDao ;
    @Override
    public User login(User user) {
        HibernateUtils.getCurrentSession().beginTransaction();
        User queryUser = userDao.getUserById(user.getUser_code());
        HibernateUtils.getCurrentSession().getTransaction().commit();
        if (null == queryUser) {
            throw new RuntimeException("没有该用户");
        }
        if (!user.getUser_password().equals(queryUser.getUser_password())) {
            throw new RuntimeException("用户名密码错误");
        }
        return queryUser;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
