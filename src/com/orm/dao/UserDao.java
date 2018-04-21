package com.orm.dao;

import com.orm.domain.User;

/**
 * Created by harry.feng on 2018/4/21 .
 */
public interface UserDao {

    User getUserById(String userCode);

}
